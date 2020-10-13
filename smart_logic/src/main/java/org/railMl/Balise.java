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
 * <p>Java-Klasse für Balise complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Balise">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{https://www.railml.org/schemas/3.1}tBaliseType" />
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="basedOnTemplate" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="isBaliseGroup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="baliseGroupType" type="{https://www.railml.org/schemas/3.1}tBaliseGroupTypeExt" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Balise")
public class Balise
    extends FunctionalInfrastructureEntity
{

    @XmlAttribute(name = "type")
    protected TBaliseType type;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;
    @XmlAttribute(name = "isBaliseGroup")
    protected Boolean isBaliseGroup;
    @XmlAttribute(name = "baliseGroupType")
    protected String baliseGroupType;

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TBaliseType }
     *     
     */
    public TBaliseType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TBaliseType }
     *     
     */
    public void setType(TBaliseType value) {
        this.type = value;
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

    /**
     * Ruft den Wert der isBaliseGroup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsBaliseGroup() {
        return isBaliseGroup;
    }

    /**
     * Legt den Wert der isBaliseGroup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsBaliseGroup(Boolean value) {
        this.isBaliseGroup = value;
    }

    /**
     * Ruft den Wert der baliseGroupType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaliseGroupType() {
        return baliseGroupType;
    }

    /**
     * Legt den Wert der baliseGroupType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaliseGroupType(String value) {
        this.baliseGroupType = value;
    }

}
