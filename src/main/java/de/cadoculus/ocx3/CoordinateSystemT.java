
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CoordinateSystem_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the vessel coordinate system A right-handed orthogonal Cartesian
 * 				coordinate system.
 *  

*/
// CoordinateSystem_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CoordinateSystem_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CoordinateSystemT extends EntityBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='isGlobal', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='true', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'isGlobal' value serialised as  XML attribute.
    * <summary>
    * If set to true, the coordinate system is the global world coordinate frame
    * 							with right-handed convention. This is the default.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty IsGlobal = new SimpleBooleanProperty();

    @XmlAttribute(name = "isGlobal", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getIsGlobal() {
        return this.IsGlobal.get();
    };

    public void setIsGlobal( boolean value) {
        this.IsGlobal.set( value);

    }
    // end isGlobal
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property XRefPlanes
    // PropertyWrapper{name='XRefPlanes', typeName='XRefPlanes', docu='null', type=XRefPlanes, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='XRefPlanes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlanes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='DistanceToAP', typeName='DistanceToAP', docu='null', type=DistanceToAP, minOccurs=0, maxOccurs=1}]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'XRefPlanes' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<XRefPlanes> XRefPlanes = new javafx.beans.property.SimpleObjectProperty<XRefPlanes>();

    @XmlElement(name = "XRefPlanes", required = true)
    public XRefPlanes getXRefPlanes() {
        return this.XRefPlanes.get();
    }
    public void setXRefPlanes( XRefPlanes value) {
        this.XRefPlanes.set( value);
    }




    // Property YRefPlanes
    // PropertyWrapper{name='YRefPlanes', typeName='YRefPlanes', docu='null', type=YRefPlanes, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='YRefPlanes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlanes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'YRefPlanes' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<YRefPlanes> YRefPlanes = new javafx.beans.property.SimpleObjectProperty<YRefPlanes>();

    @XmlElement(name = "YRefPlanes", required = false)
    public YRefPlanes getYRefPlanes() {
        return this.YRefPlanes.get();
    }
    public void setYRefPlanes( YRefPlanes value) {
        this.YRefPlanes.set( value);
    }




    // Property ZRefPlanes
    // PropertyWrapper{name='ZRefPlanes', typeName='ZRefPlanes', docu='null', type=ZRefPlanes, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ZRefPlanes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlanes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ZRefPlanes' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ZRefPlanes> ZRefPlanes = new javafx.beans.property.SimpleObjectProperty<ZRefPlanes>();

    @XmlElement(name = "ZRefPlanes", required = false)
    public ZRefPlanes getZRefPlanes() {
        return this.ZRefPlanes.get();
    }
    public void setZRefPlanes( ZRefPlanes value) {
        this.ZRefPlanes.set( value);
    }




    // Property LocalCartesian
    // PropertyWrapper{name='LocalCartesian', typeName='LocalCartesian', docu='null', type=LocalCartesian, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='LocalCartesian', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Transformation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LocalCartesian' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LocalCartesian> LocalCartesian = new javafx.beans.property.SimpleObjectProperty<LocalCartesian>();

    @XmlElement(name = "LocalCartesian", required = false)
    public LocalCartesian getLocalCartesian() {
        return this.LocalCartesian.get();
    }
    public void setLocalCartesian( LocalCartesian value) {
        this.LocalCartesian.set( value);
    }




    // end the properties serialised to elements




      public CoordinateSystemT() {
          try {
          // attr isGlobal with default value 'true', type boolean
           IsGlobal.set( Boolean.parseBoolean("true"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
