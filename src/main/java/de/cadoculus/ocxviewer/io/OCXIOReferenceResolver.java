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
import org.ocx_schema.v310.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class to resolve references after unmarshalling using the parsed XML and the listener data.
 * Currently only supports MaterialRefT, PlateMaterialRefT, SectionRefT and HoleRefT,
 * to be extended for other references as well.
 *
 * The progress of the resolution can be monitored using a PropertyChangeListener and is NOT reported
 * in the JavaFX Application Thread.
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
    private int progress;
    private final PropertyChangeSupport propChange;


    public OCXIOReferenceResolver(OcxXMLT ocxXMLT, OCXIOUnmarshallerListener jaxListener) {
        this.ocx = ocxXMLT;
        this.listener = jaxListener;
        propChange = new PropertyChangeSupport(this);
    }

    /**
     * Add a PropertyChangeListener to the listener list.
     */
    public void addPropertyChangeListener( PropertyChangeListener lis ) {
        propChange.addPropertyChangeListener( lis );
    }

    /**
     * Remove a PropertyChangeListener from the listener list.
     */
    public void removePropertyChangeListener( PropertyChangeListener lis ) {
        propChange.removePropertyChangeListener( lis );
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

        if ( np != progress ) {
            int ov = progress;
            progress = np;

            if ( ( progress % 5 ) == 0 ) {
                propChange.firePropertyChange( ProgressInputStream.PROGRESS, ov, progress );
            }
        }
    }



    public void resolve() {

        this.updateProgress(0);

        LOG.debug("start resolving #{} catalogue references", listener.getCatalogueRefs().size());
        if (ocx.getClassCatalogue() == null) {
            LOG.warn("no ClassCatalogue found, cannot resolve catalogue references");
            return;
        }

        final var catalogueRefs = new ArrayList<>(listener.getCatalogueRefs());
        final boolean containsMaterialRefs = catalogueRefs.stream().anyMatch(catalogueRefT -> catalogueRefT instanceof MaterialRefT || catalogueRefT instanceof PlateMaterialRefT);
        final boolean containsSectionRefs = catalogueRefs.stream().anyMatch(catalogueRefT -> catalogueRefT instanceof SectionRefT);
        final boolean containsHoleRefs = catalogueRefs.stream().anyMatch(catalogueRefT -> catalogueRefT instanceof HoleRefT);

        // prepare a map of GUIDRef to catalogue entries
        final var guid2entry = new HashMap<String, IdBaseT>();

        // prepare lookup maps if needed
        final MaterialCatalogue materialCatalogue = ocx.getClassCatalogue().getMaterialCatalogue();
        if (containsMaterialRefs) {
            if (materialCatalogue == null) {
                LOG.warn("no MaterialCatalogue found, cannot resolve material references");
            } else if (materialCatalogue.getMaterials() == null || materialCatalogue.getMaterials().isEmpty()) {
                LOG.warn("no Materials contained in the MaterialCatalogue, cannot resolve material references");
            } else {
                materialCatalogue.getMaterials().forEach(material -> {
                    if (material.getGUIDRef() != null) {
                        // Paranoia mode: check for duplicate GUIDRefs
                        if ( guid2entry.containsKey(material.getGUIDRef())) {
                            var previous = guid2entry.get(material.getGUIDRef());
                            LOG.warn("duplicate GUIDRefs '{}' found in the catalogue, previously found {} id={}, now {} id={}",
                                    material.getGUIDRef(),
                                    previous.getClass().getSimpleName(), previous.getId(),
                                    material.getClass().getSimpleName(), material.getId());
                        } else {
                            guid2entry.put(material.getGUIDRef(), material);
                        }
                    }
                });
            }
        }

        final XSectionCatalogue xSectionCatalogue = ocx.getClassCatalogue().getXSectionCatalogue();
        if (containsSectionRefs) {
            if (xSectionCatalogue == null) {
                LOG.warn("no XSectionCatalogue found, cannot resolve bar section references");
            } else if (xSectionCatalogue.getBarSections() == null || xSectionCatalogue.getBarSections().isEmpty()) {
                LOG.warn("no BarSections found in XSectionCatalogue, cannot resolve material references");
            } else {
                xSectionCatalogue.getBarSections().forEach(barSection -> {
                    if (barSection.getGUIDRef() != null) {
                        if ( guid2entry.containsKey(barSection.getGUIDRef())) {
                            var previous = guid2entry.get(barSection.getGUIDRef());
                            LOG.warn("duplicate GUIDRefs '{}' found in the catalogue, previously found {} id={}, now {} id={}",
                                    barSection.getGUIDRef(),
                                    previous.getClass().getSimpleName(), previous.getId(),
                                    barSection.getClass().getSimpleName(), barSection.getId());
                        } else {
                            guid2entry.put(barSection.getGUIDRef(), barSection);
                        }
                    }
                });
            }
        }

        final HoleShapeCatalogue holeShapeCatalogue = ocx.getClassCatalogue().getHoleShapeCatalogue();
        if (containsHoleRefs) {
            if (holeShapeCatalogue == null) {
                LOG.warn("no HoleShapeCatalogue found, cannot resolve hole shape references");
            } else if (holeShapeCatalogue.getHole2Ds() == null || holeShapeCatalogue.getHole2Ds().isEmpty()) {
                LOG.warn("no HoleShapeCatalogue found in HoleShapeCatalogue, cannot resolve hole shape references");
            } else {
                holeShapeCatalogue.getHole2Ds().forEach(hole2D -> {
                    if ( guid2entry.containsKey(hole2D.getGUIDRef())) {
                        var previous = guid2entry.get(hole2D.getGUIDRef());
                        LOG.warn("duplicate GUIDRefs '{}' found in the catalogue, previously found {} id={}, now {} id={}",
                                hole2D.getGUIDRef(),
                                previous.getClass().getSimpleName(), previous.getId(),
                                hole2D.getClass().getSimpleName(), hole2D.getId());
                    } else {
                        guid2entry.put(hole2D.getGUIDRef(), hole2D);
                    }
                });
            }
        }

        updateProgress(CATALOGUE_SETUP);


        int reportIntervall = Math.max(1, (int) Math.floor(catalogueRefs.size() / 10.0));

        for (int i = 0; i < catalogueRefs.size(); i++) {
            var catalogueRef = catalogueRefs.get(i);
            if (i % reportIntervall == 0) {
                LOG.debug("resolving catalogue references: {}/{}", i, catalogueRefs.size());
                var rsolvProg = CATALOGUE_SETUP + CATALOGUE_RESLV * ((double) i / (double) catalogueRefs.size());
                updateProgress( (int) rsolvProg);
            }
            IdBaseT referenced = null;
            var object = catalogueRef.getLocalRef();
            String refId = object instanceof String ? (String) object : null;
            String guid = catalogueRef.getGUIDRef();
            LOG.debug("resolving catalogue reference of type {} with localRef '{}' and GUIDRef '{}'",
                    catalogueRef.getClass().getSimpleName(), refId, guid);

            if ( PlateMaterialRefT.class.isAssignableFrom(catalogueRef.getClass()) ) {
                referenced = resolveReference(catalogueRef, Material.class, guid2entry);
            } else if ( MaterialRefT.class.isAssignableFrom(catalogueRef.getClass()) ) {
                referenced = resolveReference(catalogueRef, Material.class, guid2entry);
            } else if ( SectionRefT.class.isAssignableFrom(catalogueRef.getClass()) ) {
                referenced = resolveReference(catalogueRef, BarSection.class,  guid2entry);
            } else if ( HoleRefT.class.isAssignableFrom(catalogueRef.getClass()) ) {
                referenced = resolveReference(catalogueRef, Hole2D.class,  guid2entry);
            } else {
                LOG.warn("found unsupported catalogue reference type: {}", catalogueRef.getClass());
            }

            ((CatalogueRefTImpl)catalogueRef).setReferenced( referenced);
        }

        updateProgress(100);

    }

    private <T extends IdBaseT> T resolveReference(CatalogueRefT catalogueRef, Class<T> expectedClass, HashMap<String, IdBaseT> guid2entry) {
        String refId = null;
        IdBaseT referenced = null;
        if (catalogueRef.getLocalRef() instanceof String localRefStr) {
            refId = localRefStr;
        } else if (catalogueRef.getLocalRef() instanceof  IdBaseT) {
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

        if ( LOG.isTraceEnabled()) {
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