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
import atlantafx.base.util.BBCodeParser;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;


public class LogPage extends BorderPane implements Page {

    public static final String NAME = "Log";

    public LogPage() {
        super();

        //this.setBackground(new Background(new BackgroundFill(Color.web("#bcbcbc"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMargin(this, new Insets(15));
        this.setPadding( new Insets(10));
        this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));



        this.maxHeight(1950);
        this.setMaxWidth(1800);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);
;

        var titleBox = new VBox();
        this.setTop(titleBox);

        var title = new Label( NAME);
        title.getStyleClass().add(Styles.TITLE_2);
        titleBox.getChildren().add(title);

        final TextFlow formattedText = BBCodeParser.createFormattedText("Shows the applications internal log messages");
        titleBox.getChildren().add(formattedText);


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);




    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Pane getView() {
        return this;
    }

}
