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

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Validates the raw XML of an OCX file against a bundled XSD schema version.
 * <p>
 * Unlike {@link OCXParser} this class must never rewrite the file's namespace:
 * the whole point of the schema check is to validate the file against the
 * schema version the user selected, exactly as it is on disk.
 */
public class SchemaValidator {

    private static final Logger LOG = LogManager.getLogger(SchemaValidator.class);

    private final File file;
    private final OCXSchemaVersion version;
    private final DoubleProperty progress = new SimpleDoubleProperty(0.0);
    private final StringProperty status = new SimpleStringProperty("");
    private boolean ran = false;
    private final boolean withoutUI = Window.getWindows().isEmpty();

    /**
     * Creates a new validator for the given file and schema version.
     *
     * @param file    the OCX file to validate
     * @param version the schema version to validate against
     */
    public SchemaValidator(File file, OCXSchemaVersion version) {
        this.file = file;
        this.version = version;
    }

    /**
     * Validates the file and returns all findings. An empty list means the file
     * is valid against the selected schema version.
     *
     * @return the list of findings in document order
     * @throws IOException              when reading the file failed
     * @throws SAXException             when the bundled schema itself could not be loaded
     * @throws IllegalArgumentException if the file is not readable or the schema version is not bundled
     * @throws IllegalStateException    if the validator was already used
     */
    public List<SchemaValidationIssue> validate() throws IOException, SAXException {
        if (ran) {
            throw new IllegalStateException("validator was already used");
        }
        ran = true;

        if (!(file.exists() && file.canRead())) {
            throw new IllegalArgumentException("File is not readable: " + file.getAbsolutePath());
        }
        final var schemaResource = version.getSchemaResource();
        if (schemaResource == null) {
            throw new IllegalArgumentException("No XSD for OCX " + version.getDisplayName() + " is bundled with the application");
        }

        updateProgress(status, "Loading OCX " + version.getDisplayName() + " schema ...");
        updateProgress(progress, 0.0);

        var schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        var schema = schemaFactory.newSchema(schemaResource);

        final var issues = new ArrayList<SchemaValidationIssue>();
        var validator = schema.newValidator();
        validator.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exp) {
                issues.add(toIssue(SchemaValidationIssue.Severity.WARNING, exp));
            }

            @Override
            public void error(SAXParseException exp) {
                issues.add(toIssue(SchemaValidationIssue.Severity.ERROR, exp));
            }

            @Override
            public void fatalError(SAXParseException exp) {
                issues.add(toIssue(SchemaValidationIssue.Severity.FATAL, exp));
            }
        });

        updateProgress(status, "Validating " + file.getName() + " ...");
        try (var fis = new ProgressInputStream(file)) {
            fis.addPropertyChangeListener(evt -> {
                // The ProgressInputStream reports progress in the range 0 ... 100 as int
                int percent = (int) evt.getNewValue();
                updateProgress(progress, percent / 100.0);
            });

            validator.validate(new StreamSource(fis, file.toURI().toASCIIString()));
        } catch (SAXParseException exp) {
            // a fatal error aborts the validation; it was already reported to the error handler above
            if (issues.isEmpty()) {
                issues.add(toIssue(SchemaValidationIssue.Severity.FATAL, exp));
            }
        }

        updateProgress(progress, 1.0);
        updateProgress(status, "Done");

        LOG.info("validation of {} against OCX {} finished with {} findings", file.getName(), version.getDisplayName(), issues.size());
        return issues;
    }

    private static SchemaValidationIssue toIssue(SchemaValidationIssue.Severity severity, SAXParseException exp) {
        return new SchemaValidationIssue(severity, exp.getLineNumber(), exp.getColumnNumber(), exp.getMessage());
    }

    /**
     * Detect the namespace declared on the root element of the given file.
     *
     * @param file the file to scan
     * @return the declared namespace, or null if none could be detected
     */
    public static String detectNamespace(File file) {
        final var handler = new FindNamespaceHandler();
        try (var fis = new FileInputStream(file)) {
            var factory = SAXParserFactory.newInstance();
            var saxParser = factory.newSAXParser();
            saxParser.parse(fis, handler);
        } catch (FoundNamespaceException e) {
            return handler.namespace;
        } catch (Exception exp) {
            LOG.warn("failed to detect namespace of {}", file, exp);
        }
        return handler.namespace;
    }

    /**
     * The progress property indicates the validation progress of the OCX file.
     * It ranges from 0.0 to 1.0.
     *
     * @return the progress property
     */
    public DoubleProperty progressProperty() {
        return progress;
    }

    /**
     * The status property indicates the validation state
     *
     * @return the status property
     */
    public StringProperty statusProperty() {
        return status;
    }

    /**
     * Update a given double property in the JavaFX application thread.
     *
     * @param progress the progress property to update
     * @param newValue the new value to set
     */
    void updateProgress(DoubleProperty progress, double newValue) {
        if (withoutUI) {
            progress.set(newValue);
        } else {
            Platform.runLater(() -> progress.set(newValue));
        }
    }

    /**
     * Update a given string property in the JavaFX application thread.
     *
     * @param status   the status property to update
     * @param newValue the new value to set
     */
    void updateProgress(StringProperty status, String newValue) {
        if (withoutUI) {
            status.set(newValue);
        } else {
            Platform.runLater(() -> status.set(newValue));
        }
    }

    /**
     * Used to abort the SAX scan as soon as the root element's namespace was found.
     */
    private static class FoundNamespaceException extends RuntimeException {
        FoundNamespaceException(String namespace) {
            super("found namespace " + namespace);
        }
    }

    private static class FindNamespaceHandler extends DefaultHandler {
        private String namespace = null;

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            if (namespace != null) {
                return;
            }

            int idx = qName.indexOf(':');
            var prefix = idx > 0 ? qName.substring(0, idx) : "";

            for (int i = 0; i < attributes.getLength(); i++) {
                var attrQName = attributes.getQName(i);
                int attrIdx = attrQName.indexOf(':');
                var attrLocal = attrIdx > 0 ? attrQName.substring(attrIdx + 1) : attrQName;

                // xmlns:prefix="..." matching the root element's prefix, or a
                // default namespace declaration xmlns="..." on a prefix-less root
                if ((attrIdx > 0 && prefix.equals(attrLocal))
                        || (prefix.isEmpty() && "xmlns".equals(attrQName))) {
                    namespace = attributes.getValue(i);
                    throw new FoundNamespaceException(namespace);
                }
            }
        }
    }
}
