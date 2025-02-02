
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CompartmentProperties_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the physical properties of a compartment volume (COG, air pipe top).
 *  

*/
// CompartmentProperties_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CompartmentProperties_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CompartmentPropertiesT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CenterOfGravity
    // PropertyWrapper{name='CenterOfGravity', typeName='CenterOfGravity', docu='null', type=CenterOfGravity, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CenterOfGravity', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CenterOfGravity' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CenterOfGravity> CenterOfGravity = new javafx.beans.property.SimpleObjectProperty<CenterOfGravity>();

    @XmlElement(name = "CenterOfGravity", required = true)
    public CenterOfGravity getCenterOfGravity() {
        return this.CenterOfGravity.get();
    }
    public void setCenterOfGravity( CenterOfGravity value) {
        this.CenterOfGravity.set( value);
    }




    // Property Volume
    // PropertyWrapper{name='Volume', typeName='Volume', docu='null', type=Volume, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Volume', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Volume' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Volume> Volume = new javafx.beans.property.SimpleObjectProperty<Volume>();

    @XmlElement(name = "Volume", required = true)
    public Volume getVolume() {
        return this.Volume.get();
    }
    public void setVolume( Volume value) {
        this.Volume.set( value);
    }




    // Property AirPipeHeight
    // PropertyWrapper{name='AirPipeHeight', typeName='AirPipeHeight', docu='null', type=AirPipeHeight, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='AirPipeHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'AirPipeHeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<AirPipeHeight> AirPipeHeight = new javafx.beans.property.SimpleObjectProperty<AirPipeHeight>();

    @XmlElement(name = "AirPipeHeight", required = false)
    public AirPipeHeight getAirPipeHeight() {
        return this.AirPipeHeight.get();
    }
    public void setAirPipeHeight( AirPipeHeight value) {
        this.AirPipeHeight.set( value);
    }




    // Property FillingHeight
    // PropertyWrapper{name='FillingHeight', typeName='FillingHeight', docu='null', type=FillingHeight, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FillingHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FillingHeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FillingHeight> FillingHeight = new javafx.beans.property.SimpleObjectProperty<FillingHeight>();

    @XmlElement(name = "FillingHeight", required = false)
    public FillingHeight getFillingHeight() {
        return this.FillingHeight.get();
    }
    public void setFillingHeight( FillingHeight value) {
        this.FillingHeight.set( value);
    }




    // Property ReliefValvePressure
    // PropertyWrapper{name='ReliefValvePressure', typeName='ReliefValvePressure', docu='null', type=ReliefValvePressure, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ReliefValvePressure', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ReliefValvePressure' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ReliefValvePressure> ReliefValvePressure = new javafx.beans.property.SimpleObjectProperty<ReliefValvePressure>();

    @XmlElement(name = "ReliefValvePressure", required = false)
    public ReliefValvePressure getReliefValvePressure() {
        return this.ReliefValvePressure.get();
    }
    public void setReliefValvePressure( ReliefValvePressure value) {
        this.ReliefValvePressure.set( value);
    }




    // end the properties serialised to elements




      public CompartmentPropertiesT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
