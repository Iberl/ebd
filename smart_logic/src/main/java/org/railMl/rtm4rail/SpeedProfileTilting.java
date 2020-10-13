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
 * <p>Java-Klasse für SpeedProfileTilting complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpeedProfileTilting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="actuation" type="{https://www.railml.org/schemas/3.1}tTiltingActuationType" />
 *       &lt;attribute name="maxTiltingAngle" type="{https://www.railml.org/schemas/3.1}tAngleDegQuadrant" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedProfileTilting")
public class SpeedProfileTilting {

    @XmlAttribute(name = "actuation")
    protected TTiltingActuationType actuation;
    @XmlAttribute(name = "maxTiltingAngle")
    protected BigDecimal maxTiltingAngle;

    /**
     * Ruft den Wert der actuation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTiltingActuationType }
     *     
     */
    public TTiltingActuationType getActuation() {
        return actuation;
    }

    /**
     * Legt den Wert der actuation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTiltingActuationType }
     *     
     */
    public void setActuation(TTiltingActuationType value) {
        this.actuation = value;
    }

    /**
     * Ruft den Wert der maxTiltingAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxTiltingAngle() {
        return maxTiltingAngle;
    }

    /**
     * Legt den Wert der maxTiltingAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxTiltingAngle(BigDecimal value) {
        this.maxTiltingAngle = value;
    }

}
