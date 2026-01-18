package de.cadoculus.ocxviewer.io;

import jakarta.xml.bind.annotation.XmlTransient;
import org.ocx_schema.v310.CatalogueRefT;
import org.ocx_schema.v310.IdBaseT;
import org.ocx_schema.v310.NamedEntityT;

/**
 * Implementation class for CatalogueRefT to hold a reference to the actual object.
 * @see OCXIO
 * @author Carsten Zerbst
 */
public class CatalogueRefTImpl extends CatalogueRefT {

    @XmlTransient
    private IdBaseT referenced;

    public IdBaseT getReferenced() {
        return referenced;
    }

 public void setReferenced(IdBaseT referenced) {
        this.referenced = referenced;
    }
}
