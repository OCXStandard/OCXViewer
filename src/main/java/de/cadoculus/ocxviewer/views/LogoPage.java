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
import javafx.geometry.Pos;
import de.cadoculus.ocxviewer.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
* This class is responsible for displaying the logo of the application directly after startup.
* It is later discarded in the MainController's {@link MainController#initializeDataView()} method.
 */
public class LogoPage extends StackPane {
    private static final Logger LOG = LogManager.getLogger(Main.class);
        public LogoPage() {
            super();

            ImageView imageView = new ImageView();
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            StackPane.setAlignment(imageView, Pos.CENTER);

            try {

                LOG.error("load {}",LogoPage.class.getResource("logo.png").toString());
                Image image = new Image(LogoPage.class.getResource("logo.png").toString());
                imageView.setImage(image);
            } catch (Exception e) {
               LOG.error("Could not load logo.png", e);
            }

            this.getChildren().add(0, imageView);



        }
}
