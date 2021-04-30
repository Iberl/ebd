//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMNB_Grenze_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMNB_Grenze_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ESTW_Bereich"/>
 *     &lt;enumeration value="NB_Zone"/>
 *     &lt;enumeration value="Ortsstellbereich"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMNB_Grenze_Art")
@XmlEnum
public enum ENUMNBGrenzeArt {

    @XmlEnumValue("ESTW_Bereich")
    ESTW_BEREICH("ESTW_Bereich"),
    @XmlEnumValue("NB_Zone")
    NB_ZONE("NB_Zone"),
    @XmlEnumValue("Ortsstellbereich")
    ORTSSTELLBEREICH("Ortsstellbereich");
    private final String value;

    ENUMNBGrenzeArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMNBGrenzeArt fromValue(String v) {
        for (ENUMNBGrenzeArt c: ENUMNBGrenzeArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
