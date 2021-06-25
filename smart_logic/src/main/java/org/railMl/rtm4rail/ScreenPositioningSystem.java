//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ScreenPositioningSystem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ScreenPositioningSystem">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_PositioningSystem">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="pxX" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="pxY" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="pxZ" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScreenPositioningSystem")
public class ScreenPositioningSystem
    extends RTMPositioningSystem
{

    @XmlAttribute(name = "pxX", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pxX;
    @XmlAttribute(name = "pxY", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pxY;
    @XmlAttribute(name = "pxZ")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pxZ;

    /**
     * Ruft den Wert der pxX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPxX() {
        return pxX;
    }

    /**
     * Legt den Wert der pxX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPxX(BigInteger value) {
        this.pxX = value;
    }

    /**
     * Ruft den Wert der pxY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPxY() {
        return pxY;
    }

    /**
     * Legt den Wert der pxY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPxY(BigInteger value) {
        this.pxY = value;
    }

    /**
     * Ruft den Wert der pxZ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPxZ() {
        return pxZ;
    }

    /**
     * Legt den Wert der pxZ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPxZ(BigInteger value) {
        this.pxZ = value;
    }

}
