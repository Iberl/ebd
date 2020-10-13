//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for the infrastructure model.
 * 
 * <p>Java-Klasse für Infrastructure complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Infrastructure">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}tElementWithID">
 *       &lt;all minOccurs="0">
 *         &lt;element name="topology" type="{https://www.railml.org/schemas/3.1}Topology" minOccurs="0"/>
 *         &lt;element name="geometry" type="{https://www.railml.org/schemas/3.1}Geometry" minOccurs="0"/>
 *         &lt;element name="functionalInfrastructure" type="{https://www.railml.org/schemas/3.1}FunctionalInfrastructure" minOccurs="0"/>
 *         &lt;element name="physicalFacilities" type="{https://www.railml.org/schemas/3.1}PhysicalFacilities" minOccurs="0"/>
 *         &lt;element name="infrastructureVisualizations" type="{https://www.railml.org/schemas/3.1}InfrastructureVisualizations" minOccurs="0"/>
 *         &lt;element name="infrastructureStates" type="{https://www.railml.org/schemas/3.1}InfrastructureStates" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infrastructure", propOrder = {
    "topology",
    "geometry",
    "functionalInfrastructure",
    "physicalFacilities",
    "infrastructureVisualizations",
    "infrastructureStates"
})
public class Infrastructure
    extends TElementWithID
{

    protected Topology topology;
    protected Geometry geometry;
    protected FunctionalInfrastructure functionalInfrastructure;
    protected PhysicalFacilities physicalFacilities;
    protected InfrastructureVisualizations infrastructureVisualizations;
    protected InfrastructureStates infrastructureStates;

    /**
     * Ruft den Wert der topology-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Topology }
     *     
     */
    public Topology getTopology() {
        return topology;
    }

    /**
     * Legt den Wert der topology-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Topology }
     *     
     */
    public void setTopology(Topology value) {
        this.topology = value;
    }

    /**
     * Ruft den Wert der geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Geometry }
     *     
     */
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     * Legt den Wert der geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Geometry }
     *     
     */
    public void setGeometry(Geometry value) {
        this.geometry = value;
    }

    /**
     * Ruft den Wert der functionalInfrastructure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FunctionalInfrastructure }
     *     
     */
    public FunctionalInfrastructure getFunctionalInfrastructure() {
        return functionalInfrastructure;
    }

    /**
     * Legt den Wert der functionalInfrastructure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionalInfrastructure }
     *     
     */
    public void setFunctionalInfrastructure(FunctionalInfrastructure value) {
        this.functionalInfrastructure = value;
    }

    /**
     * Ruft den Wert der physicalFacilities-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalFacilities }
     *     
     */
    public PhysicalFacilities getPhysicalFacilities() {
        return physicalFacilities;
    }

    /**
     * Legt den Wert der physicalFacilities-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalFacilities }
     *     
     */
    public void setPhysicalFacilities(PhysicalFacilities value) {
        this.physicalFacilities = value;
    }

    /**
     * Ruft den Wert der infrastructureVisualizations-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InfrastructureVisualizations }
     *     
     */
    public InfrastructureVisualizations getInfrastructureVisualizations() {
        return infrastructureVisualizations;
    }

    /**
     * Legt den Wert der infrastructureVisualizations-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InfrastructureVisualizations }
     *     
     */
    public void setInfrastructureVisualizations(InfrastructureVisualizations value) {
        this.infrastructureVisualizations = value;
    }

    /**
     * Ruft den Wert der infrastructureStates-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InfrastructureStates }
     *     
     */
    public InfrastructureStates getInfrastructureStates() {
        return infrastructureStates;
    }

    /**
     * Legt den Wert der infrastructureStates-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InfrastructureStates }
     *     
     */
    public void setInfrastructureStates(InfrastructureStates value) {
        this.infrastructureStates = value;
    }

}
