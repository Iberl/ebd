//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMKabel_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMKabel_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Energie 400V AC"/>
 *     &lt;enumeration value="Energie 750V DC"/>
 *     &lt;enumeration value="LWL"/>
 *     &lt;enumeration value="Signalkabel adrig"/>
 *     &lt;enumeration value="Signalkabel Sternvierer"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMKabel_Art")
@XmlEnum
public enum ENUMKabelArt {

    @XmlEnumValue("Energie 400V AC")
    ENERGIE_400_V_AC("Energie 400V AC"),
    @XmlEnumValue("Energie 750V DC")
    ENERGIE_750_V_DC("Energie 750V DC"),
    LWL("LWL"),
    @XmlEnumValue("Signalkabel adrig")
    SIGNALKABEL_ADRIG("Signalkabel adrig"),
    @XmlEnumValue("Signalkabel Sternvierer")
    SIGNALKABEL_STERNVIERER("Signalkabel Sternvierer"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMKabelArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMKabelArt fromValue(String v) {
        for (ENUMKabelArt c: ENUMKabelArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
