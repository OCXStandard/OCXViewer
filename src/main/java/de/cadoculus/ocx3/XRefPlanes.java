
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>XRefPlanes</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A collection of Y-Z planes used as object limits. Can also be used to create a frame table
 * 				definition for display purposes. The exporting application will then have to provide all grid positions.
 *  

*/
// XRefPlanes https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// RefPlanes_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "XRefPlanes", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class XRefPlanes extends RefPlanesT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property DistanceToAP
    // PropertyWrapper{name='DistanceToAP', typeName='DistanceToAP', docu='null', type=DistanceToAP, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='DistanceToAP', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DistanceToAP' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DistanceToAP> DistanceToAP = new javafx.beans.property.SimpleObjectProperty<DistanceToAP>();

    @XmlElement(name = "DistanceToAP", required = false)
    public DistanceToAP getDistanceToAP() {
        return this.DistanceToAP.get();
    }
    public void setDistanceToAP( DistanceToAP value) {
        this.DistanceToAP.set( value);
    }




    // end the properties serialised to elements




      public XRefPlanes() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
