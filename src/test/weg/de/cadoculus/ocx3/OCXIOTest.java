package de.cadoculus.ocx3;

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import de.cadoculus.ocxviewer.io.OCXIO;
import jakarta.xml.bind.JAXBElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.ocx_schema.v310rc3.OcxXMLT;

import java.io.File;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class OCXIOTest {


    @BeforeAll
    static void setUp() {

        File f = new File("data/log4j2.xml");
        LoggerHelper.initLogging(f);


    }
    @TempDir
    File tempDir;

    @Test
    void readValidFile() throws IOException {


        //var file = new File("data/Schema version 3.0.0/test.3docx");
        var file = new File("data/Schema version 3.0.0/NAPA-OCX_M1.3docx");

        var result = OCXIO.read(file);

        assertNotNull(result);
        assertNotNull(result.ocx() );
        var ocx = result.ocx();
        assertNotNull(ocx.getHeader(),"header");

        var outDir = new File("test-out");
        outDir.mkdirs();
        var outFile = new File(outDir, "OCXIOTest.readValidFile.xml");

        OCXIO.write(ocx, outFile);

    }

    @Test
    void readInvalidFile() {
        File file = new File(tempDir, "invalid.xml");
        assertThrows(IOException.class, () -> OCXIO.read(file));
    }

    @Test
    void readNonExistentFile() {
        File file = new File(tempDir, "nonexistent.xml");
        assertThrows(IOException.class, () -> OCXIO.read(file));
    }
}