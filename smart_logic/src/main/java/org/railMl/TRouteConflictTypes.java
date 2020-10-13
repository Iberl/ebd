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
 * <p>Java-Klasse für tRouteConflictTypes.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tRouteConflictTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="overlappingTVDsection"/>
 *     &lt;enumeration value="conflictingSwitchPosition"/>
 *     &lt;enumeration value="conflictingStatus"/>
 *     &lt;enumeration value="conflictingOverlap"/>
 *     &lt;enumeration value="conflictingHeadProtection"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tRouteConflictTypes")
@XmlEnum
public enum TRouteConflictTypes {

    @XmlEnumValue("overlappingTVDsection")
    OVERLAPPING_TV_DSECTION("overlappingTVDsection"),
    @XmlEnumValue("conflictingSwitchPosition")
    CONFLICTING_SWITCH_POSITION("conflictingSwitchPosition"),
    @XmlEnumValue("conflictingStatus")
    CONFLICTING_STATUS("conflictingStatus"),
    @XmlEnumValue("conflictingOverlap")
    CONFLICTING_OVERLAP("conflictingOverlap"),
    @XmlEnumValue("conflictingHeadProtection")
    CONFLICTING_HEAD_PROTECTION("conflictingHeadProtection");
    private final String value;

    TRouteConflictTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TRouteConflictTypes fromValue(String v) {
        for (TRouteConflictTypes c: TRouteConflictTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
