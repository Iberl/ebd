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
 * <p>Java-Klasse f�r ENUMEV_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMEV_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="andere_Aussenelementansteuerung"/>
 *     &lt;enumeration value="FeAk_400V_DC_direkt"/>
 *     &lt;enumeration value="FeAk_750V_DC_Energiebus"/>
 *     &lt;enumeration value="Landesnetz_VNB"/>
 *     &lt;enumeration value="Notstromaggregat_NEA_mobil"/>
 *     &lt;enumeration value="Notstromaggregat_NEA_stationaer"/>
 *     &lt;enumeration value="Solar"/>
 *     &lt;enumeration value="Batterie"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="BUE"/>
 *     &lt;enumeration value="ESTW_Zentraleinheit"/>
 *     &lt;enumeration value="Fahrleitung"/>
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
    @XmlEnumValue("FeAk_400V_DC_direkt")
    FE_AK_400_V_DC_DIREKT("FeAk_400V_DC_direkt"),
    @XmlEnumValue("FeAk_750V_DC_Energiebus")
    FE_AK_750_V_DC_ENERGIEBUS("FeAk_750V_DC_Energiebus"),
    @XmlEnumValue("Landesnetz_VNB")
    LANDESNETZ_VNB("Landesnetz_VNB"),
    @XmlEnumValue("Notstromaggregat_NEA_mobil")
    NOTSTROMAGGREGAT_NEA_MOBIL("Notstromaggregat_NEA_mobil"),
    @XmlEnumValue("Notstromaggregat_NEA_stationaer")
    NOTSTROMAGGREGAT_NEA_STATIONAER("Notstromaggregat_NEA_stationaer"),
    @XmlEnumValue("Solar")
    SOLAR("Solar"),
    @XmlEnumValue("Batterie")
    BATTERIE("Batterie"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    BUE("BUE"),
    @XmlEnumValue("ESTW_Zentraleinheit")
    ESTW_ZENTRALEINHEIT("ESTW_Zentraleinheit"),
    @XmlEnumValue("Fahrleitung")
    FAHRLEITUNG("Fahrleitung");
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
