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
import jakarta.xml.bind.JAXBElement;
import net.jgeom.nurbs.BasicNurbsCurve;
import net.jgeom.nurbs.ControlPoint4f;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v3x.*;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

/**
 * This class renders curves into polygons of a given quality.
 * <p>
 * This setup is used, as it is (nearly) impossible to extend the Curve classes with additional methods due to the XSD definition
 * in OCX and JAXB. Feel free to show me better way .-(
 *
 *
 *
 *
 */
public class CurveGeometry {

    private static final Logger LOG = LogManager.getLogger(CurveGeometry.class);

    private final OcxXMLT ocx;
    private final GeometryQuality quality;
    private final boolean close;
    private final Curve3DT curve;

    private CurveGeometry(OcxXMLT ocx, Curve3DT curve, GeometryQuality quality, boolean close) {
        this.ocx = ocx;
        this.curve = curve;
        this.quality = quality;
        this.close = close;
    }

    /**
     * Renders a given curve into a polyline.
     *
     * @param ocx     the containing OCX. This is used to extract the unit and distancetolerance
     * @param curve   the Curve3DT to render
     * @param quality the desired quality
     * @param close   whether the curve should be closed. This throws an exception if the curves is NOT closed according to the numeric tolerance
     * @return a list of Point3ds
     */
    public static List<Point3d> toPoints(OcxXMLT ocx, Curve3DT curve, GeometryQuality quality, boolean close) {
        return new CurveGeometry(ocx, curve, quality, close).renderToPoints();
    }

    /**
     * Calculates the maximal angle between two points on a circle
     * such that the distance between the arc and the chord does not exceed the given tolerance.
     *
     * @param radius    the radius of the circle
     * @param tolerance the maximal allowed deviation between arc and chord
     * @return maximal angle in radians or Double.NaN, if the tolerance exceeds the radius
     */
    private static double calculateMaxAngle(double radius, double tolerance) {
        if (tolerance <= 0 || radius <= 0 ) {
            throw new IllegalArgumentException("Invalid radius or tolerance, expect positive values, got radius %f and tolerance %f".formatted(radius, tolerance));
        }
        if ( tolerance >= radius) {
            // if the tolerance is larger than the radius, we can use a full circle
            return Double.NaN;
        }
        double cosHalfAngle = 1 - (tolerance / radius);
        // Clamp value to valid range for acos due to floating point errors
        cosHalfAngle = Math.max(-1.0, Math.min(1.0, cosHalfAngle));
        return 2 * Math.acos(cosHalfAngle);
    }

