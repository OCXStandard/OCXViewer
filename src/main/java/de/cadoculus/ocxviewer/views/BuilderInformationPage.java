package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

public class BuilderInformationPage extends AbstractDataViewPage{
    public static final String NAME = "Builder Information";
    private static final Logger LOG = LogManager.getLogger(ClassficationSocietyPage.class);

    public BuilderInformationPage() {
        super(NAME);

        createTitle("Information about the builder of the OCX file.");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "No implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        setCenter(warning);

    }
}
