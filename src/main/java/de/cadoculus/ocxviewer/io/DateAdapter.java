package de.cadoculus.ocxviewer.io;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {


    @Override
    public LocalDate unmarshal(String inputDate) {
        return inputDate != null ? (LocalDate) DateTimeFormatter.ISO_OFFSET_DATE.parse(inputDate) : null;
    }

    @Override
    public String marshal(LocalDate inputDate) {
        return inputDate != null ? DateTimeFormatter.ISO_OFFSET_DATE.format(inputDate) : null;
    }


}
