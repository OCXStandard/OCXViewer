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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.Inclination;
import org.ocx_schema.v310.MaterialRefT;
import org.ocx_schema.v310.SectionRef;
import org.ocx_schema.v310.Stiffener;

import java.util.ArrayList;

/**
 * A page displaying information about a Stiffener.
 * The StiffenerPage is not intended to be navigated directly, but rather as a logical child.
 *
 * @author Carsten Zerbst
 */
public class StiffenerPage extends AbstractDataViewSubPage<Stiffener> {
    public static final String NAME = "Stiffener";
    private static final Logger LOG = LogManager.getLogger(StiffenerPage.class);

    public StiffenerPage(Stiffener stiffener, Page parent) {
        super(stiffener, parent, "Stiffener «" + stiffener.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Stiffener");

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
        label.setTooltip(new Tooltip("The stiffener's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), stiffener, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The stiffener's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), stiffener, "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The stiffener's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), stiffener, "GUIDRef", String.class);


        label = new Label("Function Type");
        label.setTooltip(new Tooltip("The stiffener's function type"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), stiffener, "functionType", String.class);


        //
        // physical properties
        //
        if (stiffener.getPhysicalProperties() == null) {
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
            label.setTooltip(new Tooltip("The stiffener's weight"));
            gridPane.add(label, 0, row);

            var group = createOrRebind(null, stiffener.getPhysicalProperties().getDryWeight(), true);
            gridPane.add(group, 1, row++);

            label = new Label("Center of Gravity");
            label.setTooltip(new Tooltip("The stiffener's COG"));
            gridPane.add(label, 0, row);

            group = createOrRebind(null, stiffener.getPhysicalProperties().getCenterOfGravity(), true);
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

        // MaterialRef
        if (stiffener.getMaterialRef() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No MaterialRef found in Stiffener/MaterialRef !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);

            // we add a dummy objects to prevent null pointer exceptions
            stiffener.setMaterialRef(new MaterialRefT());
        }

        label = new Label("Material Quality");
        label.setTooltip(new Tooltip("The stiffener's material"));
        gridPane.add(label, 0, row);

        if (stiffener.getMaterialRef().getReferenced() != null) {
            var link = new Hyperlink("Material  «" + stiffener.getMaterialRef().getReferenced().getId() + "»");
            link.setTooltip(new Tooltip("Goto Material"));
            gridPane.add(link, 1, row++);
            link.setOnAction(e -> {
                var robert = new ArrayList<>(getBreadcrumbs());
                robert.add(new BreadcrumbRecord(stiffener.getMaterialRef().getReferenced().getId(), MaterialPage.class, null, stiffener.getMaterialRef().getReferenced()));

                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            });
        } else if (stiffener.getMaterialRef().getLocalRef() instanceof String) {
            var naLabel = new Label("failed to resolve local ref " + stiffener.getMaterialRef().getLocalRef() + " to Material.");
            naLabel.getStyleClass().add(Styles.TEXT_MUTED);
            gridPane.add(naLabel, 1, row++);
        } else if (StringUtils.isNoneEmpty(stiffener.getMaterialRef().getGUIDRef())) {
            var naLabel = new Label("failed to resolve GUIDRef " + stiffener.getMaterialRef().getGUIDRef() + " to Material.");
            naLabel.getStyleClass().add(Styles.TEXT_MUTED);
            gridPane.add(naLabel, 1, row++);
        }

        // BarSection
        if (stiffener.getSectionRef() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No SectionRef found in Stiffener/SectionRef !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);

            // we add a dummy objects to prevent null pointer exceptions
            stiffener.setSectionRef(new SectionRef());
        }

        titelLabel = new Label("Cross Section");
        gridPane.add(titelLabel, 0, row);

        if (stiffener.getSectionRef().getReferenced() != null) {
            var link = new Hyperlink("Cross section  «" + stiffener.getSectionRef().getReferenced().getId() + "»");
            link.setTooltip(new Tooltip("Goto cross section"));
            gridPane.add(link, 1, row++);
            link.setOnAction(e -> {
                var robert = new ArrayList<>(getBreadcrumbs());
                robert.add(new BreadcrumbRecord(stiffener.getSectionRef().getReferenced().getId(), BarSectionPage.class, null, stiffener.getSectionRef().getReferenced()));

                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            });
        } else if (stiffener.getMaterialRef().getLocalRef() instanceof String) {
            var naLabel = new Label("failed to resolve local ref " + stiffener.getMaterialRef().getLocalRef() + " to Material.");
            naLabel.getStyleClass().add(Styles.TEXT_MUTED);
            gridPane.add(naLabel, 1, row++);
        } else if (StringUtils.isNoneEmpty(stiffener.getMaterialRef().getGUIDRef())) {
            var naLabel = new Label("failed to resolve GUIDRef " + stiffener.getMaterialRef().getGUIDRef() + " to Material.");
            naLabel.getStyleClass().add(Styles.TEXT_MUTED);
            gridPane.add(naLabel, 1, row++);
        }


        label = new Label("Offset U");
        label.setTooltip(new Tooltip("The stiffener's offset in horizontal direction"));
        gridPane.add(label, 0, row);

        var offU = createOrRebind(null, stiffener.getSectionRef().getOffsetU(), false);
        gridPane.add(offU, 1, row);

        label = new Label("Offset V");
        label.setTooltip(new Tooltip("The stiffener's offset in vertical direction"));
        gridPane.add(label, 2, row);

        var offV = createOrRebind(null, stiffener.getSectionRef().getOffsetV(), false);
        gridPane.add(offV, 3, row++);


        //
        // Positioning
        //
        if (stiffener.getMaterialRef() != null ||
                (stiffener.getInclinations() != null && !stiffener.getInclinations().isEmpty())) {
            titelLabel = new Label("Positioning");
            titelLabel.getStyleClass().add(Styles.TITLE_4);
            gridPane.add(titelLabel, 0, row++, 4, 1);
            GridPane.setHalignment(titelLabel, HPos.LEFT);
            GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

            if (stiffener.getOffset() != null) {
                label = new Label("Offset");
                label.setTooltip(new Tooltip("The stiffener's offset"));
                gridPane.add(label, 0, row);

                var group1 = createOrRebind(null, stiffener.getOffset(), true);
                gridPane.add(group1, 1, row++);
            }

            if (stiffener.getInclinations() != null && !stiffener.getInclinations().isEmpty()) {
                for (int i = 0; i < stiffener.getInclinations().size(); i++) {
                    final Inclination inclination = stiffener.getInclinations().get(i);

                    label = new Label("Inclination " + (i + 1));
                    label.setTooltip(new Tooltip("The stiffener's inclination no. " + (i + 1)));
                    gridPane.add(label, 0, row);

                    var group1 = createOrRebind(null, inclination.getPosition(), true);
                    gridPane.add(group1, 1, row++, 3, 1);

                    label = new Label("    Flange Direction no. " + (i + 1));
                    label.setTooltip(new Tooltip("The flange direction for inclination no. " + (i + 1)));
                    gridPane.add(label, 0, row);
                    group1 = createOrRebind(null, inclination.getFlangeDirection(), true);
                    gridPane.add(group1, 1, row);

                    label = new Label("    Web Direction  no. " + (i + 1));
                    label.setTooltip(new Tooltip("The web direction for inclination no. " + (i + 1)));
                    gridPane.add(label, 2, row);
                    group1 = createOrRebind(null, inclination.getWebDirection(), true);
                    gridPane.add(group1, 3, row++);
                }
            }
        }


        //
        // Endcuts
        //
        titelLabel = new Label("Endcuts");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


        label = new Label("Endcut 1");
        label.setTooltip(new Tooltip("The stiffener's first endcut"));
        gridPane.add(label, 0, row);


        if (stiffener.getEndCutEnd1() != null) {
            var link = new Hyperlink("Endcut  «" + stiffener.getEndCutEnd1().getId() + "»");
            link.setTooltip(new Tooltip("Goto Endcut"));
            gridPane.add(link, 1, row);
            link.setOnAction(e -> {
                var robert = new ArrayList<>(getBreadcrumbs());
                robert.add(new BreadcrumbRecord(stiffener.getEndCutEnd1().getId(), EndcutPage.class, null, stiffener.getEndCutEnd1()));

                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            });
        } else {
            var naLabel = new Label("No Endcut defined for End 1.");
            naLabel.getStyleClass().add(Styles.TEXT_MUTED);
            gridPane.add(naLabel, 1, row);
        }

        label = new Label("Endcut 2");
        label.setTooltip(new Tooltip("The stiffener's second endcut"));
        gridPane.add(label, 2, row);

        if (stiffener.getEndCutEnd2() != null) {
            var link = new Hyperlink("Endcut  «" + stiffener.getEndCutEnd2().getId() + "»");
            link.setTooltip(new Tooltip("Goto Endcut"));
            gridPane.add(link, 3, row);
            link.setOnAction(e -> {
                var robert = new ArrayList<>(getBreadcrumbs());
                robert.add(new BreadcrumbRecord(stiffener.getEndCutEnd1().getId(), EndcutPage.class, null, stiffener.getEndCutEnd2()));

                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            });
        } else {
            var naLabel = new Label("No Endcut defined for End 2.");
            naLabel.getStyleClass().add(Styles.TEXT_MUTED);
            gridPane.add(naLabel, 3, row);
        }


    }

}
