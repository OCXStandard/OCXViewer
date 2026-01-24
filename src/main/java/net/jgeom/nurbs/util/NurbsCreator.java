/*
 * jgeom: Geometry Library for Java
 * 
 * Copyright (C) 2005  Samuel Gerber
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package net.jgeom.nurbs.util;

import net.jgeom.nurbs.*;
import net.jgeom.util.Axis3D;
import net.jgeom.util.Origin3D;

import javax.vecmath.*;


/**
 * This class offers some static methods to create NurbsSurfaces and NurbsCurves
 * from diffrent inputs.
 * 
 * @author sg
 * @version 1.0
 */
public final 
class NurbsCreator {

    private NurbsCreator() {
    }

    /**
     * A NurbsCurve controlpolygon for a full-circle which has 9 ControlPoints
     * and the shape of quadrat.
     */
    public static final int FC_QUAD9 = 0;
    /**
     * A NurbsCurve controlpolygon for a full-circle which has 7 ControlPoints
     * and the shape of quadrat.
     */
    public static final int FC_QUAD7 = 1;
    /**
     * A NurbsCurve controlpolygon for a full-circle which has 7 ControlPoints
     * and the shape of triangle.
     */
    public static final int FC_TRI7 = 2;

    /**
     * Create a revolved NurbsSurface from the given NurbsCurve around the given
     * axis whith the angle theta. [TODO:call createRevolvedSurface(Axis3D a,
     * NurbsCurve curve, double thetaStart, double thetaEnd) as as it is tested]
     * 
     * @param a
     *            Axis to revolve around.
     * @param curve
     *            NurbsCurve to revolve
     * @param theta
     *            Angle to revolve
     * @return The revolved NurbsSurface
     */
    public static NurbsSurface createRevolvedSurface(Axis3D a, NurbsCurve curve, double theta) {
        int narcs = 4;
        if (theta <= Math.PI / 2) {
            narcs = 1;
        } else if (theta <= Math.PI) {
            narcs = 2;
        } else if (theta <= Math.PI + Math.PI / 2) {
            narcs = 3;
        }

        double dtheta = theta / narcs;
        int j = 3 + 2 * (narcs - 1);
        float uKnot[] = new float[j + 3];
        for (int i = 0; i < 3; i++) {
            uKnot[i] = 0;
            uKnot[j + i] = 1;
        }
        switch (narcs) {
        case 2:
            uKnot[3] = 0.5f;
            uKnot[4] = 0.5f;
            break;
        case 3:
            uKnot[3] = 1 / 3.0f;
            uKnot[4] = 1 / 3.0f;
            uKnot[5] = 2 / 3.0f;
            uKnot[6] = 2 / 3.0f;
            break;
        case 4:
            uKnot[3] = 0.25f;
            uKnot[4] = 0.25f;
            uKnot[5] = 0.5f;
            uKnot[6] = 0.5f;
            uKnot[7] = 0.75f;
            uKnot[8] = 0.75f;
            break;
        }

        double angle = 0;
        double cos[] = new double[narcs + 1];
        double sin[] = new double[narcs + 1];
        for (int i = 0; i <= narcs; i++) {
            cos[i] = Math.cos(angle);
            sin[i] = Math.sin(angle);
            angle += dtheta;
        }

        ControlPoint4f pj[] = curve.getControlPoints();
        double wm = Math.cos(dtheta / 2);
        Point3d O = new Point3d();
        Point3d P2 = new Point3d();
        Vector3d T2 = new Vector3d();
        Point3d P0 = new Point3d();
        Vector3d T0 = new Vector3d();
        Point3d tmp = new Point3d();
        Vector3d X = new Vector3d();
        Vector3d Y = new Vector3d();
        ControlPoint4f pij[][] = new ControlPoint4f[2 * narcs + 1][pj.length]; // TODO
                                                                                // narcs+3??
        for (j = 0; j < pj.length; j++) {
            pointToLine3D(a.origin, a.dir, new Point3d(pj[j].getPoint3f()), O);
            X.set(pj[j].getPoint3f());
            X.sub(O);
            double r = X.length();
            if (r == 0) {
                X.set(O);
            }
            X.normalize();
            Y.cross(a.dir, X);
            pij[0][j] = new ControlPoint4f(pj[j]);
            P0 = new Point3d(pj[j].getPoint3f());
            T0.set(Y);
            int index = 0;
            for (int i = 1; i <= narcs; i++) {
                P2.set(O);
                tmp.set(X);
                tmp.scale(r * cos[i]);
                P2.add(tmp);
                tmp.set(Y);
                tmp.scale(r * sin[i]);
                P2.add(tmp);

                pij[index + 2][j] = new ControlPoint4f(new Point3f(P2), pj[j].w);

                T2.set(X);
                T2.scale(-sin[i]);
                tmp.set(Y);
                tmp.scale(cos[i]);
                T2.add(tmp);

                lineIntersect3D(P0, T0, P2, T2, tmp, tmp);
                pij[index + 1][j] = new ControlPoint4f(new Point3f(tmp), (float) (wm * pj[j].w));

                index += 2;
                if (i < narcs) {
                    P0.set(P2);
                    T0.set(T2);
                }

            }
        }
        ControlNet cnet = new ControlNet(pij);
        return new BasicNurbsSurface(cnet, uKnot, curve.getKnots(), 2, curve.getDegree());
    }

