//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDAnhang;
import modell.verweise._1_8.TCIDAussenelementansteuerung;
import modell.verweise._1_8.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Abbildung einer �rtlichen Bedieneinrichtung (Stelltafel, Bedienpult etc.) als physisches Element der Au�enanlage. Bedienbare Elemente, die nicht von einer ESTW-Bedienoberfl�che bedient werden, sind durch eine entsprechende Bedieneinrichtung umstellbar. Weiterhin sind in der Bedieneinrichtung Tasten f�r die Kommunikation zwischen �zF und Bediener untergebracht. Im Objekt Bedien_Einrichtung_Oertlich wird die physische Ausbildung der Bedieneinrichtung abgebildet. Die dazugeh�rigen Melder, Schalter und Taster sind im Objekt Bedien Anzeige Element modelliert. Die logischen Funktionen einer Bedieneinrichtung f�r Nahbedienbereiche und Bahn�berg�nge befinden sich in den Objekten �BUE Bedien Anzeige Element� oder �NB Bedien Anzeige Element�. Die Bedien_Einrichtung_Oertlich kommt zur Anwendung bei: Nahbedienbereichen Bahn�berg�ngen (HET, UT, etc.) Gefahrschaltern (Berliner S-Bahn) (noch nicht abschlie�end modelliert) Schl�sselschaltern- und Tastern (Zustimmung, Gleisfreimeldung, Zugschlussmeldung, etc.) ZP 10/9 �Bediens�ulen �rtliche Abgabe von Zugschlussmeldungen und Bedieneinrichtungen an Schnittstellen zum Zugleitbetrieb. Bedieneinrichtungen von elektrisch ortsgestellten Weichen (EOW) werden mit diesem Objekt nicht modelliert. 
 * 
 * <p>Java-Klasse f�r CBedien_Einrichtung_Oertlich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Einrichtung_Oertlich">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Einricht_Oertlich_Allg" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Einricht_Oertlich_Allg"/>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Einrichtung_Oertlich_Bezeichnung" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Benutzeroberflaeche" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Aussenelementansteuerung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Aussenelementansteuerung" minOccurs="0"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Unterbringung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Einrichtung_Oertlich", propOrder = {
    "bedienEinrichtOertlichAllg",
    "bezeichnung",
    "idAnhangBenutzeroberflaeche",
    "idAussenelementansteuerung",
    "idUnterbringung"
})
public class CBedienEinrichtungOertlich
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Einricht_Oertlich_Allg", required = true)
    protected CBedienEinrichtOertlichAllg bedienEinrichtOertlichAllg;
    @XmlElement(name = "Bezeichnung")
    protected CBedienEinrichtungOertlichBezeichnung bezeichnung;
    @XmlElement(name = "ID_Anhang_Benutzeroberflaeche")
    protected TCIDAnhang idAnhangBenutzeroberflaeche;
    @XmlElement(name = "ID_Aussenelementansteuerung")
    protected TCIDAussenelementansteuerung idAussenelementansteuerung;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;

    /**
     * Ruft den Wert der bedienEinrichtOertlichAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienEinrichtOertlichAllg }
     *     
     */
    public CBedienEinrichtOertlichAllg getBedienEinrichtOertlichAllg() {
        return bedienEinrichtOertlichAllg;
    }

    /**
     * Legt den Wert der bedienEinrichtOertlichAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienEinrichtOertlichAllg }
     *     
     */
    public void setBedienEinrichtOertlichAllg(CBedienEinrichtOertlichAllg value) {
        this.bedienEinrichtOertlichAllg = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienEinrichtungOertlichBezeichnung }
     *     
     */
    public CBedienEinrichtungOertlichBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienEinrichtungOertlichBezeichnung }
     *     
     */
    public void setBezeichnung(CBedienEinrichtungOertlichBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idAnhangBenutzeroberflaeche-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangBenutzeroberflaeche() {
        return idAnhangBenutzeroberflaeche;
    }

    /**
     * Legt den Wert der idAnhangBenutzeroberflaeche-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangBenutzeroberflaeche(TCIDAnhang value) {
        this.idAnhangBenutzeroberflaeche = value;
    }

    /**
     * Ruft den Wert der idAussenelementansteuerung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDAussenelementansteuerung() {
        return idAussenelementansteuerung;
    }

    /**
     * Legt den Wert der idAussenelementansteuerung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDAussenelementansteuerung(TCIDAussenelementansteuerung value) {
        this.idAussenelementansteuerung = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
    }

}
