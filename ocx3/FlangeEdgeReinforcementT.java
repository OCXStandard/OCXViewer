
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FlangeEdgeReinforcement_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// FlangeEdgeReinforcement_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FlangeEdgeReinforcement_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class FlangeEdgeReinforcementT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property FlangeWidth
    // PropertyWrapper{name='FlangeWidth', typeName='FlangeWidth', docu='null', type=FlangeWidth, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='FlangeWidth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeWidth' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeWidth> FlangeWidth = new javafx.beans.property.SimpleObjectProperty<FlangeWidth>();

    @XmlElement(name = "FlangeWidth", required = true)
    public FlangeWidth getFlangeWidth() {
        return this.FlangeWidth.get();
    }
    public void setFlangeWidth( FlangeWidth value) {
        this.FlangeWidth.set( value);
    }




    // Property Radius
    // PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Radius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Radius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Radius> Radius = new javafx.beans.property.SimpleObjectProperty<Radius>();

    @XmlElement(name = "Radius", required = true)
    public Radius getRadius() {
        return this.Radius.get();
    }
    public void setRadius( Radius value) {
        this.Radius.set( value);
    }




    // end the properties serialised to elements




      public FlangeEdgeReinforcementT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
