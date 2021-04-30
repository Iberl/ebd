//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CW_Kr_Anlage_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CW_Kr_Anlage_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Isolierfall" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCIsolierfall" minOccurs="0"/>
 *         &lt;element name="W_Kr_Art" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCW_Kr_Art"/>
 *         &lt;element name="W_Kr_Grundform" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCW_Kr_Grundform"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CW_Kr_Anlage_Allg", propOrder = {
    "isolierfall",
    "wKrArt",
    "wKrGrundform"
})
public class CWKrAnlageAllg {

    @XmlElement(name = "Isolierfall")
    protected TCIsolierfall isolierfall;
    @XmlElement(name = "W_Kr_Art", required = true)
    protected TCWKrArt wKrArt;
    @XmlElement(name = "W_Kr_Grundform", required = true)
    protected TCWKrGrundform wKrGrundform;

    /**
     * Ruft den Wert der isolierfall-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIsolierfall }
     *     
     */
    public TCIsolierfall getIsolierfall() {
        return isolierfall;
    }

    /**
     * Legt den Wert der isolierfall-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIsolierfall }
     *     
     */
    public void setIsolierfall(TCIsolierfall value) {
        this.isolierfall = value;
    }

    /**
     * Ruft den Wert der wKrArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWKrArt }
     *     
     */
    public TCWKrArt getWKrArt() {
        return wKrArt;
    }

    /**
     * Legt den Wert der wKrArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWKrArt }
     *     
     */
    public void setWKrArt(TCWKrArt value) {
        this.wKrArt = value;
    }

    /**
     * Ruft den Wert der wKrGrundform-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWKrGrundform }
     *     
     */
    public TCWKrGrundform getWKrGrundform() {
        return wKrGrundform;
    }

    /**
     * Legt den Wert der wKrGrundform-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWKrGrundform }
     *     
     */
    public void setWKrGrundform(TCWKrGrundform value) {
        this.wKrGrundform = value;
    }

}
