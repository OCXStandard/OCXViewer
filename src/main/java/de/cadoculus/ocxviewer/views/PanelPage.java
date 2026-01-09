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
import org.ocx_schema.v310.PillarT;

import java.util.ArrayList;

/**
 * A page displaying information about a Panel.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the PanelsPage
 *
 * @author Carsten Zerbst
 */
public class PanelPage extends AbstractDataViewSubPage<org.ocx_schema.v310.Panel> {
    public static final String NAME = "Panel";
    private static final Logger LOG = LogManager.getLogger(PanelPage.class);


    public PanelPage(org.ocx_schema.v310.Panel panel, Page parent) {
        super(panel, parent, "Panel \u00AB" + panel.getId() + "\u00BB");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Panel");

        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        col2.setHgrow(Priority.ALWAYS);
        col2.setMaxWidth(600);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHalignment(HPos.LEFT);
        col4.setHgrow(Priority.ALWAYS);
        col4.setMaxWidth(600);

        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);
        //gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        setCenter(gridPane);


        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "Not implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        int row = 0;
        gridPane.add(warning, 0, row++, 4, 1);


        // The parts makeing up the panel
        var label = new Label("Panel Parts");
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

        var gridTab = new TabPane(tabPlates,tabBrackets, tabPillars, tabStiffeners, tabFlanges, tabSeams);
        gridTab.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        gridTab.setMinWidth(450);

        gridPane.add(gridTab, 0, ++row, 4, 1);

    }

    private Tab createPillarsTab() {
        var tab = new Tab("Pillars");

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.PillarT> entities = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.PillarT> filteredEntities = new FilteredList<>(entities, p -> true);

        if (getObject().getComposedOf() != null && getObject().getComposedOf().getPillars()!= null) {
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
                }
                else if (pillar.getId() != null && pillar.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.PillarT, org.ocx_schema.v310.PillarT>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<PillarT>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), PillarPage.class, null, selected));

            var event = new SelectionEvent( robert);
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



        var table = new TableView<org.ocx_schema.v310.PillarT>(filteredEntities);
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

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.Bracket> entities = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.Bracket> filteredEntities = new FilteredList<>(entities, p -> true);

        if (getObject().getComposedOf() != null && getObject().getComposedOf().getBrackets()!= null) {
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
                }
                else if (bracket.getId() != null && bracket.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.Bracket, org.ocx_schema.v310.Bracket>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<org.ocx_schema.v310.Bracket>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), BracketPage.class, null, selected));

            var event = new SelectionEvent( robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.Bracket, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.Bracket, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));

        // TODO: better material representation
        var tableColumn4 = new TableColumn<org.ocx_schema.v310.Bracket, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getPlateMaterial().getLocalRef().toString()));



        var table = new TableView<org.ocx_schema.v310.Bracket>(filteredEntities);
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

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.Seam> entities = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.Seam> filteredEntities = new FilteredList<>(entities, p -> true);

        if (getObject().getSplitBy() != null && getObject().getSplitBy().getSeams()!= null) {
            entities.addAll(getObject().getSplitBy().getSeams());
        } else {
            LOG.warn("Panel {} ({})has no getSplitBy element or no Seams", getObject().getId(), getObject().getGUIDRef());
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
                }
                else if (stiffener.getId() != null && stiffener.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.Seam, org.ocx_schema.v310.Seam>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<org.ocx_schema.v310.Seam>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), SeamPage.class, null, selected));

            var event = new SelectionEvent( robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.Seam, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.Seam, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        var table = new TableView<org.ocx_schema.v310.Seam>(filteredEntities);
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

        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.EdgeReinforcement> stiffeners = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.EdgeReinforcement> filteredStiffeners = new FilteredList<>(stiffeners, p -> true);

        if (getObject().getStiffenedBy() != null && getObject().getStiffenedBy().getEdgeReinforcements()!= null) {
            stiffeners.addAll(getObject().getStiffenedBy().getEdgeReinforcements());
        } else {
            LOG.warn("Panel {} ({})has no getStiffenedBy element or no EdgeReinforcements", getObject().getId(), getObject().getGUIDRef());
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
                }
                else if (stiffener.getId() != null && stiffener.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.EdgeReinforcement, org.ocx_schema.v310.EdgeReinforcement>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<org.ocx_schema.v310.EdgeReinforcement>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), FlangePage.class, null, selected));

            var event = new SelectionEvent( robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.EdgeReinforcement, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.EdgeReinforcement, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        // TODO: better material representation
        var tableColumn4 = new TableColumn<org.ocx_schema.v310.EdgeReinforcement, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getMaterialRef().toString()));



        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<org.ocx_schema.v310.EdgeReinforcement, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        var table = new TableView<org.ocx_schema.v310.EdgeReinforcement>(filteredStiffeners);
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
        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.Stiffener> stiffeners = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.Stiffener> filteredStiffeners = new FilteredList<>(stiffeners, p -> true);

        if (getObject().getStiffenedBy() != null && getObject().getStiffenedBy().getStiffeners()!= null) {
            stiffeners.addAll(getObject().getStiffenedBy().getStiffeners());
        } else {
            LOG.warn("Panel {} ({})has no getStiffenedBy element or no stiffeners", getObject().getId(), getObject().getGUIDRef());
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
                }
                else if (stiffener.getId() != null && stiffener.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.Stiffener, org.ocx_schema.v310.Stiffener>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<org.ocx_schema.v310.Stiffener>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), StiffenerPage.class, null, selected));

            var event = new SelectionEvent( robert);
            DefaultEventBus.getInstance().publish(event);
        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.Stiffener, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.Stiffener, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        // TODO: better material representation
        var tableColumn4 = new TableColumn<org.ocx_schema.v310.Stiffener, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getMaterialRef().toString()));



        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<org.ocx_schema.v310.Stiffener, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        var table = new TableView<org.ocx_schema.v310.Stiffener>(filteredStiffeners);
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
        var vbox = new VBox();
        tab.setContent(vbox);

        final ObservableList<org.ocx_schema.v310.Plate> plates = FXCollections.observableArrayList();
        final FilteredList<org.ocx_schema.v310.Plate> filteredPlates = new FilteredList<>(plates, p -> true);

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
                }
                else if (plate.getId() != null && plate.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                }
                return false; // Does not match
            });
        });


        var tableColumn1 = new TableColumn<org.ocx_schema.v310.Plate, org.ocx_schema.v310.Plate>("ID");
        tableColumn1.setCellValueFactory(c -> new SimpleObjectProperty<org.ocx_schema.v310.Plate>(c.getValue()));
        tableColumn1.setCellFactory(createHyperlinkCellfactory( selected -> {
            LOG.debug("selected plate {}", selected);
            if ( selected ==null) {
                // no change
                return;
            }

            var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
            robert.add( new BreadcrumbRecord(selected.getId(), PlatePage.class, null, selected));

            var event = new SelectionEvent( robert);
            DefaultEventBus.getInstance().publish(event);

        }));

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.Plate, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef()));

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.Plate, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName()));


        // TODO: better material representation
        var tableColumn4 = new TableColumn<org.ocx_schema.v310.Plate, String>("Material");
        tableColumn4.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getPlateMaterial().getLocalRef().toString()));

        // TOD: add thickness unit

        // TODO: better quantity representation
        var tableColumn5 = new TableColumn<org.ocx_schema.v310.Plate, String>("Function");
        tableColumn5.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFunctionType()));


        var table = new TableView<org.ocx_schema.v310.Plate>(filteredPlates);
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

}
