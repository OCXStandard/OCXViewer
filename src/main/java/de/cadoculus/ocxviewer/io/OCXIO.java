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

import jakarta.xml.bind.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.OcxXMLT;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParserFactory;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * This class provides methods to read and write OCX files.
 */
public class OCXIO  {

    private static final Logger LOG = LogManager.getLogger(OCXIO.class);

    /**
     * Reads an OCX file from the given file.
     * @param file the file to read the OCX file from.
     * @param listener an optional PropertyChangeListener
     * @return the OCXReadResult
     * @throws IOException when io failed
     * @throws IllegalArgumentException if the given file does not exist
     */
    public static OCXReadResult read(java.io.File file, PropertyChangeListener ... listener) throws IOException {

        if ( ! file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + file.getAbsolutePath());
        }
        PropertyChangeListener pcl = listener !=null && listener.length > 0 ? listener[0] : null;

        // first we need to check the namespace used in the file
        final String targetNamespace = "https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd";
        String usedNamespace = null;
        final var handler = new FindNamespaceHandler();
        try (FileInputStream fis = new FileInputStream(file)) {

            var factory = SAXParserFactory.newInstance();
            var saxParser = factory.newSAXParser();

            saxParser.parse(fis, handler);
        } catch (ArithmeticException e) {
            usedNamespace = handler.getNamespace();
        } catch (Exception exp) {
            LOG.error("failed to read namespace", exp);
            throw new IOException("failed to read namespace", exp);
        }
        LOG.info("file {} uses namespace {}", file.getName(), usedNamespace);

        try (var fis = new ProgressInputStream(file); var rep = new ReplacingInputStream(fis, usedNamespace, targetNamespace)) {
//            var jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
//                    .createContext(new Class[]{
//                                oasis.unitsml.ObjectFactory.class,
//                            org.ocx_schema.v310rc3.ObjectFactory.class}, null);
            if ( pcl !=null) {
                fis.addPropertyChangeListener(pcl);
            }
            var jaxbContext =  JAXBContext.newInstance( new Class[] {
                            oasis.unitsml.ObjectFactory.class,
                            org.ocx_schema.v310.ObjectFactory.class});
            var jaxUnmarshaller = jaxbContext.createUnmarshaller();

            final Object unmarshal = jaxUnmarshaller.unmarshal(rep);
            LOG.info("loaded {} from {}", unmarshal, file.getAbsolutePath());

            if ( unmarshal instanceof JAXBElement jaxbElement && jaxbElement.getValue() instanceof OcxXMLT ocxXMLT) {

                LOG.info("loaded {} {} ", jaxbElement.getName(), ocxXMLT);

                return new OCXReadResult(usedNamespace, ocxXMLT);
            }

            LOG.error("failed to loaded OCX file, got unexpected type {}", unmarshal.getClass());
            throw new IOException("unexpected type " + unmarshal.getClass());

        } catch (Exception e) {
            LOG.error("failed to read OCX from {}", file.getAbsolutePath(), e);
            throw new IOException(e);
        }

    }

    public static String serialize(Object obj) {
        if ( obj == null) {
            return "/NULL";
        }
        try {
//            var jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
//                    .createContext(new Class[]{
//                            oasis.unitsml.ObjectFactory.class,
//                            org.ocx_schema.v310rc3.ObjectFactory.class}, null);
//            var jaxMarshaller = jaxbContext.createMarshaller();
//            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();

//            jaxMarshaller.marshal(obj, sw);
            return sw.toString();
        } catch (Exception e) {
            LOG.error("failed to serialize", e);

        }
        return "";
    }

    /**
     * Writes the given OCX to the given file.
     * @param ocx the OCX to write
     * @param file the file to write the OCX to
     * @throws IOException when io failed
     * @throws IllegalArgumentException if the given file does not exist
     */
    public static void write(OcxXMLT ocx, java.io.File file ) throws IOException {
        if ( !file.canWrite()) {
            throw new IllegalArgumentException("File is write protected: " + file.getAbsolutePath());
        }
        try {
//            var jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
//                    .createContext(new Class[]{
//                                oasis.unitsml.ObjectFactory.class,
//                            org.ocx_schema.v310rc3.ObjectFactory.class}, null);
//            var jaxMarshaller = jaxbContext.createMarshaller();
//            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            var qname = new QName("https://3docx.org/fileadmin//ocx_schema//V310rc3//OCX_Schema.xsd", "ocxXML");
//            var jaxb = new JAXBElement<>(qname, OcxXMLT.class, ocx);
//            jaxMarshaller.marshal(jaxb, file);
//            LOG.info("saved {} to {}", ocx, file.getAbsolutePath());
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static class FindNamespaceHandler extends DefaultHandler {
        private String namespace = null;

        public String getNamespace() {
            return namespace;
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            if (namespace == null) {
                LOG.info("startElement {}", qName);
                int idx = qName.indexOf(':');
                var prefix  = idx > 0 ? qName.substring(0, idx) : "";
                var local = idx > 0 ? qName.substring(idx+1) : qName;
                LOG.info("prefix {} local {}", prefix, local);

                for (int i = 0; i < attributes.getLength(); i++) {
                    var attrQName = attributes.getQName(i);
                    int attrIdx = attrQName.indexOf(':');
                    var attrPrefix  = attrIdx > 0 ? attrQName.substring(0, attrIdx) : "";
                    var attrLocal = attrIdx > 0 ? attrQName.substring(attrIdx+1) : attrQName;

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
