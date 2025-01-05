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
package de.cadoculus.ocxviewer.actions;

import de.cadoculus.ocx3.OCXIO;
import de.cadoculus.ocx3.OcxXML;
import de.cadoculus.ocxviewer.MainController;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.OpenEvent;
import de.cadoculus.ocxviewer.models.WorkingContext;
import jakarta.xml.bind.JAXBElement;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class OpenAction {

    private static final Logger LOG = LogManager.getLogger(MainController.class);

    public static final KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    public static final String NAME= "Open";

    private File file;

    public OpenAction() {
    }

    public void run() {
        LOG.debug("open");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open OCX File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("OCX Files", "*.3docx"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        fileChooser.setInitialDirectory( new File(WorkingContext.getInstance().getLastOpenDir()));

        while(true) {
            file = fileChooser.showOpenDialog(null);
            if (file == null) {
                return;
            }
            if ( ! (file.exists() && file.canRead())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Open OCX File");
                alert.setHeaderText(null);
                alert.setContentText("The selected file is not readable or does not exist.");

                alert.showAndWait();
                continue;
            }

            break;
        }
        LOG.info("Selected file: {}", file);
        final File selectedFile = file;

        new Thread(() -> {

            try {
                final JAXBElement<OcxXML> element = OCXIO.read(selectedFile);
                LOG.info("loaded file: {}", element);
                OcxXML ocx = element.getValue();

                        Platform.runLater(() -> {
                            LOG.info("loaded file: {}", element);
                            WorkingContext.getInstance().setOCXFile(selectedFile);
                            OpenEvent openEvent = new OpenEvent( ocx, selectedFile);
                            DefaultEventBus.getInstance().publish(openEvent);
                });

            } catch (Throwable exception) {
                handleException(exception);

                return;
            }

        }).start();
    }

    private void handleException(Throwable exception) {
        LOG.error("failed to read", exception);
        Platform.runLater(() -> {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Open OCX File Failed");
            alert.setHeaderText("Failed to load OCX file");
            // Create expandable Exception.
            java.io.StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            String exceptionText = sw.toString();

            Label label = new Label("The exception stacktrace was:");

            TextArea textArea = new TextArea(exceptionText);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(label, 0, 0);
            expContent.add(textArea, 0, 1);

            // Set expandable Exception into the dialog pane.
            alert.getDialogPane().setExpandableContent(expContent);

            alert.showAndWait();
        });
    }
}
