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
 * <p>Java-Klasse f�r CEntgleisungsschuh complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEntgleisungsschuh">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auswurfrichtung" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCAuswurfrichtung"/>
 *         &lt;element name="Gleissperrensignal" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCGleissperrensignal" minOccurs="0"/>
 *         &lt;element name="Schutzschiene" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCSchutzschiene"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEntgleisungsschuh", propOrder = {
    "auswurfrichtung",
    "gleissperrensignal",
    "schutzschiene"
})
public class CEntgleisungsschuh {

    @XmlElement(name = "Auswurfrichtung", required = true)
    protected TCAuswurfrichtung auswurfrichtung;
    @XmlElement(name = "Gleissperrensignal")
    protected TCGleissperrensignal gleissperrensignal;
    @XmlElement(name = "Schutzschiene", required = true)
    protected TCSchutzschiene schutzschiene;

    /**
     * Ruft den Wert der auswurfrichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAuswurfrichtung }
     *     
     */
    public TCAuswurfrichtung getAuswurfrichtung() {
        return auswurfrichtung;
    }

    /**
     * Legt den Wert der auswurfrichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAuswurfrichtung }
     *     
     */
    public void setAuswurfrichtung(TCAuswurfrichtung value) {
        this.auswurfrichtung = value;
    }

    /**
     * Ruft den Wert der gleissperrensignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGleissperrensignal }
     *     
     */
    public TCGleissperrensignal getGleissperrensignal() {
        return gleissperrensignal;
    }

    /**
     * Legt den Wert der gleissperrensignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGleissperrensignal }
     *     
     */
    public void setGleissperrensignal(TCGleissperrensignal value) {
        this.gleissperrensignal = value;
    }

    /**
     * Ruft den Wert der schutzschiene-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchutzschiene }
     *     
     */
    public TCSchutzschiene getSchutzschiene() {
        return schutzschiene;
    }

    /**
     * Legt den Wert der schutzschiene-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchutzschiene }
     *     
     */
    public void setSchutzschiene(TCSchutzschiene value) {
        this.schutzschiene = value;
    }

}
