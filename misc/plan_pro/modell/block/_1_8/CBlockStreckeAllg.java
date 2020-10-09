//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.block._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBlock_Strecke_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Strecke_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Betriebsfuehrung" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCBetriebsfuehrung"/>
 *         &lt;element name="Bremsweg" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCBremsweg"/>
 *         &lt;element name="Entwurfsgeschwindigkeit" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCEntwurfsgeschwindigkeit"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Strecke_Allg", propOrder = {
    "betriebsfuehrung",
    "bremsweg",
    "entwurfsgeschwindigkeit"
})
public class CBlockStreckeAllg {

    @XmlElement(name = "Betriebsfuehrung", required = true)
    protected TCBetriebsfuehrung betriebsfuehrung;
    @XmlElement(name = "Bremsweg", required = true)
    protected TCBremsweg bremsweg;
    @XmlElement(name = "Entwurfsgeschwindigkeit", required = true)
    protected TCEntwurfsgeschwindigkeit entwurfsgeschwindigkeit;

    /**
     * Ruft den Wert der betriebsfuehrung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBetriebsfuehrung }
     *     
     */
    public TCBetriebsfuehrung getBetriebsfuehrung() {
        return betriebsfuehrung;
    }

    /**
     * Legt den Wert der betriebsfuehrung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBetriebsfuehrung }
     *     
     */
    public void setBetriebsfuehrung(TCBetriebsfuehrung value) {
        this.betriebsfuehrung = value;
    }

    /**
     * Ruft den Wert der bremsweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBremsweg }
     *     
     */
    public TCBremsweg getBremsweg() {
        return bremsweg;
    }

    /**
     * Legt den Wert der bremsweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBremsweg }
     *     
     */
    public void setBremsweg(TCBremsweg value) {
        this.bremsweg = value;
    }

    /**
     * Ruft den Wert der entwurfsgeschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEntwurfsgeschwindigkeit }
     *     
     */
    public TCEntwurfsgeschwindigkeit getEntwurfsgeschwindigkeit() {
        return entwurfsgeschwindigkeit;
    }

    /**
     * Legt den Wert der entwurfsgeschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEntwurfsgeschwindigkeit }
     *     
     */
    public void setEntwurfsgeschwindigkeit(TCEntwurfsgeschwindigkeit value) {
        this.entwurfsgeschwindigkeit = value;
    }

}
