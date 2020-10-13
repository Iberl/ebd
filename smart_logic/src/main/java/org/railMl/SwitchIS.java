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
 * <p>Java-Klasse für SwitchIS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SwitchIS">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackNode">
 *       &lt;sequence>
 *         &lt;element name="leftBranch" type="{https://www.railml.org/schemas/3.1}SwitchCrossingBranch" minOccurs="0"/>
 *         &lt;element name="rightBranch" type="{https://www.railml.org/schemas/3.1}SwitchCrossingBranch" minOccurs="0"/>
 *         &lt;element name="straightBranch" type="{https://www.railml.org/schemas/3.1}SwitchCrossingBranch" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="turningBranch" type="{https://www.railml.org/schemas/3.1}SwitchCrossingBranch" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="type" type="{https://www.railml.org/schemas/3.1}tSwitchType" />
 *       &lt;attribute name="continueCourse" type="{https://www.railml.org/schemas/3.1}tCourse" />
 *       &lt;attribute name="branchCourse" type="{https://www.railml.org/schemas/3.1}tCourse" />
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
@XmlType(name = "SwitchIS", propOrder = {
    "leftBranch",
    "rightBranch",
    "straightBranch",
    "turningBranch"
})
public class SwitchIS
    extends TrackNode
{

    protected SwitchCrossingBranch leftBranch;
    protected SwitchCrossingBranch rightBranch;
    protected List<SwitchCrossingBranch> straightBranch;
    protected List<SwitchCrossingBranch> turningBranch;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "type")
    protected TSwitchType type;
    @XmlAttribute(name = "continueCourse")
    protected TCourse continueCourse;
    @XmlAttribute(name = "branchCourse")
    protected TCourse branchCourse;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;

    /**
     * Ruft den Wert der leftBranch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchCrossingBranch }
     *     
     */
    public SwitchCrossingBranch getLeftBranch() {
        return leftBranch;
    }

    /**
     * Legt den Wert der leftBranch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchCrossingBranch }
     *     
     */
    public void setLeftBranch(SwitchCrossingBranch value) {
        this.leftBranch = value;
    }

    /**
     * Ruft den Wert der rightBranch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchCrossingBranch }
     *     
     */
    public SwitchCrossingBranch getRightBranch() {
        return rightBranch;
    }

    /**
     * Legt den Wert der rightBranch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchCrossingBranch }
     *     
     */
    public void setRightBranch(SwitchCrossingBranch value) {
        this.rightBranch = value;
    }

    /**
     * Gets the value of the straightBranch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the straightBranch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStraightBranch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchCrossingBranch }
     * 
     * 
     */
    public List<SwitchCrossingBranch> getStraightBranch() {
        if (straightBranch == null) {
            straightBranch = new ArrayList<SwitchCrossingBranch>();
        }
        return this.straightBranch;
    }

    /**
     * Gets the value of the turningBranch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the turningBranch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTurningBranch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchCrossingBranch }
     * 
     * 
     */
    public List<SwitchCrossingBranch> getTurningBranch() {
        if (turningBranch == null) {
            turningBranch = new ArrayList<SwitchCrossingBranch>();
        }
        return this.turningBranch;
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
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSwitchType }
     *     
     */
    public TSwitchType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSwitchType }
     *     
     */
    public void setType(TSwitchType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der continueCourse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCourse }
     *     
     */
    public TCourse getContinueCourse() {
        return continueCourse;
    }

    /**
     * Legt den Wert der continueCourse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCourse }
     *     
     */
    public void setContinueCourse(TCourse value) {
        this.continueCourse = value;
    }

    /**
     * Ruft den Wert der branchCourse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCourse }
     *     
     */
    public TCourse getBranchCourse() {
        return branchCourse;
    }

    /**
     * Legt den Wert der branchCourse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCourse }
     *     
     */
    public void setBranchCourse(TCourse value) {
        this.branchCourse = value;
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
