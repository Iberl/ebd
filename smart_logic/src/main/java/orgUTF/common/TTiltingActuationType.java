//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tTiltingActuationType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTiltingActuationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="rollCompensation"/>
 *     &lt;enumeration value="passive"/>
 *     &lt;enumeration value="active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTiltingActuationType")
@XmlEnum
public enum TTiltingActuationType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("rollCompensation")
    ROLL_COMPENSATION("rollCompensation"),
    @XmlEnumValue("passive")
    PASSIVE("passive"),
    @XmlEnumValue("active")
    ACTIVE("active");
    private final String value;

    TTiltingActuationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTiltingActuationType fromValue(String v) {
        for (TTiltingActuationType c: TTiltingActuationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
