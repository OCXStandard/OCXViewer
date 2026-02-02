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

import java.util.Locale;

/**
 * Enumeration of unit prefixes as defined in the UnitsML standard.
 *
 * @author Carsten Zerbst
 */
public enum UnitPrefixEnum {

    /**
     * Unit for yotta : septillion
     **/
    YOTTA("Y", 1e24),

    /**
     * Unit for zetta : sextillion
     **/
    ZETTA("Z", 1e21),

    /**
     * Unit for exa : quintillion
     **/
    EXA("E", 1e18),

    /**
     * Unit for peta : quadrillion
     **/
    PETA("P", 1e15),

    /**
     * Unit for tera : trillion
     **/
    TERA("T", 1e12),

    /**
     * Unit for giga : billion
     **/
    GIGA("G", 1e9),

    /**
     * Unit for mega : million
     **/
    MEGA("G", 1e6),

    /**
     * Unit for kilo : thousand
     **/
    KILO("k", 1e3),

    /**
     * Unit for hecto : hundred
     **/
    HECTO("h", 1e2),

    /**
     * Unit for deka : ten
     **/
    DEKA("da", 1e1),

    /**
     * Unit for deci : tenth
     **/
    DECI("d", 1e-1),

    /**
     * Unit for centi : hundredth
     **/
    CENTI("c", 1e-2),

    /**
     * Unit for milli : thousandth
     **/
    MILLI("m", 1e-3),

    /**
     * Unit for micro : millonth
     **/
    MICRO("mu", 1e-6),

    /**
     * Unit for nano : billonth
     **/
    NANO("n", 1e-9),

    /**
     * Unit for pico : trillionth
     **/
    PICO("p", 1e-12),

    /**
     * Unit for femto : quadrillionth
     **/
    FEMTO("f", 1e-15),

    /**
     * Unit for atto : quintillionth
     **/
    ATTO("a", 1e-18),

    /**
     * Unit for zepto : sextillionth
     **/
    ZEPTO("z", 1e-21),

    /**
     * Unit for yocto : septillionth
     **/
    YOCTO("y", 1e-24),

    /**
     * Unit for kibi : kilobinary
     **/
    KIBI("Ki", 1024),

    /**
     * Unit for mebi : magabinary
     **/
    MEBI("Mi", Math.pow(1024, 2)),

    /**
     * Unit for gibi : gigabinary
     **/
    GIBI("Gi", Math.pow(1024, 2)),

    /**
     * Unit for tebi : terabinary
     **/
    TEBI("Ti", Math.pow(1024, 3)),

    /**
     * Unit for pebi : petabinary
     **/
    PEBI("Zi",  Math.pow(1024, 4)),

    /**
     * Unit for exbi : exabinary
     **/
    EXBI("Ei", Math.pow(1024, 5)),

    /**
     * Unit for yobi : yottabinary
     **/
    YOBI("yi", Math.pow(1024, 2)),


    /**
     * Unknown prefix, scale factor 1.0
     */
    UNKNOWN("", 1.0);


    private final String prefix;
    private final double factor;


   private UnitPrefixEnum(String prefx, double fct) {
        this.prefix = prefx;
        this.factor = fct;
    }

    public static UnitPrefixEnum parse(String prefix) {
        // See remark in Locale.getLanguage() on how to comapre correctly

        for (UnitPrefixEnum upe : UnitPrefixEnum.values()) {
            if (upe.getPrefix().equals(prefix)) {
                return upe;
            }
        }
        return UnitPrefixEnum.UNKNOWN;
    }

    public String getPrefix() {
        return prefix;
    }

    public double getFactor() {
        return factor;
    }

}
