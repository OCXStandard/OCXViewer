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
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.FeatureCope;

import java.util.ArrayList;

/**
 * A page displaying information about a Bracket.
 * The BracketPage is not intended to be navigated directly, but rather as a logical child.
 *
 * @author Carsten Zerbst
 */
public class BracketPage extends AbstractDataViewSubPage<org.ocx_schema.v310.Bracket> {
    public static final String NAME = "Bracket";
    private static final Logger LOG = LogManager.getLogger(BracketPage.class);

    public BracketPage(org.ocx_schema.v310.Bracket bracket, Page parent) {
        super(bracket, parent, "Bracket «" + bracket.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Bracket");

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();
        scrollPane.setContent(gridPane);

        int row = 0;

        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        // ocx:Name
        var label = new Label("Id");
        label.setTooltip(new Tooltip("The bracket's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), getObject(), "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The bracket's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), getObject(), "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The bracket's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), getObject(), "GUIDRef", String.class);

        //
        // Bracket Parameters
        //
        if (bracket.getBracketParameters() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "Not Bracket Paramters found in Bracket",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, row, 4, 1);
        } else {
            label = new Label("Bracket Parameters");
            titelLabel.getStyleClass().add(Styles.TITLE_4);
            gridPane.add(titelLabel, 0, row++, 4, 1);
            GridPane.setHalignment(titelLabel, HPos.LEFT);
            GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


            label = new Label("Origin");
            label.setTooltip(new Tooltip("The origin or root point of the Bracket"));
            gridPane.add(label, 0, row);

            var group = createOrRebind(null, bracket.getBracketParameters().getOrigin(), true);
            gridPane.add(group, 1, row++);


            // U
            label = new Label("U-Arm Length");
            label.setTooltip(new Tooltip("The bracket's U arm length"));
            gridPane.add(label, 0, row);

            group = createOrRebind(null, bracket.getBracketParameters().getArmLengthU(), true);
            gridPane.add(group, 1, row);

            label = new Label("U-Direction");
            label.setTooltip(new Tooltip("Local U direction of the Bracket"));
            gridPane.add(label, 2, row);

            group = createOrRebind(null, bracket.getBracketParameters().getUDirection(), true);
            gridPane.add(group, 3, row++);

            // V
            label = new Label("V-Arm Length");
            label.setTooltip(new Tooltip("The bracket's V arm length"));
            gridPane.add(label, 0, row);

            group = createOrRebind(null, bracket.getBracketParameters().getArmLengthV(), true);
            gridPane.add(group, 1, row);

            label = new Label("V-Direction");
            label.setTooltip(new Tooltip("Local V direction of the Bracket"));
            gridPane.add(label, 2, row);

            group = createOrRebind(null, bracket.getBracketParameters().getVDirection(), true);
            gridPane.add(group, 3, row++);


            // Nose
            label = new Label("U Nose");
            label.setTooltip(new Tooltip("?? the height of the bracket's nose in U direction??"));
            gridPane.add(label, 0, row);
            group = createAndBind(bracket.getBracketParameters().getUnose(), false);
            gridPane.add(group, 1, row);

            label = new Label("V Nose");
            label.setTooltip(new Tooltip("?? the height of the bracket's nose in V direction??"));
            gridPane.add(label, 2, row);
            group = createAndBind(bracket.getBracketParameters().getUnose(), false);
            gridPane.add(group, 3, row);


            label = new Label("Free Edge Radius");
            label.setTooltip(new Tooltip("??"));
            gridPane.add(label, 0, row);
            group = createAndBind(bracket.getBracketParameters().getFreeEdgeRadius(), false);
            gridPane.add(group, 1, row++);


            if ( bracket.getBracketParameters().getFeatureCope() != null ) {

                label = new Label("Feature Cope");
                titelLabel.getStyleClass().add(Styles.TITLE_4);
                gridPane.add(titelLabel, 0, row++, 4, 1);
                GridPane.setHalignment(titelLabel, HPos.LEFT);
                GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

                label = new Label("Cope Radius");
                label.setTooltip(new Tooltip("??"));
                gridPane.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFeatureCope().getCopeRadius(), true);
                gridPane.add(group, 1, row++);

                label = new Label("Cope Length");
                label.setTooltip(new Tooltip("The length of the cope measured along the stiffener trace-line (X-axis)  from the end of the stiffener to the centre of the cope radius."));
                gridPane.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFeatureCope().getCopeLength(), false);
                gridPane.add(group, 1, row);

                label = new Label("Cope Height");
                label.setTooltip(new Tooltip("The height of the cope measured along the cross section local V-direction from the root point to the centre of the cope radius."));
                gridPane.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFeatureCope().getCopeHeight(), false);
                gridPane.add(group, 1, row);
            }

            if ( bracket.getBracketParameters().getFlangeEdgeReinforcement() != null ) {
                label = new Label("Flange Edge Reinforcement");
                label.setTooltip(new Tooltip("Bracket flange edge reinforcement parameters."));
                titelLabel.getStyleClass().add(Styles.TITLE_4);
                gridPane.add(titelLabel, 0, row++, 4, 1);
                GridPane.setHalignment(titelLabel, HPos.LEFT);
                GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

                label = new Label("Flange Width");
                label.setTooltip(new Tooltip("The width of the bracket flange edge reinforcement."));
                gridPane.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFlangeEdgeReinforcement().getFlangeWidth(), false);
                gridPane.add(group, 1, row++);

                label = new Label("Radius");
                label.setTooltip(new Tooltip("The bend radius of the transition zone between bracket web and bracket flange."));
                gridPane.add(label, 2, row);
                group = createAndBind(bracket.getBracketParameters().getFlangeEdgeReinforcement().getRadius(), false);
                gridPane.add(group, 3, row++);
            }


        }


        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);



        // Physical Properties
        if (bracket.getPhysicalProperties() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "Not Physical Properties found in Stiffener",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, row, 4, 1);
        } else {
            titelLabel = new Label("Physical Properties");
            titelLabel.getStyleClass().add(Styles.TITLE_4);
            gridPane.add(titelLabel, 0, row++, 4, 1);
            GridPane.setHalignment(titelLabel, HPos.LEFT);
            GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


            label = new Label("Weight");
            label.setTooltip(new Tooltip("The bracket's weight"));
            gridPane.add(label, 0, row);

            var group = createOrRebind(null, bracket.getPhysicalProperties().getDryWeight(), true);
            gridPane.add(group, 1, row++);

            label = new Label("Center of Gravity");
            label.setTooltip(new Tooltip("The bracket's COG"));
            gridPane.add(label, 0, row);

            group = createOrRebind(null, bracket.getPhysicalProperties().getCenterOfGravity(), true);
            gridPane.add(group, 1, row++);

        }

        // Custom Properties
        label = new Label("Custom Properties");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        var link = new Hyperlink("View Custom Properties");
        link.setTooltip(new Tooltip("Goto Custom Properties page"));
        gridPane.add(link, 0, row++, 2, 1);
        link.setOnAction(e -> {
            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord("Custom Properties", CustomPropertiesPage.class, null, getObject()));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        });


    }

}
