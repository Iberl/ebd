//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMAussenelementansteuerung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMAussenelementansteuerung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BUE_Anschaltung"/>
 *     &lt;enumeration value="ESTW_A"/>
 *     &lt;enumeration value="Gleisfreimelde_Innenanlage"/>
 *     &lt;enumeration value="Objektcontroller"/>
 *     &lt;enumeration value="Relaisstellwerk"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="virtuelle_Aussenelementansteuerung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMAussenelementansteuerung_Art")
@XmlEnum
public enum ENUMAussenelementansteuerungArt {

    @XmlEnumValue("BUE_Anschaltung")
    BUE_ANSCHALTUNG("BUE_Anschaltung"),
    ESTW_A("ESTW_A"),
    @XmlEnumValue("Gleisfreimelde_Innenanlage")
    GLEISFREIMELDE_INNENANLAGE("Gleisfreimelde_Innenanlage"),
    @XmlEnumValue("Objektcontroller")
    OBJEKTCONTROLLER("Objektcontroller"),
    @XmlEnumValue("Relaisstellwerk")
    RELAISSTELLWERK("Relaisstellwerk"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("virtuelle_Aussenelementansteuerung")
    VIRTUELLE_AUSSENELEMENTANSTEUERUNG("virtuelle_Aussenelementansteuerung");
    private final String value;

    ENUMAussenelementansteuerungArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMAussenelementansteuerungArt fromValue(String v) {
        for (ENUMAussenelementansteuerungArt c: ENUMAussenelementansteuerungArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
