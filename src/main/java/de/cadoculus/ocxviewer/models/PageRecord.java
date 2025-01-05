package de.cadoculus.ocxviewer.models;


import de.cadoculus.ocxviewer.views.Page;
import javafx.scene.Node;

import java.util.Objects;

public record PageRecord(String title,
                         Node graphic,
                         Class<? extends Page> pageClass) {

    public static final PageRecord ROOT = new PageRecord("ROOT", null, null);


    public PageRecord {
        Objects.requireNonNull(title, "title");
    }

    public boolean isGroup() {
        return pageClass == null;
    }

    private boolean contains(String text, String filter) {
        return text.toLowerCase().contains(filter.toLowerCase());
    }
}