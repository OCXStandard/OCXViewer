/**
 * PolyLine3D.java
 *
 * Copyright (c) 2013-2018, F(X)yz
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of F(X)yz, any associated website, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL F(X)yz BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package org.fxyz3d.shapes.composites;

import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import org.fxyz3d.geometry.Point3D;

import java.util.List;

/**
 *
 * @author Sean
 */
public class PolyLine3D extends Group {
    
    public List<Point3D> points;
    public float width = 2.0f;
    public Color color = Color.WHITE;
    private TriangleMesh mesh;
    public MeshView meshView;
    public PhongMaterial material;
    public static enum LineType {RIBBON, TRIANGLE, QUADRILATERAL};

    @Deprecated
    public PolyLine3D(List<Point3D> points, int width, Color color) {
        this(points, Float.valueOf(width), color);
    }
    //Creates a Ribbon PolyLine3D
    public PolyLine3D(List<Point3D> points, float width, Color color) {
        this(points, width, color, LineType.RIBBON);          
    }
    @Deprecated
    public PolyLine3D(List<Point3D> points, int width, Color color, LineType lineType ) {
        this(points, Float.valueOf(width), color, lineType);
    }
    //Creates a PolyLine3D with the user's choice of mesh style
    public PolyLine3D(List<Point3D> points, float width, Color color, LineType lineType ) {
        this.points = points;
        this.width = width;
        this.color = color;
        setDepthTest(DepthTest.ENABLE);        
        mesh  = new TriangleMesh();
        switch(lineType) {
            case TRIANGLE: buildTriangleTube(); break;
            case QUADRILATERAL: buildQuadrilateralTube(); break;
            case RIBBON:
            default: buildRibbon(); break;
        }
        //Need to add the mesh to a MeshView before adding to our 3D scene 
        meshView = new MeshView(mesh);
        meshView.setDrawMode(DrawMode.FILL);  //Fill so that the line shows width
        material = new PhongMaterial(color);
        material.setDiffuseColor(color);
        material.setSpecularColor(color);
        meshView.setMaterial(material); 
        //Make sure you Cull the Back so that no black shows through
        meshView.setCullFace(CullFace.BACK);

        //Add some ambient light so folks can see it
        AmbientLight light = new AmbientLight(Color.WHITE);
        light.getScope().add(meshView);
        getChildren().add(light);
        getChildren().add(meshView);           
    }

    private void buildTriangleTube() {
        //For each data point add three mesh points as an equilateral triangle
        float half = width / 2.0f;
        for(Point3D point: points) {
            //-0.288675f*hw, -0.5f*hw, -0.204124f*hw,
            mesh.getPoints().addAll(point.x - 0.288675f*half, point.y - 0.5f*half, point.z - 0.204124f*half);
            //-0.288675f*hw, 0.5f*hw, -0.204124f*hw, 
            mesh.getPoints().addAll(point.x - 0.288675f*half, point.y + 0.5f*half, point.z - 0.204124f*half);
            //0.57735f*hw, 0f, -0.204124f*hw
            mesh.getPoints().addAll(point.x + 0.57735f*half, point.y + 0.5f*half, point.z - 0.204124f*half);
        }
        //add dummy Texture Coordinate
        mesh.getTexCoords().addAll(0,0); 
        //Beginning End Cap
        mesh.getFaces().addAll(0,0, 1,0, 2,0);
        //Now generate trianglestrips between each point 
        for(int i=3;i<points.size()*3;i+=3) {  //add each triangle tube segment 
            //Vertices wound counter-clockwise which is the default front face of any Triange
            //Triangle Tube Face 1
            mesh.getFaces().addAll(i+2,0, i-2,0, i+1,0); //add secondary Width face
            mesh.getFaces().addAll(i+2,0, i-1,0, i-2,0); //add primary face
            //Triangle Tube Face 2
            mesh.getFaces().addAll(i+2,0, i-3,0, i-1,0); //add secondary Width face
            mesh.getFaces().addAll(i,0, i-3,0, i+2,0); //add primary face
            //Triangle Tube Face 3
            mesh.getFaces().addAll(i,0, i+1,0, i-3,0); //add primary face
            mesh.getFaces().addAll(i+1,0, i-2,0, i-3,0); //add secondary Width face
        }        
        //Final End Cap
        int last = points.size()*3 -1;
        mesh.getFaces().addAll(last,0, last-1,0, last-2,0);
    }
    private void buildRibbon() {
        //add each point. For each point add another point shifted on Z axis by width
        //This extra point allows us to build triangles later
        for(Point3D point: points) {
            mesh.getPoints().addAll(point.x,point.y,point.z);
            mesh.getPoints().addAll(point.x,point.y,point.z+width);
        }
        //add dummy Texture Coordinate
        mesh.getTexCoords().addAll(0,0); 
        //Now generate trianglestrips for each line segment
        for(int i=2;i<points.size()*2;i+=2) {  //add each segment
            //Vertices wound counter-clockwise which is the default front face of any Triange
            //These triangles live on the frontside of the line facing the camera
            mesh.getFaces().addAll(i,0,i-2,0,i+1,0); //add primary face
            mesh.getFaces().addAll(i+1,0,i-2,0,i-1,0); //add secondary Width face
            //Add the same faces but wind them clockwise so that the color looks correct when camera is rotated
            //These triangles live on the backside of the line facing away from initial the camera
            mesh.getFaces().addAll(i+1,0,i-2,0,i,0); //add primary face
            mesh.getFaces().addAll(i-1,0,i-2,0,i+1,0); //add secondary Width face
        }        
    }

