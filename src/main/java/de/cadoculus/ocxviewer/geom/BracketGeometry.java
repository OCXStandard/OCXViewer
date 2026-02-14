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


import de.cadoculus.ocxviewer.utils.UnitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.Bracket;
import org.ocx_schema.v310.Point3DT;
import org.ocx_schema.v310.Vector3DT;

import javax.vecmath.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static de.cadoculus.ocxviewer.geom.MainPlane.*;

/**
 * Class responsible for calculating geometric properties of a Bracket object from an OCX file.
 * This covers both 2D rendering on the canvas and the 3D rendering in the OpenGL view.
 * <pre>
 *   P_1 vv P_3<---------------------+ P5
 *   U      R
 *   U      R
 *   U      R
 *   U       R
 *   U        R                        P_0= origin
 *   U         R                       P_1= origin + uDirection * armLengthU
 *   U          RR                     P_2= origin + vDirection * armLengthV
 *   U            R                    P_3 = P1 + vNose
 *   U             RRR                 P_4 = P2 + uNose
 *   U                RRR              P_5 = center of radius. Is null if no freeEdgeRadius was given
 *   U                   RRRR
 *   U                       RRRR P_4
 *   U                            u
 *   U                            u
 *   P_0 VVVVVVVVVVVVVVVVVVVVVVVV P_2
 *
 * </pre>
 * @author Carsten Zerbst
 */
public class BracketGeometry {
    private static final Logger LOG = LogManager.getLogger(BracketGeometry.class);
    private final Bracket bracket;
    private BracketPoints3D bracketGeometry;
    private BracketPoints2D bracketGeometry2D;
    private final Set<String> issues = new HashSet<>();


    public BracketGeometry(Bracket bracket) {
        this.bracket = bracket;
        this.init();
    }

    /** Returns the calculated geometry of the bracket, or null if the geometry could not be calculated due to missing or invalid parameters. */
    public BracketPoints3D getBracketGeometry() {
        return bracketGeometry;
    }

    public BracketPoints2D getBracketGeometry2D() {

        return bracketGeometry2D;
    }

    /** Returns a set of issues that were encountered during the geometry calculation. If the set is empty, the geometry was calculated successfully. */
    public Set<String> getIssues() {
        return Collections.unmodifiableSet(issues);
    }

    /**
     * Initializes the geometry calculations for the bracket.
     *
     */
    private void init() {

        if (bracket.getBracketParameters() == null && bracket.getOuterContour() == null) {
            LOG.warn("Bracket {} ({})has no parameters and no outer contour, cannot calculate geometry.", bracket.getName(), bracket.getGUIDRef());
            issues.add("Both parameters and outer contour are missing.");
        }

        if (bracket.getBracketParameters() != null) {
            initBracketParameters();

        }

        if ( bracketGeometry != null) {
            initTwoDGeometry();
        }


    }

    private Matrix4d createL2G(boolean flip) {
        var mainPlane = GeomHelper.getMainPlane(bracketGeometry.wDirection);

        var viewDirection = new Vector3d(bracketGeometry.wDirection);

        var leftVector = new Vector3d(0,0,1);
        if ( XPLANE == mainPlane) {
            leftVector=new Vector3d(0,1,0);
        } else if ( YPLANE == mainPlane) {
            leftVector=new Vector3d(1,0,0);
        } else if ( ZPLANE == mainPlane) {
            leftVector = new Vector3d(1,0,0);
        }

        LOG.debug("mainPlane{}, view {}, left  {}", mainPlane, viewDirection, leftVector);

        var rawPlane3D = new PlaneGeometry("plane for bracket view "+bracket.getName(),
                bracketGeometry.origin, bracketGeometry.uDirection,bracketGeometry.vDirection, viewDirection);

        LOG.debug("raw plane  {}",  rawPlane3D);

        final Vector3d projectLeft = rawPlane3D.projectToPlane(leftVector);
        LOG.debug("projected left vector {}", projectLeft);

        final Vector3d normal = rawPlane3D.getNormal();
        LOG.debug("normal {}", normal);
        if ( flip) {
            normal.negate();
            LOG.debug("normal flipped {}", normal);
        }

        final Vector3d zVector = new Vector3d();
        zVector.cross( projectLeft, normal);
        LOG.debug("zVector {}", zVector);

        var rot = new Matrix3d();
        rot.setColumn(0, projectLeft);
        rot.setColumn(1, zVector);
        rot.setColumn(2, viewDirection);

        LOG.debug("rot {}", rot);

        var local2global = new Matrix4d();
        local2global.setIdentity();
        local2global.set(rot);
        local2global.m03 = bracketGeometry.origin.x;
        local2global.m13 = bracketGeometry.origin.y;
        local2global.m23 = bracketGeometry.origin.z;

        return local2global;
    }

