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
package net.jgeom.util;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
 * This class represents an origin for a cartesian orthoganal coordinate system in 3D Space.
 * @author sg
 * @version 1.0
 */
public class Origin3D {
  public Point3d origin;
  public Vector3d xVec, yVec, zVec;

  /**
   * Creates a new Origin which is paralle to the x,y,z axis of the 3D Space and has its origin a the given point
   * @param o Origin of the coordinate system
   */
  public Origin3D(Point3d o) {
    origin = o;
    xVec = new Vector3d(1, 0, 0);
    yVec = new Vector3d(0, 1, 0);
    zVec = new Vector3d(0, 0, 1);
  }

  /**
   * @param o Origin of the soordinate system 
   * @param x x-direction of the coordinate system
   * @param y y-direction of the coordinate system
   * @throws IllegalArgumentException if x and y vectors are not orthogonal
   */
  public Origin3D(Point3d o, Vector3d x, Vector3d y) throws IllegalArgumentException {
    origin=o;
    xVec = x;
    yVec = y;
    xVec.normalize();
    yVec.normalize();
    double cos = xVec.dot(yVec);
    if (Math.abs(cos) > 0.0001) { //TODO: epsilon value
      throw new IllegalArgumentException("Vectors are nor orthogonal");
    }
    zVec = new Vector3d();
    zVec.cross(xVec, yVec);
  }

  /**
   * Creates a new Origin which is paralle to the x,y,z axis of the 3D Space and originates at (0/0/0)
   */
  public Origin3D() {
    this(new Point3d(0, 0, 0));
  }
}
