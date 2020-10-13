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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The logical device applies any number of Boolean equations. It represents e.g. a complex relay circuit or PLC that converts high/low electric input signals from any source into Boolean true/false outputs. It can exchange binary i/o with the interlocking. The description attribute can contain textual description of the field elements and Boolean relations that produce the Boolean output. Use this for ancillary equipment connected to the interlocking, e.g. bascule bridges, tunnel equipment, detectors such as earthquake and flooding detectors. Finally it provides a state which is considered in interlocking operation.
 * 
 * <p>Java-Klasse für LogicalDevice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogicalDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="takesControlOf" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasInterface" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="refersTo" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalDevice", propOrder = {
    "takesControlOf",
    "hasInterface",
    "refersTo"
})
@XmlSeeAlso({
    GenericDetector.class,
    KeyLockIL.class
})
public abstract class LogicalDevice
    extends TrackAsset
{

    protected List<EntityILref> takesControlOf;
    protected EntityILref hasInterface;
    protected EntityILref refersTo;
    @XmlAttribute(name = "description")
    protected String description;

    /**
     * Gets the value of the takesControlOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the takesControlOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTakesControlOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getTakesControlOf() {
        if (takesControlOf == null) {
            takesControlOf = new ArrayList<EntityILref>();
        }
        return this.takesControlOf;
    }

    /**
     * Ruft den Wert der hasInterface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getHasInterface() {
        return hasInterface;
    }

    /**
     * Legt den Wert der hasInterface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setHasInterface(EntityILref value) {
        this.hasInterface = value;
    }

    /**
     * Ruft den Wert der refersTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersTo() {
        return refersTo;
    }

    /**
     * Legt den Wert der refersTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersTo(EntityILref value) {
        this.refersTo = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
