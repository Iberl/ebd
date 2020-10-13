//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpeedProfileLoad complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpeedProfileLoad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="maxAxleLoad" type="{https://www.railml.org/schemas/3.1}tWeightTons" />
 *       &lt;attribute name="maxMeterLoad" type="{https://www.railml.org/schemas/3.1}tMeterloadTonsPerMeter" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedProfileLoad")
public class SpeedProfileLoad {

    @XmlAttribute(name = "maxAxleLoad")
    protected BigDecimal maxAxleLoad;
    @XmlAttribute(name = "maxMeterLoad")
    protected BigDecimal maxMeterLoad;

    /**
     * Ruft den Wert der maxAxleLoad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxAxleLoad() {
        return maxAxleLoad;
    }

    /**
     * Legt den Wert der maxAxleLoad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxAxleLoad(BigDecimal value) {
        this.maxAxleLoad = value;
    }

    /**
     * Ruft den Wert der maxMeterLoad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxMeterLoad() {
        return maxMeterLoad;
    }

    /**
     * Legt den Wert der maxMeterLoad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxMeterLoad(BigDecimal value) {
        this.maxMeterLoad = value;
    }

}
