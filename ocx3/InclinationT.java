
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Inclination_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of inclination of stiffener or member along its trace line (web and flange directions).
 *  

*/
// Inclination_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Inclination_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class InclinationT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property WebDirection
    // PropertyWrapper{name='WebDirection', typeName='WebDirection', docu='null', type=WebDirection, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='WebDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'WebDirection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<WebDirection> WebDirection = new javafx.beans.property.SimpleObjectProperty<WebDirection>();

    @XmlElement(name = "WebDirection", required = true)
    public WebDirection getWebDirection() {
        return this.WebDirection.get();
    }
    public void setWebDirection( WebDirection value) {
        this.WebDirection.set( value);
    }




    // Property FlangeDirection
    // PropertyWrapper{name='FlangeDirection', typeName='FlangeDirection', docu='null', type=FlangeDirection, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FlangeDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeDirection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeDirection> FlangeDirection = new javafx.beans.property.SimpleObjectProperty<FlangeDirection>();

    @XmlElement(name = "FlangeDirection", required = false)
    public FlangeDirection getFlangeDirection() {
        return this.FlangeDirection.get();
    }
    public void setFlangeDirection( FlangeDirection value) {
        this.FlangeDirection.set( value);
    }




    // Property Position
    // PropertyWrapper{name='Position', typeName='Position', docu='null', type=Position, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Position', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Position' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Position> Position = new javafx.beans.property.SimpleObjectProperty<Position>();

    @XmlElement(name = "Position", required = true)
    public Position getPosition() {
        return this.Position.get();
    }
    public void setPosition( Position value) {
        this.Position.set( value);
    }




    // end the properties serialised to elements




      public InclinationT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
