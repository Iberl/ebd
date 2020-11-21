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
 * <p>Java-Klasse f�r CBedien_GBT_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_GBT_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rueckschauzeit" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCRueckschauzeit" minOccurs="0"/>
 *         &lt;element name="Vorschauzeit" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCVorschauzeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_GBT_Allg", propOrder = {
    "rueckschauzeit",
    "vorschauzeit"
})
public class CBedienGBTAllg {

    @XmlElement(name = "Rueckschauzeit")
    protected TCRueckschauzeit rueckschauzeit;
    @XmlElement(name = "Vorschauzeit")
    protected TCVorschauzeit vorschauzeit;

    /**
     * Ruft den Wert der rueckschauzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRueckschauzeit }
     *     
     */
    public TCRueckschauzeit getRueckschauzeit() {
        return rueckschauzeit;
    }

    /**
     * Legt den Wert der rueckschauzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRueckschauzeit }
     *     
     */
    public void setRueckschauzeit(TCRueckschauzeit value) {
        this.rueckschauzeit = value;
    }

    /**
     * Ruft den Wert der vorschauzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVorschauzeit }
     *     
     */
    public TCVorschauzeit getVorschauzeit() {
        return vorschauzeit;
    }

    /**
     * Legt den Wert der vorschauzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVorschauzeit }
     *     
     */
    public void setVorschauzeit(TCVorschauzeit value) {
        this.vorschauzeit = value;
    }

}
