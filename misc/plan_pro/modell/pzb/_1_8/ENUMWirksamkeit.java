//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.pzb._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMWirksamkeit.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMWirksamkeit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="schaltbar_von_Signal"/>
 *     &lt;enumeration value="staendig_wirksam_wenn_Fahrstrasse_eingestellt"/>
 *     &lt;enumeration value="unwirksam_wenn_Fahrstrasse_eingestellt"/>
 *     &lt;enumeration value="staendig_wirksam"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMWirksamkeit")
@XmlEnum
public enum ENUMWirksamkeit {

    @XmlEnumValue("schaltbar_von_Signal")
    SCHALTBAR_VON_SIGNAL("schaltbar_von_Signal"),
    @XmlEnumValue("staendig_wirksam_wenn_Fahrstrasse_eingestellt")
    STAENDIG_WIRKSAM_WENN_FAHRSTRASSE_EINGESTELLT("staendig_wirksam_wenn_Fahrstrasse_eingestellt"),
    @XmlEnumValue("unwirksam_wenn_Fahrstrasse_eingestellt")
    UNWIRKSAM_WENN_FAHRSTRASSE_EINGESTELLT("unwirksam_wenn_Fahrstrasse_eingestellt"),
    @XmlEnumValue("staendig_wirksam")
    STAENDIG_WIRKSAM("staendig_wirksam"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMWirksamkeit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMWirksamkeit fromValue(String v) {
        for (ENUMWirksamkeit c: ENUMWirksamkeit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
