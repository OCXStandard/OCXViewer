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

import atlantafx.base.theme.Styles;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.ThemeEvent;
import de.cadoculus.ocxviewer.geom.GeomHelper;
import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.threed.Plane3D;
import de.cadoculus.ocxviewer.models.threed.Point3D;
import de.cadoculus.ocxviewer.models.threed.Sphere3D;
import de.cadoculus.ocxviewer.utils.CSSUtil;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fxyz3d.geometry.Vector3D;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.*;

import javax.vecmath.Vector3d;

import static de.cadoculus.ocxviewer.geom.MainPlane.*;

/**
 * A page to show a single surface
 */
public class Surface3DViewPage extends AbstractDataViewSubPage<org.ocx_schema.v310.SurfaceT> implements Page {
    private static final Logger LOG = LogManager.getLogger(Surface3DViewPage.class);

    private final ThreeDView threeDView;
    private Color surfaceColour = Color.BLUE;
    private final PhongMaterial surfaceMaterial = new PhongMaterial();
    private Color pointsColour = Color.DARKGRAY;
    private PhongMaterial pointsMaterial = new PhongMaterial();
    private Color line1Colour = Color.RED;
    private PhongMaterial line1Material = new PhongMaterial();
    private Color line2Colour = Color.GREEN;
    private PhongMaterial line2Material = new PhongMaterial();
    private Group surfaceGroup;
    private Group pointsGroup;
    private Group linesGroup;


    public Surface3DViewPage(org.ocx_schema.v310.SurfaceT surface, Page parent) {
        super(surface, parent, "3D View of Surface «" + surface.getId() + "»");

        setId("Surface3DViewPage");
        final var bcs = getBreadcrumbs();
        createTitle(bcs, getName(), "3D view of a surface.  Camera controls:" +
                "Zoom: <Ctrl><+> and <Ctrl><-> zoom in and out. Also available using <Ctrl><Scrollwheel>\n" +
                "Pan: <Left>, <Right>, <Up>, <Down> pan. Also available using pressed middle mouse button\n"+
                "Rotate: using pressed left mouse button. Double click with the middle mouse button sets the rotation center.\n" +
                "Use <R>, <P>, <Y> to roll, pitch, or yaw the camera. Adding <CTRL> gives fine control, <SHIFT> inverts the direction"
        );

        if (getTop() instanceof VBox titleBox) {
            titleBox.setPadding(new Insets(10));
            titleBox.setSpacing(5);
        }

        updatedStyle();

        threeDView = new ThreeDView();
        threeDView.setId(getId() + "_3DView");
        this.setCenter(threeDView);

        drawSurface();

        // follow changes in style
        DefaultEventBus.getInstance().subscribe( ThemeEvent.class, themeEvent -> {
            updatedStyle();
            drawSurface();
        });

    }

    private void drawSurface() {

        threeDView.clear();
        //threeDView.drawCoordinateSystem(minX, maxX, breadth, height);

        surfaceGroup = new Group();
        surfaceGroup.setId("surface");

        pointsGroup = new Group();
        pointsGroup.setId("points");

        linesGroup = new Group();
        linesGroup.setId("lines");

        threeDView.addGroupToWorld(surfaceGroup, pointsGroup, linesGroup);

        switch (getObject()) {
            case NURBSSurfaceT nurbsSurface -> render(nurbsSurface);
            case Cylinder3DT cylinder -> render(cylinder);
            case Cone3DT cone -> render(cone);
            case Sphere3DT sphere -> render(sphere);
            case ExtrudedSurfaceT extrudedSurface -> render(extrudedSurface);
            case Plane3DT plane -> render(plane);
            default -> {
                LOG.warn("found unsupported Surface type: {}", getObject().getClass().getName());

                var warning = new atlantafx.base.controls.Message(
                        "Warning",
                        "Not implemented yet",
                        new FontIcon(MaterialDesignA.ALERT)
                );
                warning.getStyleClass().add(Styles.WARNING);

                setCenter(warning);
            }
        }


    }

