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
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.SelectionEvent;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import de.cadoculus.ocxviewer.models.LimitedByRecord;
import de.cadoculus.ocxviewer.models.LimitedByType;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import jakarta.xml.bind.JAXBElement;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignB;
import org.ocx_schema.v310.*;

import java.util.ArrayList;

/**
 * A page displaying information about the topology and geometry of a panel.
 * The PanelTopologyAndGeometryPage is not intended to be navigated directly, but rather as a logical child.
 *
 * @author Carsten Zerbst
 */
public class PanelTopologyAndGeometryPage extends AbstractDataViewSubPage<org.ocx_schema.v310.Panel> {
    public static final String NAME = "Panel Topology and Geometry";
    private static final Logger LOG = LogManager.getLogger(PanelTopologyAndGeometryPage.class);

    public PanelTopologyAndGeometryPage(org.ocx_schema.v310.Panel panel, Page parent) {
        super(panel, parent, "Topology and Geometry of Panel «" + panel.getId() + "»");

        // now we can build the page
        final var bcs = getBreadcrumbs();
        createTitle(bcs, getName(), "The topology and geometry of a panel.");

        var tabPanel = new TabPane();
        setCenter(tabPanel);

        tabPanel.getTabs().add(createLimitsTab());
        tabPanel.getTabs().add(createBoundaryTab());
        tabPanel.getTabs().add(createSurfaceTab());

    }

