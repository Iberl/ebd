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
 * This is the description of the interface status in command and message direction which is assumed in start-up cases, i.e. when both sides of the system are just powered up.
 * 
 * <p>Java-Klasse für InitStatus complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="InitStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="comString" use="required" type="{https://www.railml.org/schemas/3.1}tBitPatternAny" />
 *       &lt;attribute name="messString" use="required" type="{https://www.railml.org/schemas/3.1}tBitPatternAny" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitStatus")
public class InitStatus {

    @XmlAttribute(name = "comString", required = true)
    protected String comString;
    @XmlAttribute(name = "messString", required = true)
    protected String messString;

    /**
     * Ruft den Wert der comString-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComString() {
        return comString;
    }

    /**
     * Legt den Wert der comString-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComString(String value) {
        this.comString = value;
    }

    /**
     * Ruft den Wert der messString-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessString() {
        return messString;
    }

    /**
     * Legt den Wert der messString-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessString(String value) {
        this.messString = value;
    }

}
