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


/**
 * <p>Java-Klasse für LinePerformance complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LinePerformance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowedLoadingGauge" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowedWeight" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="maxSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="maxTrainLength" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="usablePlatformLength" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinePerformance", propOrder = {
    "allowedLoadingGauge",
    "allowedWeight"
})
public class LinePerformance {

    protected List<TElementWithIDref> allowedLoadingGauge;
    protected List<TElementWithIDref> allowedWeight;
    @XmlAttribute(name = "maxSpeed")
    protected BigDecimal maxSpeed;
    @XmlAttribute(name = "maxTrainLength")
    protected BigDecimal maxTrainLength;
    @XmlAttribute(name = "usablePlatformLength")
    protected BigDecimal usablePlatformLength;

    /**
     * Gets the value of the allowedLoadingGauge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedLoadingGauge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedLoadingGauge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getAllowedLoadingGauge() {
        if (allowedLoadingGauge == null) {
            allowedLoadingGauge = new ArrayList<TElementWithIDref>();
        }
        return this.allowedLoadingGauge;
    }

    /**
     * Gets the value of the allowedWeight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedWeight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedWeight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getAllowedWeight() {
        if (allowedWeight == null) {
            allowedWeight = new ArrayList<TElementWithIDref>();
        }
        return this.allowedWeight;
    }

    /**
     * Ruft den Wert der maxSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Legt den Wert der maxSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxSpeed(BigDecimal value) {
        this.maxSpeed = value;
    }

    /**
     * Ruft den Wert der maxTrainLength-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxTrainLength() {
        return maxTrainLength;
    }

    /**
     * Legt den Wert der maxTrainLength-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxTrainLength(BigDecimal value) {
        this.maxTrainLength = value;
    }

    /**
     * Ruft den Wert der usablePlatformLength-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUsablePlatformLength() {
        return usablePlatformLength;
    }

    /**
     * Legt den Wert der usablePlatformLength-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUsablePlatformLength(BigDecimal value) {
        this.usablePlatformLength = value;
    }

}
