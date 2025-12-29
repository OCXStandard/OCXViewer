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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class View2D extends BorderPane {

    private final Label lblRotX = new Label("Rotation X:");
    private final Label lblRotY = new Label("Rotation Y:");
    private final Label lblZoom = new Label("Z: 0");

    public View2D() {
        VBox left = new VBox();
        left.setAlignment(Pos.CENTER);
        left.setPadding(new Insets(10));
        left.setSpacing(10);
        left.getChildren().addAll(new Button("Button 1"), new Button("Button 2"), new Button("Button 3"));

        setLeft(left);

        VBox right = new VBox();
        right.setAlignment(Pos.CENTER_LEFT);
        right.setPadding(new Insets(10));
        right.setSpacing(10);
        Label lblCamera = new Label("Camera: ");
        VBox.setMargin(lblCamera, new Insets(50, 0, 0, 0));
        right.getChildren().addAll(new Label("Box: "), lblRotX, lblRotY, lblCamera, lblZoom);
        setRight(right);
    }

    public Label getLblRotX() {
        return lblRotX;
    }

    public Label getLblRotY() {
        return lblRotY;
    }

    public Label getLblZoom() {
        return lblZoom;
    }

}



