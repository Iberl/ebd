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
 * <p>Java-Klasse für LevelCrossingProtection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingProtection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="barriers" type="{https://www.railml.org/schemas/3.1}tLevelCrossingProtectionBarrierExt" />
 *       &lt;attribute name="lights" type="{https://www.railml.org/schemas/3.1}tLevelCrossingProtectionLightsExt" />
 *       &lt;attribute name="acoustic" type="{https://www.railml.org/schemas/3.1}tLevelCrossingProtectionAcousticExt" />
 *       &lt;attribute name="hasActiveProtection" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelCrossingProtection")
public class LevelCrossingProtection {

    @XmlAttribute(name = "barriers")
    protected String barriers;
    @XmlAttribute(name = "lights")
    protected String lights;
    @XmlAttribute(name = "acoustic")
    protected String acoustic;
    @XmlAttribute(name = "hasActiveProtection")
    protected Boolean hasActiveProtection;

    /**
     * Ruft den Wert der barriers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarriers() {
        return barriers;
    }

    /**
     * Legt den Wert der barriers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarriers(String value) {
        this.barriers = value;
    }

    /**
     * Ruft den Wert der lights-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLights() {
        return lights;
    }

    /**
     * Legt den Wert der lights-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLights(String value) {
        this.lights = value;
    }

    /**
     * Ruft den Wert der acoustic-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcoustic() {
        return acoustic;
    }

    /**
     * Legt den Wert der acoustic-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcoustic(String value) {
        this.acoustic = value;
    }

    /**
     * Ruft den Wert der hasActiveProtection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasActiveProtection() {
        return hasActiveProtection;
    }

    /**
     * Legt den Wert der hasActiveProtection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasActiveProtection(Boolean value) {
        this.hasActiveProtection = value;
    }

}
