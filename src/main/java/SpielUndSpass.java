package de.cadoculus.ocxviewer;

import de.cadoculus.ocxviewer.views.SubSceneResizer;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpielUndSpass extends Application {

    private Group axisGroup;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane container = new BorderPane();
        container.setTop(new Label("Hello World"));

        var group = createWorld();


        SubScene subScene = new SubScene(group, 300, 300, true, SceneAntialiasing.BALANCED);


        var camera = new PerspectiveCamera(true);
        camera.setNearClip(1.0);
        camera.setFarClip(250000.0);
        var cameraGroup = new Group();

        group.getChildren().add(cameraGroup);

        SubSceneResizer subSceneResizer = new SubSceneResizer(subScene);
        container.setCenter(subSceneResizer);


        RotateTransition rotateTransition = new RotateTransition();

        //Setting the duration for the transition
        rotateTransition.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        rotateTransition.setNode(cameraGroup);

        //Setting the angle of the rotation
        rotateTransition.setByAngle(360);

        //Setting the cycle count for the transition
        rotateTransition.setCycleCount(50);

        //Setting auto reverse value to false
        rotateTransition.setAutoReverse(false);

        //Playing the animation
        rotateTransition.play();

        var scene = new Scene(container, 300, 300, true, SceneAntialiasing.BALANCED);
        primaryStage.setTitle("spiel und spass");
        primaryStage.setScene(scene);
        primaryStage.show();




    }

    private Group createWorld() {
        var root = new Group(); // y down, z forward, x right
        var world = new Group();
        world.setRotationAxis(new Point3D(1,0,0));
        world.setRotate(90);
        root.getChildren().add(world);
        var coosys1 = new Group();
        world.getChildren().add(coosys1);


        final Box xAxis = new Box(120, 2, 2);
        xAxis.setTranslateX(60.0);
        final Box yAxis = new Box(2, 120, 2);
        yAxis.setTranslateY(60.0);
        final Box zAxis = new Box(2, 2, 120);
        zAxis.setTranslateZ(60.0);

        xAxis.setMaterial(new PhongMaterial(Color.RED));
        yAxis.setMaterial(new PhongMaterial(Color.GREEN));
        zAxis.setMaterial(new PhongMaterial(Color.BLUE));

        axisGroup = new Group();
        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        world.getChildren().add(axisGroup);


        return root;
    }
}
