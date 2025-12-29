/*
Copyright 2025 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Objects;
import java.util.prefs.Preferences;

public final class Resources {

    public static final String MODULE_DIR = "com/prostep/openpdm/ocxviewer/";

    public static InputStream getResourceAsStream(String resource) {
        String path = resolve(resource);
        return Objects.requireNonNull(
            Main.class.getResourceAsStream(resolve(path)),
            "Resource not found: " + path
        );
    }

    public static URI getResource(String resource) {
        String path = resolve(resource);
        URL url = Objects.requireNonNull(Main.class.getResource(resolve(path)), "Resource not found: " + path);
        return URI.create(url.toExternalForm());
    }

    public static String resolve(String resource) {
        Objects.requireNonNull(resource);
        return resource.startsWith("/") ? resource : MODULE_DIR + resource;
    }

    public static String getPropertyOrEnv(String propertyKey, String envKey) {
        return System.getProperty(propertyKey, System.getenv(envKey));
    }

    public static Preferences getPreferences() {
        return Preferences.userRoot().node("ocxviewer");
    }
}
