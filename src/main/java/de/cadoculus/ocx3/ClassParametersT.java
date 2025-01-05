
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ClassParameters_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Information that specifies design and intended performance characteristics of the ship in
 * 				accordance with classification society rules and statutory regulations (see ISO
 * 				10303-218, section 4.2.36).
 *  

*/
// ClassParameters_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ClassParameters_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ClassParametersT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='blockCoefficientClass', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'blockCoefficientClass' value serialised as  XML attribute.
    * <summary>
    * The ratio of the moulded displacement volume to the volume of a block that has its
    * 					length equal to the length class, its breadth equal to the moulded breadth and its depth equal
    * 					to the scantlings draught (see ISO 10303-218, section 4.2.32.1).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty BlockCoefficientClass = new SimpleDoubleProperty();

    @XmlAttribute(name = "blockCoefficientClass", required = true)
    @XmlSchemaType(name = "xs:double")
    public double getBlockCoefficientClass() {
        return this.BlockCoefficientClass.get();
    };

    public void setBlockCoefficientClass( double value) {
        this.BlockCoefficientClass.set( value);

    }
    // end blockCoefficientClass

    // AttributeWrapper{name='designSpeedAhead', typeName='xs:double', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'designSpeedAhead' value serialised as  XML attribute.
    * <summary>
    * The forward speed at which the ship is designed to operate (see ISO 10303-218, section
    * 					4.2.32.2).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty DesignSpeedAhead = new SimpleDoubleProperty();

    @XmlAttribute(name = "designSpeedAhead", required = false)
    @XmlSchemaType(name = "xs:double")
    public double getDesignSpeedAhead() {
        return this.DesignSpeedAhead.get();
    };

    public void setDesignSpeedAhead( double value) {
        this.DesignSpeedAhead.set( value);

    }
    // end designSpeedAhead

    // AttributeWrapper{name='designSpeedAstern', typeName='xs:double', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'designSpeedAstern' value serialised as  XML attribute.
    * <summary>
    * The reverse speed at which the ship is designed to operate (see ISO 10303-218, section
    * 					4.2.32.3).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty DesignSpeedAstern = new SimpleDoubleProperty();

    @XmlAttribute(name = "designSpeedAstern", required = false)
    @XmlSchemaType(name = "xs:double")
    public double getDesignSpeedAstern() {
        return this.DesignSpeedAstern.get();
    };

    public void setDesignSpeedAstern( double value) {
        this.DesignSpeedAstern.set( value);

    }
    // end designSpeedAstern

    // AttributeWrapper{name='lengthSolas', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'lengthSolas' value serialised as  XML attribute.
    * <summary>
    * A length measurement for the ship measured in accordance with IMO IC110E (see ISO
    * 					10303-218, section 4.2.32.5).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty LengthSolas = new SimpleDoubleProperty();

    @XmlAttribute(name = "lengthSolas", required = true)
    @XmlSchemaType(name = "xs:double")
    public double getLengthSolas() {
        return this.LengthSolas.get();
    };

    public void setLengthSolas( double value) {
        this.LengthSolas.set( value);

    }
    // end lengthSolas

    // AttributeWrapper{name='lengthClass', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'lengthClass' value serialised as  XML attribute.
    * <summary>
    * A length measurement for the ship that is defined in classification society rules (see
    * 					ISO 10303-218, section 4.2.32.4).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty LengthClass = new SimpleDoubleProperty();

    @XmlAttribute(name = "lengthClass", required = true)
    @XmlSchemaType(name = "xs:double")
    public double getLengthClass() {
        return this.LengthClass.get();
    };

    public void setLengthClass( double value) {
        this.LengthClass.set( value);

    }
    // end lengthClass

    // AttributeWrapper{name='scantlingsDraught', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'scantlingsDraught' value serialised as  XML attribute.
    * <summary>
    * The summer load draught used by the classification society in its calculations for
    * 					structural integrity and strength (see ISO 10303-218, section 4.2.32.6).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty ScantlingsDraught = new SimpleDoubleProperty();

    @XmlAttribute(name = "scantlingsDraught", required = true)
    @XmlSchemaType(name = "xs:double")
    public double getScantlingsDraught() {
        return this.ScantlingsDraught.get();
    };

    public void setScantlingsDraught( double value) {
        this.ScantlingsDraught.set( value);

    }
    // end scantlingsDraught
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ClassParametersT() {
          try {






         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
