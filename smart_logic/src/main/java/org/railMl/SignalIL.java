//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * A signal has an identity attribute, a reference to a signal or sign defined in the RTM scheme. A sign (or ETCS markerboard) indicating a speed change may well be modelled as a signal because the interlocking is likely to issue a different speed code at that sign
 * 
 * <p>Java-Klasse für SignalIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="refersTo" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="protectsBlockExit" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="releaseSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="malfunctionSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="approachSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="passingSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="releaseDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="function" type="{https://www.railml.org/schemas/3.1}tSignalFunctionListExt" />
 *       &lt;attribute name="isVirtual" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="callOnAspectTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="sightDistance" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalIL", propOrder = {
    "refersTo",
    "protectsBlockExit"
})
public class SignalIL
    extends TrackAsset
{

    @XmlElement(required = true)
    protected EntityILref refersTo;
    protected EntityILref protectsBlockExit;
    @XmlAttribute(name = "releaseSpeed")
    protected BigDecimal releaseSpeed;
    @XmlAttribute(name = "malfunctionSpeed")
    protected BigDecimal malfunctionSpeed;
    @XmlAttribute(name = "approachSpeed")
    protected BigDecimal approachSpeed;
    @XmlAttribute(name = "passingSpeed")
    protected BigDecimal passingSpeed;
    @XmlAttribute(name = "releaseDelay")
    protected Duration releaseDelay;
    @XmlAttribute(name = "function")
    protected String function;
    @XmlAttribute(name = "isVirtual", required = true)
    protected boolean isVirtual;
    @XmlAttribute(name = "callOnAspectTime")
    protected Duration callOnAspectTime;
    @XmlAttribute(name = "sightDistance")
    protected BigDecimal sightDistance;

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
     * Ruft den Wert der protectsBlockExit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getProtectsBlockExit() {
        return protectsBlockExit;
    }

    /**
     * Legt den Wert der protectsBlockExit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setProtectsBlockExit(EntityILref value) {
        this.protectsBlockExit = value;
    }

    /**
     * Ruft den Wert der releaseSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReleaseSpeed() {
        return releaseSpeed;
    }

    /**
     * Legt den Wert der releaseSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReleaseSpeed(BigDecimal value) {
        this.releaseSpeed = value;
    }

    /**
     * Ruft den Wert der malfunctionSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMalfunctionSpeed() {
        return malfunctionSpeed;
    }

    /**
     * Legt den Wert der malfunctionSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMalfunctionSpeed(BigDecimal value) {
        this.malfunctionSpeed = value;
    }

    /**
     * Ruft den Wert der approachSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getApproachSpeed() {
        return approachSpeed;
    }

    /**
     * Legt den Wert der approachSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setApproachSpeed(BigDecimal value) {
        this.approachSpeed = value;
    }

    /**
     * Ruft den Wert der passingSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPassingSpeed() {
        return passingSpeed;
    }

    /**
     * Legt den Wert der passingSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPassingSpeed(BigDecimal value) {
        this.passingSpeed = value;
    }

    /**
     * Ruft den Wert der releaseDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getReleaseDelay() {
        return releaseDelay;
    }

    /**
     * Legt den Wert der releaseDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setReleaseDelay(Duration value) {
        this.releaseDelay = value;
    }

    /**
     * Ruft den Wert der function-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunction() {
        return function;
    }

    /**
     * Legt den Wert der function-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunction(String value) {
        this.function = value;
    }

    /**
     * Ruft den Wert der isVirtual-Eigenschaft ab.
     * 
     */
    public boolean isIsVirtual() {
        return isVirtual;
    }

    /**
     * Legt den Wert der isVirtual-Eigenschaft fest.
     * 
     */
    public void setIsVirtual(boolean value) {
        this.isVirtual = value;
    }

    /**
     * Ruft den Wert der callOnAspectTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getCallOnAspectTime() {
        return callOnAspectTime;
    }

    /**
     * Legt den Wert der callOnAspectTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setCallOnAspectTime(Duration value) {
        this.callOnAspectTime = value;
    }

    /**
     * Ruft den Wert der sightDistance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSightDistance() {
        return sightDistance;
    }

    /**
     * Legt den Wert der sightDistance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSightDistance(BigDecimal value) {
        this.sightDistance = value;
    }

}
