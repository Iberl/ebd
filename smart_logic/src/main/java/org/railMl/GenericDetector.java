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
import javax.xml.datatype.Duration;


/**
 * Detectors are devices detecting the exceeding of a particular characteristic and providing an output to the interlocking. Depending on the function it may influence the route signalling.
 * 
 * <p>Java-Klasse für GenericDetector complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericDetector">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}LogicalDevice">
 *       &lt;sequence>
 *         &lt;element name="detectorType" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="affectsRouteSignalling" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="allowsSingleOverride" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="allowsPermanentOverride" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="hasTriggeredSelfTest" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="selfTestToleranceTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="selfTestInterval" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericDetector", propOrder = {
    "detectorType"
})
public class GenericDetector
    extends LogicalDevice
{

    @XmlElement(required = true)
    protected EntityILref detectorType;
    @XmlAttribute(name = "affectsRouteSignalling")
    protected Boolean affectsRouteSignalling;
    @XmlAttribute(name = "allowsSingleOverride")
    protected Boolean allowsSingleOverride;
    @XmlAttribute(name = "allowsPermanentOverride")
    protected Boolean allowsPermanentOverride;
    @XmlAttribute(name = "hasTriggeredSelfTest")
    protected Boolean hasTriggeredSelfTest;
    @XmlAttribute(name = "selfTestToleranceTime")
    protected Duration selfTestToleranceTime;
    @XmlAttribute(name = "selfTestInterval")
    protected Duration selfTestInterval;

    /**
     * Ruft den Wert der detectorType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getDetectorType() {
        return detectorType;
    }

    /**
     * Legt den Wert der detectorType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setDetectorType(EntityILref value) {
        this.detectorType = value;
    }

    /**
     * Ruft den Wert der affectsRouteSignalling-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAffectsRouteSignalling() {
        return affectsRouteSignalling;
    }

    /**
     * Legt den Wert der affectsRouteSignalling-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAffectsRouteSignalling(Boolean value) {
        this.affectsRouteSignalling = value;
    }

    /**
     * Ruft den Wert der allowsSingleOverride-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsSingleOverride() {
        return allowsSingleOverride;
    }

    /**
     * Legt den Wert der allowsSingleOverride-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsSingleOverride(Boolean value) {
        this.allowsSingleOverride = value;
    }

    /**
     * Ruft den Wert der allowsPermanentOverride-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsPermanentOverride() {
        return allowsPermanentOverride;
    }

    /**
     * Legt den Wert der allowsPermanentOverride-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsPermanentOverride(Boolean value) {
        this.allowsPermanentOverride = value;
    }

    /**
     * Ruft den Wert der hasTriggeredSelfTest-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasTriggeredSelfTest() {
        return hasTriggeredSelfTest;
    }

    /**
     * Legt den Wert der hasTriggeredSelfTest-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasTriggeredSelfTest(Boolean value) {
        this.hasTriggeredSelfTest = value;
    }

    /**
     * Ruft den Wert der selfTestToleranceTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSelfTestToleranceTime() {
        return selfTestToleranceTime;
    }

    /**
     * Legt den Wert der selfTestToleranceTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSelfTestToleranceTime(Duration value) {
        this.selfTestToleranceTime = value;
    }

    /**
     * Ruft den Wert der selfTestInterval-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSelfTestInterval() {
        return selfTestInterval;
    }

    /**
     * Legt den Wert der selfTestInterval-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSelfTestInterval(Duration value) {
        this.selfTestInterval = value;
    }

}
