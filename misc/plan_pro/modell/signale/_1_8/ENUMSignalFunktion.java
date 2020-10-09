//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSignal_Funktion.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSignal_Funktion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Alleinstehendes_Zusatzsignal"/>
 *     &lt;enumeration value="andere"/>
 *     &lt;enumeration value="Ausfahr_Signal"/>
 *     &lt;enumeration value="Zug_Ziel_Signal"/>
 *     &lt;enumeration value="Ausfahr_Zwischen_Signal"/>
 *     &lt;enumeration value="Block_Signal"/>
 *     &lt;enumeration value="Deckungs_Signal"/>
 *     &lt;enumeration value="Einfahr_Ausfahr_Signal"/>
 *     &lt;enumeration value="Einfahr_Block_Signal"/>
 *     &lt;enumeration value="Einfahr_Signal"/>
 *     &lt;enumeration value="Gruppenausfahr_Gruppenzwischen_Signal"/>
 *     &lt;enumeration value="Gruppenausfahr_Signal"/>
 *     &lt;enumeration value="Gruppenzwischen_Signal"/>
 *     &lt;enumeration value="Nachrueck_Signal"/>
 *     &lt;enumeration value="Zugdeckungs_Signal"/>
 *     &lt;enumeration value="Zwischen_Signal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSignal_Funktion")
@XmlEnum
public enum ENUMSignalFunktion {

    @XmlEnumValue("Alleinstehendes_Zusatzsignal")
    ALLEINSTEHENDES_ZUSATZSIGNAL("Alleinstehendes_Zusatzsignal"),
    @XmlEnumValue("andere")
    ANDERE("andere"),
    @XmlEnumValue("Ausfahr_Signal")
    AUSFAHR_SIGNAL("Ausfahr_Signal"),
    @XmlEnumValue("Zug_Ziel_Signal")
    ZUG_ZIEL_SIGNAL("Zug_Ziel_Signal"),
    @XmlEnumValue("Ausfahr_Zwischen_Signal")
    AUSFAHR_ZWISCHEN_SIGNAL("Ausfahr_Zwischen_Signal"),
    @XmlEnumValue("Block_Signal")
    BLOCK_SIGNAL("Block_Signal"),
    @XmlEnumValue("Deckungs_Signal")
    DECKUNGS_SIGNAL("Deckungs_Signal"),
    @XmlEnumValue("Einfahr_Ausfahr_Signal")
    EINFAHR_AUSFAHR_SIGNAL("Einfahr_Ausfahr_Signal"),
    @XmlEnumValue("Einfahr_Block_Signal")
    EINFAHR_BLOCK_SIGNAL("Einfahr_Block_Signal"),
    @XmlEnumValue("Einfahr_Signal")
    EINFAHR_SIGNAL("Einfahr_Signal"),
    @XmlEnumValue("Gruppenausfahr_Gruppenzwischen_Signal")
    GRUPPENAUSFAHR_GRUPPENZWISCHEN_SIGNAL("Gruppenausfahr_Gruppenzwischen_Signal"),
    @XmlEnumValue("Gruppenausfahr_Signal")
    GRUPPENAUSFAHR_SIGNAL("Gruppenausfahr_Signal"),
    @XmlEnumValue("Gruppenzwischen_Signal")
    GRUPPENZWISCHEN_SIGNAL("Gruppenzwischen_Signal"),
    @XmlEnumValue("Nachrueck_Signal")
    NACHRUECK_SIGNAL("Nachrueck_Signal"),
    @XmlEnumValue("Zugdeckungs_Signal")
    ZUGDECKUNGS_SIGNAL("Zugdeckungs_Signal"),
    @XmlEnumValue("Zwischen_Signal")
    ZWISCHEN_SIGNAL("Zwischen_Signal");
    private final String value;

    ENUMSignalFunktion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSignalFunktion fromValue(String v) {
        for (ENUMSignalFunktion c: ENUMSignalFunktion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
