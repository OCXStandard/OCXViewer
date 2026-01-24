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

import de.cadoculus.ocxviewer.models.DimensionTypesRecord;
import de.cadoculus.ocxviewer.models.UnitDimensionRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * A page displaying information about unit dimensions.
 * @author Carsten Zerbst
 */
public class UnitDimensionsPage extends AbstractDataViewPage{
    public static final String NAME = "Unit Dimensions";
    private static final Logger LOG = LogManager.getLogger(UnitDimensionsPage.class);
    private final TableView<UnitDimensionRecord> table;

    public UnitDimensionsPage() {
        super(NAME);

        createTitle("Information about the unit dimensions.");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        this.setCenter(scrollPane);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(gridPane);

        // Define the table
        var tableColumn1 = new TableColumn<UnitDimensionRecord, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().id())
        );

        var tableColumn2 = new TableColumn<UnitDimensionRecord, Boolean>("Dimensionless");
        tableColumn2.setCellValueFactory(
                c -> new SimpleBooleanProperty(c.getValue().dimensionless()));

        var tableColumn3 = new TableColumn<UnitDimensionRecord, List<DimensionTypesRecord>>("Symbols");
        tableColumn3.setCellValueFactory(
                c -> new SimpleObjectProperty<>(c.getValue().types()));

        tableColumn3.setCellFactory(column -> {
            return new TableCell<UnitDimensionRecord, List<DimensionTypesRecord>>() {
                @Override
                protected void updateItem(List<DimensionTypesRecord> types, boolean empty) {
                    super.updateItem(types, empty);

                    if (types == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        StringBuilder sb = new StringBuilder();
                        for (DimensionTypesRecord type : types) {
                            sb.append(type.typeName());
                            switch (type.powerNumerator()) {
                                case 1:
                                    break;
                                case 2:
                                    sb.append("²");
                                    break;
                                case 3:
                                    sb.append("³");
                                    break;
                                case 4:
                                    sb.append("⁴");
                                    break;
                                case -1:
                                    sb.append("⁻¹");
                                    break;
                                case -2:
                                    sb.append("⁻²");
                                    break;
                                case -3:
                                    sb.append("⁻³");
                                    break;
                                default:
                                    sb.append("^").append(type.powerNumerator());
                                    break;
                            }
                            sb.append(" ");
                        }

                        setText(sb.toString());
                    }
                }
            };
        });



        ObservableList<UnitDimensionRecord> unitDimensionRecords = FXCollections.observableArrayList();
        table = new TableView<>(unitDimensionRecords);
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


        final org.ocx_schema.v310.OcxXMLT ocx = WorkingContext.getInstance().getOcx();
        final oasis.unitsml.UnitsML unitsML = ocx.getUnitsML();
        final oasis.unitsml.DimensionSet dimensionSet = unitsML.getDimensionSet();
        final List<oasis.unitsml.Dimension> dimensions = dimensionSet.getDimensions();

        for (oasis.unitsml.Dimension dimension : dimensions) {
            unitDimensionRecords.add(UnitDimensionRecord.create(dimension));
        }


    }
}
