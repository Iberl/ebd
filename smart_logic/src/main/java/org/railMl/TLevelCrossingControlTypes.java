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
 * <p>Java-Klasse für tLevelCrossingControlTypes.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingControlTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="autonomous"/>
 *     &lt;enumeration value="fullControlled"/>
 *     &lt;enumeration value="halfControlled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingControlTypes")
@XmlEnum
public enum TLevelCrossingControlTypes {

    @XmlEnumValue("autonomous")
    AUTONOMOUS("autonomous"),
    @XmlEnumValue("fullControlled")
    FULL_CONTROLLED("fullControlled"),
    @XmlEnumValue("halfControlled")
    HALF_CONTROLLED("halfControlled");
    private final String value;

    TLevelCrossingControlTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingControlTypes fromValue(String v) {
        for (TLevelCrossingControlTypes c: TLevelCrossingControlTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
