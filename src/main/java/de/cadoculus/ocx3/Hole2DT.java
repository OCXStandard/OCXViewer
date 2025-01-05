
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Hole2D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition for a 2D hole shape defined either by a choice of a parametric hole or a
 * 				contour curve.
 *  

*/
// Hole2D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// NamedEntity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Hole2D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Hole2DT extends NamedEntityT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // ocx:guid => TypeWrapper{name='guid', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type ocx:guid!!!
    /* The 'GUIDRef' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of ocx:guid as String (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? ocx:guid
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> GUIDRef = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "GUIDRef", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "ocx:guid")
    public String getGUIDRef() {
        return this.GUIDRef.get();
    };

    public void setGUIDRef( String value) {
        this.GUIDRef.set( value);

    }
    // end GUIDRef
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ParametricHole2D
    // PropertyWrapper{name='ParametricHole2D', typeName='ParametricHole2D', docu='null', type=ParametricHole2D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ParametricHole2D', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ParametricHole2D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ParametricHole2D> ParametricHole2D = new javafx.beans.property.SimpleObjectProperty<ParametricHole2D>();

    @XmlElement(name = "ParametricHole2D", required = true)
    public ParametricHole2D getParametricHole2D() {
        return this.ParametricHole2D.get();
    }
    public void setParametricHole2D( ParametricHole2D value) {
        this.ParametricHole2D.set( value);
    }




    // Property Contour
    // PropertyWrapper{name='Contour', typeName='Contour', docu='null', type=Contour, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Contour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Contour' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Contour> Contour = new javafx.beans.property.SimpleObjectProperty<Contour>();

    @XmlElement(name = "Contour", required = true)
    public Contour getContour() {
        return this.Contour.get();
    }
    public void setContour( Contour value) {
        this.Contour.set( value);
    }




    // end the properties serialised to elements




      public Hole2DT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
