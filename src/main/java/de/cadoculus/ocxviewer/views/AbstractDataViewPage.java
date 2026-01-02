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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import oasis.unitsml.Unit;
import oasis.unitsml.UnitName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvnet.basicjaxb.lang.Bound;
import org.jvnet.basicjaxb.lang.StringUtils;
import org.ocx_schema.v310.Point3DT;
import org.ocx_schema.v310.QuantityT;
import org.ocx_schema.v310.Vector3DT;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * The base class for data views
 */
abstract class AbstractDataViewPage extends BorderPane implements de.cadoculus.ocxviewer.views.Page {

    private static final Logger LOG = LogManager.getLogger(AbstractDataViewPage.class);
    public static double SIN_30 = 0.5;
    public static double COS_30 = Math.sqrt(3) / 2;
    public static double SIN_60 = Math.sqrt(3) / 2;
    public static double COS_60 = Math.sqrt(3) / 2;
    public static double SIN_45 = 1/Math.sqrt(2);
    public static double COS_45 = SIN_45;
    public static double COS_225 = 0.923879533;
    public static double SIN_225 = 0.382683432;


    // I think this is possible, as we never run this outside the event thread
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

    protected  InputGroup createOrRebind(InputGroup inputGroup,  Point3DT point3DT,  boolean mandatory) {

        TextField valueField = null;
        TextField unitField = null;
        InputGroup group;

        if ( inputGroup== null) {
            valueField = new TextField();
            valueField.setAlignment(Pos.CENTER_RIGHT);
            unitField = new TextField();
            unitField.setPrefWidth(80);
            inputGroup = new atlantafx.base.layout.InputGroup(valueField, unitField);
        } else {
            valueField = (TextField) inputGroup.getChildren().get(0);
            unitField = (TextField) inputGroup.getChildren().get(1);
            valueField.textProperty().unbind();
            unitField.textProperty().unbind();
        }

        if (point3DT == null || point3DT.getCoordinates() == null || point3DT.getCoordinates().size() != 3) {
            valueField.setText("no value given");
        } else {

            var text =
                    "("+
                    DEC4.format(point3DT.getCoordinates().get(0)) + ", " +
                            DEC4.format(point3DT.getCoordinates().get(1)) + ", " +
                            DEC4.format(point3DT.getCoordinates().get(2)) + ")";
            LOG.info("set coordinates {}", text);
            valueField.setText(text);
            var unit="unset";
            if ( point3DT.getUnit() instanceof  Unit unit1) {
                unit = unit1.getUnitNames().getFirst().getValue();
            }

            unitField.setText("[" + unit+ "]");
            unitField.setTooltip( new Tooltip("[ " + unit+ "]"));
        }

        if (mandatory && (point3DT == null || point3DT.getCoordinates() == null || point3DT.getCoordinates().size() != 3)) {
            valueField.setStyle("-fx-background-color: -color-danger-1;");
        } else {
            valueField.setStyle("-fx-background-color: -color-bg-default;");
        }

        return inputGroup;

    }

    protected  InputGroup createOrRebind(InputGroup inputGroup, Vector3DT vector3DT, boolean mandatory) {

        TextField valueField = null;
        InputGroup group;

        if ( inputGroup== null) {
            valueField = new TextField();
            valueField.setAlignment(Pos.CENTER_RIGHT);
            inputGroup = new atlantafx.base.layout.InputGroup(valueField);
        } else {
            valueField = (TextField) inputGroup.getChildren().get(0);
            valueField.textProperty().unbind();
        }

        if (vector3DT == null || vector3DT.getDirections() == null || vector3DT.getDirections().size() != 3) {
            valueField.setText("no value given");
        } else {

            var text =
                    "("+
                            DEC4.format(vector3DT.getDirections().get(0)) + ", " +
                            DEC4.format(vector3DT.getDirections().get(1)) + ", " +
                            DEC4.format(vector3DT.getDirections().get(2)) + ")";
            valueField.setText(text);
            var unit="unset";
        }

        if (mandatory && (vector3DT == null || vector3DT.getDirections() == null || vector3DT.getDirections().size() != 3)) {
            valueField.setStyle("-fx-background-color: -color-danger-1;");
        } else {
            valueField.setStyle("-fx-background-color: -color-bg-default;");
        }

        return inputGroup;

    }


    protected InputGroup createOrRebind( InputGroup inputGroup, QuantityT quantity, boolean mandatory) {

        TextField valueField = null;
        TextField unitField = null;
        InputGroup group;

        if ( inputGroup== null) {
            valueField = new TextField();
            valueField.setAlignment(Pos.CENTER_RIGHT);
            unitField = new TextField();
            unitField.setPrefWidth(80);
        } else {
            valueField = (TextField) inputGroup.getChildren().get(0);
            unitField = (TextField) inputGroup.getChildren().get(1);
            valueField.textProperty().unbind();
            unitField.textProperty().unbind();
        }

        if (quantity == null) {
            valueField.setText("no value given");
            if (mandatory) {
                valueField.setStyle("-fx-background-color: -color-danger-1;");
            }
        } else {
            var unit="unset";

            if ( quantity.getUnit() instanceof  Unit unit1) {


                while(true) {


                    if (unit1.getUnitSymbols() != null && unit1.getUnitSymbols().getFirst() != null) {
                        unit = unit1.getUnitSymbols().getFirst().getType();
                        break;
                    }
                    if (unit1.getUnitNames() != null) {
                        var unitNameO = unit1.getUnitNames().stream().filter(u ->
                                "en".equalsIgnoreCase(u.getLang())).findFirst();
                        if (unitNameO.isPresent()) {
                            unit = unitNameO.get().getValue();
                            break;
                        }
                    }
                    unit = unit1.getId();
                    break;
                }
            }

            try {
                valueField.setText(DEC4.format(quantity.getNumericvalue()));
            } catch (Exception e) {
                LOG.error("no double property 'numericvalue' found in class {}:{}", quantity.getClass().getName(), e);
            }

            unitField.setText("[" + unit+ "]");
            unitField.setTooltip( new Tooltip("[ " + unit+ "]"));
        }

        return inputGroup;

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
        unitField.setPrefWidth(120);
        var group = new atlantafx.base.layout.InputGroup(valueField, unitField);

        if (quantity == null) {
            valueField.setText("no value given");
            if (mandatory) {
                valueField.setStyle("-fx-background-color: -color-danger-1;");
            }
        } else {
            valueField.setStyle("-fx-background-color: -color-bg-default;");

            var unit="unset";
            var longUnit = "";
            if ( quantity.getUnit() instanceof  Unit unit1) {
                unit = unit1.getUnitSymbols().getFirst().getType();
                longUnit = unit1.getUnitNames().getFirst().getValue();
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
            unitField.setTooltip(new Tooltip(longUnit));



        }

        return group;

    }

    @SuppressWarnings("rawtypes")
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

        if (StringUtils.isBlank(propertyName )) {
            LOG.error("no property class given to bind for property '{}' in object {}", propertyName, object);
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
                LOG.error("no double property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
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

    @SuppressWarnings("rawtypes")
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



}
