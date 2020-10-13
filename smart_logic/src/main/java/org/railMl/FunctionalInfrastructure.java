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
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for railML3 functional infrastructure model.
 * 
 * <p>Java-Klasse für FunctionalInfrastructure complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FunctionalInfrastructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balises" type="{https://www.railml.org/schemas/3.1}Balises" minOccurs="0"/>
 *         &lt;element name="borders" type="{https://www.railml.org/schemas/3.1}Borders" minOccurs="0"/>
 *         &lt;element name="bufferStops" type="{https://www.railml.org/schemas/3.1}BufferStops" minOccurs="0"/>
 *         &lt;element name="crossings" type="{https://www.railml.org/schemas/3.1}Crossings" minOccurs="0"/>
 *         &lt;element name="derailersIS" type="{https://www.railml.org/schemas/3.1}DerailersIS" minOccurs="0"/>
 *         &lt;element name="electrifications" type="{https://www.railml.org/schemas/3.1}Electrifications" minOccurs="0"/>
 *         &lt;element name="keyLocksIS" type="{https://www.railml.org/schemas/3.1}KeyLocksIS" minOccurs="0"/>
 *         &lt;element name="levelCrossingsIS" type="{https://www.railml.org/schemas/3.1}LevelCrossingsIS" minOccurs="0"/>
 *         &lt;element name="lines" type="{https://www.railml.org/schemas/3.1}Lines" minOccurs="0"/>
 *         &lt;element name="loadingGauges" type="{https://www.railml.org/schemas/3.1}LoadingGauges" minOccurs="0"/>
 *         &lt;element name="operationalPoints" type="{https://www.railml.org/schemas/3.1}OperationalPoints" minOccurs="0"/>
 *         &lt;element name="overCrossings" type="{https://www.railml.org/schemas/3.1}OverCrossings" minOccurs="0"/>
 *         &lt;element name="platforms" type="{https://www.railml.org/schemas/3.1}Platforms" minOccurs="0"/>
 *         &lt;element name="restrictionAreas" type="{https://www.railml.org/schemas/3.1}RestrictionAreas" minOccurs="0"/>
 *         &lt;element name="serviceSections" type="{https://www.railml.org/schemas/3.1}ServiceSections" minOccurs="0"/>
 *         &lt;element name="signalsIS" type="{https://www.railml.org/schemas/3.1}SignalsIS" minOccurs="0"/>
 *         &lt;element name="speeds" type="{https://www.railml.org/schemas/3.1}Speeds" minOccurs="0"/>
 *         &lt;element name="stoppingPlaces" type="{https://www.railml.org/schemas/3.1}StoppingPlaces" minOccurs="0"/>
 *         &lt;element name="switchesIS" type="{https://www.railml.org/schemas/3.1}SwitchesIS" minOccurs="0"/>
 *         &lt;element name="tracks" type="{https://www.railml.org/schemas/3.1}Tracks" minOccurs="0"/>
 *         &lt;element name="trackBeds" type="{https://www.railml.org/schemas/3.1}TrackBeds" minOccurs="0"/>
 *         &lt;element name="trackGauges" type="{https://www.railml.org/schemas/3.1}TrackGauges" minOccurs="0"/>
 *         &lt;element name="trainDetectionElements" type="{https://www.railml.org/schemas/3.1}TrainDetectionElements" minOccurs="0"/>
 *         &lt;element name="trainProtectionElements" type="{https://www.railml.org/schemas/3.1}TrainProtectionElements" minOccurs="0"/>
 *         &lt;element name="trainRadios" type="{https://www.railml.org/schemas/3.1}TrainRadios" minOccurs="0"/>
 *         &lt;element name="underCrossings" type="{https://www.railml.org/schemas/3.1}UnderCrossings" minOccurs="0"/>
 *         &lt;element name="weightLimits" type="{https://www.railml.org/schemas/3.1}WeightLimits" minOccurs="0"/>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionalInfrastructure", propOrder = {
    "balises",
    "borders",
    "bufferStops",
    "crossings",
    "derailersIS",
    "electrifications",
    "keyLocksIS",
    "levelCrossingsIS",
    "lines",
    "loadingGauges",
    "operationalPoints",
    "overCrossings",
    "platforms",
    "restrictionAreas",
    "serviceSections",
    "signalsIS",
    "speeds",
    "stoppingPlaces",
    "switchesIS",
    "tracks",
    "trackBeds",
    "trackGauges",
    "trainDetectionElements",
    "trainProtectionElements",
    "trainRadios",
    "underCrossings",
    "weightLimits",
    "any"
})
public class FunctionalInfrastructure {

