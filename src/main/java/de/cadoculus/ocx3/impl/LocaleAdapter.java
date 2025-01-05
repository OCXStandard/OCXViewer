package de.cadoculus.ocx3.impl;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Locale;
public class LocaleAdapter extends XmlAdapter<String, Locale> {
    private static final Logger LOG = LogManager.getLogger(LocaleAdapter.class);

    @Override
    public Locale unmarshal(String s) throws Exception {

        Locale locale= Locale.ENGLISH;
        try {
            locale = new Locale(s);
        } catch (Exception exp) {
            LOG.warn("failed to create Locale for string '{}'", s, exp);

        }
        return locale;
    }

    @Override
    public String marshal(Locale locale) throws Exception {
        if ( locale !=null) {
            return locale.getLanguage();
        }
        return "en";
    }
}
