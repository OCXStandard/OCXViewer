
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>LugPlateRef</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The reference to plate lugs with additional lug parameters.
 *  

*/
// LugPlateRef https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// LugPlaterRef_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LugPlateRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class LugPlateRef extends LugPlaterRefT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ConnectionLength
    // PropertyWrapper{name='ConnectionLength', typeName='ConnectionLength', docu='null', type=ConnectionLength, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ConnectionLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ConnectionLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ConnectionLength> ConnectionLength = new javafx.beans.property.SimpleObjectProperty<ConnectionLength>();

    @XmlElement(name = "ConnectionLength", required = true)
    public ConnectionLength getConnectionLength() {
        return this.ConnectionLength.get();
    }
    public void setConnectionLength( ConnectionLength value) {
        this.ConnectionLength.set( value);
    }




    // Property DistanceAbove
    // PropertyWrapper{name='DistanceAbove', typeName='DistanceAbove', docu='null', type=DistanceAbove, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='DistanceAbove', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DistanceAbove' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DistanceAbove> DistanceAbove = new javafx.beans.property.SimpleObjectProperty<DistanceAbove>();

    @XmlElement(name = "DistanceAbove", required = true)
    public DistanceAbove getDistanceAbove() {
        return this.DistanceAbove.get();
    }
    public void setDistanceAbove( DistanceAbove value) {
        this.DistanceAbove.set( value);
    }




    // end the properties serialised to elements




      public LugPlateRef() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
