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

import atlantafx.base.controls.Breadcrumbs;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The base class for sub page data views
 * @author Carsten Zerbst
 */
public abstract class AbstractDataViewSubPage<T extends org.ocx_schema.v310.IdBaseT> extends AbstractDataViewPage implements SubPage {

    private static final Logger LOG = LogManager.getLogger(AbstractDataViewSubPage.class);
    private final Page parentPage;
    protected final T object;


    protected AbstractDataViewSubPage( T object , Page parentPage, String name) {
        super(name);
        if ( object == null ) throw new IllegalArgumentException("object is null");
        if ( parentPage == null ) throw new IllegalArgumentException("parentPage is null");
        this.object = object;
        this.parentPage = parentPage;

        LOG.info("created a new sub page {} for {}", name, object);
        LOG.info("   parent {}, breadcrums {}", getParentPage(), getBreadcrumbs());

    }

    @Override
    public Page getParentPage() {
        return parentPage;
    }

    public T getObject() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) {
            // Same page class
            return false;
        }
        var other = (AbstractDataViewSubPage<?>) o;
        return Objects.equals(object, other.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), object);
    }

    /**
     * Get the breadcrumbs for this page. As this is a children page, the path is created from the parents path + one for this page
     * @return the list of breadcrumbs
     */
    @Override
    public List<BreadcrumbRecord> getBreadcrumbs() {
        var robert = new ArrayList<BreadcrumbRecord>( parentPage.getBreadcrumbs());
        robert.add( new BreadcrumbRecord(getName(), this.getClass(), this, getObject()));
        return robert;
    }

    protected  <T> Breadcrumbs.BreadCrumbItem<T> getTreeItemByIndex(Breadcrumbs.BreadCrumbItem<T> node, int index) {
        var counter = index;
        var current = node;
        while (counter > 0 && current.getParent() != null) {
            current = (Breadcrumbs.BreadCrumbItem<T>) current.getParent();
            counter--;
        }
        return current;
    }

}
