//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMAusstieg_ETCS_Sperre.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMAusstieg_ETCS_Sperre">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ja"/>
 *     &lt;enumeration value="nein"/>
 *     &lt;enumeration value="regulaer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMAusstieg_ETCS_Sperre")
@XmlEnum
public enum ENUMAusstiegETCSSperre {

    @XmlEnumValue("ja")
    JA("ja"),
    @XmlEnumValue("nein")
    NEIN("nein"),
    @XmlEnumValue("regulaer")
    REGULAER("regulaer");
    private final String value;

    ENUMAusstiegETCSSperre(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMAusstiegETCSSperre fromValue(String v) {
        for (ENUMAusstiegETCSSperre c: ENUMAusstiegETCSSperre.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
