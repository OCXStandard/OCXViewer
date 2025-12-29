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

import javafx.beans.binding.Bindings;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Controller3D {
    private Point2D oldPos;

    public Controller3D(View3D v3d, View2D v2d, Stage stage) {
        Rotate rX = new Rotate(0, Rotate.X_AXIS);
        Rotate rY = new Rotate(0, Rotate.Y_AXIS);

        v3d.getBox().getTransforms().addAll(rX, rY);

        stage.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            oldPos = new Point2D(event.getSceneX(), event.getSceneY());
        });

        stage.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            double newAngleX = rX.getAngle() - (oldPos.getY() - event.getSceneY());
            rX.setAngle(newAngleX > 90 ? 90 : newAngleX < -90 ? -90 : newAngleX);
            rY.setAngle(rY.getAngle() + oldPos.getX() - event.getSceneX());
            oldPos = new Point2D(event.getSceneX(), event.getSceneY());
        });

        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
            double delta = event.getDeltaY();
            v3d.getCamera().setTranslateZ(v3d.getCamera().getTranslateZ() - delta * 0.5);
        });

        v2d.getLblRotX().textProperty().bind(Bindings.concat("Rotation X: ", rX.angleProperty().asString()));
        v2d.getLblRotY().textProperty().bind(Bindings.concat("Rotation Y: ", rY.angleProperty().asString()));
        v2d.getLblZoom().textProperty().bind(Bindings.concat("Z: ", v3d.getCamera().translateZProperty().asString()));
    }

}

