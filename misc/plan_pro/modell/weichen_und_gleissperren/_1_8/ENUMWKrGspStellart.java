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
 * <p>Java-Klasse f�r ENUMW_Kr_Gsp_Stellart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMW_Kr_Gsp_Stellart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="elektrisch_ferngestellt"/>
 *     &lt;enumeration value="elektrisch_ortsgestellt"/>
 *     &lt;enumeration value="mechanisch_ferngestellt"/>
 *     &lt;enumeration value="mechanisch_ortsgestellt"/>
 *     &lt;enumeration value="nicht_stellbar"/>
 *     &lt;enumeration value="Rueckfallweiche"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="stillgelegt_links"/>
 *     &lt;enumeration value="stillgelegt_rechts"/>
 *     &lt;enumeration value="unbestimmt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMW_Kr_Gsp_Stellart")
@XmlEnum
public enum ENUMWKrGspStellart {

    @XmlEnumValue("elektrisch_ferngestellt")
    ELEKTRISCH_FERNGESTELLT("elektrisch_ferngestellt"),
    @XmlEnumValue("elektrisch_ortsgestellt")
    ELEKTRISCH_ORTSGESTELLT("elektrisch_ortsgestellt"),
    @XmlEnumValue("mechanisch_ferngestellt")
    MECHANISCH_FERNGESTELLT("mechanisch_ferngestellt"),
    @XmlEnumValue("mechanisch_ortsgestellt")
    MECHANISCH_ORTSGESTELLT("mechanisch_ortsgestellt"),
    @XmlEnumValue("nicht_stellbar")
    NICHT_STELLBAR("nicht_stellbar"),
    @XmlEnumValue("Rueckfallweiche")
    RUECKFALLWEICHE("Rueckfallweiche"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("stillgelegt_links")
    STILLGELEGT_LINKS("stillgelegt_links"),
    @XmlEnumValue("stillgelegt_rechts")
    STILLGELEGT_RECHTS("stillgelegt_rechts"),
    @XmlEnumValue("unbestimmt")
    UNBESTIMMT("unbestimmt");
    private final String value;

    ENUMWKrGspStellart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMWKrGspStellart fromValue(String v) {
        for (ENUMWKrGspStellart c: ENUMWKrGspStellart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
