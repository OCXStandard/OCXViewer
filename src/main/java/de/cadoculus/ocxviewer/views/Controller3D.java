package de.cadoculus.ocxviewer.views;


import de.cadoculus.ocxviewer.models.ViewDirections;
import javafx.beans.binding.Bindings;
import javafx.geometry.Point2D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;

/**
 * This class controls the interaction in the 3D view
 *
 * <ul>
 *     <li>Ctrl + scroll wheel: zoom in / out</li>
 * </ul>
 *
 * @author Carsten Zerbst
 */
public class Controller3D {
    private Point2D oldPos;
    private final Camera camera;
    private final Group root;

    private static final double ZOOM_SENSITIVITY = 1;
    private static final double PAN_SENSITIVITY = 1;


    public Controller3D(Group groud3D, Camera camera3d,  Pane container) {

        this.camera = camera3d;
        this.root = groud3D;

        Rotate rX = new Rotate(0, Rotate.X_AXIS);
        Rotate rY = new Rotate(0, Rotate.Y_AXIS);

        groud3D.getTransforms().addAll(rX, rY);

        container.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            oldPos = new Point2D(event.getSceneX(), event.getSceneY());
        });

        container.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            if ( oldPos != null) {
            if (event.getButton() == javafx.scene.input.MouseButton.MIDDLE) {
                double dx = oldPos.getX() - event.getSceneX();
                double dy = oldPos.getY() - event.getSceneY();
                camera3d.setTranslateX(camera3d.getTranslateX() + dx*PAN_SENSITIVITY);
                camera3d.setTranslateY(camera3d.getTranslateY() + dy*PAN_SENSITIVITY);
                oldPos = new Point2D(event.getSceneX(), event.getSceneY());
                event.consume();
            } else if (event.getButton() == MouseButton.PRIMARY) {


                    double newAngleX = rX.getAngle() - (oldPos.getY() - event.getSceneY());
                    rX.setAngle(newAngleX > 90 ? 90 : newAngleX < -90 ? -90 : newAngleX);
                    rY.setAngle(rY.getAngle() + oldPos.getX() - event.getSceneX());
                    oldPos = new Point2D(event.getSceneX(), event.getSceneY());
                }

            }
            event.consume();
        });




        container.addEventHandler(ScrollEvent.SCROLL, event -> {
            if (event.isControlDown()) {
                // Beispiel: Spezieller Zoom bei gedrückter Ctrl-Taste
                double delta = event.getDeltaY();
                camera3d.setTranslateZ(camera3d.getTranslateZ() - delta * ZOOM_SENSITIVITY);
                event.consume(); // verhindert weitere Verarbeitung
                return;
            }
        });

    }

    public void zoomAll() {

    }

    public void zoomOut() {
        camera.setTranslateZ(camera.getTranslateZ()/ 1.05);
    }

    public void zoomIn() {

        camera.setTranslateZ(camera.getTranslateZ()* 1.05);
    }

    public void setViewDirection(ViewDirections viewDirections) {

    }
}
