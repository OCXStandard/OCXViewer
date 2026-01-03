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
import de.cadoculus.ocxviewer.logging.LogRecord;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;

import java.util.List;

/**
 * Page that shows the applications internal log messages.
 * @author Carsten Zerbst
 */
public class LogPage extends AbstractDataViewPage  {

    public static final String NAME = "Log Page";
    private static final Logger LOG = LogManager.getLogger(LogPage.class);

    private static LogPage INSTANCE;
    private final ListView<LogRecord> listBox;


    public static LogPage getInstance() {
        return INSTANCE;
    }
    public void addEvent( LogRecord event) {

        if ( event.category().compareTo( Level.INFO) >0) {
            return;
        }

        Platform.runLater(() -> {
            if ( listBox.getItems().size() > 500) {
                listBox.getItems().remove(0,100);
            }

            listBox.getItems().add(event);
        });

    }

    public LogPage() {
        super(NAME);
        INSTANCE=this;

        //this.setBackground(new Background(new BackgroundFill(Color.web("#bcbcbc"), CornerRadii.EMPTY, Insets.EMPTY)));
        BorderPane.setMargin(this, new Insets(15));

        this.getStyleClass().add("content-pane");

        this.maxHeight(1950);
        this.setMaxWidth(1800);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);

        var titleBox = new VBox();
        this.setTop(titleBox);

        var title = new Label( NAME);
        title.getStyleClass().add(Styles.TITLE_2);
        titleBox.setPadding( new Insets(0, 0, 10 , 0));
        titleBox.getChildren().add(title);
        final TextFlow formattedText = BBCodeParser.createFormattedText("Shows the applications internal log messages");
        titleBox.getChildren().add(formattedText);


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        this.listBox = new ListView<>();
        scrollPane.setContent(listBox);
        listBox.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(LogRecord item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.msg());
                    StringBuilder tooltipContent = new StringBuilder(item.category().name());
                    tooltipContent.append(" \n\n");
                    tooltipContent.append(item.msg());
                    if (item.thrown() != null) {
                        tooltipContent.append("\n\n");
                        tooltipContent.append(item.thrown().getMessage());
                    }

                    setTooltip(new Tooltip(tooltipContent.toString()));

                    if (item.category() == Level.INFO) {

                        setGraphic(new FontIcon(MaterialDesignI.INFORMATION_OUTLINE));
                        if (getIndex() % 2 == 0) {
                            setStyle("-fx-background-color: -color-bg-default");
                        } else if (WorkingContext.getInstance().darkModeProperty().get()) {
                            setStyle("-fx-background-color: -color-base-8");
                        } else {
                            setStyle("-fx-background-color: -color-base-1");
                        }

                    } else if (item.category() == Level.WARN) {
                        setGraphic(new FontIcon(MaterialDesignE.EXCLAMATION_THICK));

                        if (getIndex() % 2 == 0) {
                            setStyle("-fx-background-color: -color-warning-0");
                        } else {
                            setStyle("-fx-background-color: -color-warning-1");
                        }
                    } else if (item.category() == Level.ERROR) {
                        setGraphic(new FontIcon(MaterialDesignF.FLASH));

                        if (getIndex() % 2 == 0) {
                            setStyle("-fx-background-color: -color-danger-0");
                        } else {
                            setStyle("-fx-background-color: -color-danger-1");
                        }
                    } else {
                        setGraphic(null);
                    }
                }
            }
        });

//        listBox.getSelectionModel().selectedItemProperty().addListener(
//                new ChangeListener<LogRecord>() {
//                    public void changed(ObservableValue<? extends LogRecord> ov,
//                                        LogRecord old_val, LogRecord new_val) {
//                        LOG.debug("Selected LogRecord: " + new_val);
//                    }
//                });


    }


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Pane getView() {
        return this;
    }

    @Override
    public List<BreadcrumbRecord> getBreadcrumbs() {
        return List.of(  new BreadcrumbRecord(getName(), LogPage.class, this, null));
    }

    @Override
    public void beforeShow() {

    }

    @Override
    public void afterShow() {

    }

    @Override
    public void beforeHide() {

    }

    @Override
    public void afterHide() {

    }

    @Override
    public void beforeClose() {

    }

}
