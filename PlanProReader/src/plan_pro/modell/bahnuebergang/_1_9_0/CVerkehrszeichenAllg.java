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
 * <p>Java-Klasse f�r CVerkehrszeichen_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVerkehrszeichen_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Abstand_Gehweg_Fahrbahn" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAbstand_Gehweg_Fahrbahn"/>
 *         &lt;element name="Ausrichtung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAusrichtung"/>
 *         &lt;element name="Ausrichtung_Winkel" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAusrichtung_Winkel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVerkehrszeichen_Allg", propOrder = {
    "abstandGehwegFahrbahn",
    "ausrichtung",
    "ausrichtungWinkel"
})
public class CVerkehrszeichenAllg {

    @XmlElement(name = "Abstand_Gehweg_Fahrbahn", required = true)
    protected TCAbstandGehwegFahrbahn abstandGehwegFahrbahn;
    @XmlElement(name = "Ausrichtung", required = true)
    protected TCAusrichtung ausrichtung;
    @XmlElement(name = "Ausrichtung_Winkel", required = true)
    protected TCAusrichtungWinkel ausrichtungWinkel;

    /**
     * Ruft den Wert der abstandGehwegFahrbahn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAbstandGehwegFahrbahn }
     *     
     */
    public TCAbstandGehwegFahrbahn getAbstandGehwegFahrbahn() {
        return abstandGehwegFahrbahn;
    }

    /**
     * Legt den Wert der abstandGehwegFahrbahn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAbstandGehwegFahrbahn }
     *     
     */
    public void setAbstandGehwegFahrbahn(TCAbstandGehwegFahrbahn value) {
        this.abstandGehwegFahrbahn = value;
    }

    /**
     * Ruft den Wert der ausrichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusrichtung }
     *     
     */
    public TCAusrichtung getAusrichtung() {
        return ausrichtung;
    }

    /**
     * Legt den Wert der ausrichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusrichtung }
     *     
     */
    public void setAusrichtung(TCAusrichtung value) {
        this.ausrichtung = value;
    }

    /**
     * Ruft den Wert der ausrichtungWinkel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusrichtungWinkel }
     *     
     */
    public TCAusrichtungWinkel getAusrichtungWinkel() {
        return ausrichtungWinkel;
    }

    /**
     * Legt den Wert der ausrichtungWinkel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusrichtungWinkel }
     *     
     */
    public void setAusrichtungWinkel(TCAusrichtungWinkel value) {
        this.ausrichtungWinkel = value;
    }

}
