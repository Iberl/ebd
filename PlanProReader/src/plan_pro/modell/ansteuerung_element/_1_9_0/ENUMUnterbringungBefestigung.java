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
 * <p>Java-Klasse f�r ENUMUnterbringung_Befestigung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMUnterbringung_Befestigung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fundament"/>
 *     &lt;enumeration value="Gebaeude"/>
 *     &lt;enumeration value="Mauer"/>
 *     &lt;enumeration value="Pfosten"/>
 *     &lt;enumeration value="Signalausleger"/>
 *     &lt;enumeration value="Signalbruecke"/>
 *     &lt;enumeration value="Signalmast"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMUnterbringung_Befestigung")
@XmlEnum
public enum ENUMUnterbringungBefestigung {

    @XmlEnumValue("Fundament")
    FUNDAMENT("Fundament"),
    @XmlEnumValue("Gebaeude")
    GEBAEUDE("Gebaeude"),
    @XmlEnumValue("Mauer")
    MAUER("Mauer"),
    @XmlEnumValue("Pfosten")
    PFOSTEN("Pfosten"),
    @XmlEnumValue("Signalausleger")
    SIGNALAUSLEGER("Signalausleger"),
    @XmlEnumValue("Signalbruecke")
    SIGNALBRUECKE("Signalbruecke"),
    @XmlEnumValue("Signalmast")
    SIGNALMAST("Signalmast"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMUnterbringungBefestigung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMUnterbringungBefestigung fromValue(String v) {
        for (ENUMUnterbringungBefestigung c: ENUMUnterbringungBefestigung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
