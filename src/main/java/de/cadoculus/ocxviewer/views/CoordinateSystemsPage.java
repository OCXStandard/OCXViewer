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
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
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
import org.ocx_schema.v310.*;

import java.util.ArrayList;

/**
 * This class displays the coordinated system contained in the OCX file
 * @author Carsten Zerbst
 */
public class CoordinateSystemsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Coordinate Systems";
    private static final Logger LOG = LogManager.getLogger(CoordinateSystemsPage.class);

    public CoordinateSystemsPage() {
        super(NAME);

        createTitle("Information about the contained coordinate systems.");

        GridPane gridPane = createDefaultGrid();
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var tableColumn1 = new TableColumn<CoordinateSystem, CoordinateSystem>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory( createHyperlinkCellfactory( this::selectCoordinateSystem));

        var tableColumn2 = new TableColumn<CoordinateSystem, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<CoordinateSystem, Boolean>("Global");
        tableColumn3.setCellValueFactory(
                c -> new SimpleBooleanProperty(c.getValue().isIsGlobal())
        );

        ObservableList<CoordinateSystem> coordinateSystems = FXCollections.observableArrayList();
        TableView<CoordinateSystem> table = new TableView<>(coordinateSystems);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(50);
        table.setMaxHeight(200);

        int row = 0;
        gridPane.add(table, 0, row++, 4,1);

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

    }

    private void selectCoordinateSystem( CoordinateSystem newCosys) {
        LOG.info("selected Coordinate System section {}", newCosys);
        if (newCosys == null) {
            return;
        }

        var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
        robert.add( new BreadcrumbRecord(newCosys.getId(), CoordinateSystemPage.class, null, newCosys));
        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);

    }

    @Override
    public void afterShow() {
        // Party !
    }



}
