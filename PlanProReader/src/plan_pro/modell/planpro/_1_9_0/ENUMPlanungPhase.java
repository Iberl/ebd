//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMPlanung_Phase.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMPlanung_Phase">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EP"/>
 *     &lt;enumeration value="PT_1"/>
 *     &lt;enumeration value="PT_2"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="VP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMPlanung_Phase")
@XmlEnum
public enum ENUMPlanungPhase {

    EP("EP"),
    PT_1("PT_1"),
    PT_2("PT_2"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    VP("VP");
    private final String value;

    ENUMPlanungPhase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMPlanungPhase fromValue(String v) {
        for (ENUMPlanungPhase c: ENUMPlanungPhase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
