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
 * <p>Java-Klasse für SignalConstruction complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalConstruction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="height" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="positionAtTrack" type="{https://www.railml.org/schemas/3.1}tWiderTrackPosition" />
 *       &lt;attribute name="type" type="{https://www.railml.org/schemas/3.1}tSignalConstructionType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalConstruction")
public class SignalConstruction {

    @XmlAttribute(name = "height")
    protected BigDecimal height;
    @XmlAttribute(name = "positionAtTrack")
    protected TWiderTrackPosition positionAtTrack;
    @XmlAttribute(name = "type")
    protected TSignalConstructionType type;

    /**
     * Ruft den Wert der height-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Legt den Wert der height-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    /**
     * Ruft den Wert der positionAtTrack-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TWiderTrackPosition }
     *     
     */
    public TWiderTrackPosition getPositionAtTrack() {
        return positionAtTrack;
    }

    /**
     * Legt den Wert der positionAtTrack-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TWiderTrackPosition }
     *     
     */
    public void setPositionAtTrack(TWiderTrackPosition value) {
        this.positionAtTrack = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSignalConstructionType }
     *     
     */
    public TSignalConstructionType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSignalConstructionType }
     *     
     */
    public void setType(TSignalConstructionType value) {
        this.type = value;
    }

}
