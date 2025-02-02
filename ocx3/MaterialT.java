
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Material_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a Material with physical properties.
 *  

*/
// Material_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// NamedEntity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Material_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class MaterialT extends NamedEntityT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='grade', typeName='grade', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // grade => TypeWrapper{name='grade', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use GradeEnum
    // Java Type , GradeEnum Type Adapter !!!typeAdapter unmapped type grade!!!
    /* The 'grade' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of grade as GradeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? grade
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<GradeEnum> Grade = new  javafx.beans.property.SimpleObjectProperty<GradeEnum>();

    @XmlAttribute(name = "grade", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "grade")
    public GradeEnum getGrade() {
        return this.Grade.get();
    };

    public void setGrade( GradeEnum value) {
        this.Grade.set( value);

    }
    // end grade

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
    // Property Density
    // PropertyWrapper{name='Density', typeName='Density', docu='null', type=Density, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Density', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Density' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Density> Density = new javafx.beans.property.SimpleObjectProperty<Density>();

    @XmlElement(name = "Density", required = true)
    public Density getDensity() {
        return this.Density.get();
    }
    public void setDensity( Density value) {
        this.Density.set( value);
    }




    // Property YoungsModulus
    // PropertyWrapper{name='YoungsModulus', typeName='YoungsModulus', docu='null', type=YoungsModulus, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='YoungsModulus', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'YoungsModulus' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<YoungsModulus> YoungsModulus = new javafx.beans.property.SimpleObjectProperty<YoungsModulus>();

    @XmlElement(name = "YoungsModulus", required = true)
    public YoungsModulus getYoungsModulus() {
        return this.YoungsModulus.get();
    }
    public void setYoungsModulus( YoungsModulus value) {
        this.YoungsModulus.set( value);
    }




    // Property PoissonRatio
    // PropertyWrapper{name='PoissonRatio', typeName='PoissonRatio', docu='null', type=PoissonRatio, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PoissonRatio', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PoissonRatio' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PoissonRatio> PoissonRatio = new javafx.beans.property.SimpleObjectProperty<PoissonRatio>();

    @XmlElement(name = "PoissonRatio", required = true)
    public PoissonRatio getPoissonRatio() {
        return this.PoissonRatio.get();
    }
    public void setPoissonRatio( PoissonRatio value) {
        this.PoissonRatio.set( value);
    }




    // Property YieldStress
    // PropertyWrapper{name='YieldStress', typeName='YieldStress', docu='null', type=YieldStress, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='YieldStress', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'YieldStress' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<YieldStress> YieldStress = new javafx.beans.property.SimpleObjectProperty<YieldStress>();

    @XmlElement(name = "YieldStress", required = true)
    public YieldStress getYieldStress() {
        return this.YieldStress.get();
    }
    public void setYieldStress( YieldStress value) {
        this.YieldStress.set( value);
    }




    // Property UltimateStress
    // PropertyWrapper{name='UltimateStress', typeName='UltimateStress', docu='null', type=UltimateStress, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UltimateStress', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UltimateStress' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UltimateStress> UltimateStress = new javafx.beans.property.SimpleObjectProperty<UltimateStress>();

    @XmlElement(name = "UltimateStress", required = true)
    public UltimateStress getUltimateStress() {
        return this.UltimateStress.get();
    }
    public void setUltimateStress( UltimateStress value) {
        this.UltimateStress.set( value);
    }




    // Property ThermalExpansionCoefficient
    // PropertyWrapper{name='ThermalExpansionCoefficient', typeName='ThermalExpansionCoefficient', docu='null', type=ThermalExpansionCoefficient, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ThermalExpansionCoefficient', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ThermalExpansionCoefficient' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ThermalExpansionCoefficient> ThermalExpansionCoefficient = new javafx.beans.property.SimpleObjectProperty<ThermalExpansionCoefficient>();

    @XmlElement(name = "ThermalExpansionCoefficient", required = false)
    public ThermalExpansionCoefficient getThermalExpansionCoefficient() {
        return this.ThermalExpansionCoefficient.get();
    }
    public void setThermalExpansionCoefficient( ThermalExpansionCoefficient value) {
        this.ThermalExpansionCoefficient.set( value);
    }




    // end the properties serialised to elements




      public MaterialT() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
