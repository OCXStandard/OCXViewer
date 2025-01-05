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

import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;

/**
 * Interface for Nurbs Curves
 * @author sg
 * @version 1.0
 */
public interface NurbsCurve {
	
  void setTminTmax(float tmin, float tmax);
  /**
   * Get the ControlPoints of this curve
   * @return the ordered ControlPoints
   */
  ControlPoint4f[] getControlPoints();
  
  /**
   * Gets the Knot values of the Nurbs curve
   * @return knot values
   */
  float[] getKnots();
  
  KnotVector getKnotVector();
  
  /**
   * Get the Degree of the curve
   * @return degree of curve
   */
  int getDegree();
  
  /**
   * Calculate point on surface for the given u value
   * @param u value to calculate point of
   * @return calculated Point
   */
  Point3f pointOnCurve(float u);
  
  /**
   * Calculate point on surface for the given u value
   * @param u value to calculate point of
   * @param out Point to place result in
   */
  void pointOnCurve(float u, Point3f out);

  void curveDerivs(float u, int d, Vector3d[] CK);
  
  void generateSmoothKnots();
  
}