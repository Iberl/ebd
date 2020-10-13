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
 * <p>Java-Klasse für tDetectorMedium.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tDetectorMedium">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="radio"/>
 *     &lt;enumeration value="pneumatic"/>
 *     &lt;enumeration value="optical"/>
 *     &lt;enumeration value="mechanical"/>
 *     &lt;enumeration value="magnetic"/>
 *     &lt;enumeration value="inductive"/>
 *     &lt;enumeration value="hydraulic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDetectorMedium")
@XmlEnum
public enum TDetectorMedium {

    @XmlEnumValue("radio")
    RADIO("radio"),
    @XmlEnumValue("pneumatic")
    PNEUMATIC("pneumatic"),
    @XmlEnumValue("optical")
    OPTICAL("optical"),
    @XmlEnumValue("mechanical")
    MECHANICAL("mechanical"),
    @XmlEnumValue("magnetic")
    MAGNETIC("magnetic"),
    @XmlEnumValue("inductive")
    INDUCTIVE("inductive"),
    @XmlEnumValue("hydraulic")
    HYDRAULIC("hydraulic");
    private final String value;

    TDetectorMedium(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDetectorMedium fromValue(String v) {
        for (TDetectorMedium c: TDetectorMedium.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
