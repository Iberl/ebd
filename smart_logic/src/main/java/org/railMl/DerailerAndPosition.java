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
 * A tuple (derailer, position). Refers to a derailer and a position. Used for expressing concepts like: the derailer has to be in the non-derailing/passable position.
 * 
 * <p>Java-Klasse für DerailerAndPosition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DerailerAndPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToDerailer" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inPosition" use="required" type="{https://www.railml.org/schemas/3.1}tDerailingPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DerailerAndPosition", propOrder = {
    "refersToDerailer"
})
public class DerailerAndPosition
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToDerailer;
    @XmlAttribute(name = "inPosition", required = true)
    protected TDerailingPosition inPosition;

    /**
     * Ruft den Wert der refersToDerailer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToDerailer() {
        return refersToDerailer;
    }

    /**
     * Legt den Wert der refersToDerailer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToDerailer(EntityILref value) {
        this.refersToDerailer = value;
    }

    /**
     * Ruft den Wert der inPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDerailingPosition }
     *     
     */
    public TDerailingPosition getInPosition() {
        return inPosition;
    }

    /**
     * Legt den Wert der inPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDerailingPosition }
     *     
     */
    public void setInPosition(TDerailingPosition value) {
        this.inPosition = value;
    }

}