    private void render(Plane3DT plane3DT) {

        final Vector3DT normal3DT = plane3DT.getNormal();
        var normal = new Vector3d(normal3DT.getDirections().get(0), normal3DT.getDirections().get(1), normal3DT.getDirections().get(2));
        normal.normalize();

        var uDir = new Vector3d(0,0,0);
        Vector3DT uDirection3DT = plane3DT.getUDirection();
        if (uDirection3DT != null && uDirection3DT.getDirections().size() >= 3) {
            uDir = new Vector3d(
                    uDirection3DT.getDirections().get(0),
                    uDirection3DT.getDirections().get(1),
                    uDirection3DT.getDirections().get(2)
            );
            if (uDir.lengthSquared() > 1e-12) {
                orthogonalizeToNormal(uDir, normal);
                if (uDir.lengthSquared() > 1e-12) {
                    uDir.normalize();
                }
            }
        } else {
            uDir = calculateDefaultPlaneUDirection(normal);
        }


        final Point3DT origin3DT = plane3DT.getOrigin();
        var origin = UnitHelper.toDefaultUnit(origin3DT);
        origin.scale(1 / 1000.0);

        var plane = new Plane3D(
                plane3DT.getName(), origin, normal, 10, 10, surfaceColour, Color.RED);
        surfaceGroup.getChildren().add(plane);

        var center = new Point3D(plane3DT.getId() + " centre", origin.x, origin.y, origin.z, "center point at " + origin);
        pointsGroup.getChildren().add(center);

        var mainPlane = GeomHelper.getMainPlane(normal);
        Vector3d viewDirection =null;
        if (XPLANE == mainPlane) {
            viewDirection = new Vector3d(-1, 0, 0); // looking from Fore
        } else if (YPLANE == mainPlane) {
            viewDirection = new Vector3d(0, 1, 0); // looking from SB
        } else if (ZPLANE == mainPlane) {
            viewDirection = new Vector3d(0, 0, -1); // looking from Top
        }
        threeDView.setView(origin, viewDirection, 10);

    }


    private void render(ExtrudedSurfaceT extrudedSurface) {


    }

    private void render(Sphere3DT sphere3DT) {

        var radius = UnitHelper.toDefaultUnit(sphere3DT.getRadius()) / 1000.0;
        var origin3DT = sphere3DT.getOrigin();
        var origin = UnitHelper.toDefaultUnit(origin3DT);
        origin.scale(1/1000.0);

        var sphere = new Sphere3D(sphere3DT.getName(), radius, origin.x, origin.y, origin.z, "center point at " + origin, surfaceColour);
        surfaceGroup.getChildren().add(sphere);

        var center = new Point3D(sphere3DT.getId() + " centre", origin.x, origin.y, origin.z, "center point at " + origin);
        pointsGroup.getChildren().add(center);

        threeDView.setView(origin, new Vector3d(0,1,0),radius*3);

    }



    private void render(Cone3DT cone) {
        
    }

    private void render(Cylinder3DT cylinder) {

    }

    private void render(NURBSSurfaceT nurbsSurface) {

    }

    /**
     * Updates the parameters used in the canvas from CSS.
     */
    private void updatedStyle() {
        try {
            CSSRecord cssRecord = CSSUtil.lookup("surfaces");
            surfaceColour = cssRecord.fill() != null ? cssRecord.fill() : surfaceColour;

            surfaceMaterial.setDiffuseColor(surfaceColour);
            surfaceMaterial.setSpecularColor(Color.gray(0.1));
            surfaceMaterial.setSpecularPower(8);

            pointsColour = cssRecord.colour1() != null ? cssRecord.colour1() : pointsColour;
            line1Colour = cssRecord.colour2() != null ? cssRecord.colour2() : line1Colour;
            line2Colour = cssRecord.colour2() != null ? cssRecord.colour2() : line2Colour;

        } catch (Exception exp) {
            LOG.warn("failed to update style from CSS, use default values", exp);
        }
    }



    private Vector3d calculateDefaultPlaneUDirection(Vector3d normal) {
        var normalizedNormal = new Vector3d(normal);
        normalizedNormal.normalize();

        var referenceAxis = Math.abs(normalizedNormal.x) > Math.abs(normalizedNormal.y)
                ? new Vector3d(0, 1, 0)
                : new Vector3d(1, 0, 0);

        var uDir = new Vector3d(referenceAxis);
        orthogonalizeToNormal(uDir, normalizedNormal);

        if (uDir.lengthSquared() <= 1e-12) {
            referenceAxis.set(0, 0, 1);
            uDir.set(referenceAxis);
            orthogonalizeToNormal(uDir, normalizedNormal);
        }

        uDir.normalize();
        return uDir;
    }

    private void orthogonalizeToNormal(Vector3d direction, Vector3d normal) {
        double projection = direction.dot(normal);
        var normalComponent = new Vector3d(normal);
        normalComponent.scale(projection);
        direction.sub(normalComponent);
    }

}
