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
import de.cadoculus.ocxviewer.models.CutByRecord;
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
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;
import org.ocx_schema.v310.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A page displaying information about a Panel.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the PanelsPage
 *
 * @author Carsten Zerbst
 */
public class PanelPage extends AbstractDataViewSubPage<Panel> {
    public static final String NAME = "Panel";
    private static final Logger LOG = LogManager.getLogger(PanelPage.class);


    public PanelPage(Panel panel, Page parent) {
        super(panel, parent, "Panel «" + panel.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Panel");

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(gridPane);

        // name="T11-FR1-PS" ocx:GUIDRef="59664e8c-f100-4ea2-b275-e9eac9f25fdc" ocx:functionType="TRANSVERSAL" ocx:tightness="NonTight">
        int row = 0;

        var label = new Label("Basic Information");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 3, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The name of the panel"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), panel, "name", String.class);


        label = new Label("GUID");
        label.setTooltip(new Tooltip("The panel's GUID"));
        gridPane.add(label, 2, row);
        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), panel, "GUIDRef", String.class);


        // todo: use combobox to restrict entry
        label = new Label("Function Type");
        label.setTooltip(new Tooltip("The panel's function type"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), panel, "functionType", String.class);

        label = new Label("Tightness");
        label.setTooltip(new Tooltip("The panel's tightness"));
        gridPane.add(label, 2, row);
        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), panel, "tightness", String.class);

        label = new Label("Description");
        label.setTooltip(new Tooltip("The panel's description"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        bindToBean(textField.textProperty(), panel, "description", String.class);
        gridPane.add(textField, 1, row++, 3, 1);


        label = new Label("Panel Topology and Geometry");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Custom Properties");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 2, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        var link = new Hyperlink("View Topology and Geometry...");
        link.setTooltip(new Tooltip("Goto Topology and Geometry page"));
        gridPane.add(link, 0, row, 2, 1);
        link.setOnAction(e -> {
            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord("Topology and Geometry", PanelTopologyAndGeometryPage.class, null, getObject()));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        });

        link = new Hyperlink("View Custom Properties");
        link.setTooltip(new Tooltip("Goto Custom Properties page"));
        gridPane.add(link, 2, row++, 2, 1);
        link.setOnAction(e -> {
            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord("Custom Properties", CustomPropertiesPage.class, null, getObject()));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        });


        // The parts makeing up the panel
        label = new Label("Panel Parts");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        var tabPlates = createPlatesTab();
        var tabBrackets = createBracketsTab();
        var tabPillars = createPillarsTab();
        var tabStiffeners = createStiffenersTab();
        var tabFlanges = createFlangesTab();
        var tabSeams = createSeamsTab();
        var tabHoles = createCutByTab();

        var gridTab = new TabPane(tabPlates, tabBrackets, tabPillars, tabStiffeners, tabFlanges, tabSeams, tabHoles);
        gridTab.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        gridTab.setMinWidth(450);

        gridPane.add(gridTab, 0, ++row, 4, 1);


        // ensure the last row gets all available space
        for (int r = 0; r < GridPane.getRowIndex(gridTab); r++) {
            gridPane.getRowConstraints().add(new RowConstraints());
        }
        var tableRow = new RowConstraints();
        tableRow.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().add(tableRow);

    }

    private Tab createPillarsTab() {
        var tab = new Tab("Pillars");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.PillarT> entities = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.PillarT> filteredEntities = new FilteredList<>(entities, p -> true);

        if (getObject().getComposedOf() != null && getObject().getComposedOf().getPillars() != null) {
            entities.addAll(getObject().getComposedOf().getPillars());
        } else {
            LOG.warn("Panel {} ({})has no ComposedOf element or no Pillar", getObject().getId(), getObject().getGUIDRef());
        }

        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Brackets by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredEntities.setPredicate(pillar -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (pillar.getName() != null && pillar.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (pillar.getId() != null && pillar.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.PillarT, org.ocx_schema.v310.PillarT>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(selected -> {
            if (selected == null) {
                // no change
                return;
            }

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(selected.getId(), PillarPage.class, null, selected));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.PillarT, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.PillarT, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));

        // TODO: better material representation
        var tableColumn4 = new TableColumn<org.ocx_schema.v310.PillarT, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getMaterialRef().toString()));


        var table = new TableView<>(filteredEntities);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;
    }

    /**
     * Create a tab containing all Brackets from '/ocx:ocxXML/ocx:Vessel/ocx:Panel/ocx:ComposedOf'
     *
     * @return the Tab
     */
    private Tab createBracketsTab() {
        var tab = new Tab("Brackets");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<Bracket> entities = FXCollections.observableArrayList();
        final FilteredList<Bracket> filteredEntities = new FilteredList<>(entities, p -> true);

        if (getObject().getComposedOf() != null && getObject().getComposedOf().getBrackets() != null) {
            entities.addAll(getObject().getComposedOf().getBrackets());
        } else {
            LOG.warn("Panel {} ({})has no ComposedOf element or no Brackets", getObject().getId(), getObject().getGUIDRef());
        }

        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Brackets by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredEntities.setPredicate(bracket -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (bracket.getName() != null && bracket.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (bracket.getId() != null && bracket.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<Bracket, Bracket>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(selected -> {
            if (selected == null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(selected.getId(), BracketPage.class, null, selected));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<Bracket, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<Bracket, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));

        var tableColumn4 = new TableColumn<Bracket, Pair<Bracket, Material>>("Material");
        tableColumn4.setCellValueFactory(
                cell -> new SimpleObjectProperty<>(
                        new Pair<>(cell.getValue(), (Material) cell.getValue().getPlateMaterial().getReferenced()))
        );
        tableColumn4.setCellFactory(createHyperlinkCellfactory(selected -> {
            LOG.debug("selected material pair {}", selected);
            if (selected == null) {
                // no change
                return;
            }
            var bracket = selected.getKey();
            var material = selected.getValue();

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(bracket.getId(), BracketPage.class, null, bracket));
            robert.add(new BreadcrumbRecord(material.getId(), MaterialPage.class, null, material));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);

        }));

        var table = new TableView<>(filteredEntities);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;
    }

    /**
     * Create a tab containing all Seams from '/ocx:ocxXML/ocx:Vessel/ocx:Panel/ocx:SplitBy'
     *
     * @return the Tab
     */
    private Tab createSeamsTab() {
        var tab = new Tab("Seams");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<Seam> entities = FXCollections.observableArrayList();
        final FilteredList<Seam> filteredEntities = new FilteredList<>(entities, p -> true);

        if (getObject().getSplitBy() != null && getObject().getSplitBy().getSeams() != null) {
            entities.addAll(getObject().getSplitBy().getSeams());
        } else {
            LOG.info("Panel {} ({}) has no getSplitBy element or no Seams", getObject().getId(), getObject().getGUIDRef());
        }

        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Seams by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredEntities.setPredicate(stiffener -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (stiffener.getName() != null && stiffener.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (stiffener.getId() != null && stiffener.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<Seam, Seam>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(selected -> {
            if (selected == null) {
                // no change
                return;
            }

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(selected.getId(), SeamPage.class, null, selected));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<Seam, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<Seam, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        var table = new TableView<>(filteredEntities);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;
    }


    /**
     * Create a tab containing all EdgeReinforcement from '/ocx:ocxXML/ocx:Vessel/ocx:Panel/ocx:StiffenedBy'
     *
     * @return the Tab
     */
    private Tab createFlangesTab() {
        var tab = new Tab("Flanges");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<EdgeReinforcement> stiffeners = FXCollections.observableArrayList();
        final FilteredList<EdgeReinforcement> filteredStiffeners = new FilteredList<>(stiffeners, p -> true);

        if (getObject().getStiffenedBy() != null && getObject().getStiffenedBy().getEdgeReinforcements() != null) {
            stiffeners.addAll(getObject().getStiffenedBy().getEdgeReinforcements());
        } else {
            LOG.info("Panel {} ({}) has no getStiffenedBy element or no EdgeReinforcements", getObject().getId(), getObject().getGUIDRef());
        }

        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Stiffener by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredStiffeners.setPredicate(stiffener -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (stiffener.getName() != null && stiffener.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (stiffener.getId() != null && stiffener.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<EdgeReinforcement, EdgeReinforcement>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(selected -> {
            if (selected == null) {
                // no change
                return;
            }

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(selected.getId(), FlangePage.class, null, selected));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<EdgeReinforcement, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<EdgeReinforcement, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        // TODO: better material representation
        var tableColumn4 = new TableColumn<EdgeReinforcement, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getMaterialRef().toString()));


        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<EdgeReinforcement, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        var table = new TableView<>(filteredStiffeners);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;

    }

    /**
     * Create a tab containing all Stiffeners from '/ocx:ocxXML/ocx:Vessel/ocx:Panel/ocx:StiffenedBy'
     *
     * @return the Tab
     */
    private Tab createStiffenersTab() {
        var tab = new Tab("Stiffeners");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<Stiffener> stiffeners = FXCollections.observableArrayList();
        final FilteredList<Stiffener> filteredStiffeners = new FilteredList<>(stiffeners, p -> true);

        if (getObject().getStiffenedBy() != null && getObject().getStiffenedBy().getStiffeners() != null) {
            stiffeners.addAll(getObject().getStiffenedBy().getStiffeners());
        } else {
            LOG.info("Panel {} ({}) has no getStiffenedBy element or no stiffeners", getObject().getId(), getObject().getGUIDRef());
        }

        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Stiffener by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredStiffeners.setPredicate(stiffener -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (stiffener.getName() != null && stiffener.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (stiffener.getId() != null && stiffener.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<Stiffener, Stiffener>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(selected -> {
            if (selected == null) {
                // no change
                return;
            }

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(selected.getId(), StiffenerPage.class, null, selected));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<Stiffener, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<Stiffener, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        // TODO: better material representation
        var tableColumn4 = new TableColumn<Stiffener, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getMaterialRef().toString()));


        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<Stiffener, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        var table = new TableView<>(filteredStiffeners);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;

    }

    private Tab createPlatesTab() {

        var tab = new Tab("Plates");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<Plate> plates = FXCollections.observableArrayList();
        final FilteredList<Plate> filteredPlates = new FilteredList<>(plates, p -> true);

        if (getObject().getComposedOf() != null && getObject().getComposedOf().getPlates() != null) {
            plates.addAll(getObject().getComposedOf().getPlates());
        } else {
            LOG.warn("Panel {} ({})has no ComposedOf element or no plates", getObject().getId(), getObject().getGUIDRef());
        }

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
                } else if (plate.getId() != null && plate.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<Plate, Plate>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory(selected -> {
            LOG.debug("selected plate {}", selected);
            if (selected == null) {
                // no change
                return;
            }

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(selected.getId(), PlatePage.class, null, selected));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);

        }));

        var tableColumn2 = new TableColumn<Plate, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<Plate, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));

        var tableColumn4 = new TableColumn<Plate, Pair<Plate, Material>>("Material");
        tableColumn4.setCellValueFactory(
                cell -> new SimpleObjectProperty<>(
                        new Pair<>(cell.getValue(), (Material) cell.getValue().getPlateMaterial().getReferenced()))
        );
        tableColumn4.setCellFactory(createHyperlinkCellfactory(selected -> {
            LOG.debug("selected material pair {}", selected);
            if (selected == null) {
                // no change
                return;
            }
            var plate = selected.getKey();
            var material = selected.getValue();

            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord(plate.getId(), PlatePage.class, null, plate));
            robert.add(new BreadcrumbRecord(material.getId(), MaterialPage.class, null, material));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);

        }));

        // TOD: add thickness unit

        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<Plate, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        var table = new TableView<>(filteredPlates);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;

    }


    private Tab createCutByTab() {

        var tab = new Tab("Holes");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<CutByRecord> holes = FXCollections.observableArrayList();
        final FilteredList<CutByRecord> filteredHoles = new FilteredList<>(holes, p -> true);

        if (getObject().getCutBy() != null && getObject().getCutBy().getHole2DContoursAndInnerContours() != null) {
            for (Serializable serializable : getObject().getCutBy().getHole2DContoursAndInnerContours()) {

                LOG.warn("hole {}", serializable);
                holes.add(CutByRecord.forHole(serializable));
            }

        } else {
            LOG.warn("Panel {} ({})has no CutBy element or no holes", getObject().getId(), getObject().getGUIDRef());
        }

        //
        // Define the table
        //

        var filterText = new CustomTextField();
        filterText.setLeft(new FontIcon(MaterialDesignT.TABLE_SEARCH));
        filterText.setPrefWidth(100);
        filterText.setPadding(new Insets(10, 0, 10, 0));
        filterText.setPromptText("search Hole by name");
        vbox.getChildren().add(filterText);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredHoles.setPredicate(record -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (record.name() != null && record.name().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name
                } else if (record.id() != null && record.id().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });

        var tableColumn0 = new TableColumn<CutByRecord, String>("Type");
        tableColumn0.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().type().toString()));

        var tableColumn1 = new TableColumn<CutByRecord, String>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().id()));

        var tableColumn2 = new TableColumn<CutByRecord, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().guid()));

        var tableColumn3 = new TableColumn<CutByRecord, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().name()));


        var table = new TableView<>(filteredHoles);
        vbox.getChildren().add(table);
        VBox.setVgrow(table, Priority.ALWAYS);

        table.getColumns().setAll(tableColumn0, tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        return tab;

    }

}
