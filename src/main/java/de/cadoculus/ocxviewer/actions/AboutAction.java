package de.cadoculus.ocxviewer.actions;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class AboutAction {

    public final static KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN);
    public final static  String NAME = "About";

    public void run() {
        System.out.println("About");
    }
}
