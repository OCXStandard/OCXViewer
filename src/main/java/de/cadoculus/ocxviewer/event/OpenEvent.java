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
package de.cadoculus.ocxviewer.event;

import de.cadoculus.ocx3.OcxXML;

import java.io.File;

/**
 * Event that is fired when a new OCX file is opened.
 * OpenAction is responsible for firing this event.
 */
public class OpenEvent extends  Event{

    private OcxXML ocx;
    private File ocxFile;

    public OpenEvent(OcxXML ocx, File ocxFile) {
        this.ocx = ocx;
        this.ocxFile = ocxFile;
    }

    public OcxXML getOcx() {
        return ocx;
    }

    public void setOcx(OcxXML ocx) {
        this.ocx = ocx;
    }

    @Override
    public String toString() {
        return "OpenEvent{" +
                ", ocxFile=" + ocxFile +
                '}';
    }
}
