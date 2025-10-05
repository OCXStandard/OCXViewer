package de.cadoculus.ocxviewer.models;

import org.ocx_schema.v310rc3.SurfaceCollection;
import org.ocx_schema.v310rc3.SurfaceT;

/**
 * This is a wrapper clase for both Surface and SurfaceCollection
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

