//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMMedium_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMMedium_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Kupfer_ADO8"/>
 *     &lt;enumeration value="Kupfer_KAG"/>
 *     &lt;enumeration value="Kupfer_LSA_Plus"/>
 *     &lt;enumeration value="Kupfer_RJ45"/>
 *     &lt;enumeration value="LWL_DIN"/>
 *     &lt;enumeration value="LWL_E2000"/>
 *     &lt;enumeration value="LWL_SC_LC"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMMedium_Art")
@XmlEnum
public enum ENUMMediumArt {

    @XmlEnumValue("Kupfer_ADO8")
    KUPFER_ADO_8("Kupfer_ADO8"),
    @XmlEnumValue("Kupfer_KAG")
    KUPFER_KAG("Kupfer_KAG"),
    @XmlEnumValue("Kupfer_LSA_Plus")
    KUPFER_LSA_PLUS("Kupfer_LSA_Plus"),
    @XmlEnumValue("Kupfer_RJ45")
    KUPFER_RJ_45("Kupfer_RJ45"),
    LWL_DIN("LWL_DIN"),
    @XmlEnumValue("LWL_E2000")
    LWL_E_2000("LWL_E2000"),
    LWL_SC_LC("LWL_SC_LC"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMMediumArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMMediumArt fromValue(String v) {
        for (ENUMMediumArt c: ENUMMediumArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
