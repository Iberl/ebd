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
 * <p>Java-Klasse f�r CGFR_Anlage_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGFR_Anlage_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BUE_Sicherungszeit" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Sicherungszeit"/>
 *         &lt;element name="GFR_Art" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCGFR_Art"/>
 *         &lt;element name="GFR_Typ" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCGFR_Typ" minOccurs="0"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCHersteller" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGFR_Anlage_Allg", propOrder = {
    "bueSicherungszeit",
    "gfrArt",
    "gfrTyp",
    "hersteller"
})
public class CGFRAnlageAllg {

    @XmlElement(name = "BUE_Sicherungszeit", required = true)
    protected TCBUESicherungszeit bueSicherungszeit;
    @XmlElement(name = "GFR_Art", required = true)
    protected TCGFRArt gfrArt;
    @XmlElement(name = "GFR_Typ")
    protected TCGFRTyp gfrTyp;
    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;

    /**
     * Ruft den Wert der bueSicherungszeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUESicherungszeit }
     *     
     */
    public TCBUESicherungszeit getBUESicherungszeit() {
        return bueSicherungszeit;
    }

    /**
     * Legt den Wert der bueSicherungszeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUESicherungszeit }
     *     
     */
    public void setBUESicherungszeit(TCBUESicherungszeit value) {
        this.bueSicherungszeit = value;
    }

    /**
     * Ruft den Wert der gfrArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGFRArt }
     *     
     */
    public TCGFRArt getGFRArt() {
        return gfrArt;
    }

    /**
     * Legt den Wert der gfrArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGFRArt }
     *     
     */
    public void setGFRArt(TCGFRArt value) {
        this.gfrArt = value;
    }

    /**
     * Ruft den Wert der gfrTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGFRTyp }
     *     
     */
    public TCGFRTyp getGFRTyp() {
        return gfrTyp;
    }

    /**
     * Legt den Wert der gfrTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGFRTyp }
     *     
     */
    public void setGFRTyp(TCGFRTyp value) {
        this.gfrTyp = value;
    }

    /**
     * Ruft den Wert der hersteller-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHersteller }
     *     
     */
    public TCHersteller getHersteller() {
        return hersteller;
    }

    /**
     * Legt den Wert der hersteller-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHersteller }
     *     
     */
    public void setHersteller(TCHersteller value) {
        this.hersteller = value;
    }

}
