
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CircumCircle3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a circle in 3D space defined by a circumscribed position of 3 points.
 *  

*/
// CircumCircle3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CircumCircle3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CircumCircle3DT extends Curve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Positions
    // PropertyWrapper{name='Positions', typeName='Positions', docu='null', type=Positions, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Positions', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Positions_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Positions' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Positions> Positions = new javafx.beans.property.SimpleObjectProperty<Positions>();

    @XmlElement(name = "Positions", required = true)
    public Positions getPositions() {
        return this.Positions.get();
    }
    public void setPositions( Positions value) {
        this.Positions.set( value);
    }




    // end the properties serialised to elements




      public CircumCircle3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
