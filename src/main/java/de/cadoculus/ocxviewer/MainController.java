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
package de.cadoculus.ocxviewer;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import de.cadoculus.ocxviewer.actions.AboutAction;
import de.cadoculus.ocxviewer.actions.ExitAction;
import de.cadoculus.ocxviewer.actions.OpenAction;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.HotkeyEvent;
import de.cadoculus.ocxviewer.event.NavigationEvent;
import de.cadoculus.ocxviewer.event.OpenEvent;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.views.*;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.effect.Blend;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;

public class MainController {

    private static final Logger LOG = LogManager.getLogger(MainController.class);

    private TreeView navigationTree;
    private ScrollPane navigationTreeScrollPane;

    private StackPane stackPane;
    @FXML
    private BorderPane mainBorderPane;

    private boolean dataViewInitialized = false;

    private HashMap<Class, Page> class2page = new HashMap<>();

    public MainController() {
        super();

    }

    @FXML
    public void initialize() throws IOException {

        // register for navigation
        DefaultEventBus.getInstance().subscribe(OpenEvent.class, event -> {
            initializeViews();
        });

        // and create default pages

        final LogoPage logoPage = new LogoPage();
        mainBorderPane.setCenter((Node) logoPage);

        // This is initialized here to start collecting log events when the user opens a file
        final LogPage logPage = new LogPage();
        class2page.put(LogPage.class, logPage);

        LOG.info("pages {}", class2page.keySet());


    }

    /**
     * This method is called when the data view should be initialized.
     */
    private void initializeViews() {

        // run this only once
        if (dataViewInitialized) {
            return;
        }

        dataViewInitialized = true;

        // The tree on the left side of the application
        navigationTreeScrollPane = new ScrollPane();
        BorderPane.setMargin(navigationTreeScrollPane, new Insets(15, 15, 15, 15));


        // TODO: move to central style sheet
        navigationTreeScrollPane.getStyleClass().add("content-pane");

        navigationTree = new PageTree();
        navigationTreeScrollPane.setContent(navigationTree);

        navigationTreeScrollPane.setFitToWidth(true);
        navigationTreeScrollPane.setFitToHeight(true);
        navigationTreeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        navigationTreeScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        mainBorderPane.setLeft(navigationTreeScrollPane);

        stackPane = new StackPane();
        stackPane.setId("mainStackPane");
        mainBorderPane.setCenter(stackPane);

        stackPane.getChildren().add( (BorderPane) class2page.get(LogPage.class));

        DefaultEventBus.getInstance().subscribe(NavigationEvent.class, event -> {
            this.switchPages(event);
        });

        go(WorkingContext.getInstance().isDarkMode());

        initializeDataViews();
    }



