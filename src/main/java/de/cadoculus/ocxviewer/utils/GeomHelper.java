/*
 * Copyright 2025 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cadoculus.ocxviewer.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.ControlPtList;
import org.ocx_schema.v310.NURBSSurfaceT;

/**
 * A helper class for geometric entities
 *
 * @author Carsten Zerbst
 */
public class GeomHelper {
    private static final Logger LOG = LogManager.getLogger(GeomHelper.class);

    // Prevent class instantiation
    private GeomHelper() {
    }


    /**
     * Get the geometry type as a string.
     * This works from DescriptionBaseT and its subclasses, as there is no common interface for all geometry types.
     * It returns 'Unknown Geometry Type' if the type is not recognized.
     *
     * @param geometry the geometry
     * @return the geometry type as string
     */
    public static String getGeometryType(org.ocx_schema.v310.DescriptionBaseT geometry) {
        return switch (geometry) {
            case org.ocx_schema.v310.Line3DT line3DT -> "Line";
            case org.ocx_schema.v310.CircumArc3DT circumArc3DT -> "Arc";
            case org.ocx_schema.v310.CircumCircle3DT circumCircle3DT -> "CircumCircle";
            case org.ocx_schema.v310.PolyLine3DT polyLine3DT -> "PolyLine";
            case org.ocx_schema.v310.NURBS3DT nurbs3DT -> "NURBS";
            case org.ocx_schema.v310.CompositeCurve3DT compositeCurve3DT -> "Composite Curve";
            case org.ocx_schema.v310.SurfaceCollection surfaceCollection -> "Surface Collection";
            case org.ocx_schema.v310.Cylinder3DT cylinder3DT -> "Cylinder3D";
            case org.ocx_schema.v310.Cone3DT cone3DT -> "Cone";
            case org.ocx_schema.v310.Plane3DT plane3DT -> "Plane";
            case org.ocx_schema.v310.Sphere3DT sphere3DT -> "Sphere";
            case org.ocx_schema.v310.ExtrudedSurfaceT extrudedSurfaceT -> "ExtrudedSurface";
            case NURBSSurfaceT nurbsSurfaceT -> "NURBS Surface";
            case null, default -> "Unknown Geometry Type";
        };
    }

