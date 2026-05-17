/*
Copyright 2026 Carsten Zerbst

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

package de.cadoculus.ocxviewer.views;

import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.InformationProvider;
import de.cadoculus.ocxviewer.views.threed.Plane3D;
import de.cadoculus.ocxviewer.utils.CSSUtil;
import de.cadoculus.ocxviewer.geom.GeomHelper;
import de.cadoculus.ocxviewer.geom.MainPlane;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.*;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fxyz3d.scene.Skybox;
import org.fxyz3d.shapes.primitives.Text3DMesh;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignM;

import javax.vecmath.Vector3d;
import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCombination.*;

/**
 * The ThreeDView offers a simple widget to show three-dimensional content using JavaFX's capability.
 *
 */
class ThreeDView extends BorderPane {

    private static final Logger LOG = LogManager.getLogger(ThreeDView.class);
    private static final double ZOOM_STEP = 0.5;
    private static final double PAN_STEP = 0.1;
    private static final double ROTATE_STEP = 0.2;
    private static final double ZOOM_ALL_MARGIN = 1.05;
    private static final double ZOOM_ALL_DEBOUNCE_MS = 80;
    private static final double ZOOM_CURSOR_RESET_MS = 180;
    private static final double ZOOM_CURSOR_DELTA_THRESHOLD = 1.0;
    private static final double KEYBOARD_ZOOM_DELTA = 8.0;
    private static final double KEYBOARD_PAN_DELTA = 25.0;
    private static final double KEYBOARD_ROTATIONS_STEP_DEG = 30.0;
    private static final Point3D WORLD_UP = new Point3D(0, 0, 1);
    private static final double MAX_PITCH_DEG = 85.0;
    private static final double MIN_CAMERA_PIVOT_DISTANCE = 1e-3;
    private static final double BILLBOARD_SCALE = 0.01;
    private static final KeyCodeCombination CTRL_PLUS = new KeyCodeCombination(KeyCode.PLUS, CONTROL_DOWN);
    private static final KeyCodeCombination CTRL_ADD = new KeyCodeCombination(KeyCode.ADD, CONTROL_DOWN);
    private static final KeyCodeCombination CTRL_EQUALS = new KeyCodeCombination(KeyCode.EQUALS, CONTROL_DOWN);
    private static final KeyCodeCombination CTRL_MINUS = new KeyCodeCombination(KeyCode.MINUS, CONTROL_DOWN);
    private static final KeyCodeCombination CTRL_SUBTRACT = new KeyCodeCombination(KeyCode.SUBTRACT, CONTROL_DOWN);
    private Point3D pivotPoint = new Point3D(0, 0, 0);
    private double panStartMouseX;
    private double panStartMouseY;
    private double rotateStartMouseX;
    private double rotateStartMouseY;
    private Affine rotateStartCameraAffine;
    private boolean primaryDragActive;
    private boolean middlePanActive;
    private InformationProvider selectedProvider;
    private VBox infoPaneContainer;
    private FadeTransition infoPaneFadeOut;
    private PerspectiveCamera camera;
    private Group world;
    private SubScene subScene;
    private SubScene cornerOverlaySubScene;
    private Affine cornerCameraAffine;
    private PauseTransition zoomAllDebounce;
    private PauseTransition zoomCursorReset;
    private Cursor zoomInCursor;
    private Cursor zoomOutCursor;
    private boolean zoomCursorActive;
    private Label pickCoordinateLabel;
    private Group skyboxNode;
    private FontIcon skyboxToggleIcon;
    private ToolBar bottomBar; // Make bottomBar accessible for adding/removing buttons
    private final java.util.ArrayList<Affine> billboardAffines = new java.util.ArrayList<>();
    private Color lineColour = Color.DARKSLATEGREY;
    private Color textColour = Color.BLACK;
    private double csMinX, csMaxX, csBreadth, csHeight;
    private boolean csInitialized = false;
    private MainPlane currentGridPlane = MainPlane.UNDEFINED;
    private final java.util.ArrayList<Affine> csBillboardAffines = new java.util.ArrayList<>();

    public ThreeDView() {
        updatedStyle();
        createContent();
    }


    /**
     * Updates the parameters used in the canvas from CSS.
     */
    private void updatedStyle() {
        try {
            CSSRecord cssRecord = CSSUtil.lookup("threeDView");
            lineColour = cssRecord.colour1() != null ? cssRecord.colour1() : lineColour;
            textColour = cssRecord.colour2() != null ? cssRecord.colour2() : textColour;

        } catch (Exception exp) {
            LOG.warn("failed to update style from CSS, use default values", exp);
        }
    }

    /**
     * Calculates the 3D bounding box of all content in the {@code world} group,
     * expressed in the coordinate system of the {@code world} group.
     *
     * @return BoundingBox in world coordinates, or {@code null} if no valid content is present
     */
    private Bounds calculateWorldBounds3D() {
        if (world == null || world.getChildren().isEmpty()) {
            return null;
        }

        double minX = Double.POSITIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double minZ = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        double maxZ = Double.NEGATIVE_INFINITY;

        for (Node child : world.getChildren()) {
            if (child == null || !child.isVisible()) {
                continue;
            }
            Bounds b = child.getBoundsInParent();
            if (b == null || b.isEmpty()) {
                continue;
            }
            if (!Double.isFinite(b.getMinX()) || !Double.isFinite(b.getMinY()) || !Double.isFinite(b.getMinZ())
                    || !Double.isFinite(b.getMaxX()) || !Double.isFinite(b.getMaxY()) || !Double.isFinite(b.getMaxZ())) {
                continue;
            }

            minX = Math.min(minX, b.getMinX());
            minY = Math.min(minY, b.getMinY());
            minZ = Math.min(minZ, b.getMinZ());
            maxX = Math.max(maxX, b.getMaxX());
            maxY = Math.max(maxY, b.getMaxY());
            maxZ = Math.max(maxZ, b.getMaxZ());
        }

        if (!Double.isFinite(minX)) {
            return null;
        }

        return new BoundingBox(minX, minY, minZ, maxX - minX, maxY - minY, maxZ - minZ);
    }

    /**
     * Adds one or more groups to the world node.
     *
     * @param groups groups to add (ignored when {@code null})
     */
    public void addGroupToWorld(Group... groups) {
        if (groups == null || world == null) {
            return;
        }
        world.getChildren().addAll(groups);
    }

    /**
     * Sets the camera view so the camera looks at {@code lookAtPoint} from
     * {@code viewDirection} with the given {@code distance}.
     *
     * @param lookAtPoint   world-space point to look at
     * @param viewDirection forward direction (camera -> look-at)
     * @param distance      distance from camera position to look-at point
     */
    public void setView(Point3D lookAtPoint, Point3D viewDirection, double distance) {
        if (lookAtPoint == null || !isFinite(lookAtPoint)) {
            LOG.warn("Ignoring setView(): lookAtPoint is null or non-finite: {}", lookAtPoint);
            return;
        }

        Point3D forward = normalize(viewDirection == null ? Point3D.ZERO : viewDirection);
        if (forward.magnitude() < 1e-9) {
            forward = getCurrentForwardDirection();
        }

        if (!Double.isFinite(distance) || distance < MIN_CAMERA_PIVOT_DISTANCE) {
            distance = 200.0;
        }

        Point3D upRef = WORLD_UP;
        if (Math.abs(forward.dotProduct(upRef)) > 0.995) {
            upRef = new Point3D(1, 0, 0);
        }

        Point3D right = normalize(upRef.crossProduct(forward));
        if (right.magnitude() < 1e-9) {
            right = normalize(new Point3D(0, 1, 0).crossProduct(forward));
        }
        if (right.magnitude() < 1e-9) {
            LOG.warn("Ignoring setView(): could not derive a stable right axis for direction {}", forward);
            return;
        }

        Point3D up = normalize(forward.crossProduct(right));
        Point3D cameraPos = lookAtPoint.subtract(forward.multiply(distance));

        Affine next = new Affine(
                right.getX(), up.getX(), forward.getX(), cameraPos.getX(),
                right.getY(), up.getY(), forward.getY(), cameraPos.getY(),
                right.getZ(), up.getZ(), forward.getZ(), cameraPos.getZ()
        );

        pivotPoint = lookAtPoint;
        // Adapt clip planes to the view distance so near geometry is never cut
        camera.setNearClip(Math.max(0.001, distance * 0.001));
        camera.setFarClip(Math.max(500_000, distance * 1000));
        setCameraAffine(next);
    }

    /**
     * Convenience overload for vecmath callers.
     */
    public void setView(javax.vecmath.Point3d lookAtPoint, Vector3d viewDirection, double distance) {
        if (lookAtPoint == null || viewDirection == null) {
            LOG.warn("Ignoring setView(): lookAtPoint or viewDirection is null");
            return;
        }
        setView(
                new Point3D(lookAtPoint.x, lookAtPoint.y, lookAtPoint.z),
                new Point3D(viewDirection.x, viewDirection.y, viewDirection.z),
                distance
        );
    }


