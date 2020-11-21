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
 * <p>Java-Klasse f�r CZiel_W_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZiel_W_Element">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Ziel_W_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Gsp_Element"/>
 *         &lt;element name="W_Anschluss" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCW_Anschluss" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZiel_W_Element", propOrder = {
    "idZielWElement",
    "wAnschluss"
})
public class CZielWElement {

    @XmlElement(name = "ID_Ziel_W_Element", required = true)
    protected TCIDWKrGspElement idZielWElement;
    @XmlElement(name = "W_Anschluss")
    protected TCWAnschluss wAnschluss;

    /**
     * Ruft den Wert der idZielWElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDZielWElement() {
        return idZielWElement;
    }

    /**
     * Legt den Wert der idZielWElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDZielWElement(TCIDWKrGspElement value) {
        this.idZielWElement = value;
    }

    /**
     * Ruft den Wert der wAnschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWAnschluss }
     *     
     */
    public TCWAnschluss getWAnschluss() {
        return wAnschluss;
    }

    /**
     * Legt den Wert der wAnschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWAnschluss }
     *     
     */
    public void setWAnschluss(TCWAnschluss value) {
        this.wAnschluss = value;
    }

}
