//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.pzb._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGUE_Energieversorgung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGUE_Energieversorgung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Solar"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Stellwerk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGUE_Energieversorgung")
@XmlEnum
public enum ENUMGUEEnergieversorgung {

    @XmlEnumValue("Solar")
    SOLAR("Solar"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Stellwerk")
    STELLWERK("Stellwerk");
    private final String value;

    ENUMGUEEnergieversorgung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGUEEnergieversorgung fromValue(String v) {
        for (ENUMGUEEnergieversorgung c: ENUMGUEEnergieversorgung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
