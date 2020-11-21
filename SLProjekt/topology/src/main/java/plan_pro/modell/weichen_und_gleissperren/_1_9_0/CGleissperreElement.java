//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGleissperre_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleissperre_Element">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gleissperre_Betriebsart" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCGleissperre_Betriebsart" minOccurs="0"/>
 *         &lt;element name="Gleissperre_Vorzugslage" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCGleissperre_Vorzugslage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleissperre_Element", propOrder = {
    "gleissperreBetriebsart",
    "gleissperreVorzugslage"
})
public class CGleissperreElement {

    @XmlElement(name = "Gleissperre_Betriebsart")
    protected TCGleissperreBetriebsart gleissperreBetriebsart;
    @XmlElement(name = "Gleissperre_Vorzugslage", required = true)
    protected TCGleissperreVorzugslage gleissperreVorzugslage;

    /**
     * Ruft den Wert der gleissperreBetriebsart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGleissperreBetriebsart }
     *     
     */
    public TCGleissperreBetriebsart getGleissperreBetriebsart() {
        return gleissperreBetriebsart;
    }

    /**
     * Legt den Wert der gleissperreBetriebsart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGleissperreBetriebsart }
     *     
     */
    public void setGleissperreBetriebsart(TCGleissperreBetriebsart value) {
        this.gleissperreBetriebsart = value;
    }

    /**
     * Ruft den Wert der gleissperreVorzugslage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGleissperreVorzugslage }
     *     
     */
    public TCGleissperreVorzugslage getGleissperreVorzugslage() {
        return gleissperreVorzugslage;
    }

    /**
     * Legt den Wert der gleissperreVorzugslage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGleissperreVorzugslage }
     *     
     */
    public void setGleissperreVorzugslage(TCGleissperreVorzugslage value) {
        this.gleissperreVorzugslage = value;
    }

}
