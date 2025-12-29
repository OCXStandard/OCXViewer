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

package de.cadoculus.ocxviewer.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.json.JsonConfigurationFactory;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

import java.io.*;

/**
 * This class provides an utility method to initialize org.apache.logging.log4j
 * from a file in either properties, json or xml format
 */
public class LoggerHelper {
    private static final Logger LOG = LogManager.getLogger( LoggerHelper.class );

    private LoggerHelper() {

    }

    /**
     * Initializes the logging from a given file. Will never throw exceptions,
     * only log warning
     *
     * @param f expect a none null file
     */
    public static void initLogging( File f ) {
        if ( f == null ) {
            LOG.warn( "expect none null file to configure logging" );
            return;
        }
        if ( !f.isFile() ) {
            LOG.error( "could not find log configuration file '{}', please check this is an existing file", f.getAbsolutePath() );
            return;
        }

        LOG.info( "using log4j configuration from {}", f.getAbsolutePath() );

        boolean readAsXML = false;
        boolean readAsJSON = false;

        try ( BufferedReader reader = new BufferedReader( new FileReader( f ) ) ) {
            int i = 0;
            String lin = null;
            while ( (lin = reader.readLine()) != null ) {
                lin = lin.trim();
                if ( lin.startsWith( "<Configuration " ) ||
                        lin.startsWith( "<?xml " ) ) {
                    readAsXML = true;
                    break;
                } else if ( lin.startsWith( "{ \"configuration\"" ) ) {
                    readAsJSON = true;
                } else if ( lin.length() == 0 ) {
                    // nothing to do
                } else {
                    LOG.debug( "log cfg file starts with {}, could not determine type", lin );
                }

                i++;
                if ( i > 3 ) {
                    break;
                }
            }
        } catch ( IOException exp ) {
            LOG.warn( "failed to read from config file {}, skip configuration:{}", f, exp );
            return;
        }
        if ( readAsJSON || readAsXML ) {

            try ( FileInputStream fis = new FileInputStream( (f) ) ) {

                ConfigurationSource source = new ConfigurationSource( fis, f );
                Configuration config = null;
                if ( readAsJSON ) {
                    config = JsonConfigurationFactory.getInstance().getConfiguration( null, source );
                } else { // xml is allways true, as we check in line 104 above
                    config = XmlConfigurationFactory.getInstance().getConfiguration( null, source );
                }
                LoggerContext.getContext( false ).start( config );
                LOG.info( "loaded log configuration from {} as {}", f,
                         (readAsJSON ? "json" : "xml") );
            } catch ( IOException exp ) {
                LOG.error( "failed to read log configuration from {}:{}", f, exp );
            }
        } else {
            LOG.warn( "could not determine log4j configuration file type, skip reading it" );
        }

    }
}
