//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSchienenprofil.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSchienenprofil">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="R65"/>
 *     &lt;enumeration value="S49"/>
 *     &lt;enumeration value="S54"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="UIC60"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSchienenprofil")
@XmlEnum
public enum ENUMSchienenprofil {

    @XmlEnumValue("R65")
    R_65("R65"),
    @XmlEnumValue("S49")
    S_49("S49"),
    @XmlEnumValue("S54")
    S_54("S54"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("UIC60")
    UIC_60("UIC60");
    private final String value;

    ENUMSchienenprofil(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSchienenprofil fromValue(String v) {
        for (ENUMSchienenprofil c: ENUMSchienenprofil.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
