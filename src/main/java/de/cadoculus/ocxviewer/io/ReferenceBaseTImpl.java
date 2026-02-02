package de.cadoculus.ocxviewer.io;

import jakarta.xml.bind.annotation.XmlTransient;
import org.ocx_schema.v310.IdBaseT;
import org.ocx_schema.v310.ReferenceBaseT;

/**
 * Implementation class for ReferenceBaseT to hold a reference to the actual object.
 *
 * @author Carsten Zerbst
 * @see OCXIO
 */
public class ReferenceBaseTImpl extends ReferenceBaseT {

    @XmlTransient
    private IdBaseT referenced;

    public IdBaseT getReferenced() {
        return referenced;
    }

    public void setReferenced(IdBaseT referenced) {
        this.referenced = referenced;
    }
}
