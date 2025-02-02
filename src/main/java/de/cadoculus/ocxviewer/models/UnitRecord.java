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

import oasis.unitsml.*;

import java.util.Iterator;
import java.util.List;

public record UnitRecord(
        Unit unit,
        String id,
        String name,
        String symbol,
        String dimension
        ) {

    public static UnitRecord create(Unit unit) {
        StringBuilder names = new StringBuilder();
        final List<UnitName> nameList = unit.getUnitNames();
        for (Iterator<UnitName> unitIt = nameList.iterator();unitIt.hasNext();) {
            UnitName name = unitIt.next();
            names.append(name.getLang()).append(" :  ").append(name.getValue());
            if (unitIt.hasNext()) {
                names.append(", ");
            }
        }

        StringBuilder symbols = new StringBuilder();
        // TODO:
//        final List<UnitSymbol> symbolList = unit.getUnitSymbols();
//        for (Iterator<UnitSymbol> symbolIt = symbolList.iterator();symbolIt.hasNext();) {
//            UnitSymbol symbol = symbolIt.next();
//            names.append(symbol.Lang.get()).append(" :  ").append(symbol.Name.get());
//            if (symbolIt.hasNext()) {
//                names.append(", ");
//            }
//        }


        return new UnitRecord(
                unit,
                unit.getId(),
                names.toString(),
                symbols.toString(),
                unit.getDimensionURL()
        );
    }
}
