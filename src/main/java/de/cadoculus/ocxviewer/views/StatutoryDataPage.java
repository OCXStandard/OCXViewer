package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

public class StatutoryDataPage extends AbstractDataViewPage{
    public static final String NAME = "Statutory Data";
    private static final Logger LOG = LogManager.getLogger(StatutoryDataPage.class);

    public StatutoryDataPage() {
        super(NAME);

        createTitle("Information about statutory data");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "No implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);



        setCenter(warning);

    }
}