    /**
     * Create a revolved NurbsSurface from the given NurbsCurve around the given
     * axis whith the angle theta. [TODO: test]
     * 
     * @param a
     *            Axis to revolve around.
     * @param curve
     *            NurbsCurve to revolve
     * @param thetaStart
     *            Angle to start revolution
     * @param thetaEnd
     *            Angle to end revolution
     * @return The revolved NurbsSurface
     */
    public static NurbsSurface createRevolvedSurface(Axis3D a, NurbsCurve curve, double thetaStart, double thetaEnd) {
        int narcs = 4;
        if (thetaStart > thetaEnd) {
            double tmp = thetaEnd;
            thetaEnd = thetaStart;
            thetaStart = tmp;
        }
        double theta = thetaEnd - thetaStart;
        if (theta <= Math.PI / 2) {
            narcs = 1;
        } else if (theta <= Math.PI) {
            narcs = 2;
        } else if (theta <= Math.PI + Math.PI / 2) {
            narcs = 3;
        }

        double dtheta = theta / narcs;
        int j = 3 + 2 * (narcs - 1);
        float uKnot[] = new float[j + 3];
        for (int i = 0; i < 3; i++) {
            uKnot[i] = 0;
            uKnot[j + i] = 1;
        }
        switch (narcs) {
        case 2:
            uKnot[3] = 0.5f;
            uKnot[4] = 0.5f;
            break;
        case 3:
            uKnot[3] = 1 / 3.0f;
            uKnot[4] = 1 / 3.0f;
            uKnot[5] = 2 / 3.0f;
            uKnot[6] = 2 / 3.0f;
            break;
        case 4:
            uKnot[3] = 0.25f;
            uKnot[4] = 0.25f;
            uKnot[5] = 0.5f;
            uKnot[6] = 0.5f;
            uKnot[7] = 0.75f;
            uKnot[8] = 0.75f;
            break;
        }


        double angle = thetaStart;
        double cos[] = new double[narcs + 1];
        double sin[] = new double[narcs + 1];
        for (int i = 0; i <= narcs; i++) {
            cos[i] = Math.cos(angle);
            sin[i] = Math.sin(angle);
            angle += dtheta;
        }

        ControlPoint4f pj[] = curve.getControlPoints();
        double wm = Math.cos(dtheta / 2);
        Point3d O = new Point3d();
        Point3d P2 = new Point3d();
        Vector3d T2 = new Vector3d();
        Point3d P0 = new Point3d();
        Vector3d T0 = new Vector3d();
        Point3d tmp = new Point3d();
        Vector3d X = new Vector3d();
        Vector3d Y = new Vector3d();
        ControlPoint4f pij[][] = new ControlPoint4f[2 * narcs + 1][pj.length]; // TODO
                                                                                // narcs+3??
        for (j = 0; j < pj.length; j++) {
            pointToLine3D(a.origin, a.dir, new Point3d(pj[j].getPoint3f()), O);
            X.set(pj[j].getPoint3f());
            X.sub(O);
            double r = X.length();
            if (r == 0) {
                X.set(O);
            }
            X.normalize();
            Y.cross(a.dir, X);
            pij[0][j] = new ControlPoint4f(pj[j]);
            P0 = new Point3d(pj[j].getPoint3f());
            T0.set(Y);
            int index = 0;
            for (int i = 1; i <= narcs; i++) {
                P2.set(O);
                tmp.set(X);
                tmp.scale(r * cos[i]);
                P2.add(tmp);
                tmp.set(Y);
                tmp.scale(r * sin[i]);
                P2.add(tmp);

                pij[index + 2][j] = new ControlPoint4f(new Point3f(P2), pj[j].w);

                T2.set(X);
                T2.scale(-sin[i]);
                tmp.set(Y);
                tmp.scale(cos[i]);
                T2.add(tmp);

                lineIntersect3D(P0, T0, P2, T2, tmp, tmp);
                pij[index + 1][j] = new ControlPoint4f(new Point3f(tmp), (float) (wm * pj[j].w));

                index += 2;
                if (i < narcs) {
                    P0.set(P2);
                    T0.set(T2);
                }

            }
        }
        ControlNet cnet = new ControlNet(pij);
        return new BasicNurbsSurface(cnet, uKnot, curve.getKnots(), 2, curve.getDegree());
    }

