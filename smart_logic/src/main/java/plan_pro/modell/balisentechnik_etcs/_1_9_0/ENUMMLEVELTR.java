//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMM_LEVELTR.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMM_LEVELTR">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="L0"/>
 *     &lt;enumeration value="L1"/>
 *     &lt;enumeration value="L2"/>
 *     &lt;enumeration value="L3"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="STM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMM_LEVELTR")
@XmlEnum
public enum ENUMMLEVELTR {

    @XmlEnumValue("L0")
    L_0("L0"),
    @XmlEnumValue("L1")
    L_1("L1"),
    @XmlEnumValue("L2")
    L_2("L2"),
    @XmlEnumValue("L3")
    L_3("L3"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    STM("STM");
    private final String value;

    ENUMMLEVELTR(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMMLEVELTR fromValue(String v) {
        for (ENUMMLEVELTR c: ENUMMLEVELTR.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
