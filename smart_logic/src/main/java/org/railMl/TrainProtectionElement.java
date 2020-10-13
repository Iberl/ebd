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
 * <p>Java-Klasse für TrainProtectionElement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrainProtectionElement">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aTrainProtection"/>
 *       &lt;attribute name="basedOnTemplate" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrainProtectionElement")
public class TrainProtectionElement
    extends FunctionalInfrastructureEntity
{

    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;
    @XmlAttribute(name = "trainProtectionSystem", required = true)
    protected String trainProtectionSystem;
    @XmlAttribute(name = "medium")
    protected TTrainProtectionMedium medium;
    @XmlAttribute(name = "monitoring")
    protected TTrainProtectionMonitoring monitoring;

    /**
     * Ruft den Wert der basedOnTemplate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasedOnTemplate() {
        return basedOnTemplate;
    }

    /**
     * Legt den Wert der basedOnTemplate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasedOnTemplate(String value) {
        this.basedOnTemplate = value;
    }

    /**
     * Ruft den Wert der trainProtectionSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainProtectionSystem() {
        return trainProtectionSystem;
    }

    /**
     * Legt den Wert der trainProtectionSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainProtectionSystem(String value) {
        this.trainProtectionSystem = value;
    }

    /**
     * Ruft den Wert der medium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTrainProtectionMedium }
     *     
     */
    public TTrainProtectionMedium getMedium() {
        return medium;
    }

    /**
     * Legt den Wert der medium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrainProtectionMedium }
     *     
     */
    public void setMedium(TTrainProtectionMedium value) {
        this.medium = value;
    }

    /**
     * Ruft den Wert der monitoring-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTrainProtectionMonitoring }
     *     
     */
    public TTrainProtectionMonitoring getMonitoring() {
        return monitoring;
    }

    /**
     * Legt den Wert der monitoring-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrainProtectionMonitoring }
     *     
     */
    public void setMonitoring(TTrainProtectionMonitoring value) {
        this.monitoring = value;
    }

}
