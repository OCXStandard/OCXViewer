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

public record DimensionTypesRecord(
        Object dimensionType,
        String typeName,
        int powerNumerator,
        String symbol
) {

    public static DimensionTypesRecord create(Object dimension) {
        if  (dimension instanceof oasis.unitsml.Length length) {
            return new DimensionTypesRecord(
                    length,
                    "Length",
                    length.getPowerNumerator(),
                    length.getSymbol()
            );
        } else if (dimension instanceof oasis.unitsml.Mass mass) {
            return new DimensionTypesRecord(
                    mass,
                    "Mass",
                    mass.getPowerNumerator(),
                    mass.getSymbol()
            );
        } else if (dimension instanceof oasis.unitsml.Time time) {
            return new DimensionTypesRecord(
                    time,
                    "Time",
                    time.getPowerNumerator(),
                    time.getSymbol()
            );
        } else if (dimension instanceof oasis.unitsml.ElectricCurrent electricCurrent) {
            return new DimensionTypesRecord(
                    electricCurrent,
                    "Electric Current",
                    electricCurrent.getPowerNumerator(),
                    electricCurrent.getSymbol()
            );
        } else if (dimension instanceof oasis.unitsml.ThermodynamicTemperature temperature) {
            return new DimensionTypesRecord(
                    temperature,
                    "Temperature",
                    temperature.getPowerNumerator(),
                    temperature.getSymbol()
            );
        } else if (dimension instanceof oasis.unitsml.AmountOfSubstance amountOfSubstance) {
            return new DimensionTypesRecord(
                    amountOfSubstance,
                    "Amount of Substance",
                    amountOfSubstance.getPowerNumerator(),
                    amountOfSubstance.getSymbol()
            );
        } else if (dimension instanceof oasis.unitsml.LuminousIntensity luminousIntensity) {
            return new DimensionTypesRecord(
                    luminousIntensity,
                    "Luminous Intensity",
                    luminousIntensity.getPowerNumerator(),
                    luminousIntensity.getSymbol()
            );
        } else {
            throw new IllegalArgumentException("Unknown dimension type: " + dimension.getClass().getName());
        }
    }
}
