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
import javax.vecmath.Vector3d;

/**
 * A Basic implementation of a NurbsCurve.
 * @author sg
 * @version 1.0
 */
public class BasicNurbsCurve implements NurbsCurve, Cloneable {
  private ControlPoint4f cpoly[];
  KnotVector uKnots;
  float tmin=0;
  float tmax=50;

  /**
   * Create a Nurbs Curve from the given Controlpoints, Knots and degree.<br>
   * [TODO Validate Input, part of it is done by creating the KnotVector]
   * 
   * @param cps Array of Controlpoints
   * @param uK Knot values
   * @param degree Degree of the Nurbs Curve
   */
  public BasicNurbsCurve(ControlPoint4f cps[], float uK[], int degree) { //TODO: validate input
    this(cps, new KnotVector(uK, degree));
  }
  

  /**
   * Generate a Nurbs from the given Controlpoints and the given Knotvector.<br>
   * [TODO validate input]
   * @param cps Array of Controlpoints
   * @param uKnots Knotvector of the Nurbs
   */
  public BasicNurbsCurve(ControlPoint4f[] cps, KnotVector uKnots) {
    cpoly = cps;
    this.uKnots = uKnots;
    try {
        if (uKnots.length() != uKnots.getDegree() + cpoly.length +1) {
            throw new IllegalArgumentException("Nurbs Curve has wrong knot number, found : "+uKnots.length()+" instead of expected : deg="+uKnots.getDegree()+"cpoly.length="+cpoly.length+"+1"+"=>"+(uKnots.getDegree() + cpoly.length +1));
        }
	} catch (IllegalArgumentException e) {
		System.err.println(e.getMessage()+" recompute a smooth knot vector");
		this.generateSmoothKnots();
	}
  }


  public ControlPoint4f[] getControlPoints() {
    return cpoly;
  }

  public float[] getKnots() {
    return uKnots.get();
  }
  
  public KnotVector getKnotVector(){
      return uKnots;
  }

  public int getDegree() {
    return uKnots.getDegree();
  }

  public Point3f pointOnCurve(float u) {
    Point3f res = new Point3f();
    pointOnCurve(u, res);
    return res;
  }

  public void pointOnCurve(float u, Point3f out) {
	    int span = uKnots.findSpan(u);
	    int degree = uKnots.getDegree();
	    double bf[] = uKnots.basisFunctions(span, u);
	    int i=0;
	  try{
    ControlPoint4f cw = new ControlPoint4f(0, 0, 0, 0);
    for (i = 0; i <= degree; i++) {
    	int index=span - degree + i;
    	//be safe
    	if(index<0)index=0;
    	if(index>cpoly.length-1)index=cpoly.length-1;
      ControlPoint4f tmp = (ControlPoint4f) cpoly[index].clone();
      tmp.weight();
      tmp.scale((float) bf[i]);
      cw.add(tmp);
    }
    cw.unweight(out);
	  }catch(Exception e)
	  {
		  System.out.println("couldnt calculate point on Curve : span - degree + i :"+span +" "+ degree+ " " + i+" ctrlPoints number : "+cpoly.length);
	  }
  }
  
