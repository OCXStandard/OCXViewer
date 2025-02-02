package de.cadoculus.ocx3;

import jakarta.xml.bind.JAXBElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class OCXIOTest {

    @TempDir
    File tempDir;

    @Test
    void readValidFile() throws IOException {

        var file = new File("data/Schema version 3.0.0/NAPA-OCX_M1.3docx");

        JAXBElement<OcxXML> result = OCXIO.read(file);

        assertNotNull(result);
        assertTrue(result.getValue() instanceof OcxXML);
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