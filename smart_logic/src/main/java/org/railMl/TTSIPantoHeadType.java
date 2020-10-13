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
 * <p>Java-Klasse für tTSIPantoHeadType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTSIPantoHeadType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="tsi2000_2260"/>
 *     &lt;enumeration value="tsi1600"/>
 *     &lt;enumeration value="tsi1950"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTSIPantoHeadType")
@XmlEnum
public enum TTSIPantoHeadType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("tsi2000_2260")
    TSI_2000_2260("tsi2000_2260"),
    @XmlEnumValue("tsi1600")
    TSI_1600("tsi1600"),
    @XmlEnumValue("tsi1950")
    TSI_1950("tsi1950");
    private final String value;

    TTSIPantoHeadType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTSIPantoHeadType fromValue(String v) {
        for (TTSIPantoHeadType c: TTSIPantoHeadType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
