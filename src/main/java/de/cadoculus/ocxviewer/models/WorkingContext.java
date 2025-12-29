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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.ocx_schema.v310.*;
import de.cadoculus.ocxviewer.OCXViewerApplication;
import javafx.scene.Scene;

import java.io.File;
import java.util.prefs.Preferences;

/**
 * Singleton class to store the working context of the application.
 */
public class WorkingContext {

    private static WorkingContext INSTANCE;
    private File ocxFile;
    private final Preferences preferences;
    private OcxXMLT ocx;
    private Vessel vessel;
    private Scene mainScene;
    private String targetNamespace;
    private BooleanProperty darkMode = new SimpleBooleanProperty(false);


    /**
     * Get the singleton instance of the working context.
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
     * @return the OCX file that is currently open.
     */
    public File getOCXFile() {
        return ocxFile;
    }
    /**
     * Set the OCX file that is currently open. As a side effect, the last open directory is stored in the preferences.
     * @param ocxFile the OCX file that is currently open.
     */
    public void setOCXFile(File ocxFile) {
        this.ocxFile = ocxFile;
        var previous = ocxFile.getParent() != null?
                ocxFile.getParentFile().getAbsolutePath() :
                new File(".").getAbsolutePath();

        preferences.put("lastOpenDir", previous);
    }
    /**
     * Get the last open directory.
     * @return the last open directory.
     */
    public String getLastOpenDir() {
        var previous = preferences.get("lastOpenDir", System.getProperty("user.home"));

        if ( ! new File( previous).isDirectory()) {
            previous = System.getProperty("user.home");
        }

        return previous;
    }

    /**
     * Get the OCX object that is currently open.
     * @return the OCX object that is currently open.
     */
    public OcxXMLT getOcx() {
        return ocx;
    }
    /**
     * Set the OCX object that is currently open.
     * @param ocx the OCX object that is currently open.
     */
    public void setOcx(OcxXMLT ocx) {
        this.ocx = ocx;

        if ( ocx.getForm().getValue() instanceof Vessel) {
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

    public void setTargetNamespace(String s) {this.targetNamespace=s;}
    public String getTargetNamespace() {return targetNamespace;}



}
