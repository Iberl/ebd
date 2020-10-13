//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpeedProfile complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpeedProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}tElementWithIDandName">
 *       &lt;sequence>
 *         &lt;element name="tilting" type="{https://www.railml.org/schemas/3.1}SpeedProfileTilting" minOccurs="0"/>
 *         &lt;element name="load" type="{https://www.railml.org/schemas/3.1}SpeedProfileLoad" minOccurs="0"/>
 *         &lt;element name="braking" type="{https://www.railml.org/schemas/3.1}SpeedProfileBraking" minOccurs="0"/>
 *         &lt;element name="trainType" type="{https://www.railml.org/schemas/3.1}SpeedProfileTrainType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aSpeedProfile"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedProfile", propOrder = {
    "tilting",
    "load",
    "braking",
    "trainType"
})
public class SpeedProfile
    extends TElementWithIDandName
{

    protected SpeedProfileTilting tilting;
    protected SpeedProfileLoad load;
    protected SpeedProfileBraking braking;
    protected SpeedProfileTrainType trainType;
    @XmlAttribute(name = "influence")
    protected TSpeedProfileInfluence influence;

    /**
     * Ruft den Wert der tilting-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedProfileTilting }
     *     
     */
    public SpeedProfileTilting getTilting() {
        return tilting;
    }

    /**
     * Legt den Wert der tilting-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedProfileTilting }
     *     
     */
    public void setTilting(SpeedProfileTilting value) {
        this.tilting = value;
    }

    /**
     * Ruft den Wert der load-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedProfileLoad }
     *     
     */
    public SpeedProfileLoad getLoad() {
        return load;
    }

    /**
     * Legt den Wert der load-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedProfileLoad }
     *     
     */
    public void setLoad(SpeedProfileLoad value) {
        this.load = value;
    }

    /**
     * Ruft den Wert der braking-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedProfileBraking }
     *     
     */
    public SpeedProfileBraking getBraking() {
        return braking;
    }

    /**
     * Legt den Wert der braking-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedProfileBraking }
     *     
     */
    public void setBraking(SpeedProfileBraking value) {
        this.braking = value;
    }

    /**
     * Ruft den Wert der trainType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedProfileTrainType }
     *     
     */
    public SpeedProfileTrainType getTrainType() {
        return trainType;
    }

    /**
     * Legt den Wert der trainType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedProfileTrainType }
     *     
     */
    public void setTrainType(SpeedProfileTrainType value) {
        this.trainType = value;
    }

    /**
     * Ruft den Wert der influence-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSpeedProfileInfluence }
     *     
     */
    public TSpeedProfileInfluence getInfluence() {
        return influence;
    }

    /**
     * Legt den Wert der influence-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSpeedProfileInfluence }
     *     
     */
    public void setInfluence(TSpeedProfileInfluence value) {
        this.influence = value;
    }

}
