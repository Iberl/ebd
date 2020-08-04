//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_Fortschalt_Krit_Druck complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Fortschalt_Krit_Druck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ausfahrdruck" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCAusfahrdruck" minOccurs="0"/>
 *         &lt;element name="Ausfahrdruck_Gegengleis" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCAusfahrdruck_Gegengleis" minOccurs="0"/>
 *         &lt;element name="Durchfahrdruck" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCDurchfahrdruck" minOccurs="0"/>
 *         &lt;element name="Einfahrdruck" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCEinfahrdruck" minOccurs="0"/>
 *         &lt;element name="Einfahrdruck_Gegengleis" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCEinfahrdruck_Gegengleis" minOccurs="0"/>
 *         &lt;element name="Meldedruck" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCMeldedruck" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Fortschalt_Krit_Druck", propOrder = {
    "ausfahrdruck",
    "ausfahrdruckGegengleis",
    "durchfahrdruck",
    "einfahrdruck",
    "einfahrdruckGegengleis",
    "meldedruck"
})
public class CZNFortschaltKritDruck {

    @XmlElement(name = "Ausfahrdruck")
    protected TCAusfahrdruck ausfahrdruck;
    @XmlElement(name = "Ausfahrdruck_Gegengleis")
    protected TCAusfahrdruckGegengleis ausfahrdruckGegengleis;
    @XmlElement(name = "Durchfahrdruck")
    protected TCDurchfahrdruck durchfahrdruck;
    @XmlElement(name = "Einfahrdruck")
    protected TCEinfahrdruck einfahrdruck;
    @XmlElement(name = "Einfahrdruck_Gegengleis")
    protected TCEinfahrdruckGegengleis einfahrdruckGegengleis;
    @XmlElement(name = "Meldedruck")
    protected TCMeldedruck meldedruck;

    /**
     * Ruft den Wert der ausfahrdruck-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusfahrdruck }
     *     
     */
    public TCAusfahrdruck getAusfahrdruck() {
        return ausfahrdruck;
    }

    /**
     * Legt den Wert der ausfahrdruck-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusfahrdruck }
     *     
     */
    public void setAusfahrdruck(TCAusfahrdruck value) {
        this.ausfahrdruck = value;
    }

    /**
     * Ruft den Wert der ausfahrdruckGegengleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusfahrdruckGegengleis }
     *     
     */
    public TCAusfahrdruckGegengleis getAusfahrdruckGegengleis() {
        return ausfahrdruckGegengleis;
    }

    /**
     * Legt den Wert der ausfahrdruckGegengleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusfahrdruckGegengleis }
     *     
     */
    public void setAusfahrdruckGegengleis(TCAusfahrdruckGegengleis value) {
        this.ausfahrdruckGegengleis = value;
    }

    /**
     * Ruft den Wert der durchfahrdruck-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDurchfahrdruck }
     *     
     */
    public TCDurchfahrdruck getDurchfahrdruck() {
        return durchfahrdruck;
    }

    /**
     * Legt den Wert der durchfahrdruck-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDurchfahrdruck }
     *     
     */
    public void setDurchfahrdruck(TCDurchfahrdruck value) {
        this.durchfahrdruck = value;
    }

    /**
     * Ruft den Wert der einfahrdruck-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinfahrdruck }
     *     
     */
    public TCEinfahrdruck getEinfahrdruck() {
        return einfahrdruck;
    }

    /**
     * Legt den Wert der einfahrdruck-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinfahrdruck }
     *     
     */
    public void setEinfahrdruck(TCEinfahrdruck value) {
        this.einfahrdruck = value;
    }

    /**
     * Ruft den Wert der einfahrdruckGegengleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinfahrdruckGegengleis }
     *     
     */
    public TCEinfahrdruckGegengleis getEinfahrdruckGegengleis() {
        return einfahrdruckGegengleis;
    }

    /**
     * Legt den Wert der einfahrdruckGegengleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinfahrdruckGegengleis }
     *     
     */
    public void setEinfahrdruckGegengleis(TCEinfahrdruckGegengleis value) {
        this.einfahrdruckGegengleis = value;
    }

    /**
     * Ruft den Wert der meldedruck-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMeldedruck }
     *     
     */
    public TCMeldedruck getMeldedruck() {
        return meldedruck;
    }

    /**
     * Legt den Wert der meldedruck-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMeldedruck }
     *     
     */
    public void setMeldedruck(TCMeldedruck value) {
        this.meldedruck = value;
    }

}
