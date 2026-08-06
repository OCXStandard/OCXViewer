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
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4f;

/**
 * Represents a weighted single precision ControlPoint of a Nurbs. Offers some
 * convienence methods for working with Nurbs.
 * 
 * @author sg
 * @version 1.0
 */
public class ControlPoint4f extends Tuple4f {
    private static final long serialVersionUID = 1L;
    
    public ControlPoint4f(float x, float y, float z, float w) { // TODO ?????
        super(x, y, z, w);
    }

    /**
     * Creates a new ControlPoint from the specified Tuple and the given weight
     * 
     * @param tuple
     *            Coordinates
     * @param w
     *            weight
     */
    public ControlPoint4f(Tuple3f tuple, float w) {
        super(tuple.x, tuple.y, tuple.z, w);
    }

    /**
     * Copyconstructor
     * 
     * @param point
     *            ControlPoint to copy
     */
    public ControlPoint4f(ControlPoint4f point) {
        super(point);
    }

    public ControlPoint4f() {
        super();
    }

    /**
     * Gets the coordinates of the ControlPoint
     * 
     * @return coordinates
     */
    public Point3f getPoint3f() {
        return new Point3f(x, y, z);
    }

    /**
     * Scales only the coordinates
     * 
     * @param s
     *            factor to scale the coordinates
     */
    public void scaleXYZ(double s) {
        x *= s;
        y *= s;
        z *= s;
    }

    /**
     * Adds the Tuple to the coordinates
     * 
     * @param t
     *            tuple to add.
     */
    public void addXYZ(Tuple3f t) {
        x += t.x;
        y += t.y;
        z += t.z;
    }

    /**
     * Multiplies the weight with each coordinate and sets the coordinate to the
     * newly calculatd ones.
     */
    public void weight() {
        x *= w;
        y *= w;
        z *= w;
    }

    /**
     * Divides each coordinate by the weight and places the result in given
     * Tuple
     * 
     * @param out
     *            Point3f to place result into
     */
    public void unweight(Point3f out) {
        out.x = x / w;
        out.y = y / w;
        out.z = z / w;
    }

    /**
     * Divides each coordinate bythe weight with and sets the coordinate to the
     * newly calculatd ones.
     */
    public void unweight() {
        x /= w;
        y /= w;
        z /= w;
    }

    /**
     * Negates the coordinates.
     */
    public void negateXYZ() {
        x = -x;
        y = -y;
        z = -z;
    }
    
    public void addScaled(Tuple4f t, float s){
        x+=s*t.x;
        y+=s*t.y;
        z+=s*t.z;
        w+=s*t.w;
    }

}
