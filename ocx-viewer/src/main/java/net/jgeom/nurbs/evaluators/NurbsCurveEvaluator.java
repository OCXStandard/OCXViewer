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


import net.jgeom.nurbs.NurbsCurve;
import net.jgeom.nurbs.geomContainers.GeometryArray;


/**
 * Interface for NurbsCurve evaluators for Java3D.
 * @author sg
 * @version 1.0
 */
public interface NurbsCurveEvaluator {
  /**
   * Evaluate the given Nurbs into a  Java3D GeometryArray<br>
   * @param curve NurbsCurve to evaluate
   * @param segnum Numbers of segments to calculate. 
   *               This specifies how many points on the curve get calculated.
   * @return A GeometryArray representation of the given Nurbs
   */
  public GeometryArray evaluateCurve(NurbsCurve curve, int segnum);
  
  /**
   * Evaluate the control polygon inot a Java3D Geometry Array
   * @param curve NurbsCurve to calculate ControlPolygon from
   * @return GeometryArray of the control polygon
   */
  public GeometryArray getControlPolygon(NurbsCurve curve);
}
