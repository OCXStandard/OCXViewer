/*
 * Copyright 2025 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cadoculus.ocxviewer.views;

import atlantafx.base.layout.InputGroup;
import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.models.ViewDirections;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;
import org.kordamp.ikonli.materialdesign2.MaterialDesignM;
import org.ocx_schema.v310.QuantityT;

/**
 * This class displays the coordinated system contained in the OCX file
 *
 * @author Carsten Zerbst
 */
public class CoordinateSystem3DViewPage extends AbstractDataViewSubPage<org.ocx_schema.v310.CoordinateSystem> implements Page {
    public static final String NAME = "Coordinate System";
    private static final Logger LOG = LogManager.getLogger(CoordinateSystem3DViewPage.class);
    private final Controller3D controller;


    public CoordinateSystem3DViewPage(org.ocx_schema.v310.CoordinateSystem coosys, Page parent) {
        super(coosys, parent, "3D View of Coordinate System «" + coosys.getId() + "»");

        final var bcs = getBreadcrumbs();
        createTitle(bcs, getName(), "3D view of the coordinate system.");

//        VBox vBox = new VBox();
//        this.setCenter(vBox);
//        vBox.prefWidthProperty().bind(this.widthProperty());
//        vBox.prefHeightProperty().bind(this.heightProperty());

        var box = new Box(70, 50, 20);

        var group3D = new Group(box);

        BorderPane container = new BorderPane();
        this.setCenter(container);
        SubScene subScene = new SubScene(group3D, 300, 300, true, SceneAntialiasing.BALANCED);

        SubSceneResizer subSceneResizer = new SubSceneResizer(subScene);
        container.setCenter(subSceneResizer);

        var camera = new PerspectiveCamera();
        subScene.setCamera(camera);

        controller =   new Controller3D(group3D, camera, container);

        final ToolBar toolbar = new ToolBar();
        toolbar.setMaxWidth( Double.MAX_VALUE );
        toolbar.setMinWidth( 200 );

        // ToolBar-Höhe festlegen
        toolbar.setMinHeight(40);
        toolbar.setPrefHeight(40);
        toolbar.setMaxHeight(40);
        VBox.setVgrow(toolbar, Priority.NEVER);
        VBox.setVgrow(container, Priority.ALWAYS);

        var zoomAll = new Button( "", new FontIcon(MaterialDesignM.MAGNIFY_SCAN));
        zoomAll.setTooltip(new Tooltip("Zoom out"));
        zoomAll.setOnAction(e -> { controller.zoomAll(); });
        toolbar.getItems().add(zoomAll);

        var zoomIn = new Button( "", new FontIcon(MaterialDesignM.MAGNIFY_PLUS_OUTLINE));
        zoomIn.setTooltip(new Tooltip("Zoom in"));
        zoomIn.setOnAction(e -> { controller.zoomIn(); });
        toolbar.getItems().add(zoomIn);

        var zoomOut = new Button( "", new FontIcon(MaterialDesignM.MAGNIFY_MINUS_OUTLINE));
        zoomOut.setTooltip(new Tooltip("Zoom out"));
        zoomOut.setOnAction(e -> { controller.zoomOut(); });
        toolbar.getItems().add(zoomOut);

        // Views-Menü als MenuButton in der ToolBar
        var viewsMenuButton = new MenuButton("Views");
        for (ViewDirections viewDirections : ViewDirections.values()) {
            var viewItem = new MenuItem(viewDirections.getName());
            viewItem.setOnAction(e -> { controller.setViewDirection(viewDirections); });
            viewsMenuButton.getItems().add(viewItem);
        }
        toolbar.getItems().add(viewsMenuButton);
        container.setBottom(toolbar);





    }




    @Override
    public void afterShow() {

        // Party !
        // table.getSelectionModel().selectFirst();
    }


}
