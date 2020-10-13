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
 * <p>Java-Klasse für tBorderType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tBorderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="tariff"/>
 *     &lt;enumeration value="station"/>
 *     &lt;enumeration value="state"/>
 *     &lt;enumeration value="infrastructureManager"/>
 *     &lt;enumeration value="country"/>
 *     &lt;enumeration value="area"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tBorderType")
@XmlEnum
public enum TBorderType {


    /**
     * border between different tariff zones;
     * Shall also be used for borders between two (or more) transport associations
     * 
     */
    @XmlEnumValue("tariff")
    TARIFF("tariff"),

    /**
     * border of a station
     * 
     */
    @XmlEnumValue("station")
    STATION("station"),

    /**
     * border of a (federal) state
     * 
     */
    @XmlEnumValue("state")
    STATE("state"),

    /**
     * border between infrastructure networks of different infrastructure managers
     * 
     */
    @XmlEnumValue("infrastructureManager")
    INFRASTRUCTURE_MANAGER("infrastructureManager"),

    /**
     * border between different (national) countries
     * 
     */
    @XmlEnumValue("country")
    COUNTRY("country"),

    /**
     * border between different areas, e.g. areas that are controlled by different controllers
     * 
     */
    @XmlEnumValue("area")
    AREA("area");
    private final String value;

    TBorderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TBorderType fromValue(String v) {
        for (TBorderType c: TBorderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
