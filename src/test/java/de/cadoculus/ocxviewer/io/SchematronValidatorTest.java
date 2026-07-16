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

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the Schematron Check feature ({@link SchematronValidator}).
 */
class SchematronValidatorTest {

    private static final File RULES = new File("data/schematron/ocx-example-rules.sch");
    private static final File VALID_OCX = new File("data/Schema310/brackets.3docx");
    private static final File INVALID_OCX = new File("data/Schema310/Invalidated/invalid_demo.3docx");

    @BeforeAll
    static void setUp() {
        LoggerHelper.initLogging(new File("data/testLog4j2.xml"));
    }

    @Test
    void validFileSatisfiesAllRules() throws Exception {
        var validator = new SchematronValidator(VALID_OCX, RULES);
        List<SchematronIssue> issues = validator.validate();

        assertTrue(validator.getFiredRuleCount() > 0,
                "rules must fire against a matching v3.1.0 file (0 signals a version mismatch)");
        assertTrue(issues.isEmpty(),
                "brackets.3docx should satisfy the example rules but reported: " + issues);
        assertEquals(1.0, validator.progressProperty().get(), 1e-9, "progress must reach 100%");
    }

    @Test
    void invalidFileReportsFindings() throws Exception {
        var validator = new SchematronValidator(INVALID_OCX, RULES);
        List<SchematronIssue> issues = validator.validate();

        assertTrue(validator.getFiredRuleCount() > 0,
                "rules must fire against a matching v3.1.0 file");
        assertFalse(issues.isEmpty(),
                "invalid_demo.3docx should violate at least one example rule");

        // every finding must carry the data the results table renders
        for (SchematronIssue issue : issues) {
            assertNotNull(issue.severity(), "severity");
            assertNotNull(issue.test(), "failed test expression");
            assertNotNull(issue.message(), "human readable message");
            assertFalse(issue.message().isBlank(), "message should not be blank");
        }
    }

    @Test
    void validatorIsSingleUse() throws Exception {
        var validator = new SchematronValidator(VALID_OCX, RULES);
        validator.validate();
        assertThrows(IllegalStateException.class, validator::validate,
                "a validator must reject a second validate() call");
    }

    @Test
    void unreadableOcxFileIsRejected() {
        var validator = new SchematronValidator(new File("data/does-not-exist.3docx"), RULES);
        assertThrows(IllegalArgumentException.class, validator::validate);
    }

    @Test
    void unreadableRulesFileIsRejected() {
        var validator = new SchematronValidator(VALID_OCX, new File("data/does-not-exist.sch"));
        assertThrows(IllegalArgumentException.class, validator::validate);
    }
}
