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
import org.ocx_schema.v3x.IdBaseT;

import java.util.HashSet;
import java.util.Set;

/**
 * An Unmarshaller.Listener to react on unmarshalling events.
 * It is used to collect the non-standard catalogue references in the OCX XML files.
 *
 * @author Carsten Zerbst
 */
class OCXIOUnmarshallerListener extends Listener {
    private static final Logger LOG = LogManager.getLogger(OCXIOUnmarshallerListener.class);

    private final Set<ReferenceBaseTImpl> references = new HashSet<>();
    private final Set<IdBaseT> idBaseTs = new HashSet<>();
    // the classes we want to collect entities to resolve references in bounded refs
    //    private final static Set<Class<?extends IdBaseT>> CLASSES_TO_COLLECT = Set.of(
    //            RefPlaneT.class, // GridRef_T
    //            SurfaceT.class, // SurfaceRef_T
    //            Stiffener.class, // StiffenerRef_T
    //            Panel.class, // PanelRef_T, CellBoundary_T
    //            FreeEdgeCurve3D.class, // EdgeCurveRef_T
    //            Seam.class, // SeamRef_T
    //            EdgeReinforcement.class, // EdgeReinforcementRef_T
    //            EndCutT.class,  // EndCutRef_T
    //            Plate.class, //PlateRef_T
    //            Vessel.class, // VesselRef_T
    //            ConnectionConfigurationT.class, //ConnectionConfigurationRef_T
    //            Cell.class, // CellRef_T
    //
    //    );)


    @Override
    public void afterUnmarshal(java.lang.Object target, java.lang.Object parent) {
        LOG.debug("afterUnmarshal: target class: {}, parent class: {}", target.getClass(), parent != null ? parent.getClass() : "null");

        if (target instanceof ReferenceBaseTImpl refT) {
            // we have a reference, we need to resolve it
            LOG.debug("collect ReferenceBaseT {}", refT.getLocalRef());
            references.add(refT);
        } else if (target instanceof IdBaseT idT) {
            //LOG.debug("collect IdBaseT {}", idT.getId());
            idBaseTs.add(idT);
        }
    }


    /**
     * Get the collected IdBaseT entities
     *
     * @return the id base ts
     */
    public Set<IdBaseT> getIdBaseTs() {
        return idBaseTs;
    }

    /**
     * Get the collected  references
     *
     * @return the collected references
     */
    public Set<ReferenceBaseTImpl> getReferences() {
        return references;
    }
}