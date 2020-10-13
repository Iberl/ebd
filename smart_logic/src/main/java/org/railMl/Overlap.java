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
 * INESS (INtegrated European Signalling System) definition: A defined section of track in advance of a stop signal, or a stopping point in a continuous signalling system, which must be kept clear to avoid the risk of collision should a train inadvertently run past the signal or the stopping point.
 * Many IMs require overlap beyond active routes to protect from overshoot. One or more sections beyond the exit signal are locked out from use by other routes. The overlap is delimited by train detectors. Facing switches in the overlap are locked, otherwise, use the swinging overlap. Trailing switches in the overlap may normally not locked. Note that there is no need to explicitly identify the switches in the overlap because they can be derived from the begin and endpoints of the overlap.
 * The overlap can be released if the RBC deems that an approaching train is slow enough such that overshoot is unlikely.
 * Trains other than the one for which the route-overlap is locked may be attributed a permitted speed in the overlap. If the value is set to 0 it is not possible to set a route through the overlap. Compare this variable with the release speed that applies to the train that is being released beyond the danger point.
 * 
 * <p>Java-Klasse für Overlap complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Overlap">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="activeForApproachRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="relatedToTrackAsset" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="requiresSwitchInPosition" type="{https://www.railml.org/schemas/3.1}SwitchAndGivenPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiresLevelCrossingInState" type="{https://www.railml.org/schemas/3.1}LevelCrossingAndGivenState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isLimitedBy" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="overlapRelease" type="{https://www.railml.org/schemas/3.1}OverlapRelease" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="releaseSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="overlapSpeed" type="{https://www.railml.org/schemas/3.1}tSpeedKmPerHour" />
 *       &lt;attribute name="overlapValidityTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="length" type="{https://www.railml.org/schemas/3.1}tLengthM" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Overlap", propOrder = {
    "activeForApproachRoute",
    "relatedToTrackAsset",
    "requiresSwitchInPosition",
    "requiresLevelCrossingInState",
    "hasTvdSection",
    "isLimitedBy",
    "overlapRelease"
})
public class Overlap
    extends EntityIL
{

    protected List<EntityILref> activeForApproachRoute;
    protected EntityILref relatedToTrackAsset;
    protected List<SwitchAndGivenPosition> requiresSwitchInPosition;
    protected List<LevelCrossingAndGivenState> requiresLevelCrossingInState;
    protected List<EntityILref> hasTvdSection;
    protected List<EntityILref> isLimitedBy;
    protected OverlapRelease overlapRelease;
    @XmlAttribute(name = "releaseSpeed")
    protected BigDecimal releaseSpeed;
    @XmlAttribute(name = "overlapSpeed")
    protected BigDecimal overlapSpeed;
    @XmlAttribute(name = "overlapValidityTime")
    protected Duration overlapValidityTime;
    @XmlAttribute(name = "length")
    protected BigDecimal length;

    /**
     * Gets the value of the activeForApproachRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeForApproachRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveForApproachRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getActiveForApproachRoute() {
        if (activeForApproachRoute == null) {
            activeForApproachRoute = new ArrayList<EntityILref>();
        }
        return this.activeForApproachRoute;
    }

    /**
     * Ruft den Wert der relatedToTrackAsset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRelatedToTrackAsset() {
        return relatedToTrackAsset;
    }

    /**
     * Legt den Wert der relatedToTrackAsset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRelatedToTrackAsset(EntityILref value) {
        this.relatedToTrackAsset = value;
    }

    /**
     * Gets the value of the requiresSwitchInPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiresSwitchInPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiresSwitchInPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchAndGivenPosition }
     * 
     * 
     */
    public List<SwitchAndGivenPosition> getRequiresSwitchInPosition() {
        if (requiresSwitchInPosition == null) {
            requiresSwitchInPosition = new ArrayList<SwitchAndGivenPosition>();
        }
        return this.requiresSwitchInPosition;
    }

    /**
     * Gets the value of the requiresLevelCrossingInState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiresLevelCrossingInState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiresLevelCrossingInState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelCrossingAndGivenState }
     * 
     * 
     */
    public List<LevelCrossingAndGivenState> getRequiresLevelCrossingInState() {
        if (requiresLevelCrossingInState == null) {
            requiresLevelCrossingInState = new ArrayList<LevelCrossingAndGivenState>();
        }
        return this.requiresLevelCrossingInState;
    }

    /**
     * Gets the value of the hasTvdSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasTvdSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasTvdSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasTvdSection() {
        if (hasTvdSection == null) {
            hasTvdSection = new ArrayList<EntityILref>();
        }
        return this.hasTvdSection;
    }

    /**
     * Gets the value of the isLimitedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isLimitedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsLimitedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getIsLimitedBy() {
        if (isLimitedBy == null) {
            isLimitedBy = new ArrayList<EntityILref>();
        }
        return this.isLimitedBy;
    }

    /**
     * Ruft den Wert der overlapRelease-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OverlapRelease }
     *     
     */
    public OverlapRelease getOverlapRelease() {
        return overlapRelease;
    }

    /**
     * Legt den Wert der overlapRelease-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OverlapRelease }
     *     
     */
    public void setOverlapRelease(OverlapRelease value) {
        this.overlapRelease = value;
    }

    /**
     * Ruft den Wert der releaseSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReleaseSpeed() {
        return releaseSpeed;
    }

    /**
     * Legt den Wert der releaseSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReleaseSpeed(BigDecimal value) {
        this.releaseSpeed = value;
    }

    /**
     * Ruft den Wert der overlapSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverlapSpeed() {
        return overlapSpeed;
    }

    /**
     * Legt den Wert der overlapSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverlapSpeed(BigDecimal value) {
        this.overlapSpeed = value;
    }

    /**
     * Ruft den Wert der overlapValidityTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getOverlapValidityTime() {
        return overlapValidityTime;
    }

    /**
     * Legt den Wert der overlapValidityTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setOverlapValidityTime(Duration value) {
        this.overlapValidityTime = value;
    }

    /**
     * Ruft den Wert der length-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Legt den Wert der length-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLength(BigDecimal value) {
        this.length = value;
    }

}
