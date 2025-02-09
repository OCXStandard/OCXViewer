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
package de.cadoculus.ocxviewer.logging;

import de.cadoculus.ocxviewer.views.LogPage;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;


/**
 * This is a custom Log4j2 appender that appends log events to the ListBox in the LogPage.
 */
@Plugin(name="ListBoxAppender", category= Core.CATEGORY_NAME, elementType= Appender.ELEMENT_TYPE)
public class ListBoxAppender extends AbstractAppender {
    protected ListBoxAppender(String name, Filter filter) {
        super(name, filter, null, false, null);
    }

    @PluginFactory
    public static ListBoxAppender createAppender(@PluginAttribute("name") String name, @PluginElement("Filter") Filter filter) {


        return new ListBoxAppender(name, filter);
    }

    @Override
    public void append(LogEvent event) {
        if (LogPage.getInstance() != null) {

            var page = LogPage.getInstance();
            page.addEvent(new LogRecord(event.getLevel(), event.getMessage().getFormattedMessage(), event.getThrown()));
        } else {
            // System.out.println("ListBoxAppender.append: LogPage.getInstance() is null");
        }

    }
}

