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
import jakarta.xml.bind.annotation.XmlType;


/**
 * general attributes of interlocking configuration
 * 
 * <p>Java-Klasse für Configuration complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Configuration">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="model" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="technologyType" use="required" type="{https://www.railml.org/schemas/3.1}tIxlTechnologyTypeListExt" />
 *       &lt;attribute name="SWversion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="signalSystem" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configuration")
public class Configuration
    extends EntityIL
{

    @XmlAttribute(name = "model")
    protected String model;
    @XmlAttribute(name = "technologyType", required = true)
    protected String technologyType;
    @XmlAttribute(name = "SWversion")
    protected String sWversion;
    @XmlAttribute(name = "signalSystem")
    protected String signalSystem;

    /**
     * Ruft den Wert der model-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Legt den Wert der model-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Ruft den Wert der technologyType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnologyType() {
        return technologyType;
    }

    /**
     * Legt den Wert der technologyType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnologyType(String value) {
        this.technologyType = value;
    }

    /**
     * Ruft den Wert der sWversion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWversion() {
        return sWversion;
    }

    /**
     * Legt den Wert der sWversion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWversion(String value) {
        this.sWversion = value;
    }

    /**
     * Ruft den Wert der signalSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalSystem() {
        return signalSystem;
    }

    /**
     * Legt den Wert der signalSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalSystem(String value) {
        this.signalSystem = value;
    }

}
