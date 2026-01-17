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
import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;
import org.ocx_schema.v310.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class displays the materials contained in the OCX file
 *
 * @author Carsten Zerbst
 */
public class MaterialCataloguePage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Material Catalogue";
    private static final Logger LOG = LogManager.getLogger(MaterialCataloguePage.class);


    private final TableView<Material> table;
    private final ObservableList<Material> materials = FXCollections.observableArrayList();
    private final FilteredList<Material> filteredMaterials = new FilteredList<>(materials, p -> true);

    public MaterialCataloguePage() {
        super(NAME);

        createTitle("Display the content of the material catalogue.");

        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        col2.setHgrow(Priority.ALWAYS);
        col2.setMaxWidth(500);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHalignment(HPos.LEFT);
        col4.setHgrow(Priority.ALWAYS);
        col4.setMaxWidth(600);
        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);


        //gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var vbox = new VBox();
        setCenter(vbox);

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Material by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredMaterials.setPredicate(material -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (material.getName() != null && material.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (material.getId() != null && material.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });

        // the columns
        var tableColumn1 = new TableColumn<Material, Material>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<Material>( c.getValue()));
        tableColumn1.setCellFactory( createHyperlinkCellfactory( this::selectedMaterial));

        var tableColumn2 = new TableColumn<Material, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<Material, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(  c.getValue().getName()));

        var tableColumn4 = new TableColumn<Material, String>("Grade");
        tableColumn4.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGrade())
        );

        // the table itself
        table = new TableView<>(filteredMaterials);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(200);

        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();

        if (ocx.getClassCatalogue() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No ClassCatalogue found in /ocx:ocxXML/ocx:ClassCatalogue !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            vbox.getChildren().add(warning);

            WorkingContext.getInstance().getOcx().setClassCatalogue(new ClassCatalogue());
        }

        if (ocx.getClassCatalogue().getMaterialCatalogue() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No MaterialCatalogue found in /ocx:ocxXML/ocx:ClassCatalogue/ocx:MaterialCatalogue !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            vbox.getChildren().add(warning);

            WorkingContext.getInstance().getOcx().getClassCatalogue().setMaterialCatalogue(new MaterialCatalogue());
        }

        if (ocx.getClassCatalogue().getMaterialCatalogue().getMaterials() == null ||
                ocx.getClassCatalogue().getMaterialCatalogue().getMaterials().isEmpty()) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No Material found in /ocx:ocxXML/ocx:ClassCatalogue/ocx:MaterialCatalogue !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            vbox.getChildren().add(warning);

            WorkingContext.getInstance().getOcx().getClassCatalogue().setMaterialCatalogue(new MaterialCatalogue());
        }

        if (ocx.getClassCatalogue().getMaterialCatalogue().getMaterials() != null) {
            materials.addAll(ocx.getClassCatalogue().getMaterialCatalogue().getMaterials());
            LOG.debug("found #{} materials", materials.size());
        }

        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);



    }

    private void filterMaterial(String newValue) {
        filteredMaterials.setPredicate( material -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (material.getName() != null && material.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches name
            }
            else if (material.getId() != null && material.getId().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches id
            }
            return false; // Does not match
        });
    }

    private void selectedMaterial(Material selected) {
        LOG.debug("selected material {}", selected);
        if ( selected ==null) {
            // no change
            return;
        }

        var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
        robert.add( new BreadcrumbRecord(selected.getId(), MaterialPage.class, null, selected));

        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);
    }


}
