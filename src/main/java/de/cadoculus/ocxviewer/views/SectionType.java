package de.cadoculus.ocxviewer.views;

import org.ocx_schema.v310rc3.BarSection;

public enum SectionType {
    RECTANGULAR_TUBE("Rectangular Tube"),
    OCTAGON_BAR("Octagonal Bar"),
    SQUARE_BAR("Square Bar"),
    BULB_FLAT("Bulb Flat"),
    FLAT_BAR("Flat Bar"),
    U_BAR("U Bar"),
    I_BAR("I Bar"),
    L_BAR_OF("L Bar OF"),
    Z_BAR("Z Bar"),
    ROUND_BAR("Round Bar"),
    L_BAR("L Bar"),
    T_BAR("T Bar"),
    L_BAR_OW("L Bar OW"),
    HALF_ROUND_BAR("Half Round Bar"),
    HEXAGON_BAR("Hexagon Bar"),
    TUBE("Tube"),
    USER_DEFINED_BAR_SECTION("User Defined Bar Sectrion"),
    UNKNOWN("Unknown");
    private String name;

    public String getName() {
        return name;
    }

    private SectionType(String name) {
        this.name = name;
    }

    public static SectionType getType(BarSection value) {


        //<xs:element ref="ocx:RectangularTube"/>
        if (value.getRectangularTube() != null) {
            return RECTANGULAR_TUBE;
        }
        //<xs:element ref="ocx:OctagonBar"/>
        if (value.getOctagonBar() != null) {
            return OCTAGON_BAR;
        }
        //<xs:element ref="ocx:SquareBar"/>
        if (value.getSquareBar() != null) {
            return SQUARE_BAR;
        }
        //<xs:element ref="ocx:BulbFlat"/>
        if (value.getBulbFlat() != null) {
            return BULB_FLAT;
        }
        //<xs:element ref="ocx:FlatBar"/>
        if (value.getFlatBar() != null) {
            return FLAT_BAR;
        }
        //<xs:element ref="ocx:UBar"/>
        if (value.getUBar() != null) {
            return U_BAR;
        }
        //<xs:element ref="ocx:IBar"/>
        if (value.getIBar() != null) {
            return I_BAR;
        }
        //<xs:element ref="ocx:LBarOF"/>
        if (value.getLBarOF() != null) {
            return L_BAR_OF;
        }
        //<xs:element ref="ocx:ZBar"/>
        if (value.getZBar() != null) {
            return Z_BAR;
        }
        //<xs:element ref="ocx:RoundBar"/>
        if (value.getRoundBar() != null) {
            return ROUND_BAR;
        }
        //<xs:element ref="ocx:LBar"/>
        if (value.getLBar() != null) {
            return L_BAR;
        }
        //<xs:element ref="ocx:TBar"/>
        if (value.getTBar() != null) {
            return T_BAR;
        }
        //<xs:element ref="ocx:LBarOW"/>
        if (value.getLBarOW() != null) {
            return L_BAR_OW;
        }
        //<xs:element ref="ocx:HalfRoundBar"/>
        if (value.getHalfRoundBar() != null) {
            return HALF_ROUND_BAR;
        }
        //<xs:element ref="ocx:HexagonBar"/>
        if (value.getHexagonBar() != null) {
            return HEXAGON_BAR;
        }
        //<xs:element ref="ocx:Tube"/>
        if (value.getTube() != null) {
            return TUBE;
        }

        if (value.getUserDefinedBarSection() != null) {
            return USER_DEFINED_BAR_SECTION;
        }
        return UNKNOWN;
    }
}
