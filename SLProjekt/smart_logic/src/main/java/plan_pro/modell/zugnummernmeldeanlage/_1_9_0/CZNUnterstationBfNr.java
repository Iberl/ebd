//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeitProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_Unterstation_Bf_Nr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Unterstation_Bf_Nr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bf_Nr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCBf_Nr"/>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy"/>
 *         &lt;element name="Prioritaet" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCPrioritaet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Unterstation_Bf_Nr", propOrder = {
    "bfNr",
    "idOertlichkeit",
    "prioritaet"
})
public class CZNUnterstationBfNr {

    @XmlElement(name = "Bf_Nr", required = true)
    protected TCBfNr bfNr;
    @XmlElement(name = "ID_Oertlichkeit", required = true)
    protected TCIDOertlichkeitProxy idOertlichkeit;
    @XmlElement(name = "Prioritaet")
    protected TCPrioritaet prioritaet;

    /**
     * Ruft den Wert der bfNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBfNr }
     *     
     */
    public TCBfNr getBfNr() {
        return bfNr;
    }

    /**
     * Legt den Wert der bfNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBfNr }
     *     
     */
    public void setBfNr(TCBfNr value) {
        this.bfNr = value;
    }

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
