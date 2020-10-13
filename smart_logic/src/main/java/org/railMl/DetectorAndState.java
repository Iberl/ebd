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
 * The tuple of reference to a detector and its state.
 * 
 * <p>Java-Klasse für DetectorAndState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DetectorAndState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToDetector" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inState" use="required" type="{https://www.railml.org/schemas/3.1}tDetectorStates" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetectorAndState", propOrder = {
    "refersToDetector"
})
public class DetectorAndState
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToDetector;
    @XmlAttribute(name = "inState", required = true)
    protected TDetectorStates inState;

    /**
     * Ruft den Wert der refersToDetector-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToDetector() {
        return refersToDetector;
    }

    /**
     * Legt den Wert der refersToDetector-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToDetector(EntityILref value) {
        this.refersToDetector = value;
    }

    /**
     * Ruft den Wert der inState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDetectorStates }
     *     
     */
    public TDetectorStates getInState() {
        return inState;
    }

    /**
     * Legt den Wert der inState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDetectorStates }
     *     
     */
    public void setInState(TDetectorStates value) {
        this.inState = value;
    }

}
