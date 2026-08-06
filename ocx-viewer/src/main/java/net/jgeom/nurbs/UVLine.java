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
 * This class describes a Line in the UV-Coordinate system.
 * @author sg
 * @version 1.0
 */
public class UVLine {

  public UVCoord2f start, end;
  private float vmin, vmax;

  /**
   * Creates a line from the given two Coordinates
   * @param s Start of the line
   * @param e End of the line
   */
  public UVLine(UVCoord2f s, UVCoord2f e) {
    if (s.x < e.x) {
      start = s;
      end = e;
    }
    else {
      start = e;
      end = s;
    }
    if(s.y>e.y){
    	vmin=e.y;
    	vmax=s.y;
    }
    else{
    	vmin=s.y;
    	vmax=e.y;
    }
  }
  
  /**
   * Get the minimal v value of this line.
   * @return minimal v value
   */
  public float getVMin(){
  	return vmin;
  }
  
  /**
   * Get the minimal u value of this line.
   * @return minimal u value
   */
  public float getVMax(){
  	return vmax;
  }
}
