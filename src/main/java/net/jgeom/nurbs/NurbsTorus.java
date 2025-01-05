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

import net.jgeom.nurbs.util.NurbsCreator;
import net.jgeom.util.Axis3D;
import net.jgeom.util.Origin3D;

import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import java.util.List;

public class NurbsTorus implements NurbsSurface{
	
	NurbsSurface ns=null;
	
	public NurbsTorus(double minorRadius, double majorRadius)
	{
		NurbsCurve circle=NurbsCreator.createFullCircle(new Origin3D(new Point3d(new double[]{0,0,0})), (float)minorRadius, NurbsCreator.FC_QUAD9);
		ns=NurbsCreator.createRevolvedSurface(new Axis3D(new Point3d(new double[]{0,majorRadius,0}),new Vector3d(10,0,0)), circle, 2*Math.PI);
	}

	public void addInnerTrimCurve(TrimCurve tc) {
		ns.addInnerTrimCurve(tc);
	}
	
	public void addOuterTrimCurve(TrimCurve tc) {
		ns.addOuterTrimCurve(tc);
	}

	public ControlNet getControlNet() {
		return ns.getControlNet();
	}

	public List getInnerTrimCurves() {
		return ns.getInnerTrimCurves();
	}
	
	public List getOuterTrimCurves() {
		return ns.getOuterTrimCurves();
	}

	public int getUDegree() {
		return ns.getUDegree();
	}

	public float[] getUKnots() {
		return ns.getUKnots();
	}

	public int getVDegree() {
		return ns.getVDegree();
	}

	public float[] getVKnots() {
		return ns.getVKnots();
	}

	public Point3f pointOnSurface(float u, float v) {
		return ns.pointOnSurface(u, v);
	}

	public void pointOnSurface(float u, float v, Point3f out) {
		ns.pointOnSurface(u, v, out);
	}

	public ControlPoint4f[][] surfaceDerivs(float u, float v, int d) {
		return surfaceDerivs(u, v, d);
	}

	public List<Point3f> computeTrimCurves3d(int index) {
		return ns.computeTrimCurves3d(index);
	}

	public int getInnerTrimmingCurveCount() {
		return ns.getInnerTrimmingCurveCount();
	}

	public int getOuterTrimmingCurveCount() {
		return ns.getOuterTrimmingCurveCount();
	}

}