    /**
     * Initializes the 2D geometry of the bracket based on the calculated 3D geometry.
     * The display plane for the 2D geometry is determined based on the W direction of the 3D geometry and an upvector.
     * The w direction is set according standard view directions, either from fore ( upvector 0,0,1), starboard (upvector 0,0,1) , or top view (upvector 0,1,0).*
     */
    private void initTwoDGeometry() {

        if (bracketGeometry == null) {
            LOG.warn("cannot initialize 2D geometry for bracket {} ({}) because 3D geometry is not available", bracket.getName(), bracket.getGUIDRef());
            return;
        }
        LOG.debug("initializing bracket 2D geometry for bracket {} ({}) based on parameters", bracket.getName(), bracket.getGUIDRef());



        var local2global = createL2G( false);//U, boolean flipV, bracketGeometry.origin, bracketGeometry.uDirection, bracketGeometry.vDirection);
        LOG.debug("local2global {}", local2global);
        var global2local = new Matrix4d(local2global);
        global2local.invert();
        LOG.debug("global2local I {}", global2local);


        // check if the up vector is in the right direction too
        var mainPlane = GeomHelper.getMainPlane(bracketGeometry.wDirection);
        var upVector = switch (mainPlane) {
           case MainPlane.XPLANE -> new Vector3d(0,0,-1);
            case MainPlane.YPLANE -> new Vector3d(0,0,-1);
            case MainPlane.ZPLANE -> new Vector3d(0,-1,0);
                default -> throw new IllegalStateException("unexpected main plane "+mainPlane);
        };

        var upVectorT = new Vector3d(upVector);
        global2local.transform(upVectorT);
        LOG.debug("upVectorT {}", upVectorT);
        if ( Math.toDegrees(upVectorT.angle(new Vector3d(0,1,0))) > 45) {
            LOG.debug("flipping view because up vector is not in the right direction");
            local2global = createL2G( true);
            global2local = new Matrix4d(local2global);
            global2local.invert();
            LOG.debug("global2local II {}", global2local);
        }


        var originP = new Point3d( bracketGeometry.origin );
        global2local.transform(originP);


        var p1P = new Point3d( bracketGeometry.p1 );
        global2local.transform(p1P);
        var p2P = new Point3d( bracketGeometry.p2 );
        global2local.transform(p2P);
        var p3P = new Point3d( bracketGeometry.p3 );
        global2local.transform(p3P);
        var p4P = new Point3d( bracketGeometry.p4 );
        global2local.transform(p4P);
        var p5P = p1P;
        if ( bracketGeometry.p5 != null) {
            p5P = new Point3d( bracketGeometry.p5 );
            global2local.transform(p5P);
        }
        LOG.debug("points {}/{}/{}/{}/{}/{}", bracketGeometry.origin, bracketGeometry.p1, bracketGeometry.p2, bracketGeometry.p3,bracketGeometry.p4, bracketGeometry.p5);
        LOG.debug("points' {}/{}/{}/{}/{}/{}", originP, p1P, p2P, p3P,p4P, p5P);

        var bboxL = new javax.media.j3d.BoundingBox(javax.media.j3d.BoundingBox.DEFAULT_EMPTY_BBOX);
        bboxL.combine(originP);
        bboxL.combine(p1P);
        bboxL.combine(p2P);
        bboxL.combine(p3P);
        bboxL.combine(p4P);
        bboxL.combine(p5P);

        LOG.debug("bboxL {}",bboxL);

        var offset = new Vector3d(bboxL.getLower());

        LOG.debug("offset t {}",offset);

        global2local.m03 -= offset.x;
        global2local.m13 -= offset.y;
        global2local.m23 -= offset.z;

        LOG.debug("global2local t {}",global2local);

        originP = new Point3d( bracketGeometry.origin );
        global2local.transform(originP);
        p1P = new Point3d( bracketGeometry.p1 );
        global2local.transform(p1P);
        p2P = new Point3d( bracketGeometry.p2 );
        global2local.transform(p2P);
         p3P = new Point3d( bracketGeometry.p3 );
        global2local.transform(p3P);
        p4P = new Point3d( bracketGeometry.p4 );
        global2local.transform(p4P);
         p5P = p1P;
        if ( bracketGeometry.p5 != null) {
            p5P = new Point3d( bracketGeometry.p5 );
            global2local.transform(p5P);
        }
        LOG.debug("points {}/{}/{}/{}/{}/{}", bracketGeometry.origin, bracketGeometry.p1, bracketGeometry.p2, bracketGeometry.p3,bracketGeometry.p4, bracketGeometry.p5);
        LOG.debug("points' {}/{}/{}/{}/{}/{}", originP, p1P, p2P, p3P,p4P, p5P);


        var origin2d = new Point3d(originP.x, originP.y,0);
        var p12d = new Point3d(p1P.x, p1P.y,0);
        var p22d = new Point3d(p2P.x, p2P.y,0);
        var p32d = new Point3d(p3P.x, p3P.y,0);
        var p42d = new Point3d(p4P.x, p4P.y,0);
        var p52d = bracketGeometry.p5 != null ? new Point3d(p5P.x, p5P.y, 0) : null;

        var u2d = new Vector3d( bracketGeometry.uDirection);
        global2local.transform(u2d);

        var v2d = new Vector3d( bracketGeometry.vDirection);
        global2local.transform(v2d);


        LOG.debug("u2d {}, v2d {}", u2d, v2d);
        bracketGeometry2D = new BracketPoints2D(
                 origin2d, u2d, v2d,
                 bboxL.getUpper().x-bboxL.getLower().x,
                bboxL.getUpper().y-bboxL.getLower().y,
                 p12d, p22d, p32d, p42d, p52d,global2local
         );


    }

