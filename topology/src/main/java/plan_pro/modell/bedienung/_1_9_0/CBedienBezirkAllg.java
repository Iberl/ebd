//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Bezirk_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Bezirk_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anbindung_IB2" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCAnbindung_IB2" minOccurs="0"/>
 *         &lt;element name="Anbindung_IB3" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCAnbindung_IB3" minOccurs="0"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCHersteller" minOccurs="0"/>
 *         &lt;element name="Schrankreihe" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCSchrankreihe" minOccurs="0"/>
 *         &lt;element name="Steuerbezirksname" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCSteuerbezirksname" minOccurs="0"/>
 *         &lt;element name="Steuerbezirksnummer" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCSteuerbezirksnummer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Bezirk_Allg", propOrder = {
    "anbindungIB2",
    "anbindungIB3",
    "hersteller",
    "schrankreihe",
    "steuerbezirksname",
    "steuerbezirksnummer"
})
public class CBedienBezirkAllg {

    @XmlElement(name = "Anbindung_IB2")
    protected TCAnbindungIB2 anbindungIB2;
    @XmlElement(name = "Anbindung_IB3")
    protected TCAnbindungIB3 anbindungIB3;
    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;
    @XmlElement(name = "Schrankreihe")
    protected TCSchrankreihe schrankreihe;
    @XmlElement(name = "Steuerbezirksname")
    protected TCSteuerbezirksname steuerbezirksname;
    @XmlElement(name = "Steuerbezirksnummer")
    protected TCSteuerbezirksnummer steuerbezirksnummer;

    /**
     * Ruft den Wert der anbindungIB2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnbindungIB2 }
     *     
     */
    public TCAnbindungIB2 getAnbindungIB2() {
        return anbindungIB2;
    }

    /**
     * Legt den Wert der anbindungIB2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnbindungIB2 }
     *     
     */
    public void setAnbindungIB2(TCAnbindungIB2 value) {
        this.anbindungIB2 = value;
    }

    /**
     * Ruft den Wert der anbindungIB3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnbindungIB3 }
     *     
     */
    public TCAnbindungIB3 getAnbindungIB3() {
        return anbindungIB3;
    }

    /**
     * Legt den Wert der anbindungIB3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnbindungIB3 }
     *     
     */
    public void setAnbindungIB3(TCAnbindungIB3 value) {
        this.anbindungIB3 = value;
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

    /**
     * Ruft den Wert der schrankreihe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchrankreihe }
     *     
     */
    public TCSchrankreihe getSchrankreihe() {
        return schrankreihe;
    }

    /**
     * Legt den Wert der schrankreihe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchrankreihe }
     *     
     */
    public void setSchrankreihe(TCSchrankreihe value) {
        this.schrankreihe = value;
    }

    /**
     * Ruft den Wert der steuerbezirksname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSteuerbezirksname }
     *     
     */
    public TCSteuerbezirksname getSteuerbezirksname() {
        return steuerbezirksname;
    }

    /**
     * Legt den Wert der steuerbezirksname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSteuerbezirksname }
     *     
     */
    public void setSteuerbezirksname(TCSteuerbezirksname value) {
        this.steuerbezirksname = value;
    }

    /**
     * Ruft den Wert der steuerbezirksnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSteuerbezirksnummer }
     *     
     */
    public TCSteuerbezirksnummer getSteuerbezirksnummer() {
        return steuerbezirksnummer;
    }

    /**
     * Legt den Wert der steuerbezirksnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSteuerbezirksnummer }
     *     
     */
    public void setSteuerbezirksnummer(TCSteuerbezirksnummer value) {
        this.steuerbezirksnummer = value;
    }

}
