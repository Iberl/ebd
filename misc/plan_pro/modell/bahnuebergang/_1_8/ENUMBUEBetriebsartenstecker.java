//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBUE_Betriebsartenstecker.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Betriebsartenstecker">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Betrieb"/>
 *     &lt;enumeration value="gesperrt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBUE_Betriebsartenstecker")
@XmlEnum
public enum ENUMBUEBetriebsartenstecker {

    @XmlEnumValue("Betrieb")
    BETRIEB("Betrieb"),
    @XmlEnumValue("gesperrt")
    GESPERRT("gesperrt");
    private final String value;

    ENUMBUEBetriebsartenstecker(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUEBetriebsartenstecker fromValue(String v) {
        for (ENUMBUEBetriebsartenstecker c: ENUMBUEBetriebsartenstecker.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
