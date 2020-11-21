//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDInformationEingang;
import plan_pro.modell.verweise._1_9_0.TCIDLEUAnlageOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDLEUSchaltkastenOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Elektronische Baugruppe zur Ansteuerung von Balisen in Abh�ngigkeit von Eingangsinformationen. Ein LEU-Modul ist in einem LEU-Schaltkasten untergebracht.
 * 
 * <p>Java-Klasse f�r CLEU_Modul complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Modul">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Modul_Bezeichnung"/>
 *         &lt;element name="ID_Information_Eingang" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Information_Eingang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_LEU_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_LEU_Anlage_ohne_Proxy"/>
 *         &lt;element name="ID_LEU_Schaltkasten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_LEU_Schaltkasten_ohne_Proxy"/>
 *         &lt;element name="LEU_Modul_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Modul_Allg" minOccurs="0"/>
 *         &lt;element name="LEU_Modul_Ausgang" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Modul_Ausgang" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Modul", propOrder = {
    "bezeichnung",
    "idInformationEingang",
    "idleuAnlage",
    "idleuSchaltkasten",
    "leuModulAllg",
    "leuModulAusgang"
})
public class CLEUModul
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CLEUModulBezeichnung bezeichnung;
    @XmlElement(name = "ID_Information_Eingang")
    protected List<TCIDInformationEingang> idInformationEingang;
    @XmlElement(name = "ID_LEU_Anlage", required = true)
    protected TCIDLEUAnlageOhneProxy idleuAnlage;
    @XmlElement(name = "ID_LEU_Schaltkasten", required = true)
    protected TCIDLEUSchaltkastenOhneProxy idleuSchaltkasten;
    @XmlElement(name = "LEU_Modul_Allg")
    protected CLEUModulAllg leuModulAllg;
    @XmlElement(name = "LEU_Modul_Ausgang", required = true)
    protected List<CLEUModulAusgang> leuModulAusgang;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLEUModulBezeichnung }
     *     
     */
    public CLEUModulBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLEUModulBezeichnung }
     *     
     */
    public void setBezeichnung(CLEUModulBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Gets the value of the idInformationEingang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idInformationEingang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDInformationEingang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDInformationEingang }
     * 
     * 
     */
    public List<TCIDInformationEingang> getIDInformationEingang() {
        if (idInformationEingang == null) {
            idInformationEingang = new ArrayList<TCIDInformationEingang>();
        }
        return this.idInformationEingang;
    }

    /**
     * Ruft den Wert der idleuAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDLEUAnlageOhneProxy }
     *     
     */
    public TCIDLEUAnlageOhneProxy getIDLEUAnlage() {
        return idleuAnlage;
    }

    /**
     * Legt den Wert der idleuAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDLEUAnlageOhneProxy }
     *     
     */
    public void setIDLEUAnlage(TCIDLEUAnlageOhneProxy value) {
        this.idleuAnlage = value;
    }

    /**
     * Ruft den Wert der idleuSchaltkasten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDLEUSchaltkastenOhneProxy }
     *     
     */
    public TCIDLEUSchaltkastenOhneProxy getIDLEUSchaltkasten() {
        return idleuSchaltkasten;
    }

    /**
     * Legt den Wert der idleuSchaltkasten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDLEUSchaltkastenOhneProxy }
     *     
     */
    public void setIDLEUSchaltkasten(TCIDLEUSchaltkastenOhneProxy value) {
        this.idleuSchaltkasten = value;
    }

    /**
     * Ruft den Wert der leuModulAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLEUModulAllg }
     *     
     */
    public CLEUModulAllg getLEUModulAllg() {
        return leuModulAllg;
    }

    /**
     * Legt den Wert der leuModulAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLEUModulAllg }
     *     
     */
    public void setLEUModulAllg(CLEUModulAllg value) {
        this.leuModulAllg = value;
    }

    /**
     * Gets the value of the leuModulAusgang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leuModulAusgang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLEUModulAusgang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CLEUModulAusgang }
     * 
     * 
     */
    public List<CLEUModulAusgang> getLEUModulAusgang() {
        if (leuModulAusgang == null) {
            leuModulAusgang = new ArrayList<CLEUModulAusgang>();
        }
        return this.leuModulAusgang;
    }

}
