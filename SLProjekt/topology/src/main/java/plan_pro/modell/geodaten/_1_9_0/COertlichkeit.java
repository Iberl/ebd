//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeit;
import plan_pro.modell.verweise._1_9_0.TCIDStreckePunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Bahnanlagen und Betriebsstellen des Netzes. Die �rtlichkeit muss eine g�ltige Bezeichnung nach Ril 100 beinhalten und kann mittels ID Strecke Punkt mehreren Strecken mit Bezugskilometer zugeordnet sein. DB-Regelwerk Richtlinie 100.0001 Abschnitt 1 (1) 
 * 
 * <p>Java-Klasse f�r COertlichkeit complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="COertlichkeit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}COertlichkeit_Bezeichnung"/>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit" minOccurs="0"/>
 *         &lt;element name="ID_Strecke_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Strecke_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}COertlichkeit_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COertlichkeit", propOrder = {
    "bezeichnung",
    "idOertlichkeit",
    "idStreckePunkt",
    "oertlichkeitAllg"
})
public class COertlichkeit
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected COertlichkeitBezeichnung bezeichnung;
    @XmlElement(name = "ID_Oertlichkeit")
    protected TCIDOertlichkeit idOertlichkeit;
    @XmlElement(name = "ID_Strecke_Punkt")
    protected List<TCIDStreckePunkt> idStreckePunkt;
    @XmlElement(name = "Oertlichkeit_Allg", required = true)
    protected COertlichkeitAllg oertlichkeitAllg;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link COertlichkeitBezeichnung }
     *     
     */
    public COertlichkeitBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link COertlichkeitBezeichnung }
     *     
     */
    public void setBezeichnung(COertlichkeitBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeit }
     *     
     */
    public TCIDOertlichkeit getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeit }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeit value) {
        this.idOertlichkeit = value;
    }

    /**
     * Gets the value of the idStreckePunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idStreckePunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDStreckePunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDStreckePunkt }
     * 
     * 
     */
    public List<TCIDStreckePunkt> getIDStreckePunkt() {
        if (idStreckePunkt == null) {
            idStreckePunkt = new ArrayList<TCIDStreckePunkt>();
        }
        return this.idStreckePunkt;
    }

    /**
     * Ruft den Wert der oertlichkeitAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link COertlichkeitAllg }
     *     
     */
    public COertlichkeitAllg getOertlichkeitAllg() {
        return oertlichkeitAllg;
    }

    /**
     * Legt den Wert der oertlichkeitAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link COertlichkeitAllg }
     *     
     */
    public void setOertlichkeitAllg(COertlichkeitAllg value) {
        this.oertlichkeitAllg = value;
    }

}
