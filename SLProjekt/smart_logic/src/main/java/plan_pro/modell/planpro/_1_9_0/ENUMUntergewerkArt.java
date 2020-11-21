//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMUntergewerk_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMUntergewerk_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bedienung ETCS"/>
 *     &lt;enumeration value="Bedienung Fdl BZ"/>
 *     &lt;enumeration value="Bedienung Fdl ESTW-ZE"/>
 *     &lt;enumeration value="BUE"/>
 *     &lt;enumeration value="ESTW"/>
 *     &lt;enumeration value="ETCS"/>
 *     &lt;enumeration value="Geo"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZL"/>
 *     &lt;enumeration value="ZLV-Bus"/>
 *     &lt;enumeration value="ZN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMUntergewerk_Art")
@XmlEnum
public enum ENUMUntergewerkArt {

    @XmlEnumValue("Bedienung ETCS")
    BEDIENUNG_ETCS("Bedienung ETCS"),
    @XmlEnumValue("Bedienung Fdl BZ")
    BEDIENUNG_FDL_BZ("Bedienung Fdl BZ"),
    @XmlEnumValue("Bedienung Fdl ESTW-ZE")
    BEDIENUNG_FDL_ESTW_ZE("Bedienung Fdl ESTW-ZE"),
    BUE("BUE"),
    ESTW("ESTW"),
    ETCS("ETCS"),
    @XmlEnumValue("Geo")
    GEO("Geo"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    ZL("ZL"),
    @XmlEnumValue("ZLV-Bus")
    ZLV_BUS("ZLV-Bus"),
    ZN("ZN");
    private final String value;

    ENUMUntergewerkArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMUntergewerkArt fromValue(String v) {
        for (ENUMUntergewerkArt c: ENUMUntergewerkArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
