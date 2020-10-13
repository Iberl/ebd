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
 * The level crossings have some basic features which can be specified independent of the particular manufacturer. Most important is the control type saying how the control relation between the interlocking and the level crossing is.
 * 
 * <p>Java-Klasse für LevelCrossingTypeList complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingTypeList">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="controlType" use="required" type="{https://www.railml.org/schemas/3.1}tLevelCrossingControlTypes" />
 *       &lt;attribute name="allowsLocalOperation" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="hasBarrier" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="hasTrafficWarning" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelCrossingTypeList")
public class LevelCrossingTypeList
    extends EntityIL
{

    @XmlAttribute(name = "controlType", required = true)
    protected TLevelCrossingControlTypes controlType;
    @XmlAttribute(name = "allowsLocalOperation")
    protected Boolean allowsLocalOperation;
    @XmlAttribute(name = "hasBarrier")
    protected Boolean hasBarrier;
    @XmlAttribute(name = "hasTrafficWarning")
    protected Boolean hasTrafficWarning;

    /**
     * Ruft den Wert der controlType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLevelCrossingControlTypes }
     *     
     */
    public TLevelCrossingControlTypes getControlType() {
        return controlType;
    }

    /**
     * Legt den Wert der controlType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevelCrossingControlTypes }
     *     
     */
    public void setControlType(TLevelCrossingControlTypes value) {
        this.controlType = value;
    }

    /**
     * Ruft den Wert der allowsLocalOperation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsLocalOperation() {
        return allowsLocalOperation;
    }

    /**
     * Legt den Wert der allowsLocalOperation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsLocalOperation(Boolean value) {
        this.allowsLocalOperation = value;
    }

    /**
     * Ruft den Wert der hasBarrier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasBarrier() {
        return hasBarrier;
    }

    /**
     * Legt den Wert der hasBarrier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasBarrier(Boolean value) {
        this.hasBarrier = value;
    }

    /**
     * Ruft den Wert der hasTrafficWarning-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasTrafficWarning() {
        return hasTrafficWarning;
    }

    /**
     * Legt den Wert der hasTrafficWarning-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasTrafficWarning(Boolean value) {
        this.hasTrafficWarning = value;
    }

}
