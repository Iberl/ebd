//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDElementUnterbringung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CEV_Modul_Physisch complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEV_Modul_Physisch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EV_Modul_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEV_Modul_Art"/>
 *         &lt;element name="EV_Modul_Eingang" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CEV_Modul_Eingang" maxOccurs="unbounded"/>
 *         &lt;element name="EV_Modul_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEV_Modul_Typ" minOccurs="0"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCHersteller" minOccurs="0"/>
 *         &lt;element name="ID_Element_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Element_Unterbringung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEV_Modul_Physisch", propOrder = {
    "evModulArt",
    "evModulEingang",
    "evModulTyp",
    "hersteller",
    "idElementUnterbringung"
})
public class CEVModulPhysisch {

    @XmlElement(name = "EV_Modul_Art", required = true)
    protected TCEVModulArt evModulArt;
    @XmlElement(name = "EV_Modul_Eingang", required = true)
    protected List<CEVModulEingang> evModulEingang;
    @XmlElement(name = "EV_Modul_Typ")
    protected TCEVModulTyp evModulTyp;
    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;
    @XmlElement(name = "ID_Element_Unterbringung", required = true)
    protected TCIDElementUnterbringung idElementUnterbringung;

    /**
     * Ruft den Wert der evModulArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEVModulArt }
     *     
     */
    public TCEVModulArt getEVModulArt() {
        return evModulArt;
    }

    /**
     * Legt den Wert der evModulArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEVModulArt }
     *     
     */
    public void setEVModulArt(TCEVModulArt value) {
        this.evModulArt = value;
    }

    /**
     * Gets the value of the evModulEingang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evModulEingang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEVModulEingang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CEVModulEingang }
     * 
     * 
     */
    public List<CEVModulEingang> getEVModulEingang() {
        if (evModulEingang == null) {
            evModulEingang = new ArrayList<CEVModulEingang>();
        }
        return this.evModulEingang;
    }

    /**
     * Ruft den Wert der evModulTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEVModulTyp }
     *     
     */
    public TCEVModulTyp getEVModulTyp() {
        return evModulTyp;
    }

    /**
     * Legt den Wert der evModulTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEVModulTyp }
     *     
     */
    public void setEVModulTyp(TCEVModulTyp value) {
        this.evModulTyp = value;
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

    /**
     * Ruft den Wert der idElementUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDElementUnterbringung }
     *     
     */
    public TCIDElementUnterbringung getIDElementUnterbringung() {
        return idElementUnterbringung;
    }

    /**
     * Legt den Wert der idElementUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDElementUnterbringung }
     *     
     */
    public void setIDElementUnterbringung(TCIDElementUnterbringung value) {
        this.idElementUnterbringung = value;
    }

}
