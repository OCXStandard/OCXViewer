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
import de.cadoculus.ocxviewer.actions.ActionDispatcher;
import de.cadoculus.ocxviewer.actions.ExitAction;
import de.cadoculus.ocxviewer.actions.OpenAction;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.HotkeyEvent;
import de.cadoculus.ocxviewer.event.NavigationEvent;
import de.cadoculus.ocxviewer.models.WorkingContext;
import de.cadoculus.ocxviewer.views.ClassficationSocietyPage;
import de.cadoculus.ocxviewer.views.Page;
import de.cadoculus.ocxviewer.views.PageTree;
import de.cadoculus.ocxviewer.views.PrincipalParticularsPage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;

public class MainController {

    private static final Logger LOG = LogManager.getLogger(MainController.class);

    private TreeView navigationTree;
    @FXML
    private ScrollPane navigationTreeScrollPane;
    @FXML
    private StackPane stackPane;
    @FXML
    private BorderPane borderPane;

    private HashMap<Class, Page> class2page = new HashMap<>();

    public MainController() {
        super();

    }
    @FXML
    public void initialize() throws IOException {

        // The tree on the left side of the application
        navigationTree = new PageTree();
        navigationTreeScrollPane.setContent(navigationTree);

        navigationTreeScrollPane.setFitToWidth(true);
        navigationTreeScrollPane.setFitToHeight(true);
        navigationTreeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        navigationTreeScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // register for navigation
        DefaultEventBus.getInstance().subscribe(NavigationEvent.class, event -> {
            this.switchPages( event);
        });



        // and create pages
        // TODO: do it delayed on first file loading?
        final ClassficationSocietyPage classficationDataPage = new ClassficationSocietyPage();
        class2page.put(ClassficationSocietyPage.class, classficationDataPage);

        final PrincipalParticularsPage principalParticularsPage = new PrincipalParticularsPage();
        class2page.put(PrincipalParticularsPage.class, principalParticularsPage);

    }

    /**
     * This method is called when a navigation event is received.
     * @param event
     */
    private void switchPages(NavigationEvent event) {

        LOG.info("Navigation event: {}", event);

        Page page = class2page.get(event.getPage());
        if ( page ==null) {
            LOG.warn("no page registered for {}", event.getPage());
        } else {
            borderPane.setCenter( (Node) page);
        }

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

        if (WorkingContext.getInstance().isDarkMode()) {
            Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
        } else {
            Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());
        }
        WorkingContext.getInstance().setDarkMode(!WorkingContext.getInstance().isDarkMode());
    }

}