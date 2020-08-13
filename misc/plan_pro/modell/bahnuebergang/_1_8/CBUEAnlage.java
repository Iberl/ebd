//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.basistypen._1_8.CBezeichnungElement;
import modell.verweise._1_8.TCIDBUESchnittstelle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Beschreibung der baulichen Anlage des Bahn�bergangs (B�) einschlie�lich der technischen Sicherung, sofern vorhanden. Zurzeit beschr�nken sich die Angaben auf den im Lageplan darzustellenden Teil des B�. Zu einem sp�teren Zeitpunkt werden die spezifischen B�-Sicherungsanlagen wie Lichtzeichen, Andreaskreuze, Schrankenantriebe, Belag im B�-Bereich etc. in das Modell aufgenommen. Gleiches gilt f�r die Einschaltstreckenberechnung sowie die Beeinflussungsberechnung. Das Objekt wird auf den Kreuzungspunkt (in der Mitte der kreuzenden Stra�e) verortet; damit ergibt sich die sogenannte B�-Mitte gem�� Einschaltstreckenberechnung. DB-Regelwerk F�r die Planung von Bahn�berg�ngen gelten folgende Regelwerke: 815 819.12xx Die konkreten Bez�ge zum Regelwerk werden in den einzelnen Attributen angegeben. 
 * 
 * <p>Java-Klasse f�r CBUE_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBezeichnung_Element"/>
 *         &lt;element name="BUE_Anlage_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Anlage_Allg"/>
 *         &lt;element name="ID_BUE_Schnittstelle" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_BUE_Schnittstelle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Anlage", propOrder = {
    "bezeichnung",
    "bueAnlageAllg",
    "idbueSchnittstelle"
})
public class CBUEAnlage
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "BUE_Anlage_Allg", required = true)
    protected CBUEAnlageAllg bueAnlageAllg;
    @XmlElement(name = "ID_BUE_Schnittstelle")
    protected TCIDBUESchnittstelle idbueSchnittstelle;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBezeichnungElement }
     *     
     */
    public CBezeichnungElement getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBezeichnungElement }
     *     
     */
    public void setBezeichnung(CBezeichnungElement value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der bueAnlageAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEAnlageAllg }
     *     
     */
    public CBUEAnlageAllg getBUEAnlageAllg() {
        return bueAnlageAllg;
    }

    /**
     * Legt den Wert der bueAnlageAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEAnlageAllg }
     *     
     */
    public void setBUEAnlageAllg(CBUEAnlageAllg value) {
        this.bueAnlageAllg = value;
    }

    /**
     * Ruft den Wert der idbueSchnittstelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUESchnittstelle }
     *     
     */
    public TCIDBUESchnittstelle getIDBUESchnittstelle() {
        return idbueSchnittstelle;
    }

    /**
     * Legt den Wert der idbueSchnittstelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUESchnittstelle }
     *     
     */
    public void setIDBUESchnittstelle(TCIDBUESchnittstelle value) {
        this.idbueSchnittstelle = value;
    }

}
