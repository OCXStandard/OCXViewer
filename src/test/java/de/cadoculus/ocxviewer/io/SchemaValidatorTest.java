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

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
These tests run headless (no JavaFX window open).
*/
class SchemaValidatorTest {

    /** The v3.1.0 target namespace */
    private static final String V310_NAMESPACE =
            "https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd";

    private static final File VALID_OCX = new File("data/Schema310/Validated/TR03_TC10_psav.3docx");
    private static final File INVALID_OCX = new File("data/Schema310/Invalidated/invalid_demo.3docx");

    @BeforeAll
    static void setUp() {
        LoggerHelper.initLogging(new File("data/testLog4j2.xml"));
    }

    @Test
    void validatedFileHasNoSchemaErrors() throws Exception {
        var validator = new SchemaValidator(VALID_OCX, OCXSchemaVersion.V310);
        List<SchemaValidationIssue> issues = validator.validate();

        long errors = issues.stream()
                .filter(i -> i.severity() != SchemaValidationIssue.Severity.WARNING)
                .count();
        assertEquals(0, errors,
                "a consortium-validated v3.1.0 file must pass the XSD check but reported: " + issues);
        assertEquals(1.0, validator.progressProperty().get(), 1e-9, "progress must reach 100%");
    }

    @Test
    void malformedDocumentReportsFindings(@TempDir Path tmp) throws Exception {
        // An element that the OCX schema does not declare -> guaranteed schema finding,
        // independent of any particular fixture file.
        Path nonExistentFile = tmp.resolve("non_existent_file.3docx");
        Files.writeString(nonExistentFile,
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                        + "<ocx:NotADeclaredRoot xmlns:ocx=\"" + V310_NAMESPACE + "\"/>\n");

        var validator = new SchemaValidator(nonExistentFile.toFile(), OCXSchemaVersion.V310);
        List<SchemaValidationIssue> issues = validator.validate();

        assertFalse(issues.isEmpty(), "an undeclared root element must produce a schema finding");
        for (SchemaValidationIssue issue : issues) {
            assertNotNull(issue.severity());
            assertNotNull(issue.message());
        }
    }

    @Test
    void curatedInvalidFileReportsSchemaErrors() throws Exception {
        var validator = new SchemaValidator(INVALID_OCX, OCXSchemaVersion.V310);
        List<SchemaValidationIssue> issues = validator.validate();

        assertFalse(issues.isEmpty(), "the curated invalid sample must produce schema findings");
        long errors = issues.stream()
                .filter(i -> i.severity() != SchemaValidationIssue.Severity.WARNING)
                .count();
        assertTrue(errors > 0,
                "the curated invalid sample must produce at least one error/fatal finding: " + issues);
    }

    @Test
    void bundledSchemaVersionsAreReportedCorrectly() {
        assertTrue(OCXSchemaVersion.V300.isAvailable(), "v300 XSD is bundled");
        assertTrue(OCXSchemaVersion.V310.isAvailable(), "v310 XSD is bundled");
        assertTrue(OCXSchemaVersion.V320.isAvailable(), "v320 XSD is bundled");
    }

    @Test
    void namespaceIsMappedToSchemaVersion() {
        assertEquals(Optional.of(OCXSchemaVersion.V310),
                OCXSchemaVersion.fromNamespace(V310_NAMESPACE));
        assertEquals(Optional.of(OCXSchemaVersion.V300),
                OCXSchemaVersion.fromNamespace("https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd"));
        // rc-style suffix: the V320 namespace segment is "V320rc6"
        assertEquals(Optional.of(OCXSchemaVersion.V320),
                OCXSchemaVersion.fromNamespace("https://3docx.org/fileadmin//ocx_schema//V320rc6//OCX_Schema_rc6.xsd"));
        assertTrue(OCXSchemaVersion.fromNamespace(null).isEmpty());
        assertTrue(OCXSchemaVersion.fromNamespace("urn:something:else").isEmpty());
    }

    @Test
    void namespaceOfRealFileIsDetected() {
        String detected = SchemaValidator.detectNamespace(VALID_OCX);
        assertNotNull(detected, "the root namespace should be detected");
        assertEquals(Optional.of(OCXSchemaVersion.V310), OCXSchemaVersion.fromNamespace(detected),
                "the detected namespace should map back to v3.1.0");
    }

    @Test
    void unreadableFileIsRejected() {
        var validator = new SchemaValidator(new File("data/does-not-exist.3docx"), OCXSchemaVersion.V310);
        assertThrows(IllegalArgumentException.class, validator::validate);
    }

    @Test
    void validatorIsSingleUse() throws Exception {
        var validator = new SchemaValidator(VALID_OCX, OCXSchemaVersion.V310);
        validator.validate();
        assertThrows(IllegalStateException.class, validator::validate,
                "a validator must reject a second validate() call");
    }
}
