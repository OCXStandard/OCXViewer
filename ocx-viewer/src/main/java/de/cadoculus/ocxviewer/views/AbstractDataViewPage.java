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
import de.cadoculus.ocxviewer.geom.PlaneGeometry;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Callback;
import javafx.util.Pair;
import oasis.unitsml.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvnet.basicjaxb.lang.Bound;
import org.jvnet.basicjaxb.lang.StringUtils;
import org.ocx_schema.v3x.*;

import javax.vecmath.Matrix4d;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
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
    private final Map<Class<?>, Class<? extends AbstractDataViewPage>> type2page = new HashMap<>();

    protected AbstractDataViewPage(String name) {
        super();

        this.name = name;

        BorderPane.setMargin(this, new Insets(15));

        this.maxHeight(1950);
        this.setMaxWidth(2400);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);

        this.getStyleClass().add("content-pane");

    }

    protected static void drawRadiusDimensionLine(GraphicsContext gc, Matrix4d totalHoco, Point3d center, Point3d end, String label) {

        var p0 = new Point3d(center);
        totalHoco.transform(p0);

        var p1 = new Point3d(end);
        totalHoco.transform(p1);

        gc.strokeLine(p0.x, p0.y, p1.x, p1.y);

        var dir = new Vector3d(p1);
        dir.sub(p0);
        dir.normalize();
        dir.negate();
        drawSolidArrowHead(gc, p1.x, p1.y, dir.x, dir.y);

        dir.negate();

        var angle = Math.toDegrees(dir.angle(PlaneGeometry.NORMAL_X));
        LOG.debug("{} angle to X axis: {}", label, angle);


        if (angle > 45 && angle < 225) {
            angle += 180;
        }
        LOG.debug("{} angle' to X axis: {}", label, angle);

        var tp = new Point3d(p0);
        tp.add(p1);
        tp.scale(0.5);

        var offset = new Vector3d(0, 0, 0);

        gc.save();

        gc.translate(tp.x + offset.x, tp.y + offset.y);
        gc.rotate(angle);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(label, 0, 0);

        gc.restore();


    }

    protected static void drawDimensionLine(GraphicsContext gc, Matrix4d totalHoco, Point3d start, Point3d end, Vector3d awayFrom, String label) {

        var rawDir = new Vector3d(end);
        rawDir.sub(start);

        var offset = new Vector3d();
        offset.cross(rawDir, new Vector3d(0, 0, 1));
        if (offset.dot(awayFrom) > 0) {
            offset.negate();
        }

        totalHoco.transform(offset);
        offset.normalize();
        offset.scale(50);

        var p0 = new Point3d(start);
        totalHoco.transform(p0);
        var p01 = new Point3d(start);
        totalHoco.transform(p01);
        p01.add(offset);

        gc.strokeLine(p0.x, p0.y, p01.x, p01.y);

        var p1 = new Point3d(end);
        totalHoco.transform(p1);
        var p11 = new Point3d(end);
        totalHoco.transform(p11);
        p11.add(offset);

        gc.strokeLine(p1.x, p1.y, p11.x, p11.y);

        // now the line between the two dimension lines
        offset.normalize();
        offset.scale(45);

        var p02 = new Point3d(start);
        totalHoco.transform(p02);
        p02.add(offset);

        var p12 = new Point3d(end);
        totalHoco.transform(p12);
        p12.add(offset);

        gc.strokeLine(p02.x, p02.y, p12.x, p12.y);

        var dir = new Vector3d(p12);
        dir.sub(p02);
        dir.normalize();
        drawSolidArrowHead(gc, p02.x, p02.y, dir.x, dir.y);
        dir.negate();
        drawSolidArrowHead(gc, p12.x, p12.y, dir.x, dir.y);

        offset.normalize();
        offset.scale(10);

        var angle = Math.toDegrees(dir.angle(PlaneGeometry.NORMAL_X));
        LOG.debug("{} angle to X axis: {}", label, angle);


        if (angle > 45 && angle < 225) {
            angle += 180;
        }
        LOG.debug("{} angle' to X axis: {}", label, angle);

        gc.save();

        gc.translate((p02.x + p12.x) / 2 + offset.x, (p01.y + p11.y) / 2 + offset.y);
        gc.rotate(angle);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(label, 0, 0);

        gc.restore();


    }

    /**
     * Draws a point as a cross with a label. The label is drawn in the direction of offDir and connected to the point with a line if connectionLineWidth > 0
     *
     * @param gc                  the graphics context to draw on
     * @param hoco                a homogenous transformation to apply to the point and the offDir before drawing
     * @param point               the point to draw to
     * @param length              the length of the cross arms
     * @param strokeColour        the color of the cross
     * @param strokeWidth         the width of the cross lines
     * @param label               the label to draw next to the point, can be null or empty for no label
     * @param labelColor          the color of the label text
     * @param offDir              the direction to draw the label in, will be transformed by hoco, should not be zero vector
     * @param connectionColour    the color of the line connecting the point to the label, if connectionLineWidth > 0
     * @param connectionLineWidth the width of the line connecting the point to the label, if <= 0 no line will be drawn
     */
    protected static void drawPoint(GraphicsContext gc, Matrix4d hoco, Point3d point, double length,
                                    Color strokeColour, int strokeWidth,
                                    String label, Color labelColor,
                                    Vector3d offDir, Color connectionColour, int connectionLineWidth) {


        gc.setLineWidth(strokeWidth);
        gc.setStroke(strokeColour);

        var start = new Point3d(point);
        hoco.transform(start);

        LOG.debug("draw point {} at {}, {}", point, start.x, start.y);

        gc.strokeLine(start.x - length, start.y - length, start.x + length, start.y + length);
        gc.strokeLine(start.x + length, start.y - length, start.x - length, start.y + length);

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(label)) {

            var offset = new Vector3d(offDir);
            offset.normalize();
            offset.scale(3 * length);

            var textX = start.x + offDir.x;
            var textY = start.y + offDir.y;
            gc.setFill(labelColor);

            gc.setTextAlign(offDir.x < 0 ? TextAlignment.RIGHT : TextAlignment.LEFT);
            gc.fillText(label, textX, textY);

            if (connectionLineWidth > 0 && connectionColour != null) {
                gc.setLineWidth(connectionLineWidth);
                gc.setStroke(connectionColour);
                gc.strokeLine(start.x, start.y, textX, textY);
            }
        }
    }


    protected static void drawLineArrowHead(GraphicsContext gc, Point3d tipPoint, Vector3d direction, double length, Color stroke, double strokeWidth) {

        var p0 = new Point2D(0, 0);
        var p1 = new Point2D(length / 3.0, length);
        var p2 = new Point2D(-length / 3.0, length);

        //LOG.info("p0 {} p1 {} p2 {}", p0, p1, p2);

        var angle = Math.atan2(direction.x, direction.y);
        //LOG.info("angle {}°", Math.toDegrees(angle));
        Rotate rotate = new Rotate(Math.toDegrees(angle), 0, 0);

        var p0I = rotate.transform(p0);
        var p1I = rotate.transform(p1);
        var p2I = rotate.transform(p2);

        //LOG.info("p0I {} p1I {} p2I {}", p0I, p1I, p2I);

        Translate translate = new Translate(tipPoint.x, tipPoint.y);

        var p0II = translate.transform(p0I);
        var p1II = translate.transform(p1I);
        var p2II = translate.transform(p2I);

        //LOG.info("p0I {} p1I {} p2I {}", p0II, p1II, p1II);

        gc.save();
        gc.setLineWidth(strokeWidth);
        gc.setStroke(stroke);
        gc.beginPath();
        gc.moveTo(p1II.getX(), p1II.getY());
        gc.lineTo(p0II.getX(), p0II.getY());
        gc.lineTo(p2II.getX(), p2II.getY());
        gc.stroke();

        gc.restore();


    }


    protected static void drawSolidArrowHead(GraphicsContext gc, double x, double y, double xDir, double yDir) {

        double lw = Math.max(gc.getLineWidth(), 1);
        lw = Math.min(lw, 5);

        var p0 = new Point2D(0, 0);
        var p1 = new Point2D(10 * lw, 3 * lw);
        var p2 = new Point2D(10 * lw, -3 * lw);

        //LOG.info("p0 {} p1 {} p2 {}", p0, p1, p2);

        var angle = Math.atan2(yDir, xDir);
        //LOG.info("angle {}°", Math.toDegrees(angle));
        Rotate rotate = new Rotate(Math.toDegrees(angle), 0, 0);

        var p0I = rotate.transform(p0);
        var p1I = rotate.transform(p1);
        var p2I = rotate.transform(p2);

        //LOG.info("p0I {} p1I {} p2I {}", p0I, p1I, p2I);

        Translate translate = new Translate(x, y);

        var p0II = translate.transform(p0I);
        var p1II = translate.transform(p1I);
        var p2II = translate.transform(p2I);

        //LOG.info("p0I {} p1I {} p2I {}", p0II, p1II, p1II);

        gc.beginPath();
        gc.moveTo(p0II.getX(), p0II.getY());
        gc.lineTo(p1II.getX(), p1II.getY());
        gc.lineTo(p2II.getX(), p2II.getY());
        gc.closePath();
        gc.fill();


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
    public static <E, F>
    Callback<TableColumn<E, F>, TableCell<E, F>> createHyperlinkCellfactory(Consumer<F> selectFunction) {

        return new Callback<TableColumn<E, F>, TableCell<E, F>>() {

            @Override
            public TableCell<E, F> call(TableColumn<E, F> tableColumn) {

                final TableCell<E, F> cell = new TableCell<E, F>() {


                    @Override
                    public void updateItem(F value, boolean empty) {
                        super.updateItem(value, empty);
                        if (empty || value == null) {
                            setGraphic(null);
                            setText(null);
                            return;
                        }

                        var label = "unset";
                        if (value instanceof IdBaseT idBaseT) {
                            label = idBaseT.getId();
                        } else if (value instanceof Pair<?,?> pair) {
                            if (pair.getValue() instanceof IdBaseT idBaseT) {
                                label = idBaseT.getId();
                            } else {
                                label = pair.getValue().toString();
                            }
                        } else if (value != null) {
                            label = value.toString();
                        }
                        Hyperlink link = new Hyperlink(label);
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
    public static <E extends org.ocx_schema.v3x.IdBaseT> Callback<TableColumn<E, QuantityT>, TableCell<E, QuantityT>> createQuantityCellfactory() {

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
                        var unit = getUnitDisplayValue(quantity.getUnit());

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
     * Try to get a display value for a unit
     *
     * @param unit the Unit or unit id
     * @return a display name
     */
    public static String getUnitDisplayValue(Object unit) {

        String retval = "";
        if (unit instanceof Unit unit1) {
            while (true) {
                if (unit1.getUnitSymbols() != null && unit1.getUnitSymbols().getFirst() != null) {
                    retval = unit1.getUnitSymbols().getFirst().getType();
                    break;
                }
                if (unit1.getUnitNames() != null) {
                    var unitNameO = unit1.getUnitNames().stream().filter(u ->
                            "en".equalsIgnoreCase(u.getLang())).findFirst();
                    if (unitNameO.isPresent()) {
                        retval = unitNameO.get().getValue();
                        break;
                    }
                }
                retval = unit1.getId();
                break;
            }
        } else if (unit instanceof String unitId) {
            retval = "unresolved Unit, id '" + unitId + "'";
        }
        return retval;
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

    /**
     * Create the default form gird containing 4 columns
     *
     * @return a grid pane
     */
    protected GridPane createDefaultGrid() {
        GridPane gridPane = new GridPane();

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

        return gridPane;
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
                unit = unit1.getUnitSymbols() != null && ! unit1.getUnitSymbols().isEmpty() ? unit1.getUnitSymbols().getFirst().getType() : "no unit symbols available";
                longUnit = unit1.getUnitNames()!= null && ! unit1.getUnitNames().isEmpty() ? unit1.getUnitNames().getFirst().getValue() : "no unit names available";
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

    public List<BreadcrumbRecord> createBreadcrumbs(List<BreadcrumbRecord> parentPath, IdBaseT entity) {

        initPageLookup();

        // TODO: add some magic lookup to determine the page class and parameters based on the entity type
        var robert = new ArrayList<>(getBreadcrumbs());
        var pageClass = type2page.get(entity.getClass());
        if (pageClass == null) {
            LOG.warn("no page class found for entity type {}, using default page class {}", entity.getClass(), Panel.class);
        }

        robert.add(new BreadcrumbRecord(entity.getId(), pageClass, null, entity));
        return robert;

    }


    private void initPageLookup() {
        if (type2page.isEmpty()) {

            // generic lookup is not your friend, that's why this is hardcoded for now

            type2page.put(Panel.class, PanelPage.class);
            type2page.put(Stiffener.class, StiffenerPage.class);
            type2page.put(EdgeReinforcement.class, FlangePage.class);
            type2page.put(PillarT.class, PillarPage.class);
            type2page.put(Plate.class, PlatePage.class);
            type2page.put(Seam.class, SeamPage.class);

            type2page.put(Material.class, MaterialPage.class);
            type2page.put(BarSection.class, BarSectionPage.class);
            //type2page.put( BarSection.class, HoleShapePage.class);

            type2page.put(SurfaceT.class, SurfacePage.class);
            type2page.put(Vessel.class, VesselDataPage.class);
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstractDataViewPage that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public static class PointTableCell<E, F extends Point3DT> extends TableCell<E, F> {
        @Override
        public void updateItem(F point3DT, boolean empty) {
            super.updateItem(point3DT, empty);
            if (point3DT == null) {
                setText(null);
                setGraphic(null);
            } else {
                var text =
                        "(" +
                                DEC4.format(point3DT.getCoordinates().get(0)) + ", " +
                                DEC4.format(point3DT.getCoordinates().get(1)) + ", " +
                                DEC4.format(point3DT.getCoordinates().get(2)) + ")";

                if (point3DT.getUnit() instanceof Unit unit1) {
                    text += " [" + unit1.getUnitNames().getFirst().getValue() + "]";
                    ;
                }

                setText(text);
            }
        }

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
                    toAppendTo.append(obj);
                }

            } else {
                toAppendTo.append(obj);
            }

            return toAppendTo;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
        }
    }

}
