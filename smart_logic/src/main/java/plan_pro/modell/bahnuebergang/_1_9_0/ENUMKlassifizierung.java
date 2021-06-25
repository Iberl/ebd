//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMKlassifizierung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMKlassifizierung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bundestrasse_ausserorts"/>
 *     &lt;enumeration value="Bundestrasse_innerorts"/>
 *     &lt;enumeration value="Fussweg"/>
 *     &lt;enumeration value="Fussweg_Radweg"/>
 *     &lt;enumeration value="Gemeindestrasse_ausserorts"/>
 *     &lt;enumeration value="Gemeindestrasse_innerorts"/>
 *     &lt;enumeration value="Kreisstrasse_ausserorts"/>
 *     &lt;enumeration value="Kreisstrasse_innerorts"/>
 *     &lt;enumeration value="Landstrasse_ausserorts"/>
 *     &lt;enumeration value="Landstrasse_innerorts"/>
 *     &lt;enumeration value="Privatstrasse"/>
 *     &lt;enumeration value="Privatweg"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Weg_Forst_Land"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMKlassifizierung")
@XmlEnum
public enum ENUMKlassifizierung {

    @XmlEnumValue("Bundestrasse_ausserorts")
    BUNDESTRASSE_AUSSERORTS("Bundestrasse_ausserorts"),
    @XmlEnumValue("Bundestrasse_innerorts")
    BUNDESTRASSE_INNERORTS("Bundestrasse_innerorts"),
    @XmlEnumValue("Fussweg")
    FUSSWEG("Fussweg"),
    @XmlEnumValue("Fussweg_Radweg")
    FUSSWEG_RADWEG("Fussweg_Radweg"),
    @XmlEnumValue("Gemeindestrasse_ausserorts")
    GEMEINDESTRASSE_AUSSERORTS("Gemeindestrasse_ausserorts"),
    @XmlEnumValue("Gemeindestrasse_innerorts")
    GEMEINDESTRASSE_INNERORTS("Gemeindestrasse_innerorts"),
    @XmlEnumValue("Kreisstrasse_ausserorts")
    KREISSTRASSE_AUSSERORTS("Kreisstrasse_ausserorts"),
    @XmlEnumValue("Kreisstrasse_innerorts")
    KREISSTRASSE_INNERORTS("Kreisstrasse_innerorts"),
    @XmlEnumValue("Landstrasse_ausserorts")
    LANDSTRASSE_AUSSERORTS("Landstrasse_ausserorts"),
    @XmlEnumValue("Landstrasse_innerorts")
    LANDSTRASSE_INNERORTS("Landstrasse_innerorts"),
    @XmlEnumValue("Privatstrasse")
    PRIVATSTRASSE("Privatstrasse"),
    @XmlEnumValue("Privatweg")
    PRIVATWEG("Privatweg"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Weg_Forst_Land")
    WEG_FORST_LAND("Weg_Forst_Land");
    private final String value;

    ENUMKlassifizierung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMKlassifizierung fromValue(String v) {
        for (ENUMKlassifizierung c: ENUMKlassifizierung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
