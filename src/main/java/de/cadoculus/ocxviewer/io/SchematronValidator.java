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

import com.helger.schematron.ISchematronResource;
import com.helger.schematron.sch.SchematronResourceSCH;
import com.helger.schematron.svrl.jaxb.FailedAssert;
import com.helger.schematron.svrl.jaxb.FiredRule;
import com.helger.schematron.svrl.jaxb.SchematronOutputType;
import com.helger.schematron.svrl.jaxb.Text;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Validates the raw XML of an OCX file against a Schematron rules file using the
 * ph-schematron library.
 <p>
 * Because the OCX namespace is version specific, a rules file only fires against a
 * matching file. {@link #getFiredRuleCount()} returns 0 when no rule matched, which
 * usually means the rules file targets a different OCX version than the file.
 </p>
 */
public class SchematronValidator {

    private static final Logger LOG = LogManager.getLogger(SchematronValidator.class);

    private final File ocxFile;
    private final File schematronFile;
    private final DoubleProperty progress = new SimpleDoubleProperty(0.0);
    private final StringProperty status = new SimpleStringProperty("");
    private boolean ran = false;
    private int firedRuleCount = 0;
    private final boolean withoutUI = Window.getWindows().isEmpty();

    /**
     * Creates a new validator for the given OCX file and Schematron rules file.
     *
     * @param ocxFile        the OCX file to validate
     * @param schematronFile the Schematron (.sch) rules file to apply
     */
    public SchematronValidator(File ocxFile, File schematronFile) {
        this.ocxFile = ocxFile;
        this.schematronFile = schematronFile;
    }

    /**
     * Compiles the rules file and validates the OCX file against it.
     *
     * @return the list of findings; an empty list means no rule was violated
     * @throws IllegalArgumentException if a file is not readable or the rules file is not valid Schematron
     * @throws IllegalStateException    if the validator was already used or produced no result
     * @throws Exception                when the Schematron transform itself failed
     */
    public List<SchematronIssue> validate() throws Exception {
        if (ran) {
            throw new IllegalStateException("validator was already used");
        }
        ran = true;

        if (!(ocxFile.exists() && ocxFile.canRead())) {
            throw new IllegalArgumentException("OCX file is not readable: " + ocxFile.getAbsolutePath());
        }
        if (!(schematronFile.exists() && schematronFile.canRead())) {
            throw new IllegalArgumentException("Rules file is not readable: " + schematronFile.getAbsolutePath());
        }

        updateProgress(status, "Compiling Schematron rules ...");
        updateProgress(progress, 0.0);

        final ISchematronResource schematron = SchematronResourceSCH.fromFile(schematronFile);
        if (!schematron.isValidSchematron()) {
            throw new IllegalArgumentException("The Schematron rules file could not be compiled: "
                    + schematronFile.getName() + " (see the log for details)");
        }

        updateProgress(progress, 0.2);
        updateProgress(status, "Validating " + ocxFile.getName() + " ...");

        final SchematronOutputType svrl;
        try (var pis = new ProgressInputStream(ocxFile)) {
            pis.addPropertyChangeListener(evt -> {
                // ProgressInputStream reports 0 ... 100 as int; map it onto 0.2 ... 0.95
                int percent = (int) evt.getNewValue();
                updateProgress(progress, 0.2 + 0.75 * (percent / 100.0));
            });
            svrl = schematron.applySchematronValidationToSVRL(
                    new StreamSource(pis, ocxFile.toURI().toASCIIString()));
        }
        if (svrl == null) {
            throw new IllegalStateException("Schematron validation produced no result");
        }

        updateProgress(status, "Collecting results ...");

        final var issues = new ArrayList<SchematronIssue>();
        firedRuleCount = 0;
        for (Object entry : svrl.getActivePatternAndFiredRuleAndFailedAssert()) {
            if (entry instanceof FiredRule) {
                firedRuleCount++;
            } else if (entry instanceof FailedAssert failedAssert) {
                issues.add(toIssue(failedAssert));
            }
        }

        updateProgress(progress, 1.0);
        updateProgress(status, "Done");

        LOG.info("Schematron check of {} with {} finished: {} findings, {} rules fired",
                ocxFile.getName(), schematronFile.getName(), issues.size(), firedRuleCount);
        return issues;
    }

    /**
     * The number of Schematron rules that fired (were evaluated) during the last
     * {@link #validate()} call. A value of 0 strongly suggests the rules file does
     * not match the file's OCX namespace/version.
     *
     * @return the fired rule count
     */
    public int getFiredRuleCount() {
        return firedRuleCount;
    }

    private static SchematronIssue toIssue(FailedAssert failedAssert) {
        return new SchematronIssue(
                severityOf(failedAssert),
                failedAssert.getLocation(),
                failedAssert.getTest(),
                extractMessage(failedAssert));
    }

    /**
     * Derives a severity from the rule's flag (preferred) or role attribute.
     * An absent or unknown value defaults to ERROR.
     */
    private static SchematronIssue.Severity severityOf(FailedAssert failedAssert) {
        var value = failedAssert.getFlag();
        if (value == null || value.isBlank()) {
            value = failedAssert.getRole();
        }
        if (value == null) {
            return SchematronIssue.Severity.ERROR;
        }
        return switch (value.trim().toLowerCase(Locale.ROOT)) {
            case "info", "information" -> SchematronIssue.Severity.INFO;
            case "warn", "warning" -> SchematronIssue.Severity.WARNING;
            case "fatal", "fatal-error", "fatalerror" -> SchematronIssue.Severity.FATAL;
            default -> SchematronIssue.Severity.ERROR;
        };
    }

    /**
     * Extracts the human readable text of a failed assertion and collapses the
     * whitespace the .sch source uses for indentation into single spaces.
     */
    private static String extractMessage(FailedAssert failedAssert) {
        var text = failedAssert.getDiagnosticReferenceOrPropertyReferenceOrText().stream()
                .filter(Text.class::isInstance)
                .map(Text.class::cast)
                .flatMap(t -> t.getContent().stream())
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        return text.replaceAll("\\s+", " ").trim();
    }

    /**
     * indicates the validation progress: from 0.0 to 1.0.
     *
     * @return the progress property
     */
    public DoubleProperty progressProperty() {
        return progress;
    }

    /**
     * The status property indicates the current validation phase.
     *
     * @return the status property
     */
    public StringProperty statusProperty() {
        return status;
    }

    private void updateProgress(DoubleProperty property, double newValue) {
        if (withoutUI) {
            property.set(newValue);
        } else {
            Platform.runLater(() -> property.set(newValue));
        }
    }

    private void updateProgress(StringProperty property, String newValue) {
        if (withoutUI) {
            property.set(newValue);
        } else {
            Platform.runLater(() -> property.set(newValue));
        }
    }
}
