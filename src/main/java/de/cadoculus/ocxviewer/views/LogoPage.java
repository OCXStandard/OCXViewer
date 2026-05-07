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

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * This class is responsible for displaying the logo of the application directly after startup.
 * It is later discarded in the MainController's {@link MainController#initializeDataView()} method.
 * @author Carsten Zerbst
 */
public class LogoPage extends Region {
    private static final Logger LOG = LogManager.getLogger(LogoPage.class);
    private static final String LOGO_RESOURCE = "/de/cadoculus/ocxviewer/images/logo.png";
    private final Canvas canvas;
    private final ImageView logoView;

    public LogoPage() {
        super();
        setId("logoPage");

        canvas = new Canvas();
        logoView = createLogoView();
        getChildren().addAll(canvas, logoView);

    }

    private ImageView createLogoView() {
        var logoResource = LogoPage.class.getResource(LOGO_RESOURCE);
        if (logoResource == null) {
            LOG.error("Could not load logo resource {}", LOGO_RESOURCE);
            return new ImageView();
        }

        ImageView imageView = new ImageView(new Image(logoResource.toExternalForm()));
        imageView.setManaged(false);
        imageView.setMouseTransparent(true);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        return imageView;
    }


    @Override
    protected void layoutChildren() {

        super.layoutChildren();
        double width = getWidth();
        canvas.setWidth(width);
        double height = getHeight();
        canvas.setHeight(height);

        if (logoView.getImage() != null) {
            double imageWidth = logoView.getImage().getWidth();
            double imageHeight = logoView.getImage().getHeight();
            double maxWidth = Math.min(imageWidth, width * 0.6);
            double maxHeight = Math.min(imageHeight, height * 0.6);

            logoView.setFitWidth(maxWidth);
            logoView.setFitHeight(maxHeight);
            logoView.autosize();
            logoView.relocate((width - logoView.prefWidth(-1)) / 2, (height - logoView.prefHeight(-1)) / 2);
        }


    }

}
