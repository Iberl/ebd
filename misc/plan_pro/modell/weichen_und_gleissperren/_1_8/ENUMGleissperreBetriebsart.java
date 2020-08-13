//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGleissperre_Betriebsart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGleissperre_Betriebsart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="abgelegt"/>
 *     &lt;enumeration value="aufgelegt"/>
 *     &lt;enumeration value="Betrieb"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGleissperre_Betriebsart")
@XmlEnum
public enum ENUMGleissperreBetriebsart {

    @XmlEnumValue("abgelegt")
    ABGELEGT("abgelegt"),
    @XmlEnumValue("aufgelegt")
    AUFGELEGT("aufgelegt"),
    @XmlEnumValue("Betrieb")
    BETRIEB("Betrieb");
    private final String value;

    ENUMGleissperreBetriebsart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGleissperreBetriebsart fromValue(String v) {
        for (ENUMGleissperreBetriebsart c: ENUMGleissperreBetriebsart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
