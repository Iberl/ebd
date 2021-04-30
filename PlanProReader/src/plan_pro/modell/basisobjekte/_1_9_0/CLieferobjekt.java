//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDLOEinbau;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Von der SBI geliefertes Objekt. Hier werden alle relevanten Daten des gelieferten Teils der LST-Anlage eingetragen. Das Lieferobjekt muss einen Bezug zu einem bestehenden bzw. geplanten LST-Objekt haben, das es n�her beschreibt.
 * 
 * <p>Java-Klasse f�r CLieferobjekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLieferobjekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Beschreibung" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCBeschreibung"/>
 *         &lt;element name="ID_LO_Einbau" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_LO_Einbau" maxOccurs="unbounded"/>
 *         &lt;element name="LO_Ersatz" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_Ersatz"/>
 *         &lt;element name="LO_Material" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CLO_Material"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLieferobjekt", propOrder = {
    "beschreibung",
    "idloEinbau",
    "loErsatz",
    "loMaterial"
})
public class CLieferobjekt
    extends CBasisObjekt
{

    @XmlElement(name = "Beschreibung", required = true)
    protected TCBeschreibung beschreibung;
    @XmlElement(name = "ID_LO_Einbau", required = true)
    protected List<TCIDLOEinbau> idloEinbau;
    @XmlElement(name = "LO_Ersatz", required = true)
    protected TCLOErsatz loErsatz;
    @XmlElement(name = "LO_Material", required = true)
    protected CLOMaterial loMaterial;

    /**
     * Ruft den Wert der beschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBeschreibung }
     *     
     */
    public TCBeschreibung getBeschreibung() {
        return beschreibung;
    }

    /**
     * Legt den Wert der beschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBeschreibung }
     *     
     */
    public void setBeschreibung(TCBeschreibung value) {
        this.beschreibung = value;
    }

    /**
     * Gets the value of the idloEinbau property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idloEinbau property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDLOEinbau().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDLOEinbau }
     * 
     * 
     */
    public List<TCIDLOEinbau> getIDLOEinbau() {
        if (idloEinbau == null) {
            idloEinbau = new ArrayList<TCIDLOEinbau>();
        }
        return this.idloEinbau;
    }

    /**
     * Ruft den Wert der loErsatz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLOErsatz }
     *     
     */
    public TCLOErsatz getLOErsatz() {
        return loErsatz;
    }

    /**
     * Legt den Wert der loErsatz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLOErsatz }
     *     
     */
    public void setLOErsatz(TCLOErsatz value) {
        this.loErsatz = value;
    }

    /**
     * Ruft den Wert der loMaterial-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLOMaterial }
     *     
     */
    public CLOMaterial getLOMaterial() {
        return loMaterial;
    }

    /**
     * Legt den Wert der loMaterial-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLOMaterial }
     *     
     */
    public void setLOMaterial(CLOMaterial value) {
        this.loMaterial = value;
    }

}
