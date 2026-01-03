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
package de.cadoculus.ocxviewer.actions;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * The Schema Check action
 * @author Carsten Zerbst
 */
public class SchemaCheckAction extends  AbstractAction {

    public final static KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);
    public final static  String NAME = "Schema Check";

    //TODO: implement a dialogue to select the file and version to check, then run the schema checks
    @Override
    public void run() {


        System.out.println("Schema Check");
    }
}
