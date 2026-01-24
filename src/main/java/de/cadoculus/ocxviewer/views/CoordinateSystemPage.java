/*
 * Copyright 2025 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cadoculus.ocxviewer.views;

import atlantafx.base.layout.InputGroup;
import atlantafx.base.theme.Styles;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.QuantityT;

/**
 * This class displays the coordinated system contained in the OCX file
 * @author Carsten Zerbst
 */
public class CoordinateSystemPage extends AbstractDataViewSubPage<org.ocx_schema.v310.CoordinateSystem> implements Page {
    public static final String NAME = "Coordinate System";
    private static final Logger LOG = LogManager.getLogger(CoordinateSystemPage.class);


    private final Label label = new Label();
    private final InputGroup originGroup;
    private final InputGroup primAxisGroup;
    private final InputGroup secAxisGroup;


    public CoordinateSystemPage(org.ocx_schema.v310.CoordinateSystem coosys, Page parent) {
        super(coosys, parent, "Coordinate System «"+coosys.getId() + "»");

        final var bcs = getBreadcrumbs();

        createTitle( bcs, getName(), "Information about the contained coordinate systems.");

        GridPane gridPane = createDefaultGrid();
        this.setCenter(gridPane);


        int row = 0;
        Label label = null;
        TextField textField = null;

        label = new Label("GUID");
        label.setTooltip(new Tooltip("The GUID of the Coordinate System."));
        gridPane.add(label, 0, row);

        textField = new TextField(coosys.getGUIDRef());
        gridPane.add(textField, 1, row++, 3,1);

        if (StringUtils.isNoneEmpty( coosys.getDescription())) {
            label = new Label("Description");
            label.setTooltip(new Tooltip("The description of the Coordinate System."));
            gridPane.add(label, 0, row);

            textField = new TextField(coosys.getDescription());
            gridPane.add(textField, 1, row++, 3,1);
        }

        label = new Label("Local Cartesian");
        label.setTooltip(new Tooltip("To specify a Local (Orthogonal) Axis System Origin and two of the local X,Y,Z axis need to be specified. When used to specify a Plane the XY (UV) plane is considered. Optional if the coordinate system is referring to the global coordinate frame (world coordinates)"));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        label = new Label("Origin");
        label.setTooltip(new Tooltip("The origin of a local or global coordinate system."));
        gridPane.add(label, 0, ++row);
        originGroup = createOrRebind(null, coosys.getLocalCartesian().getOrigin(), true);
        gridPane.add(originGroup, 1,row);


        label = new Label("Primary Axis");
        label.setTooltip(new Tooltip("The unit vector of the local X-axis (U-Axis) given in global Coordinate System."));
        gridPane.add(label, 0, ++row);
        primAxisGroup = createOrRebind(null, coosys.getLocalCartesian().getPrimaryAxis(), true);
        gridPane.add(primAxisGroup, 1, row);

        label = new Label("Secondary Axis");
        label.setTooltip(new Tooltip("The unit vector of the local Y-axis (V-Axis) given in global Coordinate System."));
        gridPane.add(label, 2, row);
        secAxisGroup = createOrRebind(null, coosys.getLocalCartesian().getSecondaryAxis(), true);
        gridPane.add(secAxisGroup, 3, row);

        label = new Label("References Planes");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(20, 0, 10, 0));

        var tabX = createTab("X Grid",coosys.getXRefPlanes());
        var tabY = createTab("Y Grid", coosys.getYRefPlanes());
        var tabZ = createTab("Z Grid", coosys.getZRefPlanes());

        var gridTab = new TabPane( tabX, tabY, tabZ );
        gridTab.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        gridTab.setMinWidth(450);

        gridPane.add(gridTab, 0, ++row, 4,1);

    }

    private Tab createTab(String title, org.ocx_schema.v310.RefPlanesT refPlanesT) {

        var repfplanesTab = new Tab(title);

        var vbox = new VBox();

        if ( refPlanesT instanceof org.ocx_schema.v310.XRefPlanes xRefPlanes) {
            var rev = new Label( xRefPlanes.isIsReversed()? "X-Planes are reversed":"X-Planes are not reversed");
            //rev.setGraphic( new FontIcon( xRefPlanes.isIsReversed()? MaterialDesignA.MDI_ARROW_LEFT_BOLD : MaterialDesignA.MDI_ARROW_RIGHT_BOLD));
            vbox.getChildren().add(    rev);
        }

        ObservableList<org.ocx_schema.v310.RefPlaneT> refplanes = FXCollections.observableArrayList();
        if (refPlanesT !=null && refPlanesT.getRefPlanes() !=null && ! refPlanesT.getRefPlanes().isEmpty() ) {
            refplanes.addAll( refPlanesT.getRefPlanes() );
        }

        var tableColumn1 = new TableColumn<org.ocx_schema.v310.RefPlaneT, String>("ID");
        tableColumn1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getId())
        );

        var tableColumn2 = new TableColumn<org.ocx_schema.v310.RefPlaneT, String>("GUID");
        tableColumn2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getGUIDRef())
        );

        var tableColumn3 = new TableColumn<org.ocx_schema.v310.RefPlaneT, String>("Name");
        tableColumn3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getName())
        );

        var tableColumn4 = new TableColumn<org.ocx_schema.v310.RefPlaneT, Boolean>("Display");
        tableColumn4.setCellValueFactory(
                c -> new SimpleBooleanProperty(c.getValue().isDisplayGrid())
        );

        var tableColumn5 = new TableColumn<org.ocx_schema.v310.RefPlaneT, QuantityT>("Location");
        tableColumn5.setCellValueFactory(
                c -> new SimpleObjectProperty<>(c.getValue().getReferenceLocation())
        );
        tableColumn5.setCellFactory( createQuantityCellfactory( ));

        var tableX = new TableView<>(refplanes);
        tableX.getColumns().setAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);
        tableX.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );
        vbox.getChildren().add(tableX);
        repfplanesTab.setContent(vbox);

        return repfplanesTab;

    }


    @Override
    public void afterShow() {

        // Party !
        // table.getSelectionModel().selectFirst();
    }



}
