module ocxviewer {


    requires atlantafx.base;
    requires commons.cli;
    requires hisrc.basicjaxb.runtime;
    requires jakarta.xml.bind;
    requires java.prefs;
    requires javafx.fxml;
    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires vecmath;
    requires java.desktop;
    requires java.xml;
    requires org.eclipse.persistence.moxy;
    //requires  org.eclipse.persistence.moxy;

    exports de.cadoculus.ocxviewer;
    opens de.cadoculus.ocxviewer;

}