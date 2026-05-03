package de.cadoculus.ocxviewer.views;

import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.layout.Pane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubSceneResizer extends Pane {
    private static final Logger LOG = LogManager.getLogger(AbstractDataViewSubPage.class);
    private final SubScene subScene;

    public SubSceneResizer(SubScene subScene) {
        this.subScene = subScene;
        setPrefSize(subScene.getWidth(),subScene.getHeight());
        setMinSize(0,0);
        setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        getChildren().addAll(subScene);
    }

    @Override protected void layoutChildren() {

        LOG.info("layoutChildren called, width {}, height {}", getWidth(), getHeight());
        final double width = getWidth();
        final double height = getHeight();
        if (subScene!=null) {
            subScene.setWidth(width);
            subScene.setHeight(height);
        }

    }

}
