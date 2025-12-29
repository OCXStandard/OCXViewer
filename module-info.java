module com.prostep.openpdm.ocxviewer {

    requires javafx.fxml;
    requires javafx.controls;

    requires atlantafx.base;
    requires org.kordamp.ikonli.javafx;
    requires commons.cli;

    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    requires java.desktop;
    requires java.sql;
    requires java.prefs;
    requires org.kordamp.ikonli.materialdesign2;
    requires jakarta.xml.bind;
    requires org.eclipse.persistence.core;
    requires org.eclipse.persistence.moxy;
    requires vecmath;



    opens de.cadoculus.ocxviewer to javafx.fxml;



    exports oasis.unitsml;
    exports org.ocx_schema.v310;

    opens  oasis.unitsml to org.eclipse.persistence.core;
    opens  org.ocx_schema.v310 to org.eclipse.persistence.core;
    opens  oasis.unitsml to org.eclipse.persistence.moxy;
    opens  org.ocx_schema.v310 to org.eclipse.persistence.moxy;



    exports de.cadoculus.ocxviewer;
    exports de.cadoculus.ocxviewer.views;
    opens de.cadoculus.ocxviewer.views to javafx.fxml;
    exports de.cadoculus.ocxviewer.logging;
    opens de.cadoculus.ocxviewer.logging to javafx.fxml;

    opens de.cadoculus.spiel to javafx.graphics;

}