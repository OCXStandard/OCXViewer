
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ClassCatalogue_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the Class catalogues provided as part of the OCX.
 *  

*/
// ClassCatalogue_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ClassCatalogue_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ClassCatalogueT extends DescriptionBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property MaterialCatalogue
    // PropertyWrapper{name='MaterialCatalogue', typeName='MaterialCatalogue', docu='null', type=MaterialCatalogue, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MaterialCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='MaterialCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MaterialCatalogue' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MaterialCatalogue> MaterialCatalogue = new javafx.beans.property.SimpleObjectProperty<MaterialCatalogue>();

    @XmlElement(name = "MaterialCatalogue", required = true)
    public MaterialCatalogue getMaterialCatalogue() {
        return this.MaterialCatalogue.get();
    }
    public void setMaterialCatalogue( MaterialCatalogue value) {
        this.MaterialCatalogue.set( value);
    }




    // Property XSectionCatalogue
    // PropertyWrapper{name='XSectionCatalogue', typeName='XSectionCatalogue', docu='null', type=XSectionCatalogue, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='XSectionCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='XSectionCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'XSectionCatalogue' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<XSectionCatalogue> XSectionCatalogue = new javafx.beans.property.SimpleObjectProperty<XSectionCatalogue>();

    @XmlElement(name = "XSectionCatalogue", required = false)
    public XSectionCatalogue getXSectionCatalogue() {
        return this.XSectionCatalogue.get();
    }
    public void setXSectionCatalogue( XSectionCatalogue value) {
        this.XSectionCatalogue.set( value);
    }




    // Property HoleShapeCatalogue
    // PropertyWrapper{name='HoleShapeCatalogue', typeName='HoleShapeCatalogue', docu='null', type=HoleShapeCatalogue, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='HoleShapeCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HoleShapeCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'HoleShapeCatalogue' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<HoleShapeCatalogue> HoleShapeCatalogue = new javafx.beans.property.SimpleObjectProperty<HoleShapeCatalogue>();

    @XmlElement(name = "HoleShapeCatalogue", required = false)
    public HoleShapeCatalogue getHoleShapeCatalogue() {
        return this.HoleShapeCatalogue.get();
    }
    public void setHoleShapeCatalogue( HoleShapeCatalogue value) {
        this.HoleShapeCatalogue.set( value);
    }




    // end the properties serialised to elements




      public ClassCatalogueT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
