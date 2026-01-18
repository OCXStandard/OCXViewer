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
import de.cadoculus.ocxviewer.models.SectionType;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;
import org.ocx_schema.v310.BarSection;
import org.ocx_schema.v310.OcxXMLT;

import java.util.ArrayList;

/**
 * This page shows the bar sections from the catalogue.
 * @author Carsten Zerbst
 */
public class BarSectionsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Bar Sections";
    private static final Logger LOG = LogManager.getLogger(BarSectionsPage.class);

    private final ObservableList<BarSection> barSections = FXCollections.observableArrayList();
    private final FilteredList<BarSection> filteredBarSections = new FilteredList<>(barSections, p -> true);


    public BarSectionsPage() {
        super(NAME);

        createTitle("Information about the bar sections used for stiffeners and pillars.");

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
            filteredBarSections.setPredicate(barSection -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (barSection.getName() != null && barSection.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (barSection.getId() != null && barSection.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });

        var tableColumn1 = new TableColumn<BarSection, BarSection>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>( c.getValue()));
        tableColumn1.setCellFactory( createHyperlinkCellfactory( this::selectedBarSection));

        var tableColumn2 = new TableColumn<BarSection, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<BarSection, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName())
        );

        var tableColumn4 = new TableColumn<BarSection, String>("Type");
        tableColumn4.setCellValueFactory(
                c -> new SimpleStringProperty(SectionType.getType(c.getValue()).name())
        );

        TableView<BarSection> table = new TableView<>(filteredBarSections);
        vbox.getChildren().add(table);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);

        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();
        if (ocx.getClassCatalogue() == null) {
            LOG.info("no class catalogue found");
            return;
        }
        if (ocx.getClassCatalogue().getXSectionCatalogue() == null) {
            LOG.info("no Xsections found in class catalogue");
            return;
        }

        if ( ocx.getClassCatalogue().getXSectionCatalogue().getBarSections()!= null) {
            barSections.addAll(ocx.getClassCatalogue().getXSectionCatalogue().getBarSections());
        }

        LOG.debug("found #{} bar sections", barSections.size());

    }

    /**
     * Called when a BarSection hyperlink has been selected in the table.
     * @param selected The selected BarSection
     */
    private void selectedBarSection(BarSection selected) {
        LOG.debug("selected BarSection {}", selected);
        if ( selected ==null) {
            // no change
            return;
        }

        var robert = new ArrayList<>(getBreadcrumbs());
        robert.add( new BreadcrumbRecord(selected.getId(), BarSectionPage.class, null, selected));

        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);
    }


}
