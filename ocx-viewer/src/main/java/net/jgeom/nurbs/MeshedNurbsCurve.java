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


import net.jgeom.nurbs.evaluators.NurbsCurveEvaluator;
import net.jgeom.nurbs.geomContainers.GeometryArray;

public class MeshedNurbsCurve extends BasicNurbsCurve{
	
	NurbsCurveEvaluator evaluator = null;
	int segU=50;
	
	public MeshedNurbsCurve(NurbsCurve c)
	{
		super(c.getControlPoints(),c.getKnots(),c.getDegree());
	}
	
	 public MeshedNurbsCurve (ControlPoint4f cps[], float uK[], int degree) 
	 {
		 super(cps,uK,degree);
	 }
	 
	 public void setEvaluator(NurbsCurveEvaluator evaluator)
	 {
		 this.evaluator= evaluator;
	 }
	 
	 public void setPrecision(int segU)
	 {
		 this.segU=segU;
	 }
	 
	 public GeometryArray getMeshedCurve()
	 {
		 return evaluator.evaluateCurve(this, segU);
	 }
	 
}
