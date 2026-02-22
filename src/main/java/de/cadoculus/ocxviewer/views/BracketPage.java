/*
Copyright 2025 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer.views;

import atlantafx.base.controls.ToggleSwitch;
import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.event.ThemeEvent;
import de.cadoculus.ocxviewer.geom.BracketGeometry;
import de.cadoculus.ocxviewer.geom.GeomHelper;
import de.cadoculus.ocxviewer.geom.MainPlane;
import de.cadoculus.ocxviewer.geom.PlaneGeometry;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.utils.CSSUtil;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignV;
import org.ocx_schema.v310.Bracket;

import javax.vecmath.Matrix4d;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

/**
 * A page displaying information about a Bracket.
 * The BracketPage is not intended to be navigated directly, but rather as a logical child.
 * The style of the sketch drawing is configured via CSS using the #brackets identifier.
 *
 * @author Carsten Zerbst
 */
public class BracketPage extends AbstractDataViewSubPage<org.ocx_schema.v310.Bracket> {
    public static final String NAME = "Bracket";
    private static final Logger LOG = LogManager.getLogger(BracketPage.class);

    private final BracketGeometry.BracketPoints3D bracketGeometry3D;
    private final BracketGeometry.BracketPoints2D bracketGeometry2D;
    private  final List<Point3d> bracketContour;
    private final Canvas canvas = new Canvas();
    private final HBox sketchBox = new HBox();
    private final TabPane dimeAndSketchTab;
    private final GridPane dimensionGrid = new GridPane();
    private final Matrix4d viewHoco = new Matrix4d();

    // Fill
    private Color bracketColour = Color.GREEN;
    // Colour1
    private Color bracketBorderColour = Color.DARKGREEN;
    // Colour2
    private Color shadowColour = Color.GRAY;
    // Colour3
    private Color pointLineColour = Color.RED;
    // Colour4
    private Color cosysColour = Color.BLUE;

    private Color textColour = Color.BLACK;

    private Color dimensionLineColour = Color.BLACK;

    // Width 1
    private  double bracketLineWidth = 2.0;
    // Width 2
    private  double dimensionLineWidth = 1.0;
    // Width 3
    private  double coosysLineWidth = 4.0;


    private final DropShadow dropShadow = new DropShadow();
    private Pane pane;
    private boolean drawBracketContour;


    public BracketPage(Bracket bracket, Page parent) {
        super(bracket, parent, "Bracket «" + bracket.getId() + "»");

        BracketGeometry bracketGeometry = new BracketGeometry(bracket);
        bracketGeometry3D = bracketGeometry.getBracketGeometry();
        bracketGeometry2D = bracketGeometry.getBracketGeometry2D();
        bracketContour = bracketGeometry.getBracketContour();

        DefaultEventBus.getInstance().subscribe( ThemeEvent.class, themeEvent -> {
            updatedStyle();
            updateCanvas();
        });

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about an OCX Bracket");

        GridPane gridPane = createDefaultGrid();
        setCenter(gridPane);

        int row = 0;

        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

        // ocx:Name
        var label = new Label("Id");
        label.setTooltip(new Tooltip("The bracket's Id"));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), getObject(), "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The bracket's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), getObject(), "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The bracket's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), getObject(), "GUIDRef", String.class);


        var tabSketch = createSketchTab();
        var tabDimensions = createDimensionsTab();
        dimeAndSketchTab = new TabPane(tabSketch, tabDimensions);
        gridPane.add(dimeAndSketchTab, 0, row, 4, 3);

        // ensure the last row gets all available space
        for (int r = 0; r < GridPane.getRowIndex(dimeAndSketchTab); r++) {
            gridPane.getRowConstraints().add(new RowConstraints());
        }

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        rc.setMinHeight(200);
        gridPane.getRowConstraints().add(rc);


