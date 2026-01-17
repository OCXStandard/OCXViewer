package de.cadoculus.ocxviewer.io;

import jakarta.xml.bind.annotation.XmlTransient;
import org.ocx_schema.v310.CatalogueRefT;
import org.ocx_schema.v310.NamedEntityT;

/**
 * Implementation class for CatalogueRefT to hold a reference to the actual object.
 * @see OCXIO
 * @author Carsten Zerbst
 */
public class CatalogueRefTImpl extends CatalogueRefT {

    @XmlTransient
    private NamedEntityT referenced;

    public NamedEntityT getReferenced() {
        return referenced;
    }

     void setReferenced(NamedEntityT referenced) {
        this.referenced = referenced;
    }
}
