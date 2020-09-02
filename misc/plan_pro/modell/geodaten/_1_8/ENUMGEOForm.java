//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGEO_Form.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGEO_Form">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bloss_einfach_geschwungen"/>
 *     &lt;enumeration value="Km_Sprung"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Blosskurve"/>
 *     &lt;enumeration value="Bogen"/>
 *     &lt;enumeration value="Gerade"/>
 *     &lt;enumeration value="Klothoide"/>
 *     &lt;enumeration value="Uebergangsbogen_S_Form"/>
 *     &lt;enumeration value="Richtgerade_Knick_am_Ende_200_gon"/>
 *     &lt;enumeration value="S_Form_einfach_geschwungen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGEO_Form")
@XmlEnum
public enum ENUMGEOForm {

    @XmlEnumValue("Bloss_einfach_geschwungen")
    BLOSS_EINFACH_GESCHWUNGEN("Bloss_einfach_geschwungen"),
    @XmlEnumValue("Km_Sprung")
    KM_SPRUNG("Km_Sprung"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Blosskurve")
    BLOSSKURVE("Blosskurve"),
    @XmlEnumValue("Bogen")
    BOGEN("Bogen"),
    @XmlEnumValue("Gerade")
    GERADE("Gerade"),
    @XmlEnumValue("Klothoide")
    KLOTHOIDE("Klothoide"),
    @XmlEnumValue("Uebergangsbogen_S_Form")
    UEBERGANGSBOGEN_S_FORM("Uebergangsbogen_S_Form"),
    @XmlEnumValue("Richtgerade_Knick_am_Ende_200_gon")
    RICHTGERADE_KNICK_AM_ENDE_200_GON("Richtgerade_Knick_am_Ende_200_gon"),
    @XmlEnumValue("S_Form_einfach_geschwungen")
    S_FORM_EINFACH_GESCHWUNGEN("S_Form_einfach_geschwungen");
    private final String value;

    ENUMGEOForm(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGEOForm fromValue(String v) {
        for (ENUMGEOForm c: ENUMGEOForm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
