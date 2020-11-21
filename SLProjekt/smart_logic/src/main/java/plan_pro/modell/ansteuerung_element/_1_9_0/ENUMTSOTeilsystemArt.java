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
 * <p>Java-Klasse f�r ENUMTSO_Teilsystem_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTSO_Teilsystem_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Doku ZMA ZL"/>
 *     &lt;enumeration value="MDM"/>
 *     &lt;enumeration value="RBC"/>
 *     &lt;enumeration value="Transfernetz mit SI LST"/>
 *     &lt;enumeration value="ZE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTSO_Teilsystem_Art")
@XmlEnum
public enum ENUMTSOTeilsystemArt {

    @XmlEnumValue("Doku ZMA ZL")
    DOKU_ZMA_ZL("Doku ZMA ZL"),
    MDM("MDM"),
    RBC("RBC"),
    @XmlEnumValue("Transfernetz mit SI LST")
    TRANSFERNETZ_MIT_SI_LST("Transfernetz mit SI LST"),
    ZE("ZE");
    private final String value;

    ENUMTSOTeilsystemArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTSOTeilsystemArt fromValue(String v) {
        for (ENUMTSOTeilsystemArt c: ENUMTSOTeilsystemArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
