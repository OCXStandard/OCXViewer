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
package net.jgeom.nurbs.geomContainers;

import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import java.util.Vector;

public class GeometryArray extends Geometry {

	AutoGrowingVector<Point3f> coordinates = new AutoGrowingVector<Point3f>();

	AutoGrowingVector<Color3f> colors = new AutoGrowingVector<Color3f>();

	public Vector<Point3f> getCoordinates() {
		return coordinates.getAll();
	}

	public Vector<Color3f> getColors() {
		return colors.getAll();
	}

	public void setCoordinate(int index, Point3f coordinate) {
		coordinates.add(index, coordinate);
	}

	public void setCoordinate(int index, float[] coordinate) {
		coordinates.add(index, new Point3f(coordinate[0], coordinate[1],
				coordinate[2]));
	}
	
	public int getValidVertexCount()
	{
		return coordinates.size;
	}
	
	public void getCoordinates(int index,
            float[] OUTcoord)
	{
		int j=0;
		for(int i=0;i<coordinates.size*3;i+=3)
		{
			OUTcoord[i]=coordinates.get(j).x;
			OUTcoord[i+1]=coordinates.get(j).y;
			OUTcoord[i+2]=coordinates.get(j++).z;
		}
	}

	public void setColor(int index, Color3f color) {
		colors.add(index, color);
	}

	public void setCoordinates(int index, Point3f[] coords) {
		coordinates = new AutoGrowingVector<Point3f>();
		for (int i = 0; i < coords.length; i++) {
			coordinates.add(i, coords[i]);
		}
	}

	public int getVertexCount() {
		return coordinates.size;
	}

}
