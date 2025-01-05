module com.prostep.openpdm.ocxviewer {
    requires javafx.fxml;
    requires javafx.controls;

    requires atlantafx.base;
    requires org.kordamp.ikonli.javafx;
    requires commons.cli;

    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    requires java.desktop;
    requires java.prefs;
    requires org.kordamp.ikonli.materialdesign2;
    requires jakarta.xml.bind;
    requires org.eclipse.persistence.core;
    requires org.eclipse.persistence.moxy;
    requires vecmath;



    opens de.cadoculus.ocxviewer to javafx.fxml;
    exports de.cadoculus.ocxviewer;
    exports de.cadoculus.ocxviewer.views;
    opens de.cadoculus.ocxviewer.views to javafx.fxml;
}