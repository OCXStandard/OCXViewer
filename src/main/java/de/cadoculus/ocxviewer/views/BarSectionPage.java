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

import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.models.SectionType;
import de.cadoculus.ocxviewer.models.UnitConverter;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.BarSection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * A page displaying information about a bar section.
 * The BarSectionPage is not intended to be navigated directly, but rather as a logical child to e.g. the catalogue or a flange/stiffener.
 *
 * @author Carsten Zerbst
 */
public class BarSectionPage extends AbstractDataViewSubPage<BarSection> {
    public static final String NAME = "BarSection";
    private static final Logger LOG = LogManager.getLogger(BarSectionPage.class);
    private static ImagePattern barPattern;

    private final GridPane gridPane;
    private final GridPane dimensionGrid = new GridPane();
    private final Canvas canvas = new Canvas();
    private final TabPane dimeAndSketchTab;
    private double hpC = Double.NaN;
    private double hpR = Double.NaN;

    private double canvasWidth;
    private double canvasHeight;

    private Color textColor = Color.BLACK;
    private Color dimensionLineColor = Color.BLACK;
    private Color cosysColor = Color.BLUE;
    private Color barColor = Color.BLACK;
    private final double barLineWidth = 2.0;
    private final double coosysLineWidth = 4.0;
    private final double dimensionLineWidth = 1.0;


