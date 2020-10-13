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
 * <p>Java-Klasse für tLineType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLineType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="branchLine"/>
 *     &lt;enumeration value="mainLine"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLineType")
@XmlEnum
public enum TLineType {


    /**
     * A branch line is a railway line which branches off a more important through route, usually a main line. These lines have mainly local traffic only, lower speeds and lower equipment criteria.
     * 
     */
    @XmlEnumValue("branchLine")
    BRANCH_LINE("branchLine"),

    /**
     * A main line is an important section of a railway network, which connects cities or hubs and does serve high(er) speed passenger, larger cargo or suburban trains. Normally these lines are equipped with signals, train protection systems and allow higher speeds and axle loads
     * 
     */
    @XmlEnumValue("mainLine")
    MAIN_LINE("mainLine");
    private final String value;

    TLineType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLineType fromValue(String v) {
        for (TLineType c: TLineType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
