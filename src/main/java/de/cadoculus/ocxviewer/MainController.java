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
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Blend;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Stack;
import java.util.stream.Collectors;

public class MainController {

    private static final Logger LOG = LogManager.getLogger(MainController.class);
    /**
     * This map contains a lookup from the primary data views to an instance
     */
    private final HashMap<Class<? extends Page>, Page> pageClass2page = new HashMap<>();
    private final Stack<BreadcrumbRecord> pageStack = new Stack<>();
    /**
     * The logo page shown at startup
     */
    @FXML
    public LogoPage logoPage;
    /* The main border is the central layout element in the UI.
     * In the beginning it contains only the logo page, later the navigation tree on the left and
     * the stack pane containing the data views on the right.
     */
    @FXML
    private BorderPane mainBorderPane;
    /**
     * The stack pane containing the data views on the right side
     */
    private StackPane stackPane;
    private boolean viewInitialized = false;

    public MainController() {
        super();
    }

    @FXML
    public void initialize() throws IOException {

        LOG.warn("initialize");

        // register for navigation
        DefaultEventBus.getInstance().subscribe(OpenEvent.class, event -> initializeViews());

        // This is initialized here to start collecting log events when the user opens a file
        final LogPage logPage = new LogPage();
        pageClass2page.put(LogPage.class, logPage);

        LOG.info("pages {}", pageClass2page.keySet());


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

            stackPane.getChildren().add((BorderPane) pageClass2page.get(LogPage.class));

            DefaultEventBus.getInstance().subscribe(NavigationEvent.class, this::switchPages);
            DefaultEventBus.getInstance().subscribe(SelectionEvent.class, this::selectObjects);

            go(WorkingContext.getInstance().darkModeProperty().get());
            viewInitialized = true;
        }
        // this is called on every file open
        initializeDataViews();
    }

    /**
     * This method is called when a selection event is received.
     * This opens the path associated with the event, keeping existing pages if possible.
     *
     * @param event the selection event
     */
    private void selectObjects(SelectionEvent event) {
        LOG.debug("Navigation event: {}", event);

        if (event.getBreadcrumbs() == null || event.getBreadcrumbs().isEmpty()) {
            LOG.warn("No breadcrumbs in selection event");
            return;
        }
        if (event.getBreadcrumbs().size() < 1) {
            LOG.warn("Not enough breadcrumbs in selection event, expect at least 1");
            return;
        }

        // TODO: check existing path, e.g. panels/panel/stiffener pages and clean up if needed
        LOG.info("compare existing {} with target path {}", pageStack, event.getBreadcrumbs());

        Page lastPage = null;
        int lastMatchingIndex = -1;
        for (int i = 0; i < event.getBreadcrumbs().size(); i++) {
            var trgtBC = event.getBreadcrumbs().get(i);

            if (i < pageStack.size()) {
                var existBC = pageStack.get(i);
                LOG.info("#{}: compare stack {} vs. target {}", i, existBC, trgtBC);
                var found = false;

                if (trgtBC.page() != null && trgtBC.page().equals(existBC.page())) {
                    // path already exists and page matches
                    if (trgtBC.object() == null) {
                        // no object expected and page matches
                        found = true;
                    } else if (AbstractDataViewSubPage.class.isAssignableFrom(existBC.getClass()) &&
                            trgtBC.object().equals(((AbstractDataViewSubPage) existBC.page()).getObject())) {
                        // ok, object expected
                        found = true;
                    }
                } else if (trgtBC.pageClazz() == existBC.pageClazz()) {
                    // same page class, check object, but not instantiated yet
                    break;
                }

                if (found) {
                    lastMatchingIndex = i;
                    lastPage = existBC.page();
                } else {
                    LOG.info("#{}: failed to compare stack {} vs. target {}", i, existBC, trgtBC);
                    break;
                }
            } else {
                break;
            }
        }

        LOG.info("found common path up to index {}", lastMatchingIndex);
        while (pageStack.size() > lastMatchingIndex + 1) {
            final BreadcrumbRecord popped = pageStack.pop();
            LOG.info("pop existing breadcrumb {}", popped);
        }
        LOG.info("remaining page stack {}", pageStack);

        var parentPage = pageStack.isEmpty() ? null : pageStack.peek().page();


        // now create new pages if needed
        for (int i = lastMatchingIndex + 1; i < event.getBreadcrumbs().size(); i++) {
            var trgtBC = event.getBreadcrumbs().get(i);
            LOG.info("#{}: target breadcrumb {}", i, trgtBC);

            AbstractDataViewPage newPage = null;

            // Should not happen, but check anyway
            if (trgtBC.page() != null) {
                LOG.warn("got a target path at #{} with prefilled page {}", i, trgtBC);
                lastPage = trgtBC.page();
                continue;
            }

            if (AbstractDataViewSubPage.class.isAssignableFrom(trgtBC.pageClazz())) {
                // need to create a new page for the object
                Class<? extends Page> pageClass = trgtBC.pageClazz();

                Constructor constructor = null;
                for (Constructor<?> cstr : pageClass.getConstructors()) {
                    LOG.info("found constructor {} with params {}", cstr, cstr.getParameterTypes());
                    constructor = cstr;
                }
                // now instantiate the sub page
                try {
                    lastPage = (Page) constructor.newInstance(trgtBC.object(), parentPage);
                    LOG.info("created a new sub page {} for {}", lastPage, trgtBC.object());
                } catch (Exception exp) {
                    LOG.error("Error creating sub page for trgtBC {}", trgtBC, exp);
                    break;
                }
                continue;
            }
            if (AbstractDataViewPage.class.isAssignableFrom(trgtBC.pageClazz())) {
                // reuse existing page or create a new one
                var event2 = new NavigationEvent(trgtBC.pageClazz());
                this.switchPages(event2);
                lastPage = pageClass2page.get(trgtBC.pageClazz());
                continue;
            }

            LOG.error("expect a page class extending AbstractDataViewSubPage for target Breadcrump {}, got {}", trgtBC, trgtBC.pageClazz());
            break;
        }
        if (lastPage != null) {
            switchToPage((BorderPane) lastPage);
        } else {
            LOG.error("no last page created for target breadcrumbs {}", event.getBreadcrumbs());
        }
    }


    /**
     * This method is called when a navigation event is received.
     * This opens the main page associated with the event.
     * The current page(path) is discarded and replaced with the new page/path.
     *
     * @param event the navigation event
     */
    private void switchPages(NavigationEvent event) {

        LOG.debug("Navigation event: {}", event);
        if (event.getPage() == null) {
            // this is a selection event on a group node
            return;
        }

        AbstractDataViewPage existing = (AbstractDataViewPage) pageClass2page.get(event.getPage());
        AbstractDataViewPage newPage = null;
        if (existing == null) {
            // Lazy loading of pages
            LOG.info("Creating page {}", event.getPage());

            try {
                newPage = (AbstractDataViewPage) event.getPage().getConstructor().newInstance();
                pageClass2page.put((Class<? extends Page>) newPage.getClass(), (Page) newPage);
            } catch (Exception exp) {
                LOG.error("Error creating page", exp);
                LOG.warn("no page registered for {}", event.getPage());
                LOG.warn("    pages {}", pageClass2page.keySet());

                switchPages(new NavigationEvent(LogPage.class));
                return;

            }
        } else {
            LOG.debug("use existing page {}", existing);
            newPage = existing;
        }

        BorderPane paneToAdd = existing != null ? existing : newPage;

        // clean up a path off sub-pages
        while (!pageStack.isEmpty()) {
            final BreadcrumbRecord popped = pageStack.pop();
            LOG.info("pop existing trgtBC {}", popped);
        }
        pageStack.push(newPage.getBreadcrumbs().getFirst());

        switchToPage( (BorderPane) paneToAdd);
    }


    /**
     * This method switches the visible page in the stack pane with an animation.
     * It does not handle the path in the page stack.
     *
     * @param paneToAdd the page to add
     */
    private void switchToPage(BorderPane paneToAdd) {

        ((Page) paneToAdd).beforeShow();

        var paneToRemove = stackPane.getChildren().isEmpty() ? null : stackPane.getChildren().get(0);
        LOG.debug("pane to add {}, remove {}", paneToAdd, paneToRemove);

        if (paneToRemove != null && paneToRemove.equals(paneToAdd)) {
            LOG.debug("same page, no switch needed");
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

        var pagesToRemove = pageClass2page.keySet().stream().filter(clazz -> LogPage.class != clazz).collect(Collectors.toSet());
        pagesToRemove.forEach(c -> {
            if (c != LogPage.class) {
                final Page page = pageClass2page.get(c);
                page.beforeHide();
                page.beforeClose();
                pageClass2page.remove(c);
            }
        });

        // Now the pages on the right
        final HeaderPage headerPage = new HeaderPage();
        pageClass2page.put(HeaderPage.class, headerPage);
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