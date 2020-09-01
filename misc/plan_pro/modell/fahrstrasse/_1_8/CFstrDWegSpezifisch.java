//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import modell.verweise._1_8.TCIDFMAAnlage;
import modell.verweise._1_8.TCIDMarkanterPunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_DWeg_Spezifisch complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg_Spezifisch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Aufloesung_Verzoegerung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCAufloesung_Verzoegerung"/>
 *         &lt;element name="DWeg_Reihenfolge" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCDWeg_Reihenfolge"/>
 *         &lt;element name="DWeg_V" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCDWeg_V"/>
 *         &lt;element name="DWeg_V_Aufwertung_Verzicht" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCDWeg_V_Aufwertung_Verzicht" minOccurs="0"/>
 *         &lt;element name="ID_FMA_Anlage_Zielgleis" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_FMA_Anlage"/>
 *         &lt;element name="ID_Gefahrpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Markanter_Punkt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg_Spezifisch", propOrder = {
    "aufloesungVerzoegerung",
    "dWegReihenfolge",
    "dWegV",
    "dWegVAufwertungVerzicht",
    "idfmaAnlageZielgleis",
    "idGefahrpunkt"
})
public class CFstrDWegSpezifisch {

    @XmlElement(name = "Aufloesung_Verzoegerung", required = true)
    protected TCAufloesungVerzoegerung aufloesungVerzoegerung;
    @XmlElement(name = "DWeg_Reihenfolge", required = true)
    protected TCDWegReihenfolge dWegReihenfolge;
    @XmlElement(name = "DWeg_V", required = true)
    protected TCDWegV dWegV;
    @XmlElement(name = "DWeg_V_Aufwertung_Verzicht")
    protected TCDWegVAufwertungVerzicht dWegVAufwertungVerzicht;
    @XmlElement(name = "ID_FMA_Anlage_Zielgleis", required = true)
    protected TCIDFMAAnlage idfmaAnlageZielgleis;
    @XmlElement(name = "ID_Gefahrpunkt")
    protected TCIDMarkanterPunkt idGefahrpunkt;

    /**
     * Ruft den Wert der aufloesungVerzoegerung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAufloesungVerzoegerung }
     *     
     */
    public TCAufloesungVerzoegerung getAufloesungVerzoegerung() {
        return aufloesungVerzoegerung;
    }

    /**
     * Legt den Wert der aufloesungVerzoegerung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAufloesungVerzoegerung }
     *     
     */
    public void setAufloesungVerzoegerung(TCAufloesungVerzoegerung value) {
        this.aufloesungVerzoegerung = value;
    }

    /**
     * Ruft den Wert der dWegReihenfolge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegReihenfolge }
     *     
     */
    public TCDWegReihenfolge getDWegReihenfolge() {
        return dWegReihenfolge;
    }

    /**
     * Legt den Wert der dWegReihenfolge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegReihenfolge }
     *     
     */
    public void setDWegReihenfolge(TCDWegReihenfolge value) {
        this.dWegReihenfolge = value;
    }

    /**
     * Ruft den Wert der dWegV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegV }
     *     
     */
    public TCDWegV getDWegV() {
        return dWegV;
    }

    /**
     * Legt den Wert der dWegV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegV }
     *     
     */
    public void setDWegV(TCDWegV value) {
        this.dWegV = value;
    }

    /**
     * Ruft den Wert der dWegVAufwertungVerzicht-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegVAufwertungVerzicht }
     *     
     */
    public TCDWegVAufwertungVerzicht getDWegVAufwertungVerzicht() {
        return dWegVAufwertungVerzicht;
    }

    /**
     * Legt den Wert der dWegVAufwertungVerzicht-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegVAufwertungVerzicht }
     *     
     */
    public void setDWegVAufwertungVerzicht(TCDWegVAufwertungVerzicht value) {
        this.dWegVAufwertungVerzicht = value;
    }

    /**
     * Ruft den Wert der idfmaAnlageZielgleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFMAAnlage }
     *     
     */
    public TCIDFMAAnlage getIDFMAAnlageZielgleis() {
        return idfmaAnlageZielgleis;
    }

    /**
     * Legt den Wert der idfmaAnlageZielgleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFMAAnlage }
     *     
     */
    public void setIDFMAAnlageZielgleis(TCIDFMAAnlage value) {
        this.idfmaAnlageZielgleis = value;
    }

    /**
     * Ruft den Wert der idGefahrpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDGefahrpunkt() {
        return idGefahrpunkt;
    }

    /**
     * Legt den Wert der idGefahrpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDGefahrpunkt(TCIDMarkanterPunkt value) {
        this.idGefahrpunkt = value;
    }

}
