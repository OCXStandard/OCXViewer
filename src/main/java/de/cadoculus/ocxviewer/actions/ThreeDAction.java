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

import de.cadoculus.ocxviewer.views3d.Controller3D;
import de.cadoculus.ocxviewer.views3d.View2D;
import de.cadoculus.ocxviewer.views3d.View3D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A temporary action to start an OpenGL window
 */
public class ThreeDAction extends AbstractAction {

    public static final KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.CONTROL_DOWN);
    public static final String NAME = "3D View";
    private static final Logger LOG = LogManager.getLogger(ThreeDAction.class);

    @Override
    public void run() {
        LOG.info("3D View");

        var stage = new javafx.stage.Stage();
        stage.setTitle("3D View");
        var  root = new StackPane();
        var scene = new javafx.scene.Scene(root, 400,600);
        stage.setScene(scene);


        View2D v = new View2D();
        View3D v3d = new View3D(stage);

        root.getChildren().addAll(v3d.getSubScene(), v);

        new Controller3D(v3d, v, stage);


        stage.setScene(scene);
        stage.show();
    }
}
