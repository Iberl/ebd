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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The interface between different interlockings is a special object and differs in the amount of information exchanged between the two.
 * If the interlockings are of different type or from different vendor the interface is often made of parallel data exchange and might use relays.
 * 
 * <p>Java-Klasse für InterlockingInterface complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="InterlockingInterface">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="lastOwnTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="firstRemoteTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="incomingRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="outgoingRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasInterface" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="interfaceLocation" use="required" type="{https://www.railml.org/schemas/3.1}tIxlInterfaceLocationTypeList" />
 *       &lt;attribute name="isOnCommandSide" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterlockingInterface", propOrder = {
    "lastOwnTvdSection",
    "firstRemoteTvdSection",
    "incomingRoute",
    "outgoingRoute",
    "hasInterface"
})
public class InterlockingInterface
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref lastOwnTvdSection;
    @XmlElement(required = true)
    protected EntityILref firstRemoteTvdSection;
    protected List<EntityILref> incomingRoute;
    protected List<EntityILref> outgoingRoute;
    protected EntityILref hasInterface;
    @XmlAttribute(name = "interfaceLocation", required = true)
    protected TIxlInterfaceLocationTypeList interfaceLocation;
    @XmlAttribute(name = "isOnCommandSide")
    protected Boolean isOnCommandSide;

    /**
     * Ruft den Wert der lastOwnTvdSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getLastOwnTvdSection() {
        return lastOwnTvdSection;
    }

    /**
     * Legt den Wert der lastOwnTvdSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setLastOwnTvdSection(EntityILref value) {
        this.lastOwnTvdSection = value;
    }

    /**
     * Ruft den Wert der firstRemoteTvdSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getFirstRemoteTvdSection() {
        return firstRemoteTvdSection;
    }

    /**
     * Legt den Wert der firstRemoteTvdSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setFirstRemoteTvdSection(EntityILref value) {
        this.firstRemoteTvdSection = value;
    }

    /**
     * Gets the value of the incomingRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incomingRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncomingRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getIncomingRoute() {
        if (incomingRoute == null) {
            incomingRoute = new ArrayList<EntityILref>();
        }
        return this.incomingRoute;
    }

    /**
     * Gets the value of the outgoingRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outgoingRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutgoingRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getOutgoingRoute() {
        if (outgoingRoute == null) {
            outgoingRoute = new ArrayList<EntityILref>();
        }
        return this.outgoingRoute;
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
     * Ruft den Wert der interfaceLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TIxlInterfaceLocationTypeList }
     *     
     */
    public TIxlInterfaceLocationTypeList getInterfaceLocation() {
        return interfaceLocation;
    }

    /**
     * Legt den Wert der interfaceLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TIxlInterfaceLocationTypeList }
     *     
     */
    public void setInterfaceLocation(TIxlInterfaceLocationTypeList value) {
        this.interfaceLocation = value;
    }

    /**
     * Ruft den Wert der isOnCommandSide-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOnCommandSide() {
        return isOnCommandSide;
    }

    /**
     * Legt den Wert der isOnCommandSide-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOnCommandSide(Boolean value) {
        this.isOnCommandSide = value;
    }

}
