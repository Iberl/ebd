//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGleisart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGleisart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anschlussgleis"/>
 *     &lt;enumeration value="Durchgehendes_Hauptgleis"/>
 *     &lt;enumeration value="Hauptgleis"/>
 *     &lt;enumeration value="Nebengleis"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Streckengleis"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGleisart")
@XmlEnum
public enum ENUMGleisart {

    @XmlEnumValue("Anschlussgleis")
    ANSCHLUSSGLEIS("Anschlussgleis"),
    @XmlEnumValue("Durchgehendes_Hauptgleis")
    DURCHGEHENDES_HAUPTGLEIS("Durchgehendes_Hauptgleis"),
    @XmlEnumValue("Hauptgleis")
    HAUPTGLEIS("Hauptgleis"),
    @XmlEnumValue("Nebengleis")
    NEBENGLEIS("Nebengleis"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Streckengleis")
    STRECKENGLEIS("Streckengleis");
    private final String value;

    ENUMGleisart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGleisart fromValue(String v) {
        for (ENUMGleisart c: ENUMGleisart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
