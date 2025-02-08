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


    /**
     * Called before the page is shown.
     */
    public void beforeShow();

    /**
     * Called after the page is shown.
     */
    public void afterShow();

    /**
     * Called before the page is hidden.
     */
    public void beforeHide();

    /**
     * Called after the page is hidden.
     */
    public void afterHide();

    /**
     * Called before the page is closed.
     */
    public void beforeClose();



}
