//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Energieversorgungsmodul. Einheit, die die Energieversorgung aller Ihr zugeordneten Elemente sicherstellt. Das EV-Modul kann physisch (eigenes Element) oder virtuell (Energie-Abgriff von bestehendem Element) sein.
 * 
 * <p>Java-Klasse f�r CEV_Modul complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEV_Modul">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="EV_Modul_Ausgang" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CEV_Modul_Ausgang" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element name="EV_Modul_Physisch" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CEV_Modul_Physisch"/>
 *           &lt;element name="EV_Modul_Virtuell" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CEV_Modul_Virtuell"/>
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
@XmlType(name = "CEV_Modul", propOrder = {
    "evModulAusgang",
    "evModulPhysisch",
    "evModulVirtuell"
})
public class CEVModul
    extends CBasisObjekt
{

    @XmlElement(name = "EV_Modul_Ausgang", required = true)
    protected List<CEVModulAusgang> evModulAusgang;
    @XmlElement(name = "EV_Modul_Physisch")
    protected CEVModulPhysisch evModulPhysisch;
    @XmlElement(name = "EV_Modul_Virtuell")
    protected CEVModulVirtuell evModulVirtuell;

    /**
     * Gets the value of the evModulAusgang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evModulAusgang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEVModulAusgang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CEVModulAusgang }
     * 
     * 
     */
    public List<CEVModulAusgang> getEVModulAusgang() {
        if (evModulAusgang == null) {
            evModulAusgang = new ArrayList<CEVModulAusgang>();
        }
        return this.evModulAusgang;
    }

    /**
     * Ruft den Wert der evModulPhysisch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CEVModulPhysisch }
     *     
     */
    public CEVModulPhysisch getEVModulPhysisch() {
        return evModulPhysisch;
    }

    /**
     * Legt den Wert der evModulPhysisch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CEVModulPhysisch }
     *     
     */
    public void setEVModulPhysisch(CEVModulPhysisch value) {
        this.evModulPhysisch = value;
    }

    /**
     * Ruft den Wert der evModulVirtuell-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CEVModulVirtuell }
     *     
     */
    public CEVModulVirtuell getEVModulVirtuell() {
        return evModulVirtuell;
    }

    /**
     * Legt den Wert der evModulVirtuell-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CEVModulVirtuell }
     *     
     */
    public void setEVModulVirtuell(CEVModulVirtuell value) {
        this.evModulVirtuell = value;
    }

}
