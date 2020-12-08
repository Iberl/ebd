//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.regelzeichnung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CRegelzeichnung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRegelzeichnung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bild" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.9.0.2}TCBild" minOccurs="0"/>
 *         &lt;element name="RZ_Nummer" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.9.0.2}TCRZ_Nummer"/>
 *         &lt;element name="Titel" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.9.0.2}TCTitel" minOccurs="0"/>
 *         &lt;element name="Untertitel" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.9.0.2}TCUntertitel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRegelzeichnung_Allg", propOrder = {
    "bild",
    "rzNummer",
    "titel",
    "untertitel"
})
public class CRegelzeichnungAllg {

    @XmlElement(name = "Bild")
    protected TCBild bild;
    @XmlElement(name = "RZ_Nummer", required = true)
    protected TCRZNummer rzNummer;
    @XmlElement(name = "Titel")
    protected TCTitel titel;
    @XmlElement(name = "Untertitel")
    protected TCUntertitel untertitel;

    /**
     * Ruft den Wert der bild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBild }
     *     
     */
    public TCBild getBild() {
        return bild;
    }

    /**
     * Legt den Wert der bild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBild }
     *     
     */
    public void setBild(TCBild value) {
        this.bild = value;
    }

    /**
     * Ruft den Wert der rzNummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRZNummer }
     *     
     */
    public TCRZNummer getRZNummer() {
        return rzNummer;
    }

    /**
     * Legt den Wert der rzNummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRZNummer }
     *     
     */
    public void setRZNummer(TCRZNummer value) {
        this.rzNummer = value;
    }

    /**
     * Ruft den Wert der titel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTitel }
     *     
     */
    public TCTitel getTitel() {
        return titel;
    }

    /**
     * Legt den Wert der titel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTitel }
     *     
     */
    public void setTitel(TCTitel value) {
        this.titel = value;
    }

    /**
     * Ruft den Wert der untertitel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUntertitel }
     *     
     */
    public TCUntertitel getUntertitel() {
        return untertitel;
    }

    /**
     * Legt den Wert der untertitel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUntertitel }
     *     
     */
    public void setUntertitel(TCUntertitel value) {
        this.untertitel = value;
    }

}
