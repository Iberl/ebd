//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r SignalLevelCrossing complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalLevelCrossing">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}SignalX">
 *       &lt;sequence>
 *         &lt;element name="refersToLevelCrossing" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{https://www.railml.org/schemas/3.1}tSignalLevelCrossingType" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalLevelCrossing", propOrder = {
    "refersToLevelCrossing"
})
public class SignalLevelCrossing
    extends SignalX
{

    @XmlElement(required = true)
    protected List<TElementWithIDref> refersToLevelCrossing;
    @XmlAttribute(name = "type", required = true)
    protected TSignalLevelCrossingType type;

    /**
     * Gets the value of the refersToLevelCrossing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refersToLevelCrossing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefersToLevelCrossing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getRefersToLevelCrossing() {
        if (refersToLevelCrossing == null) {
            refersToLevelCrossing = new ArrayList<TElementWithIDref>();
        }
        return this.refersToLevelCrossing;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSignalLevelCrossingType }
     *     
     */
    public TSignalLevelCrossingType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSignalLevelCrossingType }
     *     
     */
    public void setType(TSignalLevelCrossingType value) {
        this.type = value;
    }

}
