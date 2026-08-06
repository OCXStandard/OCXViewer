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

/**
 * Interface for Nurbs Surfaces.
 * @author sg
 * @version 1.2
 */
public interface NurbsSurface extends Surface{
  /**
   * Get the Contol points of the NurbsSurface
   * @return ControlNet of the Nurbs
   */
  ControlNet getControlNet();
  
  /**
   * Get the degree in u direction
   * @return degree in u direction
   */
  int getUDegree();
  
  /**
   * Get the degree in v direction
   * @return degree in v direction
   */
  int getVDegree();
  
  /**
   * Get the knot values in u direction
   * @return knot values in u direction
   */
  float[] getUKnots();
  
  /**
   * Get the knot values in v direction
   * @return knot values in v direction
   */
  float[] getVKnots();
}
