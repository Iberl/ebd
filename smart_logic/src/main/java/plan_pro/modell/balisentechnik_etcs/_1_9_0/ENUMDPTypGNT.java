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
 * <p>Java-Klasse f�r ENUMDP_Typ_GNT.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMDP_Typ_GNT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="B1"/>
 *     &lt;enumeration value="B2"/>
 *     &lt;enumeration value="B3"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMDP_Typ_GNT")
@XmlEnum
public enum ENUMDPTypGNT {

    @XmlEnumValue("B1")
    B_1("B1"),
    @XmlEnumValue("B2")
    B_2("B2"),
    @XmlEnumValue("B3")
    B_3("B3"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMDPTypGNT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMDPTypGNT fromValue(String v) {
        for (ENUMDPTypGNT c: ENUMDPTypGNT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