    private Tab createSurfaceTab() {
        var tab = new Tab("Unbounded Geometry");
        tab.setClosable(false);
        tab.setTooltip(new Tooltip("The unbounded surface geometry of the parent element. Can be a patch of connected surfaces."));


        var vbox = new VBox();
        tab.setContent(vbox);

        if (getObject().getUnboundedGeometry() == null) {
            LOG.error("panel {} ({}) has no UnboundedGeometry",
                    getObject().getId(), getObject().getGUIDRef());

            var warning = new atlantafx.base.controls.Message(
                    "Error",
                    "No Unounded Geometry found in this Panel",
                    new FontIcon(MaterialDesignB.BOMB)
            );
            warning.getStyleClass().add(Styles.WARNING);

            vbox.getChildren().add(warning);
            getObject().setUnboundedGeometry(new UnboundedGeometry());
        }

        SurfaceT surfaceT = null;
        GridRefT gridRefT = null;
        SurfaceRefT surfaceRefT = null;

        if (getObject().getUnboundedGeometry().getSurfaces() != null) {
            for (JAXBElement<? extends SurfaceT> surface : getObject().getUnboundedGeometry().getSurfaces()) {
                if (surfaceT != null) {
                    LOG.error("found multiple surfaces in unbounded geometry of panel {} ({}), only one is supported",
                            getObject().getId(), getObject().getGUIDRef());
                    var warning = new atlantafx.base.controls.Message(
                            "Error",
                            "Found multiple Surfaces in the Unbounded Geometry",
                            new FontIcon(MaterialDesignB.BOMB)
                    );
                    warning.getStyleClass().add(Styles.WARNING);

                    vbox.getChildren().add(warning);
                    break;
                }
                surfaceT = surface.getValue();
            }
        }

        if (getObject().getUnboundedGeometry().getGridReves() != null) {
            for (GridRefT gridRef : getObject().getUnboundedGeometry().getGridReves()) {
                if (gridRefT != null) {
                    LOG.error("found multiple gridRefs in unbounded geometry of panel {} ({}), only one is supported",
                            getObject().getId(), getObject().getGUIDRef());
                    var warning = new atlantafx.base.controls.Message(
                            "Error",
                            "Found multiple GridRefs in the Unbounded Geometry",
                            new FontIcon(MaterialDesignB.BOMB)
                    );
                    warning.getStyleClass().add(Styles.WARNING);

                    vbox.getChildren().add(warning);
                    break;
                }
                gridRefT = gridRef;
            }
        }

        if (getObject().getUnboundedGeometry().getSurfaceReves() != null) {
            for (SurfaceRefT surfaceRefT1 : getObject().getUnboundedGeometry().getSurfaceReves()) {
                if (surfaceRefT != null) {
                    LOG.error("found multiple surface refs in unbounded geometry of panel {} ({}), only one is supported",
                            getObject().getId(), getObject().getGUIDRef());
                    var warning = new atlantafx.base.controls.Message(
                            "Error",
                            "Found multiple SurfaceRefs in the Unbounded Geometry",
                            new FontIcon(MaterialDesignB.BOMB)
                    );
                    warning.getStyleClass().add(Styles.WARNING);

                    vbox.getChildren().add(warning);
                    break;
                }
                surfaceRefT = surfaceRefT1;
            }
        }

        int count = surfaceT != null ? 1 : 0;
        count += gridRefT != null ? 1 : 0;
        count += surfaceRefT != null ? 1 : 0;

        if (count != 1) {
            LOG.error("found !=1 definiton for the unbounded geometry, expect exactly 1");
            LOG.error("    surfaceT {}", surfaceT != null ? surfaceT.getId() : "NULL");
            LOG.error("    gridRef {}", gridRefT != null ? gridRefT.getLocalRef() : "NULL");
            LOG.error("    surfaceRefT {}", surfaceRefT != null ? surfaceRefT.getLocalRef() : "NULL");

            var warning = new atlantafx.base.controls.Message(
                    "Error",
                    "Expect exactly on value for the unbounded geometry, found " + count,
                    new FontIcon(MaterialDesignB.BOMB)
            );
            warning.getStyleClass().add(Styles.WARNING);

            vbox.getChildren().add(warning);
        } else if (surfaceT != null) {
            var label = new Label("Local Surface Definition");
            label.getStyleClass().add(Styles.TITLE_4);
            vbox.getChildren().add(label);

        } else if (gridRefT != null || surfaceRefT != null) {

            Label label = null;
            String linkText = null;
            Object linkObject = null;

            if (gridRefT != null) {

                label = new Label("Referenced Grid");

                if (gridRefT.getLocalRef() instanceof RefPlaneT refPlaneT) {
                    linkText = "RefPlane " + refPlaneT.getId();
                    linkObject = refPlaneT;
                } else if (gridRefT.getLocalRef() instanceof String id) {
                    linkText = "Unresolved reference to RefPlane id=" + id;
                } else {
                    LOG.warn("found neither RefPlaneT nor String in gridRefT localRef" + gridRefT.getLocalRef());
                }
            } else {
                label = new Label("Referenced Surface");

                if (surfaceRefT.getLocalRef() instanceof SurfaceT surfaceT1) {
                    linkText = "Surface " + surfaceT1.getId();
                    linkObject = surfaceT1;
                } else if (surfaceRefT.getLocalRef() instanceof String id) {
                    linkText = "Unresolved reference to Surface id=" + id;
                } else {
                    LOG.warn("found neither SurfaceT nor String in surfaceRefT localRef" + surfaceRefT.getLocalRef());
                }
            }

            label.getStyleClass().add(Styles.TITLE_4);
            vbox.getChildren().add(label);

            if (linkObject == null) {
                label = new Label(linkText);
                label.getStyleClass().add(Styles.WARNING);
                vbox.getChildren().add(label);
            } else {

                var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
                var nextPage = linkObject instanceof RefPlaneT ?
                        new BreadcrumbRecord(linkText, RefPlanePage.class, null, (RefPlane) linkObject) :
                        new BreadcrumbRecord(linkText, SurfacePage.class, null, (SurfaceT) linkObject);
                robert.add(nextPage);

                Hyperlink link = new Hyperlink(linkText);
                link.setStyle("-fx-padding: 10px");
                link.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        var selectionEvent = new SelectionEvent(robert);

                        DefaultEventBus.getInstance().publish(selectionEvent);
                    }
                });
                vbox.getChildren().add(link);
            }
        }


        return tab;
    }

    private Tab createLimitsTab() {
        var tab = new Tab("Limits");
        tab.setClosable(false);

        var vbox = new VBox();
        tab.setContent(vbox);


        if (getObject().getLimitedBy() == null) {
            LOG.info("panel {} ({}) has no limits",
                    getObject().getId(), getObject().getGUIDRef());

            var warning = new atlantafx.base.controls.Message(
                    "Warning",
                    "No LimitedBy found in this Panel",
                    new FontIcon(MaterialDesignA.ALERT)
            );
            warning.getStyleClass().add(Styles.WARNING);

            vbox.getChildren().add(warning);
            getObject().setLimitedBy(new LimitedBy());
        }

        ObservableList<LimitedByRecord> limits = FXCollections.observableArrayList();

        var tableColumnIdx = new TableColumn<LimitedByRecord, String>("Index");
        tableColumnIdx.setCellValueFactory(c -> new SimpleStringProperty(
                Long.toString(c.getValue().index())));
        tableColumnIdx.setStyle("-fx-alignment: CENTER-RIGHT;");
        tableColumnIdx.setMinWidth(100);
        tableColumnIdx.setMaxWidth(100);
        tableColumnIdx.setResizable(false);


        var tableColumnType = new TableColumn<LimitedByRecord, String>("Type");
        tableColumnType.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().type().getName()));
        tableColumnType.setMinWidth(100);
        tableColumnType.setMaxWidth(100);
        tableColumnType.setResizable(false);

        var tableColumnId = new TableColumn<LimitedByRecord, Object>("ID");
        tableColumnId.setCellValueFactory(c -> new SimpleObjectProperty(c.getValue().localRef()));
        tableColumnId.setCellFactory(createHyperlinkCellfactory(selected -> {
            if (selected == null) {
                // no change
                return;
            }
            BreadcrumbRecord nextPage = null;


            if (selected instanceof String s) {
                LOG.warn("failed to resolve limit '{}' in panel {} ({})", s, getObject().getId(), getObject().getGUIDRef());
            } else if (selected instanceof IdBaseT idBaseT) {
                if (idBaseT instanceof RefPlaneT plane) {
                    nextPage = new BreadcrumbRecord(idBaseT.getId(), RefPlanePage.class, null, plane);
                } else if (idBaseT instanceof SurfaceT surface) {
                    nextPage = new BreadcrumbRecord(idBaseT.getId(), SurfacePage.class, null, surface);
                } else if (idBaseT instanceof SurfaceCollection collection) {
                    nextPage = new BreadcrumbRecord(idBaseT.getId(), SurfaceCollectionPage.class, null, collection);
                } else {
                    LOG.warn("unhandled IdBaseT type for breadcrumb, got {}", idBaseT.getClass().getSimpleName());
                }
            } else {
                LOG.warn("unhandled object for breadcrumb, got {}", selected.getClass().getSimpleName());
            }
            if (nextPage != null) {
                var robert = new ArrayList<BreadcrumbRecord>(getBreadcrumbs());
                robert.add(nextPage);
                var event = new SelectionEvent(robert);
                DefaultEventBus.getInstance().publish(event);
            }

        }));

        tableColumnId.setMinWidth(100);
        tableColumnId.setMaxWidth(100);

        var tableColumnGUID = new TableColumn<LimitedByRecord, String>("GUID");
        tableColumnGUID.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().GUIDRef()));
        tableColumnGUID.setMinWidth(100);
        tableColumnGUID.setMaxWidth(100);

        var tableColumnStart = new TableColumn<LimitedByRecord, Point3DT>("Start Point");
        tableColumnStart.setCellValueFactory(
                c -> new SimpleObjectProperty<Point3DT>(c.getValue().startPoint()));
        tableColumnStart.setCellFactory(d -> new PointTableCell<>());
        tableColumnStart.setMinWidth(200);
        tableColumnStart.setMaxWidth(500);

        var tableColumnEnd = new TableColumn<LimitedByRecord, Point3DT>("End Point");
        tableColumnEnd.setCellValueFactory(
                c -> new SimpleObjectProperty<Point3DT>(c.getValue().endPoint()));
        tableColumnEnd.setCellFactory(d -> new PointTableCell<>());
        tableColumnEnd.setMinWidth(200);
        tableColumnEnd.setMaxWidth(500);

        var table = new TableView<LimitedByRecord>(limits);
        vbox.getChildren().add(table);
        table.getColumns().setAll(tableColumnIdx, tableColumnType, tableColumnId, tableColumnGUID, tableColumnStart, tableColumnEnd);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        table.setMaxWidth(Double.MAX_VALUE);
        table.setMinHeight(150);
        table.setMaxHeight(1500);

        // now populate the table
        int index = 0;
        for (Object limit : getObject().getLimitedBy().getFreeEdgeCurve3DsAndBoundedReves()) {

            if (limit instanceof JAXBElement jaxbElement) {
                limit = jaxbElement.getValue();
            }
            var type = LimitedByType.getType(limit);

            LOG.info("limit #{}, type {}", index, type);

            // Some default values
            var startPoint = new Point3DT();
            startPoint.setUnit(UnitHelper.getMilliMeterUnit());

            var endPoint = new Point3DT();
            endPoint.setUnit(UnitHelper.getMilliMeterUnit());

            var offset = new QuantityT();
            offset.setNumericvalue(0.0);
            offset.setUnit(UnitHelper.getMilliMeterUnit());


            if (limit instanceof FreeEdgeCurve3D freeEdgeCurve3D) {
                final FreeEdgeCurve3D edgeCurve3D = (FreeEdgeCurve3D) limit;
                limits.add(new LimitedByRecord(index++, type, edgeCurve3D.getId(),
                        (edgeCurve3D).getGUIDRef(), startPoint, endPoint, offset, limit));

            } else if (limit instanceof BoundedRefT boundedRefT) {
                if (boundedRefT.getContourBounds() != null) {
                    if (boundedRefT.getContourBounds().getContourStart() != null) {
                        startPoint = boundedRefT.getContourBounds().getContourStart();
                    } else {
                        LOG.warn("limit #{} of panel {} ({}) of type {} has no ContourStart",
                                index, getObject().getId(), getObject().getGUIDRef(), type);
                    }

                    if (boundedRefT.getContourBounds().getContourEnd() != null) {
                        endPoint = boundedRefT.getContourBounds().getContourEnd();
                    } else {
                        LOG.warn("limit #{} of panel {} ({}) of type {} has no ContourEnd",
                                index, getObject().getId(), getObject().getGUIDRef(), type);
                    }

                } else {
                    LOG.warn("limit #{} of panel {} ({}) of type {} has no contour bounds",
                            index, getObject().getId(), getObject().getGUIDRef(), type);
                }

                if (limit instanceof CellBoundary cellBoundary) {

                    limits.add(new LimitedByRecord(index++, type, cellBoundary.getLocalRef(),
                            "", startPoint, endPoint, offset, limit));
                } else if (limit instanceof EdgeCurveRefT edgeCurveRefT) {
                    limits.add(new LimitedByRecord(index++, type, edgeCurveRefT.getLocalRef(),
                            edgeCurveRefT.getGUIDRef(), startPoint, endPoint, offset, limit));
                } else if (limit instanceof GridRefT gridRefT) {
                    limits.add(new LimitedByRecord(index++, type, gridRefT.getLocalRef(),
                            gridRefT.getGUIDRef(), startPoint, endPoint,
                            gridRefT.getOffset() != null ? gridRefT.getOffset() : offset,
                            limit));
                } else if (limit instanceof PanelRefT panelRefT) {
                    limits.add(new LimitedByRecord(index++, type, panelRefT.getLocalRef(),
                            panelRefT.getGUIDRef(), startPoint, endPoint, offset, limit));

                } else if (limit instanceof SeamRefT seamRefT) {
                    limits.add(new LimitedByRecord(index++, type, seamRefT.getLocalRef(),
                            seamRefT.getGUIDRef(), startPoint, endPoint, offset, limit));
                } else if (limit instanceof StiffenerRefT stiffenerRefT) {
                    limits.add(new LimitedByRecord(index++, type, stiffenerRefT.getLocalRef(),
                            stiffenerRefT.getGUIDRef(), startPoint, endPoint, offset, limit));
                } else if (limit instanceof SurfaceRefT surfaceRefT) {
                    limits.add(new LimitedByRecord(index++, type, surfaceRefT.getLocalRef(),
                            surfaceRefT.getGUIDRef(), startPoint, endPoint, offset, limit));
                }
            } else {
                LOG.warn("unhandled object for limit, got {}", type);
            }
        } // end limits loop


        return tab;
    }

    private Tab createBoundaryTab() {
        var tab = new Tab("Boundary Curve");
        tab.setClosable(false);

        var warning = new atlantafx.base.controls.Message(
                "Warning",
                "Not implemented yet",
                new FontIcon(MaterialDesignA.ALERT)
        );
        warning.getStyleClass().add(Styles.WARNING);

        tab.setContent(warning);
        return tab;
    }

}
