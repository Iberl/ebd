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
 * <p>Java-Klasse f�r ENUMFiktives_Signal_Funktion.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFiktives_Signal_Funktion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FAP_Start"/>
 *     &lt;enumeration value="FAP_Ziel"/>
 *     &lt;enumeration value="Rangier_Start_Ziel_ohne_Signal"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Zug_Start_Awanst"/>
 *     &lt;enumeration value="Zug_Start_Mittelweiche"/>
 *     &lt;enumeration value="Zug_Start_ohne_Signal"/>
 *     &lt;enumeration value="Zug_Ziel_Awanst"/>
 *     &lt;enumeration value="Zug_Ziel_ohne_Signal"/>
 *     &lt;enumeration value="Zug_Ziel_Strecke"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFiktives_Signal_Funktion")
@XmlEnum
public enum ENUMFiktivesSignalFunktion {

    @XmlEnumValue("FAP_Start")
    FAP_START("FAP_Start"),
    @XmlEnumValue("FAP_Ziel")
    FAP_ZIEL("FAP_Ziel"),
    @XmlEnumValue("Rangier_Start_Ziel_ohne_Signal")
    RANGIER_START_ZIEL_OHNE_SIGNAL("Rangier_Start_Ziel_ohne_Signal"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Zug_Start_Awanst")
    ZUG_START_AWANST("Zug_Start_Awanst"),
    @XmlEnumValue("Zug_Start_Mittelweiche")
    ZUG_START_MITTELWEICHE("Zug_Start_Mittelweiche"),
    @XmlEnumValue("Zug_Start_ohne_Signal")
    ZUG_START_OHNE_SIGNAL("Zug_Start_ohne_Signal"),
    @XmlEnumValue("Zug_Ziel_Awanst")
    ZUG_ZIEL_AWANST("Zug_Ziel_Awanst"),
    @XmlEnumValue("Zug_Ziel_ohne_Signal")
    ZUG_ZIEL_OHNE_SIGNAL("Zug_Ziel_ohne_Signal"),
    @XmlEnumValue("Zug_Ziel_Strecke")
    ZUG_ZIEL_STRECKE("Zug_Ziel_Strecke");
    private final String value;

    ENUMFiktivesSignalFunktion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFiktivesSignalFunktion fromValue(String v) {
        for (ENUMFiktivesSignalFunktion c: ENUMFiktivesSignalFunktion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
