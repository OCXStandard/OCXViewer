package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

public class UnitDimensionsPage extends AbstractDataViewPage{
    public static final String NAME = "Unit Dimensions";
    private static final Logger LOG = LogManager.getLogger(UnitDimensionsPage.class);

    public UnitDimensionsPage() {
        super(NAME);

        createTitle("Information about the unit dimensions.");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "No implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);



        setCenter(warning);

    }
}
