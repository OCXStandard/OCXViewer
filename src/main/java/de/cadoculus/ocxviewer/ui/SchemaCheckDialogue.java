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
package de.cadoculus.ocxviewer.ui;

import atlantafx.base.theme.Styles;
import atlantafx.base.util.BBCodeParser;
import de.cadoculus.ocxviewer.io.OCXSchemaVersion;
import de.cadoculus.ocxviewer.io.SchemaValidationIssue;
import de.cadoculus.ocxviewer.io.SchemaValidator;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;

import java.io.File;
import java.util.List;

/**
 * Dialogue for schema checking options and results
 *
 * @author Carsten Zerbst
 */
public class SchemaCheckDialogue {

    private static final Logger LOG = LogManager.getLogger(SchemaCheckDialogue.class);

    private final BorderPane root = new BorderPane();
    private final TextField fileField = new TextField();
    private final Button browseButton = new Button("Select File ...");
    private final ComboBox<OCXSchemaVersion> versionCombo = new ComboBox<>();
    private final Button validateButton = new Button("Validate");
    private final Label detectedLabel = new Label();
    private final TableView<SchemaValidationIssue> table = new TableView<>();
    private final Label summaryLabel = new Label();
    private final ProgressBarWithText progressBar = new ProgressBarWithText();

    private File selectedFile;
    private OCXSchemaVersion detectedVersion;

    public SchemaCheckDialogue() {

        root.getStyleClass().add("content-pane");
        root.setPadding(new Insets(15));

        var title = new Label("Schema Check");
        title.getStyleClass().add(Styles.TITLE_2);
        var description = BBCodeParser.createFormattedText(
                "Validates an OCX file against the official XSD schema of the selected version");

        fileField.setEditable(false);
        fileField.setPromptText("Select an OCX file to validate ...");
        HBox.setHgrow(fileField, Priority.ALWAYS);
        browseButton.setOnAction(e -> chooseFile());

        versionCombo.getItems().addAll(OCXSchemaVersion.values());
        versionCombo.setValue(OCXSchemaVersion.V310);
        versionCombo.setCellFactory(cb -> new ListCell<>() {
            @Override
            protected void updateItem(OCXSchemaVersion item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setDisable(false);
                } else {
                    setText(item.getDisplayName() + (item.isAvailable() ? "" : " (not bundled)"));
                    setDisable(!item.isAvailable());
                }
            }
        });
        versionCombo.valueProperty().addListener((obs, oldVal, newVal) -> updateDetectedHint());

        validateButton.getStyleClass().add(Styles.ACCENT);
        validateButton.setDisable(true);
        validateButton.setOnAction(e -> runValidation());

        var controls = new HBox(10,
                new Label("File:"), fileField, browseButton,
                new Label("Schema version:"), versionCombo,
                validateButton);
        controls.setAlignment(Pos.CENTER_LEFT);

        var titleBox = new VBox(5, title, description, controls, detectedLabel);
        titleBox.setPadding(new Insets(0, 0, 10, 0));
        root.setTop(titleBox);

        // results table
        buildTable();
        root.setCenter(table);

        // bottom bar: summary, progress, close
        summaryLabel.getStyleClass().add(Styles.TITLE_4);
        HBox.setHgrow(summaryLabel, Priority.ALWAYS);
        summaryLabel.setMaxWidth(Double.MAX_VALUE);

        progressBar.setVisible(false);
        progressBar.setPrefWidth(200);

        var closeButton = new Button("Close");
        closeButton.setOnAction(e -> close());

        var bottomBox = new HBox(10, summaryLabel, progressBar, closeButton);
        bottomBox.setAlignment(Pos.CENTER_LEFT);
        bottomBox.setPadding(new Insets(10, 0, 0, 0));
        root.setBottom(bottomBox);

