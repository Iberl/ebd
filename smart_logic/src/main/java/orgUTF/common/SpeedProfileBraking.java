//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpeedProfileBraking complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpeedProfileBraking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="brakeType" type="{https://www.railml.org/schemas/3.1}tBrakeTypeExt" />
 *       &lt;attribute name="airBrakeApplicationPosition" type="{https://www.railml.org/schemas/3.1}tAirBrakeApplicationDirection" />
 *       &lt;attribute name="minBrakePercentage" type="{https://www.railml.org/schemas/3.1}tBrakePercentage" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedProfileBraking")
public class SpeedProfileBraking {

    @XmlAttribute(name = "brakeType")
    protected String brakeType;
    @XmlAttribute(name = "airBrakeApplicationPosition")
    protected TAirBrakeApplicationDirection airBrakeApplicationPosition;
    @XmlAttribute(name = "minBrakePercentage")
    protected Integer minBrakePercentage;

    /**
     * Ruft den Wert der brakeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrakeType() {
        return brakeType;
    }

    /**
     * Legt den Wert der brakeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrakeType(String value) {
        this.brakeType = value;
    }

    /**
     * Ruft den Wert der airBrakeApplicationPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TAirBrakeApplicationDirection }
     *     
     */
    public TAirBrakeApplicationDirection getAirBrakeApplicationPosition() {
        return airBrakeApplicationPosition;
    }

    /**
     * Legt den Wert der airBrakeApplicationPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TAirBrakeApplicationDirection }
     *     
     */
    public void setAirBrakeApplicationPosition(TAirBrakeApplicationDirection value) {
        this.airBrakeApplicationPosition = value;
    }

    /**
     * Ruft den Wert der minBrakePercentage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinBrakePercentage() {
        return minBrakePercentage;
    }

    /**
     * Legt den Wert der minBrakePercentage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinBrakePercentage(Integer value) {
        this.minBrakePercentage = value;
    }

}
