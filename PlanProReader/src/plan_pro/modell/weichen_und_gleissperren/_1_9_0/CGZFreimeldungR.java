//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGZ_Freimeldung_R complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGZ_Freimeldung_R">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Element_Lage" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCElement_Lage"/>
 *         &lt;element name="ID_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Element"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGZ_Freimeldung_R", propOrder = {
    "elementLage",
    "idElement"
})
public class CGZFreimeldungR {

    @XmlElement(name = "Element_Lage", required = true)
    protected TCElementLage elementLage;
    @XmlElement(name = "ID_Element", required = true)
    protected TCIDElement idElement;

    /**
     * Ruft den Wert der elementLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElementLage }
     *     
     */
    public TCElementLage getElementLage() {
        return elementLage;
    }

    /**
     * Legt den Wert der elementLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElementLage }
     *     
     */
    public void setElementLage(TCElementLage value) {
        this.elementLage = value;
    }

    /**
     * Ruft den Wert der idElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDElement }
     *     
     */
    public TCIDElement getIDElement() {
        return idElement;
    }

    /**
     * Legt den Wert der idElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDElement }
     *     
     */
    public void setIDElement(TCIDElement value) {
        this.idElement = value;
    }

}
