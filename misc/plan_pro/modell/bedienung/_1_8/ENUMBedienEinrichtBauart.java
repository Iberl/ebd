//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBedien_Einricht_Bauart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBedien_Einricht_Bauart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bedienpult"/>
 *     &lt;enumeration value="Bediensaeule"/>
 *     &lt;enumeration value="Bedientablett"/>
 *     &lt;enumeration value="Bedientafel"/>
 *     &lt;enumeration value="Stellpult"/>
 *     &lt;enumeration value="Stelltisch"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBedien_Einricht_Bauart")
@XmlEnum
public enum ENUMBedienEinrichtBauart {

    @XmlEnumValue("Bedienpult")
    BEDIENPULT("Bedienpult"),
    @XmlEnumValue("Bediensaeule")
    BEDIENSAEULE("Bediensaeule"),
    @XmlEnumValue("Bedientablett")
    BEDIENTABLETT("Bedientablett"),
    @XmlEnumValue("Bedientafel")
    BEDIENTAFEL("Bedientafel"),
    @XmlEnumValue("Stellpult")
    STELLPULT("Stellpult"),
    @XmlEnumValue("Stelltisch")
    STELLTISCH("Stelltisch"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMBedienEinrichtBauart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBedienEinrichtBauart fromValue(String v) {
        for (ENUMBedienEinrichtBauart c: ENUMBedienEinrichtBauart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
