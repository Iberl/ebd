//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Container for assets used for operation of interlockings and controllers. They represent a more functional/logical view onto the railway network but depending on the hardware as defined in infrastructure domain.
 * Assets in the container are owned by the railway network rather than by individual interlocking systems.
 * 
 * <p>Java-Klasse für AssetsForIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AssetsForIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="tvdSections" type="{https://www.railml.org/schemas/3.1}TvdSections" minOccurs="0"/>
 *         &lt;element name="switchesIL" type="{https://www.railml.org/schemas/3.1}SwitchesIL" minOccurs="0"/>
 *         &lt;element name="derailersIL" type="{https://www.railml.org/schemas/3.1}DerailersIL" minOccurs="0"/>
 *         &lt;element name="movableCrossings" type="{https://www.railml.org/schemas/3.1}MovableCrossings" minOccurs="0"/>
 *         &lt;element name="levelCrossingsIL" type="{https://www.railml.org/schemas/3.1}LevelCrossingsIL" minOccurs="0"/>
 *         &lt;element name="keys" type="{https://www.railml.org/schemas/3.1}Keys" minOccurs="0"/>
 *         &lt;element name="keyLocksIL" type="{https://www.railml.org/schemas/3.1}KeyLocksIL" minOccurs="0"/>
 *         &lt;element name="genericDetectors" type="{https://www.railml.org/schemas/3.1}GenericDetectors" minOccurs="0"/>
 *         &lt;element name="signalsIL" type="{https://www.railml.org/schemas/3.1}SignalsIL" minOccurs="0"/>
 *         &lt;element name="atpDevices" type="{https://www.railml.org/schemas/3.1}ATPdevices" minOccurs="0"/>
 *         &lt;element name="interfaces" type="{https://www.railml.org/schemas/3.1}Interfaces" minOccurs="0"/>
 *         &lt;element name="workZones" type="{https://www.railml.org/schemas/3.1}WorkZones" minOccurs="0"/>
 *         &lt;element name="localOperationAreas" type="{https://www.railml.org/schemas/3.1}LocalOperationAreas" minOccurs="0"/>
 *         &lt;element name="shuntingZones" type="{https://www.railml.org/schemas/3.1}ShuntingZones" minOccurs="0"/>
 *         &lt;element name="permissionZones" type="{https://www.railml.org/schemas/3.1}PermissionZones" minOccurs="0"/>
 *         &lt;element name="routeReleaseGroupsAhead" type="{https://www.railml.org/schemas/3.1}RouteReleaseGroupsAhead" minOccurs="0"/>
 *         &lt;element name="routeReleaseGroupsRear" type="{https://www.railml.org/schemas/3.1}RouteReleaseGroupsRear" minOccurs="0"/>
 *         &lt;element name="routes" type="{https://www.railml.org/schemas/3.1}Routes" minOccurs="0"/>
 *         &lt;element name="conflictingRoutes" type="{https://www.railml.org/schemas/3.1}ConflictingRoutes" minOccurs="0"/>
 *         &lt;element name="routeRelations" type="{https://www.railml.org/schemas/3.1}RouteRelations" minOccurs="0"/>
 *         &lt;element name="combinedRoutes" type="{https://www.railml.org/schemas/3.1}CombinedRoutes" minOccurs="0"/>
 *         &lt;element name="overlaps" type="{https://www.railml.org/schemas/3.1}Overlaps" minOccurs="0"/>
 *         &lt;element name="dangerPoints" type="{https://www.railml.org/schemas/3.1}DangerPoints" minOccurs="0"/>
 *         &lt;element name="destinationPoints" type="{https://www.railml.org/schemas/3.1}DestinationPoints" minOccurs="0"/>
 *         &lt;element name="powerSuppliesIL" type="{https://www.railml.org/schemas/3.1}PowerSuppliesIL" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssetsForIL", propOrder = {
    "tvdSections",
    "switchesIL",
    "derailersIL",
    "movableCrossings",
    "levelCrossingsIL",
    "keys",
    "keyLocksIL",
    "genericDetectors",
    "signalsIL",
    "atpDevices",
    "interfaces",
    "workZones",
    "localOperationAreas",
    "shuntingZones",
    "permissionZones",
    "routeReleaseGroupsAhead",
    "routeReleaseGroupsRear",
    "routes",
    "conflictingRoutes",
    "routeRelations",
    "combinedRoutes",
    "overlaps",
    "dangerPoints",
    "destinationPoints",
    "powerSuppliesIL"
})
public class AssetsForIL
    extends EntityIL
{

    protected TvdSections tvdSections;
    protected SwitchesIL switchesIL;
    protected DerailersIL derailersIL;
    protected MovableCrossings movableCrossings;
    protected LevelCrossingsIL levelCrossingsIL;
    protected Keys keys;
    protected KeyLocksIL keyLocksIL;
    protected GenericDetectors genericDetectors;
    protected SignalsIL signalsIL;
    protected ATPdevices atpDevices;
    protected Interfaces interfaces;
    protected WorkZones workZones;
    protected LocalOperationAreas localOperationAreas;
    protected ShuntingZones shuntingZones;
    protected PermissionZones permissionZones;
    protected RouteReleaseGroupsAhead routeReleaseGroupsAhead;
    protected RouteReleaseGroupsRear routeReleaseGroupsRear;
    protected Routes routes;
    protected ConflictingRoutes conflictingRoutes;
    protected RouteRelations routeRelations;
    protected CombinedRoutes combinedRoutes;
    protected Overlaps overlaps;
    protected DangerPoints dangerPoints;
    protected DestinationPoints destinationPoints;
    protected PowerSuppliesIL powerSuppliesIL;

    /**
     * Ruft den Wert der tvdSections-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TvdSections }
     *     
     */
    public TvdSections getTvdSections() {
        return tvdSections;
    }

    /**
     * Legt den Wert der tvdSections-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TvdSections }
     *     
     */
    public void setTvdSections(TvdSections value) {
        this.tvdSections = value;
    }

    /**
     * Ruft den Wert der switchesIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchesIL }
     *     
     */
    public SwitchesIL getSwitchesIL() {
        return switchesIL;
    }

    /**
     * Legt den Wert der switchesIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchesIL }
     *     
     */
    public void setSwitchesIL(SwitchesIL value) {
        this.switchesIL = value;
    }

    /**
     * Ruft den Wert der derailersIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DerailersIL }
     *     
     */
    public DerailersIL getDerailersIL() {
        return derailersIL;
    }

    /**
     * Legt den Wert der derailersIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DerailersIL }
     *     
     */
    public void setDerailersIL(DerailersIL value) {
        this.derailersIL = value;
    }

    /**
     * Ruft den Wert der movableCrossings-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MovableCrossings }
     *     
     */
    public MovableCrossings getMovableCrossings() {
        return movableCrossings;
    }

    /**
     * Legt den Wert der movableCrossings-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MovableCrossings }
     *     
     */
    public void setMovableCrossings(MovableCrossings value) {
        this.movableCrossings = value;
    }

    /**
     * Ruft den Wert der levelCrossingsIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LevelCrossingsIL }
     *     
     */
    public LevelCrossingsIL getLevelCrossingsIL() {
        return levelCrossingsIL;
    }

    /**
     * Legt den Wert der levelCrossingsIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelCrossingsIL }
     *     
     */
    public void setLevelCrossingsIL(LevelCrossingsIL value) {
        this.levelCrossingsIL = value;
    }

    /**
     * Ruft den Wert der keys-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Keys }
     *     
     */
    public Keys getKeys() {
        return keys;
    }

    /**
     * Legt den Wert der keys-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Ruft den Wert der keyLocksIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KeyLocksIL }
     *     
     */
    public KeyLocksIL getKeyLocksIL() {
        return keyLocksIL;
    }

    /**
     * Legt den Wert der keyLocksIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyLocksIL }
     *     
     */
    public void setKeyLocksIL(KeyLocksIL value) {
        this.keyLocksIL = value;
    }

    /**
     * Ruft den Wert der genericDetectors-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericDetectors }
     *     
     */
    public GenericDetectors getGenericDetectors() {
        return genericDetectors;
    }

    /**
     * Legt den Wert der genericDetectors-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericDetectors }
     *     
     */
    public void setGenericDetectors(GenericDetectors value) {
        this.genericDetectors = value;
    }

    /**
     * Ruft den Wert der signalsIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalsIL }
     *     
     */
    public SignalsIL getSignalsIL() {
        return signalsIL;
    }

    /**
     * Legt den Wert der signalsIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalsIL }
     *     
     */
    public void setSignalsIL(SignalsIL value) {
        this.signalsIL = value;
    }

    /**
     * Ruft den Wert der atpDevices-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ATPdevices }
     *     
     */
    public ATPdevices getAtpDevices() {
        return atpDevices;
    }

    /**
     * Legt den Wert der atpDevices-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ATPdevices }
     *     
     */
    public void setAtpDevices(ATPdevices value) {
        this.atpDevices = value;
    }

    /**
     * Ruft den Wert der interfaces-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Interfaces }
     *     
     */
    public Interfaces getInterfaces() {
        return interfaces;
    }

    /**
     * Legt den Wert der interfaces-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Interfaces }
     *     
     */
    public void setInterfaces(Interfaces value) {
        this.interfaces = value;
    }

    /**
     * Ruft den Wert der workZones-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WorkZones }
     *     
     */
    public WorkZones getWorkZones() {
        return workZones;
    }

    /**
     * Legt den Wert der workZones-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkZones }
     *     
     */
    public void setWorkZones(WorkZones value) {
        this.workZones = value;
    }

    /**
     * Ruft den Wert der localOperationAreas-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocalOperationAreas }
     *     
     */
    public LocalOperationAreas getLocalOperationAreas() {
        return localOperationAreas;
    }

    /**
     * Legt den Wert der localOperationAreas-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalOperationAreas }
     *     
     */
    public void setLocalOperationAreas(LocalOperationAreas value) {
        this.localOperationAreas = value;
    }

    /**
     * Ruft den Wert der shuntingZones-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShuntingZones }
     *     
     */
    public ShuntingZones getShuntingZones() {
        return shuntingZones;
    }

    /**
     * Legt den Wert der shuntingZones-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShuntingZones }
     *     
     */
    public void setShuntingZones(ShuntingZones value) {
        this.shuntingZones = value;
    }

    /**
     * Ruft den Wert der permissionZones-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PermissionZones }
     *     
     */
    public PermissionZones getPermissionZones() {
        return permissionZones;
    }

    /**
     * Legt den Wert der permissionZones-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PermissionZones }
     *     
     */
    public void setPermissionZones(PermissionZones value) {
        this.permissionZones = value;
    }

    /**
     * Ruft den Wert der routeReleaseGroupsAhead-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RouteReleaseGroupsAhead }
     *     
     */
    public RouteReleaseGroupsAhead getRouteReleaseGroupsAhead() {
        return routeReleaseGroupsAhead;
    }

    /**
     * Legt den Wert der routeReleaseGroupsAhead-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteReleaseGroupsAhead }
     *     
     */
    public void setRouteReleaseGroupsAhead(RouteReleaseGroupsAhead value) {
        this.routeReleaseGroupsAhead = value;
    }

    /**
     * Ruft den Wert der routeReleaseGroupsRear-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RouteReleaseGroupsRear }
     *     
     */
    public RouteReleaseGroupsRear getRouteReleaseGroupsRear() {
        return routeReleaseGroupsRear;
    }

    /**
     * Legt den Wert der routeReleaseGroupsRear-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteReleaseGroupsRear }
     *     
     */
    public void setRouteReleaseGroupsRear(RouteReleaseGroupsRear value) {
        this.routeReleaseGroupsRear = value;
    }

    /**
     * Ruft den Wert der routes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Routes }
     *     
     */
    public Routes getRoutes() {
        return routes;
    }

    /**
     * Legt den Wert der routes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Routes }
     *     
     */
    public void setRoutes(Routes value) {
        this.routes = value;
    }

    /**
     * Ruft den Wert der conflictingRoutes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConflictingRoutes }
     *     
     */
    public ConflictingRoutes getConflictingRoutes() {
        return conflictingRoutes;
    }

    /**
     * Legt den Wert der conflictingRoutes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConflictingRoutes }
     *     
     */
    public void setConflictingRoutes(ConflictingRoutes value) {
        this.conflictingRoutes = value;
    }

    /**
     * Ruft den Wert der routeRelations-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RouteRelations }
     *     
     */
    public RouteRelations getRouteRelations() {
        return routeRelations;
    }

    /**
     * Legt den Wert der routeRelations-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteRelations }
     *     
     */
    public void setRouteRelations(RouteRelations value) {
        this.routeRelations = value;
    }

    /**
     * Ruft den Wert der combinedRoutes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CombinedRoutes }
     *     
     */
    public CombinedRoutes getCombinedRoutes() {
        return combinedRoutes;
    }

    /**
     * Legt den Wert der combinedRoutes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CombinedRoutes }
     *     
     */
    public void setCombinedRoutes(CombinedRoutes value) {
        this.combinedRoutes = value;
    }

    /**
     * Ruft den Wert der overlaps-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Overlaps }
     *     
     */
    public Overlaps getOverlaps() {
        return overlaps;
    }

    /**
     * Legt den Wert der overlaps-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Overlaps }
     *     
     */
    public void setOverlaps(Overlaps value) {
        this.overlaps = value;
    }

    /**
     * Ruft den Wert der dangerPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DangerPoints }
     *     
     */
    public DangerPoints getDangerPoints() {
        return dangerPoints;
    }

    /**
     * Legt den Wert der dangerPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerPoints }
     *     
     */
    public void setDangerPoints(DangerPoints value) {
        this.dangerPoints = value;
    }

    /**
     * Ruft den Wert der destinationPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DestinationPoints }
     *     
     */
    public DestinationPoints getDestinationPoints() {
        return destinationPoints;
    }

    /**
     * Legt den Wert der destinationPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationPoints }
     *     
     */
    public void setDestinationPoints(DestinationPoints value) {
        this.destinationPoints = value;
    }

    /**
     * Ruft den Wert der powerSuppliesIL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PowerSuppliesIL }
     *     
     */
    public PowerSuppliesIL getPowerSuppliesIL() {
        return powerSuppliesIL;
    }

    /**
     * Legt den Wert der powerSuppliesIL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerSuppliesIL }
     *     
     */
    public void setPowerSuppliesIL(PowerSuppliesIL value) {
        this.powerSuppliesIL = value;
    }

}
