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
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * One aspect relation has a) one master signal showing a given aspect b) one or more slaves showing a given aspect. The slave aspect depends on the master aspect. c) an optional overlap when the master aspect is at danger. The path from slave to master may contain switches. The switch positions are given in order to unequivocally determine the path.
 * 
 * <p>Java-Klasse für AspectRelation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AspectRelation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="masterAspect" type="{https://www.railml.org/schemas/3.1}SignalAndAspect" minOccurs="0"/>
 *         &lt;element name="slaveAspect" type="{https://www.railml.org/schemas/3.1}SignalAndAspect" minOccurs="0"/>
 *         &lt;element name="distantAspect" type="{https://www.railml.org/schemas/3.1}SignalAndAspect" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="signalsSpeedProfile" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="appliesToRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="passingSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="expectingSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="endSectionTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AspectRelation", propOrder = {
    "masterAspect",
    "slaveAspect",
    "distantAspect",
    "signalsSpeedProfile",
    "appliesToRoute"
})
public class AspectRelation
    extends EntityIL
{

    protected SignalAndAspect masterAspect;
    protected SignalAndAspect slaveAspect;
    protected List<SignalAndAspect> distantAspect;
    protected EntityILref signalsSpeedProfile;
    protected List<EntityILref> appliesToRoute;
    @XmlAttribute(name = "passingSpeed")
    protected BigDecimal passingSpeed;
    @XmlAttribute(name = "expectingSpeed")
    protected BigDecimal expectingSpeed;
    @XmlAttribute(name = "endSectionTime")
    protected Duration endSectionTime;

    /**
     * Ruft den Wert der masterAspect-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalAndAspect }
     *     
     */
    public SignalAndAspect getMasterAspect() {
        return masterAspect;
    }

    /**
     * Legt den Wert der masterAspect-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalAndAspect }
     *     
     */
    public void setMasterAspect(SignalAndAspect value) {
        this.masterAspect = value;
    }

    /**
     * Ruft den Wert der slaveAspect-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalAndAspect }
     *     
     */
    public SignalAndAspect getSlaveAspect() {
        return slaveAspect;
    }

    /**
     * Legt den Wert der slaveAspect-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalAndAspect }
     *     
     */
    public void setSlaveAspect(SignalAndAspect value) {
        this.slaveAspect = value;
    }

    /**
     * Gets the value of the distantAspect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distantAspect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistantAspect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignalAndAspect }
     * 
     * 
     */
    public List<SignalAndAspect> getDistantAspect() {
        if (distantAspect == null) {
            distantAspect = new ArrayList<SignalAndAspect>();
        }
        return this.distantAspect;
    }

    /**
     * Ruft den Wert der signalsSpeedProfile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getSignalsSpeedProfile() {
        return signalsSpeedProfile;
    }

    /**
     * Legt den Wert der signalsSpeedProfile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setSignalsSpeedProfile(EntityILref value) {
        this.signalsSpeedProfile = value;
    }

    /**
     * Gets the value of the appliesToRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliesToRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliesToRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getAppliesToRoute() {
        if (appliesToRoute == null) {
            appliesToRoute = new ArrayList<EntityILref>();
        }
        return this.appliesToRoute;
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
     * Ruft den Wert der expectingSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExpectingSpeed() {
        return expectingSpeed;
    }

    /**
     * Legt den Wert der expectingSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExpectingSpeed(BigDecimal value) {
        this.expectingSpeed = value;
    }

    /**
     * Ruft den Wert der endSectionTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getEndSectionTime() {
        return endSectionTime;
    }

    /**
     * Legt den Wert der endSectionTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setEndSectionTime(Duration value) {
        this.endSectionTime = value;
    }

}
