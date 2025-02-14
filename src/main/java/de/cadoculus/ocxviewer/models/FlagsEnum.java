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


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;


/**
 * Enum to map a Locale with a flag emoji
 */
public enum FlagsEnum {

    ENGLISH(Locale.ENGLISH,  "images/flags/GB@2x.png" ),
    US_ENGLISH(Locale.forLanguageTag("en-us"),  "images/flags/US@2x.png" ),
    DANISH(Locale.forLanguageTag("dk"),  "images/flags/DK@2x.png" ),
    GERMAN(Locale.GERMAN,  "images/flags/DE@2x.png" ),
    FINNISH( Locale.forLanguageTag("fi"),  "images/flags/FI@2x.png" ),
    FRENCH(Locale.FRENCH,  "images/flags/FR@2x.png" ),
    SPANISH(Locale.forLanguageTag("es"),  "images/flags/ES@2x.png" ),
    ITALIAN(Locale.ITALIAN,  "images/flags/IT@2x.png" ),
    DUTCH( Locale.forLanguageTag("nl"),  "images/flags/NL@2x.png" ),
    NORWEGIAN( Locale.forLanguageTag("nk"),  "images/flags/NK@2x.png" ),
    PORTUGUESE( Locale.forLanguageTag("pt"),  "images/flags/PT@2x.png" ),
    RUSSIAN(Locale.forLanguageTag("ru"),  "images/flags/US@2x.png" ),
    POLISH(Locale.forLanguageTag("pl"),  "images/flags/PL@2x.png" ),
    TURKISH( Locale.forLanguageTag("tr"),  "images/flags/TR@2x.png" ),
    JAPANESE(Locale.forLanguageTag("jp"),  "images/flags/JP@2x.png" ),
    CHINESE(Locale.CHINESE,  "images/flags/CN@2x.png" ),
    KOREAN(Locale.forLanguageTag("kr"),  "images/flags/KR@2x.png"),
    UNKNOWN(Locale.getDefault(),  "" );

    private final Locale locale;
    private final String flag;
    private static final Logger LOG = LogManager.getLogger(FlagsEnum.class);


    FlagsEnum(Locale locale, String flag) {
        this.locale = locale;
        this.flag = flag;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getFlag() {
        return flag;
    }

    public static FlagsEnum fromLocale(String lang) {
        // See remark in Locale.getLanguage() on how to comapre correctly
        var test = Locale.forLanguageTag(lang);
        LOG.debug("forLocale {} {}", lang, test);
        for (FlagsEnum flag : FlagsEnum.values()) {

            //LOG.info("check against {} {}", flag.getLocale().getCountry(), flag.getLocale().getLanguage());
            if (flag.getLocale().equals(test)) {
                //LOG.info("found {} {}", flag.getLocale(), flag.getFlag());
                return flag;
            }

        }
        return FlagsEnum.UNKNOWN;
    }
}
