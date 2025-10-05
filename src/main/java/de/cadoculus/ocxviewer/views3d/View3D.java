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

