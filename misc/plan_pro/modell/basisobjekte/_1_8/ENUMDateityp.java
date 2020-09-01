//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMDateityp.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMDateityp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="jpg"/>
 *     &lt;enumeration value="mpeg"/>
 *     &lt;enumeration value="pdf"/>
 *     &lt;enumeration value="png"/>
 *     &lt;enumeration value="tif"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMDateityp")
@XmlEnum
public enum ENUMDateityp {

    @XmlEnumValue("jpg")
    JPG("jpg"),
    @XmlEnumValue("mpeg")
    MPEG("mpeg"),
    @XmlEnumValue("pdf")
    PDF("pdf"),
    @XmlEnumValue("png")
    PNG("png"),
    @XmlEnumValue("tif")
    TIF("tif");
    private final String value;

    ENUMDateityp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMDateityp fromValue(String v) {
        for (ENUMDateityp c: ENUMDateityp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
