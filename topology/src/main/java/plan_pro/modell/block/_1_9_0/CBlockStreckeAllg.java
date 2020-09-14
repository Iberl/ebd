//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.block._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBlock_Strecke_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Strecke_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Betriebsfuehrung" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCBetriebsfuehrung"/>
 *         &lt;element name="Bremsweg" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCBremsweg"/>
 *         &lt;element name="Entwurfsgeschwindigkeit" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCEntwurfsgeschwindigkeit"/>
 *         &lt;element name="Strecke_Art" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCStrecke_Art" minOccurs="0"/>
 *         &lt;element name="Traktion_Art" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCTraktion_Art" minOccurs="0"/>
 *         &lt;element name="Zugbeeinflussung_Art" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCZugbeeinflussung_Art" minOccurs="0"/>
 *         &lt;element name="Zusatzinformation" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCZusatzinformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Strecke_Allg", propOrder = {
    "betriebsfuehrung",
    "bremsweg",
    "entwurfsgeschwindigkeit",
    "streckeArt",
    "traktionArt",
    "zugbeeinflussungArt",
    "zusatzinformation"
})
public class CBlockStreckeAllg {

    @XmlElement(name = "Betriebsfuehrung", required = true)
    protected TCBetriebsfuehrung betriebsfuehrung;
    @XmlElement(name = "Bremsweg", required = true)
    protected TCBremsweg bremsweg;
    @XmlElement(name = "Entwurfsgeschwindigkeit", required = true)
    protected TCEntwurfsgeschwindigkeit entwurfsgeschwindigkeit;
    @XmlElement(name = "Strecke_Art")
    protected TCStreckeArt streckeArt;
    @XmlElement(name = "Traktion_Art")
    protected TCTraktionArt traktionArt;
    @XmlElement(name = "Zugbeeinflussung_Art")
    protected TCZugbeeinflussungArt zugbeeinflussungArt;
    @XmlElement(name = "Zusatzinformation")
    protected TCZusatzinformation zusatzinformation;

    /**
     * Ruft den Wert der betriebsfuehrung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBetriebsfuehrung }
     *     
     */
    public TCBetriebsfuehrung getBetriebsfuehrung() {
        return betriebsfuehrung;
    }

    /**
     * Legt den Wert der betriebsfuehrung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBetriebsfuehrung }
     *     
     */
    public void setBetriebsfuehrung(TCBetriebsfuehrung value) {
        this.betriebsfuehrung = value;
    }

    /**
     * Ruft den Wert der bremsweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBremsweg }
     *     
     */
    public TCBremsweg getBremsweg() {
        return bremsweg;
    }

    /**
     * Legt den Wert der bremsweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBremsweg }
     *     
     */
    public void setBremsweg(TCBremsweg value) {
        this.bremsweg = value;
    }

    /**
     * Ruft den Wert der entwurfsgeschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEntwurfsgeschwindigkeit }
     *     
     */
    public TCEntwurfsgeschwindigkeit getEntwurfsgeschwindigkeit() {
        return entwurfsgeschwindigkeit;
    }

    /**
     * Legt den Wert der entwurfsgeschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEntwurfsgeschwindigkeit }
     *     
     */
    public void setEntwurfsgeschwindigkeit(TCEntwurfsgeschwindigkeit value) {
        this.entwurfsgeschwindigkeit = value;
    }

    /**
     * Ruft den Wert der streckeArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreckeArt }
     *     
     */
    public TCStreckeArt getStreckeArt() {
        return streckeArt;
    }

    /**
     * Legt den Wert der streckeArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreckeArt }
     *     
     */
    public void setStreckeArt(TCStreckeArt value) {
        this.streckeArt = value;
    }

    /**
     * Ruft den Wert der traktionArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTraktionArt }
     *     
     */
    public TCTraktionArt getTraktionArt() {
        return traktionArt;
    }

    /**
     * Legt den Wert der traktionArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTraktionArt }
     *     
     */
    public void setTraktionArt(TCTraktionArt value) {
        this.traktionArt = value;
    }

    /**
     * Ruft den Wert der zugbeeinflussungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZugbeeinflussungArt }
     *     
     */
    public TCZugbeeinflussungArt getZugbeeinflussungArt() {
        return zugbeeinflussungArt;
    }

    /**
     * Legt den Wert der zugbeeinflussungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZugbeeinflussungArt }
     *     
     */
    public void setZugbeeinflussungArt(TCZugbeeinflussungArt value) {
        this.zugbeeinflussungArt = value;
    }

    /**
     * Ruft den Wert der zusatzinformation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZusatzinformation }
     *     
     */
    public TCZusatzinformation getZusatzinformation() {
        return zusatzinformation;
    }

    /**
     * Legt den Wert der zusatzinformation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZusatzinformation }
     *     
     */
    public void setZusatzinformation(TCZusatzinformation value) {
        this.zusatzinformation = value;
    }

}
