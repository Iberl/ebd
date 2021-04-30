//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMStandortangabe_Balisenschild.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMStandortangabe_Balisenschild">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Signal"/>
 *     &lt;enumeration value="Signal Gleis"/>
 *     &lt;enumeration value="Streckenkilometer Gleis"/>
 *     &lt;enumeration value="Strecke sonstiger Standort"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMStandortangabe_Balisenschild")
@XmlEnum
public enum ENUMStandortangabeBalisenschild {

    @XmlEnumValue("Signal")
    SIGNAL("Signal"),
    @XmlEnumValue("Signal Gleis")
    SIGNAL_GLEIS("Signal Gleis"),
    @XmlEnumValue("Streckenkilometer Gleis")
    STRECKENKILOMETER_GLEIS("Streckenkilometer Gleis"),
    @XmlEnumValue("Strecke sonstiger Standort")
    STRECKE_SONSTIGER_STANDORT("Strecke sonstiger Standort");
    private final String value;

    ENUMStandortangabeBalisenschild(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMStandortangabeBalisenschild fromValue(String v) {
        for (ENUMStandortangabeBalisenschild c: ENUMStandortangabeBalisenschild.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
