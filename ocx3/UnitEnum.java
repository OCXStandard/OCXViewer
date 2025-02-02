package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'unitEnum' enumeration.
 */
@XmlType(name = " unitEnum")
@XmlEnum(String.class)
public enum  UnitEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("meter") METER_LC,
    @XmlEnumValue("gram") GRAM_LC,
    @XmlEnumValue("second") SECOND_LC,
    @XmlEnumValue("ampere") AMPERE_LC,
    @XmlEnumValue("kelvin") KELVIN_LC,
    @XmlEnumValue("mole") MOLE_LC,
    @XmlEnumValue("candela") CANDELA_LC,
    @XmlEnumValue("radian") RADIAN_LC,
    @XmlEnumValue("steradian") STERADIAN_LC,
    @XmlEnumValue("hertz") HERTZ_LC,
    @XmlEnumValue("newton") NEWTON_LC,
    @XmlEnumValue("pascal") PASCAL_LC,
    @XmlEnumValue("joule") JOULE_LC,
    @XmlEnumValue("watt") WATT_LC,
    @XmlEnumValue("coulomb") COULOMB_LC,
    @XmlEnumValue("volt") VOLT_LC,
    @XmlEnumValue("farad") FARAD_LC,
    @XmlEnumValue("ohm") OHM_LC,
    @XmlEnumValue("siemens") SIEMENS_LC,
    @XmlEnumValue("weber") WEBER_LC,
    @XmlEnumValue("tesla") TESLA_LC,
    @XmlEnumValue("henry") HENRY_LC,
    @XmlEnumValue("degree_Celsius") DEGREE_CELSIUS_LC,
    @XmlEnumValue("lumen") LUMEN_LC,
    @XmlEnumValue("lux") LUX_LC,
    @XmlEnumValue("katal") KATAL_LC,
    @XmlEnumValue("becquerel") BECQUEREL_LC,
    @XmlEnumValue("gray") GRAY_LC,
    @XmlEnumValue("sievert") SIEVERT_LC,
    @XmlEnumValue("minute") MINUTE_LC,
    @XmlEnumValue("hour") HOUR_LC,
    @XmlEnumValue("day") DAY_LC,
    @XmlEnumValue("arc_degree") ARC_DEGREE_LC,
    @XmlEnumValue("arc_minute") ARC_MINUTE_LC,
    @XmlEnumValue("arc_second") ARC_SECOND_LC,
    @XmlEnumValue("liter") LITER_LC,
    @XmlEnumValue("metric_ton") METRIC_TON_LC,
    @XmlEnumValue("electronvolt") ELECTRONVOLT_LC,
    @XmlEnumValue("unified_atomic_mass_unit") UNIFIED_ATOMIC_MASS_UNIT_LC,
    @XmlEnumValue("astronomical_unit") ASTRONOMICAL_UNIT_LC,
    @XmlEnumValue("atomic_unit_of_1st_hyperpolarizablity") ATOMIC_UNIT_OF_1ST_HYPERPOLARIZABLITY_LC,
    @XmlEnumValue("atomic_unit_of_2nd_hyperpolarizablity") ATOMIC_UNIT_OF_2ND_HYPERPOLARIZABLITY_LC,
    @XmlEnumValue("atomic_unit_of_action") ATOMIC_UNIT_OF_ACTION_LC,
    @XmlEnumValue("atomic_unit_of_charge") ATOMIC_UNIT_OF_CHARGE_LC,
    @XmlEnumValue("atomic_unit_of_charge_density") ATOMIC_UNIT_OF_CHARGE_DENSITY_LC,
    @XmlEnumValue("atomic_unit_of_current") ATOMIC_UNIT_OF_CURRENT_LC,
    @XmlEnumValue("atomic_unit_of_electric_dipole_moment") ATOMIC_UNIT_OF_ELECTRIC_DIPOLE_MOMENT_LC,
    @XmlEnumValue("atomic_unit_of_electric_field") ATOMIC_UNIT_OF_ELECTRIC_FIELD_LC,
    @XmlEnumValue("atomic_unit_of_electric_field_gradient") ATOMIC_UNIT_OF_ELECTRIC_FIELD_GRADIENT_LC,
    @XmlEnumValue("atomic_unit_of_electric_polarizablity") ATOMIC_UNIT_OF_ELECTRIC_POLARIZABLITY_LC,
    @XmlEnumValue("atomic_unit_of_electric_potential") ATOMIC_UNIT_OF_ELECTRIC_POTENTIAL_LC,
    @XmlEnumValue("atomic_unit_of_electric_quadrupole_moment") ATOMIC_UNIT_OF_ELECTRIC_QUADRUPOLE_MOMENT_LC,
    @XmlEnumValue("atomic_unit_of_energy") ATOMIC_UNIT_OF_ENERGY_LC,
    @XmlEnumValue("atomic_unit_of_force") ATOMIC_UNIT_OF_FORCE_LC,
    @XmlEnumValue("atomic_unit_of_length") ATOMIC_UNIT_OF_LENGTH_LC,
    @XmlEnumValue("atomic_unit_of_magnetic_dipole_moment") ATOMIC_UNIT_OF_MAGNETIC_DIPOLE_MOMENT_LC,
    @XmlEnumValue("atomic_unit_of_magnetic_flux_density") ATOMIC_UNIT_OF_MAGNETIC_FLUX_DENSITY_LC,
    @XmlEnumValue("atomic_unit_of_magnetizability") ATOMIC_UNIT_OF_MAGNETIZABILITY_LC,
    @XmlEnumValue("atomic_unit_of_mass") ATOMIC_UNIT_OF_MASS_LC,
    @XmlEnumValue("atomic_unit_of_momentum") ATOMIC_UNIT_OF_MOMENTUM_LC,
    @XmlEnumValue("atomic_unit_of_permittivity") ATOMIC_UNIT_OF_PERMITTIVITY_LC,
    @XmlEnumValue("atomic_unit_of_time") ATOMIC_UNIT_OF_TIME_LC,
    @XmlEnumValue("atomic_unit_of_velocity") ATOMIC_UNIT_OF_VELOCITY_LC,
    @XmlEnumValue("natural_unit_of_action") NATURAL_UNIT_OF_ACTION_LC,
    @XmlEnumValue("natural_unit_of_action_in_eV_s") NATURAL_UNIT_OF_ACTION_IN_EV_S_LC,
    @XmlEnumValue("natural_unit_of_energy") NATURAL_UNIT_OF_ENERGY_LC,
    @XmlEnumValue("natural_unit_of_energy_in_MeV") NATURAL_UNIT_OF_ENERGY_IN_MEV_LC,
    @XmlEnumValue("natural_unit_of_length") NATURAL_UNIT_OF_LENGTH_LC,
    @XmlEnumValue("natural_unit_of_mass") NATURAL_UNIT_OF_MASS_LC,
    @XmlEnumValue("natural_unit_of_momentum") NATURAL_UNIT_OF_MOMENTUM_LC,
    @XmlEnumValue("natural_unit_of_momentum_in_MeV_per_c") NATURAL_UNIT_OF_MOMENTUM_IN_MEV_PER_C_LC,
    @XmlEnumValue("natural_unit_of_time") NATURAL_UNIT_OF_TIME_LC,
    @XmlEnumValue("natural_unit_of_velocity") NATURAL_UNIT_OF_VELOCITY_LC,
    @XmlEnumValue("nautical_mile") NAUTICAL_MILE_LC,
    @XmlEnumValue("knot") KNOT_LC,
    @XmlEnumValue("angstrom") ANGSTROM_LC,
    @XmlEnumValue("are") ARE_LC,
    @XmlEnumValue("hectare") HECTARE_LC,
    @XmlEnumValue("barn") BARN_LC,
    @XmlEnumValue("bar") BAR_LC,
    @XmlEnumValue("gal") GAL_LC,
    @XmlEnumValue("curie") CURIE_LC,
    @XmlEnumValue("roentgen") ROENTGEN_LC,
    @XmlEnumValue("rad") RAD_LC,
    @XmlEnumValue("rem") REM_LC,
    @XmlEnumValue("erg") ERG_LC,
    @XmlEnumValue("dyne") DYNE_LC,
    @XmlEnumValue("barye") BARYE_LC,
    @XmlEnumValue("poise") POISE_LC,
    @XmlEnumValue("rhe") RHE_LC,
    @XmlEnumValue("stokes") STOKES_LC,
    @XmlEnumValue("darcy") DARCY_LC,
    @XmlEnumValue("kayser") KAYSER_LC,
    @XmlEnumValue("lambert") LAMBERT_LC,
    @XmlEnumValue("phot") PHOT_LC,
    @XmlEnumValue("thermo_calorie") THERMO_CALORIE_LC,
    @XmlEnumValue("table_calorie") TABLE_CALORIE_LC,
    @XmlEnumValue("debye") DEBYE_LC,
    @XmlEnumValue("abampere") ABAMPERE_LC,
    @XmlEnumValue("abcoulomb") ABCOULOMB_LC,
    @XmlEnumValue("abfarad") ABFARAD_LC,
    @XmlEnumValue("abhenry") ABHENRY_LC,
    @XmlEnumValue("abohm") ABOHM_LC,
    @XmlEnumValue("abmho") ABMHO_LC,
    @XmlEnumValue("abvolt") ABVOLT_LC,
    @XmlEnumValue("abwatt") ABWATT_LC,
    @XmlEnumValue("maxwell") MAXWELL_LC,
    @XmlEnumValue("gauss") GAUSS_LC,
    @XmlEnumValue("gilbert") GILBERT_LC,
    @XmlEnumValue("oersted") OERSTED_LC,
    @XmlEnumValue("stilb") STILB_LC,
    @XmlEnumValue("statampere") STATAMPERE_LC,
    @XmlEnumValue("statcoulomb") STATCOULOMB_LC,
    @XmlEnumValue("statfarad") STATFARAD_LC,
    @XmlEnumValue("stathenry") STATHENRY_LC,
    @XmlEnumValue("statohm") STATOHM_LC,
    @XmlEnumValue("statmho") STATMHO_LC,
    @XmlEnumValue("statvolt") STATVOLT_LC,
    @XmlEnumValue("statwatt") STATWATT_LC,
    @XmlEnumValue("statweber") STATWEBER_LC,
    @XmlEnumValue("stattesla") STATTESLA_LC,
    @XmlEnumValue("long_ton") LONG_TON_LC,
    @XmlEnumValue("short_ton") SHORT_TON_LC,
    @XmlEnumValue("gross_hundredweight") GROSS_HUNDREDWEIGHT_LC,
    @XmlEnumValue("hundredweight") HUNDREDWEIGHT_LC,
    @XmlEnumValue("pound") POUND_LC,
    @XmlEnumValue("ounce") OUNCE_LC,
    @XmlEnumValue("dram") DRAM_LC,
    @XmlEnumValue("troy_pound") TROY_POUND_LC,
    @XmlEnumValue("troy_ounce") TROY_OUNCE_LC,
    @XmlEnumValue("pennyweight") PENNYWEIGHT_LC,
    @XmlEnumValue("apothecaries_dram") APOTHECARIES_DRAM_LC,
    @XmlEnumValue("scruple") SCRUPLE_LC,
    @XmlEnumValue("grain") GRAIN_LC,
    @XmlEnumValue("slug") SLUG_LC,
    @XmlEnumValue("pound_force") POUND_FORCE_LC,
    @XmlEnumValue("poundal") POUNDAL_LC,
    @XmlEnumValue("kip") KIP_LC,
    @XmlEnumValue("ton_force") TON_FORCE_LC,
    @XmlEnumValue("kilogram_force") KILOGRAM_FORCE_LC,
    @XmlEnumValue("inch") INCH_LC,
    @XmlEnumValue("foot") FOOT_LC,
    @XmlEnumValue("yard") YARD_LC,
    @XmlEnumValue("mile") MILE_LC,
    @XmlEnumValue("us_survey_inch") US_SURVEY_INCH_LC,
    @XmlEnumValue("us_survey_foot") US_SURVEY_FOOT_LC,
    @XmlEnumValue("us_survey_yard") US_SURVEY_YARD_LC,
    @XmlEnumValue("us_survey_fathom") US_SURVEY_FATHOM_LC,
    @XmlEnumValue("us_survey_rod") US_SURVEY_ROD_LC,
    @XmlEnumValue("us_survey_chain") US_SURVEY_CHAIN_LC,
    @XmlEnumValue("us_survey_link") US_SURVEY_LINK_LC,
    @XmlEnumValue("us_survey_furlong") US_SURVEY_FURLONG_LC,
    @XmlEnumValue("us_survey_mile") US_SURVEY_MILE_LC,
    @XmlEnumValue("us_acre") US_ACRE_LC,
    @XmlEnumValue("imperial_gallon") IMPERIAL_GALLON_LC,
    @XmlEnumValue("imperial_quart") IMPERIAL_QUART_LC,
    @XmlEnumValue("imperial_pint") IMPERIAL_PINT_LC,
    @XmlEnumValue("imperial_gill") IMPERIAL_GILL_LC,
    @XmlEnumValue("imperial_ounce") IMPERIAL_OUNCE_LC,
    @XmlEnumValue("us_gallon") US_GALLON_LC,
    @XmlEnumValue("us_quart") US_QUART_LC,
    @XmlEnumValue("us_pint") US_PINT_LC,
    @XmlEnumValue("us_cup") US_CUP_LC,
    @XmlEnumValue("us_fill") US_FILL_LC,
    @XmlEnumValue("us_fluid_ounce") US_FLUID_OUNCE_LC,
    @XmlEnumValue("us_fluid_dram") US_FLUID_DRAM_LC,
    @XmlEnumValue("us_minim") US_MINIM_LC,
    @XmlEnumValue("us_tablespoon") US_TABLESPOON_LC,
    @XmlEnumValue("us_teaspoon") US_TEASPOON_LC,
    @XmlEnumValue("us_bushel") US_BUSHEL_LC,
    @XmlEnumValue("us_peck") US_PECK_LC,
    @XmlEnumValue("us_dry_quart") US_DRY_QUART_LC,
    @XmlEnumValue("us_dry_pint") US_DRY_PINT_LC,
    @XmlEnumValue("thermo_kg_calorie") THERMO_KG_CALORIE_LC,
    @XmlEnumValue("table_kg_calorie") TABLE_KG_CALORIE_LC,
    @XmlEnumValue("us_label_teaspoon") US_LABEL_TEASPOON_LC,
    @XmlEnumValue("us_label_tablespoon") US_LABEL_TABLESPOON_LC,
    @XmlEnumValue("us_label_cup") US_LABEL_CUP_LC,
    @XmlEnumValue("us_label_fluid_ounce") US_LABEL_FLUID_OUNCE_LC,
    @XmlEnumValue("us_label_ounce") US_LABEL_OUNCE_LC,
    @XmlEnumValue("horsepower") HORSEPOWER_LC,
    @XmlEnumValue("electric_horsepower") ELECTRIC_HORSEPOWER_LC,
    @XmlEnumValue("boiler_horsepower") BOILER_HORSEPOWER_LC,
    @XmlEnumValue("metric_horsepower") METRIC_HORSEPOWER_LC,
    @XmlEnumValue("water_horsepower") WATER_HORSEPOWER_LC,
    @XmlEnumValue("uk_horsepower") UK_HORSEPOWER_LC,
    @XmlEnumValue("degree_Fahrenheit") DEGREE_FAHRENHEIT_LC,
    @XmlEnumValue("degree_Rankine") DEGREE_RANKINE_LC,
    @XmlEnumValue("torr") TORR_LC,
    @XmlEnumValue("standard_atmosphere") STANDARD_ATMOSPHERE_LC,
    @XmlEnumValue("technical_atmosphere") TECHNICAL_ATMOSPHERE_LC,
    @XmlEnumValue("mm_Hg") MM_HG_LC,
    @XmlEnumValue("cm_Hg") CM_HG_LC,
    @XmlEnumValue("0C_cm_Hg") E0C_CM_HG_LC,
    @XmlEnumValue("in_Hg") IN_HG_LC,
    @XmlEnumValue("32F_in_Hg") E32F_IN_HG_LC,
    @XmlEnumValue("60F_in_Hg") E60F_IN_HG_LC,
    @XmlEnumValue("ft_Hg") FT_HG_LC,
    @XmlEnumValue("mm_water") MM_WATER_LC,
    @XmlEnumValue("cm_water") CM_WATER_LC,
    @XmlEnumValue("4C_cm_water") E4C_CM_WATER_LC,
    @XmlEnumValue("in_water") IN_WATER_LC,
    @XmlEnumValue("39F_in_water") E39F_IN_WATER_LC,
    @XmlEnumValue("60F_in_water") E60F_IN_WATER_LC,
    @XmlEnumValue("ft_water") FT_WATER_LC,
    @XmlEnumValue("39F_ft_water") E39F_FT_WATER_LC,
    @XmlEnumValue("light_year") LIGHT_YEAR_LC,
    @XmlEnumValue("parsec") PARSEC_LC,
    @XmlEnumValue("printers_pica") PRINTERS_PICA_LC,
    @XmlEnumValue("computer_pica") COMPUTER_PICA_LC,
    @XmlEnumValue("printers_point") PRINTERS_POINT_LC,
    @XmlEnumValue("computer_point") COMPUTER_POINT_LC,
    @XmlEnumValue("thermo_btu") THERMO_BTU_LC,
    @XmlEnumValue("table_btu") TABLE_BTU_LC,
    @XmlEnumValue("mean_btu") MEAN_BTU_LC,
    @XmlEnumValue("39F_btu") E39F_BTU_LC,
    @XmlEnumValue("59F_btu") E59F_BTU_LC,
    @XmlEnumValue("60F_btu") E60F_BTU_LC,
    @XmlEnumValue("tons_of_tnt") TONS_OF_TNT_LC,
    @XmlEnumValue("ec_therm") EC_THERM_LC,
    @XmlEnumValue("us_therm") US_THERM_LC,
    @XmlEnumValue("year_365") YEAR_365_LC,
    @XmlEnumValue("tropical_year") TROPICAL_YEAR_LC,
    @XmlEnumValue("sidereal_year") SIDEREAL_YEAR_LC,
    @XmlEnumValue("sidereal_day") SIDEREAL_DAY_LC,
    @XmlEnumValue("sidereal_hour") SIDEREAL_HOUR_LC,
    @XmlEnumValue("sidereal_minute") SIDEREAL_MINUTE_LC,
    @XmlEnumValue("sidereal_second") SIDEREAL_SECOND_LC,
    @XmlEnumValue("shake") SHAKE_LC,
    @XmlEnumValue("denier") DENIER_LC,
    @XmlEnumValue("tex") TEX_LC,
    @XmlEnumValue("gon") GON_LC,
    @XmlEnumValue("nato_mil") NATO_MIL_LC,
    @XmlEnumValue("pound_mole") POUND_MOLE_LC,
    @XmlEnumValue("ton_refrigeration") TON_REFRIGERATION_LC,
    @XmlEnumValue("circular_mil") CIRCULAR_MIL_LC,
    @XmlEnumValue("bel") BEL_LC,
    @XmlEnumValue("neper") NEPER_LC,
    @XmlEnumValue("pH") PH_LC,
    @XmlEnumValue("petro_barrel") PETRO_BARREL_LC,
    @XmlEnumValue("footlambert") FOOTLAMBERT_LC,
    @XmlEnumValue("footcandle") FOOTCANDLE_LC,
    @XmlEnumValue("carat") CARAT_LC
