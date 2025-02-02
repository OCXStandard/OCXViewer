
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ContourBounds_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The type definition of the ContourBounds
 *  

*/
// ContourBounds_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ContourBounds_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ContourBoundsT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ContourStart
    // PropertyWrapper{name='ContourStart', typeName='ContourStart', docu='null', type=ContourStart, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ContourStart', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ContourStart' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ContourStart> ContourStart = new javafx.beans.property.SimpleObjectProperty<ContourStart>();

    @XmlElement(name = "ContourStart", required = true)
    public ContourStart getContourStart() {
        return this.ContourStart.get();
    }
    public void setContourStart( ContourStart value) {
        this.ContourStart.set( value);
    }




    // Property ContourEnd
    // PropertyWrapper{name='ContourEnd', typeName='ContourEnd', docu='null', type=ContourEnd, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ContourEnd', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ContourEnd' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ContourEnd> ContourEnd = new javafx.beans.property.SimpleObjectProperty<ContourEnd>();

    @XmlElement(name = "ContourEnd", required = true)
    public ContourEnd getContourEnd() {
        return this.ContourEnd.get();
    }
    public void setContourEnd( ContourEnd value) {
        this.ContourEnd.set( value);
    }




    // end the properties serialised to elements




      public ContourBoundsT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
