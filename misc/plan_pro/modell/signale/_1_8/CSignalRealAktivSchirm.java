//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Real_Aktiv_Schirm complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Real_Aktiv_Schirm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bedienart" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCBedienart" minOccurs="0"/>
 *         &lt;element name="Dunkelschaltung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCDunkelschaltung"/>
 *         &lt;element name="Richtpunkt" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCRichtpunkt" minOccurs="0"/>
 *         &lt;element name="Richtpunktentfernung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCRichtpunktentfernung"/>
 *         &lt;element name="Signal_Art" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSignal_Art"/>
 *         &lt;element name="Signalsystem" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSignalsystem"/>
 *         &lt;element name="Streuscheibe_Art" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCStreuscheibe_Art" minOccurs="0"/>
 *         &lt;element name="Streuscheibe_Betriebsstellung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCStreuscheibe_Betriebsstellung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Real_Aktiv_Schirm", propOrder = {
    "bedienart",
    "dunkelschaltung",
    "richtpunkt",
    "richtpunktentfernung",
    "signalArt",
    "signalsystem",
    "streuscheibeArt",
    "streuscheibeBetriebsstellung"
})
public class CSignalRealAktivSchirm {

    @XmlElement(name = "Bedienart")
    protected TCBedienart bedienart;
    @XmlElement(name = "Dunkelschaltung", required = true)
    protected TCDunkelschaltung dunkelschaltung;
    @XmlElement(name = "Richtpunkt")
    protected TCRichtpunkt richtpunkt;
    @XmlElement(name = "Richtpunktentfernung", required = true)
    protected TCRichtpunktentfernung richtpunktentfernung;
    @XmlElement(name = "Signal_Art", required = true)
    protected TCSignalArt signalArt;
    @XmlElement(name = "Signalsystem", required = true)
    protected TCSignalsystem signalsystem;
    @XmlElement(name = "Streuscheibe_Art")
    protected TCStreuscheibeArt streuscheibeArt;
    @XmlElement(name = "Streuscheibe_Betriebsstellung")
    protected TCStreuscheibeBetriebsstellung streuscheibeBetriebsstellung;

    /**
     * Ruft den Wert der bedienart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienart }
     *     
     */
    public TCBedienart getBedienart() {
        return bedienart;
    }

    /**
     * Legt den Wert der bedienart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienart }
     *     
     */
    public void setBedienart(TCBedienart value) {
        this.bedienart = value;
    }

    /**
     * Ruft den Wert der dunkelschaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDunkelschaltung }
     *     
     */
    public TCDunkelschaltung getDunkelschaltung() {
        return dunkelschaltung;
    }

    /**
     * Legt den Wert der dunkelschaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDunkelschaltung }
     *     
     */
    public void setDunkelschaltung(TCDunkelschaltung value) {
        this.dunkelschaltung = value;
    }

    /**
     * Ruft den Wert der richtpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRichtpunkt }
     *     
     */
    public TCRichtpunkt getRichtpunkt() {
        return richtpunkt;
    }

    /**
     * Legt den Wert der richtpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRichtpunkt }
     *     
     */
    public void setRichtpunkt(TCRichtpunkt value) {
        this.richtpunkt = value;
    }

    /**
     * Ruft den Wert der richtpunktentfernung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRichtpunktentfernung }
     *     
     */
    public TCRichtpunktentfernung getRichtpunktentfernung() {
        return richtpunktentfernung;
    }

    /**
     * Legt den Wert der richtpunktentfernung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRichtpunktentfernung }
     *     
     */
    public void setRichtpunktentfernung(TCRichtpunktentfernung value) {
        this.richtpunktentfernung = value;
    }

    /**
     * Ruft den Wert der signalArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalArt }
     *     
     */
    public TCSignalArt getSignalArt() {
        return signalArt;
    }

    /**
     * Legt den Wert der signalArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalArt }
     *     
     */
    public void setSignalArt(TCSignalArt value) {
        this.signalArt = value;
    }

    /**
     * Ruft den Wert der signalsystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalsystem }
     *     
     */
    public TCSignalsystem getSignalsystem() {
        return signalsystem;
    }

    /**
     * Legt den Wert der signalsystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalsystem }
     *     
     */
    public void setSignalsystem(TCSignalsystem value) {
        this.signalsystem = value;
    }

    /**
     * Ruft den Wert der streuscheibeArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreuscheibeArt }
     *     
     */
    public TCStreuscheibeArt getStreuscheibeArt() {
        return streuscheibeArt;
    }

    /**
     * Legt den Wert der streuscheibeArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreuscheibeArt }
     *     
     */
    public void setStreuscheibeArt(TCStreuscheibeArt value) {
        this.streuscheibeArt = value;
    }

    /**
     * Ruft den Wert der streuscheibeBetriebsstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreuscheibeBetriebsstellung }
     *     
     */
    public TCStreuscheibeBetriebsstellung getStreuscheibeBetriebsstellung() {
        return streuscheibeBetriebsstellung;
    }

    /**
     * Legt den Wert der streuscheibeBetriebsstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreuscheibeBetriebsstellung }
     *     
     */
    public void setStreuscheibeBetriebsstellung(TCStreuscheibeBetriebsstellung value) {
        this.streuscheibeBetriebsstellung = value;
    }

}
