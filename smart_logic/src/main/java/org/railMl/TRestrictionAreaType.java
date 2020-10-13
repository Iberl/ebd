//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tRestrictionAreaType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tRestrictionAreaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="radioHole"/>
 *     &lt;enumeration value="noRegenerativeBrake"/>
 *     &lt;enumeration value="noMagneticShoeBrake"/>
 *     &lt;enumeration value="mainPowerSwitchOff"/>
 *     &lt;enumeration value="lowerPantograph"/>
 *     &lt;enumeration value="airTightness"/>
 *     &lt;enumeration value="noStopping"/>
 *     &lt;enumeration value="noSanding"/>
 *     &lt;enumeration value="noEddyCurrentBrakeForEmergencyBrake"/>
 *     &lt;enumeration value="noEddyCurrentBrakeForServiceBrake"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tRestrictionAreaType")
@XmlEnum
public enum TRestrictionAreaType {

    @XmlEnumValue("radioHole")
    RADIO_HOLE("radioHole"),

    /**
     * it is forbidden to use regenerative braking
     * 
     */
    @XmlEnumValue("noRegenerativeBrake")
    NO_REGENERATIVE_BRAKE("noRegenerativeBrake"),

    /**
     * it is forbidden to use the magnetic shoe brake
     * 
     */
    @XmlEnumValue("noMagneticShoeBrake")
    NO_MAGNETIC_SHOE_BRAKE("noMagneticShoeBrake"),

    /**
     * the main power engine has to be switched off
     * 
     */
    @XmlEnumValue("mainPowerSwitchOff")
    MAIN_POWER_SWITCH_OFF("mainPowerSwitchOff"),

    /**
     * the pantograph has to be lowered
     * 
     */
    @XmlEnumValue("lowerPantograph")
    LOWER_PANTOGRAPH("lowerPantograph"),
    @XmlEnumValue("airTightness")
    AIR_TIGHTNESS("airTightness"),

    /**
     * it is forbidden to stop
     * 
     */
    @XmlEnumValue("noStopping")
    NO_STOPPING("noStopping"),

    /**
     * it is forbidden to use sanding for increasing coefficient of adhesion
     * 
     */
    @XmlEnumValue("noSanding")
    NO_SANDING("noSanding"),
    @XmlEnumValue("noEddyCurrentBrakeForEmergencyBrake")
    NO_EDDY_CURRENT_BRAKE_FOR_EMERGENCY_BRAKE("noEddyCurrentBrakeForEmergencyBrake"),
    @XmlEnumValue("noEddyCurrentBrakeForServiceBrake")
    NO_EDDY_CURRENT_BRAKE_FOR_SERVICE_BRAKE("noEddyCurrentBrakeForServiceBrake");
    private final String value;

    TRestrictionAreaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TRestrictionAreaType fromValue(String v) {
        for (TRestrictionAreaType c: TRestrictionAreaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
