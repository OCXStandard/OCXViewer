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
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

/**
 * Page to display the header information of the OCX file.
 */
public class HeaderPage extends AbstractDataViewPage implements Page {

    public static final String NAME = "Header";
    private static final Logger LOG = LogManager.getLogger(HeaderPage.class);


    public HeaderPage() {
        super(NAME);

        createTitle("Information from the OCX file's header.");


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

        var label = new Label("OCX Schema");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Schema");
        label.setTooltip(new Tooltip("The OCX Schema version referenced in the XML header."));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        textField.setText( WorkingContext.getInstance().getTargetNamespace());
        gridPane.add(textField, 1, row++, 3, 1);


        label = new Label("File Identification");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Author");
        label.setTooltip(new Tooltip("Name of the XML instance."));
        gridPane.add(label, 0, row);
        textField = new TextField();
        bindToBean(textField.textProperty(), WorkingContext.getInstance().getOcx().getHeader(), "author", String.class);
        gridPane.add(textField, 1, row);


        label = new Label("Organization");
        label.setTooltip(new Tooltip("Name of originating organization."));
        gridPane.add(label, 2, row);
        textField = new TextField();
        bindToBean(textField.textProperty(), WorkingContext.getInstance().getOcx().getHeader(), "organization", String.class);
        gridPane.add(textField, 3, row++);


        label = new Label("Time Stamp");
        label.setTooltip(new Tooltip("Time stamp of the instance."));
        gridPane.add(label, 2, row);
        textField = new TextField();

        LOG.info("timestamp {}", WorkingContext.getInstance().getOcx().getHeader().getTimeStamp());

        bindToBean(textField.textProperty(), WorkingContext.getInstance().getOcx().getHeader(), "timeStamp", LocalDateTime.class);
        gridPane.add(textField, 3, row++);


        label = new Label("Source System");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(10, 0, 10, 0));

        label = new Label("Originating System");
        label.setTooltip(new Tooltip("Name of originating system or application."));
        gridPane.add(label, 0, row);
        textField = new TextField();
        bindToBean(textField.textProperty(), WorkingContext.getInstance().getOcx().getHeader(), "originatingSystem", String.class);
        gridPane.add(textField, 1, row);


        label = new Label("Application Version");
        label.setTooltip(new Tooltip("Version of originating application."));
        gridPane.add(label, 2, row);

        textField = new TextField();
        bindToBean(textField.textProperty(), WorkingContext.getInstance().getOcx().getHeader(), "applicationVersion", String.class);
        gridPane.add(textField, 3, row++);

        label = new Label("Documentation");
        label.getStyleClass().add(Styles.TITLE_4);
        label.setTooltip(new Tooltip("Documentation of the content of the XML file."));
        gridPane.add(label, 0, row, 2, 1);
        GridPane.setMargin(label, new Insets(10, 0, 10, 0));
        GridPane.setHalignment(label, HPos.LEFT);

        textField = new TextField();
        bindToBean(textField.textProperty(), WorkingContext.getInstance().getOcx().getHeader(), "documentation", String.class);
        gridPane.add(textField, 1, row, 3, 1);


    }


}
