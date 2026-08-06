/*
 * Copyright 2026 PROSTEP AG
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
import de.cadoculus.ocxviewer.io.SchematronIssue;
import de.cadoculus.ocxviewer.io.SchematronValidator;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;

import java.io.File;
import java.util.List;

/**
 * Dialogue to pick an OCX file and a Schematron rules file, run the Schematron
 * validation and list the findings. Shown inside the main window, mirroring
 * {@link SchemaCheckDialogue}.
 */
public class SchematronCheckDialogue {

    private static final Logger LOG = LogManager.getLogger(SchematronCheckDialogue.class);

    private final BorderPane root = new BorderPane();
    private final TextField ocxField = new TextField();
    private final Button ocxBrowseButton = new Button("Select File ...");
    private final TextField rulesField = new TextField();
    private final Button rulesBrowseButton = new Button("Select Rules ...");
    private final Button validateButton = new Button("Validate");
    private final TableView<SchematronIssue> table = new TableView<>();
    private final Label summaryLabel = new Label();
    private final ProgressBarWithText progressBar = new ProgressBarWithText();

    private File selectedOcxFile;
    private File selectedRulesFile;

    public SchematronCheckDialogue() {

        root.getStyleClass().add("content-pane");
        root.setPadding(new Insets(15));

        var title = new Label("Schematron Check");
        title.getStyleClass().add(Styles.TITLE_2);
        var description = BBCodeParser.createFormattedText(
                "Runs a Schematron rules file (.sch) against the raw XML of an OCX file and "
                        + "lists all violations. The OCX namespace is version specific, "
                        + "so a rules file only matches files of the version it targets.");

        ocxField.setEditable(false);
        ocxField.setPromptText("Select an OCX file to validate ...");
        ocxField.setMaxWidth(Double.MAX_VALUE);
        ocxBrowseButton.setOnAction(e -> chooseOcxFile());

        rulesField.setEditable(false);
        rulesField.setPromptText("Select a Schematron (.sch) rules file ...");
        rulesField.setMaxWidth(Double.MAX_VALUE);
        rulesBrowseButton.setOnAction(e -> chooseRulesFile());

        validateButton.getStyleClass().add(Styles.ACCENT);
        validateButton.setDisable(true);
        validateButton.setOnAction(e -> runValidation());

        var grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);
        grid.add(new Label("OCX file:"), 0, 0);
        grid.add(ocxField, 1, 0);
        grid.add(ocxBrowseButton, 2, 0);
        grid.add(new Label("Rules file:"), 0, 1);
        grid.add(rulesField, 1, 1);
        grid.add(rulesBrowseButton, 2, 1);
        grid.add(validateButton, 3, 1);
        GridPane.setHgrow(ocxField, Priority.ALWAYS);
        GridPane.setHgrow(rulesField, Priority.ALWAYS);

