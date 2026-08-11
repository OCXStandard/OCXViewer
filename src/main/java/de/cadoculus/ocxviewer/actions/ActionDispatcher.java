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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dispatches events from the event bus to actions.
 * The dispatcher creates a map of key codes and classes at initialisation time.
 *
 * @author Carsten Zerbst
 */
public class ActionDispatcher {
    private static final Logger LOG = LogManager.getLogger(ActionDispatcher.class);

    /**
     * All actions dispatched by hotkey. Explicit registration instead of classpath
     * scanning: directory listings via getResourceAsStream() and jar-entry scanning
     * both find nothing when the application runs as a named module from a
     * jlink/jpackage runtime image (jrt filesystem), leaving all hotkeys unregistered.
     */
    private static final List<Class<? extends AbstractAction>> ACTIONS = List.of(
            AboutAction.class,
            ExitAction.class,
            HelpAction.class,
            NavigateBackAction.class,
            OpenAction.class,
            SchemaCheckAction.class,
            SchematronAction.class);

    private final Map<KeyCodeCombination, Class<? extends AbstractAction>> key2class = new HashMap<>();

    public ActionDispatcher(Scene scene) {

        DefaultEventBus.getInstance().subscribe(HotkeyEvent.class, this::handleHotkeyEvent);

        ACTIONS.forEach(clazz -> putKey(clazz, scene));

        key2class.entrySet().forEach(entry -> LOG.debug(entry.getKey().toString() + " " + entry.getValue().toString()));


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
