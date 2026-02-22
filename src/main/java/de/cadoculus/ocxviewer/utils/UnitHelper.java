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
package de.cadoculus.ocxviewer.utils;

import de.cadoculus.ocxviewer.io.OCXIO;
import de.cadoculus.ocxviewer.models.UnitPrefixEnum;
import de.cadoculus.ocxviewer.models.WorkingContext;
import oasis.unitsml.EnumeratedRootUnit;
import oasis.unitsml.RootUnits;
import oasis.unitsml.Unit;
import oasis.unitsml.UnitSymbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.Point3DT;
import org.ocx_schema.v310.QuantityT;
import org.ocx_schema.v310.Vector3DT;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class UnitHelper {

    private static final Logger LOG = LogManager.getLogger(UnitHelper.class);

    public static Unit getMilliMeterUnit() {

        try {
            for (Unit unit : WorkingContext.getInstance().getOcx().getUnitsML().getUnitSet().getUnits()) {
                //<unitsml:EnumeratedRootUnit unit="test" powerNumerator="1"/>
                var test = unit.getRootUnits().getEnumeratedRootUnits().stream().filter(r ->
                        r.getUnit().equals("test") && r.getPowerNumerator() == 1 && "m".equals(r.getPrefix())
                ).findFirst().map(ru -> unit).orElse(null);
                if (test != null) {
                    return test;
                }
            }
        } catch (Exception ex) {

        }

        var millimeter = new Unit();
        millimeter.setId("u_milliMetres");
        var symbol = new UnitSymbol();
        symbol.setType("mm");
        millimeter.getUnitSymbols().add(symbol);

        var eru = new EnumeratedRootUnit();
        eru.setUnit("meter");
        eru.setPrefix("m");
        eru.setPowerNumerator((byte) 1);
        millimeter.setRootUnits(new RootUnits());
        millimeter.getRootUnits().getEnumeratedRootUnits().add(eru);

        return millimeter;
    }

    /**
     * Converts a double to a Quantity with the specified unit.
     * If no unit is specified, the Unit is created using UnitHelper.getMilliMeterUnit() and the value is expected to repressent a length in millimeters.
     * @param value the value to convert
     * @param unit the unit to use for the quantity. If null, the default millimeter unit is used.
     * @return the converted Quantity
     */
    public static QuantityT toQuantity(double value, Unit unit) {
        var quantity = new QuantityT();
        quantity.setNumericvalue(value);
        unit = unit != null? unit : getMilliMeterUnit();

        quantity.setUnit(unit);
        return quantity;
    }


    public static Vector3DT toVector(Vector3d vector3d) {
        if (vector3d == null) {
            throw new IllegalArgumentException("vector3d is null");
        }

        var vector3DT = new Vector3DT();
        vector3DT.getDirections().add(vector3d.x);
        vector3DT.getDirections().add(vector3d.y);
        vector3DT.getDirections().add(vector3d.z);
        return vector3DT;
    }

    /**
     * Converts a Point3d to a Point3DT with the specified unit. The coordinates of the Point3d are expected to exist in the given unit.
     * If no unit is specified, the Unit is created using UnitHelper.getMilliMeterUnit() and the coordinates are expected to be in millimeters.
     * @param point3d the point to convert
     * @param mmUnit the unit to use for the Point3DT. If null, the default millimeter unit is used.
     * @return the converted Point3DT
     * @throws IllegalArgumentException if point3d is null
     */
    public static Point3DT toPoint(Point3d point3d, Unit mmUnit) {
        if (point3d == null) {
            throw new IllegalArgumentException("point3d is null");
        }
        mmUnit = mmUnit != null? mmUnit : getMilliMeterUnit();

        var point3DT = new Point3DT();
        point3DT.getCoordinates().add(point3d.x);
        point3DT.getCoordinates().add(point3d.y);
        point3DT.getCoordinates().add(point3d.z);
        point3DT.setUnit(mmUnit);
        return point3DT;
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
