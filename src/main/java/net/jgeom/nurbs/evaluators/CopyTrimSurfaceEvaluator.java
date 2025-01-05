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
package net.jgeom.nurbs.evaluators;

import net.jgeom.nurbs.NurbsSurface;
import net.jgeom.nurbs.TrimCurve;
import net.jgeom.nurbs.UVCoord2f;
import net.jgeom.nurbs.geomContainers.GeometryArray;
import net.jgeom.nurbs.geomContainers.IndexedQuadArray;

import javax.vecmath.Point2f;
import javax.vecmath.Point3f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Evaluates a NurbsSurface with TrimCurves into a PointArray. All points that
 * are trimmed are not int the PoinArray and therefore not drawn.
 * 
 * @author sg
 * @version 1.0
 */
/**
 * @author alex
 * 
 */
public class CopyTrimSurfaceEvaluator extends TrimEvaluator {

	NurbsSurface surface = null;

	class Coordinate {
		public Point3f position;

		public float u;

		public float v;

		boolean trimmed;

		public Coordinate(Point3f point, float u, float v, boolean trimmed) {
			this.u = u;
			this.v = v;
			this.position = point;
			this.trimmed = trimmed;
		}
	}

	class AutoGrowingVector<E> implements Iterable {
		int size = 0;

		Vector<Coordinate> tab = new Vector<Coordinate>();

		private static final long serialVersionUID = 1L;

		public void add(int index, E obj) {
			// System.out.println(index+" "+tab);
			Coordinate coo = (Coordinate) obj;
			if (tab.size() <= index)
				tab.setSize(index +1);
			tab.set(index, coo);
			size++;

		}

		int size() {
			return size;
		}

		void set(int index, Coordinate p) {
			tab.set(index, p);
		}

		Coordinate get(int index) {
			// return tab[index];
			return tab.get(index);
		}

		public Iterator iterator() {
			// attention a ne pas utilser l'iterateur pour choper autre chose
			// ques les coordonnées
			return tab.iterator();
		}
	}

