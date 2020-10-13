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
 * <p>Java-Klasse für TrainRadio complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrainRadio">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="supportsBroadcastCalls" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="supportsDirectMode" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="supportsPublicEmergency" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="supportsPublicNetworkRoaming" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="radioSystem" type="{https://www.railml.org/schemas/3.1}tTrainRadioSystemExt" />
 *       &lt;attribute name="supportsTextMessageService" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="networkSelection" type="{https://www.railml.org/schemas/3.1}tTrainRadioNetworkSelectionExt" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrainRadio")
public class TrainRadio
    extends FunctionalInfrastructureEntity
{

    @XmlAttribute(name = "supportsBroadcastCalls")
    protected Boolean supportsBroadcastCalls;
    @XmlAttribute(name = "supportsDirectMode")
    protected Boolean supportsDirectMode;
    @XmlAttribute(name = "supportsPublicEmergency")
    protected Boolean supportsPublicEmergency;
    @XmlAttribute(name = "supportsPublicNetworkRoaming")
    protected Boolean supportsPublicNetworkRoaming;
    @XmlAttribute(name = "radioSystem")
    protected String radioSystem;
    @XmlAttribute(name = "supportsTextMessageService")
    protected Boolean supportsTextMessageService;
    @XmlAttribute(name = "networkSelection")
    protected String networkSelection;

    /**
     * Ruft den Wert der supportsBroadcastCalls-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsBroadcastCalls() {
        return supportsBroadcastCalls;
    }

    /**
     * Legt den Wert der supportsBroadcastCalls-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsBroadcastCalls(Boolean value) {
        this.supportsBroadcastCalls = value;
    }

    /**
     * Ruft den Wert der supportsDirectMode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsDirectMode() {
        return supportsDirectMode;
    }

    /**
     * Legt den Wert der supportsDirectMode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsDirectMode(Boolean value) {
        this.supportsDirectMode = value;
    }

    /**
     * Ruft den Wert der supportsPublicEmergency-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsPublicEmergency() {
        return supportsPublicEmergency;
    }

    /**
     * Legt den Wert der supportsPublicEmergency-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsPublicEmergency(Boolean value) {
        this.supportsPublicEmergency = value;
    }

    /**
     * Ruft den Wert der supportsPublicNetworkRoaming-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsPublicNetworkRoaming() {
        return supportsPublicNetworkRoaming;
    }

    /**
     * Legt den Wert der supportsPublicNetworkRoaming-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsPublicNetworkRoaming(Boolean value) {
        this.supportsPublicNetworkRoaming = value;
    }

    /**
     * Ruft den Wert der radioSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRadioSystem() {
        return radioSystem;
    }

    /**
     * Legt den Wert der radioSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRadioSystem(String value) {
        this.radioSystem = value;
    }

    /**
     * Ruft den Wert der supportsTextMessageService-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsTextMessageService() {
        return supportsTextMessageService;
    }

    /**
     * Legt den Wert der supportsTextMessageService-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsTextMessageService(Boolean value) {
        this.supportsTextMessageService = value;
    }

    /**
     * Ruft den Wert der networkSelection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkSelection() {
        return networkSelection;
    }

    /**
     * Legt den Wert der networkSelection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkSelection(String value) {
        this.networkSelection = value;
    }

}
