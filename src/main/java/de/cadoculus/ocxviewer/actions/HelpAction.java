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
package de.cadoculus.ocxviewer.actions;

import atlantafx.base.util.BBCodeParser;
import de.cadoculus.ocxviewer.MainController;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.views.BarSectionsPage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The Help action
 * @author Carsten Zerbst
 */
public class HelpAction extends AbstractAction {
    private static final Logger LOG = LogManager.getLogger(BarSectionsPage.class);

    public final static KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN);
    public final static String NAME = "Help";

    //TODO: write the help text
    @Override
    public void run() {


        String helpText = "";

        try (var reader = new BufferedReader(new InputStreamReader(BarSectionsPage.class.getResource("help.bbc").openStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            helpText = sb.toString();
        } catch (Exception exp) {
            LOG.error("failed to load help text", exp);
            helpText = "Failed to load help text: " + exp.getMessage();
        }


        ScrollPane srollPane = new ScrollPane(BBCodeParser.createLayout(helpText));
        var border = new BorderPane();
        border.setId("helpBorderPane");
        border.setCenter(srollPane);

        Scene secondScene = new Scene(border, 600, 400);
        Stage newWindow = new Stage();
        newWindow.setMinHeight(400);
        newWindow.setMinWidth(600);

        newWindow.setTitle("OCX Viewer Help");
        newWindow.setScene(secondScene);
        newWindow.initModality(Modality.APPLICATION_MODAL);

        String css = "";
        if (WorkingContext.getInstance().darkModeProperty().get()) {
            css = MainController.class.getResource("dark.css").toExternalForm();
        } else {
            css = MainController.class.getResource("light.css").toExternalForm();
        }

        secondScene.getStylesheets().clear();
        secondScene.getStylesheets().add(css);


        // Set position of second window, related to primary window.
        newWindow.setX(WorkingContext.getInstance().getMainScene().getX() + 200);
        newWindow.setY(WorkingContext.getInstance().getMainScene().getY() + 100);

        newWindow.show();

    }

}
