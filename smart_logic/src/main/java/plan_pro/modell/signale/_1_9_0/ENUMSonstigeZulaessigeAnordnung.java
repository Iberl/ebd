//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSonstige_Zulaessige_Anordnung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSonstige_Zulaessige_Anordnung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anordnung_des_Signals_rechts_am_Gleis"/>
 *     &lt;enumeration value="Anordnung_des_Signals_rechts_am_Gleis_ohne_Schachbretttafel"/>
 *     &lt;enumeration value="Nichtgeltung_fuer_Fahrten_auf_dem_Gegengleis"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSonstige_Zulaessige_Anordnung")
@XmlEnum
public enum ENUMSonstigeZulaessigeAnordnung {

    @XmlEnumValue("Anordnung_des_Signals_rechts_am_Gleis")
    ANORDNUNG_DES_SIGNALS_RECHTS_AM_GLEIS("Anordnung_des_Signals_rechts_am_Gleis"),
    @XmlEnumValue("Anordnung_des_Signals_rechts_am_Gleis_ohne_Schachbretttafel")
    ANORDNUNG_DES_SIGNALS_RECHTS_AM_GLEIS_OHNE_SCHACHBRETTTAFEL("Anordnung_des_Signals_rechts_am_Gleis_ohne_Schachbretttafel"),
    @XmlEnumValue("Nichtgeltung_fuer_Fahrten_auf_dem_Gegengleis")
    NICHTGELTUNG_FUER_FAHRTEN_AUF_DEM_GEGENGLEIS("Nichtgeltung_fuer_Fahrten_auf_dem_Gegengleis");
    private final String value;

    ENUMSonstigeZulaessigeAnordnung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSonstigeZulaessigeAnordnung fromValue(String v) {
        for (ENUMSonstigeZulaessigeAnordnung c: ENUMSonstigeZulaessigeAnordnung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
