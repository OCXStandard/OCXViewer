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

import atlantafx.base.controls.Breadcrumbs;
import atlantafx.base.layout.InputGroup;
import atlantafx.base.theme.Styles;
import atlantafx.base.util.BBCodeParser;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;
import oasis.unitsml.Unit;
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
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * The base class for data views
 *
 * @author Carsten Zerbst
 */
public abstract class AbstractDataViewPage extends BorderPane implements de.cadoculus.ocxviewer.views.Page {

    private static final Logger LOG = LogManager.getLogger(AbstractDataViewPage.class);
    // I think this is possible, as we never run this outside the event thread
    private final static DecimalFormat DEC4 = new DecimalFormat("0.00##");
    public static double SIN_30 = 0.5;
    public static double COS_30 = Math.sqrt(3) / 2;
    public static double SIN_60 = Math.sqrt(3) / 2;
    public static double COS_60 = Math.sqrt(3) / 2;
    public static double SIN_45 = 1 / Math.sqrt(2);
    public static double COS_45 = SIN_45;
    public static double COS_225 = 0.923879533;
    public static double SIN_225 = 0.382683432;
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
     * This method creates a cell factory for a table column that displays hyperlinks.
     * It uses the Id of the item as the hyperlink text.
     * When a hyperlink is clicked, the provided selectFunction is called with the corresponding item.
     * This expects that the table column is of the same type as the table items.
     *
     * @param selectFunction the function to call with the value when the hyperlink is clicked
     * @param <E>            the type of the table items and table column
     * @return the cell factory
     */
    public static <E extends org.ocx_schema.v310.IdBaseT> Callback<TableColumn<E, E>, TableCell<E, E>> createHyperlinkCellfactory(Consumer<E> selectFunction) {

        return new Callback<TableColumn<E, E>, TableCell<E, E>>() {

            @Override
            public TableCell<E, E> call(TableColumn<E, E> tableColumn) {

                final TableCell<E, E> cell = new TableCell<E, E>() {
                    @Override
                    public void updateItem(E value, boolean empty) {
                        super.updateItem(value, empty);
                        if (empty || value == null) {
                            setGraphic(null);
                            setText(null);
                            return;
                        }
                        Hyperlink link = new Hyperlink(value.getId());
                        link.setStyle("-fx-padding: 10px");
                        link.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                selectFunction.accept(value);
                            }
                        });
                        setGraphic(link);
                    }
                };
                cell.setAlignment(Pos.BOTTOM_LEFT);
                return cell;
            }
        };
    }

    /**
     * This method creates a cell factory for a {@link QuantityT}s.
     * It uses the value and the unit as text.
     *
     * @param <E> the type of the table items and table column
     * @return the cell factory
     */
    public static <E extends org.ocx_schema.v310.IdBaseT> Callback<TableColumn<E, QuantityT>, TableCell<E, QuantityT>> createQuantityCellfactory() {

        return new Callback<TableColumn<E, QuantityT>, TableCell<E, QuantityT>>() {

            @Override
            public TableCell<E, QuantityT> call(TableColumn<E, QuantityT> tableColumn) {

                final TableCell<E, QuantityT> cell = new TableCell<E, QuantityT>() {
                    @Override
                    public void updateItem(QuantityT quantity, boolean empty) {
                        super.updateItem(quantity, empty);
                        if (empty || quantity == null) {
                            setGraphic(null);
                            setText(null);
                            return;
                        }

                        var value = "";
                        try {
                            value = DEC4.format(quantity.getNumericvalue());
                        } catch (Exception e) {
                            LOG.error("no double property 'numericvalue' found in class {}:{}", quantity.getClass().getName(), e);
                        }
                        var unit = "unset";

                        if (quantity.getUnit() instanceof Unit unit1) {
                            while (true) {
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

                        setGraphic(null);
                        setText(value + " [" + unit + "]");

                    }
                };
                cell.setAlignment(Pos.BOTTOM_RIGHT);
                return cell;
            }
        };
    }

    /**
     * Get the breadcrumbs for this page. As this is a top level page, only a single breadcrumb is returned in the list
     *
     * @return the list of breadcrumbs
     */
    @Override
    public List<BreadcrumbRecord> getBreadcrumbs() {
        return List.of(new BreadcrumbRecord(getName(), this.getClass(), this, null));
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

    protected void createTitle(List<BreadcrumbRecord> breadcrumbRecords, String title, String description) {
        var titleBox = new VBox();
        this.setTop(titleBox);

        var label = new Label(title);
        label.getStyleClass().add(Styles.TITLE_2);
        titleBox.setPadding(new Insets(0, 0, 10, 0));
        titleBox.getChildren().add(label);

        BreadcrumbRecord[] crumbsArray = breadcrumbRecords.toArray(BreadcrumbRecord[]::new);
        Breadcrumbs.BreadCrumbItem<BreadcrumbRecord> root = Breadcrumbs.buildTreeModel(crumbsArray);
        var crumbs = new Breadcrumbs<>(root);
        crumbs.setSelectedCrumb(root);
        crumbs.setOnCrumbAction(event -> {
            BreadcrumbRecord record = event.getSelectedCrumb().getValue();
            LOG.debug("Breadcrumb selected: {}", record);
            var index = breadcrumbRecords.indexOf(record);
            if (index < 0) {
                LOG.error("Breadcrumb record {} not found in current path: {}", record, breadcrumbRecords);
                return;
            }
            var subList = breadcrumbRecords.subList(0, index + 1);
            var newEvent = new SelectionEvent(subList);
            DefaultEventBus.getInstance().publish(newEvent);
        });


        titleBox.getChildren().add(crumbs);

        final TextFlow formattedText = BBCodeParser.createFormattedText(description);
        titleBox.getChildren().add(formattedText);
    }

    protected InputGroup createOrRebind(InputGroup inputGroup, Point3DT point3DT, boolean mandatory) {

        TextField valueField = null;
        TextField unitField = null;
        InputGroup group;

        if (inputGroup == null) {
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
                    "(" +
                            DEC4.format(point3DT.getCoordinates().get(0)) + ", " +
                            DEC4.format(point3DT.getCoordinates().get(1)) + ", " +
                            DEC4.format(point3DT.getCoordinates().get(2)) + ")";
            LOG.info("set coordinates {}", text);
            valueField.setText(text);
            var unit = "unset";
            if (point3DT.getUnit() instanceof Unit unit1) {
                unit = unit1.getUnitNames().getFirst().getValue();
            }

            unitField.setText("[" + unit + "]");
            unitField.setTooltip(new Tooltip("[ " + unit + "]"));
        }

        if (mandatory && (point3DT == null || point3DT.getCoordinates() == null || point3DT.getCoordinates().size() != 3)) {
            valueField.setStyle("-fx-background-color: -color-danger-1;");
        } else {
            valueField.setStyle("-fx-background-color: -color-bg-default;");
        }

        return inputGroup;

    }

    protected InputGroup createOrRebind(InputGroup inputGroup, Vector3DT vector3DT, boolean mandatory) {

        TextField valueField = null;
        InputGroup group;

        if (inputGroup == null) {
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
                    "(" +
                            DEC4.format(vector3DT.getDirections().get(0)) + ", " +
                            DEC4.format(vector3DT.getDirections().get(1)) + ", " +
                            DEC4.format(vector3DT.getDirections().get(2)) + ")";
            valueField.setText(text);
            var unit = "unset";
        }

        if (mandatory && (vector3DT == null || vector3DT.getDirections() == null || vector3DT.getDirections().size() != 3)) {
            valueField.setStyle("-fx-background-color: -color-danger-1;");
        } else {
            valueField.setStyle("-fx-background-color: -color-bg-default;");
        }

        return inputGroup;

    }

    protected InputGroup createOrRebind(InputGroup inputGroup, QuantityT quantity, boolean mandatory) {

        TextField valueField = null;
        TextField unitField = null;


        if (inputGroup == null) {
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

        if (quantity == null) {
            valueField.setText("no value given");
            if (mandatory) {
                valueField.setStyle("-fx-background-color: -color-danger-1;");
            }
        } else {
            var unit = "unset";

            if (quantity.getUnit() instanceof Unit unit1) {

                while (true) {

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

            unitField.setText("[" + unit + "]");
            unitField.setTooltip(new Tooltip("[ " + unit + "]"));
        }

        return inputGroup;

    }

    /**
     * Creates an input group for a quantity
     *
     * @param quantity  the quantity to display
     * @param mandatory whether the quantity is mandatory
     * @return the input group
     */
    protected InputGroup createAndBind(QuantityT quantity, boolean mandatory) {

        var valueField = new TextField();
        valueField.getStyleClass().add("quantity-input-value");
        valueField.setAlignment(Pos.CENTER_RIGHT);
        var unitField = new TextField();
        unitField.setPrefWidth(120);
        unitField.getStyleClass().add("quantity-input-unit");
        var group = new atlantafx.base.layout.InputGroup(valueField, unitField);
        group.getStyleClass().add("quantity-input-group");

        if (quantity == null) {
            valueField.setText("no value given");
            if (mandatory) {
                valueField.setStyle("-fx-background-color: -color-danger-1;");
            }
        } else {
            //valueField.setStyle("-fx-background-color: -color-bg-default;");

            var unit = "unset";
            var longUnit = "";
            if (quantity.getUnit() instanceof Unit unit1) {
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

            unitField.setText("[" + unit + "]");
            unitField.setTooltip(new Tooltip(longUnit));


        }

        return group;

    }

    @SuppressWarnings("rawtypes")
    protected void bindToBean(StringProperty stringProperty, Bound object, String propertyName, Class propertyClass) {

        if (object == null) {
            LOG.error("no object given to bind with property '{}'", propertyName);
            return;
        }

        //LOG.info("binding {}/{} in {}", object.getClass(),  propertyName, object);

        if (stringProperty == null) {
            LOG.error("no string property given to bind with property '{}' in {}", propertyName, object);
            return;
        }

        if (StringUtils.isBlank(propertyName)) {
            LOG.error("no property class given to bind for property '{}' in object {}", propertyName, object);
            return;
        }

        if (String.class == propertyClass) {

            try {
                final JavaBeanStringProperty property = JavaBeanStringPropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property);
            } catch (Exception e) {
                LOG.error("no string property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else if (Double.TYPE == propertyClass) {

            try {
                final JavaBeanDoubleProperty property = JavaBeanDoublePropertyBuilder.create().bean(object).name(propertyName).build();
                stringProperty.bindBidirectional(property, new PPStringConverter(propertyClass));
            } catch (Exception e) {
                LOG.error("no double property {} found in class {}:{}", propertyName, object.getClass().getName(), e);
            }
        } else if (Integer.TYPE == propertyClass) {

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
        } else if (Year.class == propertyClass) {
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

    ;

    @Override
    public void beforeClose() {

    }

    ;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstractDataViewPage that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @SuppressWarnings("rawtypes")
    static class PPStringConverter extends Format {

        private final Class propertyClass;

        public PPStringConverter(Class propertyClass) {
            this.propertyClass = propertyClass;
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            if (obj instanceof XMLGregorianCalendar calendar) {

                if (propertyClass == LocalDateTime.class) {
                    toAppendTo.append(calendar.toGregorianCalendar().toZonedDateTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
                } else if (propertyClass == Year.class) {
                    toAppendTo.append(calendar.toGregorianCalendar().get(GregorianCalendar.YEAR));
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
