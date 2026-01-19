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
package de.cadoculus.ocxviewer.io;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.OcxXMLT;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

/**
 * This class provides methods to parse OCX files and resolve the none-standard references
 * using GUIRefs instead of xsd:ID/xsd:IDREF
 *
 * @author Carsten Zerbst
 */
public class OCXParser {

    public static final String TARGET_NAMESPACE = "https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd";
    private static final double PARSE_PROG_SCALING= 0.9;
    private static final Logger LOG = LogManager.getLogger(OCXParser.class);
    private final File file;
    private final DoubleProperty progress= new SimpleDoubleProperty(0.0);
    private  final StringProperty status  = new SimpleStringProperty("");
    private boolean ran = false;
    private boolean withoutUI =  Window.getWindows().isEmpty();

    /**
     * Creates a new OCXParser for the given OCX file.
     *
     * @param ocxFile the OCX file to parse
     */
    public OCXParser(File ocxFile) {
        this.file = ocxFile;
    }

    /**
     * Parses the OCX file and returns the OCXReadResult.
     *
     * @return the OCXReadResult
     * @throws IOException              when io failed
     * @throws IllegalArgumentException if the given file does not exist
     * @throws IllegalStateException    if the parser was already used
     */
    public OCXReadResult parse() throws IOException, IllegalArgumentException {
        if (ran) {
            throw new IllegalStateException("parser was already used");
        }
        ran = true;

        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + file.getAbsolutePath());
        }

        PropertyChangeListener pcl = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // The ProgressInputStream reports progress in the range 0 ... 100 as int
                int parsePercent = (int) evt.getNewValue();
                double scaledProgress = parsePercent / 100.0 * PARSE_PROG_SCALING;
                // The parser is run on any thread, but the progress property must be updated in the display event thread
              updateProgress( progress, scaledProgress);
            }
        };

        //
        // first we need to check the namespace used in the file
        //
        updateProgress(status, "Detecting OCX namespace...");

        String usedNamespace = null;
        final var handler = new OCXPFindNamespaceHandler();
        try (FileInputStream fis = new FileInputStream(file)) {

            var factory = SAXParserFactory.newInstance();
            var saxParser = factory.newSAXParser();

            saxParser.parse(fis, handler);
        } catch (ArithmeticException e) {
            usedNamespace = handler.getNamespace();
        } catch (Exception exp) {
            LOG.error("failed to read namespace", exp);
            throw new IllegalArgumentException("failed to read namespace", exp);
        }

        URI usedNamespaceURL = URI.create(usedNamespace);
        LOG.info("file {} uses namespace {}, formatted {}", file.getName(), usedNamespace, usedNamespaceURL.toURL());

        OcxXMLT ocxXMLT = null;

        //
        // The perform the parsing. The listener is used to collect references preventing us from collecting them again later
        //
        final var jaxListener = new OCXIOUnmarshallerListener();

        try (var fis = new ProgressInputStream(file); var rep = new ReplacingInputStream(fis, usedNamespace, TARGET_NAMESPACE)) {
            updateProgress(status, "Parsing ...");
            fis.addPropertyChangeListener(pcl);

            // This uses a hardcoded target namespace for V310
            // newer and older versions are replaced in t ReplacingInputStream
            var jaxbContext = JAXBContext.newInstance(new Class[]{
                    oasis.unitsml.ObjectFactory.class,
                    org.ocx_schema.v310.ObjectFactory.class});
            var jaxUnmarshaller = jaxbContext.createUnmarshaller();
            jaxUnmarshaller.setListener(jaxListener);

            final Object unmarshal = jaxUnmarshaller.unmarshal(rep);
            LOG.info("loaded {} from {}", unmarshal, file.getAbsolutePath());

            if (!(unmarshal instanceof JAXBElement jaxbElement && jaxbElement.getValue() instanceof OcxXMLT ocxXMLTp)) {

                LOG.error("failed to loaded OCX file, got unexpected type {}", unmarshal.getClass());
                throw new IOException("unexpected type " + unmarshal.getClass());
            }
            LOG.info("loaded {} {} ", jaxbElement.getName(), ocxXMLT);
            ocxXMLT = ocxXMLTp;


        } catch (Exception e) {
            LOG.error("failed to read OCX from {}", file.getAbsolutePath(), e);
            throw new IOException(e);
        }

        //
        // finally resolve the references which are not defined using xsd:ID/xsd:IDREF
        //
        final OCXIOReferenceResolver referenceResolver = new OCXIOReferenceResolver(ocxXMLT, jaxListener);
        referenceResolver.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                // The ReferenceResolver reports progress in the range 0 ... 100 as int
                int rawProgress = (int) event.getNewValue();
                double scaledProgress =PARSE_PROG_SCALING + ( rawProgress * 0.01 * (1-PARSE_PROG_SCALING));
                updateProgress(progress, scaledProgress);
            }
        });
        updateProgress(status, "Resolving References ...");
        referenceResolver.resolve();

        updateProgress(progress, 1.0);
        updateProgress(status, "Done");

        return new OCXReadResult(usedNamespace, ocxXMLT);

    }


    /**
     * The progress property indicates the parsing and link resolution progress of the OCX file.
     * It ranges from 0.0 to 1.0.
     *
     * @return the progress property
     */
    public DoubleProperty progressProperty() {
        return progress;
    }


    /**
     * The status property indicates the parsing state
     *
     * @return the status property
     */
    public StringProperty statusProperty() {
        return status;
    }

    /**
     * Update a given double property in the JavaFX application thread, no matter which thread calls this method.
     *
     * @param progress the progress property to update
     * @param newValue the new value to set
     */
    void updateProgress( DoubleProperty progress, double newValue) {

        if ( withoutUI ) {
            LOG.info("update progress to {}", newValue);
            progress.set(newValue);
        } else {
            LOG.info("update UI progress to {}", newValue);
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    progress.set(newValue);
                }
            });
        }
    }

    /**
     * Update a given double property in the JavaFX application thread, no matter which thread calls this method.
     *
     * @param progress the progress property to update
     * @param newValue the new value to set
     */
    void updateProgress( StringProperty progress, String newValue) {

        if ( withoutUI ) {
            progress.set(newValue);
        } else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    progress.set(newValue);
                }
            });
        }
    }





    private static class OCXPFindNamespaceHandler extends DefaultHandler {
        private String namespace = null;

        public String getNamespace() {
            return namespace;
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            if (namespace == null) {
                LOG.info("startElement {}", qName);
                int idx = qName.indexOf(':');
                var prefix = idx > 0 ? qName.substring(0, idx) : "";
                var local = idx > 0 ? qName.substring(idx + 1) : qName;
                LOG.info("prefix {} local {}", prefix, local);

                for (int i = 0; i < attributes.getLength(); i++) {
                    var attrQName = attributes.getQName(i);
                    int attrIdx = attrQName.indexOf(':');
                    var attrPrefix = attrIdx > 0 ? attrQName.substring(0, attrIdx) : "";
                    var attrLocal = attrIdx > 0 ? attrQName.substring(attrIdx + 1) : attrQName;

                    LOG.info("    attr {}|{}={}", attrPrefix, attrLocal, attributes.getValue(i));

                    if (prefix.equals(attrLocal)) {
                        namespace = attributes.getValue(i);
                        throw new ArithmeticException("found namespace " + namespace);
                    }
                }
            }
        }

    }

}
