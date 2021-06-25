//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMOptik_Symbol.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMOptik_Symbol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fussgaenger"/>
 *     &lt;enumeration value="Fussgaenger_Radfahrer"/>
 *     &lt;enumeration value="Pfeil_links"/>
 *     &lt;enumeration value="Pfeil_rechts"/>
 *     &lt;enumeration value="Radfahrer"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMOptik_Symbol")
@XmlEnum
public enum ENUMOptikSymbol {

    @XmlEnumValue("Fussgaenger")
    FUSSGAENGER("Fussgaenger"),
    @XmlEnumValue("Fussgaenger_Radfahrer")
    FUSSGAENGER_RADFAHRER("Fussgaenger_Radfahrer"),
    @XmlEnumValue("Pfeil_links")
    PFEIL_LINKS("Pfeil_links"),
    @XmlEnumValue("Pfeil_rechts")
    PFEIL_RECHTS("Pfeil_rechts"),
    @XmlEnumValue("Radfahrer")
    RADFAHRER("Radfahrer"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMOptikSymbol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMOptikSymbol fromValue(String v) {
        for (ENUMOptikSymbol c: ENUMOptikSymbol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
