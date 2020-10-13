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
 * <p>Java-Klasse für ServiceSection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ServiceSection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aServiceSection"/>
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
@XmlType(name = "ServiceSection")
public class ServiceSection
    extends FunctionalInfrastructureEntity
{

    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "allowsCleaning")
    protected Boolean allowsCleaning;
    @XmlAttribute(name = "allowsFueling")
    protected Boolean allowsFueling;
    @XmlAttribute(name = "allowsLoading")
    protected Boolean allowsLoading;
    @XmlAttribute(name = "allowsMaintenance")
    protected Boolean allowsMaintenance;
    @XmlAttribute(name = "allowsParking")
    protected Boolean allowsParking;
    @XmlAttribute(name = "allowsPreheating")
    protected Boolean allowsPreheating;
    @XmlAttribute(name = "hasRamp")
    protected Boolean hasRamp;
    @XmlAttribute(name = "allowsToiletDischarge")
    protected Boolean allowsToiletDischarge;
    @XmlAttribute(name = "allowsWaterRestocking")
    protected Boolean allowsWaterRestocking;
    @XmlAttribute(name = "allowsSandRestocking")
    protected Boolean allowsSandRestocking;
    @XmlAttribute(name = "hasElectricSupply")
    protected Boolean hasElectricSupply;

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
     * Ruft den Wert der allowsCleaning-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsCleaning() {
        return allowsCleaning;
    }

    /**
     * Legt den Wert der allowsCleaning-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsCleaning(Boolean value) {
        this.allowsCleaning = value;
    }

    /**
     * Ruft den Wert der allowsFueling-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsFueling() {
        return allowsFueling;
    }

    /**
     * Legt den Wert der allowsFueling-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsFueling(Boolean value) {
        this.allowsFueling = value;
    }

    /**
     * Ruft den Wert der allowsLoading-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsLoading() {
        return allowsLoading;
    }

    /**
     * Legt den Wert der allowsLoading-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsLoading(Boolean value) {
        this.allowsLoading = value;
    }

    /**
     * Ruft den Wert der allowsMaintenance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsMaintenance() {
        return allowsMaintenance;
    }

    /**
     * Legt den Wert der allowsMaintenance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsMaintenance(Boolean value) {
        this.allowsMaintenance = value;
    }

    /**
     * Ruft den Wert der allowsParking-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsParking() {
        return allowsParking;
    }

    /**
     * Legt den Wert der allowsParking-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsParking(Boolean value) {
        this.allowsParking = value;
    }

    /**
     * Ruft den Wert der allowsPreheating-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsPreheating() {
        return allowsPreheating;
    }

    /**
     * Legt den Wert der allowsPreheating-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsPreheating(Boolean value) {
        this.allowsPreheating = value;
    }

    /**
     * Ruft den Wert der hasRamp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasRamp() {
        return hasRamp;
    }

    /**
     * Legt den Wert der hasRamp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasRamp(Boolean value) {
        this.hasRamp = value;
    }

    /**
     * Ruft den Wert der allowsToiletDischarge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsToiletDischarge() {
        return allowsToiletDischarge;
    }

    /**
     * Legt den Wert der allowsToiletDischarge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsToiletDischarge(Boolean value) {
        this.allowsToiletDischarge = value;
    }

    /**
     * Ruft den Wert der allowsWaterRestocking-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsWaterRestocking() {
        return allowsWaterRestocking;
    }

    /**
     * Legt den Wert der allowsWaterRestocking-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsWaterRestocking(Boolean value) {
        this.allowsWaterRestocking = value;
    }

    /**
     * Ruft den Wert der allowsSandRestocking-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowsSandRestocking() {
        return allowsSandRestocking;
    }

    /**
     * Legt den Wert der allowsSandRestocking-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowsSandRestocking(Boolean value) {
        this.allowsSandRestocking = value;
    }

    /**
     * Ruft den Wert der hasElectricSupply-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasElectricSupply() {
        return hasElectricSupply;
    }

    /**
     * Legt den Wert der hasElectricSupply-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasElectricSupply(Boolean value) {
        this.hasElectricSupply = value;
    }

}
