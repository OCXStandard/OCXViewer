
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>EndCut_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of stiffener end cut parameters.
 *  

*/
// EndCut_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "EndCut_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class EndCutT extends DescriptionBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='symmetricFlange', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'symmetricFlange' value serialised as  XML attribute.
    * <summary>
    * The end cut is symmetrical.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty SymmetricFlange = new SimpleBooleanProperty();

    @XmlAttribute(name = "symmetricFlange", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getSymmetricFlange() {
        return this.SymmetricFlange.get();
    };

    public void setSymmetricFlange( boolean value) {
        this.SymmetricFlange.set( value);

    }
    // end symmetricFlange

    // AttributeWrapper{name='sniped', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'sniped' value serialised as  XML attribute.
    * <summary>
    * The stiffener is sniped.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty Sniped = new SimpleBooleanProperty();

    @XmlAttribute(name = "sniped", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getSniped() {
        return this.Sniped.get();
    };

    public void setSniped( boolean value) {
        this.Sniped.set( value);

    }
    // end sniped
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CutbackDistance
    // PropertyWrapper{name='CutbackDistance', typeName='CutbackDistance', docu='null', type=CutbackDistance, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CutbackDistance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CutbackDistance' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CutbackDistance> CutbackDistance = new javafx.beans.property.SimpleObjectProperty<CutbackDistance>();

    @XmlElement(name = "CutbackDistance", required = true)
    public CutbackDistance getCutbackDistance() {
        return this.CutbackDistance.get();
    }
    public void setCutbackDistance( CutbackDistance value) {
        this.CutbackDistance.set( value);
    }




    // Property WebCutBackAngle
    // PropertyWrapper{name='WebCutBackAngle', typeName='WebCutBackAngle', docu='null', type=WebCutBackAngle, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='WebCutBackAngle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'WebCutBackAngle' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<WebCutBackAngle> WebCutBackAngle = new javafx.beans.property.SimpleObjectProperty<WebCutBackAngle>();

    @XmlElement(name = "WebCutBackAngle", required = true)
    public WebCutBackAngle getWebCutBackAngle() {
        return this.WebCutBackAngle.get();
    }
    public void setWebCutBackAngle( WebCutBackAngle value) {
        this.WebCutBackAngle.set( value);
    }




    // Property WebNoseHeight
    // PropertyWrapper{name='WebNoseHeight', typeName='WebNoseHeight', docu='null', type=WebNoseHeight, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='WebNoseHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'WebNoseHeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<WebNoseHeight> WebNoseHeight = new javafx.beans.property.SimpleObjectProperty<WebNoseHeight>();

    @XmlElement(name = "WebNoseHeight", required = false)
    public WebNoseHeight getWebNoseHeight() {
        return this.WebNoseHeight.get();
    }
    public void setWebNoseHeight( WebNoseHeight value) {
        this.WebNoseHeight.set( value);
    }




    // Property FlangeCutBackAngle
    // PropertyWrapper{name='FlangeCutBackAngle', typeName='FlangeCutBackAngle', docu='null', type=FlangeCutBackAngle, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FlangeCutBackAngle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeCutBackAngle' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeCutBackAngle> FlangeCutBackAngle = new javafx.beans.property.SimpleObjectProperty<FlangeCutBackAngle>();

    @XmlElement(name = "FlangeCutBackAngle", required = false)
    public FlangeCutBackAngle getFlangeCutBackAngle() {
        return this.FlangeCutBackAngle.get();
    }
    public void setFlangeCutBackAngle( FlangeCutBackAngle value) {
        this.FlangeCutBackAngle.set( value);
    }




    // Property FlangeNoseHeight
    // PropertyWrapper{name='FlangeNoseHeight', typeName='FlangeNoseHeight', docu='null', type=FlangeNoseHeight, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FlangeNoseHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeNoseHeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeNoseHeight> FlangeNoseHeight = new javafx.beans.property.SimpleObjectProperty<FlangeNoseHeight>();

    @XmlElement(name = "FlangeNoseHeight", required = false)
    public FlangeNoseHeight getFlangeNoseHeight() {
        return this.FlangeNoseHeight.get();
    }
    public void setFlangeNoseHeight( FlangeNoseHeight value) {
        this.FlangeNoseHeight.set( value);
    }




    // Property FeatureCope
    // PropertyWrapper{name='FeatureCope', typeName='FeatureCope', docu='null', type=FeatureCope, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FeatureCope', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FeatureCope_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FeatureCope' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FeatureCope> FeatureCope = new javafx.beans.property.SimpleObjectProperty<FeatureCope>();

    @XmlElement(name = "FeatureCope", required = false)
    public FeatureCope getFeatureCope() {
        return this.FeatureCope.get();
    }
    public void setFeatureCope( FeatureCope value) {
        this.FeatureCope.set( value);
    }




    // end the properties serialised to elements




      public EndCutT() {
          try {
          // attr symmetricFlange with default value 'false', type boolean
           SymmetricFlange.set( Boolean.parseBoolean("false"));
 
          // attr sniped with default value 'false', type boolean
           Sniped.set( Boolean.parseBoolean("false"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
