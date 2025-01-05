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
import javax.vecmath.Vector4f;
import java.util.LinkedList;
import java.util.List;

/**
 * A Basic NurbsSurface implementation.
 * 
 * @author sg
 * @version 1.2
 */
public class BasicNurbsSurface implements NurbsSurface {
	protected KnotVector uKnots;
    protected KnotVector vKnots;
    protected ControlNet cpnet;
    List<TrimCurve> innerTrimms = new LinkedList<TrimCurve>();
    List<TrimCurve> outerTrimms = new LinkedList<TrimCurve>();
    
    /**
     * Create a Nurbs Surface form the given Controlnet and the knot values of
     * degree p in u direction and of degree q in v direction.
     * 
     * @param cps
     *            ControlNet of the Nurbs
     * @param uK
     *            Knot values in u direction
     * @param vK
     *            Knot values in v direction
     * @param p
     *            degree in u direction
     * @param q
     *            degree in v direction
     */
    public BasicNurbsSurface(ControlNet cps, float uK[], float vK[], int p, int q) throws IllegalArgumentException {
        this(cps,new KnotVector(uK, p),new KnotVector(vK, q));
    }

    /**
     * Create a Nurbs form the Controlnet and the two Knot vectors.
     * 
     * @param net
     *            Contorl net of Nurbs
     * @param u
     *            KnotVector in u direction
     * @param v
     *            KnotVector in v direction
     */
    public BasicNurbsSurface(ControlNet net, KnotVector u, KnotVector v) throws IllegalArgumentException {
        cpnet = net;
        uKnots = u;
        vKnots = v;
        validate();
    }

    private void validate() {
		try {
			if (uKnots.length() != uKnots.getDegree() + cpnet.uLength() + 1) {
				throw new IllegalArgumentException(
						"Nurbs Surface has wrong Knot number in u Direction\n"+"expecting U : " + uKnots.getDegree()
						+ "(deg)+" + cpnet.uLength() + "(ctl pts) +1="
						+ (int) (uKnots.getDegree() + cpnet.uLength() + 1)
						+ " but found :" + uKnots.length());
			}
			if (vKnots.length() != vKnots.getDegree() + cpnet.vLength() + 1) {
				throw new IllegalArgumentException(
						"Nurbs Surface has wrong Knot number in v Direction\n"+"expecting V : " + vKnots.getDegree()
						+ "(deg)+" + cpnet.vLength() + "(ctl pts) +1="
						+ (int) (vKnots.getDegree() + cpnet.vLength() + 1)
						+ " but found :" + vKnots.length());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage() + " generate new knots vectors");
			this.generateSmoothKnots();
		}

	}

    public ControlNet getControlNet() {
        return cpnet;
    }

    public int getUDegree() {
        return uKnots.getDegree();
    }

    public int getVDegree() {
        return vKnots.getDegree();
    }

    public float[] getUKnots() {
        return uKnots.get();
    }

    public float[] getVKnots() {
        return vKnots.get();
    }

    public Point3f pointOnSurface(float u, float v) {
        Point3f res = new Point3f();
        pointOnSurface(u, v, res);
        return res;
    }

    public void pointOnSurface(float u, float v, Point3f out) {
    	//compensate approximation error;
//    	if(u>uKnots.get(uKnots.length()-1))
//    		u=uKnots.get(uKnots.length()-1);
//    	if(v>vKnots.get(vKnots.length()-1))
//    		v=vKnots.get(uKnots.length()-1);
//    	
//    	if(u<uKnots.get(0))
//    		u=uKnots.get(0);
//    	if(v<vKnots.get(0))
//    		v=vKnots.get(0);
    	
        int uspan = uKnots.findSpan(u); // TODO: n?
        double bfu[] = uKnots.basisFunctions(uspan, u);

        int vspan = vKnots.findSpan(v); // TODO: n?
        double bfv[] = vKnots.basisFunctions(vspan, v);

        int p = uKnots.getDegree();
        int q = vKnots.getDegree();
        ControlPoint4f tmp[] = new ControlPoint4f[q + 1];
        for (int l = 0; l <= q; l++) {
            tmp[l] = new ControlPoint4f(0, 0, 0, 0);
            for (int k = 0; k <= p; k++) {
            	int indexU=uspan - p + k;
//            	if(indexU<0)
//            		indexU=0;
            	int indexV=vspan - q + l;
//            	if(indexV<0)
//            		indexV=0;
                ControlPoint4f pw = (ControlPoint4f) cpnet.get(indexU, indexV).clone();
                pw.weight();
                pw.scale((float) bfu[k]);
                tmp[l].add(pw);
            }
        }
        ControlPoint4f sw = new ControlPoint4f(0, 0, 0, 0);
        for (int l = 0; l <= q; l++) {
            tmp[l].scale((float) bfv[l]);
            sw.add(tmp[l]);
        }
        sw.unweight(out);
    }
    


    public double[] invert(Point3f p, double ui, double vi, double theta) {
        double res[] = new double[2];
        // TODO

        return res;
    }

