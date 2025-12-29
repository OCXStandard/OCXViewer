/*
Copyright 2025 Carsten Zerbst

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
