//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMMontage_Ausgleichsgewichte.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMMontage_Ausgleichsgewichte">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="beidseitig"/>
 *     &lt;enumeration value="einseitig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMMontage_Ausgleichsgewichte")
@XmlEnum
public enum ENUMMontageAusgleichsgewichte {

    @XmlEnumValue("beidseitig")
    BEIDSEITIG("beidseitig"),
    @XmlEnumValue("einseitig")
    EINSEITIG("einseitig");
    private final String value;

    ENUMMontageAusgleichsgewichte(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMMontageAusgleichsgewichte fromValue(String v) {
        for (ENUMMontageAusgleichsgewichte c: ENUMMontageAusgleichsgewichte.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
