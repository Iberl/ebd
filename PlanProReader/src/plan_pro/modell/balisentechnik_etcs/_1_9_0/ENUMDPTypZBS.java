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
 * <p>Java-Klasse f�r ENUMDP_Typ_ZBS.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMDP_Typ_ZBS">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RBE"/>
 *     &lt;enumeration value="RS"/>
 *     &lt;enumeration value="RSp"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZA"/>
 *     &lt;enumeration value="ZBbP"/>
 *     &lt;enumeration value="ZBP"/>
 *     &lt;enumeration value="ZF"/>
 *     &lt;enumeration value="ZH"/>
 *     &lt;enumeration value="ZHF"/>
 *     &lt;enumeration value="ZLiH"/>
 *     &lt;enumeration value="ZLiV"/>
 *     &lt;enumeration value="ZO"/>
 *     &lt;enumeration value="ZRE"/>
 *     &lt;enumeration value="ZRH"/>
 *     &lt;enumeration value="ZRHF"/>
 *     &lt;enumeration value="ZRLa"/>
 *     &lt;enumeration value="ZRV"/>
 *     &lt;enumeration value="Z�"/>
 *     &lt;enumeration value="ZV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMDP_Typ_ZBS")
@XmlEnum
public enum ENUMDPTypZBS {

    RBE("RBE"),
    RS("RS"),
    @XmlEnumValue("RSp")
    R_SP("RSp"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    ZA("ZA"),
    @XmlEnumValue("ZBbP")
    Z_BB_P("ZBbP"),
    ZBP("ZBP"),
    ZF("ZF"),
    ZH("ZH"),
    ZHF("ZHF"),
    @XmlEnumValue("ZLiH")
    Z_LI_H("ZLiH"),
    @XmlEnumValue("ZLiV")
    Z_LI_V("ZLiV"),
    ZO("ZO"),
    ZRE("ZRE"),
    ZRH("ZRH"),
    ZRHF("ZRHF"),
    @XmlEnumValue("ZRLa")
    ZR_LA("ZRLa"),
    ZRV("ZRV"),
    ZUE("ZUE"),
    ZV("ZV");
    private final String value;

    ENUMDPTypZBS(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMDPTypZBS fromValue(String v) {
        for (ENUMDPTypZBS c: ENUMDPTypZBS.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
