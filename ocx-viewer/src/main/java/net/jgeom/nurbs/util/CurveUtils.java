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

import java.util.LinkedList;


/**
 * @author sg
 */
public final class CurveUtils {
    private CurveUtils() {
    };

    public static NurbsCurve increaseDegree(NurbsCurve curve, int t) {
        if (t <= 0) {
            throw new IllegalArgumentException("New degree smaller or equal degree of curve");
        }
        ControlPoint4f[] cp = curve.getControlPoints();
        float[] u = curve.getKnots();
        int p = curve.getDegree();
        int seg = curve.getKnotVector().getNumberOfSegments()+1;
        ControlPoint4f[] cph = new ControlPoint4f[cp.length  + t * seg];
        float[] uh = new float[u.length  + t * seg];
       

        float bezalfs[][] = new float[p + t + 1][p + 1];
        ControlPoint4f[] bpts = new ControlPoint4f[p + 1];
        ControlPoint4f[] ebpts = new ControlPoint4f[p + t + 1];
        ControlPoint4f[] nextbpts = new ControlPoint4f[p - 1];
        float[] alfs = new float[p - 1];

        double m = u.length - 1;
        int ph = p + t;
        int ph2 = ph / 2;
        bezalfs[0][0] = bezalfs[p + t][p] = 1;
        int[] binph = binomials(ph, ph2);
        int[] binp = binomials(p, p);
        int[] bint = binomials(t, t);
        for (int i = 1; i <= ph2; i++) {
            float inv = 1f/binph[i];
            int mpi = Math.min(p, i);
            for (int j = Math.max(0, i - t); j <= mpi; j++) {
                bezalfs[i][j] = inv * binp[j] * bint[i - j];
            }
        }
        for (int i = ph2 + 1; i < ph; i++) {
            double mpi = Math.min(p, i);
            for (int j = Math.max(0, i - t); j <= mpi; j++) {
                bezalfs[i][j] = bezalfs[ph - i][p - j];
            }
        }
        int mh = ph;
        int kind = ph + 1;
        int r = -1;
        int a = p;
        int b = p + 1;
        int cind = 1;
        float ua = u[0];
        cph[0] = new ControlPoint4f(cp[0]);
        for (int i = 0; i <= ph; i++) {
            uh[i] = ua;
        }
        for (int i = 0; i <= p; i++) {
            bpts[i] = new ControlPoint4f(cp[i]);
        }

        while (b < m) {
            int i = b;
            while (b < m && u[b] == u[b + 1]) {
                b = b + 1;
            }
            int mul = b - i + 1;
            mh += mul + t;
            float ub = u[b];
            int oldr = r;
            r = p - mul;
            int lbz = 1;
            if (oldr > 0) {
                lbz = (oldr + 2) / 2;
            }
            int rbz = ph;
            if (r > 0) {
                rbz = ph - (r + 1) / 2;
                float numer = ub - ua;
                for (int k = p; k > mul; k--) {
                    alfs[k - mul - 1] = numer / (u[a + k] - ua);
                }
                for (int j = 1; j <= r; j++) {
                    int save = r - j;
                    int s = mul + j;
                    for (int k = p; k >= s; k--) {
                        bpts[k].interpolate(bpts[k - 1], bpts[k], alfs[k - s]);
                    }
                    nextbpts[save] = bpts[p];
                }
            }
            for (i = lbz; i <= ph; i++) {
                ebpts[i]=new ControlPoint4f();
                int mpi=Math.min(p,i);
                for(int j=Math.max(0, i-t); j<=mpi; j++){
                    ebpts[i].addScaled(bpts[j], bezalfs[i][j]);
                }
            }
            if(oldr>1){
                int first=kind-2;
                int last=kind;
                float den=ua-ub; 
                for(int tr=1; tr<oldr; tr++){
                    i=first;
                    int j=last;
                    int kj=j-kind+1;
                    while(j-i>tr){
                        if(i<cind){
                            float alf=(ub-uh[i])/(ua-uh[i]);
                            cph[i].interpolate(cph[i-1], cph[i], alf);
                        }
                        if(j>=lbz){
                            if(j-tr<=kind-ph+oldr){
                                float gam=(ub-uh[j-tr])/den;
                                ebpts[kj].interpolate(ebpts[kj+1], ebpts[kj], gam);
                            }
                            else{
                                float bet=(ub-uh[kind-1])/den;
                                ebpts[kj].interpolate(ebpts[kj+1], ebpts[kj], bet); 
                            }
                        }
                        i++;
                        j--;
                        kj--;
                    }
                    first--;
                    last++;
                }
            }
            if(a!=p){
                for(i=0; i<ph-oldr; i++){
                  uh[kind]=ua;
                  kind++;
                }
            }
            for(int j=lbz; j<=rbz; j++){
                cph[cind]=new ControlPoint4f(ebpts[j]);
                cind++;
            }
            if(b<m){
                for(int j=0; j<r; j++){
                    bpts[j].set(nextbpts[j]);
                }
                for(int j=r; j<=p; j++){
                    bpts[j].set(cp[b-p+j]);
                }
                a=b;
                b++;
                ua=ub;
            }
            else{
                for(i=0; i<=ph; i++){
                    uh[kind+i]=ub;
                }
            }
        }
        int nh = mh - ph - 1;
        float[] uNew = new float[mh+1];
        for (int i = 0; i < uNew.length; i++){
            uNew[i] = uh[i];
        }
        ControlPoint4f[] cpNew = new ControlPoint4f[nh+1];
        for (int i = 0; i < cpNew.length; i++){
            cpNew[i] = new ControlPoint4f(cph[i]);
        }
        return new BasicNurbsCurve(cpNew, uNew, p+t);
    }