    protected Balises balises;
    protected Borders borders;
    protected BufferStops bufferStops;
    protected Crossings crossings;
    protected DerailersIS derailersIS;
    protected Electrifications electrifications;
    protected KeyLocksIS keyLocksIS;
    protected LevelCrossingsIS levelCrossingsIS;
    protected Lines lines;
    protected LoadingGauges loadingGauges;
    protected OperationalPoints operationalPoints;
    protected OverCrossings overCrossings;
    protected Platforms platforms;
    protected RestrictionAreas restrictionAreas;
    protected ServiceSections serviceSections;
    protected SignalsIS signalsIS;
    protected Speeds speeds;
    protected StoppingPlaces stoppingPlaces;
    protected SwitchesIS switchesIS;
    protected Tracks tracks;
    protected TrackBeds trackBeds;
    protected TrackGauges trackGauges;
    protected TrainDetectionElements trainDetectionElements;
    protected TrainProtectionElements trainProtectionElements;
    protected TrainRadios trainRadios;
    protected UnderCrossings underCrossings;
    protected WeightLimits weightLimits;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Ruft den Wert der balises-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Balises }
     *     
     */
    public Balises getBalises() {
        return balises;
    }

    /**
     * Legt den Wert der balises-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Balises }
     *     
     */
    public void setBalises(Balises value) {
        this.balises = value;
    }

    /**
     * Ruft den Wert der borders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Borders }
     *     
     */
    public Borders getBorders() {
        return borders;
    }

    /**
     * Legt den Wert der borders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Borders }
     *     
     */
    public void setBorders(Borders value) {
        this.borders = value;
    }

    /**
     * Ruft den Wert der bufferStops-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BufferStops }
     *     
     */
    public BufferStops getBufferStops() {
        return bufferStops;
    }

    /**
     * Legt den Wert der bufferStops-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BufferStops }
     *     
     */
    public void setBufferStops(BufferStops value) {
        this.bufferStops = value;
    }

    /**
     * Ruft den Wert der crossings-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Crossings }
     *     
     */
    public Crossings getCrossings() {
        return crossings;
    }

    /**
     * Legt den Wert der crossings-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Crossings }
     *     
     */
    public void setCrossings(Crossings value) {
        this.crossings = value;
    }

    /**
     * Ruft den Wert der derailersIS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DerailersIS }
     *     
     */
    public DerailersIS getDerailersIS() {
        return derailersIS;
    }

    /**
     * Legt den Wert der derailersIS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DerailersIS }
     *     
     */
    public void setDerailersIS(DerailersIS value) {
        this.derailersIS = value;
    }

    /**
     * Ruft den Wert der electrifications-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Electrifications }
     *     
     */
    public Electrifications getElectrifications() {
        return electrifications;
    }

    /**
     * Legt den Wert der electrifications-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Electrifications }
     *     
     */
    public void setElectrifications(Electrifications value) {
        this.electrifications = value;
    }

    /**
     * Ruft den Wert der keyLocksIS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KeyLocksIS }
     *     
     */
    public KeyLocksIS getKeyLocksIS() {
        return keyLocksIS;
    }

    /**
     * Legt den Wert der keyLocksIS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyLocksIS }
     *     
     */
    public void setKeyLocksIS(KeyLocksIS value) {
        this.keyLocksIS = value;
    }

    /**
     * Ruft den Wert der levelCrossingsIS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LevelCrossingsIS }
     *     
     */
    public LevelCrossingsIS getLevelCrossingsIS() {
        return levelCrossingsIS;
    }

    /**
     * Legt den Wert der levelCrossingsIS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelCrossingsIS }
     *     
     */
    public void setLevelCrossingsIS(LevelCrossingsIS value) {
        this.levelCrossingsIS = value;
    }

    /**
     * Ruft den Wert der lines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Lines }
     *     
     */
    public Lines getLines() {
        return lines;
    }

    /**
     * Legt den Wert der lines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Lines }
     *     
     */
    public void setLines(Lines value) {
        this.lines = value;
    }

    /**
     * Ruft den Wert der loadingGauges-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LoadingGauges }
     *     
     */
    public LoadingGauges getLoadingGauges() {
        return loadingGauges;
    }

    /**
     * Legt den Wert der loadingGauges-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadingGauges }
     *     
     */
    public void setLoadingGauges(LoadingGauges value) {
        this.loadingGauges = value;
    }

    /**
     * Ruft den Wert der operationalPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OperationalPoints }
     *     
     */
    public OperationalPoints getOperationalPoints() {
        return operationalPoints;
    }

    /**
     * Legt den Wert der operationalPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationalPoints }
     *     
     */
    public void setOperationalPoints(OperationalPoints value) {
        this.operationalPoints = value;
    }

    /**
     * Ruft den Wert der overCrossings-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OverCrossings }
     *     
     */
    public OverCrossings getOverCrossings() {
        return overCrossings;
    }

    /**
     * Legt den Wert der overCrossings-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OverCrossings }
     *     
     */
    public void setOverCrossings(OverCrossings value) {
        this.overCrossings = value;
    }

    /**
     * Ruft den Wert der platforms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Platforms }
     *     
     */
    public Platforms getPlatforms() {
        return platforms;
    }

    /**
     * Legt den Wert der platforms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Platforms }
     *     
     */
    public void setPlatforms(Platforms value) {
        this.platforms = value;
    }

    /**
     * Ruft den Wert der restrictionAreas-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RestrictionAreas }
     *     
     */
    public RestrictionAreas getRestrictionAreas() {
        return restrictionAreas;
    }

    /**
     * Legt den Wert der restrictionAreas-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictionAreas }
     *     
     */
    public void setRestrictionAreas(RestrictionAreas value) {
        this.restrictionAreas = value;
    }

    /**
     * Ruft den Wert der serviceSections-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSections }
     *     
     */
    public ServiceSections getServiceSections() {
        return serviceSections;
    }

    /**
     * Legt den Wert der serviceSections-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSections }
     *     
     */
    public void setServiceSections(ServiceSections value) {
        this.serviceSections = value;
    }

    /**
     * Ruft den Wert der signalsIS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalsIS }
     *     
     */
    public SignalsIS getSignalsIS() {
        return signalsIS;
    }

    /**
     * Legt den Wert der signalsIS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalsIS }
     *     
     */
    public void setSignalsIS(SignalsIS value) {
        this.signalsIS = value;
    }

    /**
     * Ruft den Wert der speeds-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Speeds }
     *     
     */
    public Speeds getSpeeds() {
        return speeds;
    }

    /**
     * Legt den Wert der speeds-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Speeds }
     *     
     */
    public void setSpeeds(Speeds value) {
        this.speeds = value;
    }

    /**
     * Ruft den Wert der stoppingPlaces-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StoppingPlaces }
     *     
     */
    public StoppingPlaces getStoppingPlaces() {
        return stoppingPlaces;
    }

    /**
     * Legt den Wert der stoppingPlaces-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StoppingPlaces }
     *     
     */
    public void setStoppingPlaces(StoppingPlaces value) {
        this.stoppingPlaces = value;
    }

    /**
     * Ruft den Wert der switchesIS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchesIS }
     *     
     */
    public SwitchesIS getSwitchesIS() {
        return switchesIS;
    }

    /**
     * Legt den Wert der switchesIS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchesIS }
     *     
     */
    public void setSwitchesIS(SwitchesIS value) {
        this.switchesIS = value;
    }

    /**
     * Ruft den Wert der tracks-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Tracks }
     *     
     */
    public Tracks getTracks() {
        return tracks;
    }

    /**
     * Legt den Wert der tracks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Tracks }
     *     
     */
    public void setTracks(Tracks value) {
        this.tracks = value;
    }

    /**
     * Ruft den Wert der trackBeds-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrackBeds }
     *     
     */
    public TrackBeds getTrackBeds() {
        return trackBeds;
    }

    /**
     * Legt den Wert der trackBeds-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackBeds }
     *     
     */
    public void setTrackBeds(TrackBeds value) {
        this.trackBeds = value;
    }

    /**
     * Ruft den Wert der trackGauges-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrackGauges }
     *     
     */
    public TrackGauges getTrackGauges() {
        return trackGauges;
    }

    /**
     * Legt den Wert der trackGauges-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackGauges }
     *     
     */
    public void setTrackGauges(TrackGauges value) {
        this.trackGauges = value;
    }

    /**
     * Ruft den Wert der trainDetectionElements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrainDetectionElements }
     *     
     */
    public TrainDetectionElements getTrainDetectionElements() {
        return trainDetectionElements;
    }

    /**
     * Legt den Wert der trainDetectionElements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainDetectionElements }
     *     
     */
    public void setTrainDetectionElements(TrainDetectionElements value) {
        this.trainDetectionElements = value;
    }

    /**
     * Ruft den Wert der trainProtectionElements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrainProtectionElements }
     *     
     */
    public TrainProtectionElements getTrainProtectionElements() {
        return trainProtectionElements;
    }

    /**
     * Legt den Wert der trainProtectionElements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainProtectionElements }
     *     
     */
    public void setTrainProtectionElements(TrainProtectionElements value) {
        this.trainProtectionElements = value;
    }

    /**
     * Ruft den Wert der trainRadios-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrainRadios }
     *     
     */
    public TrainRadios getTrainRadios() {
        return trainRadios;
    }

    /**
     * Legt den Wert der trainRadios-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainRadios }
     *     
     */
    public void setTrainRadios(TrainRadios value) {
        this.trainRadios = value;
    }

    /**
     * Ruft den Wert der underCrossings-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UnderCrossings }
     *     
     */
    public UnderCrossings getUnderCrossings() {
        return underCrossings;
    }

    /**
     * Legt den Wert der underCrossings-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UnderCrossings }
     *     
     */
    public void setUnderCrossings(UnderCrossings value) {
        this.underCrossings = value;
    }

    /**
     * Ruft den Wert der weightLimits-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightLimits }
     *     
     */
    public WeightLimits getWeightLimits() {
        return weightLimits;
    }

    /**
     * Legt den Wert der weightLimits-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightLimits }
     *     
     */
    public void setWeightLimits(WeightLimits value) {
        this.weightLimits = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
