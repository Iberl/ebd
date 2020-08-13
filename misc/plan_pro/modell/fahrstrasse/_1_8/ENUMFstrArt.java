//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFstr_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFstr_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RR"/>
 *     &lt;enumeration value="RU"/>
 *     &lt;enumeration value="ZB"/>
 *     &lt;enumeration value="ZH"/>
 *     &lt;enumeration value="ZM"/>
 *     &lt;enumeration value="ZR"/>
 *     &lt;enumeration value="ZU"/>
 *     &lt;enumeration value="ZUH"/>
 *     &lt;enumeration value="ZUM"/>
 *     &lt;enumeration value="RT"/>
 *     &lt;enumeration value="ZT"/>
 *     &lt;enumeration value="RTU"/>
 *     &lt;enumeration value="ZTU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFstr_Art")
@XmlEnum
public enum ENUMFstrArt {

    RR,
    RU,
    ZB,
    ZH,
    ZM,
    ZR,
    ZU,
    ZUH,
    ZUM,
    RT,
    ZT,
    RTU,
    ZTU;

    public String value() {
        return name();
    }

    public static ENUMFstrArt fromValue(String v) {
        return valueOf(v);
    }

}
