//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.block._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBetriebsfuehrung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBetriebsfuehrung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="eingl"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Stichstreckenblock"/>
 *     &lt;enumeration value="ZLB"/>
 *     &lt;enumeration value="zweigl"/>
 *     &lt;enumeration value="zweigl_GWB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBetriebsfuehrung")
@XmlEnum
public enum ENUMBetriebsfuehrung {

    @XmlEnumValue("eingl")
    EINGL("eingl"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Stichstreckenblock")
    STICHSTRECKENBLOCK("Stichstreckenblock"),
    ZLB("ZLB"),
    @XmlEnumValue("zweigl")
    ZWEIGL("zweigl"),
    @XmlEnumValue("zweigl_GWB")
    ZWEIGL_GWB("zweigl_GWB");
    private final String value;

    ENUMBetriebsfuehrung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBetriebsfuehrung fromValue(String v) {
        for (ENUMBetriebsfuehrung c: ENUMBetriebsfuehrung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
