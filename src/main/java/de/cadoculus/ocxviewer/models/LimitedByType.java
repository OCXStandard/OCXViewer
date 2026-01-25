/*
Copyright 2025 Carsten Zerbst

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
package de.cadoculus.ocxviewer.models;

import org.ocx_schema.v310.*;

/**
 * Enumeration of different types supported in limitedBy elements in OCX files.
 *
 * @author Carsten Zerbst
 */
public enum LimitedByType {
    CELL_BOUNDARY("Cell Boundary"),
    FREE_EDGE_CURVE("Free Edge Curve"),
    EDGE_CURVE_REF("Edge Curve Reference"),
    EDGE_REINFORCEMENT("Edge Reinforcement"),
    GRID_REF("Grid"),
    PANEL_REF("Panel"),
    SEAM_REF("Seam Reference"),
    STIFFENER_REF("Stiffener"),
    SURFACE_REF("Surface Ref"),
    SURFACE("Surface"),
    UNKNOWN("Unknown");
    private String name;

    private LimitedByType(String name) {
        this.name = name;
    }

    public static LimitedByType getType(Object limit) {

        if (limit instanceof FreeEdgeCurve3D ) {
            return LimitedByType.FREE_EDGE_CURVE;
        } else if (limit instanceof CellBoundary ) {
            return LimitedByType.CELL_BOUNDARY;
        } else if (limit instanceof EdgeCurveRefT ) {
            return LimitedByType.EDGE_CURVE_REF;
        } else if (limit instanceof GridRefT ) {
            return LimitedByType.GRID_REF;
        } else if (limit instanceof PanelRefT ) {
            return LimitedByType.PANEL_REF;
        } else if (limit instanceof SeamRefT ) {
            return LimitedByType.SEAM_REF;
        } else if (limit instanceof StiffenerRefT ) {
            return LimitedByType.STIFFENER_REF;
        } else if (limit instanceof SurfaceRefT ) {
            return LimitedByType.SURFACE_REF;
        } else if (limit instanceof SurfaceT ) {
            return LimitedByType.SURFACE;
        }

        return UNKNOWN;
    }

    public String getName() {
        return name;
    }
}
