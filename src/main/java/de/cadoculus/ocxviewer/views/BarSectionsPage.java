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
import org.ocx_schema.v310rc3.BarSection;
import org.ocx_schema.v310rc3.OcxXMLT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class BarSectionsPage extends AbstractDataViewPage implements Page {
    public static final String NAME = "Bar Sections";
    private static final Logger LOG = LogManager.getLogger(BarSectionsPage.class);
    private final TableView<BarSection> table;
    private final GridPane gridPane;
    private final Label barLabel = new Label();
    private final Canvas canvas = new Canvas();
    private final ObjectProperty<BarSection> selectedBarSection = new SimpleObjectProperty<>();
    private double hpC;
    private double hpR;
    private ImagePattern barPattern;
    public static double SIN_30=0.5;
    public static double COS_30=Math.sqrt(3)/2;
    public static double SIN_60=Math.sqrt(3)/2;
    public static double COS_60=Math.sqrt(3)/2;

    public BarSectionsPage() {
        super(NAME);

        createTitle("Information about the bar sections used for stiffeners and pillars.");

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
        gridPane.setGridLinesVisible(true);

        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 0;");
        this.setCenter(gridPane);

        //
        // Define the table
        //
        var tableColumn1 = new TableColumn<BarSection, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getId())
        );

        var tableColumn2 = new TableColumn<BarSection, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<BarSection, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName())
        );

        var tableColumn4 = new TableColumn<BarSection, String>("Type");
        tableColumn4.setCellValueFactory(
                c -> new SimpleStringProperty( SectionType.getType(c.getValue()).name())
        );

        ObservableList<BarSection> barSections = FXCollections.observableArrayList();
        table = new TableView<>(barSections);
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
        if (ocx.getClassCatalogue().getXSectionCatalogue() == null) {
            LOG.info("no Xsections found in class catalogue");
            return;
        }
        List<BarSection> catBarSections = null;
        if ((catBarSections = ocx.getClassCatalogue().getXSectionCatalogue().getBarSections()) != null) {
            barSections.addAll(catBarSections);
        }

        LOG.debug("found #{} bar sections", barSections.size());

        table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSection, selectedSection) -> {
            updateBar(oldSection, selectedSection);
        });

        this.boundsInLocalProperty().addListener((observableValue, bounds, t1) -> {
            updateCanvas();
        });

    }

    @Override
    public void afterShow() {

        table.getSelectionModel().selectFirst();
    }

    private void updateCanvas() {


        LOG.info(" gridpane local {}\nparent {}", gridPane.getBoundsInLocal(), gridPane.getBoundsInParent());
        LOG.info(" last label local {}\nparent {}", barLabel.getBoundsInLocal(), barLabel.getBoundsInParent());
        LOG.info(" canvas {}\n{}", canvas.getBoundsInLocal(), canvas.getBoundsInParent());

        var availableHeight = gridPane.getHeight() - barLabel.getBoundsInParent().getMaxY()-10;

        LOG.info("set canvas height to {}", availableHeight);
        var availableWidth = this.getWidth()-21;

        canvas.setHeight(availableHeight);
        canvas.setWidth(availableWidth);

        LOG.info(" canvas {}\n{}", canvas.getBoundsInLocal(), canvas.getBoundsInParent());

        if ( selectedBarSection.getValue() != null) {
            repaintCanvas();
        }

    }

    private  void repaintCanvas() {
        LOG.info("repaint canvas {}, {}x{}", selectedBarSection.getValue(), canvas.getWidth() , canvas.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if ( selectedBarSection.getValue() == null) {
            return;
        }

        if ( barPattern ==null) {
            barPattern = createHatch();
        }

        var canvasWidth = canvas.getWidth();
        var canvasHeight = canvas.getHeight();

        BarSection barSection = selectedBarSection.getValue();
        LOG.info("bar section {}", barSection.getId());
        if ( SectionType.FLAT_BAR== SectionType.getType(barSection)) {
            var flatBar = selectedBarSection.getValue().getFlatBar();

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
            gc.fillRect(coordX, coordY, rwidth, rheight);
            gc.setStroke(Color.DARKRED);
            gc.setLineWidth(2);
            gc.strokeRect(coordX, coordY, rwidth, rheight);

            gc.setStroke(Color.BLACK);
            gc.setFill(Color.BLACK);
            gc.setLineWidth(1);

            // Height
            var p0X = Math.round(-100 + canvasWidth / 2.0) + 0.5;
            var p0Y = 100.5;
            var p1X = p0X;
            var p1Y = p0Y + rheight;
            gc.strokeLine(p0X, p0Y, Math.round(canvasWidth / 2.0), p0Y);
            gc.strokeLine(p1X, p1Y, Math.round(canvasWidth / 2.0), p1Y);
            gc.strokeLine(p0X + 10, p0Y, p1X + 10, p1Y);

            drawArrowHead(gc, p0X + 10, p0Y, 0, 1);
            drawArrowHead(gc, p1X + 10, p1Y, 0, -1);

            gc.setTextAlign(TextAlignment.RIGHT);
            gc.fillText(String.format("Height %.2f [mm]", profileHeight), p0X, (p0Y + p1Y) / 2.0);

            // width
            var p2X = Math.round(canvas.getWidth() / 2.0) + 0.5;
            var p2Y = p1Y;
            var p3X = p2X;
            var p3Y = p2Y + 50;

            var p4X = Math.round(canvasWidth / 2.0 + rwidth) + 0.5;
            var p4Y = p2Y;
            var p5X = p4X;
            var p5Y = p4Y + 50;

            gc.strokeLine(p2X, p2Y, p3X, p3Y);
            gc.strokeLine(p4X, p4Y, p5X, p5Y);
            gc.strokeLine(p3X - 25, p3Y - 10, p5X + 100, p5Y - 10);

            drawArrowHead(gc, p3X, p3Y - 10, -1, 0);
            drawArrowHead(gc, p5X, p5Y - 10, 1, 0);


            gc.setTextAlign(TextAlignment.LEFT);
            gc.fillText(String.format("Width %.2f [mm]", flangeWidth), p5X + 20, p5Y - 20);


            // paint the coordinate system of the tube


            gc.setStroke(Color.BLUE);
            gc.setFill(Color.BLUE);
            gc.setLineWidth(1);
            gc.strokeLine(coordX, coordY+rheight, coordX+50, coordY+rheight);
            gc.strokeLine(coordX, coordY+rheight, coordX, coordY+rheight-50);
            drawArrowHead(gc, coordX+50, coordY+rheight, -1, 0);
            drawArrowHead(gc, coordX, coordY+rheight-50, 0, 1);



        } else if ( SectionType.TUBE==SectionType.getType(barSection)) {

            var tube = selectedBarSection.getValue().getTube();

            var diameter = UnitConverter.toDefaultUnit(tube.getDiameter());
            var thickness = UnitConverter.toDefaultUnit(tube.getThickness());

            var scaleY = (canvasHeight - 200) / diameter;
            var scaleX = (canvasWidth - 200) / diameter;

            var scale = Math.min(scaleX, scaleY);
            var cdia = Math.round(diameter * scale) + 0.5;
            var ct = Math.round(thickness * scale);

            // paint the coordinate system of the tube
            var pCX = Math.round((canvasWidth-cdia) / 2.0)  + 0.5;
            var pCY = Math.round(canvasHeight-100) + 0.5;

            gc.setStroke(Color.BLUE);
            gc.setFill(Color.BLUE);
            gc.setLineWidth(1);
            gc.strokeLine(pCX, pCY, pCX+50, pCY);
            gc.strokeLine(pCX, pCY, pCX, pCY-50);
            drawArrowHead(gc, pCX+50, pCY, -1, 0);
            drawArrowHead(gc, pCX, pCY-50, 0, 1);


            // paint the tube
            gc.setFill(barPattern);
            gc.beginPath();

            //gc.moveTo(pCX, Math.round( canvasHeight/2.0)+0.5);
            gc.arc(Math.round( canvasWidth/2.0)+0.5, Math.round( canvasHeight/2.0)+0.5,
                    0.5*cdia,0.5*cdia, 0,180);
            gc.lineTo( pCX+ ct, Math.round( canvasHeight/2.0)+0.5);
            gc.arc(Math.round( canvasWidth/2.0)+0.5, Math.round( canvasHeight/2.0)+0.5,
                    0.5*cdia-ct,0.5*cdia-ct, 180,-180);
            gc.lineTo( pCX+ cdia-ct, Math.round( canvasHeight/2.0)+0.5);
            gc.arc(Math.round( canvasWidth/2.0)+0.5, Math.round( canvasHeight/2.0)+0.5,
                    0.5*cdia-ct,0.5*cdia-ct, -0,-180);
            gc.lineTo( pCX, Math.round( canvasHeight/2.0)+0.5);
            gc.arc(Math.round( canvasWidth/2.0)+0.5, Math.round( canvasHeight/2.0)+0.5,
                    0.5*cdia,0.5*cdia, 180,180);



//            gc.arcTo(Math.round( canvasWidth/2.0)+0.5, 100.5,
//                    pCX, Math.round( canvasHeight/2.0),cdia);
            //gc.closePath();
            gc.stroke();
            gc.fill();

            gc.setStroke(Color.DARKRED);
            gc.setLineWidth(2);
            gc.strokeOval( pCX, 100.5, cdia, cdia);
            gc.strokeOval( pCX+ct, 100.5+ct, cdia-2*ct, cdia-2*ct);




            // diameter
            gc.setStroke(Color.BLACK);
            gc.setFill(Color.BLACK);
            gc.setLineWidth(1);
            var p0X = Math.round( (canvasWidth+cdia) / 2.0)  + 50.5;
            var p0Y = 100.5;
            var p1X = p0X;
            var p1Y = pCY;
            gc.strokeLine(Math.round(canvasWidth / 2.0), p0Y, p0X, p0Y);
            gc.strokeLine(Math.round(canvasWidth / 2.0), p1Y, p1X, p1Y);
            gc.strokeLine(p0X - 10, p0Y, p1X - 10, p1Y);

            drawArrowHead(gc, p0X - 10, p0Y, 0, 1);
            drawArrowHead(gc, p1X - 10, p1Y, 0, -1);

            gc.setTextAlign(TextAlignment.LEFT);
            gc.fillText(String.format("⌀ %.2f [mm]", diameter), p0X, (p0Y + p1Y) / 2.0);

            // thickness
            var p2X =pCX-100;
            var p2Y = Math.round( canvasHeight/2.0)+0.5;
            var p3X = pCX;
            var p3Y = p2Y;

            gc.strokeLine(p2X, p2Y, p3X, p3Y);
            drawArrowHead(gc, p3X, p3Y, -1,0);

            var p4X = pCX+ct;
            var p4Y = p2Y;
            var p5X = p4X+50;
            var p5Y = p2Y;
            gc.strokeLine(p4X, p4Y, p5X, p5Y);
            drawArrowHead(gc, p4X, p4Y, 1,0);

            gc.setTextAlign(TextAlignment.RIGHT);
            gc.fillText(String.format("t=%.2f [mm]", thickness), p3X-20, p3Y-20);




        } else if ( SectionType.BULB_FLAT== SectionType.getType(barSection)) {

            var bulbFlat = selectedBarSection.getValue().getBulbFlat();
            var profileHeight = UnitConverter.toDefaultUnit(bulbFlat.getHeight());
            var webThickness = UnitConverter.toDefaultUnit(bulbFlat.getWebThickness());
            var flangeWidth = bulbFlat.getFlangeWidth() != null?
                    UnitConverter.toDefaultUnit(bulbFlat.getFlangeWidth()) : webThickness*3;
            var radius = bulbFlat.getBulbOuterRadius() != null ?
                    UnitConverter.toDefaultUnit(bulbFlat.getBulbOuterRadius()) : webThickness;
            LOG.info("selected HP {}x{}, width {}, radius {}", profileHeight, webThickness, flangeWidth, radius);


            if (Double.isNaN(hpC) || Double.isNaN(hpR)) {

                try (var reader = new BufferedReader(new InputStreamReader(this.getClass().getResource("bulbbars.csv").openStream()));) {

                    final NumberFormat format = NumberFormat.getInstance(Locale.UK);
                    String line = null;
                    while ( (line = reader.readLine()) != null) {
                        if ( line.startsWith("#")) {
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
                    flangeWidth = hpC+hpR;
                    radius = hpR;

                } catch (Exception e) {
                    LOG.error("failed to read bulbbar.csv", e);
                }

            } else {
                flangeWidth = hpC+hpR;
                radius = hpR;
            }

            LOG.info("height {}, bulb width {}, bulb radius {}, flange thickness {}",
                    profileHeight, flangeWidth, radius, flangeWidth);

            LOG.info("canvas height {}, canvas width {}", canvasHeight, canvasWidth);

            var scaleY = (canvasHeight - 200) / profileHeight;
            var scaleX = (canvasWidth - 200) / flangeWidth;

            var scale = Math.min(scaleX, scaleY);
            LOG.info("scale {}", scale);


            var t = webThickness*scale; // flange width
            var r = radius*scale; // radius
            var h = profileHeight*scale; // profile height
            var b = flangeWidth*scale; // profile width
            var sX = b-t-2*COS_60*r; // X part of 30° line
            var sY = sX/COS_30*SIN_30; // Y part of 30° line
            var kY = r*(1+2*SIN_60)+sY; // total height of the head starting with fillet curve

            LOG.info("height {}, bulb with {}, bulb radius {}, flange thickness {}",
                    h, b, r, t);


            var oX = Math.round((canvasWidth) / 2.0); // offset X
            var oY = Math.round(canvasHeight-100); // offset Y


            // paint the HP
            gc.setFill(barPattern);
            gc.beginPath();

//            gc.moveTo( Math.round( b -COS_60*r+oX)+0.5,
//                    Math.round(SIN_60*r+100)+0.5);


            gc.arc( Math.round( b-r+oX)+0.5, Math.round( r+100)+0.5, // center of circle x,y
                    r, r, // radius
                    -60,150);
            gc.lineTo(oX+0.5, 100.5); // left top
            gc.lineTo(oX+0.5, oY+0.5); // left bottom
            gc.lineTo( Math.round(oX+t) + 0.5, oY+0.5); // bottom
            gc.lineTo( Math.round(oX+t) + 0.5, Math.round(100+kY)+0.5);
            gc.arc( Math.round(oX+t+r)+0.5, Math.round(100+kY+r)+0.5, // center of circle x,y);
                    r, r, // radius
                    180,-60);
            gc.closePath();
            gc.stroke();
            gc.fill();

            // paint the coordinate system of the tube
            gc.setStroke(Color.BLUE);
            gc.setFill(Color.BLUE);
            gc.setLineWidth(1);
            gc.strokeLine(oX+0.5, oY+0.5, oX+50.5, oY);
            gc.strokeLine(oX+0.5, oY+0.5,oX+0.5, oY-49.5);
            drawArrowHead(gc, oX+50.5, oY, -1, 0);
            drawArrowHead(gc, oX+0.5, oY-49, 0, 1);


            // Height
            gc.setStroke(Color.BLACK);
            gc.setFill(Color.BLACK);

            gc.strokeLine(oX -100, 100, oX-100, oY);
            gc.strokeLine(oX-105, 100, oX, 100);
            gc.strokeLine(oX-105, oY, oX, oY);

            drawArrowHead(gc, oX-100, 100,  0, 1);
            drawArrowHead(gc, oX-100, oY, 0, -1);

            gc.setTextAlign(TextAlignment.RIGHT);
            gc.fillText(String.format("Height %.2f [mm]", profileHeight), oX-150, canvasHeight / 2.0);

            // web thickness
            var p2X = oX;
            var p2Y = oY;
            var p3X = oX;
            var p3Y = oY + 50;

            var p4X = Math.round(oX+t) + 0.5;
            var p4Y = oY;
            var p5X = p4X;
            var p5Y = oY + 50;

            gc.strokeLine(p2X, p2Y, p3X, p3Y);
            gc.strokeLine(p4X, p4Y, p5X, p5Y);
            gc.strokeLine(p3X - 25, p3Y - 10, p5X + 100, p5Y - 10);

            drawArrowHead(gc, p3X, p3Y - 10, -1, 0);
            drawArrowHead(gc, p5X, p5Y - 10, 1, 0);

            gc.setTextAlign(TextAlignment.LEFT);
            gc.fillText(String.format("Web Thickness %.2f [mm]", webThickness), p5X + 20, p5Y - 20);


            // bulb width
            var p6X = oX;
            var p6Y = 50;
            var p7X = p6X;
            var p7Y = 100;

            var p8X = oX+b;
            var p8Y = 50;
            var p9X = oX+b;
            var p9Y = 100+r;

            gc.strokeLine(p6X, p6Y, p7X, p7Y);
            gc.strokeLine(p8X, p8Y, p9X, p9Y);
            gc.strokeLine(p6X, p6Y+10, p8X, p8Y+10);

            drawArrowHead(gc, p6X, p6Y + 10, -1, 0);
            drawArrowHead(gc, p8X, p8Y + 10, 1, 0);

            gc.setTextAlign(TextAlignment.CENTER);
            gc.fillText(String.format("Width %.2f [mm]", flangeWidth), oX+0.5*b, p6Y-15);


        } else {
            LOG.info("unsupported bar section {}", SectionType.getType( barSection));
        }


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
        for( int x = 0; x < 100; x++) {
            for( int y = 0; y < 100; y++) {

                if ( x==y) {
                    pixelWriter.setColor(x, y, hatchColor);
                } else if (Math.abs( x-y) <=2) {
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

        return new ImagePattern(hatch,0,0,100,100,false);
    }

    private void drawArrowHead(GraphicsContext gc, double x, double y, double xDir , double yDir    ) {

        var p0 = new Point2D(0,0);
        var p1 = new Point2D(12,3);
        var p2 = new Point2D(12,-3);

        //LOG.info("p0 {} p1 {} p2 {}", p0, p1, p2);

        var angle = Math.atan2(yDir, xDir);
        //LOG.info("angle {}°", Math.toDegrees(angle));
        Rotate rotate = new Rotate(Math.toDegrees(angle),0,0);

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

    private void updateBar(BarSection oldSection, BarSection selectedSection) {


        hpC = Double.NaN;
        hpR = Double.NaN;
        LOG.info("Updating bar section {}", selectedSection);
        selectedBarSection.setValue(selectedSection);

        barLabel.setText(SectionType.getType(selectedSection).getName() + " " + selectedSection.getId());
        barLabel.getStyleClass().add(Styles.TITLE_4);

        repaintCanvas();
    }

    private void createUnknown(BarSection selectedSection, int row) {
        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "Got unknown bar section !",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        var warningIcon = new FontIcon(MaterialDesignA.ALERT);
        warningIcon.getStyleClass().add(Styles.WARNING);

        gridPane.add(warning, 0, ++row, 4, 1);
    }



}
