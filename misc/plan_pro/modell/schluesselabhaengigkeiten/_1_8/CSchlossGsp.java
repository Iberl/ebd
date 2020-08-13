//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.schluesselabhaengigkeiten._1_8;

import modell.verweise._1_8.TCIDWKrGspElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_Gsp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_Gsp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gsp_Lage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}TCGsp_Lage"/>
 *         &lt;element name="ID_Gsp_Element" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_W_Kr_Gsp_Element"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchloss_Gsp", propOrder = {
    "gspLage",
    "idGspElement"
})
public class CSchlossGsp {

    @XmlElement(name = "Gsp_Lage", required = true)
    protected TCGspLage gspLage;
    @XmlElement(name = "ID_Gsp_Element", required = true)
    protected TCIDWKrGspElement idGspElement;

    /**
     * Ruft den Wert der gspLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGspLage }
     *     
     */
    public TCGspLage getGspLage() {
        return gspLage;
    }

    /**
     * Legt den Wert der gspLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGspLage }
     *     
     */
    public void setGspLage(TCGspLage value) {
        this.gspLage = value;
    }

    /**
     * Ruft den Wert der idGspElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDGspElement() {
        return idGspElement;
    }

    /**
     * Legt den Wert der idGspElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDGspElement(TCIDWKrGspElement value) {
        this.idGspElement = value;
    }

}
