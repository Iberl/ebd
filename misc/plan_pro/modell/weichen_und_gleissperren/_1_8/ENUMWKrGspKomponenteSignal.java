//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMW_Kr_Gsp_Komponente_Signal.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMW_Kr_Gsp_Komponente_Signal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="innenbeleuchtet"/>
 *     &lt;enumeration value="nein"/>
 *     &lt;enumeration value="reflektierend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMW_Kr_Gsp_Komponente_Signal")
@XmlEnum
public enum ENUMWKrGspKomponenteSignal {

    @XmlEnumValue("innenbeleuchtet")
    INNENBELEUCHTET("innenbeleuchtet"),
    @XmlEnumValue("nein")
    NEIN("nein"),
    @XmlEnumValue("reflektierend")
    REFLEKTIEREND("reflektierend");
    private final String value;

    ENUMWKrGspKomponenteSignal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMWKrGspKomponenteSignal fromValue(String v) {
        for (ENUMWKrGspKomponenteSignal c: ENUMWKrGspKomponenteSignal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}