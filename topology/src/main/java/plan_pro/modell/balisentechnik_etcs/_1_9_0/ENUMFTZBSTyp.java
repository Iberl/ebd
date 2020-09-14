//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFT_ZBS_Typ.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFT_ZBS_Typ">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="RBE"/>
 *     &lt;enumeration value="RS"/>
 *     &lt;enumeration value="RSp"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="TLa"/>
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
@XmlType(name = "ENUMFT_ZBS_Typ")
@XmlEnum
public enum ENUMFTZBSTyp {

    @XmlEnumValue("Null")
    NULL("Null"),
    RBE("RBE"),
    RS("RS"),
    @XmlEnumValue("RSp")
    R_SP("RSp"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("TLa")
    T_LA("TLa"),
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

    ENUMFTZBSTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFTZBSTyp fromValue(String v) {
        for (ENUMFTZBSTyp c: ENUMFTZBSTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
