//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import modell.verweise._1_8.TCIDFortschaltungStart;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_Fortschalt_Krit_Schalt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Fortschalt_Krit_Schalt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Besonderes_Schaltkriterium" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCBesonderes_Schaltkriterium" minOccurs="0"/>
 *         &lt;element name="ID_Fortschaltung_Start" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fortschaltung_Start"/>
 *         &lt;element name="Telegrammwiederholung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCTelegrammwiederholung" minOccurs="0"/>
 *         &lt;element name="ZN_Schaltkriterium" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZN_Schaltkriterium"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Fortschalt_Krit_Schalt", propOrder = {
    "besonderesSchaltkriterium",
    "idFortschaltungStart",
    "telegrammwiederholung",
    "znSchaltkriterium"
})
public class CZNFortschaltKritSchalt {

    @XmlElement(name = "Besonderes_Schaltkriterium")
    protected TCBesonderesSchaltkriterium besonderesSchaltkriterium;
    @XmlElement(name = "ID_Fortschaltung_Start", required = true)
    protected TCIDFortschaltungStart idFortschaltungStart;
    @XmlElement(name = "Telegrammwiederholung")
    protected TCTelegrammwiederholung telegrammwiederholung;
    @XmlElement(name = "ZN_Schaltkriterium", required = true)
    protected TCZNSchaltkriterium znSchaltkriterium;

    /**
     * Ruft den Wert der besonderesSchaltkriterium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBesonderesSchaltkriterium }
     *     
     */
    public TCBesonderesSchaltkriterium getBesonderesSchaltkriterium() {
        return besonderesSchaltkriterium;
    }

    /**
     * Legt den Wert der besonderesSchaltkriterium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBesonderesSchaltkriterium }
     *     
     */
    public void setBesonderesSchaltkriterium(TCBesonderesSchaltkriterium value) {
        this.besonderesSchaltkriterium = value;
    }

    /**
     * Ruft den Wert der idFortschaltungStart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFortschaltungStart }
     *     
     */
    public TCIDFortschaltungStart getIDFortschaltungStart() {
        return idFortschaltungStart;
    }

    /**
     * Legt den Wert der idFortschaltungStart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFortschaltungStart }
     *     
     */
    public void setIDFortschaltungStart(TCIDFortschaltungStart value) {
        this.idFortschaltungStart = value;
    }

    /**
     * Ruft den Wert der telegrammwiederholung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegrammwiederholung }
     *     
     */
    public TCTelegrammwiederholung getTelegrammwiederholung() {
        return telegrammwiederholung;
    }

    /**
     * Legt den Wert der telegrammwiederholung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegrammwiederholung }
     *     
     */
    public void setTelegrammwiederholung(TCTelegrammwiederholung value) {
        this.telegrammwiederholung = value;
    }

    /**
     * Ruft den Wert der znSchaltkriterium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNSchaltkriterium }
     *     
     */
    public TCZNSchaltkriterium getZNSchaltkriterium() {
        return znSchaltkriterium;
    }

    /**
     * Legt den Wert der znSchaltkriterium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNSchaltkriterium }
     *     
     */
    public void setZNSchaltkriterium(TCZNSchaltkriterium value) {
        this.znSchaltkriterium = value;
    }

}
