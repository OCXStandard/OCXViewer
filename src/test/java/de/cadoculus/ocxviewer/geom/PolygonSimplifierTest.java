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

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point3d;
import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PolygonSimplifierTest {

    private static final Logger LOG = LogManager.getLogger(PolygonSimplifierTest.class);

    @BeforeAll
    static void setUp() {

        File f = new File("data/testLog4j2.xml");
        LoggerHelper.initLogging(f);

    }

    @Test
    void testDistanceToLine() {

        Point3d start = new Point3d(0, 0, 0);
        Point3d end = new Point3d(10, 0, 0);

        for (int i = -50; i <= 50; i++) {
            Point3d testPoint = new Point3d(5, i / 10.0, 0);

            double distance = PolygonSimplifier.distanceToLine(testPoint, start, end);

            assertEquals(Math.abs(i / 10.0), distance, 1e-6);
        }
    }


    @Test
    void testSimplifyOpenPolygon() {
        GeometryQuality quality = GeometryQuality.MEDIUM;

        PolygonSimplifier simplifier = new PolygonSimplifier(quality);

        List<Point3d> points = List.of(
                new Point3d(0, 0, 0),
                new Point3d(1, 0, 0),
                new Point3d(2, 0.5, 0),
                new Point3d(3, -0.5, 0),
                new Point3d(4, 0, 0)
        );

        List<Point3d> simplified = simplifier.simplify(points);

        assertEquals(2, simplified.size());
        assertEquals(new Point3d(0, 0, 0), simplified.getFirst());
        assertEquals(new Point3d(4, 0, 0), simplified.getLast());

    }


    @Test
    void testSimplifyClosedPolygon() {
        GeometryQuality quality = GeometryQuality.MEDIUM;

        PolygonSimplifier simplifier = new PolygonSimplifier(quality);

        List<Point3d> points = List.of(
                new Point3d(0, 0, 0),
                new Point3d(2, 0.25, 0),
                new Point3d(3, -0.25, 0),
                new Point3d(4, 0, 0),
                new Point3d(4.25, 5, 0),
                new Point3d(3.75, 6, 0),
                new Point3d(4, 10, 0),
                new Point3d(0, 0, 0)
        );

        List<Point3d> simplified = simplifier.simplify(points);

        LOG.info("Simplified polygon points: {}", simplified);
        assertEquals(4, simplified.size());


    }

    @Test
    void testTooFewPoints() {
        GeometryQuality quality = GeometryQuality.MEDIUM;
        PolygonSimplifier simplifier = new PolygonSimplifier(quality);

        List<Point3d> points = List.of(
                new Point3d(0, 0, 0),
                new Point3d(1, 0, 0)
        );

        List<Point3d> simplified = simplifier.simplify(points);

        assertEquals(points, simplified);
    }

    @Test
    void testNullInput() {
        GeometryQuality quality = GeometryQuality.MEDIUM;
        PolygonSimplifier simplifier = new PolygonSimplifier(quality);

        assertThrows(IllegalArgumentException.class, () -> simplifier.simplify(null));
    }
}