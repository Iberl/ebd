//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.pzb._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDPZBElementMitnutzung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPZB_Element_GUE complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPZB_Element_GUE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GUE_Abstand_Abweichend" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCGUE_Abstand_Abweichend" minOccurs="0"/>
 *         &lt;element name="GUE_Anordnung" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCGUE_Anordnung"/>
 *         &lt;element name="GUE_Bauart" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCGUE_Bauart"/>
 *         &lt;element name="GUE_Energieversorgung" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCGUE_Energieversorgung"/>
 *         &lt;element name="GUE_Messstrecke" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCGUE_Messstrecke"/>
 *         &lt;element name="ID_PZB_Element_Mitnutzung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_PZB_Element_Mitnutzung" minOccurs="0"/>
 *         &lt;element name="Messfehler" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCMessfehler" minOccurs="0"/>
 *         &lt;element name="Pruefgeschwindigkeit" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCPruefgeschwindigkeit"/>
 *         &lt;element name="Pruefzeit" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCPruefzeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPZB_Element_GUE", propOrder = {
    "gueAbstandAbweichend",
    "gueAnordnung",
    "gueBauart",
    "gueEnergieversorgung",
    "gueMessstrecke",
    "idpzbElementMitnutzung",
    "messfehler",
    "pruefgeschwindigkeit",
    "pruefzeit"
})
public class CPZBElementGUE {

    @XmlElement(name = "GUE_Abstand_Abweichend")
    protected TCGUEAbstandAbweichend gueAbstandAbweichend;
    @XmlElement(name = "GUE_Anordnung", required = true)
    protected TCGUEAnordnung gueAnordnung;
    @XmlElement(name = "GUE_Bauart", required = true)
    protected TCGUEBauart gueBauart;
    @XmlElement(name = "GUE_Energieversorgung", required = true)
    protected TCGUEEnergieversorgung gueEnergieversorgung;
    @XmlElement(name = "GUE_Messstrecke", required = true)
    protected TCGUEMessstrecke gueMessstrecke;
    @XmlElement(name = "ID_PZB_Element_Mitnutzung")
    protected TCIDPZBElementMitnutzung idpzbElementMitnutzung;
    @XmlElement(name = "Messfehler")
    protected TCMessfehler messfehler;
    @XmlElement(name = "Pruefgeschwindigkeit", required = true)
    protected TCPruefgeschwindigkeit pruefgeschwindigkeit;
    @XmlElement(name = "Pruefzeit")
    protected TCPruefzeit pruefzeit;

    /**
     * Ruft den Wert der gueAbstandAbweichend-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGUEAbstandAbweichend }
     *     
     */
    public TCGUEAbstandAbweichend getGUEAbstandAbweichend() {
        return gueAbstandAbweichend;
    }

    /**
     * Legt den Wert der gueAbstandAbweichend-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGUEAbstandAbweichend }
     *     
     */
    public void setGUEAbstandAbweichend(TCGUEAbstandAbweichend value) {
        this.gueAbstandAbweichend = value;
    }

    /**
     * Ruft den Wert der gueAnordnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGUEAnordnung }
     *     
     */
    public TCGUEAnordnung getGUEAnordnung() {
        return gueAnordnung;
    }

    /**
     * Legt den Wert der gueAnordnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGUEAnordnung }
     *     
     */
    public void setGUEAnordnung(TCGUEAnordnung value) {
        this.gueAnordnung = value;
    }

    /**
     * Ruft den Wert der gueBauart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGUEBauart }
     *     
     */
    public TCGUEBauart getGUEBauart() {
        return gueBauart;
    }

    /**
     * Legt den Wert der gueBauart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGUEBauart }
     *     
     */
    public void setGUEBauart(TCGUEBauart value) {
        this.gueBauart = value;
    }

    /**
     * Ruft den Wert der gueEnergieversorgung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGUEEnergieversorgung }
     *     
     */
    public TCGUEEnergieversorgung getGUEEnergieversorgung() {
        return gueEnergieversorgung;
    }

    /**
     * Legt den Wert der gueEnergieversorgung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGUEEnergieversorgung }
     *     
     */
    public void setGUEEnergieversorgung(TCGUEEnergieversorgung value) {
        this.gueEnergieversorgung = value;
    }

    /**
     * Ruft den Wert der gueMessstrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGUEMessstrecke }
     *     
     */
    public TCGUEMessstrecke getGUEMessstrecke() {
        return gueMessstrecke;
    }

    /**
     * Legt den Wert der gueMessstrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGUEMessstrecke }
     *     
     */
    public void setGUEMessstrecke(TCGUEMessstrecke value) {
        this.gueMessstrecke = value;
    }

    /**
     * Ruft den Wert der idpzbElementMitnutzung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDPZBElementMitnutzung }
     *     
     */
    public TCIDPZBElementMitnutzung getIDPZBElementMitnutzung() {
        return idpzbElementMitnutzung;
    }

    /**
     * Legt den Wert der idpzbElementMitnutzung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDPZBElementMitnutzung }
     *     
     */
    public void setIDPZBElementMitnutzung(TCIDPZBElementMitnutzung value) {
        this.idpzbElementMitnutzung = value;
    }

    /**
     * Ruft den Wert der messfehler-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMessfehler }
     *     
     */
    public TCMessfehler getMessfehler() {
        return messfehler;
    }

    /**
     * Legt den Wert der messfehler-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMessfehler }
     *     
     */
    public void setMessfehler(TCMessfehler value) {
        this.messfehler = value;
    }

    /**
     * Ruft den Wert der pruefgeschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPruefgeschwindigkeit }
     *     
     */
    public TCPruefgeschwindigkeit getPruefgeschwindigkeit() {
        return pruefgeschwindigkeit;
    }

    /**
     * Legt den Wert der pruefgeschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPruefgeschwindigkeit }
     *     
     */
    public void setPruefgeschwindigkeit(TCPruefgeschwindigkeit value) {
        this.pruefgeschwindigkeit = value;
    }

    /**
     * Ruft den Wert der pruefzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPruefzeit }
     *     
     */
    public TCPruefzeit getPruefzeit() {
        return pruefzeit;
    }

    /**
     * Legt den Wert der pruefzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPruefzeit }
     *     
     */
    public void setPruefzeit(TCPruefzeit value) {
        this.pruefzeit = value;
    }

}
