//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.block._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBlock_Element_Erlaubnis complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Element_Erlaubnis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auto_Erlaubnisholen" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCAuto_Erlaubnisholen" minOccurs="0"/>
 *         &lt;element name="Auto_Erlaubnisruecklauf" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCAuto_Erlaubnisruecklauf" minOccurs="0"/>
 *         &lt;element name="Erlaubnis_Staendig_Vorhanden" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCErlaubnis_Staendig_Vorhanden" minOccurs="0"/>
 *         &lt;element name="Erlaubnisabgabespeicherung" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCErlaubnisabgabespeicherung" minOccurs="0"/>
 *         &lt;element name="Erlaubnisholen" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCErlaubnisholen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Element_Erlaubnis", propOrder = {
    "autoErlaubnisholen",
    "autoErlaubnisruecklauf",
    "erlaubnisStaendigVorhanden",
    "erlaubnisabgabespeicherung",
    "erlaubnisholen"
})
public class CBlockElementErlaubnis {

    @XmlElement(name = "Auto_Erlaubnisholen")
    protected TCAutoErlaubnisholen autoErlaubnisholen;
    @XmlElement(name = "Auto_Erlaubnisruecklauf")
    protected TCAutoErlaubnisruecklauf autoErlaubnisruecklauf;
    @XmlElement(name = "Erlaubnis_Staendig_Vorhanden")
    protected TCErlaubnisStaendigVorhanden erlaubnisStaendigVorhanden;
    @XmlElement(name = "Erlaubnisabgabespeicherung")
    protected TCErlaubnisabgabespeicherung erlaubnisabgabespeicherung;
    @XmlElement(name = "Erlaubnisholen")
    protected TCErlaubnisholen erlaubnisholen;

    /**
     * Ruft den Wert der autoErlaubnisholen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutoErlaubnisholen }
     *     
     */
    public TCAutoErlaubnisholen getAutoErlaubnisholen() {
        return autoErlaubnisholen;
    }

    /**
     * Legt den Wert der autoErlaubnisholen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutoErlaubnisholen }
     *     
     */
    public void setAutoErlaubnisholen(TCAutoErlaubnisholen value) {
        this.autoErlaubnisholen = value;
    }

    /**
     * Ruft den Wert der autoErlaubnisruecklauf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutoErlaubnisruecklauf }
     *     
     */
    public TCAutoErlaubnisruecklauf getAutoErlaubnisruecklauf() {
        return autoErlaubnisruecklauf;
    }

    /**
     * Legt den Wert der autoErlaubnisruecklauf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutoErlaubnisruecklauf }
     *     
     */
    public void setAutoErlaubnisruecklauf(TCAutoErlaubnisruecklauf value) {
        this.autoErlaubnisruecklauf = value;
    }

    /**
     * Ruft den Wert der erlaubnisStaendigVorhanden-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCErlaubnisStaendigVorhanden }
     *     
     */
    public TCErlaubnisStaendigVorhanden getErlaubnisStaendigVorhanden() {
        return erlaubnisStaendigVorhanden;
    }

    /**
     * Legt den Wert der erlaubnisStaendigVorhanden-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCErlaubnisStaendigVorhanden }
     *     
     */
    public void setErlaubnisStaendigVorhanden(TCErlaubnisStaendigVorhanden value) {
        this.erlaubnisStaendigVorhanden = value;
    }

    /**
     * Ruft den Wert der erlaubnisabgabespeicherung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCErlaubnisabgabespeicherung }
     *     
     */
    public TCErlaubnisabgabespeicherung getErlaubnisabgabespeicherung() {
        return erlaubnisabgabespeicherung;
    }

    /**
     * Legt den Wert der erlaubnisabgabespeicherung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCErlaubnisabgabespeicherung }
     *     
     */
    public void setErlaubnisabgabespeicherung(TCErlaubnisabgabespeicherung value) {
        this.erlaubnisabgabespeicherung = value;
    }

    /**
     * Ruft den Wert der erlaubnisholen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCErlaubnisholen }
     *     
     */
    public TCErlaubnisholen getErlaubnisholen() {
        return erlaubnisholen;
    }

    /**
     * Legt den Wert der erlaubnisholen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCErlaubnisholen }
     *     
     */
    public void setErlaubnisholen(TCErlaubnisholen value) {
        this.erlaubnisholen = value;
    }

}
