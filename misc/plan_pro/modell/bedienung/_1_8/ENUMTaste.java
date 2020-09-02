//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMTaste.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTaste">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ausfahrgruppentaste_ZP_9_10"/>
 *     &lt;enumeration value="Bedientaste_ZP_10"/>
 *     &lt;enumeration value="Bedientaste_ZP_9"/>
 *     &lt;enumeration value="Fahrstrassenanforderung"/>
 *     &lt;enumeration value="Fahrstrassenzustimmung"/>
 *     &lt;enumeration value="Freimeldetaste"/>
 *     &lt;enumeration value="Gruppentaste"/>
 *     &lt;enumeration value="Hilfstaste"/>
 *     &lt;enumeration value="Loeschtaste"/>
 *     &lt;enumeration value="Rueckgabetaste"/>
 *     &lt;enumeration value="Schluesseltaste_DB_21"/>
 *     &lt;enumeration value="Schluesseltaste_Streckenschluessel"/>
 *     &lt;enumeration value="Schluesseltaste_Vierkant"/>
 *     &lt;enumeration value="Signalanforderung"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Umstelltaste"/>
 *     &lt;enumeration value="Weichenauffahrtaste"/>
 *     &lt;enumeration value="Zieltaste"/>
 *     &lt;enumeration value="Zugschlussmeldung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTaste")
@XmlEnum
public enum ENUMTaste {

    @XmlEnumValue("Ausfahrgruppentaste_ZP_9_10")
    AUSFAHRGRUPPENTASTE_ZP_9_10("Ausfahrgruppentaste_ZP_9_10"),
    @XmlEnumValue("Bedientaste_ZP_10")
    BEDIENTASTE_ZP_10("Bedientaste_ZP_10"),
    @XmlEnumValue("Bedientaste_ZP_9")
    BEDIENTASTE_ZP_9("Bedientaste_ZP_9"),
    @XmlEnumValue("Fahrstrassenanforderung")
    FAHRSTRASSENANFORDERUNG("Fahrstrassenanforderung"),
    @XmlEnumValue("Fahrstrassenzustimmung")
    FAHRSTRASSENZUSTIMMUNG("Fahrstrassenzustimmung"),
    @XmlEnumValue("Freimeldetaste")
    FREIMELDETASTE("Freimeldetaste"),
    @XmlEnumValue("Gruppentaste")
    GRUPPENTASTE("Gruppentaste"),
    @XmlEnumValue("Hilfstaste")
    HILFSTASTE("Hilfstaste"),
    @XmlEnumValue("Loeschtaste")
    LOESCHTASTE("Loeschtaste"),
    @XmlEnumValue("Rueckgabetaste")
    RUECKGABETASTE("Rueckgabetaste"),
    @XmlEnumValue("Schluesseltaste_DB_21")
    SCHLUESSELTASTE_DB_21("Schluesseltaste_DB_21"),
    @XmlEnumValue("Schluesseltaste_Streckenschluessel")
    SCHLUESSELTASTE_STRECKENSCHLUESSEL("Schluesseltaste_Streckenschluessel"),
    @XmlEnumValue("Schluesseltaste_Vierkant")
    SCHLUESSELTASTE_VIERKANT("Schluesseltaste_Vierkant"),
    @XmlEnumValue("Signalanforderung")
    SIGNALANFORDERUNG("Signalanforderung"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Umstelltaste")
    UMSTELLTASTE("Umstelltaste"),
    @XmlEnumValue("Weichenauffahrtaste")
    WEICHENAUFFAHRTASTE("Weichenauffahrtaste"),
    @XmlEnumValue("Zieltaste")
    ZIELTASTE("Zieltaste"),
    @XmlEnumValue("Zugschlussmeldung")
    ZUGSCHLUSSMELDUNG("Zugschlussmeldung");
    private final String value;

    ENUMTaste(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTaste fromValue(String v) {
        for (ENUMTaste c: ENUMTaste.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
