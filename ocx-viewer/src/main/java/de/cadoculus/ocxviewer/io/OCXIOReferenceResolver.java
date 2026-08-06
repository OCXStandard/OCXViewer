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
import org.ocx_schema.v3x.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A class to resolve references after unmarshalling using the parsed XML and the listener data.
 * Currently only supports MaterialRefT, PlateMaterialRefT, SectionRefT and HoleRefT,
 * to be extended for other references as well.
 * <p>
 * The progress of the resolution can be monitored using a PropertyChangeListener and is NOT reported
 * in the JavaFX Application Thread.
 * </p>
 *
 * @author Carsten Zerbst
 */
class OCXIOReferenceResolver {
    private static final Logger LOG = LogManager.getLogger(OCXIOReferenceResolver.class);

    // assume 10% of the time for setup ...
    private static final int CATALOGUE_SETUP = 10;
    // and 90% for the catalogue resolution. This will change, as soon as reference surfaces etc. are taken into account.
    private static final int CATALOGUE_RESLV = 90;

    private final OCXIOUnmarshallerListener listener;
    private final OcxXMLT ocx;
    private final PropertyChangeSupport propChange;
    private int progress;


    public OCXIOReferenceResolver(OcxXMLT ocxXMLT, OCXIOUnmarshallerListener jaxListener) {
        this.ocx = ocxXMLT;
        this.listener = jaxListener;
        propChange = new PropertyChangeSupport(this);
    }

    /**
     * Add a PropertyChangeListener to the listener list.
     */
    public void addPropertyChangeListener(PropertyChangeListener lis) {
        propChange.addPropertyChangeListener(lis);
    }

    /**
     * Remove a PropertyChangeListener from the listener list.
     */
    public void removePropertyChangeListener(PropertyChangeListener lis) {
        propChange.removePropertyChangeListener(lis);
    }

    /**
     * Returns the current progress value between 0 and 100.
     */
    public int getProgress() {
        return progress;
    }

    /**
     * Updates the progress value every 5%. Expects values between 0 and 100.
     */
    private void updateProgress(int np) {

        if (np != progress) {
            int ov = progress;
            progress = np;

            if ((progress % 5) == 0) {
                propChange.firePropertyChange(ProgressInputStream.PROGRESS, ov, progress);
            }
        }
    }


    public void resolve() {

        updateProgress(0);

        final Set<IdBaseT> idBaseTs = listener.getIdBaseTs();
        final Set<ReferenceBaseTImpl> references = listener.getReferences();

        LOG.info("start resolving #{} references from #{} idBasees",
                references.size(),
                idBaseTs.size());

        final Map<String, IdBaseT> idMap = new HashMap<String, IdBaseT>();
        final Map<String, IdBaseT> guidMap = new HashMap<String, IdBaseT>();


        idBaseTs.forEach(idT -> {
            if (StringUtils.isNotEmpty(idT.getId())) {
                idMap.put(idT.getId(), idT);
            } else {
                LOG.warn("No ID found in idBase " + OCXIO.serialize(idT));
            }

            if (idT instanceof EntityBaseT entityBaseT) {
                if (StringUtils.isNotEmpty(entityBaseT.getGUIDRef())) {
                    guidMap.put(entityBaseT.getGUIDRef(), idT);
                } else {
                    LOG.warn("No GUIDRef found in EntityBaseT " + OCXIO.serialize(entityBaseT));
                }
            } else if (idT instanceof Material material) {
                if (StringUtils.isNotEmpty(material.getGUIDRef())) {
                    guidMap.put(material.getGUIDRef(), idT);
                } else {
                    LOG.warn("No GUIDRef found in Material " + OCXIO.serialize(material));
                }
            } else if (idT instanceof BarSection barSection) {
                if (StringUtils.isNotEmpty(barSection.getGUIDRef())) {
                    guidMap.put(barSection.getGUIDRef(), idT);
                } else {
                    LOG.warn("No GUIDRef found in BarSection " + OCXIO.serialize(barSection));
                }
            } else if (idT instanceof Hole2D hole2D) {
                if (StringUtils.isNotEmpty(hole2D.getGUIDRef())) {
                    guidMap.put(hole2D.getGUIDRef(), idT);
                } else {
                    LOG.warn("No GUIDRef found in Hole2D " + OCXIO.serialize(hole2D));
                }
            }
        });

        LOG.debug("prepared #{} ids and #{} GUIDs from #{} idBaseTs",
                idMap.size(), guidMap.size(), idBaseTs.size());

        LOG.debug("ids {}", idMap.keySet());
        LOG.debug("guids {}", guidMap.keySet());

        updateProgress(CATALOGUE_SETUP);

        int counter = 0;
        final int total = references.size();

        for (ReferenceBaseTImpl refBaseT : references) {
            counter++;
            int prog = CATALOGUE_SETUP + (int) (((double) counter / (double) total) * CATALOGUE_RESLV);
            updateProgress(prog);
            LOG.debug("handle object #{} / #{} ({}%}: reference of type {} with localRef='{}'",
                    counter, total, prog,
                    refBaseT.getClass().getSimpleName(),
                    refBaseT.getLocalRef()
            );


            // TODO: cross check id vs. GUIDRef
            // TODO: check of the right type was resolved
            if (refBaseT.getLocalRef() instanceof IdBaseT idBaseT) {
                // this was already resolved by JAXB
                var refId = idBaseT.getId();
                LOG.debug("resolved reference by Id '{}'=={}", refId, idBaseT);
                refBaseT.setReferenced(idBaseT);
                continue;
            }

            // This is messy, the sub-classes of ReferenceBaseT containing a GUIDRef have no common super-class :-(
            String refGUIDRef = null;
            if (refBaseT instanceof CatalogueRefT catalogueRefT) {
                refGUIDRef = catalogueRefT.getGUIDRef();
            } else if (refBaseT instanceof StructureRefT structureRefT) {
                refGUIDRef = structureRefT.getGUIDRef();
            } else if (refBaseT instanceof VesselRefT vesselRefT) {
                refGUIDRef = vesselRefT.getGUIDRef();
            } else {
                LOG.warn("find a {} reference with unresolved localRef='{}', cannot get GUIDRef, unsupported type",
                        refBaseT.getClass().getSimpleName(),
                        refBaseT.getLocalRef());
                continue;
            }

            if (StringUtils.isEmpty(refGUIDRef)) {
                LOG.warn("no GUIDRef found in reference {}", OCXIO.serialize(refBaseT));
                continue;
            }

            var referencedObject = guidMap.get(refGUIDRef);
            if (referencedObject == null) {
                LOG.warn("failed to resolve reference by GUIDRef '{}'=={}", refGUIDRef, referencedObject);
            } else {
                LOG.debug("resolved reference by GUIDRef '{}'=={}", refGUIDRef, referencedObject);
                refBaseT.setReferenced(referencedObject);
            }


        } // end loop


        updateProgress(100);

    }

