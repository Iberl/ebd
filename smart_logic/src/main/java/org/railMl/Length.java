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
 * <p>Java-Klasse für Length complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Length">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="value" use="required" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="type" use="required" type="{https://www.railml.org/schemas/3.1}tLengthTypeExt" />
 *       &lt;attribute name="validForDirection" type="{https://www.railml.org/schemas/3.1}tExtendedDirection" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Length")
public class Length {

    @XmlAttribute(name = "value", required = true)
    protected BigDecimal value;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "validForDirection")
    protected TExtendedDirection validForDirection;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der validForDirection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TExtendedDirection }
     *     
     */
    public TExtendedDirection getValidForDirection() {
        return validForDirection;
    }

    /**
     * Legt den Wert der validForDirection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtendedDirection }
     *     
     */
    public void setValidForDirection(TExtendedDirection value) {
        this.validForDirection = value;
    }

}
