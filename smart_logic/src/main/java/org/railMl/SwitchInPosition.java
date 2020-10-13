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
 * reference to any switch and its position inside or outside the restricted area required for use and/or protection
 * 
 * <p>Java-Klasse für SwitchInPosition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SwitchInPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="givenPosition" type="{https://www.railml.org/schemas/3.1}SwitchAndGivenPosition"/>
 *       &lt;/sequence>
 *       &lt;attribute name="protectingSide" type="{https://www.railml.org/schemas/3.1}tProtectingSideList" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwitchInPosition", propOrder = {
    "givenPosition"
})
public class SwitchInPosition
    extends EntityIL
{

    @XmlElement(required = true)
    protected SwitchAndGivenPosition givenPosition;
    @XmlAttribute(name = "protectingSide")
    protected TProtectingSideList protectingSide;

    /**
     * Ruft den Wert der givenPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchAndGivenPosition }
     *     
     */
    public SwitchAndGivenPosition getGivenPosition() {
        return givenPosition;
    }

    /**
     * Legt den Wert der givenPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchAndGivenPosition }
     *     
     */
    public void setGivenPosition(SwitchAndGivenPosition value) {
        this.givenPosition = value;
    }

    /**
     * Ruft den Wert der protectingSide-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TProtectingSideList }
     *     
     */
    public TProtectingSideList getProtectingSide() {
        return protectingSide;
    }

    /**
     * Legt den Wert der protectingSide-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TProtectingSideList }
     *     
     */
    public void setProtectingSide(TProtectingSideList value) {
        this.protectingSide = value;
    }

}