  /**
   * Note : Code taken from J3D.org
   * Convenience method to set knots that give a better looking curve shape
   * using the existing curve degree. The traditional way of setting these is
   * to have knot[i] = i, but whenever curves change this results in a lot of
   * extra calculations. This smoothing function will localize the changes at
   * any particular breakpoint in the line.
   */
  public void generateSmoothKnots()
  {
//      //numKnots = numControlPoints + degree + 1;
//	  int numKnots=cpoly.length+uKnots.getDegree()+1;
//	  tmax=cpoly.length - uKnots.getDegree() + 1;
//	  
//	  float [] uKnotsSmooth = new float[numKnots];
//      for (int i=0; i<uKnots.getDegree(); i++) {
//    	  uKnotsSmooth[i]                    = tmin;
//    	  uKnotsSmooth[i + cpoly.length] = tmax;
//      }
//      
//      System.out.println("tmin"+tmin+"tmax"+tmax);
//      System.out.print("Knot : ");
//      
//      //
//      // Evenly distribute remainder
//      //
//
//      float interval = (tmax - tmin) / (numKnots - uKnots.getDegree() - uKnots.getDegree() + 1);
//      for (int i=uKnots.getDegree(); i<cpoly.length; i++)
//    	  uKnotsSmooth[i] = tmin + (i - uKnots.getDegree() + 1) * interval;
//      
//      uKnotsSmooth[uKnotsSmooth.length-1]=uKnotsSmooth[uKnotsSmooth.length-2];
//      
//
//      
//     
//      uKnots= new KnotVector(uKnotsSmooth,uKnots.getDegree());
	  
	  
	  int numKnots=cpoly.length+uKnots.getDegree()+1;
     // if(knots.length < numKnots)
      //   knots = new float[numKnots];
	  float [] uKnotsSmooth=null;
//	  if(uKnots.getN()<numKnots)
		  uKnotsSmooth = new float[numKnots];
		  
	  
      int j;

      for(j = 0; j < numKnots; j++)
      {
          if(j <= uKnots.getDegree())
        	  uKnotsSmooth[j] = 0;
          else if(j < cpoly.length)
        	  uKnotsSmooth[j] = j - uKnots.getDegree() + 1;
          else if(j >= cpoly.length)
        	  uKnotsSmooth[j] = cpoly.length - uKnots.getDegree() + 1;
      }
      
//      System.out.print("recompute knots : ");
//      String knot="";

//      uKnotsSmooth=new float[]{0,0,3.2f,3.2f};
//      System.out.println("degree :"+uKnots.getDegree());
      
//      String kn="kn ";
//      for(int i=0;i<uKnotsSmooth.length;i++)
//    	  kn+=uKnotsSmooth[i] +" ";
//      System.out.println(kn);
      uKnots= new KnotVector(uKnotsSmooth,uKnots.getDegree());
  }

  //TODO revalidate and add to supply normals calculated by NURBS for Surface
  //  public void pointAndNormalOnCurve(double u, Point3f pOut, Vector3d nOut) {
  //    int span = uKnots.findSpan(u);
  //    double bf[][] = uKnots.dersBasisFuns(span, u, 2);
  //    ControlPoint cw = new ControlPoint(0, 0, 0, 0);
  //    int degree=uKnots.getDegree();
  //    for (int i = 0; i <= degree; i++) {
  //      ControlPoint tmp = (ControlPoint) cpoly[span - degree + i].clone();
  //      tmp.weight();
  //      tmp.scale(bf[0][i]);
  //      cw.add(tmp);
  //    }
  //    cw.unweight(pOut);
  //    Vector3d CK[] = new Vector3d[2];
  //    curveDerivs(span, u, 2, bf, CK);
  //    curveNormal(u, CK, nOut);
  //  }
  //
    public void curveDerivs(float u, int d, Vector3d[] CK) {
      int span = uKnots.findSpan(u);
      curveDerivs(span, u, d, CK);
    }
  
    public void curveDerivs(int span, float u, int d, Vector3d[] CK) {
      float nders[][] = uKnots.dersBasisFuns(span, u, d);
      curveDerivs(span, u, d, nders, CK);
    }
  
    public void curveDerivs(int span, double u, int d, float nders[][], Vector3d[] CK) {
      int p = uKnots.getDegree();
      if (d > p) {
        d = p + 1;
      }
      for (int k = 0; k < d; k++) {
        CK[k] = new Vector3d(0, 0, 0);
        for (int j = 0; j <= p; j++) {
          CK[k].x = CK[k].x + nders[k][j] * cpoly[span - p + j].x;
          CK[k].y = CK[k].y + nders[k][j] * cpoly[span - p + j].y;
          CK[k].z = CK[k].z + nders[k][j] * cpoly[span - p + j].z;
        }
      }
    }
  //
  //  public void curveNormal(double u, Vector3d normal) {
  //    Vector3d[] CK = new Vector3d[3];
  //    curveDerivs(u, 2, CK);
  //    curveNormal(u, CK, normal);
  //  }
  //
  //  public void curveNormal(double u, Vector3d CK[], Vector3d normal) {
  //    double s = (CK[2].dot(CK[1])) / (CK[1].lengthSquared());
  //    normal.scaleAdd(-s, CK[1], CK[2]);
  //    normal.normalize();
  //  }

	public void setTminTmax(float tmin, float tmax) {
		this.tmin=tmin;
		this.tmax=tmax;
	}

}
