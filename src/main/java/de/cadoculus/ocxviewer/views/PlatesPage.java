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

import atlantafx.base.controls.CustomTextField;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;
import org.ocx_schema.v310.Plate;

import java.util.ArrayList;


/**
 * This class displays the plates directly contained in the OCX file's Vessel.
 * @author Carsten Zerbst
 */
public class PlatesPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Plates";
    private static final Logger LOG = LogManager.getLogger(PlatesPage.class);

    private final TableView<Plate> table;
    private final ObservableList<Plate> plates = FXCollections.observableArrayList();
    private final FilteredList<Plate> filteredPlates = new FilteredList<>(plates, p -> true);

    public PlatesPage() {
        super(NAME);


        // the content
        final var vessel = WorkingContext.getInstance().getVessel();
        if (vessel == null) {
            LOG.info("no vessel found");
        } else if (vessel.getPlates() == null) {
            LOG.info("no Plates found in OCX file's vessel");
        } else {
            plates.addAll(vessel.getPlates());
        }

        createTitle("An overview on the #" + plates.size() + " contained directly in the Vessel.");

        //
        // Define the table
        //
        var vbox = new VBox();
        setCenter(vbox);



        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Plate by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredPlates.setPredicate(plate -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (plate.getName() != null && plate.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                }
                else if (plate.getId() != null && plate.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.Plate, org.ocx_schema.v310.Plate>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<org.ocx_schema.v310.Plate>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            LOG.debug("selected plate {}", selected);
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), PlatePage.class, null, selected));

            var event = new SelectionEvent( robert);
            DefaultEventBus.getInstance().publish(event);

        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.Plate, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.Plate, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        // TODO: better material representation
        var tableColumn4 = new TableColumn<org.ocx_schema.v310.Plate, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getPlateMaterial().getLocalRef().toString()));

        // TOD: add thickness unit

        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<org.ocx_schema.v310.Plate, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        table = new TableView<org.ocx_schema.v310.Plate>(filteredPlates);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);



    }

    private void filterPlate(String newValue) {
        filteredPlates.setPredicate(panel -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (panel.getName() != null && panel.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches name
            }
            else if (panel.getId() != null && panel.getId().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches id
            }
            return false; // Does not match
        });
    }

    private void selectedPanel(Plate selected) {
        LOG.debug("selected plate {}", selected);
        if ( selected ==null) {
            // no change
            return;
        }

        var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
        robert.add( new BreadcrumbRecord(selected.getId(), PlatePage.class, null, selected));

        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);
    }

    @Override
    public void afterShow() {

       // Party !
    }



}




