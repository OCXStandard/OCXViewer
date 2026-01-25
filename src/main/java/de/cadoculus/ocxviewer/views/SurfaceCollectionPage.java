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
import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.utils.GeomHelper;
import jakarta.xml.bind.JAXBElement;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;
import org.ocx_schema.v310.DescriptionBaseT;
import org.ocx_schema.v310.Panel;
import org.ocx_schema.v310.SurfaceCollection;
import org.ocx_schema.v310.SurfaceT;

import java.util.ArrayList;

/**
 * A page displaying information about a Surface.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the ReferenceSurfacesPage
 * @author Carsten Zerbst
 */
public class SurfaceCollectionPage extends AbstractDataViewSubPage<SurfaceCollection> {
    public static final String NAME = "Surface Collection";
    private static final Logger LOG = LogManager.getLogger(SurfaceCollectionPage.class);

    private final  ObservableList<DescriptionBaseT> surfaces = FXCollections.observableArrayList();
    private final FilteredList<DescriptionBaseT> filteredSurfaces = new FilteredList<>(surfaces, p -> true);

    public SurfaceCollectionPage(SurfaceCollection collection, Page parent) {
        super(collection, parent, "Surface Collection «"+collection.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();
        createTitle( bcs, getName(), "Information about an OCX Surface Collection.");


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(  gridPane);

        int row = 0;

        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


        var label = new Label("Id");
        label.setTooltip(new Tooltip("The surface collection's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), collection, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The surface collections 's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), collection, "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The surface collections's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), collection, "GUIDRef", String.class);

        //
        // the table with the contained surfaces
        //
        titelLabel = new Label("Surfaces");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10,0,10,0));
        filterText.setPromptText("search surfaces by name or type");
        gridPane.add(filterText, 0,row++,4,1);

        filterText.textProperty().addListener((observable, oldValue, newValue) -> filterSurfaces(newValue));


        var tableColumn1 = new TableColumn<DescriptionBaseT, DescriptionBaseT>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>( c.getValue()));
        tableColumn1.setCellFactory( createHyperlinkCellfactory(this::selectedSurface));

        var tableColumn2 = new TableColumn<DescriptionBaseT, String>("Name");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue() instanceof SurfaceT ? c.getValue().getName() : c.getValue().getName()));

        var tableColumn3 = new TableColumn<DescriptionBaseT, String>("GUID");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue() instanceof SurfaceT ? ((SurfaceT)c.getValue()).getGUIDRef() : ((SurfaceCollection)c.getValue()).getGUIDRef())
        );

        var tableColumn4 = new TableColumn<DescriptionBaseT, String>("Type");
        tableColumn4.setCellValueFactory( cell ->
                new SimpleStringProperty(GeomHelper.getGeometryType(cell.getValue())));


        TableView<DescriptionBaseT> table = new TableView<>(filteredSurfaces);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(600);

        gridPane.add( table, 0,row, 4, 1);

        // ensure the last row gets all available space
        for ( int r =0; r< GridPane.getRowIndex(table); r++) {
            gridPane.getRowConstraints().add(new RowConstraints());
        }
        var tableRow = new RowConstraints();
        tableRow.setVgrow(Priority.ALWAYS);;
        gridPane.getRowConstraints().add( tableRow);


        // now populate the table
        for (JAXBElement<? extends SurfaceT> jaxbElement: getObject().getSurfaces()) {
            if (jaxbElement.getValue() instanceof SurfaceT surface) {
                surfaces.add(surface);
            }
        }
    }

    private void filterSurfaces(String newValue) {
        filteredSurfaces.setPredicate( srf -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (srf.getName() != null && srf.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches name
            }
            else if (srf.getId() != null && srf.getId().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches id
            }
            else if ( GeomHelper.getGeometryType( srf).toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            return false; // Does not match
        });

    }

    private void selectedSurface(DescriptionBaseT selected) {
        LOG.debug("selected surface {}", selected);
        if ( selected ==null) {
            // no change
            return;
        }

        var robert = new ArrayList<>(getBreadcrumbs());

        if ( selected instanceof SurfaceCollection collection) {
            robert.add( new BreadcrumbRecord(collection.getId(), SurfaceCollectionPage.class, null, collection));
        } else if ( selected instanceof SurfaceT surface) {
            robert.add( new BreadcrumbRecord(surface.getId(), SurfacePage.class, null, selected));
        } else {
            LOG.warn("unhandled object type,  expect either surfaces or surface collections, got {}", selected);
            return;
        }

        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);
    }



}
