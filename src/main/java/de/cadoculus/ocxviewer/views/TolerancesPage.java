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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.QuantityT;

/**
 * The PrincipalParticularsPage class is a subclass of AbstractDataViewPage and is used to display the principal particulars of a vessel.
 * @author Carsten Zerbst
 */
public class TolerancesPage extends AbstractDataViewPage {

    public static final String NAME = "Tolerances";

    public TolerancesPage() {
        super(NAME);

        createTitle("Information on the tolerances used in the OCX file.");


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(gridPane);

        int row = 0;

        if (WorkingContext.getInstance().getVessel().getAngleTolerance() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No AngleTolerances found in Vessel/AngleTolerances !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getVessel().setAngleTolerance( new QuantityT());
        }

        if (WorkingContext.getInstance().getVessel().getDistanceTolerance() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No DistanceTolerance found in Vessel/DistanceTolerance !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getVessel().setDistanceTolerance(new QuantityT());
        }

        var label = new Label("Tolerances");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        // DistanceTolerance
        label = new Label("Distance Tolerance");
        label.setTooltip(new Tooltip("Absolute tolerance measure used by the exporting application when defining geometry."));
        gridPane.add(label, 0, ++row);

        var group2 = createAndBind(WorkingContext.getInstance().getVessel().getDistanceTolerance(), true);
        gridPane.add(group2, 1, row++);


        // ocx:FreeboardLength
        label = new Label("Angle Tolerance");
        label.setTooltip(new Tooltip("Absolute angular tolerance measure used by the exporting application when defining geometry."));
        gridPane.add(label, 0, row);

        group2 = createAndBind(WorkingContext.getInstance().getVessel().getAngleTolerance(), true);
        gridPane.add(group2, 1, row);



    }




}
