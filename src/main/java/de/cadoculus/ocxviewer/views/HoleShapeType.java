package de.cadoculus.ocxviewer.views;

import org.ocx_schema.v310rc3.*;

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
        if (parametricHole2DT instanceof RectangularMickeyMouseEarsT) {
            return RECTANGULAR_MICKEY_MOUSE_EARS;
        }

        return UNKNOWN;
    }
}
