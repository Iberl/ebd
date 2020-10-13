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
import javax.xml.datatype.Duration;


/**
 * We define a route as an entry- and exit plus the positions of intermediate switches. If there are no switches in the route, no switch positions can be defined. If one or more switches are encountered en route, either facing or trailing, the positions of these switches must be given. There can be multiple routes from entry to exit depending on the positions of the intermediate switches. The user is free to create different routes with the same entry,exit and same switch positions that differ only by the classifier. This allows one to distinguish for example a traction-route from no-traction-route
 * 
 * <p>Java-Klasse für Route complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Route">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="handlesRouteType" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeActivationSection" type="{https://www.railml.org/schemas/3.1}RouteActivationSection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="facingSwitchInPosition" type="{https://www.railml.org/schemas/3.1}SwitchAndPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeEntry" type="{https://www.railml.org/schemas/3.1}RouteEntry"/>
 *         &lt;element name="hasReleaseGroup" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="switchPositionInDepartureTrack" type="{https://www.railml.org/schemas/3.1}SwitchAndPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeExit" type="{https://www.railml.org/schemas/3.1}RouteExit"/>
 *         &lt;element name="additionalRelation" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="locksAutomatically" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="processingDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="proceedAspectDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="signalClosureDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="approachReleaseDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Route", propOrder = {
    "handlesRouteType",
    "routeActivationSection",
    "facingSwitchInPosition",
    "hasTvdSection",
    "routeEntry",
    "hasReleaseGroup",
    "switchPositionInDepartureTrack",
    "routeExit",
    "additionalRelation"
})
public class Route
    extends TrackAsset
{

    protected List<EntityILref> handlesRouteType;
    protected List<RouteActivationSection> routeActivationSection;
    protected List<SwitchAndPosition> facingSwitchInPosition;
    protected List<EntityILref> hasTvdSection;
    @XmlElement(required = true)
    protected RouteEntry routeEntry;
    protected List<EntityILref> hasReleaseGroup;
    protected List<SwitchAndPosition> switchPositionInDepartureTrack;
    @XmlElement(required = true)
    protected RouteExit routeExit;
    protected List<EntityILref> additionalRelation;
    @XmlAttribute(name = "locksAutomatically")
    protected Boolean locksAutomatically;
    @XmlAttribute(name = "processingDelay")
    protected Duration processingDelay;
    @XmlAttribute(name = "proceedAspectDelay")
    protected Duration proceedAspectDelay;
    @XmlAttribute(name = "signalClosureDelay")
    protected Duration signalClosureDelay;
    @XmlAttribute(name = "approachReleaseDelay")
    protected Duration approachReleaseDelay;

    /**
     * Gets the value of the handlesRouteType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the handlesRouteType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHandlesRouteType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHandlesRouteType() {
        if (handlesRouteType == null) {
            handlesRouteType = new ArrayList<EntityILref>();
        }
        return this.handlesRouteType;
    }

    /**
     * Gets the value of the routeActivationSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the routeActivationSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRouteActivationSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteActivationSection }
     * 
     * 
     */
    public List<RouteActivationSection> getRouteActivationSection() {
        if (routeActivationSection == null) {
            routeActivationSection = new ArrayList<RouteActivationSection>();
        }
        return this.routeActivationSection;
    }

    /**
     * Gets the value of the facingSwitchInPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facingSwitchInPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacingSwitchInPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchAndPosition }
     * 
     * 
     */
    public List<SwitchAndPosition> getFacingSwitchInPosition() {
        if (facingSwitchInPosition == null) {
            facingSwitchInPosition = new ArrayList<SwitchAndPosition>();
        }
        return this.facingSwitchInPosition;
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
     * Ruft den Wert der routeEntry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RouteEntry }
     *     
     */
    public RouteEntry getRouteEntry() {
        return routeEntry;
    }

    /**
     * Legt den Wert der routeEntry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteEntry }
     *     
     */
    public void setRouteEntry(RouteEntry value) {
        this.routeEntry = value;
    }

    /**
     * Gets the value of the hasReleaseGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasReleaseGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasReleaseGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasReleaseGroup() {
        if (hasReleaseGroup == null) {
            hasReleaseGroup = new ArrayList<EntityILref>();
        }
        return this.hasReleaseGroup;
    }

    /**
     * Gets the value of the switchPositionInDepartureTrack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the switchPositionInDepartureTrack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwitchPositionInDepartureTrack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchAndPosition }
     * 
     * 
     */
    public List<SwitchAndPosition> getSwitchPositionInDepartureTrack() {
        if (switchPositionInDepartureTrack == null) {
            switchPositionInDepartureTrack = new ArrayList<SwitchAndPosition>();
        }
        return this.switchPositionInDepartureTrack;
    }

    /**
     * Ruft den Wert der routeExit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RouteExit }
     *     
     */
    public RouteExit getRouteExit() {
        return routeExit;
    }

    /**
     * Legt den Wert der routeExit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteExit }
     *     
     */
    public void setRouteExit(RouteExit value) {
        this.routeExit = value;
    }

    /**
     * Gets the value of the additionalRelation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalRelation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalRelation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getAdditionalRelation() {
        if (additionalRelation == null) {
            additionalRelation = new ArrayList<EntityILref>();
        }
        return this.additionalRelation;
    }

    /**
     * Ruft den Wert der locksAutomatically-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLocksAutomatically() {
        return locksAutomatically;
    }

    /**
     * Legt den Wert der locksAutomatically-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLocksAutomatically(Boolean value) {
        this.locksAutomatically = value;
    }

    /**
     * Ruft den Wert der processingDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getProcessingDelay() {
        return processingDelay;
    }

    /**
     * Legt den Wert der processingDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setProcessingDelay(Duration value) {
        this.processingDelay = value;
    }

    /**
     * Ruft den Wert der proceedAspectDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getProceedAspectDelay() {
        return proceedAspectDelay;
    }

    /**
     * Legt den Wert der proceedAspectDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setProceedAspectDelay(Duration value) {
        this.proceedAspectDelay = value;
    }

    /**
     * Ruft den Wert der signalClosureDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSignalClosureDelay() {
        return signalClosureDelay;
    }

    /**
     * Legt den Wert der signalClosureDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSignalClosureDelay(Duration value) {
        this.signalClosureDelay = value;
    }

    /**
     * Ruft den Wert der approachReleaseDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getApproachReleaseDelay() {
        return approachReleaseDelay;
    }

    /**
     * Legt den Wert der approachReleaseDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setApproachReleaseDelay(Duration value) {
        this.approachReleaseDelay = value;
    }

}
