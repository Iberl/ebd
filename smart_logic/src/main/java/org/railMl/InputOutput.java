//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * The detailed list of input or output information (closed=1=active, open=0=inactive)
 * 
 * <p>Java-Klasse für InputOutput complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="InputOutput">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="bitNr" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="normalState" type="{https://www.railml.org/schemas/3.1}tContactState" />
 *       &lt;attribute name="pulseDuration" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputOutput")
public class InputOutput
    extends EntityIL
{

    @XmlAttribute(name = "bitNr")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger bitNr;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "normalState")
    protected TContactState normalState;
    @XmlAttribute(name = "pulseDuration")
    protected Duration pulseDuration;

    /**
     * Ruft den Wert der bitNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBitNr() {
        return bitNr;
    }

    /**
     * Legt den Wert der bitNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBitNr(BigInteger value) {
        this.bitNr = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Ruft den Wert der normalState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TContactState }
     *     
     */
    public TContactState getNormalState() {
        return normalState;
    }

    /**
     * Legt den Wert der normalState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TContactState }
     *     
     */
    public void setNormalState(TContactState value) {
        this.normalState = value;
    }

    /**
     * Ruft den Wert der pulseDuration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getPulseDuration() {
        return pulseDuration;
    }

    /**
     * Legt den Wert der pulseDuration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setPulseDuration(Duration value) {
        this.pulseDuration = value;
    }

}
