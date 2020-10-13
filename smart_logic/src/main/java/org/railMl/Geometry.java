//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for railML3 geometry model.
 * 
 * <p>Java-Klasse für Geometry complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Geometry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="horizontalCurves" type="{https://www.railml.org/schemas/3.1}HorizontalCurves" minOccurs="0"/>
 *         &lt;element name="gradientCurves" type="{https://www.railml.org/schemas/3.1}GradientCurves" minOccurs="0"/>
 *         &lt;element name="geometryPoints" type="{https://www.railml.org/schemas/3.1}GeometryPoints" minOccurs="0"/>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geometry", propOrder = {
    "horizontalCurves",
    "gradientCurves",
    "geometryPoints",
    "any"
})
public class Geometry {

    protected HorizontalCurves horizontalCurves;
    protected GradientCurves gradientCurves;
    protected GeometryPoints geometryPoints;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Ruft den Wert der horizontalCurves-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HorizontalCurves }
     *     
     */
    public HorizontalCurves getHorizontalCurves() {
        return horizontalCurves;
    }

    /**
     * Legt den Wert der horizontalCurves-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HorizontalCurves }
     *     
     */
    public void setHorizontalCurves(HorizontalCurves value) {
        this.horizontalCurves = value;
    }

    /**
     * Ruft den Wert der gradientCurves-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GradientCurves }
     *     
     */
    public GradientCurves getGradientCurves() {
        return gradientCurves;
    }

    /**
     * Legt den Wert der gradientCurves-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GradientCurves }
     *     
     */
    public void setGradientCurves(GradientCurves value) {
        this.gradientCurves = value;
    }

    /**
     * Ruft den Wert der geometryPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPoints }
     *     
     */
    public GeometryPoints getGeometryPoints() {
        return geometryPoints;
    }

    /**
     * Legt den Wert der geometryPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPoints }
     *     
     */
    public void setGeometryPoints(GeometryPoints value) {
        this.geometryPoints = value;
    }

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

}
