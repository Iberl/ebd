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
 * <p>Java-Klasse f�r ENUMFuss_Radweg_Seite.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFuss_Radweg_Seite">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="beidseitig"/>
 *     &lt;enumeration value="Quadrant_1_2"/>
 *     &lt;enumeration value="Quadrant_3_4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFuss_Radweg_Seite")
@XmlEnum
public enum ENUMFussRadwegSeite {

    @XmlEnumValue("beidseitig")
    BEIDSEITIG("beidseitig"),
    @XmlEnumValue("Quadrant_1_2")
    QUADRANT_1_2("Quadrant_1_2"),
    @XmlEnumValue("Quadrant_3_4")
    QUADRANT_3_4("Quadrant_3_4");
    private final String value;

    ENUMFussRadwegSeite(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFussRadwegSeite fromValue(String v) {
        for (ENUMFussRadwegSeite c: ENUMFussRadwegSeite.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
