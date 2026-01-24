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
        if (geometry instanceof org.ocx_schema.v310.Line3DT) {
            return "Line";
        } else if (geometry instanceof org.ocx_schema.v310.CircumArc3DT) {
            return "Arc";
        } else if (geometry instanceof org.ocx_schema.v310.CircumCircle3DT) {
            return "CircumCircle";
        } else if (geometry instanceof org.ocx_schema.v310.PolyLine3DT) {
            return "PolyLine";
        } else if (geometry instanceof org.ocx_schema.v310.NURBS3DT) {
            return "NURBS";
        } else if (geometry instanceof org.ocx_schema.v310.CompositeCurve3DT) {
            return "Composite Curve";
        } else if (geometry instanceof org.ocx_schema.v310.SurfaceCollection) {
            return "Surface Collection";
        } else if (geometry instanceof org.ocx_schema.v310.Cylinder3DT) {
            return "Cylinder3D";
        } else if (geometry instanceof org.ocx_schema.v310.Cone3DT) {
            return "Cone";
        } else if (geometry instanceof org.ocx_schema.v310.Plane3DT) {
            return "Plane";
        } else if (geometry instanceof org.ocx_schema.v310.Sphere3DT) {
            return "Sphere";
        } else if (geometry instanceof org.ocx_schema.v310.ExtrudedSurfaceT) {
            return "ExtrudedSurface";
        } else if (geometry instanceof org.ocx_schema.v310.NURBSSurfaceT) {
            return "NURBS Surface";
        } else {
            return "Unknown Geometry Type";
        }
    }

}