    public BarSectionPage(BarSection barSection, Page parent) {
        super(barSection, parent, "BarSection \u00AB" + barSection.getId() + "\u00BB");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about a BarSection.");

        gridPane = createDefaultGrid();
        setCenter(gridPane);

        int row = 0;

        var titelLabel = new Label("Identification");
        titelLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(titelLabel, 0, row++,4,1);
        GridPane.setHalignment(titelLabel, HPos.LEFT);
        GridPane.setMargin(titelLabel, new Insets(20, 0, 10, 0));
        gridPane.getRowConstraints().add(new RowConstraints());

        // ocx:Name
        var label = new Label("Id");
        label.setTooltip(new Tooltip("The barSection's Id"));
        gridPane.add(label, 0, row);

        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), barSection, "id", String.class);

       // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The barSection's GUID"));
        gridPane.add(label, 2, row);
        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), barSection, "GUIDRef", String.class);
        gridPane.getRowConstraints().add(new RowConstraints());

        label = new Label("Description");
        label.setTooltip(new Tooltip("The barSection's description"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++,3,1);
        bindToBean(textField.textProperty(), barSection, "description", String.class);
        gridPane.getRowConstraints().add(new RowConstraints());

        // bar section drawing
        var barLabel = new Label(SectionType.getType(barSection).getName() );

        barLabel.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(barLabel, 0, row++,4,1);
        GridPane.setHalignment(barLabel, HPos.LEFT);
        GridPane.setMargin(barLabel, new Insets(20, 0, 10, 0));
        gridPane.getRowConstraints().add(new RowConstraints());


        var tabSketch = createSketchTab();
        var tabDimensions = createDimensionsTab();
        dimeAndSketchTab = new TabPane(tabSketch, tabDimensions);
        gridPane.add(dimeAndSketchTab, 0, row,4,3);
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        rc.setMinHeight(200);
        gridPane.getRowConstraints().add(rc);




        if (barPattern == null) {
            barPattern = createHatch();
        }

        updateCanvas();

        this.boundsInLocalProperty().addListener((bound, oldBound, newBound) -> updateCanvas());
        WorkingContext.getInstance().darkModeProperty().addListener(obs -> updateCanvas());

    }

    private Tab createDimensionsTab() {
        var tab = new Tab("Dimensions");

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

        tab.setContent(dimensionGrid);
        dimensionGrid.getColumnConstraints().addAll(col1, col2, col3, col4);

        BarSection barSection = this.getObject();
        var sectionType = SectionType.getType(barSection);

        switch (sectionType) {
            case BULB_FLAT -> createDimsBulbFlat();
            case FLAT_BAR -> createDimsFlatBar();
            case HALF_ROUND_BAR -> createDimsHalfRoundBar();
            case HEXAGON_BAR -> createDimsHexagonBar();
            case I_BAR -> createDimsIBar();
            case L_BAR, L_BAR_OF, L_BAR_OW -> createDimsLBar();
            case OCTAGON_BAR -> createDimsOctagonBar();
            case RECTANGULAR_TUBE -> createDimsRectangularTube();
            case ROUND_BAR -> createDimsRoundBar();
            case SQUARE_BAR -> createDimsSquareBar();
            case T_BAR -> createDimsTBar();
            case TUBE -> createDimsTube();
            case U_BAR -> createDimsUBar();
            case Z_BAR -> createDimsZBar();
            case USER_DEFINED_BAR_SECTION -> createDimsUserDefinedBar();
            default -> LOG.warn("unsupported bar section {}", SectionType.getType(barSection));
        }

        return tab;
    }

    private void createDimsUserDefinedBar() {
        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "Not implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        int row = 0;
        dimensionGrid.add(warning, 0, row++,4,1);

    }

    private void createDimsZBar() {
        var zBar = object.getZBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(zBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Width");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(zBar.getWidth(), true);
        dimensionGrid.add(group, 3, row++);


        label = new Label("Web Thickness");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(zBar.getWebThickness(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Flange Thickness");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(zBar.getFlangeThickness(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsUBar() {
        var uBar = object.getUBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(uBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Width");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(uBar.getWidth(), true);
        dimensionGrid.add(group, 3, row++);


        label = new Label("Web Thickness");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(uBar.getWebThickness(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Flange Thickness");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(uBar.getFlangeThickness(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsTube() {
        var tube = object.getTube();
        int row = 0;
        var label = new Label("Diameter");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(tube.getDiameter(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Thickness");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(tube.getThickness(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsTBar() {
        var tBar = object.getTBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(tBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Width");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(tBar.getWidth(), true);
        dimensionGrid.add(group, 3, row++);


        label = new Label("Web Thickness");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(tBar.getWebThickness(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Flange Thickness");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(tBar.getFlangeThickness(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsSquareBar() {
        var squareBar = object.getSquareBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(squareBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);
    }

    private void createDimsRoundBar() {
        var roundBar = object.getRoundBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(roundBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);
        
    }

    private void createDimsRectangularTube() {
        var rectangularTube = object.getRectangularTube();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(rectangularTube.getHeight(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Width");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(rectangularTube.getWidth(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsOctagonBar() {
        var octagonBar = object.getOctagonBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(octagonBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);

    }

    private void createDimsLBar() {
        var sectionType = SectionType.getType(object);
        int row = 0;
        if ( sectionType == SectionType.L_BAR ) {
            var lBar = object.getLBar();
            var label = new Label("Height");
            dimensionGrid.add(label, 0, row);
            var group = createAndBind(lBar.getHeight(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("Width");
            dimensionGrid.add(label, 2, row);
            group = createAndBind(lBar.getWidth(), true);
            dimensionGrid.add(group, 3, row++);

            label = new Label("Web Thickness");
            dimensionGrid.add(label, 0, row);
            group = createAndBind(lBar.getWebThickness(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("Flange Thickness");
            dimensionGrid.add(label, 2, row);
            group = createAndBind(lBar.getFlangeThickness(), true);
            dimensionGrid.add(group, 3, row++);


        } else if (sectionType==SectionType.L_BAR_OF) {

            var lBarOF = object.getLBarOF();
            var label = new Label("Height");
            dimensionGrid.add(label, 0, row);
            var group = createAndBind(lBarOF.getHeight(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("Width");
            dimensionGrid.add(label, 2, row);
            group = createAndBind(lBarOF.getWidth(), true);
            dimensionGrid.add(group, 3, row++);

            label = new Label("Web Thickness");
            dimensionGrid.add(label, 0, row);
            group = createAndBind(lBarOF.getWebThickness(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("Flange Thickness");
            dimensionGrid.add(label, 2, row);
            group = createAndBind(lBarOF.getFlangeThickness(), true);
            dimensionGrid.add(group, 3, row++);

            label = new Label("Overshoot");
            dimensionGrid.add(label, 0, row);
            group = createAndBind(lBarOF.getOvershoot(), true);
            dimensionGrid.add(group, 1, row++);

        } else if (sectionType==SectionType.L_BAR_OW) {

            var lBarOW = object.getLBarOW();
            var label = new Label("Height");
            dimensionGrid.add(label, 0, row);
            var group = createAndBind(lBarOW.getHeight(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("Width");
            dimensionGrid.add(label, 2, row);
            group = createAndBind(lBarOW.getWidth(), true);
            dimensionGrid.add(group, 3, row++);

            label = new Label("Web Thickness");
            dimensionGrid.add(label, 0, row);
            group = createAndBind(lBarOW.getWebThickness(), true);
            dimensionGrid.add(group, 1, row);

            label = new Label("Flange Thickness");
            dimensionGrid.add(label, 2, row);
            group = createAndBind(lBarOW.getFlangeThickness(), true);
            dimensionGrid.add(group, 3, row++);

            label = new Label("Overshoot");
            dimensionGrid.add(label, 0, row);
            group = createAndBind(lBarOW.getOvershoot(), true);
            dimensionGrid.add(group, 1, row++);

        }
    }

    private void createDimsIBar() {
        var iBar = object.getIBar();
        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(iBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Width");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(iBar.getWidth(), true);
        dimensionGrid.add(group, 3, row++);


        label = new Label("Web Thickness");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(iBar.getWebThickness(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Flange Thickness");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(iBar.getFlangeThickness(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsHexagonBar() {
        var hexagonBar = object.getHexagonBar();

        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(hexagonBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);
    }

    private void createDimsHalfRoundBar() {
        var roundBar = object.getHalfRoundBar();

        int row = 0;

        var label = new Label("Diameter");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(roundBar.getDiameter(), true);
        dimensionGrid.add(group, 1, row);
    }

    private void createDimsFlatBar() {
        var flatBar = object.getFlatBar();
        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(flatBar.getHeight(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Width");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(flatBar.getWidth(), true);
        dimensionGrid.add(group, 3, row++);
    }

    private void createDimsBulbFlat() {
        var bulbFlat = object.getBulbFlat();
        int row = 0;

        var label = new Label("Height");
        dimensionGrid.add(label, 0, row);
        var group = createAndBind(bulbFlat.getHeight(), true);
        dimensionGrid.add(group, 1, row++);


        label = new Label("Flange Width");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(bulbFlat.getFlangeWidth(), true);
        dimensionGrid.add(group, 1, row);

        label = new Label("Web Thickness");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(bulbFlat.getWebThickness(), true);
        dimensionGrid.add(group, 3, row++);


        label = new Label("Top Radius");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(bulbFlat.getBulbTopRadius(), false);
        dimensionGrid.add(group, 1, row);

        label = new Label("Bottom Radius");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(bulbFlat.getBulbBottomRadius(), false);
        dimensionGrid.add(group, 3, row++);


        label = new Label("Outer Radius");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(bulbFlat.getBulbOuterRadius(), false);
        dimensionGrid.add(group, 1, row);

        label = new Label("Inner Radius");
        dimensionGrid.add(label, 2, row);
        group = createAndBind(bulbFlat.getBulbInnerRadius(), false);
        dimensionGrid.add(group, 3, row++);

        label = new Label("Bulb Angle");
        dimensionGrid.add(label, 0, row);
        group = createAndBind(bulbFlat.getBulbAngle(), false);
        dimensionGrid.add(group, 1, row);

    }

    private Tab createSketchTab() {
        var tab = new Tab("Sketch");

        tab.setContent(canvas);
        canvas.setWidth(200);
        canvas.setHeight(200);

        return tab;
    }


    private void updateCanvas() {

        canvasHeight = dimeAndSketchTab.getHeight()-20;
        canvasWidth = dimeAndSketchTab.getWidth() - 21;

        canvas.setHeight(canvasHeight);
        canvas.setWidth(canvasWidth);

        LOG.info(" canvas {}\n{}", canvas.getBoundsInLocal(), canvas.getBoundsInParent());

        // todo: better way to get colour scheme
        textColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.WHITE : Color.BLACK;
        dimensionLineColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.WHITE : Color.BLACK;
        cosysColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.web("#bccadc") : Color.web("#537297");
        barColor = WorkingContext.getInstance().darkModeProperty().get() ? Color.web("#d29097") : Color.web("#86444a");


        LOG.info("repaint canvas {}, {}x{}", object, canvas.getWidth(), canvas.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


        BarSection barSection = this.getObject();
        var sectionType = SectionType.getType(barSection);

        //LOG.info("bar section {} {}", sectionType, barSection.getId());

        switch (sectionType) {
            case BULB_FLAT -> drawBulbFlat(gc);
            case FLAT_BAR -> drawFlatBar(gc);
            case HALF_ROUND_BAR -> drawHalfRoundBar(gc);
            case HEXAGON_BAR -> drawHexagonBar(gc);
            case I_BAR -> drawIBar(gc);
            case L_BAR, L_BAR_OF, L_BAR_OW -> drawLBars(gc);
            case OCTAGON_BAR -> drawOctagonBar(gc);
            case RECTANGULAR_TUBE -> drawRectangularTube(gc);
            case ROUND_BAR -> drawRoundBar(gc);
            case SQUARE_BAR -> drawSquareBar(gc);
            case T_BAR -> drawTBar(gc);
            case TUBE -> drawTube(gc);
            case U_BAR -> drawUBar(gc);
            case Z_BAR -> drawZBar(gc);
            case USER_DEFINED_BAR_SECTION -> drawUserDefinedBar(gc);
            default -> LOG.warn("unsupported bar section {}", SectionType.getType(barSection));
        }

    }

    private void drawUserDefinedBar(GraphicsContext gc) {

        var centerX = Math.round(canvasWidth/2.0)+0.5;
        var centerY = Math.round(canvasHeight/2.0)+0.5;

        gc.setFill(textColor);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("drawing user defined bars ist not implemented yet",centerX, centerY);


    }

    private void drawZBar(GraphicsContext gc) {
        var zBar = object.getZBar();
        var height = UnitConverter.toDefaultUnit(zBar.getHeight());
        var width = UnitConverter.toDefaultUnit(zBar.getWidth());
        var webThickness = UnitConverter.toDefaultUnit(zBar.getWebThickness());
        var flangeThickness = UnitConverter.toDefaultUnit(zBar.getFlangeThickness());
        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;

        var scale = Math.min(scaleX, scaleY);

        var w = width*scale;
        var ft = flangeThickness*scale;
        var wt = webThickness*scale;

        var offsetX = Math.round((canvasWidth - w) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y
        var centerX = Math.round(canvasWidth/2.0)+0.5;
        var centerY = Math.round(canvasHeight/2.0)+0.5;

        // paint the hexagon
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.moveTo(offsetX, 100);
        gc.lineTo(offsetX, 100+ft);
        gc.lineTo(centerX-0.5*wt, 100+ft);
        gc.lineTo(centerX-0.5*wt, offsetY);
        gc.lineTo(offsetX+w, offsetY);
        gc.lineTo(offsetX+w, offsetY-ft);
        gc.lineTo(centerX+0.5*wt, offsetY-ft);
        gc.lineTo(centerX+0.5*wt, 100);


        gc.closePath();
        gc.stroke();
        gc.fill();


        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine( offsetX-50, 100, offsetX, 100);
        gc.strokeLine(offsetX-50, offsetY, centerX-0.5*wt, offsetY);
        gc.strokeLine(offsetX-40, 100, offsetX-40, offsetY);

        drawArrowHead(gc, offsetX-40, 100,0,1);
        drawArrowHead(gc, offsetX-40, offsetY,0,-1);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("h=%.2f [mm]", height),offsetX-50, centerY);

        // width
        gc.strokeLine(offsetX, 100+ft, offsetX, offsetY+50);
        gc.strokeLine(offsetX+w, offsetY, offsetX+w, offsetY+50);
        gc.strokeLine(offsetX, offsetY+40, offsetX+w, offsetY+40);

        drawArrowHead(gc, offsetX, offsetY+40, 1, 0);
        drawArrowHead(gc, offsetX+w, offsetY+40, -1, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("w=%.2f [mm]", width),centerX, offsetY+35);

        // flange thickness
        gc.strokeLine(centerX+0.5*wt, 100.5,centerX+0.5*wt+50, 100.5);
        gc.strokeLine(centerX+0.5*wt, 100.5+ft,centerX+0.5*wt+50, 100.5+ft);
        gc.strokeLine(centerX+0.5*wt+40, 50,centerX+0.5*wt+40,100);
        gc.strokeLine(centerX+0.5*wt+40, 100+ft, centerX+0.5*wt+40, 100+ft+50);
        drawArrowHead(gc, centerX+0.5*wt+40, 100, 0,-1);
        drawArrowHead(gc, centerX+0.5*wt+40, 100+ft,0,1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("flange=%.2f [mm]",flangeThickness), centerX+0.5*wt+60, 100+0.5*ft);

        // web width
        gc.strokeLine(centerX-0.5*wt-50, offsetY-2*ft, centerX-0.5*wt, offsetY-2*ft);
        gc.strokeLine(centerX+0.5*wt, offsetY-2*ft, centerX+0.5*wt+50, offsetY-2*ft);

        drawArrowHead(gc, centerX-0.5*wt, offsetY-2*ft, -1,0);
        drawArrowHead(gc, centerX+0.5*wt, offsetY-2*ft, 1,0);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("w=%.2f [mm]",webThickness), centerX+0.5*wt+60, offsetY-2*ft);


        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);


    }

    private void drawUBar(GraphicsContext gc) {
        var uBar = object.getUBar();

        var height = UnitConverter.toDefaultUnit(uBar.getHeight());
        var width = UnitConverter.toDefaultUnit(uBar.getWidth());
        var webThickness = UnitConverter.toDefaultUnit(uBar.getWebThickness());
        var flangeThickness = UnitConverter.toDefaultUnit(uBar.getFlangeThickness());

        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;
        var scale = Math.min(scaleX, scaleY);

        var w = width*scale;
        var ft = flangeThickness*scale;
        var wt = webThickness*scale;

        var offsetX = Math.round((canvasWidth - w) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y

        var centerY = Math.round(canvasHeight/2.0)+0.5;

        // paint the hexagon
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.moveTo(offsetX+w, 100);
        gc.lineTo(offsetX, 100);
        gc.lineTo(offsetX, offsetY);
        gc.lineTo(offsetX+w, offsetY);
        gc.lineTo(offsetX+w, offsetY-ft);
        gc.lineTo(offsetX+wt, offsetY-ft);
        gc.lineTo(offsetX+wt, 100+ft);
        gc.lineTo(offsetX+w, 100+ft);

        gc.closePath();
        gc.stroke();
        gc.fill();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX-80, 100, offsetX, 100);
        gc.strokeLine(offsetX-80, offsetY, offsetX, offsetY);
        gc.strokeLine(offsetX-70, 100, offsetX-70, offsetY);

        drawArrowHead(gc, offsetX-70, 100, 0,1);
        drawArrowHead(gc, offsetX-70, offsetY, 0,-1);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("height=%.2f [mm]", height),offsetX-80,centerY);

        // width
        gc.strokeLine(offsetX, offsetY, offsetX, offsetY+50);
        gc.strokeLine(offsetX+w, offsetY, offsetX+w, offsetY+50);
        gc.strokeLine(offsetX, offsetY+40, offsetX+w, offsetY+40);

        drawArrowHead(gc, offsetX, offsetY+40, 1, 0);
        drawArrowHead(gc, offsetX+w, offsetY+40, -1, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("w=%.2f [mm]", width),offsetX+0.5*w, offsetY+35);

        // flange thickness
        gc.strokeLine(offsetX+w, 100.5, offsetX+w+50, 100.5);
        gc.strokeLine(offsetX+w, 100.5+ft, offsetX+w+50, 100.5+ft);
        gc.strokeLine(offsetX+w+40, 50,offsetX+w+40,100);
        gc.strokeLine(offsetX+w+40, 100+ft, offsetX+w+40, 100+ft+50);
        drawArrowHead(gc, offsetX+w+40, 100, 0,-1);
        drawArrowHead(gc, offsetX+w+40, 100+ft,0,1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("flange=%.2f [mm]",flangeThickness), offsetX+w+60, 80);

        // web thickness
        gc.strokeLine(offsetX-50, centerY+30, offsetX, centerY+30);
        gc.strokeLine(offsetX+wt, centerY+30, offsetX+wt+50, centerY+30);
        drawArrowHead(gc, offsetX, centerY+30, -1,0);
        drawArrowHead(gc, offsetX+wt, centerY+30, 1,0);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("web=%.2f [mm]",webThickness), offsetX+wt+60, centerY+30);


        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);


    }

    private void drawTBar(GraphicsContext gc) {
        var tBar = object.getTBar();

        var height = UnitConverter.toDefaultUnit(tBar.getHeight());
        var width = UnitConverter.toDefaultUnit(tBar.getWidth());
        var webThickness = UnitConverter.toDefaultUnit(tBar.getWebThickness());
        var flangeThickness = UnitConverter.toDefaultUnit(tBar.getFlangeThickness());

        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;
        var scale = Math.min(scaleX, scaleY);

        var w = width*scale;
        var f = flangeThickness*scale;
        var wt = webThickness*scale;

        var offsetX = Math.round((canvasWidth - w) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y
        var centerX = Math.round(canvasWidth/2.0)+0.5;
        var centerY = Math.round(height/2.0)+0.5;

        // paint the T bar
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.moveTo(offsetX, 100);
        gc.lineTo(offsetX, 100+f);
        gc.lineTo(centerX-0.5*wt, 100+f);
        gc.lineTo(centerX-0.5*wt, offsetY);
        gc.lineTo(centerX+0.5*wt, offsetY);
        gc.lineTo(centerX+0.5*wt, 100+f);
        gc.lineTo(offsetX+w, 100+f);
        gc.lineTo(offsetX+w, 100);

        gc.closePath();
        gc.stroke();
        gc.fill();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX-50, 100, offsetX, 100);
        gc.strokeLine(offsetX-50, offsetY, centerX-0.5*wt, offsetY);
        gc.strokeLine(offsetX-40, 100, offsetX-40, offsetY);

        drawArrowHead(gc, offsetX-40, 100, 0,1);
        drawArrowHead(gc, offsetX-40, offsetY, 0,-1);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("h=%.2f [mm]", height),offsetX-60,centerY);

        // width
        gc.strokeLine(offsetX, 50, offsetX, 100);
        gc.strokeLine(offsetX+w, 50, offsetX+w, 100);
        gc.strokeLine(offsetX, 60, offsetX+w, 60);

        drawArrowHead(gc, offsetX, 60, -1, 0);
        drawArrowHead(gc, offsetX+w, 60, 1, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("web=%.2f [mm]", width),centerX, 40);

        // flange thickness
        gc.strokeLine(offsetX+w, 100,offsetX+w+50,100);
        gc.strokeLine(offsetX+w, 100+f,offsetX+w+50,100+f);
        gc.strokeLine(offsetX+w+40, 50,offsetX+w+40,100);
        gc.strokeLine(offsetX+w+40, 100+f,offsetX+w+40,100+f+50);
        drawArrowHead(gc, offsetX+w+40, 100, 0,-1);
        drawArrowHead(gc, offsetX+w+40, 100+f,0,1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("flange=%.2f [mm]",flangeThickness), offsetX+w+66, 100+f+40);

        // web thickness
        gc.strokeLine(centerX-0.5*wt-50, offsetY-100, centerX-0.5*wt, offsetY-100);
        gc.strokeLine(centerX+0.5*wt, offsetY-100, centerX+0.5*wt+50, offsetY-100);

        drawArrowHead(gc, centerX-0.5*wt, offsetY-100, -1,0);
        drawArrowHead(gc, centerX+0.5*wt, offsetY-100, 1,0);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("web=%.2f [mm]",webThickness), centerX+0.5*wt+60, offsetY-100);

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private void drawSquareBar(GraphicsContext gc) {
        var squareBar = object.getSquareBar();
        var height = UnitConverter.toDefaultUnit(squareBar.getHeight());
        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / height;

        var scale = Math.min(scaleX, scaleY);
        var h = height*scale;

        var centerX = Math.round(canvasWidth/2.0); // offset X
        var centerY = Math.round(canvasHeight/2.0); // offset Y
        var offsetX = Math.round(centerX-0.5*h);
        var offsetY = Math.round(centerY+0.5*h);

        // paint the hexagon
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);

        gc.fillRect(offsetX, 100.5, h, h);
        gc.strokeRect(offsetX, 100.5, h,h);


        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX, 100.5, offsetX-50, 100.5);
        gc.strokeLine(offsetX, offsetY, offsetX-50, offsetY);
        gc.strokeLine(offsetX-40, 100.5, offsetX-40, offsetY);

        drawArrowHead(gc, offsetX-40, 100,0,1);
        drawArrowHead(gc, offsetX-40, offsetY,0,-1);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("height=%.2f [mm]", height),offsetX-60, centerY);


        // and the center
        gc.save();
        gc.setLineWidth(1);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*h, centerY, centerX+0.25*h, centerY);
        gc.strokeLine(centerX, centerY-0.25*h, centerX, centerY+0.25*h);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private void drawRoundBar(GraphicsContext gc) {
        var roundBar = object.getRoundBar();
        var height = UnitConverter.toDefaultUnit(roundBar.getHeight());
        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / height;

        var scale = Math.min(scaleX, scaleY);

        var h = height*scale;
        var r = 0.5* height*scale; // radius

        var centerX = Math.round(canvasWidth/2.0); // offset X
        var centerY = Math.round(canvasHeight/2.0); // offset Y
        var offsetX = Math.round(centerX-r);
        var offsetY = Math.round(centerY+r);

        // paint the hexagon
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.arc(centerX, centerY, r, r,0,360);

        gc.closePath();
        gc.stroke();
        gc.fill();

        // height
        gc.setLineWidth(dimensionLineWidth);
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);

        gc.strokeLine(centerX,  offsetY-h, centerX+r+50, offsetY-h);
        gc.strokeLine(centerX, offsetY, centerX+r+50, offsetY);
        gc.strokeLine(centerX+r+40, offsetY-h, centerX+r+40, offsetY);

        drawArrowHead(gc, centerX+r+40, offsetY-h,0,1);
        drawArrowHead(gc, centerX+r+40, offsetY,0,-1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h=%.2f [mm]", height),centerX+r+50, centerY);

        // and the center
        gc.save();
        gc.setLineWidth(1);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.5*r, centerY, centerX+0.5*r, centerY);
        gc.strokeLine(centerX, centerY-0.5*r, centerX, centerY+0.5*r);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private void drawOctagonBar(GraphicsContext gc) {
        var octagonBar = object.getOctagonBar();
        var height = UnitConverter.toDefaultUnit(octagonBar.getHeight());
        var width = height/COS_30;
        var scaleY = (canvasHeight - 200) / (height);
        var scaleX = (canvasWidth - 200) / width;

        var scale = Math.min(scaleX, scaleY);
        var h = height*scale;
        var w = h/COS_60;
        var r = h/(2*COS_225); // radius

        LOG.info("octagon bar h {} r {} ", h, r);

        var centerX = Math.round(canvasWidth/2.0); // offset X
        var centerY = Math.round(canvasHeight/2.0); // offset Y
        var offsetX = Math.round(centerX-0.5*h);
        var offsetY = Math.round(centerY+0.5*h);

        // paint the octagon
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        var angles = new double[]{22.5, 90-22.5, 90+22.5, 180-22.5, 180+22.5, 270-22.5, 270+22.5, 360-22.5};

        for( int i = 0; i < angles.length; i++ ) {
            var angle = angles[i];
            var x = centerX + r * Math.cos(Math.toRadians(angle));
            var y = centerY + r * Math.sin(Math.toRadians(angle));
            if ( i == 0 ) {
                gc.moveTo(Math.round(x) + 0.5, Math.round(y) + 0.5);
            } else {
                gc.lineTo(Math.round(x) + 0.5, Math.round(y) + 0.5);
            }
        }

        gc.closePath();
        gc.stroke();
        gc.fill();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX+r*SIN_225, offsetY-h, offsetX+h+50, offsetY-h);
        gc.strokeLine(centerX+r*SIN_225, offsetY, offsetX+h+50, offsetY);
        gc.strokeLine(offsetX+h+40, offsetY-h, offsetX+h+40, offsetY);

        drawArrowHead(gc, offsetX+h+40, offsetY-h,0,1);
        drawArrowHead(gc, offsetX+h+40, offsetY,0,-1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h=%.2f [mm]", height),offsetX+w+60, centerY);

        // and the center
        gc.save();
        gc.setLineWidth(1);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.5*r, centerY, centerX+0.5*r, centerY);
        gc.strokeLine(centerX, centerY-0.5*r, centerX, centerY+0.5*r);
        gc.restore();


        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);
    }

    private void drawIBar(GraphicsContext gc) {
        var iBar = object.getIBar();

        var height = UnitConverter.toDefaultUnit(iBar.getHeight());
        var width = UnitConverter.toDefaultUnit(iBar.getWidth());
        var webThickness = UnitConverter.toDefaultUnit(iBar.getWebThickness());
        var flangeThickness = UnitConverter.toDefaultUnit(iBar.getFlangeThickness());

        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;
        var scale = Math.min(scaleX, scaleY);

        var w = width*scale;
        var ft = flangeThickness*scale;
        var wt = webThickness*scale;

        var offsetX = Math.round((canvasWidth - w) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y
        var centerX = Math.round(canvasWidth/2.0)+0.5;
        var centerY = Math.round(canvasHeight/2.0)+0.5;


        // paint the I-bar
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.moveTo(offsetX, 100);
        gc.lineTo(offsetX, 100+ft);
        gc.lineTo(centerX-0.5*wt, 100+ft);
        gc.lineTo(centerX-0.5*wt, offsetY-ft);
        gc.lineTo(offsetX, offsetY-ft);
        gc.lineTo(offsetX, offsetY);
        gc.lineTo(offsetX+w, offsetY);
        gc.lineTo(offsetX+w, offsetY-ft);
        gc.lineTo(centerX+0.5*wt, offsetY-ft);
        gc.lineTo(centerX+0.5*wt, 100+ft);
        gc.lineTo(offsetX+w, 100+ft);
        gc.lineTo(offsetX+w, 100);

        gc.closePath();
        gc.stroke();
        gc.fill();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX-50, 100, offsetX, 100);
        gc.strokeLine(offsetX-50, offsetY, offsetX, offsetY);
        gc.strokeLine(offsetX-40, 100, offsetX-40, offsetY);

        drawArrowHead(gc, offsetX-40, 100, 0,1);
        drawArrowHead(gc, offsetX-40, offsetY, 0,-1);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("h=%.2f [mm]", height),offsetX-60,centerY);

        // width
        gc.strokeLine(offsetX, 50, offsetX, 100);
        gc.strokeLine(offsetX+w, 50, offsetX+w, 100);
        gc.strokeLine(offsetX, 60, offsetX+w, 60);

        drawArrowHead(gc, offsetX, 60, -1, 0);
        drawArrowHead(gc, offsetX+w, 60, 1, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("web=%.2f [mm]", width),centerX, 40);

        // flange thickness
        gc.strokeLine(offsetX+w, 100,offsetX+w+50,100);
        gc.strokeLine(offsetX+w, 100+ft,offsetX+w+50,100+ft);
        gc.strokeLine(offsetX+w+40, 50,offsetX+w+40,100);
        gc.strokeLine(offsetX+w+40, 100+ft,offsetX+w+40,100+ft+50);
        drawArrowHead(gc, offsetX+w+40, 100, 0,-1);
        drawArrowHead(gc, offsetX+w+40, 100+ft,0,1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("flange=%.2f [mm]",flangeThickness), offsetX+w+66, 100+ft+40);

        // web thickness
        gc.strokeLine(centerX-0.5*wt-50, offsetY-100, centerX+0.5*wt, offsetY-100);
        gc.strokeLine(centerX+0.5*wt, offsetY-100, centerX+0.5*wt+50, offsetY-100);

        drawArrowHead(gc, centerX-0.5*wt, offsetY-100, -1,0);
        drawArrowHead(gc, centerX+0.5*wt, offsetY-100, 1,0);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("width=%.2f [mm]",webThickness), centerX+0.5*wt+60, offsetY-100);


        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);
    }

    private void drawHexagonBar(GraphicsContext gc) {

        var hexagonBar = object.getHexagonBar();
        var height = UnitConverter.toDefaultUnit(hexagonBar.getHeight());
        var radius = height/ (2*COS_30);
        var width = 2*radius;

        var scaleY = (canvasHeight - 200) / height;
        var scaleX = (canvasWidth - 200) / width;

        var scale = Math.min(scaleX, scaleY);
        var h = height*scale;
        var r = radius*scale;

        var centerX = Math.round(canvasWidth/2.)+ 0.5;
        var centerY = Math.round(canvasHeight/2.0)+0.5;

        var offsetX = Math.round(centerX- r)+0.5; // offset X
        var offsetY = Math.round(centerY+0.5*h ); // offset Y


        // paint the hexagon
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        var angles = new double[]{0,60,120,180,240,300,360};

        for( int i = 0; i < angles.length; i++ ) {
            var angle = angles[i];
            var x = centerX + r * Math.cos(Math.toRadians(angle));
            var y = centerY + r * Math.sin(Math.toRadians(angle));
            if ( i == 0 ) {
                gc.moveTo(Math.round(x) + 0.5, Math.round(y) + 0.5);
            } else {
                gc.lineTo(Math.round(x) + 0.5, Math.round(y) + 0.5);
            }
        }

        gc.closePath();
        gc.stroke();
        gc.fill();

        // height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(centerX+0.5*r, offsetY-h, centerX+r+30, offsetY-h);
        gc.strokeLine(centerX+0.5*r, offsetY, centerX+r+30, offsetY);
        gc.strokeLine(centerX+r+20, offsetY-h, centerX+r+20, offsetY);

        drawArrowHead(gc, centerX+r+20, offsetY-h,0,1);
        drawArrowHead(gc, centerX+r+20, offsetY,0,-1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("h=%.2f [mm]", height),centerX+r+40, centerY);

        // and the center
        gc.save();
        gc.setLineWidth(1);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.5*r, centerY, centerX+0.5*r, centerY);
        gc.strokeLine(centerX, centerY-0.5*r, centerX, centerY+0.5*r);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private void drawHalfRoundBar(GraphicsContext gc) {
        var halfRoundBar = object.getHalfRoundBar();
        var diameter = UnitConverter.toDefaultUnit(halfRoundBar.getDiameter());
        var scaleY = (canvasHeight - 200) / (diameter/2.0);
        var scaleX = (canvasWidth - 200) / diameter;

        var scale = Math.min(scaleX, scaleY);

        var r = Math.round(diameter * scale*0.5) + 0.5;

        var centerX = Math.round(canvasWidth/2.0)+0.5;

        var offsetX = Math.round((canvasWidth - 2*r) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y

        // paint the halfround
        gc.setStroke(barColor);
        gc.setFill(barPattern);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.moveTo(offsetX, offsetY);
        gc.lineTo(Math.round(offsetX +2*r) + 0.5, offsetY );
        gc.arc(centerX, offsetY, r, r, 0, 180);
        gc.closePath();
        gc.stroke();
        gc.fill();


        // radius
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        var rX = Math.round(offsetX + r + COS_45*r) + 0.5;
        var rY = Math.round(offsetY - SIN_45*r) + 0.5;

        gc.strokeLine(rX, rY, rX+COS_45*50, rY-SIN_45*50);
        drawArrowHead(gc, rX, rY, COS_45, -SIN_45);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("r=%.2f [mm]", 0.5*diameter), centerX+COS_45*(r+60),offsetY-SIN_45*(r+60));


        // and the center
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.5*r, offsetY, centerX+0.5*r, offsetY);
        gc.strokeLine(centerX, offsetY-0.5*r, centerX, offsetY+5);

        gc.setLineDashes();


        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);


    }

    private void drawBulbFlat(GraphicsContext gc) {
        var bulbFlat = object.getBulbFlat();
        var profileHeight = UnitConverter.toDefaultUnit(bulbFlat.getHeight());
        var webThickness = UnitConverter.toDefaultUnit(bulbFlat.getWebThickness());
        var flangeWidth = bulbFlat.getFlangeWidth() != null ?
                UnitConverter.toDefaultUnit(bulbFlat.getFlangeWidth()) : webThickness * 3;
        var radius = bulbFlat.getBulbOuterRadius() != null ?
                UnitConverter.toDefaultUnit(bulbFlat.getBulbOuterRadius()) : webThickness;
        LOG.info("selected HP {}x{}, width {}, radius {}", profileHeight, webThickness, flangeWidth, radius);


        if (Double.isNaN(hpC) || Double.isNaN(hpR)) {

            try (var reader = new BufferedReader(new InputStreamReader(this.getClass().getResource("bulbbars.csv").openStream()))) {

                final NumberFormat format = NumberFormat.getInstance(Locale.UK);
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("#")) {
                        continue;
                    }
                    final String[] split = line.split(";");
                    try {
                        var h = format.parse(split[0]).doubleValue();
                        var w = format.parse(split[1]).doubleValue();
                        var c = format.parse(split[2]).doubleValue();
                        var r = format.parse(split[3]).doubleValue();

                        if (h <= profileHeight && w <= flangeWidth) {
                            hpC = c;
                            hpR = r;
                        }
                    } catch (ParseException exp) {

                    }
                }
                LOG.debug("found hpC {} hpR {}", hpC, hpR);
                flangeWidth = hpC + hpR;
                radius = hpR;

            } catch (Exception e) {
                LOG.error("failed to read bulbbar.csv", e);
            }

        } else {
            flangeWidth = hpC + hpR;
            radius = hpR;
        }

        LOG.info("height {}, bulb width {}, bulb radius {}, flange thickness {}",
                profileHeight, flangeWidth, radius, flangeWidth);

        LOG.info("canvas height {}, canvas width {}", canvasHeight, canvasWidth);

        var scaleY = (canvasHeight - 200) / profileHeight;
        var scaleX = (canvasWidth - 200) / flangeWidth;

        var scale = Math.min(scaleX, scaleY);

        var t = webThickness * scale; // flange width
        var r = radius * scale; // radius
        var h = profileHeight * scale; // profile height
        var b = flangeWidth * scale; // profile width
        var sX = b - t - 2 * COS_60 * r; // X part of 30° line
        var sY = sX / COS_30 * SIN_30; // Y part of 30° line
        var kY = r * (1 + 2 * SIN_60) + sY; // total height of the head starting with fillet curve

        LOG.info("height {}, bulb with {}, bulb radius {}, flange thickness {}",
                h, b, r, t);


        var offsetX = Math.round((canvasWidth) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y


        // paint the HP
        gc.setFill(barPattern);
        gc.setStroke(barColor);
        gc.setLineWidth(barLineWidth);

        gc.beginPath();

        gc.arc(Math.round(b - r + offsetX) + 0.5, Math.round(r + 100) + 0.5, // center of circle x,y
                r, r, // radius
                -60, 150);
        gc.lineTo(offsetX + 0.5, 100.5); // left top
        gc.lineTo(offsetX + 0.5, offsetY + 0.5); // left bottom
        gc.lineTo(Math.round(offsetX + t) + 0.5, offsetY + 0.5); // bottom
        gc.lineTo(Math.round(offsetX + t) + 0.5, Math.round(100 + kY) + 0.5);
        gc.arc(Math.round(offsetX + t + r) + 0.5, Math.round(100 + kY + r) + 0.5, // center of circle
                r, r, // radius
                180, -60);
        gc.closePath();
        gc.stroke();
        gc.fill();

        // example path with hole
//            gc.beginPath();
//            gc.moveTo(100,100);
//            gc.lineTo(200,100);
//            gc.lineTo(200,200);
//            gc.lineTo(100,200);
//            gc.lineTo(100,100);
//
//            gc.moveTo(140,140);
//            gc.lineTo(140,160);
//            gc.lineTo(160,160);
//            gc.lineTo(160,140);
//            gc.lineTo(140,140);
//            gc.closePath();
//            gc.stroke();
//            gc.fill();



        // Height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX - 100, 100, offsetX - 100, offsetY);
        gc.strokeLine(offsetX - 105, 100, offsetX, 100);
        gc.strokeLine(offsetX - 105, offsetY, offsetX, offsetY);

        drawArrowHead(gc, offsetX - 100, 100, 0, 1);
        drawArrowHead(gc, offsetX - 100, offsetY, 0, -1);

        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("Height %.2f [mm]", profileHeight), offsetX - 150, canvasHeight / 2.0);

        // web thickness
        var p3Y = offsetY + 50;

        var p4X = Math.round(offsetX + t) + 0.5;
        var p5Y = offsetY + 50;

        gc.strokeLine(offsetX, offsetY, offsetX, p3Y);
        gc.strokeLine(p4X, offsetY, p4X, p5Y);
        gc.strokeLine(offsetX - 25, p3Y - 10, p4X + 100, p5Y - 10);

        drawArrowHead(gc, offsetX, p3Y - 10, -1, 0);
        drawArrowHead(gc, p4X, p5Y - 10, 1, 0);

        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("Web Thickness %.2f [mm]", webThickness), p4X + 20, p5Y - 20);


        // bulb width
        var p6Y = 50;
        var p7Y = 100;

        var p8X = offsetX + b;
        var p8Y = 50;
        var p9X = offsetX + b;
        var p9Y = 100 + r;

        gc.strokeLine(offsetX, p6Y, offsetX, p7Y);
        gc.strokeLine(p8X, p8Y, p9X, p9Y);
        gc.strokeLine(offsetX, p6Y + 10, p8X, p8Y + 10);

        drawArrowHead(gc, offsetX, p6Y + 10, -1, 0);
        drawArrowHead(gc, p8X, p8Y + 10, 1, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("Width %.2f [mm]", flangeWidth), offsetX + 0.5 * b, p6Y - 15);

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);
    }

    private void drawTube(GraphicsContext gc) {
        var tube = object.getTube();

        var diameter = UnitConverter.toDefaultUnit(tube.getDiameter());
        var thickness = UnitConverter.toDefaultUnit(tube.getThickness());

        var scaleY = (canvasHeight - 200) / diameter;
        var scaleX = (canvasWidth - 200) / diameter;

        var scale = Math.min(scaleX, scaleY);
        var cdia = Math.round(diameter * scale) + 0.5;
        var r = Math.round(diameter* scale*0.5);
        var ct = Math.round(thickness * scale);

        // paint the coordinate system of the tube
        var centerX = Math.round(canvasWidth / 2.0) + 0.5;
        var centerY = Math.round(canvasHeight /2.0) + 0.5;
        var offsetX = centerX-r;
        var offsetY = centerY+r;

        // paint the tube
        gc.setFill(barPattern);
        gc.setStroke(barColor);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        //gc.moveTo(centerX, Math.round( canvasHeight/2.0)+0.5);
        gc.arc(centerX, centerY, r, r,0,360);
        gc.arc(centerX, centerY, r-ct, r-ct,0, -360);
        gc.closePath();
        gc.stroke();
        gc.fill();

        // diameter
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);
        gc.strokeLine(centerX, centerY-r, centerX+r+50, centerY-r);
        gc.strokeLine(centerX, offsetY, centerX+r+50, offsetY);
        gc.strokeLine(centerX+r+40, centerY-r, centerX+r+40, offsetY);

        drawArrowHead(gc, centerX+r+40, centerY-r, 0, 1);
        drawArrowHead(gc, centerX+r+40, offsetY, 0, -1);

        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("⌀ %.2f [mm]", diameter), centerX+r+50, centerY);

        // thickness
        gc.strokeLine(offsetX-50, centerY, offsetX, centerY);
        gc.strokeLine(offsetX+ct, centerY, offsetX+ct+50, centerY);
        drawArrowHead(gc, offsetX, centerY, -1, 0);
        drawArrowHead(gc, offsetX+ct, centerY, 1, 0);

        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("t=%.2f [mm]", thickness), offsetX-60, centerY);


        // and the center
        gc.save();
        gc.setLineWidth(dimensionLineWidth);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.25*cdia, centerY, centerX+0.25*cdia, centerY);
        gc.strokeLine(centerX, centerY-0.25*cdia, centerX, centerY+0.25*cdia);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private void drawFlatBar(GraphicsContext gc) {
        var flatBar = object.getFlatBar();

        var flangeWidth = UnitConverter.toDefaultUnit(flatBar.getWidth());
        var profileHeight = UnitConverter.toDefaultUnit(flatBar.getHeight());

        var scaleY = (canvasHeight - 200) / profileHeight;
        var scaleX = (canvasWidth - 200) / flangeWidth;

        var scale = Math.min(scaleX, scaleY);

        var coordX = Math.round(canvas.getWidth() / 2.0) + 0.5;
        var coordY = 100.5;
        var rheight = Math.round(profileHeight * scale) + 0.5;
        var rwidth = Math.round(flangeWidth * scale) + 0.5;

        gc.setFill(barPattern);
        gc.setStroke(barColor);
        gc.setLineWidth(barLineWidth);

        gc.fillRect(coordX, coordY, rwidth, rheight);
        gc.strokeRect(coordX, coordY, rwidth, rheight);

        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        // Height
        var p0X = Math.round(-100 + canvasWidth / 2.0) + 0.5;
        var p0Y = 100.5;
        var p1Y = p0Y + rheight;
        gc.strokeLine(p0X, p0Y, Math.round(canvasWidth / 2.0), p0Y);
        gc.strokeLine(p0X, p1Y, Math.round(canvasWidth / 2.0), p1Y);
        gc.strokeLine(p0X + 10, p0Y, p0X + 10, p1Y);

        drawArrowHead(gc, p0X + 10, p0Y, 0, 1);
        drawArrowHead(gc, p0X + 10, p1Y, 0, -1);

        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("Height %.2f [mm]", profileHeight), p0X, (p0Y + p1Y) / 2.0);

        // width
        var p2X = Math.round(canvas.getWidth() / 2.0) + 0.5;
        var p3Y = p1Y + 50;

        var p4X = Math.round(canvasWidth / 2.0 + rwidth) + 0.5;
        var p5Y = p1Y + 50;

        gc.strokeLine(p2X, p1Y, p2X, p3Y);
        gc.strokeLine(p4X, p1Y, p4X, p5Y);
        gc.strokeLine(p2X - 25, p3Y - 10, p4X + 100, p5Y - 10);

        drawArrowHead(gc, p2X, p3Y - 10, -1, 0);
        drawArrowHead(gc, p4X, p5Y - 10, 1, 0);


        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("Width %.2f [mm]", flangeWidth), p4X + 20, p5Y - 20);


        // paint the coordinate system of the tube
        drawCossys(gc, coordX, coordY+rheight);


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

    private void drawRectangularTube(GraphicsContext gc) {

        var tube = object.getRectangularTube();
        double profileHeight = UnitConverter.toDefaultUnit(tube.getHeight());
        double profileWidth = UnitConverter.toDefaultUnit(tube.getWidth());
        double thickness = UnitConverter.toDefaultUnit(tube.getThickness());

        var scaleX = (canvasWidth - 300) / profileWidth * 0.75;
        var scaleY = (canvasHeight - 200) / profileHeight * 0.75;

        var scale = Math.min(scaleX, scaleY);

        LOG.info("tube {}x{}", profileWidth, profileHeight);
        LOG.info("canvas {}x{}", canvasWidth, canvasHeight);
        LOG.info("scale {}, x  {}, y {}", scale, scaleX, scaleY);

        var h = profileHeight * scale; // web height
        var w = profileWidth * scale; // web thickness
        var t = thickness * scale; // thickness
        var innerRadius = t;
        var outerRadius = 2 * t;

        var offsetX = Math.round((canvasWidth - w) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y
        var centerX = Math.round(canvasWidth/2.)+ 0.5;
        var centerY = Math.round(canvasHeight/2.0)+0.5;

        gc.setFill(barPattern);
        gc.setStroke(barColor);
        gc.setLineWidth(barLineWidth);
        gc.beginPath();

        gc.moveTo(Math.round(offsetX + outerRadius), 100);
        gc.arcTo(offsetX, 100, offsetX, 100 + outerRadius, outerRadius);
        gc.lineTo(offsetX, offsetY - outerRadius);
        gc.arcTo(offsetX, offsetY, offsetX + outerRadius, offsetY, outerRadius);
        gc.lineTo(offsetX + w - outerRadius, offsetY);
        gc.arcTo(offsetX + w, offsetY, offsetX + w, offsetY - outerRadius, outerRadius);
        gc.lineTo(offsetX + w, 100 + outerRadius);
        gc.arcTo(offsetX + w, 100, offsetX + w - outerRadius, 100, outerRadius);
        gc.lineTo(offsetX + outerRadius, 100);

        gc.moveTo(Math.round(offsetX + t + innerRadius), 100 + t);
        gc.lineTo(offsetX + w - t - innerRadius, 100 + t);
        gc.arcTo(offsetX + w - t, 100 + t, offsetX + w - t, 100 + t + innerRadius, innerRadius);
        gc.lineTo(offsetX + w - t, offsetY - t - innerRadius);
        gc.arcTo(offsetX + w - t, offsetY - t, offsetX + w - t - innerRadius, offsetY - t, innerRadius);
        gc.lineTo(offsetX + t + innerRadius, offsetY - t);
        gc.arcTo(offsetX + t, offsetY - t, offsetX + t, offsetY - t - innerRadius, innerRadius);
        gc.lineTo(offsetX + t, 100 + t + innerRadius);
        gc.arcTo(offsetX + t, 100 + t, offsetX + t + innerRadius, 100 + t, innerRadius);


        gc.closePath();
        gc.stroke();
        gc.fill();

        // Height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX - 50, 100, offsetX + outerRadius, 100);
        gc.strokeLine(offsetX - 50, offsetY, offsetX + outerRadius, offsetY);
        gc.strokeLine(offsetX - 40, 100, offsetX - 40, offsetY);

        drawArrowHead(gc, offsetX - 40, 100, 0, 1);
        drawArrowHead(gc, offsetX - 40, offsetY, 0, -1);

        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("Height %.2f [mm]", profileHeight), offsetX - 60, canvasHeight / 2.0);

        // width
        gc.strokeLine(offsetX, 50, offsetX, 100 + outerRadius);
        gc.strokeLine(offsetX + w, 50, offsetX + w, 100 + outerRadius);
        gc.strokeLine(offsetX, 60, offsetX + w, 60);

        drawArrowHead(gc, offsetX, 60, 1, 0);
        drawArrowHead(gc, offsetX + w, 60, -1, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("Width %.2f [mm]", profileWidth), canvasWidth / 2.0, 40);

        // web thickness
        gc.strokeLine(offsetX + w - t - 50, canvasHeight / 2.0, offsetX + w - t, canvasHeight / 2.0);
        gc.strokeLine(offsetX + w, canvasHeight / 2.0, offsetX + w + 50, canvasHeight / 2.0);

        drawArrowHead(gc, offsetX + w - t, canvasHeight / 2.0, -1, 0);
        drawArrowHead(gc, offsetX + w, canvasHeight / 2.0, 1, 0);

        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("t=%.2f [mm]", thickness), offsetX + w + 60, canvasHeight / 2.0);


        // and the center
        gc.save();
        gc.setLineWidth(1);
        gc.setLineDashes(30,5);
        gc.strokeLine(centerX-0.2*w, centerY, centerX+0.2*w, centerY);
        gc.strokeLine(centerX, centerY-0.2*h, centerX, centerY+0.2*h);
        gc.restore();

        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private void drawLBars(GraphicsContext gc) {

        BarSection barSection = getObject();
        var sectionType = SectionType.getType(barSection);

        double webHeight;
        double webThickness;
        double flangeWidth;
        double flangeThickness;
        double overshoot;
        double overallHeight;
        double overallWidth;


        if (SectionType.L_BAR == sectionType) {
            var lbar = object.getLBar();
            webHeight = UnitConverter.toDefaultUnit(lbar.getHeight());
            webThickness = UnitConverter.toDefaultUnit(lbar.getWebThickness());
            flangeWidth = UnitConverter.toDefaultUnit(lbar.getWidth());
            flangeThickness = UnitConverter.toDefaultUnit(lbar.getFlangeThickness());
            overallHeight = webHeight;
            overallWidth = flangeWidth;
            overshoot=0.0;
        } else if (SectionType.L_BAR_OF == sectionType) {
            var lbar = object.getLBarOF();
            overshoot = UnitConverter.toDefaultUnit(lbar.getOvershoot());
            webHeight = UnitConverter.toDefaultUnit(lbar.getHeight());
            webThickness = UnitConverter.toDefaultUnit(lbar.getWebThickness());
            flangeWidth = UnitConverter.toDefaultUnit(lbar.getWidth());
            flangeThickness = UnitConverter.toDefaultUnit(lbar.getFlangeThickness());
            overallHeight = webHeight + flangeThickness;
            overallWidth = flangeWidth;
        } else {
            // L_BAR_OW
            var lbar = object.getLBarOW();
            overshoot = UnitConverter.toDefaultUnit(lbar.getOvershoot());
            webHeight = UnitConverter.toDefaultUnit(lbar.getHeight());
            webThickness = UnitConverter.toDefaultUnit(lbar.getWebThickness());
            flangeWidth = UnitConverter.toDefaultUnit(lbar.getWidth());
            flangeThickness = UnitConverter.toDefaultUnit(lbar.getFlangeThickness());
            overallHeight = webHeight;
            overallWidth = flangeWidth + webThickness;
        }

        var scaleY = (canvasHeight - 200) / overallHeight;
        var scaleX = (canvasWidth - 200) / overallWidth;

        var scale = Math.min(scaleX, scaleY);
        LOG.info("scale {}", scale);


        var offsetX = Math.round((canvasWidth) / 2.0); // offset X
        var offsetY = Math.round(canvasHeight - 100); // offset Y

        var h = webHeight * scale; // web height
        var wt = webThickness * scale; // web thickness

        var f = flangeWidth * scale; // flange width
        var ft = flangeThickness * scale; // flange thickness

        var over = overshoot * scale; // overshoot

        var wX = Math.round(offsetX + (SectionType.L_BAR_OF == sectionType ? over : 0.0)) + 0.5;
        var wY = SectionType.L_BAR_OF == sectionType ?  Math.round(100 + ft) + 0.5 : 100.5;

        var fX = SectionType.L_BAR_OW == sectionType ? Math.round(offsetX+wt) + 0.5 : offsetX;
        var fY = SectionType.L_BAR_OW == sectionType ? Math.round(100 + over) + 0.5 : 100.5;

        // the web
        gc.setStroke(barColor);
        gc.setLineWidth(barLineWidth);
        gc.setFill(barPattern);

        gc.fillRect(wX, wY, wt, h);
        gc.strokeRect(wX, wY, wt, h);

        // the flange
        gc.fillRect(fX, fY, f, ft);
        gc.strokeRect(fX, fY, f, ft);


        // Height
        gc.setStroke(dimensionLineColor);
        gc.setFill(dimensionLineColor);
        gc.setLineWidth(dimensionLineWidth);

        gc.strokeLine(offsetX - 50, wY, wX, wY);
        gc.strokeLine(offsetX - 50, offsetY, wX, offsetY);
        gc.strokeLine(offsetX - 40, wY, offsetX - 40, offsetY);
        drawArrowHead(gc, offsetX - 40, wY, 0, 1);
        drawArrowHead(gc, offsetX - 40, offsetY, 0, -1);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("web height %.2f [mm]", webHeight), offsetX - 150, canvasHeight / 2.0);

        gc.strokeLine(wX, offsetY, wX, offsetY + 40);
        gc.strokeLine(wX + wt, offsetY, wX + wt, offsetY + 40);
        gc.strokeLine(wX - 50, offsetY + 30, wX, offsetY + 30);
        gc.strokeLine(wX + wt, offsetY + 30, wX + wt + 50, offsetY + 30);
        drawArrowHead(gc, wX, offsetY + 30, -1, 0);
        drawArrowHead(gc, wX + wt, offsetY + 30, 1, 0);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("web t=%.2f [mm]", webHeight), wX + wt + 60, offsetY + 30);

        gc.strokeLine(fX, fY, fX, 50);
        gc.strokeLine(fX + f, fY, fX + f, 50);
        gc.strokeLine(fX, 60, fX + f, 60);
        drawArrowHead(gc, fX, 60, -1, 0);
        drawArrowHead(gc, fX + f, 60, 1, 0);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(String.format("flange width %.2f [mm]", flangeWidth), fX + 0.5 * f, 40);

        gc.strokeLine(fX + f, fY, fX + f + 40, fY);
        gc.strokeLine(fX + f, fY + ft, fX + f + 40, fY + ft);
        gc.strokeLine(fX + f + 30, fY - 30, fX + f + 30, fY);
        gc.strokeLine(fX + f + 30, fY + ft, fX + f + 30, fY + ft + 30);
        drawArrowHead(gc, fX + f + 30, fY, 0, -1);
        drawArrowHead(gc, fX + f + 30, fY + ft, 0, 1);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("flange t=%.2f [mm]", flangeThickness), fX + f + 60, fY + 0.5 * ft);


        // Paint the coordinate system
        drawCossys(gc, offsetX, offsetY);

    }

    private ImagePattern createHatch() {

//        CssToColorHelper helper = new CssToColorHelper();
//        helper.setStyle("-named-color: -color-danger-emphasis;");
//        helper.applyCss();
//        Color color = helper.getNamedColor();
//        LOG.info("color: {}", color);

        var color = Color.RED;
        var hatchColor = Color.WHITE;
        var hatchColor2 = Color.LIGHTGRAY;

        final WritableImage hatch = new WritableImage(100, 100);
        final PixelWriter pixelWriter = hatch.getPixelWriter();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {

                if (x == y) {
                    pixelWriter.setColor(x, y, hatchColor);
                } else if (Math.abs(x - y) <= 2) {
                    pixelWriter.setColor(x, y, hatchColor2);
                } else {
                    pixelWriter.setColor(x, y, color);
                }
            }
        }

//        final File file = new File("hatch.png");
//        LOG.error("write hatch to {}", file.getAbsolutePath());
//
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(hatch, null), "png", file);
//        } catch (IOException e) {
//           LOG.error("write hatch to {} failed", file.getAbsolutePath(), e);
//        }

        return new ImagePattern(hatch, 0, 0, 100, 100, false);
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



}
