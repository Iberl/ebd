//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.gleis._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGleis_Abschluss_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGleis_Abschluss_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Drehscheibe"/>
 *     &lt;enumeration value="Faehranleger"/>
 *     &lt;enumeration value="Festprellbock"/>
 *     &lt;enumeration value="Infrastrukturgrenze"/>
 *     &lt;enumeration value="Kopframpe"/>
 *     &lt;enumeration value="Schiebebuehne"/>
 *     &lt;enumeration value="Schwellenkreuz"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Bremsprellbock"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGleis_Abschluss_Art")
@XmlEnum
public enum ENUMGleisAbschlussArt {

    @XmlEnumValue("Drehscheibe")
    DREHSCHEIBE("Drehscheibe"),
    @XmlEnumValue("Faehranleger")
    FAEHRANLEGER("Faehranleger"),
    @XmlEnumValue("Festprellbock")
    FESTPRELLBOCK("Festprellbock"),
    @XmlEnumValue("Infrastrukturgrenze")
    INFRASTRUKTURGRENZE("Infrastrukturgrenze"),
    @XmlEnumValue("Kopframpe")
    KOPFRAMPE("Kopframpe"),
    @XmlEnumValue("Schiebebuehne")
    SCHIEBEBUEHNE("Schiebebuehne"),
    @XmlEnumValue("Schwellenkreuz")
    SCHWELLENKREUZ("Schwellenkreuz"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Bremsprellbock")
    BREMSPRELLBOCK("Bremsprellbock");
    private final String value;

    ENUMGleisAbschlussArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGleisAbschlussArt fromValue(String v) {
        for (ENUMGleisAbschlussArt c: ENUMGleisAbschlussArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
