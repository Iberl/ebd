//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMEnergie_Eingang_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMEnergie_Eingang_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Brennstoffzelle"/>
 *     &lt;enumeration value="Fahrleitung"/>
 *     &lt;enumeration value="Landesnetz"/>
 *     &lt;enumeration value="Solar"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMEnergie_Eingang_Art")
@XmlEnum
public enum ENUMEnergieEingangArt {

    @XmlEnumValue("Brennstoffzelle")
    BRENNSTOFFZELLE("Brennstoffzelle"),
    @XmlEnumValue("Fahrleitung")
    FAHRLEITUNG("Fahrleitung"),
    @XmlEnumValue("Landesnetz")
    LANDESNETZ("Landesnetz"),
    @XmlEnumValue("Solar")
    SOLAR("Solar"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMEnergieEingangArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMEnergieEingangArt fromValue(String v) {
        for (ENUMEnergieEingangArt c: ENUMEnergieEingangArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
