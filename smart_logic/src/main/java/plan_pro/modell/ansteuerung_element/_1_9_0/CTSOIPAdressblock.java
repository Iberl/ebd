//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CTSO_IP_Adressblock complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTSO_IP_Adressblock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IP_Adressblock_Blau_V4" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Blau_V4"/>
 *         &lt;element name="IP_Adressblock_Blau_V6" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Blau_V6"/>
 *         &lt;element name="IP_Adressblock_Grau_V4" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Grau_V4"/>
 *         &lt;element name="IP_Adressblock_Grau_V6" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Grau_V6"/>
 *         &lt;element name="Regionalbereich" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCRegionalbereich"/>
 *         &lt;element name="TSO_IP_AB_Teilsystem" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}CTSO_IP_AB_Teilsystem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTSO_IP_Adressblock", propOrder = {
    "ipAdressblockBlauV4",
    "ipAdressblockBlauV6",
    "ipAdressblockGrauV4",
    "ipAdressblockGrauV6",
    "regionalbereich",
    "tsoipabTeilsystem"
})
public class CTSOIPAdressblock {

    @XmlElement(name = "IP_Adressblock_Blau_V4", required = true)
    protected TCIPAdressblockBlauV4 ipAdressblockBlauV4;
    @XmlElement(name = "IP_Adressblock_Blau_V6", required = true)
    protected TCIPAdressblockBlauV6 ipAdressblockBlauV6;
    @XmlElement(name = "IP_Adressblock_Grau_V4", required = true)
    protected TCIPAdressblockGrauV4 ipAdressblockGrauV4;
    @XmlElement(name = "IP_Adressblock_Grau_V6", required = true)
    protected TCIPAdressblockGrauV6 ipAdressblockGrauV6;
    @XmlElement(name = "Regionalbereich", required = true)
    protected TCRegionalbereich regionalbereich;
    @XmlElement(name = "TSO_IP_AB_Teilsystem")
    protected List<CTSOIPABTeilsystem> tsoipabTeilsystem;

    /**
     * Ruft den Wert der ipAdressblockBlauV4-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockBlauV4 }
     *     
     */
    public TCIPAdressblockBlauV4 getIPAdressblockBlauV4() {
        return ipAdressblockBlauV4;
    }

    /**
     * Legt den Wert der ipAdressblockBlauV4-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockBlauV4 }
     *     
     */
    public void setIPAdressblockBlauV4(TCIPAdressblockBlauV4 value) {
        this.ipAdressblockBlauV4 = value;
    }

    /**
     * Ruft den Wert der ipAdressblockBlauV6-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockBlauV6 }
     *     
     */
    public TCIPAdressblockBlauV6 getIPAdressblockBlauV6() {
        return ipAdressblockBlauV6;
    }

    /**
     * Legt den Wert der ipAdressblockBlauV6-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockBlauV6 }
     *     
     */
    public void setIPAdressblockBlauV6(TCIPAdressblockBlauV6 value) {
        this.ipAdressblockBlauV6 = value;
    }

    /**
     * Ruft den Wert der ipAdressblockGrauV4-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockGrauV4 }
     *     
     */
    public TCIPAdressblockGrauV4 getIPAdressblockGrauV4() {
        return ipAdressblockGrauV4;
    }

    /**
     * Legt den Wert der ipAdressblockGrauV4-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockGrauV4 }
     *     
     */
    public void setIPAdressblockGrauV4(TCIPAdressblockGrauV4 value) {
        this.ipAdressblockGrauV4 = value;
    }

    /**
     * Ruft den Wert der ipAdressblockGrauV6-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockGrauV6 }
     *     
     */
    public TCIPAdressblockGrauV6 getIPAdressblockGrauV6() {
        return ipAdressblockGrauV6;
    }

    /**
     * Legt den Wert der ipAdressblockGrauV6-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockGrauV6 }
     *     
     */
    public void setIPAdressblockGrauV6(TCIPAdressblockGrauV6 value) {
        this.ipAdressblockGrauV6 = value;
    }

    /**
     * Ruft den Wert der regionalbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRegionalbereich }
     *     
     */
    public TCRegionalbereich getRegionalbereich() {
        return regionalbereich;
    }

    /**
     * Legt den Wert der regionalbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRegionalbereich }
     *     
     */
    public void setRegionalbereich(TCRegionalbereich value) {
        this.regionalbereich = value;
    }

    /**
     * Gets the value of the tsoipabTeilsystem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tsoipabTeilsystem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTSOIPABTeilsystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTSOIPABTeilsystem }
     * 
     * 
     */
    public List<CTSOIPABTeilsystem> getTSOIPABTeilsystem() {
        if (tsoipabTeilsystem == null) {
            tsoipabTeilsystem = new ArrayList<CTSOIPABTeilsystem>();
        }
        return this.tsoipabTeilsystem;
    }

}