    /**
     * Calculate the center point for a circle given by the start, end and middle points of the given curve.
     * See http://nickpisca.com/sherpa/?p=385.
     * If the provided points are collinear a null center will be returned.
     *
     * <param name="startPoint"> start point </param>
     * <param name="middlePoint"> middle point, a point on the arc </param>
     * <param name="endPoint"> end point </param>
     * <returns>null if the points of the segment are collinear</returns>
     *
     */
    private static Point3d CalculateCenter(Point3d startPoint, Point3d middlePoint,
                                           Point3d endPoint) {
        var r1 = startPoint.x - endPoint.x;
        var r2 = startPoint.y - endPoint.y;
        var r3 = startPoint.z - endPoint.z;
        var q1 = middlePoint.x - endPoint.x;
        var q2 = middlePoint.y - endPoint.y;
        var q3 = middlePoint.z - endPoint.z;
        var t1 = r2 * q1 * Math.pow(r3, 2.0) * q2; //NOTE:  the negative is NOT included
        var t2 = q1 * Math.pow(r3, 2.0) * Math.pow(q2, 2.0);
        var t3 = r3 * q3 * r1 * Math.pow(q2, 2.0);
        var t4 = r3 * q3 * r1 * Math.pow(q1, 2.0);
        var t5 = r3 * q3 * Math.pow(r1, 2.0) * q1;
        var t6 = r3 * Math.pow(r2, 2.0) * q3 * q1;
        var t7 = Math.pow(q3, 2.0) * r1 * Math.pow(r3, 2.0);
        var t8 = q1 * Math.pow(r2, 3.0) * q2;
        var t9 = q1 * Math.pow(r2, 2.0) * Math.pow(q2, 2.0);
        var t10 = q1 * Math.pow(r2, 2.0) * Math.pow(q3, 2.0);
        var t11 = r2 * Math.pow(q1, 2.0) * r1 * q2;
        var t12 = r2 * q1 * Math.pow(r1, 2.0) * q2;
        var t13 = q1 * Math.pow(r3, 2.0) * Math.pow(q3, 2.0);
        var t14 = Math.pow(r2, 2.0) * Math.pow(q1, 3.0);
        var t15 = Math.pow(q1, 3.0) * Math.pow(r3, 2.0);
        var t16 = r3 * Math.pow(q3, 3.0) * r1;
        var t17 = Math.pow(r1, 3.0) * Math.pow(q3, 2.0);
        var t18 = q3 * q1 * Math.pow(r3, 3.0);
        var t19 = Math.pow(q2, 3.0) * r1 * r2;
        var t20 = Math.pow(q3, 2.0) * r1 * r2 * q2;
        var t21 = r1 * Math.pow(r2, 2.0) * Math.pow(q3, 2.0);
        var t22 = Math.pow(r3, 2.0) * r1 * Math.pow(q2, 2.0);
        var t23 = Math.pow(q2, 2.0) * r1 * Math.pow(r2, 2.0);
        var t24 = Math.pow(r1, 3.0) * Math.pow(q2, 2.0);
        var numX = -1 * t1 + t2 - t3 - t4 - t5 - t6 + t7 - t8 + t9 + t10 - t11 - t12 + t13 + t14 + t15 - t16 +
                t17 - t18 - t19 - t20 + t21 + t22 + t23 + t24;
        var s1 = r2 * r1 * Math.pow(q1, 3.0);
        var s2 = Math.pow(q1, 2.0) * Math.pow(r2, 3.0);
        var s3 = Math.pow(q1, 2.0) * r2 * Math.pow(r1, 2.0);
        var s4 = Math.pow(q1, 2.0) * r2 * q3 * r3;
        var s5 = Math.pow(q1, 2.0) * r2 * Math.pow(r3, 2.0);
        var s6 = Math.pow(q1, 2.0) * Math.pow(r3, 2.0) * q2;
        var s7 = Math.pow(q1, 2.0) * Math.pow(r1, 2.0) * q2;
        var s8 = q1 * Math.pow(r2, 2.0) * q2 * r1;
        var s9 = q1 * r2 * Math.pow(q2, 2.0) * r1;
        var s10 = q1 * r2 * Math.pow(q3, 2.0) * r1;
        var s11 = q1 * Math.pow(r1, 3.0) * q2;
        var s12 = q1 * Math.pow(r3, 2.0) * r1 * q2;
        var s13 = Math.pow(q3, 2.0) * Math.pow(r2, 3.0);
        var s14 = r3 * q3 * q2 * Math.pow(r2, 2.0);
        var s15 = Math.pow(r3, 2.0) * r2 * Math.pow(q3, 2.0);
        var s16 = r2 * Math.pow(q3, 2.0) * Math.pow(r1, 2.0);
        var s17 = r2 * r3 * q3 * Math.pow(q2, 2.0);
        var s18 = r2 * r3 * Math.pow(q3, 3.0);
        var s19 = Math.pow(q2, 3.0) * Math.pow(r1, 2.0);
        var s20 = q3 * Math.pow(r3, 3.0) * q2;
        var s21 = r3 * q3 * Math.pow(r1, 2.0) * q2;
        var s22 = Math.pow(q3, 2.0) * Math.pow(r1, 2.0) * q2;
        var s23 = Math.pow(r3, 2.0) * Math.pow(q2, 3.0);
        var s24 = Math.pow(r3, 2.0) * q2 * Math.pow(q3, 2.0);
        var numY = s1 - s2 - s3 + s4 - s5 - s6 - s7 + s8 + s9 + s10 + s11 + s12 - s13 + s14 - s15 - s16 + s17 +
                s18 - s19 + s20 + s21 - s22 - s23 - s24;
        var v1 = q3 * Math.pow(r1, 2.0) * Math.pow(q2, 2.0); //negative not put on this variable
        var v2 = q3 * Math.pow(r1, 2.0) * Math.pow(q1, 2.0);
        var v3 = Math.pow(r3, 3.0) * Math.pow(q2, 2.0);
        var v4 = Math.pow(r2, 2.0) * Math.pow(q3, 3.0);
        var v5 = Math.pow(q1, 2.0) * Math.pow(r3, 3.0);
        var v6 = q3 * Math.pow(r1, 3.0) * q1;
        var v7 = Math.pow(q1, 2.0) * r3 * Math.pow(r1, 2.0);
        var v8 = r3 * Math.pow(q2, 2.0) * Math.pow(r1, 2.0);
        var v9 = Math.pow(q1, 3.0) * r3 * r1;
        var v10 = r3 * q2 * r2 * Math.pow(q3, 2.0);
        var v11 = r2 * q3 * Math.pow(r3, 2.0) * q2;
        var v12 = q1 * r3 * r1 * Math.pow(q3, 2.0);
        var v13 = q3 * r1 * q1 * Math.pow(r3, 2.0);
        var v14 = Math.pow(q3, 3.0) * Math.pow(r1, 2.0);
        var v15 = r3 * Math.pow(q2, 3.0) * r2;
        var v16 = Math.pow(r2, 2.0) * q3 * q1 * r1;
        var v17 = Math.pow(r2, 2.0) * q3 * Math.pow(q1, 2.0);
        var v18 = Math.pow(r2, 2.0) * q3 * Math.pow(q2, 2.0);
        var v19 = Math.pow(q1, 2.0) * r3 * Math.pow(r2, 2.0);
        var v20 = q1 * r3 * r1 * Math.pow(q2, 2.0);
        var v21 = r3 * Math.pow(q2, 2.0) * Math.pow(r2, 2.0);
        var v22 = r2 * q3 * Math.pow(r1, 2.0) * q2;
        var v23 = Math.pow(r2, 3.0) * q3 * q2;
        var v24 = r3 * q2 * r2 * Math.pow(q1, 2.0);
        var numZ = -1 * v1 - v2 - v3 - v4 - v5 + v6 - v7 - v8 + v9 + v10 + v11 + v12 + v13 - v14 + v15 + v16 -
                v17 - v18 - v19 + v20 - v21 + v22 + v23 + v24;
        var n1 = Math.pow(q2, 2.0) * Math.pow(r1, 2.0);
        var n2 = Math.pow(q3, 2.0) * Math.pow(r1, 2.0);
        var n3 = Math.pow(r2, 2.0) * Math.pow(q3, 2.0);
        var n4 = Math.pow(q1, 2.0) * Math.pow(r3, 2.0);
        var n5 = Math.pow(r3, 2.0) * Math.pow(q2, 2.0);
        var n6 = Math.pow(q1, 2.0) * Math.pow(r2, 2.0);
        var n7 = 2 * r3 * q2 * r2 * q3;
        var n8 = 2 * q3 * r1 * q1 * r3;
        var n9 = 2 * q1 * r2 * r1 * q2;
        var den = n1 + n2 + n3 + n4 + n5 + n6 - n7 - n8 - n9;
        if (Math.abs(den) < 0.00005) {
            LOG.error("failed to calculate center");
            LOG.error("    startPoint {}", startPoint);
            LOG.error("    pointOnArc {}", middlePoint);
            LOG.error("    endPoint {}", endPoint);
            return null;
        }

        var x = 0.5 * (numX / den) + endPoint.x;
        var y = -0.5 * (numY / den) + endPoint.y;
        var z = -0.5 * (numZ / den) + endPoint.z;

        return new Point3d(x, y, z);

    }

