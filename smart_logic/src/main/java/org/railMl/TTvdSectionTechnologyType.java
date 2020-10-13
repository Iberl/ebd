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
 * <p>Java-Klasse für tTvdSectionTechnologyType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTvdSectionTechnologyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="trackCircuit"/>
 *     &lt;enumeration value="axleCounter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTvdSectionTechnologyType")
@XmlEnum
public enum TTvdSectionTechnologyType {

    @XmlEnumValue("trackCircuit")
    TRACK_CIRCUIT("trackCircuit"),
    @XmlEnumValue("axleCounter")
    AXLE_COUNTER("axleCounter");
    private final String value;

    TTvdSectionTechnologyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTvdSectionTechnologyType fromValue(String v) {
        for (TTvdSectionTechnologyType c: TTvdSectionTechnologyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
