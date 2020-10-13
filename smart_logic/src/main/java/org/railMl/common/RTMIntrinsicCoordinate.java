//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_IntrinsicCoordinate complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_IntrinsicCoordinate">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_BaseObject">
 *       &lt;sequence>
 *         &lt;element name="linearCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_LinearCoordinate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="geometricCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_GeometricCoordinate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="intrinsicCoord" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_IntrinsicCoordinate", propOrder = {
    "linearCoordinate",
    "geometricCoordinate"
})
public class RTMIntrinsicCoordinate
    extends RTMBaseObject
{

    protected List<RTMLinearCoordinate> linearCoordinate;
    protected List<RTMGeometricCoordinate> geometricCoordinate;
    @XmlAttribute(name = "intrinsicCoord", required = true)
    protected double intrinsicCoord;

    /**
     * Gets the value of the linearCoordinate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearCoordinate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearCoordinate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMLinearCoordinate }
     * 
     * 
     */
    public List<RTMLinearCoordinate> getLinearCoordinate() {
        if (linearCoordinate == null) {
            linearCoordinate = new ArrayList<RTMLinearCoordinate>();
        }
        return this.linearCoordinate;
    }

    /**
     * Gets the value of the geometricCoordinate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometricCoordinate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometricCoordinate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMGeometricCoordinate }
     * 
     * 
     */
    public List<RTMGeometricCoordinate> getGeometricCoordinate() {
        if (geometricCoordinate == null) {
            geometricCoordinate = new ArrayList<RTMGeometricCoordinate>();
        }
        return this.geometricCoordinate;
    }

    /**
     * Ruft den Wert der intrinsicCoord-Eigenschaft ab.
     * 
     */
    public double getIntrinsicCoord() {
        return intrinsicCoord;
    }

    /**
     * Legt den Wert der intrinsicCoord-Eigenschaft fest.
     * 
     */
    public void setIntrinsicCoord(double value) {
        this.intrinsicCoord = value;
    }

}