    private List<Point3d> renderToPoints() {
        var points = renderToPoints(curve);
        if (close) {
            double distanceTolerance = 1.0;
            final JAXBElement<? extends FormT> form = ocx.getForm();
            if (form != null && form.getValue() != null && form.getValue() instanceof Vessel vessel) {
                distanceTolerance = UnitHelper.toDefaultUnit(vessel.getDistanceTolerance());
            }
            if (points.getFirst().distance(points.getLast()) >= distanceTolerance) {
                throw new IllegalStateException("curve is not closed. Distance of start and end point exceeds tolerance %.1f given in the OCX".formatted(distanceTolerance));
            }
            points.remove(points.getLast());
            points.add(points.getFirst());
        }
        return points;
    }

    private List<Point3d> renderToPoints(Curve3DT ic) {
        return switch (ic) {
            case Circle3DT c -> renderToPoints(c);
            case Ellipse3DT e -> renderToPoints(e);
            case CircumCircle3DT c -> renderToPoints(c);
            case PolyLine3DT p -> renderToPoints(p);
            case Line3DT l -> renderToPoints(l);
            case CompositeCurve3DT p -> renderToPoints(p);
            case NURBS3DT n -> renderToPoints(n);
            case CircumArc3DT c -> renderToPoints(c);
            default -> throw new IllegalArgumentException("got unsupported curve " + curve);
        };
    }

