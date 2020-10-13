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
 * <p>Java-Klasse für tLevelCrossingProtectionBarrier.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingProtectionBarrier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="doubleHalfBarrier"/>
 *     &lt;enumeration value="singleHalfBarrier"/>
 *     &lt;enumeration value="singleFullBarrier"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingProtectionBarrier")
@XmlEnum
public enum TLevelCrossingProtectionBarrier {


    /**
     * no barriers
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * protection of the level crossing with half barriers on entry and exit side
     * 
     */
    @XmlEnumValue("doubleHalfBarrier")
    DOUBLE_HALF_BARRIER("doubleHalfBarrier"),

    /**
     * protection of the level crossing with half barriers on entry side
     * 
     */
    @XmlEnumValue("singleHalfBarrier")
    SINGLE_HALF_BARRIER("singleHalfBarrier"),

    /**
     * protection of the level crossing with full barriers
     * 
     */
    @XmlEnumValue("singleFullBarrier")
    SINGLE_FULL_BARRIER("singleFullBarrier");
    private final String value;

    TLevelCrossingProtectionBarrier(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingProtectionBarrier fromValue(String v) {
        for (TLevelCrossingProtectionBarrier c: TLevelCrossingProtectionBarrier.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
