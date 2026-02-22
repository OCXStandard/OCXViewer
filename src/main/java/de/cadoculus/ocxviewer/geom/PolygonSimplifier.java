/*
Copyright 2026 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer.geom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple polygon simplifier that reduces the number of points in a polygon by checking the distance of points to a line between two endpoints.
 */
public class PolygonSimplifier {

    private static final Logger LOG = LogManager.getLogger(PolygonSimplifier.class);

    private final GeometryQuality quality;

    /**
     * Creates a new PolygonSimplifier with the given quality.
     *
     * @param quality the quality of the simplification, which determines the maximum distance to the "perfect" solution
     */
    public PolygonSimplifier(GeometryQuality quality) {
        this.quality = quality;
    }

    /**
     * Simplifies a polygon
     *
     * @param points the list of points representing the polygon
     * @return a simplified list of points representing the polygon
     */
    public List<Point3d> simplify(List<Point3d> points) {

        if ( points == null ) {
            throw new IllegalArgumentException("expect none null points list");
        }
        if ( points.size() <3 ) {
            return points;
        }

        LOG.debug("Simplifying polygon with {} points using quality {}", points.size(), quality);

        var result = new ArrayList<Point3d>();

        var lastStartPointIdx = 0;
        result.add(points.get(lastStartPointIdx));

        int i = 2;

        while( i < points.size()  ) {

            Point3d startPoint = result.getLast();
            Point3d endPointToTest = points.get(i);
            LOG.trace("Testing line from #{}--{}, {} to {}", lastStartPointIdx, i, startPoint, endPointToTest);
            LOG.trace("   at positions #{}--{}", lastStartPointIdx+1, i-1);

            // Create a line from startPointToTest to endPointToTest
            // and check the distance of all other points to this line
            for (int k = lastStartPointIdx+1; k < i; k++) {
                Point3d testPoint = points.get(k);

                double d = distanceToLine(testPoint, startPoint, endPointToTest);
                LOG.trace("   at #{} {}, distance  {}", k, testPoint, d);
                if (d > quality.getMaxDistance()) {
                    // exceeded the maximum distance, use the previous endpoint

                    lastStartPointIdx = i-1;
                    result.add(points.get(lastStartPointIdx));


                    LOG.trace("   exceeded tolerance at #{} {} width distance {}, use #{} {}",
                            k, testPoint, d, lastStartPointIdx,  points.get(lastStartPointIdx));

                    i= lastStartPointIdx;
                    LOG.trace("   continue search for endpoint at #{}", i);
                  break ;
                }
            }
            i++;
        }
        if ( result.getLast().distance(points.getLast()) > 1e-3 ) {
            result.add(points.getLast());
        }

        return result;

    }

    public static double distanceToLine(Point3d pointToTest, Point3d startPoint, Point3d endPoint) {
        // vector ba = endPoint - startPoint
        double bax = endPoint.x - startPoint.x;
        double bay = endPoint.y - startPoint.y;
        double baz = endPoint.z - startPoint.z;

        // vector pa = pointToTest - startPoint
        double pax = pointToTest.x - startPoint.x;
        double pay = pointToTest.y - startPoint.y;
        double paz = pointToTest.z - startPoint.z;

        // cross product pa x ba
        double crossX = pay * baz - paz * bay;
        double crossY = paz * bax - pax * baz;
        double crossZ = pax * bay - pay * bax;

        // length off cross product
        double numerator = Math.sqrt(crossX * crossX + crossY * crossY + crossZ * crossZ);

        // length of baseline
        double denominator = Math.sqrt(bax * bax + bay * bay + baz * baz);

        if (denominator == 0) return 0; // startPoint and endPoint are the same point
        return numerator / denominator;
    }

}
