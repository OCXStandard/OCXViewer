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

import de.cadoculus.ocxviewer.MainController;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
/*
 * This class is responsible for displaying the logo of the application directly after startup.
 * It is later discarded in the MainController's {@link MainController#initializeDataView()} method.
 * @author Carsten Zerbst
 */
public class LogoPage extends Region {
    private static final Logger LOG = LogManager.getLogger(LogoPage.class);
    private final Canvas canvas;
    private double[] widths;
    private Font thinFont;
    private Font boldFont;
    private final Consumer<Canvas> repaint ;
    private final String[] txts=new String[] {" OCX ", "Viewer ", "Version " , "0.1 " };
    private double height =36;
    private final DoubleProperty startX = new SimpleDoubleProperty();
    private double  dy = 1.1*height;
    private double y=dy;
    private final Random random = new Random();
    private int boldIdx = random.nextInt(0,10);
    private int numText = 10;

    public LogoPage() {
        super();

        canvas = new Canvas();
        getChildren().add(canvas);

        repaint = c -> paint() ;

        try {
            InputStream fontStream = MainController.class.getResourceAsStream("fonts/Doto-Thin.ttf");
            if (fontStream == null) {
                LOG.error("Could not create font");
                thinFont = new Font("Arial", 36);
            } else {
                thinFont = Font.loadFont(fontStream, 36);
                fontStream.close();
            }
            fontStream = MainController.class.getResourceAsStream("fonts/Doto-ExtraBold.ttf");
            if (fontStream == null) {
                LOG.error("Could not create font");
                boldFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 36);
            } else {
                boldFont = Font.loadFont(fontStream, 36);
                fontStream.close();
            }

            widths  = Arrays.stream(txts).mapToDouble( t -> {
                Text text = new Text(t);
                text.setFont(thinFont);

                Bounds layoutBounds = text.getLayoutBounds();
                return layoutBounds.getWidth();
            }).toArray();
            double startX = -1*Arrays.stream(widths).sum();
            double endX = 1;


            KeyValue startKeyValue = new KeyValue(this.startX,startX);
            KeyValue endKeyValue = new KeyValue(this.startX,endX);
            KeyFrame startFrame = new KeyFrame(Duration.ZERO, startKeyValue);
            KeyFrame endFrame = new KeyFrame(Duration.seconds(10), endKeyValue);
            Timeline timeline = new Timeline(startFrame, endFrame);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();

            this.startX.addListener((obs, oldVal, newVal) -> {
                layoutChildren();
            });

        } catch (Exception e) {
            LOG.error("Could not load font", e);
            thinFont = new Font("Arial", 36);
        }


    }



    @Override
    protected void layoutChildren() {

        super.layoutChildren();
        double width = getWidth();
        canvas.setWidth(width);
        double height = getHeight();
        canvas.setHeight(height);
        repaint.accept(canvas);
    }


    private void paint() {
        double x = startX.doubleValue();
        y = dy;
        GraphicsContext gc = canvas.getGraphicsContext2D();

        if (WorkingContext.getInstance().darkModeProperty().get()) {
            gc.setFill( Color.web("#ECEFF4")); // --color-fg-default from nord-dark
        } else {
            gc.setFill( Color.web("#2E3440")); // --color-fg-default from nord-light
        }


        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int idx = 0;
        OUTER:while( true) {
            INNER:while ( true) {
                var txtIdx = idx/txts.length;
                if ( txtIdx== boldIdx){
                    gc.setFont(boldFont);
                    if (WorkingContext.getInstance().darkModeProperty().get()) {
                        gc.setFill( Color.web("#5E81AC")); // --color-fg-default from nord-dark -color-accent-5: #5E81AC;
                    } else {
                        gc.setFill( Color.web("#5E81AC")); // --color-fg-default from nord-light -color-accent-5: #5E81AC;
                    }
                } else {
                    gc.setFont(thinFont);
                    if (WorkingContext.getInstance().darkModeProperty().get()) {
                        gc.setFill( Color.web("#ECEFF4")); // --color-fg-default from nord-dark
                    } else {
                        gc.setFill( Color.web("#2E3440")); // --color-fg-default from nord-light
                    }
                }

                var txt = txts[idx % txts.length];
                var w = widths[idx % txts.length];
                gc.fillText(txt, x, y);

                x+=w;

                if ( x> canvas.getWidth()) {
                    x = -w + (x-canvas.getWidth() );
                    if ( txtIdx==boldIdx) {
                        boldIdx = random.nextInt(2,numText-2);
                    }
                    break INNER;
                } else {
                    idx++;
                }
            }
            y+=dy;
            if ( y > (canvas.getHeight()+dy)) {
                numText = idx/txts.length;
                break OUTER;
            }
        }
    }
}
