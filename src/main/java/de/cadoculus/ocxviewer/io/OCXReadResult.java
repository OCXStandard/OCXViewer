package de.cadoculus.ocxviewer.io;

import org.ocx_schema.v310rc3.OcxXMLT;

public record OCXReadResult(String originalNamespace, OcxXMLT ocx) {
}
