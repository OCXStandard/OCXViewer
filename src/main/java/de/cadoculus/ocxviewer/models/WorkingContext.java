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
package de.cadoculus.ocxviewer.models;

import de.cadoculus.ocxviewer.MainController;
import de.cadoculus.ocxviewer.OCXViewerApplication;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import org.ocx_schema.v310.OcxXMLT;
import org.ocx_schema.v310.Vessel;

import java.io.File;
import java.util.prefs.Preferences;

/**
 * Singleton class to store the working context of the application.
 *
 * @author Carsten Zerbst
 */
public class WorkingContext {

    /** Default rules file preselected in the Schematron check until the user picks another one. */
    private static final String DEFAULT_SCHEMATRON_FILE = "data/schematron/ocx-example-rules.sch";

    private static WorkingContext INSTANCE;
    private File ocxFile;
    private File schematronFile;
    private final Preferences preferences;
    private OcxXMLT ocx;
    private Vessel vessel;
    private Scene mainScene;
    private String targetNamespace;
    private BooleanProperty darkMode = new SimpleBooleanProperty(false);
    private MainController mainController;


    /**
     * Get the singleton instance of the working context.
     *
     * @return the singleton instance of the working context.
     */
    public synchronized static WorkingContext getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorkingContext();
        }
        return INSTANCE;
    }

    private WorkingContext() {
        preferences = Preferences.userRoot().node(OCXViewerApplication.class.getName());
    }

    /**
     * Get the OCX file that is currently open.
     *
     * @return the OCX file that is currently open.
     */
    public File getOCXFile() {
        return ocxFile;
    }

    /**
     * Set the OCX file that is currently open. As a side effect, the last open directory is stored in the preferences.
     *
     * @param ocxFile the OCX file that is currently open.
     */
    public void setOCXFile(File ocxFile) {
        this.ocxFile = ocxFile;
        var previous = ocxFile.getParent() != null ?
                ocxFile.getParentFile().getAbsolutePath() :
                new File(".").getAbsolutePath();

        preferences.put("lastOpenDir", previous);
    }

    /**
     * Get the Schematron rules file to preselect in the Schematron check. This is the
     * last file the user chose, falling back to the example rules shipped under {@code data/schematron/}.
     * Returns {@code null} if neither is readable.
     *
     * @return the rules file to preselect, or null if none is available.
     */
    public File getSchematronFile() {
        if (schematronFile == null) {
            var stored = preferences.get("schematronFile", DEFAULT_SCHEMATRON_FILE);
            var candidate = new File(stored);
            if (candidate.isFile()) {
                schematronFile = candidate;
            }
        }
        return schematronFile;
    }

    /**
     * Set the Schematron rules file and remember it in the preferences so it is
     * preselected the next time the Schematron check is opened.
     *
     * @param schematronFile the rules file the user chose.
     */
    public void setSchematronFile(File schematronFile) {
        this.schematronFile = schematronFile;
        preferences.put("schematronFile", schematronFile.getAbsolutePath());
    }

    /**
     * Get the last open directory.
     *
     * @return the last open directory.
     */
    public String getLastOpenDir() {
        var previous = preferences.get("lastOpenDir", System.getProperty("user.home"));

        if (!new File(previous).isDirectory()) {
            previous = System.getProperty("user.home");
        }

        return previous;
    }

    /**
     * Get the OCX object that is currently open.
     *
     * @return the OCX object that is currently open.
     */
    public OcxXMLT getOcx() {
        return ocx;
    }

    /**
     * Set the OCX object that is currently open.
     *
     * @param ocx the OCX object that is currently open.
     */
    public void setOcx(OcxXMLT ocx) {
        this.ocx = ocx;

        if (ocx.getForm().getValue() instanceof Vessel) {
            vessel = (Vessel) ocx.getForm().getValue();
        }
    }

    public Vessel getVessel() {
        return vessel;
    }

    public BooleanProperty darkModeProperty() {
        return darkMode;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public void setTargetNamespace(String s) {
        this.targetNamespace = s;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {
        return mainController;
    }
}
