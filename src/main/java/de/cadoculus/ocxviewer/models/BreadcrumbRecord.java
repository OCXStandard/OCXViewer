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


import de.cadoculus.ocxviewer.views.Page;
import org.ocx_schema.v310.IdBaseT;

/**
 * A record representing a breadcrumb entry, containing information whether it is a page or an object,
 * the page class, and the associated object.
 * @param pageClazz the target class of the page, may be null
 * @param name the display name of the breadcrumb
 * @param page the page instance, may be null
 * @param object the associated object, may be null
 * @author Carsten Zerbst
 */
public record BreadcrumbRecord(String name, Class<? extends Page> pageClazz, Page page, org.ocx_schema.v310.IdBaseT object) {

    @Override
    public String toString() {
        return name;
    }
}
