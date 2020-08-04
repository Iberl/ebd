//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMZN_Anlagentyp.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMZN_Anlagentyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZN_B950"/>
 *     &lt;enumeration value="ZN_SuB"/>
 *     &lt;enumeration value="ZNE_L2000"/>
 *     &lt;enumeration value="ZNL_2000"/>
 *     &lt;enumeration value="ZNL_800"/>
 *     &lt;enumeration value="ZNP_801"/>
 *     &lt;enumeration value="ZNS_801"/>
 *     &lt;enumeration value="ZNS_901"/>
 *     &lt;enumeration value="ZNS_901R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMZN_Anlagentyp")
@XmlEnum
public enum ENUMZNAnlagentyp {

    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("ZN_B950")
    ZN_B_950("ZN_B950"),
    @XmlEnumValue("ZN_SuB")
    ZN_SU_B("ZN_SuB"),
    @XmlEnumValue("ZNE_L2000")
    ZNE_L_2000("ZNE_L2000"),
    ZNL_2000("ZNL_2000"),
    ZNL_800("ZNL_800"),
    ZNP_801("ZNP_801"),
    ZNS_801("ZNS_801"),
    ZNS_901("ZNS_901"),
    @XmlEnumValue("ZNS_901R")
    ZNS_901_R("ZNS_901R");
    private final String value;

    ENUMZNAnlagentyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMZNAnlagentyp fromValue(String v) {
        for (ENUMZNAnlagentyp c: ENUMZNAnlagentyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