	public GeometryArray evaluateSurface(NurbsSurface surface, int segU,
			int segV) {
		float uKnots[] = surface.getUKnots();
		float u = uKnots[0]; // TODO: always 0?
		float maxU = uKnots[uKnots.length - 1];
		float uStep = (maxU - u) / segU;

		float vKnots[] = surface.getVKnots();
		float v = vKnots[0]; // TODO: always 0?
		float maxV = vKnots[vKnots.length - 1];
		float vStep = (maxV - v) / segV;

		List trim = surface.getOuterTrimCurves();

		int step = segV * 4;
		int low = -step + 1;
		int high = 0;

		AutoGrowingVector<Coordinate> coordinates = new AutoGrowingVector<Coordinate>();

		this.surface = surface;
		for (int i = 0; i <= segU;) {
			v = vKnots[0];
			Iterator it = trim.iterator();
			this.setUforAllCurves(surface, u);
			for (int j = 0; j <= segV;) {
				boolean trimmed = this.isTrimmedForSetU(surface, v);
				Point3f point = surface.pointOnSurface(u, v);
				v += vStep;
				Coordinate currentCoord =new Coordinate(point, u, v - vStep,trimmed);
				if (i == 0) {
					if (j == 0) {
						coordinates.add(0, currentCoord);
					} else if (j == segV) {
						coordinates.add(step - 1, currentCoord);
					} else {
						int tmp = j * 4;
						coordinates.add(tmp, currentCoord);
						coordinates.add(tmp - 1, currentCoord);
					}
				} else if (i == segU) {
					if (j == 0) {
						coordinates.add(low, currentCoord);
					} else if (j == segV) {
						coordinates.add(low + (j - 1) * 4 + 1, currentCoord);
					} else {
						int tmp = low + (j - 1) * 4;
						coordinates.add(tmp + 1, currentCoord);
						coordinates.add(tmp + 4, currentCoord);
					}
				} else {
					if (j == 0) {
						coordinates.add(low, currentCoord);
						coordinates.add(high, currentCoord);
					} else if (j == segV) {
						coordinates.add(low + step - 3, currentCoord);
						coordinates.add(high + step - 1, currentCoord);
					} else {
						int tmp = low + (j - 1) * 4 + 1;
						coordinates.add(tmp, currentCoord);
						coordinates.add(tmp + 3, currentCoord);
						tmp = high + j * 4;
						coordinates.add(tmp, currentCoord);
						coordinates.add(tmp - 1, currentCoord);
					}
				}
				j++;
			}
			low += step;
			high += step;
			u += uStep;
			i++;
		}
		

		int[] stripIndexCounts = new int[coordinates.size / 4];
		for (int i = 0; i < stripIndexCounts.length; i++)
			stripIndexCounts[0] = 4;

		ArrayList<Integer> indexes = new ArrayList<Integer>();
		ArrayList<Point3f> quadList = new ArrayList<Point3f>();

		for (int i = 0; i < coordinates.size(); i += 4) {
			int trimmedVerticesBitMask = 0;
			Point3f pt1 = coordinates.get(i).position;
			Point3f pt2 = coordinates.get(i + 1).position;
			Point3f pt3 = coordinates.get(i + 2).position;
			Point3f pt4 = coordinates.get(i + 3).position;
			if (coordinates.get(i).trimmed == true)
				trimmedVerticesBitMask |= 0x1;
			if (coordinates.get(i + 1).trimmed == true)
				trimmedVerticesBitMask |= 0x2;
			if (coordinates.get(i + 2).trimmed == true)
				trimmedVerticesBitMask |= 0x4;
			if (coordinates.get(i + 3).trimmed == true)
				trimmedVerticesBitMask |= 0x8;

			// si au plus 3 vertices du quad sont invisibles
			if (
					trimmedVerticesBitMask == 0
					||
					// tous les quads qui ont 1 point invisible
					trimmedVerticesBitMask == 0x1
					|| trimmedVerticesBitMask == 0x2
					|| trimmedVerticesBitMask == 0x4
					|| trimmedVerticesBitMask == 0x8
					||
					// // tous les quads avec 2 points invisibles
					trimmedVerticesBitMask == 0x3
					|| trimmedVerticesBitMask == 0x5
					|| trimmedVerticesBitMask == 0x9
					|| trimmedVerticesBitMask == 0x6
					|| trimmedVerticesBitMask == 0xa
					|| trimmedVerticesBitMask == 0xc
					||
//					 tous les quads avec 3 points invisibles
					trimmedVerticesBitMask == 0x7
					|| trimmedVerticesBitMask == 0xb
					|| trimmedVerticesBitMask == 0xd
					|| trimmedVerticesBitMask == 0xe) 
					{

				if (trimmedVerticesBitMask != 0)// tous les vertex doivent être
												// affichés, on passe les tests
					// pour chaque vertex d'un quad
					for (int k = 0; k < 4; k++) {

						// on recupere les coordonnees du vertex concerné.
						u = coordinates.get(i + k).u;
						v = coordinates.get(i + k).v;

						if (isVertexUVTrimmed(surface,u, v)) {
							Point2f intersection=null;
							try {
								intersection = this.closestIntersection(u,v);
							} catch (Exception e) {
								continue;
							}

							if (intersection != null) {
								u = intersection.x;
								v = intersection.y;
							} else {
								// one point of the quad is too close to the
								// curve Intersection. Let these 2 have the same
								// coord.
								// find which point on the vertex is too close.
								for (int l = 0; l < 4; l++)
									if (!coordinates.get(i + l).trimmed) {
										u = coordinates.get(i + l).u;
										v = coordinates.get(i + l).v;
										break;
									}
							}
						}

						Point3f coordNewPoint = surface.pointOnSurface(u, v);
						
						coordinates.get(i).position = coordNewPoint;
						coordinates.get(i).trimmed=false;
						
						switch (k) {
						case 0:
							pt1 = coordNewPoint;
							break;
						case 1:
							pt2 = coordNewPoint;
							break;
						case 2:
							pt3 = coordNewPoint;
							break;
						case 3:
							pt4 = coordNewPoint;
							break;
						}
					}// end pour tous les vertex d'un quad
				addIndexedQuad(quadList, indexes, pt1, pt2, pt3, pt4);
			}//
		}
		
		Point3f[] quadsList_Array = new Point3f[quadList.size()];
		quadList.toArray(quadsList_Array);

		int[] indexesArray = new int[indexes.size()];
		for (int i = 0; i < indexes.size(); i++)
			indexesArray[i] = indexes.get(i);
		
			IndexedQuadArray ta = new IndexedQuadArray(quadList.size(),
					IndexedQuadArray.COORDINATES | IndexedQuadArray.COLOR_3,
					indexes.size(), stripIndexCounts, indexes.size());
			ta.setCoordinates(0, quadsList_Array);
			ta.setCoordinateIndices(0, indexesArray);
			return ta;
	}

