//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CKreuzung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CKreuzung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Elektrischer_Antrieb_Anzahl" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCElektrischer_Antrieb_Anzahl"/>
 *         &lt;element name="Geschwindigkeit_L" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCGeschwindigkeit_L"/>
 *         &lt;element name="Geschwindigkeit_R" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCGeschwindigkeit_R"/>
 *         &lt;element name="Radius_L" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCRadius_L"/>
 *         &lt;element name="Radius_R" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCRadius_R"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CKreuzung", propOrder = {
    "elektrischerAntriebAnzahl",
    "geschwindigkeitL",
    "geschwindigkeitR",
    "radiusL",
    "radiusR"
})
public class CKreuzung {

    @XmlElement(name = "Elektrischer_Antrieb_Anzahl", required = true)
    protected TCElektrischerAntriebAnzahl elektrischerAntriebAnzahl;
    @XmlElement(name = "Geschwindigkeit_L", required = true)
    protected TCGeschwindigkeitL geschwindigkeitL;
    @XmlElement(name = "Geschwindigkeit_R", required = true)
    protected TCGeschwindigkeitR geschwindigkeitR;
    @XmlElement(name = "Radius_L", required = true)
    protected TCRadiusL radiusL;
    @XmlElement(name = "Radius_R", required = true)
    protected TCRadiusR radiusR;

    /**
     * Ruft den Wert der elektrischerAntriebAnzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElektrischerAntriebAnzahl }
     *     
     */
    public TCElektrischerAntriebAnzahl getElektrischerAntriebAnzahl() {
        return elektrischerAntriebAnzahl;
    }

    /**
     * Legt den Wert der elektrischerAntriebAnzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElektrischerAntriebAnzahl }
     *     
     */
    public void setElektrischerAntriebAnzahl(TCElektrischerAntriebAnzahl value) {
        this.elektrischerAntriebAnzahl = value;
    }

    /**
     * Ruft den Wert der geschwindigkeitL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschwindigkeitL }
     *     
     */
    public TCGeschwindigkeitL getGeschwindigkeitL() {
        return geschwindigkeitL;
    }

    /**
     * Legt den Wert der geschwindigkeitL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschwindigkeitL }
     *     
     */
    public void setGeschwindigkeitL(TCGeschwindigkeitL value) {
        this.geschwindigkeitL = value;
    }

    /**
     * Ruft den Wert der geschwindigkeitR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschwindigkeitR }
     *     
     */
    public TCGeschwindigkeitR getGeschwindigkeitR() {
        return geschwindigkeitR;
    }

    /**
     * Legt den Wert der geschwindigkeitR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschwindigkeitR }
     *     
     */
    public void setGeschwindigkeitR(TCGeschwindigkeitR value) {
        this.geschwindigkeitR = value;
    }

    /**
     * Ruft den Wert der radiusL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRadiusL }
     *     
     */
    public TCRadiusL getRadiusL() {
        return radiusL;
    }

    /**
     * Legt den Wert der radiusL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRadiusL }
     *     
     */
    public void setRadiusL(TCRadiusL value) {
        this.radiusL = value;
    }

    /**
     * Ruft den Wert der radiusR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRadiusR }
     *     
     */
    public TCRadiusR getRadiusR() {
        return radiusR;
    }

    /**
     * Legt den Wert der radiusR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRadiusR }
     *     
     */
    public void setRadiusR(TCRadiusR value) {
        this.radiusR = value;
    }

}
