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

import de.cadoculus.ocxviewer.BuildVersion;
import de.cadoculus.ocxviewer.OCXViewerApplication;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;

/**
 * The Navigate Back action. This action is only used to register the keyboard shortcut for navigating back in the page history.
 * The actual navigation is handled by the {@link de.cadoculus.ocxviewer.MainController} class.
 *
 * @author Carsten Zerbst
 */
public class NavigateBackAction extends AbstractAction {

    public final static KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.LEFT, KeyCombination.ALT_DOWN);

    public final static String NAME = "Navigate Back";

    @Override
    public void run() {

    }
}