    private List<Point3d> renderToPoints(NURBS3DT nurbsDT) {

        final int degree = nurbsDT.getNURBSproperties().getDegree();
        final int numControlPoints = (int)nurbsDT.getNURBSproperties().getNumCtrlPts();
        final List<ControlPoint> controlPointsOCX = nurbsDT.getControlPtList().getControlPoints();
        if ( controlPointsOCX.size() != numControlPoints) {
            throw new IllegalStateException("number of control points does not match the number specified in the NURBS properties, expected %d but got %d".formatted(numControlPoints, controlPointsOCX.size()));
        }

        ControlPoint4f[] controlPoints = new ControlPoint4f[numControlPoints];
        int index = 0;
        for( ControlPointT ctrlPtT : controlPointsOCX ) {

            var point = UnitHelper.toDefaultUnit(ctrlPtT);
            controlPoints[index] = new ControlPoint4f((float)point.x, (float)point.y, (float)point.z, (float)ctrlPtT.getWeight());
            index++;
        }

        // the knotvector
        final List<Double> knots = nurbsDT.getKnotVector().getValues();
        if ( knots.size() != nurbsDT.getNURBSproperties().getNumKnots()) {
            throw new IllegalStateException("number of knots does not match the number specified in the NURBS properties, expected %d but got %d".formatted(nurbsDT.getNURBSproperties().getNumKnots(), knots.size()));
        }
        float[] knotVector = new float[ (int)nurbsDT.getNURBSproperties().getNumKnots()];
        for (int i = 0; i < knotVector.length; i++) {
            knotVector[i] = knots.get(i).floatValue();
        }

        var basicNurbs = new BasicNurbsCurve(controlPoints, knotVector, degree);
        var startU =knotVector[0];
        var endU = knotVector[knotVector.length-1];
        // use 4 times the number of knots as segments, this is a heuristic to get a good quality for most curves, but it can be improved by using the curvature of the curve
        // net.jgeom does not contain such a method, but it is found in the C# GShark Library
        var deltaU = (endU-startU)/knotVector.length/4.0;


        var points = new ArrayList<Point3d>();
        var u = startU;

        while( u <= endU) {
            var point = basicNurbs.pointOnCurve(u);
            points.add(new Point3d(point.x, point.y, point.z));
            u+=deltaU;
        }
        var lastPoint = basicNurbs.pointOnCurve(endU);
        points.add(new Point3d(lastPoint.x, lastPoint.y, lastPoint.z));

        if ( close) {
            if ( points.getFirst().distance(points.getLast()) > quality.getMaxDistance()) {
                throw new IllegalArgumentException("the given NURBS is not closed");
            }
            points.remove(points.getLast());
            points.add(points.getFirst());
        }

        return filterQuality(points);

    }

    private List<Point3d> renderToPoints(CompositeCurve3DT p) {
        var points = new java.util.ArrayList<Point3d>();
        for (var c : p.getPolyLine3DsAndLine3DsAndNURBS3DS()) {
            points.addAll(renderToPoints(c));
        }
        return filterQuality(points);
    }

    private List<Point3d> renderToPoints(Line3DT l) {

        var points = new java.util.ArrayList<Point3d>();
        points.add(UnitHelper.toDefaultUnit(l.getStartPoint()));
        points.add(UnitHelper.toDefaultUnit(l.getEndPoint()));
        return points;
    }

    private List<Point3d> renderToPoints(PolyLine3DT p) {
        var points = new java.util.ArrayList<Point3d>();
        for (Point3DT point3D : p.getPoint3Ds()) {
            points.add(UnitHelper.toDefaultUnit(point3D));
        }

        return filterQuality(points);
    }

