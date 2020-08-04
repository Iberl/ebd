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
 * <p>Java-Klasse f�r ENUMTrasse_Knoten_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTrasse_Knoten_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Schacht"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Trassenabzweig"/>
 *     &lt;enumeration value="Trassenaenderung"/>
 *     &lt;enumeration value="Trassenauslass"/>
 *     &lt;enumeration value="Trassenende"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTrasse_Knoten_Art")
@XmlEnum
public enum ENUMTrasseKnotenArt {

    @XmlEnumValue("Schacht")
    SCHACHT("Schacht"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Trassenabzweig")
    TRASSENABZWEIG("Trassenabzweig"),
    @XmlEnumValue("Trassenaenderung")
    TRASSENAENDERUNG("Trassenaenderung"),
    @XmlEnumValue("Trassenauslass")
    TRASSENAUSLASS("Trassenauslass"),
    @XmlEnumValue("Trassenende")
    TRASSENENDE("Trassenende");
    private final String value;

    ENUMTrasseKnotenArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTrasseKnotenArt fromValue(String v) {
        for (ENUMTrasseKnotenArt c: ENUMTrasseKnotenArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
