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

import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;

/**
 * The About action
 * @author Carsten Zerbst
 */
public class AboutAction extends  AbstractAction {

    public final static KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN);
    public final static  String NAME = "About";

    //TODO: implement showing a dialogue with version information
    @Override
    public void run() {
        var infoBtn = new Button("Info", new FontIcon(MaterialDesignI.INBOX));
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("TODO: add version from POM and GIT");
            alert.initOwner(WorkingContext.getInstance().getMainScene().getWindow());
            alert.showAndWait();

    }
}
