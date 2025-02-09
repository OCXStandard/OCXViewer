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
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

/**
 * The PrincipalParticularsPage class is a subclass of AbstractDataViewPage and is used to display the principal particulars of a vessel.
 */
public class PrincipalParticularsPage extends AbstractDataViewPage {

    public static final String NAME = "Principal Particulars";

    public PrincipalParticularsPage() {
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



        if (WorkingContext.getInstance().getVessel().getClassificationData() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No Classification Data found in Vessel/ClassificationData !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getVessel().setClassificationData(new ClassificationData());
        }

        if (WorkingContext.getInstance().getVessel().getClassificationData().getPrincipalParticulars() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No PrincipalParticulars found in Vessel/ClassificationData/PrincipalParticulars !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getVessel().getClassificationData().setPrincipalParticulars(new PrincipalParticulars());
        }

        final PrincipalParticulars prince = WorkingContext.getInstance().getVessel().getClassificationData().getPrincipalParticulars();

        var label = new Label("Lengths and Positions");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        // ocx:Lpp
        label = new Label("Lpp");
        label.setTooltip(new Tooltip("Length between perpendiculars"));
        gridPane.add(label, 0, ++row);

        var group2 = createAndBind(prince.getLpp(), true);
        gridPane.add(group2, 1, row);


        // ocx:FreeboardLength
        label = new Label("Freeboard Length");
        label.setTooltip(new Tooltip("The free-board length of the Vessel, Lll."));
        gridPane.add(label, 2, row);

        group2 = createAndBind(prince.getFreeboardLength(), true);
        gridPane.add(group2, 3, row);

        // ocx:RuleLength
        label = new Label("Rule Length");
        label.setTooltip(new Tooltip("Length of the ship according to the classification society rules"));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getRuleLength(), true);
        gridPane.add(group2, 1, row);

        // ocx:LengthOfWaterline" minOccurs="0"/>
        label = new Label("Length of Waterline");
        label.setTooltip(new Tooltip("The length of the waterline at T, Lwl."));
        gridPane.add(label, 2, row);

        group2 = createAndBind(prince.getLengthOfWaterline(), false);
        gridPane.add(group2, 3, row);


        //ocx:DeepestEquilibriumWL" minOccurs="0"/>
        label = new Label("Deepest Equilibrium WL");
        label.setTooltip(new Tooltip("Deepest equilibrium waterline in damaged condition."));
        gridPane.add(label, 2, ++row);
        group2 = createAndBind(prince.getDeepestEquilibriumWL(), false);
        gridPane.add(group2, 3, row);


