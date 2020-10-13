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
 * reference to any detector and its state inside or outside the restricted area required for use
 * 
 * <p>Java-Klasse für DetectorInState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DetectorInState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="givenState" type="{https://www.railml.org/schemas/3.1}DetectorAndGivenState"/>
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
@XmlType(name = "DetectorInState", propOrder = {
    "givenState"
})
public class DetectorInState
    extends EntityIL
{

    @XmlElement(required = true)
    protected DetectorAndGivenState givenState;

    /**
     * Ruft den Wert der givenState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DetectorAndGivenState }
     *     
     */
    public DetectorAndGivenState getGivenState() {
        return givenState;
    }

    /**
     * Legt den Wert der givenState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DetectorAndGivenState }
     *     
     */
    public void setGivenState(DetectorAndGivenState value) {
        this.givenState = value;
    }

}
