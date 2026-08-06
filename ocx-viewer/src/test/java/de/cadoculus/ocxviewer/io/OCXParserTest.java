package de.cadoculus.ocxviewer.io;

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import jakarta.xml.bind.JAXBElement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ocx_schema.v3x.*;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

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

        var file = new File("data/Schema310/PROSTEP/V3.1.0/TR03_TC10_psav.3docx");
        LOG.info("load {}", file.getAbsolutePath());

        var parser = new OCXParser(file);

        parser.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                LOG.info("total progress: {}%", String.format("%.2f", t1.doubleValue() * 100.0));
            }
        });

        var result =parser.parse();

        LOG.info("parsed {}", file.getAbsolutePath());
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
        LOG.info("check stiffener {} ({})", stiffener.getId(), stiffener.getGUIDRef());
        assertNotNull(stiffener, "found stiffener");

        assertNotNull(stiffener.getMaterialRef(), "has stiffener material");
        LOG.info(" found stiffener material reference: {} {},  ref type '{}'", stiffener.getMaterialRef().getReferenced(),
                stiffener.getMaterialRef().getLocalRef(),
                stiffener.getMaterialRef().getRefType());
        assertNotNull(stiffener.getMaterialRef().getReferenced(), "stiffener material is resolved");

        assertNotNull(stiffener.getSectionRef(), "has stiffener section");
        LOG.info(" found stiffener section reference: {} --> {}, localRef {}, guidRef '{}', ref type '{}'",
                OCXIO.serialize( stiffener.getSectionRef()),
                stiffener.getSectionRef().getReferenced(),
                stiffener.getSectionRef().getLocalRef(),
                stiffener.getSectionRef().getGUIDRef(),
                stiffener.getSectionRef().getRefType());
        assertNotNull(stiffener.getSectionRef().getReferenced(), "stiffener section is resolved" + OCXIO.serialize(stiffener.getSectionRef()));


    }


    @Test
    public void testGeometryExtensions() throws IOException {

        var file = new File("data/Schema310/brackets.3docx");
        LOG.info("load {}", file.getAbsolutePath());

        var parser = new OCXParser(file);

        parser.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                LOG.info("total progress: {}%", String.format("%.2f", t1.doubleValue() * 100.0));
            }
        });

        var result =parser.parse();

        LOG.info("parsed {}", file.getAbsolutePath());
        assertNotNull(result);

        final OcxXMLT ocx = result.ocx();
        Vessel vessel = (Vessel) ocx.getForm().getValue();
        final Arrangement arrangement = vessel.getArrangement();
        assertNotNull(result, "arrangement");
        arrangement.getCompartmentsAndPhysicalSpaces().stream().forEach( entityBaseT -> { LOG.info(" found {}", entityBaseT.getId());});
        final Optional<EntityBaseT> firstO = arrangement.getCompartmentsAndPhysicalSpaces().stream().filter(entityBaseT -> "nplcid22".equals(entityBaseT.getId())).findFirst();
        assertTrue(firstO.isPresent(), "found nplcid22");
        Compartment comp = (Compartment)firstO.get();
        var compFace0 = comp.getCompartmentFaces().getFirst();
        for (JAXBElement<? extends Curve3DT> curve3D : compFace0.getFaceBoundaryCurve().getCurve3Ds()) {
            LOG.info("curve {}", curve3D.getValue());
            if ( curve3D.getValue() instanceof  CompositeCurve3DT compositeCurve3DT) {
                for (var  innerCurves : compositeCurve3DT.getPolyLine3DsAndLine3DsAndNURBS3DS()) {
                    LOG.info("inner curve {}", innerCurves);
                }

            }
        }


    }



}