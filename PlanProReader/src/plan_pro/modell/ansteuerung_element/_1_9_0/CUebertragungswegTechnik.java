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
 * <p>Java-Klasse f�r CUebertragungsweg_Technik complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUebertragungsweg_Technik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bandbreite" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCBandbreite" minOccurs="0"/>
 *         &lt;element name="Medium_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCMedium_Art" minOccurs="0"/>
 *         &lt;element name="Netz_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCNetz_Art" minOccurs="0"/>
 *         &lt;element name="Technik_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCTechnik_Art"/>
 *         &lt;element name="Technik_Beschreibung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCTechnik_Beschreibung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUebertragungsweg_Technik", propOrder = {
    "bandbreite",
    "mediumArt",
    "netzArt",
    "technikArt",
    "technikBeschreibung"
})
public class CUebertragungswegTechnik {

    @XmlElement(name = "Bandbreite")
    protected TCBandbreite bandbreite;
    @XmlElement(name = "Medium_Art")
    protected TCMediumArt mediumArt;
    @XmlElement(name = "Netz_Art")
    protected TCNetzArt netzArt;
    @XmlElement(name = "Technik_Art", required = true)
    protected TCTechnikArt technikArt;
    @XmlElement(name = "Technik_Beschreibung")
    protected TCTechnikBeschreibung technikBeschreibung;

    /**
     * Ruft den Wert der bandbreite-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBandbreite }
     *     
     */
    public TCBandbreite getBandbreite() {
        return bandbreite;
    }

    /**
     * Legt den Wert der bandbreite-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBandbreite }
     *     
     */
    public void setBandbreite(TCBandbreite value) {
        this.bandbreite = value;
    }

    /**
     * Ruft den Wert der mediumArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMediumArt }
     *     
     */
    public TCMediumArt getMediumArt() {
        return mediumArt;
    }

    /**
     * Legt den Wert der mediumArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMediumArt }
     *     
     */
    public void setMediumArt(TCMediumArt value) {
        this.mediumArt = value;
    }

    /**
     * Ruft den Wert der netzArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNetzArt }
     *     
     */
    public TCNetzArt getNetzArt() {
        return netzArt;
    }

    /**
     * Legt den Wert der netzArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNetzArt }
     *     
     */
    public void setNetzArt(TCNetzArt value) {
        this.netzArt = value;
    }

    /**
     * Ruft den Wert der technikArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTechnikArt }
     *     
     */
    public TCTechnikArt getTechnikArt() {
        return technikArt;
    }

    /**
     * Legt den Wert der technikArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTechnikArt }
     *     
     */
    public void setTechnikArt(TCTechnikArt value) {
        this.technikArt = value;
    }

    /**
     * Ruft den Wert der technikBeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTechnikBeschreibung }
     *     
     */
    public TCTechnikBeschreibung getTechnikBeschreibung() {
        return technikBeschreibung;
    }

    /**
     * Legt den Wert der technikBeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTechnikBeschreibung }
     *     
     */
    public void setTechnikBeschreibung(TCTechnikBeschreibung value) {
        this.technikBeschreibung = value;
    }

}
