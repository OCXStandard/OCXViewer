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

import de.cadoculus.ocxviewer.io.OCXIO;
import oasis.unitsml.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.Point3DT;
import org.ocx_schema.v310.QuantityT;

import javax.vecmath.Point3d;

/**
 * A utility class for converting units.
 *
 * @author Carsten Zerbst
 */
public class UnitConverter {
    private static final Logger LOG = LogManager.getLogger(UnitConverter.class);

    private UnitConverter() {
    }

    /**
     * Converts a Point3DT to the default unit (millimeters).
     * The scale factor is determined based on the unit specified in the Point3DT, @{see #getScaleFactor(Unit)}.
     * If the point3DT does not contain three coordinates, the returned value are @{see Double.NaN}s.
     * @param point3DT the Point3DT to convert
     * @return the converted Point3d in default units
     * @throws IllegalArgumentException if point3DT is null
     */
    public static Point3d toDefaultUnit(Point3DT point3DT) {
        if (point3DT == null) {
            throw new IllegalArgumentException("point is null");
        }


        var scale = 1.0;
        var test = point3DT.getUnit();
        if ( test instanceof String) {
            LOG.warn("could not resolve Point3DT's unit '{}'", test);
        } else if ( test instanceof Unit) {
            scale = getScaleFactor((Unit) test);
        } else {
            LOG.warn("got unsupported Unit in Point3D '{}'", test);
        }

        double x=Double.NaN, y=Double.NaN, z=Double.NaN;

        if ( point3DT.getCoordinates().size() != 3) {
            LOG.error("invalid Point3DT '{}', {}", point3DT, OCXIO.serialize(point3DT));
        } else {

            x = scale*point3DT.getCoordinates().get(0);
            y = scale*point3DT.getCoordinates().get(1);
            z = scale*point3DT.getCoordinates().get(2);
        }

        return new Point3d(x, y, z);
    }

    /**
     * Converts a QuantityT to the default unit.
     * The scale factor is determined based on the unit specified in the QuantityT, @{see #getScaleFactor(Unit)}.
     * If the quantity is null, @{see Double.NaN} is returned.
     * If the quantity does not have a unit, the numeric value is returned as is.
     *
     * @param quantity the QuantityT to convert
     * @return the converted value in default units
     */
    public static double toDefaultUnit(QuantityT quantity) {

        if (quantity == null) {
            return Double.NaN;
        }
        if (quantity.getUnit() == null) {
            return quantity.getNumericvalue();
        }
        var unit = (Unit) quantity.getUnit();

        double scale = getScaleFactor(unit);

        return quantity.getNumericvalue() * scale;

    }

    /**
     * Gets the scale factor for the given unit to convert it to the default unit.
     * The default unit is millimeters for length and seconds for time.
     * @param unit the unit to convert
     * @return a double scale factor to convert the given unit to the default unit
     */
    public static double getScaleFactor(Unit unit) {

        double scale = 1.0;
        if (unit.getRootUnits() != null && unit.getRootUnits().getEnumeratedRootUnits() != null) {

            if (unit.getRootUnits().getEnumeratedRootUnits().size() == 1) {
                var rootUnit = unit.getRootUnits().getEnumeratedRootUnits().get(0);
                if (rootUnit.getUnit() != null) {
                    if (rootUnit.getPrefix() != null) {
                        scale= UnitPrefixEnum.parse(rootUnit.getPrefix()).getFactor();
                    }

                    if ("meter".equals(rootUnit.getUnit())) {
                        // return always in mm
                        scale *= 1000;
                    } else if ("inch".equals(rootUnit.getUnit())) {
                        scale *= 25.41;
                    } else if ("second".equals(rootUnit.getUnit())) {
                        // return always in seconds
                    } else if ("foot".equals(rootUnit.getUnit())) {
                        scale *= 304.9;
                    } else if ("yard".equals(rootUnit.getUnit())) {
                        scale *= 914.4;
                    } else {
                        LOG.info("got unsupported unit: {} {}", rootUnit.getUnit(), rootUnit.getPrefix());
                    }
                }
            } else {
                LOG.info("got unsupported number of root units: {}", unit.getRootUnits().getEnumeratedRootUnits().size());
            }
        }
        return scale;
    }
}
