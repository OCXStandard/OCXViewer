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
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.Plate;

import java.util.ArrayList;

/**
 * A page displaying information about a Plate.
 * The PlatePage is not intended to be navigated directly, but rather as a logical child.
 *
 * @author Carsten Zerbst
 */
public class PlatePage extends AbstractDataViewSubPage<Plate> {
    public static final String NAME = "Plate";
    private static final Logger LOG = LogManager.getLogger(PlatePage.class);

    public PlatePage(Plate plate, Page parent) {
        super(plate, parent, "Plate «" + plate.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Plate");

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
        label.setTooltip(new Tooltip("The plate's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), plate, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The plate's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), plate, "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The plate's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), plate, "GUIDRef", String.class);

        //
        // physical properties
        //
        if ( plate.getPhysicalProperties() ==null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "Not Physical Properties found in Plate",
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
            label.setTooltip(new Tooltip("The stiffener's weight"));
            gridPane.add(label, 0, row);

            var group = createOrRebind(null, plate.getPhysicalProperties().getDryWeight(), true);
            gridPane.add(group, 1, row++);

            label = new Label("Center of Gravity");
            label.setTooltip(new Tooltip("The stiffener's COG"));
            gridPane.add(label, 0, row);

            group = createOrRebind(null, plate.getPhysicalProperties().getCenterOfGravity(), true);
            gridPane.add(group, 1, row++);

        }


        //
        // Raw Material
        //
        titelLabel = new Label("Raw Material");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


        if (plate.getPlateMaterial() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No PlateMaterial found in Panel/PlateMaterial !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);

            // we add a dummy objects to prevent null pointer exceptions
            plate.setPlateMaterial(new org.ocx_schema.v310.PlateMaterial());

        }

        label = new Label("Thickness");
        label.setTooltip(new Tooltip("The plate's thickness"));
        gridPane.add(label, 0, row);
        var group1 = createAndBind(plate.getPlateMaterial().getThickness(), true);
        gridPane.add(group1, 1, row);


        label = new Label("Offset");
        label.setTooltip(new Tooltip("The plate's offset"));
        gridPane.add(label, 2, row);
        group1 = createAndBind(plate.getOffset(), true);
        gridPane.add(group1, 3, row++);



        label = new Label("Material Quality");
        label.setTooltip(new Tooltip("The plate's material"));
        gridPane.add(label, 0, row);

        if ( plate.getPlateMaterial().getReferenced() != null) {
            var link = new Hyperlink("Material  «" + plate.getPlateMaterial().getReferenced().getId() + "»");
            link.setTooltip(new Tooltip("Goto Material"));
            gridPane.add(link, 1, row++);
            link.setOnAction(e -> {
                var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
                robert.add(new BreadcrumbRecord(plate.getPlateMaterial().getReferenced().getId(), MaterialPage.class, null, plate.getPlateMaterial().getReferenced()));

                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            });
        } else if ( plate.getPlateMaterial().getLocalRef() instanceof  String ) {
            var naLabel = new Label("failed to resolve local ref " + plate.getPlateMaterial().getLocalRef() + " to Material.");
            naLabel.getStyleClass().add(Styles.WARNING);
            gridPane.add(naLabel, 1, row++);
        } else if (StringUtils.isNoneEmpty(plate.getPlateMaterial().getGUIDRef( )) ) {
            var naLabel = new Label("failed to resolve GUIDRef " + plate.getPlateMaterial().getGUIDRef() + " to Material.");
            naLabel.getStyleClass().add(Styles.WARNING);
            gridPane.add(naLabel, 1, row++);
        } else {
            var naLabel = new Label("failed to resolve MaterialRef, not localRef or GUIDRef found");
            naLabel.getStyleClass().add(Styles.WARNING);
            gridPane.add(naLabel, 1, row++);
        }





    }

}
