//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnsteig._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Bahnsteig_Zugang_Art" type="{http://www.plan-pro.org/modell/Bahnsteig/1.9.0.2}TCBahnsteig_Zugang_Art"/>
 *         &lt;element name="Hauptzugang" type="{http://www.plan-pro.org/modell/Bahnsteig/1.9.0.2}TCHauptzugang"/>
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
    "hauptzugang"
})
public class CBahnsteigZugangAllg {

    @XmlElement(name = "Bahnsteig_Zugang_Art", required = true)
    protected TCBahnsteigZugangArt bahnsteigZugangArt;
    @XmlElement(name = "Hauptzugang", required = true)
    protected TCHauptzugang hauptzugang;

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
     * Ruft den Wert der hauptzugang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHauptzugang }
     *     
     */
    public TCHauptzugang getHauptzugang() {
        return hauptzugang;
    }

    /**
     * Legt den Wert der hauptzugang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHauptzugang }
     *     
     */
    public void setHauptzugang(TCHauptzugang value) {
        this.hauptzugang = value;
    }

}
