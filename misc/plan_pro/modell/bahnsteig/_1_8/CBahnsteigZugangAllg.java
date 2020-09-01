//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnsteig._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBahnsteig_Zugang_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Zugang_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bahnsteig_Zugang_Art" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}TCBahnsteig_Zugang_Art"/>
 *         &lt;element name="Bahnsteig_Zugang_Prioritaet" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}TCBahnsteig_Zugang_Prioritaet"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Zugang_Allg", propOrder = {
    "bahnsteigZugangArt",
    "bahnsteigZugangPrioritaet"
})
public class CBahnsteigZugangAllg {

    @XmlElement(name = "Bahnsteig_Zugang_Art", required = true)
    protected TCBahnsteigZugangArt bahnsteigZugangArt;
    @XmlElement(name = "Bahnsteig_Zugang_Prioritaet", required = true)
    protected TCBahnsteigZugangPrioritaet bahnsteigZugangPrioritaet;

    /**
     * Ruft den Wert der bahnsteigZugangArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBahnsteigZugangArt }
     *     
     */
    public TCBahnsteigZugangArt getBahnsteigZugangArt() {
        return bahnsteigZugangArt;
    }

    /**
     * Legt den Wert der bahnsteigZugangArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBahnsteigZugangArt }
     *     
     */
    public void setBahnsteigZugangArt(TCBahnsteigZugangArt value) {
        this.bahnsteigZugangArt = value;
    }

    /**
     * Ruft den Wert der bahnsteigZugangPrioritaet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBahnsteigZugangPrioritaet }
     *     
     */
    public TCBahnsteigZugangPrioritaet getBahnsteigZugangPrioritaet() {
        return bahnsteigZugangPrioritaet;
    }

    /**
     * Legt den Wert der bahnsteigZugangPrioritaet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBahnsteigZugangPrioritaet }
     *     
     */
    public void setBahnsteigZugangPrioritaet(TCBahnsteigZugangPrioritaet value) {
        this.bahnsteigZugangPrioritaet = value;
    }

}
