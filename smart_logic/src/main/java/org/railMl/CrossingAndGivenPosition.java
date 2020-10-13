//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * the tuple of references to the movable crossing and its position plus the level of enforcement
 * 
 * <p>Java-Klasse für CrossingAndGivenPosition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CrossingAndGivenPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndGivenState">
 *       &lt;sequence>
 *         &lt;element name="relatedCrossingAndPosition" type="{https://www.railml.org/schemas/3.1}CrossingAndPosition"/>
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
@XmlType(name = "CrossingAndGivenPosition", propOrder = {
    "relatedCrossingAndPosition"
})
public class CrossingAndGivenPosition
    extends AssetAndGivenState
{

    @XmlElement(required = true)
    protected CrossingAndPosition relatedCrossingAndPosition;

    /**
     * Ruft den Wert der relatedCrossingAndPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CrossingAndPosition }
     *     
     */
    public CrossingAndPosition getRelatedCrossingAndPosition() {
        return relatedCrossingAndPosition;
    }

    /**
     * Legt den Wert der relatedCrossingAndPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossingAndPosition }
     *     
     */
    public void setRelatedCrossingAndPosition(CrossingAndPosition value) {
        this.relatedCrossingAndPosition = value;
    }

}
