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
 * <p>Java-Klasse für SignalSpeed complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalSpeed">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}SignalX">
 *       &lt;sequence>
 *         &lt;element name="refersToBeginOfSpeedSection" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="refersToEndOfSpeedSection" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{https://www.railml.org/schemas/3.1}tSignalSpeedType" />
 *       &lt;attribute name="trainRelation" type="{https://www.railml.org/schemas/3.1}tTrainRelation" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalSpeed", propOrder = {
    "refersToBeginOfSpeedSection",
    "refersToEndOfSpeedSection"
})
public class SignalSpeed
    extends SignalX
{

    protected List<TElementWithIDref> refersToBeginOfSpeedSection;
    protected List<TElementWithIDref> refersToEndOfSpeedSection;
    @XmlAttribute(name = "type")
    protected TSignalSpeedType type;
    @XmlAttribute(name = "trainRelation")
    protected TTrainRelation trainRelation;

    /**
     * Gets the value of the refersToBeginOfSpeedSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refersToBeginOfSpeedSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefersToBeginOfSpeedSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getRefersToBeginOfSpeedSection() {
        if (refersToBeginOfSpeedSection == null) {
            refersToBeginOfSpeedSection = new ArrayList<TElementWithIDref>();
        }
        return this.refersToBeginOfSpeedSection;
    }

    /**
     * Gets the value of the refersToEndOfSpeedSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refersToEndOfSpeedSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefersToEndOfSpeedSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getRefersToEndOfSpeedSection() {
        if (refersToEndOfSpeedSection == null) {
            refersToEndOfSpeedSection = new ArrayList<TElementWithIDref>();
        }
        return this.refersToEndOfSpeedSection;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSignalSpeedType }
     *     
     */
    public TSignalSpeedType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSignalSpeedType }
     *     
     */
    public void setType(TSignalSpeedType value) {
        this.type = value;
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

}
