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
 * <p>Java-Klasse f�r ENUMEV_Modul_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMEV_Modul_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="autonom"/>
 *     &lt;enumeration value="autonom klein"/>
 *     &lt;enumeration value="netzgebunden"/>
 *     &lt;enumeration value="PoP-V"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMEV_Modul_Art")
@XmlEnum
public enum ENUMEVModulArt {

    @XmlEnumValue("autonom")
    AUTONOM("autonom"),
    @XmlEnumValue("autonom klein")
    AUTONOM_KLEIN("autonom klein"),
    @XmlEnumValue("netzgebunden")
    NETZGEBUNDEN("netzgebunden"),
    @XmlEnumValue("PoP-V")
    PO_P_V("PoP-V"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMEVModulArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMEVModulArt fromValue(String v) {
        for (ENUMEVModulArt c: ENUMEVModulArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
