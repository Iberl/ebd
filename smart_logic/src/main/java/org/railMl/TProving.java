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
 * <p>Java-Klasse für tProving.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tProving">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="staffAcknowledged"/>
 *     &lt;enumeration value="continuously"/>
 *     &lt;enumeration value="oneOff"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tProving")
@XmlEnum
public enum TProving {

    @XmlEnumValue("staffAcknowledged")
    STAFF_ACKNOWLEDGED("staffAcknowledged"),
    @XmlEnumValue("continuously")
    CONTINUOUSLY("continuously"),
    @XmlEnumValue("oneOff")
    ONE_OFF("oneOff");
    private final String value;

    TProving(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TProving fromValue(String v) {
        for (TProving c: TProving.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