	public void addIndexedQuad(ArrayList<Point3f> vertexList,
			ArrayList<Integer> indexes, Point3f pt1, Point3f pt2, Point3f pt3,
			Point3f pt4) {
		
		int index = 0;
		if (!vertexList.contains(pt1))
			vertexList.add(pt1);
		
		index = vertexList.indexOf(pt1);

		if (index != -1)
			indexes.add(index);
		else
			indexes.add(vertexList.size() - 1);

		if (!vertexList.contains(pt2))
			vertexList.add(pt2);
		
		index = vertexList.indexOf(pt2);
		if (index != -1)
			indexes.add(index);
		else
			indexes.add(vertexList.size() - 1);

		if (!vertexList.contains(pt3))
			vertexList.add(pt3);
		
		index = vertexList.indexOf(pt3);
		if (index != -1)
			indexes.add(index);
		else
			indexes.add(vertexList.size() - 1);

		if (!vertexList.contains(pt4))
			vertexList.add(pt4);
		index = vertexList.indexOf(pt4);
		if (index != -1)
			indexes.add(index);
		else
			indexes.add(vertexList.size() - 1);
	}

	public Point3f[] getQuadFromIndexedSet(ArrayList<Point3f> quadList,
			ArrayList<Integer> indexes, int index) {
		Point3f[] quad = new Point3f[4];
		quad[0] = quadList.get(indexes.get(index * 4));
		quad[1] = quadList.get(indexes.get(index * 4 + 1));
		quad[2] = quadList.get(indexes.get(index * 4 + 2));
		quad[3] = quadList.get(indexes.get(index * 4 + 3));
		return quad;
	}

	/*
	 * Returns the closest orthogonal projection If the the given point its
	 * projection are the same (distance < delta), then returns null
	 */
	public Point2f closestIntersection(float u, float v) {
		ArrayList<Point2f> intersections = new ArrayList<Point2f>();
		List trim = surface.getOuterTrimCurves();
		Iterator it = trim.iterator();
		while (it.hasNext()) {
			((TrimCurve) it.next()).setU(u);
		}
		it = trim.iterator();
		while (it.hasNext()) {
			UVCoord2f c = ((TrimCurve) it.next()).getIntersection(v);
			intersections.add(new Point2f(c.x, c.y));
		}

		float minDist = Integer.MAX_VALUE;
		Point2f testPoint = new Point2f(u, v);
		Point2f closestIntersection = new Point2f();
		float delta = 0;
		for (Point2f a : intersections) {
			delta = a.distance(testPoint);
			if (delta < minDist) {
				minDist = delta;
				closestIntersection.x = a.x;
				closestIntersection.y = a.y;
			}
		}
		// si trop pres du point d'origine, retourne null
//		if (delta ==0) {
//			return null;
//		}
		return closestIntersection;
	}

}
