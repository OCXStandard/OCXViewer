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

import atlantafx.base.controls.Spacer;
import atlantafx.base.theme.Tweaks;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.NavigationEvent;
import de.cadoculus.ocxviewer.models.PageRecord;
import de.cadoculus.ocxviewer.utils.NodeUtils;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.*;
import org.ocx_schema.v310.CoordinateSystem;

import java.lang.ref.Reference;
import java.util.Objects;

/**
 * A tree view for navigating between pages.
 */
public final class PageTree extends TreeView<PageRecord> {
    private static final Logger LOG = LogManager.getLogger(PageTree.class);

    public PageTree() {
        super();

        createTreeItems();

        getSelectionModel().selectedItemProperty().addListener((obs, old, val) -> {

            LOG.info("Selected item: {}", val);

            DefaultEventBus.getInstance().publish( new NavigationEvent(val.getValue().pageClass()));

        });

        getStyleClass().addAll(Tweaks.EDGE_TO_EDGE);

        setShowRoot(false);

        setCellFactory(p -> new NavTreeCell());
    }

    private void createTreeItems() {
        var root = Item.root();

        // ClassificationData, BuilderInformation, TonnageData , StatutoryData    ShipDesignation
        var fileGroup = Item.group("Base Data", new FontIcon(MaterialDesignF.FERRY));
        root.getChildren().add(fileGroup);
        fileGroup.setExpanded(true);

        fileGroup.getChildren().add( Item.page("Header",new FontIcon(MaterialDesignI.INFORMATION_OUTLINE), HeaderPage.class));
        fileGroup.getChildren().add( Item.page(ClassificationSocietyPage.NAME,new FontIcon(MaterialDesignA.ANCHOR), ClassificationSocietyPage.class));
        fileGroup.getChildren().add( Item.page(PrincipalParticularsPage.NAME,new FontIcon(MaterialDesignA.ARROW_LEFT_RIGHT), PrincipalParticularsPage.class));
        fileGroup.getChildren().add( Item.page(BuilderInformationPage.NAME,new FontIcon(MaterialDesignG.GANTRY_CRANE), BuilderInformationPage.class));
        fileGroup.getChildren().add( Item.page(TonnageInformationPage.NAME,new FontIcon(MaterialDesignC.CUBE_OUTLINE), TonnageInformationPage.class));
        fileGroup.getChildren().add( Item.page(StatutoryDataPage.NAME,new FontIcon(MaterialDesignF.FLAG_OUTLINE), StatutoryDataPage.class));
        fileGroup.getChildren().add( Item.page(ShipDesignationPage.NAME,new FontIcon(MaterialDesignS.SCRIPT_TEXT_OUTLINE), ShipDesignationPage.class));

        // Reference Surfaces and Grid
        var geomGroup = Item.group("Geometry", new FontIcon(MaterialDesignS.SHIP_WHEEL));
        root.getChildren().add(geomGroup);
        geomGroup.setExpanded(false);
        geomGroup.getChildren().add( Item.page("Tolerances",new FontIcon(MaterialDesignT.TILDE), TolerancesPage.class));
        geomGroup.getChildren().add( Item.page("Coordinate Systems",new FontIcon(MaterialDesignA.AXIS_ARROW), CoordinateSystemsPage.class));
        geomGroup.getChildren().add( Item.page("Reference Surfaces",new FontIcon(MaterialDesignL.LAYERS_TRIPLE_OUTLINE), ReferenceSurfacesPage.class));


        // DesignView
        var dsgnViewGroup = Item.group("Design Views", new FontIcon(MaterialDesignC.CAMERA_OUTLINE));
        root.getChildren().add(dsgnViewGroup);

        // Arrangements
        var arrangementsGroup = Item.group("Arrangements", new FontIcon(MaterialDesignF.FILE_TREE));
        root.getChildren().add(arrangementsGroup);

        // Hull
        var hullGroup = Item.group("Hull Structure", new FontIcon(MaterialDesignG.GRID_LARGE));
        root.getChildren().add(hullGroup);
        hullGroup.setExpanded(true);
        hullGroup.getChildren().add( Item.group("Panel",new FontIcon(MaterialDesignB.BORDER_NONE)));
        hullGroup.getChildren().add( Item.group("Plate",new FontIcon(MaterialDesignB.BORDER_ALL_VARIANT)));
        hullGroup.getChildren().add( Item.group("Stiffener",new FontIcon(MaterialDesignB.BORDER_HORIZONTAL)));
        hullGroup.getChildren().add( Item.group("Bracket",new FontIcon(MaterialDesignN.NETWORK_STRENGTH_OUTLINE)));
        hullGroup.getChildren().add( Item.group("Member",new FontIcon(MaterialDesignB.BORDER_LEFT_VARIANT)));

        var catalogueGroup = Item.group("Catalogue", new FontIcon(MaterialDesignP.PACKAGE_VARIANT));
        root.getChildren().add(catalogueGroup);
        catalogueGroup.setExpanded(false);
        catalogueGroup.getChildren().add( Item.page("Materials",new FontIcon(MaterialDesignB.BLUR), MaterialsPage.class));
        catalogueGroup.getChildren().add( Item.page("Holes",new FontIcon(MaterialDesignS.STRETCH_TO_PAGE_OUTLINE), HoleShapePage.class));
        catalogueGroup.getChildren().add( Item.page("Bar Sections",new FontIcon(MaterialDesignS.SHAPE_PLUS), BarSectionsPage.class));

        var unitsGroup = Item.group("Units", new FontIcon(MaterialDesignW.WEIGHT_KILOGRAM));
        root.getChildren().add(unitsGroup);
        unitsGroup.setExpanded(false);
        unitsGroup.getChildren().add( Item.page("Units",new FontIcon(MaterialDesignW.WEIGHT_KILOGRAM), UnitsPage.class));
        unitsGroup.getChildren().add( Item.page("Dimensions",new FontIcon(MaterialDesignW.WEIGHT_KILOGRAM), UnitDimensionsPage.class));

        var internalGroup = Item.group("Internal", new FontIcon(MaterialDesignE.EYE_OUTLINE));
        internalGroup.getChildren().add( Item.page(LogPage.NAME,new FontIcon(MaterialDesignC.COMMENT_TEXT_OUTLINE), LogPage.class));
        root.getChildren().add(internalGroup);
        internalGroup.setExpanded(true);


        rootProperty().setValue(root);
    }

