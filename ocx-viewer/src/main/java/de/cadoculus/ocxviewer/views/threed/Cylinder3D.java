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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import javax.vecmath.Vector3d;

/**
 * An open cylindrical surface (no top or bottom caps) defined by an origin,
 * revolution-axis direction, radius and height.
 * <p>
 * The mesh is built in local space with the axis along +Z (base at z=0, top at z=height)
 * and then rotated so that +Z aligns with the supplied axis direction.
 */
public class Cylinder3D extends Group implements InformationProvider {

    private static final int DIVISIONS = 36;
    private static final Vector3d LOCAL_Z = new Vector3d(0, 0, 1);

    private final String name;
    private final String information;

    /**
     * @param name        display name / node id
     * @param originX     world X of the cylinder base centre
     * @param originY     world Y of the cylinder base centre
     * @param originZ     world Z of the cylinder base centre
     * @param axisX       X component of the revolution axis (need not be normalised)
     * @param axisY       Y component of the revolution axis
     * @param axisZ       Z component of the revolution axis
     * @param radius      cylinder radius
     * @param height      cylinder height along the axis
     * @param information BBCode text shown in the info pane on hover
     * @param colour      surface colour
     */
    public Cylinder3D(String name,
                      double originX, double originY, double originZ,
                      double axisX, double axisY, double axisZ,
                      double radius, double height,
                      String information, Color colour) {
        setId(name);
        this.name = name;
        this.information = information;

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(colour != null ? colour : Color.STEELBLUE);
        material.setSpecularColor(Color.gray(0.2));
        material.setSpecularPower(16);

        MeshView meshView = new MeshView(buildLateralMesh(radius, height));
        meshView.setMaterial(material);
        meshView.setCullFace(CullFace.BACK);

        Vector3d axis = new Vector3d(axisX, axisY, axisZ);
        if (axis.length() > 1e-9) {
            axis.normalize();
        }
        applyAxisRotation(meshView, axis);

        getChildren().add(meshView);
        setTranslateX(originX);
        setTranslateY(originY);
        setTranslateZ(originZ);
    }

    // -----------------------------------------------------------------------
    // Mesh construction
    // -----------------------------------------------------------------------

    /**
     * Builds a TriangleMesh for the open lateral surface of a cylinder.
     * The base ring sits at z=0, the top ring at z=height; both rings have
     * {@code DIVISIONS} vertices evenly spaced around the circumference.
     */
    private static TriangleMesh buildLateralMesh(double radius, double height) {
        int n = DIVISIONS;

        // 2*n points: [0..n-1] base ring, [n..2n-1] top ring
        float[] pts = new float[n * 2 * 3];
        for (int i = 0; i < n; i++) {
            double angle = 2.0 * Math.PI * i / n;
            float cx = (float) (radius * Math.cos(angle));
            float cy = (float) (radius * Math.sin(angle));
            pts[i * 3]           = cx;
            pts[i * 3 + 1]       = cy;
            pts[i * 3 + 2]       = 0f;
            pts[(n + i) * 3]     = cx;
            pts[(n + i) * 3 + 1] = cy;
            pts[(n + i) * 3 + 2] = (float) height;
        }

        // (n+1) columns × 2 rows (bottom u,0 / top u,1); extra column closes the seam cleanly
        float[] tex = new float[(n + 1) * 4];
        for (int i = 0; i <= n; i++) {
            float u = (float) i / n;
            tex[i * 4]     = u;
            tex[i * 4 + 1] = 0f;
            tex[i * 4 + 2] = u;
            tex[i * 4 + 3] = 1f;
        }

        // n quads → 4 triangles each: front pair + back pair with reversed winding.
        // CullFace.BACK + doubled triangles gives correct PhongMaterial lighting on
        // both sides; CullFace.NONE would darken back faces due to inverted normals.
        int[] faces = new int[n * 24];
        for (int i = 0; i < n; i++) {
            int b0  = i;
            int b1  = (i + 1) % n;
            int t0  = n + i;
            int t1  = n + (i + 1) % n;
            int tb0 = i * 2;
            int tb1 = (i + 1) * 2;
            int tt0 = i * 2 + 1;
            int tt1 = (i + 1) * 2 + 1;

            int base = i * 24;
            // front triangle 1: b0 → b1 → t1
            faces[base]      = b0;  faces[base + 1]  = tb0;
            faces[base + 2]  = b1;  faces[base + 3]  = tb1;
            faces[base + 4]  = t1;  faces[base + 5]  = tt1;
            // front triangle 2: b0 → t1 → t0
            faces[base + 6]  = b0;  faces[base + 7]  = tb0;
            faces[base + 8]  = t1;  faces[base + 9]  = tt1;
            faces[base + 10] = t0;  faces[base + 11] = tt0;
            // back triangle 1 (reversed): t1 → b1 → b0
            faces[base + 12] = t1;  faces[base + 13] = tt1;
            faces[base + 14] = b1;  faces[base + 15] = tb1;
            faces[base + 16] = b0;  faces[base + 17] = tb0;
            // back triangle 2 (reversed): t0 → t1 → b0
            faces[base + 18] = t0;  faces[base + 19] = tt0;
            faces[base + 20] = t1;  faces[base + 21] = tt1;
            faces[base + 22] = b0;  faces[base + 23] = tb0;
        }

        TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().setAll(pts);
        mesh.getTexCoords().setAll(tex);
        mesh.getFaces().setAll(faces);
        return mesh;
    }

    // -----------------------------------------------------------------------
    // Orientation
    // -----------------------------------------------------------------------

    /** Appends a Rotate transform to {@code node} so that +Z maps to {@code axis}. */
    private static void applyAxisRotation(Node node, Vector3d axis) {
        double dot = Math.max(-1.0, Math.min(1.0, LOCAL_Z.dot(axis)));
        if (dot > 0.999999) {
            return; // already aligned
        }
        Rotate rotate;
        if (dot < -0.999999) {
            rotate = new Rotate(180.0, Rotate.X_AXIS);
        } else {
            Vector3d rotAxis = new Vector3d();
            rotAxis.cross(LOCAL_Z, axis);
            rotAxis.normalize();
            rotate = new Rotate(Math.toDegrees(Math.acos(dot)),
                    new javafx.geometry.Point3D(rotAxis.x, rotAxis.y, rotAxis.z));
        }
        node.getTransforms().add(rotate);
    }

    // -----------------------------------------------------------------------
    // InformationProvider
    // -----------------------------------------------------------------------

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return information;
    }
}
