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
import atlantafx.base.layout.InputGroup;
import atlantafx.base.theme.Styles;
import atlantafx.base.util.BBCodeParser;
import de.cadoculus.ocxviewer.models.BreadcrumbRecord;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import oasis.unitsml.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvnet.basicjaxb.lang.Bound;
import org.jvnet.basicjaxb.lang.StringUtils;
import org.ocx_schema.v310.IdBaseT;
import org.ocx_schema.v310.Point3DT;
import org.ocx_schema.v310.QuantityT;
import org.ocx_schema.v310.Vector3DT;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * The base class for sub page data views
 * @author Carsten Zerbst
 */
public abstract class AbstractDataViewSubPage<T extends IdBaseT> extends AbstractDataViewPage implements SubPage {

    private static final Logger LOG = LogManager.getLogger(AbstractDataViewSubPage.class);
    private final Page parentPage;
    private final T object;


    protected AbstractDataViewSubPage( T object , Page parentPage, String name) {
        super(name);
        if ( object == null ) throw new IllegalArgumentException("object is null");
        if ( parentPage == null ) throw new IllegalArgumentException("parentPage is null");

        this.object = object;
        this.parentPage = parentPage;
    }

    @Override
    public Page getParentPage() {
        return parentPage;
    }

    public T getObject() {
        return object;
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
