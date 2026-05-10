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
package de.cadoculus.ocxviewer.models.threed;

import de.cadoculus.ocxviewer.models.InformationProvider;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
 * The class represents a rectangle used to represent e.g. frame grids
 */
public class Plane3D extends Group implements InformationProvider {
	private static final Vector3d DEFAULT_NORMAL = new Vector3d(0, 0, 1);

	private final MeshView meshView;
	private final PhongMaterial material;
	private final Rotate orientation;

	private Point3d center;
	private Vector3d normal;
	private double width;
	private double height;
	private Color colour;
	private final Color highlightColour;
	private boolean highlighted;

	/**
	 * Create a new Plane3D
	 * @param id the group id
	 * @param center the plane's center point
	 * @param normal the plane's normal direction
	 * @param width the plane's width
	 * @param height the plane's height
	 * @param colour the mesh colour
	 * @param highlightColor the mesh colour used when setting state to 'highlighted'
	 */
	public Plane3D(String id, Point3d center, Vector3d normal, double width, double height,
	               Color colour, Color highlightColor) {
		this.setId(id);
		this.meshView = new MeshView();
		this.material = new PhongMaterial();
		this.orientation = new Rotate(0, new Point3D(0,0,1));

		meshView.getTransforms().add(orientation);
		// Render one front-facing triangle set per view direction.
		meshView.setCullFace(CullFace.BACK);
		meshView.setMaterial(material);
		getChildren().add(meshView);

		setWidth(width);
		setHeight(height);
		setCenter(center);
		setNormal(normal);
		setColour(colour);
		this.highlightColour = highlightColor;

	}


	public Point3d getCenter() {
		return center;
	}

	public void setCenter(Point3d center) {
		if (center == null) {
			throw new IllegalArgumentException("center must not be null");
		}
		this.center = center;
		setTranslateX(center.getX());
		setTranslateY(center.getY());
		setTranslateZ(center.getZ());
	}

	public Vector3d getNormal() {
		return normal;
	}

	public void setNormal(Vector3d normal) {
		if (normal == null || normal.length() < 1e-1) {
			throw new IllegalArgumentException("normal must not be null or zero");
		}
		normal.normalize();
		this.normal =normal;
		updateOrientation();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width <= 0) {
			throw new IllegalArgumentException("width must be > 0");
		}
		this.width = width;
		rebuildMesh();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalArgumentException("height must be > 0");
		}
		this.height = height;
		rebuildMesh();
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		if (colour == null) {
			throw new IllegalArgumentException("color must not be null");
		}
		this.colour = colour;
		updateMaterial();
	}

	public boolean isHighlighted() {
		return highlighted;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
		updateMaterial();
	}

	private void updateMaterial() {
		Color base = colour == null ? Color.LIGHTGRAY : colour;
		Color high = highlightColour != null ? highlightColour: base.brighter();
		if (highlighted) {
			material.setDiffuseColor(high);
			material.setSpecularColor(Color.WHITE);
			material.setSpecularPower(64);
		} else {
			material.setDiffuseColor(base);
			material.setSpecularColor(Color.gray(0.1));
			material.setSpecularPower(8);
		}
	}

	private void rebuildMesh() {
		float halfWidth = (float) (width / 2.0);
		float halfHeight = (float) (height / 2.0);

		TriangleMesh mesh = new TriangleMesh();
		mesh.getPoints().setAll(
				-halfWidth, -halfHeight, 0,
				halfWidth, -halfHeight, 0,
				halfWidth, halfHeight, 0,
				-halfWidth, halfHeight, 0
		);
		mesh.getTexCoords().setAll(
				0, 0,
				1, 0,
				1, 1,
				0, 1
		);
		mesh.getFaces().setAll(
				// Front side
				0, 0, 1, 1, 2, 2,
				0, 0, 2, 2, 3, 3,
				// Back side (reversed winding)
				2, 2, 1, 1, 0, 0,
				3, 3, 2, 2, 0, 0
		);
		meshView.setMesh(mesh);
	}

	private void updateOrientation() {
		double dot = Math.clamp(DEFAULT_NORMAL.dot( normal), -1.0, 1.0);

		if (dot > 0.999999) {
			orientation.setAxis(Rotate.Z_AXIS);
			orientation.setAngle(0.0);
			return;
		}

		if (dot < -0.999999) {
			orientation.setAxis(Rotate.X_AXIS);
			orientation.setAngle(180.0);
			return;
		}

		Vector3d axis = new Vector3d();
		axis.cross(DEFAULT_NORMAL, normal);
		axis.normalize();
		double angle = Math.toDegrees(Math.acos(dot));
		orientation.setAxis(new Point3D(axis.x, axis.y, axis.z));
		orientation.setAngle(angle);
	}


	@Override
	public String toString() {
		return String.format("Plane3D{id='%s', center=(%.1f, %.1f, %.1f), normal=(%.3f, %.3f, %.3f), size=%.0f×%.0f}",
				getId(),
				center.getX(), center.getY(), center.getZ(),
				normal.getX(), normal.getY(), normal.getZ(),
				width, height);
	}

	@Override
	public String getName() {
		return getId();
	}

	@Override
	public String getInformation() {
		StringBuilder sb = new StringBuilder();
		sb.append("[heading=4]").append( getId()).append("[/heading][ul]");
		sb.append(String.format("[li]Center: (%.1f, %.1f, %.1f)[/li]", center.getX(), center.getY(), center.getZ()));
		sb.append(String.format("[li]Normal: (%.1f, %.1f, %.1f)[/li]", normal.getX(), normal.getY(), normal.getZ()));
		sb.append("[/ul]");

		return sb.toString();
	}
}
