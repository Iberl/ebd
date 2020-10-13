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
 * <p>Java-Klasse für tLevelCrossingSupervision.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingSupervision">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="trainManual"/>
 *     &lt;enumeration value="infrastructureManual"/>
 *     &lt;enumeration value="infrastructureAutomatic"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingSupervision")
@XmlEnum
public enum TLevelCrossingSupervision {


    /**
     * level crossing is supervised manually from train side (by train driver)
     * 
     */
    @XmlEnumValue("trainManual")
    TRAIN_MANUAL("trainManual"),

    /**
     * level crossing is supervised manually from infrastructure side (e.g. by dispatcher looking)
     * 
     */
    @XmlEnumValue("infrastructureManual")
    INFRASTRUCTURE_MANUAL("infrastructureManual"),

    /**
     * level crossing is supervised automatically from infrastructure side (e.g. via camera)
     * 
     */
    @XmlEnumValue("infrastructureAutomatic")
    INFRASTRUCTURE_AUTOMATIC("infrastructureAutomatic"),

    /**
     * the level crossing is not supervised
     * 
     */
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    TLevelCrossingSupervision(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingSupervision fromValue(String v) {
        for (TLevelCrossingSupervision c: TLevelCrossingSupervision.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
