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
            page.addEvent(new LogRecord(event.getLevel(), event.getMessage().getFormattedMessage()));
        }

    }
}

