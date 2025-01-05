
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Sweep_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a sweep extent defined by a direction and length.
 *  

*/
// Sweep_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Sweep_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SweepT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Vector3D
    // PropertyWrapper{name='Vector3D', typeName='Vector3D', docu='null', type=Vector3D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Vector3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Vector3D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Vector3D> Vector3D = new javafx.beans.property.SimpleObjectProperty<Vector3D>();

    @XmlElement(name = "Vector3D", required = true)
    public Vector3D getVector3D() {
        return this.Vector3D.get();
    }
    public void setVector3D( Vector3D value) {
        this.Vector3D.set( value);
    }




    // Property SweepLength
    // PropertyWrapper{name='SweepLength', typeName='SweepLength', docu='null', type=SweepLength, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SweepLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SweepLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SweepLength> SweepLength = new javafx.beans.property.SimpleObjectProperty<SweepLength>();

    @XmlElement(name = "SweepLength", required = true)
    public SweepLength getSweepLength() {
        return this.SweepLength.get();
    }
    public void setSweepLength( SweepLength value) {
        this.SweepLength.set( value);
    }




    // end the properties serialised to elements




      public SweepT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
