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
import org.ocx_schema.v310.DesignView;

import java.util.ArrayList;


/**
 * This class displays the design views contained in the OCX file.
 *
 * @author Carsten Zerbst
 */
public class DesignViewsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Design Views";
    private static final Logger LOG = LogManager.getLogger(DesignViewsPage.class);

    private final ObservableList<DesignView> designViews = FXCollections.observableArrayList();
    private final FilteredList<DesignView> filteredDesignViews = new FilteredList<>(designViews, p -> true);

    public DesignViewsPage() {
        super(NAME);


        // the content

        final var vessel = WorkingContext.getInstance().getVessel();
        if (vessel == null) {
            LOG.info("no vessel found");
        } else if (vessel.getPanels() == null) {
            LOG.info("no Panels found in OCX file");
        } else {
            designViews.addAll(vessel.getDesignViews());
        }

        createTitle("An overview on the #" + designViews.size() + " contained DesignViews.");

        //
        // Define the table
        //
        var vbox = new VBox();
        setCenter(vbox);

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Design View by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) -> filterPanel(newValue));

        var tableColumn1 = new TableColumn<DesignView, DesignView>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(this::selectedPanel));

        var tableColumn2 = new TableColumn<DesignView, String>("Name");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));

        var tableColumn3 = new TableColumn<DesignView, String>("Description");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getDescription()));


        TableView<DesignView> table = new TableView<>(filteredDesignViews);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);


        LOG.debug("found #{} DesignViews ", designViews.size());

    }

    private void filterPanel(String newValue) {
        filteredDesignViews.setPredicate(panel -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (panel.getName() != null && panel.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches name
            } else if (panel.getId() != null && panel.getId().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches id
            }
            return false; // Does not match
        });
    }

    private void selectedPanel(DesignView selected) {
        LOG.debug("selected design views {}", selected);
        if (selected == null) {
            // no change
            return;
        }

        var robert = new ArrayList<>(getBreadcrumbs());
        robert.add(new BreadcrumbRecord(selected.getId(), DesignViewPage.class, null, selected));

        var event = new SelectionEvent(robert);
        DefaultEventBus.getInstance().publish(event);
    }



}




