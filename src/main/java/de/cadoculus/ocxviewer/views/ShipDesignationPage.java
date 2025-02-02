package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

public class ShipDesignationPage extends AbstractDataViewPage{
    public static final String NAME = "Ship Designation";
    private static final Logger LOG = LogManager.getLogger(ShipDesignationPage.class);

    public ShipDesignationPage() {
        super(NAME);

        createTitle("Information about the ship's designation");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "No implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);


        setCenter(warning);

    }
}
