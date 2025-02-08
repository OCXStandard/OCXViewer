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
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310rc3.ClassNotation;
import org.ocx_schema.v310rc3.ClassificationSociety;

import java.util.Arrays;

public class ClassficationSocietyPage extends AbstractDataViewPage {

    public static final String NAME = "Classfication Society";
    private static final Logger LOG = LogManager.getLogger(ClassficationSocietyPage.class);


    public ClassficationSocietyPage() {
        super(NAME);


        createTitle("Information that specifies design and intended performance characteristics of the ship in accordance with classification society rules and statutory regulations (see ISO 10303-218, section 4.2.36).");

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


        int row = 0;
        // Newbuilding Society
        var label = new Label("Classification Society");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Newbuilding Society");
        label.setTooltip(new Tooltip("The name and organizational details of the classification society whose rules and regulations are being used to assess the ship during construction."));
        gridPane.add(label, 0, ++row);

        final var combo = new ComboBox<String>();

        Arrays.asList(ClassificationSociety.values()).stream().
                forEach(classificationSocietyEnum -> {
                    combo.getItems().add(classificationSocietyEnum.name());
                });

        StringProperty nbcs = new SimpleStringProperty();
        try {
            ClassificationSociety enu = WorkingContext.getInstance().getVessel().getClassificationData().getNewbuildingSociety();
            nbcs.setValue(enu != null ? enu.name() : "unset");
        } catch (Exception e) {
            LOG.error("Error getting Newbuilding Society", e);
        }
        combo.valueProperty().bindBidirectional(nbcs);

        gridPane.add(combo, 1, row);

        label = new Label("Newbuilding Society Name");
        label.setTooltip(new Tooltip("The common name of the class society relevant for operating the ship. Needs only to be specified when @newbuildingSociety = OTHER"));
        gridPane.add(label, 2, row);

        var textField = new TextField();
        gridPane.add(textField, 3, row);

        // Society

        label = new Label("Society");
        label.setTooltip(new Tooltip("The name and organizational details of the classification society whose rules and regulations are being used to assess the ship during construction."));
        gridPane.add(label, 0, ++row);

        var societyCombo = new ComboBox<String>();
        societyCombo.getItems().addAll("ABS", "BV", "CCS", "DNV", "GL", "KR", "LR", "NK", "NV", "PR", "RS", "RINA", "OTHER");
        gridPane.add(societyCombo, 1, row);

        StringProperty cs = new SimpleStringProperty();
        societyCombo.valueProperty().bindBidirectional(cs);

        try {
            ClassificationSociety enu = WorkingContext.getInstance().getVessel().getClassificationData().getSociety();
            cs.setValue(enu != null ? enu.name() : "unset");

        } catch (Exception e) {
            LOG.error("Error getting Newbuilding Society", e);
        }


        label = new Label("Society Name");
        label.setTooltip(new Tooltip("The common name of the class society relevant for operating the ship. Needs only to be specified when @society = OTHER"));
        gridPane.add(label, 2, row);


        textField = new TextField();
        gridPane.add(textField, 3, row);

        bindToBean(textField.textProperty(), WorkingContext.getInstance().getVessel().getClassificationData(), "SocietyName", String.class);


        label = new Label("Class Notation");
        label.setTooltip(new Tooltip("The notations given to the hull and machinery of the Ship by the classification society as a result of its approval activities during the design, manufacture and in-service maintenance of the ship (see ISO 10303-218, section 4.2.35)"));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);


        if (WorkingContext.getInstance().getVessel().getClassificationData().getClassNotation() == null) {

            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No Class Notation found in Vessel/ClassificationData/ClassNotation !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);


            // we add a dummy objects to prevent null pointer exceptions
            WorkingContext.getInstance().getVessel().getClassificationData().setClassNotation(new ClassNotation());
        }
        final ClassNotation classNotation = WorkingContext.getInstance().getVessel().getClassificationData().getClassNotation();

        label = new Label("Hull");
        label.setTooltip(new Tooltip("The notation given to the hull of the ship by the classification society as a result of its approval activities done on the hull."));
        gridPane.add(label, 0, ++row);
        var classNotationHull = new TextField();
        bindToBean(classNotationHull.textProperty(), classNotation, "Hull", String.class);
        gridPane.add(classNotationHull, 1, row);


        label = new Label("Machinery");
        label.setTooltip(new Tooltip("The notation given to the machinery on the ship by the classification society as a result of its approval activities done on the machinery."));
        gridPane.add(label, 2, row);
        var classNotationMachinery = new TextField();
        bindToBean(classNotationMachinery.textProperty(), classNotation, "Machinery", String.class);
        gridPane.add(classNotationMachinery, 3, row);

        label = new Label("Service Area");
        label.setTooltip(new Tooltip("The area or route in which the ship operates. NOTE: This may include information about waterway, wave, weather and wind conditions."));
        gridPane.add(label, 0, ++row);
        var classNotationServiceArea = new TextField();
        bindToBean(classNotationServiceArea.textProperty(), classNotation, "ServiceArea", String.class);
        gridPane.add(classNotationServiceArea, 1, row);

        label = new Label("Service Factor");
        label.setTooltip(new Tooltip("The service area of the ship and the waves that occur in that area. The service factor should be in the range of 0.5 to 1.0."));
        gridPane.add(label, 2, row);
        var classNotationServiceFactor = new TextField();


        bindToBean(classNotationServiceFactor.textProperty(), classNotation, "ServiceFactor", Double.TYPE);
        gridPane.add(classNotationServiceFactor, 3, row);

        label = new Label("Ice Class");
        label.setTooltip(new Tooltip("The type of class notation given to the ship indicating the ice conditions in which the ship has been approved to operate."));
        gridPane.add(label, 0, ++row);
        var classNotationIceClass = new TextField();
        bindToBean(classNotationIceClass.textProperty(), classNotation, "IceClass", String.class);
        gridPane.add(classNotationIceClass, 1, row);


        label = new Label("Additional Annotations");
        label.setTooltip(new Tooltip("Additional notations assigned by the society."));
        gridPane.add(label, 0, ++row);
        var classNotationAdditional = new TextField();
        bindToBean(classNotationAdditional.textProperty(), classNotation, "AdditionalNotations", String.class);
        gridPane.add(classNotationAdditional, 1, row);


    }


}
