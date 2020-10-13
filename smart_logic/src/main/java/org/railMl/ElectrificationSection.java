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
 * <p>Java-Klasse für ElectrificationSection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ElectrificationSection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="electrificationSystemRef" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *         &lt;element name="energyCatenary" type="{https://www.railml.org/schemas/3.1}EnergyCatenary" minOccurs="0"/>
 *         &lt;element name="energyPantograph" type="{https://www.railml.org/schemas/3.1}EnergyPantograph" minOccurs="0"/>
 *         &lt;element name="energyRollingstock" type="{https://www.railml.org/schemas/3.1}EnergyRollingstock" minOccurs="0"/>
 *         &lt;element name="hasContactWire" type="{https://www.railml.org/schemas/3.1}ContactWire" minOccurs="0"/>
 *         &lt;element name="pantographSpacing" type="{https://www.railml.org/schemas/3.1}PantographSpacing" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="phaseSeparationSection" type="{https://www.railml.org/schemas/3.1}PhaseSeparationSection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="systemSeparationSection" type="{https://www.railml.org/schemas/3.1}SystemSeparationSection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="contactLineType" use="required" type="{https://www.railml.org/schemas/3.1}tContactLineType" />
 *       &lt;attribute name="isInsulatedSection" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
@XmlType(name = "ElectrificationSection", propOrder = {
    "electrificationSystemRef",
    "energyCatenary",
    "energyPantograph",
    "energyRollingstock",
    "hasContactWire",
    "pantographSpacing",
    "phaseSeparationSection",
    "systemSeparationSection"
})
public class ElectrificationSection
    extends FunctionalInfrastructureEntity
{

    protected TElementWithIDref electrificationSystemRef;
    protected EnergyCatenary energyCatenary;
    protected EnergyPantograph energyPantograph;
    protected EnergyRollingstock energyRollingstock;
    protected ContactWire hasContactWire;
    protected List<PantographSpacing> pantographSpacing;
    protected List<PhaseSeparationSection> phaseSeparationSection;
    protected List<SystemSeparationSection> systemSeparationSection;
    @XmlAttribute(name = "contactLineType", required = true)
    protected String contactLineType;
    @XmlAttribute(name = "isInsulatedSection")
    protected Boolean isInsulatedSection;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;

    /**
     * Ruft den Wert der electrificationSystemRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getElectrificationSystemRef() {
        return electrificationSystemRef;
    }

    /**
     * Legt den Wert der electrificationSystemRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setElectrificationSystemRef(TElementWithIDref value) {
        this.electrificationSystemRef = value;
    }

    /**
     * Ruft den Wert der energyCatenary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EnergyCatenary }
     *     
     */
    public EnergyCatenary getEnergyCatenary() {
        return energyCatenary;
    }

    /**
     * Legt den Wert der energyCatenary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyCatenary }
     *     
     */
    public void setEnergyCatenary(EnergyCatenary value) {
        this.energyCatenary = value;
    }

    /**
     * Ruft den Wert der energyPantograph-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EnergyPantograph }
     *     
     */
    public EnergyPantograph getEnergyPantograph() {
        return energyPantograph;
    }

    /**
     * Legt den Wert der energyPantograph-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyPantograph }
     *     
     */
    public void setEnergyPantograph(EnergyPantograph value) {
        this.energyPantograph = value;
    }

    /**
     * Ruft den Wert der energyRollingstock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EnergyRollingstock }
     *     
     */
    public EnergyRollingstock getEnergyRollingstock() {
        return energyRollingstock;
    }

    /**
     * Legt den Wert der energyRollingstock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyRollingstock }
     *     
     */
    public void setEnergyRollingstock(EnergyRollingstock value) {
        this.energyRollingstock = value;
    }

    /**
     * Ruft den Wert der hasContactWire-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactWire }
     *     
     */
    public ContactWire getHasContactWire() {
        return hasContactWire;
    }

    /**
     * Legt den Wert der hasContactWire-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactWire }
     *     
     */
    public void setHasContactWire(ContactWire value) {
        this.hasContactWire = value;
    }

    /**
     * Gets the value of the pantographSpacing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pantographSpacing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPantographSpacing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PantographSpacing }
     * 
     * 
     */
    public List<PantographSpacing> getPantographSpacing() {
        if (pantographSpacing == null) {
            pantographSpacing = new ArrayList<PantographSpacing>();
        }
        return this.pantographSpacing;
    }

    /**
     * Gets the value of the phaseSeparationSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phaseSeparationSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhaseSeparationSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhaseSeparationSection }
     * 
     * 
     */
    public List<PhaseSeparationSection> getPhaseSeparationSection() {
        if (phaseSeparationSection == null) {
            phaseSeparationSection = new ArrayList<PhaseSeparationSection>();
        }
        return this.phaseSeparationSection;
    }

    /**
     * Gets the value of the systemSeparationSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemSeparationSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemSeparationSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemSeparationSection }
     * 
     * 
     */
    public List<SystemSeparationSection> getSystemSeparationSection() {
        if (systemSeparationSection == null) {
            systemSeparationSection = new ArrayList<SystemSeparationSection>();
        }
        return this.systemSeparationSection;
    }

    /**
     * Ruft den Wert der contactLineType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactLineType() {
        return contactLineType;
    }

    /**
     * Legt den Wert der contactLineType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactLineType(String value) {
        this.contactLineType = value;
    }

    /**
     * Ruft den Wert der isInsulatedSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInsulatedSection() {
        return isInsulatedSection;
    }

    /**
     * Legt den Wert der isInsulatedSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInsulatedSection(Boolean value) {
        this.isInsulatedSection = value;
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

}
