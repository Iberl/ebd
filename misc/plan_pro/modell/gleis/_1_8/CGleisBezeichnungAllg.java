//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.gleis._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGleis_Bezeichnung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Bezeichnung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nutzung_Gueterzug" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCNutzung_Gueterzug" minOccurs="0"/>
 *         &lt;element name="Nutzung_Rangier" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCNutzung_Rangier" minOccurs="0"/>
 *         &lt;element name="Nutzung_Reisezug" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCNutzung_Reisezug" minOccurs="0"/>
 *         &lt;element name="Nutzung_SBahn" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCNutzung_SBahn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Bezeichnung_Allg", propOrder = {
    "nutzungGueterzug",
    "nutzungRangier",
    "nutzungReisezug",
    "nutzungSBahn"
})
public class CGleisBezeichnungAllg {

    @XmlElement(name = "Nutzung_Gueterzug")
    protected TCNutzungGueterzug nutzungGueterzug;
    @XmlElement(name = "Nutzung_Rangier")
    protected TCNutzungRangier nutzungRangier;
    @XmlElement(name = "Nutzung_Reisezug")
    protected TCNutzungReisezug nutzungReisezug;
    @XmlElement(name = "Nutzung_SBahn")
    protected TCNutzungSBahn nutzungSBahn;

    /**
     * Ruft den Wert der nutzungGueterzug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNutzungGueterzug }
     *     
     */
    public TCNutzungGueterzug getNutzungGueterzug() {
        return nutzungGueterzug;
    }

    /**
     * Legt den Wert der nutzungGueterzug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNutzungGueterzug }
     *     
     */
    public void setNutzungGueterzug(TCNutzungGueterzug value) {
        this.nutzungGueterzug = value;
    }

    /**
     * Ruft den Wert der nutzungRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNutzungRangier }
     *     
     */
    public TCNutzungRangier getNutzungRangier() {
        return nutzungRangier;
    }

    /**
     * Legt den Wert der nutzungRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNutzungRangier }
     *     
     */
    public void setNutzungRangier(TCNutzungRangier value) {
        this.nutzungRangier = value;
    }

    /**
     * Ruft den Wert der nutzungReisezug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNutzungReisezug }
     *     
     */
    public TCNutzungReisezug getNutzungReisezug() {
        return nutzungReisezug;
    }

    /**
     * Legt den Wert der nutzungReisezug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNutzungReisezug }
     *     
     */
    public void setNutzungReisezug(TCNutzungReisezug value) {
        this.nutzungReisezug = value;
    }

    /**
     * Ruft den Wert der nutzungSBahn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNutzungSBahn }
     *     
     */
    public TCNutzungSBahn getNutzungSBahn() {
        return nutzungSBahn;
    }

    /**
     * Legt den Wert der nutzungSBahn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNutzungSBahn }
     *     
     */
    public void setNutzungSBahn(TCNutzungSBahn value) {
        this.nutzungSBahn = value;
    }

}
