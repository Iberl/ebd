//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPlanung_E_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_E_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bauphase" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBauphase" minOccurs="0"/>
 *         &lt;element name="Bauzustand_Kurzbezeichnung" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBauzustand_Kurzbezeichnung"/>
 *         &lt;element name="Datum_Abschluss_Einzel" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCDatum_Abschluss_Einzel" minOccurs="0"/>
 *         &lt;element name="Datum_Regelwerksstand" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCDatum_Regelwerksstand"/>
 *         &lt;element name="Index_Ausgabe" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCIndex_Ausgabe"/>
 *         &lt;element name="Informativ" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCInformativ"/>
 *         &lt;element name="Laufende_Nummer_Ausgabe" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCLaufende_Nummer_Ausgabe"/>
 *         &lt;element name="Planung_E_Art" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCPlanung_E_Art"/>
 *         &lt;element name="Planung_Phase" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCPlanung_Phase" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_E_Allg", propOrder = {
    "bauphase",
    "bauzustandKurzbezeichnung",
    "datumAbschlussEinzel",
    "datumRegelwerksstand",
    "indexAusgabe",
    "informativ",
    "laufendeNummerAusgabe",
    "planungEArt",
    "planungPhase"
})
public class CPlanungEAllg {

    @XmlElement(name = "Bauphase")
    protected TCBauphase bauphase;
    @XmlElement(name = "Bauzustand_Kurzbezeichnung", required = true)
    protected TCBauzustandKurzbezeichnung bauzustandKurzbezeichnung;
    @XmlElement(name = "Datum_Abschluss_Einzel")
    protected TCDatumAbschlussEinzel datumAbschlussEinzel;
    @XmlElement(name = "Datum_Regelwerksstand", required = true)
    protected TCDatumRegelwerksstand datumRegelwerksstand;
    @XmlElement(name = "Index_Ausgabe", required = true)
    protected TCIndexAusgabe indexAusgabe;
    @XmlElement(name = "Informativ", required = true)
    protected TCInformativ informativ;
    @XmlElement(name = "Laufende_Nummer_Ausgabe", required = true)
    protected TCLaufendeNummerAusgabe laufendeNummerAusgabe;
    @XmlElement(name = "Planung_E_Art", required = true)
    protected TCPlanungEArt planungEArt;
    @XmlElement(name = "Planung_Phase")
    protected TCPlanungPhase planungPhase;

    /**
     * Ruft den Wert der bauphase-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBauphase }
     *     
     */
    public TCBauphase getBauphase() {
        return bauphase;
    }

    /**
     * Legt den Wert der bauphase-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBauphase }
     *     
     */
    public void setBauphase(TCBauphase value) {
        this.bauphase = value;
    }

    /**
     * Ruft den Wert der bauzustandKurzbezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBauzustandKurzbezeichnung }
     *     
     */
    public TCBauzustandKurzbezeichnung getBauzustandKurzbezeichnung() {
        return bauzustandKurzbezeichnung;
    }

    /**
     * Legt den Wert der bauzustandKurzbezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBauzustandKurzbezeichnung }
     *     
     */
    public void setBauzustandKurzbezeichnung(TCBauzustandKurzbezeichnung value) {
        this.bauzustandKurzbezeichnung = value;
    }

    /**
     * Ruft den Wert der datumAbschlussEinzel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatumAbschlussEinzel }
     *     
     */
    public TCDatumAbschlussEinzel getDatumAbschlussEinzel() {
        return datumAbschlussEinzel;
    }

    /**
     * Legt den Wert der datumAbschlussEinzel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatumAbschlussEinzel }
     *     
     */
    public void setDatumAbschlussEinzel(TCDatumAbschlussEinzel value) {
        this.datumAbschlussEinzel = value;
    }

    /**
     * Ruft den Wert der datumRegelwerksstand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatumRegelwerksstand }
     *     
     */
    public TCDatumRegelwerksstand getDatumRegelwerksstand() {
        return datumRegelwerksstand;
    }

    /**
     * Legt den Wert der datumRegelwerksstand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatumRegelwerksstand }
     *     
     */
    public void setDatumRegelwerksstand(TCDatumRegelwerksstand value) {
        this.datumRegelwerksstand = value;
    }

    /**
     * Ruft den Wert der indexAusgabe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIndexAusgabe }
     *     
     */
    public TCIndexAusgabe getIndexAusgabe() {
        return indexAusgabe;
    }

    /**
     * Legt den Wert der indexAusgabe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIndexAusgabe }
     *     
     */
    public void setIndexAusgabe(TCIndexAusgabe value) {
        this.indexAusgabe = value;
    }

    /**
     * Ruft den Wert der informativ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCInformativ }
     *     
     */
    public TCInformativ getInformativ() {
        return informativ;
    }

    /**
     * Legt den Wert der informativ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInformativ }
     *     
     */
    public void setInformativ(TCInformativ value) {
        this.informativ = value;
    }

    /**
     * Ruft den Wert der laufendeNummerAusgabe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLaufendeNummerAusgabe }
     *     
     */
    public TCLaufendeNummerAusgabe getLaufendeNummerAusgabe() {
        return laufendeNummerAusgabe;
    }

    /**
     * Legt den Wert der laufendeNummerAusgabe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLaufendeNummerAusgabe }
     *     
     */
    public void setLaufendeNummerAusgabe(TCLaufendeNummerAusgabe value) {
        this.laufendeNummerAusgabe = value;
    }

    /**
     * Ruft den Wert der planungEArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPlanungEArt }
     *     
     */
    public TCPlanungEArt getPlanungEArt() {
        return planungEArt;
    }

    /**
     * Legt den Wert der planungEArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPlanungEArt }
     *     
     */
    public void setPlanungEArt(TCPlanungEArt value) {
        this.planungEArt = value;
    }

    /**
     * Ruft den Wert der planungPhase-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPlanungPhase }
     *     
     */
    public TCPlanungPhase getPlanungPhase() {
        return planungPhase;
    }

    /**
     * Legt den Wert der planungPhase-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPlanungPhase }
     *     
     */
    public void setPlanungPhase(TCPlanungPhase value) {
        this.planungPhase = value;
    }

}
