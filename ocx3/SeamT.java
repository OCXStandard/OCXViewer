
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Seam_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the Seam element describing plate seams.
 *  

*/
// Seam_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Seam_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SeamT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property TraceLine
    // PropertyWrapper{name='TraceLine', typeName='TraceLine', docu='null', type=TraceLine, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='TraceLine', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TraceLine_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'TraceLine' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<TraceLine> TraceLine = new javafx.beans.property.SimpleObjectProperty<TraceLine>();

    @XmlElement(name = "TraceLine", required = false)
    public TraceLine getTraceLine() {
        return this.TraceLine.get();
    }
    public void setTraceLine( TraceLine value) {
        this.TraceLine.set( value);
    }




    // end the properties serialised to elements




      public SeamT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
