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

import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.ThemeEvent;
import de.cadoculus.ocxviewer.geom.CurveGeometry;
import de.cadoculus.ocxviewer.geom.GeomHelper;
import de.cadoculus.ocxviewer.geom.GeometryQuality;
import de.cadoculus.ocxviewer.geom.PolygonSimplifier;
import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.ObjectType;
import de.cadoculus.ocxviewer.models.TargetType;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.utils.CSSUtil;
import de.cadoculus.ocxviewer.utils.ColourManager;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import jakarta.xml.bind.JAXBElement;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import net.jgeom.nurbs.ControlPoint4f;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fxyz3d.shapes.composites.PolyLine3D;
import org.ocx_schema.v3x.*;

import javax.vecmath.Point2d;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A page to show a collection of surfaces in 3D
 */
public class Surface3DCollectionPage extends AbstractDataViewSubPage<SurfaceCollection> implements Page {
    private static final Logger LOG = LogManager.getLogger(Surface3DCollectionPage.class);

    private final ThreeDView threeDView;
    private Color surfaceColour = Color.BLUE;
    private final PhongMaterial surfaceMaterial = new PhongMaterial();
    private Color boundaryColour = Color.RED;
    private final PhongMaterial boundaryMaterial = new PhongMaterial();
    private Group surfaceGroup; // Used during rendering
    private Group linesGroup;   // Used during rendering

    // Options for rendering
    private boolean showBoundary = true;
    private boolean limitSurfacesByBoundary = false;
    private boolean showShipGrid = true;
    private boolean skipAutoViewOnNextDraw = false;

