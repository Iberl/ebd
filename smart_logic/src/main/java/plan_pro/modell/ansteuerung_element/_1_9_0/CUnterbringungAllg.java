//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CUnterbringung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUnterbringung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCHersteller" minOccurs="0"/>
 *         &lt;element name="Unterbringung_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCUnterbringung_Art"/>
 *         &lt;element name="Unterbringung_Befestigung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCUnterbringung_Befestigung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUnterbringung_Allg", propOrder = {
    "hersteller",
    "unterbringungArt",
    "unterbringungBefestigung"
})
public class CUnterbringungAllg {

    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;
    @XmlElement(name = "Unterbringung_Art", required = true)
    protected TCUnterbringungArt unterbringungArt;
    @XmlElement(name = "Unterbringung_Befestigung", required = true)
    protected TCUnterbringungBefestigung unterbringungBefestigung;

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
     * Ruft den Wert der unterbringungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUnterbringungArt }
     *     
     */
    public TCUnterbringungArt getUnterbringungArt() {
        return unterbringungArt;
    }

    /**
     * Legt den Wert der unterbringungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUnterbringungArt }
     *     
     */
    public void setUnterbringungArt(TCUnterbringungArt value) {
        this.unterbringungArt = value;
    }

    /**
     * Ruft den Wert der unterbringungBefestigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUnterbringungBefestigung }
     *     
     */
    public TCUnterbringungBefestigung getUnterbringungBefestigung() {
        return unterbringungBefestigung;
    }

    /**
     * Legt den Wert der unterbringungBefestigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUnterbringungBefestigung }
     *     
     */
    public void setUnterbringungBefestigung(TCUnterbringungBefestigung value) {
        this.unterbringungBefestigung = value;
    }

}
