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
 * <p>Java-Klasse für tLevelCrossingProtectionLights.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingProtectionLights">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="flashing"/>
 *     &lt;enumeration value="continuous"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingProtectionLights")
@XmlEnum
public enum TLevelCrossingProtectionLights {


    /**
     * no visual level crossing protection with lights
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * visual level crossing protection with flashing light
     * 
     */
    @XmlEnumValue("flashing")
    FLASHING("flashing"),

    /**
     * visual level crossing protection with continuous light
     * 
     */
    @XmlEnumValue("continuous")
    CONTINUOUS("continuous");
    private final String value;

    TLevelCrossingProtectionLights(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingProtectionLights fromValue(String v) {
        for (TLevelCrossingProtectionLights c: TLevelCrossingProtectionLights.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
