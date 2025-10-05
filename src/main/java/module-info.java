module ocxviewer {

    requires commons.cli;
    requires hisrc.basicjaxb.runtime;
    requires jakarta.xml.bind;
    requires java.prefs;
    requires javafx.fxml;
    requires javafx.swing;
    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires vecmath;
    requires java.desktop;
    requires atlantafx.base;
    requires javafx.graphics;
    requires org.apache.logging.log4j;

    exports de.cadoculus.ocxviewer;
    opens de.cadoculus.ocxviewer;
    opens oasis.unitsml;
    opens org.ocx_schema.v310rc3;

    exports de.cadoculus.ocxviewer.logging to org.apache.logging.log4j.core;

}