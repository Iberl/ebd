//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for the interlocking model. It is the home of several elements (classes) containing the particular aspects of the information.
 * 
 * <p>Java-Klasse für Interlocking complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Interlocking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="assetsForIL" type="{https://www.railml.org/schemas/3.1}AssetsForIL" minOccurs="0"/>
 *         &lt;element name="controllers" type="{https://www.railml.org/schemas/3.1}Controllers" minOccurs="0"/>
 *         &lt;element name="signalBoxes" type="{https://www.railml.org/schemas/3.1}SignalBoxes" minOccurs="0"/>
 *         &lt;element name="specificIMs" type="{https://www.railml.org/schemas/3.1}GenericIMs" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Interlocking", propOrder = {
    "assetsForIL",
    "controllers",
    "signalBoxes",
    "specificIMs"
})
public class Interlocking {

    protected AssetsForIL assetsForIL;
    protected Controllers controllers;
    protected SignalBoxes signalBoxes;
    protected GenericIMs specificIMs;

    /**
     * Ruft den Wert der assetsForIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AssetsForIL }
     *     
     */
    public AssetsForIL getAssetsForIL() {
        return assetsForIL;
    }

    /**
     * Legt den Wert der assetsForIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetsForIL }
     *     
     */
    public void setAssetsForIL(AssetsForIL value) {
        this.assetsForIL = value;
    }

    /**
     * Ruft den Wert der controllers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Controllers }
     *     
     */
    public Controllers getControllers() {
        return controllers;
    }

    /**
     * Legt den Wert der controllers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Controllers }
     *     
     */
    public void setControllers(Controllers value) {
        this.controllers = value;
    }

    /**
     * Ruft den Wert der signalBoxes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalBoxes }
     *     
     */
    public SignalBoxes getSignalBoxes() {
        return signalBoxes;
    }

    /**
     * Legt den Wert der signalBoxes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalBoxes }
     *     
     */
    public void setSignalBoxes(SignalBoxes value) {
        this.signalBoxes = value;
    }

    /**
     * Ruft den Wert der specificIMs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericIMs }
     *     
     */
    public GenericIMs getSpecificIMs() {
        return specificIMs;
    }

    /**
     * Legt den Wert der specificIMs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericIMs }
     *     
     */
    public void setSpecificIMs(GenericIMs value) {
        this.specificIMs = value;
    }

}
