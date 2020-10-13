//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_LinearCoordinate complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_LinearCoordinate">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_PositioningSystemCoordinate">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="lateralDistance" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="verticalDistance" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="lateralSide" type="{https://www.railml.org/schemas/3.1}tLateralSide" />
 *       &lt;attribute name="verticalSide" type="{https://www.railml.org/schemas/3.1}tVerticalSide" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_LinearCoordinate")
public class RTMLinearCoordinate
    extends RTMPositioningSystemCoordinate
{

    @XmlAttribute(name = "lateralDistance")
    protected Double lateralDistance;
    @XmlAttribute(name = "measure", required = true)
    protected double measure;
    @XmlAttribute(name = "verticalDistance")
    protected Double verticalDistance;
    @XmlAttribute(name = "lateralSide")
    protected TLateralSide lateralSide;
    @XmlAttribute(name = "verticalSide")
    protected TVerticalSide verticalSide;

    /**
     * Ruft den Wert der lateralDistance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLateralDistance() {
        return lateralDistance;
    }

    /**
     * Legt den Wert der lateralDistance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLateralDistance(Double value) {
        this.lateralDistance = value;
    }

    /**
     * Ruft den Wert der measure-Eigenschaft ab.
     * 
     */
    public double getMeasure() {
        return measure;
    }

    /**
     * Legt den Wert der measure-Eigenschaft fest.
     * 
     */
    public void setMeasure(double value) {
        this.measure = value;
    }

    /**
     * Ruft den Wert der verticalDistance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVerticalDistance() {
        return verticalDistance;
    }

    /**
     * Legt den Wert der verticalDistance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVerticalDistance(Double value) {
        this.verticalDistance = value;
    }

    /**
     * Ruft den Wert der lateralSide-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLateralSide }
     *     
     */
    public TLateralSide getLateralSide() {
        return lateralSide;
    }

    /**
     * Legt den Wert der lateralSide-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLateralSide }
     *     
     */
    public void setLateralSide(TLateralSide value) {
        this.lateralSide = value;
    }

    /**
     * Ruft den Wert der verticalSide-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TVerticalSide }
     *     
     */
    public TVerticalSide getVerticalSide() {
        return verticalSide;
    }

    /**
     * Legt den Wert der verticalSide-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TVerticalSide }
     *     
     */
    public void setVerticalSide(TVerticalSide value) {
        this.verticalSide = value;
    }

}
