//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java-Klasse für LineLayout complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineLayout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}anyAttribute"/>
 *       &lt;attribute name="maxGradient" type="{https://www.railml.org/schemas/3.1}tGradientPerMille" />
 *       &lt;attribute name="numberOfTracks" type="{https://www.railml.org/schemas/3.1}tNumberOfTracks" />
 *       &lt;attribute name="minRadius" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineLayout", propOrder = {
    "any"
})
public class LineLayout {

    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "maxGradient")
    protected BigDecimal maxGradient;
    @XmlAttribute(name = "numberOfTracks")
    protected TNumberOfTracks numberOfTracks;
    @XmlAttribute(name = "minRadius")
    protected BigDecimal minRadius;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Ruft den Wert der maxGradient-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxGradient() {
        return maxGradient;
    }

    /**
     * Legt den Wert der maxGradient-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxGradient(BigDecimal value) {
        this.maxGradient = value;
    }

    /**
     * Ruft den Wert der numberOfTracks-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TNumberOfTracks }
     *     
     */
    public TNumberOfTracks getNumberOfTracks() {
        return numberOfTracks;
    }

    /**
     * Legt den Wert der numberOfTracks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TNumberOfTracks }
     *     
     */
    public void setNumberOfTracks(TNumberOfTracks value) {
        this.numberOfTracks = value;
    }

    /**
     * Ruft den Wert der minRadius-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinRadius() {
        return minRadius;
    }

    /**
     * Legt den Wert der minRadius-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinRadius(BigDecimal value) {
        this.minRadius = value;
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
