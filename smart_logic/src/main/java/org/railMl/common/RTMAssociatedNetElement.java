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
 * <p>Java-Klasse für RTM_AssociatedNetElement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_AssociatedNetElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geometricCoordinateBegin" type="{https://www.railml.org/schemas/3.1}RTM_GeometricCoordinate" minOccurs="0"/>
 *         &lt;element name="linearCoordinateBegin" type="{https://www.railml.org/schemas/3.1}RTM_LinearCoordinate" minOccurs="0"/>
 *         &lt;element name="geometricCoordinateEnd" type="{https://www.railml.org/schemas/3.1}RTM_GeometricCoordinate" minOccurs="0"/>
 *         &lt;element name="linearCoordinateEnd" type="{https://www.railml.org/schemas/3.1}RTM_LinearCoordinate" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="netElementRef" use="required" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="intrinsicCoordBegin" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="intrinsicCoordEnd" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="keepsOrientation" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="sequence" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="posBegin" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="posEnd" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_AssociatedNetElement", propOrder = {
    "geometricCoordinateBegin",
    "linearCoordinateBegin",
    "geometricCoordinateEnd",
    "linearCoordinateEnd"
})
public class RTMAssociatedNetElement {

    protected RTMGeometricCoordinate geometricCoordinateBegin;
    protected RTMLinearCoordinate linearCoordinateBegin;
    protected RTMGeometricCoordinate geometricCoordinateEnd;
    protected RTMLinearCoordinate linearCoordinateEnd;
    @XmlAttribute(name = "netElementRef", required = true)
    protected String netElementRef;
    @XmlAttribute(name = "intrinsicCoordBegin")
    protected Double intrinsicCoordBegin;
    @XmlAttribute(name = "intrinsicCoordEnd")
    protected Double intrinsicCoordEnd;
    @XmlAttribute(name = "keepsOrientation", required = true)
    protected boolean keepsOrientation;
    @XmlAttribute(name = "sequence")
    protected Integer sequence;
    @XmlAttribute(name = "posBegin")
    protected BigDecimal posBegin;
    @XmlAttribute(name = "posEnd")
    protected BigDecimal posEnd;

    /**
     * Ruft den Wert der geometricCoordinateBegin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RTMGeometricCoordinate }
     *     
     */
    public RTMGeometricCoordinate getGeometricCoordinateBegin() {
        return geometricCoordinateBegin;
    }

    /**
     * Legt den Wert der geometricCoordinateBegin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RTMGeometricCoordinate }
     *     
     */
    public void setGeometricCoordinateBegin(RTMGeometricCoordinate value) {
        this.geometricCoordinateBegin = value;
    }

    /**
     * Ruft den Wert der linearCoordinateBegin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RTMLinearCoordinate }
     *     
     */
    public RTMLinearCoordinate getLinearCoordinateBegin() {
        return linearCoordinateBegin;
    }

    /**
     * Legt den Wert der linearCoordinateBegin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RTMLinearCoordinate }
     *     
     */
    public void setLinearCoordinateBegin(RTMLinearCoordinate value) {
        this.linearCoordinateBegin = value;
    }

    /**
     * Ruft den Wert der geometricCoordinateEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RTMGeometricCoordinate }
     *     
     */
    public RTMGeometricCoordinate getGeometricCoordinateEnd() {
        return geometricCoordinateEnd;
    }

    /**
     * Legt den Wert der geometricCoordinateEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RTMGeometricCoordinate }
     *     
     */
    public void setGeometricCoordinateEnd(RTMGeometricCoordinate value) {
        this.geometricCoordinateEnd = value;
    }

    /**
     * Ruft den Wert der linearCoordinateEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RTMLinearCoordinate }
     *     
     */
    public RTMLinearCoordinate getLinearCoordinateEnd() {
        return linearCoordinateEnd;
    }

    /**
     * Legt den Wert der linearCoordinateEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RTMLinearCoordinate }
     *     
     */
    public void setLinearCoordinateEnd(RTMLinearCoordinate value) {
        this.linearCoordinateEnd = value;
    }

    /**
     * Ruft den Wert der netElementRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
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
    public void setNetElementRef(String value) {
        this.netElementRef = value;
    }

    /**
     * Ruft den Wert der intrinsicCoordBegin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIntrinsicCoordBegin() {
        return intrinsicCoordBegin;
    }

    /**
     * Legt den Wert der intrinsicCoordBegin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIntrinsicCoordBegin(Double value) {
        this.intrinsicCoordBegin = value;
    }

    /**
     * Ruft den Wert der intrinsicCoordEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIntrinsicCoordEnd() {
        return intrinsicCoordEnd;
    }

    /**
     * Legt den Wert der intrinsicCoordEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIntrinsicCoordEnd(Double value) {
        this.intrinsicCoordEnd = value;
    }

    /**
     * Ruft den Wert der keepsOrientation-Eigenschaft ab.
     * 
     */
    public boolean isKeepsOrientation() {
        return keepsOrientation;
    }

    /**
     * Legt den Wert der keepsOrientation-Eigenschaft fest.
     * 
     */
    public void setKeepsOrientation(boolean value) {
        this.keepsOrientation = value;
    }

    /**
     * Ruft den Wert der sequence-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * Legt den Wert der sequence-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSequence(Integer value) {
        this.sequence = value;
    }

    /**
     * Ruft den Wert der posBegin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPosBegin() {
        return posBegin;
    }

    /**
     * Legt den Wert der posBegin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPosBegin(BigDecimal value) {
        this.posBegin = value;
    }

    /**
     * Ruft den Wert der posEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPosEnd() {
        return posEnd;
    }

    /**
     * Legt den Wert der posEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPosEnd(BigDecimal value) {
        this.posEnd = value;
    }

}
