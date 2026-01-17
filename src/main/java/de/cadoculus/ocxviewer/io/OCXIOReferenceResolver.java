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

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocx_schema.v310.DescriptionBaseT;
import org.ocx_schema.v310.IdBaseT;
import org.ocx_schema.v310.NamedEntityT;
import org.ocx_schema.v310.OcxXMLT;

/**
 * A class to resolve references after unmarshallin using the parsed XML and the listener data.
 *
 * @author Carsten Zerbst
 */
class OCXIOReferenceResolver {
    private static final Logger LOG = LogManager.getLogger(OCXIO.class);

    private final OCXIOUnmarshallerListener listener;
    private final OcxXMLT ocx;

    // TODO: switch for strict or lenient behviour
    public OCXIOReferenceResolver(OcxXMLT ocxXMLT, OCXIOUnmarshallerListener jaxListener) {
        this.ocx  = ocxXMLT;
        this.listener = jaxListener;
    }

    public void resolve() {

        LOG.debug("start resolving #{} catalogue references", listener.getCatalogueRefs().size());


    }
}