    /**
     * Initializes the 3D geometry of the bracket based on its parameters.
     * This method calculates the positions of the key points of the bracket (p0 to p5) and the directions (u, v, w) based on the provided parameters.
     * If any required parameter is missing or invalid, it adds an issue to the issues set and does not calculate the geometry.
     * The W direction is calculated as the cross product of the U and V directions and should point in the material direction.
     */
    private  void initBracketParameters() {
        LOG.debug("initializing bracket geometry for bracket {} ({}) based on parameters", bracket.getName(), bracket.getGUIDRef());
        final var bracketIssues = new HashSet<String>();

        final Point3DT originDT = bracket.getBracketParameters().getOrigin();
        var p0 = new Point3d(Double.NaN, Double.NaN, Double.NaN);
        if (originDT == null) {
            bracketIssues.add("origin is missing.");
        } else {
            p0 = UnitHelper.toDefaultUnit(originDT);
        }

        final Vector3DT uDirectionDT = bracket.getBracketParameters().getUDirection();
        var uDirection = new Vector3d(Double.NaN, Double.NaN, Double.NaN);
        if (uDirectionDT == null) {
            bracketIssues.add("uDirection is missing.");
        } else {
            uDirection = GeomHelper.convert(uDirectionDT);
            if (uDirection.length() < 0.5) {
                bracketIssues.add("uDirection length is too small: %f< 0.5".formatted(uDirection.length()));
            }
            uDirection.normalize();
        }

        final Vector3DT vDirectionDT = bracket.getBracketParameters().getVDirection();
        var vDirection = new Vector3d(Double.NaN, Double.NaN, Double.NaN);
        if (vDirectionDT == null) {
            bracketIssues.add("vDirectionDT is missing.");
        } else {
            vDirection = GeomHelper.convert(vDirectionDT);
            if (vDirection.length() < 0.5) {
                bracketIssues.add("vDirection length is too small: %f< 0.5".formatted(uDirection.length()));
            }
            vDirection.normalize();
        }

        if ( uDirection.angle(vDirection) > Math.toRadians(160) || uDirection.angle(vDirection) < Math.toRadians(20)) {
            bracketIssues.add("the angle %f between uDirection and vDirection is outside [20°,160°] range".formatted(Math.toDegrees(uDirection.angle(vDirection))));
        }


        final double armLengthU = bracket.getBracketParameters().getArmLengthU() != null ? UnitHelper.toDefaultUnit(bracket.getBracketParameters().getArmLengthU()) : Double.NaN;
        if (Double.isNaN(armLengthU) || armLengthU < 10) {
            bracketIssues.add("armLengthU is missing or too small: %f< 10".formatted(armLengthU));
        }

        final double armLengthV = bracket.getBracketParameters().getArmLengthV() != null ? UnitHelper.toDefaultUnit(bracket.getBracketParameters().getArmLengthV()) : Double.NaN;
        if (Double.isNaN(armLengthV) || armLengthV < 10) {
            bracketIssues.add("armLengthV is missing or too small: %f< 10".formatted(armLengthV));
        }

        // these are optional
        final double uNose = bracket.getBracketParameters().getUnose() != null ? UnitHelper.toDefaultUnit(bracket.getBracketParameters().getUnose()) : 0;
        if (uNose < 0) {
            bracketIssues.add("uNose is negative: %f".formatted(uNose));
        }
        final double vNose = bracket.getBracketParameters().getVnose() != null ? UnitHelper.toDefaultUnit(bracket.getBracketParameters().getVnose()) : 0;
        if (vNose < 0) {
            bracketIssues.add("vNose is negative: %f".formatted(vNose));
        }
        final double freeEdgeRadius = bracket.getBracketParameters().getFreeEdgeRadius() != null ? UnitHelper.toDefaultUnit(bracket.getBracketParameters().getFreeEdgeRadius()) : 0;
        if (freeEdgeRadius < 0) {
            bracketIssues.add("freeEdgeRadius is negative: %f".formatted(vNose));
        }

        if (!bracketIssues.isEmpty()) {
            issues.addAll(bracketIssues);
            return;
        }

        // now calculate the remaining points of the bracket based on the parameters
        var wDirection = new Vector3d();
        wDirection.cross(uDirection, vDirection);
        wDirection.normalize();

        var p1 = new Point3d(p0);
        var tmp = new Vector3d(uDirection);
        tmp.scale(armLengthU);
        p1.add(tmp);


        var p2 = new Point3d(p0);
        tmp = new Vector3d(vDirection);
        tmp.scale(armLengthV);
        p2.add(tmp);


        // the nose is perpendicular on the arm, so we need to calculate the direction of the nose as the cross product of the arm direction and the wDirection
        var p3 = new Point3d(p1);
        if ( vNose > 0) {

            tmp = new Vector3d();
            tmp.cross(uDirection, wDirection);
            tmp.scale(vNose);
            // the nose must point inwards the bracket, so we may need to invert the direction
            if ( tmp.angle(vDirection) > Math.toRadians(90)) {
                p3.sub(tmp);
            } else {
                p3.add(tmp);
            }
        }

        var p4 = new Point3d(p2);
        if ( uNose > 0) {

            tmp = new Vector3d();
            tmp.cross(vDirection, wDirection);
            tmp.scale(uNose);

            // the nose must point inwards the bracket, so we may need to invert the direction
            if ( tmp.angle(uDirection) > Math.toRadians(90)) {
                p4.sub(tmp);
            } else {
                p4.add(tmp);
            }
        }

        Point3d p5 = null;
        if ( freeEdgeRadius > 0) {
            if ( freeEdgeRadius*1.42 < p3.distance(p4)) {
                bracketIssues.add("freeEdgeRadius is too small to fit between p3 and p4: %f < %f".formatted(freeEdgeRadius, p3.distance(p4)));
            } else {
                // https://math.stackexchange.com/questions/1594340/center-of-arc-with-two-points-radius-and-normal-in-3d

                var centerOfCord = new Point3d(p3);
                centerOfCord.add(p4);
                centerOfCord.scale(0.5);

                // the distance from the center of the cord to the center of the arc is sqrt(r^2 - (d/2)^2), where d is the distance between p3 and p4.
                var h = Math.sqrt(freeEdgeRadius * freeEdgeRadius - centerOfCord.distance(p3) * centerOfCord.distance(p3));

                // The direction from the center of the cord to the center of the arc is given by the cross product of the vector from p3 to p4 and the wDirection,
                var p3p4 = new Vector3d();
                p3p4.sub(p4,p3);

                var cOchord2Center = new Vector3d();
                cOchord2Center.cross(p3p4, wDirection);
                cOchord2Center.normalize();
                cOchord2Center.scale(h);

                p5 = new Point3d(centerOfCord);
                p5.add(cOchord2Center);
            }
        }
        LOG.debug("bracket geometry calculated successfully for bracket {} ({}), p0={}, p1={}, p2={}, p3={}, p4={}, p5={}", bracket.getName(), bracket.getGUIDRef(), p0, p1, p2, p3, p4, p5);

        bracketGeometry = new BracketPoints3D(p0, uDirection, vDirection, wDirection, armLengthU, armLengthV, uNose, vNose, freeEdgeRadius, p1, p2, p3, p4, p5);

    }

    public record BracketPoints2D(
            Point3d origin,
            Vector3d uDirection,
            Vector3d vDirection,
            double width,
            double height,
            Point3d p1,
            Point3d p2,
            Point3d p3,
            Point3d p4,
            Point3d p5,
            Matrix4d global2localT){}


    public record BracketPoints3D(
            Point3d origin,
            Vector3d uDirection,
            Vector3d vDirection,
            Vector3d wDirection,
            double armLengthU,
            double armLengthV,
            double uNose,
            double vNose,
            double freeEdgeRadius,
            Point3d p1,
            Point3d p2,
            Point3d p3,
            Point3d p4,
            Point3d p5
    ){}

}

