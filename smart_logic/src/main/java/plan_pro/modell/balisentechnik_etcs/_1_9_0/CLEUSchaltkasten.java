//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Schaltkasten als Element der LEU-Anlage zur Unterbringung eines oder mehrerer LEU-Module.
 * 
 * <p>Java-Klasse f�r CLEU_Schaltkasten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Schaltkasten">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Schaltkasten_Bezeichnung"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung" minOccurs="0"/>
 *         &lt;element name="LEU_Schaltkasten_Energie" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Schaltkasten_Energie" minOccurs="0"/>
 *         &lt;element name="LEU_Schaltkasten_Position" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Schaltkasten_Position" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LEU_Schaltkasten_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLEU_Schaltkasten_Typ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Schaltkasten", propOrder = {
    "bezeichnung",
    "idUnterbringung",
    "leuSchaltkastenEnergie",
    "leuSchaltkastenPosition",
    "leuSchaltkastenTyp"
})
public class CLEUSchaltkasten
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CLEUSchaltkastenBezeichnung bezeichnung;
    @XmlElement(name = "ID_Unterbringung")
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "LEU_Schaltkasten_Energie")
    protected CLEUSchaltkastenEnergie leuSchaltkastenEnergie;
    @XmlElement(name = "LEU_Schaltkasten_Position")
    protected List<CLEUSchaltkastenPosition> leuSchaltkastenPosition;
    @XmlElement(name = "LEU_Schaltkasten_Typ")
    protected TCLEUSchaltkastenTyp leuSchaltkastenTyp;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLEUSchaltkastenBezeichnung }
     *     
     */
    public CLEUSchaltkastenBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLEUSchaltkastenBezeichnung }
     *     
     */
    public void setBezeichnung(CLEUSchaltkastenBezeichnung value) {
        this.bezeichnung = value;
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
     * Ruft den Wert der leuSchaltkastenEnergie-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLEUSchaltkastenEnergie }
     *     
     */
    public CLEUSchaltkastenEnergie getLEUSchaltkastenEnergie() {
        return leuSchaltkastenEnergie;
    }

    /**
     * Legt den Wert der leuSchaltkastenEnergie-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLEUSchaltkastenEnergie }
     *     
     */
    public void setLEUSchaltkastenEnergie(CLEUSchaltkastenEnergie value) {
        this.leuSchaltkastenEnergie = value;
    }

    /**
     * Gets the value of the leuSchaltkastenPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leuSchaltkastenPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLEUSchaltkastenPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CLEUSchaltkastenPosition }
     * 
     * 
     */
    public List<CLEUSchaltkastenPosition> getLEUSchaltkastenPosition() {
        if (leuSchaltkastenPosition == null) {
            leuSchaltkastenPosition = new ArrayList<CLEUSchaltkastenPosition>();
        }
        return this.leuSchaltkastenPosition;
    }

    /**
     * Ruft den Wert der leuSchaltkastenTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLEUSchaltkastenTyp }
     *     
     */
    public TCLEUSchaltkastenTyp getLEUSchaltkastenTyp() {
        return leuSchaltkastenTyp;
    }

    /**
     * Legt den Wert der leuSchaltkastenTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLEUSchaltkastenTyp }
     *     
     */
    public void setLEUSchaltkastenTyp(TCLEUSchaltkastenTyp value) {
        this.leuSchaltkastenTyp = value;
    }

}
