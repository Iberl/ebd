//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Abstract element defining the attributes common to movable elements. The movable element refers to TrackAsset, thus creating a link to the IS namespace.
 * 
 * <p>Java-Klasse für MovableElement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MovableElement">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="refersTo" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="hasGaugeClearanceMarker" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="hasTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="connectedToPowerSupply" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="relatedMovableElement" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="maxThrowTime" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="typicalThrowTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="returnsToPreferredPosition" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isKeyLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="numberOfBladeSwitchActuators" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="numberOfFrogSwitchActuators" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovableElement", propOrder = {
    "refersTo",
    "hasGaugeClearanceMarker",
    "hasTvdSection",
    "connectedToPowerSupply",
    "relatedMovableElement"
})
@XmlSeeAlso({
    MovableCrossing.class,
    DerailerIL.class,
    SwitchIL.class
})
public abstract class MovableElement
    extends TrackAsset
{

    @XmlElement(required = true)
    protected EntityILref refersTo;
    protected List<EntityILref> hasGaugeClearanceMarker;
    protected EntityILref hasTvdSection;
    protected EntityILref connectedToPowerSupply;
    protected EntityILref relatedMovableElement;
    @XmlAttribute(name = "maxThrowTime", required = true)
    protected Duration maxThrowTime;
    @XmlAttribute(name = "typicalThrowTime")
    protected Duration typicalThrowTime;
    @XmlAttribute(name = "returnsToPreferredPosition")
    protected Boolean returnsToPreferredPosition;
    @XmlAttribute(name = "isKeyLocked")
    protected Boolean isKeyLocked;
    @XmlAttribute(name = "numberOfBladeSwitchActuators")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfBladeSwitchActuators;
    @XmlAttribute(name = "numberOfFrogSwitchActuators")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfFrogSwitchActuators;

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
     * Gets the value of the hasGaugeClearanceMarker property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasGaugeClearanceMarker property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasGaugeClearanceMarker().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasGaugeClearanceMarker() {
        if (hasGaugeClearanceMarker == null) {
            hasGaugeClearanceMarker = new ArrayList<EntityILref>();
        }
        return this.hasGaugeClearanceMarker;
    }

    /**
     * Ruft den Wert der hasTvdSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getHasTvdSection() {
        return hasTvdSection;
    }

    /**
     * Legt den Wert der hasTvdSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setHasTvdSection(EntityILref value) {
        this.hasTvdSection = value;
    }

    /**
     * Ruft den Wert der connectedToPowerSupply-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getConnectedToPowerSupply() {
        return connectedToPowerSupply;
    }

    /**
     * Legt den Wert der connectedToPowerSupply-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setConnectedToPowerSupply(EntityILref value) {
        this.connectedToPowerSupply = value;
    }

    /**
     * Ruft den Wert der relatedMovableElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRelatedMovableElement() {
        return relatedMovableElement;
    }

    /**
     * Legt den Wert der relatedMovableElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRelatedMovableElement(EntityILref value) {
        this.relatedMovableElement = value;
    }

    /**
     * Ruft den Wert der maxThrowTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMaxThrowTime() {
        return maxThrowTime;
    }

    /**
     * Legt den Wert der maxThrowTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMaxThrowTime(Duration value) {
        this.maxThrowTime = value;
    }

    /**
     * Ruft den Wert der typicalThrowTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTypicalThrowTime() {
        return typicalThrowTime;
    }

    /**
     * Legt den Wert der typicalThrowTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTypicalThrowTime(Duration value) {
        this.typicalThrowTime = value;
    }

    /**
     * Ruft den Wert der returnsToPreferredPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnsToPreferredPosition() {
        return returnsToPreferredPosition;
    }

    /**
     * Legt den Wert der returnsToPreferredPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnsToPreferredPosition(Boolean value) {
        this.returnsToPreferredPosition = value;
    }

    /**
     * Ruft den Wert der isKeyLocked-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsKeyLocked() {
        return isKeyLocked;
    }

    /**
     * Legt den Wert der isKeyLocked-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsKeyLocked(Boolean value) {
        this.isKeyLocked = value;
    }

    /**
     * Ruft den Wert der numberOfBladeSwitchActuators-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfBladeSwitchActuators() {
        return numberOfBladeSwitchActuators;
    }

    /**
     * Legt den Wert der numberOfBladeSwitchActuators-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfBladeSwitchActuators(BigInteger value) {
        this.numberOfBladeSwitchActuators = value;
    }

    /**
     * Ruft den Wert der numberOfFrogSwitchActuators-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfFrogSwitchActuators() {
        return numberOfFrogSwitchActuators;
    }

    /**
     * Legt den Wert der numberOfFrogSwitchActuators-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfFrogSwitchActuators(BigInteger value) {
        this.numberOfFrogSwitchActuators = value;
    }

}
