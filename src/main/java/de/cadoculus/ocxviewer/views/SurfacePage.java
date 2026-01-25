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
import de.cadoculus.ocxviewer.models.ControlPointRecord;
import de.cadoculus.ocxviewer.utils.GeomHelper;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import oasis.unitsml.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignB;
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

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        gridPane = createDefaultGrid();
        scrollPane.setContent(  gridPane);

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

    /**
     * Create the page for a NURBSSurface
     * @param nurbsSurface the surface cast as a {@link NURBSSurfaceT}
     */
    private void init(NURBSSurfaceT nurbsSurface) {

        try {
            GeomHelper.checkNURBS( nurbsSurface);
        } catch (IllegalArgumentException exp) {
            var warning = new atlantafx.base.controls.Message(
                    "Error",
                    exp.getMessage(),
                    new FontIcon(MaterialDesignB.BOMB)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, row++, 4, 1);
        }


        if ( nurbsSurface.getUNURBSproperties() == null) {
            nurbsSurface.setUNURBSproperties( new NURBSPropertiesT() );
        }

        if ( nurbsSurface.getVNURBSproperties() == null) {
            nurbsSurface.setVNURBSproperties( new NURBSPropertiesT() );
        }

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


        // Knotvectors
        label = new Label("Knotvector");
        label.setTooltip( new Tooltip("""
                The knot-vector is a list of size m=+n-1 knots where p is the polynomial basis degree
                and n is the number of control points.
                The knot vector consists of a non-decreasing sequence of values.
                Knot multiplicities can be included.
                A knot multiplicity means that a knot value can be repeated up to p+1 times.
                """));
        gridPane.add(label, 0, row);
        final  StringBuilder sb = new StringBuilder();
        nurbsSurface.getUknotVector().getValues().forEach(d -> {
            sb.append( d.toString()).append(" ");
        });

        var knot = new TextField(sb.toString());
        //knot.setWrapText(true);
        gridPane.add(knot, 1, row);

        // the Duplicator class from fxd is gone :-(
        var label2 = new Label(label.getText());
        label2.setTooltip( new Tooltip( label.getTooltip().getText()));
        gridPane.add(label2, 2, row);
        final var sb2 = new StringBuilder();
        nurbsSurface.getVknotVector().getValues().forEach(d -> {
            sb2.append( d.toString()).append(" ");
        });

        knot = new TextField(sb2.toString());
        //knot.setWrapText(true);
        gridPane.add(knot, 3, row++);

        var tabPane = new TabPane();
        gridPane.add(tabPane, 0, row++, 4,1);

        // ensure the last row gets all available space
        for ( int r =0; r< GridPane.getRowIndex(tabPane); r++) {
            gridPane.getRowConstraints().add(new RowConstraints());
        }
        var tableRow = new RowConstraints();
        tableRow.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().add( tableRow);



        // The control points table
        var ctrlPtsTab = new Tab("Control Points");
        ctrlPtsTab.setClosable(false);
        tabPane.getTabs().add(ctrlPtsTab);
        ctrlPtsTab.setTooltip(new Tooltip("The control points defining the surface's geometry."));


        var tableColumnIdx = new TableColumn<ControlPointRecord, String>("Index");
        tableColumnIdx.setCellValueFactory(c -> new SimpleStringProperty(
                Long.toString(  c.getValue().index())));
        tableColumnIdx.setStyle( "-fx-alignment: CENTER-RIGHT;");

        var tableColumnRC = new TableColumn<ControlPointRecord, String>("Row/Column");
        tableColumnRC.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().row() + ":" + c.getValue().colum()));


        var tableColumnX = new TableColumn<ControlPointRecord, Number>("X");
        tableColumnX.setCellValueFactory(c -> new SimpleDoubleProperty( c.getValue().controlPoint().getCoordinates().getFirst()));

        var tableColumnY = new TableColumn<ControlPointRecord, Number>("Y");
        tableColumnY.setCellValueFactory(c -> new SimpleDoubleProperty( c.getValue().controlPoint().getCoordinates().get(1)));

        var tableColumnZ = new TableColumn<ControlPointRecord, Number>("Z");
        tableColumnZ.setCellValueFactory(c -> new SimpleDoubleProperty( c.getValue().controlPoint().getCoordinates().getLast()));

        var tableColumnUnit = new TableColumn<ControlPointRecord, String>("Unit");
        tableColumnUnit.setCellValueFactory(c -> {
            if ( c.getValue().controlPoint().getUnit() instanceof Unit unit) {
                return new SimpleStringProperty( unit.getId());
            } else if ( c.getValue().controlPoint().getUnit() != null) {
                return new SimpleStringProperty("failed to resolve '" + c.getValue().controlPoint().getUnit().toString() + "'");
            } else {
                return new SimpleStringProperty("!!unit reference missing!!");
            }

        });

        var tableColumnWeight = new TableColumn<ControlPointRecord, Number>("Weight");
        tableColumnWeight.setCellValueFactory(c -> new SimpleDoubleProperty( c.getValue().controlPoint().getWeight()));

        ObservableList<ControlPointRecord> ctrlPoints = FXCollections.observableArrayList();
        var table = new TableView<>(ctrlPoints);
        ctrlPtsTab.setContent(table);

        table.getColumns().setAll(tableColumnIdx, tableColumnRC, tableColumnX, tableColumnY, tableColumnZ, tableColumnUnit, tableColumnWeight);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1600);



        // now fill the control points
        final long numCtrlPtsU = nurbsSurface.getUNURBSproperties().getNumCtrlPts();
        int ctrlPtIdx=0;
        for (ControlPtList controlPtList : nurbsSurface.getControlPtLists()) {
            for (ControlPoint controlPoint : controlPtList.getControlPoints()) {
                final long rowNum = ctrlPtIdx / numCtrlPtsU;
                final long colNum = ctrlPtIdx % numCtrlPtsU;
                ctrlPoints.add( new ControlPointRecord( ctrlPtIdx, rowNum, colNum, controlPoint));
                ctrlPtIdx++;
            }
        }


    }

}