    public Surface3DCollectionPage(SurfaceCollection collection, Page parent) {
        super(collection, parent, "3D View of Surface Collection «" + collection.getId() + "»");

        setId("Surface3DCollectionPage");
        final var bcs = getBreadcrumbs();
        createTitle(bcs, getName(), "3D view of a surface collection. Camera controls:" +
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

        drawSurfaceCollection();

        // Add option buttons to ThreeDView
        threeDView.addSurfaceCollectionOptions(
                showBoundary -> {
                    this.showBoundary = showBoundary;
                    this.skipAutoViewOnNextDraw = true;
                    updatedStyle();
                    drawSurfaceCollection();
                },
                limitByBoundary -> {
                    this.limitSurfacesByBoundary = limitByBoundary;
                    drawSurfaceCollection();
                },
                showShipGrid -> {
                    this.showShipGrid = showShipGrid;
                    drawSurfaceCollection();
                }
        );

        // follow changes in style
        DefaultEventBus.getInstance().subscribe( ThemeEvent.class, ignoredEvent -> {
            updatedStyle();
            drawSurfaceCollection();
        });
    }

    private void drawSurfaceCollection() {
        threeDView.clear();

        if (showShipGrid) {
            drawShipGrid();
        }

        surfaceGroup = new Group();
        surfaceGroup.setId("surfaces");

        linesGroup = new Group();
        linesGroup.setId("lines");

        threeDView.addGroupToWorld(surfaceGroup, linesGroup);

        render(getObject());
    }

    private void drawShipGrid() {
        var vessel = WorkingContext.getInstance().getVessel();
        if (vessel == null || vessel.getCoordinateSystems() == null || vessel.getCoordinateSystems().isEmpty()) {
            LOG.debug("No vessel/coordinate systems available for ship grid in surface collection view");
            return;
        }

        CoordinateSystem coosys = vessel.getCoordinateSystems().stream()
                .filter(cs -> cs != null && cs.isIsGlobal())
                .findFirst()
                .orElse(vessel.getCoordinateSystems().getFirst());

        if (coosys == null || coosys.getXRefPlanes() == null || coosys.getXRefPlanes().getRefPlanes() == null || coosys.getXRefPlanes().getRefPlanes().isEmpty()) {
            LOG.debug("No usable X reference planes for ship grid in coordinate system {}",
                    coosys != null ? coosys.getId() : "<null>");
            return;
        }

        double minX = -10;
        double maxX = 150;
        double breadth = 40;
        double height = 30;

        for (var rp : coosys.getXRefPlanes().getRefPlanes()) {
            if (rp == null || !rp.isDisplayGrid() || rp.getReferenceLocation() == null) {
                continue;
            }
            double x = UnitHelper.toDefaultUnit(rp.getReferenceLocation()) / 1000.0;
            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
        }

        minX -= 0.1 * Math.abs(maxX);
        maxX += 0.1 * Math.abs(maxX);

        if (coosys.getYRefPlanes() != null && coosys.getYRefPlanes().getRefPlanes() != null) {
            for (var rp : coosys.getYRefPlanes().getRefPlanes()) {
                if (rp == null || !rp.isDisplayGrid() || rp.getReferenceLocation() == null) {
                    continue;
                }
                breadth = Math.max(UnitHelper.toDefaultUnit(rp.getReferenceLocation()) / 500.0, breadth);
            }
            breadth *= 1.1;
        } else {
            breadth = maxX * 0.2;
        }

        if (coosys.getZRefPlanes() != null && coosys.getZRefPlanes().getRefPlanes() != null) {
            for (var rp : coosys.getZRefPlanes().getRefPlanes()) {
                if (rp == null || !rp.isDisplayGrid() || rp.getReferenceLocation() == null) {
                    continue;
                }
                height = Math.max(UnitHelper.toDefaultUnit(rp.getReferenceLocation()) / 10000.0, height);
            }
        } else {
            height = maxX * 0.2;
        }

        LOG.debug("Draw ship grid in Surface3DCollectionPage: x {}..{}, b {}, h {}", minX, maxX, breadth, height);
        threeDView.drawCoordinateSystem(minX, maxX, breadth, height);
    }

    /**
     * Render a surface collection with all its surfaces and optional face boundary curves
     */
    private void render(SurfaceCollection collection) {
        if (collection == null || collection.getSurfaces() == null || collection.getSurfaces().isEmpty()) {
            LOG.warn("Surface collection {} is empty", collection != null ? collection.getId() : "unknown");
            return;
        }

        var allBounds = new ArrayList<Point3d>();

        // Render each surface in the collection
        var legends = new HashSet<ThreeDView.LegendEntry>();
        for (JAXBElement<? extends SurfaceT> surfaceElement : collection.getSurfaces()) {
            if (surfaceElement == null || surfaceElement.getValue() == null) {
                continue;
            }

            SurfaceT surface = surfaceElement.getValue();

            // Render the surface itself
            var entry = renderIndividualSurface(surface);
            if ( entry != null) {
                legends.add(entry);
            }

            // If there's a FaceBoundaryCurve, render it as a boundary line
            if (surface.getFaceBoundaryCurve() != null) {
                var boundaryPoints = renderFaceBoundaryCurve(surface.getFaceBoundaryCurve(), surface.getId());
                if (!boundaryPoints.isEmpty()) {
                    allBounds.addAll(boundaryPoints);
                }
            }

            // Calculate bounds for camera positioning
            calculateSurfaceBounds(surface, allBounds);
        }

        // Set camera view to show all surfaces
        if (!skipAutoViewOnNextDraw && !allBounds.isEmpty()) {
            setViewForBounds(allBounds);
        }
        skipAutoViewOnNextDraw = false;
        if ( ! legends.isEmpty()) {
            threeDView.setLegend(legends.stream().sorted((o1, o2) -> o1.name().compareTo(o2.name())).toList());
        }
    }

    /**
     * Render individual surface based on its type
     */
    private ThreeDView.LegendEntry  renderIndividualSurface(SurfaceT surface) {
        try {
        var legend =  switch (surface) {
                case NURBSSurfaceT nurbsSurface -> renderNURBSSurface(nurbsSurface);
                case Cylinder3DT cylinder ->  renderCylinder(cylinder);
                case Cone3DT cone ->  renderCone(cone);
                case Sphere3DT sphere -> renderSphere(sphere);
                case ExtrudedSurfaceT extrudedSurface -> renderExtrudedSurface(extrudedSurface);
                case Plane3DT plane -> renderPlane(plane);
                default -> {
                    LOG.warn("Unsupported surface type in collection: {}", surface.getClass().getName());
                    yield null;
                }
            };
            return legend;
        } catch (Exception exp) {
            LOG.error("Error rendering surface {}: {}", surface.getId(), exp.getMessage(), exp);
            return null;
        }
    }

    /**
     * Render a FaceBoundaryCurve as a polyline
     * @param faceBoundary the FaceBoundaryCurve to render
     * @param surfaceId ID of the surface this boundary belongs to
     * @return list of points that make up the boundary
     */
    private List<Point3d> renderFaceBoundaryCurve(FaceBoundaryCurve faceBoundary, String surfaceId) {
        if (!showBoundary || faceBoundary == null || faceBoundary.getCurve3Ds() == null || faceBoundary.getCurve3Ds().isEmpty()) {
            return new ArrayList<>();
        }

        var boundaryPoints = extractFaceBoundaryCurvePoints(faceBoundary, surfaceId);

        // Visualize the boundary as a polyline
        if (!boundaryPoints.isEmpty()) {
            var boundaryPolylinePoints = new ArrayList<org.fxyz3d.geometry.Point3D>();
            for (var p : boundaryPoints) {
                boundaryPolylinePoints.add(new org.fxyz3d.geometry.Point3D(p.x, p.y, p.z));
            }

            var boundaryPolyline = new PolyLine3D(boundaryPolylinePoints, 0.25f, boundaryColour, PolyLine3D.LineType.QUADRILATERAL);
            linesGroup.getChildren().add(boundaryPolyline);
        }

        return boundaryPoints;
    }

    private List<Point3d> extractFaceBoundaryCurvePoints(FaceBoundaryCurve faceBoundary, String surfaceId) {
        if (faceBoundary == null || faceBoundary.getCurve3Ds() == null || faceBoundary.getCurve3Ds().isEmpty()) {
            return new ArrayList<>();
        }

        var boundaryPoints = new ArrayList<Point3d>();
        var ocx = WorkingContext.getInstance().getOcx();

        if (ocx == null) {
            LOG.warn("No OCX context available for rendering boundary curve of surface {}", surfaceId);
            return boundaryPoints;
        }

        // Check if boundary is in UV space or 3D space
        boolean isUVspace = faceBoundary.isIsUVspace();

        // Extract all curves from the boundary
        for (JAXBElement<? extends Curve3DT> curveElement : faceBoundary.getCurve3Ds()) {
            if (curveElement == null || curveElement.getValue() == null) {
                continue;
            }

            try {
                var curvePoints = CurveGeometry.toPoints(ocx, curveElement.getValue(), GeometryQuality.MEDIUM, false);

                if (!isUVspace) {
                    // Convert points from mm to m
                    for (var p : curvePoints) {
                        boundaryPoints.add(new Point3d(p.x / 1000.0, p.y / 1000.0, p.z / 1000.0));
                    }
                } else {
                    // UV space points - for now just convert as-is (in future could map to surface)
                    for (var p : curvePoints) {
                        boundaryPoints.add(new Point3d(p.x / 1000.0, p.y / 1000.0, p.z / 1000.0));
                    }
                }
            } catch (Exception exp) {
                LOG.warn("Error rendering boundary curve segment for surface {}: {}", surfaceId, exp.getMessage());
            }
        }
        return boundaryPoints;
    }

    /**
     * Calculate bounds of a surface for view positioning
     */
    private void calculateSurfaceBounds(SurfaceT surface, List<Point3d> bounds) {
        // This is a simplified version - just add origin/center point
        Point3DT originDT = null;
        try {
            if (surface instanceof Sphere3DT sphere) {
                originDT = sphere.getOrigin();
            } else if (surface instanceof Cone3DT cone) {
                originDT = cone.getOrigin();
            } else if (surface instanceof Cylinder3DT cylinder) {
                originDT = cylinder.getOrigin();
            }

            if (originDT != null) {
                var origin = UnitHelper.toDefaultUnit(originDT);
                origin.scale(1 / 1000.0);
                bounds.add(new Point3d(origin.x, origin.y, origin.z));
            }
        } catch (Exception exp) {
            LOG.debug("Could not extract bounds from surface {}: {}", surface.getId(), exp.getMessage());
        }
    }

    /**
     * Set camera view to encompass all boundary points
     */
    private void setViewForBounds(List<Point3d> bounds) {
        if (bounds.isEmpty()) {
            return;
        }

        // Calculate centroid
        var center = new Point3d(0, 0, 0);
        for (var p : bounds) {
            center.x += p.x;
            center.y += p.y;
            center.z += p.z;
        }
        center.scale(1.0 / bounds.size());

        // Calculate maximum distance from centroid
        double maxDist = 0;
        for (var p : bounds) {
            maxDist = Math.max(maxDist, center.distance(p));
        }

        threeDView.setView(center, new Vector3d(0, 1, 0), Math.max(2.0 * maxDist, 5.0));
    }

    // Delegate rendering to appropriate methods (simplified - actual implementation would
    // reference the implementations from Surface3DViewPage)

    private ThreeDView.LegendEntry renderNURBSSurface(NURBSSurfaceT nurbsSurface) {
        LOG.debug("Rendering NURBS surface {} in collection", nurbsSurface.getId());
        try {
            GeomHelper.checkNURBS(nurbsSurface);
        } catch (IllegalArgumentException exp) {
            LOG.warn("NURBS validation failed for {}: {}", nurbsSurface.getId(), exp.getMessage());
            return null;
        }

        final int numCtrlPtsU = (int) nurbsSurface.getUNURBSproperties().getNumCtrlPts();
        final int numCtrlPtsV = (int) nurbsSurface.getVNURBSproperties().getNumCtrlPts();
        final int degreeU = nurbsSurface.getUNURBSproperties().getDegree();
        final int degreeV = nurbsSurface.getVNURBSproperties().getDegree();

        ControlPoint4f[][] controlPoints = new ControlPoint4f[numCtrlPtsU][numCtrlPtsV];
        int ctrlPtIdx = 0;
        for (ControlPtList controlPtList : nurbsSurface.getControlPtLists()) {
            for (ControlPoint controlPoint : controlPtList.getControlPoints()) {
                if (ctrlPtIdx >= numCtrlPtsU * numCtrlPtsV) {
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

        float[] uKnots = new float[(int) nurbsSurface.getUNURBSproperties().getNumKnots()];
        for (int i = 0; i < uKnots.length; i++) {
            uKnots[i] = nurbsSurface.getUknotVector().getValues().get(i).floatValue();
        }

        float[] vKnots = new float[(int) nurbsSurface.getVNURBSproperties().getNumKnots()];
        for (int i = 0; i < vKnots.length; i++) {
            vKnots[i] = nurbsSurface.getVknotVector().getValues().get(i).floatValue();
        }

        try {
            var controlNet = new net.jgeom.nurbs.ControlNet(controlPoints);
            var nurbsSurfaceObj = new net.jgeom.nurbs.BasicNurbsSurface(controlNet, uKnots, vKnots, degreeU, degreeV);

            float startU = uKnots[0];
            float endU = uKnots[uKnots.length - 1];
            float startV = vKnots[0];
            float endV = vKnots[vKnots.length - 1];

            int segmentsU = Math.max(4, uKnots.length * 4);
            int segmentsV = Math.max(4, vKnots.length * 4);

            var mesh = new javafx.scene.shape.TriangleMesh();
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

            mesh.getTexCoords().addAll(0f, 0f);

            for (int i = 0; i < segmentsU; i++) {
                for (int j = 0; j < segmentsV; j++) {
                    int p0 = i * (segmentsV + 1) + j;
                    int p1 = i * (segmentsV + 1) + j + 1;
                    int p2 = (i + 1) * (segmentsV + 1) + j;
                    int p3 = (i + 1) * (segmentsV + 1) + j + 1;
                    mesh.getFaces().addAll(p0, 0, p2, 0, p1, 0);
                    mesh.getFaces().addAll(p1, 0, p2, 0, p3, 0);
                }
            }

            var meshView = new javafx.scene.shape.MeshView(mesh);

            var key = "NURBS ";
            key += StringUtils.isNoneEmpty(nurbsSurface.getName()) ? nurbsSurface.getId() : ", no name";
            key += StringUtils.isNoneEmpty(nurbsSurface.getId()) ? nurbsSurface.getId() : ", no ID";

            var colour = ColourManager.getColour(key, ObjectType.SURFACE, TargetType.SURFACE, false);
            final PhongMaterial material = new PhongMaterial();
            material.setDiffuseColor(colour);
            material.setSpecularColor(Color.gray(0.1));
            material.setSpecularPower(8);
            meshView.setMaterial(material);

            meshView.setCullFace(javafx.scene.shape.CullFace.NONE);
            meshView.setOnMouseClicked(event -> {
                LOG.info("Selected surface: {} ({})", nurbsSurface.getName(), nurbsSurface.getId());
                threeDView.showInformationProvider(new SurfaceInformationProvider(nurbsSurface));
                event.consume();
            });
            surfaceGroup.getChildren().add(meshView);

            if (showBoundary && nurbsSurface.getFaceBoundaryCurve() != null) {
                var boundaryPoints = renderFaceBoundaryCurve(nurbsSurface.getFaceBoundaryCurve(), nurbsSurface.getId());
                if (limitSurfacesByBoundary && !boundaryPoints.isEmpty()) {
                    LOG.debug("Boundary limiting requested for {} but clipping is not yet implemented; rendering surface mesh and boundary overlay.", nurbsSurface.getId());
                }
            }

            var center = new Point3d(0, 0, 0);
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
                    var pt = new Point3d(surfacePoints[i][j].x, surfacePoints[i][j].y, surfacePoints[i][j].z);
                    maxDist = Math.max(maxDist, center.distance(pt));
                }
            }

            //threeDView.setView(center, new Vector3d(0, 1, 0), Math.max(2.0 * maxDist, 5.0));

            return new ThreeDView.LegendEntry(key, colour);

        } catch (Exception exp) {
            LOG.error("Error rendering NURBS surface {}: {}", nurbsSurface.getId(), exp.getMessage(), exp);
            return null;
        }
    }

    private ThreeDView.LegendEntry renderCylinder(Cylinder3DT cylinder) {
        LOG.debug("Rendering cylinder {} in collection", cylinder.getId());
        try {
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


            var key = "Cylinder ";
            key += StringUtils.isNoneEmpty(cylinder.getName()) ? cylinder.getId() : ", no name";
            key += StringUtils.isNoneEmpty(cylinder.getId()) ? cylinder.getId() : ", no ID";

            Color colour = ColourManager.getColour(key, ObjectType.SURFACE, TargetType.SURFACE, false);
            if (colour == null || colour.equals(Color.BLACK)) {
                colour = surfaceColour;
            }


            var cyl = new de.cadoculus.ocxviewer.views.threed.Cylinder3D(
                    cylinder.getId(),
                    origin.x, origin.y, origin.z,
                    axis.x, axis.y, axis.z,
                    radius, height,
                    String.format("[heading=4]%s[/heading][ul]" +
                                    "[li]Radius: %.2f[/li]" +
                                    "[li]Height: %.2f[/li][/ul]",
                            cylinder.getId(), radius, height),
                    colour);

            // Add click handler to show surface name/info
            cyl.setOnMouseClicked(event -> {
                LOG.info("Selected surface: {} ({})", cylinder.getName(), cylinder.getId());
                threeDView.showInformationProvider(new SurfaceInformationProvider(cylinder));
                event.consume();
            });

            surfaceGroup.getChildren().add(cyl);

            return new ThreeDView.LegendEntry(key, colour);
        } catch (Exception exp) {
            LOG.error("Error rendering cylinder {}: {}", cylinder.getId(), exp.getMessage());
        }
        return null;
    }

    private ThreeDView.LegendEntry renderCone(Cone3DT cone) {
        LOG.debug("Rendering cone {} in collection", cone.getId());
        try {
            var key = "Cone ";
            key += StringUtils.isNoneEmpty(cone.getName()) ? cone.getId() : ", no name";
            key += StringUtils.isNoneEmpty(cone.getId()) ? cone.getId() : ", no ID";

            Color colour = ColourManager.getColour(key, ObjectType.SURFACE, TargetType.SURFACE, false);
            if (colour == null || colour.equals(Color.BLACK)) {
                colour = surfaceColour;
            }

            var origin = UnitHelper.toDefaultUnit(cone.getOrigin());
            origin.scale(1 / 1000.0);

            var tip = UnitHelper.toDefaultUnit(cone.getTip());
            tip.scale(1 / 1000.0);

            double baseRadius = UnitHelper.toDefaultUnit(cone.getBaseRadius()) / 1000.0;
            double tipRadius = cone.getTipRadius() != null
                    ? UnitHelper.toDefaultUnit(cone.getTipRadius()) / 1000.0
                    : 0.0;

            var cone3D = new de.cadoculus.ocxviewer.views.threed.Cone3D(
                    cone.getId(),
                    origin.x, origin.y, origin.z,
                    tip.x, tip.y, tip.z,
                    baseRadius, tipRadius,
                    String.format("[heading=4]%s[/heading][ul]" +
                                    "[li]Base radius: %.2f[/li]" +
                                    "[li]Tip radius: %.2f[/li][/ul]",
                            cone.getId(), baseRadius, tipRadius),
                    colour);

            // Add click handler
            cone3D.setOnMouseClicked(event -> {
                LOG.info("Selected surface: {} ({})", cone.getName(), cone.getId());
                threeDView.showInformationProvider(new SurfaceInformationProvider(cone));
                event.consume();
            });

            surfaceGroup.getChildren().add(cone3D);

            return new ThreeDView.LegendEntry(key,colour);
        } catch (Exception exp) {
            LOG.error("Error rendering cone {}: {}", cone.getId(), exp.getMessage());
        }
        return null;
    }

    private ThreeDView.LegendEntry renderSphere(Sphere3DT sphere) {
        LOG.debug("Rendering sphere {} in collection", sphere.getId());
        try {
            var key = "Sphere ";
            key += StringUtils.isNoneEmpty(sphere.getName()) ? sphere.getId() : ", no name";
            key += StringUtils.isNoneEmpty(sphere.getId()) ? sphere.getId() : ", no ID";

            Color colour = ColourManager.getColour(key, ObjectType.SURFACE, TargetType.SURFACE, false);
            if (colour == null || colour.equals(Color.BLACK)) {
                colour = surfaceColour;
            }

            var radius = UnitHelper.toDefaultUnit(sphere.getRadius()) / 1000.0;
            var origin3DT = sphere.getOrigin();
            var origin = UnitHelper.toDefaultUnit(origin3DT);
            origin.scale(1/1000.0);

            var sphere3D = new de.cadoculus.ocxviewer.views.threed.Sphere3D(sphere.getName(), radius, origin.x, origin.y, origin.z,
                    "center point at " + origin, colour);

            // Add click handler
            sphere3D.setOnMouseClicked(event -> {
                LOG.info("Selected surface: {} ({})", sphere.getName(), sphere.getId());
                threeDView.showInformationProvider(new SurfaceInformationProvider(sphere));
                event.consume();
            });

            surfaceGroup.getChildren().add(sphere3D);

            return new ThreeDView.LegendEntry(key, colour);
        } catch (Exception exp) {
            LOG.error("Error rendering sphere {}: {}", sphere.getId(), exp.getMessage());
        }
        return null;
    }

    private ThreeDView.LegendEntry renderExtrudedSurface(ExtrudedSurfaceT extrudedSurface) {
        LOG.debug("Rendering extruded surface {} in collection", extrudedSurface.getId());
        try {
            final var basePolygon = resolveBasePolygon(extrudedSurface);
            if (basePolygon == null || basePolygon.size() < 3) {
                LOG.warn("Cannot render extruded surface {}: invalid base polygon", extrudedSurface.getId());
                return null;
            }
            var key = "Extruded Surface ";
            key += StringUtils.isNoneEmpty(extrudedSurface.getName()) ? extrudedSurface.getId() : ", no name";
            key += StringUtils.isNoneEmpty(extrudedSurface.getId()) ? extrudedSurface.getId() : ", no ID";

            var colour = ColourManager.getColour(key, ObjectType.SURFACE, TargetType.SURFACE, false);

            boolean closedBaseCurve = isClosedPolygon(basePolygon);
            var meshBasePolygon = closedBaseCurve
                    ? new ArrayList<>(basePolygon.subList(0, basePolygon.size() - 1))
                    : basePolygon;

            var sweepVector = resolveSweepVector(extrudedSurface);
            if (sweepVector == null || sweepVector.lengthSquared() < 1e-12) {
                LOG.warn("Cannot render extruded surface {}: invalid sweep vector", extrudedSurface.getId());
                return null;
            }

            var topPolygon = new ArrayList<Point3d>(meshBasePolygon.size());
            for (var p : meshBasePolygon) {
                topPolygon.add(new Point3d(
                        p.x + sweepVector.x,
                        p.y + sweepVector.y,
                        p.z + sweepVector.z
                ));
            }

            var mesh = new javafx.scene.shape.TriangleMesh();
            for (var p : meshBasePolygon) {
                mesh.getPoints().addAll((float) p.x, (float) p.y, (float) p.z);
            }
            for (var p : topPolygon) {
                mesh.getPoints().addAll((float) p.x, (float) p.y, (float) p.z);
            }
            mesh.getTexCoords().addAll(0f, 0f);

            int n = meshBasePolygon.size();
            int topOffset = n;
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

            var meshView = new javafx.scene.shape.MeshView(mesh);

            final PhongMaterial material = new PhongMaterial();
            material.setDiffuseColor(colour);

            meshView.setMaterial(material);
            meshView.setCullFace(javafx.scene.shape.CullFace.NONE);
            meshView.setOnMouseClicked(event -> {
                LOG.info("Selected surface: {} ({})", extrudedSurface.getName(), extrudedSurface.getId());
                threeDView.showInformationProvider(new SurfaceInformationProvider(extrudedSurface));
                event.consume();
            });
            surfaceGroup.getChildren().add(meshView);

            if (showBoundary && extrudedSurface.getFaceBoundaryCurve() != null) {
                renderFaceBoundaryCurve(extrudedSurface.getFaceBoundaryCurve(), extrudedSurface.getId());
            }

            var baseCurvePoints = new ArrayList<Point3d>(meshBasePolygon);
            baseCurvePoints = new ArrayList<>(new PolygonSimplifier(GeometryQuality.COARSE).simplify(baseCurvePoints));
            if (closedBaseCurve && !baseCurvePoints.isEmpty() && baseCurvePoints.getFirst().distance(baseCurvePoints.getLast()) > 1e-6) {
                baseCurvePoints.add(new Point3d(baseCurvePoints.getFirst()));
            }
            if (!baseCurvePoints.isEmpty()) {
                var polylinePoints = new ArrayList<org.fxyz3d.geometry.Point3D>();
                for (var p : baseCurvePoints) {
                    polylinePoints.add(new org.fxyz3d.geometry.Point3D(p.x, p.y, p.z));
                }
                linesGroup.getChildren().add(new PolyLine3D(polylinePoints, 2.0f, boundaryColour));
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

            return new ThreeDView.LegendEntry(key, colour);

        } catch (Exception exp) {
            LOG.error("Error rendering extruded surface {}: {}", extrudedSurface.getId(), exp.getMessage(), exp);
        }
        return null;
    }

    private ThreeDView.LegendEntry  renderPlane(Plane3DT plane) {
        LOG.debug("Rendering plane {} in collection", plane.getId());
        try {

            var key = "Plane ";
            key += StringUtils.isNoneEmpty(plane.getName()) ? plane.getId() : ", no name";
            key += StringUtils.isNoneEmpty(plane.getId()) ? plane.getId() : ", no ID";

            var colour = ColourManager.getColour(key, ObjectType.SURFACE, TargetType.SURFACE, false);

            final Vector3DT normal3DT = plane.getNormal();
            var normal = new Vector3d(normal3DT.getDirections().get(0), normal3DT.getDirections().get(1), normal3DT.getDirections().get(2));
            normal.normalize();

            final Point3DT origin3DT = plane.getOrigin();
            var origin = UnitHelper.toDefaultUnit(origin3DT);
            origin.scale(1 / 1000.0);

            var boundary = plane.getFaceBoundaryCurve();
            if (boundary != null) {
                var boundaryPoints = extractFaceBoundaryCurvePoints(boundary, plane.getId());
                var boundaryMesh = createPlanarBoundaryMesh(boundaryPoints, normal);
                if (boundaryMesh != null) {
                    boundaryMesh.setOnMouseClicked(event -> {
                        LOG.info("Selected surface: {} ({})", plane.getName(), plane.getId());
                        threeDView.showInformationProvider(new SurfaceInformationProvider(plane));
                        event.consume();
                    });
                    surfaceGroup.getChildren().add(boundaryMesh);
                    return null;
                }
                LOG.warn("Plane {} has FaceBoundaryCurve but triangulation failed; fallback to rectangular Plane3D", plane.getId());
            }

            var plane3D = new de.cadoculus.ocxviewer.views.threed.Plane3D(
                    plane.getName(), origin, normal, 10, 10, colour, Color.RED);
            plane3D.setOnMouseClicked(event -> {
                LOG.info("Selected surface: {} ({})", plane.getName(), plane.getId());
                threeDView.showInformationProvider(new SurfaceInformationProvider(plane));
                event.consume();
            });
            surfaceGroup.getChildren().add(plane3D);

            return new ThreeDView.LegendEntry(key, colour);
        } catch (Exception exp) {
            LOG.error("Error rendering plane {}: {}", plane.getId(), exp.getMessage(), exp);
        }
        return null;
    }

    private javafx.scene.shape.MeshView createPlanarBoundaryMesh(List<Point3d> rawBoundaryPoints, Vector3d planeNormal) {
        if (rawBoundaryPoints == null || rawBoundaryPoints.size() < 3 || planeNormal == null || planeNormal.lengthSquared() < 1e-12) {
            return null;
        }

        var boundaryPoints = new ArrayList<Point3d>();
        Point3d last = null;
        for (var p : rawBoundaryPoints) {
            if (last == null || last.distance(p) > 1e-6) {
                boundaryPoints.add(new Point3d(p));
                last = p;
            }
        }
        if (boundaryPoints.size() > 2 && boundaryPoints.getFirst().distance(boundaryPoints.getLast()) < 1e-6) {
            boundaryPoints.removeLast();
        }
        if (boundaryPoints.size() < 3) {
            return null;
        }

        var n = new Vector3d(planeNormal);
        n.normalize();

        Vector3d u = Math.abs(n.x) < 0.9 ? new Vector3d(1, 0, 0) : new Vector3d(0, 1, 0);
        var projection = new Vector3d(n);
        projection.scale(u.dot(n));
        u.sub(projection);
        if (u.lengthSquared() < 1e-12) {
            return null;
        }
        u.normalize();

        var v = new Vector3d();
        v.cross(n, u);
        if (v.lengthSquared() < 1e-12) {
            return null;
        }
        v.normalize();

        var origin = boundaryPoints.getFirst();
        var projected = new ArrayList<Point2d>(boundaryPoints.size());
        for (var p : boundaryPoints) {
            var rel = new Vector3d(p.x - origin.x, p.y - origin.y, p.z - origin.z);
            projected.add(new Point2d(rel.dot(u), rel.dot(v)));
        }

        var triangleIndices = triangulatePolygon(projected);
        if (triangleIndices.isEmpty()) {
            return null;
        }

        var mesh = new javafx.scene.shape.TriangleMesh();
        for (var p : boundaryPoints) {
            mesh.getPoints().addAll((float) p.x, (float) p.y, (float) p.z);
        }
        mesh.getTexCoords().addAll(0f, 0f);

        for (int i = 0; i < triangleIndices.size(); i += 3) {
            int i0 = triangleIndices.get(i);
            int i1 = triangleIndices.get(i + 1);
            int i2 = triangleIndices.get(i + 2);
            mesh.getFaces().addAll(i0, 0, i1, 0, i2, 0);
        }

        var meshView = new javafx.scene.shape.MeshView(mesh);
        meshView.setMaterial(surfaceMaterial);
        meshView.setCullFace(javafx.scene.shape.CullFace.NONE);
        meshView.setOpacity(0.7);
        return meshView;
    }

    private List<Integer> triangulatePolygon(List<Point2d> polygon) {
        var result = new ArrayList<Integer>();
        if (polygon == null || polygon.size() < 3) {
            return result;
        }

        final int n = polygon.size();
        final boolean ccw = signedArea(polygon) > 0.0;
        var vertices = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            vertices.add(i);
        }

        int guard = 0;
        int maxIterations = n * n;
        while (vertices.size() > 3 && guard++ < maxIterations) {
            boolean earFound = false;
            for (int i = 0; i < vertices.size(); i++) {
                int prev = vertices.get((i - 1 + vertices.size()) % vertices.size());
                int curr = vertices.get(i);
                int next = vertices.get((i + 1) % vertices.size());

                if (!isConvex(polygon.get(prev), polygon.get(curr), polygon.get(next), ccw)) {
                    continue;
                }

                if (containsOtherPointInTriangle(polygon, vertices, prev, curr, next)) {
                    continue;
                }

                result.add(prev);
                result.add(curr);
                result.add(next);
                vertices.remove(i);
                earFound = true;
                break;
            }

            if (!earFound) {
                // Fallback for nearly degenerate polygons.
                result.clear();
                for (int i = 1; i < n - 1; i++) {
                    result.add(0);
                    result.add(i);
                    result.add(i + 1);
                }
                return result;
            }
        }

        if (vertices.size() == 3) {
            result.add(vertices.get(0));
            result.add(vertices.get(1));
            result.add(vertices.get(2));
        }

        return result;
    }

    private double signedArea(List<Point2d> polygon) {
        double area = 0.0;
        for (int i = 0; i < polygon.size(); i++) {
            var p0 = polygon.get(i);
            var p1 = polygon.get((i + 1) % polygon.size());
            area += p0.x * p1.y - p1.x * p0.y;
        }
        return 0.5 * area;
    }

    private boolean isConvex(Point2d prev, Point2d curr, Point2d next, boolean ccw) {
        double cross = (curr.x - prev.x) * (next.y - curr.y) - (curr.y - prev.y) * (next.x - curr.x);
        return ccw ? cross > 1e-12 : cross < -1e-12;
    }

    private boolean containsOtherPointInTriangle(List<Point2d> polygon, List<Integer> vertices, int a, int b, int c) {
        var pa = polygon.get(a);
        var pb = polygon.get(b);
        var pc = polygon.get(c);

        for (int idx : vertices) {
            if (idx == a || idx == b || idx == c) {
                continue;
            }
            if (pointInTriangle(polygon.get(idx), pa, pb, pc)) {
                return true;
            }
        }
        return false;
    }

    private boolean pointInTriangle(Point2d p, Point2d a, Point2d b, Point2d c) {
        double d1 = sign2d(p, a, b);
        double d2 = sign2d(p, b, c);
        double d3 = sign2d(p, c, a);

        boolean hasNeg = d1 < -1e-12 || d2 < -1e-12 || d3 < -1e-12;
        boolean hasPos = d1 > 1e-12 || d2 > 1e-12 || d3 > 1e-12;
        return !(hasNeg && hasPos);
    }

    private double sign2d(Point2d p1, Point2d p2, Point2d p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    private List<Point3d> resolveBasePolygon(ExtrudedSurfaceT extrudedSurface) {
        if (extrudedSurface == null || extrudedSurface.getBaseCurve() == null) {
            return List.of();
        }

        var ocx = WorkingContext.getInstance().getOcx();
        if (ocx == null) {
            LOG.warn("No OCX in working context while rendering base curve for extruded surface {}", extrudedSurface.getId());
            return List.of();
        }

        var points = new ArrayList<Point3d>();
        for (JAXBElement<? extends Curve3DT> wrappedCurve : extrudedSurface.getBaseCurve().getCurve3Ds()) {
            if (wrappedCurve == null || wrappedCurve.getValue() == null) {
                continue;
            }
            var curvePoints = CurveGeometry.toPoints(ocx, wrappedCurve.getValue(), GeometryQuality.MEDIUM, false);
            appendWithoutDuplicate(points, curvePoints);
        }

        var scaled = new ArrayList<Point3d>(points.size());
        for (var p : points) {
            scaled.add(new Point3d(p.x / 1000.0, p.y / 1000.0, p.z / 1000.0));
        }
        return scaled;
    }

    private boolean isClosedPolygon(List<Point3d> polygon) {
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
            Point3d end = null;
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

    private void appendWithoutDuplicate(List<Point3d> target, List<Point3d> source) {
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

    private Point3d calculatePolygonCenter(List<Point3d> polygon) {
        var center = new Point3d(0, 0, 0);
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

    /**
     * Updates the parameters used in the canvas from CSS.
     */
    private void updatedStyle() {
        try {
            CSSRecord cssRecord = CSSUtil.lookup("surfaces");
            surfaceColour = cssRecord.fill() != null ? cssRecord.fill() : surfaceColour;
            boundaryColour = cssRecord.colour1() != null ? cssRecord.colour1() : boundaryColour;

            surfaceMaterial.setDiffuseColor(surfaceColour);
            surfaceMaterial.setSpecularColor(Color.gray(0.1));
            surfaceMaterial.setSpecularPower(8);

            boundaryMaterial.setDiffuseColor(boundaryColour);
            boundaryMaterial.setSpecularColor(Color.gray(0.1));
            boundaryMaterial.setSpecularPower(8);

        } catch (Exception exp) {
            LOG.warn("failed to update style from CSS, use default values", exp);
        }
    }

    /**
     * Simple information provider for displaying surface information
     */
    private static class SurfaceInformationProvider implements de.cadoculus.ocxviewer.models.InformationProvider {
        private final SurfaceT surface;

        public SurfaceInformationProvider(SurfaceT surface) {
            this.surface = surface;
        }

        @Override
        public String getName() {
            return surface.getName() != null ? surface.getName() : surface.getId();
        }

        @Override
        public String getInformation() {
            var sb = new StringBuilder();
            sb.append("[heading=3]").append(getName()).append("[/heading]\n");
            sb.append("[ul]");
            if (surface.getId() != null) {
                sb.append("[li]ID: ").append(surface.getId()).append("[/li]");
            }
            if (surface.getName() != null) {
                sb.append("[li]Name: ").append(surface.getName()).append("[/li]");
            }
            sb.append("[li]Type: ").append(surface.getClass().getSimpleName()).append("[/li]");
            sb.append("[/ul]");
            return sb.toString();
        }
    }
}


