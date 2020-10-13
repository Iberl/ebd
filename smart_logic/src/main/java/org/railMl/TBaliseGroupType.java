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
 * <p>Java-Klasse für tBaliseGroupType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tBaliseGroupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="signal"/>
 *     &lt;enumeration value="infill"/>
 *     &lt;enumeration value="fixed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tBaliseGroupType")
@XmlEnum
public enum TBaliseGroupType {

    @XmlEnumValue("signal")
    SIGNAL("signal"),
    @XmlEnumValue("infill")
    INFILL("infill"),
    @XmlEnumValue("fixed")
    FIXED("fixed");
    private final String value;

    TBaliseGroupType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TBaliseGroupType fromValue(String v) {
        for (TBaliseGroupType c: TBaliseGroupType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
