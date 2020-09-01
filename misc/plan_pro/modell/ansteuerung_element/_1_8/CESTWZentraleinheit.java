//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDBedienBezirk;
import modell.verweise._1_8.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zentrale Komponente eines ESTW. Die ESTW-Zentraleinheit (ZE) steuert alle untergeordneten Aussenelementansteuerungen, stellt die Verbindung zu den Bedienbezirken (Notbedienplatz, Steuerbezirk/Zentralbedienung) und zu Nachbar-ESTW-Zentraleinheiten, zur Zuglenkung und zur Zugnummernmeldeanlage her. Die ZE kann ein ESTW-Z oder eine ESTW-UZ sein. Die geografische Grenze einer ZE liegt immer an einem Haupt- oder Sperrsignal (Signal_Real_Aktiv) oder einem Bedienpunkt (Signal_Fiktiv), in der Regel an einem Einfahrsignal. Die von einer Unterzentrale ben�tigten Adressformeln nach Richtlinie 819.0705 werden �ber die Verkn�pfung zu Bedien Bezirk bereitgestellt. DB-Regelwerk Darstellung des ESTW-Geb�udes im sicherungstechnischen Lageplan nach Ril 819.9002, Beschreibung im Erl�uterungsbericht
 * 
 * <p>Java-Klasse f�r CESTW_Zentraleinheit complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CESTW_Zentraleinheit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CESTW_Zentraleinheit_Bezeichnung"/>
 *         &lt;element name="ESTW_Zentraleinheit_Allg" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CESTW_Zentraleinheit_Allg"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Unterbringung"/>
 *         &lt;choice>
 *           &lt;element name="ID_Bedien_Bezirk_Virtuell" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bedien_Bezirk" minOccurs="0"/>
 *           &lt;element name="ID_Bedien_Bezirk_Zentral" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bedien_Bezirk" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CESTW_Zentraleinheit", propOrder = {
    "bezeichnung",
    "estwZentraleinheitAllg",
    "idUnterbringung",
    "idBedienBezirkVirtuell",
    "idBedienBezirkZentral"
})
public class CESTWZentraleinheit
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CESTWZentraleinheitBezeichnung bezeichnung;
    @XmlElement(name = "ESTW_Zentraleinheit_Allg", required = true)
    protected CESTWZentraleinheitAllg estwZentraleinheitAllg;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "ID_Bedien_Bezirk_Virtuell")
    protected TCIDBedienBezirk idBedienBezirkVirtuell;
    @XmlElement(name = "ID_Bedien_Bezirk_Zentral")
    protected TCIDBedienBezirk idBedienBezirkZentral;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CESTWZentraleinheitBezeichnung }
     *     
     */
    public CESTWZentraleinheitBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CESTWZentraleinheitBezeichnung }
     *     
     */
    public void setBezeichnung(CESTWZentraleinheitBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der estwZentraleinheitAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CESTWZentraleinheitAllg }
     *     
     */
    public CESTWZentraleinheitAllg getESTWZentraleinheitAllg() {
        return estwZentraleinheitAllg;
    }

    /**
     * Legt den Wert der estwZentraleinheitAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CESTWZentraleinheitAllg }
     *     
     */
    public void setESTWZentraleinheitAllg(CESTWZentraleinheitAllg value) {
        this.estwZentraleinheitAllg = value;
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

    /**
     * Ruft den Wert der idBedienBezirkVirtuell-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public TCIDBedienBezirk getIDBedienBezirkVirtuell() {
        return idBedienBezirkVirtuell;
    }

    /**
     * Legt den Wert der idBedienBezirkVirtuell-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public void setIDBedienBezirkVirtuell(TCIDBedienBezirk value) {
        this.idBedienBezirkVirtuell = value;
    }

    /**
     * Ruft den Wert der idBedienBezirkZentral-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public TCIDBedienBezirk getIDBedienBezirkZentral() {
        return idBedienBezirkZentral;
    }

    /**
     * Legt den Wert der idBedienBezirkZentral-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public void setIDBedienBezirkZentral(TCIDBedienBezirk value) {
        this.idBedienBezirkZentral = value;
    }

}
