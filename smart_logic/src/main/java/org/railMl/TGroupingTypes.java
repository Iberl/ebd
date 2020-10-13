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
 * <p>Java-Klasse für tGroupingTypes.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tGroupingTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="catenary"/>
 *     &lt;enumeration value="elementBlocking"/>
 *     &lt;enumeration value="automaticRouteSetting"/>
 *     &lt;enumeration value="automaticTrainRouting"/>
 *     &lt;enumeration value="callOn"/>
 *     &lt;enumeration value="emergencyStop"/>
 *     &lt;enumeration value="pointStaggering"/>
 *     &lt;enumeration value="pointHeating"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tGroupingTypes")
@XmlEnum
public enum TGroupingTypes {

    @XmlEnumValue("catenary")
    CATENARY("catenary"),
    @XmlEnumValue("elementBlocking")
    ELEMENT_BLOCKING("elementBlocking"),
    @XmlEnumValue("automaticRouteSetting")
    AUTOMATIC_ROUTE_SETTING("automaticRouteSetting"),
    @XmlEnumValue("automaticTrainRouting")
    AUTOMATIC_TRAIN_ROUTING("automaticTrainRouting"),
    @XmlEnumValue("callOn")
    CALL_ON("callOn"),
    @XmlEnumValue("emergencyStop")
    EMERGENCY_STOP("emergencyStop"),
    @XmlEnumValue("pointStaggering")
    POINT_STAGGERING("pointStaggering"),
    @XmlEnumValue("pointHeating")
    POINT_HEATING("pointHeating");
    private final String value;

    TGroupingTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGroupingTypes fromValue(String v) {
        for (TGroupingTypes c: TGroupingTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
