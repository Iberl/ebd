//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A tuple (signal, aspect). Refers to a signal and an aspect. Used for expressing concepts like signal 1105 shows yellow flashing.
 * 
 * <p>Java-Klasse für SignalAndAspect complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalAndAspect">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToSignal" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="showsAspect" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
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
@XmlType(name = "SignalAndAspect", propOrder = {
    "refersToSignal",
    "showsAspect"
})
@XmlSeeAlso({
    AspectRelatedLevelCrossingDelay.class
})
public class SignalAndAspect
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToSignal;
    @XmlElement(required = true)
    protected List<EntityILref> showsAspect;

    /**
     * Ruft den Wert der refersToSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToSignal() {
        return refersToSignal;
    }

    /**
     * Legt den Wert der refersToSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToSignal(EntityILref value) {
        this.refersToSignal = value;
    }

    /**
     * Gets the value of the showsAspect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the showsAspect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShowsAspect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getShowsAspect() {
        if (showsAspect == null) {
            showsAspect = new ArrayList<EntityILref>();
        }
        return this.showsAspect;
    }

}
