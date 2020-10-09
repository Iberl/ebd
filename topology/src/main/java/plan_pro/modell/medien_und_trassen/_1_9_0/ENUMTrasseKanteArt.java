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
 * <p>Java-Klasse f�r ENUMTrasse_Kante_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTrasse_Kante_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Erdtrasse"/>
 *     &lt;enumeration value="frei"/>
 *     &lt;enumeration value="Lufttrasse"/>
 *     &lt;enumeration value="Rohrtrasse"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Trogtrasse"/>
 *     &lt;enumeration value="Trogtrasse_aufgestaendert"/>
 *     &lt;enumeration value="Trogtrasse_Behelf"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTrasse_Kante_Art")
@XmlEnum
public enum ENUMTrasseKanteArt {

    @XmlEnumValue("Erdtrasse")
    ERDTRASSE("Erdtrasse"),
    @XmlEnumValue("frei")
    FREI("frei"),
    @XmlEnumValue("Lufttrasse")
    LUFTTRASSE("Lufttrasse"),
    @XmlEnumValue("Rohrtrasse")
    ROHRTRASSE("Rohrtrasse"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Trogtrasse")
    TROGTRASSE("Trogtrasse"),
    @XmlEnumValue("Trogtrasse_aufgestaendert")
    TROGTRASSE_AUFGESTAENDERT("Trogtrasse_aufgestaendert"),
    @XmlEnumValue("Trogtrasse_Behelf")
    TROGTRASSE_BEHELF("Trogtrasse_Behelf");
    private final String value;

    ENUMTrasseKanteArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTrasseKanteArt fromValue(String v) {
        for (ENUMTrasseKanteArt c: ENUMTrasseKanteArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
