
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>TraceLine_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The type definition of the stiffener TraceLine.
 *  

*/
// TraceLine_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "TraceLine_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class TraceLineT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CompositeCurve3D
    // PropertyWrapper{name='CompositeCurve3D', typeName='CompositeCurve3D', docu='null', type=CompositeCurve3D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CompositeCurve3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CompositeCurve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CompositeCurve3D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CompositeCurve3D> CompositeCurve3D = new javafx.beans.property.SimpleObjectProperty<CompositeCurve3D>();

    @XmlElement(name = "CompositeCurve3D", required = true)
    public CompositeCurve3D getCompositeCurve3D() {
        return this.CompositeCurve3D.get();
    }
    public void setCompositeCurve3D( CompositeCurve3D value) {
        this.CompositeCurve3D.set( value);
    }




    // end the properties serialised to elements




      public TraceLineT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
