//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDLEUBezugspunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Elektronische Einheit zur Ansteuerung der Eurobalisen mit Balisentelegrammen in Abh�ngigkeit von Eingangsinformationen (Signalbegriffe, Weichenlagen etc.). Die LEU-Anlage besteht ggf. aus mehreren Schaltk�sten, die mehrere LEU-Module enthalten k�nnen.
 * 
 * <p>Java-Klasse f�r CLEU_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Anlage_Bezeichnung"/>
 *         &lt;element name="ID_LEU_Bezugspunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_LEU_Bezugspunkt"/>
 *         &lt;element name="LEU_Anlage_Moduleigenschaften" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Anlage_Moduleigenschaften" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Anlage", propOrder = {
    "bezeichnung",
    "idleuBezugspunkt",
    "leuAnlageModuleigenschaften"
})
public class CLEUAnlage
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CLEUAnlageBezeichnung bezeichnung;
    @XmlElement(name = "ID_LEU_Bezugspunkt", required = true)
    protected TCIDLEUBezugspunkt idleuBezugspunkt;
    @XmlElement(name = "LEU_Anlage_Moduleigenschaften")
    protected List<CLEUAnlageModuleigenschaften> leuAnlageModuleigenschaften;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLEUAnlageBezeichnung }
     *     
     */
    public CLEUAnlageBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLEUAnlageBezeichnung }
     *     
     */
    public void setBezeichnung(CLEUAnlageBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idleuBezugspunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDLEUBezugspunkt }
     *     
     */
    public TCIDLEUBezugspunkt getIDLEUBezugspunkt() {
        return idleuBezugspunkt;
    }

    /**
     * Legt den Wert der idleuBezugspunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDLEUBezugspunkt }
     *     
     */
    public void setIDLEUBezugspunkt(TCIDLEUBezugspunkt value) {
        this.idleuBezugspunkt = value;
    }

    /**
     * Gets the value of the leuAnlageModuleigenschaften property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leuAnlageModuleigenschaften property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLEUAnlageModuleigenschaften().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CLEUAnlageModuleigenschaften }
     * 
     * 
     */
    public List<CLEUAnlageModuleigenschaften> getLEUAnlageModuleigenschaften() {
        if (leuAnlageModuleigenschaften == null) {
            leuAnlageModuleigenschaften = new ArrayList<CLEUAnlageModuleigenschaften>();
        }
        return this.leuAnlageModuleigenschaften;
    }

}
