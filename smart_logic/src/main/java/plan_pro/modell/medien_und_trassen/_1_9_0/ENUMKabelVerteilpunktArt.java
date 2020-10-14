//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMKabel_Verteilpunkt_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMKabel_Verteilpunkt_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Kabelschrank"/>
 *     &lt;enumeration value="Kabelverteiler"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMKabel_Verteilpunkt_Art")
@XmlEnum
public enum ENUMKabelVerteilpunktArt {

    @XmlEnumValue("Kabelschrank")
    KABELSCHRANK("Kabelschrank"),
    @XmlEnumValue("Kabelverteiler")
    KABELVERTEILER("Kabelverteiler"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMKabelVerteilpunktArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMKabelVerteilpunktArt fromValue(String v) {
        for (ENUMKabelVerteilpunktArt c: ENUMKabelVerteilpunktArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
