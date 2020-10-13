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
 * <p>Java-Klasse für TrackBed complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrackBed">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aTrackbed"/>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackBed")
public class TrackBed
    extends FunctionalInfrastructureEntity
{

    @XmlAttribute(name = "ballastType")
    protected TBallastType ballastType;
    @XmlAttribute(name = "railType")
    protected String railType;
    @XmlAttribute(name = "sleepersType")
    protected TSleepersType sleepersType;
    @XmlAttribute(name = "jointsType")
    protected TJointsType jointsType;

    /**
     * Ruft den Wert der ballastType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TBallastType }
     *     
     */
    public TBallastType getBallastType() {
        return ballastType;
    }

    /**
     * Legt den Wert der ballastType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TBallastType }
     *     
     */
    public void setBallastType(TBallastType value) {
        this.ballastType = value;
    }

    /**
     * Ruft den Wert der railType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRailType() {
        return railType;
    }

    /**
     * Legt den Wert der railType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRailType(String value) {
        this.railType = value;
    }

    /**
     * Ruft den Wert der sleepersType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSleepersType }
     *     
     */
    public TSleepersType getSleepersType() {
        return sleepersType;
    }

    /**
     * Legt den Wert der sleepersType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSleepersType }
     *     
     */
    public void setSleepersType(TSleepersType value) {
        this.sleepersType = value;
    }

    /**
     * Ruft den Wert der jointsType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TJointsType }
     *     
     */
    public TJointsType getJointsType() {
        return jointsType;
    }

    /**
     * Legt den Wert der jointsType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TJointsType }
     *     
     */
    public void setJointsType(TJointsType value) {
        this.jointsType = value;
    }

}
