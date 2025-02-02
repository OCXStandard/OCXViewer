
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>NURBSSurface_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a Non-uniform rational basis surface definition defined by a grid of 3D
 * 				control points.
 *  

*/
// NURBSSurface_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Surface_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "NURBSSurface_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class NURBSSurfaceT extends SurfaceT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property U_NURBSproperties
    // PropertyWrapper{name='U_NURBSproperties', typeName='U_NURBSproperties', docu='null', type=U_NURBSproperties, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='U_NURBSproperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'U_NURBSproperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UNURBSproperties> UNURBSproperties = new javafx.beans.property.SimpleObjectProperty<UNURBSproperties>();

    @XmlElement(name = "U_NURBSproperties", required = true)
    public UNURBSproperties getUNURBSproperties() {
        return this.UNURBSproperties.get();
    }
    public void setUNURBSproperties( UNURBSproperties value) {
        this.UNURBSproperties.set( value);
    }




    // Property UknotVector
    // PropertyWrapper{name='UknotVector', typeName='UknotVector', docu='null', type=UknotVector, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UknotVector', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='KnotVector_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UknotVector' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UknotVector> UknotVector = new javafx.beans.property.SimpleObjectProperty<UknotVector>();

    @XmlElement(name = "UknotVector", required = true)
    public UknotVector getUknotVector() {
        return this.UknotVector.get();
    }
    public void setUknotVector( UknotVector value) {
        this.UknotVector.set( value);
    }




    // Property V_NURBSproperties
    // PropertyWrapper{name='V_NURBSproperties', typeName='V_NURBSproperties', docu='null', type=V_NURBSproperties, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='V_NURBSproperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'V_NURBSproperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<VNURBSproperties> VNURBSproperties = new javafx.beans.property.SimpleObjectProperty<VNURBSproperties>();

    @XmlElement(name = "V_NURBSproperties", required = true)
    public VNURBSproperties getVNURBSproperties() {
        return this.VNURBSproperties.get();
    }
    public void setVNURBSproperties( VNURBSproperties value) {
        this.VNURBSproperties.set( value);
    }




    // Property VknotVector
    // PropertyWrapper{name='VknotVector', typeName='VknotVector', docu='null', type=VknotVector, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='VknotVector', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='KnotVector_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'VknotVector' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<VknotVector> VknotVector = new javafx.beans.property.SimpleObjectProperty<VknotVector>();

    @XmlElement(name = "VknotVector", required = true)
    public VknotVector getVknotVector() {
        return this.VknotVector.get();
    }
    public void setVknotVector( VknotVector value) {
        this.VknotVector.set( value);
    }




    // Property ControlPtList
    // PropertyWrapper{name='ControlPtList', typeName='ControlPtList', docu='null', type=ControlPtList, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='ControlPtList', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ControlPtList_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ControlPtList' property serialised as  XML elemenmt.
    * 
    */

    private List<ControlPtList> controlPtLists = new ArrayList<>();

    public List<ControlPtList> getControlPtList() {
        return controlPtLists;
    }




    // end the properties serialised to elements




      public NURBSSurfaceT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
