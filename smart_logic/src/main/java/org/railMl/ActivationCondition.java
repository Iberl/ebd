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
 * The container to list all possible conditions for activating the level crossing.
 * 
 * <p>Java-Klasse für ActivationCondition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ActivationCondition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="delayBySwitchPosition" type="{https://www.railml.org/schemas/3.1}SwitchRelatedDelay" minOccurs="0"/>
 *         &lt;element name="aspectRelatedDelay" type="{https://www.railml.org/schemas/3.1}AspectRelatedLevelCrossingDelay" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="signalDelayTime" type="{https://www.railml.org/schemas/3.1}SignalDelayTime" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="activatedBy" type="{https://www.railml.org/schemas/3.1}ApproachStartingDetector" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="andOr" type="{https://www.railml.org/schemas/3.1}tAndOr" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivationCondition", propOrder = {
    "delayBySwitchPosition",
    "aspectRelatedDelay",
    "signalDelayTime",
    "activatedBy"
})
public class ActivationCondition
    extends EntityIL
{

    protected SwitchRelatedDelay delayBySwitchPosition;
    protected List<AspectRelatedLevelCrossingDelay> aspectRelatedDelay;
    protected List<SignalDelayTime> signalDelayTime;
    @XmlElement(required = true)
    protected List<ApproachStartingDetector> activatedBy;
    @XmlAttribute(name = "andOr")
    protected TAndOr andOr;

    /**
     * Ruft den Wert der delayBySwitchPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchRelatedDelay }
     *     
     */
    public SwitchRelatedDelay getDelayBySwitchPosition() {
        return delayBySwitchPosition;
    }

    /**
     * Legt den Wert der delayBySwitchPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchRelatedDelay }
     *     
     */
    public void setDelayBySwitchPosition(SwitchRelatedDelay value) {
        this.delayBySwitchPosition = value;
    }

    /**
     * Gets the value of the aspectRelatedDelay property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aspectRelatedDelay property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAspectRelatedDelay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AspectRelatedLevelCrossingDelay }
     * 
     * 
     */
    public List<AspectRelatedLevelCrossingDelay> getAspectRelatedDelay() {
        if (aspectRelatedDelay == null) {
            aspectRelatedDelay = new ArrayList<AspectRelatedLevelCrossingDelay>();
        }
        return this.aspectRelatedDelay;
    }

    /**
     * Gets the value of the signalDelayTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signalDelayTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignalDelayTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignalDelayTime }
     * 
     * 
     */
    public List<SignalDelayTime> getSignalDelayTime() {
        if (signalDelayTime == null) {
            signalDelayTime = new ArrayList<SignalDelayTime>();
        }
        return this.signalDelayTime;
    }

    /**
     * Gets the value of the activatedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activatedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivatedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApproachStartingDetector }
     * 
     * 
     */
    public List<ApproachStartingDetector> getActivatedBy() {
        if (activatedBy == null) {
            activatedBy = new ArrayList<ApproachStartingDetector>();
        }
        return this.activatedBy;
    }

    /**
     * Ruft den Wert der andOr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TAndOr }
     *     
     */
    public TAndOr getAndOr() {
        return andOr;
    }

    /**
     * Legt den Wert der andOr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TAndOr }
     *     
     */
    public void setAndOr(TAndOr value) {
        this.andOr = value;
    }

}
