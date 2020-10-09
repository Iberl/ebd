//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_Rangier complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Rangier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Automatische_Einstellung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCAutomatische_Einstellung" minOccurs="0"/>
 *         &lt;element name="Rangier_Gegenfahrtausschluss" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCRangier_Gegenfahrtausschluss" minOccurs="0"/>
 *         &lt;element name="Rangier_Gleisfreimeldung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCRangier_Gleisfreimeldung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Rangier", propOrder = {
    "automatischeEinstellung",
    "rangierGegenfahrtausschluss",
    "rangierGleisfreimeldung"
})
public class CFstrRangier {

    @XmlElement(name = "Automatische_Einstellung")
    protected TCAutomatischeEinstellung automatischeEinstellung;
    @XmlElement(name = "Rangier_Gegenfahrtausschluss")
    protected TCRangierGegenfahrtausschluss rangierGegenfahrtausschluss;
    @XmlElement(name = "Rangier_Gleisfreimeldung", required = true)
    protected TCRangierGleisfreimeldung rangierGleisfreimeldung;

    /**
     * Ruft den Wert der automatischeEinstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutomatischeEinstellung }
     *     
     */
    public TCAutomatischeEinstellung getAutomatischeEinstellung() {
        return automatischeEinstellung;
    }

    /**
     * Legt den Wert der automatischeEinstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutomatischeEinstellung }
     *     
     */
    public void setAutomatischeEinstellung(TCAutomatischeEinstellung value) {
        this.automatischeEinstellung = value;
    }

    /**
     * Ruft den Wert der rangierGegenfahrtausschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRangierGegenfahrtausschluss }
     *     
     */
    public TCRangierGegenfahrtausschluss getRangierGegenfahrtausschluss() {
        return rangierGegenfahrtausschluss;
    }

    /**
     * Legt den Wert der rangierGegenfahrtausschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRangierGegenfahrtausschluss }
     *     
     */
    public void setRangierGegenfahrtausschluss(TCRangierGegenfahrtausschluss value) {
        this.rangierGegenfahrtausschluss = value;
    }

    /**
     * Ruft den Wert der rangierGleisfreimeldung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRangierGleisfreimeldung }
     *     
     */
    public TCRangierGleisfreimeldung getRangierGleisfreimeldung() {
        return rangierGleisfreimeldung;
    }

    /**
     * Legt den Wert der rangierGleisfreimeldung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRangierGleisfreimeldung }
     *     
     */
    public void setRangierGleisfreimeldung(TCRangierGleisfreimeldung value) {
        this.rangierGleisfreimeldung = value;
    }

}
