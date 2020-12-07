//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMObjektzustand_Besonders.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMObjektzustand_Besonders">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="abgedeckt"/>
 *     &lt;enumeration value="ausser_Betrieb"/>
 *     &lt;enumeration value="ausser_Betrieb_vorbereitend"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMObjektzustand_Besonders")
@XmlEnum
public enum ENUMObjektzustandBesonders {

    @XmlEnumValue("abgedeckt")
    ABGEDECKT("abgedeckt"),
    @XmlEnumValue("ausser_Betrieb")
    AUSSER_BETRIEB("ausser_Betrieb"),
    @XmlEnumValue("ausser_Betrieb_vorbereitend")
    AUSSER_BETRIEB_VORBEREITEND("ausser_Betrieb_vorbereitend"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMObjektzustandBesonders(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMObjektzustandBesonders fromValue(String v) {
        for (ENUMObjektzustandBesonders c: ENUMObjektzustandBesonders.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