    private <T extends IdBaseT> T resolveReference(CatalogueRefT catalogueRef, Class<T> expectedClass, HashMap<String, IdBaseT> guid2entry) {
        String refId = null;
        IdBaseT referenced = null;
        if (catalogueRef.getLocalRef() instanceof String localRefStr) {
            refId = localRefStr;
        } else if (catalogueRef.getLocalRef() instanceof IdBaseT) {
            referenced = ((IdBaseT) catalogueRef.getLocalRef());
            refId = referenced.getId();
        }

        String referenceGUIDRef = catalogueRef.getGUIDRef();

        // The localRef was already resolved during unmarshalling by JAXB
        if (referenced != null) {
            if (!expectedClass.isAssignableFrom(referenced.getClass())) {
                LOG.warn("the localRef '{}' found in a catalogue reference of {} resolved to a {}, expected a {}",
                        referenced.getId(), catalogueRef.getClass().getSimpleName(), referenced.getClass().getSimpleName(), expectedClass.getSimpleName());
                referenced = null;
            } else if (StringUtils.isNoneEmpty(referenceGUIDRef)) {
                // paranoia mode: check GUIDRef matches. This is a bit complicated, as the GUIDRef in the referenced object may be null
                String objectGUIDRef = null;
                switch (referenced) {
                    case Material material -> objectGUIDRef = material.getGUIDRef();
                    case BarSection barSection -> objectGUIDRef = barSection.getGUIDRef();
                    case Hole2D hole2D -> objectGUIDRef = hole2D.getGUIDRef();
                    default ->
                            LOG.warn("cannot check GUIDRef of referenced object of type {}, unsupported type", referenced.getClass().getSimpleName());
                }

                if (!(referenceGUIDRef.equals(objectGUIDRef))) {
                    LOG.warn("the localRef '{}' found in a catalogue reference of {} resolved to '{}', but the referenced GUIDRef '{}' does not match the GUIDRef '{}' from the object",
                            refId, catalogueRef.getClass().getSimpleName(), referenced.getId(), referenceGUIDRef, objectGUIDRef);
                }
            }
        } else if (StringUtils.isNoneEmpty(referenceGUIDRef)) {
            // try to resolve by GUIDRef
            referenced = guid2entry.get(referenceGUIDRef);
            if (referenced == null) {
                LOG.warn("failed to resolve the GUIDRef '{}' in the catalogue", referenceGUIDRef);
            } else if (!expectedClass.isAssignableFrom(referenced.getClass())) {
                LOG.warn("the GUIDRef '{}' found in a catalogue reference of {} resolved to a {}, expected a {}",
                        referenceGUIDRef, catalogueRef.getClass().getSimpleName(), referenced.getClass().getSimpleName(), expectedClass.getSimpleName());
                referenced = null;
            }
        }

        if (LOG.isTraceEnabled()) {
            LOG.trace("resolved catalogue reference of type {} with localRef='{}', GUIDRef='{}' to a {}, id='{}', GUIDRef='{}'",
                    catalogueRef.getClass().getSimpleName(), refId, referenceGUIDRef,
                    referenced != null ? (referenced.getClass().getSimpleName()) : "/NULL",
                    referenced != null ? referenced.getId() : "/NULL",
                    referenced != null ? (referenced instanceof Material material ? material.getGUIDRef() : (referenced instanceof BarSection barSection ? barSection.getGUIDRef() : (referenced instanceof Hole2D hole2D ? hole2D.getGUIDRef() : "/NULL"))) : "/NULL"
            );
        }

        return (T) referenced;
    }
}