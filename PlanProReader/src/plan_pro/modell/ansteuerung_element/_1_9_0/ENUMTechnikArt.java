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
 * <p>Java-Klasse f�r ENUMTechnik_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTechnik_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="analog_FSK"/>
 *     &lt;enumeration value="Ethernet"/>
 *     &lt;enumeration value="G_703"/>
 *     &lt;enumeration value="SBI_intern_Kupferkabel"/>
 *     &lt;enumeration value="SBI_intern_LWL_Faser"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTechnik_Art")
@XmlEnum
public enum ENUMTechnikArt {

    @XmlEnumValue("analog_FSK")
    ANALOG_FSK("analog_FSK"),
    @XmlEnumValue("Ethernet")
    ETHERNET("Ethernet"),
    G_703("G_703"),
    @XmlEnumValue("SBI_intern_Kupferkabel")
    SBI_INTERN_KUPFERKABEL("SBI_intern_Kupferkabel"),
    @XmlEnumValue("SBI_intern_LWL_Faser")
    SBI_INTERN_LWL_FASER("SBI_intern_LWL_Faser"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMTechnikArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTechnikArt fromValue(String v) {
        for (ENUMTechnikArt c: ENUMTechnikArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
