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
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import oasis.unitsml.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvnet.basicjaxb.lang.Bound;
import org.jvnet.basicjaxb.lang.StringUtils;
import org.ocx_schema.v310rc3.QuantityT;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.GregorianCalendar;

/**
 * The base class for data views
 */
abstract class AbstractDataViewPage extends BorderPane implements de.cadoculus.ocxviewer.views.Page {

    private static final Logger LOG = LogManager.getLogger(AbstractDataViewPage.class);

    // I think this is possible, as we never run this outside the event thread
    private final static DecimalFormat DEC2 = new DecimalFormat("0.00");
    private final static DecimalFormat DEC4 = new DecimalFormat("0.00##");

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

            var unit="unset";
            if ( quantity.getUnit() instanceof  Unit unit1) {
                unit = unit1.getUnitNames().getFirst().getValue();
            }

            LOG.debug("binding quantity {} {}", quantity.getNumericvalue(), quantity.getUnit());

            try {
//                final JavaBeanDoubleProperty property = JavaBeanDoublePropertyBuilder.create().bean(quantity).name("numericvalue").build();
//                valueField.textProperty().bindBidirectional(property, new PPStringConverter());
                 valueField.setText(DEC4.format(quantity.getNumericvalue()));

            } catch (Exception e) {
                LOG.error("no double property 'numericvalue' found in class {}:{}", quantity.getClass().getName(), e);
            }

            unitField.setText("[" + unit+ "]");

        }

        return group;

    }

    protected void bindToBean(StringProperty stringProperty, Bound object, String propertyName, Class propertyClass) {

        if ( object==null) {
            LOG.error("no object given to bind with property '{}'", propertyName);
            return;
        }

        //LOG.info("binding {}/{} in {}", object.getClass(),  propertyName, object);

        if ( stringProperty == null) {
            LOG.error("no string property given to bind with property '{}' in {}", propertyName, object);
            return;
        }
        if ( object==null) {
            LOG.error("no object given to bind with property '{}'", propertyName);
            return;
        }
        if (StringUtils.isBlank(propertyName )) {
            LOG.error("no property name given to bind in object {}", object);
            return;
        }
        if ( propertyName == null ) {
            LOG.error("no property class given to bind for properrty '{}' in object {}", propertyName, object);
            return;
        }

        if ( String.class == propertyClass) {

            try {
                final JavaBeanStringProperty property = JavaBeanStringPropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property);
            } catch (Exception e) {
                LOG.error("no string property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else if ( Double.TYPE == propertyClass) {

            try {
                final JavaBeanDoubleProperty property = JavaBeanDoublePropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property, new PPStringConverter(propertyClass));
            } catch (Exception e) {
                LOG.error("no doube property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else if ( Integer.TYPE == propertyClass) {

            try {
                final JavaBeanIntegerProperty property = JavaBeanIntegerPropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property, new PPStringConverter(propertyClass));
            } catch (Exception e) {
                LOG.error("no int property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else if (LocalDateTime.class == propertyClass) {
            try {
                final JavaBeanObjectProperty property = JavaBeanObjectPropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property, new PPStringConverter(propertyClass));
            } catch (Exception e) {
                LOG.error("no int property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else if ( Year.class == propertyClass) {
            try {
                final JavaBeanObjectProperty property = JavaBeanObjectPropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property, new PPStringConverter(propertyClass));
            } catch (Exception e) {
                LOG.error("no int property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else {
            LOG.error("unsupported property class {}", propertyClass);
            try {
                final JavaBeanObjectProperty property = JavaBeanObjectPropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property, new PPStringConverter(String.class));
            } catch (Exception e) {
                LOG.error("no object property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }

        }


    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Pane getView() {
        return this;
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

    static class PPStringConverter extends Format {

        private final Class propertyClass;

        public PPStringConverter(Class propertyClass) {
            this.propertyClass = propertyClass;
        }
        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            if ( obj instanceof XMLGregorianCalendar calendar) {

                if ( propertyClass == LocalDateTime.class) {
                    toAppendTo.append( calendar.toGregorianCalendar().toZonedDateTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
                } else if ( propertyClass == Year.class) {
                    toAppendTo.append( calendar.toGregorianCalendar().get(GregorianCalendar.YEAR));
                } else {
                    toAppendTo.append(obj.toString());
                }

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
