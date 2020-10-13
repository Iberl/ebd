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
 * <p>Java-Klasse für GeometryPoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GeometryPoint">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}GeometryEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="radius" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="gradient" type="{https://www.railml.org/schemas/3.1}tGradientPerMille" />
 *       &lt;attribute name="azimuth" type="{https://www.railml.org/schemas/3.1}tAngleDeg" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeometryPoint")
public class GeometryPoint
    extends GeometryEntity
{

    @XmlAttribute(name = "radius")
    protected BigDecimal radius;
    @XmlAttribute(name = "gradient")
    protected BigDecimal gradient;
    @XmlAttribute(name = "azimuth")
    protected BigDecimal azimuth;

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
     * Ruft den Wert der gradient-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGradient() {
        return gradient;
    }

    /**
     * Legt den Wert der gradient-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGradient(BigDecimal value) {
        this.gradient = value;
    }

    /**
     * Ruft den Wert der azimuth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAzimuth() {
        return azimuth;
    }

    /**
     * Legt den Wert der azimuth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAzimuth(BigDecimal value) {
        this.azimuth = value;
    }

}
