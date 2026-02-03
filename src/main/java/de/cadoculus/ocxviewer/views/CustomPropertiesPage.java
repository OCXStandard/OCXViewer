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

import atlantafx.base.controls.CustomTextField;
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
import org.ocx_schema.v310.CustomProperty;
import org.ocx_schema.v310.IdBaseT;

/**
 * A page displaying the CustomProperties attached to an IdBaseT.
 * The CustomPropertiesPage is not intended to be navigated directly, but rather as a logical child to an IdBaseT details page.
 *
 * @author Carsten Zerbst
 */
public class CustomPropertiesPage extends AbstractDataViewSubPage<IdBaseT> {
    public static final String NAME = "Custom Properties";
    private static final Logger LOG = LogManager.getLogger(CustomPropertiesPage.class);
   private final  ObservableList<CustomProperty> customProperties = FXCollections.observableArrayList();
    private final  FilteredList<CustomProperty> filteredCustomProperties = new FilteredList<>(customProperties, p -> true);

    public CustomPropertiesPage(IdBaseT idBaseT, Page parent) {
        super(idBaseT, parent, "Custom Properties of  «" + idBaseT.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Custom Properties");

        //
        // Define the table
        //
        var vbox = new VBox();
        setCenter(vbox);

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Propertes by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) -> filterProperty(newValue));

        var tableColumn1 = new TableColumn<CustomProperty, String>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));

        var tableColumn2 = new TableColumn<CustomProperty, String>("Name");
        tableColumn2.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));

        var tableColumn3 = new TableColumn<CustomProperty, String>("Value");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getValue()));


        var tableColumn4 = new TableColumn<CustomProperty, String>("Unit");
        tableColumn4.setCellValueFactory(cell -> new SimpleStringProperty(getUnitDisplayValue(cell.getValue().getUnit())));


        TableView<CustomProperty> table = new TableView<CustomProperty>(filteredCustomProperties);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        // load the data
        if ( idBaseT.getCustomProperties() != null) {
            customProperties.addAll(idBaseT.getCustomProperties().getCustomProperties());
        }

        LOG.debug("found #{} properties ", customProperties.size());
    }

    private void filterProperty(String newValue) {
        filteredCustomProperties.setPredicate(property -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (property.getName() != null && property.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches name
            } else if (property.getId() != null && property.getId().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches id
            }
            return false; // Does not match
        });
    }

}
