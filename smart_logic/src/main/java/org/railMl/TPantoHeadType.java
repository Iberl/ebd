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
 * <p>Java-Klasse für tPantoHeadType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tPantoHeadType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="DC_1450"/>
 *     &lt;enumeration value="AC_1450"/>
 *     &lt;enumeration value="GB_1600"/>
 *     &lt;enumeration value="GB_CTRL_1600"/>
 *     &lt;enumeration value="EP_1600"/>
 *     &lt;enumeration value="BE_1760"/>
 *     &lt;enumeration value="NO_SO_1800"/>
 *     &lt;enumeration value="PL_1950"/>
 *     &lt;enumeration value="Type2_1950"/>
 *     &lt;enumeration value="Type1_1950"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tPantoHeadType")
@XmlEnum
public enum TPantoHeadType {

    @XmlEnumValue("other")
    OTHER("other"),
    DC_1450("DC_1450"),
    AC_1450("AC_1450"),
    GB_1600("GB_1600"),
    GB_CTRL_1600("GB_CTRL_1600"),
    EP_1600("EP_1600"),
    BE_1760("BE_1760"),
    NO_SO_1800("NO_SO_1800"),
    PL_1950("PL_1950"),
    @XmlEnumValue("Type2_1950")
    TYPE_2_1950("Type2_1950"),
    @XmlEnumValue("Type1_1950")
    TYPE_1_1950("Type1_1950");
    private final String value;

    TPantoHeadType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TPantoHeadType fromValue(String v) {
        for (TPantoHeadType c: TPantoHeadType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
