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
package de.cadoculus.ocxviewer.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;

/**
 * This Input Stream covers an ordinary FileInputStream and offers an additional
 * progress counter.
 *
 * @author zerbst
 */
public class ProgressInputStream extends FilterInputStream {

    private static final Logger LOG = LogManager.getLogger(ProgressInputStream.class);

    public static final String PROGRESS = "progress";
    private final File file;
    private long pos;
    private int progress;
    private final PropertyChangeSupport propChange;
    private final long size;

    /**
     * Creates a new instance of ProgressInputStream
     */
    public ProgressInputStream(final File file ) throws FileNotFoundException {

        super( new FileInputStream( file ) );
        this.file = file;
        this.size = file.length();
        this.pos = 0;
        this.propChange = new PropertyChangeSupport( this );
    }

    /**
     * Add a PropertyChangeListener to the listener list.
     */
    public void addPropertyChangeListener( PropertyChangeListener lis ) {
        propChange.addPropertyChangeListener( lis );
    }

    /**
     * Overides read, increments position;
     */
    public int read() throws IOException {
        pos++;
        updateProgress();

        return super.read();
    }

    /**
     * Overrides read, increments position;
     */
    public int read( byte[] b ) throws IOException {
        int retval = super.read( b );
        pos += retval;
        updateProgress();

        return retval;

    }

    /**
     * Overrides read, increments position;
     */
    public int read( byte[] b, int off, int len ) throws IOException {
        int retval = super.read( b, off, len );
        pos += retval;
        updateProgress();

        return retval;

    }

    /**
     * Remove a PropertyChangeListener from the listener list.
     */
    public void removePropertyChangeListener( PropertyChangeListener lis ) {
        propChange.removePropertyChangeListener( lis );
    }

    public int getProgress() {
        return progress;
    }

    /**
     * Calculates the progress value
     */
    private void updateProgress() {
        int np = (int) Math.floor( 100.0 * pos / (float) size );

        if ( np != progress ) {
            int ov = progress;
            progress = np;

            if ( ( progress % 5 ) == 0 ) {
                propChange.firePropertyChange( PROGRESS, ov, progress );
                LOG.debug( "read " + progress + "%" );
            }
        }

    }

}
