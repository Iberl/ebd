//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * base type for normal elements in IL providing attributes @id and @name plus the possibility to add an anyAttribute
 * 
 * <p>Java-Klasse für EntityIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EntityIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}tElementWithIDandDesignator">
 *       &lt;sequence>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}anyAttribute"/>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityIL", propOrder = {
    "any"
})
@XmlSeeAlso({
    RouteEntry.class,
    DetectorTypes.class,
    TrackAssetConnectedToIL.class,
    SignalPlan.class,
    LevelCrossingTypeList.class,
    ActivationCondition.class,
    Interface.class,
    ControlledSignalBox.class,
    DetectorInState.class,
    LevelCrossingInState.class,
    RouteRelation.class,
    DerailerInPosition.class,
    SignalDelayTime.class,
    GenericIM.class,
    RouteActivationSection.class,
    PartialRoute.class,
    Configuration.class,
    Overlap.class,
    GenericAspect.class,
    SystemAssetConnectedToIL.class,
    SwitchPositionRestriction.class,
    Key.class,
    DangerPoint.class,
    SignalBox.class,
    ConflictReason.class,
    AspectRelation.class,
    ConflictingRoute.class,
    CombinedRoute.class,
    InterlockingInterface.class,
    ElementGroupingTypes.class,
    SignalWithAspect.class,
    KeyLockInState.class,
    InputOutput.class,
    PowerSupplyIL.class,
    ElementGroup.class,
    AssetAndState.class,
    Controller.class,
    AssetsForIL.class,
    OverlapRelease.class,
    TrackAsset.class,
    RouteExit.class,
    LevelCrossingDeactivator.class,
    AssetAndGivenState.class,
    ApproachStartingDetector.class,
    GenericResetStrategy.class,
    SwitchInPosition.class,
    GenericRouteType.class,
    CrossingInPosition.class
})
public class EntityIL
    extends TElementWithIDandDesignator
{

    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
