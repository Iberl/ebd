//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.01.07 um 02:16:09 PM CET
//


package modell.bahnuebergang._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ENUMBUE_Funktionsueberwachung.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Funktionsueberwachung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fü"/>
 *     &lt;enumeration value="Fue"/>
 *     &lt;enumeration value="Hp"/>
 *     &lt;enumeration value="Ues"/>
 *     &lt;enumeration value="UesOE"/>
 *     &lt;enumeration value="Üs"/>
 *     &lt;enumeration value="ÜsOE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "ENUMBUE_Funktionsueberwachung")
@XmlEnum
public enum ENUMBUEFunktionsueberwachung {

    @XmlEnumValue("Fueb")
    FUEB("Fueb"),
    @XmlEnumValue("Fue")
    FUE("Fue"),
    @XmlEnumValue("Hp")
    HP("Hp"),
    @XmlEnumValue("Ues")
    UES("Ues"),
    @XmlEnumValue("UesOE")
    UES_OE("UesOE"),
    @XmlEnumValue("\u00dcs")
    ÜS("\u00dcs"),
    @XmlEnumValue("\u00dcsOE")
    ÜS_OE("\u00dcsOE");
    private final String value;

    ENUMBUEFunktionsueberwachung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUEFunktionsueberwachung fromValue(String v) {
        for (ENUMBUEFunktionsueberwachung c: ENUMBUEFunktionsueberwachung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
