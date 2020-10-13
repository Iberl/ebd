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
 * <p>Java-Klasse für MaxTrainCurrent complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MaxTrainCurrent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="maxCurrent" type="{https://www.railml.org/schemas/3.1}tCurrentAmpere" />
 *       &lt;attribute name="trainType" type="{https://www.railml.org/schemas/3.1}tOperationalTrainType" />
 *       &lt;attribute name="operationType" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="validFor" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaxTrainCurrent")
public class MaxTrainCurrent {

    @XmlAttribute(name = "maxCurrent")
    protected BigDecimal maxCurrent;
    @XmlAttribute(name = "trainType")
    protected TOperationalTrainType trainType;
    @XmlAttribute(name = "operationType")
    protected Integer operationType;
    @XmlAttribute(name = "validFor")
    protected Integer validFor;

    /**
     * Ruft den Wert der maxCurrent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxCurrent() {
        return maxCurrent;
    }

    /**
     * Legt den Wert der maxCurrent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxCurrent(BigDecimal value) {
        this.maxCurrent = value;
    }

    /**
     * Ruft den Wert der trainType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TOperationalTrainType }
     *     
     */
    public TOperationalTrainType getTrainType() {
        return trainType;
    }

    /**
     * Legt den Wert der trainType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TOperationalTrainType }
     *     
     */
    public void setTrainType(TOperationalTrainType value) {
        this.trainType = value;
    }

    /**
     * Ruft den Wert der operationType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOperationType() {
        return operationType;
    }

    /**
     * Legt den Wert der operationType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOperationType(Integer value) {
        this.operationType = value;
    }

    /**
     * Ruft den Wert der validFor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValidFor() {
        return validFor;
    }

    /**
     * Legt den Wert der validFor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValidFor(Integer value) {
        this.validFor = value;
    }

}
