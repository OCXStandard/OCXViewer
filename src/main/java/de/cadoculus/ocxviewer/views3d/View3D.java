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
package de.cadoculus.ocxviewer.views3d;

import javafx.scene.SubScene;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class View3D {

    private final SubScene subScene;
    private final Box box;
    private final Camera camera;


    public View3D(Stage stage) {
    box = new Box(70, 50, 20);

    Group group = new Group(box);

    subScene = new SubScene(group, 300, 300, true, SceneAntialiasing.BALANCED);
    subScene.widthProperty().bind(stage.getScene().widthProperty());
    subScene.heightProperty().bind(stage.getScene().heightProperty());

    subScene.setFill(Color.rgb(80, 80, 80));
    camera = new PerspectiveCamera();
    subScene.setCamera(camera);

    box.translateXProperty().bind(subScene.widthProperty().divide(2));
    box.translateYProperty().bind(subScene.heightProperty().divide(2));

    PhongMaterial material = new PhongMaterial();
    Image i = new Image(getClass().getResourceAsStream("blue_checker.png"));
    material.setDiffuseMap(i);
    material.setSpecularColor(Color.YELLOW);
    box.setMaterial(material);
}

public SubScene getSubScene() {
    return subScene;
}

public Box getBox() {
    return box;
}

public Camera getCamera() {
    return camera;
}
}

