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
 * <p>Java-Klasse für tCrossedElementType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tCrossedElementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="lake"/>
 *     &lt;enumeration value="river"/>
 *     &lt;enumeration value="valley"/>
 *     &lt;enumeration value="ridge"/>
 *     &lt;enumeration value="peak"/>
 *     &lt;enumeration value="road"/>
 *     &lt;enumeration value="motorway"/>
 *     &lt;enumeration value="footway"/>
 *     &lt;enumeration value="city"/>
 *     &lt;enumeration value="area"/>
 *     &lt;enumeration value="cycleway"/>
 *     &lt;enumeration value="railway"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tCrossedElementType")
@XmlEnum
public enum TCrossedElementType {

    @XmlEnumValue("lake")
    LAKE("lake"),
    @XmlEnumValue("river")
    RIVER("river"),
    @XmlEnumValue("valley")
    VALLEY("valley"),
    @XmlEnumValue("ridge")
    RIDGE("ridge"),
    @XmlEnumValue("peak")
    PEAK("peak"),
    @XmlEnumValue("road")
    ROAD("road"),
    @XmlEnumValue("motorway")
    MOTORWAY("motorway"),
    @XmlEnumValue("footway")
    FOOTWAY("footway"),
    @XmlEnumValue("city")
    CITY("city"),
    @XmlEnumValue("area")
    AREA("area"),
    @XmlEnumValue("cycleway")
    CYCLEWAY("cycleway"),
    @XmlEnumValue("railway")
    RAILWAY("railway");
    private final String value;

    TCrossedElementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TCrossedElementType fromValue(String v) {
        for (TCrossedElementType c: TCrossedElementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
