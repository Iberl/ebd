//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Platform complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Platform">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="ownsPlatformEdge" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="width" type="{https://www.railml.org/schemas/3.1}Length" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="length" type="{https://www.railml.org/schemas/3.1}Length" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="basedOnTemplate" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="height" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Platform", propOrder = {
    "ownsPlatformEdge",
    "width",
    "length"
})
public class Platform
    extends FunctionalInfrastructureEntity
{

    protected List<TElementWithIDref> ownsPlatformEdge;
    protected List<Length> width;
    protected List<Length> length;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;
    @XmlAttribute(name = "height")
    protected BigDecimal height;

    /**
     * Gets the value of the ownsPlatformEdge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsPlatformEdge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsPlatformEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getOwnsPlatformEdge() {
        if (ownsPlatformEdge == null) {
            ownsPlatformEdge = new ArrayList<TElementWithIDref>();
        }
        return this.ownsPlatformEdge;
    }

    /**
     * Gets the value of the width property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the width property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWidth().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Length }
     * 
     * 
     */
    public List<Length> getWidth() {
        if (width == null) {
            width = new ArrayList<Length>();
        }
        return this.width;
    }

    /**
     * Gets the value of the length property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the length property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLength().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Length }
     * 
     * 
     */
    public List<Length> getLength() {
        if (length == null) {
            length = new ArrayList<Length>();
        }
        return this.length;
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
     * Ruft den Wert der height-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Legt den Wert der height-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

}
