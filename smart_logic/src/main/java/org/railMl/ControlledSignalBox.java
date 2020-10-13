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
 * The control relation from the controller to a signalBox (interlocking)
 * 
 * <p>Java-Klasse für ControlledSignalBox complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ControlledSignalBox">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="connectedSignalBox" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="extentOfControl" type="{https://www.railml.org/schemas/3.1}tExtentOfControl" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ControlledSignalBox", propOrder = {
    "connectedSignalBox"
})
public class ControlledSignalBox
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref connectedSignalBox;
    @XmlAttribute(name = "extentOfControl")
    protected TExtentOfControl extentOfControl;

    /**
     * Ruft den Wert der connectedSignalBox-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getConnectedSignalBox() {
        return connectedSignalBox;
    }

    /**
     * Legt den Wert der connectedSignalBox-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setConnectedSignalBox(EntityILref value) {
        this.connectedSignalBox = value;
    }

    /**
     * Ruft den Wert der extentOfControl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TExtentOfControl }
     *     
     */
    public TExtentOfControl getExtentOfControl() {
        return extentOfControl;
    }

    /**
     * Legt den Wert der extentOfControl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtentOfControl }
     *     
     */
    public void setExtentOfControl(TExtentOfControl value) {
        this.extentOfControl = value;
    }

}
