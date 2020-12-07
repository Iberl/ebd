//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBedienStandort;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Bei DSTW: B�ndelung der technischen Anlagen f�r ESTW_Zentraleinheit, Telekommunikation, Prozessdaten- und Diagnoseschnittstellen sowie die zugeh�rige technische Geb�udeausr�stung. Je Netzbezirk ist ein Technikstandort vorgesehen.
 * 
 * <p>Java-Klasse f�r CTechnik_Standort complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTechnik_Standort">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}CTechnik_Standort_Bezeichnung"/>
 *         &lt;element name="ID_Bedien_Standort" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Standort" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung"/>
 *         &lt;element name="TSO_IP_Adressblock" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}CTSO_IP_Adressblock" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTechnik_Standort", propOrder = {
    "bezeichnung",
    "idBedienStandort",
    "idUnterbringung",
    "tsoipAdressblock"
})
public class CTechnikStandort
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CTechnikStandortBezeichnung bezeichnung;
    @XmlElement(name = "ID_Bedien_Standort")
    protected List<TCIDBedienStandort> idBedienStandort;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "TSO_IP_Adressblock")
    protected CTSOIPAdressblock tsoipAdressblock;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTechnikStandortBezeichnung }
     *     
     */
    public CTechnikStandortBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTechnikStandortBezeichnung }
     *     
     */
    public void setBezeichnung(CTechnikStandortBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Gets the value of the idBedienStandort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idBedienStandort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDBedienStandort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDBedienStandort }
     * 
     * 
     */
    public List<TCIDBedienStandort> getIDBedienStandort() {
        if (idBedienStandort == null) {
            idBedienStandort = new ArrayList<TCIDBedienStandort>();
        }
        return this.idBedienStandort;
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
     * Ruft den Wert der tsoipAdressblock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTSOIPAdressblock }
     *     
     */
    public CTSOIPAdressblock getTSOIPAdressblock() {
        return tsoipAdressblock;
    }

    /**
     * Legt den Wert der tsoipAdressblock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTSOIPAdressblock }
     *     
     */
    public void setTSOIPAdressblock(CTSOIPAdressblock value) {
        this.tsoipAdressblock = value;
    }

}
