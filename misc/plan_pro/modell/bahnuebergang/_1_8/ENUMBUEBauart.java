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
 * <p>Java-Klasse f�r ENUMBUE_Bauart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Bauart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bau_Bue"/>
 *     &lt;enumeration value="Bue"/>
 *     &lt;enumeration value="Resi"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBUE_Bauart")
@XmlEnum
public enum ENUMBUEBauart {

    @XmlEnumValue("Bau_Bue")
    BAU_BUE("Bau_Bue"),
    @XmlEnumValue("Bue")
    BUE("Bue"),
    @XmlEnumValue("Resi")
    RESI("Resi");
    private final String value;

    ENUMBUEBauart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUEBauart fromValue(String v) {
        for (ENUMBUEBauart c: ENUMBUEBauart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
