/*
 * Copyright 2026 Carsten Zerbst
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
package de.cadoculus.ocxviewer.views.threed;

import de.cadoculus.ocxviewer.models.InformationProvider;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Translate;
import org.fxyz3d.shapes.primitives.Text3DMesh;

import javax.vecmath.Vector3d;

/**
 * Radius dimension annotation: a thin radial line from a centre point to the
 * circumference, a cone arrowhead at the rim, and a text label — styled like a
 * technical drawing radius callout.
 * <p>
 * The dimension line is drawn in the plane perpendicular to the supplied axis,
 * choosing a radial direction that is also perpendicular to the axis.
 */
public class RadiusDimension3D extends Group implements InformationProvider {

    private final String name;
    private final String information;

    /**
     * @param name    node id
     * @param cx      world X of the centre (on the revolution axis)
     * @param cy      world Y of the centre
     * @param cz      world Z of the centre
     * @param axisX   X component of the revolution axis (normalised internally)
     * @param axisY   Y component of the revolution axis
     * @param axisZ   Z component of the revolution axis
     * @param radius  radius value in world units
     * @param label   text shown on the dimension line, e.g. "R = 1.23 m"
     * @param colour  dimension and text colour
     */
    public RadiusDimension3D(String name,
                              double cx, double cy, double cz,
                              double axisX, double axisY, double axisZ,
                              double radius,
                              String label,
                              Color colour) {
        setId(name);
        this.name = name;
        this.information = "[heading=4]Radius dimension[/heading][ul][li]" + label + "[/li][/ul]";

        Color c = colour != null ? colour : Color.DARKGRAY;

        Vector3d axis = new Vector3d(axisX, axisY, axisZ);
        if (axis.length() > 1e-9) axis.normalize();

        // radialDir: perpendicular to axis — the direction of the dimension line
        Vector3d radialDir = new Vector3d();
        radialDir.cross(axis, Math.abs(axis.x) < 0.9 ? new Vector3d(1, 0, 0) : new Vector3d(0, 1, 0));
        radialDir.normalize();

        // tangDir: perpendicular to both axis and radialDir — text reading direction
        Vector3d tangDir = new Vector3d();
        tangDir.cross(radialDir, axis);
        tangDir.normalize();

        double arrowHeight = radius * 0.15;
        double arrowBaseR  = radius * 0.05;
        double lineRadius  = radius * 0.015;
        double textHeight  = radius * 0.18;

        // Thin rod from centre to (rim - arrowHeight)
        double lineLength = radius - arrowHeight;
        if (lineLength > 1e-9) {
            var rod = new Cylinder3D(name + "_rod",
                    cx, cy, cz,
                    radialDir.x, radialDir.y, radialDir.z,
                    lineRadius, lineLength,
                    label, c);
            getChildren().add(rod);
        }

        // Arrowhead cone: base at (rim - arrowHeight), tip at rim
        double abX = cx + radialDir.x * (radius - arrowHeight);
        double abY = cy + radialDir.y * (radius - arrowHeight);
        double abZ = cz + radialDir.z * (radius - arrowHeight);
        double atX = cx + radialDir.x * radius;
        double atY = cy + radialDir.y * radius;
        double atZ = cz + radialDir.z * radius;
        var arrow = new Cone3D(name + "_arrow",
                abX, abY, abZ, atX, atY, atZ,
                arrowBaseR, 0.0, label, c);
        getChildren().add(arrow);

        // Text label positioned just past the arrowhead, centred on the radial line
        if ( false) {
            var tm = new Text3DMesh(label, 1.0);
            PhongMaterial textMat = new PhongMaterial(c);
            tm.getMeshes().forEach(mv -> mv.setMaterial(textMat));

            Group rawText = new Group();
            rawText.getChildren().addAll(tm.getMeshes());
            Bounds tb = rawText.getBoundsInLocal();

            // Centre text geometry at its own local origin
            rawText.getTransforms().add(new Translate(
                    -(tb.getMinX() + tb.getWidth() / 2.0),
                    -(tb.getMinY() + tb.getHeight() / 2.0),
                    0));

            // World position: just past the arrowhead tip along radialDir
            double tpX = cx + radialDir.x * (radius + arrowHeight * 0.6);
            double tpY = cy + radialDir.y * (radius + arrowHeight * 0.6);
            double tpZ = cz + radialDir.z * (radius + arrowHeight * 0.6);

            // Affine maps text-local → world:
            //   text +X (reading direction)  → tangDir   (tangential, so label reads "around" the axis)
            //   text +Y (character height)   → axis       (upward along cylinder axis)
            //   text +Z (depth toward viewer) → radialDir (faces the camera looking perpendicular to axis)
            Affine af = new Affine(
                    tangDir.x * textHeight, axis.x * textHeight, radialDir.x * textHeight, tpX,
                    tangDir.y * textHeight, axis.y * textHeight, radialDir.y * textHeight, tpY,
                    tangDir.z * textHeight, axis.z * textHeight, radialDir.z * textHeight, tpZ
            );
            Group textGroup = new Group(rawText);
            textGroup.getTransforms().add(af);
            getChildren().add(textGroup);
        }
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getInformation() { return information; }
}