    /**
     * Create a semi-circle NurbsCurve around the given Origin with radius r.
     * 
     * @param o
     *            Origin to create semi-circle around.
     * @param r
     *            Radius of the semi-circle
     * @return A NurbsCurve for a semi-circle
     */
    public static NurbsCurve createSemiCircle(Origin3D o, float r) {
        ControlPoint4f cp[] = new ControlPoint4f[4];

        cp[0] = new ControlPoint4f(new Vector3f(o.xVec), 1);
        cp[0].scaleXYZ(r);
        cp[3] = new ControlPoint4f(cp[0]);
        cp[3].negateXYZ();
        cp[3].addXYZ(new Point3f(o.origin));
        cp[0].addXYZ(new Point3f(o.origin));

        cp[1] = new ControlPoint4f(new Vector3f(o.xVec), 1 / 2.0f);
        cp[1].addXYZ(new Vector3f(o.yVec));
        cp[1].scaleXYZ(r);
        cp[1].addXYZ(new Point3f(o.origin));

        cp[2] = new ControlPoint4f(new Vector3f(o.xVec), 1 / 2.0f);
        cp[2].negateXYZ();
        cp[2].addXYZ(new Vector3f(o.yVec));
        cp[2].scaleXYZ(r);
        cp[2].addXYZ(new Point3f(o.origin));

        float u[] = { 0, 0, 0, 0.5f, 1, 1, 1 };
        return new BasicNurbsCurve(cp, u, 2);
    }

    /**
     * Create a full-circle NurbsCurve around the given Origin with radius r and
     * of ControlPolygon type cptype.
     * 
     * @param o
     *            Origin to create the full-circle around
     * @param r
     *            Radius of the full-circle
     * @param cptype
     *            Type of the controlpolygon
     * @return A NurbsCurve for a full-circle
     */
    public static NurbsCurve createFullCircle(Origin3D o, float r, int cptype) {
        switch (cptype) {
        case FC_QUAD9:
            return createFullCircleQuad9(o, r);
        case FC_QUAD7:
            return createFullCircleQuad7(o, r);
        case FC_TRI7:
            return createFullCircleTri7(o, r);
        default:

        }
        return null;
    }

    /**
     * Create a full-circle NurbsCurve around the given Origin with radius r.
     * The NurbsCurve has controlpolygon which has 9 controlpoints and the shape
     * of quadrat.
     * 
     * @param o
     *            Origin to create the full-circle around
     * @param r
     *            Radius of the full-circle
     * @return A NurbsCurve for a full-circle
     */
    public static NurbsCurve createFullCircleQuad9(Origin3D o, float r) {
        float w = (float) Math.sqrt(2) / 2;

        ControlPoint4f cp[] = new ControlPoint4f[9];
        cp[0] = new ControlPoint4f(new Vector3f(o.xVec), 1);
        cp[0].scaleXYZ(r);
        cp[4] = new ControlPoint4f(cp[0]);
        cp[4].negateXYZ();
        cp[8] = new ControlPoint4f(cp[0]);
        cp[0].addXYZ(new Point3f(o.origin));
        cp[4].addXYZ(new Point3f(o.origin));
        cp[8].addXYZ(new Point3f(o.origin));

        cp[1] = new ControlPoint4f(new Vector3f(o.xVec), w);
        cp[1].addXYZ(new Vector3f(o.yVec));
        cp[1].scaleXYZ(r);
        cp[5] = new ControlPoint4f(cp[1]);
        cp[5].negateXYZ();
        cp[1].addXYZ(new Point3f(o.origin));
        cp[5].addXYZ(new Point3f(o.origin));

        cp[2] = new ControlPoint4f(new Vector3f(o.yVec), 1);
        cp[2].scaleXYZ(r);
        cp[6] = new ControlPoint4f(cp[2]);
        cp[6].negateXYZ();
        cp[2].addXYZ(new Point3f(o.origin));
        cp[6].addXYZ(new Point3f(o.origin));

        cp[3] = new ControlPoint4f(new Vector3f(o.xVec), w);
        cp[3].negateXYZ();
        cp[3].addXYZ(new Vector3f(o.yVec));
        cp[3].scaleXYZ(r);
        cp[7] = new ControlPoint4f(cp[3]);
        cp[7].negateXYZ();
        cp[3].addXYZ(new Point3f(o.origin));
        cp[7].addXYZ(new Point3f(o.origin));

        float uQ9[] = { 0, 0, 0, 0.25f, 0.25f, 0.5f, 0.5f, 0.75f, 0.75f, 1, 1, 1 };
        return new BasicNurbsCurve(cp, uQ9, 2);
    }

