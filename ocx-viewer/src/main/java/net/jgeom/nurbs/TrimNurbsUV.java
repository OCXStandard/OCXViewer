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

/**
 * @author alex
 * This class define a 2D Nurbs trimming curve. It trims a NurbsSurface in UV-Space
 */
public class TrimNurbsUV extends TrimCurve {
	NurbsCurve curve=null;//keep a reference to the original NurbsCurve

	public TrimNurbsUV(NurbsCurve curve, int segnum) {
		super();
		this.curve=curve;
		float uKnots[] = curve.getKnots();
		float u = uKnots[0];
		float max = uKnots[uKnots.length - 1];
		float uStep = (max - u) / segnum;
//
		UVCoord2f linesLocal[] = new UVCoord2f[segnum + 1];
//		
//		class uAndDerivative implements Comparable
//		{
//			uAndDerivative(double u,double der)
//			{
//				this.u=u;
//				this.derivative=der;
//			}
//			double u;
//			double derivative;
//			public int compareTo(Object o) {
//				if(derivative>((uAndDerivative)o).derivative)
//					return 1;
//				else if(derivative==((uAndDerivative)o).derivative)
//					return 0;
//				else
//					return -1;
//			}
//		}
//		
//		ArrayList<uAndDerivative>secondDerivatives=new ArrayList<uAndDerivative>();
//		for(int i=0;i<segnum;i++)
//		{
//			Vector3d[] CK= new Vector3d[2];
//			curve.curveDerivs(u, 2, CK);	
//			//get the max
//			if(CK[1].x>CK[1].y)
//				secondDerivatives.add(new uAndDerivative(u,CK[1].x));
//			else
//				secondDerivatives.add(new uAndDerivative(u,CK[1].y));
//			u += uStep;
//		}
		
//		ArrayList<Integer> usIndices=new ArrayList<Integer>(); 
//		int ptsCount=segnum;
//		for(int i=0;i<ptsCount;i++)
//		{
//			int index=secondDerivatives.indexOf(Collections.max(secondDerivatives));
//			secondDerivatives.remove(index);
//			usIndices.add(index);
//		}
//		secondDerivatives.remove(0);
//		secondDerivatives.remove(secondDerivatives.size()-1);
		

		//tries to set inflection points at derivative maxs
		
//		System.out.println(secondDerivatives);
//		int nb=segnum;
//		UVCoord2f linesLocal[] = new UVCoord2f[nb];
//		Point3f point1 =curve.pointOnCurve(uKnots[0]);
//		UVCoord2f coord1 = new UVCoord2f(point1.x, point1.y);
//		linesLocal[0]=coord1;
//		
//		Collections.sort(secondDerivatives);
////		Collections.reverse(secondDerivatives);
//		
//		ArrayList<Float>us=new ArrayList<Float>();
//		for(int i=0;i<nb;i++)
//			us.add((float)secondDerivatives.get(i).u);
//		
//		Collections.sort(us);
//		
//		for(int i=1;i<nb-1;i++)
//		{
//			Point3f point = curve.pointOnCurve(us.get(i));
//			UVCoord2f coord = new UVCoord2f(point.x, point.y);
//			System.out.println((float)secondDerivatives.get(i).u+"   -   "+(float)secondDerivatives.get(i).derivative);
//			linesLocal[i]=coord;
//		}
//		
//		Point3f pointn =curve.pointOnCurve(uKnots[uKnots.length - 1]);
//		UVCoord2f coordn = new UVCoord2f(pointn.x, pointn.y);
//		linesLocal[nb-1]=coordn;

		linesLocal = new UVCoord2f[segnum+1];
		u = uKnots[0];
		for (int i = 0; i <= segnum; i++) {
			Point3f point = curve.pointOnCurve(u);
			//convert 3d point to 2d UV.
			UVCoord2f coord = new UVCoord2f(point.x, point.y);
			linesLocal[i] = coord;
			u += uStep;
		}
		
		this.lines=linesLocal;
	}
	
	public NurbsCurve getNurbsCurve()
	{
		return this.curve;
	}

}
