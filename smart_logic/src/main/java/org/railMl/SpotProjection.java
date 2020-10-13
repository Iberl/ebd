//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpotProjection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpotProjection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}ElementProjection">
 *       &lt;sequence>
 *         &lt;element name="coordinate" type="{https://www.railml.org/schemas/3.1}ProjectionCoordinate"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpotProjection", propOrder = {
    "coordinate"
})
public class SpotProjection
    extends ElementProjection
{

    @XmlElement(required = true)
    protected ProjectionCoordinate coordinate;

    /**
     * Ruft den Wert der coordinate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProjectionCoordinate }
     *     
     */
    public ProjectionCoordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Legt den Wert der coordinate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectionCoordinate }
     *     
     */
    public void setCoordinate(ProjectionCoordinate value) {
        this.coordinate = value;
    }

}
