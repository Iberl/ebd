//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ElectrificationSystem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ElectrificationSystem">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}tElementWithID">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="voltage" type="{https://www.railml.org/schemas/3.1}tVoltageVolt" />
 *       &lt;attribute name="frequency" type="{https://www.railml.org/schemas/3.1}tFrequencyHertz" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectrificationSystem")
public class ElectrificationSystem
    extends TElementWithID
{

    @XmlAttribute(name = "voltage")
    protected BigDecimal voltage;
    @XmlAttribute(name = "frequency")
    protected BigDecimal frequency;

    /**
     * Ruft den Wert der voltage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVoltage() {
        return voltage;
    }

    /**
     * Legt den Wert der voltage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVoltage(BigDecimal value) {
        this.voltage = value;
    }

    /**
     * Ruft den Wert der frequency-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFrequency() {
        return frequency;
    }

    /**
     * Legt den Wert der frequency-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFrequency(BigDecimal value) {
        this.frequency = value;
    }

}
