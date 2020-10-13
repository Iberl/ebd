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
 * Used by TVD section reset strategy that the IM regulates. E.g. reset by sweep allowed, manual reset allowed. Note that the IM can apply different reset strategies to sections. Absence of a strategy implies that reset is not possible.
 * 
 * <p>Java-Klasse für GenericResetStrategy complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericResetStrategy">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="resetStrategy" use="required" type="{https://www.railml.org/schemas/3.1}tGenericResetStrategyList" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericResetStrategy")
public class GenericResetStrategy
    extends EntityIL
{

    @XmlAttribute(name = "resetStrategy", required = true)
    protected TGenericResetStrategyList resetStrategy;

    /**
     * Ruft den Wert der resetStrategy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TGenericResetStrategyList }
     *     
     */
    public TGenericResetStrategyList getResetStrategy() {
        return resetStrategy;
    }

    /**
     * Legt den Wert der resetStrategy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TGenericResetStrategyList }
     *     
     */
    public void setResetStrategy(TGenericResetStrategyList value) {
        this.resetStrategy = value;
    }

}
