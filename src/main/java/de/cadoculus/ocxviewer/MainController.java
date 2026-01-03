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
import de.cadoculus.ocxviewer.actions.*;
import de.cadoculus.ocxviewer.event.*;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Blend;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MainController {

    private static final Logger LOG = LogManager.getLogger(MainController.class);

    private StackPane stackPane;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    public LogoPage logoPage;

    private boolean viewInitialized = false;

    private final HashMap<Class, Page> class2page = new HashMap<>();

    public MainController() {
        super();
    }

    @FXML
    public void initialize() throws IOException {

        LOG.warn("initialize");

        try {
            final URL resource = MainController.class.getResource("media/emoji.ttf");
            if (resource == null) {
                LOG.error("Font not found");
            } else {
                var fontStream = resource.openStream();
                Font.loadFont(fontStream, 24);
            }
        } catch (IOException exp) {
            LOG.error("Error loading font", exp);
        }

        // register for navigation
        DefaultEventBus.getInstance().subscribe(OpenEvent.class, event -> initializeViews());


        // This is initialized here to start collecting log events when the user opens a file
        final LogPage logPage = new LogPage();
        class2page.put(LogPage.class, logPage);

        LOG.info("pages {}", class2page.keySet());


//        DefaultEventBus.getInstance().subscribe(ThemeEvent.class, e -> {
//            var eventType = e.getEventType();
//
//            if (eventType == ThemeEvent.EventType.THEME_CHANGE ) {
//                updateColorInfo(Duration.seconds(1));
//            }
//        });


    }

    /**
     * This method is called when the data view should be initialized.
     */
    private void initializeViews() {

        if (!viewInitialized) {
            // run this only once
            // The tree on the left side of the application
            ScrollPane navigationTreeScrollPane = new ScrollPane();
            BorderPane.setMargin(navigationTreeScrollPane, new Insets(15, 15, 15, 15));


            // TODO: move to central style sheet
            navigationTreeScrollPane.getStyleClass().add("content-pane");

            PageTree navigationTree = new PageTree();
            navigationTreeScrollPane.setContent(navigationTree);

            navigationTreeScrollPane.setFitToWidth(true);
            navigationTreeScrollPane.setFitToHeight(true);
            navigationTreeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            navigationTreeScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

            mainBorderPane.setLeft(navigationTreeScrollPane);

            stackPane = new StackPane();
            stackPane.setId("mainStackPane");
            mainBorderPane.setCenter(stackPane);

            stackPane.getChildren().add((BorderPane) class2page.get(LogPage.class));

            DefaultEventBus.getInstance().subscribe(NavigationEvent.class, this::switchPages);

            go(WorkingContext.getInstance().darkModeProperty().get());
            viewInitialized = true;
        }
        // this is called on every file open
        initializeDataViews();
    }


    /**
     * This method is called when a navigation event is received.
     *
     * @param event the navigation event
     */
    private void switchPages(NavigationEvent event) {

        LOG.debug("Navigation event: {}", event);
        if ( event.getPage()==null) {
            // this is a selection event on a group node
            return;
        }

        BorderPane existing = (BorderPane) class2page.get(event.getPage());
        BorderPane newPage = null;
        if (existing == null) {
            // Lazy loading of pages
            LOG.info("Creating page {}", event.getPage());

            try {
                newPage = (BorderPane) event.getPage().getConstructor().newInstance();
                class2page.put(newPage.getClass(), (Page) newPage);
            } catch (Exception exp) {
                LOG.error("Error creating page", exp);
                LOG.warn("no page registered for {}", event.getPage());
                LOG.warn("    pages {}", class2page.keySet());

                switchPages(new NavigationEvent(LogPage.class));
                return;

            }
        } else {
            LOG.debug("use existing page {}", existing);
        }

        BorderPane paneToAdd = existing != null ? existing : newPage;

        ((Page) paneToAdd).beforeShow();

        var paneToRemove = stackPane.getChildren().isEmpty() ? null : stackPane.getChildren().get(0);

        LOG.debug("pane to add {}, remove {}", paneToAdd, paneToRemove);

        if (paneToRemove != null && paneToRemove.equals(paneToAdd)) {
            return;
        }

        Rectangle clipRect = null;
        if (paneToRemove != null) {

            ((Page) paneToRemove).beforeHide();

            var bounds = paneToRemove.getBoundsInParent();
            //LOG.error("bounds {}", bounds);
            clipRect = new Rectangle();
            clipRect.setX(bounds.getMinX());
            clipRect.setY(bounds.getMinY());
            clipRect.setWidth(bounds.getWidth());
            clipRect.setHeight(bounds.getHeight());

            //LOG.info("clip rect {}", clipRect);

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
        stackPane.getChildren().addAll(paneToAdd);


        var movePane = new KeyValue(paneToAdd.translateXProperty(), 0, Interpolator.EASE_IN);
        //var moveClip = new KeyValue(clipRect.translateXProperty(), 0, Interpolator.EASE_IN);
        //var reduceClip = new KeyValue(clipRect.widthProperty(), 0, Interpolator.EASE_IN);
        var keyFrame = new KeyFrame(Duration.millis(450), movePane);
        var timeline = new Timeline(keyFrame);
        if (paneToRemove != null) {
            timeline.setOnFinished(evt -> {
                stackPane.getChildren().remove(paneToRemove);
                ((Page) paneToRemove).afterHide();
                ((Page) paneToAdd).afterShow();

                //LOG.info("after {},{} {}x{}", paneToAdd.getLayoutX(), paneToAdd.getLayoutY(), paneToAdd.getWidth(), paneToAdd.getHeight());
                stackPane.setClip(null);
                paneToAdd.setEffect(null);
                //LOG.info("after clip {},{} {}x{}", paneToAdd.getLayoutX(), paneToAdd.getLayoutY(), paneToAdd.getWidth(), paneToAdd.getHeight());
            });
        }

        timeline.play();


    }

    private void initializeDataViews() {

        // get rid of all pages with binding to previous loaded models

        // raise the log page
        switchPages(new NavigationEvent(LogPage.class));

        var pagesToRemove = class2page.keySet().stream().filter( clazz-> LogPage.class != clazz).collect(Collectors.toSet());
        pagesToRemove.forEach(c -> {
            if (c != LogPage.class) {
                final Page page = class2page.get(c);
                page.beforeHide();
                page.beforeClose();
                class2page.remove(c);
            }
        });

        // Now the pages on the right
        final HeaderPage headerPage = new HeaderPage();
        class2page.put(HeaderPage.class, headerPage);
        this.switchPages(new NavigationEvent(HeaderPage.class));


    }


    // The actions from the menu bar, all directed to the event bus
    public void help(ActionEvent actionEvent) {
        var hke = new HotkeyEvent(HelpAction.KEYS);
        DefaultEventBus.getInstance().publish(hke);
    }

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

    public void schemaCheck(ActionEvent actionEvent) {

        var hke = new HotkeyEvent(SchemaCheckAction.KEYS);
        DefaultEventBus.getInstance().publish(hke);
    }

    public void schematronCheck(ActionEvent actionEvent) {
        var hke = new HotkeyEvent(SchematronAction.KEYS);
        DefaultEventBus.getInstance().publish(hke);
    }

    public void switchUIMode(ActionEvent actionEvent) {

        boolean dark = !WorkingContext.getInstance().darkModeProperty().get();
        go(dark);
    }

    private void go(boolean dark) {

        String css = "";
        if (dark) {
            Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());
            css = this.getClass().getResource("dark.css").toExternalForm();
        } else {
            Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
            css = this.getClass().getResource("light.css").toExternalForm();
        }

        // Todo: do we need this?
        WorkingContext.getInstance().getMainScene().getStylesheets().clear();
        WorkingContext.getInstance().getMainScene().getStylesheets().add(css);
        WorkingContext.getInstance().darkModeProperty().set(dark);

        var event = new ThemeEvent(ThemeEvent.EventType.THEME_CHANGE);
        DefaultEventBus.getInstance().publish(event);
    }




//    // TODO: fail to load arbitrary color from css variables, investigate later
//    private void updateColorInfo(Duration delay) {
//        var t = new Timeline(new KeyFrame(delay));
//        t.setOnFinished(e -> {
//            var colorTest = new Label("nothing to see here");
//            colorTest.setStyle("-fx-text-fill:-color-accent-8;");
//            mainBorderPane.setLeft(colorTest);
//            //LOG.info("-color-accent-8 {}" , colorTest.getTextFill());
//
//            mainBorderPane.setLeft(null);
//            colorTest = new Label("nothing to see here");
//            colorTest.setStyle("-fx-text-fill:-color-base-3;");
//            //LOG.info("-color-accent-8 {}" , colorTest.getTextFill());
//
//           mainBorderPane.setLeft(null);
//        });
//        t.play();
//    }


}