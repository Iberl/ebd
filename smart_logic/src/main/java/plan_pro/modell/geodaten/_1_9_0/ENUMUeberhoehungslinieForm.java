//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMUeberhoehungslinie_Form.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMUeberhoehungslinie_Form">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="gleichbleibend"/>
 *     &lt;enumeration value="Rampe_Bloss"/>
 *     &lt;enumeration value="Rampe_gerade"/>
 *     &lt;enumeration value="Rampe_S"/>
 *     &lt;enumeration value="Schere_Bloss"/>
 *     &lt;enumeration value="Schere_S"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMUeberhoehungslinie_Form")
@XmlEnum
public enum ENUMUeberhoehungslinieForm {

    @XmlEnumValue("gleichbleibend")
    GLEICHBLEIBEND("gleichbleibend"),
    @XmlEnumValue("Rampe_Bloss")
    RAMPE_BLOSS("Rampe_Bloss"),
    @XmlEnumValue("Rampe_gerade")
    RAMPE_GERADE("Rampe_gerade"),
    @XmlEnumValue("Rampe_S")
    RAMPE_S("Rampe_S"),
    @XmlEnumValue("Schere_Bloss")
    SCHERE_BLOSS("Schere_Bloss"),
    @XmlEnumValue("Schere_S")
    SCHERE_S("Schere_S");
    private final String value;

    ENUMUeberhoehungslinieForm(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMUeberhoehungslinieForm fromValue(String v) {
        for (ENUMUeberhoehungslinieForm c: ENUMUeberhoehungslinieForm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
