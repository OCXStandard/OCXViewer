/*
Copyright 2026 Carsten Zerbst

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

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.RefPlaneT;

/**
 * A page displaying information about a RefPlane.
 * The RefPlanePage is not intended to be navigated directly, but rather as a logical child.
 *
 * @author Carsten Zerbst
 */
public class RefPlanePage extends AbstractDataViewSubPage<RefPlaneT> {
    public static final String NAME = "Reference Plane";
    private static final Logger LOG = LogManager.getLogger(RefPlanePage.class);

    public RefPlanePage(RefPlaneT refPlaneT, Page parent) {
        super(refPlaneT, parent, "Reference Plane «" + refPlaneT.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();

        createTitle(bcs, getName(), "Information about a Reference Plane.");

        GridPane gridPane = createDefaultGrid();
        setCenter(gridPane);

        int row = 0;

        // ocx:Name
        var label = new Label("Id");
        label.setTooltip(new Tooltip("The plane's Id"));
        gridPane.add(label, 0, row);

        var textField = new TextField();
        gridPane.add(textField, 1, row);
        bindToBean(textField.textProperty(), refPlaneT, "id", String.class);

        label = new Label("Name");
        label.setTooltip(new Tooltip("The plane's name"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row++);
        bindToBean(textField.textProperty(), refPlaneT, "name", String.class);

        // ocx:Guid
        label = new Label("GUID");
        label.setTooltip(new Tooltip("The refPlaneT's GUID"));
        gridPane.add(label, 0, row);
        textField = new TextField();
        gridPane.add(textField, 1, row++);
        bindToBean(textField.textProperty(), refPlaneT, "GUIDRef", String.class);

        label = new Label("Display");
        gridPane.add(label, 0, row);
        var cb  = new CheckBox();
        cb.setSelected( refPlaneT.isDisplayGrid());
        gridPane.add(cb, 1, row++);

        label = new Label("Location");
        label.setTooltip(new Tooltip("The grids location along its normal vector."));
        gridPane.add(label, 0, row);
        var youngsGroup = createAndBind(refPlaneT.getReferenceLocation(), true);
        gridPane.add(youngsGroup, 1, row++);

    }


}