    private static int[] binomials(int x, int y) {
        int[] bin = new int[y + 1];
        bin[0] = 1;
        for (int i = 1; i <= y; i++) {
            bin[i] = (bin[i - 1] * x) / i;
            x--;
        }
        return bin;
    }
    
    public static NurbsCurve connectCurves(NurbsCurve[] curves){
        if(curves.length<2){
            throw new IllegalArgumentException("Must be at least 2 curves");
        }
        int degree=curves[0].getDegree();
        LinkedList knots=new LinkedList();
        Float zero=0f;
        for(int i=0; i<=degree; i++){
            knots.add(zero);
        }
        LinkedList cps=new LinkedList();
        cps.add(curves[0].getControlPoints()[0]);
        for(int i=0; i<curves.length; i++){
            float[] u=curves[i].getKnots();
            if(degree!=curves[i].getDegree()){
                throw new IllegalArgumentException("Curves must have equal degrees");
            }
            float start=((Float)knots.getLast()).floatValue()-u[0];
            for(int j=degree+1; j<u.length-degree-1; j++){
                knots.addLast( (float) start+u[j]);
            }
            for(int j=0; j<degree; j++){
                knots.addLast( (float) start+u[u.length-1]);
            }
            
            ControlPoint4f pts[]=curves[i].getControlPoints();
            for(int j=1; j<pts.length; j++){
                cps.addLast(pts[j]);
            }
            //TODO check start and end point equality
        }
        knots.addLast(knots.getLast());
        
        float[] u=new float[knots.size()];
        for(int i=0; i<u.length; i++){
            u[i]=((Float)knots.get(i)).floatValue();
        }
        ControlPoint4f cp[]=new ControlPoint4f[cps.size()];
        cps.toArray(cp);
        return new BasicNurbsCurve(cp, u, degree);
    }
    
    public static NurbsCurve connectCurves(NurbsCurve curve1, NurbsCurve curve2){
        return connectCurves(new NurbsCurve[]{curve1, curve2});
    }
    
    public NurbsCurve equalizeConnectCurves(NurbsCurve[] curves){
        //TODO equalize degrees and movw curves so that end of curves[i-1] is the same as start of curves[i];
        return connectCurves(curves);
    }
    
}
