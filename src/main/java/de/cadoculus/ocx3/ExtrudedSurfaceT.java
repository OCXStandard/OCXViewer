
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ExtrudedSurface_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of an extruded surface defined by a base curve and a sweep path with
 * 				extent.
 *  

*/
// ExtrudedSurface_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Surface_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ExtrudedSurface_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ExtrudedSurfaceT extends SurfaceT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property BaseCurve
    // PropertyWrapper{name='BaseCurve', typeName='BaseCurve', docu='null', type=BaseCurve, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='BaseCurve', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BaseCurve_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BaseCurve' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BaseCurve> BaseCurve = new javafx.beans.property.SimpleObjectProperty<BaseCurve>();

    @XmlElement(name = "BaseCurve", required = true)
    public BaseCurve getBaseCurve() {
        return this.BaseCurve.get();
    }
    public void setBaseCurve( BaseCurve value) {
        this.BaseCurve.set( value);
    }




    // end the properties serialised to elements




      public ExtrudedSurfaceT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
