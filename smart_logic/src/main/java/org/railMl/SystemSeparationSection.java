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
 * <p>Java-Klasse für SystemSeparationSection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SystemSeparationSection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="lengthSystemSeparation" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="switchOffBreaker" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="lowerPantograph" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isSupplySystemChange" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemSeparationSection")
public class SystemSeparationSection {

    @XmlAttribute(name = "lengthSystemSeparation")
    protected BigDecimal lengthSystemSeparation;
    @XmlAttribute(name = "switchOffBreaker")
    protected Boolean switchOffBreaker;
    @XmlAttribute(name = "lowerPantograph")
    protected Boolean lowerPantograph;
    @XmlAttribute(name = "isSupplySystemChange")
    protected Boolean isSupplySystemChange;

    /**
     * Ruft den Wert der lengthSystemSeparation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLengthSystemSeparation() {
        return lengthSystemSeparation;
    }

    /**
     * Legt den Wert der lengthSystemSeparation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLengthSystemSeparation(BigDecimal value) {
        this.lengthSystemSeparation = value;
    }

    /**
     * Ruft den Wert der switchOffBreaker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSwitchOffBreaker() {
        return switchOffBreaker;
    }

    /**
     * Legt den Wert der switchOffBreaker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSwitchOffBreaker(Boolean value) {
        this.switchOffBreaker = value;
    }

    /**
     * Ruft den Wert der lowerPantograph-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLowerPantograph() {
        return lowerPantograph;
    }

    /**
     * Legt den Wert der lowerPantograph-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLowerPantograph(Boolean value) {
        this.lowerPantograph = value;
    }

    /**
     * Ruft den Wert der isSupplySystemChange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSupplySystemChange() {
        return isSupplySystemChange;
    }

    /**
     * Legt den Wert der isSupplySystemChange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSupplySystemChange(Boolean value) {
        this.isSupplySystemChange = value;
    }

}
