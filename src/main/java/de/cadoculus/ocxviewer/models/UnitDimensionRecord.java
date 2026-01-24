/*
 * Copyright 2025 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cadoculus.ocxviewer.models;

import java.util.List;

/**
 * Wrapper record for a unit.
 * @param dimension the dimension
 * @param id the id of the dimension
 * @param dimensionless true if the dimension is dimensionless
 * @param types the list of dimension types
 * @author Carsten Zerbst
 */
public record UnitDimensionRecord(
        oasis.unitsml.Dimension dimension,
        String id,
        boolean dimensionless,
        List<DimensionTypesRecord> types        ) {

    //private static final Logger LOG = LogManager.getLogger(UnitRecord.class);

    public static UnitDimensionRecord create(oasis.unitsml.Dimension dimension) {

        var types = dimension.getLengthsAndMassesAndTimes().stream()
                .map( DimensionTypesRecord::create)
                .toList();


        return new UnitDimensionRecord(
                dimension,
                dimension.getId(),
                dimension.isDimensionless(),
                types);
    }
}
