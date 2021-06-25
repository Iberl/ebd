//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlageOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringungOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Abbildung von Lichtzeichen und Andreaskreuzen im Rahmen der B�-Planung. Die Attributgruppe Verkehrszeichen_Lz entf�llt bei nichttechnisch gesicherten B� oder beschrankten B� mit L�utewerk. Die Attributgruppe Verkehrszeichen_Andreaskreuz entf�llt bei vorgeschalteten Lichtzeichen. Mehrere Andreaskreuze bei einm�ndenden Stra�en sind m�glich (i. d. R. max 3). Die Attributgruppe Vz_Sperrstrecke entf�llt bei vorgeschalteten Lichtzeichen
 * 
 * <p>Java-Klasse f�r CVerkehrszeichen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVerkehrszeichen">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVerkehrszeichen_Bezeichnung" minOccurs="0"/>
 *         &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Anlage_ohne_Proxy"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung_ohne_Proxy"/>
 *         &lt;element name="Verkehrszeichen_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVerkehrszeichen_Allg"/>
 *         &lt;element name="Verkehrszeichen_Andreaskreuz" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVerkehrszeichen_Andreaskreuz" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="Verkehrszeichen_Lz" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVerkehrszeichen_Lz" minOccurs="0"/>
 *         &lt;element name="Vz_Sperrstrecke" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVz_Sperrstrecke" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVerkehrszeichen", propOrder = {
    "bezeichnung",
    "idbueAnlage",
    "idUnterbringung",
    "verkehrszeichenAllg",
    "verkehrszeichenAndreaskreuz",
    "verkehrszeichenLz",
    "vzSperrstrecke"
})
public class CVerkehrszeichen
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CVerkehrszeichenBezeichnung bezeichnung;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlageOhneProxy idbueAnlage;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringungOhneProxy idUnterbringung;
    @XmlElement(name = "Verkehrszeichen_Allg", required = true)
    protected CVerkehrszeichenAllg verkehrszeichenAllg;
    @XmlElement(name = "Verkehrszeichen_Andreaskreuz")
    protected List<CVerkehrszeichenAndreaskreuz> verkehrszeichenAndreaskreuz;
    @XmlElement(name = "Verkehrszeichen_Lz")
    protected CVerkehrszeichenLz verkehrszeichenLz;
    @XmlElement(name = "Vz_Sperrstrecke")
    protected CVzSperrstrecke vzSperrstrecke;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CVerkehrszeichenBezeichnung }
     *     
     */
    public CVerkehrszeichenBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CVerkehrszeichenBezeichnung }
     *     
     */
    public void setBezeichnung(CVerkehrszeichenBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public TCIDBUEAnlageOhneProxy getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlageOhneProxy value) {
        this.idbueAnlage = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringungOhneProxy }
     *     
     */
    public TCIDUnterbringungOhneProxy getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringungOhneProxy }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringungOhneProxy value) {
        this.idUnterbringung = value;
    }

    /**
     * Ruft den Wert der verkehrszeichenAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CVerkehrszeichenAllg }
     *     
     */
    public CVerkehrszeichenAllg getVerkehrszeichenAllg() {
        return verkehrszeichenAllg;
    }

    /**
     * Legt den Wert der verkehrszeichenAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CVerkehrszeichenAllg }
     *     
     */
    public void setVerkehrszeichenAllg(CVerkehrszeichenAllg value) {
        this.verkehrszeichenAllg = value;
    }

    /**
     * Gets the value of the verkehrszeichenAndreaskreuz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verkehrszeichenAndreaskreuz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerkehrszeichenAndreaskreuz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CVerkehrszeichenAndreaskreuz }
     * 
     * 
     */
    public List<CVerkehrszeichenAndreaskreuz> getVerkehrszeichenAndreaskreuz() {
        if (verkehrszeichenAndreaskreuz == null) {
            verkehrszeichenAndreaskreuz = new ArrayList<CVerkehrszeichenAndreaskreuz>();
        }
        return this.verkehrszeichenAndreaskreuz;
    }

    /**
     * Ruft den Wert der verkehrszeichenLz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CVerkehrszeichenLz }
     *     
     */
    public CVerkehrszeichenLz getVerkehrszeichenLz() {
        return verkehrszeichenLz;
    }

    /**
     * Legt den Wert der verkehrszeichenLz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CVerkehrszeichenLz }
     *     
     */
    public void setVerkehrszeichenLz(CVerkehrszeichenLz value) {
        this.verkehrszeichenLz = value;
    }

    /**
     * Ruft den Wert der vzSperrstrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CVzSperrstrecke }
     *     
     */
    public CVzSperrstrecke getVzSperrstrecke() {
        return vzSperrstrecke;
    }

    /**
     * Legt den Wert der vzSperrstrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CVzSperrstrecke }
     *     
     */
    public void setVzSperrstrecke(CVzSperrstrecke value) {
        this.vzSperrstrecke = value;
    }

}
