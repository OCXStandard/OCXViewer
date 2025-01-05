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

import net.jgeom.nurbs.ControlPoint4f;
import net.jgeom.nurbs.NurbsCurve;
import net.jgeom.nurbs.geomContainers.GeometryArray;
import net.jgeom.nurbs.geomContainers.LineStripArray;

import javax.vecmath.Color3f;
import java.util.Random;


/**
 * A basic NurbsCurve evaluator for Java3D. Evaluates a given NurbsCurve into a QuadArray.
 * 
 * @author sg
 * @version 1.0
 */
public class BasicNurbsCurveEvaluator implements NurbsCurveEvaluator {

  /**
   * Create a new Evaluator.
   */
  public BasicNurbsCurveEvaluator() {}

  public GeometryArray evaluateCurve(NurbsCurve curve, int segnum) {
    float uKnots[] = curve.getKnots();
    float u = uKnots[0]; //TODO: always 0?
    float max = uKnots[uKnots.length - 1];
    float uStep = (max - u) / segnum;
    LineStripArray la = new LineStripArray(segnum + 1, LineStripArray.COORDINATES|LineStripArray.COLOR_3, new int[] { segnum + 1 });
    Random r=new Random();
    float red=r.nextFloat();
    float blue=r.nextFloat();
    for (int i = 0; i <= segnum; i++) {
      la.setCoordinate(i, curve.pointOnCurve(u));
      la.setColor(i, new Color3f(red,blue,0.2f));
      u += uStep;
    }

    return la;
  }

  public GeometryArray getControlPolygon(NurbsCurve curve) {
    ControlPoint4f cp[] = curve.getControlPoints();
    LineStripArray lsa = new LineStripArray(cp.length, LineStripArray.COORDINATES, new int[] { cp.length });
    for (int i = 0; i < cp.length; i++) {
      lsa.setCoordinate(i, new float[] { cp[i].x, cp[i].y, cp[i].z });
    }
    return lsa;
  }

}
