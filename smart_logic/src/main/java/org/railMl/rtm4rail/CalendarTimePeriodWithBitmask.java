//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für CalendarTimePeriodWithBitmask complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CalendarTimePeriodWithBitmask">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TimePeriod">
 *       &lt;sequence>
 *         &lt;element name="periodRule" type="{https://www.railml.org/schemas/3.1}PeriodRule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fromDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="bitmask" type="{https://www.railml.org/schemas/3.1}tBitmaskAny" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalendarTimePeriodWithBitmask", propOrder = {
    "periodRule"
})
public class CalendarTimePeriodWithBitmask
    extends TimePeriod
{

    protected List<PeriodRule> periodRule;
    @XmlAttribute(name = "fromDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fromDate;
    @XmlAttribute(name = "bitmask")
    protected String bitmask;

    /**
     * Gets the value of the periodRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the periodRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriodRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodRule }
     * 
     * 
     */
    public List<PeriodRule> getPeriodRule() {
        if (periodRule == null) {
            periodRule = new ArrayList<PeriodRule>();
        }
        return this.periodRule;
    }

    /**
     * Ruft den Wert der fromDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    /**
     * Legt den Wert der fromDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

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
