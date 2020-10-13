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
 * Extends the infrastructure::switch for IXL purposes. The graph model from RailTopoModel allows the definition of connections between tracks. Thus, one can include or exclude connections between tracks. The name SwitchIL is chosen to reconcile US nomenclature and to avoid a naming conflict with infrastructure domain.
 * 
 * <p>Java-Klasse für SwitchIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SwitchIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}MovableElement">
 *       &lt;sequence>
 *         &lt;element name="hasFoulingTrainDetectors" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="branchLeft" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="branchRight" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="hasPositionRestriction" type="{https://www.railml.org/schemas/3.1}SwitchPositionRestriction" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="preferredPosition" type="{https://www.railml.org/schemas/3.1}tSwitchPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwitchIL", propOrder = {
    "hasFoulingTrainDetectors",
    "branchLeft",
    "branchRight",
    "hasPositionRestriction"
})
public class SwitchIL
    extends MovableElement
{

    protected List<EntityILref> hasFoulingTrainDetectors;
    @XmlElement(required = true)
    protected EntityILref branchLeft;
    @XmlElement(required = true)
    protected EntityILref branchRight;
    protected SwitchPositionRestriction hasPositionRestriction;
    @XmlAttribute(name = "preferredPosition")
    protected TSwitchPosition preferredPosition;

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
     * Ruft den Wert der branchLeft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getBranchLeft() {
        return branchLeft;
    }

    /**
     * Legt den Wert der branchLeft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setBranchLeft(EntityILref value) {
        this.branchLeft = value;
    }

    /**
     * Ruft den Wert der branchRight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getBranchRight() {
        return branchRight;
    }

    /**
     * Legt den Wert der branchRight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setBranchRight(EntityILref value) {
        this.branchRight = value;
    }

    /**
     * Ruft den Wert der hasPositionRestriction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchPositionRestriction }
     *     
     */
    public SwitchPositionRestriction getHasPositionRestriction() {
        return hasPositionRestriction;
    }

    /**
     * Legt den Wert der hasPositionRestriction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchPositionRestriction }
     *     
     */
    public void setHasPositionRestriction(SwitchPositionRestriction value) {
        this.hasPositionRestriction = value;
    }

    /**
     * Ruft den Wert der preferredPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSwitchPosition }
     *     
     */
    public TSwitchPosition getPreferredPosition() {
        return preferredPosition;
    }

    /**
     * Legt den Wert der preferredPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSwitchPosition }
     *     
     */
    public void setPreferredPosition(TSwitchPosition value) {
        this.preferredPosition = value;
    }

}