        var titleBox = new VBox(5, title, description, grid);
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
            setOcxFile(currentFile);
        }
        // preselect the last used rules file, if available
        var rulesFile = WorkingContext.getInstance().getSchematronFile();
        if (rulesFile != null && rulesFile.canRead()) {
            setRulesFile(rulesFile.getAbsoluteFile());
        }
    }

    public void show() {
        WorkingContext.getInstance().getMainController().showFullWindowPane(root);
    }

    private void close() {
        WorkingContext.getInstance().getMainController().restoreMainView();
    }

    private void buildTable() {

        var severityCol = new TableColumn<SchematronIssue, SchematronIssue.Severity>("Severity");
        severityCol.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().severity()));
        severityCol.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(SchematronIssue.Severity item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.name());
                    switch (item) {
                        case WARNING -> setGraphic(new FontIcon(MaterialDesignE.EXCLAMATION_THICK));
                        case INFO -> setGraphic(new FontIcon(MaterialDesignI.INFORMATION_OUTLINE));
                        default -> setGraphic(new FontIcon(MaterialDesignF.FLASH));
                    }
                }
            }
        });
        severityCol.setPrefWidth(80);
        severityCol.setMaxWidth(110);

        var locationCol = new TableColumn<SchematronIssue, String>("Location");
        locationCol.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().location()));
        locationCol.setCellFactory(col -> new TableCell<>() {
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
        locationCol.setPrefWidth(190);
        locationCol.setMaxWidth(350);

        var messageCol = new TableColumn<SchematronIssue, String>("Message");
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
                    var issue = getTableRow() == null ? null : getTableRow().getItem();
                    var tip = item;
                    if (issue != null && issue.test() != null && !issue.test().isBlank()) {
                        tip = item + "\n\nTest: " + issue.test();
                    }
                    var tooltip = new Tooltip(tip);
                    tooltip.setWrapText(true);
                    tooltip.setMaxWidth(600);
                    setTooltip(tooltip);
                }
            }
        });

        table.getColumns().addAll(List.of(severityCol, locationCol, messageCol));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.setPlaceholder(new Label("No validation results"));

        table.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(SchematronIssue item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setStyle("");
                } else if (item.severity() == SchematronIssue.Severity.WARNING
                        || item.severity() == SchematronIssue.Severity.INFO) {
                    setStyle(getIndex() % 2 == 0
                            ? "-fx-background-color: -color-warning-0"
                            : "-fx-background-color: -color-warning-1");
                } else {
                    setStyle(getIndex() % 2 == 0
                            ? "-fx-background-color: -color-danger-0"
                            : "-fx-background-color: -color-danger-1");
                }
            }
        });
    }

    private void chooseOcxFile() {
        var fileChooser = new FileChooser();
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
            warn("The selected file is not readable or does not exist.");
            return;
        }
        // remember the directory so the next chooser (here or File > Open) starts here
        WorkingContext.getInstance().rememberLastOpenDir(file);
        setOcxFile(file);
    }

    private void chooseRulesFile() {
        var fileChooser = new FileChooser();
        fileChooser.setTitle("Select Schematron Rules File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Schematron Rules", "*.sch"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        var initialDir = selectedRulesFile != null && selectedRulesFile.getParentFile() != null
                ? selectedRulesFile.getParentFile()
                : new File(WorkingContext.getInstance().getLastOpenDir());
        fileChooser.setInitialDirectory(initialDir);

        var file = fileChooser.showOpenDialog(WorkingContext.getInstance().getMainScene().getWindow());
        if (file == null) {
            return;
        }
        if (!(file.exists() && file.canRead())) {
            warn("The selected rules file is not readable or does not exist.");
            return;
        }
        setRulesFile(file);
    }

    private void setOcxFile(File file) {
        selectedOcxFile = file;
        ocxField.setText(file.getAbsolutePath());
        updateValidateButton();
    }

    private void setRulesFile(File file) {
        selectedRulesFile = file;
        rulesField.setText(file.getAbsolutePath());
        // remember the choice so it is preselected next time (mirrors WorkingContext.setOCXFile)
        WorkingContext.getInstance().setSchematronFile(file);
        updateValidateButton();
    }

    private void updateValidateButton() {
        validateButton.setDisable(selectedOcxFile == null || selectedRulesFile == null);
    }

    private void warn(String message) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Schematron Check");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void runValidation() {
        final var ocx = selectedOcxFile;
        final var rules = selectedRulesFile;
        if (ocx == null || rules == null) {
            return;
        }

        table.getItems().clear();
        setRunning(true);

        // bind progress and status on the FX thread before starting the worker
        final var validator = new SchematronValidator(ocx, rules);
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(validator.progressProperty());
        summaryLabel.textProperty().bind(validator.statusProperty());
        summaryLabel.setStyle("");

        new Thread(() -> {
            try {
                var issues = validator.validate();
                Platform.runLater(() -> showResults(issues, validator.getFiredRuleCount()));
            } catch (Throwable exp) {
                LOG.error("schematron validation of {} with {} failed", ocx, rules, exp);
                Platform.runLater(() -> showFailure(exp));
            } finally {
                Platform.runLater(() -> setRunning(false));
            }
        }, "SchematronCheckValidation").start();
    }

    private void showResults(List<SchematronIssue> issues, int firedRuleCount) {
        summaryLabel.textProperty().unbind();
        table.getItems().setAll(issues);

        long errors = issues.stream()
                .filter(i -> i.severity() == SchematronIssue.Severity.ERROR
                        || i.severity() == SchematronIssue.Severity.FATAL)
                .count();
        long warnings = issues.size() - errors;

        if (firedRuleCount == 0) {
            var text = "No Schematron rule matched the document - check that the rules file "
                    + "targets the file's OCX namespace/version.";
            summaryLabel.setText(text);
            summaryLabel.setStyle("-fx-text-fill: -color-warning-fg");
            table.setPlaceholder(new Label(text));
            LOG.warn("no Schematron rule fired for {} with {}",
                    selectedOcxFile.getName(), selectedRulesFile.getName());
        } else if (errors == 0) {
            var text = "No Schematron violations found (" + firedRuleCount + " rules fired)"
                    + (warnings > 0 ? " - " + warnings + " warnings" : "");
            summaryLabel.setText(text);
            summaryLabel.setStyle("-fx-text-fill: -color-success-fg");
            if (issues.isEmpty()) {
                table.setPlaceholder(new Label("No findings - " + text));
            }
            LOG.info("{} passed the Schematron check ({} rules fired)",
                    selectedOcxFile.getName(), firedRuleCount);
        } else {
            var text = issues.size() + " violations: " + errors + " errors, " + warnings + " warnings";
            summaryLabel.setText(text);
            summaryLabel.setStyle("-fx-text-fill: -color-danger-fg");
            LOG.warn("{} failed the Schematron check: {} errors, {} warnings",
                    selectedOcxFile.getName(), errors, warnings);
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
        ocxBrowseButton.setDisable(running);
        rulesBrowseButton.setDisable(running);
        validateButton.setDisable(running || selectedOcxFile == null || selectedRulesFile == null);
    }
}
