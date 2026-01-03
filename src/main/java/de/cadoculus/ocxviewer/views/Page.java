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
package de.cadoculus.ocxviewer.views;

import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import javafx.scene.Parent;

import java.util.List;

/**
 * An interface used for pages
 * @author Carsten Zerbst
 */
public interface Page {

    int MAX_WIDTH = 1680;
    int MIN_WIDTH = 600;

    /**
     * Returns the name of the page.
     * @return the name of the page
     */
    String getName();
    /**
     * Returns the view of the page.
     * @return the view of the page
     */
    Parent getView();

    /**
     * Returns the breadcrumbs for the page.
     * @return the breadcrumbs for the page
     */
    public List<BreadcrumbRecord> getBreadcrumbs();

    /**
     * Called before the page is shown.
     */
     void beforeShow();

    /**
     * Called after the page is shown.
     */
     void afterShow();

    /**
     * Called before the page is hidden.
     */
     void beforeHide();

    /**
     * Called after the page is hidden.
     */
     void afterHide();

    /**
     * Called before the page is closed.
     */
    void beforeClose();

}
