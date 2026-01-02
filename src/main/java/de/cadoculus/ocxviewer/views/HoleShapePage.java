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
import de.cadoculus.ocxviewer.models.UnitConverter;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.ArcType;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class displays standard hole shapes in a table and a canvas.
 */
public class HoleShapePage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Hole Shapes";
    private static final Logger LOG = LogManager.getLogger(HoleShapePage.class);

    private final TableView<Hole2D> table;
    private final GridPane gridPane;
    private final Label barLabel = new Label();
    private final Canvas canvas = new Canvas();
    private final ObjectProperty<Hole2D> selectedHoleShape = new SimpleObjectProperty<>();
    private ImagePattern barPattern;
    private double canvasWidth;
    private double canvasHeight;

    private Color textColor = Color.BLACK;
    private Color dimensionLineColor = Color.BLACK;
    private Color cosysColor = Color.BLUE;
    private Color panelColor = Color.GREEN;
    private final double barLineWidth = 2.0;
    private final double coosysLineWidth = 4.0;
    private final double dimensionLineWidth = 1.0;

    private final static Random RANDOM = new Random();


    private final DropShadow dropShadow = new DropShadow();


    public HoleShapePage() {
        super(NAME);

        dropShadow.setColor(Color.GRAY);

        createTitle("Information about the hole shapes.");

        gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.LEFT);
        col1.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(col1);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(200);
        row1.setVgrow(Priority.SOMETIMES);

        RowConstraints row2 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);

        RowConstraints row3 = new RowConstraints();
        row3.setFillHeight(true);
        row3.setVgrow(Priority.ALWAYS);
        row3.setMinHeight(300);
        row3.setVgrow(Priority.ALWAYS);

        gridPane.getRowConstraints().addAll(row1, row2, row3);
        //gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var tableColumn1 = new TableColumn<Hole2D, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getId())
        );

        var tableColumn2 = new TableColumn<Hole2D, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<Hole2D, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName())
        );

        var tableColumn4 = new TableColumn<Hole2D, String>("Type");
        tableColumn4.setCellValueFactory(
                c -> new SimpleStringProperty(HoleShapeType.getType(c.getValue()).name())
        );

        ObservableList<Hole2D> holeShapes = FXCollections.observableArrayList();
        table = new TableView<Hole2D>(holeShapes);
        table.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(200);
        int row = 0;

        gridPane.add(table, 0, row++);
        gridPane.add(barLabel, 0, row++);
        gridPane.add(canvas, 0, row);

        canvas.setWidth(200);
        canvas.setHeight(200);

        final OcxXMLT ocx = WorkingContext.getInstance().getOcx();
        if (ocx.getClassCatalogue() == null) {
            LOG.info("no class catalogue found");
            return;
        }
        if (ocx.getClassCatalogue().getHoleShapeCatalogue() == null) {
            LOG.info("no Xsections found in class catalogue");
            return;
        }

        if ( ocx.getClassCatalogue().getHoleShapeCatalogue().getHole2Ds()!= null) {
            holeShapes.addAll(ocx.getClassCatalogue().getHoleShapeCatalogue().getHole2Ds());
        }

        LOG.debug("found #{} hole shapes", holeShapes.size());

        table.getSelectionModel().selectedItemProperty().addListener((hole2d, oldHole, newHole) -> updateHoleShape(oldHole, newHole));

        this.boundsInLocalProperty().addListener((bound, oldBound, newBounds) -> updateCanvas());

        WorkingContext.getInstance().darkModeProperty().addListener(observable -> updateCanvas());

    }

    @Override
    public void afterShow() {

        table.getSelectionModel().selectFirst();
    }

    private void updateCanvas() {

        var availableHeight = gridPane.getHeight() - barLabel.getBoundsInParent().getMaxY() - 10;

        //LOG.info("set canvas height to {}", availableHeight);
        var availableWidth = this.getWidth() - 21;

        canvas.setHeight(availableHeight);
        canvas.setWidth(availableWidth);

        //LOG.info(" canvas {}\n{}", canvas.getBoundsInLocal(), canvas.getBoundsInParent());

        // todo: better way to get colour scheme
        textColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.WHITE : Color.BLACK;
        dimensionLineColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.WHITE : Color.BLACK;
        cosysColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.web("#bccadc") : Color.web("#537297");
        panelColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.web("#82b8b8") : Color.web("#508f8e");

        if (selectedHoleShape.getValue() != null) {
            repaintCanvas();
        }

    }

    private void repaintCanvas() {
        //LOG.info("repaint canvas {}, {}x{}", selectedBarSection.getValue(), canvas.getWidth(), canvas.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (selectedHoleShape.getValue() == null) {
            return;
        }

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        double dim = Math.min(canvasWidth, canvasHeight) / 33.0;

        dropShadow.setOffsetY(dim);
        dropShadow.setOffsetX(dim);


        Hole2D holeShape = selectedHoleShape.getValue();
        var sectionType = HoleShapeType.getType(holeShape);

        //LOG.info("bar section {} {}", sectionType, holeShape.getId());

        switch (sectionType) {
            case PARAMETRIC_CIRCLE ->  drawCircle(gc);
            case SYMMETRIC_HOLE -> drawSymmetricHole(gc);
            case SUPER_ELLIPTICAL -> drawSuperElliptical(gc);
            case RECTANGULAR_HOLE -> drawRectangularHole(gc);
            case RECTANGULAR_MICKEY_MOUSE_EARS -> drawMickeyMouse(gc);
            default -> LOG.warn("unsupported hole shape {} ({})", sectionType, holeShape);
        }

    }

    private void drawMickeyMouse(GraphicsContext gc) {

        var shape = selectedHoleShape.getValue().getParametricHole2D().getValue();
        if ( ! (shape instanceof RectangularMickeyMouseEars mickeyMouseEarsT)) {
            LOG.error("expected a RectangularMickeyMouseEarsT but got {}", shape.getClass());
            return;
        }

        var width = UnitConverter.toDefaultUnit(mickeyMouseEarsT.getWidth());
        var height = UnitConverter.toDefaultUnit(mickeyMouseEarsT.getHeight());
        var radius = UnitConverter.toDefaultUnit(mickeyMouseEarsT.getRadius());
        var displ = UnitConverter.toDefaultUnit(mickeyMouseEarsT.getDisplacement());


        var scaleY = (canvasHeight - 200) / (height+2*radius);
        var scaleX = (canvasWidth - 200) / (width+2*radius);
        var scale = Math.min(scaleX, scaleY);

        var w = Math.round(width* scale);
        var h = Math.round(height* scale);
        var b = h/2.0;
        var a = w/2.0;
        var r = Math.round(radius* scale);

        var centerX = Math.round(canvasWidth / 2.0) + 0.5;
        var centerY = Math.round(canvasHeight /2.0) + 0.5;
        drawPanelBoundary(gc);

        gc.moveTo(centerX-a+r, centerY-b);
        gc.arc(centerX-a, centerY-b, r, r, 0, 270);
        gc.lineTo(centerX-a, centerY+b-r);
        gc.arc(centerX-a, centerY+b, r, r, 90, 270);
        gc.lineTo(centerX+a-r, centerY+b);
        gc.arc(centerX+a, centerY+b, r, r, 180, 270);
        gc.lineTo(centerX+a, centerY-b+r);
        gc.arc(centerX+a, centerY-b, r, r, -90, 270);
        gc.lineTo(centerX-a+r, centerY-b);

        gc.closePath();

        gc.setEffect(dropShadow);
        gc.fill();
        gc.setEffect(null);


        gc.setStroke(dimensionLineColor);
        gc.setLineWidth(2);
        gc.beginPath();

        gc.arc(centerX-a, centerY-b, r, r, 0, 270);
        gc.lineTo(centerX-a, centerY+b-r);
        gc.arc(centerX-a, centerY+b, r, r, 90, 270);
        gc.lineTo(centerX+a-r, centerY+b);
        gc.arc(centerX+a, centerY+b, r, r, 180, 270);
        gc.lineTo(centerX+a, centerY-b+r);
        gc.arc(centerX+a, centerY-b, r, r, -90, 270);
        gc.lineTo(centerX-a+r, centerY-b);

        gc.stroke();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX+a-r, centerY-b, centerX+a+r+50, centerY-b);
        gc.strokeLine(centerX+a-r, centerY+b, centerX+a+r+50, centerY+b);
        gc.strokeLine(centerX+a+r+40, centerY-b, centerX+r+a+40, centerY+b);

        drawArrowHead(gc, centerX+r+a+40, centerY-b, 0, 1);
        drawArrowHead(gc, centerX+r+a+40, centerY+b, 0, -1);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h %.2f [mm]", height), centerX+a+r+50, centerY);

        // width
        gc.strokeLine(centerX-a, centerY+b-r, centerX-a, centerY+b+r+50);
        gc.strokeLine(centerX+a, centerY+b-r, centerX+a, centerY+b+r+50);
        gc.strokeLine(centerX-a, centerY+b+r+40, centerX+a, centerY+b+r+40);

        drawArrowHead(gc, centerX-a, centerY+r+b+40, 1, 0);
        drawArrowHead(gc, centerX+a, centerY+r+b+40, -1, 0);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("w %.2f [mm]", width), centerX,centerY+b+r+30);

        var cX = centerX-a;
        var cY = centerY-b;

        var pX = cX -COS_45*r;
        var pY = cY-COS_45*r;

        gc.strokeLine(pX, pY, pX+40, pY+40);
        drawArrowHead(gc, pX, pY, COS_45, SIN_45);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("r %.2f [mm]", radius), pX+50, pY+50);

        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*r, centerY, centerX+0.25*r, centerY);
        gc.strokeLine(centerX, centerY-0.25*r, centerX, centerY+0.25*r);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, centerX, centerY);


    }

    private void drawRectangularHole(GraphicsContext gc) {

        var shape = selectedHoleShape.getValue().getParametricHole2D().getValue();
        if ( ! (shape instanceof RectangularHoleT rechHoleT)) {
            LOG.error("expected a RectangularHoleT but got {}", shape.getClass());
            return;
        }

        var width = UnitConverter.toDefaultUnit(rechHoleT.getWidth());
        var height = UnitConverter.toDefaultUnit(rechHoleT.getHeight());
        var radius = UnitConverter.toDefaultUnit(rechHoleT.getFilletRadius());


        var scaleY = (canvasHeight - 300) / height;
        var scaleX = (canvasWidth - 300) / width;
        var scale = Math.min(scaleX, scaleY);

        var w = Math.round(width* scale);
        var h = Math.round(height* scale);
        var b = h/2.0;
        var a = w/2.0;
        var r = Math.round(radius* scale);

        var centerX = Math.round(canvasWidth / 2.0) + 0.5;
        var centerY = Math.round(canvasHeight /2.0) + 0.5;
        drawPanelBoundary(gc);


        if ( r >1) {
            gc.moveTo(centerX - a+r, centerY - b);
            gc.arc(centerX-a+r, centerY-b+r, r, r, 90, 90);
            gc.lineTo(centerX - a, centerY + b-r);
            gc.arc(centerX-a+r, centerY+b-r, r, r, 180, 90);
            gc.lineTo(centerX + a-r, centerY + b);
            gc.arc(centerX+a-r, centerY+b-r, r, r, 270,90);
            gc.lineTo(centerX + a, centerY - b+r);
            gc.arc(centerX+a-r, centerY-b+r, r, r, 0,90);
            gc.lineTo(centerX - a+r, centerY - b);
        } else {
            gc.moveTo(centerX - a, centerY - b);
            gc.lineTo(centerX - a, centerY + b);
            gc.lineTo(centerX + a, centerY + b);
            gc.lineTo(centerX + a, centerY - b);
            gc.lineTo(centerX - a, centerY - b);
        }

        gc.setEffect(dropShadow);
        gc.closePath();
        gc.fill();
        gc.setEffect(null);


        gc.setStroke(dimensionLineColor);
        gc.setLineWidth(2);
        if ( r >1) {
            gc.strokeRoundRect(centerX - a, centerY - b, w, h, 2 * r, 2 * r);
        } else {
            gc.strokeRect(centerX - a, centerY - b, w, h);
        }

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX+a-r, centerY-b, centerX+a+50, centerY-b);
        gc.strokeLine(centerX+a-r, centerY+b, centerX+a+50, centerY+b);
        gc.strokeLine(centerX+a+40, centerY-b, centerX+a+40, centerY+b);

        drawArrowHead(gc, centerX+a+40, centerY-b, 0, 1);
        drawArrowHead(gc, centerX+a+40, centerY+b, 0, -1);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h %.2f [mm]", height), centerX+a+50, centerY);

        // width
        gc.strokeLine(centerX-a, centerY+b-r, centerX-a, centerY+b+50);
        gc.strokeLine(centerX+a, centerY+b-r, centerX+a, centerY+b+50);
        gc.strokeLine(centerX-a, centerY+b+40, centerX+a, centerY+b+40);

        drawArrowHead(gc, centerX-a, centerY+b+40, 1, 0);
        drawArrowHead(gc, centerX+a, centerY+b+40, -1, 0);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("w %.2f [mm]", width), centerX,centerY+b+30);

        if (r > 1) {
            var cX = centerX-a+r;
            var cY = centerY-b+r;

            var pX = cX -COS_45*r;
            var pY = cY-COS_45*r;

            gc.strokeLine(pX, pY, pX+40, pY+40);
            drawArrowHead(gc, pX, pY, COS_45, SIN_45);

            gc.setFill(textColor);
            gc.setTextAlign(TextAlignment.LEFT);
            gc.fillText(String.format("r %.2f [mm]", radius), pX+50, pY+40);

        }
        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*a, centerY, centerX+0.25*a, centerY);
        gc.strokeLine(centerX, centerY-0.25*b, centerX, centerY+0.25*b);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, centerX, centerY);


    }

    private void drawSuperElliptical(GraphicsContext gc) {

        var shape = selectedHoleShape.getValue().getParametricHole2D().getValue();
        if ( ! (shape instanceof SuperEllipticalT ellipticalHoleHole)) {
            LOG.error("expected a SuperEllipticalT but got {}", shape.getClass());
            return;
        }

        var width = UnitConverter.toDefaultUnit(ellipticalHoleHole.getWidth());
        var height = UnitConverter.toDefaultUnit(ellipticalHoleHole.getHeight());
        var exponent = ellipticalHoleHole.getExponent();
        if (exponent ==0 ) {
            exponent = 2;
        }
        if ( exponent <1 || exponent> 4) {
            LOG.error("powerNumerator {} out of range [1,4]", exponent);
            return;
        }

        //The powerNumerator of the super ellipse equation (x/Height)**e + (y/Width)**e = 1.
        // If e=2.5 the result is a super ellipse while e=2.0 results in a normal ellipse.
        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;
        var scale = Math.min(scaleX, scaleY);

        var b = Math.round(height* scale/2.0);
        var a = Math.round(width* scale/2.0);

        // paint the coordinate system of the tube
        var centerX = Math.round(canvasWidth / 2.0) + 0.5;
        var centerY = Math.round(canvasHeight /2.0) + 0.5;
        drawPanelBoundary(gc);

        var points = new ArrayList<Point2D>();

        for( int i = 0; i >=-360; i -= 5) {
            var angle = Math.toRadians(1.0*i);
            // (x/Height)**e + (y/Width)**e = 1.
            var dx = Math.cos(angle)*a;
            var c0= 1- Math.pow(Math.abs(dx/a), exponent);
            var dy = b * Math.pow( c0, 1.0/exponent) * Math.signum(Math.sin(angle));
            var p = new Point2D(centerX + dx, centerY + dy );

            points.add( p);
        }
        for (int i = 0; i < points.size(); i++) {
            var p = points.get(i);
            if ( i==0) {
                gc.moveTo(p.getX(), p.getY());
                continue;
            }
            gc.lineTo(p.getX(), p.getY());
        }
        gc.closePath();

        gc.setEffect(dropShadow);
        gc.closePath();
        gc.fill();
        gc.setEffect(null);

        gc.setStroke(dimensionLineColor);
        gc.setLineWidth(2);
        gc.beginPath();
        for (int i = 0; i < points.size(); i++) {
            var p = points.get(i);
            if ( i==0) {
                gc.moveTo(p.getX(), p.getY());
                continue;
            }
            gc.lineTo(p.getX(), p.getY());
        }


        gc.stroke();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX, centerY-b, centerX+a+50, centerY-b);
        gc.strokeLine(centerX, centerY+b, centerX+a+50, centerY+b);
        gc.strokeLine(centerX+a+40, centerY-b, centerX+a+40, centerY+b);

        drawArrowHead(gc, centerX+a+40, centerY-b, 0, 1);
        drawArrowHead(gc, centerX+a+40, centerY+b, 0, -1);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h %.2f [mm]", height), centerX+a+50, centerY);

        // width
        gc.strokeLine(centerX-a, centerY, centerX-a, centerY+b+50);
        gc.strokeLine(centerX+a, centerY, centerX+a, centerY+b+50);
        gc.strokeLine(centerX-a, centerY+b+40, centerX+a, centerY+b+40);

        drawArrowHead(gc, centerX-a, centerY+b+40, 1, 0);
        drawArrowHead(gc, centerX+a, centerY+b+40, -1, 0);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("w %.2f [mm]", width), centerX,centerY+b+30);

        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*a, centerY, centerX+0.25*a, centerY);
        gc.strokeLine(centerX, centerY-0.25*b, centerX, centerY+0.25*b);
        gc.restore();

        // powerNumerator
        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("powerNumerator %.2f", exponent), 120,120);

        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*a, centerY, centerX+0.25*a, centerY);
        gc.strokeLine(centerX, centerY-0.25*b, centerX, centerY+0.25*b);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, centerX, centerY);
    }

    private void drawSymmetricHole(GraphicsContext gc) {

        var shape = selectedHoleShape.getValue().getParametricHole2D().getValue();
        if ( ! (shape instanceof SymmetricalHoleT symmetricalHole)) {
            LOG.error("expected a SymmetricalHoleT but got {}", shape.getClass());
            return;
        }

        var width = UnitConverter.toDefaultUnit(symmetricalHole.getWidth());
        var height = UnitConverter.toDefaultUnit(symmetricalHole.getHeight());
        var diameter = width > height ? height : width;

        //LOG.info("width {} height {} diameter {}", width, height, diameter);

        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;
        var scale = Math.min(scaleX, scaleY);

        //LOG.info("scale {} scaleX {} scaleY {}", scale, scaleX, scaleY);

        var h = Math.round(height* scale);
        var w = Math.round(width* scale);
        var r = Math.round(diameter* scale*0.5);

        LOG.info("width {} height {} diameter {}", w, h, r);

        // paint the coordinate system of the tube
        var centerX = Math.round(canvasWidth / 2.0) + 0.5;
        var centerY = Math.round(canvasHeight /2.0) + 0.5;

        // paint the panel with the hole
        drawPanelBoundary(gc);

        if ( height > width) {
            gc.moveTo(centerX - 0.5 * w, 100 + r);
            gc.lineTo(centerX - 0.5 * w, canvasHeight - 100 - r);
            gc.arc(centerX, canvasHeight - 100 - r, r, r, 180, 180);
            gc.lineTo(centerX + 0.5 * w, 100 + r);
            gc.arc(centerX, 100+r, r, r, 0, 180);
        } else {
            gc.moveTo(centerX - 0.5 * w+r, 100 );
            gc.arc(centerX-0.5*w+r, centerY, r, r, 90, 180);
            gc.lineTo(centerX + 0.5 * w-r , canvasHeight - 100);
            gc.arc(centerX+0.5*w-r, centerY,  r, r, -90, 180);
            gc.lineTo(centerX - 0.5 * w+r, 100 );
        }

        gc.setEffect(dropShadow);
        gc.closePath();
        gc.fill();
        gc.setEffect(null);

        gc.setStroke(dimensionLineColor);
        gc.setLineWidth(2);

        if ( height > width) {
            gc.strokeRoundRect(centerX - 0.5 * w, 100, w, h, w, w);
        } else {
            gc.strokeRoundRect(centerX - 0.5 * w, 100, w, h, h, h);
        }

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX, 100, centerX+w/2.0+50, 100);
        gc.strokeLine(centerX, canvasHeight-100, centerX+w/2.0+50, canvasHeight-100);
        gc.strokeLine(centerX+w/2.0+40, 100, centerX+w/2.0+40, canvasHeight-100);

        drawArrowHead(gc, centerX+w/2.0+40, 100, 0, 1);
        drawArrowHead(gc, centerX+w/2.0+40, canvasHeight-100, 0, -1);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h %.2f [mm]", height), centerX+w/2.0+50, centerY);

        // width
        gc.strokeLine(centerX-w/2.0, centerY, centerX-w/2.0, canvasHeight-60);
        gc.strokeLine(centerX+w/2.0, centerY, centerX+w/2.0, canvasHeight-60);
        gc.strokeLine(centerX-w/2.0, canvasHeight-70, centerX+w/2.0, canvasHeight-70);

        drawArrowHead(gc, centerX-w/2.0, canvasHeight-70, 1, 0);
        drawArrowHead(gc, centerX+w/2.0, canvasHeight-70, -1, 0);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("w %.2f [mm]", width), centerX,canvasHeight-80);

        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*r, centerY, centerX+0.25*r, centerY);
        gc.strokeLine(centerX, centerY-0.25*r, centerX, centerY+0.25*r);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, centerX, centerY);


    }



    private void drawCircle(GraphicsContext gc) {

        var shape = selectedHoleShape.getValue().getParametricHole2D().getValue();
        if ( ! (shape instanceof ParametricCircleT circle)) {
            LOG.error("expected a ParametricCircleT but got {}", shape.getClass());
            return;
        }

        var diameter = UnitConverter.toDefaultUnit(circle.getDiameter());

        var scaleY = (canvasHeight - 200) / diameter;
        var scaleX = (canvasWidth - 200) / diameter;

        var scale = Math.min(scaleX, scaleY);

        var r = Math.round(diameter* scale*0.5);

        // paint the coordinate system of the tube
        var centerX = Math.round(canvasWidth / 2.0) + 0.5;
        var centerY = Math.round(canvasHeight /2.0) + 0.5;

        // paint the panel with the hole
        drawPanelBoundary(gc);

        gc.moveTo(centerX+r, centerY+r);
        gc.arc(centerX, centerY, r, r,0,360);

        gc.setEffect(dropShadow);
        gc.closePath();
        gc.fill();
        gc.setEffect(null);


        gc.setStroke(dimensionLineColor);
        gc.setLineWidth(2);
        gc.strokeArc(centerX-r, centerY-r, 2*r, 2*r, 180, 360, ArcType.OPEN);


        // diameter
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX, centerY-r, centerX+r+50, centerY-r);
        gc.strokeLine(centerX, centerY+r, centerX+r+50, centerY+r);
        gc.strokeLine(centerX+r+40, centerY-r, centerX+r+40, centerY+r);

        drawArrowHead(gc, centerX+r+40, centerY-r, 0, 1);
        drawArrowHead(gc, centerX+r+40, centerY+r, 0, -1);

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("⌀ %.2f [mm]", diameter), centerX+r+50, centerY);

        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*r, centerY, centerX+0.25*r, centerY);
        gc.strokeLine(centerX, centerY-0.25*r, centerX, centerY+0.25*r);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, centerX, centerY);

    }


    private void drawCossys(GraphicsContext gc, double coordX, double coordY) {
        gc.setStroke(cosysColor);
        gc.setFill(cosysColor);
        gc.setLineWidth(coosysLineWidth);
        gc.strokeLine(coordX, coordY , coordX + 50, coordY );
        gc.strokeLine(coordX+40, coordY-5 , coordX + 50, coordY );
        gc.strokeLine(coordX+40, coordY+5 , coordX + 50, coordY );

        gc.strokeLine(coordX, coordY , coordX, coordY  - 50);
        gc.strokeLine(coordX-5, coordY-40 , coordX, coordY  - 50);
        gc.strokeLine(coordX+5, coordY-40 , coordX, coordY  - 50);


    }
    private void drawPanelBoundary(GraphicsContext gc) {
        var pointsRaw = new ArrayList<Point2D>();



        pointsRaw.add( new Point2D(50,50));
        pointsRaw.add( new Point2D(0.33*canvasWidth+50,50));
        pointsRaw.add( new Point2D(0.66*canvasWidth+50,50));
        pointsRaw.add( new Point2D(canvasWidth-50,50));
        pointsRaw.add( new Point2D(canvasWidth-50,0.33*canvasHeight+50));
        pointsRaw.add( new Point2D(canvasWidth-50,0.66*canvasHeight-50));
        pointsRaw.add( new Point2D(canvasWidth-50,canvasHeight-50));
        pointsRaw.add( new Point2D(0.66*canvasWidth-50,canvasHeight-50));
        pointsRaw.add( new Point2D(0.33*canvasWidth+50,canvasHeight-50));
        pointsRaw.add( new Point2D(50,canvasHeight-50));
        pointsRaw.add( new Point2D(50,0.66*canvasHeight-50));
        pointsRaw.add( new Point2D(50,0.33*canvasHeight+50));


        var max = Math.min( canvasWidth, canvasHeight) / 25;
        var pointsWiggly = new ArrayList<Point2D>();
        pointsRaw.forEach(point -> {
            pointsWiggly.add(new Point2D(point.getX()+(RANDOM.nextDouble()*max)/2.0, point.getY() + (RANDOM.nextDouble()*max)/2.0));});

        pointsWiggly.add(pointsWiggly.getFirst());

        gc.setFill(panelColor);
        gc.setLineWidth(0);
        gc.beginPath();

        for (int i = 0; i < pointsWiggly.size(); i++) {
            var p = pointsWiggly.get(i);
            if ( i==0) {
                gc.moveTo(p.getX(), p.getX());
                continue;
            }
            gc.lineTo(p.getX(), p.getY());
        }
    }


    private void drawArrowHead(GraphicsContext gc, double x, double y, double xDir, double yDir) {

        double lw = Math.max(gc.getLineWidth(),1);
        lw = Math.min(lw, 5);

        var p0 = new Point2D(0, 0);
        var p1 = new Point2D(10*lw, 3*lw);
        var p2 = new Point2D(10*lw, -3*lw);

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

    private void updateHoleShape(Hole2D oldSection, Hole2D selectedSection) {

        LOG.info("Updating hole section {} ({})", selectedSection.getId() , selectedSection.getGUIDRef() );
        selectedHoleShape.setValue(selectedSection);

        barLabel.setText(HoleShapeType.getType(selectedSection).getName() + " " + selectedSection.getId());
        barLabel.getStyleClass().add(Styles.TITLE_4);

        repaintCanvas();
    }

}
