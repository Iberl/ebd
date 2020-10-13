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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpeedSection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpeedSection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="validForSpeedProfile" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="maxSpeed" type="{https://www.railml.org/schemas/3.1}tVMax" />
 *       &lt;attribute name="isTemporary" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isSignalized" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedSection", propOrder = {
    "validForSpeedProfile"
})
public class SpeedSection
    extends FunctionalInfrastructureEntity
{

    protected List<TElementWithIDref> validForSpeedProfile;
    @XmlAttribute(name = "maxSpeed")
    protected String maxSpeed;
    @XmlAttribute(name = "isTemporary")
    protected Boolean isTemporary;
    @XmlAttribute(name = "isSignalized")
    protected Boolean isSignalized;

    /**
     * Gets the value of the validForSpeedProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validForSpeedProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidForSpeedProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getValidForSpeedProfile() {
        if (validForSpeedProfile == null) {
            validForSpeedProfile = new ArrayList<TElementWithIDref>();
        }
        return this.validForSpeedProfile;
    }

    /**
     * Ruft den Wert der maxSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Legt den Wert der maxSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxSpeed(String value) {
        this.maxSpeed = value;
    }

    /**
     * Ruft den Wert der isTemporary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTemporary() {
        return isTemporary;
    }

    /**
     * Legt den Wert der isTemporary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTemporary(Boolean value) {
        this.isTemporary = value;
    }

    /**
     * Ruft den Wert der isSignalized-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSignalized() {
        return isSignalized;
    }

    /**
     * Legt den Wert der isSignalized-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSignalized(Boolean value) {
        this.isSignalized = value;
    }

}
