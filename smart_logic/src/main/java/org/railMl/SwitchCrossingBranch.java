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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SwitchCrossingBranch complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SwitchCrossingBranch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="branchingSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="joiningSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="netRelationRef" use="required" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="radius" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="length" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwitchCrossingBranch")
public class SwitchCrossingBranch {

    @XmlAttribute(name = "branchingSpeed")
    protected BigDecimal branchingSpeed;
    @XmlAttribute(name = "joiningSpeed")
    protected BigDecimal joiningSpeed;
    @XmlAttribute(name = "netRelationRef", required = true)
    protected String netRelationRef;
    @XmlAttribute(name = "radius")
    protected BigDecimal radius;
    @XmlAttribute(name = "length")
    protected BigDecimal length;

    /**
     * Ruft den Wert der branchingSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBranchingSpeed() {
        return branchingSpeed;
    }

    /**
     * Legt den Wert der branchingSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBranchingSpeed(BigDecimal value) {
        this.branchingSpeed = value;
    }

    /**
     * Ruft den Wert der joiningSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getJoiningSpeed() {
        return joiningSpeed;
    }

    /**
     * Legt den Wert der joiningSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setJoiningSpeed(BigDecimal value) {
        this.joiningSpeed = value;
    }

    /**
     * Ruft den Wert der netRelationRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetRelationRef() {
        return netRelationRef;
    }

    /**
     * Legt den Wert der netRelationRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetRelationRef(String value) {
        this.netRelationRef = value;
    }

    /**
     * Ruft den Wert der radius-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRadius() {
        return radius;
    }

    /**
     * Legt den Wert der radius-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRadius(BigDecimal value) {
        this.radius = value;
    }

    /**
     * Ruft den Wert der length-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Legt den Wert der length-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLength(BigDecimal value) {
        this.length = value;
    }

}
