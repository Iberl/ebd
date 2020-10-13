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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ElementProjectionSymbol complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ElementProjectionSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}VisualizationBaseElement">
 *       &lt;sequence>
 *         &lt;element name="isLocatedAt" type="{https://www.railml.org/schemas/3.1}ProjectionCoordinate"/>
 *       &lt;/sequence>
 *       &lt;attribute name="externalIconRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="orientation" type="{https://www.railml.org/schemas/3.1}tElementProjectionSymbolOrientationExt" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElementProjectionSymbol", propOrder = {
    "isLocatedAt"
})
public class ElementProjectionSymbol
    extends VisualizationBaseElement
{

    @XmlElement(required = true)
    protected ProjectionCoordinate isLocatedAt;
    @XmlAttribute(name = "externalIconRef")
    protected String externalIconRef;
    @XmlAttribute(name = "orientation")
    protected String orientation;

    /**
     * Ruft den Wert der isLocatedAt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProjectionCoordinate }
     *     
     */
    public ProjectionCoordinate getIsLocatedAt() {
        return isLocatedAt;
    }

    /**
     * Legt den Wert der isLocatedAt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectionCoordinate }
     *     
     */
    public void setIsLocatedAt(ProjectionCoordinate value) {
        this.isLocatedAt = value;
    }

    /**
     * Ruft den Wert der externalIconRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalIconRef() {
        return externalIconRef;
    }

    /**
     * Legt den Wert der externalIconRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalIconRef(String value) {
        this.externalIconRef = value;
    }

    /**
     * Ruft den Wert der orientation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * Legt den Wert der orientation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrientation(String value) {
        this.orientation = value;
    }

}
