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

import de.cadoculus.ocxviewer.models.UnitRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310rc3.*;

import java.util.List;

public class BarSectionsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Bar Sections";
    private static final Logger LOG = LogManager.getLogger(BarSectionsPage.class);
    private final TableView<BarSection> table;


    public BarSectionsPage() {
        super(NAME);

        createTitle("Information about the bar sections used for stiffeners and pillars.");

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = new GridPane();

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
        var tableColumn1 = new TableColumn<BarSection, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getId())
        );

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
                c -> new SimpleStringProperty( getSectionType(c.getValue()))
        );

        ObservableList<BarSection> barSections = FXCollections.observableArrayList();
        table = new TableView<>(barSections);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );
        table.getSelectionModel().selectFirst();
        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(200);
        int row = 0;
           gridPane.add(table, 0, row, 4,3);
        row+=3;

        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();
        if ( ocx.getClassCatalogue() == null) {
            LOG.info("no class catalogue found");
            return;
        }
        if ( ocx.getClassCatalogue().getXSectionCatalogue() == null) {
            LOG.info("no Xsections found in class catalogue");
            return;
        }
        List<BarSection> catBarSections=null;
        if ( ( catBarSections = ocx.getClassCatalogue().getXSectionCatalogue().getBarSections()) != null) {
            barSections.addAll(catBarSections);
        }


        LOG.debug("found #{} bar sections", barSections.size() );

        table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSection, selectedSection) -> {
            updateBar(oldSection, selectedSection);
        });


    }

    private void updateBar(BarSection oldSection, BarSection selectedSection) {



    }

    public static String getSectionType(BarSection value) {

        //<xs:element ref="ocx:RectangularTube"/>
        if ( value.getRectangularTube() != null) {
            return "Rectangular Tube";
        }
        //<xs:element ref="ocx:OctagonBar"/>
        if ( value.getOctagonBar() != null) {
            return "Octogon Bar";
        }
        //<xs:element ref="ocx:SquareBar"/>
        if ( value.getSquareBar() != null) {
            return "Square Bar";
        }
        //<xs:element ref="ocx:BulbFlat"/>
        if ( value.getBulbFlat() != null) {
            return "Bulb Flat";
        }
        //<xs:element ref="ocx:FlatBar"/>
        if ( value.getFlatBar() != null) {
            return "Flat Bar";
        }
        //<xs:element ref="ocx:UBar"/>
        if ( value.getUBar() != null) {
            return "U Bar";
        }
        //<xs:element ref="ocx:IBar"/>
        if ( value.getIBar() != null) {
            return "I";
        }
        //<xs:element ref="ocx:LBarOF"/>
        if ( value.getLBarOF() != null) {
            return "LBar OF";
        }
        //<xs:element ref="ocx:ZBar"/>
        if ( value.getZBar() != null) {
            return "Z Bar";
        }
        //<xs:element ref="ocx:RoundBar"/>
        if ( value.getRoundBar() != null) {
            return "Round Bar";
        }
        //<xs:element ref="ocx:LBar"/>
        if ( value.getLBar() != null) {
            return "L Bar";
        }
        //<xs:element ref="ocx:TBar"/>
        if ( value.getTBar() != null) {
            return "T Bar";
        }
        //<xs:element ref="ocx:LBarOW"/>
        if ( value.getLBarOW() != null) {
            return "L Bar OW";
        }
        //<xs:element ref="ocx:HalfRoundBar"/>
        if ( value.getHalfRoundBar() != null) {
            return "Halfround Bar";
        }
        //<xs:element ref="ocx:HexagonBar"/>
        if ( value.getHexagonBar() != null) {
            return "Hexagon Bar";
        }
        //<xs:element ref="ocx:Tube"/>
        if ( value.getTube() != null) {
            return "Tube";
        }

        //<xs:element ref="ocx:UserDefinedBarSection"/>
        if ( value.getUserDefinedBarSection() != null) {
            return "Tube";
        }

        return "Unknown";

    }
}
