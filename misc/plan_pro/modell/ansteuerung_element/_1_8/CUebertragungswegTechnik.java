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
 * <p>Java-Klasse f�r CUebertragungsweg_Technik complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUebertragungsweg_Technik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bandbreite" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCBandbreite" minOccurs="0"/>
 *         &lt;element name="Netz" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCNetz" minOccurs="0"/>
 *         &lt;element name="Physik" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCPhysik" minOccurs="0"/>
 *         &lt;element name="Technik_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCTechnik_Art"/>
 *         &lt;element name="Technik_Beschreibung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCTechnik_Beschreibung" minOccurs="0"/>
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
    "netz",
    "physik",
    "technikArt",
    "technikBeschreibung"
})
public class CUebertragungswegTechnik {

    @XmlElement(name = "Bandbreite")
    protected TCBandbreite bandbreite;
    @XmlElement(name = "Netz")
    protected TCNetz netz;
    @XmlElement(name = "Physik")
    protected TCPhysik physik;
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
     * Ruft den Wert der netz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNetz }
     *     
     */
    public TCNetz getNetz() {
        return netz;
    }

    /**
     * Legt den Wert der netz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNetz }
     *     
     */
    public void setNetz(TCNetz value) {
        this.netz = value;
    }

    /**
     * Ruft den Wert der physik-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPhysik }
     *     
     */
    public TCPhysik getPhysik() {
        return physik;
    }

    /**
     * Legt den Wert der physik-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPhysik }
     *     
     */
    public void setPhysik(TCPhysik value) {
        this.physik = value;
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
