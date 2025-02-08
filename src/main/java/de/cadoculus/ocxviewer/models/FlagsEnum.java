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


    ENGLISH(Locale.ENGLISH,  "🇬🇧" ),
    US_ENGLISH(Locale.forLanguageTag("en-us"),  "🇺🇸" ),
    GERMAN(Locale.GERMAN,  "🇩🇪" ),
    FRENCH(Locale.FRENCH,  "🇫🇷" ),
    SPANISH(Locale.forLanguageTag("es"),  "🇪🇸" ),
    ITALIAN(Locale.ITALIAN,  "🇮🇹" ),
    DUTCH( Locale.forLanguageTag("nl"),  "🇳🇱" ),
    PORTUGUESE( Locale.forLanguageTag("pt"),  "🇵🇹" ),
    RUSSIAN(Locale.forLanguageTag("ru"),  "🇷🇺" ),
    POLISH(Locale.forLanguageTag("pl"),  "🇵🇱" ),
    TURKISH( Locale.forLanguageTag("tr"),  "🇹🇷" ),
    JAPANESE(Locale.JAPANESE,  "🇯🇵" ),
    CHINESE(Locale.CHINESE,  "🇨🇳" ),
    KOREAN(Locale.KOREAN,  "🇰🇷" ),
    UNKNOWN(Locale.getDefault(),  "🏳️" );

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
        LOG.info("forLocale {} {}", lang, test);
        for (FlagsEnum flag : FlagsEnum.values()) {

            LOG.info("check against {} {}", flag.getLocale().getCountry(), flag.getLocale().getLanguage());
            if (flag.getLocale().equals(test)) {
                LOG.info("found {} {}", flag.getLocale(), flag.getFlag());
                return flag;
            }

        }
        return FlagsEnum.UNKNOWN;
    }
}
