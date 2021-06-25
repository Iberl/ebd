//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSA_Schrankenbaum complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSA_Schrankenbaum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ausrichtung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAusrichtung"/>
 *         &lt;element name="Ausrichtung_Winkel" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAusrichtung_Winkel"/>
 *         &lt;element name="Baumprofil" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBaumprofil"/>
 *         &lt;element name="Gitterbehang" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCGitterbehang" minOccurs="0"/>
 *         &lt;element name="Lagerung_Art" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCLagerung_Art" minOccurs="0"/>
 *         &lt;element name="Lieferlaenge" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCLieferlaenge"/>
 *         &lt;element name="Montage_Ausgleichsgewichte" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCMontage_Ausgleichsgewichte" minOccurs="0"/>
 *         &lt;element name="Sperrlaenge" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSperrlaenge"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSA_Schrankenbaum", propOrder = {
    "ausrichtung",
    "ausrichtungWinkel",
    "baumprofil",
    "gitterbehang",
    "lagerungArt",
    "lieferlaenge",
    "montageAusgleichsgewichte",
    "sperrlaenge"
})
public class CSASchrankenbaum {

    @XmlElement(name = "Ausrichtung", required = true)
    protected TCAusrichtung ausrichtung;
    @XmlElement(name = "Ausrichtung_Winkel", required = true)
    protected TCAusrichtungWinkel ausrichtungWinkel;
    @XmlElement(name = "Baumprofil", required = true)
    protected TCBaumprofil baumprofil;
    @XmlElement(name = "Gitterbehang")
    protected TCGitterbehang gitterbehang;
    @XmlElement(name = "Lagerung_Art")
    protected TCLagerungArt lagerungArt;
    @XmlElement(name = "Lieferlaenge", required = true)
    protected TCLieferlaenge lieferlaenge;
    @XmlElement(name = "Montage_Ausgleichsgewichte")
    protected TCMontageAusgleichsgewichte montageAusgleichsgewichte;
    @XmlElement(name = "Sperrlaenge", required = true)
    protected TCSperrlaenge sperrlaenge;

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

    /**
     * Ruft den Wert der baumprofil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBaumprofil }
     *     
     */
    public TCBaumprofil getBaumprofil() {
        return baumprofil;
    }

    /**
     * Legt den Wert der baumprofil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBaumprofil }
     *     
     */
    public void setBaumprofil(TCBaumprofil value) {
        this.baumprofil = value;
    }

    /**
     * Ruft den Wert der gitterbehang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGitterbehang }
     *     
     */
    public TCGitterbehang getGitterbehang() {
        return gitterbehang;
    }

    /**
     * Legt den Wert der gitterbehang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGitterbehang }
     *     
     */
    public void setGitterbehang(TCGitterbehang value) {
        this.gitterbehang = value;
    }

    /**
     * Ruft den Wert der lagerungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLagerungArt }
     *     
     */
    public TCLagerungArt getLagerungArt() {
        return lagerungArt;
    }

    /**
     * Legt den Wert der lagerungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLagerungArt }
     *     
     */
    public void setLagerungArt(TCLagerungArt value) {
        this.lagerungArt = value;
    }

    /**
     * Ruft den Wert der lieferlaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLieferlaenge }
     *     
     */
    public TCLieferlaenge getLieferlaenge() {
        return lieferlaenge;
    }

    /**
     * Legt den Wert der lieferlaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLieferlaenge }
     *     
     */
    public void setLieferlaenge(TCLieferlaenge value) {
        this.lieferlaenge = value;
    }

    /**
     * Ruft den Wert der montageAusgleichsgewichte-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMontageAusgleichsgewichte }
     *     
     */
    public TCMontageAusgleichsgewichte getMontageAusgleichsgewichte() {
        return montageAusgleichsgewichte;
    }

    /**
     * Legt den Wert der montageAusgleichsgewichte-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMontageAusgleichsgewichte }
     *     
     */
    public void setMontageAusgleichsgewichte(TCMontageAusgleichsgewichte value) {
        this.montageAusgleichsgewichte = value;
    }

    /**
     * Ruft den Wert der sperrlaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSperrlaenge }
     *     
     */
    public TCSperrlaenge getSperrlaenge() {
        return sperrlaenge;
    }

    /**
     * Legt den Wert der sperrlaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSperrlaenge }
     *     
     */
    public void setSperrlaenge(TCSperrlaenge value) {
        this.sperrlaenge = value;
    }

}
