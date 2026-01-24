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

import atlantafx.base.controls.Breadcrumbs;
import atlantafx.base.theme.Styles;
import atlantafx.base.util.IntegerStringConverter;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.EventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.SurfaceControlPointRecord;
import de.cadoculus.ocxviewer.utils.GeomHelper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A page displaying information about a Surface.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the ReferenceSurfacesPage
 *
 * @author Carsten Zerbst
 */
public class SurfacePage extends AbstractDataViewSubPage<org.ocx_schema.v310.SurfaceT> {
    public static final String NAME = "Surface";
    private static final Logger LOG = LogManager.getLogger(SurfacePage.class);
    private final GridPane gridPane;

    public SurfacePage(org.ocx_schema.v310.SurfaceT surface, Page parent) {
        super(surface, parent, GeomHelper.getGeometryType(surface) + " \u00AB" + surface.getId() + "\u00BB");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Surface");

        gridPane = createDefaultGrid();
        setCenter(gridPane);


        if (surface instanceof NURBSSurfaceT nurbsSurface) {
            init(nurbsSurface);
        } else if (surface instanceof Cylinder3DT cylinder) {
            init(cylinder);
        } else if (surface instanceof Cone3DT nurbsSurface) {
            init(nurbsSurface);
        } else if (surface instanceof Sphere3DT sphere) {
            init(sphere);
        } else if (surface instanceof ExtrudedSurfaceT nurbsSurface) {
            init(nurbsSurface);
        } else if (surface instanceof Plane3DT plane) {
            init(plane);
        } else {


            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "Not implemented yet",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            setCenter(warning);
        }

    }

    private void init(Plane3DT plane) {
        int row = 0;
        var label = new Label("Origin");
        label.setTooltip(new Tooltip("A point on the plane."));
        gridPane.add(label, 0, row);
        var group = createOrRebind(null, plane.getOrigin(), true);
        gridPane.add(group, 1, row++, 3, 1);


        label = new Label("Normal");
        label.setTooltip(new Tooltip("The planes normal."));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, plane.getNormal(), true);
        gridPane.add(group, 1, row++, 3, 1);

        label = new Label("U Direction");
        label.setTooltip(new Tooltip("Optional local U direction of the plane."));
        gridPane.add(label, 2, row);
        group = createOrRebind(null, plane.getUDirection(), false);
        gridPane.add(group, 3, row, 3, 1);