        //ocx:FP_Pos
        label = new Label("FP Pos");
        label.setTooltip(new Tooltip("Forward Perpendicular Position"));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getFPPos(), true);
        gridPane.add(group2, 1, row);

        //ocx:AP_Pos
        label = new Label("AP Pos");
        label.setTooltip(new Tooltip("Aftward Perpendicular Position"));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getAPPos(), true);
        gridPane.add(group2, 3, row);


        label = new Label("Breadths and Depths");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row, 4, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(30, 0, 10, 0));

        //        ocx:MouldedBreadth
        label = new Label("Moulded Breadth");
        label.setTooltip(new Tooltip("The maximum breadth of the ship measured between the moulded lines of the ship"));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getMouldedBreadth(), true);
        gridPane.add(group2, 1, row);


        //        ocx:MouldedDepth
        label = new Label("Moulded Depth");
        label.setTooltip(new Tooltip("The moulded depth of the ship, Hm"));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getMouldedDepth(), true);
        gridPane.add(group2, 3, row);

        //        ocx:ScantlingDraught
        label = new Label("Scantling Draught");
        label.setTooltip(new Tooltip("Design draught moulded, fully loaded condition, Td. The summer load draught used by the classification society in its calculations for structural integrity and strength (see ISO 10303-218, section 4.2.32.6)."));
        gridPane.add(label, 2, ++row);
        group2 = createAndBind(prince.getScantlingDraught(), true);
        gridPane.add(group2, 3, row);


        //ocx:NormalBallastDraught" minOccurs="0"/>
        label = new Label("Normal Ballast Draught");
        label.setTooltip(new Tooltip("The Vessel draught at normal ballast, Tnb."));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getNormalBallastDraught(), false);
        gridPane.add(group2, 1, row);

        //ocx:HeavyBallastDraught" minOccurs="0"/>
        label = new Label("Heavy Ballast Draught");
        label.setTooltip(new Tooltip("The Vessel draught at heavy ballast, Thb."));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getHeavyBallastDraught(), false);
        gridPane.add(group2, 3, row);


        //ocx:SlammingDraughtEmptyFP" minOccurs="0"/>
        label = new Label("Slamming Draught Empty FP");
        label.setTooltip(new Tooltip("The design slamming draught at FP (all ballast tanks empty), Tf-e."));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getSlammingDraughtEmptyFP(), false);
        gridPane.add(group2, 1, row);

        //ocx:SlammingDraughtFullFP" minOccurs="0"/>
        label = new Label("Slamming Draught Full FP");
        label.setTooltip(new Tooltip("The Vessel draught at FP used when calculation design slamming loads (all ballast tanks full), Tf-f."));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getSlammingDraughtFullFP(), false);
        gridPane.add(group2, 3, row);


        //-------------
        label = new Label("Heights and Deck Information");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row, 4, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(30, 0, 10, 0));

        //ocx:FreeboardDeckHeight" minOccurs="0"/>
        label = new Label("Freeboard Deck Height");
        label.setTooltip(new Tooltip("The height of free-board deck, D1."));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getFreeboardDeckHeight(), false);
        gridPane.add(group2, 1, row);

        //ocx:ZPosOfDeck" minOccurs="0"/>
        label = new Label("ZPos of Deck");
        label.setTooltip(new Tooltip("Z coordinate of the bulkhead deck."));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getZPosOfDeck(), false);
        gridPane.add(group2, 3, row);

        //ocx:ZPosDeckline" minOccurs="0"/>
        label = new Label("ZPos of Deckline");
        label.setTooltip(new Tooltip("Vertical distance from baseline to deck-line at FE."));
        gridPane.add(label, 2, ++row);
        group2 = createAndBind(prince.getZPosDeckline(), false);
        gridPane.add(group2, 3, row);

        //ocx:UpperDeckArea" minOccurs="0"/>
        label = new Label("UpperDeckArea");
        label.setTooltip(new Tooltip("Projected area of upper deck forward 0.2 L."));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getUpperDeckArea(), false);
        gridPane.add(group2, 1, row);

        //ocx:WaterPlaneArea" minOccurs="0"/>
        label = new Label("WaterPlaneArea");
        label.setTooltip(new Tooltip("The area of water-plane forward 0.2 L at scantling draught Td."));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getWaterPlaneArea(), false);
        gridPane.add(group2, 3, row);

        //------------------------
        label = new Label("Miscellaneous");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row, 4, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        //ocx:BlockCoefficient
        label = new Label("Block Coefficient");
        label.setTooltip(new Tooltip("The ratio of the moulded displacement volume to the volume of a block that has its length equal to the length class, its breadth equal to the moulded breadth and its depth equal\t\t\t\t\tto the scantlings draught (see ISO 10303-218, section 4.2.32.1)."));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getBlockCoefficient(), true);
        gridPane.add(group2, 1, row);

        //ocx:DesignSpeed
        label = new Label("Design Speed");
        label.setTooltip(new Tooltip("The forward or service speed at which the ship is designed to operate (see ISO 10303-218, section 4.2.32.2)."));
        gridPane.add(label, 0, ++row);
        group2 = createAndBind(prince.getDesignSpeed(), true);
        gridPane.add(group2, 1, row);

        //ocx:SpeedFactor" minOccurs="0"/>
        label = new Label("Speed Factor");
        label.setTooltip(new Tooltip("Speed factor Cav."));
        gridPane.add(label, 2, row);
        group2 = createAndBind(prince.getSpeedFactor(), false);
        gridPane.add(group2, 3, row);

    }




}
