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

public class ThreeDAction {

    public static final KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN);
    public static final String NAME = "3D View";
    private static final Logger LOG = LogManager.getLogger(ThreeDAction.class);

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
