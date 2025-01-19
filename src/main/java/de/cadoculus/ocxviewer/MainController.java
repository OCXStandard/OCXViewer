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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
    private BorderPane borderPane;

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

        //borderPane.setStyle( "-fx-background-color: -color-base-0;");

        // and create default pages

        final LogoPage logoPage = new LogoPage();
        borderPane.setCenter((Node) logoPage);

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
        navigationTreeScrollPane.setStyle("""         
                
                        -fx-padding: 15px;
                -fx-background-color: -color-bg-default;
                                -fx-background-radius: 15px;
                
                -fx-border-radius: 15px;
                -fx-border-width: 1px;
                -fx-border-color: -color-accent-0;""");

        navigationTree = new PageTree();
        navigationTreeScrollPane.setContent(navigationTree);

        navigationTreeScrollPane.setFitToWidth(true);
        navigationTreeScrollPane.setFitToHeight(true);
        navigationTreeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        navigationTreeScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        borderPane.setLeft(navigationTreeScrollPane);

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

        Page page = class2page.get(event.getPage());
        if (page == null) {
            LOG.warn("no page registered for {}", event.getPage());
            LOG.warn("    pages {}", class2page.keySet());
        } else {
            borderPane.setCenter((Node) page);
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
            borderPane.setStyle("""
                    -fx-background-color: linear-gradient(from 0% 25% to 100% 50%, -color-base-7, -color-base-9);                   
                    """);


        } else {
            Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
            borderPane.setStyle("""
                     -fx-background-color: linear-gradient(from 0% 25% to 100% 50%, #fefefe, -color-base-2);
                    """);


        }

        WorkingContext.getInstance().setDarkMode(dark);
    }

}