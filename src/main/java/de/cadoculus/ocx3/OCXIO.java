package de.cadoculus.ocx3;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

import java.io.IOException;

public class OCXIO  {

    public static OcxXML read(java.io.File file) throws IOException {

        try {
            var jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[]{ObjectFactory.class, de.cadoculus.unitsml.ObjectFactory.class}, null);
            var jaxUnmarshaller = jaxbContext.createUnmarshaller();
            return (OcxXML) jaxUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new IOException(e);
        }


    }
}
