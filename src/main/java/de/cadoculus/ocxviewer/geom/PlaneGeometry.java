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


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix4d;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.Optional;

/**
 * Represents a coordinate system / plane with a start point, normal and ref direction
 *
 * @author cz
 */
public class PlaneGeometry {

    private static final Logger LOG = LogManager.getLogger(PlaneGeometry.class);
    private final String name;
    private final MainPlane locationType;
    private final Vector3d normal;
    private final Point3d refPoint;
    private final Vector3d refDir1;
    private final Vector3d refDir2;
    private Point3d[] threePoints;


    public static final Vector3d NORMAL_X = new Vector3d(1, 0, 0);
    public static final Vector3d NORMAL_Y = new Vector3d(0, 1, 0);
    public static final Vector3d NORMAL_Z = new Vector3d(0, 0, 1);
    public static final Vector3d NORMAL_INV_X = new Vector3d(-1, 0, 0);
    public static final Vector3d NORMAL_INV_Y = new Vector3d(0, -1, 0);
    public static final Vector3d NORMAL_INV_Z = new Vector3d(0, 0, -1);
    public static final double ANGLE_45_DEG = Math.PI / 180.0 * 45;
    public static final double ANGLE_90_DEG = Math.PI / 180.0 * 90;

    public static final PlaneGeometry REFERENCE = new PlaneGeometry("REFERENCE", new Point3d(0, 0, 0), NORMAL_X, NORMAL_Y, NORMAL_Z);


    /**
     * A copy constructor
     *
     * @param src the source plane
     */
    public PlaneGeometry(PlaneGeometry src) {
        if ( src ==null) {
            throw new IllegalArgumentException("source plane must not be null");
        }
        this.name = src.getName();
        this.refPoint = new Point3d(src.refPoint);
        this.refDir1 = new Vector3d(src.refDir1);
        refDir1.normalize();
        this.refDir2 = new Vector3d(src.refDir2);
        refDir2.normalize();
        this.normal = new Vector3d(src.normal);
        this.normal.normalize();
        this.locationType = GeomHelper.getMainPlane(normal);
        if ( src.getThreePoints() != null && src.getThreePoints().length == 3) {
            this.threePoints = new Point3d[]{new Point3d(src.threePoints[0]), new Point3d(src.threePoints[1]), new Point3d(src.threePoints[2])};
        } else {
            Point3d r1 = new Point3d(refPoint);
            Vector3d v1 = new Vector3d(refDir1);
            v1.scale(100);
            r1.add( v1);

            Point3d r2 = new Point3d(refPoint);
            Vector3d v2 = new Vector3d(refDir2);
            v2.scale(100);
            r2.add( v2);

            this.threePoints = new Point3d[]{refPoint, r1, r2};
        }
    }

    /**
     * Constructor based on a point and two reference directions in the global coordinate system
     *
     * @param name    the name of the plane
     * @param p       a point on the plane, already with offset if needed
     * @param refDir1 the first reference direction in the plane
     * @param refDir2 the second reference direction
     * @param normal  the normal of the plane
     */
    public PlaneGeometry(String name, Point3d p, Vector3d refDir1, Vector3d refDir2, Vector3d normal) {
        this.name = name;
        this.refPoint = p;

        if (Math.abs(1 - refDir1.lengthSquared()) > 1e-3) {
            throw new IllegalArgumentException("expect valid xaxis, got " + refDir1);
        }
        this.refDir1 = refDir1;
        if (Math.abs(1 - refDir2.lengthSquared()) > 1e-3) {
            throw new IllegalArgumentException("expect valid yaxis, got " + refDir2);
        }
        this.refDir2 = refDir2;
        if (Math.abs(1 - normal.lengthSquared()) > 1e-3) {
            throw new IllegalArgumentException("expect valid zaxis, got " + normal);
        }
        this.normal = normal;
        this.locationType = GeomHelper.getMainPlane(normal);
    }

    /**
     * Constructor based on three points
     */
    public PlaneGeometry(String name, Point3d p1, Point3d p2, Point3d p3) {
        this.name = name;
        this.refPoint = p1;
        this.refDir1 = new Vector3d();
        refDir1.sub(p2, p1);
        refDir1.normalize();

        this.refDir2 = new Vector3d();
        refDir2.sub(p3, p1);
        refDir2.normalize();
        this.normal = new Vector3d();
        normal.cross(refDir2, refDir1);
        normal.normalize();

        threePoints = new Point3d[3];
        threePoints[0] = p1;
        threePoints[1] = p2;
        threePoints[2] = p3;

        this.locationType = GeomHelper.getMainPlane(normal);

    }

