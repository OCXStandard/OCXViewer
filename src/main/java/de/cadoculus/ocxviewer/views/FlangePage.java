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
package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

/**
 * A page displaying information about a Stiffener.
 * The StiffnerPage is not intended to be navigated directly, but rather as a logical child.
 * @author Carsten Zerbst
 */
public class FlangePage extends AbstractDataViewSubPage<org.ocx_schema.v310.Stiffener> {
    public static final String NAME = "Stiffener";
    private static final Logger LOG = LogManager.getLogger(FlangePage.class);

    public FlangePage(org.ocx_schema.v310.Stiffener stiffener, Page parent) {
        super(stiffener, parent, "Stiffener «"+stiffener.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle( bcs, getName(), "Information about an OCX Stiffener");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "Not implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        setCenter(warning);

    }

}
