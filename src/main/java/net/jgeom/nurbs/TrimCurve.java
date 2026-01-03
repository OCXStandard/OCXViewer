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
package net.jgeom.nurbs;

import net.jgeom.util.DistancePoint;

import javax.vecmath.Point2d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * A Trimcurve for a Nurbs.
 * 
 * @author sg
 * @version 1.0
 */
@SuppressWarnings("removal")
public class TrimCurve {
  public UVCoord2f lines[];
  private List vs;
  private float u;
  private boolean invert = false;
  private static int curveNb=0;
  private int id=0;
  private boolean senseForward=true;

  /**
   * Create a  TrimCurve from the given Coordinates which must be in correct order. 
   * That means that each point following another is the next edge point of the polygon.
   * 
   * @param lines
   */
   
/*
Note added 22 March 2012: VJM
Examination of logic of the getIntersection routine shows that the
intent is that the list of points should "close up", that is that
lines[lines.size-1] == lines[0];
or equivalently in N=lines.length that the
curve is made up of N-1 segments
(lines[i-1], lines[i])  i in [1,N)
*/

  public TrimCurve(UVCoord2f lines[]) {
	this();
    this.lines = lines;
  }
  
  public TrimCurve(){curveNb++;id=curveNb;}

  private boolean isBetween(float u, UVCoord2f u1, UVCoord2f u2) {
    float vmin, vmax;
    if (u1.x > u2.x) {
      vmin = u2.x;
      vmax = u1.x;
    }
    else {
      vmin = u1.x;
      vmax = u2.x;
    }
    return u >= vmin && u <= vmax;
  }

  /**
   * @param v
   * @return UV space point, representing the intersection between the trimming curve and the normal
   *  the the trimming curve passing through the tested point. (return the closest projection on the set of lines)
   */
  public UVCoord2f getIntersection(float v) {
		Point2d p1=null;
		Point2d p2=null;
		Point2d p3 = new Point2d(u, v);	
		Point2d closestIntersection = new Point2d();
		double  minDist = Integer.MAX_VALUE;
		
		for (int i = 1; i < lines.length; i++) {
			p1= new Point2d(lines[i - 1].x, lines[i - 1].y);
			p2 = new Point2d(lines[i].x, lines[i].y);
			Point2d proj = DistancePoint.getNormalProjectionOnSegment(p1, p2,p3);
			
			double distTmp =p3.distance(proj);
			if (distTmp < minDist) {
				minDist = distTmp;
				closestIntersection.x = proj.x;
				closestIntersection.y = proj.y;
			}
		}
	  return  new UVCoord2f((float)closestIntersection.x,(float)closestIntersection.y);
  }
  
  /**
   * This method calculates all v values the polygon has for this u value. and stores them internally for
   * testing later v values which maybe lying inside or outside. This is done like this to
   * increase performance.
   * 
   * @param u u value to calculate v values for.
   */
  public void setU(float u) {
//    if (u >= 1) {
//      u = 0.999999f; //TODO
//    }
//    if (u <= 0) {
//      u = 0.000001f;
//    }
	this.u=u;
    vs = new LinkedList();
    if(lines.length>=2)
    	senseForward=lines[0].x<lines[1].x;
    for (int i = 1; i < lines.length; i++) {
      if (isBetween(u, lines[i - 1], lines[i])) {
        float a = (lines[i - 1].y - lines[i].y) / (lines[i - 1].x - lines[i].x);
        float ud = u - lines[i].x;
        float vd = lines[i].y + ud * a;
        vs.add(new Float(vd));
      }
    }
  }

  /**
   * This method checks if the given v value lies inside or outside the TrimCurve.
   * This method only works after a call to setU. This is done like this to
   * increase performance.<br>
   * So if you want to check if a given UV Coordinate lies in- or outside, you have to call first
   * SetU and then isTrimmed. For optimal performance the u value should be set once and then all v values for this
   * u value should be calculated.<br>
   * <code>
   * float currentU=0.1f;
   * aTC.setU(currentU);
   * for(allV on currentU){
   * 	aTC.isTrimed(allV[i]);
   * }
   * </code>
   * 
   * @param v
   * @return true if v is for currently set u trimmed, false otherwise. 
   *              If no u was set previous a null pointer exception is thrown.
   */
  public boolean isTrimed(float v) {
    Iterator it = vs.iterator();
    int nu = 0;
//    if (v >= 1) {
//      v = 0.999999f; //TODO
//    }
//    if (v <= 0) {
//      v = 0.000001f;
//    }
    while (it.hasNext()) {
      Float tmp = (Float) it.next();
      if (tmp.floatValue() >= v) {
        nu++;
      }
    }
//    invert=!senseForward;
    return invert ? nu % 2 == 0 : nu % 2 != 0;
  }

  /**
   * Get the coordinates of this TrimCurve
   * @return The UV_Coordinates of the TrimCurve
   */
  public UVCoord2f[] getCoordinates() {
    return lines;
  }

  /**
   * Sets the inverted attribute of this TrimCurve.
   * A TrimCurve that is inverted means that, points that lied inside are now outside and vice versa.
   * @param invert true to invert the nurbs, false otherwise. If the the nurbs was inverted before a call
   * to tis method with true changes nothing but a call with false does. This is also the other way round.
   */
  public void inverted(boolean invert) {
    this.invert = invert;
  }
  
  /**
   * Checks if this TrimCurve is inverted or not.
   * @return True for an inverted TrimCurve, false otherwise.
   */
  public boolean isInverted(){
  	return invert;
  }

public boolean isSenseForward() {
	return senseForward;
}
}
