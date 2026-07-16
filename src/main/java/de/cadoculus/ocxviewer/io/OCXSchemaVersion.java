/*
 * Copyright 2026 prostep
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
package de.cadoculus.ocxviewer.io;

import java.net.URL;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * The OCX schema versions the application can validate against.
 * Each version points to an XSD bundled under src/main/resources/xsds/vXXX/.
 */
public enum OCXSchemaVersion {

    V300("3.0.0", "V300", "/xsds/v300/OCX_Schema.xsd"),
    V310("3.1.0", "V310", "/xsds/v310/OCX_Schema.xsd"),
    // work-in-progress release candidate; replace the file when OCX 3.2.0 is released
    V320("3.2.0 (rc6)", "V320rc6", "/xsds/v320/OCX_Schema_rc6.xsd");

    /**
     * The version segment inside an OCX target namespace, e.g. "V310" in
     * "https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd".
     */
    private static final Pattern VERSION_SEGMENT = Pattern.compile("V\\d{3}[A-Za-z0-9]*");

    private final String displayName;
    private final String namespaceSegment;
    private final String resourcePath;

    OCXSchemaVersion(String displayName, String namespaceSegment, String resourcePath) {
        this.displayName = displayName;
        this.namespaceSegment = namespaceSegment;
        this.resourcePath = resourcePath;
    }

    /**
     * Determine the schema version a file declares from its target namespace.
     *
     * @param namespace the namespace found in the OCX file, may be null
     * @return the matching version (or empty for unknown namespaces)
     */
    public static Optional<OCXSchemaVersion> fromNamespace(String namespace) {
        if (namespace == null) {
            return Optional.empty();
        }
        var matcher = VERSION_SEGMENT.matcher(namespace);
        if (!matcher.find()) {
            return Optional.empty();
        }
        var segment = matcher.group();
        for (var version : values()) {
            if (version.namespaceSegment.equals(segment)) {
                return Optional.of(version);
            }
        }
        return Optional.empty();
    }

    /**
     * @return the display name, e.g. "3.1.0"
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return the classpath URL of the bundled XSD, or null if this version is not bundled
     */
    public URL getSchemaResource() {
        return OCXSchemaVersion.class.getResource(resourcePath);
    }

    /**
     * @return true if the XSD for this version is bundled with the application
     */
    public boolean isAvailable() {
        return getSchemaResource() != null;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
