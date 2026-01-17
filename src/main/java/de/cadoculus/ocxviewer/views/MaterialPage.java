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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.Material;

import java.util.List;

/**
 * A page displaying information about a Stiffener.
 * The StiffnerPage is not intended to be navigated directly, but rather as a logical child.
 *
 * @author Carsten Zerbst
 */
public class MaterialPage extends AbstractDataViewSubPage<org.ocx_schema.v310.Material> {
    public static final String NAME = "Stiffener";
    private static final Logger LOG = LogManager.getLogger(MaterialPage.class);

    public MaterialPage(org.ocx_schema.v310.Material material, Page parent) {
        super(material, parent, "Material \u00AB" + material.getId() + "\u00BB");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about a Material.");

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


        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++,4,1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        // ocx:Name
        var label = new Label("Id");
        label.setTooltip(new Tooltip("The material's Id"));
        gridPane.add(label, 0, row);

        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), material, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The material's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), material, "name", String.class);


        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The material's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), material, "GUIDRef", String.class);

        titelLabel = new Label("Strength");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++,4,1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        // ocx:Grade
        label = new Label("Grade");
        label.setTooltip(new Tooltip("The material's grade"));
        gridPane.add(label, 0, row);
        var gradeBox = new ComboBox<>();
        List.of("no grade given", "A", "B", "C", "D", "A32", "D32", "E32", "F32", "A36", "D36", "E36", "F36", "A40", "D40", "E40", "F40").forEach(gradeBox.getItems()::add);
        gridPane.add(gradeBox, 1, row++);
        gradeBox.setValue(material.getGrade());


        // ocx:YoungsModulus
        label = new Label("Young's Modulus");
        label.setTooltip(new Tooltip("The material's Youngs modulus"));
        gridPane.add(label, 0, row);
        var youngsGroup = createAndBind(material.getYoungsModulus(), true);
        gridPane.add(youngsGroup, 1, row);

        // ocx:PoissonRatio
        label = new Label("Poisson's Ratio");
        label.setTooltip(new Tooltip("The material's Poisson Ratio"));
        gridPane.add(label, 2, row);
        var poissonGroup = createAndBind(material.getPoissonRatio(), true);
        gridPane.add(poissonGroup, 3, row++);


        // ocx:YieldStress
        label = new Label("Yield Stress");
        label.setTooltip(new Tooltip("The material's yield stress"));
        gridPane.add(label, 0, row);
        var yieldStressGroup = createAndBind(material.getYieldStress(), false);
        gridPane.add(yieldStressGroup, 1, row);


        // ocx:UltimateStress
        label = new Label("Ultimate Stress");
        label.setTooltip(new Tooltip("The material's ultimate stress"));
        gridPane.add(label, 2, row);
        var ultimateStressGroup = createAndBind(material.getUltimateStress(), false);
        gridPane.add(ultimateStressGroup, 3, row++);

        titelLabel = new Label("Miscellaneous");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++,4,1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        // ocx:Density
        label = new Label("Density");
        label.setTooltip(new Tooltip("The material's density"));
        gridPane.add(label, 0, row);
        var densityGroup = createAndBind(material.getDensity(), true);
        gridPane.add(densityGroup, 1, row++);


        // ocx:ThermalExpansionCoefficient
        label = new Label("Thermal Expansion Coefficient ");
        label.setTooltip(new Tooltip("The material's thermal expansion coefficient"));
        gridPane.add(label, 0, row);
        var thermalExpGroup = createAndBind(material.getThermalExpansionCoefficient(), false);
        gridPane.add(thermalExpGroup, 1, row++);

    }


}
