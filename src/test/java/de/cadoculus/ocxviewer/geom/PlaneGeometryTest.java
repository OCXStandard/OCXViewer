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
package de.cadoculus.ocxviewer.geom;

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.vecmath.Vector3d;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaneGeometryTest {
    private static final Logger LOG = LogManager.getLogger(PlaneGeometryTest.class);

    @BeforeAll
    static void setUp() {

        File f = new File("data/testLog4j2.xml");
        LoggerHelper.initLogging(f);

    }

    @Test
    void projectToPlane() {


        var plane = PlaneGeometry.REFERENCE;

        for ( int i = 0; i < 360; i+=10) {
            var vector = new Vector3d(Math.cos( Math.toRadians(i)),Math.sin( Math.toRadians(i)),0);
             var projected = plane.projectToPlane(vector);
             LOG.info("Original: {}, Projected: {}", vector, projected);
             assertEquals(vector, projected);
        }

        for ( int i = 0; i < 360; i+=10) {
            var vector = new Vector3d(1, Math.cos( Math.toRadians(i)),Math.sin( Math.toRadians(i)));
            var projected = plane.projectToPlane(vector);
            var expected = new Vector3d(vector.x, vector.y, 0);
            LOG.info("Original: {}, Projected: {}", vector, projected);
            assertEquals(expected, projected);
        }


        //System.out.println("Bracket uDirection length is too small: %f< 0.5".formatted(0.123));


    }
}