    /**
     * Create a new PlaneGeometry based on a HOCO matrix.
     * The first three columns of the matrix are expected to be the refDir1, refDir2 and normal, the fourth column is expected to be the refPoint.
     *
     * @param name the name
     * @param hoco the hoco
     */
    public PlaneGeometry(String name, Matrix4d hoco) {
        this.name = name;
        Vector3d trans = new Vector3d();
        hoco.get(trans);
        this.refPoint = new Point3d(trans);

        Matrix3d rot = new Matrix3d();
        hoco.get(rot);
        this.refDir1 = new Vector3d();
        this.refDir2 = new Vector3d();
        this.normal = new Vector3d();

        rot.getColumn(0, refDir1);
        rot.getColumn(1, refDir2);
        rot.getColumn(2, normal);

        this.locationType = GeomHelper.getMainPlane(normal);
    }


    /**
     * Get the MainPlane of the plane
     *
     * @return one of X, Y, Z or TP
     */
    public MainPlane getLocationType() {
        return locationType;
    }

    /**
     * Get three points on the plane
     *
     * @return an array with three points on the plane
     */
    public Point3d[] getThreePoints() {

        if (threePoints == null) {
            threePoints = new Point3d[3];
            threePoints[0] = refPoint;

            Point3d point2 = new Point3d(refPoint);

            point2.add(refDir1);
            threePoints[1] = point2;

            Point3d point3 = new Point3d(refPoint);

            point3.add(refDir2);
            threePoints[2] = point3;

        }
        return threePoints;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Plane ");
        sb.append(name).append(", p ").append(refPoint).append(",u ").append(refDir1).append(",v ").append(refDir2).append(",w ").append(normal);
        return sb.toString();

    }

    /**
     * Check if given point is on the plane
     *
     * @param p the point to check
     * @return true if the given point is on the same plane with the default tolerance
     */
    public boolean isOnSamePlane(Point3d p) {
        return onSamePlane(getThreePoints(), p);
    }

    /**
     * Calculated the unsigned distance of a point to the plane. See
     * <a href="https://graphics.stanford.edu/~mdfisher/Code/Engine/Plane.cpp.html">...</a>
     *
     * @param p the point to check
     * @return the unsigned distance
     */
    public double distance(Point3d p) {
        return Math.abs(unsignedDistance(p));
    }

    /**
     * Calculated the unsigned distance of a point to the plane. See
     * <a href="https://graphics.stanford.edu/~mdfisher/Code/Engine/Plane.cpp.html">...</a>
     *
     * @param p the point to check
     * @return the unsigned distance
     */
    public double unsignedDistance(Point3d p) {

        double d = -normal.dot(new Vector3d(refPoint));

        return (normal.x * p.x + normal.y * p.y + normal.z * p.z + d);

    }

    /**
     * Calculate the signed distance of a point to the plane. See
     * https://graphics.stanford.edu/~mdfisher/Code/Engine/Plane.cpp.html
     */
    public double signedDistance(Point3d p) {
        double d = -normal.dot(new Vector3d(refPoint));
        return (normal.x * p.x + normal.y * p.y + normal.z * p.z + d);
    }

    /**
     * Calculate the closes point on the plane to another point. See
     * https://graphics.stanford.edu/~mdfisher/Code/Engine/Plane.cpp.html
     */
    public Point3d closestPoint(Point3d p) {

        double dist = signedDistance(p);
        Point3d retval = new Point3d(p);

        Vector3d normalScaled = new Vector3d(normal);
        normalScaled.scale(dist);
        retval.sub(normalScaled);
        return retval;
    }

    /**
     * Project a vector onto the plane, meaning the resulting vector is in the plane
     *
     * @param vector the vector to project
     * @return the projected vector
     */
    public Vector3d projectToPlane(Vector3d vector) {

        var retval = new Vector3d(vector);
        var point4vector = new Point3d(refPoint);
        point4vector.add(vector);
        var distanceToPoint = signedDistance(point4vector);

        var substract = new Vector3d(normal);
        substract.scale(distanceToPoint);
        point4vector.sub(substract);
        point4vector.sub(refPoint);

        return new Vector3d(point4vector);

    }

