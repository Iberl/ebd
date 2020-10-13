//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SignalMilepost complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalMilepost">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}SignalX">
 *       &lt;sequence>
 *         &lt;element name="refersToLine" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="shownValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalMilepost", propOrder = {
    "refersToLine"
})
public class SignalMilepost
    extends SignalX
{

    protected TElementWithIDref refersToLine;
    @XmlAttribute(name = "shownValue")
    protected String shownValue;

    /**
     * Ruft den Wert der refersToLine-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getRefersToLine() {
        return refersToLine;
    }

    /**
     * Legt den Wert der refersToLine-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setRefersToLine(TElementWithIDref value) {
        this.refersToLine = value;
    }

    /**
     * Ruft den Wert der shownValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShownValue() {
        return shownValue;
    }

    /**
     * Legt den Wert der shownValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShownValue(String value) {
        this.shownValue = value;
    }

}
