package de.cadoculus.ocxviewer.views;

import javafx.scene.Parent;

public interface Page {

    int MAX_WIDTH = 1680;
    int MIN_WIDTH = 600;
    int HGAP_20 = 20;
    int HGAP_30 = 30;
    int VGAP_10 = 10;
    int VGAP_20 = 20;


    String getName();

    Parent getView();


}
