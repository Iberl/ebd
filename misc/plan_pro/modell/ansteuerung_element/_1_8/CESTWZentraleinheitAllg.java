//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Bauart" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCBauart" minOccurs="0"/>
 *         &lt;element name="Energieversorgung_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCEnergieversorgung_Art"/>
 *         &lt;element name="Energieversorgung_Art_Ersatz" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCEnergieversorgung_Art_Ersatz" minOccurs="0"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCHersteller" minOccurs="0"/>
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
    "hersteller"
})
public class CESTWZentraleinheitAllg {

    @XmlElement(name = "Bauart")
    protected TCBauart bauart;
    @XmlElement(name = "Energieversorgung_Art", required = true)
    protected TCEnergieversorgungArt energieversorgungArt;
    @XmlElement(name = "Energieversorgung_Art_Ersatz")
    protected TCEnergieversorgungArtErsatz energieversorgungArtErsatz;
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
