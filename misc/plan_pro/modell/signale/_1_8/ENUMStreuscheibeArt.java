//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMStreuscheibe_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMStreuscheibe_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HRL"/>
 *     &lt;enumeration value="HG"/>
 *     &lt;enumeration value="HN"/>
 *     &lt;enumeration value="ORL"/>
 *     &lt;enumeration value="VRL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMStreuscheibe_Art")
@XmlEnum
public enum ENUMStreuscheibeArt {

    HRL,
    HG,
    HN,
    ORL,
    VRL;

    public String value() {
        return name();
    }

    public static ENUMStreuscheibeArt fromValue(String v) {
        return valueOf(v);
    }

}