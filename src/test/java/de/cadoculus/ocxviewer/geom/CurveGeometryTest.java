/*
Copyright 2026 Carsten Zerbst

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
package de.cadoculus.ocxviewer.geom;

import de.cadoculus.ocxviewer.io.OCXParser;
import de.cadoculus.ocxviewer.io.OCXReadResult;
import de.cadoculus.ocxviewer.logging.LoggerHelper;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import jakarta.xml.bind.JAXBElement;
import oasis.unitsml.Unit;
import oasis.unitsml.UnitSet;
import oasis.unitsml.UnitsML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ocx_schema.v310.*;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CurveGeometryTest {
    private static final Logger LOG = LogManager.getLogger(BracketGeometryTest.class);
    private static Unit milliMeterUnit;
    private static OcxXMLT ocx;

    @BeforeAll
    static void setUp() {

        File f = new File("data/testLog4j2.xml");
        LoggerHelper.initLogging(f);

        milliMeterUnit = UnitHelper.getMilliMeterUnit();
        ocx = new OcxXMLT();
        ocx.setUnitsML(new UnitsML());
        ocx.getUnitsML().setUnitSet(new UnitSet());
        ocx.getUnitsML().getUnitSet().getUnits().add(milliMeterUnit);
        var vessel = new Vessel();
        var jb = new JAXBElement<FormT>(
                new javax.xml.namespace.QName("https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd", "Form"),
                FormT.class,
                vessel
        );
        ocx.setForm(jb);

        var tol = new QuantityT();
        tol.setUnit(milliMeterUnit);
        tol.setNumericvalue(1.0);
        vessel.setDistanceTolerance(tol);


    }

    @Test
    void testLine3DToPoints() {


        Line3DT line = new Line3DT();
        line.setStartPoint(UnitHelper.toPoint(new Point3d(0, 0, 0), milliMeterUnit));
        line.setEndPoint(UnitHelper.toPoint(new Point3d(1, 1, 1), milliMeterUnit));

        GeometryQuality quality = GeometryQuality.FINEST;
        List<Point3d> points = CurveGeometry.toPoints(ocx, line, quality, false);

        assertEquals(2, points.size());
        assertEquals(new Point3d(0, 0, 0), points.get(0));
        assertEquals(new Point3d(1, 1, 1), points.get(1));
    }

    @Test
    void testPolyLine3DToPoints() {
        PolyLine3DT poly = new PolyLine3DT();
        poly.getPoint3Ds().add(UnitHelper.toPoint(new Point3d(0, 0, 0), milliMeterUnit));
        poly.getPoint3Ds().add(UnitHelper.toPoint(new Point3d(1, 0, 0), milliMeterUnit));
        poly.getPoint3Ds().add(UnitHelper.toPoint(new Point3d(1, 1, 0), milliMeterUnit));

        GeometryQuality quality = GeometryQuality.FINEST;

        List<Point3d> points = CurveGeometry.toPoints(ocx, poly, quality, false);

        assertEquals(3, points.size());
        assertEquals(new Point3d(0, 0, 0), points.get(0));
        assertEquals(new Point3d(1, 0, 0), points.get(1));
        assertEquals(new Point3d(1, 1, 0), points.get(2));
    }

    @Test
    void testCircumCircle3DToPoints() {

        var radiuses = List.of(1.0, 50.0, 1000.0);

        for (GeometryQuality quality : GeometryQuality.values()) {

            for (Double radius : radiuses) {

                var input = List.of(new Point3d(0, radius, 0), new Point3d(radius, 0, 0), new Point3d(radius * 1 / Math.sqrt(2), -radius * 1 / Math.sqrt(2), 0));


                CircumCircle3DT circle = new CircumCircle3DT();
                circle.setPositions(new Positions());
                circle.getPositions().getPoint3Ds().add(UnitHelper.toPoint(input.getFirst(), milliMeterUnit));
                circle.getPositions().getPoint3Ds().add(UnitHelper.toPoint(input.get(1), milliMeterUnit));
                circle.getPositions().getPoint3Ds().add(UnitHelper.toPoint(input.getLast(), milliMeterUnit));


                List<Point3d> output = CurveGeometry.toPoints(ocx, circle, quality, true);
                LOG.info("CircumCircle3DT Points for radius {}, quality {} : #{} {}", radius, quality, output.size(), output);
                assertTrue(output.size() > 3);

                var origin = new Point3d(0, 0, 0);
                for (Point3d point3d : output) {
                    assertTrue(Math.abs(origin.distance(point3d) - radius) <= quality.getMaxDistance(), "distance to center ~" + radius + " : " + point3d);
                }

            }
        }
    }

    @Test
    void testCircumArc3DToPoints() {
        CircumArc3DT arc = new CircumArc3DT();


        var radiuses = List.of(1.0, 50.0, 1000.0);

        for (GeometryQuality quality : GeometryQuality.values()) {

            for (Double radius : radiuses) {

                var input = List.of(new Point3d(0, radius, 0), new Point3d(radius, 0, 0), new Point3d(radius * 1 / Math.sqrt(2), -radius * 1 / Math.sqrt(2), 0));
                arc.setStartPoint(UnitHelper.toPoint(input.getFirst(), milliMeterUnit));

                arc.setIntermediatePoint(UnitHelper.toPoint(input.get(1), milliMeterUnit));
                arc.setEndPoint(UnitHelper.toPoint(input.getLast(), milliMeterUnit));

                List<Point3d> output = CurveGeometry.toPoints(ocx, arc, quality, false);

                LOG.info("CircumArc3DT Points for radius {}, quality {} : #{} {}", radius, quality, output.size(), output);

                assertTrue(output.size() >= 2);
                assertEquals(input.getFirst(), output.getFirst());
                assertEquals(input.getLast(), output.getLast());

                var origin = new Point3d(0, 0, 0);
                for (Point3d point3d : output) {
                    assertTrue(Math.abs(origin.distance(point3d) - radius) <= quality.getMaxDistance(), "distance to center ~" + radius + " : " + point3d);
                    assertTrue(point3d.x >= 0, "x should be positive " + point3d);
                }
            }
        }

    }


    @Test
    void testEllipse3DTToPoints() {


        var radiuses = List.of(1.0, 50.0, 1000.0);
        var proportions = List.of(1.0, 2.0, 10.0);
        var angles = List.of(0.0, 45.0, 90.0, 120.0);

        for (GeometryQuality quality : GeometryQuality.values()) {
            for (Double angle : angles) {
                for (Double proportion : proportions) {
                    for (Double radius : radiuses) {

                        var theta = Math.toRadians(angle);
                        Ellipse3DT ellipse3DT = new Ellipse3DT();
                        ellipse3DT.setCenter(UnitHelper.toPoint(new Point3d(0, 0, 0), milliMeterUnit));
                        ellipse3DT.setNormal(UnitHelper.toVector(new Vector3d(0, 0, 1)));
                        ellipse3DT.setMajorAxis(UnitHelper.toVector(new Vector3d(Math.cos(theta), Math.sin(theta), 0)));
                        ellipse3DT.setMinorAxis(UnitHelper.toVector(new Vector3d(Math.sin(theta), Math.cos(theta), 0)));
                        ellipse3DT.setMajorDiameter(UnitHelper.toQuantity(radius * proportion, milliMeterUnit));
                        ellipse3DT.setMinorDiameter(UnitHelper.toQuantity(radius, milliMeterUnit));

                        List<Point3d> output = CurveGeometry.toPoints(ocx, ellipse3DT, quality, true);

                        LOG.info("Ellipse3DT Points for radius {}/{}, angle {}°, quality {} : #{} {}",
                                radius * proportion, radius, angle, quality, output.size(), output);

                        assertTrue(output.size() >= 2);
                        assertEquals(output.getFirst(), output.getLast());

                        var origin = new Point3d(0, 0, 0);

                    }
                }
            }
        }

    }

    @Test
    public void testNURBSCurve3DToPoints() throws IOException {

        var file = new File("data/NAPA-OCX_M2.3docx");
        assertTrue(file.exists(), "found file: " + file.getAbsolutePath());

        OCXParser parser = new OCXParser(file);
        final OCXReadResult result = parser.parse();
        final OcxXMLT ocx = result.ocx();


        var vessel = (Vessel) ocx.getForm().getValue();

        vessel.getPanels().forEach(panel -> LOG.info("found panel {}", panel.getId()));
        var panelO = vessel.getPanels().stream().filter(panel -> "nplcid12".equals(panel.getId())).findFirst();
        assertTrue(panelO.isPresent(), "found panel nplcid12");
        var plateO = panelO.get().getComposedOf().getPlates().stream().filter(testPlate -> "nplcid16".equals(testPlate.getId())).findFirst();
        assertTrue(plateO.isPresent(), "found plate nplcid16");

        final Curve3DT curve3DT = plateO.get().getOuterContour().getCurve3Ds().getFirst().getValue();
        assertEquals("nplcid19", curve3DT.getId(), "found curver nplcid19");
        assertEquals(CompositeCurve3DT.class, curve3DT.getClass(), "found CompositeCurve3DT nplcid19");

        var ccurve = (CompositeCurve3DT) curve3DT;
        var subCurve = ccurve.getPolyLine3DsAndLine3DsAndNURBS3DS().getFirst();
        assertEquals(NURBS3DT.class, subCurve.getClass(), "found NURBS3DT nplcid20");


        var nurbs3DT = (NURBS3DT) subCurve;

        for (GeometryQuality quality : GeometryQuality.values()) {
            List<Point3d> points = CurveGeometry.toPoints(ocx, nurbs3DT, quality, false);

            LOG.info("NURBSCurve3DT Points for quality {} : #{} {}", quality, points.size(), points);
        }

    }


}