package de.cadoculus.ocx3.impl;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class LocalDateTimeAdapter extends XmlAdapter<String, Temporal> {

    private static final Logger LOG = LogManager.getLogger(LocalDateTimeAdapter.class);
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;


    @Override
    public Temporal unmarshal(String strVal) throws Exception {

        if (strVal == null || strVal.isEmpty()) {
            return LocalDateTime.now();
        }

        try {
            return ZonedDateTime.parse(strVal);
        } catch (Exception exp) {
            LOG.warn("failed to parse {} as date time", strVal, exp);
            return LocalDateTime.now();
        }

    }

    @Override
    public String marshal(Temporal dateTime) throws Exception {
        if ( dateTime ==null) {
            return null;
        }
        if ( dateTime instanceof LocalDateTime localDateTime) {
            return localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        } else if ( dateTime instanceof ZonedDateTime zonedDateTime) {
            return zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } else if ( dateTime !=null) {
                LOG.warn("got unsupported temporal {} '{}'", dateTime.getClass(), dateTime.toString());
        }
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);

    }
}
