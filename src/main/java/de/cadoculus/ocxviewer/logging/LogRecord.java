package de.cadoculus.ocxviewer.logging;

public record LogRecord(org.apache.logging.log4j.Level category, String msg) {
}
