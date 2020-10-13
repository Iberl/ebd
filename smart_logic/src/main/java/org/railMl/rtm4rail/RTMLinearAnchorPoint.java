//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_LinearAnchorPoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_LinearAnchorPoint">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_BaseObject">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="anchorName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="measure" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="measureToNext" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_LinearAnchorPoint")
public class RTMLinearAnchorPoint
    extends RTMBaseObject
{

    @XmlAttribute(name = "anchorName")
    protected String anchorName;
    @XmlAttribute(name = "measure")
    protected Double measure;
    @XmlAttribute(name = "measureToNext")
    protected Double measureToNext;

    /**
     * Ruft den Wert der anchorName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnchorName() {
        return anchorName;
    }

    /**
     * Legt den Wert der anchorName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnchorName(String value) {
        this.anchorName = value;
    }

    /**
     * Ruft den Wert der measure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMeasure() {
        return measure;
    }

    /**
     * Legt den Wert der measure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMeasure(Double value) {
        this.measure = value;
    }

    /**
     * Ruft den Wert der measureToNext-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMeasureToNext() {
        return measureToNext;
    }

    /**
     * Legt den Wert der measureToNext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMeasureToNext(Double value) {
        this.measureToNext = value;
    }

}
