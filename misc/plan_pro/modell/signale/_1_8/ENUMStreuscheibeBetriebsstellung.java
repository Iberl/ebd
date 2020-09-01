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
 * <p>Java-Klasse f�r ENUMStreuscheibe_Betriebsstellung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMStreuscheibe_Betriebsstellung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HG1"/>
 *     &lt;enumeration value="HG2"/>
 *     &lt;enumeration value="HG3"/>
 *     &lt;enumeration value="HG4"/>
 *     &lt;enumeration value="HL"/>
 *     &lt;enumeration value="HN"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="OL"/>
 *     &lt;enumeration value="OR"/>
 *     &lt;enumeration value="VL"/>
 *     &lt;enumeration value="VR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMStreuscheibe_Betriebsstellung")
@XmlEnum
public enum ENUMStreuscheibeBetriebsstellung {

    @XmlEnumValue("HG1")
    HG_1("HG1"),
    @XmlEnumValue("HG2")
    HG_2("HG2"),
    @XmlEnumValue("HG3")
    HG_3("HG3"),
    @XmlEnumValue("HG4")
    HG_4("HG4"),
    HL("HL"),
    HN("HN"),
    HR("HR"),
    OL("OL"),
    OR("OR"),
    VL("VL"),
    VR("VR");
    private final String value;

    ENUMStreuscheibeBetriebsstellung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMStreuscheibeBetriebsstellung fromValue(String v) {
        for (ENUMStreuscheibeBetriebsstellung c: ENUMStreuscheibeBetriebsstellung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
