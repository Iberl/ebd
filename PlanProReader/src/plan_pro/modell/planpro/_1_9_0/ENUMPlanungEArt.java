//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMPlanung_E_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMPlanung_E_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bauzustand"/>
 *     &lt;enumeration value="Bestandsdigitalisierung_Geo_Topo"/>
 *     &lt;enumeration value="Bestandsdigitalisierung_LST"/>
 *     &lt;enumeration value="Bestandskorrektur"/>
 *     &lt;enumeration value="Geodaten"/>
 *     &lt;enumeration value="Revision"/>
 *     &lt;enumeration value="Revision_letzte_Planung_E"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Verbindungsknoten"/>
 *     &lt;enumeration value="Versionshebung"/>
 *     &lt;enumeration value="Voraussichtlich"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMPlanung_E_Art")
@XmlEnum
public enum ENUMPlanungEArt {

    @XmlEnumValue("Bauzustand")
    BAUZUSTAND("Bauzustand"),
    @XmlEnumValue("Bestandsdigitalisierung_Geo_Topo")
    BESTANDSDIGITALISIERUNG_GEO_TOPO("Bestandsdigitalisierung_Geo_Topo"),
    @XmlEnumValue("Bestandsdigitalisierung_LST")
    BESTANDSDIGITALISIERUNG_LST("Bestandsdigitalisierung_LST"),
    @XmlEnumValue("Bestandskorrektur")
    BESTANDSKORREKTUR("Bestandskorrektur"),
    @XmlEnumValue("Geodaten")
    GEODATEN("Geodaten"),
    @XmlEnumValue("Revision")
    REVISION("Revision"),
    @XmlEnumValue("Revision_letzte_Planung_E")
    REVISION_LETZTE_PLANUNG_E("Revision_letzte_Planung_E"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Verbindungsknoten")
    VERBINDUNGSKNOTEN("Verbindungsknoten"),
    @XmlEnumValue("Versionshebung")
    VERSIONSHEBUNG("Versionshebung"),
    @XmlEnumValue("Voraussichtlich")
    VORAUSSICHTLICH("Voraussichtlich");
    private final String value;

    ENUMPlanungEArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMPlanungEArt fromValue(String v) {
        for (ENUMPlanungEArt c: ENUMPlanungEArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
