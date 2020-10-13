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
 * <p>Java-Klasse für EnergyRollingstock complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EnergyRollingstock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="requiresPowerLimitation" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="permittedStaticContactForce" type="{https://www.railml.org/schemas/3.1}tForceN" />
 *       &lt;attribute name="permittedMaxContactForce" type="{https://www.railml.org/schemas/3.1}tForceN" />
 *       &lt;attribute name="requiresAutomaticDroppingDevice" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="requiredFireCategory" type="{https://www.railml.org/schemas/3.1}tRSFireCategoryType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyRollingstock")
public class EnergyRollingstock {

    @XmlAttribute(name = "requiresPowerLimitation")
    protected Boolean requiresPowerLimitation;
    @XmlAttribute(name = "permittedStaticContactForce")
    protected BigDecimal permittedStaticContactForce;
    @XmlAttribute(name = "permittedMaxContactForce")
    protected BigDecimal permittedMaxContactForce;
    @XmlAttribute(name = "requiresAutomaticDroppingDevice")
    protected Boolean requiresAutomaticDroppingDevice;
    @XmlAttribute(name = "requiredFireCategory")
    protected TRSFireCategoryType requiredFireCategory;

    /**
     * Ruft den Wert der requiresPowerLimitation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiresPowerLimitation() {
        return requiresPowerLimitation;
    }

    /**
     * Legt den Wert der requiresPowerLimitation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiresPowerLimitation(Boolean value) {
        this.requiresPowerLimitation = value;
    }

    /**
     * Ruft den Wert der permittedStaticContactForce-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPermittedStaticContactForce() {
        return permittedStaticContactForce;
    }

    /**
     * Legt den Wert der permittedStaticContactForce-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPermittedStaticContactForce(BigDecimal value) {
        this.permittedStaticContactForce = value;
    }

    /**
     * Ruft den Wert der permittedMaxContactForce-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPermittedMaxContactForce() {
        return permittedMaxContactForce;
    }

    /**
     * Legt den Wert der permittedMaxContactForce-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPermittedMaxContactForce(BigDecimal value) {
        this.permittedMaxContactForce = value;
    }

    /**
     * Ruft den Wert der requiresAutomaticDroppingDevice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiresAutomaticDroppingDevice() {
        return requiresAutomaticDroppingDevice;
    }

    /**
     * Legt den Wert der requiresAutomaticDroppingDevice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiresAutomaticDroppingDevice(Boolean value) {
        this.requiresAutomaticDroppingDevice = value;
    }

    /**
     * Ruft den Wert der requiredFireCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TRSFireCategoryType }
     *     
     */
    public TRSFireCategoryType getRequiredFireCategory() {
        return requiredFireCategory;
    }

    /**
     * Legt den Wert der requiredFireCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TRSFireCategoryType }
     *     
     */
    public void setRequiredFireCategory(TRSFireCategoryType value) {
        this.requiredFireCategory = value;
    }

}
