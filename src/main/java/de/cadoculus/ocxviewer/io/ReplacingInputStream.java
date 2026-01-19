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
package de.cadoculus.ocxviewer.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is based on an idea from Simon Lang published on https://stackoverflow.com/questions/41302330/given-inputstream-replace-character-and-produce-outputstream.
 * It reads from an underlying InputStream and replaces all occurrences of a given byte sequence with another byte sequence.
 * THis is used to replace non-standard namespace declarations in OCX XML files on-the-fly during parsing, so we could use standard JAXB parsing
 * even for OCX files from a different namespace.
 *
 * This will not use for OCX 2.7.8 files, as they have big differences in the XML structure e.g. for all coordinates.
 * @author Carsten Zerbst
 */
class ReplacingInputStream extends FilterInputStream {

    private final Queue<Integer> inQueue;
    private final Queue<Integer> outQueue;
    private final byte[] search, replacement;

    public ReplacingInputStream(InputStream in, String search, String replacement) {
        super(in);

        this.inQueue = new LinkedList<>();
        this.outQueue = new LinkedList<>();

        this.search = search.getBytes();
        this.replacement = replacement.getBytes();
    }

    private boolean isMatchFound() {
        Iterator<Integer> iterator = inQueue.iterator();

        for (byte b : search) {
            if (!iterator.hasNext() || b != iterator.next()) {
                return false;
            }
        }

        return true;
    }

    private void readAhead() throws IOException {
        // Work up some look-ahead.
        while (inQueue.size() < search.length) {
            int next = super.read();
            inQueue.offer(next);

            if (next == -1) {
                break;
            }
        }
    }

    @Override
    public int read() throws IOException {
        // Next byte already determined.

        while (outQueue.isEmpty()) {
            readAhead();

            if (isMatchFound()) {
                for (byte a : search) {
                    inQueue.remove();
                }

                for (byte b : replacement) {
                    outQueue.offer((int) b);
                }
            } else {
                outQueue.add(inQueue.remove());
            }
        }

        return outQueue.remove();
    }

    @Override
    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }

    // copied straight from InputStream inplementation, just needed to to use `read()` from this class
    @Override
    public int read(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }

        int c = read();
        if (c == -1) {
            return -1;
        }
        b[off] = (byte)c;

        int i = 1;
        try {
            for (; i < len ; i++) {
                c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte)c;
            }
        } catch (IOException ee) {
        }
        return i;
    }
}