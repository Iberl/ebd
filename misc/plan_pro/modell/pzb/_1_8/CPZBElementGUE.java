//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.pzb._1_8;

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
 *         &lt;element name="GUE_Abstand_Abweichend" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCGUE_Abstand_Abweichend" minOccurs="0"/>
 *         &lt;element name="GUE_Anordnung" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCGUE_Anordnung"/>
 *         &lt;element name="GUE_Energieversorgung" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCGUE_Energieversorgung"/>
 *         &lt;element name="GUE_Messstrecke" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCGUE_Messstrecke"/>
 *         &lt;element name="GUE_Wirkmagnet_Am_Signal" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCGUE_Wirkmagnet_Am_Signal"/>
 *         &lt;element name="Pruefgeschwindigkeit" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCPruefgeschwindigkeit"/>
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
    "gueEnergieversorgung",
    "gueMessstrecke",
    "gueWirkmagnetAmSignal",
    "pruefgeschwindigkeit"
})
public class CPZBElementGUE {

    @XmlElement(name = "GUE_Abstand_Abweichend")
    protected TCGUEAbstandAbweichend gueAbstandAbweichend;
    @XmlElement(name = "GUE_Anordnung", required = true)
    protected TCGUEAnordnung gueAnordnung;
    @XmlElement(name = "GUE_Energieversorgung", required = true)
    protected TCGUEEnergieversorgung gueEnergieversorgung;
    @XmlElement(name = "GUE_Messstrecke", required = true)
    protected TCGUEMessstrecke gueMessstrecke;
    @XmlElement(name = "GUE_Wirkmagnet_Am_Signal", required = true)
    protected TCGUEWirkmagnetAmSignal gueWirkmagnetAmSignal;
    @XmlElement(name = "Pruefgeschwindigkeit", required = true)
    protected TCPruefgeschwindigkeit pruefgeschwindigkeit;

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
     * Ruft den Wert der gueWirkmagnetAmSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGUEWirkmagnetAmSignal }
     *     
     */
    public TCGUEWirkmagnetAmSignal getGUEWirkmagnetAmSignal() {
        return gueWirkmagnetAmSignal;
    }

    /**
     * Legt den Wert der gueWirkmagnetAmSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGUEWirkmagnetAmSignal }
     *     
     */
    public void setGUEWirkmagnetAmSignal(TCGUEWirkmagnetAmSignal value) {
        this.gueWirkmagnetAmSignal = value;
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

}
