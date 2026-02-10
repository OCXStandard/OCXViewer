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

import de.cadoculus.ocxviewer.io.OCXIO;
import de.cadoculus.ocxviewer.logging.LoggerHelper;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ocx_schema.v310.Bracket;
import org.ocx_schema.v310.BracketParameters;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BracketGeometryTest {
    private static final Logger LOG = LogManager.getLogger(BracketGeometryTest.class);

    @BeforeAll
    static void setUp() {

        File f = new File("data/testLog4j2.xml");
        LoggerHelper.initLogging(f);

    }

    @Test
    public void test001() {

        var mm = UnitHelper.getMilliMeterUnit();


        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(150, mm));

        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        final BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);

        assertNotNull(issues);
        assertEquals(0, issues.size(), "There should be no issues with the geometry calculation");

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(1.0, 0.0, 0.0), vDirection=(0.0, 1.0, 0.0), wDirection=(0.0, 0.0, 1.0), " +
                        "armLengthU=200.0, armLengthV=150.0, uNose=0.0, vNose=0.0, freeEdgeRadius=0.0, p1=(200.0, 0.0, 0.0), p2=(0.0, 150.0, 0.0), p3=(200.0, 0.0, 0.0), p4=(0.0, 150.0, 0.0), p5=null]"
                , bracketGeometry.toString());


    }

    @Test
    public void test002() {

        var mm = UnitHelper.getMilliMeterUnit();


        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(150, mm));
        bracketParameters.setVnose(UnitHelper.toQuantity(10, mm));


        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

         BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);

        assertNotNull(issues);
        assertEquals(0, issues.size(), "There should be no issues with the geometry calculation");

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(1.0, 0.0, 0.0), vDirection=(0.0, 1.0, 0.0), wDirection=(0.0, 0.0, 1.0)," +
                        " armLengthU=200.0, armLengthV=150.0, uNose=0.0, vNose=10.0, freeEdgeRadius=0.0, " +
                        "p1=(200.0, 0.0, 0.0), p2=(0.0, 150.0, 0.0), p3=(200.0, 10.0, 0.0), p4=(0.0, 150.0, 0.0), p5=null]"
                , bracketGeometry.toString());

        // invert u and v direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);
        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(150, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setUnose(UnitHelper.toQuantity(10, mm));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 2: '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(0.0, 1.0, 0.0), vDirection=(1.0, 0.0, 0.0), wDirection=(0.0, 0.0, -1.0)," +
                        " armLengthU=150.0, armLengthV=200.0, uNose=10.0, vNose=0.0, freeEdgeRadius=0.0, " +
                        "p1=(0.0, 150.0, 0.0), p2=(200.0, 0.0, 0.0), p3=(0.0, 150.0, 0.0), p4=(200.0, 10.0, 0.0), p5=null]"
                , bracketGeometry.toString());


        // add noseheight on both
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);
        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(150, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setUnose(UnitHelper.toQuantity(15, mm));
        bracketParameters.setVnose(UnitHelper.toQuantity(20, mm));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 3: '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(0.0, 1.0, 0.0), vDirection=(1.0, 0.0, 0.0), wDirection=(0.0, 0.0, -1.0), armLengthU=150.0, armLengthV=200.0, uNose=15.0, vNose=20.0, freeEdgeRadius=0.0, " +
                        "p1=(0.0, 150.0, 0.0), p2=(200.0, 0.0, 0.0), p3=(20.0, 150.0, 0.0), p4=(200.0, 15.0, 0.0), p5=null]"
                , bracketGeometry.toString());

        // flip U direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);
        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, -1, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(150, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setUnose(UnitHelper.toQuantity(15, mm));
        bracketParameters.setVnose(UnitHelper.toQuantity(20, mm));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 4: '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(0.0, -1.0, 0.0), vDirection=(1.0, 0.0, 0.0), wDirection=(-0.0, 0.0, 1.0)," +
                        " armLengthU=150.0, armLengthV=200.0, uNose=15.0, vNose=20.0, freeEdgeRadius=0.0, " +
                        "p1=(0.0, -150.0, 0.0), p2=(200.0, 0.0, 0.0), p3=(20.0, -150.0, 0.0), p4=(200.0, -15.0, 0.0), p5=null]"
                , bracketGeometry.toString());

        // flip V direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);
        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(-1, 0, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(150, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setUnose(UnitHelper.toQuantity(15, mm));
        bracketParameters.setVnose(UnitHelper.toQuantity(20, mm));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 5: '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(0.0, 1.0, 0.0), vDirection=(-1.0, 0.0, 0.0), wDirection=(0.0, -0.0, 1.0)," +
                        " armLengthU=150.0, armLengthV=200.0, uNose=15.0, vNose=20.0, freeEdgeRadius=0.0, " +
                        "p1=(0.0, 150.0, 0.0), p2=(-200.0, 0.0, 0.0), p3=(-20.0, 150.0, 0.0), p4=(-200.0, 15.0, 0.0), p5=null]"
                , bracketGeometry.toString());

        // flip U & V direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);
        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, -1, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(-1, 0, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(150, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setUnose(UnitHelper.toQuantity(15, mm));
        bracketParameters.setVnose(UnitHelper.toQuantity(20, mm));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 5: '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(0.0, -1.0, 0.0), vDirection=(-1.0, 0.0, 0.0), wDirection=(-0.0, -0.0, -1.0)," +
                        " armLengthU=150.0, armLengthV=200.0, uNose=15.0, vNose=20.0, freeEdgeRadius=0.0, " +
                        "p1=(0.0, -150.0, 0.0), p2=(-200.0, 0.0, 0.0), p3=(-20.0, -150.0, 0.0), p4=(-200.0, -15.0, 0.0), p5=null]"
                , bracketGeometry.toString());

    }

    @Test
    public void test003() {

        var mm = UnitHelper.getMilliMeterUnit();

        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setFreeEdgeRadius(UnitHelper.toQuantity(200, mm));


        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);

        assertNotNull(issues);
        assertEquals(0, issues.size(), "There should be no issues with the geometry calculation");

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(1.0, 0.0, 0.0), vDirection=(0.0, 1.0, 0.0), wDirection=(0.0, 0.0, 1.0)," +
                        " armLengthU=200.0, armLengthV=200.0, uNose=0.0, vNose=0.0, freeEdgeRadius=200.0, " +
                        "p1=(200.0, 0.0, 0.0), p2=(0.0, 200.0, 0.0), p3=(200.0, 0.0, 0.0), p4=(0.0, 200.0, 0.0), p5=(200.0, 200.0, 0.0)]"
                , bracketGeometry.toString());

        // flip U direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(-1, 0, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 1, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setFreeEdgeRadius(UnitHelper.toQuantity(200, mm));


        LOG.info("bracket {}", OCXIO.serialize(bracket));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry2:  '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(-1.0, 0.0, 0.0), vDirection=(0.0, 1.0, 0.0), wDirection=(0.0, 0.0, -1.0)," +
                        " armLengthU=200.0, armLengthV=200.0, uNose=0.0, vNose=0.0, freeEdgeRadius=200.0, " +
                        "p1=(-200.0, 0.0, 0.0), p2=(0.0, 200.0, 0.0), p3=(-200.0, 0.0, 0.0), p4=(0.0, 200.0, 0.0), p5=(-200.0, 200.0, 0.0)]"
                , bracketGeometry.toString());


        // flip V direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(1, 0, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, -1, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setFreeEdgeRadius(UnitHelper.toQuantity(200, mm));


        LOG.info("bracket {}", OCXIO.serialize(bracket));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 3:  '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(1.0, 0.0, 0.0), vDirection=(0.0, -1.0, 0.0), wDirection=(0.0, 0.0, -1.0)," +
                        " armLengthU=200.0, armLengthV=200.0, uNose=0.0, vNose=0.0, freeEdgeRadius=200.0, " +
                        "p1=(200.0, 0.0, 0.0), p2=(0.0, -200.0, 0.0), p3=(200.0, 0.0, 0.0), p4=(0.0, -200.0, 0.0), p5=(200.0, -200.0, 0.0)]"
                , bracketGeometry.toString());



        // flip U & V direction
        bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(0, 0, 0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(-1, 0, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, -1, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(200, mm));
        bracketParameters.setFreeEdgeRadius(UnitHelper.toQuantity(200, mm));


        LOG.info("bracket {}", OCXIO.serialize(bracket));

        bg = new BracketGeometry(bracket);
        bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry 4:  '{}'", bracketGeometry);

        assertNotNull(bracketGeometry);
        assertEquals("BracketPoints3D[origin=(0.0, 0.0, 0.0), uDirection=(-1.0, 0.0, 0.0), vDirection=(0.0, -1.0, 0.0), wDirection=(0.0, 0.0, 1.0)," +
                        " armLengthU=200.0, armLengthV=200.0, uNose=0.0, vNose=0.0, freeEdgeRadius=200.0, " +
                        "p1=(-200.0, 0.0, 0.0), p2=(0.0, -200.0, 0.0), p3=(-200.0, 0.0, 0.0), p4=(0.0, -200.0, 0.0), p5=(-200.0, -200.0, 0.0)]"
                , bracketGeometry.toString());

    }


    @Test
    public void test020() {

        var mm = UnitHelper.getMilliMeterUnit();


        // on Z Plane
        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(10, 20, 30), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(10, 5, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(5, -25, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(150, mm));

        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        final BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);

        final BracketGeometry.BracketPoints2D bracketGeometry2D = bg.getBracketGeometry2D();

        LOG.info("created bracket geometry 2D: '{}'", bracketGeometry2D);

        assertNotNull(bracketGeometry2D);
        assertEquals("BracketPoints2D[origin=(147.08710135363805, 0.0), uDirection=(0.4472135954999579, 0.8944271909999159), vDirection=(-0.9805806756909202, 0.19611613513818404), " +
                        "width=236.52982045362964, height=178.88543819998318, p1=(236.52982045362964, 178.88543819998318), p2=(0.0, 29.417420270727604), p3=(0.0, 29.417420270727604), p4=(0.0, 29.417420270727604), p5=null, " +
                        "hoco=-0.0, 1.0, -0.0, 127.08710135363805\n" +
                        "1.0, 0.0, -0.0, -10.0\n" +
                        "0.0, 0.0, 1.0, -30.0\n" +
                        "0.0, 0.0, 0.0, 1.0\n" +
                        "]"
                , bracketGeometry2D.toString());



    }


}