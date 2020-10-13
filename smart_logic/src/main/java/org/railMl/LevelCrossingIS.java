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
 * <p>Java-Klasse für LevelCrossingIS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingIS">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}XCrossing">
 *       &lt;sequence>
 *         &lt;element name="protection" type="{https://www.railml.org/schemas/3.1}LevelCrossingProtection" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="obstacleDetection" type="{https://www.railml.org/schemas/3.1}tLevelCrossingObstacleDetection" />
 *       &lt;attribute name="opensOnDemand" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="activation" type="{https://www.railml.org/schemas/3.1}tLevelCrossingActivation" />
 *       &lt;attribute name="supervision" type="{https://www.railml.org/schemas/3.1}tLevelCrossingSupervision" />
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="basedOnTemplate" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelCrossingIS", propOrder = {
    "protection"
})
public class LevelCrossingIS
    extends XCrossing
{

    protected LevelCrossingProtection protection;
    @XmlAttribute(name = "obstacleDetection")
    protected TLevelCrossingObstacleDetection obstacleDetection;
    @XmlAttribute(name = "opensOnDemand")
    protected Boolean opensOnDemand;
    @XmlAttribute(name = "activation")
    protected TLevelCrossingActivation activation;
    @XmlAttribute(name = "supervision")
    protected TLevelCrossingSupervision supervision;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;

    /**
     * Ruft den Wert der protection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LevelCrossingProtection }
     *     
     */
    public LevelCrossingProtection getProtection() {
        return protection;
    }

    /**
     * Legt den Wert der protection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelCrossingProtection }
     *     
     */
    public void setProtection(LevelCrossingProtection value) {
        this.protection = value;
    }

    /**
     * Ruft den Wert der obstacleDetection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLevelCrossingObstacleDetection }
     *     
     */
    public TLevelCrossingObstacleDetection getObstacleDetection() {
        return obstacleDetection;
    }

    /**
     * Legt den Wert der obstacleDetection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevelCrossingObstacleDetection }
     *     
     */
    public void setObstacleDetection(TLevelCrossingObstacleDetection value) {
        this.obstacleDetection = value;
    }

    /**
     * Ruft den Wert der opensOnDemand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOpensOnDemand() {
        return opensOnDemand;
    }

    /**
     * Legt den Wert der opensOnDemand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpensOnDemand(Boolean value) {
        this.opensOnDemand = value;
    }

    /**
     * Ruft den Wert der activation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLevelCrossingActivation }
     *     
     */
    public TLevelCrossingActivation getActivation() {
        return activation;
    }

    /**
     * Legt den Wert der activation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevelCrossingActivation }
     *     
     */
    public void setActivation(TLevelCrossingActivation value) {
        this.activation = value;
    }

    /**
     * Ruft den Wert der supervision-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLevelCrossingSupervision }
     *     
     */
    public TLevelCrossingSupervision getSupervision() {
        return supervision;
    }

    /**
     * Legt den Wert der supervision-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevelCrossingSupervision }
     *     
     */
    public void setSupervision(TLevelCrossingSupervision value) {
        this.supervision = value;
    }

    /**
     * Ruft den Wert der belongsToParent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongsToParent() {
        return belongsToParent;
    }

    /**
     * Legt den Wert der belongsToParent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongsToParent(String value) {
        this.belongsToParent = value;
    }

    /**
     * Ruft den Wert der basedOnTemplate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasedOnTemplate() {
        return basedOnTemplate;
    }

    /**
     * Legt den Wert der basedOnTemplate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasedOnTemplate(String value) {
        this.basedOnTemplate = value;
    }

}
