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
 * <p>Java-Klasse für tLineCategory.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLineCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="E5"/>
 *     &lt;enumeration value="E4"/>
 *     &lt;enumeration value="D4xL"/>
 *     &lt;enumeration value="D4"/>
 *     &lt;enumeration value="D3"/>
 *     &lt;enumeration value="D2"/>
 *     &lt;enumeration value="C4"/>
 *     &lt;enumeration value="C3"/>
 *     &lt;enumeration value="C2"/>
 *     &lt;enumeration value="B2"/>
 *     &lt;enumeration value="B1"/>
 *     &lt;enumeration value="A"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLineCategory")
@XmlEnum
public enum TLineCategory {


    /**
     * axle load: 25.0 t, meter load: 8.8 t/m
     * only valid for freight cars
     * 
     */
    @XmlEnumValue("E5")
    E_5("E5"),

    /**
     * axle load: 25.0 t, meter load: 8.0 t/m
     * only valid for freight cars
     * 
     */
    @XmlEnumValue("E4")
    E_4("E4"),

    /**
     * only valid for locomotives
     * 
     */
    @XmlEnumValue("D4xL")
    D_4_X_L("D4xL"),

    /**
     * axle load: 22.5 t, meter load: 8.0 t/m
     * 
     */
    @XmlEnumValue("D4")
    D_4("D4"),

    /**
     * axle load: 22.5 t, meter load: 7.2 t/m
     * 
     */
    @XmlEnumValue("D3")
    D_3("D3"),

    /**
     * axle load: 22.5 t, meter load: 6.4 t/m
     * 
     */
    @XmlEnumValue("D2")
    D_2("D2"),

    /**
     * axle load: 20.0 t, meter load: 8.0 t/m
     * 
     */
    @XmlEnumValue("C4")
    C_4("C4"),

    /**
     * axle load: 20.0 t, meter load: 7.2 t/m
     * 
     */
    @XmlEnumValue("C3")
    C_3("C3"),

    /**
     * axle load: 20.0 t, meter load: 6.4 t/m
     * 
     */
    @XmlEnumValue("C2")
    C_2("C2"),

    /**
     * axle load: 18.0 t, meter load: 6.4 t/m
     * 
     */
    @XmlEnumValue("B2")
    B_2("B2"),

    /**
     * axle load: 18.0 t, meter load: 5.0 t/m
     * 
     */
    @XmlEnumValue("B1")
    B_1("B1"),

    /**
     * axle load: 16.0 t, meter load: 5.0 t/m
     * 
     */
    A("A");
    private final String value;

    TLineCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLineCategory fromValue(String v) {
        for (TLineCategory c: TLineCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
