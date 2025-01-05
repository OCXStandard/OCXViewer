
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>NURBS3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a Non-uniform rational basis spline (NURBS) curve defined by a set of
 * 				3D control points.
 *  

*/
// NURBS3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "NURBS3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class NURBS3DT extends Curve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property NURBSproperties
    // PropertyWrapper{name='NURBSproperties', typeName='NURBSproperties', docu='null', type=NURBSproperties, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='NURBSproperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'NURBSproperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<NURBSproperties> NURBSproperties = new javafx.beans.property.SimpleObjectProperty<NURBSproperties>();

    @XmlElement(name = "NURBSproperties", required = true)
    public NURBSproperties getNURBSproperties() {
        return this.NURBSproperties.get();
    }
    public void setNURBSproperties( NURBSproperties value) {
        this.NURBSproperties.set( value);
    }




    // Property KnotVector
    // PropertyWrapper{name='KnotVector', typeName='KnotVector', docu='null', type=KnotVector, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='KnotVector', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='KnotVector_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'KnotVector' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<KnotVector> KnotVector = new javafx.beans.property.SimpleObjectProperty<KnotVector>();

    @XmlElement(name = "KnotVector", required = true)
    public KnotVector getKnotVector() {
        return this.KnotVector.get();
    }
    public void setKnotVector( KnotVector value) {
        this.KnotVector.set( value);
    }




    // Property ControlPtList
    // PropertyWrapper{name='ControlPtList', typeName='ControlPtList', docu='null', type=ControlPtList, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ControlPtList', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ControlPtList_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ControlPtList' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ControlPtList> ControlPtList = new javafx.beans.property.SimpleObjectProperty<ControlPtList>();

    @XmlElement(name = "ControlPtList", required = true)
    public ControlPtList getControlPtList() {
        return this.ControlPtList.get();
    }
    public void setControlPtList( ControlPtList value) {
        this.ControlPtList.set( value);
    }




    // end the properties serialised to elements




      public NURBS3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
