//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt, das alle Informationen zur Einschaltung eines Bahn�bergangs (B�) enth�lt. �ber den Verweis auf BUE Gleisbezogener Gefahrraum findet eine Verortung am zugeh�rigen Gleis statt, f�r das der Einschaltkontakt angeordnet wird. Der Einschaltkontakt selbst ist �ber das Objekt Schaltmittel Zuordnung abgebildet. F�r die BUE Einschaltung ist die in Fahrtrichtung von Anr�ckmelder / Einschaltkontakt in Richtung B� die VOR der B�-Mitte liegende Grenze von BUE Gleisbezogener Gefahrraum ma�gebend, auf dem das Objekt verortet wird. Die Gefahrraum-Grenze liegt damit in Fahrtrichtung HINTER dem Anr�ckmelder / Einschaltkontakt. Bei Ausbildung des Einschaltpunktes als Doppelschleife gelten hinsichtlich des ma�gebenden Einschaltpunktes gem�� Einschaltstreckenberechnung folgende Unterschiede: Hersteller PintschBamag: ma�gebend ist die Mitte der in Fahrtrichtung B� liegenden ERSTEN Schleife Hersteller Scheidt\u0026amp;Bachmann: ma�gebend ist die Mitte der in Fahrtrichtung B� liegenden ZWEITE Schleife DB-Regelwerk 815.0033 in Verbindung mit Einschaltstreckenberechnung Die Angaben zur B�-Einschaltung beschr�nken sich gegenw�rtig auf die Planungswerte mit Auswirkungen auf das Stellwerk.
 * 
 * <p>Java-Klasse f�r CBUE_Einschaltung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Einschaltung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="BUE_Einschaltung_Hp" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Einschaltung_Hp" minOccurs="0"/>
 *         &lt;element name="BUE_Funktionsueberwachung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}TCBUE_Funktionsueberwachung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Einschaltung", propOrder = {
    "bueEinschaltungHp",
    "bueFunktionsueberwachung"
})
public class CBUEEinschaltung
    extends CBasisObjekt
{

    @XmlElement(name = "BUE_Einschaltung_Hp")
    protected CBUEEinschaltungHp bueEinschaltungHp;
    @XmlElement(name = "BUE_Funktionsueberwachung", required = true)
    protected TCBUEFunktionsueberwachung bueFunktionsueberwachung;

    /**
     * Ruft den Wert der bueEinschaltungHp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEEinschaltungHp }
     *     
     */
    public CBUEEinschaltungHp getBUEEinschaltungHp() {
        return bueEinschaltungHp;
    }

    /**
     * Legt den Wert der bueEinschaltungHp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEEinschaltungHp }
     *     
     */
    public void setBUEEinschaltungHp(CBUEEinschaltungHp value) {
        this.bueEinschaltungHp = value;
    }

    /**
     * Ruft den Wert der bueFunktionsueberwachung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEFunktionsueberwachung }
     *     
     */
    public TCBUEFunktionsueberwachung getBUEFunktionsueberwachung() {
        return bueFunktionsueberwachung;
    }

    /**
     * Legt den Wert der bueFunktionsueberwachung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEFunktionsueberwachung }
     *     
     */
    public void setBUEFunktionsueberwachung(TCBUEFunktionsueberwachung value) {
        this.bueFunktionsueberwachung = value;
    }

}
