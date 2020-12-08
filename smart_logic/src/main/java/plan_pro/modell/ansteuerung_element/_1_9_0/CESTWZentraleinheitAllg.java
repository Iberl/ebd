//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CESTW_Zentraleinheit_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CESTW_Zentraleinheit_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bauart" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCBauart" minOccurs="0"/>
 *         &lt;element name="Energieversorgung_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCEnergieversorgung_Art"/>
 *         &lt;element name="Energieversorgung_Art_Ersatz" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCEnergieversorgung_Art_Ersatz" minOccurs="0"/>
 *         &lt;element name="Energieversorgung_Art_Ersatz_2" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCEnergieversorgung_Art_Ersatz" minOccurs="0"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCHersteller" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CESTW_Zentraleinheit_Allg", propOrder = {
    "bauart",
    "energieversorgungArt",
    "energieversorgungArtErsatz",
    "energieversorgungArtErsatz2",
    "hersteller"
})
public class CESTWZentraleinheitAllg {

    @XmlElement(name = "Bauart")
    protected TCBauart bauart;
    @XmlElement(name = "Energieversorgung_Art", required = true)
    protected TCEnergieversorgungArt energieversorgungArt;
    @XmlElement(name = "Energieversorgung_Art_Ersatz")
    protected TCEnergieversorgungArtErsatz energieversorgungArtErsatz;
    @XmlElement(name = "Energieversorgung_Art_Ersatz_2")
    protected TCEnergieversorgungArtErsatz energieversorgungArtErsatz2;
    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;

    /**
     * Ruft den Wert der bauart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBauart }
     *     
     */
    public TCBauart getBauart() {
        return bauart;
    }

    /**
     * Legt den Wert der bauart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBauart }
     *     
     */
    public void setBauart(TCBauart value) {
        this.bauart = value;
    }

    /**
     * Ruft den Wert der energieversorgungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEnergieversorgungArt }
     *     
     */
    public TCEnergieversorgungArt getEnergieversorgungArt() {
        return energieversorgungArt;
    }

    /**
     * Legt den Wert der energieversorgungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnergieversorgungArt }
     *     
     */
    public void setEnergieversorgungArt(TCEnergieversorgungArt value) {
        this.energieversorgungArt = value;
    }

    /**
     * Ruft den Wert der energieversorgungArtErsatz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEnergieversorgungArtErsatz }
     *     
     */
    public TCEnergieversorgungArtErsatz getEnergieversorgungArtErsatz() {
        return energieversorgungArtErsatz;
    }

    /**
     * Legt den Wert der energieversorgungArtErsatz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnergieversorgungArtErsatz }
     *     
     */
    public void setEnergieversorgungArtErsatz(TCEnergieversorgungArtErsatz value) {
        this.energieversorgungArtErsatz = value;
    }

    /**
     * Ruft den Wert der energieversorgungArtErsatz2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEnergieversorgungArtErsatz }
     *     
     */
    public TCEnergieversorgungArtErsatz getEnergieversorgungArtErsatz2() {
        return energieversorgungArtErsatz2;
    }

    /**
     * Legt den Wert der energieversorgungArtErsatz2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnergieversorgungArtErsatz }
     *     
     */
    public void setEnergieversorgungArtErsatz2(TCEnergieversorgungArtErsatz value) {
        this.energieversorgungArtErsatz2 = value;
    }

    /**
     * Ruft den Wert der hersteller-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHersteller }
     *     
     */
    public TCHersteller getHersteller() {
        return hersteller;
    }

    /**
     * Legt den Wert der hersteller-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHersteller }
     *     
     */
    public void setHersteller(TCHersteller value) {
        this.hersteller = value;
    }

}
