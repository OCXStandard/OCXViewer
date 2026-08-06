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
 * This class represents an axis in 3D-Space.
 * @author sg
 * @version 1.0
 */
public class Axis3D {
  public Point3d origin;
  public Vector3d dir;

  /**
   * Create a new Axis3D, which originates from the origin (0/0/0) and directs in z-Direction.
   */
  public Axis3D() {
    origin = new Point3d(0, 0, 0);
    dir = new Vector3d(0, 0, 1);
  }

  /**
   * Create a new Axis3D, which originates from the origin (0/0/0) and directs in the given direction..
   * @param dir Direction of the Axis3D.
   */
  public Axis3D(Vector3d dir) {
    origin = new Point3d(0, 0, 0);
    this.dir = new Vector3d(dir);
    this.dir.normalize();
  }
  /**
   * Create a new Axis3D with the given origin and thegiven Direction.
   * @param o Origin of the Axis3D
   * @param dir Direction of the Axis3D
   */
  public Axis3D(Point3d o, Vector3d dir) {
    origin = new Point3d(o);
    this.dir = new Vector3d(dir);
    this.dir.normalize();
  }

  /**
   * Get a new x-Axis3D Object.
   * @return An Axis3D which originates from the origin (0/0/0) and directs in x-Direction.
   */
  public static Axis3D xAxis() {
    return new Axis3D(new Vector3d(1, 0, 0));
  }

  /**
   * Get a new y-Axis3D Object.
   * @return An Axis3D which originates from the origin (0/0/0) and directs in y-Direction.
   */
  public static Axis3D yAxis() {
    return new Axis3D(new Vector3d(0, 1, 0));
  }

  /**
   * Get a new z-Axis3D Object.
   * @return An Axis3D which originates from the origin (0/0/0) and directs in z-Direction.
   */
  public static Axis3D zAxis() {
    return new Axis3D(new Vector3d(0, 0, 1));
  }

}
