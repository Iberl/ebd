//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CZUB_Bereichsgrenze_Nach_PZB complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Bereichsgrenze_Nach_PZB">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bgrenze_Nach_PZB_Bed_Einstieg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBgrenze_Nach_PZB_Bed_Einstieg" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Harter_Ausstieg_Aus_L2" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCHarter_Ausstieg_Aus_L2" minOccurs="0"/>
 *         &lt;element name="Prioritaet" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCPrioritaet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZUB_Bereichsgrenze_Nach_PZB", propOrder = {
    "bgrenzeNachPZBBedEinstieg",
    "harterAusstiegAusL2",
    "prioritaet"
})
public class CZUBBereichsgrenzeNachPZB {

    @XmlElement(name = "Bgrenze_Nach_PZB_Bed_Einstieg")
    protected List<CBgrenzeNachPZBBedEinstieg> bgrenzeNachPZBBedEinstieg;
    @XmlElement(name = "Harter_Ausstieg_Aus_L2")
    protected TCHarterAusstiegAusL2 harterAusstiegAusL2;
    @XmlElement(name = "Prioritaet")
    protected TCPrioritaet prioritaet;

    /**
     * Gets the value of the bgrenzeNachPZBBedEinstieg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bgrenzeNachPZBBedEinstieg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBgrenzeNachPZBBedEinstieg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBgrenzeNachPZBBedEinstieg }
     * 
     * 
     */
    public List<CBgrenzeNachPZBBedEinstieg> getBgrenzeNachPZBBedEinstieg() {
        if (bgrenzeNachPZBBedEinstieg == null) {
            bgrenzeNachPZBBedEinstieg = new ArrayList<CBgrenzeNachPZBBedEinstieg>();
        }
        return this.bgrenzeNachPZBBedEinstieg;
    }

    /**
     * Ruft den Wert der harterAusstiegAusL2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHarterAusstiegAusL2 }
     *     
     */
    public TCHarterAusstiegAusL2 getHarterAusstiegAusL2() {
        return harterAusstiegAusL2;
    }

    /**
     * Legt den Wert der harterAusstiegAusL2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHarterAusstiegAusL2 }
     *     
     */
    public void setHarterAusstiegAusL2(TCHarterAusstiegAusL2 value) {
        this.harterAusstiegAusL2 = value;
    }

    /**
     * Ruft den Wert der prioritaet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPrioritaet }
     *     
     */
    public TCPrioritaet getPrioritaet() {
        return prioritaet;
    }

    /**
     * Legt den Wert der prioritaet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPrioritaet }
     *     
     */
    public void setPrioritaet(TCPrioritaet value) {
        this.prioritaet = value;
    }

}
