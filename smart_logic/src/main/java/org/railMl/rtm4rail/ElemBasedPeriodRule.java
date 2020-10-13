//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ElemBasedPeriodRule complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ElemBasedPeriodRule">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}ShiftablePeriodRule">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="operatingDay" type="{https://www.railml.org/schemas/3.1}OperatingDay" minOccurs="0"/>
 *           &lt;element name="genericOperatingPeriod" type="{https://www.railml.org/schemas/3.1}GenericOperatingPeriodDescription" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElemBasedPeriodRule", propOrder = {
    "operatingDay",
    "genericOperatingPeriod"
})
public class ElemBasedPeriodRule
    extends ShiftablePeriodRule
{

    protected OperatingDay operatingDay;
    protected GenericOperatingPeriodDescription genericOperatingPeriod;

    /**
     * Ruft den Wert der operatingDay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OperatingDay }
     *     
     */
    public OperatingDay getOperatingDay() {
        return operatingDay;
    }

    /**
     * Legt den Wert der operatingDay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingDay }
     *     
     */
    public void setOperatingDay(OperatingDay value) {
        this.operatingDay = value;
    }

    /**
     * Ruft den Wert der genericOperatingPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericOperatingPeriodDescription }
     *     
     */
    public GenericOperatingPeriodDescription getGenericOperatingPeriod() {
        return genericOperatingPeriod;
    }

    /**
     * Legt den Wert der genericOperatingPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericOperatingPeriodDescription }
     *     
     */
    public void setGenericOperatingPeriod(GenericOperatingPeriodDescription value) {
        this.genericOperatingPeriod = value;
    }

}
