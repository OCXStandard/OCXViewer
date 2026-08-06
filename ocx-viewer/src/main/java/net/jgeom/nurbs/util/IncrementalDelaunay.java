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

import java.util.ArrayList;
import java.util.List;


public class IncrementalDelaunay {
	
	 double maxX=Double.MIN_VALUE;
	 double maxY=Double.MIN_VALUE;
	 
	 double minX=Double.MAX_VALUE;
	 double minY=Double.MAX_VALUE;
	
	  private double changeRangeX(double x)
	  {
		  double result=Scale.changeRange(minX,maxX,0,Integer.MAX_VALUE-1,x);
//		  System.out.println("res : "+result);
		  return result;
	  }
	  
	  private double changeRangeY(double x)
	  {
		  double result=Scale.changeRange(minY,maxY,0,Integer.MAX_VALUE-1,x);
//		  System.out.println("res : "+result);
		  return result;
	  }
	  
	synchronized  public int[] getTriangulation(float[]points, int[]constraintEdges)
	{
		/* creation de l'instance */
		Delaunay delaunay = new Delaunay();
		ArrayList<Point> al=new ArrayList();
		
		 int id=0;
		 int k=0;
		 /* ajout des points (calcul incrémental) */
		 for(int i=0;i<points.length/3;i++)
		 {
			 al.add(new Point((int)points[k++],(int)points[k++],id++));
			 k++;
		 }
		 
//		  scale the value to higher precision
		for (Point c : al) {
			if (maxX < c.x)
				maxX = c.x;
			if (maxY < c.y)
				maxY = c.y;
			if (minX > c.x)
				minX = c.x;
			if (minY > c.y)
				minY = c.y;
		}
//		 for( Point p:al)
//		 {
//			 p.x=(int)this.changeRangeX(p.x);
//			 p.y=(int)this.changeRangeX(p.y);
//		 }
		 
		 for( Point p:al)
			 delaunay.insertPoint(p);
		
//		delaunay.insertPoint( new Point2f(12f,98f) );
//		delaunay.insertPoint( new Point2f(34,76) );
//		delaunay.insertPoint( new Point2f(56,54) );
//		delaunay.insertPoint( new Point2f(78,32) );
		/* ... */
		 
		/* retourne la liste des segments */
//		List<Point2f[]> edges = delaunay.computeEdges();
		 
		/* retourne la liste des triangles */
		List<Point[]> triangles = delaunay.computeTriangles();
		
		k=0;
		int []indexes=new int[triangles.size()*3];
		for(Point[] p:triangles)
		{
			indexes[k++]=p[0].getId();
			indexes[k++]=p[1].getId();
			indexes[k++]=p[2].getId();
		}
		 
		/* retourne la liste des régions */
//		List<Point2f[]> voronoi = delaunay.computeVoronoi();
		
		return indexes;
	}

}
