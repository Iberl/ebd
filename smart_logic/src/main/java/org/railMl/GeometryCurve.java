//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für GeometryCurve complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GeometryCurve">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}GeometryEntity">
 *       &lt;sequence>
 *         &lt;element name="beginsInGeometryPoint" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *         &lt;element name="endsInGeometryPoint" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
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
@XmlType(name = "GeometryCurve", propOrder = {
    "beginsInGeometryPoint",
    "endsInGeometryPoint"
})
@XmlSeeAlso({
    GradientCurve.class,
    HorizontalCurve.class
})
public abstract class GeometryCurve
    extends GeometryEntity
{

    protected TElementWithIDref beginsInGeometryPoint;
    protected TElementWithIDref endsInGeometryPoint;

    /**
     * Ruft den Wert der beginsInGeometryPoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getBeginsInGeometryPoint() {
        return beginsInGeometryPoint;
    }

    /**
     * Legt den Wert der beginsInGeometryPoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setBeginsInGeometryPoint(TElementWithIDref value) {
        this.beginsInGeometryPoint = value;
    }

    /**
     * Ruft den Wert der endsInGeometryPoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getEndsInGeometryPoint() {
        return endsInGeometryPoint;
    }

    /**
     * Legt den Wert der endsInGeometryPoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setEndsInGeometryPoint(TElementWithIDref value) {
        this.endsInGeometryPoint = value;
    }

}
