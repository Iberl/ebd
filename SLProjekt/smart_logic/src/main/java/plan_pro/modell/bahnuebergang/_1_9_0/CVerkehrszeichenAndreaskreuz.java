//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CVerkehrszeichen_Andreaskreuz complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVerkehrszeichen_Andreaskreuz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Blitzpfeil" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBlitzpfeil" minOccurs="0"/>
 *         &lt;element name="Montage_Besonders" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCMontage_Besonders" minOccurs="0"/>
 *         &lt;element name="Richtungspfeil" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCRichtungspfeil" minOccurs="0"/>
 *         &lt;element name="Schutzbuegel" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSchutzbuegel" minOccurs="0"/>
 *         &lt;element name="Zusatzschild" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCZusatzschild" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVerkehrszeichen_Andreaskreuz", propOrder = {
    "blitzpfeil",
    "montageBesonders",
    "richtungspfeil",
    "schutzbuegel",
    "zusatzschild"
})
public class CVerkehrszeichenAndreaskreuz {

    @XmlElement(name = "Blitzpfeil")
    protected TCBlitzpfeil blitzpfeil;
    @XmlElement(name = "Montage_Besonders")
    protected TCMontageBesonders montageBesonders;
    @XmlElement(name = "Richtungspfeil")
    protected TCRichtungspfeil richtungspfeil;
    @XmlElement(name = "Schutzbuegel")
    protected TCSchutzbuegel schutzbuegel;
    @XmlElement(name = "Zusatzschild")
    protected TCZusatzschild zusatzschild;

    /**
     * Ruft den Wert der blitzpfeil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBlitzpfeil }
     *     
     */
    public TCBlitzpfeil getBlitzpfeil() {
        return blitzpfeil;
    }

    /**
     * Legt den Wert der blitzpfeil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBlitzpfeil }
     *     
     */
    public void setBlitzpfeil(TCBlitzpfeil value) {
        this.blitzpfeil = value;
    }

    /**
     * Ruft den Wert der montageBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMontageBesonders }
     *     
     */
    public TCMontageBesonders getMontageBesonders() {
        return montageBesonders;
    }

    /**
     * Legt den Wert der montageBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMontageBesonders }
     *     
     */
    public void setMontageBesonders(TCMontageBesonders value) {
        this.montageBesonders = value;
    }

    /**
     * Ruft den Wert der richtungspfeil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRichtungspfeil }
     *     
     */
    public TCRichtungspfeil getRichtungspfeil() {
        return richtungspfeil;
    }

    /**
     * Legt den Wert der richtungspfeil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRichtungspfeil }
     *     
     */
    public void setRichtungspfeil(TCRichtungspfeil value) {
        this.richtungspfeil = value;
    }

    /**
     * Ruft den Wert der schutzbuegel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchutzbuegel }
     *     
     */
    public TCSchutzbuegel getSchutzbuegel() {
        return schutzbuegel;
    }

    /**
     * Legt den Wert der schutzbuegel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchutzbuegel }
     *     
     */
    public void setSchutzbuegel(TCSchutzbuegel value) {
        this.schutzbuegel = value;
    }

    /**
     * Ruft den Wert der zusatzschild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZusatzschild }
     *     
     */
    public TCZusatzschild getZusatzschild() {
        return zusatzschild;
    }

    /**
     * Legt den Wert der zusatzschild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZusatzschild }
     *     
     */
    public void setZusatzschild(TCZusatzschild value) {
        this.zusatzschild = value;
    }

}
