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
 * <p>Java-Klasse f�r ENUMLEU_Modul_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMLEU_Modul_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LEU-P"/>
 *     &lt;enumeration value="Voll-LEU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMLEU_Modul_Art")
@XmlEnum
public enum ENUMLEUModulArt {

    @XmlEnumValue("LEU-P")
    LEU_P("LEU-P"),
    @XmlEnumValue("Voll-LEU")
    VOLL_LEU("Voll-LEU");
    private final String value;

    ENUMLEUModulArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMLEUModulArt fromValue(String v) {
        for (ENUMLEUModulArt c: ENUMLEUModulArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