    /**
     * This method is called when a navigation event is received.
     *
     * @param event
     */
    private void switchPages(NavigationEvent event) {

        LOG.info("Navigation event: {}", event);

        BorderPane existing = (BorderPane) class2page.get(event.getPage());
        BorderPane newPage = null;
        if (existing == null) {
            // Lazy loading of pages


            try {
                newPage =(BorderPane) event.getPage().getConstructor().newInstance();
            } catch (Exception exp) {
                LOG.error("Error creating page", exp);
            }

        }

        BorderPane paneToAdd = existing != null ? existing : newPage;

        if (paneToAdd == null) {
            LOG.warn("no page registered for {}", event.getPage());
            LOG.warn("    pages {}", class2page.keySet());



        } else {

            var paneToRemove = stackPane.getChildren().isEmpty() ? null : stackPane.getChildren().get(0);
            LOG.debug("pane to add {}, remove {}", paneToAdd,  paneToRemove);

            if ( paneToRemove != null && paneToRemove.equals(paneToAdd)) {
                return;
            }

            Rectangle clipRect = null;
            if ( paneToRemove != null) {
                var bounds = paneToRemove.getBoundsInParent();
                LOG.error("bounds {}", bounds);
                clipRect = new Rectangle();
                clipRect.setX( bounds.getMinX());
                clipRect.setY( bounds.getMinY());
                clipRect.setWidth(bounds.getWidth());
                clipRect.setHeight(bounds.getHeight());

                LOG.info("clip rect {}", clipRect);

                stackPane.setClip(clipRect);
            }

            paneToAdd.translateXProperty().set(-stackPane.getWidth());
            var blend = new Blend();
            var blur = new MotionBlur();
            blur.setRadius(20);
            blur.setAngle(10);
            //blend.setBottomInput(blur);
            blend.setTopInput(new GaussianBlur(5));
            blend.setBottomInput(blur);
            paneToAdd.setEffect(blend);
            stackPane.getChildren().addAll( paneToAdd);


            var movePane = new KeyValue(paneToAdd.translateXProperty(), 0, Interpolator.EASE_IN);
            //var moveClip = new KeyValue(clipRect.translateXProperty(), 0, Interpolator.EASE_IN);
            //var reduceClip = new KeyValue(clipRect.widthProperty(), 0, Interpolator.EASE_IN);
            var keyFrame = new KeyFrame(Duration.millis(450), movePane);
            var timeline =  new Timeline(keyFrame);
            if ( paneToRemove != null) {
                timeline.setOnFinished(evt -> {
                    stackPane.getChildren().remove(paneToRemove);
                    LOG.info("after {},{} {}x{}", paneToAdd.getLayoutX(), paneToAdd.getLayoutY(), paneToAdd.getWidth(), paneToAdd.getHeight());
                    stackPane.setClip(null);
                    paneToAdd.setEffect(null);
                    LOG.info("after clip {},{} {}x{}", paneToAdd.getLayoutX(), paneToAdd.getLayoutY(), paneToAdd.getWidth(), paneToAdd.getHeight());
                });
            }

            timeline.play();

        }

    }

    private void initializeDataViews() {

        // get rid of all pages with binding to previous loaded models

        class2page.keySet().forEach( c -> {
            if (c != LogPage.class) {

            class2page.remove(c);}
        });

        // Now the pages on the right
        final HeaderPage headerPage = new HeaderPage();
        class2page.put(HeaderPage.class, headerPage);
        this.switchPages(new NavigationEvent(HeaderPage.class));

        final ClassficationSocietyPage classficationDataPage = new ClassficationSocietyPage();
        class2page.put(ClassficationSocietyPage.class, classficationDataPage);

        final PrincipalParticularsPage principalParticularsPage = new PrincipalParticularsPage();
        class2page.put(PrincipalParticularsPage.class, principalParticularsPage);


    }


    // The actions from the menu bar, all directed to the event bus
    public void about(ActionEvent actionEvent) {
        var hke = new HotkeyEvent(AboutAction.KEYS);
        DefaultEventBus.getInstance().publish(hke);
    }

    public void exit(ActionEvent actionEvent) {
        var hke = new HotkeyEvent(ExitAction.KEYS);
        DefaultEventBus.getInstance().publish(hke);
    }

    public void open(ActionEvent actionEvent) {
        var hke = new HotkeyEvent(OpenAction.KEYS);
        DefaultEventBus.getInstance().publish(hke);
    }

    public void swithchUIMode(ActionEvent actionEvent) {

        boolean dark = !WorkingContext.getInstance().isDarkMode();
        go(dark);
    }

    private void go(boolean dark) {

        if (dark) {
            Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());

            WorkingContext.getInstance().getMainScene().getStylesheets().clear();
            var css = this.getClass().getResource("dark.css").toExternalForm();
            WorkingContext.getInstance().getMainScene().getStylesheets().add( css);
            LOG.debug("csss {}", css);

        } else {
            Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());


            WorkingContext.getInstance().getMainScene().getStylesheets().clear();
            var css = this.getClass().getResource("light.css").toExternalForm();
            WorkingContext.getInstance().getMainScene().getStylesheets().add( css);
            LOG.debug("csss {}", css);


        }

        WorkingContext.getInstance().setDarkMode(dark);
    }

}