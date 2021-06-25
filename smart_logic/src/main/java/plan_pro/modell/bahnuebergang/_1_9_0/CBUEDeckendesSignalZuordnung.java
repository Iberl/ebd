//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEEinschaltung;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Das Zuordnungsobjekt BUE_Deckendes_Signal bildet die diesbez�gliche Angabe in der Signaltabelle 1 sowie in der Einschaltstreckenberechnung ab. Die Angaben in der Signaltabelle 1 sowie in der Einschaltstreckenberechnung beziehen sich auf das deckende Signal (Haupt-/LS-Signal) und nicht auf die den B�-Schlie�vorgang ansto�ende Fahrstra�e. DB-Regelwerk Signaltabelle 1, Zeile 33 und 34 Einschaltstreckenberechnung 
 * 
 * <p>Java-Klasse f�r CBUE_Deckendes_Signal_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Deckendes_Signal_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_BUE_Einschaltung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Einschaltung"/>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal"/>
 *         &lt;element name="Sicherheitsabstand" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSicherheitsabstand"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Deckendes_Signal_Zuordnung", propOrder = {
    "idbueEinschaltung",
    "idSignal",
    "sicherheitsabstand"
})
public class CBUEDeckendesSignalZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_BUE_Einschaltung", required = true)
    protected TCIDBUEEinschaltung idbueEinschaltung;
    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignal idSignal;
    @XmlElement(name = "Sicherheitsabstand", required = true)
    protected TCSicherheitsabstand sicherheitsabstand;

    /**
     * Ruft den Wert der idbueEinschaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public TCIDBUEEinschaltung getIDBUEEinschaltung() {
        return idbueEinschaltung;
    }

    /**
     * Legt den Wert der idbueEinschaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public void setIDBUEEinschaltung(TCIDBUEEinschaltung value) {
        this.idbueEinschaltung = value;
    }

    /**
     * Ruft den Wert der idSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignal() {
        return idSignal;
    }

    /**
     * Legt den Wert der idSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignal(TCIDSignal value) {
        this.idSignal = value;
    }

    /**
     * Ruft den Wert der sicherheitsabstand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSicherheitsabstand }
     *     
     */
    public TCSicherheitsabstand getSicherheitsabstand() {
        return sicherheitsabstand;
    }

    /**
     * Legt den Wert der sicherheitsabstand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSicherheitsabstand }
     *     
     */
    public void setSicherheitsabstand(TCSicherheitsabstand value) {
        this.sicherheitsabstand = value;
    }

}
