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

package net.jgeom.util;

import javax.vecmath.Point2d;
/*
 * DistancePointSegmentExample, calculate distance to line
*/

public class DistancePoint {

    /**
     * Wrapper function to accept the same arguments as the other examples
     * 
     * @param x3
     * @param y3
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double distanceToSegment(double x3, double y3, double x1, double y1, double x2, double y2) {
	final Point2d p3 = new Point2d(x3, y3);
	final Point2d p1 = new Point2d(x1, y1);
	final Point2d p2 = new Point2d(x2, y2);
	return distanceToSegment(p1, p2, p3);
    }

    /**
     * Returns the distance of p3 to the segment defined by p1,p2;
     * 
     * @param p1
     *                First point of the segment
     * @param p2
     *                Second point of the segment
     * @param p3
     *                Point to which we want to know the distance of the segment
     *                defined by p1,p2
     * @return The distance of p3 to the segment defined by p1,p2
     */
    public static double distanceToSegment(Point2d p1, Point2d p2, Point2d p3) {

	final double xDelta = p2.x - p1.x;
	final double yDelta = p2.y - p1.y;

	if ((xDelta == 0) && (yDelta == 0)) {
	    throw new IllegalArgumentException("p1 and p2 cannot be the same point");
	}

	final double u = ((p3.x - p1.x) * xDelta + (p3.y - p1.y) * yDelta) / (xDelta * xDelta + yDelta * yDelta);

	final Point2d closestPoint;
	if (u < 0) {
	    closestPoint = p1;
	} else if (u > 1) {
	    closestPoint = p2;
	} else {
	    closestPoint = new Point2d(p1.x + u * xDelta, p1.y + u * yDelta);
	}

	return closestPoint.distance(p3);
    }
    
    public static Point2d getNormalProjectionOnSegment(Point2d p1, Point2d p2, Point2d p3) {

    	final double xDelta = p2.x - p1.x;
    	final double yDelta = p2.y - p1.y;

    	if ((xDelta == 0) && (yDelta == 0)) {
    	    throw new IllegalArgumentException("p1 and p2 cannot be the same point");
    	}

    	final double u = ((p3.x - p1.x) * xDelta + (p3.y - p1.y) * yDelta) / (xDelta * xDelta + yDelta * yDelta);

    	final Point2d closestPoint;
    	if (u < 0) {
    	    closestPoint = p1;
    	} else if (u > 1) {
    	    closestPoint = p2;
    	} else {
    	    closestPoint = new Point2d(p1.x + u * xDelta, p1.y + u * yDelta);
    	}

    	return closestPoint;
        }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// Test example
	System.out.println(String.format("Distance from 5,5 to (10,10)-(20,20): %f", distanceToSegment(5, 5, 10, 10, 20, 20)));
	System.out.println(String.format("Distance from 15,15 to (10,10)-(20,20): %f", distanceToSegment(15, 15, 10, 10, 20, 20)));
	System.out.println(String.format("Distance from 15,15 to (20,10)-(20,20): %f", distanceToSegment(15, 15, 20, 10, 20, 20)));
	System.out.println(String.format("Distance from 0,15 to (20,10)-(20,20): %f", distanceToSegment(0, 15, 20, 10, 20, 20)));
	System.out.println(String.format("Distance from 0,25 to (20,10)-(20,20): %f", distanceToSegment(0, 25, 20, 10, 20, 20)));
	System.out.println(String.format("Distance from -13,-25 to (-50,10)-(20,20): %f", distanceToSegment(-13, -25, -50, 10, 20, 20)));

	// Should give:
	// Distance from 5,5 to (10,10)-(20,20): 7.071068
	// Distance from 15,15 to (10,10)-(20,20): 0.000000
	// Distance from 15,15 to (20,10)-(20,20): 5.000000
	// Distance from 0,15 to (20,10)-(20,20): 20.000000
	// Distance from 0,25 to (20,10)-(20,20): 20.615528
	// Distance from -13,-25 to (-50,10)-(20,20): 39.880822
    }

}
