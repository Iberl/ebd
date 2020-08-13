//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMTOP_Anschluss.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTOP_Anschluss">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ende"/>
 *     &lt;enumeration value="Ende_Bestdig"/>
 *     &lt;enumeration value="Links"/>
 *     &lt;enumeration value="Rechts"/>
 *     &lt;enumeration value="Schnitt"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Spitze"/>
 *     &lt;enumeration value="Verbindung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTOP_Anschluss")
@XmlEnum
public enum ENUMTOPAnschluss {

    @XmlEnumValue("Ende")
    ENDE("Ende"),
    @XmlEnumValue("Ende_Bestdig")
    ENDE_BESTDIG("Ende_Bestdig"),
    @XmlEnumValue("Links")
    LINKS("Links"),
    @XmlEnumValue("Rechts")
    RECHTS("Rechts"),
    @XmlEnumValue("Schnitt")
    SCHNITT("Schnitt"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Spitze")
    SPITZE("Spitze"),
    @XmlEnumValue("Verbindung")
    VERBINDUNG("Verbindung");
    private final String value;

    ENUMTOPAnschluss(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTOPAnschluss fromValue(String v) {
        for (ENUMTOPAnschluss c: ENUMTOPAnschluss.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
