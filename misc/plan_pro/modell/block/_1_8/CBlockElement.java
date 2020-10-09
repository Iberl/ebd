//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.block._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDBedienAnzeigeElement;
import modell.verweise._1_8.TCIDBlockStrecke;
import modell.verweise._1_8.TCIDSchaltmittelZuordnung;
import modell.verweise._1_8.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Element am Ende einer Blockstrecke/Blockanlage. Ein Streckengleis, welches mit einer Block Anlage ausger�stet ist, besitzt zwei korrespondierende Blockelemente in den benachbarten Betriebsstellen. Eine Ausnahme bildet der Stichstreckenblock, der nur ein Block_Element besitzt. Das Block_Element verweist auch auf die zugeh�rige Blockstrecke, die die relevanten blocktechnischen und betrieblichen Daten der Strecke enth�lt. Bei zweigleisigen Strecken verweisen zwei Blockelemente auf die Blockstrecke. Das Block_Element verweist auf ein Signal in Form des Streckenziels (A-Feld) und auf ein Schaltmittel zur R�umungspr�fung (E-Feld). Wenn eine gesonderte Zugschlussmeldung verwendet wird, wird mit ID_Zugschlussmeldung auf eine entsprechende Bedieneinrichtung verwiesen. Aus der Blockbauform der jeweiligen Endstelle kann die Art der technischen Realisierung erkannt werden. 
 * 
 * <p>Java-Klasse f�r CBlock_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Block_Element_Allg" type="{http://www.plan-pro.org/modell/Block/1.8.0}CBlock_Element_Allg"/>
 *         &lt;element name="Block_Element_Erlaubnis" type="{http://www.plan-pro.org/modell/Block/1.8.0}CBlock_Element_Erlaubnis" minOccurs="0"/>
 *         &lt;element name="ID_Block_Strecke" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Block_Strecke"/>
 *         &lt;element name="ID_Raeumungspruefung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Schaltmittel_Zuordnung" minOccurs="0"/>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal" minOccurs="0"/>
 *         &lt;element name="ID_Zugschlussmeldung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bedien_Anzeige_Element" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Element", propOrder = {
    "blockElementAllg",
    "blockElementErlaubnis",
    "idBlockStrecke",
    "idRaeumungspruefung",
    "idSignal",
    "idZugschlussmeldung"
})
public class CBlockElement
    extends CBasisObjekt
{

    @XmlElement(name = "Block_Element_Allg", required = true)
    protected CBlockElementAllg blockElementAllg;
    @XmlElement(name = "Block_Element_Erlaubnis")
    protected CBlockElementErlaubnis blockElementErlaubnis;
    @XmlElement(name = "ID_Block_Strecke", required = true)
    protected TCIDBlockStrecke idBlockStrecke;
    @XmlElement(name = "ID_Raeumungspruefung")
    protected TCIDSchaltmittelZuordnung idRaeumungspruefung;
    @XmlElement(name = "ID_Signal")
    protected TCIDSignal idSignal;
    @XmlElement(name = "ID_Zugschlussmeldung")
    protected TCIDBedienAnzeigeElement idZugschlussmeldung;

    /**
     * Ruft den Wert der blockElementAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBlockElementAllg }
     *     
     */
    public CBlockElementAllg getBlockElementAllg() {
        return blockElementAllg;
    }

    /**
     * Legt den Wert der blockElementAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBlockElementAllg }
     *     
     */
    public void setBlockElementAllg(CBlockElementAllg value) {
        this.blockElementAllg = value;
    }

    /**
     * Ruft den Wert der blockElementErlaubnis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBlockElementErlaubnis }
     *     
     */
    public CBlockElementErlaubnis getBlockElementErlaubnis() {
        return blockElementErlaubnis;
    }

    /**
     * Legt den Wert der blockElementErlaubnis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBlockElementErlaubnis }
     *     
     */
    public void setBlockElementErlaubnis(CBlockElementErlaubnis value) {
        this.blockElementErlaubnis = value;
    }

    /**
     * Ruft den Wert der idBlockStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBlockStrecke }
     *     
     */
    public TCIDBlockStrecke getIDBlockStrecke() {
        return idBlockStrecke;
    }

    /**
     * Legt den Wert der idBlockStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBlockStrecke }
     *     
     */
    public void setIDBlockStrecke(TCIDBlockStrecke value) {
        this.idBlockStrecke = value;
    }

    /**
     * Ruft den Wert der idRaeumungspruefung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchaltmittelZuordnung }
     *     
     */
    public TCIDSchaltmittelZuordnung getIDRaeumungspruefung() {
        return idRaeumungspruefung;
    }

    /**
     * Legt den Wert der idRaeumungspruefung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchaltmittelZuordnung }
     *     
     */
    public void setIDRaeumungspruefung(TCIDSchaltmittelZuordnung value) {
        this.idRaeumungspruefung = value;
    }

    /**
     * Ruft den Wert der idSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignal() {
        return idSignal;
    }

    /**
     * Legt den Wert der idSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignal(TCIDSignal value) {
        this.idSignal = value;
    }

    /**
     * Ruft den Wert der idZugschlussmeldung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienAnzeigeElement }
     *     
     */
    public TCIDBedienAnzeigeElement getIDZugschlussmeldung() {
        return idZugschlussmeldung;
    }

    /**
     * Legt den Wert der idZugschlussmeldung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienAnzeigeElement }
     *     
     */
    public void setIDZugschlussmeldung(TCIDBedienAnzeigeElement value) {
        this.idZugschlussmeldung = value;
    }

}