    /**
     * CHecks the NURBS conditions are met.
     * Performed checks:
     * <ul>
     *     <li>U and V Nurbs Properties exist</li>
     * </ul>
     *
     * @param nurbsSurface the surface to check
     */
    public static void checkNURBS(NURBSSurfaceT nurbsSurface) throws IllegalArgumentException {

        if (nurbsSurface.getUNURBSproperties() == null) {
            throw new IllegalArgumentException("Missing U NurbsProperties");
        }
        if (nurbsSurface.getVNURBSproperties() == null) {
            throw new IllegalArgumentException("Missing V NurbsProperties");
        }
        if (nurbsSurface.getUNURBSproperties().getDegree() < 2 || nurbsSurface.getUNURBSproperties().getDegree() > 5) {
            throw new IllegalArgumentException(String.format("The U Degree %d is not in the expected range 3⸺5", nurbsSurface.getUNURBSproperties().getDegree()));
        }
        if (nurbsSurface.getVNURBSproperties().getDegree() < 2 || nurbsSurface.getVNURBSproperties().getDegree() > 5) {
            throw new IllegalArgumentException(String.format("The V Degree %d is not in the expected range 3⸺5", nurbsSurface.getVNURBSproperties().getDegree()));
        }

        // There is an error in the formula, must be r= m+p+1=m+k+1, with r = size knotvector, m = ,p = num control points k=degree
        // The knot-vector is a list of  size m=+n-1 knots where p is the polynomial basis degree and n is the number of control points.
        // The knot vector consists of a non-decreasing sequence of values. Knot multiplicities can be included. A knot multiplicity means that a knot value can be repeated up to p+1 times.</xs:documentation>

        // for U
        var r = nurbsSurface.getUknotVector().getValues().size();
        var p = nurbsSurface.getUNURBSproperties().getDegree();
        var n = nurbsSurface.getUNURBSproperties().getNumCtrlPts();
        var k = nurbsSurface.getUNURBSproperties().getNumKnots();

        if (r != (n + p + 1)) {
            throw new IllegalArgumentException(String.format("Found wrong number of knots in U, expect r=n+p+1=%d+%d+1=%d, but found %d",
                    n, p, (n + p + 1), r));
        }
        if (k != nurbsSurface.getUknotVector().getValues().size()) {
            throw new IllegalArgumentException(String.format("Found wrong number of knots in U, expect  k=%d as given in NURBS properties, but found %d",
                    k, nurbsSurface.getUknotVector().getValues().size()));
        }

        // for V
        r = nurbsSurface.getVknotVector().getValues().size();
        p = nurbsSurface.getVNURBSproperties().getDegree();
        n = nurbsSurface.getVNURBSproperties().getNumCtrlPts();
        k = nurbsSurface.getVNURBSproperties().getNumKnots();

        if (r != (n + p + 1)) {
            throw new IllegalArgumentException(String.format("Found wrong number of knots in V, expect r=n+p+1=%d+%d+1=%d, but found %d",
                    n, p, (n + p + 1), r));
        }
        if (k != nurbsSurface.getUknotVector().getValues().size()) {
            throw new IllegalArgumentException(String.format("Found wrong number of knots in VU, expect  k=%d as given in NURBS properties, but found %d",
                    k, nurbsSurface.getVknotVector().getValues().size()));
        }

        // total
        if ( nurbsSurface.getControlPtLists()== null ||  nurbsSurface.getControlPtLists().isEmpty()) {
            throw new IllegalArgumentException("Missing control points list");
        } else if ( nurbsSurface.getControlPtLists().size()==1) {

            final ControlPtList ptList = nurbsSurface.getControlPtLists().getFirst();

            if (nurbsSurface.getUNURBSproperties().getNumCtrlPts() * nurbsSurface.getVNURBSproperties().getNumCtrlPts() != ptList.getControlPoints().size()) {
                throw new IllegalArgumentException(String.format("Found wrong number of control points, expect n = n_u*n_v=%d*%d=%d, found %d",
                        nurbsSurface.getUNURBSproperties().getNumCtrlPts(), nurbsSurface.getVNURBSproperties().getNumCtrlPts(),
                        nurbsSurface.getUNURBSproperties().getNumCtrlPts() * nurbsSurface.getVNURBSproperties().getNumCtrlPts(),
                        ptList.getControlPoints().size()));
            }
        } else {
            LOG.warn("found #{} controlpoint lists in {} ({}), is this intended?", nurbsSurface.getControlPtLists().size(),
                    nurbsSurface.getId(), nurbsSurface.getGUIDRef());

            if ( nurbsSurface.getControlPtLists().size()!= nurbsSurface.getUNURBSproperties().getNumCtrlPts()) {
                throw new IllegalArgumentException(String.format("Found #%d control points, expect to match U numCtrlPts=%d",
                        nurbsSurface.getControlPtLists().size(), nurbsSurface.getUNURBSproperties().getNumCtrlPts()));
            }
            // now look at the individual list
            for( int i = 0; i <  nurbsSurface.getControlPtLists().size(); i++) {
                final ControlPtList ptList = nurbsSurface.getControlPtLists().get(i);
                if ( ptList.getControlPoints().size() != nurbsSurface.getVNURBSproperties().getNumCtrlPts()) {
                    throw new IllegalArgumentException(String.format("Found wrong number of control points in sublist #%d, expect size to match V numCtrlPts=%d , found %d",
                            i, nurbsSurface.getVNURBSproperties().getNumCtrlPts(),  ptList.getControlPoints().size()));
                }
            }
        }

        // increasing knots
        var ks = nurbsSurface.getUknotVector().getValues();
        var last = ks.getFirst();
        for ( int i = 1; i < ks.size();i++) {
            var mult = ks.get(i);
            if ( mult-last <0) {
                throw new IllegalArgumentException(String.format("Found decreasing values in U knot vector at #%d=%f and #%d=%f",
                        i-1, last, i, mult));

            }
            last = mult;
        }
        ks = nurbsSurface.getVknotVector().getValues();
        last = ks.getFirst();
        for ( int i = 1; i < ks.size();i++) {
            var mult = ks.get(i);
            if ( mult-last <0) {
                throw new IllegalArgumentException(String.format("Found decreasing values in V knot vector at #%d=%f and #%d=%f",
                        i-1, last, i, mult));
            }
            last = mult;
        }


    }
}
