//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * A track vacancy detection (TVD) section reports train occupancy to the interlocking. This is a logical unit characterised by the delimiters of the section. Typically, a section is delimited by two insulated track joints or axle counters at the extremities. Sections with a switch or a crossing can have several such limits.
 * 
 * <p>Java-Klasse für TvdSection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TvdSection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="hasDemarcatingBufferstop" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="hasExitSignal" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="hasDemarcatingTraindetector" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasResetStrategy" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isBerthingTrack" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="residualRouteCancellationDelay" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="partialRouteReleaseDelay" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="technology" type="{https://www.railml.org/schemas/3.1}tTvdSectionTechnologyTypeExt" />
 *       &lt;attribute name="frequency" type="{https://www.railml.org/schemas/3.1}tFrequencyHertz" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TvdSection", propOrder = {
    "hasDemarcatingBufferstop",
    "hasExitSignal",
    "hasDemarcatingTraindetector",
    "hasResetStrategy"
})
public class TvdSection
    extends TrackAsset
{

    protected List<EntityILref> hasDemarcatingBufferstop;
    protected List<EntityILref> hasExitSignal;
    protected List<EntityILref> hasDemarcatingTraindetector;
    protected EntityILref hasResetStrategy;
    @XmlAttribute(name = "isBerthingTrack")
    protected Boolean isBerthingTrack;
    @XmlAttribute(name = "residualRouteCancellationDelay", required = true)
    protected Duration residualRouteCancellationDelay;
    @XmlAttribute(name = "partialRouteReleaseDelay", required = true)
    protected Duration partialRouteReleaseDelay;
    @XmlAttribute(name = "technology")
    protected String technology;
    @XmlAttribute(name = "frequency")
    protected BigDecimal frequency;

    /**
     * Gets the value of the hasDemarcatingBufferstop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasDemarcatingBufferstop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasDemarcatingBufferstop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasDemarcatingBufferstop() {
        if (hasDemarcatingBufferstop == null) {
            hasDemarcatingBufferstop = new ArrayList<EntityILref>();
        }
        return this.hasDemarcatingBufferstop;
    }

    /**
     * Gets the value of the hasExitSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasExitSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasExitSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasExitSignal() {
        if (hasExitSignal == null) {
            hasExitSignal = new ArrayList<EntityILref>();
        }
        return this.hasExitSignal;
    }

    /**
     * Gets the value of the hasDemarcatingTraindetector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasDemarcatingTraindetector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasDemarcatingTraindetector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasDemarcatingTraindetector() {
        if (hasDemarcatingTraindetector == null) {
            hasDemarcatingTraindetector = new ArrayList<EntityILref>();
        }
        return this.hasDemarcatingTraindetector;
    }

    /**
     * Ruft den Wert der hasResetStrategy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getHasResetStrategy() {
        return hasResetStrategy;
    }

    /**
     * Legt den Wert der hasResetStrategy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setHasResetStrategy(EntityILref value) {
        this.hasResetStrategy = value;
    }

    /**
     * Ruft den Wert der isBerthingTrack-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsBerthingTrack() {
        return isBerthingTrack;
    }

    /**
     * Legt den Wert der isBerthingTrack-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsBerthingTrack(Boolean value) {
        this.isBerthingTrack = value;
    }

    /**
     * Ruft den Wert der residualRouteCancellationDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getResidualRouteCancellationDelay() {
        return residualRouteCancellationDelay;
    }

    /**
     * Legt den Wert der residualRouteCancellationDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setResidualRouteCancellationDelay(Duration value) {
        this.residualRouteCancellationDelay = value;
    }

    /**
     * Ruft den Wert der partialRouteReleaseDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getPartialRouteReleaseDelay() {
        return partialRouteReleaseDelay;
    }

    /**
     * Legt den Wert der partialRouteReleaseDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setPartialRouteReleaseDelay(Duration value) {
        this.partialRouteReleaseDelay = value;
    }

    /**
     * Ruft den Wert der technology-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * Legt den Wert der technology-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnology(String value) {
        this.technology = value;
    }

    /**
     * Ruft den Wert der frequency-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFrequency() {
        return frequency;
    }

    /**
     * Legt den Wert der frequency-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFrequency(BigDecimal value) {
        this.frequency = value;
    }

}
