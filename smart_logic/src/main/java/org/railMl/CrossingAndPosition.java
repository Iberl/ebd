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
import jakarta.xml.bind.annotation.XmlType;


/**
 * Tuple of crossing element and its (logical) position.
 * 
 * <p>Java-Klasse für CrossingAndPosition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CrossingAndPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToCrossing" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inPosition" use="required" type="{https://www.railml.org/schemas/3.1}tCrossingPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrossingAndPosition", propOrder = {
    "refersToCrossing"
})
public class CrossingAndPosition
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToCrossing;
    @XmlAttribute(name = "inPosition", required = true)
    protected TCrossingPosition inPosition;

    /**
     * Ruft den Wert der refersToCrossing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToCrossing() {
        return refersToCrossing;
    }

    /**
     * Legt den Wert der refersToCrossing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToCrossing(EntityILref value) {
        this.refersToCrossing = value;
    }

    /**
     * Ruft den Wert der inPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCrossingPosition }
     *     
     */
    public TCrossingPosition getInPosition() {
        return inPosition;
    }

    /**
     * Legt den Wert der inPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCrossingPosition }
     *     
     */
    public void setInPosition(TCrossingPosition value) {
        this.inPosition = value;
    }

}
