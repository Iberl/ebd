//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für StoppingPlace complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StoppingPlace">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="validForTrainMovement" type="{https://www.railml.org/schemas/3.1}TrainMovement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aStoppingPlace"/>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoppingPlace", propOrder = {
    "validForTrainMovement"
})
public class StoppingPlace
    extends FunctionalInfrastructureEntity
{

    protected List<TrainMovement> validForTrainMovement;
    @XmlAttribute(name = "isSignalized")
    protected Boolean isSignalized;
    @XmlAttribute(name = "trainRelation")
    protected TTrainRelation trainRelation;
    @XmlAttribute(name = "platformEdgeRef")
    protected String platformEdgeRef;
    @XmlAttribute(name = "trainLength")
    protected BigDecimal trainLength;
    @XmlAttribute(name = "axleCount")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger axleCount;
    @XmlAttribute(name = "wagonCount")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger wagonCount;
    @XmlAttribute(name = "verbalConstraint")
    protected String verbalConstraint;

    /**
     * Gets the value of the validForTrainMovement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validForTrainMovement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidForTrainMovement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrainMovement }
     * 
     * 
     */
    public List<TrainMovement> getValidForTrainMovement() {
        if (validForTrainMovement == null) {
            validForTrainMovement = new ArrayList<TrainMovement>();
        }
        return this.validForTrainMovement;
    }

    /**
     * Ruft den Wert der isSignalized-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSignalized() {
        return isSignalized;
    }

    /**
     * Legt den Wert der isSignalized-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSignalized(Boolean value) {
        this.isSignalized = value;
    }

    /**
     * Ruft den Wert der trainRelation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTrainRelation }
     *     
     */
    public TTrainRelation getTrainRelation() {
        return trainRelation;
    }

    /**
     * Legt den Wert der trainRelation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrainRelation }
     *     
     */
    public void setTrainRelation(TTrainRelation value) {
        this.trainRelation = value;
    }

    /**
     * Ruft den Wert der platformEdgeRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformEdgeRef() {
        return platformEdgeRef;
    }

    /**
     * Legt den Wert der platformEdgeRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformEdgeRef(String value) {
        this.platformEdgeRef = value;
    }

    /**
     * Ruft den Wert der trainLength-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrainLength() {
        return trainLength;
    }

    /**
     * Legt den Wert der trainLength-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrainLength(BigDecimal value) {
        this.trainLength = value;
    }

    /**
     * Ruft den Wert der axleCount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAxleCount() {
        return axleCount;
    }

    /**
     * Legt den Wert der axleCount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAxleCount(BigInteger value) {
        this.axleCount = value;
    }

    /**
     * Ruft den Wert der wagonCount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWagonCount() {
        return wagonCount;
    }

    /**
     * Legt den Wert der wagonCount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWagonCount(BigInteger value) {
        this.wagonCount = value;
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
