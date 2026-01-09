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
 * A page displaying information about a Surface.
 * The SurfacePages is not intended to be navigated directly, but rather as a logical child, e.g. from the ReferenceSurfacesPage
 * @author Carsten Zerbst
 */
public class SurfaceCollectionPage extends AbstractDataViewSubPage<org.ocx_schema.v310.SurfaceCollection> {
    public static final String NAME = "Surface Collection";
    private static final Logger LOG = LogManager.getLogger(SurfaceCollectionPage.class);

    public SurfaceCollectionPage(org.ocx_schema.v310.SurfaceCollection collection, Page parent) {
        super(collection, parent, "Surface \u00AB"+collection.getId() + "\u00BB");

        // now we can build the page
        final var bcs = getBreadcrumbs();


        createTitle( bcs, getName(), "Information about an OCX Surface");

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "Not implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        setCenter(warning);

    }

}
