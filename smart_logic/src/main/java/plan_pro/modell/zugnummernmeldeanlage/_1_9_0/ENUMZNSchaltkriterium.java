//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMZN_Schaltkriterium.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMZN_Schaltkriterium">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="kein"/>
 *     &lt;enumeration value="Signalhaltfall_Hauptsignal"/>
 *     &lt;enumeration value="Signalhaltfall_Rangiersignal"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Gleis_belegen"/>
 *     &lt;enumeration value="Gleis_belegen_und_davor_freifahren"/>
 *     &lt;enumeration value="Gleis_freifahren"/>
 *     &lt;enumeration value="manuell"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMZN_Schaltkriterium")
@XmlEnum
public enum ENUMZNSchaltkriterium {

    @XmlEnumValue("kein")
    KEIN("kein"),
    @XmlEnumValue("Signalhaltfall_Hauptsignal")
    SIGNALHALTFALL_HAUPTSIGNAL("Signalhaltfall_Hauptsignal"),
    @XmlEnumValue("Signalhaltfall_Rangiersignal")
    SIGNALHALTFALL_RANGIERSIGNAL("Signalhaltfall_Rangiersignal"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Gleis_belegen")
    GLEIS_BELEGEN("Gleis_belegen"),
    @XmlEnumValue("Gleis_belegen_und_davor_freifahren")
    GLEIS_BELEGEN_UND_DAVOR_FREIFAHREN("Gleis_belegen_und_davor_freifahren"),
    @XmlEnumValue("Gleis_freifahren")
    GLEIS_FREIFAHREN("Gleis_freifahren"),
    @XmlEnumValue("manuell")
    MANUELL("manuell");
    private final String value;

    ENUMZNSchaltkriterium(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMZNSchaltkriterium fromValue(String v) {
        for (ENUMZNSchaltkriterium c: ENUMZNSchaltkriterium.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