    private List<Point3d> renderToPoints(CircumCircle3DT circumCircle3DT) {

        if ( circumCircle3DT.getPositions()== null || circumCircle3DT.getPositions().getPoint3Ds() == null || circumCircle3DT.getPositions().getPoint3Ds().size() != 3) {
            throw new IllegalArgumentException("CircumCircle3DT must have exactly 3 points");
        }

        var p0 = UnitHelper.toDefaultUnit(circumCircle3DT.getPositions().getPoint3Ds().getFirst());
        var p1 = UnitHelper.toDefaultUnit(circumCircle3DT.getPositions().getPoint3Ds().get(1));
        var p2 = UnitHelper.toDefaultUnit(circumCircle3DT.getPositions().getPoint3Ds().getLast());

        var center = CalculateCenter(p0, p1, p2);

        if (center == null) {
            throw new IllegalArgumentException("Arc points are collinear");
        }
        double radius = center.distance(p0);

        // calculate the plane normal
        Vector3d v0 = new Vector3d();
        v0.sub(p0, center);
        Vector3d v1 = new Vector3d();
        v1.sub(p1, center);
        Vector3d v2 = new Vector3d();
        v2.sub(p2, center);

        Vector3d normal = new Vector3d();
        if ( normal.length() < 0.00001) {
            normal.cross(v0, v1);
        }
        if ( normal.length() < 0.00001) {
            throw new IllegalArgumentException("Arc points are collinear");
        }
        normal.normalize();

        Vector3d u = new Vector3d(v0);
        u.normalize();
        Vector3d v = new Vector3d();
        v.cross(normal, u);

        double deltaTheta = calculateMaxAngle(radius, quality.getMaxDistance());

        if ( Double.isNaN(deltaTheta) ) {
            // use 3 points on the circle
            deltaTheta = Math.PI*3.0/4.0;
        }


        List<Point3d> points = new ArrayList<>();

        double theta = 0;
        while (theta < 2*Math.PI) {
            Vector3d pos = new Vector3d(u);
            pos.scale(Math.cos(theta));
            Vector3d tmp = new Vector3d(v);
            tmp.scale(Math.sin(theta));
            pos.add(tmp);
            pos.scale(radius);
            Point3d pt = new Point3d(center);
            pt.add(pos);
            points.add(pt);

            theta+=deltaTheta;
        }
        // and add the end point
        points.add(points.getFirst());

        return points;
    }

    private List<Point3d> renderToPoints(CircumArc3DT carc3Dt) {
        var p0 = UnitHelper.toDefaultUnit(carc3Dt.getStartPoint());
        var p1 = UnitHelper.toDefaultUnit(carc3Dt.getIntermediatePoint());
        var p2 = UnitHelper.toDefaultUnit(carc3Dt.getEndPoint());

        var center = CalculateCenter(p0, p1, p2);

        if (center == null) {
            throw new IllegalArgumentException("Arc points are collinear");
        }
        double radius = center.distance(p0);

        // calculate the plane normal
        Vector3d v0 = new Vector3d();
        v0.sub(p0, center);
        Vector3d v1 = new Vector3d();
        v1.sub(p1, center);
        Vector3d v2 = new Vector3d();
        v2.sub(p2, center);

        Vector3d normal = new Vector3d();
        normal.cross(v0, v2);
        if ( normal.length() < 0.00001) {
                normal.cross(v0, v1);
        }
        if ( normal.length() < 0.00001) {
            throw new IllegalArgumentException("Arc points are collinear");
        }
        normal.normalize();

        Vector3d u = new Vector3d(v0);
        u.normalize();
        Vector3d v = new Vector3d();
        v.cross(normal, u);


        // ... the start and stop theta
        double angle0 = 0.0;
        double angle1 = Math.atan2(v1.dot(v), v1.dot(u));
        double angle2 = Math.atan2(v2.dot(v), v2.dot(u));

        double angleStart = angle0;
        double angleEnd = angle2;
        if (angleEnd < angleStart) angleEnd += 2 * Math.PI;
        if (angle1 < angleStart) angle1 += 2 * Math.PI;
        if (!(angleStart < angle1 && angle1 < angleEnd)) {
            // invert direction
            double tmp = angleStart;
            angleStart = angleEnd;
            angleEnd = tmp;
        }

        List<Point3d> points = new ArrayList<>();
        // add the start point
        points.add(p0);

        double deltaTheta = calculateMaxAngle(radius, quality.getMaxDistance());

        if ( Double.isNaN(deltaTheta)) {
            // if the tolerance is larger than the radius, simply keep the start and end points
        } else {


            double theta = angleStart + deltaTheta;
            while (theta < angleEnd) {
                Vector3d pos = new Vector3d(u);
                pos.scale(Math.cos(theta));
                Vector3d tmp = new Vector3d(v);
                tmp.scale(Math.sin(theta));
                pos.add(tmp);
                pos.scale(radius);
                Point3d pt = new Point3d(center);
                pt.add(pos);
                points.add(pt);

                theta += deltaTheta;
            }
        }
        // and add the end point
        points.add(p2);

        return points;

    }

