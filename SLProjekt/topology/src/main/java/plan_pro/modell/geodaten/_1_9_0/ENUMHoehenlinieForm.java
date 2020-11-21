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
 * <p>Java-Klasse f�r ENUMHoehenlinie_Form.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMHoehenlinie_Form">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Gerade"/>
 *     &lt;enumeration value="Parabel"/>
 *     &lt;enumeration value="Weichenabzweig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMHoehenlinie_Form")
@XmlEnum
public enum ENUMHoehenlinieForm {

    @XmlEnumValue("Gerade")
    GERADE("Gerade"),
    @XmlEnumValue("Parabel")
    PARABEL("Parabel"),
    @XmlEnumValue("Weichenabzweig")
    WEICHENABZWEIG("Weichenabzweig");
    private final String value;

    ENUMHoehenlinieForm(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMHoehenlinieForm fromValue(String v) {
        for (ENUMHoehenlinieForm c: ENUMHoehenlinieForm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
