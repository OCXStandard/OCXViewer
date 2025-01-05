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
import net.jgeom.nurbs.geomContainers.GeometryArray;
import net.jgeom.nurbs.geomContainers.PointArray;

import javax.vecmath.Point3f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Evaluates a NurbsSurface with TrimCurves into a PointArray. 
 * All points that are trimmed are not int the PoinArray and therefore not drawn.
 * 
 * @author sg
 * @version 1.0
 */
public class TrimSurfaceEvaluatorPointsCloud extends TrimEvaluator {

  public GeometryArray evaluateSurface(NurbsSurface surface, int segU, int segV) {
	  float uKnots[] = surface.getUKnots();
	    float u = uKnots[0]; //TODO: always 0?
	    float maxU = uKnots[uKnots.length - 1];
	    float uStep = (maxU - u) / segU;

	    float vKnots[] = surface.getVKnots();
	    float v = vKnots[0]; //TODO: always 0?
	    float maxV = vKnots[vKnots.length - 1];
	    float vStep = (maxV - v) / segV;

	    List trim = surface.getOuterTrimCurves();
	    List points = new LinkedList();

	    for (int i = 0; i <= segU; i++) {
	      v = vKnots[0];
	      Iterator it = trim.iterator();
//	      this.setUforAllCurves(surface, u);
	      for (int j = 0; j <= segV; j++) {
	        it = trim.iterator();
	        boolean trimmed = false;
//	        trimmed=isTrimmedForSetU(surface, v);
	        trimmed=!this.isVertexInBoundary(surface, u, v);
	        if (!trimmed) {
	          points.add(surface.pointOnSurface(u, v));
	        }
	        v += vStep;
	      }
	      u += uStep;

    }
    

    PointArray pa = new PointArray(points.size(), PointArray.COORDINATES);
    Point3f pnts[] = new Point3f[points.size()];
    points.toArray(pnts);
    pa.setCoordinates(0, pnts);
//    for(int i=0;i<pa.getVertexCount();i++)
//    {
//    	pa.setColor(i, new float[]{derivates.get(i),derivates.get(i),0.5f});
//    	System.out.println(derivates.get(i));
//    }
    return pa;
  }

}
