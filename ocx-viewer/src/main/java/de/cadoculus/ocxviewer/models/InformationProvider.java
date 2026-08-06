/*
 * Copyright 2026 Carsten Zerbst
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

/**
 * The InformationProvider is an inteface used to mark objects which are able
 * to create human readable information about themselves. This is used to display information about objects in the 3D scene when the user clicks on them.
 * The information is expected to be HTML styled text, so it can be displayed in a JavaFX WebView.
 */
public interface InformationProvider {

    /**
     * Get a Name used to shortly represent an object
     * @return the display name
     */
    public String getName();

    /**
     * Return a Bulletin Board Code formatted text containing the information on the object
     * @return the HTML text
     */
    String getInformation();
}
