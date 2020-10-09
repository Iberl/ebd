//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMRangier_Gegenfahrtausschluss.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMRangier_Gegenfahrtausschluss">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Inselgleis_frei"/>
 *     &lt;enumeration value="ja"/>
 *     &lt;enumeration value="nein"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMRangier_Gegenfahrtausschluss")
@XmlEnum
public enum ENUMRangierGegenfahrtausschluss {

    @XmlEnumValue("Inselgleis_frei")
    INSELGLEIS_FREI("Inselgleis_frei"),
    @XmlEnumValue("ja")
    JA("ja"),
    @XmlEnumValue("nein")
    NEIN("nein");
    private final String value;

    ENUMRangierGegenfahrtausschluss(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMRangierGegenfahrtausschluss fromValue(String v) {
        for (ENUMRangierGegenfahrtausschluss c: ENUMRangierGegenfahrtausschluss.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
