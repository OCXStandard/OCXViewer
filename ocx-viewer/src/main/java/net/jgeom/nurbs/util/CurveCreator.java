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
package net.jgeom.nurbs.util;

import net.jgeom.nurbs.BasicNurbsCurve;
import net.jgeom.nurbs.ControlPoint4f;
import net.jgeom.nurbs.NurbsCurve;

import javax.vecmath.Point3f;
import java.util.LinkedList;
import java.util.List;


/**
 * Convenience class to create dynamically NurbsCurves.
 * 
 * @author sg
 * @version 1.0
 */
public class CurveCreator {

  private int p;
  private int incp = 0;
  private List cps = new LinkedList();
  private NurbsCurve actual = null;

  /**
   * Create a new CurveCretor object which can create Curves from the given degree
   * @param degree Degree the created NurbsCurve will have.
   */
  public CurveCreator(int degree) {
    p = degree;
  }

  /**
   * Add a new Controlpoint to the current CurveCreator.
   * @param cp ControlPoint to add.
   * @return the actual NurbsCurve if any exists, or null otherwise (to less control for the given degree).
   */
  public NurbsCurve addControlPoint(ControlPoint4f cp) {
    cps.add(cp);
    int np = cps.size();
    int tmp = p;
    if (np <= p) {
      if (incp == 0) {
      	incp++;
        return null;
      }
      tmp = incp++;
    }

	float u[] = new float[np + tmp + 1];
    for (int i = 0; i <= tmp; i++) {
      u[i] = 0;
      u[u.length - 1 - i] = 1;
    }
    if (np > p + 1) {
			float val = 1.0f / (np - p);
			float step = val;
      for (int i = p+1; i < u.length - 1 - p; i++) {
        u[i] = val;
        val += step;
      }
    }
    ControlPoint4f ctrlp[] = new ControlPoint4f[cps.size()];
    cps.toArray(ctrlp);
    actual = new BasicNurbsCurve(ctrlp, u, tmp);
    return actual;
  }

  /**
   * Get the actual NurbsCurve of the CurveCreator
   * @return the actual NurbsCurve if any exists, or null otherwise (to less control for the given degree).
   */
  public NurbsCurve getActual() {
    return actual;
  }

  /**
   * Add a normal Point as ControlPoint to the CurveCreator. The newly added Point has automatically the weight one.
   * @param cp Controlpoint to add with weight one.
   * @return the actual NurbsCurve if any exists, or null otherwise (to less control for the given degree).
   */
  public NurbsCurve addControlPoint(Point3f cp) {
    return addControlPoint(new ControlPoint4f(cp, 1));
  }

}
