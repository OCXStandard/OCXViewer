package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

public class TonnageInformationPage extends AbstractDataViewPage{
    public static final String NAME = "Tonnage Information";
    private static final Logger LOG = LogManager.getLogger(TonnageInformationPage.class);

    public TonnageInformationPage() {
        super(NAME);

        createTitle("Information about the tonnage.");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "No implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);



        setCenter(warning);

    }
}