    ///////////////////////////////////////////////////////////////////////////

    public static final class NavTreeCell extends TreeCell<PageRecord> {

        private static final PseudoClass GROUP = PseudoClass.getPseudoClass("group");

        private final HBox root;
        private final Label titleLabel;
        private final Node arrowIcon;
        //private final Label tagLabel;

        public NavTreeCell() {
            super();

            titleLabel = new Label();
            titleLabel.setGraphicTextGap(10);
            titleLabel.getStyleClass().add("title");

            arrowIcon = new FontIcon();
            arrowIcon.getStyleClass().add("arrow");

            root = new HBox();
            root.setAlignment(Pos.CENTER_LEFT);
            root.getChildren().setAll(titleLabel, new Spacer(), arrowIcon //, tagLabel
                     );
            root.setCursor(Cursor.HAND);
            root.getStyleClass().add("container");
            root.setMaxWidth(450);

            root.setOnMouseClicked(e -> {
                if (!(getTreeItem() instanceof Item item)) {
                    return;
                }

                if (item.isGroup() && e.getButton() == MouseButton.PRIMARY) {
                    item.setExpanded(!item.isExpanded());
                    // scroll slightly above the target
                    getTreeView().scrollTo(getTreeView().getRow(item) - 10);
                }
            });

            getStyleClass().add("nav-tree-cell");
        }

        @Override
        protected void updateItem(PageRecord nav, boolean empty) {
            super.updateItem(nav, empty);

            if (nav == null || empty) {
                setGraphic(null);
                titleLabel.setText(null);
                titleLabel.setGraphic(null);
            } else {
                setGraphic(root);

                titleLabel.setText(nav.title());
                titleLabel.setGraphic(nav.graphic());

                pseudoClassStateChanged(GROUP, nav.isGroup());
                NodeUtils.toggleVisibility(arrowIcon, nav.isGroup());
            }
        }
    }

    public static final class Item extends TreeItem<PageRecord> {

        private final PageRecord record;

        private Item(PageRecord nav) {
            this.record = Objects.requireNonNull(nav, "nav");
            setValue(nav);
        }

        public boolean isGroup() {
            return record.isGroup();
        }

        public  Class<? extends Page> pageClass() {
            return record.pageClass();
        }

        public static Item root() {
            return new Item(PageRecord.ROOT);
        }

        public static Item group(String title, Node graphic) {
            return new Item(new PageRecord(title, graphic, null));
        }

        public static Item page(String title,
                                 Node graphic,
                                 Class<? extends Page> pageClass) {
            Objects.requireNonNull(pageClass, "pageClass");
            return new Item(new PageRecord(title, graphic, pageClass));
        }


    }
}
