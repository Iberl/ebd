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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für TimePeriodRuleSituation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TimePeriodRuleSituation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="periodRule" type="{https://www.railml.org/schemas/3.1}PeriodRule" minOccurs="0"/>
 *           &lt;element name="publicHolidayPeriodRule" type="{https://www.railml.org/schemas/3.1}PublicHolidayPeriodRule" minOccurs="0"/>
 *           &lt;element name="elementBasedPeriodRule" type="{https://www.railml.org/schemas/3.1}ElemBasedPeriodRule" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="fromDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimePeriodRuleSituation", propOrder = {
    "periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule"
})
public class TimePeriodRuleSituation {

    @XmlElements({
        @XmlElement(name = "periodRule", type = PeriodRule.class),
        @XmlElement(name = "publicHolidayPeriodRule", type = PublicHolidayPeriodRule.class),
        @XmlElement(name = "elementBasedPeriodRule", type = ElemBasedPeriodRule.class)
    })
    protected List<TimePeriodRule> periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule;
    @XmlAttribute(name = "fromDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fromDate;

    /**
     * Gets the value of the periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodRule }
     * {@link PublicHolidayPeriodRule }
     * {@link ElemBasedPeriodRule }
     * 
     * 
     */
    public List<TimePeriodRule> getPeriodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule() {
        if (periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule == null) {
            periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule = new ArrayList<TimePeriodRule>();
        }
        return this.periodRuleOrPublicHolidayPeriodRuleOrElementBasedPeriodRule;
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

}
