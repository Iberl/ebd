//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r Period complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Period">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="period" type="{https://www.railml.org/schemas/3.1}CalendarTimePeriod" minOccurs="0"/>
 *           &lt;element name="periodBitmask" type="{https://www.railml.org/schemas/3.1}CalendarTimePeriodWithBitmask" minOccurs="0"/>
 *           &lt;element name="periodGeneric" type="{https://www.railml.org/schemas/3.1}GenericTimePeriod" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Period", propOrder = {
    "period",
    "periodBitmask",
    "periodGeneric"
})
public class Period {

    protected CalendarTimePeriod period;
    protected CalendarTimePeriodWithBitmask periodBitmask;
    protected GenericTimePeriod periodGeneric;

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CalendarTimePeriod }
     *     
     */
    public CalendarTimePeriod getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarTimePeriod }
     *     
     */
    public void setPeriod(CalendarTimePeriod value) {
        this.period = value;
    }

    /**
     * Ruft den Wert der periodBitmask-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CalendarTimePeriodWithBitmask }
     *     
     */
    public CalendarTimePeriodWithBitmask getPeriodBitmask() {
        return periodBitmask;
    }

    /**
     * Legt den Wert der periodBitmask-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarTimePeriodWithBitmask }
     *     
     */
    public void setPeriodBitmask(CalendarTimePeriodWithBitmask value) {
        this.periodBitmask = value;
    }

    /**
     * Ruft den Wert der periodGeneric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericTimePeriod }
     *     
     */
    public GenericTimePeriod getPeriodGeneric() {
        return periodGeneric;
    }

    /**
     * Legt den Wert der periodGeneric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericTimePeriod }
     *     
     */
    public void setPeriodGeneric(GenericTimePeriod value) {
        this.periodGeneric = value;
    }

}