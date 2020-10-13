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
 * <p>Java-Klasse für GradientCurve complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GradientCurve">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}GeometryCurve">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="curveType" use="required" type="{https://www.railml.org/schemas/3.1}tGradientCurveType" />
 *       &lt;attribute name="gradient" type="{https://www.railml.org/schemas/3.1}tGradientPerMille" />
 *       &lt;attribute name="deltaGradient" type="{https://www.railml.org/schemas/3.1}tGradientPerMille" />
 *       &lt;attribute name="radius" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="length" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GradientCurve")
public class GradientCurve
    extends GeometryCurve
{

    @XmlAttribute(name = "curveType", required = true)
    protected TGradientCurveType curveType;
    @XmlAttribute(name = "gradient")
    protected BigDecimal gradient;
    @XmlAttribute(name = "deltaGradient")
    protected BigDecimal deltaGradient;
    @XmlAttribute(name = "radius")
    protected BigDecimal radius;
    @XmlAttribute(name = "length")
    protected BigDecimal length;

    /**
     * Ruft den Wert der curveType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TGradientCurveType }
     *     
     */
    public TGradientCurveType getCurveType() {
        return curveType;
    }

    /**
     * Legt den Wert der curveType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TGradientCurveType }
     *     
     */
    public void setCurveType(TGradientCurveType value) {
        this.curveType = value;
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
     * Ruft den Wert der deltaGradient-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDeltaGradient() {
        return deltaGradient;
    }

    /**
     * Legt den Wert der deltaGradient-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDeltaGradient(BigDecimal value) {
        this.deltaGradient = value;
    }

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
     * Ruft den Wert der length-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Legt den Wert der length-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLength(BigDecimal value) {
        this.length = value;
    }

}
