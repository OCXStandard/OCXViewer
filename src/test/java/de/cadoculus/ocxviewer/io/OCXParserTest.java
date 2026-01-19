package de.cadoculus.ocxviewer.io;

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ocx_schema.v310.Panel;
import org.ocx_schema.v310.Plate;
import org.ocx_schema.v310.Stiffener;
import org.ocx_schema.v310.Vessel;


import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OCXParserTest {

    private static final Logger LOG = LogManager.getLogger(OCXParserTest.class);

    @BeforeAll
    static void setUp() {

        File f = new File("data/testLog4j2.xml");
        LoggerHelper.initLogging(f);

    }

    @Test
    void testReferences() throws IOException {
        LOG.error("run in {}", new File(".").getAbsolutePath());
        var file = new File("data/Schema310/PROSTEP/V3.1.0/TR03_TC10_psav.3docx");

        var parser = new OCXParser(file);

        parser.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                LOG.info("total progress: {}%", String.format("%.2f", t1.doubleValue() * 100.0));
            }
        });

        var result =parser.parse();
        assertNotNull(result);

        var vessel = (Vessel) result.ocx().getForm().getValue();
        final Panel panel = vessel.getPanels().stream().filter(test -> "panel_25170".equals(test.getId())).findFirst().get();
        assertNotNull(panel);


        final Plate plate = panel.getComposedOf().getPlates().getFirst();
        assertNotNull(plate, "found plate");
        assertNotNull(plate.getPlateMaterial(), "has plate material");

        LOG.info(" found plate material reference: {} {},  ref type '{}'", plate.getPlateMaterial().getReferenced(),
                plate.getPlateMaterial().getLocalRef(),
                plate.getPlateMaterial().getRefType());
        assertNotNull(plate.getPlateMaterial().getReferenced(), "plate material is resolved");


        final Stiffener stiffener = panel.getStiffenedBy().getStiffeners().getFirst();
        assertNotNull(stiffener, "found stiffener");
        assertNotNull(stiffener.getMaterialRef(), "has stiffener material");
        LOG.info(" found stiffener material reference: {} {},  ref type '{}'", stiffener.getMaterialRef().getReferenced(),
                stiffener.getMaterialRef().getLocalRef(),
                stiffener.getMaterialRef().getRefType());
        assertNotNull(stiffener.getMaterialRef().getReferenced(), "stiffener material is resolved");

        assertNotNull(stiffener.getSectionRef(), "has stiffener section");
        LOG.info(" found stiffener section reference: {} {},  ref type '{}'", stiffener.getSectionRef().getReferenced(),
                stiffener.getSectionRef().getLocalRef(),
                stiffener.getSectionRef().getRefType());
        assertNotNull(stiffener.getSectionRef().getReferenced(), "stiffener section is resolved");


    }

    //@Test
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


}