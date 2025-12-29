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
package de.cadoculus.ocxviewer;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import de.cadoculus.ocxviewer.actions.AboutAction;
import de.cadoculus.ocxviewer.actions.ActionDispatcher;
import de.cadoculus.ocxviewer.actions.ExitAction;
import de.cadoculus.ocxviewer.actions.OpenAction;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.HotkeyEvent;
import de.cadoculus.ocxviewer.event.WindowEvent;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.views.LogoPage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * The viewer application
 */
public class OCXViewerApplication extends Application {

    private static final Logger LOG = LogManager.getLogger(OCXViewerApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        // Exit JAVA when the window is closed
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        try {

         Image   paper = new Image(LogoPage.class.getResource("Rastergrafik.png").toString());
            stage.getIcons().add(paper);

        } catch (Exception e) {
            LOG.error("Could not load logo.png", e);
        }


        // This loads the main-view.fxml file and thus starts the complete UI of the application
        // See MainController for the actual logic
        FXMLLoader fxmlLoader = new FXMLLoader(OCXViewerApplication.class.getResource("main-view.fxml"));
        // TODO: figure out screen size and scaling, then set the size
        Scene scene = new Scene(fxmlLoader.load(), 1024, 512);
        WorkingContext.getInstance().setMainScene(scene);
        stage.setTitle("OCX Viewer");
        stage.setMinHeight(600);
        stage.setMinWidth(1024);
        stage.setScene(scene);


        // ... and the window events
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                DefaultEventBus.getInstance().publish( new WindowEvent(scene));
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                DefaultEventBus.getInstance().publish( new WindowEvent(scene));
            }
        });

        // listen for actions
        new ActionDispatcher(scene);

        // set the theme
        if (! WorkingContext.getInstance().darkModeProperty().get()) {
            Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
        } else {
            Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}