    /**
     * Create a full-circle NurbsCurve around the given Origin with radius r.
     * The NurbsCurve has controlpolygon which has 7 controlpoints and the shape
     * of quadrat.
     * 
     * @param o
     *            Origin to create the full-circle around
     * @param r
     *            Radius of the full-circle
     * @return A NurbsCurve for a full-circle
     */
    public static NurbsCurve createFullCircleQuad7(Origin3D o, float r) {

        ControlPoint4f cp[] = new ControlPoint4f[7];
        cp[0] = new ControlPoint4f(new Vector3f(o.xVec), 1);
        cp[0].scaleXYZ(r);
        cp[3] = new ControlPoint4f(cp[0]);
        cp[3].negateXYZ();
        cp[6] = new ControlPoint4f(cp[0]);
        cp[0].addXYZ(new Point3f(o.origin));
        cp[3].addXYZ(new Point3f(o.origin));
        cp[6].addXYZ(new Point3f(o.origin));

        cp[1] = new ControlPoint4f(new Vector3f(o.yVec), 1 / 2.0f);
        cp[1].addXYZ(new Vector3f(o.xVec));
        cp[1].scaleXYZ(r);
        cp[4] = new ControlPoint4f(cp[1]);
        cp[4].negateXYZ();
        cp[1].addXYZ(new Point3f(o.origin));
        cp[4].addXYZ(new Point3f(o.origin));

        cp[2] = new ControlPoint4f(new Vector3f(o.xVec), 1 / 2.0f);
        cp[2].negateXYZ();
        cp[2].addXYZ(new Vector3f(o.yVec));
        cp[2].scaleXYZ(r);

        cp[5] = new ControlPoint4f(cp[2]);
        cp[5].negateXYZ();
        cp[2].addXYZ(new Point3f(o.origin));
        cp[5].addXYZ(new Point3f(o.origin));

        float uQ7[] = { 0, 0, 0, 0.25f, 0.5f, 0.5f, 0.75f, 1, 1, 1 };
        return new BasicNurbsCurve(cp, uQ7, 2);
    }

    /**
     * Create a full-circle NurbsCurve around the given Origin with radius r.
     * The NurbsCurve has controlpolygon which has 7 controlpoints and the shape
     * oftriangle. <br>
     * [TODO not implemented by now]
     * 
     * @param o
     *            Origin to create the full-circle around
     * @param r
     *            Radius of the full-circle
     * @return A NurbsCurve for a full-circle
     */
    public static NurbsCurve createFullCircleTri7(Origin3D o, float r) {
        return null; // TODO
    }
    
