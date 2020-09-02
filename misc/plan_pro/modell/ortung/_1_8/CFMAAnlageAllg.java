//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ortung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFMA_Anlage_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Anlage_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMA_Art" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Art"/>
 *         &lt;element name="FMA_Hilffreimeldung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Hilffreimeldung"/>
 *         &lt;element name="FMA_Typ" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Typ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Anlage_Allg", propOrder = {
    "fmaArt",
    "fmaHilffreimeldung",
    "fmaTyp"
})
public class CFMAAnlageAllg {

    @XmlElement(name = "FMA_Art", required = true)
    protected TCFMAArt fmaArt;
    @XmlElement(name = "FMA_Hilffreimeldung", required = true)
    protected TCFMAHilffreimeldung fmaHilffreimeldung;
    @XmlElement(name = "FMA_Typ")
    protected TCFMATyp fmaTyp;

    /**
     * Ruft den Wert der fmaArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAArt }
     *     
     */
    public TCFMAArt getFMAArt() {
        return fmaArt;
    }

    /**
     * Legt den Wert der fmaArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAArt }
     *     
     */
    public void setFMAArt(TCFMAArt value) {
        this.fmaArt = value;
    }

    /**
     * Ruft den Wert der fmaHilffreimeldung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAHilffreimeldung }
     *     
     */
    public TCFMAHilffreimeldung getFMAHilffreimeldung() {
        return fmaHilffreimeldung;
    }

    /**
     * Legt den Wert der fmaHilffreimeldung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAHilffreimeldung }
     *     
     */
    public void setFMAHilffreimeldung(TCFMAHilffreimeldung value) {
        this.fmaHilffreimeldung = value;
    }

    /**
     * Ruft den Wert der fmaTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMATyp }
     *     
     */
    public TCFMATyp getFMATyp() {
        return fmaTyp;
    }

    /**
     * Legt den Wert der fmaTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMATyp }
     *     
     */
    public void setFMATyp(TCFMATyp value) {
        this.fmaTyp = value;
    }

}
