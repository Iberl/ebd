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
 * <p>Java-Klasse für RTM_SpotLocation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_SpotLocation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_EntityLocation">
 *       &lt;sequence>
 *         &lt;element name="linearCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_LinearCoordinate" minOccurs="0"/>
 *         &lt;element name="geometricCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_GeometricCoordinate" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="netElementRef" use="required" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="intrinsicCoord" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="applicationDirection" type="{https://www.railml.org/schemas/3.1}tApplicationDirection" />
 *       &lt;attribute name="pos" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_SpotLocation", propOrder = {
    "linearCoordinate",
    "geometricCoordinate"
})
public class RTMSpotLocation
    extends RTMBaseObject implements de.ibw.rtm.intf.IRTMSpotLocation {

    protected RTMLinearCoordinate linearCoordinate;
    protected RTMGeometricCoordinate geometricCoordinate;
    @XmlAttribute(name = "netElementRef", required = true)
    protected String netElementRef;
    @XmlAttribute(name = "intrinsicCoord")
    protected Double intrinsicCoord;
    @XmlAttribute(name = "applicationDirection")
    protected TApplicationDirection applicationDirection;
    @XmlAttribute(name = "pos")
    protected BigDecimal pos;

    /**
     * Ruft den Wert der linearCoordinate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RTMLinearCoordinate }
     *     
     */
    @Override
    public RTMLinearCoordinate getLinearCoordinate() {
        return linearCoordinate;
    }

    /**
     * Legt den Wert der linearCoordinate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RTMLinearCoordinate }
     *     
     */
    @Override
    public void setLinearCoordinate(RTMLinearCoordinate value) {
        this.linearCoordinate = value;
    }

    /**
     * Ruft den Wert der geometricCoordinate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RTMGeometricCoordinate }
     *     
     */
    @Override
    public RTMGeometricCoordinate getGeometricCoordinate() {
        return geometricCoordinate;
    }

    /**
     * Legt den Wert der geometricCoordinate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RTMGeometricCoordinate }
     *     
     */
    @Override
    public void setGeometricCoordinate(RTMGeometricCoordinate value) {
        this.geometricCoordinate = value;
    }

    /**
     * Ruft den Wert der netElementRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getNetElementRef() {
        return netElementRef;
    }

    /**
     * Legt den Wert der netElementRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setNetElementRef(String value) {
        this.netElementRef = value;
    }

    /**
     * Ruft den Wert der intrinsicCoord-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
    public Double getIntrinsicCoord() {
        return intrinsicCoord;
    }

    /**
     * Legt den Wert der intrinsicCoord-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    @Override
    public void setIntrinsicCoord(Double value) {
        this.intrinsicCoord = value;
    }

    /**
     * Ruft den Wert der applicationDirection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TApplicationDirection }
     *     
     */
    @Override
    public TApplicationDirection getApplicationDirection() {
        return applicationDirection;
    }

    /**
     * Legt den Wert der applicationDirection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TApplicationDirection }
     *     
     */
    @Override
    public void setApplicationDirection(TApplicationDirection value) {
        this.applicationDirection = value;
    }

    /**
     * Ruft den Wert der pos-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    @Override
    public BigDecimal getPos() {
        return pos;
    }

    /**
     * Legt den Wert der pos-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    @Override
    public void setPos(BigDecimal value) {
        this.pos = value;
    }

}
