package de.cadoculus.ocxviewer.io;

public @interface SchemaVersion {
    public String from() default "3.1.0";
    public String to() default "";
}
