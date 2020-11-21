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
 * <p>Java-Klasse f�r ENUMZBS_Schnittstelle.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMZBS_Schnittstelle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Comserver"/>
 *     &lt;enumeration value="LOGEM_LGM_28_8_D1"/>
 *     &lt;enumeration value="NOKIA_ECM_FAST_14400"/>
 *     &lt;enumeration value="NOKIA_ECM_FAST_19200"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMZBS_Schnittstelle")
@XmlEnum
public enum ENUMZBSSchnittstelle {

    @XmlEnumValue("Comserver")
    COMSERVER("Comserver"),
    @XmlEnumValue("LOGEM_LGM_28_8_D1")
    LOGEM_LGM_28_8_D_1("LOGEM_LGM_28_8_D1"),
    NOKIA_ECM_FAST_14400("NOKIA_ECM_FAST_14400"),
    NOKIA_ECM_FAST_19200("NOKIA_ECM_FAST_19200"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMZBSSchnittstelle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMZBSSchnittstelle fromValue(String v) {
        for (ENUMZBSSchnittstelle c: ENUMZBSSchnittstelle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
