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
package de.cadoculus.ocxviewer.views;

import atlantafx.base.layout.InputGroup;
import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310rc3.*;

import java.util.ArrayList;

/**
 * This class displays the coordinated system contained in the OCX file
 */
public class CoordinateSystemsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Coordinate Systems";
    private static final Logger LOG = LogManager.getLogger(CoordinateSystemsPage.class);

    private final TableView<CoordinateSystem> table;
    private final GridPane gridPane;
    private final Label label = new Label();
    private final ObjectProperty<CoordinateSystem> selectedObject = new SimpleObjectProperty<>();

    private final InputGroup originGroup;
    private final InputGroup primAxisGroup;
    private final InputGroup secAxisGroup;

    public CoordinateSystemsPage() {
        super(NAME);

        createTitle("Information about the contained coordinate systems.");

        gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        col2.setHgrow(Priority.ALWAYS);
        col2.setMaxWidth(600);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHalignment(HPos.LEFT);
        col4.setHgrow(Priority.ALWAYS);
        col4.setMaxWidth(600);

        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);
        gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var tableColumn1 = new TableColumn<CoordinateSystem, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getId())
        );

        var tableColumn2 = new TableColumn<CoordinateSystem, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<CoordinateSystem, Boolean>("Global");
        tableColumn3.setCellValueFactory(
                c -> new SimpleBooleanProperty(c.getValue().isIsGlobal())
        );


        ObservableList<CoordinateSystem> coordinateSystems = FXCollections.observableArrayList();
        table = new TableView<CoordinateSystem>(coordinateSystems);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(50);
        table.setMaxHeight(200);

        int row = 0;

        gridPane.add(table, 0, row++, 4,1);
        gridPane.add(label, 0, row++);
        label.getStyleClass().add(Styles.TITLE_3);

        var label = new Label("Local Cartesian");
        label.setTooltip(new Tooltip("To specify a Local (Orthogonal) Axis System Origin and two of the local X,Y,Z axis need to be specified. When used to specify a Plane the XY (UV) plane is considered. Optional if the coordinate system is referring to the global coordinate frame (world coordinates)"));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        label = new Label("Origin");
        label.setTooltip(new Tooltip("The origin of a local or global coordinate system."));
        gridPane.add(label, 0, ++row);
        originGroup = createOrRebind(null, (Point3DT) null, true);
        gridPane.add(originGroup, 1,row);


        label = new Label("Primary Axis");
        label.setTooltip(new Tooltip("The unit vector of the local X-axis (U-Axis) given in global Coordinate System."));
        gridPane.add(label, 0, ++row);
        primAxisGroup = createOrRebind(null, (Point3DT) null, true);
        gridPane.add(primAxisGroup, 1, row);

        label = new Label("Secondary Axis");
        label.setTooltip(new Tooltip("The unit vector of the local Y-axis (V-Axis) given in global Coordinate System."));
        gridPane.add(label, 2, row);
        secAxisGroup = createOrRebind(null, (Point3DT) null, true);
        gridPane.add(secAxisGroup, 3, row);


        label = new Label("X References Planes");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));


        label = new Label("Y References Planes");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));


        label = new Label("Y References Planes");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));


        final var vessel = WorkingContext.getInstance().getVessel();
        if (vessel == null) {
            LOG.info("no vessel found");
            return;
        }
        if (vessel.getCoordinateSystems() == null) {
            LOG.info("no CoordinateSystems found in OCX file");
            return;
        }

        coordinateSystems.addAll( vessel.getCoordinateSystems());

        LOG.debug("found #{} coordinate systems", coordinateSystems.size());

        table.getSelectionModel().selectedItemProperty().addListener((_, oldCosys, newCosys) -> updateCoordinateSystem(oldCosys, newCosys));

    }

    private void updateCoordinateSystem(CoordinateSystem oldCosys, CoordinateSystem newCosys) {


        LOG.info("Updating Coordinate System section {}", newCosys);
        selectedObject.setValue(newCosys);
        if (newCosys == null) {
            label.setText("No CoordinateSystem selected");
            return;
        }

        label.setText( "Coordinate System " +  newCosys.getId() );
        LOG.debug(" (" + newCosys.getGUIDRef() + ") + " + new ArrayList(newCosys.getLocalCartesian().getOrigin().getCoordinates()).toString());


        createOrRebind( originGroup, newCosys.getLocalCartesian().getOrigin(), true);
        createOrRebind( primAxisGroup, newCosys.getLocalCartesian().getPrimaryAxis(), true);
        createOrRebind(secAxisGroup, newCosys.getLocalCartesian().getSecondaryAxis(), true);

    }

    @Override
    public void afterShow() {

        table.getSelectionModel().selectFirst();
    }



}
