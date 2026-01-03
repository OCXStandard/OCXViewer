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

import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.SurfaceCollection;
import org.ocx_schema.v310.SurfaceT;

import java.util.ArrayList;
import java.util.List;

/**
 * This class displays the reference surfaces contained in the OCX file.
 * @author Carsten Zerbst
 */
public class ReferenceSurfacesPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Reference Surfaces";
    private static final Logger LOG = LogManager.getLogger(ReferenceSurfacesPage.class);

    private final TableView<SurfaceRecord> table;

    private final ObjectProperty<SurfaceRecord> selectedObject = new SimpleObjectProperty<>();

    public ReferenceSurfacesPage() {
        super(NAME);

        createTitle("Information about the contained coordinate systems.");


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = new GridPane();
        scrollPane.setContent(gridPane);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.LEFT);
        col1.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(col1);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(200);
        row1.setVgrow(Priority.ALWAYS);

        gridPane.getRowConstraints().addAll(row1);
        //gridPane.setGridLinesVisible(true);


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
        table.setMaxHeight(600);
        int row = 0;

        gridPane.add(table, 0, row++);

        // now fill with content
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

        table.getSelectionModel().selectedItemProperty().addListener((surfaceRecord, oldSurfaceRec, newSurfaceRec) -> selectedSurface(oldSurfaceRec, newSurfaceRec));

    }

    private void selectedSurface(SurfaceRecord oldSurfaceRec, SurfaceRecord newSurfaceRec) {
        LOG.debug("selected surface rec #{}, {}", oldSurfaceRec, newSurfaceRec);
        if ( oldSurfaceRec != null && oldSurfaceRec.equals(newSurfaceRec) ) {
            // no change
            return;
        }

        var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
        robert.add( new BreadcrumbRecord(newSurfaceRec.id(), SurfacePage.class, null, newSurfaceRec.surface()));
        var event = new SelectionEvent( robert);
        DefaultEventBus.getInstance().publish(event);

    }

    @Override
    public void afterShow() {

       // Party !
    }

}
