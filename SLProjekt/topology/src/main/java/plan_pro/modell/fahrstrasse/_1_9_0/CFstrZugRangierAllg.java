//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_Zug_Rangier_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Zug_Rangier_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_Bedienung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCF_Bedienung" minOccurs="0"/>
 *         &lt;element name="Fstr_Art" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_Art"/>
 *         &lt;element name="Fstr_Bedienstring" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_Bedienstring" minOccurs="0"/>
 *         &lt;element name="Fstr_Bildezeit" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_Bildezeit" minOccurs="0"/>
 *         &lt;element name="Fstr_Reihenfolge" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_Reihenfolge"/>
 *         &lt;element name="Fstr_V" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_V" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Zug_Rangier_Allg", propOrder = {
    "fBedienung",
    "fstrArt",
    "fstrBedienstring",
    "fstrBildezeit",
    "fstrReihenfolge",
    "fstrV"
})
public class CFstrZugRangierAllg {

    @XmlElement(name = "F_Bedienung")
    protected TCFBedienung fBedienung;
    @XmlElement(name = "Fstr_Art", required = true)
    protected TCFstrArt fstrArt;
    @XmlElement(name = "Fstr_Bedienstring")
    protected TCFstrBedienstring fstrBedienstring;
    @XmlElement(name = "Fstr_Bildezeit")
    protected TCFstrBildezeit fstrBildezeit;
    @XmlElement(name = "Fstr_Reihenfolge", required = true)
    protected TCFstrReihenfolge fstrReihenfolge;
    @XmlElement(name = "Fstr_V")
    protected TCFstrV fstrV;

    /**
     * Ruft den Wert der fBedienung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFBedienung }
     *     
     */
    public TCFBedienung getFBedienung() {
        return fBedienung;
    }

    /**
     * Legt den Wert der fBedienung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFBedienung }
     *     
     */
    public void setFBedienung(TCFBedienung value) {
        this.fBedienung = value;
    }

    /**
     * Ruft den Wert der fstrArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrArt }
     *     
     */
    public TCFstrArt getFstrArt() {
        return fstrArt;
    }

    /**
     * Legt den Wert der fstrArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrArt }
     *     
     */
    public void setFstrArt(TCFstrArt value) {
        this.fstrArt = value;
    }

    /**
     * Ruft den Wert der fstrBedienstring-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrBedienstring }
     *     
     */
    public TCFstrBedienstring getFstrBedienstring() {
        return fstrBedienstring;
    }

    /**
     * Legt den Wert der fstrBedienstring-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrBedienstring }
     *     
     */
    public void setFstrBedienstring(TCFstrBedienstring value) {
        this.fstrBedienstring = value;
    }

    /**
     * Ruft den Wert der fstrBildezeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrBildezeit }
     *     
     */
    public TCFstrBildezeit getFstrBildezeit() {
        return fstrBildezeit;
    }

    /**
     * Legt den Wert der fstrBildezeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrBildezeit }
     *     
     */
    public void setFstrBildezeit(TCFstrBildezeit value) {
        this.fstrBildezeit = value;
    }

    /**
     * Ruft den Wert der fstrReihenfolge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrReihenfolge }
     *     
     */
    public TCFstrReihenfolge getFstrReihenfolge() {
        return fstrReihenfolge;
    }

    /**
     * Legt den Wert der fstrReihenfolge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrReihenfolge }
     *     
     */
    public void setFstrReihenfolge(TCFstrReihenfolge value) {
        this.fstrReihenfolge = value;
    }

    /**
     * Ruft den Wert der fstrV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrV }
     *     
     */
    public TCFstrV getFstrV() {
        return fstrV;
    }

    /**
     * Legt den Wert der fstrV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrV }
     *     
     */
    public void setFstrV(TCFstrV value) {
        this.fstrV = value;
    }

}
