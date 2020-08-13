//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDOertlichkeitProxy;
import modell.verweise._1_8.TCIDStreckePunkt;

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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Oertlichkeit_Proxy" minOccurs="0"/>
 *         &lt;element name="ID_Strecke_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Strecke_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}COertlichkeit_Allg"/>
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
    "idOertlichkeit",
    "idStreckePunkt",
    "oertlichkeitAllg"
})
public class COertlichkeit
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Oertlichkeit")
    protected TCIDOertlichkeitProxy idOertlichkeit;
    @XmlElement(name = "ID_Strecke_Punkt")
    protected List<TCIDStreckePunkt> idStreckePunkt;
    @XmlElement(name = "Oertlichkeit_Allg", required = true)
    protected COertlichkeitAllg oertlichkeitAllg;

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeitProxy value) {
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
