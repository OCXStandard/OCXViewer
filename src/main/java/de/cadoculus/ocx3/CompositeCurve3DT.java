
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CompositeCurve3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a composite curve composed of a collection of Line3D, CircumArc3D and/or NURBS segments..
 *  

*/
// CompositeCurve3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CompositeCurve3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CompositeCurve3DT extends Curve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property PolyLine3D
    // PropertyWrapper{name='PolyLine3D', typeName='PolyLine3D', docu='null', type=PolyLine3D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PolyLine3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PolyLine3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PolyLine3D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PolyLine3D> PolyLine3D = new javafx.beans.property.SimpleObjectProperty<PolyLine3D>();

    @XmlElement(name = "PolyLine3D", required = true)
    public PolyLine3D getPolyLine3D() {
        return this.PolyLine3D.get();
    }
    public void setPolyLine3D( PolyLine3D value) {
        this.PolyLine3D.set( value);
    }




    // Property Line3D
    // PropertyWrapper{name='Line3D', typeName='Line3D', docu='null', type=Line3D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Line3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Line3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Line3D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Line3D> Line3D = new javafx.beans.property.SimpleObjectProperty<Line3D>();

    @XmlElement(name = "Line3D", required = true)
    public Line3D getLine3D() {
        return this.Line3D.get();
    }
    public void setLine3D( Line3D value) {
        this.Line3D.set( value);
    }




    // Property NURBS3D
    // PropertyWrapper{name='NURBS3D', typeName='NURBS3D', docu='null', type=NURBS3D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='NURBS3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBS3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'NURBS3D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<NURBS3D> NURBS3D = new javafx.beans.property.SimpleObjectProperty<NURBS3D>();

    @XmlElement(name = "NURBS3D", required = true)
    public NURBS3D getNURBS3D() {
        return this.NURBS3D.get();
    }
    public void setNURBS3D( NURBS3D value) {
        this.NURBS3D.set( value);
    }




    // Property CircumArc3D
    // PropertyWrapper{name='CircumArc3D', typeName='CircumArc3D', docu='null', type=CircumArc3D, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CircumArc3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CircumArc3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CircumArc3D' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CircumArc3D> CircumArc3D = new javafx.beans.property.SimpleObjectProperty<CircumArc3D>();

    @XmlElement(name = "CircumArc3D", required = true)
    public CircumArc3D getCircumArc3D() {
        return this.CircumArc3D.get();
    }
    public void setCircumArc3D( CircumArc3D value) {
        this.CircumArc3D.set( value);
    }




    // end the properties serialised to elements




      public CompositeCurve3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
