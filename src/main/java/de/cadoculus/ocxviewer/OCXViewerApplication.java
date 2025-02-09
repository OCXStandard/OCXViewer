package de.cadoculus.ocxviewer;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import de.cadoculus.ocxviewer.actions.AboutAction;
import de.cadoculus.ocxviewer.actions.ActionDispatcher;
import de.cadoculus.ocxviewer.actions.ExitAction;
import de.cadoculus.ocxviewer.actions.OpenAction;
import de.cadoculus.ocxviewer.event.DefaultEventBus;
import de.cadoculus.ocxviewer.event.HotkeyEvent;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * The viewer application
 */
public class OCXViewerApplication extends Application {

    private static final Logger LOG = LogManager.getLogger(OCXViewerApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        LOG.debug("Starting OCXViewerApplication");

        // Exit JAVA when the window is closed
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        // This loads the main-view.fxml file and thus starts the complete UI of the application
        // See MainController for the actual logic
        FXMLLoader fxmlLoader = new FXMLLoader(OCXViewerApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
        WorkingContext.getInstance().setMainScene(scene);
        stage.setTitle("OCXViewer");
        stage.setScene(scene);

        // listen for actions
        new ActionDispatcher();

        // and register some hotkeys
        scene.getAccelerators().put(OpenAction.KEYS, () -> DefaultEventBus.getInstance().publish( new HotkeyEvent(OpenAction.KEYS)));

        scene.getAccelerators().put(ExitAction.KEYS, () -> DefaultEventBus.getInstance().publish( new HotkeyEvent(ExitAction.KEYS)));
        scene.getAccelerators().put(AboutAction.KEYS, () -> DefaultEventBus.getInstance().publish( new HotkeyEvent(AboutAction.KEYS)));

        // set the theme
        if (! WorkingContext.getInstance().isDarkMode()) {
            Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
        } else {
            Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());
        }


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}