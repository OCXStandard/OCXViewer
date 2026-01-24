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

import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.OCXViewerApplication;
import de.cadoculus.ocxviewer.models.FlagsEnum;
import de.cadoculus.ocxviewer.models.UnitRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import oasis.unitsml.Unit;
import oasis.unitsml.UnitName;
import oasis.unitsml.UnitSet;
import oasis.unitsml.UnitsML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.OcxXMLT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The UnitsPage displays the units used in the OCX file.
 * @author Carsten Zerbst
 */
public class UnitsPage extends AbstractDataViewPage{
    public static final String NAME = "Units";
    private static final Logger LOG = LogManager.getLogger(UnitsPage.class);

    private final TableView<UnitRecord> table;
    private final TextField unitId = new TextField();
    private final FlowPane unitNames = new FlowPane();
    private final TextField unitSymbols = new TextField();
    private final TextField rootUnits = new TextField();
    private final TextField unitDimensions = new TextField();

    private final Map<FlagsEnum, Image> flagImages = new HashMap<>();

    private final ChangeListener<UnitRecord> userListener = (obs, oldRecord, newRecord) -> {
//        if (oldRecord != null) {
//            firstNameField.textProperty().unbindBidirectional(oldRecord.firstNameProperty());
//            lastNameField.textProperty().unbindBidirectional(oldRecord.lastNameProperty());
//            adminCheckBox.selectedProperty().unbindBidirectional(oldRecord.adminProperty());
//        }

        if (newRecord == null) {
            unitId.clear();
            unitNames.getChildren().clear();
            unitSymbols.clear();
            rootUnits.clear();
            unitDimensions.clear();
        } else {
            unitId.setText(newRecord.id());
            unitNames.getChildren().clear();
            for (UnitName name : newRecord.names()) {
                var flag = FlagsEnum.fromLocale(name.getLang());
                Image image = null;
                if (flagImages.containsKey(flag)) {
                    image = flagImages.get(flag);
                } else {
                    try {
                        image = new Image(OCXViewerApplication.class.getResourceAsStream(flag.getFlag()));
                        flagImages.put(flag, image);
                    } catch (Exception exp) {
                        LOG.debug("no flag icon found for '{}'", flag.getFlag());
                    }
                }

                Label label = null;
                if ( image != null) {
                    label = new Label( name.getValue());
                    label.setGraphic(new ImageView(image));
                    label.getStyleClass().add("unitName");
                } else {
                    label = new Label(name.getLang() + " : " + name.getValue());
                }

                unitNames.getChildren().add(label);
            }
            unitSymbols.setText(newRecord.symbol());
            rootUnits.setText(newRecord.rootUnits());
            unitDimensions.setText(newRecord.dimension());

        }
    };



    public UnitsPage() {
        super(NAME);

        createTitle("Information about the used unitRecords.");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        this.setCenter(scrollPane);

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 10;");

        scrollPane.setContent(gridPane);


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
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 10;");


        // Define the table
        var tableColumn1 = new TableColumn<UnitRecord, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().id())
        );

        var tableColumn2 = new TableColumn<UnitRecord, List<UnitName>>("Names");
        tableColumn2.setCellValueFactory(
                c -> new SimpleObjectProperty<>(c.getValue().names()));

        tableColumn2.setCellFactory(column -> {
            return new TableCell<UnitRecord, List<UnitName>>() {
                @Override
                protected void updateItem(List<UnitName> names, boolean empty) {
                    super.updateItem(names, empty);

                    if (names == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        StringBuilder sb = new StringBuilder();
                        for (UnitName name : names) {
                            sb.append(name.getLang()).append(":").append(name.getValue()).append(";");
                            if ( sb.length() > 40) {
                                sb.append(" ...");
                                break;
                            }
                        }
                        setText(sb.toString());
                    }
                }
            };
        });


        tableColumn2.setCellValueFactory(
                c -> new SimpleObjectProperty<>(c.getValue().names())
        );

        var tableColumn3 = new TableColumn<UnitRecord, String>("Symbols");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().symbol())
        );

        ObservableList<UnitRecord> unitRecords = FXCollections.observableArrayList();
        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();
        final UnitsML unitsML = ocx.getUnitsML();
        final UnitSet unitSet = unitsML.getUnitSet();
        final List<Unit> units = unitSet.getUnits();

        for (Unit unit : units) {
            unitRecords.add(UnitRecord.create(unit));
        }

        table = new TableView<>(unitRecords);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );
        table.getSelectionModel().selectFirst();
        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(300);

        int row = 0;
        gridPane.add(table, 0, row, 4,3);
        row+=3;

        // The detail view for one Unit
        var label = new Label("Unit Details");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Id");
        label.setTooltip(new Tooltip("The unit's ID."));
        gridPane.add(label, 0, row);
        gridPane.add(unitId, 1, row++);


        unitNames.setId("unitsName");
        unitNames.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        label = new Label("Names");
        label.setTooltip(new Tooltip("The unit's display names."));
        gridPane.add(label, 0, row);
        gridPane.add(unitNames, 1, row++, 3, 1);

        label = new Label("Symbols");
        label.setTooltip(new Tooltip("The unit's symbols.  Examples include Aring (ASCII), Å (HTML)."));
        gridPane.add(label, 0, row);
        gridPane.add(unitSymbols, 1, row++, 3, 1);

        label = new Label("Root Units");
        label.setTooltip(new Tooltip("The unit's root units. Container for defining derived units in terms of their root units. This allows a precise definition of a wide range of units. The goal is to improve interoperability among applications and databases which use derived units based on commonly encountered root units.</xsd:documentation" ));
        gridPane.add(label, 0, row);
        gridPane.add(rootUnits, 1, row++, 3, 1);

        label = new Label("Dimensions");
        label.setTooltip(new Tooltip("The unit's root units. Reference to a representation of the unit or quantity in terms of the 7 SI base dimensions."));
        gridPane.add(label, 0, row);
        gridPane.add(unitDimensions, 1, row++, 3, 1);


        table.getSelectionModel().selectedItemProperty().addListener(userListener);

    }

    @Override
    public void afterShow() {
        super.afterShow();
        table.getSelectionModel().selectFirst();
        userListener.changed(null, null, table.getSelectionModel().getSelectedItem());


    }
}