    public static NurbsCurve createSegment(Point3f p1, Point3f p2){
    	ControlPoint4f cps[] = new ControlPoint4f[2];
    	cps[0]=new ControlPoint4f(p1.x, p1.y, p1.z, 1);
    	cps[1]=new ControlPoint4f(p2.x, p2.y, p2.z, 1);
		
		float uk[] = { 0,0,1,1};
		BasicNurbsCurve nc = new BasicNurbsCurve(cps, uk, 1);
//		nc.generateSmoothKnots();
		return nc;
    }
    /**
     * Create an Arc.
     * 
     * @param o
     *            Origin to creat arc around
     * @param r
     *            Radius of the arc.
     * @param ths
     *            Start angle of the arc in radians
     * @param the
     *            End angle of the arc in radians. If end angle is smaller than
     *            start angle, the end angle is increased by 2*PI.
     * @return A NurbsCurve for the Arc.
     */
    public static NurbsCurve createArc(Origin3D o, double r, double ths, double the) {
        Point3d tmp = new Point3d();

        if (the < ths)
            the += Math.PI + Math.PI;
        double theta = the - ths;

        int narcs = 4;
        if (theta <= Math.PI / 2) {
            narcs = 1;
        } else if (theta <= Math.PI) {
            narcs = 2;
        } else if (theta <= Math.PI + Math.PI / 2) {
            narcs = 3;
        }
        double dtheta = theta / narcs;
        int n = 2 * narcs;
        double w1 = Math.cos(dtheta / 2);

        Point3d p0 = new Point3d(o.origin);
        tmp.set(o.xVec);
        tmp.scale(r * Math.cos(ths));
        p0.add(tmp);
        tmp.set(o.yVec);
        tmp.scale(r * Math.sin(ths));
        p0.add(tmp);

        Vector3d t0 = new Vector3d(o.xVec);
        t0.scale(-Math.sin(ths));
        tmp.set(o.yVec);
        tmp.scale(Math.cos(ths));
        t0.add(tmp);

        ControlPoint4f cps[] = new ControlPoint4f[n + 1];
        cps[0] = new ControlPoint4f((float) p0.x, (float) p0.y, (float) p0.z, 1);
        int index = 0;
        double angle = ths;

        Point3d p2 = new Point3d();
        Vector3d t2 = new Vector3d();
        Point3d p1 = new Point3d();
        for (int i = 1; i <= narcs; i++) {
            angle += dtheta;
            double sin = Math.sin(angle);
            double cos = Math.cos(angle);

            p2.set(o.origin);
            tmp.set(o.xVec);
            tmp.scale(r * cos);
            p2.add(tmp);
            tmp.set(o.yVec);
            tmp.scale(r * sin);
            p2.add(tmp);

            cps[index + 2] = new ControlPoint4f((float) p2.x, (float) p2.y, (float) p2.z, 1);

            t2.set(o.xVec);
            t2.scale(-sin);
            tmp.set(o.yVec);
            tmp.scale(cos);
            t2.add(tmp);

            lineIntersect3D(p0, t0, p2, t2, p1, p1);

            cps[index + 1] = new ControlPoint4f((float) p1.x, (float) p1.y, (float) p1.z, (float) w1);

            index += 2;

            if (i < narcs) {
                p0.set(p2);
                t0.set(t2);
            }
        }
        int j = n + 1;
        float uKnot[] = new float[j + 3];
        for (int i = 0; i < 3; i++) {
            uKnot[i] = 0;
            uKnot[i + j] = 1;
        }
        switch (narcs) {
        case 2:
            uKnot[3] = 0.5f;
            uKnot[4] = 0.5f;
            break;
        case 3:
            uKnot[3] = 1 / 3.0f;
            uKnot[4] = 1 / 3.0f;
            uKnot[5] = 2 / 3.0f;
            uKnot[6] = 2 / 3.0f;
            break;
        case 4:
            uKnot[3] = 0.25f;
            uKnot[4] = 0.25f;
            uKnot[5] = 0.5f;
            uKnot[6] = 0.5f;
            uKnot[7] = 0.75f;
            uKnot[8] = 0.75f;
            break;
        }

        return new BasicNurbsCurve(cps, uKnot, 2);
    }

    private static void lineIntersect3D(Point3d p0, Vector3d t0, Point3d p2, Vector3d t2, Point3d out0, Point3d out2) {
        Vector3d v02 = new Vector3d(p0);
        v02.sub(p2);

        double a = t0.dot(t0);
        double b = t0.dot(t2);
        double c = t2.dot(t2);
        double d = t0.dot(v02);
        double e = t2.dot(v02);
        double denom = a * c - b * b;

        double mu0, mu2;

        if (denom < 0.0001) { // TODO: epsilon
            mu0 = 0;
            mu2 = b > c ? d / b : e / c;
        } else {
            mu0 = (b * e - c * d) / denom;
            mu2 = (a * e - b * d) / denom;
        }

        out0.set(t0);
        out0.scale(mu0);
        out0.add(p0);

        out2.set(t2);
        out2.scale(mu2);
        out2.add(p2);
    }

