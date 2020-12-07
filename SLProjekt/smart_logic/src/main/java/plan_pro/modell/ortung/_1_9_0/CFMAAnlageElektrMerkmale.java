//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFMA_Anlage_Elektr_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Anlage_Elektr_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bettungswiderstand" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCBettungswiderstand" minOccurs="0"/>
 *         &lt;element name="FMA_Laenge" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Laenge" minOccurs="0"/>
 *         &lt;element name="FMA_Laenge_Beeinflusst" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Laenge_Beeinflusst" minOccurs="0"/>
 *         &lt;element name="FMA_Laenge_E1" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Laenge_E1" minOccurs="0"/>
 *         &lt;element name="FMA_Laenge_E2" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Laenge_E2" minOccurs="0"/>
 *         &lt;element name="FMA_Laenge_E3" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Laenge_E3" minOccurs="0"/>
 *         &lt;element name="FMA_Laenge_S" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Laenge_S" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Anlage_Elektr_Merkmale", propOrder = {
    "bettungswiderstand",
    "fmaLaenge",
    "fmaLaengeBeeinflusst",
    "fmaLaengeE1",
    "fmaLaengeE2",
    "fmaLaengeE3",
    "fmaLaengeS"
})
public class CFMAAnlageElektrMerkmale {

    @XmlElement(name = "Bettungswiderstand")
    protected TCBettungswiderstand bettungswiderstand;
    @XmlElement(name = "FMA_Laenge")
    protected TCFMALaenge fmaLaenge;
    @XmlElement(name = "FMA_Laenge_Beeinflusst")
    protected TCFMALaengeBeeinflusst fmaLaengeBeeinflusst;
    @XmlElement(name = "FMA_Laenge_E1")
    protected TCFMALaengeE1 fmaLaengeE1;
    @XmlElement(name = "FMA_Laenge_E2")
    protected TCFMALaengeE2 fmaLaengeE2;
    @XmlElement(name = "FMA_Laenge_E3")
    protected TCFMALaengeE3 fmaLaengeE3;
    @XmlElement(name = "FMA_Laenge_S")
    protected TCFMALaengeS fmaLaengeS;

    /**
     * Ruft den Wert der bettungswiderstand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBettungswiderstand }
     *     
     */
    public TCBettungswiderstand getBettungswiderstand() {
        return bettungswiderstand;
    }

    /**
     * Legt den Wert der bettungswiderstand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBettungswiderstand }
     *     
     */
    public void setBettungswiderstand(TCBettungswiderstand value) {
        this.bettungswiderstand = value;
    }

    /**
     * Ruft den Wert der fmaLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMALaenge }
     *     
     */
    public TCFMALaenge getFMALaenge() {
        return fmaLaenge;
    }

    /**
     * Legt den Wert der fmaLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMALaenge }
     *     
     */
    public void setFMALaenge(TCFMALaenge value) {
        this.fmaLaenge = value;
    }

    /**
     * Ruft den Wert der fmaLaengeBeeinflusst-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMALaengeBeeinflusst }
     *     
     */
    public TCFMALaengeBeeinflusst getFMALaengeBeeinflusst() {
        return fmaLaengeBeeinflusst;
    }

    /**
     * Legt den Wert der fmaLaengeBeeinflusst-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMALaengeBeeinflusst }
     *     
     */
    public void setFMALaengeBeeinflusst(TCFMALaengeBeeinflusst value) {
        this.fmaLaengeBeeinflusst = value;
    }

    /**
     * Ruft den Wert der fmaLaengeE1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMALaengeE1 }
     *     
     */
    public TCFMALaengeE1 getFMALaengeE1() {
        return fmaLaengeE1;
    }

    /**
     * Legt den Wert der fmaLaengeE1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMALaengeE1 }
     *     
     */
    public void setFMALaengeE1(TCFMALaengeE1 value) {
        this.fmaLaengeE1 = value;
    }

    /**
     * Ruft den Wert der fmaLaengeE2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMALaengeE2 }
     *     
     */
    public TCFMALaengeE2 getFMALaengeE2() {
        return fmaLaengeE2;
    }

    /**
     * Legt den Wert der fmaLaengeE2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMALaengeE2 }
     *     
     */
    public void setFMALaengeE2(TCFMALaengeE2 value) {
        this.fmaLaengeE2 = value;
    }

    /**
     * Ruft den Wert der fmaLaengeE3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMALaengeE3 }
     *     
     */
    public TCFMALaengeE3 getFMALaengeE3() {
        return fmaLaengeE3;
    }

    /**
     * Legt den Wert der fmaLaengeE3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMALaengeE3 }
     *     
     */
    public void setFMALaengeE3(TCFMALaengeE3 value) {
        this.fmaLaengeE3 = value;
    }

    /**
     * Ruft den Wert der fmaLaengeS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMALaengeS }
     *     
     */
    public TCFMALaengeS getFMALaengeS() {
        return fmaLaengeS;
    }

    /**
     * Legt den Wert der fmaLaengeS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMALaengeS }
     *     
     */
    public void setFMALaengeS(TCFMALaengeS value) {
        this.fmaLaengeS = value;
    }

}
