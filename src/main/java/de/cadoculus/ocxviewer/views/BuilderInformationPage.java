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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.BuilderInformation;

import java.time.Year;

/**
 * Page for the builder information.
 * @author Carsten Zerbst
 */
public class BuilderInformationPage extends AbstractDataViewPage{
    public static final String NAME = "Builder Information";
    private static final Logger LOG = LogManager.getLogger(BuilderInformationPage.class);

    public BuilderInformationPage() {
        super(NAME);

        LOG.debug("create BuilderInformationPage");
        createTitle("Information about the builder of the OCX file.");


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = createDefaultGrid();

        int row = 0;


        var builderInformation = WorkingContext.getInstance().getVessel().getBuilderInformation();

        if ( builderInformation==null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No BuilderInformation found in Vessel/BuilderInformation !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            gridPane.add(warning, 0, ++row, 4, 1);

            builderInformation = new BuilderInformation();

            WorkingContext.getInstance().getVessel().setBuilderInformation( builderInformation);
        }

        var label = new Label("Yard");
        label.setTooltip(new Tooltip("Name of the construction yard."));
        gridPane.add(label, 0, ++row);

        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), builderInformation, "yard", String.class);


        label = new Label("Designer");
        label.setTooltip(new Tooltip("The name of the designer of the vessel."));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row);
        bindToBean(textField.textProperty(), builderInformation, "designer", String.class);


        label = new Label("Owner");
        label.setTooltip(new Tooltip("Contractor of the vessel."));
        gridPane.add(label, 0, ++row);

        textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), builderInformation, "owner", String.class);


        label = new Label("Year of Build");
        label.setTooltip(new Tooltip("Keel laying date."));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row);
        bindToBean(textField.textProperty(), builderInformation, "yearOfBuild", Year.class);



    }
}
