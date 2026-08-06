/*
 * jgeom: Geometry Library for Java
 * 
 * Copyright (C) 2005  Samuel Gerber
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package net.jgeom.nurbs.util;

import javax.vecmath.Point3f;

public class GeomUtils {
	static public int[] convertQuadIndexesToTriangleIndexes(int[] indexes) {
		int[] indexesTriangles = new int[(int) (indexes.length * 2)];
		int indTri = 0;
		for (int i = 0; i < indexes.length; i += 4) {
			int v1 = indexes[i];
			int v2 = indexes[i + 1];
			int v3 = indexes[i + 2];
			int v4 = indexes[i + 3];

			// 1 2 => 1 2 + 2
			// 4 3 4 4 3
			// indexesTriangles[indTri++]=v1;
			// indexesTriangles[indTri++]=v4;
			// indexesTriangles[indTri++]=v2;
			// indexesTriangles[indTri++]=v4;
			// indexesTriangles[indTri++]=v3;
			// indexesTriangles[indTri++]=v2;

			indexesTriangles[indTri++] = v1;
			indexesTriangles[indTri++] = v2;
			indexesTriangles[indTri++] = v4;
			indexesTriangles[indTri++] = v4;
			indexesTriangles[indTri++] = v2;
			indexesTriangles[indTri++] = v3;

		}
		return indexesTriangles;
	}
	
	static public Point3f[] convertIndexedTrianglesToFlat(int[]indexes,Point3f[]coordinates)
	{
		Point3f[] triangles=new Point3f[indexes.length];
		for(int i=0;i<triangles.length;i++)
			triangles[i]=coordinates[indexes[i]];
		return triangles;
	}

	static public void generateNormals(int ntriang, int[] triang,
			float[] verts, float[] flatverts, float[] flatnormals) {
		// double[] flatverts=new double[9*ntriang];
		// double[] flatnormals=new double[9*ntriang];
		
		float[] p0 = new float[3];
		float[] p1 = new float[3];
		float[] p2 = new float[3];
		float[] x1 = new float[3];
		float[] x2 = new float[3];
		float[] n2 = new float[3];
		double dist;
		int i0, i1, i2, j;
		float conversionFactor = 1f;
		int idx = 0;
		int nidx = 0;
		boolean generateNormals = true;
		boolean normalPerVertex = true;

		for (j = 0; j < ntriang; j++) {
			if (triang != null) {
				i0 = triang[3 * j];
				i1 = triang[3 * j + 1];
				i2 = triang[3 * j + 2];
			} else {
				i0 = j;
				i1 = j + 1;
				i2 = j + 2;
			}

			p0[0] = verts[3 * i0] * conversionFactor;
			p0[1] = verts[3 * i0 + 1] * conversionFactor;
			p0[2] = verts[3 * i0 + 2] * conversionFactor;

			p1[0] = verts[3 * i1] * conversionFactor;
			p1[1] = verts[3 * i1 + 1] * conversionFactor;
			p1[2] = verts[3 * i1 + 2] * conversionFactor;

			p2[0] = verts[3 * i2] * conversionFactor;
			p2[1] = verts[3 * i2 + 1] * conversionFactor;
			p2[2] = verts[3 * i2 + 2] * conversionFactor;

			flatverts[idx++] = p0[0];
			flatverts[idx++] = p0[1];
			flatverts[idx++] = p0[2];
			flatverts[idx++] = p1[0];
			flatverts[idx++] = p1[1];
			flatverts[idx++] = p1[2];
			flatverts[idx++] = p2[0];
			flatverts[idx++] = p2[1];
			flatverts[idx++] = p2[2];

			if (generateNormals) {
				if (normalPerVertex) {
					// take position, normalize
					normalize(p0);
					flatnormals[nidx++] = p0[0];
					flatnormals[nidx++] = p0[1];
					flatnormals[nidx++] = p0[2];
					normalize(p1);
					flatnormals[nidx++] = p1[0];
					flatnormals[nidx++] = p1[1];
					flatnormals[nidx++] = p1[2];
					normalize(p2);
					flatnormals[nidx++] = p2[0];
					flatnormals[nidx++] = p2[1];
					flatnormals[nidx++] = p2[2];
				} else {
					x1[0] = p1[0] - p0[0];
					x2[0] = p2[0] - p0[0];
					x1[1] = p1[1] - p0[1];
					x2[1] = p2[1] - p0[1];
					x1[2] = p1[2] - p0[2];
					x2[2] = p2[2] - p0[2];
					/*
					 * CROSS(n2, x1, x2); #define CROSS(a,b,c) a[0] =
					 * (b[1]*c[2]) - (b[2]*c[1]);\ a[1] = (b[2]*c[0]) -
					 * (b[0]*c[2]);\ a[2] = (b[0]*c[1]) - (b[1]*c[0])
					 */
					n2[0] = (x1[1] * x2[2]) - (x1[2] * x2[1]);
					n2[1] = (x1[2] * x2[0]) - (x1[0] * x2[2]);
					n2[2] = (x1[0] * x2[1]) - (x1[1] * x2[0]);
					/*
					 * dist = DOT(n2, n2); // Dot Production Defintion #define
					 * DOT(a,b) (a[0]*b[0] + a[1]*b[1] + a[2]*b[2])
					 */
					dist = n2[0] * n2[0] + n2[1] * n2[1] + n2[2] * n2[2];

					if (dist == 0.0) {
						System.out
								.println(" Warning Zero area tri" + j + "!\n");
					} else {
						dist = 1.0 / Math.sqrt(dist);
					}

					n2[0] *= dist;
					n2[1] *= dist;
					n2[2] *= dist;

					flatnormals[nidx++] = n2[0];
					flatnormals[nidx++] = n2[1];
					flatnormals[nidx++] = n2[2];
					flatnormals[nidx++] = n2[0];
					flatnormals[nidx++] = n2[1];
					flatnormals[nidx++] = n2[2];
					flatnormals[nidx++] = n2[0];
					flatnormals[nidx++] = n2[1];
					flatnormals[nidx++] = n2[2];
				}
			}
		}
	}

	/**
	 * Normalize a vector.
	 * 
	 * @param vec
	 *            The vector to normalize
	 */
	static void normalize(float[] vec) {
		float norm;

		norm = (float) (1.0 / Math.sqrt(vec[0] * vec[0] + vec[1] * vec[1]
				+ vec[2] * vec[2]));
		vec[0] = vec[0] * norm;
		vec[1] = vec[1] * norm;
		vec[2] = vec[2] * norm;
	}
}
