//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMRichtungspfeil.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMRichtungspfeil">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="linksweisend"/>
 *     &lt;enumeration value="rechtsweisend"/>
 *     &lt;enumeration value="Richtung_Gefahrenstelle_links"/>
 *     &lt;enumeration value="Richtung_Gefahrenstelle_rechts"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMRichtungspfeil")
@XmlEnum
public enum ENUMRichtungspfeil {

    @XmlEnumValue("linksweisend")
    LINKSWEISEND("linksweisend"),
    @XmlEnumValue("rechtsweisend")
    RECHTSWEISEND("rechtsweisend"),
    @XmlEnumValue("Richtung_Gefahrenstelle_links")
    RICHTUNG_GEFAHRENSTELLE_LINKS("Richtung_Gefahrenstelle_links"),
    @XmlEnumValue("Richtung_Gefahrenstelle_rechts")
    RICHTUNG_GEFAHRENSTELLE_RECHTS("Richtung_Gefahrenstelle_rechts"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMRichtungspfeil(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMRichtungspfeil fromValue(String v) {
        for (ENUMRichtungspfeil c: ENUMRichtungspfeil.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
