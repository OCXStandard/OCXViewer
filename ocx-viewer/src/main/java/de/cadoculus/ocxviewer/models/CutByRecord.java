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

/**
 * A record representing a "Cut By" description, including its type and the associated hole object.
 *
 * @author Carsten Zerbst
 */
public record CutByRecord(CutByType type, String name, String id, String guid, Object hole)  {

    public static CutByRecord forHole(Object obj) {

        if ( obj instanceof org.ocx_schema.v3x.Hole2DContourT hole2DContourT) {
            return new CutByRecord( CutByType.HOLE2D_CONTOUR, hole2DContourT.getName(), hole2DContourT.getId(), hole2DContourT.getGUIDRef(), hole2DContourT);
        } else if ( obj instanceof org.ocx_schema.v3x.Contour3DT outerContourT) {
            return new CutByRecord( CutByType.OUTER_CONTOUR, "", "", "",  outerContourT);
        }

        return new CutByRecord( CutByType.UNKNOWN, "", "", "",  null);

    }
}
