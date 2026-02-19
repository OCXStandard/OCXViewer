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

    private List<Point3d> renderToPoints() {

        return switch (curve) {
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

    private List<Point3d> renderToPoints(NURBS3DT n) {
        return null;
    }

    private List<Point3d> renderToPoints(CompositeCurve3DT p) {
        return null;
    }

    private List<Point3d> renderToPoints(Line3DT l) {
        return null;
    }

    private List<Point3d> renderToPoints(PolyLine3DT p) {
        return null;
    }

    private List<Point3d> renderToPoints(CircumCircle3DT c) {
        return null;
    }

    private List<Point3d> renderToPoints(Ellipse3DT e) {
        return null;
    }

    private List<Point3d> renderToPoints(Circle3DT c) {
        return null;
    }

    private List<Point3d> renderToPoints(CircumArc3DT c) {
        return null;
    }

}
