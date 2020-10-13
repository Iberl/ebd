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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * The route is locked, i.e. activated, when this sections turns from vacant to occupied. If the delayForLock timer isn't given (or zero) the lock applies immediately.
 * 
 * <p>Java-Klasse für RouteActivationSection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RouteActivationSection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="activationSection" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="delayForLock" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="automaticReleaseDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteActivationSection", propOrder = {
    "activationSection"
})
public class RouteActivationSection
    extends EntityIL
{

    @XmlElement(required = true)
    protected List<EntityILref> activationSection;
    @XmlAttribute(name = "delayForLock")
    protected Duration delayForLock;
    @XmlAttribute(name = "automaticReleaseDelay")
    protected Duration automaticReleaseDelay;

    /**
     * Gets the value of the activationSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activationSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivationSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getActivationSection() {
        if (activationSection == null) {
            activationSection = new ArrayList<EntityILref>();
        }
        return this.activationSection;
    }

    /**
     * Ruft den Wert der delayForLock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDelayForLock() {
        return delayForLock;
    }

    /**
     * Legt den Wert der delayForLock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDelayForLock(Duration value) {
        this.delayForLock = value;
    }

    /**
     * Ruft den Wert der automaticReleaseDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getAutomaticReleaseDelay() {
        return automaticReleaseDelay;
    }

    /**
     * Legt den Wert der automaticReleaseDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setAutomaticReleaseDelay(Duration value) {
        this.automaticReleaseDelay = value;
    }

}
