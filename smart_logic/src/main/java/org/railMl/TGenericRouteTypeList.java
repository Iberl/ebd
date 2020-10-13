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
 * <p>Java-Klasse für tGenericRouteTypeList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tGenericRouteTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="tunnel"/>
 *     &lt;enumeration value="siding"/>
 *     &lt;enumeration value="shunting"/>
 *     &lt;enumeration value="occupied"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="nonElectrified"/>
 *     &lt;enumeration value="callOn"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tGenericRouteTypeList")
@XmlEnum
public enum TGenericRouteTypeList {

    @XmlEnumValue("tunnel")
    TUNNEL("tunnel"),
    @XmlEnumValue("siding")
    SIDING("siding"),
    @XmlEnumValue("shunting")
    SHUNTING("shunting"),
    @XmlEnumValue("occupied")
    OCCUPIED("occupied"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("nonElectrified")
    NON_ELECTRIFIED("nonElectrified"),
    @XmlEnumValue("callOn")
    CALL_ON("callOn");
    private final String value;

    TGenericRouteTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGenericRouteTypeList fromValue(String v) {
        for (TGenericRouteTypeList c: TGenericRouteTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
