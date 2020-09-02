//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMPlan_Quelle.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMPlan_Quelle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GIS"/>
 *     &lt;enumeration value="GND"/>
 *     &lt;enumeration value="Ivl"/>
 *     &lt;enumeration value="Ivmg"/>
 *     &lt;enumeration value="Kopie"/>
 *     &lt;enumeration value="Neutrassierung"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="GND_autokorr"/>
 *     &lt;enumeration value="GND_mankorr"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMPlan_Quelle")
@XmlEnum
public enum ENUMPlanQuelle {

    GIS("GIS"),
    GND("GND"),
    @XmlEnumValue("Ivl")
    IVL("Ivl"),
    @XmlEnumValue("Ivmg")
    IVMG("Ivmg"),
    @XmlEnumValue("Kopie")
    KOPIE("Kopie"),
    @XmlEnumValue("Neutrassierung")
    NEUTRASSIERUNG("Neutrassierung"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("GND_autokorr")
    GND_AUTOKORR("GND_autokorr"),
    @XmlEnumValue("GND_mankorr")
    GND_MANKORR("GND_mankorr");
    private final String value;

    ENUMPlanQuelle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMPlanQuelle fromValue(String v) {
        for (ENUMPlanQuelle c: ENUMPlanQuelle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
