//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMPlanung_G_Art_Besonders.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMPlanung_G_Art_Besonders">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bestandsdigitalisierung_Geo_Topo"/>
 *     &lt;enumeration value="Bestandsdigitalisierung_LST"/>
 *     &lt;enumeration value="Geodaten"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Verbindungsknoten"/>
 *     &lt;enumeration value="Versionshebung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMPlanung_G_Art_Besonders")
@XmlEnum
public enum ENUMPlanungGArtBesonders {

    @XmlEnumValue("Bestandsdigitalisierung_Geo_Topo")
    BESTANDSDIGITALISIERUNG_GEO_TOPO("Bestandsdigitalisierung_Geo_Topo"),
    @XmlEnumValue("Bestandsdigitalisierung_LST")
    BESTANDSDIGITALISIERUNG_LST("Bestandsdigitalisierung_LST"),
    @XmlEnumValue("Geodaten")
    GEODATEN("Geodaten"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Verbindungsknoten")
    VERBINDUNGSKNOTEN("Verbindungsknoten"),
    @XmlEnumValue("Versionshebung")
    VERSIONSHEBUNG("Versionshebung");
    private final String value;

    ENUMPlanungGArtBesonders(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMPlanungGArtBesonders fromValue(String v) {
        for (ENUMPlanungGArtBesonders c: ENUMPlanungGArtBesonders.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
