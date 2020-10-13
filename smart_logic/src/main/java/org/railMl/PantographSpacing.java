//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PantographSpacing complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PantographSpacing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="numberPantographsRaised" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="spacingPantographsRaised" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="speed4PantographSpacing" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PantographSpacing")
public class PantographSpacing {

    @XmlAttribute(name = "numberPantographsRaised")
    protected BigInteger numberPantographsRaised;
    @XmlAttribute(name = "spacingPantographsRaised")
    protected BigDecimal spacingPantographsRaised;
    @XmlAttribute(name = "speed4PantographSpacing")
    protected BigDecimal speed4PantographSpacing;

    /**
     * Ruft den Wert der numberPantographsRaised-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberPantographsRaised() {
        return numberPantographsRaised;
    }

    /**
     * Legt den Wert der numberPantographsRaised-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberPantographsRaised(BigInteger value) {
        this.numberPantographsRaised = value;
    }

    /**
     * Ruft den Wert der spacingPantographsRaised-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpacingPantographsRaised() {
        return spacingPantographsRaised;
    }

    /**
     * Legt den Wert der spacingPantographsRaised-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpacingPantographsRaised(BigDecimal value) {
        this.spacingPantographsRaised = value;
    }

    /**
     * Ruft den Wert der speed4PantographSpacing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpeed4PantographSpacing() {
        return speed4PantographSpacing;
    }

    /**
     * Legt den Wert der speed4PantographSpacing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpeed4PantographSpacing(BigDecimal value) {
        this.speed4PantographSpacing = value;
    }

}
