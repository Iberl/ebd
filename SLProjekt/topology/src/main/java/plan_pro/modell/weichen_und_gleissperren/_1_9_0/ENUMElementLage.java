//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMElement_Lage.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMElement_Lage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Abschnitt"/>
 *     &lt;enumeration value="Weiche"/>
 *     &lt;enumeration value="WeicheL"/>
 *     &lt;enumeration value="WeicheR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMElement_Lage")
@XmlEnum
public enum ENUMElementLage {

    @XmlEnumValue("Abschnitt")
    ABSCHNITT("Abschnitt"),
    @XmlEnumValue("Weiche")
    WEICHE("Weiche"),
    @XmlEnumValue("WeicheL")
    WEICHE_L("WeicheL"),
    @XmlEnumValue("WeicheR")
    WEICHE_R("WeicheR");
    private final String value;

    ENUMElementLage(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMElementLage fromValue(String v) {
        for (ENUMElementLage c: ENUMElementLage.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
