//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDEVModul;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CLEU_Schaltkasten_Energie complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Schaltkasten_Energie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anzahl_Voll_LEU_Kalkuliert" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnzahl_Voll_LEU_Kalkuliert"/>
 *         &lt;element name="ID_Energie_LEU_Schaltkasten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_EV_Modul" minOccurs="0"/>
 *         &lt;element name="Max_Leistung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCMax_Leistung"/>
 *         &lt;element name="Spannung_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSpannung_Art"/>
 *         &lt;element name="Ueberbrueckung_EV_Unterbrechung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCUeberbrueckung_EV_Unterbrechung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Schaltkasten_Energie", propOrder = {
    "anzahlVollLEUKalkuliert",
    "idEnergieLEUSchaltkasten",
    "maxLeistung",
    "spannungArt",
    "ueberbrueckungEVUnterbrechung"
})
public class CLEUSchaltkastenEnergie {

    @XmlElement(name = "Anzahl_Voll_LEU_Kalkuliert", required = true)
    protected TCAnzahlVollLEUKalkuliert anzahlVollLEUKalkuliert;
    @XmlElement(name = "ID_Energie_LEU_Schaltkasten")
    protected TCIDEVModul idEnergieLEUSchaltkasten;
    @XmlElement(name = "Max_Leistung", required = true)
    protected TCMaxLeistung maxLeistung;
    @XmlElement(name = "Spannung_Art", required = true)
    protected TCSpannungArt spannungArt;
    @XmlElement(name = "Ueberbrueckung_EV_Unterbrechung")
    protected TCUeberbrueckungEVUnterbrechung ueberbrueckungEVUnterbrechung;

    /**
     * Ruft den Wert der anzahlVollLEUKalkuliert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnzahlVollLEUKalkuliert }
     *     
     */
    public TCAnzahlVollLEUKalkuliert getAnzahlVollLEUKalkuliert() {
        return anzahlVollLEUKalkuliert;
    }

    /**
     * Legt den Wert der anzahlVollLEUKalkuliert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnzahlVollLEUKalkuliert }
     *     
     */
    public void setAnzahlVollLEUKalkuliert(TCAnzahlVollLEUKalkuliert value) {
        this.anzahlVollLEUKalkuliert = value;
    }

    /**
     * Ruft den Wert der idEnergieLEUSchaltkasten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDEVModul }
     *     
     */
    public TCIDEVModul getIDEnergieLEUSchaltkasten() {
        return idEnergieLEUSchaltkasten;
    }

    /**
     * Legt den Wert der idEnergieLEUSchaltkasten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDEVModul }
     *     
     */
    public void setIDEnergieLEUSchaltkasten(TCIDEVModul value) {
        this.idEnergieLEUSchaltkasten = value;
    }

    /**
     * Ruft den Wert der maxLeistung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMaxLeistung }
     *     
     */
    public TCMaxLeistung getMaxLeistung() {
        return maxLeistung;
    }

    /**
     * Legt den Wert der maxLeistung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMaxLeistung }
     *     
     */
    public void setMaxLeistung(TCMaxLeistung value) {
        this.maxLeistung = value;
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
     * Ruft den Wert der ueberbrueckungEVUnterbrechung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUeberbrueckungEVUnterbrechung }
     *     
     */
    public TCUeberbrueckungEVUnterbrechung getUeberbrueckungEVUnterbrechung() {
        return ueberbrueckungEVUnterbrechung;
    }

    /**
     * Legt den Wert der ueberbrueckungEVUnterbrechung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUeberbrueckungEVUnterbrechung }
     *     
     */
    public void setUeberbrueckungEVUnterbrechung(TCUeberbrueckungEVUnterbrechung value) {
        this.ueberbrueckungEVUnterbrechung = value;
    }

}
