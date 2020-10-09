//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ENUMV_Profil_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMV_Profil_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ETCS"/>
 *     &lt;enumeration value="konventionell"/>
 *     &lt;enumeration value="Neitec"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="windabhängig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMV_Profil_Art")
@XmlEnum
public enum ENUMVProfilArt {

    ETCS("ETCS"),
    @XmlEnumValue("konventionell")
    KONVENTIONELL("konventionell"),
    @XmlEnumValue("Neitec")
    NEITEC("Neitec"),
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
