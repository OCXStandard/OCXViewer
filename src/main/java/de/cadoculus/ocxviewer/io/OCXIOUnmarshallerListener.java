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

import jakarta.xml.bind.Unmarshaller.Listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.CatalogueRefT;

import java.util.HashSet;
import java.util.Set;

/**
 * An Unmarshaller.Listener to react on unmarshalling events.
 * It is used to collect the non-standard catalogue references in the OCX XML files.
 *
 *
 * @author Carsten Zerbst
 */
class OCXIOUnmarshallerListener extends Listener {
    private static final Logger LOG = LogManager.getLogger(OCXIOUnmarshallerListener.class);

    private final Set<CatalogueRefT> catalogueRefs = new HashSet<>();

    @Override
    public void afterUnmarshal(java.lang.Object target, java.lang.Object parent) {


        if ( target instanceof CatalogueRefTImpl refT ) {

            LOG.debug("afterUnmarshal: target class: {}, parent class: {}", target.getClass(), parent != null ? parent.getClass() : "null");
            // we have a reference, we need to resolve it
            catalogueRefs.add(refT);
        }
    }

    public Set<CatalogueRefT> getCatalogueRefs() {
        return catalogueRefs;
    }
}