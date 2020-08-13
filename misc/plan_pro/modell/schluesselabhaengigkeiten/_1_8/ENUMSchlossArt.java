//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.schluesselabhaengigkeiten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSchloss_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSchloss_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HV_73"/>
 *     &lt;enumeration value="Riegelhandschloss"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Weichenschloss"/>
 *     &lt;enumeration value="Zungensperre"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSchloss_Art")
@XmlEnum
public enum ENUMSchlossArt {

    HV_73("HV_73"),
    @XmlEnumValue("Riegelhandschloss")
    RIEGELHANDSCHLOSS("Riegelhandschloss"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Weichenschloss")
    WEICHENSCHLOSS("Weichenschloss"),
    @XmlEnumValue("Zungensperre")
    ZUNGENSPERRE("Zungensperre");
    private final String value;

    ENUMSchlossArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSchlossArt fromValue(String v) {
        for (ENUMSchlossArt c: ENUMSchlossArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
