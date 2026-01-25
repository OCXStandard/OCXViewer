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

import de.cadoculus.ocxviewer.models.WorkingContext;
import oasis.unitsml.EnumeratedRootUnit;
import oasis.unitsml.RootUnits;
import oasis.unitsml.Unit;
import oasis.unitsml.UnitSymbol;

public class UnitHelper {

    public static Unit getMilliMeterUnit() {

        try {
            for (Unit unit : WorkingContext.getInstance().getOcx().getUnitsML().getUnitSet().getUnits()) {
                 //<unitsml:EnumeratedRootUnit unit="test" powerNumerator="1"/>
             var     test = unit.getRootUnits().getEnumeratedRootUnits().stream().filter(r ->
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
        millimeter.setRootUnits( new RootUnits());
        millimeter.getRootUnits().getEnumeratedRootUnits().add( eru);

        return millimeter;
    }

}
