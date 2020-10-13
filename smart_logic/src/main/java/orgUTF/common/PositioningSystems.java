//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for railML3 positioning and coordinate systems model.
 * 
 * <p>Java-Klasse für PositioningSystems complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PositioningSystems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geometricPositioningSystems" type="{https://www.railml.org/schemas/3.1}GeometricPositioningSystems" minOccurs="0"/>
 *         &lt;element name="linearPositioningSystems" type="{https://www.railml.org/schemas/3.1}LinearPositioningSystems" minOccurs="0"/>
 *         &lt;element name="screenPositioningSystems" type="{https://www.railml.org/schemas/3.1}ScreenPositioningSystems" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PositioningSystems", propOrder = {
    "geometricPositioningSystems",
    "linearPositioningSystems",
    "screenPositioningSystems"
})
public class PositioningSystems {

    protected GeometricPositioningSystems geometricPositioningSystems;
    protected LinearPositioningSystems linearPositioningSystems;
    protected ScreenPositioningSystems screenPositioningSystems;

    /**
     * Ruft den Wert der geometricPositioningSystems-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometricPositioningSystems }
     *     
     */
    public GeometricPositioningSystems getGeometricPositioningSystems() {
        return geometricPositioningSystems;
    }

    /**
     * Legt den Wert der geometricPositioningSystems-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometricPositioningSystems }
     *     
     */
    public void setGeometricPositioningSystems(GeometricPositioningSystems value) {
        this.geometricPositioningSystems = value;
    }

    /**
     * Ruft den Wert der linearPositioningSystems-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LinearPositioningSystems }
     *     
     */
    public LinearPositioningSystems getLinearPositioningSystems() {
        return linearPositioningSystems;
    }

    /**
     * Legt den Wert der linearPositioningSystems-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LinearPositioningSystems }
     *     
     */
    public void setLinearPositioningSystems(LinearPositioningSystems value) {
        this.linearPositioningSystems = value;
    }

    /**
     * Ruft den Wert der screenPositioningSystems-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ScreenPositioningSystems }
     *     
     */
    public ScreenPositioningSystems getScreenPositioningSystems() {
        return screenPositioningSystems;
    }

    /**
     * Legt den Wert der screenPositioningSystems-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ScreenPositioningSystems }
     *     
     */
    public void setScreenPositioningSystems(ScreenPositioningSystems value) {
        this.screenPositioningSystems = value;
    }

}
