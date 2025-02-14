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

import de.cadoculus.ocxviewer.Main;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * This class is responsible for displaying the logo of the application directly after startup.
 * It is later discarded in the MainController's {@link MainController#initializeDataView()} method.
 */
public class LogoPage extends BorderPane {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private final Canvas canvas;
    private Image background = null;
    private Image paper = null;

    public LogoPage() {
        super();

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        canvas = new Canvas();
        this.setCenter(canvas);

        var g2d = canvas.getGraphicsContext2D();


        try {

            background = new Image(LogoPage.class.getResource("windfinder.png").toString());
            paper = new Image(LogoPage.class.getResource("Rastergrafik.png").toString());

        } catch (Exception e) {
            LOG.error("Could not load logo.png", e);
        }

        drawShapes(g2d);

        this.heightProperty().addListener(observable -> layoutChildren());
        this.widthProperty().addListener(observable -> layoutChildren());


    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        double width = getWidth();
        canvas.setWidth(width);
        double height = getHeight();
        canvas.setHeight(height);
        drawShapes(canvas.getGraphicsContext2D());
    }


    private void drawShapes(GraphicsContext gc) {

        //LOG.info("drawShapes {}x{}", canvas.getWidth(), canvas.getHeight());
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());



        if ( background !=null) {
            gc.drawImage(background, 0, 0);
        };

        if ( paper !=null) {

            var endX = canvas.getWidth()*0.4;
            var endY  =canvas.getHeight()*0.6;

            gc.setStroke(Color.WHITE);
            gc.setLineWidth(2);

            var lastX = endX;
            var lastY = endY+160;

            while ( lastY < canvas.getHeight()) {
                var deltaX =-10 * 5* Math.random();
                var deltaY = 10 + 10.*Math.random();

                gc.strokeLine(lastX, lastY, lastX+deltaX, lastY+deltaY);
                lastX +=deltaX;
                lastY +=deltaY;
            }

            gc.drawImage(paper, endX, endY);

        };
    }
}
