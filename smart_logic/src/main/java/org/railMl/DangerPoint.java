//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The danger point defines the position beyond the exit signal up to where a train is likely to be safe.
 * Designed for ETCS modelling.
 * 
 * <p>Java-Klasse für DangerPoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DangerPoint">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="lastSupervisedSectionBeforeDP" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="situatedAtTrackAsset" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="distance" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;attribute name="releaseSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DangerPoint", propOrder = {
    "lastSupervisedSectionBeforeDP",
    "situatedAtTrackAsset"
})
public class DangerPoint
    extends EntityIL
{

    protected EntityILref lastSupervisedSectionBeforeDP;
    protected EntityILref situatedAtTrackAsset;
    @XmlAttribute(name = "distance")
    protected BigDecimal distance;
    @XmlAttribute(name = "releaseSpeed")
    protected BigDecimal releaseSpeed;

    /**
     * Ruft den Wert der lastSupervisedSectionBeforeDP-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getLastSupervisedSectionBeforeDP() {
        return lastSupervisedSectionBeforeDP;
    }

    /**
     * Legt den Wert der lastSupervisedSectionBeforeDP-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setLastSupervisedSectionBeforeDP(EntityILref value) {
        this.lastSupervisedSectionBeforeDP = value;
    }

    /**
     * Ruft den Wert der situatedAtTrackAsset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getSituatedAtTrackAsset() {
        return situatedAtTrackAsset;
    }

    /**
     * Legt den Wert der situatedAtTrackAsset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setSituatedAtTrackAsset(EntityILref value) {
        this.situatedAtTrackAsset = value;
    }

    /**
     * Ruft den Wert der distance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDistance() {
        return distance;
    }

    /**
     * Legt den Wert der distance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDistance(BigDecimal value) {
        this.distance = value;
    }

    /**
     * Ruft den Wert der releaseSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReleaseSpeed() {
        return releaseSpeed;
    }

    /**
     * Legt den Wert der releaseSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReleaseSpeed(BigDecimal value) {
        this.releaseSpeed = value;
    }

}
