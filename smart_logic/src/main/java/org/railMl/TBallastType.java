//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r tBallastType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tBallastType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="slabTrack"/>
 *     &lt;enumeration value="ballast"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tBallastType")
@XmlEnum
public enum TBallastType {

    @XmlEnumValue("slabTrack")
    SLAB_TRACK("slabTrack"),
    @XmlEnumValue("ballast")
    BALLAST("ballast");
    private final String value;

    TBallastType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TBallastType fromValue(String v) {
        for (TBallastType c: TBallastType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
