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
    requires javafx.controls;

    exports de.cadoculus.ocxviewer;
    opens de.cadoculus.ocxviewer;
    opens oasis.unitsml;
    opens org.ocx_schema.v310;

    exports de.cadoculus.ocxviewer.logging to org.apache.logging.log4j.core;
    exports de.cadoculus.ocxviewer.views to javafx.fxml;

}