    /**
     * Builds a tube with rectangular (quadrilateral) cross section.
     *
     * The local orientation at each polyline point uses incoming/outgoing segment directions,
     * and start/end are capped with a simple rectangle (two triangles each).
     */
    private void buildQuadrilateralTube() {
        if (points == null || points.size() < 2) {
            return;
        }

        float half = width / 2.0f;
        int count = points.size();

        Point3D[] tangents = new Point3D[count];
        Point3D[] planeNormals = new Point3D[count];

        // Tangents and turning-plane normals
        for (int i = 0; i < count; i++) {
            Point3D prevDir;
            Point3D nextDir;

            if (i == 0) {
                prevDir = direction(points.get(0), points.get(1));
                nextDir = prevDir;
            } else if (i == count - 1) {
                prevDir = direction(points.get(i - 1), points.get(i));
                nextDir = prevDir;
            } else {
                prevDir = direction(points.get(i - 1), points.get(i));
                nextDir = direction(points.get(i), points.get(i + 1));
            }

            Point3D tangent = normalize(prevDir.add(nextDir));
            if (isNearZero(tangent)) {
                tangent = normalize(nextDir);
            }
            tangents[i] = tangent;

            Point3D planeNormal = normalize(prevDir.crossProduct(nextDir));
            if (isNearZero(planeNormal)) {
                if (i > 0 && planeNormals[i - 1] != null && !isNearZero(planeNormals[i - 1])) {
                    planeNormal = planeNormals[i - 1];
                } else {
                    planeNormal = orthogonalTo(tangent);
                }
            }
            planeNormals[i] = planeNormal;
        }

        // Four vertices per polyline point
        for (int i = 0; i < count; i++) {
            Point3D t = tangents[i];
            Point3D nPlane = planeNormals[i];

            // One axis lies in the turning plane; the second closes an orthonormal frame
            Point3D axisA = normalize(nPlane.crossProduct(t));
            if (isNearZero(axisA)) {
                axisA = orthogonalTo(t);
            }
            Point3D axisB = normalize(t.crossProduct(axisA));
            if (isNearZero(axisB)) {
                axisB = orthogonalTo(axisA);
            }

            Point3D p = points.get(i);

            Point3D p0 = p.add(axisA.multiply(half)).add(axisB.multiply(half));
            Point3D p1 = p.add(axisA.multiply(-half)).add(axisB.multiply(half));
            Point3D p2 = p.add(axisA.multiply(-half)).add(axisB.multiply(-half));
            Point3D p3 = p.add(axisA.multiply(half)).add(axisB.multiply(-half));

            mesh.getPoints().addAll(p0.x, p0.y, p0.z);
            mesh.getPoints().addAll(p1.x, p1.y, p1.z);
            mesh.getPoints().addAll(p2.x, p2.y, p2.z);
            mesh.getPoints().addAll(p3.x, p3.y, p3.z);
        }

        mesh.getTexCoords().addAll(0, 0);

        // Side quads between successive rings (as two triangles); add both windings for robustness.
        for (int i = 1; i < count; i++) {
            int prevBase = (i - 1) * 4;
            int currBase = i * 4;

            for (int k = 0; k < 4; k++) {
                int kn = (k + 1) % 4;

                int a = prevBase + k;
                int b = prevBase + kn;
                int c = currBase + kn;
                int d = currBase + k;

                addTwoSidedQuad(a, b, c, d);
            }
        }

        // Start cap (rectangle as two triangles, both windings)
        addTwoSidedQuad(0, 1, 2, 3);

        // End cap
        int endBase = (count - 1) * 4;
        addTwoSidedQuad(endBase, endBase + 1, endBase + 2, endBase + 3);
    }

    private void addTwoSidedQuad(int a, int b, int c, int d) {
        // front
        mesh.getFaces().addAll(a, 0, b, 0, c, 0);
        mesh.getFaces().addAll(a, 0, c, 0, d, 0);
        // back
        mesh.getFaces().addAll(c, 0, b, 0, a, 0);
        mesh.getFaces().addAll(d, 0, c, 0, a, 0);
    }

    private Point3D direction(Point3D from, Point3D to) {
        return normalize(to.substract(from));
    }

    private Point3D normalize(Point3D p) {
        return p == null ? new Point3D(0, 0, 0) : p.normalize();
    }

    private boolean isNearZero(Point3D p) {
        return p == null || p.magnitude() < 1e-6f;
    }

    private Point3D orthogonalTo(Point3D v) {
        Point3D ref = Math.abs(v.z) < 0.9f ? new Point3D(0, 0, 1) : new Point3D(0, 1, 0);
        Point3D ortho = normalize(v.crossProduct(ref));
        if (isNearZero(ortho)) {
            ortho = normalize(v.crossProduct(new Point3D(1, 0, 0)));
        }
        return ortho;
    }
}