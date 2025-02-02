
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Hole2DContour_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Parametric or curve based 2D contours.
 *  

*/
// Hole2DContour_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// GeometryRepresentation_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Hole2DContour_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Hole2DContourT extends GeometryRepresentationT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property HoleRef
    // PropertyWrapper{name='HoleRef', typeName='HoleRef', docu='null', type=HoleRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='HoleRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HoleRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'HoleRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<HoleRef> HoleRef = new javafx.beans.property.SimpleObjectProperty<HoleRef>();

    @XmlElement(name = "HoleRef", required = true)
    public HoleRef getHoleRef() {
        return this.HoleRef.get();
    }
    public void setHoleRef( HoleRef value) {
        this.HoleRef.set( value);
    }




    // Property Transformation
    // PropertyWrapper{name='Transformation', typeName='Transformation', docu='null', type=Transformation, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Transformation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Transformation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Transformation' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Transformation> Transformation = new javafx.beans.property.SimpleObjectProperty<Transformation>();

    @XmlElement(name = "Transformation", required = true)
    public Transformation getTransformation() {
        return this.Transformation.get();
    }
    public void setTransformation( Transformation value) {
        this.Transformation.set( value);
    }




    // end the properties serialised to elements




      public Hole2DContourT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
