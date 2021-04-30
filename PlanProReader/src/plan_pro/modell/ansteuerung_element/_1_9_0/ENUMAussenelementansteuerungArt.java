//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMAussenelementansteuerung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMAussenelementansteuerung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FeAk"/>
 *     &lt;enumeration value="GFK"/>
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

    @XmlEnumValue("FeAk")
    FE_AK("FeAk"),
    GFK("GFK"),
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
