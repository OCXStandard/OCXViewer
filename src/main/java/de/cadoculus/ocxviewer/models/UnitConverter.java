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

import oasis.unitsml.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310rc3.QuantityT;

public class UnitConverter {
    private static final Logger LOG = LogManager.getLogger(UnitConverter.class);

    private UnitConverter() {}

    public static double toDefaultUnit(QuantityT quantity) {

        if (quantity == null ) {
            return Double.NaN;
        }
        if ( quantity.getUnit() == null ) {
            return quantity.getNumericvalue();
        }
        var unit = (Unit) quantity.getUnit();

        double scale = 1.0;

        if ( unit.getRootUnits() != null && unit.getRootUnits().getEnumeratedRootUnits() != null) {

            if ( unit.getRootUnits().getEnumeratedRootUnits().size()==1) {
                var rootUnit = unit.getRootUnits().getEnumeratedRootUnits().get(0);
                if ( rootUnit.getUnit() != null) {
                    if ( "meter".equals( rootUnit.getUnit())){
                        scale = Math.pow(1000, rootUnit.getPowerNumerator());
                    } else if ( "inch".equals( rootUnit.getUnit())){
                        scale = 25.41;
                    } else if ( "second".equals( rootUnit.getUnit())){
                        scale = Math.pow(60, rootUnit.getPowerNumerator());
                    } else if ( "foot".equals( rootUnit.getUnit())){
                        scale = 304.9;
                    } else if ( "yard".equals( rootUnit.getUnit())){
                        scale = 914.4;
                    } else {
                        LOG.info("got unsupported unit: {} {} {}", rootUnit.getUnit(), rootUnit.getPrefix(), rootUnit.getPowerNumerator());
                    }
                }
            } else {
                LOG.info("got unsupported number of root units: {}", unit.getRootUnits().getEnumeratedRootUnits().size());
            }
        }

        return quantity.getNumericvalue() * scale;


    }
}
