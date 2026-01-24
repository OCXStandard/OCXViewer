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

import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.utils.GeomHelper;
import jakarta.xml.bind.JAXBElement;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.DescriptionBaseT;
import org.ocx_schema.v310.SurfaceCollection;
import org.ocx_schema.v310.SurfaceT;

import java.util.ArrayList;

/**
 * A page displaying information about a Surface.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the ReferenceSurfacesPage
 * @author Carsten Zerbst
 */
public class SurfaceCollectionPage extends AbstractDataViewSubPage<org.ocx_schema.v310.SurfaceCollection> {
    public static final String NAME = "Surface Collection";
    private static final Logger LOG = LogManager.getLogger(SurfaceCollectionPage.class);
    private final TableView<DescriptionBaseT> table;

    public SurfaceCollectionPage(org.ocx_schema.v310.SurfaceCollection collection, Page parent) {
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



        var tableColumn1 = new TableColumn<DescriptionBaseT, DescriptionBaseT>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<DescriptionBaseT>( c.getValue()));
        tableColumn1.setCellFactory( createHyperlinkCellfactory(this::selectedSurface));

        var tableColumn2 = new TableColumn<DescriptionBaseT, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue() instanceof SurfaceT ? ((SurfaceT)c.getValue()).getGUIDRef() : ((SurfaceCollection)c.getValue()).getGUIDRef())
        );

        var tableColumn3 = new TableColumn<DescriptionBaseT, String>("Type");
        tableColumn3.setCellValueFactory( cell ->
                new SimpleStringProperty(GeomHelper.getGeometryType(cell.getValue())));


        ObservableList<DescriptionBaseT> surfaces = FXCollections.observableArrayList();
        table = new TableView<DescriptionBaseT>(surfaces);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(600);

        setCenter(table);

        // now populate the table
        for (JAXBElement<? extends SurfaceT> jaxbElement: getObject().getSurfaces()) {
            if (jaxbElement.getValue() instanceof SurfaceT surface) {
                surfaces.add(surface);
            }
        }
    }

    private void selectedSurface(DescriptionBaseT selected) {
        LOG.debug("selected surface {}", selected);
        if ( selected ==null) {
            // no change
            return;
        }

        var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());

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
