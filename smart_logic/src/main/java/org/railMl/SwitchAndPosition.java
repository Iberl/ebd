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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A tuple (Switch, position). This refers to a switch and its position.
 * 
 * <p>Java-Klasse für SwitchAndPosition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SwitchAndPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToSwitch" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inPosition" use="required" type="{https://www.railml.org/schemas/3.1}tSwitchPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwitchAndPosition", propOrder = {
    "refersToSwitch"
})
@XmlSeeAlso({
    SwitchRelatedDelay.class
})
public class SwitchAndPosition
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToSwitch;
    @XmlAttribute(name = "inPosition", required = true)
    protected TSwitchPosition inPosition;

    /**
     * Ruft den Wert der refersToSwitch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToSwitch() {
        return refersToSwitch;
    }

    /**
     * Legt den Wert der refersToSwitch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToSwitch(EntityILref value) {
        this.refersToSwitch = value;
    }

    /**
     * Ruft den Wert der inPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSwitchPosition }
     *     
     */
    public TSwitchPosition getInPosition() {
        return inPosition;
    }

    /**
     * Legt den Wert der inPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSwitchPosition }
     *     
     */
    public void setInPosition(TSwitchPosition value) {
        this.inPosition = value;
    }

}
