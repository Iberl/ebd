//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SignalStopPost complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalStopPost">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}SignalX">
 *       &lt;sequence>
 *         &lt;element name="refersToStoppingPlace" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalStopPost", propOrder = {
    "refersToStoppingPlace"
})
public class SignalStopPost
    extends SignalX
{

    protected TElementWithIDref refersToStoppingPlace;

    /**
     * Ruft den Wert der refersToStoppingPlace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getRefersToStoppingPlace() {
        return refersToStoppingPlace;
    }

    /**
     * Legt den Wert der refersToStoppingPlace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setRefersToStoppingPlace(TElementWithIDref value) {
        this.refersToStoppingPlace = value;
    }

}
