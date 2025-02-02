package de.cadoculus.ocx3;

import de.cadoculus.ocxviewer.views.HeaderPage;
import jakarta.xml.bind.JAXBElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitsMLTest {

    private static final Logger LOG = LogManager.getLogger(UnitsMLTest.class);



    @Test
    void readValidFile() throws IOException {

        var file = new File("data/Schema version 3.0.0/NAPA-OCX_M1.3docx");


        JAXBElement<OcxXML> result = OCXIO.read(file);

        assertNotNull(result);
        assertTrue(result.getValue() instanceof OcxXML);
    }
}
