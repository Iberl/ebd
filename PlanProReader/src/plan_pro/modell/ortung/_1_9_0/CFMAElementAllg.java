//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFMA_Element_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Element_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMA_Element_Art" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Element_Art"/>
 *         &lt;element name="FMA_Element_Seilanzahl" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Element_Seilanzahl"/>
 *         &lt;element name="FMA_Element_Seiltyp" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Element_Seiltyp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Element_Allg", propOrder = {
    "fmaElementArt",
    "fmaElementSeilanzahl",
    "fmaElementSeiltyp"
})
public class CFMAElementAllg {

    @XmlElement(name = "FMA_Element_Art", required = true)
    protected TCFMAElementArt fmaElementArt;
    @XmlElement(name = "FMA_Element_Seilanzahl", required = true)
    protected TCFMAElementSeilanzahl fmaElementSeilanzahl;
    @XmlElement(name = "FMA_Element_Seiltyp", required = true)
    protected TCFMAElementSeiltyp fmaElementSeiltyp;

    /**
     * Ruft den Wert der fmaElementArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAElementArt }
     *     
     */
    public TCFMAElementArt getFMAElementArt() {
        return fmaElementArt;
    }

    /**
     * Legt den Wert der fmaElementArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAElementArt }
     *     
     */
    public void setFMAElementArt(TCFMAElementArt value) {
        this.fmaElementArt = value;
    }

    /**
     * Ruft den Wert der fmaElementSeilanzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAElementSeilanzahl }
     *     
     */
    public TCFMAElementSeilanzahl getFMAElementSeilanzahl() {
        return fmaElementSeilanzahl;
    }

    /**
     * Legt den Wert der fmaElementSeilanzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAElementSeilanzahl }
     *     
     */
    public void setFMAElementSeilanzahl(TCFMAElementSeilanzahl value) {
        this.fmaElementSeilanzahl = value;
    }

    /**
     * Ruft den Wert der fmaElementSeiltyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAElementSeiltyp }
     *     
     */
    public TCFMAElementSeiltyp getFMAElementSeiltyp() {
        return fmaElementSeiltyp;
    }

    /**
     * Legt den Wert der fmaElementSeiltyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAElementSeiltyp }
     *     
     */
    public void setFMAElementSeiltyp(TCFMAElementSeiltyp value) {
        this.fmaElementSeiltyp = value;
    }

}
