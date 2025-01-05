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

import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;

/**
 * This is just a class to ensure type safety. Basically it is the same as a
 * Point2f.
 * 
 * @author sg
 * @version 1.0
 */
public class UVCoord2f extends Tuple2f {
    private static final long serialVersionUID = 1L;

    public UVCoord2f(float arg0, float arg1) {
        super(arg0, arg1);
    }

    public UVCoord2f(float[] arg0) {
        super(arg0);
    }

    public UVCoord2f(Tuple2f arg0) {
        super(arg0);
    }

    public UVCoord2f(Tuple2d arg0) {
        super(arg0);
    }

    public UVCoord2f() {
        super();
    }
    
    @Override
    public boolean equals(Object arg0) {
    	if(!(arg0 instanceof UVCoord2f))
    		return false;
    	
    	return this.x==((UVCoord2f)arg0).x && this.y==((UVCoord2f)arg0).y;
    }
    
    public float distanceTo(UVCoord2f pt)
    {
    	return (float)Math.sqrt((x-pt.x)*(x-pt.x) - (y-pt.y)*(y-pt.y));
    }

}
