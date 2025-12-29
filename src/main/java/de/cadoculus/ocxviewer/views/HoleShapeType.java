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
package de.cadoculus.ocxviewer.views;

import org.ocx_schema.v310.*;

public enum HoleShapeType {
    PARAMETRIC_CIRCLE("Parametric Circle"),
    SYMMETRIC_HOLE("Symmetrical Hole"),
    SUPER_ELLIPTICAL("SuperElliptical"),
    RECTANGULAR_HOLE("RectangularHole"),
    RECTANGULAR_MICKEY_MOUSE_EARS("RectangularMickeyMouseEars"),
    UNKNOWN("Unknown");
    private String name;

    public String getName() {
        return name;
    }

    private HoleShapeType(String name) {
        this.name = name;
    }

    public static HoleShapeType getType(Hole2D value) {

        if (value.getParametricHole2D() == null) {
            return UNKNOWN;
        }

        final ParametricHole2DT parametricHole2DT = value.getParametricHole2D().getValue();

        if (parametricHole2DT instanceof ParametricCircleT) {
            return PARAMETRIC_CIRCLE;
        }
        if (parametricHole2DT instanceof SymmetricalHoleT) {
            return SYMMETRIC_HOLE;
        }
        if (parametricHole2DT instanceof SuperEllipticalT) {
            return SUPER_ELLIPTICAL;
        }
        if (parametricHole2DT instanceof RectangularHoleT) {
            return RECTANGULAR_HOLE;
        }
        if (parametricHole2DT instanceof RectangularMickeyMouseEars) {
            return RECTANGULAR_MICKEY_MOUSE_EARS;
        }

        return UNKNOWN;
    }
}