;

   public static UnitEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "meter".equals( value ) ) { return METER_LC;}
        if ( "gram".equals( value ) ) { return GRAM_LC;}
        if ( "second".equals( value ) ) { return SECOND_LC;}
        if ( "ampere".equals( value ) ) { return AMPERE_LC;}
        if ( "kelvin".equals( value ) ) { return KELVIN_LC;}
        if ( "mole".equals( value ) ) { return MOLE_LC;}
        if ( "candela".equals( value ) ) { return CANDELA_LC;}
        if ( "radian".equals( value ) ) { return RADIAN_LC;}
        if ( "steradian".equals( value ) ) { return STERADIAN_LC;}
        if ( "hertz".equals( value ) ) { return HERTZ_LC;}
        if ( "newton".equals( value ) ) { return NEWTON_LC;}
        if ( "pascal".equals( value ) ) { return PASCAL_LC;}
        if ( "joule".equals( value ) ) { return JOULE_LC;}
        if ( "watt".equals( value ) ) { return WATT_LC;}
        if ( "coulomb".equals( value ) ) { return COULOMB_LC;}
        if ( "volt".equals( value ) ) { return VOLT_LC;}
        if ( "farad".equals( value ) ) { return FARAD_LC;}
        if ( "ohm".equals( value ) ) { return OHM_LC;}
        if ( "siemens".equals( value ) ) { return SIEMENS_LC;}
        if ( "weber".equals( value ) ) { return WEBER_LC;}
        if ( "tesla".equals( value ) ) { return TESLA_LC;}
        if ( "henry".equals( value ) ) { return HENRY_LC;}
        if ( "degree_Celsius".equals( value ) ) { return DEGREE_CELSIUS_LC;}
        if ( "lumen".equals( value ) ) { return LUMEN_LC;}
        if ( "lux".equals( value ) ) { return LUX_LC;}
        if ( "katal".equals( value ) ) { return KATAL_LC;}
        if ( "becquerel".equals( value ) ) { return BECQUEREL_LC;}
        if ( "gray".equals( value ) ) { return GRAY_LC;}
        if ( "sievert".equals( value ) ) { return SIEVERT_LC;}
        if ( "minute".equals( value ) ) { return MINUTE_LC;}
        if ( "hour".equals( value ) ) { return HOUR_LC;}
        if ( "day".equals( value ) ) { return DAY_LC;}
        if ( "arc_degree".equals( value ) ) { return ARC_DEGREE_LC;}
        if ( "arc_minute".equals( value ) ) { return ARC_MINUTE_LC;}
        if ( "arc_second".equals( value ) ) { return ARC_SECOND_LC;}
        if ( "liter".equals( value ) ) { return LITER_LC;}
        if ( "metric_ton".equals( value ) ) { return METRIC_TON_LC;}
        if ( "electronvolt".equals( value ) ) { return ELECTRONVOLT_LC;}
        if ( "unified_atomic_mass_unit".equals( value ) ) { return UNIFIED_ATOMIC_MASS_UNIT_LC;}
        if ( "astronomical_unit".equals( value ) ) { return ASTRONOMICAL_UNIT_LC;}
        if ( "atomic_unit_of_1st_hyperpolarizablity".equals( value ) ) { return ATOMIC_UNIT_OF_1ST_HYPERPOLARIZABLITY_LC;}
        if ( "atomic_unit_of_2nd_hyperpolarizablity".equals( value ) ) { return ATOMIC_UNIT_OF_2ND_HYPERPOLARIZABLITY_LC;}
        if ( "atomic_unit_of_action".equals( value ) ) { return ATOMIC_UNIT_OF_ACTION_LC;}
        if ( "atomic_unit_of_charge".equals( value ) ) { return ATOMIC_UNIT_OF_CHARGE_LC;}
        if ( "atomic_unit_of_charge_density".equals( value ) ) { return ATOMIC_UNIT_OF_CHARGE_DENSITY_LC;}
        if ( "atomic_unit_of_current".equals( value ) ) { return ATOMIC_UNIT_OF_CURRENT_LC;}
        if ( "atomic_unit_of_electric_dipole_moment".equals( value ) ) { return ATOMIC_UNIT_OF_ELECTRIC_DIPOLE_MOMENT_LC;}
        if ( "atomic_unit_of_electric_field".equals( value ) ) { return ATOMIC_UNIT_OF_ELECTRIC_FIELD_LC;}
        if ( "atomic_unit_of_electric_field_gradient".equals( value ) ) { return ATOMIC_UNIT_OF_ELECTRIC_FIELD_GRADIENT_LC;}
        if ( "atomic_unit_of_electric_polarizablity".equals( value ) ) { return ATOMIC_UNIT_OF_ELECTRIC_POLARIZABLITY_LC;}
        if ( "atomic_unit_of_electric_potential".equals( value ) ) { return ATOMIC_UNIT_OF_ELECTRIC_POTENTIAL_LC;}
        if ( "atomic_unit_of_electric_quadrupole_moment".equals( value ) ) { return ATOMIC_UNIT_OF_ELECTRIC_QUADRUPOLE_MOMENT_LC;}
        if ( "atomic_unit_of_energy".equals( value ) ) { return ATOMIC_UNIT_OF_ENERGY_LC;}
        if ( "atomic_unit_of_force".equals( value ) ) { return ATOMIC_UNIT_OF_FORCE_LC;}
        if ( "atomic_unit_of_length".equals( value ) ) { return ATOMIC_UNIT_OF_LENGTH_LC;}
        if ( "atomic_unit_of_magnetic_dipole_moment".equals( value ) ) { return ATOMIC_UNIT_OF_MAGNETIC_DIPOLE_MOMENT_LC;}
        if ( "atomic_unit_of_magnetic_flux_density".equals( value ) ) { return ATOMIC_UNIT_OF_MAGNETIC_FLUX_DENSITY_LC;}
        if ( "atomic_unit_of_magnetizability".equals( value ) ) { return ATOMIC_UNIT_OF_MAGNETIZABILITY_LC;}
        if ( "atomic_unit_of_mass".equals( value ) ) { return ATOMIC_UNIT_OF_MASS_LC;}
        if ( "atomic_unit_of_momentum".equals( value ) ) { return ATOMIC_UNIT_OF_MOMENTUM_LC;}
        if ( "atomic_unit_of_permittivity".equals( value ) ) { return ATOMIC_UNIT_OF_PERMITTIVITY_LC;}
        if ( "atomic_unit_of_time".equals( value ) ) { return ATOMIC_UNIT_OF_TIME_LC;}
        if ( "atomic_unit_of_velocity".equals( value ) ) { return ATOMIC_UNIT_OF_VELOCITY_LC;}
        if ( "natural_unit_of_action".equals( value ) ) { return NATURAL_UNIT_OF_ACTION_LC;}
        if ( "natural_unit_of_action_in_eV_s".equals( value ) ) { return NATURAL_UNIT_OF_ACTION_IN_EV_S_LC;}
        if ( "natural_unit_of_energy".equals( value ) ) { return NATURAL_UNIT_OF_ENERGY_LC;}
        if ( "natural_unit_of_energy_in_MeV".equals( value ) ) { return NATURAL_UNIT_OF_ENERGY_IN_MEV_LC;}
        if ( "natural_unit_of_length".equals( value ) ) { return NATURAL_UNIT_OF_LENGTH_LC;}
        if ( "natural_unit_of_mass".equals( value ) ) { return NATURAL_UNIT_OF_MASS_LC;}
        if ( "natural_unit_of_momentum".equals( value ) ) { return NATURAL_UNIT_OF_MOMENTUM_LC;}
        if ( "natural_unit_of_momentum_in_MeV_per_c".equals( value ) ) { return NATURAL_UNIT_OF_MOMENTUM_IN_MEV_PER_C_LC;}
        if ( "natural_unit_of_time".equals( value ) ) { return NATURAL_UNIT_OF_TIME_LC;}
        if ( "natural_unit_of_velocity".equals( value ) ) { return NATURAL_UNIT_OF_VELOCITY_LC;}
        if ( "nautical_mile".equals( value ) ) { return NAUTICAL_MILE_LC;}
        if ( "knot".equals( value ) ) { return KNOT_LC;}
        if ( "angstrom".equals( value ) ) { return ANGSTROM_LC;}
        if ( "are".equals( value ) ) { return ARE_LC;}
        if ( "hectare".equals( value ) ) { return HECTARE_LC;}
        if ( "barn".equals( value ) ) { return BARN_LC;}
        if ( "bar".equals( value ) ) { return BAR_LC;}
        if ( "gal".equals( value ) ) { return GAL_LC;}
        if ( "curie".equals( value ) ) { return CURIE_LC;}
        if ( "roentgen".equals( value ) ) { return ROENTGEN_LC;}
        if ( "rad".equals( value ) ) { return RAD_LC;}
        if ( "rem".equals( value ) ) { return REM_LC;}
        if ( "erg".equals( value ) ) { return ERG_LC;}
        if ( "dyne".equals( value ) ) { return DYNE_LC;}
        if ( "barye".equals( value ) ) { return BARYE_LC;}
        if ( "poise".equals( value ) ) { return POISE_LC;}
        if ( "rhe".equals( value ) ) { return RHE_LC;}
        if ( "stokes".equals( value ) ) { return STOKES_LC;}
        if ( "darcy".equals( value ) ) { return DARCY_LC;}
        if ( "kayser".equals( value ) ) { return KAYSER_LC;}
        if ( "lambert".equals( value ) ) { return LAMBERT_LC;}
        if ( "phot".equals( value ) ) { return PHOT_LC;}
        if ( "thermo_calorie".equals( value ) ) { return THERMO_CALORIE_LC;}
        if ( "table_calorie".equals( value ) ) { return TABLE_CALORIE_LC;}
        if ( "debye".equals( value ) ) { return DEBYE_LC;}
        if ( "abampere".equals( value ) ) { return ABAMPERE_LC;}
        if ( "abcoulomb".equals( value ) ) { return ABCOULOMB_LC;}
        if ( "abfarad".equals( value ) ) { return ABFARAD_LC;}
        if ( "abhenry".equals( value ) ) { return ABHENRY_LC;}
        if ( "abohm".equals( value ) ) { return ABOHM_LC;}
        if ( "abmho".equals( value ) ) { return ABMHO_LC;}
        if ( "abvolt".equals( value ) ) { return ABVOLT_LC;}
        if ( "abwatt".equals( value ) ) { return ABWATT_LC;}
        if ( "maxwell".equals( value ) ) { return MAXWELL_LC;}
        if ( "gauss".equals( value ) ) { return GAUSS_LC;}
        if ( "gilbert".equals( value ) ) { return GILBERT_LC;}
        if ( "oersted".equals( value ) ) { return OERSTED_LC;}
        if ( "stilb".equals( value ) ) { return STILB_LC;}
        if ( "statampere".equals( value ) ) { return STATAMPERE_LC;}
        if ( "statcoulomb".equals( value ) ) { return STATCOULOMB_LC;}
        if ( "statfarad".equals( value ) ) { return STATFARAD_LC;}
        if ( "stathenry".equals( value ) ) { return STATHENRY_LC;}
        if ( "statohm".equals( value ) ) { return STATOHM_LC;}
        if ( "statmho".equals( value ) ) { return STATMHO_LC;}
        if ( "statvolt".equals( value ) ) { return STATVOLT_LC;}
        if ( "statwatt".equals( value ) ) { return STATWATT_LC;}
        if ( "statweber".equals( value ) ) { return STATWEBER_LC;}
        if ( "stattesla".equals( value ) ) { return STATTESLA_LC;}
        if ( "long_ton".equals( value ) ) { return LONG_TON_LC;}
        if ( "short_ton".equals( value ) ) { return SHORT_TON_LC;}
        if ( "gross_hundredweight".equals( value ) ) { return GROSS_HUNDREDWEIGHT_LC;}
        if ( "hundredweight".equals( value ) ) { return HUNDREDWEIGHT_LC;}
        if ( "pound".equals( value ) ) { return POUND_LC;}
        if ( "ounce".equals( value ) ) { return OUNCE_LC;}
        if ( "dram".equals( value ) ) { return DRAM_LC;}
        if ( "troy_pound".equals( value ) ) { return TROY_POUND_LC;}
        if ( "troy_ounce".equals( value ) ) { return TROY_OUNCE_LC;}
        if ( "pennyweight".equals( value ) ) { return PENNYWEIGHT_LC;}
        if ( "apothecaries_dram".equals( value ) ) { return APOTHECARIES_DRAM_LC;}
        if ( "scruple".equals( value ) ) { return SCRUPLE_LC;}
        if ( "grain".equals( value ) ) { return GRAIN_LC;}
        if ( "slug".equals( value ) ) { return SLUG_LC;}
        if ( "pound_force".equals( value ) ) { return POUND_FORCE_LC;}
        if ( "poundal".equals( value ) ) { return POUNDAL_LC;}
        if ( "kip".equals( value ) ) { return KIP_LC;}
        if ( "ton_force".equals( value ) ) { return TON_FORCE_LC;}
        if ( "kilogram_force".equals( value ) ) { return KILOGRAM_FORCE_LC;}
        if ( "inch".equals( value ) ) { return INCH_LC;}
        if ( "foot".equals( value ) ) { return FOOT_LC;}
        if ( "yard".equals( value ) ) { return YARD_LC;}
        if ( "mile".equals( value ) ) { return MILE_LC;}
        if ( "us_survey_inch".equals( value ) ) { return US_SURVEY_INCH_LC;}
        if ( "us_survey_foot".equals( value ) ) { return US_SURVEY_FOOT_LC;}
        if ( "us_survey_yard".equals( value ) ) { return US_SURVEY_YARD_LC;}
        if ( "us_survey_fathom".equals( value ) ) { return US_SURVEY_FATHOM_LC;}
        if ( "us_survey_rod".equals( value ) ) { return US_SURVEY_ROD_LC;}
        if ( "us_survey_chain".equals( value ) ) { return US_SURVEY_CHAIN_LC;}
        if ( "us_survey_link".equals( value ) ) { return US_SURVEY_LINK_LC;}
        if ( "us_survey_furlong".equals( value ) ) { return US_SURVEY_FURLONG_LC;}
        if ( "us_survey_mile".equals( value ) ) { return US_SURVEY_MILE_LC;}
        if ( "us_acre".equals( value ) ) { return US_ACRE_LC;}
        if ( "imperial_gallon".equals( value ) ) { return IMPERIAL_GALLON_LC;}
        if ( "imperial_quart".equals( value ) ) { return IMPERIAL_QUART_LC;}
        if ( "imperial_pint".equals( value ) ) { return IMPERIAL_PINT_LC;}
        if ( "imperial_gill".equals( value ) ) { return IMPERIAL_GILL_LC;}
        if ( "imperial_ounce".equals( value ) ) { return IMPERIAL_OUNCE_LC;}
        if ( "us_gallon".equals( value ) ) { return US_GALLON_LC;}
        if ( "us_quart".equals( value ) ) { return US_QUART_LC;}
        if ( "us_pint".equals( value ) ) { return US_PINT_LC;}
        if ( "us_cup".equals( value ) ) { return US_CUP_LC;}
        if ( "us_fill".equals( value ) ) { return US_FILL_LC;}
        if ( "us_fluid_ounce".equals( value ) ) { return US_FLUID_OUNCE_LC;}
        if ( "us_fluid_dram".equals( value ) ) { return US_FLUID_DRAM_LC;}
        if ( "us_minim".equals( value ) ) { return US_MINIM_LC;}
        if ( "us_tablespoon".equals( value ) ) { return US_TABLESPOON_LC;}
        if ( "us_teaspoon".equals( value ) ) { return US_TEASPOON_LC;}
        if ( "us_bushel".equals( value ) ) { return US_BUSHEL_LC;}
        if ( "us_peck".equals( value ) ) { return US_PECK_LC;}
        if ( "us_dry_quart".equals( value ) ) { return US_DRY_QUART_LC;}
        if ( "us_dry_pint".equals( value ) ) { return US_DRY_PINT_LC;}
        if ( "thermo_kg_calorie".equals( value ) ) { return THERMO_KG_CALORIE_LC;}
        if ( "table_kg_calorie".equals( value ) ) { return TABLE_KG_CALORIE_LC;}
        if ( "us_label_teaspoon".equals( value ) ) { return US_LABEL_TEASPOON_LC;}
        if ( "us_label_tablespoon".equals( value ) ) { return US_LABEL_TABLESPOON_LC;}
        if ( "us_label_cup".equals( value ) ) { return US_LABEL_CUP_LC;}
        if ( "us_label_fluid_ounce".equals( value ) ) { return US_LABEL_FLUID_OUNCE_LC;}
        if ( "us_label_ounce".equals( value ) ) { return US_LABEL_OUNCE_LC;}
        if ( "horsepower".equals( value ) ) { return HORSEPOWER_LC;}
        if ( "electric_horsepower".equals( value ) ) { return ELECTRIC_HORSEPOWER_LC;}
        if ( "boiler_horsepower".equals( value ) ) { return BOILER_HORSEPOWER_LC;}
        if ( "metric_horsepower".equals( value ) ) { return METRIC_HORSEPOWER_LC;}
        if ( "water_horsepower".equals( value ) ) { return WATER_HORSEPOWER_LC;}
        if ( "uk_horsepower".equals( value ) ) { return UK_HORSEPOWER_LC;}
        if ( "degree_Fahrenheit".equals( value ) ) { return DEGREE_FAHRENHEIT_LC;}
        if ( "degree_Rankine".equals( value ) ) { return DEGREE_RANKINE_LC;}
        if ( "torr".equals( value ) ) { return TORR_LC;}
        if ( "standard_atmosphere".equals( value ) ) { return STANDARD_ATMOSPHERE_LC;}
        if ( "technical_atmosphere".equals( value ) ) { return TECHNICAL_ATMOSPHERE_LC;}
        if ( "mm_Hg".equals( value ) ) { return MM_HG_LC;}
        if ( "cm_Hg".equals( value ) ) { return CM_HG_LC;}
        if ( "0C_cm_Hg".equals( value ) ) { return E0C_CM_HG_LC;}
        if ( "in_Hg".equals( value ) ) { return IN_HG_LC;}
        if ( "32F_in_Hg".equals( value ) ) { return E32F_IN_HG_LC;}
        if ( "60F_in_Hg".equals( value ) ) { return E60F_IN_HG_LC;}
        if ( "ft_Hg".equals( value ) ) { return FT_HG_LC;}
        if ( "mm_water".equals( value ) ) { return MM_WATER_LC;}
        if ( "cm_water".equals( value ) ) { return CM_WATER_LC;}
        if ( "4C_cm_water".equals( value ) ) { return E4C_CM_WATER_LC;}
        if ( "in_water".equals( value ) ) { return IN_WATER_LC;}
        if ( "39F_in_water".equals( value ) ) { return E39F_IN_WATER_LC;}
        if ( "60F_in_water".equals( value ) ) { return E60F_IN_WATER_LC;}
        if ( "ft_water".equals( value ) ) { return FT_WATER_LC;}
        if ( "39F_ft_water".equals( value ) ) { return E39F_FT_WATER_LC;}
        if ( "light_year".equals( value ) ) { return LIGHT_YEAR_LC;}
        if ( "parsec".equals( value ) ) { return PARSEC_LC;}
        if ( "printers_pica".equals( value ) ) { return PRINTERS_PICA_LC;}
        if ( "computer_pica".equals( value ) ) { return COMPUTER_PICA_LC;}
        if ( "printers_point".equals( value ) ) { return PRINTERS_POINT_LC;}
        if ( "computer_point".equals( value ) ) { return COMPUTER_POINT_LC;}
        if ( "thermo_btu".equals( value ) ) { return THERMO_BTU_LC;}
        if ( "table_btu".equals( value ) ) { return TABLE_BTU_LC;}
        if ( "mean_btu".equals( value ) ) { return MEAN_BTU_LC;}
        if ( "39F_btu".equals( value ) ) { return E39F_BTU_LC;}
        if ( "59F_btu".equals( value ) ) { return E59F_BTU_LC;}
        if ( "60F_btu".equals( value ) ) { return E60F_BTU_LC;}
        if ( "tons_of_tnt".equals( value ) ) { return TONS_OF_TNT_LC;}
        if ( "ec_therm".equals( value ) ) { return EC_THERM_LC;}
        if ( "us_therm".equals( value ) ) { return US_THERM_LC;}
        if ( "year_365".equals( value ) ) { return YEAR_365_LC;}
        if ( "tropical_year".equals( value ) ) { return TROPICAL_YEAR_LC;}
        if ( "sidereal_year".equals( value ) ) { return SIDEREAL_YEAR_LC;}
        if ( "sidereal_day".equals( value ) ) { return SIDEREAL_DAY_LC;}
        if ( "sidereal_hour".equals( value ) ) { return SIDEREAL_HOUR_LC;}
        if ( "sidereal_minute".equals( value ) ) { return SIDEREAL_MINUTE_LC;}
        if ( "sidereal_second".equals( value ) ) { return SIDEREAL_SECOND_LC;}
        if ( "shake".equals( value ) ) { return SHAKE_LC;}
        if ( "denier".equals( value ) ) { return DENIER_LC;}
        if ( "tex".equals( value ) ) { return TEX_LC;}
        if ( "gon".equals( value ) ) { return GON_LC;}
        if ( "nato_mil".equals( value ) ) { return NATO_MIL_LC;}
        if ( "pound_mole".equals( value ) ) { return POUND_MOLE_LC;}
        if ( "ton_refrigeration".equals( value ) ) { return TON_REFRIGERATION_LC;}
        if ( "circular_mil".equals( value ) ) { return CIRCULAR_MIL_LC;}
        if ( "bel".equals( value ) ) { return BEL_LC;}
        if ( "neper".equals( value ) ) { return NEPER_LC;}
        if ( "pH".equals( value ) ) { return PH_LC;}
        if ( "petro_barrel".equals( value ) ) { return PETRO_BARREL_LC;}
        if ( "footlambert".equals( value ) ) { return FOOTLAMBERT_LC;}
        if ( "footcandle".equals( value ) ) { return FOOTCANDLE_LC;}
        if ( "carat".equals( value ) ) { return CARAT_LC;}
        return UNKNOWN_VALUE;
   }

}
