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
 * <p>Java-Klasse für tGradientCurveType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tGradientCurveType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mixed"/>
 *     &lt;enumeration value="straight"/>
 *     &lt;enumeration value="arc"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tGradientCurveType")
@XmlEnum
public enum TGradientCurveType {


    /**
     * an aggregated curve with arcs and straight parts
     * 
     */
    @XmlEnumValue("mixed")
    MIXED("mixed"),

    /**
     * curve with constant infinite radius (zero curvature)
     * 
     */
    @XmlEnumValue("straight")
    STRAIGHT("straight"),

    /**
     * curve with a constant radius that is not infinite
     * 
     */
    @XmlEnumValue("arc")
    ARC("arc");
    private final String value;

    TGradientCurveType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGradientCurveType fromValue(String v) {
        for (TGradientCurveType c: TGradientCurveType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
