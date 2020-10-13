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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Crossings are a special item for interlockings as a position is required for them even if there is no really movable item trackside.
 * Some crossings, especially high speed ones, have a movable frog to close the gap at the crossing (UK: movable nose crossing, DE: Herzstück mit beweglicher Spitze, NL: kruising met beweegbaar puntstuk). Unlike a switch, such a movable frog will not send the train left or right but it does guide the train. Thus the position is essential for avoiding derailment. Do not confound this class with ordinary double or single slip switches. The latter are regarded as two back-to-back switches.
 * 
 * <p>Java-Klasse für MovableCrossing complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MovableCrossing">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}MovableElement">
 *       &lt;sequence>
 *         &lt;element name="branchUpLeft" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="branchUpRight" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="branchDownLeft" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="branchDownRight" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="hasFoulingTrainDetectors" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="preferredPosition" type="{https://www.railml.org/schemas/3.1}tCrossingPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovableCrossing", propOrder = {
    "branchUpLeft",
    "branchUpRight",
    "branchDownLeft",
    "branchDownRight",
    "hasFoulingTrainDetectors"
})
public class MovableCrossing
    extends MovableElement
{

    @XmlElement(required = true)
    protected EntityILref branchUpLeft;
    @XmlElement(required = true)
    protected EntityILref branchUpRight;
    @XmlElement(required = true)
    protected EntityILref branchDownLeft;
    @XmlElement(required = true)
    protected EntityILref branchDownRight;
    protected List<EntityILref> hasFoulingTrainDetectors;
    @XmlAttribute(name = "preferredPosition")
    protected TCrossingPosition preferredPosition;

    /**
     * Ruft den Wert der branchUpLeft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getBranchUpLeft() {
        return branchUpLeft;
    }

    /**
     * Legt den Wert der branchUpLeft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setBranchUpLeft(EntityILref value) {
        this.branchUpLeft = value;
    }

    /**
     * Ruft den Wert der branchUpRight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getBranchUpRight() {
        return branchUpRight;
    }

    /**
     * Legt den Wert der branchUpRight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setBranchUpRight(EntityILref value) {
        this.branchUpRight = value;
    }

    /**
     * Ruft den Wert der branchDownLeft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getBranchDownLeft() {
        return branchDownLeft;
    }

    /**
     * Legt den Wert der branchDownLeft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setBranchDownLeft(EntityILref value) {
        this.branchDownLeft = value;
    }

    /**
     * Ruft den Wert der branchDownRight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getBranchDownRight() {
        return branchDownRight;
    }

    /**
     * Legt den Wert der branchDownRight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setBranchDownRight(EntityILref value) {
        this.branchDownRight = value;
    }

    /**
     * Gets the value of the hasFoulingTrainDetectors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasFoulingTrainDetectors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasFoulingTrainDetectors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasFoulingTrainDetectors() {
        if (hasFoulingTrainDetectors == null) {
            hasFoulingTrainDetectors = new ArrayList<EntityILref>();
        }
        return this.hasFoulingTrainDetectors;
    }

    /**
     * Ruft den Wert der preferredPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCrossingPosition }
     *     
     */
    public TCrossingPosition getPreferredPosition() {
        return preferredPosition;
    }

    /**
     * Legt den Wert der preferredPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCrossingPosition }
     *     
     */
    public void setPreferredPosition(TCrossingPosition value) {
        this.preferredPosition = value;
    }

}
