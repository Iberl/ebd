//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMTB_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTB_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bruecke"/>
 *     &lt;enumeration value="Durchlass"/>
 *     &lt;enumeration value="Schutzwand"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Tunnel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTB_Art")
@XmlEnum
public enum ENUMTBArt {

    @XmlEnumValue("Bruecke")
    BRUECKE("Bruecke"),
    @XmlEnumValue("Durchlass")
    DURCHLASS("Durchlass"),
    @XmlEnumValue("Schutzwand")
    SCHUTZWAND("Schutzwand"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Tunnel")
    TUNNEL("Tunnel");
    private final String value;

    ENUMTBArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTBArt fromValue(String v) {
        for (ENUMTBArt c: ENUMTBArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
