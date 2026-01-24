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
import org.ocx_schema.v310.Panel;

import java.util.ArrayList;


/**
 * This class displays the panels contained in the OCX file.
 * @author Carsten Zerbst
 */
public class PanelsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Panels";
    private static final Logger LOG = LogManager.getLogger(PanelsPage.class);

    private final TableView<org.ocx_schema.v310.Panel> table;
    private final ObservableList<org.ocx_schema.v310.Panel> panels = FXCollections.observableArrayList();
    private final FilteredList<Panel> filteredPanels = new FilteredList<>(panels, p -> true);

    public PanelsPage() {
        super(NAME);


        // the content

        final var vessel = WorkingContext.getInstance().getVessel();
        if (vessel == null) {
            LOG.info("no vessel found");
        } else if (vessel.getPanels() == null) {
            LOG.info("no Panels found in OCX file");
        } else {
            panels.addAll(vessel.getPanels());
        }

        createTitle("An overview on the #" + panels.size() + " contained Panels.");

        //
        // Define the table
        //
        var vbox = new VBox();
        setCenter(vbox);

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10,0,10,0));
        filterText.setPromptText("search Panel by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) -> filterPanel(newValue));

        var tableColumn1 = new TableColumn<Panel,Panel>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<Panel>( c.getValue()));
        tableColumn1.setCellFactory( createHyperlinkCellfactory( this::selectedPanel));

        var tableColumn2 = new TableColumn<Panel, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(  c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<Panel, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(  c.getValue().getName()));


        var tableColumn4 = new TableColumn<Panel, String>("Function");
        tableColumn4.setCellValueFactory( cell ->
                        new SimpleStringProperty(cell.getValue().getFunctionType()));

        var tableColumn5 = new TableColumn<Panel, String>("Tightness");
        tableColumn5.setCellValueFactory( cell ->
                new SimpleStringProperty(cell.getValue().getTightness()));


        table = new TableView<Panel>(filteredPanels);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);
        int row = 0;




        LOG.debug("found #{} panels ", panels.size());

    }

    private void filterPanel(String newValue) {
        filteredPanels.setPredicate( panel -> {
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

    private void selectedPanel(Panel selected) {
        LOG.debug("selected panel {}", selected);
        if ( selected ==null) {
            // no change
            return;
        }

        var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
        robert.add( new BreadcrumbRecord(selected.getId(), PanelPage.class, null, selected));

        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);
    }

    @Override
    public void afterShow() {

       // Party !
    }



}




