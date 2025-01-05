
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import de.cadoculus.unitsml.Unit;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Quantity_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the abstract base class for all types with values carrying a Unit : Q =
 * 				v * u.
 *  

*/
// Quantity_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Quantity_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class QuantityT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='numericvalue', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'numericvalue' value serialised as  XML attribute.
    * <summary>
    * The numerical value of the quantity.</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty Numericvalue = new SimpleDoubleProperty();

    @XmlAttribute(name = "numericvalue", required = true)
    @XmlSchemaType(name = "xs:double")
    public double getNumericvalue() {
        return this.Numericvalue.get();
    };

    public void setNumericvalue( double value) {
        this.Numericvalue.set( value);

    }
    // end numericvalue

    // AttributeWrapper{name='unit', typeName='xs:IDREF', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:IDREF => TypeWrapper{name='IDREF', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:IDREF!!!
    /* The 'unit' value serialised as  XML attribute.
    * <summary>
    * The reference to the unitsML reference unit.</summary>
    */
    // contains the String serialised form of xs:IDREF as String ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> UnitId = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "unit", required = true)
    @XmlSchemaType(name = "xs:IDREF")
    public String getUnitId() {
        return this.UnitId.get();
    };

    public void setUnitId( String value) {
        this.UnitId.set( value);

    }
    // end unit
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



	// from QuantityT.ftl
    @XmlTransient
    public javafx.beans.property.ObjectProperty<de.cadoculus.unitsml.Unit> Unit = new javafx.beans.property.SimpleObjectProperty<Unit>();

    @XmlTransient
    public void setUnit( Unit unit) {
         this.Unit.set(unit);

    }
    @XmlTransient
    public Unit getUnit( ) {
        return this.Unit.get();
    }

    protected QuantityT( )
    {
    }

    protected QuantityT(double value , String unitId)
    {
        this.Numericvalue.set( value);
        this.UnitId.set( unitId);
    }
    protected QuantityT(double value , Unit u)
    {
        this.Numericvalue.set( value);
        this.Unit.set(u);
        this.UnitId.set( u != null ? u.getId() : null);
    }

    @Override
    public String toString()
    {
        return String.format(java.util.Locale.US, "%s %s %.2f", this.getClass().getName(), UnitId.get(), Numericvalue.get());
    }

    public double As(Unit targetUnit)
    {
        // TODO: return BaseClass.As(Numericvalue, Unit, targetUnit);
        return 0.0;
    }



    // end QuantityT.ftl

}