        // preselect the file currently opened in the viewer, if any
        var currentFile = WorkingContext.getInstance().getOCXFile();
        if (currentFile != null && currentFile.canRead()) {
            setFile(currentFile);
        }
    }

    /**
     * Shows the schema check in the main window, replacing the navigation tree and data view.
     */
    public void show() {
        WorkingContext.getInstance().getMainController().showFullWindowPane(root);
    }

    private void close() {
        WorkingContext.getInstance().getMainController().restoreMainView();
    }

    private void buildTable() {

        var severityCol = new TableColumn<SchemaValidationIssue, SchemaValidationIssue.Severity>("Severity");
        severityCol.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().severity()));
        severityCol.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(SchemaValidationIssue.Severity item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.name());
                    if (item == SchemaValidationIssue.Severity.WARNING) {
                        setGraphic(new FontIcon(MaterialDesignE.EXCLAMATION_THICK));
                    } else {
                        setGraphic(new FontIcon(MaterialDesignF.FLASH));
                    }
                }
            }
        });

        severityCol.setPrefWidth(110);
        severityCol.setMaxWidth(140);

        var lineCol = new TableColumn<SchemaValidationIssue, Number>("Line");
        lineCol.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().line()));
        lineCol.setPrefWidth(70);
        lineCol.setMaxWidth(100);

        var columnCol = new TableColumn<SchemaValidationIssue, Number>("Column");
        columnCol.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().column()));
        columnCol.setPrefWidth(70);
        columnCol.setMaxWidth(100);

        var messageCol = new TableColumn<SchemaValidationIssue, String>("Message");
        messageCol.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().message()));
        messageCol.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setTooltip(null);
                } else {
                    setText(item);
                    var tooltip = new Tooltip(item);
                    tooltip.setWrapText(true);
                    tooltip.setMaxWidth(600);
                    setTooltip(tooltip);
                }
            }
        });

        table.getColumns().addAll(List.of(severityCol, lineCol, columnCol, messageCol));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.setPlaceholder(new Label("No validation results"));

        table.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(SchemaValidationIssue item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setStyle("");
                } else if (item.severity() == SchemaValidationIssue.Severity.WARNING) {
                    if (getIndex() % 2 == 0) {
                        setStyle("-fx-background-color: -color-warning-0");
                    } else {
                        setStyle("-fx-background-color: -color-warning-1");
                    }
                } else {
                    if (getIndex() % 2 == 0) {
                        setStyle("-fx-background-color: -color-danger-0");
                    } else {
                        setStyle("-fx-background-color: -color-danger-1");
                    }
                }
            }
        });
    }

    private void chooseFile() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select OCX File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("OCX Files", "*.3docx", "*.ocx", "*.xml"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        fileChooser.setInitialDirectory(new File(WorkingContext.getInstance().getLastOpenDir()));

        var file = fileChooser.showOpenDialog(WorkingContext.getInstance().getMainScene().getWindow());
        if (file == null) {
            return;
        }
        if (!(file.exists() && file.canRead())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Schema Check");
            alert.setHeaderText(null);
            alert.setContentText("The selected file is not readable or does not exist.");
            alert.showAndWait();
            return;
        }
        setFile(file);
    }

    private void setFile(File file) {
        selectedFile = file;
        fileField.setText(file.getAbsolutePath());
        validateButton.setDisable(false);
        detectedVersion = null;
        detectedLabel.setText("Detecting the file's OCX version ...");
        detectedLabel.setStyle("");

        new Thread(() -> {
            var namespace = SchemaValidator.detectNamespace(file);
            var version = OCXSchemaVersion.fromNamespace(namespace).orElse(null);
            Platform.runLater(() -> {
                detectedVersion = version;
                if (version != null && version.isAvailable()) {
                    versionCombo.setValue(version);
                }
                updateDetectedHint();
            });
        }, "SchemaCheckNamespaceDetection").start();
    }

    private void updateDetectedHint() {
        if (selectedFile == null) {
            detectedLabel.setText("");
            detectedLabel.setStyle("");
        } else if (detectedVersion == null) {
            detectedLabel.setText("Could not detect a known OCX version from the file's namespace.");
            detectedLabel.setStyle("");
        } else if (detectedVersion == versionCombo.getValue()) {
            detectedLabel.setText("The file declares OCX " + detectedVersion.getDisplayName() + ".");
            detectedLabel.setStyle("");
        } else {
            detectedLabel.setText("The file declares OCX " + detectedVersion.getDisplayName()
                    + " but will be validated against " + versionCombo.getValue().getDisplayName() + ".");
            detectedLabel.setStyle("-fx-text-fill: -color-warning-fg");
        }
    }

    private void runValidation() {
        final var file = selectedFile;
        final var version = versionCombo.getValue();
        if (file == null || version == null) {
            return;
        }

        table.getItems().clear();
        setRunning(true);

        // binding progress (in same JavaFX thread)
        final var validator = new SchemaValidator(file, version);
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(validator.progressProperty());
        summaryLabel.textProperty().bind(validator.statusProperty());
        summaryLabel.setStyle("");

        new Thread(() -> {
            try {
                var issues = validator.validate();
                Platform.runLater(() -> showResults(version, issues));
            } catch (Throwable exp) {
                LOG.error("schema validation of {} failed", file, exp);
                Platform.runLater(() -> showFailure(exp));
            } finally {
                Platform.runLater(() -> setRunning(false));
            }
        }, "SchemaCheckValidation").start();
    }

    private void showResults(OCXSchemaVersion version, List<SchemaValidationIssue> issues) {
        summaryLabel.textProperty().unbind();
        table.getItems().setAll(issues);

        long errors = issues.stream()
                .filter(i -> i.severity() != SchemaValidationIssue.Severity.WARNING)
                .count();
        long warnings = issues.size() - errors;

        if (errors == 0) {
            var text = "The file is valid against OCX " + version.getDisplayName()
                    + (warnings > 0 ? " (" + warnings + " warnings)" : "");
            summaryLabel.setText(text);
            summaryLabel.setStyle("-fx-text-fill: -color-success-fg");
            if (issues.isEmpty()) {
                table.setPlaceholder(new Label("No findings - " + text));
            }
            LOG.info("{} is valid against OCX {}", selectedFile.getName(), version.getDisplayName());
        } else {
            var text = "The file is NOT valid against OCX " + version.getDisplayName()
                    + ": " + errors + " errors, " + warnings + " warnings";
            summaryLabel.setText(text);
            summaryLabel.setStyle("-fx-text-fill: -color-danger-fg");
            LOG.warn("{} is not valid against OCX {}: {} errors, {} warnings",
                    selectedFile.getName(), version.getDisplayName(), errors, warnings);
        }
    }

    private void showFailure(Throwable exp) {
        summaryLabel.textProperty().unbind();
        var cause = exp.getMessage() != null ? exp.getMessage() : exp.getClass().getSimpleName();
        summaryLabel.setText("Validation failed: " + cause);
        summaryLabel.setStyle("-fx-text-fill: -color-danger-fg");
    }

    private void setRunning(boolean running) {
        progressBar.setVisible(running);
        validateButton.setDisable(running || selectedFile == null);
        browseButton.setDisable(running);
        versionCombo.setDisable(running);
    }
}
