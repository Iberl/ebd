//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import modell.verweise._1_8.TCIDStellelement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Real_Aktiv complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Real_Aktiv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auto_Einstellung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCAuto_Einstellung" minOccurs="0"/>
 *         &lt;element name="ID_Stellelement" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Stellelement"/>
 *         &lt;element name="Signal_Funktion" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSignal_Funktion"/>
 *         &lt;element name="Signalsicht_Erreichbar" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSignalsicht_Erreichbar" minOccurs="0"/>
 *         &lt;element name="Signalsicht_Mindest" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSignalsicht_Mindest" minOccurs="0"/>
 *         &lt;element name="Signalsicht_Soll" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSignalsicht_Soll" minOccurs="0"/>
 *         &lt;element name="Sonstige_Zulaessige_Anordnung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCSonstige_Zulaessige_Anordnung" minOccurs="0"/>
 *         &lt;element name="Tunnelsignal" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCTunnelsignal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Real_Aktiv", propOrder = {
    "autoEinstellung",
    "idStellelement",
    "signalFunktion",
    "signalsichtErreichbar",
    "signalsichtMindest",
    "signalsichtSoll",
    "sonstigeZulaessigeAnordnung",
    "tunnelsignal"
})
public class CSignalRealAktiv {

    @XmlElement(name = "Auto_Einstellung")
    protected TCAutoEinstellung autoEinstellung;
    @XmlElement(name = "ID_Stellelement", required = true)
    protected TCIDStellelement idStellelement;
    @XmlElement(name = "Signal_Funktion", required = true)
    protected TCSignalFunktion signalFunktion;
    @XmlElement(name = "Signalsicht_Erreichbar")
    protected TCSignalsichtErreichbar signalsichtErreichbar;
    @XmlElement(name = "Signalsicht_Mindest")
    protected TCSignalsichtMindest signalsichtMindest;
    @XmlElement(name = "Signalsicht_Soll")
    protected TCSignalsichtSoll signalsichtSoll;
    @XmlElement(name = "Sonstige_Zulaessige_Anordnung")
    protected TCSonstigeZulaessigeAnordnung sonstigeZulaessigeAnordnung;
    @XmlElement(name = "Tunnelsignal")
    protected TCTunnelsignal tunnelsignal;

    /**
     * Ruft den Wert der autoEinstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutoEinstellung }
     *     
     */
    public TCAutoEinstellung getAutoEinstellung() {
        return autoEinstellung;
    }

    /**
     * Legt den Wert der autoEinstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutoEinstellung }
     *     
     */
    public void setAutoEinstellung(TCAutoEinstellung value) {
        this.autoEinstellung = value;
    }

    /**
     * Ruft den Wert der idStellelement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStellelement }
     *     
     */
    public TCIDStellelement getIDStellelement() {
        return idStellelement;
    }

    /**
     * Legt den Wert der idStellelement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStellelement }
     *     
     */
    public void setIDStellelement(TCIDStellelement value) {
        this.idStellelement = value;
    }

    /**
     * Ruft den Wert der signalFunktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalFunktion }
     *     
     */
    public TCSignalFunktion getSignalFunktion() {
        return signalFunktion;
    }

    /**
     * Legt den Wert der signalFunktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalFunktion }
     *     
     */
    public void setSignalFunktion(TCSignalFunktion value) {
        this.signalFunktion = value;
    }

    /**
     * Ruft den Wert der signalsichtErreichbar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalsichtErreichbar }
     *     
     */
    public TCSignalsichtErreichbar getSignalsichtErreichbar() {
        return signalsichtErreichbar;
    }

    /**
     * Legt den Wert der signalsichtErreichbar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalsichtErreichbar }
     *     
     */
    public void setSignalsichtErreichbar(TCSignalsichtErreichbar value) {
        this.signalsichtErreichbar = value;
    }

    /**
     * Ruft den Wert der signalsichtMindest-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalsichtMindest }
     *     
     */
    public TCSignalsichtMindest getSignalsichtMindest() {
        return signalsichtMindest;
    }

    /**
     * Legt den Wert der signalsichtMindest-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalsichtMindest }
     *     
     */
    public void setSignalsichtMindest(TCSignalsichtMindest value) {
        this.signalsichtMindest = value;
    }

    /**
     * Ruft den Wert der signalsichtSoll-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalsichtSoll }
     *     
     */
    public TCSignalsichtSoll getSignalsichtSoll() {
        return signalsichtSoll;
    }

    /**
     * Legt den Wert der signalsichtSoll-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalsichtSoll }
     *     
     */
    public void setSignalsichtSoll(TCSignalsichtSoll value) {
        this.signalsichtSoll = value;
    }

    /**
     * Ruft den Wert der sonstigeZulaessigeAnordnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSonstigeZulaessigeAnordnung }
     *     
     */
    public TCSonstigeZulaessigeAnordnung getSonstigeZulaessigeAnordnung() {
        return sonstigeZulaessigeAnordnung;
    }

    /**
     * Legt den Wert der sonstigeZulaessigeAnordnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSonstigeZulaessigeAnordnung }
     *     
     */
    public void setSonstigeZulaessigeAnordnung(TCSonstigeZulaessigeAnordnung value) {
        this.sonstigeZulaessigeAnordnung = value;
    }

    /**
     * Ruft den Wert der tunnelsignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTunnelsignal }
     *     
     */
    public TCTunnelsignal getTunnelsignal() {
        return tunnelsignal;
    }

    /**
     * Legt den Wert der tunnelsignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTunnelsignal }
     *     
     */
    public void setTunnelsignal(TCTunnelsignal value) {
        this.tunnelsignal = value;
    }

}
