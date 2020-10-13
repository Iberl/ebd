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
 * <p>Java-Klasse für tBufferStopType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tBufferStopType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sleeperCross"/>
 *     &lt;enumeration value="headRamp"/>
 *     &lt;enumeration value="fixedBufferStop"/>
 *     &lt;enumeration value="brakingBufferStop"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tBufferStopType")
@XmlEnum
public enum TBufferStopType {

    @XmlEnumValue("sleeperCross")
    SLEEPER_CROSS("sleeperCross"),
    @XmlEnumValue("headRamp")
    HEAD_RAMP("headRamp"),
    @XmlEnumValue("fixedBufferStop")
    FIXED_BUFFER_STOP("fixedBufferStop"),
    @XmlEnumValue("brakingBufferStop")
    BRAKING_BUFFER_STOP("brakingBufferStop");
    private final String value;

    TBufferStopType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TBufferStopType fromValue(String v) {
        for (TBufferStopType c: TBufferStopType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