    public void derivatives(float u, float v, int d) {
        ControlPoint4f skl[][] = surfaceDerivs(u, v, d);

    }
    

    
public ControlPoint4f[][] surfaceDerivs(float u, float v, int d) {
        ControlPoint4f skl[][] = new ControlPoint4f[d + 1][d + 1];
        int p = uKnots.getDegree();
        int q = vKnots.getDegree();

        int du = Math.min(d, p);
        for (int k = p + 1; k <= d; k++) {
            for (int l = 0; l <= d - k; l++) {
                skl[k][l] = new ControlPoint4f();
            }
        }

        int dv = Math.min(d, q);
        for (int l = q + 1; l <= d; l++) {
            for (int k = 0; k <= d - l; k++) {
                skl[k][l] = new ControlPoint4f();
            }
        }

        int uspan = uKnots.findSpan(u);
        float nu[][] = uKnots.dersBasisFuns(uspan, u, du);

        int vspan = vKnots.findSpan(v);
        float nv[][] = vKnots.dersBasisFuns(vspan, v, dv);

        for (int k = 0; k <= du; k++) {
            Vector4f temp[] = new Vector4f[q + 1];
            for (int s = 0; s <= q; s++) {
                temp[s] = new Vector4f();
                Vector4f tmp = new Vector4f();
                for (int r = 0; r <= p; r++) {
                    tmp.set(cpnet.get(uspan - p + r, vspan - q + s));
                    tmp.scale(nu[k][r]);
                    temp[s].add(tmp);
                }
            }
            int dd = Math.min(d - k, dv);
            Vector4f tmp = new Vector4f();
            for (int l = 0; l <= dd; l++) {
                skl[k][l] = new ControlPoint4f();
                for (int s = 0; s <= q; s++) {
                    tmp.set(temp[s]);
                    tmp.scale(nv[l][s]);
                    skl[k][l].add(tmp);
                }
            }
        }
        return skl;
    }
    

    public void addInnerTrimCurve(TrimCurve tc) {
        innerTrimms.add(tc);
    }
    
    public void addOuterTrimCurve(TrimCurve tc) {
        outerTrimms.add(tc);
    }

    public List<TrimCurve> getInnerTrimCurves() {
        return innerTrimms;
    }
    
    public List<TrimCurve> getOuterTrimCurves() {
        return outerTrimms;
    }
    
    // return a 3d representation of the trimming curve
	public List<Point3f> computeTrimCurves3d(int index)
    {
    	List<Point3f> polylines=new LinkedList<Point3f>();
    	TrimCurve tc=innerTrimms.get(index);
    		for(UVCoord2f uvCoord : tc.getCoordinates())
    		{
    			polylines.add(this.pointOnSurface(uvCoord.x, uvCoord.y));
    		}
    	return polylines;
    }

	public int getInnerTrimmingCurveCount()
	{
		return innerTrimms.size();
	}
	
	public int getOuterTrimmingCurveCount()
	{
		return outerTrimms.size();
	}
    
    /**
     * Note : Code taken from J3D.org
     * Convenience method to set knots that give a better looking curve shape
     * using the existing curve degree. The traditional way of setting these is
     * to have knot[i] = i, but whenever curves change this results in a lot of
     * extra calculations. This smoothing function will localize the changes at
     * any particular breakpoint in the line.
     */
    public void generateSmoothKnots() {
		System.out.println("generate Knots...");
		// if(knots.length < numKnots)
		//   knots = new float[numKnots];
		
		//u direction
    	int numCtrlPointsU = cpnet.uLength();
		int numKnotsU = numCtrlPointsU + uKnots.getDegree() + 1;
		float[] uKnotsSmooth = null;
//		if (uKnots.getN() < numKnotsU)
			uKnotsSmooth = new float[numKnotsU];

		for (int j = 0; j < numKnotsU; j++) {
			if (j <= uKnots.getDegree())
				uKnotsSmooth[j] = 0;
			else if (j < numCtrlPointsU)
				uKnotsSmooth[j] = j - uKnots.getDegree() + 1;
			else if (j >= numCtrlPointsU)
				uKnotsSmooth[j] = numCtrlPointsU - uKnots.getDegree() + 1;
		}
		uKnots = new KnotVector(uKnotsSmooth, uKnots.getDegree());
		System.err.println("New uKnots size : "+uKnots.length());
		
		//v direction
		int numCtrlPointsV = cpnet.vLength();
		int numKnotsV = numCtrlPointsV + vKnots.getDegree() + 1;
		System.out.println( numCtrlPointsV +" "+ vKnots.getDegree() +" "+ 1);
		float[] vKnotsSmooth = null;
//		if (vKnots.getN() < numKnotsV)
			vKnotsSmooth = new float[numKnotsV];

		for (int j = 0; j < numKnotsV; j++) {
			if (j <= vKnots.getDegree())
				vKnotsSmooth[j] = 0;
			else if (j < numCtrlPointsV)
				vKnotsSmooth[j] = j - vKnots.getDegree() + 1;
			else if (j >= numCtrlPointsV)
				vKnotsSmooth[j] = numCtrlPointsV - vKnots.getDegree() + 1;
		}
		vKnots = new KnotVector(vKnotsSmooth, vKnots.getDegree());
		System.err.println("New vKnots size : "+vKnots.length());
	}
    
    public void removeTrimmingCurves()
    {
    	innerTrimms.clear();
    	outerTrimms.clear();
    }
}
