//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFMA_Element_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFMA_Element_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anschlussseile"/>
 *     &lt;enumeration value="Drosselspule"/>
 *     &lt;enumeration value="S_Verbinder"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Endverbinder"/>
 *     &lt;enumeration value="Endverbinder_modifiziert"/>
 *     &lt;enumeration value="Kurzschlussverbinder"/>
 *     &lt;enumeration value="Ueberlagerungsverbinder"/>
 *     &lt;enumeration value="Potentialausgleichsverbinder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFMA_Element_Art")
@XmlEnum
public enum ENUMFMAElementArt {

    @XmlEnumValue("Anschlussseile")
    ANSCHLUSSSEILE("Anschlussseile"),
    @XmlEnumValue("Drosselspule")
    DROSSELSPULE("Drosselspule"),
    @XmlEnumValue("S_Verbinder")
    S_VERBINDER("S_Verbinder"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Endverbinder")
    ENDVERBINDER("Endverbinder"),
    @XmlEnumValue("Endverbinder_modifiziert")
    ENDVERBINDER_MODIFIZIERT("Endverbinder_modifiziert"),
    @XmlEnumValue("Kurzschlussverbinder")
    KURZSCHLUSSVERBINDER("Kurzschlussverbinder"),
    @XmlEnumValue("Ueberlagerungsverbinder")
    UEBERLAGERUNGSVERBINDER("Ueberlagerungsverbinder"),
    @XmlEnumValue("Potentialausgleichsverbinder")
    POTENTIALAUSGLEICHSVERBINDER("Potentialausgleichsverbinder");
    private final String value;

    ENUMFMAElementArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFMAElementArt fromValue(String v) {
        for (ENUMFMAElementArt c: ENUMFMAElementArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
