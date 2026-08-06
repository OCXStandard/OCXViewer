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
 * A ControlNet for a NurbsSurface
 * @author sg
 * @version 1.0
 */
public class ControlNet {
  private int nU, nV;
  private ControlPoint4f cps[][];

  /**
   * Create a ControlNet from the given points the two dimensional array must be a Matrix else
   * an IllegalArgumentException is thrown.
   * @param cpnet "Matrix" of ControlPoints
   */
  public ControlNet(ControlPoint4f cpnet[][]) throws IllegalArgumentException{
    if (cpnet.length < 1) {
      throw new IllegalArgumentException("Nurbs is not a Surface, to less ControlPoints in u Direction");
    }
    if (cpnet[0].length < 1) {
      throw new IllegalArgumentException("Nurbs is not a Surface, to less ControlPoints in v Direction");
    }
    for (int i = 1; i < cpnet.length; i++) {
      if (cpnet[i].length != cpnet[i - 1].length) {
        throw new IllegalArgumentException("ControlPoint net is not a Matrix");
      }
    }

    nU = cpnet.length;
    nV = cpnet[0].length;
    cps = cpnet; //TODO: data hiding?! probably use System.arraycopy(cps, cpnet);
  }

  /**
   * Get number of ControlPoints in u direction
   * @return number of ControlPoints in u direction
   */
  public int uLength() {
    return nU;
  }
  /**
   * Get number of ControlPoints in v direction
   * @return number of ControlPoints in v direction
   */
  public int vLength() {
    return nV;
  }

  /**
   * Get the ControlPoint at the position u,v
   * @param u index in u direction
   * @param v index in v direction
   * @return The by u and v indexed ControlPoint
   */
  public ControlPoint4f get(int u, int v) {
	if(u<0)
		u=0;
	if(v<0)
		v=0;
	if(u>this.uLength()-1)
		u=this.uLength()-1;
	if(v>this.vLength()-1)
		v=this.vLength()-1;
    return cps[u][v];
  }

  /**
   * Set the ControlPoint at the position u,v
   * @param u index in u direction
   * @param v index in v direction
   * @param cp ControlPoint to set at the indexed position
   */
  public void set(int u, int v, ControlPoint4f cp) { //TODO copy values or set ref?
    cps[u][v] = cp;
  }
}
