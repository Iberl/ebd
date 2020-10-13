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
import jakarta.xml.bind.annotation.XmlType;


/**
 * The SignalBox (single interlocking) is a vital and fail-safe system. It accepts commands from operation control systems and reads the status of field elements. The interlocking controls a set of track assets and system assets to safely guide and control train movement. This logic reflects the railway rules and regulations.
 * IL logic may be implemented in terms of mechanically interlocking bars, relay circuitry or computer programs. 
 * This is the master class that must be instantiated for a specific interlocking system that controls a specific yard.
 * 
 * <p>Java-Klasse für SignalBox complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalBox">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="controlsSystemAsset" type="{https://www.railml.org/schemas/3.1}SystemAssetConnectedToIL" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controlsTrackAsset" type="{https://www.railml.org/schemas/3.1}TrackAssetConnectedToIL" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controlsRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controlsCombinedRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controlsInterface" type="{https://www.railml.org/schemas/3.1}InterlockingInterface" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controlledBy" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="implementsSignalplan" type="{https://www.railml.org/schemas/3.1}SignalPlan" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="implementsElementGroup" type="{https://www.railml.org/schemas/3.1}ElementGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasPermissionZone" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasConflictingRoutes" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasConfiguration" type="{https://www.railml.org/schemas/3.1}Configuration" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "SignalBox", propOrder = {
    "controlsSystemAsset",
    "controlsTrackAsset",
    "controlsRoute",
    "controlsCombinedRoute",
    "controlsInterface",
    "controlledBy",
    "implementsSignalplan",
    "implementsElementGroup",
    "hasPermissionZone",
    "hasConflictingRoutes",
    "hasConfiguration"
})
public class SignalBox
    extends EntityIL
{

    protected List<SystemAssetConnectedToIL> controlsSystemAsset;
    protected List<TrackAssetConnectedToIL> controlsTrackAsset;
    protected List<EntityILref> controlsRoute;
    protected List<EntityILref> controlsCombinedRoute;
    protected List<InterlockingInterface> controlsInterface;
    protected List<EntityILref> controlledBy;
    protected List<SignalPlan> implementsSignalplan;
    protected List<ElementGroup> implementsElementGroup;
    protected List<EntityILref> hasPermissionZone;
    protected List<EntityILref> hasConflictingRoutes;
    protected List<Configuration> hasConfiguration;

    /**
     * Gets the value of the controlsSystemAsset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlsSystemAsset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlsSystemAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemAssetConnectedToIL }
     * 
     * 
     */
    public List<SystemAssetConnectedToIL> getControlsSystemAsset() {
        if (controlsSystemAsset == null) {
            controlsSystemAsset = new ArrayList<SystemAssetConnectedToIL>();
        }
        return this.controlsSystemAsset;
    }

    /**
     * Gets the value of the controlsTrackAsset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlsTrackAsset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlsTrackAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackAssetConnectedToIL }
     * 
     * 
     */
    public List<TrackAssetConnectedToIL> getControlsTrackAsset() {
        if (controlsTrackAsset == null) {
            controlsTrackAsset = new ArrayList<TrackAssetConnectedToIL>();
        }
        return this.controlsTrackAsset;
    }

    /**
     * Gets the value of the controlsRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlsRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlsRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getControlsRoute() {
        if (controlsRoute == null) {
            controlsRoute = new ArrayList<EntityILref>();
        }
        return this.controlsRoute;
    }

    /**
     * Gets the value of the controlsCombinedRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlsCombinedRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlsCombinedRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getControlsCombinedRoute() {
        if (controlsCombinedRoute == null) {
            controlsCombinedRoute = new ArrayList<EntityILref>();
        }
        return this.controlsCombinedRoute;
    }

    /**
     * Gets the value of the controlsInterface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlsInterface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlsInterface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterlockingInterface }
     * 
     * 
     */
    public List<InterlockingInterface> getControlsInterface() {
        if (controlsInterface == null) {
            controlsInterface = new ArrayList<InterlockingInterface>();
        }
        return this.controlsInterface;
    }

    /**
     * Gets the value of the controlledBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlledBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlledBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getControlledBy() {
        if (controlledBy == null) {
            controlledBy = new ArrayList<EntityILref>();
        }
        return this.controlledBy;
    }

    /**
     * Gets the value of the implementsSignalplan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implementsSignalplan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplementsSignalplan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignalPlan }
     * 
     * 
     */
    public List<SignalPlan> getImplementsSignalplan() {
        if (implementsSignalplan == null) {
            implementsSignalplan = new ArrayList<SignalPlan>();
        }
        return this.implementsSignalplan;
    }

    /**
     * Gets the value of the implementsElementGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implementsElementGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplementsElementGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementGroup }
     * 
     * 
     */
    public List<ElementGroup> getImplementsElementGroup() {
        if (implementsElementGroup == null) {
            implementsElementGroup = new ArrayList<ElementGroup>();
        }
        return this.implementsElementGroup;
    }

    /**
     * Gets the value of the hasPermissionZone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasPermissionZone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasPermissionZone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasPermissionZone() {
        if (hasPermissionZone == null) {
            hasPermissionZone = new ArrayList<EntityILref>();
        }
        return this.hasPermissionZone;
    }

    /**
     * Gets the value of the hasConflictingRoutes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasConflictingRoutes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasConflictingRoutes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasConflictingRoutes() {
        if (hasConflictingRoutes == null) {
            hasConflictingRoutes = new ArrayList<EntityILref>();
        }
        return this.hasConflictingRoutes;
    }

    /**
     * Gets the value of the hasConfiguration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasConfiguration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Configuration }
     * 
     * 
     */
    public List<Configuration> getHasConfiguration() {
        if (hasConfiguration == null) {
            hasConfiguration = new ArrayList<Configuration>();
        }
        return this.hasConfiguration;
    }

}
