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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A Point is defined by a single coordinate tuple. The direct position of a point is specified by the pos element which is of type DirectPositionType.
 * 
 * <p>Java-Klasse für PointType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PointType">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1/gml}AbstractGeometricPrimitiveType">
 *       &lt;sequence>
 *         &lt;element name="pos" type="{https://www.railml.org/schemas/3.1/gml}DirectPositionType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointType", namespace = "https://www.railml.org/schemas/3.1/gml", propOrder = {
    "pos"
})
@XmlSeeAlso({
    PointTypeCoordinate.class
})
public class PointType
    extends AbstractGeometricPrimitiveType
{

    @XmlElement(required = true)
    protected DirectPositionType pos;

    /**
     * Ruft den Wert der pos-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DirectPositionType }
     *     
     */
    public DirectPositionType getPos() {
        return pos;
    }

    /**
     * Legt den Wert der pos-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectPositionType }
     *     
     */
    public void setPos(DirectPositionType value) {
        this.pos = value;
    }

}
