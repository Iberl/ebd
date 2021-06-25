//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für OperatingDay complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OperatingDay">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}PeriodRuleElement">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="bitmask" type="{https://www.railml.org/schemas/3.1}tBitmaskWeek" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperatingDay")
public class OperatingDay {

    @XmlAttribute(name = "bitmask")
    protected String bitmask;

    /**
     * Ruft den Wert der bitmask-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBitmask() {
        return bitmask;
    }

    /**
     * Legt den Wert der bitmask-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitmask(String value) {
        this.bitmask = value;
    }

}
