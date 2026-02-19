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

/**
 * An enumeration for geometry qualities given by the maximum distance to the "perfect" solution.
 */
public enum GeometryQuality {
    COARSE(5.0),
    MODERATE(2.5),
    MEDIUM(1),
    FINE(0.5),
    FINEST(0.1);


    GeometryQuality(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    private final double maxDistance;

}
