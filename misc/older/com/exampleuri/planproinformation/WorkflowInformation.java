//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package com.exampleuri.planproinformation;

import javax.xml.bind.annotation.*;


/**
 * <p>Java-Klasse f�r WorkflowInformation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WorkflowInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ExampleValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObjectType" type="{http://www.exampleURI.com/PlanProInformation}ENUMObjectType" minOccurs="0"/>
 *         &lt;element name="PlanningStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProposedValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowInformation", propOrder = {

})
public class WorkflowInformation {

    @XmlElement(name = "ExampleValue")
    protected String exampleValue;
    @XmlElement(name = "ObjectType")
    @XmlSchemaType(name = "string")
    protected ENUMObjectType objectType;
    @XmlElement(name = "PlanningStage")
    protected String planningStage;
    @XmlElement(name = "ProposedValue")
    protected String proposedValue;

    /**
     * Ruft den Wert der exampleValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExampleValue() {
        return exampleValue;
    }

    /**
     * Legt den Wert der exampleValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExampleValue(String value) {
        this.exampleValue = value;
    }

    /**
     * Ruft den Wert der objectType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ENUMObjectType }
     *     
     */
    public ENUMObjectType getObjectType() {
        return objectType;
    }

    /**
     * Legt den Wert der objectType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ENUMObjectType }
     *     
     */
    public void setObjectType(ENUMObjectType value) {
        this.objectType = value;
    }

    /**
     * Ruft den Wert der planningStage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanningStage() {
        return planningStage;
    }

    /**
     * Legt den Wert der planningStage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanningStage(String value) {
        this.planningStage = value;
    }

    /**
     * Ruft den Wert der proposedValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProposedValue() {
        return proposedValue;
    }

    /**
     * Legt den Wert der proposedValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProposedValue(String value) {
        this.proposedValue = value;
    }

}
