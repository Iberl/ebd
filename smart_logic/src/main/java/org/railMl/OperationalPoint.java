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
 * The OperationalPoint defines a point in the railway network that is essential for railway operation. Typical examples for railway operational points are stations, block signals or stopping points. Operational points allow an interaction between the railway operator and the train driver.
 * 
 * <p>Java-Klasse für OperationalPoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OperationalPoint">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="infrastructureManagerRef" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="connectedToLine" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="limitedByBorder" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="opEquipment" type="{https://www.railml.org/schemas/3.1}OpEquipment" minOccurs="0"/>
 *         &lt;element name="opOperations" type="{https://www.railml.org/schemas/3.1}OpOperations" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="basedOnTemplate" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationalPoint", propOrder = {
    "infrastructureManagerRef",
    "connectedToLine",
    "limitedByBorder",
    "opEquipment",
    "opOperations"
})
public class OperationalPoint
    extends FunctionalInfrastructureEntity
{

    protected List<TElementWithIDref> infrastructureManagerRef;
    protected List<TElementWithIDref> connectedToLine;
    protected List<TElementWithIDref> limitedByBorder;
    protected OpEquipment opEquipment;
    protected OpOperations opOperations;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;
    @XmlAttribute(name = "timezone")
    protected String timezone;

    /**
     * Gets the value of the infrastructureManagerRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infrastructureManagerRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfrastructureManagerRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getInfrastructureManagerRef() {
        if (infrastructureManagerRef == null) {
            infrastructureManagerRef = new ArrayList<TElementWithIDref>();
        }
        return this.infrastructureManagerRef;
    }

    /**
     * Gets the value of the connectedToLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectedToLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectedToLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getConnectedToLine() {
        if (connectedToLine == null) {
            connectedToLine = new ArrayList<TElementWithIDref>();
        }
        return this.connectedToLine;
    }

    /**
     * Gets the value of the limitedByBorder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the limitedByBorder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimitedByBorder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getLimitedByBorder() {
        if (limitedByBorder == null) {
            limitedByBorder = new ArrayList<TElementWithIDref>();
        }
        return this.limitedByBorder;
    }

    /**
     * Ruft den Wert der opEquipment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OpEquipment }
     *     
     */
    public OpEquipment getOpEquipment() {
        return opEquipment;
    }

    /**
     * Legt den Wert der opEquipment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OpEquipment }
     *     
     */
    public void setOpEquipment(OpEquipment value) {
        this.opEquipment = value;
    }

    /**
     * Ruft den Wert der opOperations-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OpOperations }
     *     
     */
    public OpOperations getOpOperations() {
        return opOperations;
    }

    /**
     * Legt den Wert der opOperations-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OpOperations }
     *     
     */
    public void setOpOperations(OpOperations value) {
        this.opOperations = value;
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
     * Ruft den Wert der timezone-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Legt den Wert der timezone-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

}
