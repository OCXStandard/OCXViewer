package de.cadoculus.ocx3.impl;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final Logger LOG = LogManager.getLogger(LocalDateAdapter.class);
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDate unmarshal(String strVal) throws Exception {
        if (strVal == null || strVal.isEmpty()) {
            return LocalDate.now();
        }

        try {
            return LocalDate.parse(strVal);
        } catch (Exception exp) {
            LOG.warn("failed to parse {} as local date", strVal, exp);
            return LocalDate.now();
        }

    }

    @Override
    public String marshal(LocalDate dateTime) throws Exception {
        if ( dateTime ==null) {
            return null;
        }

        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);

    }
}
