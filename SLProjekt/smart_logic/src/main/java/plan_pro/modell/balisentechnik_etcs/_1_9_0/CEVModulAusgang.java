//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CEV_Modul_Ausgang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEV_Modul_Ausgang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ausgang_Nr" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAusgang_Nr"/>
 *         &lt;element name="Max_Unterbrechungszeit" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCMax_Unterbrechungszeit" minOccurs="0"/>
 *         &lt;element name="Nennleistung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCNennleistung"/>
 *         &lt;element name="Spannung_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSpannung_Art"/>
 *         &lt;element name="Spannung_Toleranz_Obere" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSpannung_Toleranz_Obere" minOccurs="0"/>
 *         &lt;element name="Spannung_Toleranz_Untere" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSpannung_Toleranz_Untere" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEV_Modul_Ausgang", propOrder = {
    "ausgangNr",
    "maxUnterbrechungszeit",
    "nennleistung",
    "spannungArt",
    "spannungToleranzObere",
    "spannungToleranzUntere"
})
public class CEVModulAusgang {

    @XmlElement(name = "Ausgang_Nr", required = true)
    protected TCAusgangNr ausgangNr;
    @XmlElement(name = "Max_Unterbrechungszeit")
    protected TCMaxUnterbrechungszeit maxUnterbrechungszeit;
    @XmlElement(name = "Nennleistung", required = true)
    protected TCNennleistung nennleistung;
    @XmlElement(name = "Spannung_Art", required = true)
    protected TCSpannungArt spannungArt;
    @XmlElement(name = "Spannung_Toleranz_Obere")
    protected TCSpannungToleranzObere spannungToleranzObere;
    @XmlElement(name = "Spannung_Toleranz_Untere")
    protected TCSpannungToleranzUntere spannungToleranzUntere;

    /**
     * Ruft den Wert der ausgangNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusgangNr }
     *     
     */
    public TCAusgangNr getAusgangNr() {
        return ausgangNr;
    }

    /**
     * Legt den Wert der ausgangNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusgangNr }
     *     
     */
    public void setAusgangNr(TCAusgangNr value) {
        this.ausgangNr = value;
    }

    /**
     * Ruft den Wert der maxUnterbrechungszeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMaxUnterbrechungszeit }
     *     
     */
    public TCMaxUnterbrechungszeit getMaxUnterbrechungszeit() {
        return maxUnterbrechungszeit;
    }

    /**
     * Legt den Wert der maxUnterbrechungszeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMaxUnterbrechungszeit }
     *     
     */
    public void setMaxUnterbrechungszeit(TCMaxUnterbrechungszeit value) {
        this.maxUnterbrechungszeit = value;
    }

    /**
     * Ruft den Wert der nennleistung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNennleistung }
     *     
     */
    public TCNennleistung getNennleistung() {
        return nennleistung;
    }

    /**
     * Legt den Wert der nennleistung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNennleistung }
     *     
     */
    public void setNennleistung(TCNennleistung value) {
        this.nennleistung = value;
    }

    /**
     * Ruft den Wert der spannungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSpannungArt }
     *     
     */
    public TCSpannungArt getSpannungArt() {
        return spannungArt;
    }

    /**
     * Legt den Wert der spannungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSpannungArt }
     *     
     */
    public void setSpannungArt(TCSpannungArt value) {
        this.spannungArt = value;
    }

    /**
     * Ruft den Wert der spannungToleranzObere-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSpannungToleranzObere }
     *     
     */
    public TCSpannungToleranzObere getSpannungToleranzObere() {
        return spannungToleranzObere;
    }

    /**
     * Legt den Wert der spannungToleranzObere-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSpannungToleranzObere }
     *     
     */
    public void setSpannungToleranzObere(TCSpannungToleranzObere value) {
        this.spannungToleranzObere = value;
    }

    /**
     * Ruft den Wert der spannungToleranzUntere-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSpannungToleranzUntere }
     *     
     */
    public TCSpannungToleranzUntere getSpannungToleranzUntere() {
        return spannungToleranzUntere;
    }

    /**
     * Legt den Wert der spannungToleranzUntere-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSpannungToleranzUntere }
     *     
     */
    public void setSpannungToleranzUntere(TCSpannungToleranzUntere value) {
        this.spannungToleranzUntere = value;
    }

}
