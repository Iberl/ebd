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
 * <p>Java-Klasse für tTrainProtectionMedium.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainProtectionMedium">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="cable"/>
 *     &lt;enumeration value="rail"/>
 *     &lt;enumeration value="radio"/>
 *     &lt;enumeration value="inductive"/>
 *     &lt;enumeration value="mechanical"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainProtectionMedium")
@XmlEnum
public enum TTrainProtectionMedium {

    @XmlEnumValue("cable")
    CABLE("cable"),
    @XmlEnumValue("rail")
    RAIL("rail"),
    @XmlEnumValue("radio")
    RADIO("radio"),
    @XmlEnumValue("inductive")
    INDUCTIVE("inductive"),
    @XmlEnumValue("mechanical")
    MECHANICAL("mechanical");
    private final String value;

    TTrainProtectionMedium(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainProtectionMedium fromValue(String v) {
        for (TTrainProtectionMedium c: TTrainProtectionMedium.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
