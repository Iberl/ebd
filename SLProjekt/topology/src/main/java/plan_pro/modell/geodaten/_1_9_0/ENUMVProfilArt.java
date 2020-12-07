//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMV_Profil_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMV_Profil_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="anzeigegef�hrt"/>
 *     &lt;enumeration value="signalgef�hrt"/>
 *     &lt;enumeration value="signalgef�hrt ES"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="windabh�ngig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMV_Profil_Art")
@XmlEnum
public enum ENUMVProfilArt {

    @XmlEnumValue("anzeigegefuehrt")
    ANZEIGEGEFUEHRT("anzeigegefuert"),
    @XmlEnumValue("signalgefuert")
    SIGNALGEFUEHRT("signalgefuehrt"),
    @XmlEnumValue("signalgefuehrt ES")
    SIGNALGEFUEHRT_ES("signalgefuehrt ES"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("windabhaengig")
    WINDABHAENGIG("windabhaengig");
    private final String value;

    ENUMVProfilArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMVProfilArt fromValue(String v) {
        for (ENUMVProfilArt c: ENUMVProfilArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