        this.boundsInLocalProperty().addListener((bound, oldBound, newBound) -> updateCanvas());
        WorkingContext.getInstance().darkModeProperty().addListener(obs -> updateCanvas());
        updateCanvas();

    }

    /**
     * Updates the parameters used in the canvas from CSS.
     */
    private void updatedStyle() {
        final CSSRecord brackets = CSSUtil.lookup("brackets");
        bracketColour = brackets.fill() != null ? brackets.fill() : bracketColour;
        bracketBorderColour= brackets.colour1() != null ? brackets.colour1() : bracketBorderColour;
        shadowColour = brackets.colour2() != null ? brackets.colour2() : shadowColour;
        pointLineColour  = brackets.colour3() != null ? brackets.colour3() : pointLineColour;
        cosysColour  = brackets.colour4() != null ? brackets.colour4() : cosysColour;
        textColour = brackets.colour5() != null ? brackets.colour5() : textColour;
        dimensionLineColour = textColour;

        bracketLineWidth = Double.isNaN( brackets.width1()) ? bracketLineWidth : brackets.width1();
        dimensionLineWidth = Double.isNaN( brackets.width2()) ? dimensionLineWidth : brackets.width2();
        coosysLineWidth = Double.isNaN( brackets.width3()) ? coosysLineWidth : brackets.width3();

    }


    /**
     * repaint the canvas using the precalculated geometry from {@link BracketGeometry },
     * the current canvas dimensions, and the current CSS settings.
     */
    private void  updateCanvas() {


        double canvasHeight = dimeAndSketchTab.getHeight() -30;
        double canvasWidth = dimeAndSketchTab.getWidth() - 21;

        canvas.setHeight(canvasHeight);
        canvas.setWidth(canvasWidth);

        double dim = Math.min(canvasWidth, canvasHeight) / 33.0;
        dropShadow.setOffsetY(dim);
        dropShadow.setOffsetX(dim);
        dropShadow.setColor(shadowColour);

        var labelX = 10;
        var labelY = pane.getHeight() - sketchBox.getHeight();
        //sketchBox.relocate(labelX, labelY);
        sketchBox.setLayoutX(labelX);
        sketchBox.setLayoutY(labelY);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


        int textHeight = canvasHeight /50 < 12 ? 12 : (int) (canvasHeight /50);
        gc.setFont(new Font(gc.getFont().getName(), textHeight));

        if  (bracketGeometry2D == null) {
            gc.setFill(textColour);
            gc.fillText("No 2D Geometry available for this Bracket", 10, 20);
            return;
        }

        var height = bracketGeometry2D.height();
        var width = bracketGeometry2D.width();
        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 250) / width;
        var scale = Math.min(scaleX, scaleY);

        var offsetX = Math.round( (canvasWidth - scale * width) / 2.0);
        var offsetY = 100.0;

        LOG.debug("offsetX {}, offsetY {}", offsetX, offsetY);


        viewHoco.setIdentity();
        //viewHoco.m11=-1;
        viewHoco.setScale(scale);
        viewHoco.m03 = offsetX;
        viewHoco.m13 = offsetY;

        LOG.debug("viewHoco\n{}", viewHoco);

        drawBracketShape(gc);

        // draw key points and try to avoid overlapping text
        // Origin
        var offDir = new Vector3d(bracketGeometry2D.uDirection());
        offDir.add( bracketGeometry2D.vDirection());
        offDir.negate();
        offDir.normalize();
        offDir.scale(4*textHeight);

        var d = 5*scale;
        if  ( d <5) {
            d = 5;
        } else if ( d > 20) {
            d = 20;
        }


        drawPoint( gc, viewHoco, bracketGeometry2D.origin(),  d, pointLineColour,2,
                "(%.1f, %.1f, %.1f)".formatted(bracketGeometry3D.origin().x, bracketGeometry3D.origin().y,bracketGeometry3D.origin().z),
                textColour, offDir, dimensionLineColour, 1);


        // p1 (udir)
        offDir = new Vector3d(bracketGeometry2D.uDirection());
        offDir.normalize();
        offDir.scale(4*textHeight);

        drawPoint( gc, viewHoco, bracketGeometry2D.p1(), d, pointLineColour,2,
                "(%.1f, %.1f, %.1f)".formatted(bracketGeometry3D.p1().x, bracketGeometry3D.p1().y,bracketGeometry3D.p1().z),
                textColour, offDir, dimensionLineColour, 1);

        // p2 (vdir)
        offDir = new Vector3d(bracketGeometry2D.vDirection());
        offDir.normalize();
        offDir.scale(4*textHeight);
        drawPoint( gc, viewHoco, bracketGeometry2D.p2(), d, pointLineColour,2,
                "(%.1f, %.1f, %.1f)".formatted(bracketGeometry3D.p2().x, bracketGeometry3D.p2().y,bracketGeometry3D.p2().z),
                textColour,  offDir, dimensionLineColour, 1);

        if ( bracketGeometry2D.p5() != null ) {

            offDir = new Vector3d(bracketGeometry2D.p5());
            offDir.sub(bracketGeometry2D.origin());
            offDir.normalize();
            offDir.scale(4*textHeight);
            drawPoint( gc, viewHoco, bracketGeometry2D.p5(), d, pointLineColour,2,
                    "%.1f, %.1f, %.1f".formatted(bracketGeometry3D.p5().x, bracketGeometry3D.p2().y,bracketGeometry3D.p2().z),
                    textColour,  offDir, dimensionLineColour, 1);

        }

        drawBracketDimensions(gc);

        drawCoordinatSystem( gc);

        if ( drawBracketContour) {
            drawBracketContour(gc);
        }

    }

    private void drawCoordinatSystem(GraphicsContext gc) {

        final MainPlane mainPlane = GeomHelper.getMainPlane(new Vector3d(viewHoco.m03, viewHoco.m13, viewHoco.m23));
        LOG.info("drawCoordinatSystem {} {}", mainPlane, viewHoco);

        var global2local = bracketGeometry2D.global2localT();
        LOG.info("bracketGeometry2D.hoco {}", global2local);

        var xVector = new Vector3d(PlaneGeometry.NORMAL_X);
        global2local.transform(xVector);
        viewHoco.transform(xVector);
        xVector.normalize();
        xVector.scale(50);

        var yVector = new Vector3d(PlaneGeometry.NORMAL_Y);
        global2local.transform(yVector);
        viewHoco.transform(yVector);
        yVector.normalize();
        yVector.scale(50);

        var zVector = new Vector3d(PlaneGeometry.NORMAL_Z);
        global2local.transform(zVector);
        viewHoco.transform(zVector);
        zVector.normalize();
        zVector.scale(50);

        LOG.info("coosys dir in view coord: xVector' {}, yVector' {}, zVector' {}", xVector, yVector, zVector);

        var  offset = 75;

        gc.setStroke( cosysColour);
        gc.setFill(cosysColour);

        var coosysStart = new Point3d(canvas.getWidth()-offset, canvas.getHeight()-offset,0);

        if ( Math.abs(xVector.x) > 1 || Math.abs(yVector.y) > 1 ) {
            gc.setLineWidth(coosysLineWidth);
            var tipPoint = new Point3d(canvas.getWidth()-offset + xVector.x, canvas.getHeight()-offset + xVector.y,0);
            gc.strokeLine(coosysStart.x, coosysStart.y, tipPoint.x, tipPoint.y);
            drawLineArrowHead(gc, tipPoint, yVector, 10, cosysColour, coosysLineWidth);

            gc.fillText("X", canvas.getWidth()-offset+ xVector.x +10,
                                canvas.getHeight()-offset + xVector.y+10);
        }

        if ( Math.abs(yVector.x) > 1 || Math.abs(yVector.y) > 1 ) {
            gc.setLineWidth(coosysLineWidth);
            var tipPoint = new Point3d(canvas.getWidth()-offset + yVector.x,canvas.getHeight()-offset + yVector.y,0);
            gc.strokeLine(coosysStart.x, coosysStart.y,  tipPoint.x, tipPoint.y);
            drawLineArrowHead(gc, tipPoint, yVector, 10, cosysColour, coosysLineWidth);

            gc.fillText("Y", canvas.getWidth()-offset+ yVector.x +10,
                    canvas.getHeight()-offset + yVector.y+10);
        }

        if ( Math.abs(zVector.x) > 1 || Math.abs(zVector.y) > 1 ) {
            gc.setLineWidth(coosysLineWidth);
            var tipPoint = new Point3d(canvas.getWidth()-offset + zVector.x, canvas.getHeight()-offset + zVector.y,0);
            gc.strokeLine(coosysStart.x, coosysStart.y,  tipPoint.x, tipPoint.y);
            var zInv = new Vector3d(zVector);
            zInv.negate();
            drawLineArrowHead(gc, tipPoint, zInv, 10, cosysColour, coosysLineWidth);

            gc.fillText("Z", canvas.getWidth()-offset+ zVector.x +10,
                    canvas.getHeight()-offset + zVector.y+10);
        }


    }

    private void drawBracketDimensions(GraphicsContext gc) {

        gc.setStroke(dimensionLineColour);
        gc.setFill(dimensionLineColour);
        gc.setLineWidth(dimensionLineWidth);

        // U direction dimension
        drawDimensionLine(gc, viewHoco, bracketGeometry2D.origin(), bracketGeometry2D.p1(), bracketGeometry2D.vDirection(),
                String.format("u=%.2f [mm]", bracketGeometry3D.armLengthU()));

        // V direction dimension
        drawDimensionLine(gc, viewHoco, bracketGeometry2D.origin(), bracketGeometry2D.p2(), bracketGeometry2D.uDirection(),
                String.format("v=%.2f [mm]", bracketGeometry3D.armLengthV()));

        if ( bracketGeometry2D.p5() != null) {
            // TODO: get rid of the duplicated code
            var center = new Point3d(bracketGeometry2D.p5());
            var p3p4 = new Vector3d(bracketGeometry2D.p4());
            p3p4.sub(bracketGeometry2D.p3());
            p3p4.scale(0.5);

            var pM = new Point3d(bracketGeometry2D.p3());
            pM.add(p3p4);

            var center2pM = new Vector3d(pM);
            center2pM.sub(center);
            center2pM.normalize();
            center2pM.scale( bracketGeometry3D.freeEdgeRadius());

            var por = new Point3d(center);
            por.add(center2pM);

            drawRadiusDimensionLine(gc, viewHoco, center, por, String.format("r=%.1f [mm]", bracketGeometry3D.freeEdgeRadius()));

        }


    }

    private void drawBracketContour(GraphicsContext gc) {
        LOG.info("drawBracketContour");
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(bracketLineWidth);

        gc.beginPath();

        boolean first = true;
        for (Point3d point3d : bracketContour) {

            var p = new Point3d(point3d);
            bracketGeometry2D.global2localT().transform(p);
            viewHoco.transform(p);

            if ( first) {
                gc.moveTo(p.x, p.y);
                first = false;
            } else {
                gc.lineTo(p.x, p.y);
            }
        }

        gc.closePath();
        gc.stroke();


    }


    /**
     * Paints the bracket shape on the canvas using the 2D geometry from {@link BracketGeometry},
     * @param gc the GraphicsContext to paint on
     */
    private void drawBracketShape(GraphicsContext gc) {

        gc.setFill(bracketColour);
        gc.setStroke(bracketBorderColour);
        gc.setLineWidth(bracketLineWidth);

        gc.beginPath();

        if ( bracketGeometry3D.copeRadius() > 0) {

            var p02 = new Point3d( bracketGeometry2D.p02());
            viewHoco.transform(p02);
            gc.moveTo(p02.x, p02.y);

            var center = new Point3d(bracketGeometry2D.origin());
            viewHoco.transform(center);

            double radius = p02.distance(center);

            var startDir = new Vector3d(p02);
            startDir.sub(center);

            LOG.debug("arc center {}, startDir {}, radius {}", center, startDir, radius);

            var startAngle = Math.toDegrees(new Vector3d(1,0,0).angle(startDir));
            var length = Math.toDegrees( bracketGeometry2D.uDirection().angle( bracketGeometry2D.vDirection()));

            var uDir = new Vector3d(bracketGeometry2D.uDirection());
            viewHoco.transform(uDir);
            var vDir = new Vector3d(bracketGeometry2D.vDirection());
            viewHoco.transform(vDir);

            var cross = new Vector3d();
            cross.cross(uDir, vDir);

             if ( cross.z < 0) {
                 length = -length;
             }

            LOG.debug("start angle {}, length {}", startAngle, length);

            gc.arc(center.x, center.y, radius, radius, startAngle, length);


        } else if ( bracketGeometry3D.copeHeight() > 0) {
            var p02 = new Point3d( bracketGeometry2D.p02());
            viewHoco.transform(p02);
            gc.moveTo(p02.x, p02.y);

            var p01 = new Point3d( bracketGeometry2D.p01());
            viewHoco.transform(p01);
            gc.lineTo(p01.x, p01.y);

        } else {
            var start = new Point3d( bracketGeometry2D.origin());
            viewHoco.transform(start);
            gc.moveTo(start.x, start.y);
        }

        var next = new Point3d(bracketGeometry2D.p1());
        viewHoco.transform(next);
        gc.lineTo(next.x, next.y);

        next = new Point3d(bracketGeometry2D.p3());
        viewHoco.transform(next);
        gc.lineTo(next.x, next.y);


        if ( bracketGeometry2D.p5() != null) {
            // calculate in original 2D space

            var center = new Point3d(bracketGeometry2D.p5());

            var p3p4 = new Vector3d(bracketGeometry2D.p4());
            p3p4.sub(bracketGeometry2D.p3());
            p3p4.scale(0.5);

            var pM = new Point3d(bracketGeometry2D.p3());
            pM.add(p3p4);

            var center2pM = new Vector3d(pM);
            center2pM.sub(center);
            center2pM.normalize();
            center2pM.scale( bracketGeometry3D.freeEdgeRadius());

            var por = new Point3d(center);
            por.add(center2pM);

            next = new Point3d(bracketGeometry2D.p4());
            viewHoco.transform(next);

            viewHoco.transform(por);
            viewHoco.transform(center);

            gc.arcTo(por.x, por.y, next.x,next.y, por.distance(center));
        } else {
            next = new Point3d(bracketGeometry2D.p4());
            viewHoco.transform(next);
            gc.lineTo(next.x, next.y);
        }

        next = new Point3d(bracketGeometry2D.p2());
        viewHoco.transform(next);
        gc.lineTo(next.x, next.y);

        gc.closePath();
        gc.stroke();
        gc.setEffect(dropShadow);
        gc.fill();
        gc.setEffect(null);

    }




    private Tab createDimensionsTab() {
        var tab = new Tab("Dimensions & Material");
        tab.setClosable(false);

        ScrollPane scrollPane = new ScrollPane();
        tab.setContent(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        scrollPane.setContent(dimensionGrid);

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
        dimensionGrid.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 10;");

        var bracket = getObject();
        //
        // Bracket Parameters
        //
        Label label ;
        Label titelLabel;
        int row = 0;

        if (bracket.getBracketParameters() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No Bracket Parameters found in Bracket",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            dimensionGrid.add(warning, 0, row, 4, 1);
        } else {
            titelLabel = new Label("Bracket Parameters");
            titelLabel.getStyleClass().add(Styles.TITLE_4);
            dimensionGrid.add(titelLabel, 0, row++, 4, 1);
            GridPane.setHalignment(titelLabel, HPos.LEFT);
            GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


            label = new Label("Origin");
            label.setTooltip(new Tooltip("The origin or root point of the Bracket"));
            dimensionGrid.add(label, 0, row);

            var group = createOrRebind(null, bracket.getBracketParameters().getOrigin(), true);
            dimensionGrid.add(group, 1, row++);


            // U
            label = new Label("U-Arm Length");
            label.setTooltip(new Tooltip("The bracket's U arm length"));
            dimensionGrid.add(label, 0, row);

            group = createOrRebind(null, bracket.getBracketParameters().getArmLengthU(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("U-Direction");
            label.setTooltip(new Tooltip("Local U-direction of the Bracket"));
            dimensionGrid.add(label, 2, row);

            group = createOrRebind(null, bracket.getBracketParameters().getUDirection(), true);
            dimensionGrid.add(group, 3, row++);

            // V
            label = new Label("V-Arm Length");
            label.setTooltip(new Tooltip("The bracket's V arm length"));
            dimensionGrid.add(label, 0, row);

            group = createOrRebind(null, bracket.getBracketParameters().getArmLengthV(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("V-Direction");
            label.setTooltip(new Tooltip("Local V-direction of the Bracket"));
            dimensionGrid.add(label, 2, row);

            group = createOrRebind(null, bracket.getBracketParameters().getVDirection(), true);
            dimensionGrid.add(group, 3, row++);


            // Nose
            label = new Label("U Nose");
            label.setTooltip(new Tooltip("The bracket nose depth at the local U end of the bracket. "));
            dimensionGrid.add(label, 0, row);
            group = createAndBind(bracket.getBracketParameters().getUnose(), false);
            dimensionGrid.add(group, 1, row);

            label = new Label("V Nose");
            label.setTooltip(new Tooltip("The bracket nose depth at the local V end of the bracket. "));
            dimensionGrid.add(label, 2, row);
            group = createAndBind(bracket.getBracketParameters().getUnose(), false);
            dimensionGrid.add(group, 3, row++);

            label = new Label("Free Edge Radius");
            label.setTooltip(new Tooltip("??"));
            dimensionGrid.add(label, 0, row);
            group = createAndBind(bracket.getBracketParameters().getFreeEdgeRadius(), false);
            dimensionGrid.add(group, 1, row++);

            if ( bracket.getBracketParameters().getFeatureCope() != null ) {

                titelLabel = new Label("Feature Cope");
                titelLabel.getStyleClass().add(Styles.TITLE_4);
                dimensionGrid.add(titelLabel, 0, row++, 4, 1);
                GridPane.setHalignment(titelLabel, HPos.LEFT);
                GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

                label = new Label("Cope Radius");
                label.setTooltip(new Tooltip("The length of the cope measured along the stiffener trace-line (X-axis)  from the end of the stiffener to the centre of the cope radius."));
                dimensionGrid.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFeatureCope().getCopeRadius(), true);
                dimensionGrid.add(group, 1, row++);

                label = new Label("Cope Length");
                label.setTooltip(new Tooltip("The length of the cope measured along the stiffener trace-line (X-axis)  from the end of the stiffener to the centre of the cope radius."));
                dimensionGrid.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFeatureCope().getCopeLength(), false);
                dimensionGrid.add(group, 1, row);

                label = new Label("Cope Height");
                label.setTooltip(new Tooltip("The height of the cope measured along the cross section local V-direction from the root point to the centre of the cope radius."));
                dimensionGrid.add(label, 2, row);
                group = createAndBind(bracket.getBracketParameters().getFeatureCope().getCopeHeight(), false);
                dimensionGrid.add(group, 3, row++);
            }

            if ( bracket.getBracketParameters().getFlangeEdgeReinforcement() != null ) {
                titelLabel = new Label("Flange Edge Reinforcement");
                titelLabel.setTooltip(new Tooltip("Bracket flange edge reinforcement parameters."));
                titelLabel.getStyleClass().add(Styles.TITLE_4);
                dimensionGrid.add(titelLabel, 0, row++, 4, 1);
                GridPane.setHalignment(titelLabel, HPos.LEFT);
                GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));

                label = new Label("Flange Width");
                label.setTooltip(new Tooltip("The width of the bracket flange edge reinforcement."));
                dimensionGrid.add(label, 0, row);
                group = createAndBind(bracket.getBracketParameters().getFlangeEdgeReinforcement().getFlangeWidth(), false);
                dimensionGrid.add(group, 1, row++);

                label = new Label("Radius");
                label.setTooltip(new Tooltip("The bend radius of the transition zone between bracket web and bracket flange."));
                dimensionGrid.add(label, 2, row);
                group = createAndBind(bracket.getBracketParameters().getFlangeEdgeReinforcement().getRadius(), false);
                dimensionGrid.add(group, 3, row++);
            }


        }

        // Physical Properties
        if (bracket.getPhysicalProperties() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "Not Physical Properties found in Stiffener",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);
            dimensionGrid.add(warning, 0, row, 4, 1);
        } else {
            titelLabel = new Label("Physical Properties");
            titelLabel.getStyleClass().add(Styles.TITLE_4);
            dimensionGrid.add(titelLabel, 0, row++, 4, 1);
            GridPane.setHalignment(titelLabel, HPos.LEFT);
            GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


            label = new Label("Weight");
            label.setTooltip(new Tooltip("The bracket's weight"));
            dimensionGrid.add(label, 0, row);

            var group = createOrRebind(null, bracket.getPhysicalProperties().getDryWeight(), true);
            dimensionGrid.add(group, 1, row++);

            label = new Label("Center of Gravity");
            label.setTooltip(new Tooltip("The bracket's COG"));
            dimensionGrid.add(label, 0, row);

            group = createOrRebind(null, bracket.getPhysicalProperties().getCenterOfGravity(), true);
            dimensionGrid.add(group, 1, row++);

        }

        // Material
        titelLabel = new Label("Bracket Material");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        dimensionGrid.add(titelLabel, 0, row++, 4, 1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));


        if (bracket.getPlateMaterial() == null) {
            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No PlateMaterial found in Bracket/PlateMaterial !",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            var warningIcon = new FontIcon(MaterialDesignA.ALERT);
            warningIcon.getStyleClass().add(Styles.WARNING);

            dimensionGrid.add(warning, 0, ++row, 4, 1);

        } else {

            label = new Label("Thickness");
            label.setTooltip(new Tooltip("The plate's thickness"));
            dimensionGrid.add(label, 0, row);
            var group1 = createAndBind(bracket.getPlateMaterial().getThickness(), true);
            dimensionGrid.add(group1, 1, row);


            label = new Label("Offset");
            label.setTooltip(new Tooltip("The plate's offset"));
            dimensionGrid.add(label, 2, row);
            group1 = createAndBind(bracket.getOffset(), true);
            dimensionGrid.add(group1, 3, row++);


            label = new Label("Material Quality");
            label.setTooltip(new Tooltip("The plate's material"));
            dimensionGrid.add(label, 0, row);

            if (bracket.getPlateMaterial().getReferenced() != null) {
                var link = new Hyperlink("Material  «" + bracket.getPlateMaterial().getReferenced().getId() + "»");
                link.setTooltip(new Tooltip("Goto Material"));
                dimensionGrid.add(link, 1, row++);
                link.setOnAction(e -> {
                    var robert = new ArrayList<>(getBreadcrumbs());
                    robert.add(new BreadcrumbRecord(bracket.getPlateMaterial().getReferenced().getId(), MaterialPage.class, null, bracket.getPlateMaterial().getReferenced()));

                    var event = new SelectionEvent(robert);
                    DefaultEventBus.getInstance().publish(event);
                });
            } else if (bracket.getPlateMaterial().getLocalRef() instanceof String) {
                var naLabel = new Label("failed to resolve local ref " + bracket.getPlateMaterial().getLocalRef() + " to Material.");
                naLabel.getStyleClass().add(Styles.WARNING);
                dimensionGrid.add(naLabel, 1, row++);
            } else if (StringUtils.isNoneEmpty(bracket.getPlateMaterial().getGUIDRef())) {
                var naLabel = new Label("failed to resolve GUIDRef " + bracket.getPlateMaterial().getGUIDRef() + " to Material.");
                naLabel.getStyleClass().add(Styles.WARNING);
                dimensionGrid.add(naLabel, 1, row++);
            } else {
                var naLabel = new Label("failed to resolve MaterialRef, not localRef or GUIDRef found");
                naLabel.getStyleClass().add(Styles.WARNING);
                dimensionGrid.add(naLabel, 1, row++);
            }

        }

        // Custom Properties
        label = new Label("Custom Properties");
        label.getStyleClass().add(Styles.TITLE_4);
        dimensionGrid.add(label, 0, row++, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);

        var link = new Hyperlink("View Custom Properties");
        link.setTooltip(new Tooltip("Goto Custom Properties page"));
        dimensionGrid.add(link, 0, row++, 2, 1);
        link.setOnAction(e -> {
            var robert = new ArrayList<>(getBreadcrumbs());
            robert.add(new BreadcrumbRecord("Custom Properties", CustomPropertiesPage.class, null, getObject()));

            var event = new SelectionEvent(robert);
            DefaultEventBus.getInstance().publish(event);
        });

        return tab;
    }

    private Tab createSketchTab() {
        var tab = new Tab("Sketch");
        tab.setClosable(false);


        pane = new Pane();
        tab.setContent(pane);
        pane.getChildren().add( canvas);

        pane.getChildren().add(sketchBox);
        sketchBox.setAlignment(Pos.CENTER_LEFT);
        sketchBox.toFront();

        var label = new Label("");
        label.setGraphic(new FontIcon(MaterialDesignV.VIDEO_3D));
        sketchBox.getChildren().add(label);

        var posLabel = new Label("");
        sketchBox.getChildren().add(posLabel);

        if ( bracketContour != null && !bracketContour.isEmpty()) {
            var contour = new ToggleSwitch("  Draw Contour");
            sketchBox.getChildren().add(contour);
            contour.setSelected(false);

            contour.selectedProperty().addListener((observable, oldValue, newValue) -> {
                drawBracketContour = newValue;

                LOG.info("drawBracketContour {}", drawBracketContour);
                updateCanvas();
            });
        }




        canvas.setOnMouseMoved( event -> {
            var rawPos = new Point3d(event.getX(), event.getY(), 0);

            var pos2d = new Point3d(rawPos);
            var invViewHoco = new Matrix4d(viewHoco);
            invViewHoco.invert();
            invViewHoco.transform(pos2d);

            var pos3d = new Point3d(pos2d);
            var invGlobal2Local = bracketGeometry2D.global2localT();
            invGlobal2Local.invert();
            invGlobal2Local.transform(pos3d);

            posLabel.setText("( %.0f, %.0f, %.0f)".formatted( pos3d.x, pos3d.y,pos3d.z  ));

        });

        canvas.setWidth(200);
        canvas.setHeight(200);

        canvas.setCursor( Cursor.CROSSHAIR);

        return tab;
    }


}
