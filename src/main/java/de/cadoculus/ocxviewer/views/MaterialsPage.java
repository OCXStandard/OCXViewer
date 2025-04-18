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

import atlantafx.base.layout.InputGroup;
import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310rc3.*;

import java.util.Arrays;
import java.util.List;

public class MaterialsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Materials";
    private static final Logger LOG = LogManager.getLogger(MaterialsPage.class);

    private final TableView<Material> table;
    private final ObjectProperty<Material> selectedMaterial = new SimpleObjectProperty<>();
    private final InputGroup thermalExpGroup;

    private final Label materialLabel;
    private final TextField nameField;
    private final TextField guidField;
    private final ComboBox<String> gradeBox;
    private final InputGroup densityGroup;
    private final InputGroup youngsGroup;
    private final InputGroup poissonGroup;
    private final InputGroup yieldStressGroup;
    private final InputGroup ultimateStressGroup;


    public MaterialsPage() {
        super(NAME);

        createTitle("Information about the materials used for plates, stiffeners, and pillars.");

        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        col2.setHgrow(Priority.ALWAYS);
        col2.setMaxWidth(500);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHalignment(HPos.LEFT);
        col4.setHgrow(Priority.ALWAYS);
        col4.setMaxWidth(600);
        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);


        //gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var tableColumn1 = new TableColumn<Material, String>("Name");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getId())
        );

        var tableColumn2 = new TableColumn<Material, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<Material, String>("Grade");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName())
        );

        ObservableList<Material> materials = FXCollections.observableArrayList();
        table = new TableView<>(materials);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(200);
        int row = 0;

        gridPane.add(table, 0, row++,4,1   );

        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();

        if (ocx.getClassCatalogue() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No ClassCatalogue found in /ocx:ocxXML/ocx:ClassCatalogue !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getOcx().setClassCatalogue( new ClassCatalogue());
        }

        if (ocx.getClassCatalogue().getMaterialCatalogue() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No MaterialCatalogue found in /ocx:ocxXML/ocx:ClassCatalogue/ocx:MaterialCatalogue !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getOcx().getClassCatalogue().setMaterialCatalogue( new MaterialCatalogue());
        }

        if (ocx.getClassCatalogue().getMaterialCatalogue().getMaterials() == null ||
                ocx.getClassCatalogue().getMaterialCatalogue().getMaterials().isEmpty()) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No Material found in /ocx:ocxXML/ocx:ClassCatalogue/ocx:MaterialCatalogue !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);
            gridPane.add(warning, 0, ++row, 4, 1);

            WorkingContext.getInstance().getOcx().getClassCatalogue().setMaterialCatalogue( new MaterialCatalogue());
        }

        if ( ocx.getClassCatalogue().getMaterialCatalogue().getMaterials() != null) {
            materials.addAll(ocx.getClassCatalogue().getMaterialCatalogue().getMaterials());
        }

        LOG.debug("found #{} materials", materials.size());

        //initialize the labels
        materialLabel = new Label("Material");
        materialLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(materialLabel, 0, row++,4,1);
        GridPane.setHalignment(materialLabel, HPos.LEFT);
        GridPane.setMargin(materialLabel, new Insets(20, 0, 10, 0));

        // ocx:Name
        var label = new Label("Name");
        label.setTooltip(new Tooltip("The material's name"));
        gridPane.add(label, 0, row);

        nameField = new TextField();
        gridPane.add(nameField, 1, row);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The material's GUID"));
        gridPane.add(label, 2, row);
        guidField = new TextField();
        gridPane.add(guidField, 3, row++);

        // ocx:Grade
        label = new Label("Grade");
        label.setTooltip(new Tooltip("The material's grade"));
        gridPane.add(label, 0, row);
        gradeBox = new ComboBox<>();
        List.of("no grade given", "A", "B", "C", "D", "A32", "D32", "E32", "F32", "A36", "D36", "E36", "F36",  "A40", "D40", "E40", "F40" ).forEach(gradeBox.getItems()::add);
        gridPane.add(gradeBox, 1, row++);

        // ocx:Density
        label = new Label("Density");
        label.setTooltip(new Tooltip("The material's density"));
        gridPane.add(label, 0, row);
        densityGroup = createAndBind( null, true);
        gridPane.add(densityGroup, 1,row);

        // ocx:ThermalExpansionCoefficient
        label = new Label("Thermal Expansion Coefficient ");
        label.setTooltip(new Tooltip("The material's thermal expansion coefficient"));
        gridPane.add(label, 2, row);
        thermalExpGroup = createAndBind( null, false);
        gridPane.add(thermalExpGroup, 3,row++);


        // ocx:YoungsModulus
        label = new Label("Young's Modulus");
        label.setTooltip(new Tooltip("The material's Youngs modulus"));
        gridPane.add(label, 0, row);
        youngsGroup = createAndBind( null, true);
        gridPane.add(youngsGroup, 1,row);

        // ocx:PoissonRatio
        label = new Label("Poisson's Ratio");
        label.setTooltip(new Tooltip("The material's Poisson Ratio"));
        gridPane.add(label, 2, row);
        poissonGroup = createAndBind( null, true);
        gridPane.add(poissonGroup, 3,row++);


        // ocx:YieldStress
        label = new Label("Yield Stress");
        label.setTooltip(new Tooltip("The material's yield stress"));
        gridPane.add(label, 0, row);
        yieldStressGroup = createAndBind( null, false);
        gridPane.add(yieldStressGroup, 1,row);


        // ocx:UltimateStress
        label = new Label("Ultimate Stress");
        label.setTooltip(new Tooltip("The material's ultimate stress"));
        gridPane.add(label, 2, row);
        ultimateStressGroup = createAndBind( null, false);
        gridPane.add(ultimateStressGroup, 3,row);

        // Add listener to the table
        table.getSelectionModel().selectedItemProperty().addListener((_, oldMaterial, selectedMaterial) -> updateMaterial(oldMaterial, selectedMaterial));

    }

    @Override
    public void afterShow() {

        table.getSelectionModel().selectFirst();
    }



    private void updateMaterial(Material oldMaterial, Material newMaterial) {

        if ( newMaterial ==null) {
            materialLabel.setText("");
            nameField.setText("");
            guidField.setText("");
            gradeBox.setValue(gradeBox.getItems().getFirst());
        } else {
            materialLabel.setText("Material " + newMaterial.getId());
            nameField.setText(newMaterial.getName());
            guidField.setText(newMaterial.getGUIDRef());
            gradeBox.setValue(newMaterial.getGrade());
        }

        createOrRebind( densityGroup, newMaterial.getDensity(), true);
        createOrRebind( youngsGroup, newMaterial.getYoungsModulus(), true);
        createOrRebind( poissonGroup, newMaterial.getPoissonRatio(), true);

        createOrRebind( thermalExpGroup, newMaterial.getThermalExpansionCoefficient(), true);

        createOrRebind( yieldStressGroup, newMaterial.getYieldStress(), true);
        createOrRebind( ultimateStressGroup, newMaterial.getUltimateStress(), true);



    }

}
