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
 * <p>Java-Klasse für tInfrastructureState.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tInfrastructureState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="closed"/>
 *     &lt;enumeration value="operational"/>
 *     &lt;enumeration value="conceptual"/>
 *     &lt;enumeration value="planned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tInfrastructureState")
@XmlEnum
public enum TInfrastructureState {


    /**
     * The element is currently not usable, switched off or deactivated and therefore cannot be used regularly. However, it can be put back into operation at short notice without further construction, acceptance or approval activities.
     * 
     */
    @XmlEnumValue("disabled")
    DISABLED("disabled"),

    /**
     * The element is no longer available, removed, dismantled, or no longer exists. Planning, construction or commissioning activities are absolutely necessary for recommissioning.
     * 
     */
    @XmlEnumValue("closed")
    CLOSED("closed"),

    /**
     * The element is operational and can be used regularly.
     * 
     */
    @XmlEnumValue("operational")
    OPERATIONAL("operational"),

    /**
     * The construction or commissioning of the element is planned for the medium or long term. However, there are still no concrete (planning) activities for the construction of the element beyond the preliminary planning and cost estimation.
     * 
     */
    @XmlEnumValue("conceptual")
    CONCEPTUAL("conceptual"),

    /**
     * The construction or commissioning of the element is planned concretely and at short notice or concrete planning activities for the construction take place, e.g. design, approval or implementation planning, cost calculation, award of contracts. It is not normally possible to use the element.
     * 
     */
    @XmlEnumValue("planned")
    PLANNED("planned");
    private final String value;

    TInfrastructureState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TInfrastructureState fromValue(String v) {
        for (TInfrastructureState c: TInfrastructureState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
