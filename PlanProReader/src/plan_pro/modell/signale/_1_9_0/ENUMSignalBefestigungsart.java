//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSignal_Befestigungsart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSignal_Befestigungsart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bahnsteig"/>
 *     &lt;enumeration value="Fundament"/>
 *     &lt;enumeration value="Konstruktionsteil"/>
 *     &lt;enumeration value="OL_Kettenwerk"/>
 *     &lt;enumeration value="OL_Mast"/>
 *     &lt;enumeration value="Prellbock"/>
 *     &lt;enumeration value="Signalausleger"/>
 *     &lt;enumeration value="Signalbruecke"/>
 *     &lt;enumeration value="Sonderkonstruktion"/>
 *     &lt;enumeration value="Dach"/>
 *     &lt;enumeration value="Mast"/>
 *     &lt;enumeration value="Pfahl"/>
 *     &lt;enumeration value="Wand"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSignal_Befestigungsart")
@XmlEnum
public enum ENUMSignalBefestigungsart {

    @XmlEnumValue("Bahnsteig")
    BAHNSTEIG("Bahnsteig"),
    @XmlEnumValue("Fundament")
    FUNDAMENT("Fundament"),
    @XmlEnumValue("Konstruktionsteil")
    KONSTRUKTIONSTEIL("Konstruktionsteil"),
    @XmlEnumValue("OL_Kettenwerk")
    OL_KETTENWERK("OL_Kettenwerk"),
    @XmlEnumValue("OL_Mast")
    OL_MAST("OL_Mast"),
    @XmlEnumValue("Prellbock")
    PRELLBOCK("Prellbock"),
    @XmlEnumValue("Signalausleger")
    SIGNALAUSLEGER("Signalausleger"),
    @XmlEnumValue("Signalbruecke")
    SIGNALBRUECKE("Signalbruecke"),
    @XmlEnumValue("Sonderkonstruktion")
    SONDERKONSTRUKTION("Sonderkonstruktion"),
    @XmlEnumValue("Dach")
    DACH("Dach"),
    @XmlEnumValue("Mast")
    MAST("Mast"),
    @XmlEnumValue("Pfahl")
    PFAHL("Pfahl"),
    @XmlEnumValue("Wand")
    WAND("Wand");
    private final String value;

    ENUMSignalBefestigungsart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSignalBefestigungsart fromValue(String v) {
        for (ENUMSignalBefestigungsart c: ENUMSignalBefestigungsart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
