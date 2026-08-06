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
import java.util.List;

public interface Surface {
	  /**
	   * Calculate point on surface for the given u and v values
	   * @param u u value to caculate point from
	   * @param v v value to caculate point from
	   * @return calculated point
	   */
	  Point3f pointOnSurface(float u, float v);
	  
	  /**
	   * Calculate point on surface for the given u and v values
	   * @param u u value to caculate point from
	   * @param v v value to caculate point from
	   * @param out point to place result in.
	   */
	  void pointOnSurface(float u, float v, Point3f out);
	  
	  /**
	   * Add a TrimCurve to this Nurbs Surface
	   * @param tc TrimCurve to add.
	   */
	  void addInnerTrimCurve(TrimCurve tc);
	  
	  /**
	   * Add a TrimCurve to this Nurbs Surface
	   * @param tc TrimCurve to add.
	   */
	  void addOuterTrimCurve(TrimCurve tc);
	  
	  /**
	   * Get a List of all TrimCurves asociated with this Nurbs Surface
	   * @return List of TrimCurves
	   */
	  List getInnerTrimCurves();
	  
	  List getOuterTrimCurves();
	  
	  ControlPoint4f[][] surfaceDerivs(float u, float v, int d);

	public List<Point3f> computeTrimCurves3d(int index);

	public int getOuterTrimmingCurveCount();
	
	public int getInnerTrimmingCurveCount();
	
}
