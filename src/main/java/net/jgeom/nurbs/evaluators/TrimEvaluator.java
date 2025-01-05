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
import net.jgeom.nurbs.geomContainers.LineStripArray;
import net.jgeom.nurbs.util.Scale;

import javax.vecmath.Point2f;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Evaluates a NurbsSurface with TrimCurves. The Surface get calculated as before with no respect to the TrimCurves.
 * But this class offers to visualise the TrimCurves of NurbsSurface
 * @author sg
 * @version 1.0
 */
public class TrimEvaluator extends BasicNurbsSurfaceEvaluator {

//	NurbsSurface surface = null;
NurbsSurface surfaceCache=null;
 
 double maxX=Double.MIN_VALUE;
 double maxY=Double.MIN_VALUE;
 
 double minX=Double.MAX_VALUE;
 double minY=Double.MAX_VALUE;
 
 Polygon outerPolygon=new Polygon();
 ArrayList<Polygon> innerPolygons=new ArrayList<Polygon>();
 
  /**
   * This method calculates all the TrimCurves of a NurbsSurface into a LineStripArray array.
   * @param surface NurbsSurface to evaluate TrimCurves from.
   * @return All the TrimCurve in 3D-Space as a LineStripArray
   */
	 public LineStripArray[] evaluateTrimmCurves(NurbsSurface surface) {
    List trims = surface.getOuterTrimCurves();
    LineStripArray res[] = new LineStripArray[trims.size()];
    for (int i = 0; i < res.length; i++) {
      TrimCurve tc = (TrimCurve) trims.get(i);
      res[i] =evaluateTrimmCurves(tc, surface);
    }
    return res;
  }

  /**
   * Caclulate a given TrimCurve on a given NurbsSurface.
   * @param tc TrimCurve to evaluate
   * @param surface NurbsSurface to evaluate TrimCurve on.
   * @return The TrimCurve in 3D-Space as LineStripaArray 
   */
   public LineStripArray evaluateTrimmCurves(TrimCurve tc, NurbsSurface surface) {
    UVCoord2f lines[] = tc.getCoordinates();
    int n = lines.length;
    LineStripArray res = new LineStripArray(n, LineStripArray.COORDINATES, new int[] { n });
    for (int j = 0; j < lines.length; j++) {
      res.setCoordinate(j, surface.pointOnSurface(lines[j].x, lines[j].y));
    }
    return res;
  }
  
   public void setUforAllCurves(NurbsSurface surface, float u)
  {
		List trim = surface.getOuterTrimCurves();
		Iterator it = trim.iterator();
		while (it.hasNext()) {
			((TrimCurve) it.next()).setU(u);
		}
  }
  
  public boolean isTrimmedForSetU(NurbsSurface surface, float v) {
		List trim = surface.getOuterTrimCurves();
		Iterator it = trim.iterator();
		it = trim.iterator();
		boolean answer = false;
		while (it.hasNext()) {
			// System.out.println("param surface : "+u+" | "+v);
			TrimCurve tc = ((TrimCurve) it.next());
			if (tc.isTrimed(v)) {
				answer = true;
				break;
			}
		}

		if (trim.size() == 0)
			return false;
		else
			return !answer;
	}
  
  //slow method but doesn't need to call setU()
  synchronized public boolean isVertexUVTrimmed(NurbsSurface surface, float u, float v) {
	  this.setUforAllCurves(surface, u);
	  return isTrimmedForSetU(surface, v);
  }
  

  
  public double changeRangeX(double x)
  {
	  double result=Scale.changeRange(minX,maxX,0,Integer.MAX_VALUE-1,x);
//	  System.out.println("res : "+result);
	  return result;
  }
  
  public double changeRangeY(double x)
  {
	  double result=Scale.changeRange(minY,maxY,0,Integer.MAX_VALUE-1,x);
//	  System.out.println("res : "+result);
	  return result;
  }
  
