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

import de.cadoculus.ocxviewer.models.SurfaceRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import jakarta.xml.bind.JAXBElement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310rc3.CoordinateSystem;
import org.ocx_schema.v310rc3.SurfaceCollection;
import org.ocx_schema.v310rc3.SurfaceT;

/**
 * This class displays the reference surfaces contained in the OCX file
 */
public class ReferenceSurfacesPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Reference Surfaces";
    private static final Logger LOG = LogManager.getLogger(ReferenceSurfacesPage.class);

    private final TableView<SurfaceRecord> table;
    private final GridPane gridPane;
    private final Label barLabel = new Label();
    private final ObjectProperty<SurfaceRecord> selectedObject = new SimpleObjectProperty<>();

    public ReferenceSurfacesPage() {
        super(NAME);

        createTitle("Information about the contained coordinate systems.");

        gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.LEFT);
        col1.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(col1);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(200);
        row1.setVgrow(Priority.SOMETIMES);

        RowConstraints row2 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);

        RowConstraints row3 = new RowConstraints();
        row3.setFillHeight(true);
        row3.setVgrow(Priority.ALWAYS);
        row3.setMinHeight(300);
        row3.setVgrow(Priority.ALWAYS);

        gridPane.getRowConstraints().addAll(row1, row2, row3);
        //gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var tableColumn1 = new TableColumn<SurfaceRecord, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().id())
        );

        var tableColumn2 = new TableColumn<SurfaceRecord, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().guid())
        );

        var tableColumn3 = new TableColumn<SurfaceRecord, Boolean>("Collection");
        tableColumn3.setCellValueFactory(
                c -> new SimpleBooleanProperty(c.getValue().isCollection())
        );


        ObservableList<SurfaceRecord> surfaces = FXCollections.observableArrayList();
        table = new TableView<SurfaceRecord>(surfaces);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(200);
        int row = 0;

        gridPane.add(table, 0, row++);
        gridPane.add(barLabel, 0, row++);

        final var vessel = WorkingContext.getInstance().getVessel();
        if (vessel == null) {
            LOG.info("no vessel found");
            return;
        }
        if (vessel.getReferenceSurfaces() == null) {
            LOG.info("no Reference Surfaces found in OCX file");
            return;
        }
        for (JAXBElement<? extends SurfaceT> jaxbElement: vessel.getReferenceSurfaces().getSurfaces()) {
            if (jaxbElement.getValue() instanceof SurfaceT surface) {
                surfaces.add(SurfaceRecord.create(surface));
            }
        }
        for (SurfaceCollection collection: vessel.getReferenceSurfaces().getSurfaceCollections()) {
                surfaces.add(SurfaceRecord.create(collection));
        }

        LOG.debug("found #{} surfaces and surface collection", surfaces.size());

        table.getSelectionModel().selectedItemProperty().addListener((_, oldSurfaceRec, newSurfaceRec) -> updateSurface(oldSurfaceRec, newSurfaceRec));

    }

    private void updateSurface(SurfaceRecord oldSurfaceRec, SurfaceRecord newSurfaceRec) {
    }

    @Override
    public void afterShow() {

        table.getSelectionModel().selectFirst();
    }

   

}
