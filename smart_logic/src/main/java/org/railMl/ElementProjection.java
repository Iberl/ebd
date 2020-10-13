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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ElementProjection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ElementProjection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}VisualizationBaseElement">
 *       &lt;sequence>
 *         &lt;element name="usesSymbol" type="{https://www.railml.org/schemas/3.1}ElementProjectionSymbol" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="refersToElement" use="required" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElementProjection", propOrder = {
    "usesSymbol"
})
@XmlSeeAlso({
    LinearProjection.class,
    AreaProjection.class,
    SpotProjection.class
})
public class ElementProjection
    extends VisualizationBaseElement
{

    protected ElementProjectionSymbol usesSymbol;
    @XmlAttribute(name = "refersToElement", required = true)
    protected String refersToElement;

    /**
     * Ruft den Wert der usesSymbol-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ElementProjectionSymbol }
     *     
     */
    public ElementProjectionSymbol getUsesSymbol() {
        return usesSymbol;
    }

    /**
     * Legt den Wert der usesSymbol-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementProjectionSymbol }
     *     
     */
    public void setUsesSymbol(ElementProjectionSymbol value) {
        this.usesSymbol = value;
    }

    /**
     * Ruft den Wert der refersToElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefersToElement() {
        return refersToElement;
    }

    /**
     * Legt den Wert der refersToElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefersToElement(String value) {
        this.refersToElement = value;
    }

}
