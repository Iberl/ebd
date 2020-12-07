//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSchaltmittel_Funktion.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSchaltmittel_Funktion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ARM"/>
 *     &lt;enumeration value="Awanst"/>
 *     &lt;enumeration value="Ein_BUE"/>
 *     &lt;enumeration value="Haltfall"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZL_Anstoss"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSchaltmittel_Funktion")
@XmlEnum
public enum ENUMSchaltmittelFunktion {

    ARM("ARM"),
    @XmlEnumValue("Awanst")
    AWANST("Awanst"),
    @XmlEnumValue("Ein_BUE")
    EIN_BUE("Ein_BUE"),
    @XmlEnumValue("Haltfall")
    HALTFALL("Haltfall"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("ZL_Anstoss")
    ZL_ANSTOSS("ZL_Anstoss");
    private final String value;

    ENUMSchaltmittelFunktion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSchaltmittelFunktion fromValue(String v) {
        for (ENUMSchaltmittelFunktion c: ENUMSchaltmittelFunktion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