    private List<Point3d> renderToPoints(Ellipse3DT ellipse) {

        var centerDT = ellipse.getCenter();
        if (centerDT == null) {
            throw new IllegalArgumentException("centerDT is null");
        }
        Point3d center = UnitHelper.toDefaultUnit(centerDT);

        var majorAxisDT = ellipse.getMajorAxis();
        if (majorAxisDT == null) {
            throw new IllegalArgumentException("majorAxisDT is null");
        }
        var majorAxis = GeomHelper.convert(majorAxisDT);

        var minorAxisDT = ellipse.getMinorAxis();
        if (minorAxisDT == null) {
            throw new IllegalArgumentException("minorAxisDT is null");
        }
        var minorAxis = GeomHelper.convert(minorAxisDT);
        double majorDiameter = UnitHelper.toDefaultUnit(ellipse.getMajorDiameter());
        double minorDiameter = UnitHelper.toDefaultUnit(ellipse.getMinorDiameter());

        double deltaTheta = calculateMaxAngle(minorDiameter / 2.0, quality.getMaxDistance());
        if ( Double.isNaN(deltaTheta)) {
            // we need at least 4 points to render an ellipse
            deltaTheta = Math.PI/2.0;
        }

        double a = majorDiameter / 2.0;
        double b = minorDiameter / 2.0;

        List<Point3d> points = new ArrayList<>();

        double theta = 0.0;
        while ( theta < Math.PI*2) {
            double cosT = Math.cos(theta);
            double sinT = Math.sin(theta);

            Vector3d majorComponent = new Vector3d(majorAxis);
            majorComponent.scale(a * cosT);

            Vector3d minorComponent = new Vector3d(minorAxis);
            minorComponent.scale(b * sinT);

            Point3d p = new Point3d(center);
            p.add(majorComponent);
            p.add(minorComponent);

            points.add(p);
            theta+=deltaTheta;
        }
        points.add( points.getFirst());
        return points;

    }

    private List<Point3d> renderToPoints(Circle3DT circle) {
        var centerDT = circle.getCenter();
        if (centerDT == null) {
            throw new IllegalArgumentException("centerDT is null");
        }
        Point3d center = UnitHelper.toDefaultUnit(centerDT);

        var normalDT = circle.getNormal();
        if (normalDT == null) {
            throw new IllegalArgumentException("normalDT is null");
        }
        var normal = GeomHelper.convert(normalDT);


        double diameter = UnitHelper.toDefaultUnit(circle.getDiameter());
        double radius = diameter / 2.0;

        double deltaTheta = calculateMaxAngle(radius, quality.getMaxDistance());


        // Calculate orthogonal axes in the plane of the circle
        Vector3d ref = Math.abs(normal.x) < 0.9 ? new Vector3d(1, 0, 0) : new Vector3d(0, 1, 0);
        Vector3d majorAxis = new Vector3d();
        majorAxis.cross(normal, ref);
        majorAxis.normalize();

        Vector3d minorAxis = new Vector3d();
        minorAxis.cross(normal, majorAxis);
        minorAxis.normalize();

        List<Point3d> points = new ArrayList<>();

        double theta = 0.0;
        while (theta < Math.PI * 2) {
            double cosT = Math.cos(theta);
            double sinT = Math.sin(theta);

            Vector3d majorComponent = new Vector3d(majorAxis);
            majorComponent.scale(radius * cosT);

            Vector3d minorComponent = new Vector3d(minorAxis);
            minorComponent.scale(radius * sinT);

            Point3d p = new Point3d(center);
            p.add(majorComponent);
            p.add(minorComponent);

            points.add(p);
            theta += deltaTheta;
        }
        // Close the circle
        points.add(points.getFirst());
        return points;
    }

    /**
     * Calculates a new list of points based on the given quality.
     *
     * @param points the points to filter.
     * @return a new list of points with potentially less points
     */
    private List<Point3d> filterQuality(List<Point3d> points) {

        return new PolygonSimplifier(quality).simplify(points);
    }
}