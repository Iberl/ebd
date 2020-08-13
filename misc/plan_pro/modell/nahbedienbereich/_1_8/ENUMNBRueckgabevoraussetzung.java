//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMNB_Rueckgabevoraussetzung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMNB_Rueckgabevoraussetzung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="abgelegt"/>
 *     &lt;enumeration value="aufgelegt"/>
 *     &lt;enumeration value="Hp_0"/>
 *     &lt;enumeration value="keine"/>
 *     &lt;enumeration value="Kennlicht"/>
 *     &lt;enumeration value="links"/>
 *     &lt;enumeration value="rechts"/>
 *     &lt;enumeration value="Schluessel_eingeschlossen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMNB_Rueckgabevoraussetzung")
@XmlEnum
public enum ENUMNBRueckgabevoraussetzung {

    @XmlEnumValue("abgelegt")
    ABGELEGT("abgelegt"),
    @XmlEnumValue("aufgelegt")
    AUFGELEGT("aufgelegt"),
    @XmlEnumValue("Hp_0")
    HP_0("Hp_0"),
    @XmlEnumValue("keine")
    KEINE("keine"),
    @XmlEnumValue("Kennlicht")
    KENNLICHT("Kennlicht"),
    @XmlEnumValue("links")
    LINKS("links"),
    @XmlEnumValue("rechts")
    RECHTS("rechts"),
    @XmlEnumValue("Schluessel_eingeschlossen")
    SCHLUESSEL_EINGESCHLOSSEN("Schluessel_eingeschlossen");
    private final String value;

    ENUMNBRueckgabevoraussetzung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMNBRueckgabevoraussetzung fromValue(String v) {
        for (ENUMNBRueckgabevoraussetzung c: ENUMNBRueckgabevoraussetzung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