    private static void pointToLine3D(Point3d p, Vector3d t, Point3d top, Point3d out) {
        Vector3d dir = new Vector3d(top.x - p.x, top.y - p.y, top.z - p.z);
        double hyp = dir.length();
        dir.normalize();
        double dot = t.dot(dir);

        out.set(p);
        Vector3d v = new Vector3d(t);
        v.scale(dot * hyp);
        out.add(v);
    }

    /**
     * Interpolates a NurbCurve form the given Points using a global
     * interpolation technique.
     * 
     * @param points
     *            Points to interpolate
     * @param p
     *            degree of the interpolated NurbsCurve
     * @return A NurbsCurve interpolating the given Points
     * @throws InterpolationException
     *             thrown if interpolation failed or is not possible.
     */
    public static NurbsCurve globalCurveInterpolation(Point3f points[], int p) throws InterpolationException {
        try {

            int n = points.length - 1;
            double A[] = new double[(n + 1) * (n + 1)];

            float uk[] = centripetal(points);
            KnotVector uKnots = averaging(uk, p);
            for (int i = 0; i <= n; i++) {
                int span = uKnots.findSpan(uk[i]);
                double tmp[] = uKnots.basisFunctions(span, uk[i]);
                System.arraycopy(tmp, 0, A, i * (n + 1) + span - p, tmp.length);
            }
            GMatrix a = new GMatrix(n + 1, n + 1, A);
            GVector perm = new GVector(n + 1);
            GMatrix lu = new GMatrix(n + 1, n + 1);
            a.LUD(lu, perm);

            ControlPoint4f cps[] = new ControlPoint4f[n + 1];
            for (int i = 0; i < cps.length; i++) {
                cps[i] = new ControlPoint4f(0, 0, 0, 1);
            }

            // x-ccordinate
            GVector b = new GVector(n + 1);
            for (int j = 0; j <= n; j++) {
                b.setElement(j, points[j].x);
            }
            GVector sol = new GVector(n + 1);
            sol.LUDBackSolve(lu, b, perm);
            for (int j = 0; j <= n; j++) {
                cps[j].x = (float) sol.getElement(j);
            }

            // y-ccordinate
            b = new GVector(n + 1);
            for (int j = 0; j <= n; j++) {
                b.setElement(j, points[j].y);
            }
            sol = new GVector(n + 1);
            sol.LUDBackSolve(lu, b, perm);
            for (int j = 0; j <= n; j++) {
                cps[j].y = (float) sol.getElement(j);
            }

            // z-ccordinate
            b = new GVector(n + 1);
            for (int j = 0; j <= n; j++) {
                b.setElement(j, points[j].z);
            }
            sol = new GVector(n + 1);
            sol.LUDBackSolve(lu, b, perm);
            for (int j = 0; j <= n; j++) {
                cps[j].z = (float) sol.getElement(j);
            }
            return new BasicNurbsCurve(cps, uKnots);
        } catch (SingularMatrixException ex) {
            throw new InterpolationException(ex);
        }

    }

    private static float[] centripetal(Point3f points[]) {
        int n = points.length - 1;
        float d = 0;
        float uk[] = new float[n + 1];
        uk[n] = 1;
        double tmp[] = new double[n];
        for (int k = 1; k <= n; k++) {
            tmp[k - 1] = Math.sqrt(points[k].distance(points[k - 1]));
            d += tmp[k - 1];
        }
        for (int i = 1; i < n; i++) {
            uk[i] = uk[i - 1] + (float) (tmp[i - 1] / d);
        }
        return uk;
    }

    private static KnotVector averaging(float uk[], int p) {
        int m = uk.length + p;
        int n = uk.length - 1;
        float u[] = new float[m + 1];
        for (int i = 0; i <= p; i++) {
            u[i] = 0;
            u[u.length - 1 - i] = 1;
        }
        for (int j = 1; j <= n - p; j++) {
            float sum = 0;
            for (int i = j; i <= j + p - 1; i++) {
                sum += uk[i];
            }
            u[j + p] = sum / p;
        }
        return new KnotVector(u, p);
    }

