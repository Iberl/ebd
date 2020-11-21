//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDAussenelementansteuerung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFMA_Anlage_Uebertragung_FMinfo complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Anlage_Uebertragung_FMinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Uebertragung_FMinfo" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Aussenelementansteuerung"/>
 *         &lt;element name="Uebertragung_FMinfo_Richtung" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCUebertragung_FMinfo_Richtung"/>
 *         &lt;element name="Uebertragung_FMinfo_Typ" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCUebertragung_FMinfo_Typ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Anlage_Uebertragung_FMinfo", propOrder = {
    "idUebertragungFMinfo",
    "uebertragungFMinfoRichtung",
    "uebertragungFMinfoTyp"
})
public class CFMAAnlageUebertragungFMinfo {

    @XmlElement(name = "ID_Uebertragung_FMinfo", required = true)
    protected TCIDAussenelementansteuerung idUebertragungFMinfo;
    @XmlElement(name = "Uebertragung_FMinfo_Richtung", required = true)
    protected TCUebertragungFMinfoRichtung uebertragungFMinfoRichtung;
    @XmlElement(name = "Uebertragung_FMinfo_Typ")
    protected TCUebertragungFMinfoTyp uebertragungFMinfoTyp;

    /**
     * Ruft den Wert der idUebertragungFMinfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDUebertragungFMinfo() {
        return idUebertragungFMinfo;
    }

    /**
     * Legt den Wert der idUebertragungFMinfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDUebertragungFMinfo(TCIDAussenelementansteuerung value) {
        this.idUebertragungFMinfo = value;
    }

    /**
     * Ruft den Wert der uebertragungFMinfoRichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUebertragungFMinfoRichtung }
     *     
     */
    public TCUebertragungFMinfoRichtung getUebertragungFMinfoRichtung() {
        return uebertragungFMinfoRichtung;
    }

    /**
     * Legt den Wert der uebertragungFMinfoRichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUebertragungFMinfoRichtung }
     *     
     */
    public void setUebertragungFMinfoRichtung(TCUebertragungFMinfoRichtung value) {
        this.uebertragungFMinfoRichtung = value;
    }

    /**
     * Ruft den Wert der uebertragungFMinfoTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUebertragungFMinfoTyp }
     *     
     */
    public TCUebertragungFMinfoTyp getUebertragungFMinfoTyp() {
        return uebertragungFMinfoTyp;
    }

    /**
     * Legt den Wert der uebertragungFMinfoTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUebertragungFMinfoTyp }
     *     
     */
    public void setUebertragungFMinfoTyp(TCUebertragungFMinfoTyp value) {
        this.uebertragungFMinfoTyp = value;
    }

}
