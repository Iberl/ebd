//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import modell.verweise._1_8.TCIDGrenzzeichen;
import modell.verweise._1_8.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CWeiche_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CWeiche_Element">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auffahrortung" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCAuffahrortung" minOccurs="0"/>
 *         &lt;element name="GZ_Freimeldung_L" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CGZ_Freimeldung_L" minOccurs="0"/>
 *         &lt;element name="GZ_Freimeldung_R" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CGZ_Freimeldung_R" minOccurs="0"/>
 *         &lt;element name="ID_Grenzzeichen" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Grenzzeichen" minOccurs="0"/>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal" minOccurs="0"/>
 *         &lt;element name="Weiche_Betriebsart" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCWeiche_Betriebsart" minOccurs="0"/>
 *         &lt;element name="Weiche_Vorzugslage" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCWeiche_Vorzugslage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CWeiche_Element", propOrder = {
    "auffahrortung",
    "gzFreimeldungL",
    "gzFreimeldungR",
    "idGrenzzeichen",
    "idSignal",
    "weicheBetriebsart",
    "weicheVorzugslage"
})
public class CWeicheElement {

    @XmlElement(name = "Auffahrortung")
    protected TCAuffahrortung auffahrortung;
    @XmlElement(name = "GZ_Freimeldung_L")
    protected CGZFreimeldungL gzFreimeldungL;
    @XmlElement(name = "GZ_Freimeldung_R")
    protected CGZFreimeldungR gzFreimeldungR;
    @XmlElement(name = "ID_Grenzzeichen")
    protected TCIDGrenzzeichen idGrenzzeichen;
    @XmlElement(name = "ID_Signal")
    protected TCIDSignal idSignal;
    @XmlElement(name = "Weiche_Betriebsart")
    protected TCWeicheBetriebsart weicheBetriebsart;
    @XmlElement(name = "Weiche_Vorzugslage")
    protected TCWeicheVorzugslage weicheVorzugslage;

    /**
     * Ruft den Wert der auffahrortung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAuffahrortung }
     *     
     */
    public TCAuffahrortung getAuffahrortung() {
        return auffahrortung;
    }

    /**
     * Legt den Wert der auffahrortung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAuffahrortung }
     *     
     */
    public void setAuffahrortung(TCAuffahrortung value) {
        this.auffahrortung = value;
    }

    /**
     * Ruft den Wert der gzFreimeldungL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGZFreimeldungL }
     *     
     */
    public CGZFreimeldungL getGZFreimeldungL() {
        return gzFreimeldungL;
    }

    /**
     * Legt den Wert der gzFreimeldungL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGZFreimeldungL }
     *     
     */
    public void setGZFreimeldungL(CGZFreimeldungL value) {
        this.gzFreimeldungL = value;
    }

    /**
     * Ruft den Wert der gzFreimeldungR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGZFreimeldungR }
     *     
     */
    public CGZFreimeldungR getGZFreimeldungR() {
        return gzFreimeldungR;
    }

    /**
     * Legt den Wert der gzFreimeldungR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGZFreimeldungR }
     *     
     */
    public void setGZFreimeldungR(CGZFreimeldungR value) {
        this.gzFreimeldungR = value;
    }

    /**
     * Ruft den Wert der idGrenzzeichen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGrenzzeichen }
     *     
     */
    public TCIDGrenzzeichen getIDGrenzzeichen() {
        return idGrenzzeichen;
    }

    /**
     * Legt den Wert der idGrenzzeichen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGrenzzeichen }
     *     
     */
    public void setIDGrenzzeichen(TCIDGrenzzeichen value) {
        this.idGrenzzeichen = value;
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
     * Ruft den Wert der weicheBetriebsart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWeicheBetriebsart }
     *     
     */
    public TCWeicheBetriebsart getWeicheBetriebsart() {
        return weicheBetriebsart;
    }

    /**
     * Legt den Wert der weicheBetriebsart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWeicheBetriebsart }
     *     
     */
    public void setWeicheBetriebsart(TCWeicheBetriebsart value) {
        this.weicheBetriebsart = value;
    }

    /**
     * Ruft den Wert der weicheVorzugslage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWeicheVorzugslage }
     *     
     */
    public TCWeicheVorzugslage getWeicheVorzugslage() {
        return weicheVorzugslage;
    }

    /**
     * Legt den Wert der weicheVorzugslage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWeicheVorzugslage }
     *     
     */
    public void setWeicheVorzugslage(TCWeicheVorzugslage value) {
        this.weicheVorzugslage = value;
    }

}
