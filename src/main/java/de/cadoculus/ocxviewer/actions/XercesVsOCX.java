/*
Copyright 2025 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer.actions;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.net.URI;


public class XercesVsOCX {
    public static void main(String... args) throws Exception {

        var unitsMl = "https://raw.githubusercontent.com/OCXStandard/ocx-unitsml/refs/heads/main/ocx_unitsml/unitsmlSchema_lite.xsd";
        var ocx = "https://3docx.org/fileadmin//ocx_schema//V310rc3//OCX_Schema.xsd";
        var ocxStream = new URI(ocx).toURL().openStream();
        var ocxSrc = new StreamSource(ocxStream);

        var schemaDocuments = new StreamSource[]{ocxSrc};

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schemaFactory.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("Warning: " + exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("Error: " + exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("Fatal error: " + exception.getMessage());
            }
        });
        var xsdSchema = schemaFactory.newSchema(schemaDocuments);

        System.out.printf("loaded %s", xsdSchema);
    }
}
