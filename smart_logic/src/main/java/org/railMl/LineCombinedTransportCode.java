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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für LineCombinedTransportCode complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineCombinedTransportCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="wagonCompatibilityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="profileNumber" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineCombinedTransportCode")
public class LineCombinedTransportCode {

    @XmlAttribute(name = "wagonCompatibilityCode")
    protected String wagonCompatibilityCode;
    @XmlAttribute(name = "profileNumber")
    protected BigInteger profileNumber;

    /**
     * Ruft den Wert der wagonCompatibilityCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWagonCompatibilityCode() {
        return wagonCompatibilityCode;
    }

    /**
     * Legt den Wert der wagonCompatibilityCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWagonCompatibilityCode(String value) {
        this.wagonCompatibilityCode = value;
    }

    /**
     * Ruft den Wert der profileNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProfileNumber() {
        return profileNumber;
    }

    /**
     * Legt den Wert der profileNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProfileNumber(BigInteger value) {
        this.profileNumber = value;
    }

}
