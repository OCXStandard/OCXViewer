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
 * A single Schematron finding (a failed assertion).
 * <p>
 * SVRL reports the location as an XPath into the document instead.
 *
 * @param severity the severity derived from the rule's role/flag attribute
 * @param location the XPath location of the offending element in the document
 * @param test     the XPath test expression of the failed assertion
 * @param message  the human readable message of the rule
 */
public record SchematronIssue(Severity severity, String location, String test, String message) {

    public enum Severity {
        INFO, WARNING, ERROR, FATAL
    }
}
