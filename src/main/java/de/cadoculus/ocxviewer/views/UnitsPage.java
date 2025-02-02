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
import org.ocx_schema.v310rc3.*;
import de.cadoculus.ocxviewer.models.UnitRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import oasis.unitsml.*;
import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

import java.util.ArrayList;
import java.util.List;

public class UnitsPage extends AbstractDataViewPage{
    public static final String NAME = "Units";
    private static final Logger LOG = LogManager.getLogger(UnitsPage.class);

    public UnitsPage() {
        super(NAME);

        createTitle("Information about the used unitRecords.");

        var col1 = new TableColumn<UnitRecord, String>("ID");
        col1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().id())
        );

        var col2 = new TableColumn<UnitRecord, String>("Names");
        col2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().name())
        );

        var col3 = new TableColumn<UnitRecord, String>("Symbols");
        col3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().symbol())
        );

        ObservableList<UnitRecord> unitRecords = new SimpleListProperty<>();
        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();
        final UnitsML unitsML = ocx.getUnitsML();
        final UnitSet unitSet = unitsML.getUnitSet();
        final List<Unit> units = unitSet.getUnits();
                
                units.forEach(
                unit -> unitRecords.add(UnitRecord.create(unit))
        );

        var table = new TableView<UnitRecord>(unitRecords);
        table.getColumns().setAll(col1, col2, col3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );
        table.getSelectionModel().selectFirst();
        //snippet_1:end

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(300);



        setCenter(table);

    }
}
