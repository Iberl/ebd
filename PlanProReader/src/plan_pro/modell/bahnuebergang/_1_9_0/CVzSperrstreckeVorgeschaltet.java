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
 * <p>Java-Klasse f�r CVz_Sperrstrecke_Vorgeschaltet complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVz_Sperrstrecke_Vorgeschaltet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Beeinflussung_Strassenverkehr" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBeeinflussung_Strassenverkehr" minOccurs="0"/>
 *         &lt;element name="Raeumstrecke_DAB" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCRaeumstrecke_DAB"/>
 *         &lt;element name="Raeumstrecke_DBK" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCRaeumstrecke_DBK" minOccurs="0"/>
 *         &lt;element name="Raeumstrecke_DCK" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCRaeumstrecke_DCK" minOccurs="0"/>
 *         &lt;element name="Raeumstrecke_DSK_Strich" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCRaeumstrecke_DSK_Strich" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVz_Sperrstrecke_Vorgeschaltet", propOrder = {
    "beeinflussungStrassenverkehr",
    "raeumstreckeDAB",
    "raeumstreckeDBK",
    "raeumstreckeDCK",
    "raeumstreckeDSKStrich"
})
public class CVzSperrstreckeVorgeschaltet {

    @XmlElement(name = "Beeinflussung_Strassenverkehr")
    protected TCBeeinflussungStrassenverkehr beeinflussungStrassenverkehr;
    @XmlElement(name = "Raeumstrecke_DAB", required = true)
    protected TCRaeumstreckeDAB raeumstreckeDAB;
    @XmlElement(name = "Raeumstrecke_DBK")
    protected TCRaeumstreckeDBK raeumstreckeDBK;
    @XmlElement(name = "Raeumstrecke_DCK")
    protected TCRaeumstreckeDCK raeumstreckeDCK;
    @XmlElement(name = "Raeumstrecke_DSK_Strich")
    protected TCRaeumstreckeDSKStrich raeumstreckeDSKStrich;

    /**
     * Ruft den Wert der beeinflussungStrassenverkehr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBeeinflussungStrassenverkehr }
     *     
     */
    public TCBeeinflussungStrassenverkehr getBeeinflussungStrassenverkehr() {
        return beeinflussungStrassenverkehr;
    }

    /**
     * Legt den Wert der beeinflussungStrassenverkehr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBeeinflussungStrassenverkehr }
     *     
     */
    public void setBeeinflussungStrassenverkehr(TCBeeinflussungStrassenverkehr value) {
        this.beeinflussungStrassenverkehr = value;
    }

    /**
     * Ruft den Wert der raeumstreckeDAB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRaeumstreckeDAB }
     *     
     */
    public TCRaeumstreckeDAB getRaeumstreckeDAB() {
        return raeumstreckeDAB;
    }

    /**
     * Legt den Wert der raeumstreckeDAB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRaeumstreckeDAB }
     *     
     */
    public void setRaeumstreckeDAB(TCRaeumstreckeDAB value) {
        this.raeumstreckeDAB = value;
    }

    /**
     * Ruft den Wert der raeumstreckeDBK-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRaeumstreckeDBK }
     *     
     */
    public TCRaeumstreckeDBK getRaeumstreckeDBK() {
        return raeumstreckeDBK;
    }

    /**
     * Legt den Wert der raeumstreckeDBK-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRaeumstreckeDBK }
     *     
     */
    public void setRaeumstreckeDBK(TCRaeumstreckeDBK value) {
        this.raeumstreckeDBK = value;
    }

    /**
     * Ruft den Wert der raeumstreckeDCK-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRaeumstreckeDCK }
     *     
     */
    public TCRaeumstreckeDCK getRaeumstreckeDCK() {
        return raeumstreckeDCK;
    }

    /**
     * Legt den Wert der raeumstreckeDCK-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRaeumstreckeDCK }
     *     
     */
    public void setRaeumstreckeDCK(TCRaeumstreckeDCK value) {
        this.raeumstreckeDCK = value;
    }

    /**
     * Ruft den Wert der raeumstreckeDSKStrich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRaeumstreckeDSKStrich }
     *     
     */
    public TCRaeumstreckeDSKStrich getRaeumstreckeDSKStrich() {
        return raeumstreckeDSKStrich;
    }

    /**
     * Legt den Wert der raeumstreckeDSKStrich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRaeumstreckeDSKStrich }
     *     
     */
    public void setRaeumstreckeDSKStrich(TCRaeumstreckeDSKStrich value) {
        this.raeumstreckeDSKStrich = value;
    }

}
