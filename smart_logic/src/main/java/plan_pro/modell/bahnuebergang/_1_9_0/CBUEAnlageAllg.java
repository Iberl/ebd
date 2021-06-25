//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Anlage_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BUE_Bauart" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Bauart"/>
 *         &lt;element name="BUE_Buestra" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Buestra" minOccurs="0"/>
 *         &lt;element name="BUE_Mit_GFR" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Mit_GFR" minOccurs="0"/>
 *         &lt;element name="BUE_Sicherungsart" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Sicherungsart" minOccurs="0"/>
 *         &lt;element name="BUE_Strasse" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Strasse"/>
 *         &lt;element name="BUE_Technik" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Technik" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Anlage_Allg", propOrder = {
    "bueBauart",
    "bueBuestra",
    "bueMitGFR",
    "bueSicherungsart",
    "bueStrasse",
    "bueTechnik"
})
public class CBUEAnlageAllg {

    @XmlElement(name = "BUE_Bauart", required = true)
    protected TCBUEBauart bueBauart;
    @XmlElement(name = "BUE_Buestra")
    protected TCBUEBuestra bueBuestra;
    @XmlElement(name = "BUE_Mit_GFR")
    protected TCBUEMitGFR bueMitGFR;
    @XmlElement(name = "BUE_Sicherungsart")
    protected TCBUESicherungsart bueSicherungsart;
    @XmlElement(name = "BUE_Strasse", required = true)
    protected TCBUEStrasse bueStrasse;
    @XmlElement(name = "BUE_Technik")
    protected TCBUETechnik bueTechnik;

    /**
     * Ruft den Wert der bueBauart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEBauart }
     *     
     */
    public TCBUEBauart getBUEBauart() {
        return bueBauart;
    }

    /**
     * Legt den Wert der bueBauart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEBauart }
     *     
     */
    public void setBUEBauart(TCBUEBauart value) {
        this.bueBauart = value;
    }

    /**
     * Ruft den Wert der bueBuestra-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEBuestra }
     *     
     */
    public TCBUEBuestra getBUEBuestra() {
        return bueBuestra;
    }

    /**
     * Legt den Wert der bueBuestra-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEBuestra }
     *     
     */
    public void setBUEBuestra(TCBUEBuestra value) {
        this.bueBuestra = value;
    }

    /**
     * Ruft den Wert der bueMitGFR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEMitGFR }
     *     
     */
    public TCBUEMitGFR getBUEMitGFR() {
        return bueMitGFR;
    }

    /**
     * Legt den Wert der bueMitGFR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEMitGFR }
     *     
     */
    public void setBUEMitGFR(TCBUEMitGFR value) {
        this.bueMitGFR = value;
    }

    /**
     * Ruft den Wert der bueSicherungsart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUESicherungsart }
     *     
     */
    public TCBUESicherungsart getBUESicherungsart() {
        return bueSicherungsart;
    }

    /**
     * Legt den Wert der bueSicherungsart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUESicherungsart }
     *     
     */
    public void setBUESicherungsart(TCBUESicherungsart value) {
        this.bueSicherungsart = value;
    }

    /**
     * Ruft den Wert der bueStrasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEStrasse }
     *     
     */
    public TCBUEStrasse getBUEStrasse() {
        return bueStrasse;
    }

    /**
     * Legt den Wert der bueStrasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEStrasse }
     *     
     */
    public void setBUEStrasse(TCBUEStrasse value) {
        this.bueStrasse = value;
    }

    /**
     * Ruft den Wert der bueTechnik-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUETechnik }
     *     
     */
    public TCBUETechnik getBUETechnik() {
        return bueTechnik;
    }

    /**
     * Legt den Wert der bueTechnik-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUETechnik }
     *     
     */
    public void setBUETechnik(TCBUETechnik value) {
        this.bueTechnik = value;
    }

}
