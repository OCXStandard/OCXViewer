/*
 * Copyright 2026 Carsten Zerbst
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

import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.ThemeEvent;
import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.threed.Plane3D;
import de.cadoculus.ocxviewer.utils.CSSUtil;
import de.cadoculus.ocxviewer.utils.UnitHelper;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.RefPlane;
import javafx.scene.paint.Color;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.List;

/**
 * This class displays the coordinated system contained in the OCX file
 *
 * @author Carsten Zerbst
 */
public class CoordinateSystem3DViewPage extends AbstractDataViewSubPage<org.ocx_schema.v310.CoordinateSystem> implements Page {
    public static final String NAME = "Coordinate System";
    private static final Logger LOG = LogManager.getLogger(CoordinateSystem3DViewPage.class);
    private final ThreeDView threeDView;
    private Color frame0Colour = Color.GREY;
    private Color evenFrameColour = Color.DARKGRAY;
    private Color oddFrameColour = Color.LIGHTGRAY;
    private Color centerLPColour = Color.GREY;
    private Color evenLPPSColour = Color.RED;
    private Color oddLPPSColour = Color.ORANGERED;
    private Color evenLPSBColour = Color.GREEN;
    private Color oddLPPSBColour = Color.LIGHTGREEN;
    private Color evenLVRTColour = Color.DARKBLUE;
    private Color oddVRTColour = Color.LIGHTBLUE;

    private double minX=-10;
    private double maxX=150;
    private double breadth=40;
    private double height=30;

    public CoordinateSystem3DViewPage(org.ocx_schema.v310.CoordinateSystem coosys, Page parent) {
        super(coosys, parent, "3D View of Coordinate System «" + coosys.getId() + "»");

        setId("CoordinateSystem3DViewPage");
        final var bcs = getBreadcrumbs();
        createTitle(bcs, getName(), "3D view of the coordinate system.  Camera controls:" +
                "Zoom: <Ctrl><+> and <Ctrl><-> zoom in and out. Also available using <Ctrl><Scrollwheel>\n" +
                "Pan: <Left>, <Right>, <Up>, <Down> pan. Also available using pressed middle mouse button\n"+
                "Rotate: using pressed left mouse button. Double click with the middle mouse button sets the rotation center.\n" +
                "Use <R>, <P>, <Y> to roll, pitch, or yaw the camera. Adding <CTRL> gives fine control, <SHIFT> inverts the direction"
        );

        if (getTop() instanceof VBox titleBox) {
            titleBox.setPadding(new Insets(10));
            titleBox.setSpacing(5);
        }

        coosys.getXRefPlanes().getRefPlanes().stream().filter(rp-> rp.isDisplayGrid()).forEach( rp -> {

            minX = Math.min( UnitHelper.toDefaultUnit(rp.getReferenceLocation())/1000.0, minX);
            maxX = Math.max( UnitHelper.toDefaultUnit(rp.getReferenceLocation())/1000.0, maxX);
        });

        minX -= 0.1* maxX;
        maxX += 0.1* maxX;

        if ( coosys.getYRefPlanes() != null && coosys.getYRefPlanes().getRefPlanes() != null) {
            coosys.getYRefPlanes().getRefPlanes().stream().filter(rp -> rp.isDisplayGrid()).forEach(rp -> {
                breadth = Math.max(UnitHelper.toDefaultUnit(rp.getReferenceLocation()) / 500.0, breadth);
            });
            breadth*=1.1;
        } else {
            breadth = maxX*0.2;
        }

        if ( coosys.getZRefPlanes()!=null && coosys.getZRefPlanes().getRefPlanes() != null) {
            coosys.getZRefPlanes().getRefPlanes().stream().filter(rp -> rp.isDisplayGrid()).forEach(rp -> {
                height = Math.max(UnitHelper.toDefaultUnit(rp.getReferenceLocation()) / 10000, height);
            });
        } else {
            height = maxX*0.2;
        }

        updatedStyle();

        threeDView = new ThreeDView();
        threeDView.setId(getId() + "_3DView");
        this.setCenter(threeDView);

        LOG.info("create framegrid {}-{}, b {}, h {}", minX, maxX,breadth,height);
        threeDView.drawCoordinateSystem(minX, maxX, breadth, height);

        // follow changes in style
        DefaultEventBus.getInstance().subscribe( ThemeEvent.class, themeEvent -> {
            updatedStyle();
            drawFrames();
        });

    }

