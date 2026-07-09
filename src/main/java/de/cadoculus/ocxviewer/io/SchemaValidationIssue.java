/*
 * Copyright 2026 PROSTEP AG
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

/**
 * A single finding reported while validating an OCX file against an XSD schema.
 *
 * @param severity the severity of the finding
 * @param line     the line in the validated file, -1 if unknown
 * @param column   the column in the validated file, -1 if unknown
 * @param message  the parser / validator message
 */
public record SchemaValidationIssue(Severity severity, int line, int column, String message) {

    /**
     * Severity of a validation finding.
     * WARNING does not make the file invalid.
     * ERROR is a schema violation.
     * FATAL aborted the validation (e.g. not well-formed XML).
     */
    public enum Severity {
        WARNING, ERROR, FATAL
    }
}
