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

import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix4d;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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


        // on X Plane
        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(10, 20, 30), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 10, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 0, 10)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(150, mm));

        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        final BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);


        assertTrue(bracketGeometry.p1().distance(bracketGeometry.p3()) < 0.0001, "p1 and p3 should be the same point");
        assertTrue(bracketGeometry.p2().distance(bracketGeometry.p4()) < 0.0001, "p2 and p4 should be the same point");

        final BracketGeometry.BracketPoints2D bracketGeometry2D = bg.getBracketGeometry2D();

        LOG.info("created bracket geometry 2D: '{}'", bracketGeometry2D);

        assertNotNull(bracketGeometry2D);

        assertTrue(bracketGeometry2D.p1().distance(bracketGeometry2D.p3()) < 0.0001, "2D: p1 " + bracketGeometry2D.p1() + " and p3 " + bracketGeometry2D.p3() + " should be the same point ");
        assertTrue(bracketGeometry2D.p2().distance(bracketGeometry2D.p4()) < 0.0001, "2D: p1 " + bracketGeometry2D.p2() + " and p3 " + bracketGeometry2D.p4() + " should be the same point ");


        var reference2D = "BracketPoints2D[origin=(0.0, 150.0, 0.0), uDirection=(1.0, -0.0, -0.0), vDirection=(0.0, -1.0, -0.0), width=200.0, height=150.0, p1=(200.0, 150.0, 0.0), p2=(0.0, 0.0, 0.0), p3=(200.0, 150.0, 0.0), p4=(0.0, 0.0, 0.0), p5=null, hoco=0.0, 0.0, -1.0, 10.0\n" +
                "1.0, 0.0, -0.0, 20.0\n" +
                "0.0, -1.0, -0.0, 30.0\n" +
                "0.0, 0.0, 0.0, 1.0\n" +
                "]";

        assertEquals(reference2D, bracketGeometry2D.toString());

        var global2localT = new Matrix4d(bracketGeometry2D.global2localT());
        // hocoInv.invert();
        LOG.info("global2localT {}", global2localT);

        var testX = new Vector3d(PlaneGeometry.NORMAL_X);
        var testY = new Vector3d(PlaneGeometry.NORMAL_Y);
        var testZ = new Vector3d(PlaneGeometry.NORMAL_Z);

        global2localT.transform(testX);
        global2localT.transform(testY);
        global2localT.transform(testZ);
        LOG.info("X^t {}", testX);
        LOG.info("Y^t {}", testY);
        LOG.info("Z^t {}", testZ);

    }


    @Test
    public void test000() {

        var uDir = new Vector3d(1, 10, 0);
        var vDir = new Vector3d(1, 0, -10);
        var origin = new Point3d(10, 20, 30);
        uDir.normalize();
        vDir.normalize();

        LOG.info("uDir {}, vDir {}, origin {}", uDir, vDir, origin);

        var p1 = new Point3d(origin);
        var dU = new Vector3d(uDir);
        dU.scale(200);
        p1.add(dU);

        var p2 = new Point3d(origin);
        var dV = new Vector3d(vDir);
        dV.scale(100);
        p2.add(dV);

        LOG.info("origin {}, p1 {}, p2 {}", origin, p1, p2);

        var plane = new PlaneGeometry("testPlane", origin, p1, p2);
        LOG.info("plane {}", plane);

        var refDir1 = plane.getRefDir1();
        var refDir2 = plane.getRefDir2();
        LOG.info("refDir1 {}, refDir2 {}", refDir1, refDir2);

        var horizontal = new Vector3d(0, 100, 0);
        var hp = plane.projectToPlane(horizontal);
        hp.normalize();
        LOG.info("horizontal {}, projected {}", horizontal, hp);

        var normal = plane.getNormal();

        var vertical = new Vector3d();
        vertical.cross(normal, hp);
        vertical.normalize();
        LOG.info("vertical {}", vertical);


        var hoco = new Matrix4d();
        hoco.setIdentity();

        var rot = new Matrix3d();
        rot.setColumn(0, hp);
        rot.setColumn(1, vertical);
        rot.setColumn(2, normal);
        hoco.set(rot);

        hoco.m03 = origin.x;
        hoco.m13 = origin.y;
        hoco.m23 = origin.z;

        LOG.info("LocalToWorldTransform\n {} det {}", hoco, hoco.determinant());

        var hocoInv = new Matrix4d(hoco);
        hocoInv.invert();

        LOG.info("WorldToLocalTransform\n {}", hocoInv);

        LOG.info("uDir {}, vDir {}, origin {}", uDir, vDir, origin);


        var uTransformed = new Vector3d(uDir);
        hocoInv.transform(uTransformed);
        var vTransformed = new Vector3d(vDir);
        hocoInv.transform(vTransformed);
        var originTransformed = new Point3d(origin);
        hocoInv.transform(originTransformed);
        var p1T = new Point3d(p1);
        hocoInv.transform(p1T);
        var p2T = new Point3d(p2);
        hocoInv.transform(p2T);

        LOG.info("u L {}", uTransformed);
        LOG.info("v L {}", vTransformed);
        LOG.info("origin L {}", originTransformed);
        LOG.info("p1 L {}", p1T);
        LOG.info("p2 L {}", p2T);



    }

    @Test
    public void test020a() {

        var mm = UnitHelper.getMilliMeterUnit();


        // on X Plane
        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(10, 20, 30), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 10, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 0, -10)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(150, mm));

        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        final BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);


        assertTrue(bracketGeometry.p1().distance(bracketGeometry.p3()) < 0.0001, "p1 and p3 should be the same point");
        assertTrue(bracketGeometry.p2().distance(bracketGeometry.p4()) < 0.0001, "p2 and p4 should be the same point");

        final BracketGeometry.BracketPoints2D bracketGeometry2D = bg.getBracketGeometry2D();

        LOG.info("created bracket geometry 2D: '{}'", bracketGeometry2D);

        assertNotNull(bracketGeometry2D);

        assertTrue(bracketGeometry2D.p1().distance(bracketGeometry2D.p3()) < 0.0001, "2D: p1 " + bracketGeometry2D.p1() + " and p3 " + bracketGeometry2D.p3() + " should be the same point ");
        assertTrue(bracketGeometry2D.p2().distance(bracketGeometry2D.p4()) < 0.0001, "2D: p1 " + bracketGeometry2D.p2() + " and p3 " + bracketGeometry2D.p4() + " should be the same point ");


        var reference2D = "BracketPoints2D[origin=(0.0, 150.0, 0.0), uDirection=(1.0, 0.0, -0.0), vDirection=(0.0, -1.0, 0.0), width=200.0, height=150.0, p1=(200.0, 150.0, 0.0), p2=(0.0, 0.0, 0.0), p3=(200.0, 150.0, 0.0), p4=(0.0, 0.0, 0.0), p5=null, hoco=0.0, 0.0, -1.0, 10.0\n" +
                "1.0, -0.0, 0.0, 20.0\n" +
                "0.0, 1.0, 0.0, 30.0\n" +
                "0.0, 0.0, 0.0, 1.0\n" +
                "]";

        assertEquals(reference2D, bracketGeometry2D.toString());

        var global2localT = new Matrix4d(bracketGeometry2D.global2localT());
        // global2localT.invert();
        LOG.info("global2localT {}", global2localT);

        var testX = new Vector3d(PlaneGeometry.NORMAL_X);
        var testY = new Vector3d(PlaneGeometry.NORMAL_Y);
        var testZ = new Vector3d(PlaneGeometry.NORMAL_Z);

        global2localT.transform(testX);
        global2localT.transform(testY);
        global2localT.transform(testZ);
        LOG.info("X^t {}", testX);
        LOG.info("Y^t {}", testY);
        LOG.info("Z^t {}", testZ);

    }

    @Test
    public void test020b() {

        var mm = UnitHelper.getMilliMeterUnit();


        // on X Plane
        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(4500.0, -5682.46, 1500.0), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 10, 0)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(0, 0, 10)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(400, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(300, mm));

        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        final BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);


        assertTrue(bracketGeometry.p1().distance(bracketGeometry.p3()) < 0.0001, "p1 and p3 should be the same point");
        assertTrue(bracketGeometry.p2().distance(bracketGeometry.p4()) < 0.0001, "p2 and p4 should be the same point");

        final BracketGeometry.BracketPoints2D bracketGeometry2D = bg.getBracketGeometry2D();

        LOG.info("created bracket geometry 2D: '{}'", bracketGeometry2D);

        assertNotNull(bracketGeometry2D);

        assertTrue(bracketGeometry2D.p1().distance(bracketGeometry2D.p3()) < 0.0001, "2D: p1 " + bracketGeometry2D.p1() + " and p3 " + bracketGeometry2D.p3() + " should be the same point ");
        assertTrue(bracketGeometry2D.p2().distance(bracketGeometry2D.p4()) < 0.0001, "2D: p1 " + bracketGeometry2D.p2() + " and p3 " + bracketGeometry2D.p4() + " should be the same point ");


        var reference2D = "BracketPoints2D[origin=(0.0, 150.0, 0.0), uDirection=(1.0, 0.0, -0.0), vDirection=(0.0, -1.0, 0.0), width=200.0, height=150.0, p1=(200.0, 150.0, 0.0), p2=(0.0, 0.0, 0.0), p3=(200.0, 150.0, 0.0), p4=(0.0, 0.0, 0.0), p5=null, hoco=0.0, 0.0, -1.0, 10.0\n" +
                "1.0, -0.0, 0.0, 20.0\n" +
                "0.0, 1.0, 0.0, 30.0\n" +
                "0.0, 0.0, 0.0, 1.0\n" +
                "]";

        assertEquals(reference2D, bracketGeometry2D.toString());

        var global2localT = new Matrix4d(bracketGeometry2D.global2localT());
        // global2localT.invert();
        LOG.info("global2localT {}", global2localT);

        var testX = new Vector3d(PlaneGeometry.NORMAL_X);
        var testY = new Vector3d(PlaneGeometry.NORMAL_Y);
        var testZ = new Vector3d(PlaneGeometry.NORMAL_Z);

        global2localT.transform(testX);
        global2localT.transform(testY);
        global2localT.transform(testZ);
        LOG.info("X^t {}", testX);
        LOG.info("Y^t {}", testY);
        LOG.info("Z^t {}", testZ);

    }


    @Test
    public void test021() {

        var mm = UnitHelper.getMilliMeterUnit();


        // on Y Plane
        var bracket = new Bracket();
        var bracketParameters = new BracketParameters();
        bracket.setBracketParameters(bracketParameters);

        bracketParameters.setOrigin(UnitHelper.toPoint(new Point3d(10, 20, 30), mm));
        bracketParameters.setUDirection(UnitHelper.toVector(new Vector3d(0, 0, -10)));
        bracketParameters.setVDirection(UnitHelper.toVector(new Vector3d(-10, 0, 0)));
        bracketParameters.setArmLengthU(UnitHelper.toQuantity(200, mm));
        bracketParameters.setArmLengthV(UnitHelper.toQuantity(150, mm));

        LOG.info("bracket {}", OCXIO.serialize(bracket));

        var bg = new BracketGeometry(bracket);
        final Set<String> issues = bg.getIssues();
        LOG.info("issues {}", issues);

        final BracketGeometry.BracketPoints3D bracketGeometry = bg.getBracketGeometry();

        LOG.info("created bracket geometry: '{}'", bracketGeometry);


        assertTrue(bracketGeometry.p1().distance(bracketGeometry.p3()) < 0.0001, "p1 and p3 should be the same point");
        assertTrue(bracketGeometry.p2().distance(bracketGeometry.p4()) < 0.0001, "p2 and p4 should be the same point");

        final BracketGeometry.BracketPoints2D bracketGeometry2D = bg.getBracketGeometry2D();

        LOG.info("created bracket geometry 2D: '{}'", bracketGeometry2D);

        assertNotNull(bracketGeometry2D);

        assertTrue(bracketGeometry2D.p1().distance(bracketGeometry2D.p3()) < 0.0001, "2D: p1 " + bracketGeometry2D.p1() + " and p3 " + bracketGeometry2D.p3() + " should be the same point ");
        assertTrue(bracketGeometry2D.p2().distance(bracketGeometry2D.p4()) < 0.0001, "2D: p1 " + bracketGeometry2D.p2() + " and p3 " + bracketGeometry2D.p4() + " should be the same point ");


        var reference2D = "BracketPoints2D[origin=(150.0, 200.0, 0.0), uDirection=(0.0, -1.0, 0.0), vDirection=(-1.0, 0.0, 0.0), width=150.0, height=200.0, p1=(150.0, 0.0, 0.0), p2=(0.0, 200.0, 0.0), p3=(150.0, 0.0, 0.0), p4=(0.0, 200.0, 0.0), p5=null, hoco=1.0, 0.0, 0.0, 10.0\n" +
                "0.0, 0.0, 1.0, 20.0\n" +
                "0.0, 1.0, 0.0, 30.0\n" +
                "0.0, 0.0, 0.0, 1.0\n" +
                "]";

        assertEquals(reference2D, bracketGeometry2D.toString());

        var global2localT = new Matrix4d(bracketGeometry2D.global2localT());
        // global2localT.invert();
        LOG.info("global2localT {}", global2localT);

        var testX = new Vector3d(PlaneGeometry.NORMAL_X);
        var testY = new Vector3d(PlaneGeometry.NORMAL_Y);
        var testZ = new Vector3d(PlaneGeometry.NORMAL_Z);

        global2localT.transform(testX);
        global2localT.transform(testY);
        global2localT.transform(testZ);
        LOG.info("X^t {}", testX);
        LOG.info("Y^t {}", testY);
        LOG.info("Z^t {}", testZ);

    }

    @Test
    public void test022() {

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
        assertEquals("BracketPoints2D[origin=(0.0, 147.08710135363805, 0.0), uDirection=(0.8944271909999159, 0.4472135954999579, -0.0), vDirection=(0.19611613513818404, -0.9805806756909202, 0.0), width=178.88543819998318, height=236.52982045362964, p1=(178.88543819998318, 236.52982045362964, 0.0), p2=(29.417420270727604, 0.0, 0.0), p3=(178.88543819998318, 236.52982045362964, 0.0), p4=(29.417420270727604, 0.0, 0.0), p5=null, hoco=1.0, -0.0, 0.0, 10.0\n" +
                        "0.0, 1.0, 0.0, 20.0\n" +
                        "0.0, 0.0, -1.0, 30.0\n" +
                        "0.0, 0.0, 0.0, 1.0\n" +
                        "]"
                , bracketGeometry2D.toString());


    }


}