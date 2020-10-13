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
 * <p>Java-Klasse für tLevelCrossingActivation.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingActivation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="trainAutomatic"/>
 *     &lt;enumeration value="trainManual"/>
 *     &lt;enumeration value="infrastructureAutomatic"/>
 *     &lt;enumeration value="infrastructureManual"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingActivation")
@XmlEnum
public enum TLevelCrossingActivation {


    /**
     * level crossing is activated automatically from train side
     * 
     */
    @XmlEnumValue("trainAutomatic")
    TRAIN_AUTOMATIC("trainAutomatic"),

    /**
     * level crossing is activated manually from train side (action of train driver required)
     * 
     */
    @XmlEnumValue("trainManual")
    TRAIN_MANUAL("trainManual"),

    /**
     * level crossing is activated automatically from infrastructure side (e.g. via activating rail detector)
     * 
     */
    @XmlEnumValue("infrastructureAutomatic")
    INFRASTRUCTURE_AUTOMATIC("infrastructureAutomatic"),

    /**
     * level crossing is activated manually from infrastructure side (e.g. by a dispatcher)
     * 
     */
    @XmlEnumValue("infrastructureManual")
    INFRASTRUCTURE_MANUAL("infrastructureManual"),

    /**
     * there is no activation of the level crossing protection
     * 
     */
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    TLevelCrossingActivation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingActivation fromValue(String v) {
        for (TLevelCrossingActivation c: TLevelCrossingActivation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