        if (plane.getLimitedBy() != null ) {
            label = new Label("The plane is limited by a curve");
            label.setTooltip(new Tooltip(""));
            gridPane.add(label, 0, ++row, 3, 1);
        } else {
            label = new Label("The plane is not limited by a curve");
            label.setTooltip(new Tooltip("The plane is limited by a curve"));
            gridPane.add(label, 0, ++row, 3, 1);
        }

    }

    private void init(ExtrudedSurfaceT extrudedSurface) {

        int row = 0;
        var label = new Label("BaseCurve");
        label.setTooltip(new Tooltip("The base curve which is extruded, defining an extruded surface when it is swept."));
        gridPane.add(label, 0, row);

        label = new Label("Display of Curve not implemented yet.");
        label.getStyleClass().add(Styles.WARNING);
        gridPane.add(label, 1, row++, 3, 1);

        if ( extrudedSurface.getSweep()  != null && extrudedSurface.getSweepCurve() != null) {

            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "Found both Sweep and SweepCurve, expect only one of them!",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            gridPane.add(label, 0, row++, 4, 1);
        }

        if ( extrudedSurface.getSweep() != null ) {

            label = new Label("Definition of the sweep extent  by a direction and sweep  length.");
            gridPane.add(label, 0, row++, 4, 1);

            label = new Label("Vector");
            label.setTooltip(new Tooltip("The sweep direction given by a Unit vector of length 1."));
            gridPane.add(label, 0, row);
            var group = createOrRebind(null, extrudedSurface.getSweep().getVector3D(), true);
            gridPane.add(group, 1, row++, 3, 1);

            label = new Label("Sweep Length");
            label.setTooltip(new Tooltip("The extent of the sweep."));
            gridPane.add(label, 0, row);
            group = createOrRebind(null, extrudedSurface.getSweep().getSweepLength(), true);
            gridPane.add(group, 1, row++);

        } else {
            label = new Label("The sweep direction and extent is defined by a general 3D sweep curve.");
            gridPane.add(label, 0, row++, 4, 1);

            label = new Label("Curve");
            label.setTooltip(new Tooltip("The sweep curve."));
            gridPane.add(label, 0, row);

            label = new Label("Display of Curve not implemented yet.");
            label.getStyleClass().add(Styles.WARNING);
            gridPane.add(label, 1, row++, 3, 1);

        }
    }

    private void init(Sphere3DT sphere) {

        int row = 0;
        var label = new Label("Origin");
        label.setTooltip(new Tooltip("The origin or centre of the sphere."));
        gridPane.add(label, 0, row);
        var group = createOrRebind(null, sphere.getOrigin(), true);
        gridPane.add(group, 1, row++, 3, 1);


        label = new Label("Radius");
        label.setTooltip(new Tooltip("The radius of the sphere."));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, sphere.getRadius(), true);
        gridPane.add(group, 1, row++);


    }

    private void init(Cone3DT cone) {

        int row = 0;
        var label = new Label("Origin");
        label.setTooltip(new Tooltip("The origin or centre of the cone at the base."));
        gridPane.add(label, 0, row);
        var group = createOrRebind(null, cone.getOrigin(), true);
        gridPane.add(group, 1, row++, 3, 1);

        label = new Label("Tip");
        label.setTooltip(new Tooltip("The planes normal."));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, cone.getTip(), true);
        gridPane.add(group, 1, row++, 3, 1);

        label = new Label("Base Radius");
        label.setTooltip(new Tooltip("The radius of the sphere."));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, cone.getBaseRadius(), true);
        gridPane.add(group, 1, row++);


        label = new Label("Tip Radius");
        label.setTooltip(new Tooltip("Cone tip radius (default = 0)."));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, cone.getTipRadius(),false);
        gridPane.add(group, 1, row++);



    }

    private void init(Cylinder3DT cylinder) {

        int row = 0;
        var label = new Label("Origin");
        label.setTooltip(new Tooltip("Cylinder anchor position."));
        gridPane.add(label, 0, row);
        var group = createOrRebind(null, cylinder.getOrigin(), true);
        gridPane.add(group, 1, row++, 3, 1);

        label = new Label("Axis");
        label.setTooltip(new Tooltip("The cylinder's axis"));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, cylinder.getAxis(), true);
        gridPane.add(group, 1, row++, 3, 1);

        label = new Label("Height");
        label.setTooltip(new Tooltip("Cylinder height relative to origin."));
        gridPane.add(label, 0, row);
        group = createOrRebind(null, cylinder.getHeight(), true);
        gridPane.add(group, 1, row++);


    }

    private void init(NURBSSurfaceT nurbsSurface) {

        int row = 0;

        var  label = new Label("NURBS Properties");
        label.setTooltip(new Tooltip("Properties of the basis function in U and V direction."));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        if ( nurbsSurface.getUNURBSproperties() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No U NurbsProperties found!",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            gridPane.add(label, 0, row++, 4, 1);

            nurbsSurface.setUNURBSproperties( new NURBSPropertiesT() );
        }

        if ( nurbsSurface.getVNURBSproperties() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No V NurbsProperties found!",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            gridPane.add(label, 0, row++, 4, 1);

            nurbsSurface.setVNURBSproperties( new NURBSPropertiesT() );
        }

        var uProps = nurbsSurface.getUNURBSproperties();
        var vProps = nurbsSurface.getVNURBSproperties();

        label = new Label("U Degree");
        label.setTooltip(new Tooltip("The degree of the NURBS surface in U direction."));
        gridPane.add(label, 0, row);
        var text  = new TextField(Integer.toString(uProps.getDegree()));
        gridPane.add(text, 1, row);

        label = new Label("V Degree");
        label.setTooltip(new Tooltip("The degree of the NURBS surface in V direction."));
        gridPane.add(label, 2, row);
        text  = new TextField(Integer.toString(vProps.getDegree()));
        gridPane.add(text, 3, row++);

        label = new Label("Number of Control Points U");
        label.setTooltip(new Tooltip("Number of control points in the curve direction or the surface grid U-direction."));
        gridPane.add(label, 0, row);
        text  = new TextField(Long.toString(uProps.getNumCtrlPts()));
        gridPane.add(text, 1, row);

        label = new Label("Number of Control Points V");
        label.setTooltip(new Tooltip("Number of control points in the curve direction or the surface grid V-direction."));
        gridPane.add(label, 2, row);
        text  = new TextField(Long.toString(vProps.getNumCtrlPts()));
        gridPane.add(text, 3, row++);


        label = new Label("Number Knots U");
        label.setTooltip(new Tooltip("umKnots: m=(p+n-1) numbers, where p is the polynomial basis degree and n is the number of control points."));
        gridPane.add(label, 0, row);
        text  = new TextField(Long.toString(uProps.getNumKnots()));
        gridPane.add(text, 1, row);

        label = new Label("Number Knots U");
        label.setTooltip(new Tooltip("numKnots: m=(p+n-1) numbers, where p is the polynomial basis degree and n is the number of control points."));
        gridPane.add(label, 2, row);
        text  = new TextField(Long.toString(vProps.getNumKnots()));
        gridPane.add(text, 3, row++);

        label = new Label("Curve Form U");
        label.setTooltip(new Tooltip("The NURBS curve form (Open, Closed, or Periodic)."));
        gridPane.add(label, 0, row);
        text  = new TextField(uProps.getForm().toString());
        gridPane.add(text, 1, row);

        label = new Label("Curve Form V");
        label.setTooltip(new Tooltip("The NURBS curve form (Open, Closed, or Periodic)."));
        gridPane.add(label, 2, row);
        text  = new TextField(uProps.getForm().toString());
        gridPane.add(text, 3, row++);

        label = new Label("Rational U");
        label.setTooltip(new Tooltip("The default is non-rational basis functions (isRational=false).\n" +
                "Rational refers to the underlying mathematical representation.\n" +
                "This property allows NURBS to represent exact conics (such as parabolic curves, circles, and ellipses)\n" +
                "in addition to free-form curves. To define conical curve types set isRational=true."));
        gridPane.add(label, 0, row);
        var cb  = new CheckBox();
        cb.setSelected( uProps.isIsRational());
        gridPane.add(cb, 1, row);

        label = new Label("Curve Form V");
        label.setTooltip(new Tooltip("The default is non-rational basis functions (isRational=false).\n" +
                "Rational refers to the underlying mathematical representation.\n" +
                "This property allows NURBS to represent exact conics (such as parabolic curves, circles, and ellipses)\n" +
                "in addition to free-form curves. To define conical curve types set isRational=true."));
        gridPane.add(label, 2, row);
        cb =         new CheckBox();
        cb.setSelected( vProps.isIsRational());
        gridPane.add(cb, 3, row++);


    }

}
