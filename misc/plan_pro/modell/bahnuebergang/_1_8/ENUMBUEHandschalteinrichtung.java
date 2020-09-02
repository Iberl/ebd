//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBUE_Handschalteinrichtung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Handschalteinrichtung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AT"/>
 *     &lt;enumeration value="ET"/>
 *     &lt;enumeration value="HAT"/>
 *     &lt;enumeration value="HET"/>
 *     &lt;enumeration value="RS"/>
 *     &lt;enumeration value="RT_ein_aus"/>
 *     &lt;enumeration value="RT_ein_RT_aus"/>
 *     &lt;enumeration value="UT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBUE_Handschalteinrichtung")
@XmlEnum
public enum ENUMBUEHandschalteinrichtung {

    AT("AT"),
    ET("ET"),
    HAT("HAT"),
    HET("HET"),
    RS("RS"),
    @XmlEnumValue("RT_ein_aus")
    RT_EIN_AUS("RT_ein_aus"),
    @XmlEnumValue("RT_ein_RT_aus")
    RT_EIN_RT_AUS("RT_ein_RT_aus"),
    UT("UT");
    private final String value;

    ENUMBUEHandschalteinrichtung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUEHandschalteinrichtung fromValue(String v) {
        for (ENUMBUEHandschalteinrichtung c: ENUMBUEHandschalteinrichtung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
