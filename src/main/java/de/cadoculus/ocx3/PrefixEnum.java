package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'prefixEnum' enumeration.
 */
@XmlType(name = " prefixEnum")
@XmlEnum(String.class)
public enum  PrefixEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Y") Y,
    @XmlEnumValue("Z") Z,
    @XmlEnumValue("E") E,
    @XmlEnumValue("P") P,
    @XmlEnumValue("T") T,
    @XmlEnumValue("G") G,
    @XmlEnumValue("M") M,
    @XmlEnumValue("k") K_LC,
    @XmlEnumValue("h") H_LC,
    @XmlEnumValue("da") DA_LC,
    @XmlEnumValue("d") D_LC,
    @XmlEnumValue("c") C_LC,
    @XmlEnumValue("m") M_LC,
    @XmlEnumValue("mu") MU_LC,
    @XmlEnumValue("n") N_LC,
    @XmlEnumValue("p") P_LC,
    @XmlEnumValue("f") F_LC,
    @XmlEnumValue("a") A_LC,
    @XmlEnumValue("z") Z_LC,
    @XmlEnumValue("y") Y_LC,
    @XmlEnumValue("Ki") KI,
    @XmlEnumValue("Mi") MI,
    @XmlEnumValue("Gi") GI,
    @XmlEnumValue("Ti") TI,
    @XmlEnumValue("Zi") ZI,
    @XmlEnumValue("Ei") EI,
    @XmlEnumValue("Yi") YI
;

   public static PrefixEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Y".equals( value ) ) { return Y;}
        if ( "Z".equals( value ) ) { return Z;}
        if ( "E".equals( value ) ) { return E;}
        if ( "P".equals( value ) ) { return P;}
        if ( "T".equals( value ) ) { return T;}
        if ( "G".equals( value ) ) { return G;}
        if ( "M".equals( value ) ) { return M;}
        if ( "k".equals( value ) ) { return K_LC;}
        if ( "h".equals( value ) ) { return H_LC;}
        if ( "da".equals( value ) ) { return DA_LC;}
        if ( "d".equals( value ) ) { return D_LC;}
        if ( "c".equals( value ) ) { return C_LC;}
        if ( "m".equals( value ) ) { return M_LC;}
        if ( "mu".equals( value ) ) { return MU_LC;}
        if ( "n".equals( value ) ) { return N_LC;}
        if ( "p".equals( value ) ) { return P_LC;}
        if ( "f".equals( value ) ) { return F_LC;}
        if ( "a".equals( value ) ) { return A_LC;}
        if ( "z".equals( value ) ) { return Z_LC;}
        if ( "y".equals( value ) ) { return Y_LC;}
        if ( "Ki".equals( value ) ) { return KI;}
        if ( "Mi".equals( value ) ) { return MI;}
        if ( "Gi".equals( value ) ) { return GI;}
        if ( "Ti".equals( value ) ) { return TI;}
        if ( "Zi".equals( value ) ) { return ZI;}
        if ( "Ei".equals( value ) ) { return EI;}
        if ( "Yi".equals( value ) ) { return YI;}
        return UNKNOWN_VALUE;
   }

}
