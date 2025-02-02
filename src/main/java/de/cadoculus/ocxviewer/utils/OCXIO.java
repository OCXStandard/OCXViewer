package de.cadoculus.ocxviewer.utils;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

import org.ocx_schema.v310rc3.*;
import java.io.IOException;

public class OCXIO  {

    public static JAXBElement<OcxXMLT> read(java.io.File file) throws IOException {

        try {
            var jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[]{
                                oasis.unitsml.ObjectFactory.class,
                            org.ocx_schema.v310rc3.ObjectFactory.class}, null);
            var jaxUnmarshaller = jaxbContext.createUnmarshaller();
            return (JAXBElement<OcxXMLT>) jaxUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new IOException(e);
        }


    }
}
