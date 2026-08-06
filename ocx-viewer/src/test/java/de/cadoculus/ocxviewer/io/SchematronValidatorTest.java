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
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * These tests run headless (no JavaFX window open). The Schematron rules and the
 * OCX instances are self-contained so no external fixture files are needed - the
 * rule contexts only have to match the synthetic instance, not a real OCX version.
 */
class SchematronValidatorTest {

    @BeforeAll
    static void setUp() {
        LoggerHelper.initLogging(new File("data/testLog4j2.xml"));
    }

    // A rule whose four assertions all fail (@ok is absent), one per severity source:
    // flag=info/warning/fatal and one without a flag (which must default to ERROR).
    private static final String SEVERITY_SCH = """
            <?xml version="1.0" encoding="UTF-8"?>
            <sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2">
              <sch:pattern>
                <sch:rule context="item">
                  <sch:assert test="@ok" flag="info">info finding</sch:assert>
                  <sch:assert test="@ok" flag="warning">warning finding</sch:assert>
                  <sch:assert test="@ok" flag="fatal">fatal finding</sch:assert>
                  <sch:assert test="@ok">default error finding</sch:assert>
                </sch:rule>
              </sch:pattern>
            </sch:schema>
            """;

    // A rule whose context matches nothing in the instance -> no rule fires.
    private static final String NO_MATCH_SCH = """
            <?xml version="1.0" encoding="UTF-8"?>
            <sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2">
              <sch:pattern>
                <sch:rule context="does-not-exist">
                  <sch:assert test="false()">never reported</sch:assert>
                </sch:rule>
              </sch:pattern>
            </sch:schema>
            """;

    private static final String INSTANCE = "<root><item/></root>";

    @Test
    void severitiesAreMappedFromFlagAndRulesFire(@TempDir Path tmp) throws Exception {
        var ocx = write(tmp, "instance.xml", INSTANCE);
        var sch = write(tmp, "severity.sch", SEVERITY_SCH);

        var validator = new SchematronValidator(ocx, sch);
        List<SchematronIssue> issues = validator.validate();

        Set<SchematronIssue.Severity> severities = issues.stream()
                .map(SchematronIssue::severity)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(SchematronIssue.Severity.class)));

        assertEquals(EnumSet.allOf(SchematronIssue.Severity.class), severities,
                "flag=info/warning/fatal and an unflagged assert must map to INFO/WARNING/FATAL/ERROR: " + issues);
        assertTrue(validator.getFiredRuleCount() > 0, "the item rule must have fired");
    }

    @Test
    void noFiredRuleYieldsNoFindings(@TempDir Path tmp) throws Exception {
        var ocx = write(tmp, "instance.xml", INSTANCE);
        var sch = write(tmp, "no-match.sch", NO_MATCH_SCH);

        var validator = new SchematronValidator(ocx, sch);
        List<SchematronIssue> issues = validator.validate();

        assertTrue(issues.isEmpty(), "a rule that never matches must not produce findings");
        assertEquals(0, validator.getFiredRuleCount(),
                "getFiredRuleCount()==0 signals a version/namespace mismatch, not a valid file");
    }

    @Test
    void unreadableFilesAreRejected(@TempDir Path tmp) throws Exception {
        var sch = write(tmp, "severity.sch", SEVERITY_SCH);
        var missingOcx = new File("data/does-not-exist.3docx");

        var validator = new SchematronValidator(missingOcx, sch);
        assertThrows(IllegalArgumentException.class, validator::validate);
    }

    @Test
    void validatorIsSingleUse(@TempDir Path tmp) throws Exception {
        var ocx = write(tmp, "instance.xml", INSTANCE);
        var sch = write(tmp, "severity.sch", SEVERITY_SCH);

        var validator = new SchematronValidator(ocx, sch);
        validator.validate();
        assertThrows(IllegalStateException.class, validator::validate,
                "a validator must reject a second validate() call");
    }

    private static File write(Path dir, String name, String content) throws Exception {
        Path p = dir.resolve(name);
        Files.writeString(p, content);
        return p.toFile();
    }
}
