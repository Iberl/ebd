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
 * An under crossing describes a crossing, where something crosses under the railway line. The most common constructional type of an under crossing is a bridge.
 * 
 * <p>Java-Klasse für UnderCrossing complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="UnderCrossing">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}XCrossing">
 *       &lt;sequence>
 *         &lt;element name="allowedWeightLimit" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="length" type="{https://www.railml.org/schemas/3.1}Length" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aVerbalConstraint"/>
 *       &lt;attribute name="constructionType" use="required" type="{https://www.railml.org/schemas/3.1}tCrossingConstructionTypeExt" />
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnderCrossing", propOrder = {
    "allowedWeightLimit",
    "length"
})
public class UnderCrossing
    extends XCrossing
{

    protected List<TElementWithIDref> allowedWeightLimit;
    protected List<Length> length;
    @XmlAttribute(name = "constructionType", required = true)
    protected String constructionType;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "verbalConstraint")
    protected String verbalConstraint;

    /**
     * Gets the value of the allowedWeightLimit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedWeightLimit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedWeightLimit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getAllowedWeightLimit() {
        if (allowedWeightLimit == null) {
            allowedWeightLimit = new ArrayList<TElementWithIDref>();
        }
        return this.allowedWeightLimit;
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
     * Ruft den Wert der constructionType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstructionType() {
        return constructionType;
    }

    /**
     * Legt den Wert der constructionType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstructionType(String value) {
        this.constructionType = value;
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
     * Ruft den Wert der verbalConstraint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerbalConstraint() {
        return verbalConstraint;
    }

    /**
     * Legt den Wert der verbalConstraint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerbalConstraint(String value) {
        this.verbalConstraint = value;
    }

}
