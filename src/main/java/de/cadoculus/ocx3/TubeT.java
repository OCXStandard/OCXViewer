
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Tube_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// Tube_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Tube_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class TubeT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Diameter
    // PropertyWrapper{name='Diameter', typeName='Diameter', docu='null', type=Diameter, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Diameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Diameter' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Diameter> Diameter = new javafx.beans.property.SimpleObjectProperty<Diameter>();

    @XmlElement(name = "Diameter", required = true)
    public Diameter getDiameter() {
        return this.Diameter.get();
    }
    public void setDiameter( Diameter value) {
        this.Diameter.set( value);
    }




    // Property Thickness
    // PropertyWrapper{name='Thickness', typeName='Thickness', docu='null', type=Thickness, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Thickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Thickness' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Thickness> Thickness = new javafx.beans.property.SimpleObjectProperty<Thickness>();

    @XmlElement(name = "Thickness", required = true)
    public Thickness getThickness() {
        return this.Thickness.get();
    }
    public void setThickness( Thickness value) {
        this.Thickness.set( value);
    }




    // end the properties serialised to elements




      public TubeT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
