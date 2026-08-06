/*
 * Copyright 2025 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cadoculus.ocxviewer.actions;

import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.HotkeyEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCodeCombination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.jar.JarFile;

/**
 * Dispatches events from the event bus to actions.
 * The dispatcher creates a map of key codes and classes at initialisation time.
 *
 * @author Carsten Zerbst
 */
public class ActionDispatcher {
    private static final Logger LOG = LogManager.getLogger(ActionDispatcher.class);
    private final Map<KeyCodeCombination, Class<? extends AbstractAction>> key2class = new HashMap<>();

    public ActionDispatcher(Scene scene) {

        DefaultEventBus.getInstance().subscribe(HotkeyEvent.class, this::handleHotkeyEvent);


        var packageName = AbstractAction.class.getPackageName();
        ClassLoader classLoader = AbstractAction.class.getClassLoader();

        collectActionClassFileNames(packageName, classLoader).stream()
                .map(line -> getClass(line, packageName))
                .filter(Objects::nonNull)
                .filter(clazz -> clazz.getSuperclass() == AbstractAction.class)
                .forEach(clazz -> putKey(clazz, scene));

        key2class.entrySet().forEach(entry -> LOG.debug(entry.getKey().toString() + " " + entry.getValue().toString()));


    }

    /**
     * Collect the simple file names of the classes directly in the given package.
     * This works both when the classes are exploded on disk (javafx:run)
     * and when they are packaged inside a jar (the launch4j / jar delivery).
     */
    private Set<String> collectActionClassFileNames(String packageName, ClassLoader classLoader) {
        String path = packageName.replace('.', '/');
        Set<String> classFileNames = new LinkedHashSet<>();

        // Packaged in a jar: enumerate the jar entries directly under the package path.
        try {
            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                if ("jar".equals(url.getProtocol())) {
                    JarURLConnection connection = (JarURLConnection) url.openConnection();
                    try (JarFile jar = connection.getJarFile()) {
                        String prefix = path + "/";
                        var entries = jar.entries();
                        while (entries.hasMoreElements()) {
                            String name = entries.nextElement().getName();
                            if (name.startsWith(prefix) && name.endsWith(".class")
                                    && name.indexOf('/', prefix.length()) < 0) {
                                classFileNames.add(name.substring(prefix.length()));
                            }
                        }
                    }
                }
            }
        } catch (IOException exp) {
            LOG.error("failed to scan jar for action classes in package {}", packageName, exp);
        }

        // on disk: the package directory can be read as a text listing of file names.
        InputStream stream = classLoader.getResourceAsStream(path);
        if (stream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                reader.lines()
                        .filter(line -> line.endsWith(".class"))
                        .forEach(classFileNames::add);
            } catch (IOException exp) {
                LOG.error("failed to read action package directory {}", packageName, exp);
            }
        }

        return classFileNames;
    }

    private void putKey(Class clazz, Scene scene) {

        try {
            var key = (KeyCodeCombination) (clazz.getField("KEYS").get(null));
            if (key2class.containsKey(key)) {
                LOG.error("found duplicated KeyCodeCombination {} on {} and {}",
                        key, key2class.get(key), clazz);
            } else {
                key2class.put(key, clazz);
                // and register some hotkeys
                scene.getAccelerators().put(key, () -> DefaultEventBus.getInstance().publish(new HotkeyEvent(key)));

                LOG.debug(key.toString() + " " + key2class.get(key));
            }

        } catch (Throwable exp) {
            LOG.error("failed to collect key codes for actions", exp);
        }
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    private void handleHotkeyEvent(HotkeyEvent hotkeyEvent) {
        LOG.debug("handleHotkeyEvent: {} ({})", hotkeyEvent, hotkeyEvent.getKeys().toString());

        // TODO: use static Action.Keys instead of hardcoded strings
        var key = hotkeyEvent.getKeys();
        if (key2class.containsKey(key)) {
            var actionClazz = key2class.get(key);
            run(actionClazz);
        } else {
            LOG.info("got unknown key combination {}", key);
            LOG.info("supported keycodes are");
            key2class.entrySet().forEach(entry -> LOG.info("    " + entry.getKey().toString() + " " + entry.getValue().toString()));
        }
    }

    private void run(Class<? extends AbstractAction> actionClazz) {

        try {
            actionClazz.getConstructor().newInstance().run();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException exp) {
            LOG.error("failed to create action for class {}:{}", actionClazz, exp);
        }

    }
}
