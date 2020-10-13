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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The exit signal or any other track asset that acts as route exit
 * 
 * <p>Java-Klasse für RouteExit complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RouteExit">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="refersTo" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="hasDangerPoint" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="hasOverlap" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "RouteExit", propOrder = {
    "refersTo",
    "hasDangerPoint",
    "hasOverlap"
})
public class RouteExit
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref refersTo;
    protected EntityILref hasDangerPoint;
    protected List<EntityILref> hasOverlap;

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
     * Ruft den Wert der hasDangerPoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getHasDangerPoint() {
        return hasDangerPoint;
    }

    /**
     * Legt den Wert der hasDangerPoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setHasDangerPoint(EntityILref value) {
        this.hasDangerPoint = value;
    }

    /**
     * Gets the value of the hasOverlap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasOverlap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasOverlap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasOverlap() {
        if (hasOverlap == null) {
            hasOverlap = new ArrayList<EntityILref>();
        }
        return this.hasOverlap;
    }

}
