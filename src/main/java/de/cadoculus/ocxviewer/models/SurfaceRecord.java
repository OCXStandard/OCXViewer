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

import org.ocx_schema.v310.SurfaceCollection;
import org.ocx_schema.v310.SurfaceT;

/**
 * This is a wrapper clase for both Surface and SurfaceCollection
 * @param surface the surface
 * @param collection the surface collection
 * @param isCollection true if the record represents a collection
 * @param id the id of the surface or collection
 * @param guid the GUID of the surface or collection
 * @author Carsten Zerbst
 */
public record SurfaceRecord(

        SurfaceT surface,
        SurfaceCollection collection,
        boolean isCollection,
        String id,
        String guid
) {

    public static SurfaceRecord create(SurfaceT surface) {
        return new SurfaceRecord(surface, null, false,  surface.getId(), surface.getGUIDRef());
    }

    public static SurfaceRecord create(SurfaceCollection collection) {
        return new SurfaceRecord(null, collection, true,collection.getId(), collection.getGUIDRef());
    }

}

