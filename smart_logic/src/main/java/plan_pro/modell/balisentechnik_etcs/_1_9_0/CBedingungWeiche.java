//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDWKrGspElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedingung_Weiche complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedingung_Weiche">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bedingung_Weichenlage" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBedingung_Weichenlage"/>
 *         &lt;element name="ID_W_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Gsp_Element"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedingung_Weiche", propOrder = {
    "bedingungWeichenlage",
    "idwElement"
})
public class CBedingungWeiche {

    @XmlElement(name = "Bedingung_Weichenlage", required = true)
    protected TCBedingungWeichenlage bedingungWeichenlage;
    @XmlElement(name = "ID_W_Element", required = true)
    protected TCIDWKrGspElement idwElement;

    /**
     * Ruft den Wert der bedingungWeichenlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedingungWeichenlage }
     *     
     */
    public TCBedingungWeichenlage getBedingungWeichenlage() {
        return bedingungWeichenlage;
    }

    /**
     * Legt den Wert der bedingungWeichenlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedingungWeichenlage }
     *     
     */
    public void setBedingungWeichenlage(TCBedingungWeichenlage value) {
        this.bedingungWeichenlage = value;
    }

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

}
