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
 * <p>Java-Klasse für tIxlTechnologyTypeList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tIxlTechnologyTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="digital"/>
 *     &lt;enumeration value="electronic"/>
 *     &lt;enumeration value="relay"/>
 *     &lt;enumeration value="electromechanical"/>
 *     &lt;enumeration value="mechanical"/>
 *     &lt;enumeration value="manual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tIxlTechnologyTypeList")
@XmlEnum
public enum TIxlTechnologyTypeList {

    @XmlEnumValue("digital")
    DIGITAL("digital"),
    @XmlEnumValue("electronic")
    ELECTRONIC("electronic"),
    @XmlEnumValue("relay")
    RELAY("relay"),
    @XmlEnumValue("electromechanical")
    ELECTROMECHANICAL("electromechanical"),
    @XmlEnumValue("mechanical")
    MECHANICAL("mechanical"),
    @XmlEnumValue("manual")
    MANUAL("manual");
    private final String value;

    TIxlTechnologyTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TIxlTechnologyTypeList fromValue(String v) {
        for (TIxlTechnologyTypeList c: TIxlTechnologyTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
