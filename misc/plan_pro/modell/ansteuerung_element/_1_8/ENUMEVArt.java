//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMEV_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMEV_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="andere_Aussenelementansteuerung"/>
 *     &lt;enumeration value="Batterie"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="BUE"/>
 *     &lt;enumeration value="ESTW_Zentraleinheit"/>
 *     &lt;enumeration value="Fahrleitung"/>
 *     &lt;enumeration value="Landesnetz"/>
 *     &lt;enumeration value="Notstromaggregat"/>
 *     &lt;enumeration value="Notstromanschluss"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMEV_Art")
@XmlEnum
public enum ENUMEVArt {

    @XmlEnumValue("andere_Aussenelementansteuerung")
    ANDERE_AUSSENELEMENTANSTEUERUNG("andere_Aussenelementansteuerung"),
    @XmlEnumValue("Batterie")
    BATTERIE("Batterie"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    BUE("BUE"),
    @XmlEnumValue("ESTW_Zentraleinheit")
    ESTW_ZENTRALEINHEIT("ESTW_Zentraleinheit"),
    @XmlEnumValue("Fahrleitung")
    FAHRLEITUNG("Fahrleitung"),
    @XmlEnumValue("Landesnetz")
    LANDESNETZ("Landesnetz"),
    @XmlEnumValue("Notstromaggregat")
    NOTSTROMAGGREGAT("Notstromaggregat"),
    @XmlEnumValue("Notstromanschluss")
    NOTSTROMANSCHLUSS("Notstromanschluss");
    private final String value;

    ENUMEVArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMEVArt fromValue(String v) {
        for (ENUMEVArt c: ENUMEVArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
