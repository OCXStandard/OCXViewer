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

import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.utils.GeomHelper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.*;

/**
 * A page displaying information about a Surface.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the ReferenceSurfacesPage
 *
 * @author Carsten Zerbst
 */
public class SurfacePage extends AbstractDataViewSubPage<SurfaceT> {
    public static final String NAME = "Surface";
    private static final Logger LOG = LogManager.getLogger(SurfacePage.class);
    private final GridPane gridPane;
    private int row = 0;

    public SurfacePage(SurfaceT surface, Page parent) {
        super(surface, parent, GeomHelper.getGeometryType(surface) + " «" + surface.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX " +GeomHelper.getGeometryType(surface));

        gridPane = createDefaultGrid();
        setCenter(gridPane);

        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


        var label = new Label("Id");
        label.setTooltip(new Tooltip("The surface's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), surface, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The surface's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), surface, "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The surface's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), surface, "GUIDRef", String.class);


        switch (surface) {
            case NURBSSurfaceT nurbsSurface -> init(nurbsSurface);
            case Cylinder3DT cylinder -> init(cylinder);
            case Cone3DT nurbsSurface -> init(nurbsSurface);
            case Sphere3DT sphere -> init(sphere);
            case ExtrudedSurfaceT nurbsSurface -> init(nurbsSurface);
            case Plane3DT plane -> init(plane);
            default -> {
                LOG.warn("found unsupported Surface type: {}", surface.getClass().getName());

                var warning = new atlantafx.base.controls.Message(
                        "Warning",
                        "Not implemented yet",
                        new FontIcon(MaterialDesignA.ALERT)
                );
                warning.getStyleClass().add(Styles.WARNING);

                setCenter(warning);
            }
        }

    }

    private void init(Plane3DT plane) {

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



        var  label = new Label("NURBS Properties U");
        label.setTooltip(new Tooltip("Properties of the basis function in U direction."));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row,2,1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        label = new Label("NURBS Properties V");
        label.setTooltip(new Tooltip("Properties of the basis function in V direction."));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 2, row++,2,1);
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

        label = new Label("Degree");
        label.setTooltip(new Tooltip("The degree of the NURBS surface in U direction."));
        gridPane.add(label, 0, row);
        var text  = new TextField(Integer.toString(uProps.getDegree()));
        gridPane.add(text, 1, row);

        label = new Label("Degree");
        label.setTooltip(new Tooltip("The degree of the NURBS surface in V direction."));
        gridPane.add(label, 2, row);
        text  = new TextField(Integer.toString(vProps.getDegree()));
        gridPane.add(text, 3, row++);

        label = new Label("Number of Control Points");
        label.setTooltip(new Tooltip("Number of control points in the curve direction or the surface grid U-direction."));
        gridPane.add(label, 0, row);
        text  = new TextField(Long.toString(uProps.getNumCtrlPts()));
        gridPane.add(text, 1, row);

        label = new Label("Number of Control Points");
        label.setTooltip(new Tooltip("Number of control points in the curve direction or the surface grid V-direction."));
        gridPane.add(label, 2, row);
        text  = new TextField(Long.toString(vProps.getNumCtrlPts()));
        gridPane.add(text, 3, row++);


        label = new Label("Number Knots");
        label.setTooltip(new Tooltip("umKnots: m=(p+n-1) numbers, where p is the polynomial basis degree and n is the number of control points."));
        gridPane.add(label, 0, row);
        text  = new TextField(Long.toString(uProps.getNumKnots()));
        gridPane.add(text, 1, row);

        label = new Label("Number Knots");
        label.setTooltip(new Tooltip("numKnots: m=(p+n-1) numbers, where p is the polynomial basis degree and n is the number of control points."));
        gridPane.add(label, 2, row);
        text  = new TextField(Long.toString(vProps.getNumKnots()));
        gridPane.add(text, 3, row++);

        label = new Label("Curve Form");
        label.setTooltip(new Tooltip("The NURBS curve form (Open, Closed, or Periodic)."));
        gridPane.add(label, 0, row);
        text  = new TextField(uProps.getForm().toString());
        gridPane.add(text, 1, row);

        label = new Label("Curve Form");
        label.setTooltip(new Tooltip("The NURBS curve form (Open, Closed, or Periodic)."));
        gridPane.add(label, 2, row);
        text  = new TextField(uProps.getForm().toString());
        gridPane.add(text, 3, row++);

        label = new Label("Rational");
        label.setTooltip(new Tooltip("""
                The default is non-rational basis functions (isRational=false).
                Rational refers to the underlying mathematical representation.
                This property allows NURBS to represent exact conics (such as parabolic curves, circles, and ellipses)
                in addition to free-form curves. To define conical curve types set isRational=true."""));
        gridPane.add(label, 0, row);
        var cb  = new CheckBox();
        cb.setSelected( uProps.isIsRational());
        gridPane.add(cb, 1, row);

        label = new Label("Rational");
        label.setTooltip(new Tooltip("""
                The default is non-rational basis functions (isRational=false).
                Rational refers to the underlying mathematical representation.
                This property allows NURBS to represent exact conics (such as parabolic curves, circles, and ellipses)
                in addition to free-form curves. To define conical curve types set isRational=true."""));
        gridPane.add(label, 2, row);
        cb =         new CheckBox();
        cb.setSelected( vProps.isIsRational());
        gridPane.add(cb, 3, row++);


    }

}