    private void createContent() {

        var root = new Group();
        root.setId("root");
        root.setDepthTest(DepthTest.ENABLE);

        world = new Group();
        world.setId("world");
        world.setDepthTest(DepthTest.ENABLE);

        root.getChildren().add(world);

        // Create and position camera
        camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(500_000);

        var affine = new Affine();
        affine.append(new Translate(75, -200, 0));
        var rotateZUp = new Rotate(-90, Rotate.X_AXIS);
        affine.append(rotateZUp);

        camera.getTransforms().addAll(affine);

        //        LOG.info("Camera initial transforms: {}",
        //                camera.getTransforms());
        //        LOG.info("view {}", camera.getLocalToSceneTransform());
        //
        //        LOG.info("bbox {}", world.getBoundsInParent());
        //        LOG.info("bbox' {}", camera.sceneToLocal(world.getBoundsInParent()));


        root.getChildren().add(camera);

        // Skybox – a box with inward-facing texture
        // TODO: configure from CSS
        var top = new Image(getClass().getResourceAsStream("top.png"));
        var right = new Image(getClass().getResourceAsStream("left.png"));
        var back = new Image(getClass().getResourceAsStream("fwd.png"));
        var left = new Image(getClass().getResourceAsStream("right.png"));
        var fwd = new Image(getClass().getResourceAsStream("back.png"));
        var bot = new Image(getClass().getResourceAsStream("bot.png"));

        skyboxNode = new Skybox(top, bot, left, right, fwd, back, 3000, camera);
        var rsbx = new Rotate(-90, Rotate.X_AXIS);
        skyboxNode.getTransforms().add(rsbx);
        var rsbz = new Rotate(-90, Rotate.Y_AXIS);
        skyboxNode.getTransforms().add(rsbz);

        root.getChildren().add(skyboxNode);

        // Create info pane overlay
        infoPaneContainer = new VBox(8);
        infoPaneContainer.setId("infoPaneContainer");
        infoPaneContainer.setMinWidth(200);
        infoPaneContainer.setPrefWidth(200);
        infoPaneContainer.setMaxWidth(200);
        infoPaneContainer.setMinHeight(VBox.USE_PREF_SIZE);
        infoPaneContainer.setMaxHeight(VBox.USE_PREF_SIZE);
        infoPaneContainer.setStyle(
                "-fx-background-color: rgba(255,255,255,0.85);" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-color: rgba(200,200,200,0.5);" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-padding: 14px 16px 14px 16px;"
        );
        infoPaneContainer.setMouseTransparent(true);
        infoPaneContainer.setManaged(false);
        infoPaneContainer.setVisible(false);


        // Use a SubScene
        subScene = new SubScene(root, 300, 300, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.TRANSPARENT);
        subScene.setCamera(camera);
        subScene.setFocusTraversable(true);

        zoomInCursor = createIconCursor(MaterialDesignM.MAGNIFY_PLUS);
        zoomOutCursor = createIconCursor(MaterialDesignM.MAGNIFY_MINUS);
        zoomCursorReset = new PauseTransition(Duration.millis(ZOOM_CURSOR_RESET_MS));
        zoomCursorReset.setOnFinished(_ -> {
            zoomCursorActive = false;
            applyInteractionCursor();
        });

        zoomAllDebounce = new PauseTransition(Duration.millis(ZOOM_ALL_DEBOUNCE_MS));
        zoomAllDebounce.setOnFinished(_ -> zoomAll(world, 50));

        // now add all the event listeners used to control the 3D view
        subScene.setOnScroll(event -> {
            if (event.isControlDown()) {
                showZoomCursor(event.getDeltaY());
                zoom(event.getDeltaY());
                event.consume();
            }
        });
        subScene.setOnMousePressed(event -> {
            subScene.requestFocus();
            if (event.getButton() == MouseButton.PRIMARY) {
                rotateStartMouseX = event.getX();
                rotateStartMouseY = event.getY();
                var current = (Affine) camera.getTransforms().getFirst();
                rotateStartCameraAffine = new Affine(current);
                primaryDragActive = true;
                applyInteractionCursor();
                event.consume();
            } else if (event.getButton() == MouseButton.MIDDLE) {
                if (event.getClickCount() == 2 &&
                        event.getPickResult().getIntersectedNode() != null &&
                        event.getPickResult().getIntersectedPoint() != null) {
                    // 1) Point on the picked mesh
                    Point3D hitLocal = event.getPickResult().getIntersectedPoint();

                    // 2) -> Scene
                    Point3D hitScene = event.getPickResult().getIntersectedNode().localToScene(hitLocal);

                    // 3) -> World-Group coordinates
                    Point3D hitWorld = world.sceneToLocal(hitScene);


                    LOG.info("selected with MB2 {} : {}, {}, {}", event.getPickResult().getIntersectedNode(),
                            hitLocal, hitScene, hitWorld);
                    pivotPoint = hitWorld;
                    centerWorldPointInView(pivotPoint);
                    middlePanActive = false;
                } else {

                    panStartMouseX = event.getX();
                    panStartMouseY = event.getY();
                    middlePanActive = true;

                }
                applyInteractionCursor();
                event.consume();
            }
        });
        subScene.setOnMouseDragged(event -> {
            if (event.isPrimaryButtonDown()) {
                double dragDist = Math.hypot(event.getX() - rotateStartMouseX, event.getY() - rotateStartMouseY);
                if (dragDist > 2.0) {
                    primaryDragActive = true;
                }
                rotate(event.getX() - rotateStartMouseX, event.getY() - rotateStartMouseY);
                event.consume();
            } else if (event.isMiddleButtonDown() && middlePanActive) {
                double deltaX = event.getX() - panStartMouseX;
                double deltaY = event.getY() - panStartMouseY;
                pan(deltaX, deltaY);
                panStartMouseX = event.getX();
                panStartMouseY = event.getY();
                event.consume();
            }
        });
        subScene.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                primaryDragActive = false;
                applyInteractionCursor();
                event.consume();
            } else if (event.getButton() == MouseButton.MIDDLE) {
                middlePanActive = false;
                applyInteractionCursor();
                event.consume();
            }
        });
        subScene.setOnMouseMoved(event -> {
            if (!primaryDragActive) {
                pickProvider(event.getPickResult());
            }
            updatePickCoordinateLabel(event.getPickResult());
        });
        subScene.setOnMouseExited(_ -> {
            middlePanActive = false;
            primaryDragActive = false;
            zoomCursorActive = false;
            applyInteractionCursor();
            selectProvider(null);
        });

        subScene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.CONTROL) {
                if (zoomCursorReset != null) {
                    zoomCursorReset.stop();
                }
                zoomCursorActive = false;
                applyInteractionCursor();
            }
        });

        subScene.setOnKeyPressed(event -> {
            if (CTRL_PLUS.match(event) || CTRL_ADD.match(event) || CTRL_EQUALS.match(event)) {
                showZoomCursor(KEYBOARD_ZOOM_DELTA);
                zoom(KEYBOARD_ZOOM_DELTA);
                event.consume();
                return;
            }

            if (CTRL_MINUS.match(event) || CTRL_SUBTRACT.match(event)) {
                showZoomCursor(-KEYBOARD_ZOOM_DELTA);
                zoom(-KEYBOARD_ZOOM_DELTA);
                event.consume();
                return;
            }

            if (event.getCode() == KeyCode.LEFT) {
                pan(event.isControlDown() ? -0.1 * KEYBOARD_PAN_DELTA : -KEYBOARD_PAN_DELTA, 0);
                event.consume();
            }
            if (event.getCode() == KeyCode.RIGHT) {
                pan(event.isControlDown() ? 0.1 * KEYBOARD_PAN_DELTA : KEYBOARD_PAN_DELTA, 0);
                event.consume();
            }
            if (event.getCode() == KeyCode.UP) {
                pan(0, event.isControlDown() ? 0.1 * KEYBOARD_PAN_DELTA : KEYBOARD_PAN_DELTA);
                event.consume();
            }
            if (event.getCode() == KeyCode.DOWN) {
                pan(0, event.isControlDown() ? -0.1 * KEYBOARD_PAN_DELTA : -KEYBOARD_PAN_DELTA);
                event.consume();
            }

            if (event.getCode() == KeyCode.R) {
                var amount = KEYBOARD_ROTATIONS_STEP_DEG;
                amount *= event.isControlDown() ? 0.1 : 1;
                amount *= event.isShiftDown() ? -1 : 1;

                rotateAroundCurrentRightAxis(amount);
                event.consume();
                return;
            }
            if (event.getCode() == KeyCode.P) {
                var amount = KEYBOARD_ROTATIONS_STEP_DEG;
                amount *= event.isControlDown() ? 0.1 : 1;
                amount *= event.isShiftDown() ? -1 : 1;

                pitchAroundCurrentViewAxis(amount);
                event.consume();
                return;
            }
            if (event.getCode() == KeyCode.Y) {
                var amount = KEYBOARD_ROTATIONS_STEP_DEG;
                amount *= event.isControlDown() ? 0.1 : 1;
                amount *= event.isShiftDown() ? -1 : 1;

                rotateAroundCurrentVerticalAxis(amount);
                event.consume();
                return;
            }

        });

        Group cornerOverlayRoot = new Group();
        // Orientation cube built from 6 individual face panels with 3D text labels
        double boxSize = 2.0;
        double half = boxSize / 2.0;
        double textOffset = 0.02;  // text slightly proud of face surface
        double textScale = 0.012;

        // 6 individual face panels with 3D text labels
        // Each face: createOrientFace(label, faceSize, tx,ty,tz, faceRotation, textScale, rightX,Y,Z, normalX,Y,Z)
        // "right" = screen-right direction when looking at the face from outside
        cornerOverlayRoot.getChildren().addAll(
                createOrientFace("Fore", boxSize, half + textOffset, 0, 0,
                        new Rotate(-90, Rotate.Y_AXIS), textScale,
                        0, 1, 0,     // text right = +Y
                        1, 0, 0),    // outward normal +X
                createOrientFace("Aft", boxSize, -half - textOffset, 0, 0,
                        new Rotate(90, Rotate.Y_AXIS), textScale,
                        0, -1, 0,    // text right = -Y
                        -1, 0, 0),
                createOrientFace("PS", boxSize, 0, half + textOffset, 0,
                        new Rotate(90, Rotate.X_AXIS), textScale,
                        -1, 0, 0,    // text right = -X
                        0, 1, 0),
                createOrientFace("SB", boxSize, 0, -half - textOffset, 0,
                        new Rotate(-90, Rotate.X_AXIS), textScale,
                        1, 0, 0,     // text right = +X
                        0, -1, 0),
                createOrientFace("Top", boxSize, 0, 0, half + textOffset,
                        null, textScale,
                        1, 0, 0,     // text right = +X
                        0, 0, 1),
                createOrientFace("Bot", boxSize, 0, 0, -half - textOffset,
                        new Rotate(180, Rotate.X_AXIS), textScale,
                        1, 0, 0,     // text right = +X
                        0, 0, -1)
        );

        // Camera for the overlay – fixed distance, rotation-only
        PerspectiveCamera cornerCamera = new PerspectiveCamera(true);
        cornerCamera.setNearClip(0.1);
        cornerCamera.setFarClip(100);
        cornerCameraAffine = new Affine();
        cornerCameraAffine.append(new Translate(0, 0, -8));
        cornerCamera.getTransforms().add(cornerCameraAffine);
        cornerOverlayRoot.getChildren().add(cornerCamera);

        cornerOverlaySubScene = new SubScene(cornerOverlayRoot, 100, 100, true, SceneAntialiasing.BALANCED);
        cornerOverlaySubScene.setFill(Color.TRANSPARENT);
        cornerOverlaySubScene.setCamera(cornerCamera);

        // Click on a face of the orientation box triggers the corresponding preset view
        cornerOverlaySubScene.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                Node picked = event.getPickResult().getIntersectedNode();
                String viewName = findFaceViewName(picked);
                if (viewName != null) {
                    applyPresetView(viewName);
                    event.consume();
                }
            }
        });

        // Highlight face panel on hover
        PhongMaterial hoverMat = new PhongMaterial(Color.WHITESMOKE);
        PhongMaterial normalMat = new PhongMaterial(Color.LIGHTGRAY);
        cornerOverlaySubScene.setOnMouseMoved(event -> {
            Node picked = event.getPickResult().getIntersectedNode();
            String hoveredFace = findFaceViewName(picked);
            for (Node child : cornerOverlayRoot.getChildren()) {
                highlightOrientFace(child, hoveredFace, hoverMat, normalMat);
            }
        });
        cornerOverlaySubScene.setOnMouseExited(_ -> {
            for (Node child : cornerOverlayRoot.getChildren()) {
                highlightOrientFace(child, null, hoverMat, normalMat);
            }
        });


        SubSceneResizer subSceneHost = new SubSceneResizer(subScene);
        subSceneHost.setMinSize(0, 0);

        StackPane overlayPane = new StackPane(subSceneHost, infoPaneContainer, cornerOverlaySubScene);
        infoPaneContainer.toFront();
        overlayPane.setMinSize(0, 0);
        setMinSize(0, 0);
        overlayPane.setPickOnBounds(false);
        StackPane.setAlignment(infoPaneContainer, Pos.TOP_LEFT);
        StackPane.setMargin(infoPaneContainer, new Insets(10, 0, 0, 10));
        StackPane.setAlignment(cornerOverlaySubScene, Pos.TOP_RIGHT);
        StackPane.setMargin(cornerOverlaySubScene, new Insets(10, 10, 0, 0));
        setCenter(overlayPane);


        var toolbar = new ToolBar();
        setTop(toolbar);

        var fitAllButton = new Button("");
        fitAllButton.setTooltip(new Tooltip("Fit View, Shortcut: <Ctrl><0>"));
        fitAllButton.setGraphic(new FontIcon(MaterialDesignF.FIT_TO_PAGE));
        fitAllButton.setOnAction(_ -> {
            fitAll(ZOOM_ALL_MARGIN);
            subScene.requestFocus();
        });
        toolbar.getItems().add(fitAllButton);

        var zoomInButton = new Button("");
        zoomInButton.setTooltip(new Tooltip("Zoom In, Shortcut: <Ctrl><+>"));
        zoomInButton.setGraphic(new FontIcon(MaterialDesignM.MAGNIFY_PLUS));
        zoomInButton.setOnAction(_ -> {
            zoom(KEYBOARD_ZOOM_DELTA);
            subScene.requestFocus();
        });
        toolbar.getItems().add(zoomInButton);

        var zoomOutButton = new Button("");
        zoomOutButton.setTooltip(new Tooltip("Zoom Out, Shortcut: <Ctrl><->"));
        zoomOutButton.setGraphic(new FontIcon(MaterialDesignM.MAGNIFY_MINUS));
        zoomOutButton.setOnAction(_ -> {
            zoom(-KEYBOARD_ZOOM_DELTA);
            subScene.requestFocus();
        });
        toolbar.getItems().add(zoomOutButton);

        var views = List.of("SB", "Top", "Fore", "PS", "Bot", "Aft");
        var viewSelector = new ComboBox<String>();
        viewSelector.setPromptText("View");
        viewSelector.getItems().addAll(views);
        viewSelector.setValue("SB");
        viewSelector.setOnAction(_ -> applyPresetView(viewSelector.getValue()));
        toolbar.getItems().add(viewSelector);

        //Platform.runLater(() -> applyPresetView("SB"));


        // --- Bottom status bar ---
        pickCoordinateLabel = new Label("X: –  Y: –  Z: –");
        pickCoordinateLabel.setMinWidth(250);
        pickCoordinateLabel.setStyle("-fx-font-family: monospace;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        skyboxToggleIcon = new FontIcon(MaterialDesignE.EYE_OUTLINE);
        var skyboxToggleButton = new Button("Skybox", skyboxToggleIcon);
        skyboxToggleButton.setTooltip(new Tooltip("Toggle Skybox Visibility"));
        skyboxToggleButton.setOnAction(_ -> {
            boolean visible = !skyboxNode.isVisible();
            skyboxNode.setVisible(visible);
            skyboxToggleIcon.setIconCode(visible
                    ? MaterialDesignE.EYE_OUTLINE
                    : MaterialDesignE.EYE_OFF_OUTLINE);
        });

        bottomBar = new ToolBar(pickCoordinateLabel, new Separator(), spacer, skyboxToggleButton);
        bottomBar.getStyleClass().add("three-d-view-bottom-toolbar");
        setBottom(bottomBar);

        infoPaneFadeOut = new FadeTransition(Duration.millis(180), infoPaneContainer);
        infoPaneFadeOut.setFromValue(1.0);
        infoPaneFadeOut.setToValue(0.0);
        infoPaneFadeOut.setOnFinished(_ -> {
            if (infoPaneContainer != null) {
                infoPaneContainer.setVisible(false);
                infoPaneContainer.setManaged(false);
            }
        });

        // Sync overlay camera rotation with main camera
        var mainAffine = (Affine) camera.getTransforms().getFirst();
        syncCornerCamera(mainAffine);
        updateBillboards(mainAffine);
        mainAffine.setOnTransformChanged(_ -> {
            syncCornerCamera(mainAffine);
            updateBillboards(mainAffine);
            rebuildCoordinateSystemGrid();
        });

        // Keep the initial camera view; zoomAll is triggered explicitly by user action.

        //printScene(root);

        // BorderPane is this class itself.
    }


    private void updatePickCoordinateLabel(PickResult pickResult) {
        if (pickCoordinateLabel == null) {
            return;
        }
        if (pickResult != null
                && pickResult.getIntersectedNode() != null
                && pickResult.getIntersectedPoint() != null
                && !isDescendantOf(pickResult.getIntersectedNode(), skyboxNode)) {
            Point3D hitLocal = pickResult.getIntersectedPoint();
            Point3D hitScene = pickResult.getIntersectedNode().localToScene(hitLocal);
            Point3D hitWorld = world.sceneToLocal(hitScene);
            pickCoordinateLabel.setText(String.format("(%.2f %.2f %.2f)",
                    hitWorld.getX(), hitWorld.getY(), hitWorld.getZ()));
        } else {
            pickCoordinateLabel.setText("");
        }
    }

    private boolean isDescendantOf(Node node, Node ancestor) {
        if (ancestor == null) return false;
        Node current = node;
        while (current != null) {
            if (current == ancestor) return true;
            current = current.getParent();
        }
        return false;
    }

    private void showZoomCursor(double deltaY) {
        if (subScene == null) {
            return;
        }
        if (Math.abs(deltaY) <= ZOOM_CURSOR_DELTA_THRESHOLD) {
            return;
        }
        Cursor zoomCursor = deltaY >= 0 ? zoomInCursor : zoomOutCursor;
        if (zoomCursor == null) {
            zoomCursorActive = false;
            applyInteractionCursor();
            return;
        }
        zoomCursorActive = true;
        subScene.setCursor(zoomCursor);
        if (zoomCursorReset != null) {
            zoomCursorReset.stop();
            zoomCursorReset.playFromStart();
        }
    }

    private void applyInteractionCursor() {
        if (subScene == null) {
            return;
        }
        if (zoomCursorActive) {
            return;
        }
        if (middlePanActive) {
            subScene.setCursor(Cursor.MOVE);
        } else if (primaryDragActive) {
            subScene.setCursor(Cursor.CLOSED_HAND);
        } else {
            subScene.setCursor(Cursor.DEFAULT);
        }
    }

    private Cursor createIconCursor(Ikon iconCode) {
        try {
            FontIcon icon = new FontIcon(iconCode);
            icon.setIconSize(20);
            icon.setIconColor(Color.BLACK);

            // Unter Linux liefert ein einzelnes, nicht gelayoutetes Node-Snapshot oft 0x0.
            // Deshalb in einen Container legen und per Scene layouten.
            var pane = new StackPane(icon);
            pane.setPadding(new Insets(2));
            pane.setStyle("-fx-background-color: transparent;");
            new Scene(pane);
            pane.applyCss();
            pane.layout();

            Bounds b = pane.getLayoutBounds();
            int requestedW = Math.max(16, (int) Math.ceil(b.getWidth()));
            int requestedH = Math.max(16, (int) Math.ceil(b.getHeight()));
            Dimension2D bestSize = ImageCursor.getBestSize(requestedW, requestedH);
            int targetW = Math.max(16, (int) Math.ceil(bestSize.getWidth()));
            int targetH = Math.max(16, (int) Math.ceil(bestSize.getHeight()));

            pane.setPrefSize(targetW, targetH);
            pane.applyCss();
            pane.layout();

            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            WritableImage image = pane.snapshot(params, null);
            if (image == null || image.getWidth() <= 1 || image.getHeight() <= 1) {
                return null;
            }

            double hotSpotX = Math.max(0, Math.min(image.getWidth() - 1, image.getWidth() * 0.5));
            double hotSpotY = Math.max(0, Math.min(image.getHeight() - 1, image.getHeight() * 0.5));
            return new ImageCursor(image, hotSpotX, hotSpotY);
        } catch (Exception ex) {
            LOG.warn("Could not create icon cursor for {}", iconCode, ex);
            return null;
        }
    }

    private void rotateAroundCurrentVerticalAxis(double angleDeg) {
        if (camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        var base = (Affine) camera.getTransforms().getFirst();
        Point3D axis = normalize(new Point3D(base.getMxy(), base.getMyy(), base.getMzy()));
        if (axis.magnitude() < 1e-6) {
            axis = WORLD_UP;
        }
        Point3D pivot = pivotPoint != null ? pivotPoint : Point3D.ZERO;

        Transform rotated = new Rotate(
                angleDeg,
                pivot.getX(),
                pivot.getY(),
                pivot.getZ(),
                axis
        ).createConcatenation(base);

        setCameraAffine(new Affine(rotated));
    }

    private void rotateAroundCurrentRightAxis(double angleDeg) {
        if (camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        var base = (Affine) camera.getTransforms().getFirst();
        Point3D axis = normalize(new Point3D(base.getMxx(), base.getMyx(), base.getMzx()));
        if (axis.magnitude() < 1e-6) {
            return;
        }
        Point3D pivot = pivotPoint != null ? pivotPoint : Point3D.ZERO;

        Transform rotated = new Rotate(
                angleDeg,
                pivot.getX(),
                pivot.getY(),
                pivot.getZ(),
                axis
        ).createConcatenation(base);

        setCameraAffine(new Affine(rotated));
    }

    private void pitchAroundCurrentRightAxis(double angleDeg) {
        if (camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        var base = (Affine) camera.getTransforms().getFirst();
        Point3D axis = normalize(new Point3D(base.getMxx(), base.getMyx(), base.getMzx()));
        if (axis.magnitude() < 1e-6) {
            return;
        }
        Point3D pivot = pivotPoint != null ? pivotPoint : Point3D.ZERO;

        Transform rotated = new Rotate(
                angleDeg,
                pivot.getX(),
                pivot.getY(),
                pivot.getZ(),
                axis
        ).createConcatenation(base);

        setCameraAffine(new Affine(rotated));
    }


    private void pitchAroundCurrentViewAxis(double angleDeg) {
        if (camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        var base = (Affine) camera.getTransforms().getFirst();
        Point3D axis = normalize(new Point3D(base.getMxz(), base.getMyz(), base.getMzz()));
        if (axis.magnitude() < 1e-6) {
            return;
        }
        Point3D pivot = pivotPoint != null ? pivotPoint : Point3D.ZERO;

        Transform rotated = new Rotate(
                angleDeg,
                pivot.getX(),
                pivot.getY(),
                pivot.getZ(),
                axis
        ).createConcatenation(base);

        setCameraAffine(new Affine(rotated));
    }


    private void viewFrom(String side) {

        Bounds bounds = world.getBoundsInLocal();
        if (bounds.isEmpty()) {
            return;
        }

        Point3D centerG = new Point3D(
                (bounds.getMinX() + bounds.getMaxX()) * 0.5,
                (bounds.getMinY() + bounds.getMaxY()) * 0.5,
                (bounds.getMinZ() + bounds.getMaxZ()) * 0.5
        );
        pivotPoint = centerG;


        Bounds worldBounds = calculateWorldBounds3D();
        LOG.info("World bounds 3D: {}", worldBounds);

        LOG.info("center G {}", centerG);

        Point3D cameraPos;
        Vector3d cameraDir;
        Vector3d cameraUp;

        switch (side) {
            case "PS" -> {
                cameraPos = new Point3D(centerG.getX(), centerG.getY() + 200, centerG.getZ());
                cameraDir = new Vector3d(0, -1, 0);
                cameraUp = new Vector3d(0, 0, -1);
            }
            case "SB" -> {
                cameraPos = new Point3D(centerG.getX(), centerG.getY() - 200, centerG.getZ());
                cameraDir = new Vector3d(0, 1, 0);
                cameraUp = new Vector3d(0, 0, -1);
            }
            case "Fore" -> {
                cameraPos = new Point3D(centerG.getX() + 200, centerG.getY(), centerG.getZ());
                cameraDir = new Vector3d(-1, 0, 0);
                cameraUp = new Vector3d(0, 0, -1);
            }
            case "Aft" -> {
                cameraPos = new Point3D(centerG.getX() - 200, centerG.getY(), centerG.getZ());
                cameraDir = new Vector3d(1, 0, 0);
                cameraUp = new Vector3d(0, 0, -1);
            }
            case "Top" -> {
                cameraPos = new Point3D(centerG.getX(), centerG.getY(), centerG.getZ() + 200);
                cameraDir = new Vector3d(0, 0, -1);
                cameraUp = new Vector3d(0, -1, 0);  // X+ zeigt nach rechts auf dem Bildschirm
            }
            case "Bot" -> {
                cameraPos = new Point3D(centerG.getX(), centerG.getY(), centerG.getZ() - 200);
                cameraDir = new Vector3d(0, 0, 1);
                cameraUp = new Vector3d(0, 1, 0);   // X+ zeigt nach rechts auf dem Bildschirm
            }
            case null, default -> {
                LOG.error("got unknown side {}", side);
                return;
            }
        }

        Vector3d x = new Vector3d();
        x.cross(cameraUp, cameraDir);


        LOG.info("x {}, y {}, z {}, t {}", x, cameraUp, cameraDir, cameraPos);

        var affine = (Affine) camera.getTransforms().getFirst();
        LOG.info("affine {}", affine);

        var affineT = new Affine(
                x.getX(), cameraUp.getX(), cameraDir.getX(), cameraPos.getX(),
                x.getY(), cameraUp.getY(), cameraDir.getY(), cameraPos.getY(),
                x.getZ(), cameraUp.getZ(), cameraDir.getZ(), cameraPos.getZ()
        );

        LOG.info("affine' {}", affineT);
        setCameraAffine(affineT);
        fitAll(ZOOM_ALL_MARGIN);


    }

    private void applyPresetView(String view) {
        if (view == null || view.isBlank()) {
            return;
        }
        resetViewInteractionState();
        viewFrom(view);
        if (subScene != null) {
            subScene.requestFocus();
        }
    }

    private void resetViewInteractionState() {
        primaryDragActive = false;
        middlePanActive = false;
        zoomCursorActive = false;
        rotateStartCameraAffine = null;
        pivotPoint = Point3D.ZERO;
        if (zoomCursorReset != null) {
            zoomCursorReset.stop();
        }
        if (zoomAllDebounce != null) {
            zoomAllDebounce.stop();
        }
        applyInteractionCursor();
    }

    private void createGrid() {
        // Grid-Plane bei z=0
        if (false) {
            var gridGroup = new Group();
            int gridSize = 100;
            int gridStep = 10;
            Color gridColor = Color.DARKBLUE;
            for (int i = -gridSize / 2; i <= gridSize / 2; i += gridStep) {
                // Vertikale Linien (X) auf halben Pixeln
                double x = i + 0.5;
                var lineX = new javafx.scene.shape.Line(x, -gridSize / 2.0, x, gridSize / 2.0);
                lineX.setStroke(gridColor);
                lineX.setStrokeWidth(i == 0 ? 0.01 : 0.05);
                gridGroup.getChildren().add(lineX);
                // Horizontale Linien (Y) auf halben Pixeln
                double y = i + 0.5;
                var lineY = new javafx.scene.shape.Line(-gridSize / 2.0, y, gridSize / 2.0, y);
                lineY.setStroke(gridColor);
                lineY.setStrokeWidth(i == 0 ? 0.01 : 0.05);
                gridGroup.getChildren().add(lineY);
            }
            // Lege das Grid in eine Gruppe und platziere sie bei z=0
            // Füge einen Arc mit 135° Öffnungswinkel auf der Grid-Ebene hinzu, der in -X-Richtung zeigt und vom Mittelpunkt gefüllt ist
            double arcRadius = 30;
            double arcCenterX = -20;
            double arcCenterY = 0;
            double arcStartAngle = 112.6; // -X Richtung (JavaFX: 0° = +X, 90° = -Y, 180° = -X)
            double arcLength = 135.0;
            javafx.scene.shape.Arc arc = new javafx.scene.shape.Arc(arcCenterX, arcCenterY, arcRadius, arcRadius, arcStartAngle, arcLength);
            arc.setType(javafx.scene.shape.ArcType.ROUND); // Kuchenstück, vom Mittelpunkt gefüllt
//										arc.setStroke(Color.BLACK);
//										arc.setStrokeWidth(2.0);
            arc.setFill(Color.rgb(0, 0, 0, 0.2)); // halbtransparente Füllung
            gridGroup.getChildren().add(arc);


            arcCenterX = 75;
            arcCenterY = -50;
            arcStartAngle = 0; // -X Richtung (JavaFX: 0° = +X, 90° = -Y, 180° = -X)
            arcLength = 112.5;
            arc = new javafx.scene.shape.Arc(arcCenterX, arcCenterY, arcRadius, arcRadius, arcStartAngle, arcLength);
            arc.setType(javafx.scene.shape.ArcType.ROUND); // Kuchenstück, vom Mittelpunkt gefüllt
//										arc.setStroke(Color.BLACK);
//										arc.setStrokeWidth(2.0);
            arc.setFill(Color.web("#57b757", 0.75)); // kräftiges halbtransparentes Grün
            gridGroup.getChildren().add(arc);


            arcCenterX = 75;
            arcCenterY = 50;
            arcStartAngle = 0; // -X Richtung (JavaFX: 0° = +X, 90° = -Y, 180° = -X)
            arcLength = -112.5;
            arc = new javafx.scene.shape.Arc(arcCenterX, arcCenterY, arcRadius, arcRadius, arcStartAngle, arcLength);
            arc.setType(javafx.scene.shape.ArcType.ROUND); // Kuchenstück, vom Mittelpunkt gefüllt
//										arc.setStroke(Color.BLACK);
//										arc.setStrokeWidth(2.0);
            arc.setFill(Color.web("#f3622d", 0.75)); // kräftiges halbtransparentes Grün
            gridGroup.getChildren().add(arc);


            var gridPlane = new Group(gridGroup);
            gridPlane.setTranslateZ(0);
            world.getChildren().add(gridPlane);
        }

    }

    private void printScene(Group root) {
        recPrint(root, "");
    }

    private void recPrint(Group group, String s) {

        LOG.info("{} <{}>", s, group.getId());
        for (Transform transform : group.getTransforms()) {
            LOG.info("{}   transform: {}", s, transform);
        }
        for (Node child : group.getChildren()) {
            if (child instanceof Group childGroup) {
                recPrint(childGroup, s + "  ");
            } else {
                LOG.info("{}   <{}> {}", s, child.getClass().getSimpleName(), child.getId());
                for (Transform transform : child.getTransforms()) {
                    LOG.info("{}     transform: {}", s, transform);
                }
            }
        }

    }

    private void zoom(double amount) {
        var affine = (Affine) camera.getTransforms().getFirst();

        var lookAt = new Vector3d(affine.getMxz(), affine.getMyz(), affine.getMzz());
        lookAt.normalize();

        //var lookFrom = new Point3D(affine.getTx(), affine.getTy(), affine.getTz());
        //LOG.info("look direction {}, from {}", lookAt, lookFrom);
        lookAt.scale(amount * ZOOM_STEP);
        //LOG.info("move camera by {}", lookAt);

        affine.prependTranslation(lookAt.x, lookAt.y, lookAt.z);

        //LOG.info("affine' {}", affine);


    }

    private void pan(double deltaX, double deltaY) {
        if (camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        var affine = (Affine) camera.getTransforms().getFirst();
        Point3D right = normalize(new Point3D(affine.getMxx(), affine.getMyx(), affine.getMzx()));
        Point3D up = normalize(new Point3D(affine.getMxy(), affine.getMyy(), affine.getMzy()));

        Point3D move = right.multiply(-deltaX * PAN_STEP).add(up.multiply(-deltaY * PAN_STEP));
        if (move.magnitude() < 1e-9) {
            return;
        }
        affine.prependTranslation(move.getX(), move.getY(), move.getZ());
    }

    private void rotate(double deltaX, double deltaY) {
        if (camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        Affine base = rotateStartCameraAffine != null
                ? rotateStartCameraAffine
                : (Affine) camera.getTransforms().getFirst();

        Point3D pivot = pivotPoint != null ? pivotPoint : Point3D.ZERO;
        Point3D cameraPos0 = new Point3D(base.getTx(), base.getTy(), base.getTz());
        Point3D offset0 = cameraPos0.subtract(pivot);
        if (offset0.magnitude() < MIN_CAMERA_PIVOT_DISTANCE) {
            return;
        }

        Point3D baseRight = normalize(new Point3D(base.getMxx(), base.getMyx(), base.getMzx()));
        Point3D baseUp = normalize(new Point3D(base.getMxy(), base.getMyy(), base.getMzy()));
        Point3D yawAxis = baseUp.magnitude() > 1e-6 ? baseUp : WORLD_UP;

        double yawRad = Math.toRadians(-deltaX * ROTATE_STEP);
        Point3D offsetAfterYaw = rotateAroundAxis(offset0, yawAxis, yawRad);

        Point3D forwardAfterYaw = normalize(pivot.subtract(pivot.add(offsetAfterYaw)));
        Point3D rightAxis = yawAxis.crossProduct(forwardAfterYaw);
        if (rightAxis.magnitude() < 1e-6) {
            rightAxis = baseRight;
        }
        rightAxis = normalize(rightAxis);

        double currentPitch = Math.asin(clamp(forwardAfterYaw.dotProduct(yawAxis), -1.0, 1.0));
        double requestedPitch = Math.toRadians(deltaY * ROTATE_STEP);
        double maxPitch = Math.toRadians(MAX_PITCH_DEG);
        double appliedPitch = clamp(requestedPitch, -maxPitch - currentPitch, maxPitch - currentPitch);

        Point3D offsetFinal = rotateAroundAxis(offsetAfterYaw, rightAxis, appliedPitch);
        Point3D cameraPos = pivot.add(offsetFinal);
        Point3D forward = normalize(pivot.subtract(cameraPos));

        Point3D upRef = rotateAroundAxis(yawAxis, rightAxis, appliedPitch);
        Point3D right = upRef.crossProduct(forward);
        if (right.magnitude() < 1e-6) {
            right = rightAxis;
        }
        right = normalize(right);
        Point3D up = normalize(forward.crossProduct(right));

        Affine next = new Affine(
                right.getX(), up.getX(), forward.getX(), cameraPos.getX(),
                right.getY(), up.getY(), forward.getY(), cameraPos.getY(),
                right.getZ(), up.getZ(), forward.getZ(), cameraPos.getZ()
        );
        setCameraAffine(next);
    }

    private Point3D rotateAroundAxis(Point3D vector, Point3D axis, double angleRad) {
        Point3D n = normalize(axis);
        double cos = Math.cos(angleRad);
        double sin = Math.sin(angleRad);
        Point3D term1 = vector.multiply(cos);
        Point3D term2 = n.crossProduct(vector).multiply(sin);
        Point3D term3 = n.multiply(n.dotProduct(vector) * (1.0 - cos));
        return term1.add(term2).add(term3);
    }

    private Point3D normalize(Point3D v) {
        double len = v.magnitude();
        if (len < 1e-12) {
            return Point3D.ZERO;
        }
        return v.multiply(1.0 / len);
    }

    private Point3D getCurrentForwardDirection() {
        if (camera != null && !camera.getTransforms().isEmpty() && camera.getTransforms().getFirst() instanceof Affine affine) {
            Point3D forward = normalize(new Point3D(affine.getMxz(), affine.getMyz(), affine.getMzz()));
            if (forward.magnitude() >= 1e-9) {
                return forward;
            }
        }
        return new Point3D(1, 0, 0);
    }

    private boolean isFinite(Point3D p) {
        return Double.isFinite(p.getX()) && Double.isFinite(p.getY()) && Double.isFinite(p.getZ());
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Moves the camera parallel to the image plane so that the given world point
     * is centred in the current view. View direction and distance remain unchanged.
     */
    private void centerWorldPointInView(Point3D worldPoint) {
        if (worldPoint == null || camera == null || camera.getTransforms().isEmpty()) {
            return;
        }

        var affine = (Affine) camera.getTransforms().getFirst();
        Point3D cameraPos = new Point3D(affine.getTx(), affine.getTy(), affine.getTz());
        Point3D right = normalize(new Point3D(affine.getMxx(), affine.getMyx(), affine.getMzx()));
        Point3D up = normalize(new Point3D(affine.getMxy(), affine.getMyy(), affine.getMzy()));

        Point3D cameraToPoint = worldPoint.subtract(cameraPos);
        double x = right.dotProduct(cameraToPoint);
        double y = up.dotProduct(cameraToPoint);

        // Pan in der Kameraebene: danach ist der Punkt im Projektionszentrum.
        Point3D move = right.multiply(x).add(up.multiply(y));
        affine.prependTranslation(move.getX(), move.getY(), move.getZ());
    }

    private void pickProvider(PickResult pickResult) {
        if (pickResult == null) {
            selectProvider(null);
            return;
        }
        Node node = pickResult.getIntersectedNode();
        selectProvider(findProvider(node));
    }

    private InformationProvider findProvider(Node node) {
        Node current = node;
        while (current != null) {
            if (current instanceof InformationProvider provider) {
                return provider;
            }
            current = current.getParent();
        }
        return null;
    }

    private void selectProvider(InformationProvider provider) {
        if (selectedProvider == provider) {
            return;
        }
        if (selectedProvider instanceof Plane3D plane) {
            plane.setHighlighted(false);
        }
        selectedProvider = provider;
        if (selectedProvider != null) {
            if (selectedProvider instanceof Plane3D plane) {
                plane.setHighlighted(true);
            }
            updateInfoPane(selectedProvider);
        } else {
            hideInfoPane();
        }
    }

    private void updateInfoPane(InformationProvider provider) {
        if (infoPaneContainer != null && provider != null) {
            infoPaneContainer.getChildren().clear();
            infoPaneContainer.getChildren().add(
                    atlantafx.base.util.BBCodeParser.createFormattedText(provider.getInformation()));
            infoPaneContainer.setManaged(true);
            infoPaneContainer.setVisible(true);
            infoPaneContainer.setOpacity(1.0);
            if (infoPaneFadeOut != null) {
                infoPaneFadeOut.stop();
            }
        }
    }

    private void hideInfoPane() {
        if (infoPaneContainer != null && infoPaneContainer.isVisible() && infoPaneFadeOut != null) {
            infoPaneFadeOut.stop();
            infoPaneFadeOut.playFromStart();
        }
    }

    private void fitAll(double margin) {


        double width = subScene.getWidth();
        double height = subScene.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (width > 3 * margin) {
            width -= 2 * margin;
        }
        if (height > 3 * margin) {
            height -= 2 * margin;
        }

        LOG.info("widthxheight {}x{}", width, height);


        int counter = 0;
        Vector3d deltaUVW;
        do {

            counter++;
            var affine = (Affine) camera.getTransforms().getFirst();
            //            LOG.info("Camera transforms: {}", affine);
            //            LOG.info("LocalToSceneTransform {}", camera.getLocalToSceneTransform());

            var lookAt = new Vector3d(affine.getMxz(), affine.getMyz(), affine.getMzz());
            var xAxis = new Vector3d(affine.getMxx(), affine.getMyx(), affine.getMzx());
            var yAxis = new Vector3d(affine.getMxy(), affine.getMyy(), affine.getMzy());

            //LOG.info("global view x {}, y {}, z {}", xAxis, yAxis, lookAt);

            var lookFrom = new Point3D(affine.getTx(), affine.getTy(), affine.getTz());

            var worldOnScreen = getNodeBoundsInScreen(world);

            if (worldOnScreen == null || Double.isNaN(worldOnScreen.getMinX()) || Double.isNaN(worldOnScreen.getMinY())) {
                // world is not visible at all
                LOG.error("world is not visible, cannot fit all");
                break;
            }
            var windowOnScreen = getNodeBoundsInScreen(subScene);
            if (windowOnScreen == null || windowOnScreen.getWidth() <= 0 || windowOnScreen.getHeight() <= 0) {
                LOG.error("subScene not visible, cannot fit all");
                break;
            }
            //LOG.info("  world {}, scene {}", worldOnScreen, windowOnScreen);

            var worldInWindow = new Rectangle2D(
                    worldOnScreen.getMinX() - windowOnScreen.getMinX(),
                    worldOnScreen.getMinY() - windowOnScreen.getMinY(),
                    worldOnScreen.getWidth(), worldOnScreen.getHeight());

            //LOG.info("world in window {}", worldInWindow);

            var worldCenterIW = new Point2D(worldInWindow.getMinX() + 0.5 * worldInWindow.getWidth(), worldInWindow.getMinY() + 0.5 * worldInWindow.getHeight());
            var centerWindow = new Point2D(0.5 * windowOnScreen.getWidth(), 0.5 * windowOnScreen.getHeight());
            //LOG.info("center world in window {}, center window {}", worldCenterIW, centerWindow);

            var zoomX = (windowOnScreen.getWidth() * 0.9) / worldOnScreen.getWidth();
            var zoomY = (windowOnScreen.getHeight() * 0.9) / worldOnScreen.getHeight();
            var zoom = Math.min(zoomX, zoomY);


            var deltaUVWScale = new Vector3d(worldCenterIW.getX() - centerWindow.getX(),
                    worldCenterIW.getY() - centerWindow.getY(),
                    zoom - 1);

            if (deltaUVWScale.length() < 1e-3) {
                // close enough
                //LOG.info("delta UVW is small enough, done");
                break;
            }
            deltaUVWScale.normalize();

            xAxis.scale(deltaUVWScale.x);
            yAxis.scale(deltaUVWScale.y);
            lookAt.scale(deltaUVWScale.z);

            deltaUVW = new Vector3d(xAxis);
            deltaUVW.add(yAxis);
            deltaUVW.add(lookAt);


            affine.prependTranslation(deltaUVW.getX(), deltaUVW.getY(), deltaUVW.getZ());
        } while (counter < 1000);

        // Update pivot point to the world center so subsequent rotations orbit correctly
        Bounds wb = calculateWorldBounds3D();
        if (wb != null) {
            pivotPoint = new Point3D(
                    (wb.getMinX() + wb.getMaxX()) * 0.5,
                    (wb.getMinY() + wb.getMaxY()) * 0.5,
                    (wb.getMinZ() + wb.getMaxZ()) * 0.5
            );
            // Adapt near clip so no visible geometry is cut by the near plane
            var finalAffine = (Affine) camera.getTransforms().getFirst();
            Point3D camPos = new Point3D(finalAffine.getTx(), finalAffine.getTy(), finalAffine.getTz());
            double diag = Math.sqrt(
                    wb.getWidth() * wb.getWidth() +
                            wb.getHeight() * wb.getHeight() +
                            wb.getDepth() * wb.getDepth());
            double distToNearSurface = Math.max(0.001, pivotPoint.distance(camPos) - diag * 0.5);
            camera.setNearClip(distToNearSurface * 0.1);
        }
    }

    private void zoomAll(Node target, double margin) {
        if (subScene == null || world == null || camera == null) {
            return;
        }
        if (target == null) {
            target = world;
        }
        if (margin < 1.0) {
            margin = 1.0;
        }

        double width = subScene.getWidth();
        double height = subScene.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }

        Bounds bounds = target.getBoundsInLocal();
        if (bounds.isEmpty()) {
            return;
        }

        Point3D centerLocal = new Point3D(
                (bounds.getMinX() + bounds.getMaxX()) * 0.5,
                (bounds.getMinY() + bounds.getMaxY()) * 0.5,
                (bounds.getMinZ() + bounds.getMaxZ()) * 0.5
        );
        Point3D centerScene = target.localToScene(centerLocal);

        Affine cameraRotation = new Affine();


        try {
            Transform sceneToCameraRotation = cameraRotation.createInverse();
            double aspect = width / height;
            double fov = Math.toRadians(camera.getFieldOfView());
            double tanHalfFov = Math.tan(fov / 2.0);

            double tanX;
            double tanY;
            if (camera.isVerticalFieldOfView()) {
                tanY = tanHalfFov;
                tanX = tanHalfFov * aspect;
            } else {
                tanX = tanHalfFov;
                tanY = tanHalfFov / aspect;
            }

            double requiredZ = camera.getNearClip();
            for (Point3D localCorner : cornersOf(bounds)) {
                Point3D sceneCorner = target.localToScene(localCorner);
                Point3D relativeScene = sceneCorner.subtract(centerScene);
                Point3D relativeCam = sceneToCameraRotation.transform(relativeScene);

                double candidateByX = Math.abs(relativeCam.getX()) / tanX - relativeCam.getZ();
                double candidateByY = Math.abs(relativeCam.getY()) / tanY - relativeCam.getZ();
                double candidateByNear = camera.getNearClip() - relativeCam.getZ();

                requiredZ = Math.max(requiredZ, Math.max(candidateByNear, Math.max(candidateByX, candidateByY)));
            }

            requiredZ *= margin;
            requiredZ = Math.min(requiredZ, camera.getFarClip() * 0.95);

            Point3D forwardInScene = cameraRotation.deltaTransform(0, 0, 1);
            centerScene.subtract(forwardInScene.multiply(requiredZ));

        } catch (NonInvertibleTransformException ignored) {
            // Rotation is invertible in normal operation.
        }
    }

    private Point3D[] cornersOf(Bounds b) {
        double minX = b.getMinX();
        double minY = b.getMinY();
        double minZ = b.getMinZ();
        double maxX = b.getMaxX();
        double maxY = b.getMaxY();
        double maxZ = b.getMaxZ();

        return new Point3D[]{
                new Point3D(minX, minY, minZ),
                new Point3D(minX, minY, maxZ),
                new Point3D(minX, maxY, minZ),
                new Point3D(minX, maxY, maxZ),
                new Point3D(maxX, minY, minZ),
                new Point3D(maxX, minY, maxZ),
                new Point3D(maxX, maxY, minZ),
                new Point3D(maxX, maxY, maxZ)
        };
    }

    /**
     * Draw a coordinate system whose visible axes adapt to the current camera view direction.
     * When the camera looks mainly along X → YZ plane; along Y → XZ plane; along Z → XY plane.
     *
     * @param minX    the minimal X value (after AP)
     * @param maxX    the maximal X value (before FP)
     * @param breadth the total breadth
     * @param height  the height
     */
    public void drawCoordinateSystem(double minX, double maxX, double breadth, double height) {
        csMinX = minX;
        csMaxX = maxX;
        csBreadth = breadth;
        csHeight = height;
        csInitialized = true;
        currentGridPlane = MainPlane.UNDEFINED;
        rebuildCoordinateSystemGrid();
    }

    private void rebuildCoordinateSystemGrid() {
        if (!csInitialized || camera == null || camera.getTransforms().isEmpty()) return;

        var affine = (Affine) camera.getTransforms().getFirst();
        var viewDir = new Vector3d(affine.getMxz(), affine.getMyz(), affine.getMzz());
        MainPlane plane = GeomHelper.getMainPlane(viewDir);
        if (plane == MainPlane.UNDEFINED) plane = MainPlane.YPLANE;

        if (plane == currentGridPlane) return;
        currentGridPlane = plane;

        final Optional<Node> gOpt = world.getChildren().stream()
                .filter(c -> c instanceof Group g && "coordinate-system".equals(g.getId()))
                .findFirst();
        if (gOpt.isPresent()) {
            world.getChildren().remove(gOpt.get());
        }
        billboardAffines.removeAll(csBillboardAffines);
        csBillboardAffines.clear();

        var cosysGroup = new Group();
        cosysGroup.setId("coordinate-system");
        world.getChildren().add(cosysGroup);

        int major = 10;
        int minor = 5;

        switch (plane) {
            case XPLANE -> drawYZGrid(cosysGroup, major, minor);
            case YPLANE -> drawXZGrid(cosysGroup, major, minor);
            case ZPLANE -> drawXYGrid(cosysGroup, major, minor);
            default -> drawXZGrid(cosysGroup, major, minor);
        }

        updateBillboards(affine);
    }

    /** YPLANE view (camera along Y): draw X, Y and Z axes on the XZ plane (Y=0).
     *  X ticks → -Z direction, Y ticks → -Z direction, Z ticks → +X direction. */
    private void drawXZGrid(Group g, int major, int minor) {
        double length = csMaxX - csMinX;
        double center = (csMaxX + csMinX) / 2.0;

        Box xLine = new Box(length, 0.1, 0.1);
        xLine.getTransforms().add(new Translate(center, 0, 0.0));
        xLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(xLine);

        int startX = (int) Math.ceil(csMinX / (1.0 * major)) * major;
        for (int x = startX; x < csMaxX; x += minor) {
            double h = x % major == 0 ? 1 : 0.5;
            Box tick = new Box(0.1, 0.1, h);
            tick.getTransforms().add(new Translate(x, 0, -0.5 * h));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (x % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(x), x, 0, -1));
            }
        }

        Box yLine = new Box(0.1, csBreadth, 0.1);
        yLine.getTransforms().add(new Translate(0, 0, 0));
        yLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(yLine);

        for (int y = minor; y <= 0.5 * csBreadth; y += minor) {
            double h = y % major == 0 ? 1 : 0.5;

            Box tick = new Box(0.1, 0.1, h);
            tick.getTransforms().add(new Translate(0, y, -0.5 * h));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (y % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(y), 0, y, -1));
            }

            Box tick2 = new Box(0.1, 0.1, h);
            tick2.getTransforms().add(new Translate(0, -y, -0.5 * h));
            tick2.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick2);
            if (y % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(-y), 0, -y, -1));
            }
        }

        Box zLine = new Box(0.1, 0.1, csHeight);
        zLine.getTransforms().add(new Translate(0, 0, csHeight / 2.0));
        zLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(zLine);

        for (int z = minor; z <= csHeight; z += minor) {
            double h = z % major == 0 ? 1 : 0.5;
            Box tick = new Box(h, 0.1, 0.1);
            tick.getTransforms().add(new Translate(0.5 * h, 0, z));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (z % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(z), 1, 0, z));
            }
        }
    }

    /** XPLANE view (camera along X): draw X, Y and Z axes on the YZ plane (X=0).
     *  X ticks → -Z direction, Y ticks → -Z direction, Z ticks → +Y direction. */
    private void drawYZGrid(Group g, int major, int minor) {
        double length = csMaxX - csMinX;
        double center = (csMaxX + csMinX) / 2.0;

        Box xLine = new Box(length, 0.1, 0.1);
        xLine.getTransforms().add(new Translate(center, 0, 0.0));
        xLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(xLine);

        int startX = (int) Math.ceil(csMinX / (1.0 * major)) * major;
        for (int x = startX; x < csMaxX; x += minor) {
            double h = x % major == 0 ? 1 : 0.5;
            Box tick = new Box(0.1, 0.1, h);
            tick.getTransforms().add(new Translate(x, 0, -0.5 * h));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (x % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(x), x, 0, -1));
            }
        }

        Box yLine = new Box(0.1, csBreadth, 0.1);
        yLine.getTransforms().add(new Translate(0, 0, 0));
        yLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(yLine);

        for (int y = minor; y <= 0.5 * csBreadth; y += minor) {
            double h = y % major == 0 ? 1 : 0.5;

            Box tick = new Box(0.1, 0.1, h);
            tick.getTransforms().add(new Translate(0, y, -0.5 * h));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (y % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(y), 0, y, -1));
            }

            Box tick2 = new Box(0.1, 0.1, h);
            tick2.getTransforms().add(new Translate(0, -y, -0.5 * h));
            tick2.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick2);
            if (y % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(-y), 0, -y, -1));
            }
        }

        Box zLine = new Box(0.1, 0.1, csHeight);
        zLine.getTransforms().add(new Translate(0, 0, csHeight / 2.0));
        zLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(zLine);

        for (int z = minor; z <= csHeight; z += minor) {
            double h = z % major == 0 ? 1 : 0.5;
            Box tick = new Box(0.1, h, 0.1);
            tick.getTransforms().add(new Translate(0, 0.5 * h, z));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (z % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(z), 0, 1, z));
            }
        }
    }

    /** ZPLANE view (camera along Z): draw X, Y and Z axes on the XY plane (Z=0).
     *  X ticks → +Y direction, Y ticks → -Z direction, Z ticks → +X direction. */
    private void drawXYGrid(Group g, int major, int minor) {
        double length = csMaxX - csMinX;
        double center = (csMaxX + csMinX) / 2.0;

        Box xLine = new Box(length, 0.1, 0.1);
        xLine.getTransforms().add(new Translate(center, 0, 0));
        xLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(xLine);

        int startX = (int) Math.ceil(csMinX / (1.0 * major)) * major;
        for (int x = startX; x < csMaxX; x += minor) {
            double h = x % major == 0 ? 1 : 0.5;
            Box tick = new Box(0.1, h, 0.1);
            tick.getTransforms().add(new Translate(x, 0.5 * h, 0));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (x % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(x), x, 1, 0));
            }
        }

        Box yLine = new Box(0.1, csBreadth, 0.1);
        yLine.getTransforms().add(new Translate(0, 0, 0));
        yLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(yLine);

        for (int y = minor; y <= 0.5 * csBreadth; y += minor) {
            double h = y % major == 0 ? 1 : 0.5;

            Box tick = new Box(0.1, 0.1, h);
            tick.getTransforms().add(new Translate(0, y, -0.5 * h));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (y % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(y), 0, y, -1));
            }

            Box tick2 = new Box(0.1, 0.1, h);
            tick2.getTransforms().add(new Translate(0, -y, -0.5 * h));
            tick2.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick2);
            if (y % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(-y), 0, -y, -1));
            }
        }

        Box zLine = new Box(0.1, 0.1, csHeight);
        zLine.getTransforms().add(new Translate(0, 0, csHeight / 2.0));
        zLine.setMaterial(new PhongMaterial(lineColour));
        g.getChildren().add(zLine);

        for (int z = minor; z <= csHeight; z += minor) {
            double h = z % major == 0 ? 1 : 0.5;
            Box tick = new Box(h, 0.1, 0.1);
            tick.getTransforms().add(new Translate(0.5 * h, 0, z));
            tick.setMaterial(new PhongMaterial(lineColour));
            g.getChildren().add(tick);
            if (z % major == 0) {
                g.getChildren().add(createCsBillboardLabel(Integer.toString(z), 1, 0, z));
            }
        }
    }

    private Node createCsBillboardLabel(String text, double wx, double wy, double wz) {
        var tm = new Text3DMesh(text, 0.1);
        tm.setDrawMode(DrawMode.FILL);
        PhongMaterial textMat = new PhongMaterial(textColour);
        for (var mv : tm.getMeshes()) {
            if (mv instanceof javafx.scene.shape.MeshView meshView) {
                meshView.setMaterial(textMat);
            }
        }

        Group billboard = new Group();
        billboard.getChildren().addAll(tm.getMeshes());

        Affine bbAffine = new Affine();
        bbAffine.setTx(wx);
        bbAffine.setTy(wy);
        bbAffine.setTz(wz);
        billboard.getTransforms().addFirst(bbAffine);
        billboardAffines.add(bbAffine);
        csBillboardAffines.add(bbAffine);

        return billboard;
    }

    /**
     * Creates a textured face panel for the orientation cube.
     * Renders the label text into an image and applies it as diffuse map.
     */
    /**
     * Creates one face of the orientation cube: a thin Box panel (pickable) with a Text3DMesh label.
     * The text is placed using an Affine built from the face's outward normal and a "right" direction,
     * so it always sticks out and reads correctly when viewed from outside.
     */
    private Node createOrientFace(String text, double faceSize,
                                  double tx, double ty, double tz,
                                  Transform faceRotation, double tScale,
                                  double rx, double ry, double rz,
                                  double nx, double ny, double nz) {
        // --- pickable face panel ---
        double thickness = 0.02;
        Box facePanel = new Box(faceSize, faceSize, thickness);
        facePanel.setMaterial(new PhongMaterial(Color.LIGHTGRAY));
        facePanel.setId("orient-face-" + text);
        // Position & rotate the panel at the face center (without the textOffset)
        double faceTx = tx - nx * 0.02;  // pull back to face surface
        double faceTy = ty - ny * 0.02;
        double faceTz = tz - nz * 0.02;
        Group faceGroup = new Group(facePanel);
        faceGroup.getTransforms().add(new Translate(faceTx, faceTy, faceTz));
        if (faceRotation != null) {
            faceGroup.getTransforms().add(faceRotation);
        }

        // --- 3D text label ---
        var tm = new Text3DMesh(text, 0.05);
        var meshes = tm.getMeshes();
        PhongMaterial textMat = new PhongMaterial(Color.rgb(40, 40, 40));
        for (var mv : meshes) {
            if (mv instanceof javafx.scene.shape.MeshView meshView) {
                meshView.setMaterial(textMat);
            }
        }

        Group rawText = new Group();
        rawText.getChildren().addAll(meshes);
        Bounds tb = rawText.getBoundsInLocal();

        // Compute up = right × normal (right-handed: text readable from outside)
        double upX = ry * nz - rz * ny;
        double upY = rz * nx - rx * nz;
        double upZ = rx * ny - ry * nx;

        // Build an Affine that maps text-local coords → world coords:
        //   text +X (reading direction) → right
        //   text +Y (height)            → up
        //   text +Z (depth/toward viewer) → normal (outward)
        // Columns: [right | up | normal | position]
        Affine textAffine = new Affine(
                rx * tScale, upX * tScale, nx * tScale, tx,
                ry * tScale, upY * tScale, ny * tScale, ty,
                rz * tScale, upZ * tScale, nz * tScale, tz
        );

        // Center the text: shift so that the text's center maps to the face center
        double cxOff = -(tb.getMinX() + tb.getWidth() / 2.0);
        double cyOff = -(tb.getMinY() + tb.getHeight() / 2.0);
        double czOff = -(tb.getMinZ() + tb.getDepth() / 2.0);
        rawText.getTransforms().add(new Translate(cxOff, cyOff, czOff));

        Group textGroup = new Group(rawText);
        textGroup.getTransforms().add(textAffine);

        // Outer group – just holds face + text together
        var group = new Group(faceGroup, textGroup);
        return group;
    }

    /**
     * Walks up from the picked node to find the face group whose id encodes the view name.
     */
    private String findFaceViewName(Node node) {
        Node current = node;
        while (current != null) {
            String id = current.getId();
            if (id != null && id.startsWith("orient-face-")) {
                return id.substring("orient-face-".length());
            }
            current = current.getParent();
        }
        return null;
    }

    /**
     * Recursively finds Box nodes with "orient-face-" IDs and sets their material
     * to hoverMat if their face name matches hoveredFace, or normalMat otherwise.
     */
    private void highlightOrientFace(Node node, String hoveredFace, PhongMaterial hoverMat, PhongMaterial normalMat) {
        String id = node.getId();
        if (id != null && id.startsWith("orient-face-") && node instanceof Box box) {
            String faceName = id.substring("orient-face-".length());
            box.setMaterial(faceName.equals(hoveredFace) ? hoverMat : normalMat);
        }
        if (node instanceof Group group) {
            for (Node child : group.getChildren()) {
                highlightOrientFace(child, hoveredFace, hoverMat, normalMat);
            }
        }
    }

    /**
     * Sets the main camera's Affine transform and re-registers the sync listener for the corner overlay.
     */
    /**
     * Creates a billboard label (a textured thin box) placed at the given world coordinates.
     * The billboard always faces the camera.
     */
    /**
     * Adds a billboard label at the given world coordinates with the specified text and colour.
     * The billboard is transparent and always faces the camera.
     *
     * @param text            the label text
     * @param wx              world X coordinate
     * @param wy              world Y coordinate
     * @param wz              world Z coordinate
     * @param billboardColour colour of the text
     */
    public void addBillboard(String text, double wx, double wy, double wz, Color billboardColour) {
        Node billboard = createBillboardLabel(text, wx, wy, wz, billboardColour);
        world.getChildren().add(billboard);
    }


    private Node createBillboardLabel(String text, double wx, double wy, double wz, Color billboardColour) {

        var tm = new Text3DMesh(text, 0.1);
        tm.setDrawMode(DrawMode.FILL);
        PhongMaterial textMat = new PhongMaterial(billboardColour);
        for (var mv : tm.getMeshes()) {
            if (mv instanceof javafx.scene.shape.MeshView meshView) {
                meshView.setMaterial(textMat);
            }
        }

        Group billboard = new Group();
        billboard.getChildren().addAll(tm.getMeshes());

        Affine bbAffine = new Affine();
        bbAffine.setTx(wx);
        bbAffine.setTy(wy);
        bbAffine.setTz(wz);
        billboard.getTransforms().addFirst(bbAffine);
        billboardAffines.add(bbAffine);

        return billboard;
    }

    /**
     * Updates all billboard rotations so they always face the camera.
     */
    private void updateBillboards(Affine cameraAffine) {
        if (cameraAffine == null) {
            return;
        }
        for (Affine bbAffine : billboardAffines) {
            double tx = bbAffine.getTx();
            double ty = bbAffine.getTy();
            double tz = bbAffine.getTz();

            bbAffine.setMxx(cameraAffine.getMxx());
            bbAffine.setMxy(cameraAffine.getMxy());
            bbAffine.setMxz(cameraAffine.getMxz());
            bbAffine.setMyx(cameraAffine.getMyx());
            bbAffine.setMyy(cameraAffine.getMyy());
            bbAffine.setMyz(cameraAffine.getMyz());
            bbAffine.setMzx(cameraAffine.getMzx());
            bbAffine.setMzy(cameraAffine.getMzy());
            bbAffine.setMzz(cameraAffine.getMzz());


            bbAffine.prependScale(BILLBOARD_SCALE, BILLBOARD_SCALE, BILLBOARD_SCALE);

            bbAffine.setTx(tx);
            bbAffine.setTy(ty);
            bbAffine.setTz(tz);


        }
    }

    private void setCameraAffine(Affine newAffine) {
        camera.getTransforms().clear();
        camera.getTransforms().setAll(newAffine);
        newAffine.setOnTransformChanged(_ -> {
            syncCornerCamera(newAffine);
            updateBillboards(newAffine);
            rebuildCoordinateSystemGrid();
        });
        syncCornerCamera(newAffine);
        updateBillboards(newAffine);
        rebuildCoordinateSystemGrid();
    }

    /**
     * Copies only the rotational part of the main camera affine to the corner overlay camera.
     */
    private void syncCornerCamera(Affine source) {
        if (cornerCameraAffine == null || source == null) {
            return;
        }
        // Build rotation-only affine with fixed translation along the view axis
        cornerCameraAffine.setMxx(source.getMxx());
        cornerCameraAffine.setMxy(source.getMxy());
        cornerCameraAffine.setMxz(source.getMxz());
        cornerCameraAffine.setMyx(source.getMyx());
        cornerCameraAffine.setMyy(source.getMyy());
        cornerCameraAffine.setMyz(source.getMyz());
        cornerCameraAffine.setMzx(source.getMzx());
        cornerCameraAffine.setMzy(source.getMzy());
        cornerCameraAffine.setMzz(source.getMzz());
        // Fixed distance along the camera's forward (z column)
        double dist = 8.0;
        cornerCameraAffine.setTx(source.getMxz() * (-dist));
        cornerCameraAffine.setTy(source.getMyz() * (-dist));
        cornerCameraAffine.setTz(source.getMzz() * (-dist));
    }


    /**
     * Calculates the bounding box of a 3D node in screen coordinates.
     *
     * @param node the 3D node (e.g. worldGroup)
     * @return Rectangle2D containing the bounding box in screen coordinates
     */
    public static Rectangle2D getNodeBoundsInScreen(Node node) {
        final Point3D[] corners = getPoint3DS(node);
        double minScreenX = Double.POSITIVE_INFINITY;
        double minScreenY = Double.POSITIVE_INFINITY;
        double maxScreenX = Double.NEGATIVE_INFINITY;
        double maxScreenY = Double.NEGATIVE_INFINITY;
        for (Point3D p : corners) {
            Point2D screen = node.localToScreen(p);
            if (screen != null) {
                minScreenX = Math.min(minScreenX, screen.getX());
                minScreenY = Math.min(minScreenY, screen.getY());
                maxScreenX = Math.max(maxScreenX, screen.getX());
                maxScreenY = Math.max(maxScreenY, screen.getY());
            }
        }
        if (minScreenX == Double.POSITIVE_INFINITY) {
            return null; // node is not visible or has no valid bounds
        }
        return new Rectangle2D(minScreenX, minScreenY, maxScreenX - minScreenX, maxScreenY - minScreenY);
    }

    private static Point3D[] getPoint3DS(Node node) {
        Bounds bounds = node.getBoundsInParent();
        double minX = bounds.getMinX();
        double minY = bounds.getMinY();
        double minZ = bounds.getMinZ();
        double maxX = bounds.getMaxX();
        double maxY = bounds.getMaxY();
        double maxZ = bounds.getMaxZ();
        // 8 corners of the bounding box
        Point3D[] corners = new Point3D[]{
                new Point3D(minX, minY, minZ),
                new Point3D(minX, minY, maxZ),
                new Point3D(minX, maxY, minZ),
                new Point3D(minX, maxY, maxZ),
                new Point3D(maxX, minY, minZ),
                new Point3D(maxX, minY, maxZ),
                new Point3D(maxX, maxY, minZ),
                new Point3D(maxX, maxY, maxZ)
        };
        return corners;
    }

    public static Color withOpacity(Color color, double opacity) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity);
    }

    /**
     * Remove all children below the 'world' node
     *
     */
    public void clear() {
        world.getChildren().clear();
        billboardAffines.clear();
    }

    /**
     * Add option buttons for surface collection rendering
     *
     * @param showBoundaryCallback   callback when "Show Boundary" is toggled
     * @param limitBySurfaceCallback callback when "Limit by Boundary" is toggled
     */
    public void addSurfaceCollectionOptions(
            java.util.function.Consumer<Boolean> showBoundaryCallback,
            java.util.function.Consumer<Boolean> limitBySurfaceCallback) {

        if (bottomBar == null || bottomBar.getItems() == null) {
            return;
        }

        // Create buttons for boundary options
        var boundaryCheckBox = new CheckBox("Show Boundary");
        boundaryCheckBox.setSelected(true);
        boundaryCheckBox.setTooltip(new Tooltip("Toggle visibility of face boundary curves"));
        boundaryCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (showBoundaryCallback != null) {
                showBoundaryCallback.accept(newVal);
            }
        });

        var limitCheckBox = new CheckBox("Limit by Boundary");
        limitCheckBox.setSelected(false);
        limitCheckBox.setTooltip(new Tooltip("Limit surfaces by face boundary curves"));
        limitCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (limitBySurfaceCallback != null) {
                limitBySurfaceCallback.accept(newVal);
            }
        });

        // Add checkboxes before the spacer (before the skybox button)
        int spacerIndex = bottomBar.getItems().indexOf(bottomBar.getItems().stream()
                .filter(item -> item instanceof Region && HBox.getHgrow((Region) item) == Priority.ALWAYS)
                .findFirst()
                .orElse(null));

        if (spacerIndex >= 0) {
            bottomBar.getItems().add(spacerIndex, new Separator(Orientation.VERTICAL));
            bottomBar.getItems().add(spacerIndex + 1, boundaryCheckBox);
            bottomBar.getItems().add(spacerIndex + 2, limitCheckBox);
        } else {
            bottomBar.getItems().add(new Separator(Orientation.VERTICAL));
            bottomBar.getItems().add(boundaryCheckBox);
            bottomBar.getItems().add(limitCheckBox);
        }
    }

    /**
     * Remove option buttons for surface collection rendering
     */
    public void removeSurfaceCollectionOptions() {
        if (bottomBar == null || bottomBar.getItems() == null) {
            return;
        }

        // Remove the checkboxes and separator(s) that were added
        java.util.List<Control> toRemove = new java.util.ArrayList<>();
        for (Object item : bottomBar.getItems()) {
            if (item instanceof CheckBox checkbox &&
                    (checkbox.getText().contains("Boundary") || checkbox.getText().contains("Limit"))) {
                toRemove.add((Control) item);
            }
        }

        // Also remove separators before checkboxes if they were added
        bottomBar.getItems().removeAll(toRemove);

        // Remove trailing separator if present
        if (!bottomBar.getItems().isEmpty()) {
            Object lastItem = bottomBar.getItems().get(bottomBar.getItems().size() - 1);
            if (lastItem instanceof Separator sep && sep.getOrientation() == Orientation.VERTICAL) {
                // Check if this is our separator
                int count = 0;
                for (Object item : bottomBar.getItems()) {
                    if (item instanceof Separator s && s.getOrientation() == Orientation.VERTICAL) {
                        count++;
                    }
                }
                if (count > 1) { // Keep the main separator
                    bottomBar.getItems().remove(lastItem);
                }
            }
        }
    }

    /**
     * Show information about a provider in the info pane
     *
     * @param provider the information provider
     */
    public void showInformationProvider(InformationProvider provider) {
        if (provider == null || infoPaneContainer == null) {
            return;
        }

        selectedProvider = provider;

        // Stop any ongoing fade out animation
        if (infoPaneFadeOut != null && infoPaneFadeOut.getStatus() == javafx.animation.Animation.Status.RUNNING) {
            infoPaneFadeOut.stop();
        }

        // Clear and update the info pane
        infoPaneContainer.getChildren().clear();
        infoPaneContainer.setVisible(true);
        infoPaneContainer.setManaged(true);
        infoPaneContainer.setOpacity(1.0);

        Label titleLabel = new Label(provider.getName());
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
        titleLabel.setWrapText(true);

        TextArea infoArea = new TextArea(provider.getInformation());
        infoArea.setWrapText(true);
        infoArea.setEditable(false);
        infoArea.setPrefRowCount(5);
        VBox.setVgrow(infoArea, Priority.ALWAYS);

        infoPaneContainer.getChildren().addAll(titleLabel, new Separator(), infoArea);

        // Auto-hide info after 5 seconds
        PauseTransition hideDelay = new PauseTransition(Duration.seconds(5));
        hideDelay.setOnFinished(_ -> {
            if (infoPaneFadeOut != null) {
                infoPaneFadeOut.play();
            }
        });
        hideDelay.play();
    }
}








