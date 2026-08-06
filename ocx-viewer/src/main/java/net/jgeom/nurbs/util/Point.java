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

public class Point {
	public int x;
	public int y;
	private int id;
	
	Point(){}
	
	Point(int x, int y, int id)
	{
		this.x=x;
		this.y=y;
		this.id=id;
	}
	Point(int x, int y)
	{
		this.x=x;
		this.y=y;
		this.id=-1;
	}
	
	public int getId()
	{
		if(id!=-1)
			return id;
		else
			System.out.println("ID NOT SET");
		
		return-1;
	}
}
