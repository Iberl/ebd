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
 * <p>Java-Klasse für tNumberOfTracks.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tNumberOfTracks">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="single"/>
 *     &lt;enumeration value="multiple"/>
 *     &lt;enumeration value="double"/>
 *     &lt;enumeration value="mixed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tNumberOfTracks")
@XmlEnum
public enum TNumberOfTracks {


    /**
     * single track line
     * 
     */
    @XmlEnumValue("single")
    SINGLE("single"),

    /**
     * line with more than two tracks
     * 
     */
    @XmlEnumValue("multiple")
    MULTIPLE("multiple"),

    /**
     * double track line
     * 
     */
    @XmlEnumValue("double")
    DOUBLE("double"),

    /**
     * line with changing number of tracks
     * 
     */
    @XmlEnumValue("mixed")
    MIXED("mixed");
    private final String value;

    TNumberOfTracks(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TNumberOfTracks fromValue(String v) {
        for (TNumberOfTracks c: TNumberOfTracks.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
