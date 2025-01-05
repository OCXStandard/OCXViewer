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

public class IndexedGeometryArray extends GeometryArray{
	AutoGrowingVector<Integer>coordinateIndices=new AutoGrowingVector<Integer>();
	
	public void setCoordinateIndices(int index, int[] coordsIndices) 
	{
		coordinateIndices=new AutoGrowingVector<Integer>();
		for(int i=0;i<coordsIndices.length;i++)
		{
			coordinateIndices.add(i, coordsIndices[i]);
		}
	}
	
	public int getIndexCount()
	{
		return coordinateIndices.size;
	}
	
	public  void 	getCoordinateIndices(int index, int[] coordsIndices)
	{
		for(int i=index;i<coordinateIndices.size;i++)
		{
			coordsIndices[i]=coordinateIndices.get(i);
		}
	}
}
