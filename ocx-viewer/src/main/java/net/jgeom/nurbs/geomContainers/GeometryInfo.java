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

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

public class GeometryInfo {
	public static int QUAD_ARRAY=0;
	public static int POLYGON_ARRAY=1;
	public int getOldPrim(){return 0;};
	public int getPrimitive(){return 0;};
	public Point3f[] getCoordinates(){return null;}
	public int[] getCoordinateIndices(){return null;}
	
	public  void setNormals(Vector3f[] normals){}
	public  void setNormalIndices(int[] normalsIndices){}
	public void setCoordinateIndices(int []indices){}
}
