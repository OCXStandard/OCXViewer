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
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v3x.OcxXMLT;
import org.xml.sax.helpers.DefaultHandler;

import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * This class provides methods to read and write OCX files.
 *
 * @author Carsten Zerbst
 */
public class OCXIO {

    private static final Logger LOG = LogManager.getLogger(OCXIO.class);



    public static String serialize(Object obj) {
        if (obj == null) {
            return "/NULL";
        }
        try {

            var jaxbContext = JAXBContext.newInstance(new Class[]{
                    oasis.unitsml.ObjectFactory.class});
                    //org.ocx_schema.v3x.ObjectFactory.class});

            var jaxMarshaller = jaxbContext.createMarshaller();
            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();

            jaxMarshaller.marshal(obj, sw);
            return sw.toString();
        } catch (Exception e) {
            LOG.error("failed to serialize", e);

        }
        return "";
    }

    /**
     * Writes the given OCX to the given file.
     *
     * @param ocx  the OCX to write
     * @param file the file to write the OCX to
     * @throws IOException              when io failed
     * @throws IllegalArgumentException if the given file does not exist
     */
    public static void write(OcxXMLT ocx, java.io.File file) throws IOException {
        if (!file.canWrite()) {
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
