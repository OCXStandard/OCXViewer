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
import atlantafx.base.util.BBCodeParser;
import org.ocx_schema.v310rc3.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;

/**
 * The base class for data views
 */
abstract class AbstractDataViewPage extends BorderPane implements Page {

    private final String name;

    protected AbstractDataViewPage(String name) {
        super();

        this.name = name;

        BorderPane.setMargin(this, new Insets(15));

        this.maxHeight(1950);
        this.setMaxWidth(1800);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);

        this.getStyleClass().add("content-pane");

    }

    /**
     * Create a title for the page
     *
     * @param description the description to display as explanation
     */
    protected void createTitle(String description) {
        var titleBox = new VBox();
        this.setTop(titleBox);

        var title = new Label(name);
        title.getStyleClass().add(Styles.TITLE_2);
        titleBox.setPadding(new Insets(0, 0, 10, 0));
        titleBox.getChildren().add(title);
        final TextFlow formattedText = BBCodeParser.createFormattedText(description);
        titleBox.getChildren().add(formattedText);
    }

    /**
     * Creates an input group for a quantity
     * @param quantity the quantity to display
     * @param mandatory whether the quantity is mandatory
     * @return the input group
     */
    protected InputGroup createAndBind(QuantityT quantity, boolean mandatory) {

        var valueField = new TextField();
        valueField.setAlignment(Pos.CENTER_RIGHT);
        var unitField = new TextField();
        unitField.setPrefWidth(80);
        var group = new atlantafx.base.layout.InputGroup(valueField, unitField);

        if (quantity == null) {
            if (mandatory) {
                valueField.setText("no value given");
                valueField.setStyle("-fx-background-color: -color-danger-1;");
            }
        } else {
            valueField.textProperty().bindBidirectional(quantity.getNumericvalue(), new PrincipalParticularsPage.PPStringConverter());
            unitField.setText("[" + quantity.getUnitId() + "]");

            if (quantity.getUnit() != null) {
                var unit = quantity.getUnit();
                if (unit.getUnitSymbol() != null && unit.getUnitSymbol().size() > 0) {
                    unitField.setText(unit.getUnitSymbol().get(0).getType());
                }
                StringBuilder tt = new StringBuilder();
                if (unit.getUnitName() != null) {
                    unit.getUnitName().forEach(name -> {
                        tt.append("Unit Name: ").append(name.toString()).append("\n");
                    });
                    unitField.setTooltip(new Tooltip(tt.toString()));
                }
                ;
            }
        }

        return group;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Pane getView() {
        return this;
    }

    static class PPStringConverter extends Format {
        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            toAppendTo.append(obj.toString());
            return toAppendTo;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
        }
    }

    static class CSClassEnumConverter extends Format {

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            toAppendTo.append(obj.toString());
            return toAppendTo;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
        }
    }


    static class HPStringConverter extends Format {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            if ( obj instanceof Temporal) {
                toAppendTo.append( formatter.format((Temporal) obj));
            } else {
                toAppendTo.append(obj.toString());
            }
            return toAppendTo;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
        }
    }

}
