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


/**
 * <p>Java-Klasse f�r CETCS_Adresse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Adresse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ETCS_Kennung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Kennung"/>
 *         &lt;element name="NID_C" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCNID_C"/>
 *         &lt;element name="NID_RBC" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCNID_RBC"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Adresse", propOrder = {
    "etcsKennung",
    "nidc",
    "nidrbc"
})
public class CETCSAdresse {

    @XmlElement(name = "ETCS_Kennung", required = true)
    protected TCETCSKennung etcsKennung;
    @XmlElement(name = "NID_C", required = true)
    protected TCNIDC nidc;
    @XmlElement(name = "NID_RBC", required = true)
    protected TCNIDRBC nidrbc;

    /**
     * Ruft den Wert der etcsKennung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSKennung }
     *     
     */
    public TCETCSKennung getETCSKennung() {
        return etcsKennung;
    }

    /**
     * Legt den Wert der etcsKennung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSKennung }
     *     
     */
    public void setETCSKennung(TCETCSKennung value) {
        this.etcsKennung = value;
    }

    /**
     * Ruft den Wert der nidc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNIDC }
     *     
     */
    public TCNIDC getNIDC() {
        return nidc;
    }

    /**
     * Legt den Wert der nidc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNIDC }
     *     
     */
    public void setNIDC(TCNIDC value) {
        this.nidc = value;
    }

    /**
     * Ruft den Wert der nidrbc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNIDRBC }
     *     
     */
    public TCNIDRBC getNIDRBC() {
        return nidrbc;
    }

    /**
     * Legt den Wert der nidrbc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNIDRBC }
     *     
     */
    public void setNIDRBC(TCNIDRBC value) {
        this.nidrbc = value;
    }

}
