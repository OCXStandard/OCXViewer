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
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.WindowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;
import javafx.scene.text.Text;
/*
 * This class is responsible for displaying the logo of the application directly after startup.
 * It is later discarded in the MainController's {@link MainController#initializeDataView()} method.
 */
public class LogoPage extends Region {
    private static final Logger LOG = LogManager.getLogger(LogoPage.class);
    private final Canvas canvas;
    private Image background = null;
    private double imgW, imgH;
    private Consumer<Canvas> repaint ;

    public LogoPage() {
        super();

       // this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        canvas = new Canvas();
        getChildren().add(canvas);
        repaint = c -> drawShapes() ;

        try {
            background = new Image(LogoPage.class.getResource("logo.png").toString());
            imgW = background.getWidth();
            imgH =background.getHeight();
        } catch (Exception e) {
            LOG.error("Could not load logo.png", e);
        }

        /*
        this.heightProperty().addListener(observable -> layoutChildren());
        this.widthProperty().addListener(observable -> layoutChildren());

        DefaultEventBus.getInstance().subscribe(WindowEvent.class, new Consumer<WindowEvent>() {
            @Override
            public void accept(WindowEvent windowEvent) {
                LOG.error(windowEvent.toString());
                layoutChildren();
            }
        });
*/
    }

    @Override
    protected void layoutChildren() {
        LOG.info("layoutChildren {}x{}", this.getWidth(), this.getHeight());
        super.layoutChildren();
        double width = getWidth();
        canvas.setWidth(width);
        double height = getHeight();
        canvas.setHeight(height);
        repaint.accept(canvas);
        //drawShapes(canvas.getGraphicsContext2D());
    }

    public Consumer<Canvas> getRepaint() {
        return repaint;
    }

    public void setRepaint(Consumer<Canvas> repaint) {
        this.repaint = repaint ;
    }

    private void drawShapes() {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        LOG.info("drawShapes {}x{}", canvas.getWidth(), canvas.getHeight());
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.strokeLine(0,0, canvas.getWidth(), canvas.getHeight());

        var txt="OCXViewer";
        var font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Text text = new Text(txt);
        text.setFont(font);
        var textWidth = text.getLayoutBounds().getWidth();
        var textHeight = text.getLayoutBounds().getHeight();
        var x = 10.0;
        var y = canvas.getHeight() - textHeight-25;
        gc.setFont(font );
        gc.fillText(txt, x, y);

        if ( background !=null) {
            var cnvsW = canvas.getWidth();
            var cnvsH =canvas.getHeight();

            var scaleX = Math.min(1, cnvsW/imgW);
            var scaleY = Math.min(1, cnvsH/imgH);
            var scale = Math.min(scaleX, scaleY);

            var imgWS = imgW*scale;
            var imgHS = imgH*scale;

            var ix = canvas.getWidth()-imgWS-10;
            var iy = canvas.getHeight()-imgHS-25;
            gc.drawImage(background, ix, iy, imgWS, imgHS);
        };
    }
}
