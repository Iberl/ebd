//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDPZBElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedingung_PZB complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedingung_PZB">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_PZB_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_PZB_Element"/>
 *         &lt;element name="Wirksam" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCWirksam"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedingung_PZB", propOrder = {
    "idpzbElement",
    "wirksam"
})
public class CBedingungPZB {

    @XmlElement(name = "ID_PZB_Element", required = true)
    protected TCIDPZBElement idpzbElement;
    @XmlElement(name = "Wirksam", required = true)
    protected TCWirksam wirksam;

    /**
     * Ruft den Wert der idpzbElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDPZBElement }
     *     
     */
    public TCIDPZBElement getIDPZBElement() {
        return idpzbElement;
    }

    /**
     * Legt den Wert der idpzbElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDPZBElement }
     *     
     */
    public void setIDPZBElement(TCIDPZBElement value) {
        this.idpzbElement = value;
    }

    /**
     * Ruft den Wert der wirksam-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWirksam }
     *     
     */
    public TCWirksam getWirksam() {
        return wirksam;
    }

    /**
     * Legt den Wert der wirksam-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWirksam }
     *     
     */
    public void setWirksam(TCWirksam value) {
        this.wirksam = value;
    }

}
