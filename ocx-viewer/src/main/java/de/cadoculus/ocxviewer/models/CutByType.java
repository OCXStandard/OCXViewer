/*
Copyright 2025 Carsten Zerbst

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
package de.cadoculus.ocxviewer.models;

import org.ocx_schema.v3x.Hole2DContourT;

/**
 * Enumeration of different cut by types in OCX files.
 *
 * @author Carsten Zerbst
 */
public enum CutByType {
    HOLE2D_CONTOUR,
    OUTER_CONTOUR,
    INNER_CONTOUR,
    SLOT_CONTOUR,
    UNKNOWN;


    public static CutByType forType(Object obj) {

        if ( obj instanceof Hole2DContourT) {
            return HOLE2D_CONTOUR;
        } else {
            return UNKNOWN;
        }

    }
}
