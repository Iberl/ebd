//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * A level crossing (LX) is activated, i.e. requested to close for road traffic, upon train approach. This happens when the train crosses a detection point, i.e. an insulated track joint, axle counter or treadle. These approach detectors are commonly referred to as Approach Starting (AS).
 * 
 * <p>Java-Klasse für LevelCrossingIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="hasInterface" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="isLevelCrossingType" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="refersTo" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="deactivatedBy" type="{https://www.railml.org/schemas/3.1}LevelCrossingDeactivator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="activationCondition" type="{https://www.railml.org/schemas/3.1}ActivationCondition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="preferredPosition" type="{https://www.railml.org/schemas/3.1}tLevelCrossingState" />
 *       &lt;attribute name="unprotectedSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="typicalTimeToClose" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="constantWarningTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="minimumOpenTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="maximumClosedTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="requiresStopBeforeUnprotectedLevelCrossing" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelCrossingIL", propOrder = {
    "hasInterface",
    "isLevelCrossingType",
    "refersTo",
    "deactivatedBy",
    "activationCondition",
    "hasTvdSection"
})
public class LevelCrossingIL
    extends TrackAsset
{

    protected EntityILref hasInterface;
    @XmlElement(required = true)
    protected EntityILref isLevelCrossingType;
    @XmlElement(required = true)
    protected EntityILref refersTo;
    protected List<LevelCrossingDeactivator> deactivatedBy;
    protected List<ActivationCondition> activationCondition;
    protected List<EntityILref> hasTvdSection;
    @XmlAttribute(name = "preferredPosition")
    protected TLevelCrossingState preferredPosition;
    @XmlAttribute(name = "unprotectedSpeed")
    protected BigDecimal unprotectedSpeed;
    @XmlAttribute(name = "typicalTimeToClose", required = true)
    protected Duration typicalTimeToClose;
    @XmlAttribute(name = "constantWarningTime")
    protected Duration constantWarningTime;
    @XmlAttribute(name = "minimumOpenTime")
    protected Duration minimumOpenTime;
    @XmlAttribute(name = "maximumClosedTime")
    protected Duration maximumClosedTime;
    @XmlAttribute(name = "requiresStopBeforeUnprotectedLevelCrossing")
    protected Boolean requiresStopBeforeUnprotectedLevelCrossing;

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
     * Ruft den Wert der isLevelCrossingType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getIsLevelCrossingType() {
        return isLevelCrossingType;
    }

    /**
     * Legt den Wert der isLevelCrossingType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setIsLevelCrossingType(EntityILref value) {
        this.isLevelCrossingType = value;
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
     * Gets the value of the deactivatedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deactivatedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeactivatedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelCrossingDeactivator }
     * 
     * 
     */
    public List<LevelCrossingDeactivator> getDeactivatedBy() {
        if (deactivatedBy == null) {
            deactivatedBy = new ArrayList<LevelCrossingDeactivator>();
        }
        return this.deactivatedBy;
    }

    /**
     * Gets the value of the activationCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activationCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivationCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivationCondition }
     * 
     * 
     */
    public List<ActivationCondition> getActivationCondition() {
        if (activationCondition == null) {
            activationCondition = new ArrayList<ActivationCondition>();
        }
        return this.activationCondition;
    }

    /**
     * Gets the value of the hasTvdSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasTvdSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasTvdSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasTvdSection() {
        if (hasTvdSection == null) {
            hasTvdSection = new ArrayList<EntityILref>();
        }
        return this.hasTvdSection;
    }

    /**
     * Ruft den Wert der preferredPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLevelCrossingState }
     *     
     */
    public TLevelCrossingState getPreferredPosition() {
        return preferredPosition;
    }

    /**
     * Legt den Wert der preferredPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevelCrossingState }
     *     
     */
    public void setPreferredPosition(TLevelCrossingState value) {
        this.preferredPosition = value;
    }

    /**
     * Ruft den Wert der unprotectedSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnprotectedSpeed() {
        return unprotectedSpeed;
    }

    /**
     * Legt den Wert der unprotectedSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnprotectedSpeed(BigDecimal value) {
        this.unprotectedSpeed = value;
    }

    /**
     * Ruft den Wert der typicalTimeToClose-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTypicalTimeToClose() {
        return typicalTimeToClose;
    }

    /**
     * Legt den Wert der typicalTimeToClose-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTypicalTimeToClose(Duration value) {
        this.typicalTimeToClose = value;
    }

    /**
     * Ruft den Wert der constantWarningTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getConstantWarningTime() {
        return constantWarningTime;
    }

    /**
     * Legt den Wert der constantWarningTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setConstantWarningTime(Duration value) {
        this.constantWarningTime = value;
    }

    /**
     * Ruft den Wert der minimumOpenTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMinimumOpenTime() {
        return minimumOpenTime;
    }

    /**
     * Legt den Wert der minimumOpenTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMinimumOpenTime(Duration value) {
        this.minimumOpenTime = value;
    }

    /**
     * Ruft den Wert der maximumClosedTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMaximumClosedTime() {
        return maximumClosedTime;
    }

    /**
     * Legt den Wert der maximumClosedTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMaximumClosedTime(Duration value) {
        this.maximumClosedTime = value;
    }

    /**
     * Ruft den Wert der requiresStopBeforeUnprotectedLevelCrossing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiresStopBeforeUnprotectedLevelCrossing() {
        return requiresStopBeforeUnprotectedLevelCrossing;
    }

    /**
     * Legt den Wert der requiresStopBeforeUnprotectedLevelCrossing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiresStopBeforeUnprotectedLevelCrossing(Boolean value) {
        this.requiresStopBeforeUnprotectedLevelCrossing = value;
    }

}
