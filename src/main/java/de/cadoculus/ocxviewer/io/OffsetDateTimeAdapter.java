package de.cadoculus.ocxviewer.io;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeAdapter extends XmlAdapter<String, OffsetDateTime> {
    private static final Logger LOG = LogManager.getLogger(OffsetDateTimeAdapter.class);

    @Override
    public OffsetDateTime unmarshal(String inputDate) {

        LOG.info("Unmarshalling date: {}", inputDate);

        return inputDate != null ? (OffsetDateTime) DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(inputDate) : null;
    }

    @Override
    public String marshal(OffsetDateTime inputDate) {
        return inputDate != null ? DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(inputDate) : null;
    }


}
