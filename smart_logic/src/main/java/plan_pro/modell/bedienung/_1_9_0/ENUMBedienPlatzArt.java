//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBedien_Platz_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBedien_Platz_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Not_BPS"/>
 *     &lt;enumeration value="Not_BPS_abgesetzt"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Standard_BPS"/>
 *     &lt;enumeration value="Standard_BPS_abgesetzt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBedien_Platz_Art")
@XmlEnum
public enum ENUMBedienPlatzArt {

    @XmlEnumValue("Not_BPS")
    NOT_BPS("Not_BPS"),
    @XmlEnumValue("Not_BPS_abgesetzt")
    NOT_BPS_ABGESETZT("Not_BPS_abgesetzt"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Standard_BPS")
    STANDARD_BPS("Standard_BPS"),
    @XmlEnumValue("Standard_BPS_abgesetzt")
    STANDARD_BPS_ABGESETZT("Standard_BPS_abgesetzt");
    private final String value;

    ENUMBedienPlatzArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBedienPlatzArt fromValue(String v) {
        for (ENUMBedienPlatzArt c: ENUMBedienPlatzArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
