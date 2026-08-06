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

import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.io.ReferenceBaseTImpl;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.DesignViewRecord;
import jakarta.xml.bind.JAXBElement;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.Callback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v3x.*;

import java.util.ArrayList;

/**
 * A page displaying information about a DesignView.
 * The DesignViewPage is not intended to be navigated directly, but rather as a logical child, e.g. from the {@link DesignViewsPage}
 *
 * @author Carsten Zerbst
 */
public class DesignViewPage extends AbstractDataViewSubPage<DesignView> {
    public static final String NAME = "Design View";
    private static final Logger LOG = LogManager.getLogger(DesignViewPage.class);


    public DesignViewPage(DesignView designView, Page parent) {
        super(designView, parent, "Design View «" + designView.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Design View");

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(gridPane);

        int row = 0;

        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        // ocx:Name
        var label = new Label("Id");
        label.setTooltip(new Tooltip("The design views's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), designView, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The design views's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), designView, "name", String.class);


        label = new Label("Description");
        label.setTooltip(new Tooltip("The design views's description"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        bindToBean(textField.textProperty(), designView, "description", String.class);
        gridPane.add(textField, 1, row++, 3, 1);


        label = new Label("Vessel Reference");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Custom Properties");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 2, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        if ( designView.getVesselRef() != null && designView.getVesselRef().getReferenced() != null) {
            var vessel = designView.getVesselRef().getReferenced();
            var link = new Hyperlink("Vessel " + vessel.getId() );
            link.setTooltip(new Tooltip("Goto Vessel page"));
            gridPane.add(link, 0, row, 2, 1);
            link.setOnAction(e -> {
                var robert = createBreadcrumbs( getBreadcrumbs(), vessel);
                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            });
        } else {
            var labelNoVessel = new Label("No vessel reference found");
            label.setStyle(Styles.WARNING);
            labelNoVessel.setTooltip(new Tooltip("The design view has no vessel reference"));
            gridPane.add(labelNoVessel, 0, row, 2, 1);
        }


        var   link = new Hyperlink("View Custom Properties");
        link.setTooltip(new Tooltip("Goto Custom Properties page"));
        gridPane.add(link, 2, row++, 2, 1);
        link.setOnAction(e -> {
            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord("Custom Properties", CustomPropertiesPage.class, null, getObject()));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        });

        label = new Label("Design Tree");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        // The tree table
        var col1 = new TreeTableColumn<DesignViewRecord, String>("Tree");
        var col2 = new TreeTableColumn<DesignViewRecord, String>("Type");
        var col3 = new TreeTableColumn<DesignViewRecord, DesignViewRecord>("Name");

        col1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getValue().id())
        );
        col2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getValue().type())
        );

