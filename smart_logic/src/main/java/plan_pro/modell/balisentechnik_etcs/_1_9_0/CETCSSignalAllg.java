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
 * <p>Java-Klasse f�r CETCS_Signal_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Signal_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ausstieg_ETCS_Sperre" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAusstieg_ETCS_Sperre"/>
 *         &lt;element name="Dunkelschaltanstoss" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDunkelschaltanstoss"/>
 *         &lt;element name="Einstieg_Erlaubt" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEinstieg_Erlaubt"/>
 *         &lt;element name="Gruppen_ID" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCGruppen_ID" minOccurs="0"/>
 *         &lt;element name="Untergruppen_ID" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCUntergruppen_ID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Signal_Allg", propOrder = {
    "ausstiegETCSSperre",
    "dunkelschaltanstoss",
    "einstiegErlaubt",
    "gruppenID",
    "untergruppenID"
})
public class CETCSSignalAllg {

    @XmlElement(name = "Ausstieg_ETCS_Sperre", required = true)
    protected TCAusstiegETCSSperre ausstiegETCSSperre;
    @XmlElement(name = "Dunkelschaltanstoss", required = true)
    protected TCDunkelschaltanstoss dunkelschaltanstoss;
    @XmlElement(name = "Einstieg_Erlaubt", required = true)
    protected TCEinstiegErlaubt einstiegErlaubt;
    @XmlElement(name = "Gruppen_ID")
    protected TCGruppenID gruppenID;
    @XmlElement(name = "Untergruppen_ID")
    protected TCUntergruppenID untergruppenID;

    /**
     * Ruft den Wert der ausstiegETCSSperre-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusstiegETCSSperre }
     *     
     */
    public TCAusstiegETCSSperre getAusstiegETCSSperre() {
        return ausstiegETCSSperre;
    }

    /**
     * Legt den Wert der ausstiegETCSSperre-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusstiegETCSSperre }
     *     
     */
    public void setAusstiegETCSSperre(TCAusstiegETCSSperre value) {
        this.ausstiegETCSSperre = value;
    }

    /**
     * Ruft den Wert der dunkelschaltanstoss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDunkelschaltanstoss }
     *     
     */
    public TCDunkelschaltanstoss getDunkelschaltanstoss() {
        return dunkelschaltanstoss;
    }

    /**
     * Legt den Wert der dunkelschaltanstoss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDunkelschaltanstoss }
     *     
     */
    public void setDunkelschaltanstoss(TCDunkelschaltanstoss value) {
        this.dunkelschaltanstoss = value;
    }

    /**
     * Ruft den Wert der einstiegErlaubt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinstiegErlaubt }
     *     
     */
    public TCEinstiegErlaubt getEinstiegErlaubt() {
        return einstiegErlaubt;
    }

    /**
     * Legt den Wert der einstiegErlaubt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinstiegErlaubt }
     *     
     */
    public void setEinstiegErlaubt(TCEinstiegErlaubt value) {
        this.einstiegErlaubt = value;
    }

    /**
     * Ruft den Wert der gruppenID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGruppenID }
     *     
     */
    public TCGruppenID getGruppenID() {
        return gruppenID;
    }

    /**
     * Legt den Wert der gruppenID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGruppenID }
     *     
     */
    public void setGruppenID(TCGruppenID value) {
        this.gruppenID = value;
    }

    /**
     * Ruft den Wert der untergruppenID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUntergruppenID }
     *     
     */
    public TCUntergruppenID getUntergruppenID() {
        return untergruppenID;
    }

    /**
     * Legt den Wert der untergruppenID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUntergruppenID }
     *     
     */
    public void setUntergruppenID(TCUntergruppenID value) {
        this.untergruppenID = value;
    }

}
