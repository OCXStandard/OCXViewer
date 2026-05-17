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
import de.cadoculus.ocxviewer.geom.CurveGeometry;
import de.cadoculus.ocxviewer.geom.GeomHelper;
import de.cadoculus.ocxviewer.geom.GeometryQuality;
import de.cadoculus.ocxviewer.geom.PolygonSimplifier;
import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.views.threed.Cone3D;
import de.cadoculus.ocxviewer.views.threed.Cylinder3D;
import de.cadoculus.ocxviewer.views.threed.Plane3D;
import de.cadoculus.ocxviewer.views.threed.Point3D;
import de.cadoculus.ocxviewer.views.threed.RadiusDimension3D;
import de.cadoculus.ocxviewer.views.threed.Sphere3D;
import de.cadoculus.ocxviewer.utils.CSSUtil;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import org.fxyz3d.shapes.composites.PolyLine3D;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import jakarta.xml.bind.JAXBElement;
import net.jgeom.nurbs.BasicNurbsSurface;
import net.jgeom.nurbs.ControlNet;
import net.jgeom.nurbs.ControlPoint4f;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.ocx_schema.v310.*;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        final var basePolygon = resolveBasePolygon(extrudedSurface);
        if (basePolygon == null || basePolygon.size() < 3) {
            LOG.warn("Cannot render extruded surface {}: invalid base polygon", extrudedSurface.getId());
            return;
        }

        boolean closedBaseCurve = isClosedPolygon(basePolygon);
        var meshBasePolygon = closedBaseCurve
                ? new ArrayList<>(basePolygon.subList(0, basePolygon.size() - 1))
                : basePolygon;

        var sweepVector = resolveSweepVector(extrudedSurface);
        if (sweepVector == null || sweepVector.lengthSquared() < 1e-12) {
            LOG.warn("Cannot render extruded surface {}: invalid sweep vector", extrudedSurface.getId());
            return;
        }

        var topPolygon = new ArrayList<javax.vecmath.Point3d>(meshBasePolygon.size());
        for (var p : meshBasePolygon) {
            topPolygon.add(new javax.vecmath.Point3d(
                    p.x + sweepVector.x,
                    p.y + sweepVector.y,
                    p.z + sweepVector.z
            ));
        }

        var mesh = new TriangleMesh();
        for (var p : meshBasePolygon) {
            mesh.getPoints().addAll((float) p.x, (float) p.y, (float) p.z);
        }
        for (var p : topPolygon) {
            mesh.getPoints().addAll((float) p.x, (float) p.y, (float) p.z);
        }

        // JavaFX TriangleMesh always needs at least one texCoord.
        mesh.getTexCoords().addAll(0f, 0f);

        int n = meshBasePolygon.size();
        int topOffset = n;

        // side quads split into two triangles
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            if (next >= n) {
                if (!closedBaseCurve) {
                    break;
                }
                next = 0;
            }
            int i0 = i;
            int i1 = next;
            int j0 = topOffset + i;
            int j1 = topOffset + next;

            mesh.getFaces().addAll(i0, 0, i1, 0, j1, 0);
            mesh.getFaces().addAll(i0, 0, j1, 0, j0, 0);
        }

        var meshView = new MeshView(mesh);
        meshView.setMaterial(surfaceMaterial);
        meshView.setCullFace(CullFace.NONE);
        surfaceGroup.getChildren().add(meshView);

        // Add polyline for base curve
        var baseCurvePoints = new ArrayList<javax.vecmath.Point3d>(meshBasePolygon);
      //  baseCurvePoints = new ArrayList<>(new PolygonSimplifier(de.cadoculus.ocxviewer.geom.GeometryQuality.COARSE).simplify(baseCurvePoints));
        if (closedBaseCurve && !baseCurvePoints.isEmpty() && baseCurvePoints.getFirst().distance(baseCurvePoints.getLast()) > 1e-6) {
            baseCurvePoints.add(new javax.vecmath.Point3d(baseCurvePoints.getFirst()));
        }
        if (!baseCurvePoints.isEmpty()) {
            var polylinePoints = new ArrayList<org.fxyz3d.geometry.Point3D>();
            for (var p : baseCurvePoints) {
                polylinePoints.add(new org.fxyz3d.geometry.Point3D(p.x, p.y, p.z));
            }
            var baseCurvePolyline = new PolyLine3D(polylinePoints, 0.25f, line1Colour, PolyLine3D.LineType.QUADRILATERAL);
            linesGroup.getChildren().add(baseCurvePolyline);
        }

        // Add polyline for sweep curve if available
        var ocx = WorkingContext.getInstance().getOcx();
        if (ocx != null && extrudedSurface.getSweepCurve() != null) {
            var sweepCurvePoints = CurveGeometry.toPoints(ocx, extrudedSurface.getSweepCurve(), GeometryQuality.MEDIUM, false);
            if (!sweepCurvePoints.isEmpty()) {
                var sweepPolylinePoints = new ArrayList<org.fxyz3d.geometry.Point3D>();
                for (var p : sweepCurvePoints) {
                    sweepPolylinePoints.add(new org.fxyz3d.geometry.Point3D(p.x / 1000.0, p.y / 1000.0, p.z / 1000.0));
                }
                var sweepCurvePolyline = new PolyLine3D(sweepPolylinePoints, 0.25f, line2Colour, PolyLine3D.LineType.QUADRILATERAL);
                linesGroup.getChildren().add(sweepCurvePolyline);
            }
        }

        var center = calculatePolygonCenter(basePolygon);
        var viewDirection = new Vector3d(-sweepVector.x, -sweepVector.y, -sweepVector.z);
        if (viewDirection.lengthSquared() < 1e-12) {
            viewDirection = new Vector3d(0, 1, 0);
        }

        double radius = 0.0;
        for (var p : basePolygon) {
            radius = Math.max(radius, p.distance(center));
        }
        double sweepLength = sweepVector.length();
        threeDView.setView(center, viewDirection, Math.max(2.0 * radius, 2.0 * sweepLength));
    }

    private List<javax.vecmath.Point3d> resolveBasePolygon(ExtrudedSurfaceT extrudedSurface) {
        if (extrudedSurface == null || extrudedSurface.getBaseCurve() == null) {
            return List.of();
        }

        var ocx = WorkingContext.getInstance().getOcx();
        if (ocx == null) {
            LOG.warn("No OCX in working context while rendering base curve for extruded surface {}", extrudedSurface.getId());
            return List.of();
        }

        var points = new ArrayList<javax.vecmath.Point3d>();
        for (JAXBElement<? extends Curve3DT> wrappedCurve : extrudedSurface.getBaseCurve().getCurve3Ds()) {
            if (wrappedCurve == null || wrappedCurve.getValue() == null) {
                continue;
            }
            var curvePoints = CurveGeometry.toPoints(ocx, wrappedCurve.getValue(), GeometryQuality.MEDIUM, false);
            appendWithoutDuplicate(points, curvePoints);
        }

        // convert mm -> m for 3D view consistency
        var scaled = new ArrayList<javax.vecmath.Point3d>(points.size());
        for (var p : points) {
            scaled.add(new javax.vecmath.Point3d(p.x / 1000.0, p.y / 1000.0, p.z / 1000.0));
        }
        return scaled;
    }

    private boolean isClosedPolygon(List<javax.vecmath.Point3d> polygon) {
        return polygon != null && polygon.size() > 2 && polygon.getFirst().distance(polygon.getLast()) < 1e-6;
    }

    private Vector3d resolveSweepVector(ExtrudedSurfaceT extrudedSurface) {
        if (extrudedSurface.getSweep() != null) {
            var sweep = extrudedSurface.getSweep();
            var vector3D = sweep.getVector3D();
            if (vector3D != null && vector3D.getDirections() != null && vector3D.getDirections().size() >= 3) {
                var sweepVector = new Vector3d(
                        vector3D.getDirections().get(0),
                        vector3D.getDirections().get(1),
                        vector3D.getDirections().get(2)
                );
                if (sweepVector.lengthSquared() > 1e-12) {
                    sweepVector.normalize();
                    double length = UnitHelper.toDefaultUnit(sweep.getSweepLength()) / 1000.0;
                    sweepVector.scale(length);
                    return sweepVector;
                }
            }
        }

        if (extrudedSurface.getSweepCurve() != null) {
            var ocx = WorkingContext.getInstance().getOcx();
            if (ocx == null) {
                return null;
            }

            var sweepPoints = CurveGeometry.toPoints(ocx, extrudedSurface.getSweepCurve(), GeometryQuality.MEDIUM, false);
            if (sweepPoints.size() < 2) {
                return null;
            }

            var start = sweepPoints.getFirst();
            javax.vecmath.Point3d end = null;
            for (int i = sweepPoints.size() - 1; i >= 1; i--) {
                if (sweepPoints.get(i).distance(start) > 1e-6) {
                    end = sweepPoints.get(i);
                    break;
                }
            }
            if (end == null) {
                end = sweepPoints.getLast();
            }

            var sweepVector = new Vector3d(
                    (end.x - start.x) / 1000.0,
                    (end.y - start.y) / 1000.0,
                    (end.z - start.z) / 1000.0
            );
            if (sweepVector.lengthSquared() > 1e-12) {
                return sweepVector;
            }
        }

        return null;
    }

    private void appendWithoutDuplicate(List<javax.vecmath.Point3d> target, List<javax.vecmath.Point3d> source) {
        if (source == null || source.isEmpty()) {
            return;
        }
        if (target.isEmpty()) {
            target.addAll(source);
            return;
        }

        var last = target.getLast();
        int startIndex = source.getFirst().distance(last) < 1e-6 ? 1 : 0;
        for (int i = startIndex; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }

    private javax.vecmath.Point3d calculatePolygonCenter(List<javax.vecmath.Point3d> polygon) {
        var center = new javax.vecmath.Point3d(0, 0, 0);
        if (polygon == null || polygon.isEmpty()) {
            return center;
        }
        for (var p : polygon) {
            center.x += p.x;
            center.y += p.y;
            center.z += p.z;
        }
        center.scale(1.0 / polygon.size());
        return center;
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
        var origin = UnitHelper.toDefaultUnit(cone.getOrigin());
        origin.scale(1 / 1000.0);

        var tip = UnitHelper.toDefaultUnit(cone.getTip());
        tip.scale(1 / 1000.0);

        double baseRadius = UnitHelper.toDefaultUnit(cone.getBaseRadius()) / 1000.0;
        double tipRadius = cone.getTipRadius() != null
                ? UnitHelper.toDefaultUnit(cone.getTipRadius()) / 1000.0
                : 0.0;

        var cone3D = new Cone3D(
                cone.getId(),
                origin.x, origin.y, origin.z,
                tip.x, tip.y, tip.z,
                baseRadius, tipRadius,
                String.format(Locale.ENGLISH, "[heading=4]%s[/heading][ul]" +
                                "[li]Origin: (%.2f, %.2f, %.2f)[/li]" +
                                "[li]Tip: (%.2f, %.2f, %.2f)[/li]" +
                                "[li]Base radius: %.2f[/li]" +
                                "[li]Tip radius: %.2f[/li][/ul]",
                        cone.getId(), origin.x, origin.y, origin.z,
                        tip.x, tip.y, tip.z, baseRadius, tipRadius),
                surfaceColour);
        surfaceGroup.getChildren().add(cone3D);

        pointsGroup.getChildren().add(new Point3D(cone.getId() + " origin",
                origin.x, origin.y, origin.z, "base centre at " + origin));
        pointsGroup.getChildren().add(new Point3D(cone.getId() + " tip",
                tip.x, tip.y, tip.z, "tip centre at " + tip));

        // Look at the cone centre from a direction perpendicular to the axis
        var axis = new Vector3d(tip.x - origin.x, tip.y - origin.y, tip.z - origin.z);
        double height = axis.length();
        axis.normalize();
        var perp = new Vector3d();
        perp.cross(axis, Math.abs(axis.x) < 0.9 ? new Vector3d(1, 0, 0) : new Vector3d(0, 1, 0));
        perp.normalize();
        var viewCenter = new javax.vecmath.Point3d(
                origin.x + axis.x * height / 2,
                origin.y + axis.y * height / 2,
                origin.z + axis.z * height / 2);
        threeDView.setView(viewCenter, perp, Math.max(baseRadius, height) * 3);

        // Axis line
        double coneAxisRadius = Math.max(baseRadius, tipRadius) * 0.04;
        linesGroup.getChildren().add(new Cylinder3D(
                cone.getId() + " axis",
                origin.x, origin.y, origin.z,
                axis.x, axis.y, axis.z,
                coneAxisRadius, height,
                String.format(Locale.ENGLISH, "[heading=4]Axis[/heading][ul]" +
                   "[li]dir: (%.2f, %.2f, %.2f)[/li][/UL]", axis.x, axis.y, axis.z),
                line1Colour));

        // Base radius dimension
        linesGroup.getChildren().add(new RadiusDimension3D(
                cone.getId() + " R_base",
                origin.x, origin.y, origin.z,
                axis.x, axis.y, axis.z,
                baseRadius,
                String.format("R_base = %.3f m", baseRadius),
                line2Colour));

        // Tip radius dimension (only when tip is not a sharp point)
        if (tipRadius > 1e-6) {
            linesGroup.getChildren().add(new RadiusDimension3D(
                    cone.getId() + " R_tip",
                    tip.x, tip.y, tip.z,
                    axis.x, axis.y, axis.z,
                    tipRadius,
                    String.format("R_tip = %.3f m", tipRadius),
                    line2Colour));
        }
    }

    private void render(Cylinder3DT cylinder) {
        var origin = UnitHelper.toDefaultUnit(cylinder.getOrigin());
        origin.scale(1 / 1000.0);

        Vector3DT axisDT = cylinder.getAxis();
        var axis = new Vector3d(
                axisDT.getDirections().get(0),
                axisDT.getDirections().get(1),
                axisDT.getDirections().get(2));
        axis.normalize();

        double radius = UnitHelper.toDefaultUnit(cylinder.getRadius()) / 1000.0;
        double height = UnitHelper.toDefaultUnit(cylinder.getHeight()) / 1000.0;

        var cyl = new Cylinder3D(
                cylinder.getId(),
                origin.x, origin.y, origin.z,
                axis.x, axis.y, axis.z,
                radius, height,
                String.format("[heading=4]%s[/heading][ul]" +
                                "[li]Origin: (%.2f, %.2f, %.2f)[/li]" +
                                "[li]Axis: (%.3f, %.3f, %.3f)[/li]" +
                                "[li]Radius: %.2f[/li]" +
                                "[li]Height: %.2f[/li][/ul]",
                        cylinder.getId(), origin.x, origin.y, origin.z,
                        axis.x, axis.y, axis.z, radius, height),
                surfaceColour);
        surfaceGroup.getChildren().add(cyl);

        // Base centre and top centre points
        pointsGroup.getChildren().add(new Point3D(cylinder.getId() + " origin",
                origin.x, origin.y, origin.z, "base centre at " + origin));
        double topX = origin.x + axis.x * height;
        double topY = origin.y + axis.y * height;
        double topZ = origin.z + axis.z * height;
        pointsGroup.getChildren().add(new Point3D(cylinder.getId() + " top",
                topX, topY, topZ, "top centre at (" + topX + ", " + topY + ", " + topZ + ")"));

        // Axis line as a thin cylinder from base to top centre
        double axisRadius = Math.max(radius * 0.04, height * 0.005);
        var axisLine = new Cylinder3D(
                cylinder.getId() + " axis",
                origin.x, origin.y, origin.z,
                axis.x, axis.y, axis.z,
                axisRadius, height,
                String.format(Locale.ENGLISH, "[heading=4]Axis[/heading][ul]" +
                        "[li]dir: (%.2f, %.2f, %.2f)[/li][/UL]", axis.x, axis.y, axis.z),
                line1Colour);
        linesGroup.getChildren().add(axisLine);

        // Radius dimension at mid-height
        double midX = origin.x + axis.x * height / 2;
        double midY = origin.y + axis.y * height / 2;
        double midZ = origin.z + axis.z * height / 2;
        linesGroup.getChildren().add(new RadiusDimension3D(
                cylinder.getId() + " R",
                midX, midY, midZ,
                axis.x, axis.y, axis.z,
                radius,
                String.format("R = %.3f m", radius),
                line2Colour));

        // Look at the cylinder midpoint from a direction perpendicular to the axis
        var perp = new Vector3d();
        perp.cross(axis, Math.abs(axis.x) < 0.9 ? new Vector3d(1, 0, 0) : new Vector3d(0, 1, 0));
        perp.normalize();
        var viewCenter = new javax.vecmath.Point3d(
                origin.x + axis.x * height / 2,
                origin.y + axis.y * height / 2,
                origin.z + axis.z * height / 2);
        threeDView.setView(viewCenter, perp, Math.max(radius, height) * 3);
    }

    private void render(NURBSSurfaceT nurbsSurface) {
        try {
            GeomHelper.checkNURBS(nurbsSurface);
        } catch (IllegalArgumentException exp) {
            LOG.warn("NURBS validation failed: {}", exp.getMessage());
            return;
        }

        // Extract control points from OCX and organize into 2D matrix
        final int numCtrlPtsU = (int) nurbsSurface.getUNURBSproperties().getNumCtrlPts();
        final int numCtrlPtsV = (int) nurbsSurface.getVNURBSproperties().getNumCtrlPts();
        final int degreeU = nurbsSurface.getUNURBSproperties().getDegree();
        final int degreeV = nurbsSurface.getVNURBSproperties().getDegree();

        ControlPoint4f[][] controlPoints = new ControlPoint4f[numCtrlPtsU][numCtrlPtsV];
        int ctrlPtIdx = 0;

        // Iterate through control point lists and organize by (u, v) position
        for (ControlPtList controlPtList : nurbsSurface.getControlPtLists()) {
            for (ControlPoint controlPoint : controlPtList.getControlPoints()) {
                if (ctrlPtIdx >= numCtrlPtsU * numCtrlPtsV) {
                    LOG.warn("NURBS surface has more control points than expected");
                    break;
                }

                int u = ctrlPtIdx / numCtrlPtsV;
                int v = ctrlPtIdx % numCtrlPtsV;

                var point = UnitHelper.toDefaultUnit(controlPoint);
                controlPoints[u][v] = new ControlPoint4f(
                        (float) (point.x / 1000.0),
                        (float) (point.y / 1000.0),
                        (float) (point.z / 1000.0),
                        (float) controlPoint.getWeight()
                );
                ctrlPtIdx++;
            }
        }

        // Extract knot vectors
        float[] uKnots = new float[(int) nurbsSurface.getUNURBSproperties().getNumKnots()];
        for (int i = 0; i < uKnots.length; i++) {
            uKnots[i] = nurbsSurface.getUknotVector().getValues().get(i).floatValue();
        }

        float[] vKnots = new float[(int) nurbsSurface.getVNURBSproperties().getNumKnots()];
        for (int i = 0; i < vKnots.length; i++) {
            vKnots[i] = nurbsSurface.getVknotVector().getValues().get(i).floatValue();
        }

        // Create NURBS surface
        try {
            var controlNet = new ControlNet(controlPoints);
            var nurbsSurfaceObj = new BasicNurbsSurface(controlNet, uKnots, vKnots, degreeU, degreeV);

            // Evaluate surface at multiple u,v parameter values
            float startU = uKnots[0];
            float endU = uKnots[uKnots.length - 1];
            float startV = vKnots[0];
            float endV = vKnots[vKnots.length - 1];

            // Heuristic: use approximately knot count times 4 segments
            int segmentsU = Math.max(4, uKnots.length * 4);
            int segmentsV = Math.max(4, vKnots.length * 4);

            var mesh = new TriangleMesh();

            // Store surface points in a 2D grid and build mesh
            Point3f[][] surfacePoints = new Point3f[segmentsU + 1][segmentsV + 1];

            for (int i = 0; i <= segmentsU; i++) {
                float u = startU + (endU - startU) * i / segmentsU;
                for (int j = 0; j <= segmentsV; j++) {
                    float v = startV + (endV - startV) * j / segmentsV;
                    Point3f point = nurbsSurfaceObj.pointOnSurface(u, v);
                    surfacePoints[i][j] = point;
                    mesh.getPoints().addAll(point.x, point.y, point.z);
                }
            }

            // Always need at least one texture coordinate
            mesh.getTexCoords().addAll(0f, 0f);

            // Build triangles
            for (int i = 0; i < segmentsU; i++) {
                for (int j = 0; j < segmentsV; j++) {
                    int p0 = i * (segmentsV + 1) + j;
                    int p1 = i * (segmentsV + 1) + j + 1;
                    int p2 = (i + 1) * (segmentsV + 1) + j;
                    int p3 = (i + 1) * (segmentsV + 1) + j + 1;

                    // First triangle
                    mesh.getFaces().addAll(p0, 0, p2, 0, p1, 0);
                    // Second triangle
                    mesh.getFaces().addAll(p1, 0, p2, 0, p3, 0);
                }
            }

            var meshView = new MeshView(mesh);
            meshView.setMaterial(surfaceMaterial);
            meshView.setCullFace(CullFace.NONE);
            surfaceGroup.getChildren().add(meshView);

            // Calculate view center and direction
            var center = new javax.vecmath.Point3d(0, 0, 0);
            double maxDist = 0;

            for (int i = 0; i <= segmentsU; i++) {
                for (int j = 0; j <= segmentsV; j++) {
                    center.x += surfacePoints[i][j].x;
                    center.y += surfacePoints[i][j].y;
                    center.z += surfacePoints[i][j].z;
                }
            }
            int totalPoints = (segmentsU + 1) * (segmentsV + 1);
            center.scale(1.0 / totalPoints);

            for (int i = 0; i <= segmentsU; i++) {
                for (int j = 0; j <= segmentsV; j++) {
                    var pt = new javax.vecmath.Point3d(surfacePoints[i][j].x, surfacePoints[i][j].y, surfacePoints[i][j].z);
                    maxDist = Math.max(maxDist, center.distance(pt));
                }
            }

            threeDView.setView(center, new Vector3d(0, 1, 0), Math.max(2.0 * maxDist, 5.0));

        } catch (IllegalArgumentException exp) {
            LOG.error("Failed to create NURBS surface: {}", exp.getMessage(), exp);
        }
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
