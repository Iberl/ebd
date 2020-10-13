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
 * <p>Java-Klasse für tHorizontalCurveType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tHorizontalCurveType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="straight"/>
 *     &lt;enumeration value="sinusoide"/>
 *     &lt;enumeration value="doucine"/>
 *     &lt;enumeration value="curveWiener"/>
 *     &lt;enumeration value="curveBloss"/>
 *     &lt;enumeration value="cubicParabola"/>
 *     &lt;enumeration value="cosinusoide"/>
 *     &lt;enumeration value="clothoide"/>
 *     &lt;enumeration value="arc"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tHorizontalCurveType")
@XmlEnum
public enum THorizontalCurveType {


    /**
     * A straight curve has a constant radius that is infinite.
     * 
     */
    @XmlEnumValue("straight")
    STRAIGHT("straight"),
    @XmlEnumValue("sinusoide")
    SINUSOIDE("sinusoide"),
    @XmlEnumValue("doucine")
    DOUCINE("doucine"),
    @XmlEnumValue("curveWiener")
    CURVE_WIENER("curveWiener"),
    @XmlEnumValue("curveBloss")
    CURVE_BLOSS("curveBloss"),
    @XmlEnumValue("cubicParabola")
    CUBIC_PARABOLA("cubicParabola"),
    @XmlEnumValue("cosinusoide")
    COSINUSOIDE("cosinusoide"),
    @XmlEnumValue("clothoide")
    CLOTHOIDE("clothoide"),

    /**
     * An arc has a constant radius that is not infinite and not zero.
     * 
     */
    @XmlEnumValue("arc")
    ARC("arc");
    private final String value;

    THorizontalCurveType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static THorizontalCurveType fromValue(String v) {
        for (THorizontalCurveType c: THorizontalCurveType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
