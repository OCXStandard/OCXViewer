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
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.Vessel;

/**
 * A page displaying information about the ship's designation.
 *
 * @author Carsten Zerbst
 */
public class VesselDataPage extends AbstractDataViewPage {
    public static final String NAME = "Vessel Data";
    private static final Logger LOG = LogManager.getLogger(VesselDataPage.class);

    public VesselDataPage() {
        super(NAME);

        createTitle("Miscellaneous Vessel Information");

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(gridPane);

        int row = 0;

        Vessel vessel = WorkingContext.getInstance().getVessel();

        //
        // Ship Designation
        //
        var label = new Label("Ship Designation");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));


        var designation = vessel.getShipDesignation();

        if (designation == null) {

            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No ShipDesignation found in Vessel/ShipDesignation !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, row++, 4, 1);


            designation = new org.ocx_schema.v310.ShipDesignation();
            vessel.setShipDesignation(designation);
        }

        // ocx:shipName
        label = new Label("Ship Name");
        label.setTooltip(new Tooltip("The name of the ship assigned by the owner."));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), designation, "shipName", String.class);

        // callSign
        label = new Label("Call Sign");
        label.setTooltip(new Tooltip("The unique life-cycle identifier assigned to the ship by the flag state for radio communication."));
        gridPane.add(label, 0, row);

        textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), designation, "callSign", String.class);

        // numberIMO
        label = new Label("IMO Number");
        label.setTooltip(new Tooltip("A unique identification of a vessel according to IMO resolution A.600(15).\n" +
                "It is made of the three letters “IMO” in front of the Lloyd’s Register number.\n" +
                "This is a unique seven-digit number that is assigned to\n" +
                "propelled, sea-going merchant ships of 100 GT and above upon keel laying (with some exceptions).\n" +
                "See: IACS Procedural Requirements No. 11, IACS Procedure for Assigning Date of Build, 1996.\n" +
                "https://www.imo.org/en/OurWork/IIIS/Pages/IMO-Identification-Number-Schemes.aspx: \n" +
                "Information on IMO ship identification number scheme on the website of the IMO."));
        gridPane.add(label, 0, row);

        textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), designation, "numberIMO", String.class);


        // numberIMO
        label = new Label("Ship Type");
        label.setTooltip(new Tooltip("Optional string indicating the ship type."));
        gridPane.add(label, 0, row);

        textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), designation, "shipType", String.class);


        //
        // Statutory Data
        //
        label = new Label("Statutory Data");
        label.getStyleClass().add(Styles.TITLE_4);
        label.setTooltip(new Tooltip("Type definition of vessel data related to the flag state."));
        gridPane.add(label, 0, row++);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        var statutoryData = vessel.getStatutoryData();

        if (statutoryData == null) {

            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No StatutoryData found in Vessel/StatutoryData !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, row++, 4, 1);


            statutoryData = new org.ocx_schema.v310.StatutoryData();
            vessel.setStatutoryData(statutoryData);
        }

        // ocx:shipName
        label = new Label("Port Registration");
        label.setTooltip(new Tooltip("Type definition of vessel data related to the flag state."));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), statutoryData, "portRegistration", String.class);

        // Flag Stage
        label = new Label("Flag State");
        label.setTooltip(new Tooltip("The national authority with which the ship is registered (see ISO 10303-215, section 4.2.142.3)."));
        gridPane.add(label, 0, row);

        textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), statutoryData, "flagState", String.class);


        //
        // Tonnage Data
        //
        label = new Label("Tonnage Data");
        label.getStyleClass().add(Styles.TITLE_4);
        label.setTooltip(new Tooltip("The Vessel tonnage information."));
        gridPane.add(label, 0, row++);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        var tonnageData = vessel.getTonnageData();

        if (tonnageData == null) {

            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No TonnageData found in Vessel/TonnageData !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, row++, 4, 1);


            tonnageData = new org.ocx_schema.v310.TonnageData();
            vessel.setTonnageData(tonnageData);
        }

        // Tonnage
        label = new Label("Tonnage");
        label.setTooltip(new Tooltip("The numerical value resulting from the tonnage calculation (see ISO 10303-215, section 4.2.165.3)."));
        gridPane.add(label, 0, row);
        var group = createAndBind(tonnageData.getDeadWeight(), false);
        gridPane.add(group, 1, row++);

        // DeadWeight
        label = new Label("Dead Weight");
        label.setTooltip(new Tooltip("The weight of the passengers, crew, cargo, stores, ballast, fresh water, fuel oil, and other consumables being carried by a ship (see ISO 10303-215, section 4.2.74)."));
                gridPane.add(label, 0, row);
        group = createAndBind(tonnageData.getDeadWeight(), false);
        gridPane.add(group, 1, row++);



    }
}