  synchronized public boolean isVertexInBoundary(NurbsSurface surface, float u, float v) {
	  boolean withinOuterBorder=true;
	  boolean withinInnerBorder=false;
	  
	  List outerTrim = surface.getOuterTrimCurves();
	  
	  //if no boundary, always visible
	  if(outerTrim.size()==0 ) return true;
	  
	  Iterator itOuter = outerTrim.iterator();
	  
//	  scale the value to higher precision
	  while (itOuter.hasNext()) {
			TrimCurve tc = ((TrimCurve) itOuter.next());
			for (UVCoord2f c : tc.lines) {
				if (maxX < c.x)
					maxX = c.x;
				if (maxY < c.y)
					maxY = c.y;
				if(minX > c.x)
					minX = c.x;
				if(minY > c.y)
					minY = c.y;
			}
		}
	  
	  if (surfaceCache!=surface) {
			itOuter = outerTrim.iterator();
			while (itOuter.hasNext()) {
				TrimCurve tc = ((TrimCurve) itOuter.next());
				for (UVCoord2f c : tc.lines)
					outerPolygon.addPoint((int)changeRangeX(c.x), (int)changeRangeY(c.y));
			}
			surfaceCache=surface;
			
			List innerTrim=surface.getInnerTrimCurves();
			Iterator itInner=innerTrim.iterator();
			while(itInner.hasNext()){
				Polygon pInner=new Polygon();
				TrimCurve tc=((TrimCurve)itInner.next());
				for (UVCoord2f c : tc.lines)
					pInner.addPoint((int)changeRangeX(c.x), (int)changeRangeY(c.y));
				innerPolygons.add(pInner);
			}
		}
	  withinOuterBorder= outerPolygon.contains((int)changeRangeX(u), (int)changeRangeY(v));
	  for(Polygon p : innerPolygons)
		  if(p.contains((int)changeRangeX(u), (int)changeRangeY(v)))
		  {
			  withinInnerBorder=true;
	  		  break;
		  }
	  
	  return withinOuterBorder&&!withinInnerBorder;
//	  return !withinInnerBorder;
//	  return withinOuterBorder;
	}
  /*
	 * Returns the closest orthogonal projection If the the given point its
	 * projection are the same (distance < delta), then returns null
	 */
	public Point2f closestIntersection(NurbsSurface surface, float u, float v) {
		
		ArrayList<Point2f> intersections = new ArrayList<Point2f>();
		List outerTrim = surface.getOuterTrimCurves();
		
		List innerTrim = surface.getInnerTrimCurves();
		
		
		//if no border, can't compute intersection
		if(outerTrim.size()==0)
			return new Point2f(u,v);
		
		Iterator it = outerTrim.iterator();
		while (it.hasNext()) {
			((TrimCurve) it.next()).setU(u);
		}
		
		it = outerTrim.iterator();
		while (it.hasNext()) {
			try{
				UVCoord2f c = ((TrimCurve) it.next()).getIntersection(v);
				intersections.add(new Point2f(c.x, c.y));
			}
			catch(Exception e)
			{
				//bad intersection, ignore it, probably occured when comparing two points too close from each other.
				continue;
			}
		}
		
		it = innerTrim.iterator();
		while (it.hasNext()) {
			((TrimCurve) it.next()).setU(u);
		}
		
		it = innerTrim.iterator();
		while (it.hasNext()) {
			try{
				UVCoord2f c = ((TrimCurve) it.next()).getIntersection(v);
				intersections.add(new Point2f(c.x, c.y));
			}
			catch(Exception e)
			{
				//bad intersection, ignore it, probably occured when comparing two points too close from each other.
				continue;
			}
		}

		float minDist = Integer.MAX_VALUE;
		Point2f testPoint = new Point2f(u, v);
		Point2f closestIntersection = new Point2f();
		float delta = 0;
		for (Point2f a : intersections) {
			delta = a.distance(testPoint);
			if (delta < minDist ) {
				minDist = delta;
				closestIntersection.x = a.x;
				closestIntersection.y = a.y;
			}
		}
		// si trop pres du point d'origine, retourne null
		// if (delta ==0) {
		// return null;
		// }
			return closestIntersection;
	}

public double closestDistance(NurbsSurface surface, float u, float v) {
		
		ArrayList<Point2f> intersections = new ArrayList<Point2f>();
		List outerTrim = surface.getOuterTrimCurves();
		
		List innerTrim = surface.getInnerTrimCurves();
		
		
		//if no border, can't compute intersection
		if(outerTrim.size()==0)
			return 0;
		
		Iterator it = outerTrim.iterator();
		while (it.hasNext()) {
			((TrimCurve) it.next()).setU(u);
		}
		
		it = outerTrim.iterator();
		while (it.hasNext()) {
			try{
				UVCoord2f c = ((TrimCurve) it.next()).getIntersection(v);
				intersections.add(new Point2f(c.x, c.y));
			}
			catch(Exception e)
			{
				//bad intersection, ignore it, probably occured when comparing two points too close from each other.
				continue;
			}
		}
		
		it = innerTrim.iterator();
		while (it.hasNext()) {
			((TrimCurve) it.next()).setU(u);
		}
		
		it = innerTrim.iterator();
		while (it.hasNext()) {
			try{
				UVCoord2f c = ((TrimCurve) it.next()).getIntersection(v);
				intersections.add(new Point2f(c.x, c.y));
			}
			catch(Exception e)
			{
				//bad intersection, ignore it, probably occured when comparing two points too close from each other.
				continue;
			}
		}

		float minDist = Integer.MAX_VALUE;
		Point2f testPoint = new Point2f(u, v);
		Point2f closestIntersection = new Point2f();
		float delta = 0;
		for (Point2f a : intersections) {
			delta = a.distance(testPoint);
			if (delta < minDist ) {
				minDist = delta;
				closestIntersection.x = a.x;
				closestIntersection.y = a.y;
			}
		}
		// si trop pres du point d'origine, retourne null
		// if (delta ==0) {
		// return null;
		// }
			return minDist;
	}
}
