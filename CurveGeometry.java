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

import org.ocx_schema.v310.*;

import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.List;

/**
 * A Class responsible for calculating geometric properties of a Curved3DT from an OCX file.
 * It uses Vessel/DistanceTolerance to check if the curved is closed. If not found, use a tolerance of 1mm.
 *
 */
public class CurveGeometry {
    private final Curve3DT curve;
    private final GeometryQuality quality;
    private final List<Point3d> points = new ArrayList<>();
    private boolean closed;
    private double length = Double.NaN;

    /**
     * Create a new CurveGeometry for a curve and the desired quality
     *
     * @param curve   the curve
     * @param quality the quality
     */
    public CurveGeometry(Curve3DT curve, GeometryQuality quality) {
        if (curve == null) {
            throw new IllegalArgumentException("missing curve");
        }
        if (quality == null) {
            throw new IllegalArgumentException("missing quality")
        }

        this.curve = curve;
        this.quality = quality;
        this.init();
    }

    private void init() {
        if (curve instanceof CompositeCurve3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof CircumCircle3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof PolyLine3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof Line3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof NURBS3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof CircumArc3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof Circle3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof Ellipse3DT ccurve) {
            length = init(ccurve, points);
        } else if (curve instanceof FreeEdgeCurve3DT ccurve) {
            length = init(ccurve, points);
        } else {
            throw new IllegalArgumentException("got unsupported curve type " + curve);
        }
    }

    private double  init(CompositeCurve3DT curve, List<Point3d> points) {

        for (Curve3DT innerCurve : curve.getPolyLine3DsAndLine3DsAndNURBS3DS()) {
            var innerPoints = new ArrayList<Point3d>();

            length += switch (innerCurve) {
                case PolyLine3DT ccurve -> init(ccurve, innerPoints);
                case Line3DT ccurve -> init(ccurve, innerPoints);
                case NURBS3DT ccurve -> init(ccurve, innerPoints);
                case null, default ->
                        throw new IllegalArgumentException("got unsupported curve type " + curve + " in CompositeCurve3DT");
            };
            points.addAll( innerPoints)
        }
    }

    private double init(CircumCircle3DT curve, List<Point3d> points) {

    }

    private double init(PolyLine3DT curve, List<Point3d> points) {

    }

    private double init(Line3DT curve, List<Point3d> points) {

    }

    private double init(NURBS3DT curve, List<Point3d> points) {



    }

    private double init(CircumArc3DT curve, List<Point3d> points) {

    }

    private double init(Circle3DT curve, List<Point3d> points) {

    }
    private double init(Ellipse3DT curve, List<Point3d> points) {

    }

    private double init(FreeEdgeCurve3DT curve, List<Point3d> points) {

    }

    /**
     * Returns a list of Point3ds. If the line is closed, the first and last point are identical
     *
     * @return the points
     */
    public List<Point3d> getPoints() {

        return points;
    }

    /**
     * Check whether a curve is closed
     *
     * @return Returns true if the curve is closed.
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Get the approximated curve length
     *
     * @return the length in mm. Double.NaN if calculation failed
     */
    public double getLength() {

        return length;
    }


}
