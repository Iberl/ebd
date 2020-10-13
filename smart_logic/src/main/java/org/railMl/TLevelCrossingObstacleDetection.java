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
 * <p>Java-Klasse für tLevelCrossingObstacleDetection.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingObstacleDetection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="automatic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingObstacleDetection")
@XmlEnum
public enum TLevelCrossingObstacleDetection {


    /**
     * there is no obstacle detection taking place in the level crossing danger area
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * obstacle detection in level crossing danger area is done manually (e.g. via dispatcher looking)
     * 
     */
    @XmlEnumValue("manual")
    MANUAL("manual"),

    /**
     * obstacle detection in level crossing danger area is done automatically (e.g. via radar)
     * 
     */
    @XmlEnumValue("automatic")
    AUTOMATIC("automatic");
    private final String value;

    TLevelCrossingObstacleDetection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingObstacleDetection fromValue(String v) {
        for (TLevelCrossingObstacleDetection c: TLevelCrossingObstacleDetection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
