//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A tuple of Level Crossing and its position.
 * 
 * <p>Java-Klasse f�r LevelCrossingAndState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingAndState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToLevelCrossing" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inState" use="required" type="{https://www.railml.org/schemas/3.1}tLevelCrossingState" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelCrossingAndState", propOrder = {
    "refersToLevelCrossing"
})
public class LevelCrossingAndState
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToLevelCrossing;
    @XmlAttribute(name = "inState", required = true)
    protected TLevelCrossingState inState;

    /**
     * Ruft den Wert der refersToLevelCrossing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToLevelCrossing() {
        return refersToLevelCrossing;
    }

    /**
     * Legt den Wert der refersToLevelCrossing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToLevelCrossing(EntityILref value) {
        this.refersToLevelCrossing = value;
    }

    /**
     * Ruft den Wert der inState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLevelCrossingState }
     *     
     */
    public TLevelCrossingState getInState() {
        return inState;
    }

    /**
     * Legt den Wert der inState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevelCrossingState }
     *     
     */
    public void setInState(TLevelCrossingState value) {
        this.inState = value;
    }

}