        col3.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getValue()));
        col3.setCellFactory(createHyperlinkCellfactory());

        var treeTable = new TreeTableView<DesignViewRecord>();
        treeTable.setColumnResizePolicy(
                TreeTableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );
        treeTable.getColumns().setAll(col1, col2, col3);
        treeTable.setMinHeight(150);
        treeTable.setMaxHeight(1500);

        gridPane.add(treeTable, 0, row++, 4, 1);


        var rootItem = new TreeItem<>(
                new DesignViewRecord(designView.getId(), designView.getName(), "DesignView", null));

        // todo: either walk on demand or in a background thread
        recWalk(designView, rootItem);
        rootItem.setExpanded(true);
        treeTable.setRoot(rootItem);


        // ensure the last row gets all available space
        for (int r = 0; r < GridPane.getRowIndex(treeTable); r++) {
            gridPane.getRowConstraints().add(new RowConstraints());
        }
        var tableRow = new RowConstraints();
        tableRow.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().add(tableRow);


    }

    private Callback<TreeTableColumn<DesignViewRecord, DesignViewRecord>, TreeTableCell<DesignViewRecord, DesignViewRecord>> createHyperlinkCellfactory() {
        return new Callback<>() {


            @Override
            public TreeTableCell<DesignViewRecord, DesignViewRecord> call(TreeTableColumn<DesignViewRecord, DesignViewRecord> treeTableColumn) {

                return new TreeTableCell<DesignViewRecord, DesignViewRecord>() {
                    private final Hyperlink hyperlink = new Hyperlink();

                    {
                        hyperlink.setOnAction(new EventHandler<>() {
                            @Override
                            public void handle(ActionEvent event) {
                                DesignViewRecord record = getItem();
                                if (record != null && record.part() instanceof EntityBaseT entity) {
                                    LOG.debug("selected item {}", record);
                                    var robert = createBreadcrumbs(getBreadcrumbs(), entity);
                                    var selectionEvent = new SelectionEvent(robert);
                                    DefaultEventBus.getInstance().publish(selectionEvent);
                                } else {
                                    LOG.warn("selected item {} has no or invalid reference", record);
                                }
                            }
                        });
                    }

                    @Override
                    protected void updateItem(DesignViewRecord item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setGraphic(null);
                        } else {
                            hyperlink.setText(item.name());
                            setGraphic(hyperlink);
                        }
                    }
                };
            }
        };
    }

    private void recWalk(DesignView designView, TreeItem<DesignViewRecord> rootItem) {
        LOG.debug("recWalk {} {}", designView.getId(), designView.getName());
        for (OccurrenceGroup occurrenceGroup : designView.getOccurrenceGroups()) {
            recWalk(occurrenceGroup, rootItem,0);
        }

        for (Occurrence occurrence : designView.getOccurrences()) {
            recWalk(occurrence, rootItem,0);
        }
    }

    private void recWalk(OccurrenceGroup occurrenceGroup, TreeItem<DesignViewRecord> rootItem, int depth) {
        LOG.debug("{}recWalk {} {}", "  ".repeat(depth), occurrenceGroup.getId(), occurrenceGroup.getName());
        var occ = new TreeItem<>(
                new DesignViewRecord(occurrenceGroup.getId(), occurrenceGroup.getName(), "Occurrence Group", null));

        rootItem.getChildren().add(occ);

        for (OccurrenceGroup occGrp : occurrenceGroup.getOccurrenceGroups()) {
            recWalk(occGrp, occ, depth + 1);
        }

        for (Occurrence occurrence : occurrenceGroup.getOccurrences()) {
            recWalk(occurrence, occ, depth+1);
        }
    }

    private void recWalk(Occurrence occurrence, TreeItem<DesignViewRecord> rootItem, int depth) {
        LOG.debug("{}recWalk {} {}", "  ".repeat(depth),occurrence.getId(), occurrence.getName());
        var occ = new TreeItem<>(
                new DesignViewRecord(occurrence.getId(), occurrence.getName(), "Occurrence", null));

        rootItem.getChildren().add(occ);

        for (JAXBElement<? extends ReferenceBaseTImpl> element : occurrence.getStructureRevesAndStiffenerRevesAndSeamReves()) {
            var value = element.getValue();

            LOG.debug("{}  found item in occurrence {} {}: {}", "  ".repeat(depth), occurrence.getId(), occurrence.getName(), value);


            String id = element.getName().getLocalPart();
            String name = "unresolved reference";
            String type = "???";
            Object referenced;

            if (value instanceof PlateRefT plateRefT) {
                LOG.debug("{}  plateRefT: {} {}", "  ".repeat(depth), plateRefT.getGUIDRef(), plateRefT.getReferenced());
                referenced = plateRefT.getReferenced();
                type = "Plate Reference";
            } else if (value instanceof StiffenerRefT stiffenerRefT) {
                LOG.debug("{}  stiffenerRefT: {} {}", "  ".repeat(depth),stiffenerRefT.getGUIDRef(), stiffenerRefT.getReferenced());
                referenced = stiffenerRefT.getReferenced();
                type = "Stiffener Reference";
            } else if (value instanceof PillarRef pillarRef) {
                LOG.debug("{}  pillarRef: {} {}", "  ".repeat(depth) ,pillarRef.getGUIDRef(), pillarRef.getReferenced());
                referenced = pillarRef.getReferenced();
                type = "Pillar Reference";

            } else {
                LOG.error("found unsupported item in occurrence {} {}", occurrence.getId(), value);
                continue;
            }

            if ( referenced instanceof  EntityBaseT ) {
                id = ((EntityBaseT) referenced).getId();
                name = id;
                LOG.info("updated to id {} name {} type {}", id, name, type);
            }

            var ref = new TreeItem<>(
                    new DesignViewRecord(id, name, type, referenced));

            LOG.info("{}  adding item to occurrence {} {}: {}", "  ".repeat(depth), occurrence.getId(), occurrence.getName(), ref);
            occ.getChildren().add(ref);


        }
    }
}
