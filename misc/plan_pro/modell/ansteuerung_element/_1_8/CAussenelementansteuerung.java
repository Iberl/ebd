//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Technisches Objekt, von dem aus die Ansteuerung der ESTW-Elemente der Au�enanlage erfolgt. Au�enelementansteuerungen (AEA) k�nnen hierarchich angeordnet sein. �ber dem h�chsten Element der Hierarchie steht immer die ESTW Zentraleinheit. Von allen AEA k�nnen ein oder mehrere Elemente der Au�enanlage angesteuert sowie deren Zust�nde eingelesen werden. In der Verkettung zeigt die Verweisrichtung immer auf das in der Hierarchie h�here Element. Die �bertragung von Daten und Energie wird durch getrennte Verweise modelliert. In der konventionellen ESTW-Technik entspricht die AEA dem ESTW-A. Eine Kaskadierung von AEA ist erst in neuerer ESTW-Technik �blich. Geh�rt ein Schaltkasten zu einem Signal, muss dieser nicht als AEA geplant werden, in dem Fall wird der Schaltkasten als Bestandteil des Signals betrachtet. Kann ein Schaltkasten mehrere Signale steuern, ist er als AEA zu betrachten. Je nach Detaillierungsgrad der Planung kann die prim�re und sekund�re Energieversorgung nur in der grunds�tzlichen Art oder sogar der tats�chliche Lieferant �ber einen Verweis auf diesen angegeben werden. Als AEA werden nur Bestandteile des ESTW modelliert. Schnittstellen zu anderen Untergewerken (z. B. PZB, B�, ETCS) werden �ber das Stellelement dargestellt. DB-Regelwerk Darstellung und Beschriftung des ESTW-Geb�udes im sicherungstechnischen Lageplan nach Ril 819.9002
 * 
 * <p>Java-Klasse f�r CAussenelementansteuerung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAussenelementansteuerung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="AEA_Allg" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CAEA_Allg"/>
 *         &lt;element name="AEA_Energieversorgung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CAEA_Energieversorgung" minOccurs="0"/>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CAussenelementansteuerung_Bezeichnung"/>
 *         &lt;element name="ID_Information_Primaer" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Information_Primaer" minOccurs="0"/>
 *         &lt;element name="ID_Information_Sekundaer" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Aussenelementansteuerung" minOccurs="0"/>
 *         &lt;element name="ID_Oertlichkeit_Gesteuert" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Oertlichkeit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Oertlichkeit_Namensgebend" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Oertlichkeit_Proxy" minOccurs="0"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Unterbringung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAussenelementansteuerung", propOrder = {
    "aeaAllg",
    "aeaEnergieversorgung",
    "bezeichnung",
    "idInformationPrimaer",
    "idInformationSekundaer",
    "idOertlichkeitGesteuert",
    "idOertlichkeitNamensgebend",
    "idUnterbringung"
})
public class CAussenelementansteuerung
    extends CBasisObjekt
{

    @XmlElement(name = "AEA_Allg", required = true)
    protected CAEAAllg aeaAllg;
    @XmlElement(name = "AEA_Energieversorgung")
    protected CAEAEnergieversorgung aeaEnergieversorgung;
    @XmlElement(name = "Bezeichnung", required = true)
    protected CAussenelementansteuerungBezeichnung bezeichnung;
    @XmlElement(name = "ID_Information_Primaer")
    protected TCIDInformationPrimaer idInformationPrimaer;
    @XmlElement(name = "ID_Information_Sekundaer")
    protected TCIDAussenelementansteuerung idInformationSekundaer;
    @XmlElement(name = "ID_Oertlichkeit_Gesteuert")
    protected List<TCIDOertlichkeit> idOertlichkeitGesteuert;
    @XmlElement(name = "ID_Oertlichkeit_Namensgebend")
    protected TCIDOertlichkeitProxy idOertlichkeitNamensgebend;
    @XmlElement(name = "ID_Unterbringung")
    protected TCIDUnterbringung idUnterbringung;

    /**
     * Ruft den Wert der aeaAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAEAAllg }
     *     
     */
    public CAEAAllg getAEAAllg() {
        return aeaAllg;
    }

    /**
     * Legt den Wert der aeaAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAEAAllg }
     *     
     */
    public void setAEAAllg(CAEAAllg value) {
        this.aeaAllg = value;
    }

    /**
     * Ruft den Wert der aeaEnergieversorgung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAEAEnergieversorgung }
     *     
     */
    public CAEAEnergieversorgung getAEAEnergieversorgung() {
        return aeaEnergieversorgung;
    }

    /**
     * Legt den Wert der aeaEnergieversorgung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAEAEnergieversorgung }
     *     
     */
    public void setAEAEnergieversorgung(CAEAEnergieversorgung value) {
        this.aeaEnergieversorgung = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAussenelementansteuerungBezeichnung }
     *     
     */
    public CAussenelementansteuerungBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAussenelementansteuerungBezeichnung }
     *     
     */
    public void setBezeichnung(CAussenelementansteuerungBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idInformationPrimaer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDInformationPrimaer }
     *     
     */
    public TCIDInformationPrimaer getIDInformationPrimaer() {
        return idInformationPrimaer;
    }

    /**
     * Legt den Wert der idInformationPrimaer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDInformationPrimaer }
     *     
     */
    public void setIDInformationPrimaer(TCIDInformationPrimaer value) {
        this.idInformationPrimaer = value;
    }

    /**
     * Ruft den Wert der idInformationSekundaer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDInformationSekundaer() {
        return idInformationSekundaer;
    }

    /**
     * Legt den Wert der idInformationSekundaer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDInformationSekundaer(TCIDAussenelementansteuerung value) {
        this.idInformationSekundaer = value;
    }

    /**
     * Gets the value of the idOertlichkeitGesteuert property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idOertlichkeitGesteuert property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDOertlichkeitGesteuert().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDOertlichkeit }
     * 
     * 
     */
    public List<TCIDOertlichkeit> getIDOertlichkeitGesteuert() {
        if (idOertlichkeitGesteuert == null) {
            idOertlichkeitGesteuert = new ArrayList<TCIDOertlichkeit>();
        }
        return this.idOertlichkeitGesteuert;
    }

    /**
     * Ruft den Wert der idOertlichkeitNamensgebend-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDOertlichkeitNamensgebend() {
        return idOertlichkeitNamensgebend;
    }

    /**
     * Legt den Wert der idOertlichkeitNamensgebend-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDOertlichkeitNamensgebend(TCIDOertlichkeitProxy value) {
        this.idOertlichkeitNamensgebend = value;
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
