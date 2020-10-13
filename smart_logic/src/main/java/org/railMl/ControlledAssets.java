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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * container for all references to signalboxes/interlockings and system assets controlled by this controller
 * 
 * <p>Java-Klasse für ControlledAssets complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ControlledAssets">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlledInterlocking" type="{https://www.railml.org/schemas/3.1}ControlledSignalBox" maxOccurs="unbounded"/>
 *         &lt;element name="controlledSystemAsset" type="{https://www.railml.org/schemas/3.1}SystemAssetConnectedToIL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ControlledAssets", propOrder = {
    "controlledInterlocking",
    "controlledSystemAsset"
})
public class ControlledAssets {

    @XmlElement(required = true)
    protected List<ControlledSignalBox> controlledInterlocking;
    protected List<SystemAssetConnectedToIL> controlledSystemAsset;

    /**
     * Gets the value of the controlledInterlocking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlledInterlocking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlledInterlocking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlledSignalBox }
     * 
     * 
     */
    public List<ControlledSignalBox> getControlledInterlocking() {
        if (controlledInterlocking == null) {
            controlledInterlocking = new ArrayList<ControlledSignalBox>();
        }
        return this.controlledInterlocking;
    }

    /**
     * Gets the value of the controlledSystemAsset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlledSystemAsset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlledSystemAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemAssetConnectedToIL }
     * 
     * 
     */
    public List<SystemAssetConnectedToIL> getControlledSystemAsset() {
        if (controlledSystemAsset == null) {
            controlledSystemAsset = new ArrayList<SystemAssetConnectedToIL>();
        }
        return this.controlledSystemAsset;
    }

}
