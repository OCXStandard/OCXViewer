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

import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.NavigationEvent;
import de.cadoculus.ocxviewer.event.OpenEvent;
import de.cadoculus.ocxviewer.io.OCXIO;
import de.cadoculus.ocxviewer.io.OCXParser;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.ui.ProgressBarWithText;
import de.cadoculus.ocxviewer.views.LogPage;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.OcxXMLT;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Action to open an OCX file.
 * @author Carsten Zerbst
 */
public class OpenAction extends AbstractAction {

    public static final KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    public static final String NAME = "Open";
    private static final Logger LOG = LogManager.getLogger(OpenAction.class);


    public OpenAction() {
    }

    @Override
    public void run() {
        LOG.debug("open");

        DefaultEventBus.getInstance().publish(
                new NavigationEvent(LogPage.class)
        );

        File file;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open OCX File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("OCX Files", "*.3docx"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        fileChooser.setInitialDirectory(new File(WorkingContext.getInstance().getLastOpenDir()));

        while (true) {
            file = fileChooser.showOpenDialog(null);
            if (file == null) {
                return;
            }
            if (!(file.exists() && file.canRead())) {
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

        //
        // Prepare a dialog to show progress
        //
        var dialogue = new Dialog<Void>();
        dialogue.setResizable(true);
        var owner = dialogue.getDialogPane().getScene().getWindow();
        Stage stage = (Stage) owner;
        stage.setMinWidth(300);
        stage.setMinHeight(150);

        dialogue.setTitle("Parsing " + selectedFile.getName());
        dialogue.setHeaderText("");
        final var prgressBar = new ProgressBarWithText();
        dialogue.getDialogPane().setContent(prgressBar);

        dialogue.initModality(Modality.APPLICATION_MODAL);

        dialogue.getDialogPane().getButtonTypes().add( ButtonType.CLOSE);
        Node loginButton = dialogue.getDialogPane().lookupButton(ButtonType.CLOSE);
        loginButton.setDisable(true);

        // binding the progress must happen in the JavaFX thread, that's why the parser is created here
        final var parser = new OCXParser( selectedFile);
        prgressBar.progressProperty().bind( parser.progressProperty());
        dialogue.getDialogPane().headerTextProperty().bind( parser.statusProperty());

        dialogue.show();

        // Now we can start a new thread to read the file
        new Thread(() -> {

            try {

                var result  = parser.parse();
                OcxXMLT ocx = result.ocx();
                WorkingContext.getInstance().setOCXFile(selectedFile);
                WorkingContext.getInstance().setTargetNamespace(result.originalNamespace());
                WorkingContext.getInstance().setOcx(ocx);
                LOG.info("header {}", OCXIO.serialize(ocx.getHeader()));

                Runtime rt = Runtime.getRuntime();
                long total = rt.totalMemory();
                long free = rt.freeMemory();
                long max = rt.maxMemory();
                long used = total -free;

                LOG.info("Memory: total {} free {} used {} max {}",
                        total, free, used, max);
                Platform.runLater(() -> {
                    OpenEvent openEvent = new OpenEvent(ocx, selectedFile);
                    DefaultEventBus.getInstance().publish(openEvent);
                });

            } catch (Throwable exception) {
                handleException(exception);
            } finally {
                Platform.runLater(() -> {
                    // it is necessary to first hide the dialog, otherwise on some platforms
                    // it remains visible even after close is called.
                    dialogue.hide();
                    dialogue.close();});
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
