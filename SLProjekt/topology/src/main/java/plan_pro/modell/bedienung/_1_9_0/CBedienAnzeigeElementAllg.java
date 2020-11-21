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
 * <p>Java-Klasse f�r CBedien_Anzeige_Element_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Anzeige_Element_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Melder" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCMelder" minOccurs="0"/>
 *           &lt;element name="Schalter" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCSchalter" minOccurs="0"/>
 *           &lt;element name="Taste" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCTaste" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Anzeige_Element_Allg", propOrder = {
    "melder",
    "schalter",
    "taste"
})
public class CBedienAnzeigeElementAllg {

    @XmlElement(name = "Melder")
    protected TCMelder melder;
    @XmlElement(name = "Schalter")
    protected TCSchalter schalter;
    @XmlElement(name = "Taste")
    protected TCTaste taste;

    /**
     * Ruft den Wert der melder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMelder }
     *     
     */
    public TCMelder getMelder() {
        return melder;
    }

    /**
     * Legt den Wert der melder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMelder }
     *     
     */
    public void setMelder(TCMelder value) {
        this.melder = value;
    }

    /**
     * Ruft den Wert der schalter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchalter }
     *     
     */
    public TCSchalter getSchalter() {
        return schalter;
    }

    /**
     * Legt den Wert der schalter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchalter }
     *     
     */
    public void setSchalter(TCSchalter value) {
        this.schalter = value;
    }

    /**
     * Ruft den Wert der taste-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTaste }
     *     
     */
    public TCTaste getTaste() {
        return taste;
    }

    /**
     * Legt den Wert der taste-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTaste }
     *     
     */
    public void setTaste(TCTaste value) {
        this.taste = value;
    }

}
