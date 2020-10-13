//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tBrakeType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tBrakeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="compressedAirBrake"/>
 *     &lt;enumeration value="vacuumAirBrake"/>
 *     &lt;enumeration value="cableBrake"/>
 *     &lt;enumeration value="parkingBrake"/>
 *     &lt;enumeration value="handBrake"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tBrakeType")
@XmlEnum
public enum TBrakeType {

    @XmlEnumValue("none")
    NONE("none"),

    /**
     * de: Druckluftbremse
     * 
     */
    @XmlEnumValue("compressedAirBrake")
    COMPRESSED_AIR_BRAKE("compressedAirBrake"),

    /**
     * de: Saugluftbremse
     * 
     */
    @XmlEnumValue("vacuumAirBrake")
    VACUUM_AIR_BRAKE("vacuumAirBrake"),

    /**
     * de: Seilzugbremse
     * 
     */
    @XmlEnumValue("cableBrake")
    CABLE_BRAKE("cableBrake"),
    @XmlEnumValue("parkingBrake")
    PARKING_BRAKE("parkingBrake"),
    @XmlEnumValue("handBrake")
    HAND_BRAKE("handBrake");
    private final String value;

    TBrakeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TBrakeType fromValue(String v) {
        for (TBrakeType c: TBrakeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
