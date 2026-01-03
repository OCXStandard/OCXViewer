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

import oasis.unitsml.EnumeratedRootUnit;
import oasis.unitsml.Unit;
import oasis.unitsml.UnitName;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

/**
 * Wrapper record for a unit.
 * @param unit the unit
 * @param id    the id of the unit
 * @param names the list of unit names
 * @param symbol the unit symbols
 * @param rootUnits the root units
 * @param dimension the dimension URL
 * @author Carsten Zerbst
 */
public record UnitRecord(
        Unit unit,
        String id,
        List<UnitName> names,
        String symbol,
        String rootUnits,
        String dimension
        ) {

    //private static final Logger LOG = LogManager.getLogger(UnitRecord.class);

    public static UnitRecord create(Unit unit) {

        var onLinux = System.getProperty("os.name").toLowerCase().contains("linux");
        StringBuilder names = new StringBuilder();
        final List<UnitName> nameList = unit.getUnitNames();
//        for (Iterator<UnitName> unitIt = nameList.iterator();unitIt.hasNext();) {
//            UnitName name = unitIt.next();
//            FlagsEnum flag = FlagsEnum.fromLocale(name.getLang());
//            //LOG.info("found flag: " + flag.name() + " " + flag.getFlag());
//            if (onLinux) {
//                names.append( flag.getFlag()).append(" ").append(flag.getLocale().getDisplayLanguage()).append(" :  ").append(name.getValue());
//            } else {
//                names.append(flag.getFlag()).append(" :  ").append(name.getValue());
//            }
//            if (unitIt.hasNext()) {
//                names.append(", ");
//            }
//        }
        StringBuilder rootUnits = new StringBuilder();
        if ( unit.getRootUnits() !=null) {
            for(Iterator<EnumeratedRootUnit> rootUnitIt = unit.getRootUnits().getEnumeratedRootUnits().iterator();rootUnitIt.hasNext();) {
                EnumeratedRootUnit rootUnit = rootUnitIt.next();

                if ( StringUtils.isNoneEmpty(rootUnit.getPrefix())) {
                    rootUnits.append( rootUnit.getPrefix()).append(" ");
                }
                rootUnits.append(rootUnit.getUnit());
                switch ( rootUnit.getPowerNumerator()) {
                    case 1:
                        rootUnits.append(" ");
                        break;
                    case 2:
                        rootUnits.append("² ");
                        break;
                    case 3:
                        rootUnits.append("³ ");
                        break;
                    case 4:
                        rootUnits.append("⁴ ");
                        break;
                    case -1:
                        rootUnits.append("⁻¹ ");
                        break;
                    case -2:
                        rootUnits.append("⁻² ");
                        break;
                    case -3:
                        rootUnits.append("⁻³ ");
                        break;
                    default:
                        rootUnits.append("^").append(rootUnit.getPowerNumerator()).append(" ");
                }

                if (rootUnitIt.hasNext()) {
                    rootUnits.append(", ");
                }
            }

        }

        StringBuilder symbols = new StringBuilder();
        if ( unit.getUnitSymbols() !=null) {
            unit.getUnitSymbols().forEach((symbol) -> symbols.append(symbol.getType()).append(", "));
        }


        return new UnitRecord(
                unit,
                unit.getId(),
                nameList,
                symbols.toString(),
                rootUnits.toString(),
                unit.getDimensionURL()
        );
    }
}