    /**
     * Interpolates a NurbsSurface from the given points using a gloabl
     * interpolation technique.
     * 
     * @param points
     *            Points arranged in a net (matrix) to interpolate
     * @param p
     *            degree in u direction
     * @param q
     *            degree in v direction
     * @return A NurbsSurface interpolating the given points.
     * @throws InterpolationException
     *             thrown if interpolation failed or is not possible.
     */
    public static NurbsSurface globalSurfaceInterpolation(Point3f points[][], int p, int q)
            throws InterpolationException {
        int n = points.length - 1;
        int m = points[0].length - 1;
        float uv[][] = surfaceMeshParameters(points, n, m);
        KnotVector u = averaging(uv[0], p);
        KnotVector v = averaging(uv[1], q);

        ControlPoint4f r[][] = new ControlPoint4f[m + 1][n + 1];
        for (int l = 0; l <= m; l++) {
            Point3f tmp[] = new Point3f[n + 1];
            for (int i = 0; i <= n; i++) {
                tmp[i] = points[i][l];
            }
            try {
                NurbsCurve curve = globalCurveInterpolation(tmp, p);
                r[l] = curve.getControlPoints();
            } catch (InterpolationException ex) {
                for (int i = 0; i < tmp.length; i++) {
                    r[l][i] = new ControlPoint4f(tmp[i], 1);
                }
            }

        }

        ControlPoint4f cp[][] = new ControlPoint4f[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Point3f tmp[] = new Point3f[m + 1];
            for (int j = 0; j <= m; j++) {
                tmp[j] = r[j][i].getPoint3f();
                //tmp[j]=points[i][j];
            }
            try {
                NurbsCurve curve = globalCurveInterpolation(tmp, q);
                cp[i] = curve.getControlPoints();
            } catch (InterpolationException ex) {
                for (int j = 0; j < tmp.length; j++) {
                    cp[i][j] = new ControlPoint4f(tmp[j], 1);
                }
            }
        }

        return new BasicNurbsSurface(new ControlNet(cp), u, v);
    }

    private static float[][] surfaceMeshParameters(Point3f points[][], int n, int m) {
        float res[][] = new float[2][];
        int num = m + 1;
        float cds[] = new float[(n + 1) * (m + 1)];

        float uk[] = new float[n + 1];
        uk[n] = 1;
        for (int l = 0; l <= m; l++) {
            float total = 0;
            for (int k = 1; k <= n; k++) {
                cds[k] = points[k][l].distance(points[k - 1][l]);
                total += cds[k];
            }
            if (total == 0) {
                num = num - 1;
            } else {
                float d = 0;
                for (int k = 1; k <= n; k++) {
                    d += cds[k];
                    uk[k] += d / total;
                }
            }
        }
        if (num == 0) {
            return null;
        }
        for (int k = 1; k < n; k++) {
            uk[k] /= num;
        }

        num = n + 1;
        float vk[] = new float[m + 1];
        vk[m] = 1;
        for (int l = 0; l <= n; l++) {
            float total = 0;
            for (int k = 1; k <= m; k++) {
                cds[k] = points[l][k].distance(points[l][k - 1]);
                total += cds[k];
            }
            if (total == 0) {
                num = num - 1;
            } else {
                float d = 0;
                for (int k = 1; k <= m; k++) {
                    d += cds[k];
                    vk[k] += d / total;
                }
            }
        }
        if (num == 0) {
            return null;
        }
        for (int k = 1; k < m; k++) {
            vk[k] /= num;
        }

        res[0] = uk;
        res[1] = vk;

        return res;
    }
    
    public static NurbsSurface createSwungSurface(NurbsCurve traj, NurbsCurve proj){
        ControlPoint4f cpProj[]=proj.getControlPoints();
        ControlPoint4f cpTraj[]=traj.getControlPoints();
        
        ControlPoint4f cps[][]=new ControlPoint4f[cpProj.length][cpTraj.length];
        for(int i=0; i<cpProj.length; i++){
            for(int j=0; j<cpTraj.length; j++){
                ControlPoint4f cp=new ControlPoint4f();
                cp.x=cpProj[i].x*cpTraj[j].x;
                cp.y=cpProj[i].y*cpTraj[j].y;
                cp.z=cpProj[i].z*cpTraj[j].z;
                cp.w=cpProj[i].w*cpTraj[j].w;
                cps[i][j]=cp;
            }
        }
        return new BasicNurbsSurface(new ControlNet(cps), proj.getKnots(), traj.getKnots(), proj.getDegree(), traj.getDegree());
        
    }

}
