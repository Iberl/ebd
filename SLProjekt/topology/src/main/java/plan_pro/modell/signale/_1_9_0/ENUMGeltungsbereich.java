//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGeltungsbereich.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGeltungsbereich">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DS"/>
 *     &lt;enumeration value="DV"/>
 *     &lt;enumeration value="S-Bahn B"/>
 *     &lt;enumeration value="S-Bahn HH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGeltungsbereich")
@XmlEnum
public enum ENUMGeltungsbereich {

    DS("DS"),
    DV("DV"),
    @XmlEnumValue("S-Bahn B")
    S_BAHN_B("S-Bahn B"),
    @XmlEnumValue("S-Bahn HH")
    S_BAHN_HH("S-Bahn HH");
    private final String value;

    ENUMGeltungsbereich(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGeltungsbereich fromValue(String v) {
        for (ENUMGeltungsbereich c: ENUMGeltungsbereich.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