    /**
     * Updates the parameters used in the canvas from CSS.
     */
    private void updatedStyle() {
        try {
            CSSRecord cssRecord = CSSUtil.lookup("refPlaneFrames");
            frame0Colour = cssRecord.fill() != null ? cssRecord.fill() : frame0Colour;
            evenFrameColour = cssRecord.colour1() != null ? cssRecord.colour1() : evenFrameColour;
            oddFrameColour = cssRecord.colour2() != null ? cssRecord.colour2() : oddFrameColour;

            cssRecord = CSSUtil.lookup("refPlaneLongitudinals");
            centerLPColour = cssRecord.fill() != null ? cssRecord.fill() : centerLPColour;
            evenLPPSColour = cssRecord.colour1() != null ? cssRecord.colour1() : evenLPPSColour;
            oddLPPSColour = cssRecord.colour2() != null ? cssRecord.colour2() : oddLPPSColour;
            evenLPSBColour = cssRecord.colour3() != null ? cssRecord.colour3() : evenLPSBColour;
            oddLPPSBColour = cssRecord.colour4() != null ? cssRecord.colour4() : oddLPPSBColour;

            cssRecord = CSSUtil.lookup("refPlaneVerticals");
            evenLVRTColour = cssRecord.colour1() != null ? cssRecord.colour1() : evenLVRTColour;
            oddVRTColour = cssRecord.colour2() != null ? cssRecord.colour2() : oddVRTColour;
        } catch (Exception exp) {
            LOG.warn("failed to update style from CSS, use default values", exp);
        }
    }



    private void drawFrames() {

        var coosys = getObject();

        threeDView.clear();
        threeDView.drawCoordinateSystem(minX, maxX, breadth, height);

        var refPlanesGroup = new Group();
        refPlanesGroup.setId("refPlanes");


        var frameGroup = new Group();
        frameGroup.setId("frames");
        refPlanesGroup.getChildren().add(frameGroup);

        var frWidth=10;
        var frHeight=10;

        final List<RefPlane> frames = coosys.getXRefPlanes().getRefPlanes();
        for( int i =0; i < frames.size();i++) {
            var refPlane  = frames.get(i);
            if ( ! refPlane.isDisplayGrid()) {
                continue;
            }
            var x = (float) UnitHelper.toDefaultUnit(refPlane.getReferenceLocation());
            x /=1000.0f;

            var colour = Math.abs(x) < 0.01 ? frame0Colour : (i%2==0? evenFrameColour : oddFrameColour);
            var plane = new Plane3D( refPlane.getName() + " (" + refPlane.getId() + ")", new Point3d(x, 0, frHeight/2.0), new Vector3d(1, 0, 0),
                    frWidth, frHeight, colour, Color.RED);
            frameGroup.getChildren().add(plane);

        }

        if ( coosys.getZRefPlanes() != null && coosys.getZRefPlanes().getRefPlanes() != null) {
            LOG.info("found {} vertical reference planes", coosys.getZRefPlanes().getRefPlanes().size());

            var verticalGroup = new Group();
            verticalGroup.setId("verticalGroup");
            refPlanesGroup.getChildren().add(verticalGroup);

            final List<RefPlane> verticals = coosys.getZRefPlanes().getRefPlanes();
            for (int i = 0; i < verticals.size(); i++) {
                var refPlane = verticals.get(i);
                if (!refPlane.isDisplayGrid()) {
                    continue;
                }
                var z = (float) UnitHelper.toDefaultUnit(refPlane.getReferenceLocation());
                z /= 1000.0f;

                var colour = (i % 2 == 0 ? evenLVRTColour : oddVRTColour);
                var plane = new Plane3D(refPlane.getName() + " (" + refPlane.getName() + ")", new Point3d(0.25 * maxX, 0, z), new Vector3d(0, 0, 1),
                        frWidth, frHeight, colour, Color.RED);
                frameGroup.getChildren().add(plane);
            }
        }

        if ( coosys.getYRefPlanes() !=null && coosys.getYRefPlanes().getRefPlanes() != null) {
            LOG.info("found {} longitudinal reference planes", coosys.getYRefPlanes().getRefPlanes().size());
            var longitudinalGroup = new Group();
            longitudinalGroup.setId("longitudinalGroup");
            refPlanesGroup.getChildren().add(longitudinalGroup);

            final List<RefPlane> longitudinals = coosys.getYRefPlanes().getRefPlanes();
            for (int i = 0; i < longitudinals.size(); i++) {
                var refPlane = longitudinals.get(i);
                if (!refPlane.isDisplayGrid()) {
                    continue;
                }
                var y = (float) UnitHelper.toDefaultUnit(refPlane.getReferenceLocation());
                y /= 1000.0f;

                var colour = Color.YELLOW;
                if (Math.abs(y) < 0.01) {
                    colour = centerLPColour;
                } else if (y > 0) {
                    colour = (i % 2 == 0 ? evenLPPSColour : oddLPPSColour);
                } else {
                    colour = (i % 2 == 0 ? evenLPSBColour : oddLPPSBColour);
                }
                var plane = new Plane3D(refPlane.getName() + " (" + refPlane.getName() + ")", new Point3d(0, y, height / 2.0 + 2), new Vector3d(0, 1, 0),
                        frWidth, frHeight, colour, Color.RED);
                longitudinalGroup.getChildren().add(plane);

            }
        }

        threeDView.addGroupToWorld(refPlanesGroup);
    }



    @Override
    public void afterShow() {
        drawFrames();
    }


}
