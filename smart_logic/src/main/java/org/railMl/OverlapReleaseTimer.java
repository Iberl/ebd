//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.HashMap;
import java.util.Map;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;


/**
 * Details for timing the overlap release.
 * 
 * <p>Java-Klasse für OverlapReleaseTimer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OverlapReleaseTimer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}anyAttribute"/>
 *       &lt;attribute name="timerValue" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="overlapReleaseCondition" type="{https://www.railml.org/schemas/3.1}tOverlapReleaseCondition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OverlapReleaseTimer")
public class OverlapReleaseTimer {

    @XmlAttribute(name = "timerValue", required = true)
    protected Duration timerValue;
    @XmlAttribute(name = "overlapReleaseCondition")
    protected TOverlapReleaseCondition overlapReleaseCondition;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Ruft den Wert der timerValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTimerValue() {
        return timerValue;
    }

    /**
     * Legt den Wert der timerValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTimerValue(Duration value) {
        this.timerValue = value;
    }

    /**
     * Ruft den Wert der overlapReleaseCondition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TOverlapReleaseCondition }
     *     
     */
    public TOverlapReleaseCondition getOverlapReleaseCondition() {
        return overlapReleaseCondition;
    }

    /**
     * Legt den Wert der overlapReleaseCondition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TOverlapReleaseCondition }
     *     
     */
    public void setOverlapReleaseCondition(TOverlapReleaseCondition value) {
        this.overlapReleaseCondition = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
