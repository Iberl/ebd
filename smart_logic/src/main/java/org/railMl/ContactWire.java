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
 * <p>Java-Klasse für ContactWire complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ContactWire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="minHeight" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="maxHeight" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="maxDisplacement" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactWire")
public class ContactWire {

    @XmlAttribute(name = "minHeight")
    protected BigDecimal minHeight;
    @XmlAttribute(name = "maxHeight")
    protected BigDecimal maxHeight;
    @XmlAttribute(name = "maxDisplacement")
    protected BigDecimal maxDisplacement;

    /**
     * Ruft den Wert der minHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinHeight() {
        return minHeight;
    }

    /**
     * Legt den Wert der minHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinHeight(BigDecimal value) {
        this.minHeight = value;
    }

    /**
     * Ruft den Wert der maxHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxHeight() {
        return maxHeight;
    }

    /**
     * Legt den Wert der maxHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxHeight(BigDecimal value) {
        this.maxHeight = value;
    }

    /**
     * Ruft den Wert der maxDisplacement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxDisplacement() {
        return maxDisplacement;
    }

    /**
     * Legt den Wert der maxDisplacement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxDisplacement(BigDecimal value) {
        this.maxDisplacement = value;
    }

}
