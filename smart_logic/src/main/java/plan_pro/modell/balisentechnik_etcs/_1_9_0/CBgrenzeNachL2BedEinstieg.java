//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDWKrGspElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBgrenze_Nach_L2_Bed_Einstieg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBgrenze_Nach_L2_Bed_Einstieg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_W_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Gsp_Element"/>
 *         &lt;element name="W_Lage" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCW_Lage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBgrenze_Nach_L2_Bed_Einstieg", propOrder = {
    "idwElement",
    "wLage"
})
public class CBgrenzeNachL2BedEinstieg {

    @XmlElement(name = "ID_W_Element", required = true)
    protected TCIDWKrGspElement idwElement;
    @XmlElement(name = "W_Lage", required = true)
    protected TCWLage wLage;

    /**
     * Ruft den Wert der idwElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDWElement() {
        return idwElement;
    }

    /**
     * Legt den Wert der idwElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDWElement(TCIDWKrGspElement value) {
        this.idwElement = value;
    }

    /**
     * Ruft den Wert der wLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWLage }
     *     
     */
    public TCWLage getWLage() {
        return wLage;
    }

    /**
     * Legt den Wert der wLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWLage }
     *     
     */
    public void setWLage(TCWLage value) {
        this.wLage = value;
    }

}