    /**
     * Check if a given point is on the same plane as those given by three
     * points. Uses a tolerance of 1 if not given
     *
     * @param tps       three points defining a plane
     * @param p         the fourth point to check
     * @param tolerance an (one !) optional double used as tolerance. If not given uses 0.01
     * @return true if distance from planet to point is less than 0.01 or given tolerance
     */
    public static boolean onSamePlane(Point3d[] tps, Point3d p, double... tolerance) {
        Matrix4d mat = new Matrix4d();
        mat.m00 = tps[0].x;
        mat.m10 = tps[0].y;
        mat.m20 = tps[0].z;
        mat.m30 = 1;
        mat.m01 = tps[1].x;
        mat.m11 = tps[1].y;
        mat.m21 = tps[1].z;
        mat.m31 = 1;
        mat.m02 = tps[2].x;
        mat.m12 = tps[2].y;
        mat.m22 = tps[2].z;
        mat.m32 = 1;
        mat.m03 = p.x;
        mat.m13 = p.y;
        mat.m23 = p.z;
        mat.m33 = 1;
        double det = mat.determinant();

        double tol = 1;
        if (tolerance != null && tolerance.length > 0) {
            tol = tolerance[0];
        }

        return Math.abs(det) < Math.abs(tol);
    }


    /**
     * Calculate the intersection point of a line with the plane.
     *
     * @param startPoint the start point of the line
     * @param endPoint   the end point of the line
     * @return an Optional containing the intersection point if it exists, or an empty Optional if there is no intersection (e.g., line is parallel to the plane)
     */
    public Optional<Point3d> intersection(Point3d startPoint, Point3d endPoint) {
        Vector3d lineDirection = new Vector3d();
        lineDirection.sub(endPoint, startPoint);
        lineDirection.normalize();

        if (Math.abs(normal.dot(lineDirection)) < 1e-3) {
            return Optional.empty();
        }
        Vector3d lineStart = new Vector3d(startPoint);
        Vector3d planeStart = new Vector3d(this.refPoint);

        double t = (normal.dot(planeStart) - normal.dot(lineStart)) / normal.dot(lineDirection);
        lineDirection.scale(t);

        Point3d intersectionPoint = new Point3d(lineStart);
        intersectionPoint.add(lineDirection);
        return Optional.of(intersectionPoint);
    }

    /**
     * Check if this plane is similar to another plane, meaning they are parallel and the distance between them is less than 1.0
     *
     * @param other the other plane to compare with
     * @return true if the planes are similar, false otherwise
     */
    public boolean similar(PlaneGeometry other) {

        LOG.debug("similar {} vs. {}", name, other.name);

        LOG.debug("compare {}/{} vs. {}/{}", normal, refPoint, other.normal, other.refPoint);

        if ( Math.toDegrees(normal.angle( other.normal)) <2.0 ||
                Math.toDegrees(normal.angle( other.normal)) >178.0 ) {
        } else {
            LOG.debug("different direction {} vs. {}", name, other.name);
            LOG.debug("    {} != {}, angle {}°", normal, other.normal,
                    Math.toDegrees(normal.angle(other.normal) / Math.PI * 180.0));
            return false;
        }

        if (distance(other.refPoint) > 1.0) {
            LOG.debug("calculated distance to {} exceeds tolerance by {}", other.refPoint, distance(other.refPoint));
            return false;
        }
        return true;

    }

    /**
     * Calculate the HOCO matrix for this plane, which represents the transformation from the global coordinate system to the local coordinate system defined by this plane.
     * @return
     */
    public Matrix4d getHOCO() {

        Matrix4d retval = new Matrix4d();
        retval.setIdentity();
        retval.m00 = refDir1.x;
        retval.m10 = refDir1.y;
        retval.m20 = refDir1.z;

        retval.m01 = refDir2.x;
        retval.m11 = refDir2.y;
        retval.m21 = refDir2.z;

        retval.m02 = normal.x;
        retval.m12 = normal.y;
        retval.m22 = normal.z;

        retval.m03 = refPoint.x;
        retval.m13 = refPoint.y;
        retval.m23 = refPoint.z;

        return retval;

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the normal
     */
    public Vector3d getNormal() {
        return normal;
    }

    /**
     * @return the refPoint
     */
    public Point3d getRefPoint() {
        return new Point3d(refPoint);
    }

    /**
     * @return the refDir1
     */
    public Vector3d getRefDir1() {
        return refDir1;
    }

    /**
     * @return the refDir2
     */
    public Vector3d getRefDir2() {
        return refDir2;
    }


    /**
     * Creates a new PlaneG with an offset in Z direction
     *
     * @param offset the offset to apply
     * @return a new PlaneG
     */
    public PlaneGeometry offset(double offset) {

        Point3d offsetPoint = new Point3d(refPoint);
        Vector3d translation = new Vector3d(this.normal);
        translation.normalize();
        translation.scale(offset);

        offsetPoint.add(translation);

        return new PlaneGeometry(this.name + " + offset " + offset,
                offsetPoint, this.refDir1, this.refDir2, this.normal);

    }




}
