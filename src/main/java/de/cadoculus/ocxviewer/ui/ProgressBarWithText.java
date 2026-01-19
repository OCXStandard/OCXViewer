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
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

/**
 * A ProgressBar with a text label showing the progress in percent.
 * Build from a stackpane containing a ProgressBar and a Label.
 *
 * @author Carsten Zerbst
 */
public class ProgressBarWithText extends StackPane  {

    private final ProgressBar progressBar;
    private final Label labeledProgressIndicator;
    private final DoubleProperty progress = new SimpleDoubleProperty();
    private final String formatString = "%.0f %%";

    /**
     * Creates a new ProgressBarWithText instance.
     */
    public ProgressBarWithText() {
        this.progressBar = new ProgressBar(0);
        progressBar.getStyleClass().add(Styles.LARGE);
        this.labeledProgressIndicator = new Label();
        this.getChildren().addAll(progressBar, labeledProgressIndicator);

        progressBar.progressProperty().bind(progress);
        progress.addListener((obs, oldVal, newVal) -> {
            double progressValue = newVal.doubleValue() * 100.0;
            labeledProgressIndicator.setText(String.format(formatString, progressValue));
        });
    }

    /**
     * Returns the progress property.
     * The given value must be between 0.0 and 1.0.
     * @return the progress property
     */
    public DoubleProperty progressProperty() {
        return progress;
    }

}
